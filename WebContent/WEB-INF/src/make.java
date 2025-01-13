import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Vector;

import deepspot.basic.Cnstnts;
import deepspot.util.DB;
import deepspot.util.XML;

import java.io.IOException;

import org.dom4j.DocumentFactory;
import org.dom4j.Element;

public class make{

	private static File xmlFile = new File("../xmlschema/progInfo.xml");
	private static XML progInfo;
	private static String createType = "";
	private static String javaOut = "";
	private static String class_name = "";
	private static char newLine = (char)10;
	private static StringBuffer javaSB;
	private static StringBuffer jspSB;
	private static boolean create_table = false;
	private static boolean make_jspPage = false;
	private static boolean make_message = false;
	private static boolean make = false;
	private static boolean make_masterBean = false;
	private static boolean make_detailBean = false;
	
	public static void main(String args[]) throws Exception {
	    progInfo = new XML(xmlFile);
	    if(args.length<2) {
	    	System.out.println("There is nothing to do. please input class_name & make_type!");
		    print_make_type();
		    return;
	    }	       
	    String javaName = args[0];
	    String make_type = args[1];
	    Element javaInfo = progInfo.getElement("java","name",javaName);
	    if(javaInfo==null) {
	    	System.out.println("Class name: " + javaName + " not found!");
	    } else {
	    	setFlag(make_type);
	    	if(make) {
	    		go(javaInfo);
	    	} else {
	    		System.out.println("make_type error!");
	    		print_make_type();
	    	}
	    }
	}
  
	private static void print_make_type(){
		System.out.println("make_type: all             ** make all function **");
		System.out.println("           table           ** create master & detail table **");
		System.out.println("           javaBean        ** make master & detail javaBean **");
		System.out.println("           masterBean 	   ** make masterBean **");
		System.out.println("           detailBean 	   ** make detailBean **");
		System.out.println("           jspPage         ** make master & detail jspPage **");
		System.out.println("           message         ** make master & detail message **");
	}
  
	private static void setFlag(String make_type){
		if(make_type.equals("all")){
			create_table = true;
			make_jspPage = true;
			make_masterBean = true;
			make_detailBean = true;
			make_message = true;
			make = true;
		} else
		if(make_type.equals("table")){
			create_table = true;
			make = true;
		} else
		if(make_type.equals("javaBean")){
			make_masterBean = true;
			make_detailBean = true;
			make = true;
		} else
		if(make_type.equals("masterBean")){
			make_masterBean = true;
			make = true;
		} else
		if(make_type.equals("detailBean")){
			make_detailBean = true;
			make = true;
		} else
		if(make_type.equals("jspPage")){
			make_jspPage = true;
			make = true;
		} else
		if(make_type.equals("message")){
			make_message = true;
			make = true;
		}
	}
  
	private static void go(Element javaInfo) throws Exception {
		class_name = javaInfo.attributeValue("name");
		createType = javaInfo.attributeValue("createType");
		if(createType.equals("master")){
			make_detailBean = false;
		}
		if(create_table){            //create table & get sqlStrs
			createTable(javaInfo,"master");     
			if(createType.equals("masterDetail")){
				createTable(javaInfo,"detail");        
			}
		}
		if(make_masterBean){
			makeMasterBean(javaInfo);//make MasterBean         
		}
		if(make_detailBean){
			makeDetailBean(javaInfo);//make DetailBean
		}
		if(make_jspPage){            //make jsp page
			makeJsp(javaInfo);
		}
		if(make_message){            //make mssage.xml & chkData.jsp & getData.jsp
			makeMessage(javaInfo);          
		}
	}
  
	private static void createTable(Element javaInfo,
									String type) throws Exception {
		Element tableInfo = javaInfo.element("table").element(type);
		String className = class_name;
		if(type.equals("detail")) className += "_detail";
		String tableName = className;
		String createStr = "create table " + tableName + "(";
		String keyStr = Cnstnts.EMPTY_STRING;
		Iterator<?> fields = tableInfo.elementIterator();
		while(fields.hasNext()) {
			Element fieldInfo = (Element)fields.next();
			String fieldName = fieldInfo.attributeValue("name");
			String dbType = fieldInfo.attributeValue("dbType");
			String fieldKey = fieldInfo.attributeValue("key");
			if(dbType!=null && dbType!=null 
					&& dbType.trim().length()>0 
							&& dbType.trim().length()>0){
				createStr += fieldName + " " + dbType + " not null";
			}
			if(fieldKey!=null && fieldKey.equals("primary key")) {
				if(keyStr.trim().length()==0){
					keyStr = ",primary key(" + fieldName ;
				} else {
					keyStr += "," + fieldName;
				}
			}
			if(fields.hasNext()) {
				createStr += ",";
			} else {
				if(keyStr.trim().length()>0){
					keyStr += ")";
				}
				createStr += keyStr+")";
			}
		}
		DB db = new DB();
		//if(db.chkTable(tableName)) {
			db.executeUpdate("drop table " + tableName);
		//} 
		db.executeUpdate(createStr);
		db.close();
		db=null;
		System.out.println(tableName + " table created ok.");
	}
  
