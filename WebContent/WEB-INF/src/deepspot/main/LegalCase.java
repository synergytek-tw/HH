package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.MasterBean;
import deepspot.basic.Field;
import deepspot.basic.SelectItem;
import deepspot.html.HiddenTag;
import deepspot.html.SelectOneTag;
import deepspot.util.Util;

public class LegalCase extends MasterBean {

    public LegalCase(){this.init();}

    public LegalCase(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}
    
    public Field Description;
    public void setDescription(String Description){this.Description.setValue(Description);}
    public String getDescription(){return this.Description.getValue();}
    
    public Field MainType;
    public void setMainType(String MainType){this.MainType.setValue(MainType);}
    public String getMainType(){return this.MainType.getValue();}
    
    public Field SubType;
    public void setSubType(String SubType){this.SubType.setValue(SubType);}
    public String getSubType(){return this.SubType.getValue();}
    
    public Field Priority;
    public void setPriority(String Priority){this.Priority.setValue(Priority);}
    public String getPriority(){return this.Priority.getValue();}
    
    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}
    
    public Field TargetStartDate;
    public void setTargetStartDate(String TargetStartDate){this.TargetStartDate.setValue(TargetStartDate);}
    public String getTargetStartDate(){return this.TargetStartDate.getValue();}
    
    public Field RealStartDate;
    public void setRealStartDate(String RealStartDate){this.RealStartDate.setValue(RealStartDate);}
    public String getRealStartDate(){return this.RealStartDate.getValue();}
    
    public Field TargetFinishDate;
    public void setTargetFinishDate(String TargetFinishDate){this.TargetFinishDate.setValue(TargetFinishDate);}
    public String getTargetFinishDate(){return this.TargetFinishDate.getValue();}
    
    public Field RealFinishDate;
    public void setRealFinishDate(String RealFinishDate){this.RealFinishDate.setValue(RealFinishDate);}
    public String getRealFinishDate(){return this.RealFinishDate.getValue();}
    
    public Field TmpField_01;
    public void setTmpField_01(String TmpField_01){this.TmpField_01.setValue(TmpField_01);}
    public String getTmpField_01(){return this.TmpField_01.getValue();}
    
    public Field TmpField_02;
    public void setTmpField_02(String TmpField_02){this.TmpField_02.setValue(TmpField_02);}
    public String getTmpField_02(){return this.TmpField_02.getValue();}
    
    public Field TmpField_03;
    public void setTmpField_03(String TmpField_03){this.TmpField_03.setValue(TmpField_03);}
    public String getTmpField_03(){return this.TmpField_03.getValue();}
    
    public Field TmpField_04;
    public void setTmpField_04(String TmpField_04){this.TmpField_04.setValue(TmpField_04);}
    public String getTmpField_04(){return this.TmpField_04.getValue();}
    
    public Field TmpField_05;
    public void setTmpField_05(String TmpField_05){this.TmpField_05.setValue(TmpField_05);}
    public String getTmpField_05(){return this.TmpField_05.getValue();}
    
    public Field TmpField_06;
    public void setTmpField_06(String TmpField_06){this.TmpField_06.setValue(TmpField_06);}
    public String getTmpField_06(){return this.TmpField_06.getValue();}
    
    public Field TmpField_07;
    public void setTmpField_07(String TmpField_07){this.TmpField_07.setValue(TmpField_07);}
    public String getTmpField_07(){return this.TmpField_07.getValue();}
    
    public Field TmpField_08;
    public void setTmpField_08(String TmpField_08){this.TmpField_08.setValue(TmpField_08);}
    public String getTmpField_08(){return this.TmpField_08.getValue();}
    
    public Field TmpField_09;
    public void setTmpField_09(String TmpField_09){this.TmpField_09.setValue(TmpField_09);}
    public String getTmpField_09(){return this.TmpField_09.getValue();}
    
    public Field TmpField_10;
    public void setTmpField_10(String TmpField_10){this.TmpField_10.setValue(TmpField_10);}
    public String getTmpField_10(){return this.TmpField_10.getValue();}
    
    public Field TabText;
    public void setTabText(String TabText){this.TabText.setValue(TabText);}
    public String getTabText(){return this.TabText.getValue();}
    

    public void init() {
        super.init();
        this.setProgramId("jsp.LegalCase");
        this.setTableName("LegalCase");

        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("nvarchar(500)");
        this.Title.setCheckEmpty(true);
        this.Title.setSearchCondition(Cnstnts.LIKE);

        this.Description = new Field("Description", this.getTableName());
        this.Description.setDbType("nvarchar(500)");
        this.Description.setCheckEmpty(true);
        this.Description.setSearchCondition(Cnstnts.LIKE);
        
        this.MainType = new Field("MainType", this.getTableName());
        this.MainType.setDbType("varchar(50)");
        this.MainType.setCheckEmpty(true);

        this.SubType = new Field("SubType", this.getTableName());
        this.SubType.setDbType("varchar(50)");
        this.SubType.setCheckEmpty(true);

        this.Priority = new Field("Priority", this.getTableName());
        this.Priority.setDbType("varchar(50)");

        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");

        this.TargetStartDate = new Field("TargetStartDate", this.getTableName());
        this.TargetStartDate.setDbType("varchar(10)");
        
        this.RealStartDate = new Field("RealStartDate", this.getTableName());
        this.RealStartDate.setDbType("varchar(10)");
        
        this.TargetFinishDate = new Field("TargetFinishDate", this.getTableName());
        this.TargetFinishDate.setDbType("nvarchar(10)");
        
        this.RealFinishDate = new Field("RealFinishDate", this.getTableName());
        this.RealFinishDate.setDbType("nvarchar(10)");
        
        this.TmpField_01 = new Field("TmpField_01", this.getTableName());
        this.TmpField_01.setDbType("nvarchar(50)");
        
        this.TmpField_02 = new Field("TmpField_02", this.getTableName());
        this.TmpField_02.setDbType("nvarchar(50)");
        
        this.TmpField_03 = new Field("TmpField_03", this.getTableName());
        this.TmpField_03.setDbType("nvarchar(50)");
        
        this.TmpField_04 = new Field("TmpField_04", this.getTableName());
        this.TmpField_04.setDbType("nvarchar(50)");
        
        this.TmpField_05 = new Field("TmpField_05", this.getTableName());
        this.TmpField_05.setDbType("nvarchar(50)");
        
        this.TmpField_06 = new Field("TmpField_06", this.getTableName());
        this.TmpField_06.setDbType("nvarchar(50)");
        
        this.TmpField_07 = new Field("TmpField_07", this.getTableName());
        this.TmpField_07.setDbType("nvarchar(50)");
        
        this.TmpField_08 = new Field("TmpField_08", this.getTableName());
        this.TmpField_08.setDbType("nvarchar(50)");
        
        this.TmpField_09 = new Field("TmpField_09", this.getTableName());
        this.TmpField_09.setDbType("nvarchar(50)");
        
        this.TmpField_10 = new Field("TmpField_10", this.getTableName());
        this.TmpField_10.setDbType("nvarchar(50)");
        
        this.TabText = new Field("TabText", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    private List<List<Field>> InventorDetails;
    
    public void setInventorDetails(ArrayList<List<Field>> Details) {
    	this.InventorDetails = Details;
	}
    
    public List<List<Field>> getInventorDetails(String FlowKey) {
		return null;
	}
    
    public List<List<Field>> getInventorDetails() {
    	return this.InventorDetails;
	}

	public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.Title);
        this.DbFields.add(this.Description);
        this.DbFields.add(this.MainType);
        this.DbFields.add(this.SubType);
        this.DbFields.add(this.Priority);
        this.DbFields.add(this.Status);        
        this.DbFields.add(this.TargetStartDate);
        this.DbFields.add(this.RealStartDate);
        this.DbFields.add(this.TargetFinishDate);
        this.DbFields.add(this.RealFinishDate);
        this.DbFields.add(this.TmpField_01);
        this.DbFields.add(this.TmpField_02);
        this.DbFields.add(this.TmpField_03);
        this.DbFields.add(this.TmpField_04);
        this.DbFields.add(this.TmpField_05);
        this.DbFields.add(this.TmpField_06);
        this.DbFields.add(this.TmpField_07);
        this.DbFields.add(this.TmpField_08);
        this.DbFields.add(this.TmpField_09);
        this.DbFields.add(this.TmpField_10);
    }
	
	protected String getDbActionSelectItem() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;

		if ((Cnstnts.TRUE_FLAG.equals(this.getModeLockFlag()) 
				&& !this.getProgramMode().equals("M"))
					|| (Cnstnts.MAINTAIN.equals(this.getPageActionMode()) 
						&& (Cnstnts.SIGN.equals(this.getDbActionMode())
							|| Cnstnts.CLOSE.equals(this.getDbActionMode()) 
								|| Cnstnts.ENDING.equals(this.getDbActionMode())))
									|| Cnstnts.SEARCH.equals(this.getPageActionMode())) {
			rtnString = new HiddenTag("dbActionMode", this.getDbActionMode()).toString();
			return rtnString;
		}
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())
				&& this.getDbActionList() == null) {
			this.setDbActionList(getUserInfo().getDbActionList(this.getProgramId()));
		}

		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())){
			String onChange = "doAjaxRequest(\"LegalCase\",\"dbActionMode\",\"dbActionMode\",\"bodyDiv\",\"innerHTML\")";
			SelectOneTag selectItem = new SelectOneTag(Cnstnts.DB_ACTION_MODE,
					onChange, this.getDbActionMode(), this.getDbActionList());

			rtnString = selectItem.toString();
		}
		return rtnString;
	}

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("LegalCaseStatus"));
            
        	this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Title.setSize(20);
        	this.Title.setAnotherField(this.Status);
            rtnString += this.printHtml(this.Title);
            
            this.SubType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.SubType.setSelectList(new Category().getChildList(this.SubType));

            this.MainType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.MainType.setSelectList(new Category().getChildList(this.MainType));
            this.MainType.setAnotherField(this.SubType);
            rtnString += this.printHtml(this.MainType);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Title.setCols(82);
            this.Title.setRows(2);
            rtnString += this.printHtml(this.Title);

            this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Description.setCols(82);
            this.Description.setRows(2);
            rtnString += this.printHtml(this.Description);

            this.SubType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.SubType.setSelectList(new Category().getChildList(this.SubType));
            
            this.MainType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.MainType.setSelectList(new Category().getChildList(this.MainType));
            this.MainType.setAnotherField(this.SubType);
            this.MainType.setColspan(1);
            rtnString += this.printHtml(this.MainType);
            
            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("LegalCaseStatus"));
            
            List<SelectItem> priorityItems = new ArrayList<SelectItem>();
            priorityItems.add(new SelectItem("1","1"));
            priorityItems.add(new SelectItem("2","2"));
            priorityItems.add(new SelectItem("3","3"));
            priorityItems.add(new SelectItem("4","4"));
            priorityItems.add(new SelectItem("5","5"));
            this.Priority.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Priority.setSelectList(priorityItems);
            this.Priority.setColspan(1);
            this.Priority.setAnotherField(this.Status);
            rtnString += this.printHtml(this.Priority);
                    	
        	this.RealStartDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.TargetStartDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.TargetStartDate.setAnotherField(this.RealStartDate);
            this.TargetStartDate.setColspan(1);
            rtnString += this.printHtml(this.TargetStartDate);
            
            this.RealFinishDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.TargetFinishDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.TargetFinishDate.setAnotherField(this.RealFinishDate);
            this.TargetFinishDate.setColspan(1);
            rtnString += this.printHtml(this.TargetFinishDate);
            
            if(this.TabText.getValue().trim().length()==0){
            	this.TabText.setValue("LegalSecondPage");
            }
            rtnString += this.TabText.printHiddenTag();
            
            if(this.FlowKey.getValue().trim().length()>0){
            	String scriptText = Cnstnts.EMPTY_STRING;
            	String resetBtn = "resetBtn('"+this.getTabText()+"');";   
            	scriptText = "<script>"+resetBtn+
								"function openTabFrame(jspName,dbActionMode,flowkey,frameHight){"+
								"  var frameWidth=document.getElementById('functionBar').offsetWidth;"+
								"  var tabFramDiv=document.getElementById('tabDiv');"+
								"  var srcUrl=jspName+'.jsp?_pageActionMode=maintain&_dbActionMode='+dbActionMode;"+
								"  if(dbActionMode=='insert'){"+
								"    srcUrl += '&parentId='+flowkey;"+
								"  } else {"+
								"    srcUrl += '&_getDataFlag=true&flowKey='+flowkey;"+
								"  }"+
								"  tabFramDiv.innerHTML=\"<iframe "+
									"src='\"+srcUrl+\"' height='\"+frameHight+\"' width='\"+(frameWidth-30)+\"'></iframe>\";"+
								"}"+
								"function closeTabFrame(){"+
								"  var tabFramDiv=document.getElementById('tabDiv');"+
								"  tabFramDiv.innerHTML='';"+
								"}"+
								"function resetBtn(newTabText){"+
								"  for(x=0;x<document.input.elements.length;x++){"+
								"    if(document.input.elements[x].type=='button'){"+
								"      document.input.elements[x].disabled=false;"+
								"    }"+
								"  }"+
								"  document.getElementById(newTabText).disabled=true;"+
								"}"+
								"function resetFrame(newTabText){"+
								"  resetBtn(newTabText);"+
								"  document.getElementById(newTabText).disabled=true;"+
								"  document.input.tabText.value=newTabText;"+
								"  closeTabFrame();"+
								"  doAjaxRequest('LegalCase','tabText','tabText','detailDiv','innerHTML')"+
								"}"+
								"</script>";
            	
            	rtnString += "<tr><td colspan=4>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.LegalCase.LegalSecondPage")+"' "+
            						   	"id='LegalSecondPage' onClick='resetFrame(\"LegalSecondPage\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.LegalColleagues.title")+"' "+
            							"id='LegalColleagues' onClick='resetFrame(\"LegalColleagues\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.LegalDocument.title")+"' "+
            							"id='LegalDocument' onClick='resetFrame(\"LegalDocument\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.LegalApplicant.title")+"' "+
            							"id='LegalApplicant' onClick='resetFrame(\"LegalApplicant\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.LegalPriority.title")+"' "+
            							"id='LegalPriority' onClick='resetFrame(\"LegalPriority\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.LegalAttorney.title")+"' "+
            							"id='LegalAttorney' onClick='resetFrame(\"LegalAttorney\")'/>"+
            				 "</td></tr>"+scriptText+
            				 "<tr"+Cnstnts.DEFAULT_TR_BGCOLOR_1+"><td colspan='4'>"+
            				 "<table width='100%'>"+
            				 	"<tr><td><div id='tabDiv' name='tabDiv'></div></td></tr>"+
            				 	"<tr><td>" +
            				 		"<div id='detailDiv' name='detailDiv'>"+this.printDetailTable()+"</div>" +
            				 	"</td></tr>"+
            				 "</table></td></tr>";
            }
           
        }
        return rtnString;
    }

    public void setSearchListPrpts() {
    	Properties categoryPrpt = null;
    	try {
			categoryPrpt = new Category().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.FlowKey.setListWidth("10%");

        this.Title.setListWidth("40%");

        this.MainType.setListWidth("10%");
        this.MainType.setMapingPrpt(categoryPrpt);
        this.MainType.setNotShowCode(true);
        
        this.SubType.setListWidth("10%");
        this.SubType.setMapingPrpt(categoryPrpt);
        this.SubType.setNotShowCode(true);

        this.Status.setListWidth("10%");
        this.Status.setMapingPrpt(categoryPrpt);
        this.Status.setNotShowCode(true);
        
        this.TargetStartDate.setListWidth("10%");
        this.TargetStartDate.setAlign(Cnstnts.CENTER);
        
        this.TargetFinishDate.setListWidth("10%");
        this.TargetFinishDate.setAlign(Cnstnts.CENTER);

        Field[] showField = {this.FlowKey, this.Title, this.MainType, this.SubType, 
        					 this.Status, this.TargetStartDate, this.TargetFinishDate};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.Title);
        whereStr = Util.addWhereSQL(whereStr, this.MainType);
        whereStr = Util.addWhereSQL(whereStr, this.SubType);
        whereStr = Util.addWhereSQL(whereStr, this.Status);
        whereStr = this.getDataAuthorityWhereSQL(whereStr);
        String SQL = "select * from LegalCase "+whereStr;
        SQL = Util.addOrderSQL(SQL, this.getOrderKey(), this.getOrderSequence());
        //System.out.println(SQL);
        return this.doSearch(SQL);
    }
    
    public List<Object[]> doSearch(String SQL) throws Exception{
  	  	if(this.getPageNo()==0){
  	  		this.setPageNo(1);
  	  	}
        int recordCount=0;
        
        List<Object[]> rtnList = new ArrayList<Object[]>();
        
        Iterator<?> itr = this.getDbUtil().getList(SQL, this.getShowField()).iterator();
        while(itr.hasNext()){
      	  Object[] record = (Object[])itr.next();
      	  recordCount++;
      	  if(recordCount<=this.getPageNo()*this.getPageRecords()
      			  && recordCount>(this.getPageNo()-1)*this.getPageRecords()){
      		  rtnList.add(record);
      	  }
        }
        this.setFindRecords(recordCount);
        return rtnList;
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Title);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
        	LegalCase preObj = (LegalCase) userInfo.getObj(this.getTableName());
            if(this.onBtnDeleteDetail()
                    && this.getDeleteItems()!=null
            				   && this.getDeleteItems().length>0){
                for(int i=0;i<this.getDeleteItems().length;i++){
                    int seqNo = Integer.parseInt(this.getDeleteItems()[i]);
                    preObj.getDetails().remove(seqNo-i);
                }
            }
            this.setSearchResult(preObj.getSearchResult());
            if (!this.getDataFromDB()) {
                this.setDetails(preObj.getDetails());
            }
        }
    }
    
    public boolean checkInsertError() throws Exception {
        if(super.checkInsertError()){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUpdateError() throws Exception {
        return this.checkInsertError();
    }

    public boolean checkDeleteError() throws Exception {
        if(super.checkDeleteError()){
            return true;
        } else {
            return false;
        }
    }
    
    public String printDetailTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if(this.getTabText().equals("LegalDocument")){
        	rtnString = new LegalDocument().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("LegalApplicant")){
        	rtnString = new LegalApplicant().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("LegalColleagues")){
        	rtnString = new LegalColleagues().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("LegalAttorney")){
        	rtnString = new LegalAttorney().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("LegalPriority")){
        	rtnString = new LegalPriority().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("LegalSecondPage")){
        	rtnString="<table width='100%' " + this.getTableBgcolor() + ">";
        	
        	this.TmpField_02.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.TmpField_01.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TmpField_01.setAnotherField(this.TmpField_02);
            this.TmpField_01.setColspan(1);
            rtnString += this.printHtml(this.TmpField_01);
            
            this.TmpField_04.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.TmpField_03.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TmpField_03.setAnotherField(this.TmpField_04);
            this.TmpField_03.setColspan(1);
            rtnString += this.printHtml(this.TmpField_03);
            
            this.TmpField_06.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.TmpField_05.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TmpField_05.setAnotherField(this.TmpField_06);
            this.TmpField_05.setColspan(1);
            rtnString += this.printHtml(this.TmpField_05);
            
            this.TmpField_08.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.TmpField_07.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TmpField_07.setAnotherField(this.TmpField_08);
            this.TmpField_07.setColspan(1);
            rtnString += this.printHtml(this.TmpField_07);
            
            this.TmpField_10.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.TmpField_09.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TmpField_09.setAnotherField(this.TmpField_10);
            this.TmpField_09.setColspan(1);
            rtnString += this.printHtml(this.TmpField_09);
        	
            rtnString += "</table>";
        } else {
        	rtnString += this.TmpField_01.printHiddenTag();
        	rtnString += this.TmpField_02.printHiddenTag();
        	rtnString += this.TmpField_03.printHiddenTag();
        	rtnString += this.TmpField_04.printHiddenTag();
        	rtnString += this.TmpField_05.printHiddenTag();
        	rtnString += this.TmpField_06.printHiddenTag();
        	rtnString += this.TmpField_07.printHiddenTag();
        	rtnString += this.TmpField_08.printHiddenTag();
        	rtnString += this.TmpField_09.printHiddenTag();
        	rtnString += this.TmpField_10.printHiddenTag();
        }
        return rtnString;
    }
    
    public boolean delete() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.setDbFields();
		if (this.hasBindingFlow()) {
			sqlList.add("delete from Flow where FlowKey='" + this.getFlowKey()
					+ "'");
			sqlList.add("delete from Flow_detail where FlowKey='"
					+ this.getFlowKey() + "'");
		}
		sqlList.add("delete from LegalApplicant where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from LegalDocument where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from LegalColleagues where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from LegalAttorney where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from LegalPriority where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from "+this.getTableName()+" where FlowKey='"+this.getFlowKey()+"'");
		if (this.getDetails() != null) {
			sqlList.add("delete from " + this.getTableName()
					+ "_detail where FlowKey='" + this.getFlowKey() + "'");
		}
		if (new Program(this.getProgramId()).getLogDelete().equals("1")) {
			sqlList.add(this.getLogSQL(null));
		}
		return this.getDbUtil().executeUpdate(sqlList);
	}
    
    public void doPrintProcess() throws Exception {
    	String outFile = this.makeDoc();
    	if(outFile!=null){
    		this.setOutputFile(outFile);
    	}
	}
    
    public String makeDoc() throws Exception{
    	if(this.getSampleDoc().trim().length()==0){
    		return null;
    	}
    	
    	return null;
    }

}