	private static void makeMasterBean(Element javaInfo) throws Exception {
		
		String className = class_name;
		
		javaOut = "../src/deepspot/main/" + className + ".java";
		
		/* make package line */
		javaSB = new StringBuffer("package "+javaInfo.attributeValue("package")+";"+newLine);
		javaSB.append(newLine);
		
		/* make import line */
		javaSB.append("import java.util.ArrayList;"+newLine);
		javaSB.append("import java.util.Iterator;"+newLine);
		javaSB.append("import java.util.List;"+newLine);
		javaSB.append("import java.util.Properties;"+newLine);
		javaSB.append("import deepspot.basic.Cnstnts;"+newLine);
		javaSB.append("import deepspot.basic.Field;"+newLine);
		javaSB.append("import deepspot.basic.MasterBean;"+newLine);
		javaSB.append("import deepspot.basic.SelectItem;"+newLine);
		javaSB.append("import deepspot.html.Html;"+newLine);
		javaSB.append("import deepspot.util.Util;"+newLine);
		javaSB.append(newLine);
    
		/* make class begain line */
		javaSB.append("public class "+className+" extends MasterBean {"+newLine);
		javaSB.append(newLine);
    
		/* make constracotr method */
		javaSB.append("    public "+className+"(){this.init();}"+newLine);
		javaSB.append(newLine);
		
		javaSB.append("    public "+className+"(String FlowKey) {"+newLine);
		javaSB.append("        this.init();"+newLine);
		javaSB.append("        this.setFlowKey(FlowKey);"+newLine);
		javaSB.append("        this.getAttribute();"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
    
		/* make all fields & set_get methods */
		Element fields = javaInfo.element("table").element("master");
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			if(!eName.equals("FlowKey") 
					&& !eName.equals("CreateDept") 
							&& !eName.equals("Applicant")){
				javaSB.append("    public Field "+eName+";"+newLine);
				javaSB.append("    public void set"+eName+"(String "+eName+
							  "){this."+eName+".setValue("+eName+");}"+newLine);
				javaSB.append("    public String get"+eName+"(){return this."+
										  eName+".getValue();}"+newLine);
				javaSB.append(newLine);
			}
		}
		if(createType.equals("masterDetail")){
			javaSB.append("    public "+className+"_detail myDetail;"+newLine);
			javaSB.append("    public void setMyDetail("+className+"_detail myDetail){"+newLine);
			javaSB.append("        this.myDetail = myDetail;"+newLine);
			javaSB.append("    }"+newLine);
			javaSB.append("    public "+className+"_detail getMyDetail(){return this.myDetail;}"+newLine);
			javaSB.append(newLine);
		}
		
		/* make init() */
		javaSB.append("    public void init() {"+newLine);
		javaSB.append("        super.init();"+newLine);
		javaSB.append("        this.setProgramId(\"jsp."+className+"\");"+newLine);
		javaSB.append("        this.setTableName(\""+className+"\");"+newLine);
		javaSB.append(newLine);
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			String chkEmpty = e.attributeValue("chkEmpty");
			String dbType = e.attributeValue("dbType");
			String searchCondition = e.attributeValue("searchCondition");
			if(!eName.equals("FlowKey") 
					&& !eName.equals("CreateDept") 
							&& !eName.equals("Applicant")){
				javaSB.append("        this."+eName+" = new Field(\""+eName+
								  "\", this.getTableName());"+newLine);
				if(dbType!=null && dbType.trim().length()>0){
					javaSB.append("        this."+eName+".setDbType(\""+dbType+"\");"+newLine);
				}
				if(chkEmpty!=null && chkEmpty.equals("true")){
					javaSB.append("        this."+eName+".setCheckEmpty(true);"+newLine);
				}
				if(searchCondition!=null && searchCondition.trim().length()>0){
					javaSB.append("        this."+eName+".setSearchCondition("+
												  searchCondition+");"+newLine);
				}
				javaSB.append(newLine);
			}
		}
		javaSB.append("        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);"+newLine);
		javaSB.append(newLine);
		javaSB.append("        this.setSearchListPrpts();"+newLine);
		javaSB.append(newLine);
		if(createType.equals("masterDetail")){
			javaSB.append("        this.myDetail = new "+className+"_detail();"+newLine);
			javaSB.append("        this.setDetails(new ArrayList<List<Field>>());"+newLine);
		}
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make setDbFields() */
		javaSB.append("    public void setDbFields() {"+newLine);
		javaSB.append("        super.setDbFields();"+newLine);
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			if(!eName.equals("FlowKey") 
					&& !eName.equals("CreateDept") 
							&& !eName.equals("Applicant")){
				javaSB.append("        this.DbFields.add(this."+eName+");"+newLine);
				javaSB.append(newLine);
			}
		}
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make printSearchTable() */
		javaSB.append("    public String printSearchTable() throws Exception {"+newLine);
		javaSB.append("        String rtnString = Cnstnts.EMPTY_STRING;"+newLine);
		javaSB.append("        if (this.onSearchMode()) {"+newLine);
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			String canSearch = e.attributeValue("canSearch");
			String htmlType = e.attributeValue("htmlType");
			String selectItem = e.attributeValue("selectItem");
			String mapingPrpt = e.attributeValue("mapingPrpt");
			if(htmlType==null || htmlType.trim().length()==0){
				htmlType = "Cnstnts.HTML_TAG_TEXT";
			}
			if(!eName.equals("FlowKey") 
					&& !eName.equals("CreateDept") 
							&& !eName.equals("Applicant")){
				if(canSearch!=null && canSearch.equals("true")){
					javaSB.append("            " +
								  "this."+eName+".setHtmlType("+htmlType+");"+newLine);
					if(selectItem!=null && selectItem.trim().length()>0){
						javaSB.append("            " +
								  "this."+eName+".setSelectList("+selectItem+");"+newLine);
					}
					if(mapingPrpt!=null && mapingPrpt.trim().length()>0){
						javaSB.append("            " +
								  "this."+eName+".setMapingPrpt("+mapingPrpt+");"+newLine);
					}
					javaSB.append("            " +
								  "rtnString += this.printHtml(this."+eName+");"+newLine);
					javaSB.append(newLine);
				}
				
			}
		}
		javaSB.append("        }"+newLine);
		javaSB.append("        return rtnString;"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make printMaintainTable() */
		javaSB.append("    public String printMaintainTable() throws Exception {"+newLine);
		javaSB.append("        String rtnString = Cnstnts.EMPTY_STRING;"+newLine);
		javaSB.append("        if (this.onMaintainMode()) {"+newLine);
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			String htmlType = e.attributeValue("htmlType");
			String selectItem = e.attributeValue("selectItem");
			String mapingPrpt = e.attributeValue("mapingPrpt");
			if(htmlType==null || htmlType.trim().length()==0){
				htmlType = "Cnstnts.HTML_TAG_TEXT";
			}
			if(!eName.equals("FlowKey") 
					&& !eName.equals("CreateDept") 
							&& !eName.equals("Applicant")){
				javaSB.append("            " +
						  "this."+eName+".setHtmlType("+htmlType+");"+newLine);
				if(selectItem!=null && selectItem.trim().length()>0){
					javaSB.append("            " +
						  "this."+eName+".setSelectList("+selectItem+");"+newLine);
				}
				if(mapingPrpt!=null && mapingPrpt.trim().length()>0){
					javaSB.append("            " +
						  "this."+eName+".setMapingPrpt("+mapingPrpt+");"+newLine);
				}
				javaSB.append("            " +
						  "rtnString += this.printHtml(this."+eName+");"+newLine);
				javaSB.append(newLine);	
			}
		}
		if(createType.equals("masterDetail")){
			javaSB.append("            if(this.myDetail!=null){"+newLine);
			javaSB.append("                rtnString += this.printDetailTable();"+newLine);
			javaSB.append("            }"+newLine);
		}
		javaSB.append("        }"+newLine);
		javaSB.append("        return rtnString;"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make setSearchListPrpts() */
		javaSB.append("    public void setSearchListPrpts() {"+newLine);
		int i=0;
		String showFieldArray = "Field[] showField = {";
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();i++){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			String searchListWidth = e.attributeValue("searchListWidth");
			if(searchListWidth!=null && searchListWidth.trim().length()>0){
				javaSB.append("        this."+eName+".setListWidth(\""+
							  searchListWidth+"\");"+newLine);
				javaSB.append(newLine);
				if(i==0){
					showFieldArray += "this."+eName;
				} else {
					showFieldArray += ", this."+eName;
				}
			}
		}
		showFieldArray += "};";
		javaSB.append("        "+showFieldArray+newLine);
		javaSB.append("        this.setShowField(showField);"+newLine);
		javaSB.append("        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make getSearchList() */
		javaSB.append("    public List<Object[]> getSearchList() throws Exception {"+newLine);
		javaSB.append("        String whereStr = Cnstnts.EMPTY_STRING;"+newLine);
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			String canSearch = e.attributeValue("canSearch");
			if(canSearch!=null && canSearch.equals("true")){
				javaSB.append("        whereStr = Util.addWhereSQL(whereStr, this."+eName+");"+newLine);
			}
		}
		javaSB.append("        return this.doSearch(whereStr);"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make getNamesPrpts() */
		String prptNameField = javaInfo.element("table").element("master").
		   								attributeValue("prptNameField");
		javaSB.append("    public Properties getNamesPrpts() throws Exception {"+newLine);
		javaSB.append("        return super.getNamesPrpts(this."+prptNameField+");"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make setPreObj() */
		javaSB.append("    public void setPreObj(UserBean userInfo){"+newLine);
		javaSB.append("        if (userInfo.getObj(this.getTableName()) != null) {"+newLine);
		javaSB.append("            "+className+" preObj = ("+className+
								   ") userInfo.getObj(this.getTableName());"+newLine);
		javaSB.append("            if(this.onBtnDeleteDetail()"+newLine);
		javaSB.append("                    && this.getDeleteItems()!=null"+newLine);
		javaSB.append("            				   && this.getDeleteItems().length>0){"+newLine);
		javaSB.append("                for(int i=0;i<this.getDeleteItems().length;i++){"+newLine);
		javaSB.append("                    int seqNo = Integer.parseInt(this.getDeleteItems()[i]);"+newLine);
		javaSB.append("                    preObj.getDetails().remove(seqNo-i);"+newLine);
		javaSB.append("                }"+newLine);
		javaSB.append("            }"+newLine);
		javaSB.append("            this.setSearchResult(preObj.getSearchResult());"+newLine);
		javaSB.append("            if (!this.getDataFromDB()) {"+newLine);
		javaSB.append("                this.setDetails(preObj.getDetails());"+newLine);
		javaSB.append("            }"+newLine);
		javaSB.append("        }"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make checkInsertError() */
		javaSB.append("    public boolean checkInsertError() throws Exception {"+newLine);
		javaSB.append("        if(super.checkInsertError()){"+newLine);
		javaSB.append("            return true;"+newLine);
		javaSB.append("        } else {"+newLine);
		javaSB.append("            return false;"+newLine);
		javaSB.append("        }"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make checkUpdateError() */
		javaSB.append("    public boolean checkUpdateError() throws Exception {"+newLine);
		javaSB.append("        return this.checkInsertError();"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make checkDeleteError() */
		javaSB.append("    public boolean checkDeleteError() throws Exception {"+newLine);
		javaSB.append("        if(super.checkDeleteError()){"+newLine);
		javaSB.append("            return true;"+newLine);
		javaSB.append("        } else {"+newLine);
		javaSB.append("            return false;"+newLine);
		javaSB.append("        }"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make printDetailTable() */
		if(createType.equals("masterDetail")){
			javaSB.append("    @SuppressWarnings(\"unchecked\")"+newLine);
			javaSB.append("    private String printDetailTable() throws Exception {"+newLine);
			javaSB.append("        char newLine = Cnstnts.NEW_LINE;"+newLine);
			javaSB.append("        String rtnString = newLine+\"</table>\";"+newLine);
			javaSB.append("        int iframeWidth = 120;"+newLine);
			javaSB.append("        rtnString+=newLine+Html.getJavaScriptFunction(this.getTableName(),iframeWidth);"+newLine);
			javaSB.append("        rtnString+=newLine+\"<table\"+Cnstnts.DEFAULT_TABLE_BGCOLOR+\">\";"+newLine);
			javaSB.append("        rtnString+=newLine+\"  <tr><td colspan='\"+this.myDetail.getDbFields().size()+\"'>\"+this.myDetail.getPageTitle()+\"</td></tr>\";"+newLine);
			javaSB.append("        if(this.canEdit()){"+newLine);
			javaSB.append("            rtnString += newLine+\"  <tr><td colspan='\"+this.myDetail.getDbFields().size()+\"' align='center'>\"+\"<div id='showDetail'></div></td></tr>\";"+newLine);
			javaSB.append("        }"+newLine);
			javaSB.append("        rtnString+=newLine+\"  <tr\"+Cnstnts.DEFAULT_TH_BGCOLOR+\">\";"+newLine);
			javaSB.append("        rtnString+=newLine+\"    <td width='3%' align='center'>\"+this.getInsertImg()+\"</td>\";"+newLine);
			javaSB.append("        List<Field> detailFieldLst = this.myDetail.getDbFields();"+newLine);
			javaSB.append("        for(Iterator itr=detailFieldLst.iterator();itr.hasNext();){"+newLine);
			javaSB.append("            Field detailField = (Field)itr.next();"+newLine);
			javaSB.append("            if(detailField!=null && !\"FlowKey\".equals(detailField.getName()) && !\"Seq_no\".equals(detailField.getName())){"+newLine);
			javaSB.append("                rtnString += newLine+\"    <td align='center'\"+detailField.printListWidth()+\">\"+this.myDetail.getAlias(detailField)+\"</td>\";"+newLine);
			javaSB.append("            }"+newLine);
			javaSB.append("        }"+newLine);
			javaSB.append("        rtnString+=newLine+\"    <td width='3%' align='center'>\"+this.getDeleteImg()+\"</td>\";"+newLine);
			javaSB.append("        rtnString+=newLine+\"  </tr>\";"+newLine);
			javaSB.append("        if(this.getDetails()!=null && this.getDetails().size()>0){"+newLine);
			javaSB.append("            int i=0;"+newLine);
			javaSB.append("            boolean showSubTotal = false;"+newLine);
			javaSB.append("            for(Iterator detailItr=this.getDetails().iterator();detailItr.hasNext();i++){"+newLine);
			javaSB.append("                List<Field> fields = (List<Field>)detailItr.next();"+newLine);
			javaSB.append("                String trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_1;"+newLine);
			javaSB.append("                if(i%2==0) trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_2;"+newLine);
			javaSB.append("                rtnString += newLine+\"  <tr\"+trBgcolor+\">\";"+newLine);
			javaSB.append("                rtnString += newLine+\"    <td align='center'>\"+this.getEditImg(i)+\"</td>\";"+newLine);
			javaSB.append("                int j=0;"+newLine);
			javaSB.append("                for(Iterator fieldsItr=fields.iterator();fieldsItr.hasNext();j++){"+newLine);
			javaSB.append("                    Field detailField = (Field)fieldsItr.next();"+newLine);
			javaSB.append("                    String showName = detailField.getValue();"+newLine);
			javaSB.append("                    if(detailFieldLst.get(j).getMapingPrpt()!=null "+newLine);
			javaSB.append("                    	       && detailFieldLst.get(j).getMapingPrpt().getProperty(showName)!=null){"+newLine);
			javaSB.append("                        if(detailFieldLst.get(j).notShowCode()){"+newLine);
			javaSB.append("                            showName = detailFieldLst.get(j).getMapingPrpt().getProperty(showName);"+newLine);
			javaSB.append("                        } else {"+newLine);
			javaSB.append("                            showName += \"-\"+detailFieldLst.get(j).getMapingPrpt().getProperty(showName);"+newLine);
			javaSB.append("                        }"+newLine);
			javaSB.append("                    }"+newLine);
			javaSB.append("                    if(detailFieldLst.get(j).getDbType().equals(Cnstnts.DB_TYPE_INT)"+newLine);
			javaSB.append("                    			&& detailFieldLst.get(j).subTotalFlag()){"+newLine);
			javaSB.append("                    	   detailFieldLst.get(j).setSubtotal(detailFieldLst.get(j).getSubTotal()+"+newLine);
			javaSB.append("                                 Integer.parseInt(showName));"+newLine);
			javaSB.append("                        showSubTotal = true;"+newLine);
			javaSB.append("                        showName = Util.outFormat(Integer.parseInt(showName), 3);"+newLine);
			javaSB.append("                    }"+newLine);
			javaSB.append("                    if(detailField!=null && !\"FlowKey\".equals(detailField.getName()) && !\"Seq_no\".equals(detailField.getName())){"+newLine);
			javaSB.append("                        rtnString += newLine+\"    <td\"+detailFieldLst.get(j).printAlign()+\">\"+showName+\"</td>\";"+newLine);
			javaSB.append("                    }"+newLine);
			javaSB.append("                }"+newLine);
			javaSB.append("                rtnString += newLine+\"    <td align='center'>\"+this.getDeleteCheckbox(i)+\"</td>\";"+newLine);
			javaSB.append("                rtnString += newLine+\"  </tr>\";"+newLine);
			javaSB.append("            }"+newLine);
			javaSB.append("            if(showSubTotal){"+newLine);
			javaSB.append("            	   String printValue = Cnstnts.EMPTY_STRING;"+newLine);
			javaSB.append("                for(Iterator itr=detailFieldLst.iterator();itr.hasNext();){"+newLine);
			javaSB.append("                    Field detailField = (Field)itr.next();"+newLine);
			javaSB.append("                    if(detailField!=null && !\"FlowKey\".equals(detailField.getName()) "+newLine);
			javaSB.append("                            && !\"Seq_no\".equals(detailField.getName())){"+newLine);
			javaSB.append("                        if(detailField.subTotalFlag()){"+newLine);
			javaSB.append("                            printValue += \"<td align='right'>\"+Util.outFormat(detailField.getSubTotal(), 3)+\"</td>\";"+newLine);
			javaSB.append("                        } else {"+newLine);
			javaSB.append("                            printValue += \"<td></td>\";"+newLine);
			javaSB.append("                        }"+newLine);
			javaSB.append("                    }"+newLine);
			javaSB.append("                }"+newLine);
			javaSB.append("                rtnString +=  newLine+\"  <tr><td></td>\"+printValue+\"<td></td></tr>\";"+newLine);
			javaSB.append("            }"+newLine);
			javaSB.append("        }"+newLine);
			javaSB.append("        return rtnString;"+newLine);
			javaSB.append("    }"+newLine);
			javaSB.append(newLine);
		}
		
		/* make doAction()--this is only need for masterDetail createType */
		if(createType.equals("masterDetail")){
			javaSB.append("    public void doAction(UserBean userInfo) throws Exception{"+newLine);
			javaSB.append("        if(this.myDetail!=null){"+newLine);
			javaSB.append("            this.myDetail.setUserInfo(userInfo);"+newLine);
			javaSB.append("            if (this.getDataFromDB()) {"+newLine);
			javaSB.append("                this.setDetails(this.myDetail.getDetails(this.FlowKey.getValue()));"+newLine);
			javaSB.append("            }"+newLine);
			javaSB.append("        }"+newLine);
			javaSB.append("        super.doAction(userInfo);"+newLine);
			javaSB.append("    }"+newLine);
			javaSB.append(newLine);
		}
		
        javaSB.append("}");
    
	    File javaFile = new File(javaOut);
	    writeToFile(javaFile,javaSB);
	}
	
	private static void makeDetailBean(Element javaInfo) throws Exception {

		String className = class_name + "_detail";
		
		javaOut = "../src/deepspot/main/" + className + ".java";
		
		/* make package line */
		javaSB = new StringBuffer("package "+javaInfo.attributeValue("package")+";"+newLine);
		javaSB.append(newLine);
		
		/* make import line */
		javaSB.append("import java.util.Iterator;"+newLine);
		javaSB.append("import java.util.List;"+newLine);
		javaSB.append("import deepspot.basic.Cnstnts;"+newLine);
		javaSB.append("import deepspot.basic.Field;"+newLine);
		javaSB.append("import deepspot.basic.DetailBean;"+newLine);
		javaSB.append("import deepspot.basic.SelectItem;"+newLine);
		javaSB.append("import deepspot.util.Util;"+newLine);
		javaSB.append(newLine);
    
		/* make class begain line */
		javaSB.append("public class "+className+" extends DetailBean {"+newLine);
		javaSB.append(newLine);
    
		/* make constracotr method */
		javaSB.append("    public "+className+"(){this.init();}"+newLine);
		javaSB.append(newLine);
		
		javaSB.append("    public "+className+"(String FlowKey) {"+newLine);
		javaSB.append("        this.init();"+newLine);
		javaSB.append("        this.setFlowKey(FlowKey);"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
    
		/* make all fields & set_get methods */
		Element fields = javaInfo.element("table").element("detail");
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			if(!eName.equals("FlowKey") && !eName.equals("Seq_no")){
				javaSB.append("    public Field "+eName+";"+newLine);
				javaSB.append("    public void set"+eName+"(String "+eName+
							  "){this."+eName+".setValue("+eName+");}"+newLine);
				javaSB.append("    public String get"+eName+"(){return this."+
										  eName+".getValue();}"+newLine);
				javaSB.append(newLine);
			}
		}
		
		/* make init() */
		javaSB.append("    public void init() {"+newLine);
		javaSB.append("        super.init();"+newLine);
		javaSB.append("        this.setProgramId(\"jsp."+className+"\");"+newLine);
		javaSB.append("        this.setTableName(\""+className+"\");"+newLine);
		javaSB.append(newLine);
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			String chkEmpty = e.attributeValue("chkEmpty");
			if(!eName.equals("FlowKey") && !eName.equals("Seq_no")){
				javaSB.append("        this."+eName+" = new Field(\""+eName+
								  "\", this.getTableName());"+newLine);
				if(chkEmpty!=null && chkEmpty.equals("true")){
					javaSB.append("        this."+eName+".setCheckEmpty(true);"+newLine);
				}
				javaSB.append(newLine);
			}
		}
		javaSB.append("        this.setDbFields();"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make setDbFields() */
		javaSB.append("    public void setDbFields() {"+newLine);
		javaSB.append("        super.setDbFields();"+newLine);
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			String dbType = e.attributeValue("dbType");
			if(!eName.equals("FlowKey") && !eName.equals("Seq_no")){
				if(dbType!=null && dbType.trim().length()>0){
					javaSB.append("        this."+eName+".setDbType(\""+dbType+"\");"+newLine);
				}
				javaSB.append("        this.getDbFields().add(this."+eName+");"+newLine);
			}
		}
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make printMaintainTable() */
		javaSB.append("    public String printMaintainTable() throws Exception {"+newLine);
		javaSB.append("        String rtnString = Cnstnts.EMPTY_STRING;"+newLine);
		for(Iterator<?> itr=fields.elementIterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String eName = e.attributeValue("name");
			String htmlType = e.attributeValue("htmlType");
			String selectItem = e.attributeValue("selectItem");
			String mapingPrpt = e.attributeValue("mapingPrpt");
			if(htmlType==null || htmlType.trim().length()==0){
				htmlType = "Cnstnts.HTML_TAG_TEXT";
			}
			if(!eName.equals("FlowKey") && !eName.equals("Seq_no")){
				javaSB.append("            " +
						  "this."+eName+".setHtmlType("+htmlType+");"+newLine);
				if(selectItem!=null && selectItem.trim().length()>0){
					javaSB.append("            " +
						  "this."+eName+".setSelectList("+selectItem+");"+newLine);
				}
				if(mapingPrpt!=null && mapingPrpt.trim().length()>0){
					javaSB.append("            " +
						  "this."+eName+".setMapingPrpt("+mapingPrpt+");"+newLine);
				}
				javaSB.append("            " +
						  "rtnString += this.printHtml(this."+eName+");"+newLine);
				javaSB.append(newLine);	
			}
		}
		javaSB.append("        return rtnString;"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make doAction() */
		javaSB.append("    @SuppressWarnings(\"unchecked\")"+newLine);
		javaSB.append("    public void doAction(UserBean userInfo) throws Exception{"+newLine);
		javaSB.append("        this.setUserInfo(userInfo);"+newLine);
		javaSB.append("        if(this.onBtnSubmit()){"+newLine);
		javaSB.append("            if(this.checkFieldEmptyError()){"+newLine);
		javaSB.append("                return;"+newLine);
		javaSB.append("            } else {"+newLine);
		javaSB.append("                if(this.checkHasAnotherError()){"+newLine);
		javaSB.append("                    return;"+newLine);
		javaSB.append("                } else {"+newLine);
		javaSB.append("                    this.setCloseFlag(true);"+newLine);
		javaSB.append("                }"+newLine);
		javaSB.append("            }"+newLine);
		javaSB.append("            "+class_name+" parentObj = ("+
					  class_name+")userInfo.getObj(\""+class_name+"\");"+newLine);
		javaSB.append("            this.setDbFields();"+newLine);
		javaSB.append("            if(Cnstnts.INSERT.equals(this.getActionMode())){"+newLine);
		javaSB.append("                parentObj.getDetails().add(this.getDbFields());"+newLine);
		javaSB.append("            }"+newLine);
		javaSB.append("            if(Cnstnts.UPDATE.equals(this.getActionMode())){"+newLine);
		javaSB.append("                parentObj.getDetails().set(this.getRecordIndex(), this.getDbFields());"+newLine);
		javaSB.append("            }"+newLine);
		javaSB.append("         } else {"+newLine);
		javaSB.append("            if(Cnstnts.UPDATE.equals(this.getActionMode())){"+newLine);
		javaSB.append("                "+class_name+" parentObj = ("+
					  class_name+")userInfo.getObj(\""+class_name+"\");"+newLine);
		javaSB.append("                parentObj.setDbFields();"+newLine);
		javaSB.append("                List<Field> parentFields = (List<Field>)parentObj.getDetails().get(this.getRecordIndex());"+newLine);
		javaSB.append("                this.setDbFields();"+newLine);
		javaSB.append("                for(Iterator parentFieldsItr=parentFields.iterator();parentFieldsItr.hasNext();){"+newLine);
		javaSB.append("                    Field parentField = (Field)parentFieldsItr.next();"+newLine);
		javaSB.append("                    if(parentField!=null){"+newLine);
		javaSB.append("                        for(Iterator thisFieldsItr=this.getDbFields().iterator();thisFieldsItr.hasNext();){"+newLine);
		javaSB.append("                            Field thisField = (Field)thisFieldsItr.next();"+newLine);
		javaSB.append("                            if(thisField!=null && thisField.getName().equals(parentField.getName())){"+newLine);
		javaSB.append("                                thisField.setValue(parentField.getValue());"+newLine);
		javaSB.append("                            }"+newLine);
		javaSB.append("                        }"+newLine);
		javaSB.append("                    }"+newLine);
		javaSB.append("                }"+newLine);
		javaSB.append("            }"+newLine);
		javaSB.append("        }"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
		/* make checkHasAnotherError() */
		javaSB.append("    private boolean checkHasAnotherError() throws Exception{"+newLine);
		javaSB.append("        return false;"+newLine);
		javaSB.append("    }"+newLine);
		javaSB.append(newLine);
		
        javaSB.append("}");
    
	    File javaFile = new File(javaOut);
	    writeToFile(javaFile,javaSB);
	}
  
  	private static void makeJsp(Element javaInfo) throws Exception {
  		String className = class_name;
  		jspSB = new StringBuffer();
  		jspSB.append("<%@ include file=\"include/jspHeader.include\" %>");
  		jspSB.append(newLine+"<jsp:useBean id=\"thisObj\" scope=\"page\" "+
  					"class=\"deepspot.main."+className+"\"/>");
  		jspSB.append(newLine+"<jsp:setProperty name=\"thisObj\" property=\"*\"/>");
  		jspSB.append(newLine+"<%@ include file=\"include/jspHtml.include\"%>");
  		File jspFile = new File("../../"+className+".jsp");
  		writeToFile(jspFile,jspSB);
    
  		if(createType.equals("masterDetail")){
  			String detailClass = class_name + "_detail";
  			jspSB = new StringBuffer();
  			jspSB.append("<%@ include file=\"include/jspDetailHeader.include\" %>");
  			jspSB.append(newLine+"<jsp:useBean id=\"thisObj\" scope=\"page\" "+
  						"class=\"deepspot.main."+detailClass+"\"/>");
  			jspSB.append(newLine+"<jsp:setProperty name=\"thisObj\" property=\"*\"/>");
  			jspSB.append(newLine+"<%@ include file=\"include/jspDetailHtml.include\"%>");
  			jspFile = new File("../../"+detailClass+".jsp");
  			writeToFile(jspFile,jspSB);
  		} 
  	}
  
  	private static void writeToFile(File outFile, 
		  						  StringBuffer pageContent) throws IOException {
  		FileWriter fileOut = null;
  		try {
  			fileOut = new FileWriter(outFile);
  			fileOut.write(pageContent.toString());
  			System.out.println(outFile + " file created ok.");
  		} catch (Exception e) {
  			e.printStackTrace();
  		} finally {   
  			fileOut.close();
  		}
  	}
  
  	private static void makeMessage(Element javaInfo) throws Exception {
  		
  		String masterClass = class_name;
  		String detailClass = class_name + "_detail";
  		Vector<Element> jspMsgVtr = new Vector<Element>();
    
  		String title = javaInfo.element("table").element("master").attributeValue("title");
  		if(title!=null && title.trim().length()>0){
  			DocumentFactory _df = new DocumentFactory();
  			Element _newElement = _df.createElement("jsp."+masterClass+".title");
  			_newElement.addAttribute("value",title);
  			jspMsgVtr.add(_newElement);
  		}
  		Iterator<?> fields = javaInfo.element("table").element("master").elementIterator();
  		while(fields.hasNext()) {
  			Element e = (Element)fields.next();
  			String fieldName = e.attributeValue("name");
  			String jspMsgValue = e.attributeValue("jspMsgValue");
      
  			if(jspMsgValue!=null && fieldName!=null 
  					&& jspMsgValue.trim().length()>0 
  							&& fieldName.trim().length()>0){
  				DocumentFactory df = new DocumentFactory();
  				Element newElement = df.createElement("jsp."+masterClass+"."+fieldName);
  				newElement.addAttribute("value",jspMsgValue);
  				jspMsgVtr.add(newElement);
  			}
  		}
    
  		title = javaInfo.element("table").element("detail").attributeValue("title");
  		if(title!=null && title.trim().length()>0){
  			DocumentFactory _df = new DocumentFactory();
  			Element _newElement = _df.createElement("jsp."+detailClass+".title");
  			_newElement.addAttribute("value",title);
  			jspMsgVtr.add(_newElement);
  		}
  		fields = javaInfo.element("table").element("detail").elementIterator();
  		while(fields.hasNext()) {
  			Element e = (Element)fields.next();
  			String fieldName = e.attributeValue("name");
  			String jspMsgValue = e.attributeValue("jspMsgValue");
      
  			if(jspMsgValue!=null && fieldName!=null 
  					&& jspMsgValue.trim().length()>0 
  							&& fieldName.trim().length()>0){
  				DocumentFactory df = new DocumentFactory();
  				Element newElement = df.createElement("jsp."+detailClass+"."+fieldName);
  				newElement.addAttribute("value",jspMsgValue);
  				jspMsgVtr.add(newElement);
  			}
  		}
    
  		File outFile = new File("../xmlschema/tmpMessage.xml");
  		StringBuffer sb = new StringBuffer();
      
  		Iterator<Element> jspMsgItr = jspMsgVtr.iterator();
  		while(jspMsgItr.hasNext()) {
  			Element ejspMsg = (Element)jspMsgItr.next();
  			String s = "    <" + ejspMsg.getName() + " value=\"" + 
  					   ejspMsg.attributeValue("value") + "\"/>" + newLine ;
  			sb.append(s);
  		}
    
  		writeToFile(outFile,sb);
  	}
  
}