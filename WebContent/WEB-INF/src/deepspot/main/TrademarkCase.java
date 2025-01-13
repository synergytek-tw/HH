package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.MasterBean;
import deepspot.basic.Field;
import deepspot.html.HiddenTag;
import deepspot.html.SelectOneTag;
import deepspot.util.Util;

public class TrademarkCase extends MasterBean {

    public TrademarkCase(){this.init();}

    public TrademarkCase(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Office;
    public void setOffice(String Office){this.Office.setValue(Office);}
    public String getOffice(){return this.Office.getValue();}
    
    public Field TrademarkType;
    public void setTrademarkType(String TrademarkType){this.TrademarkType.setValue(TrademarkType);}
    public String getTrademarkType(){return this.TrademarkType.getValue();}
    
    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}
    
    public Field AttorneyDate;
    public void setAttorneyDate(String AttorneyDate){this.AttorneyDate.setValue(AttorneyDate);}
    public String getAttorneyDate(){return this.AttorneyDate.getValue();}
    
    public Field AttorneyNum;
    public void setAttorneyNum(String AttorneyNum){this.AttorneyNum.setValue(AttorneyNum);}
    public String getAttorneyNum(){return this.AttorneyNum.getValue();}
    
    public Field FillingDate;
    public void setFillingDate(String FillingDate){this.FillingDate.setValue(FillingDate);}
    public String getFillingDate(){return this.FillingDate.getValue();}
    
    public Field FillingNum;
    public void setFillingNum(String FillingNum){this.FillingNum.setValue(FillingNum);}
    public String getFillingNum(){return this.FillingNum.getValue();}
    
    public Field PublicationDate;
    public void setPublicationDate(String PublicationDate){this.PublicationDate.setValue(PublicationDate);}
    public String getPublicationDate(){return this.PublicationDate.getValue();}
    
    public Field PublicationNum;
    public void setPublicationNum(String PublicationNum){this.PublicationNum.setValue(PublicationNum);}
    public String getPublicationNum(){return this.PublicationNum.getValue();}
    
    public Field RegistDate;
    public void setRegistDate(String RegistDate){this.RegistDate.setValue(RegistDate);}
    public String getRegistDate(){return this.RegistDate.getValue();}
    
    public Field RegistNum;
    public void setRegistNum(String RegistNum){this.RegistNum.setValue(RegistNum);}
    public String getRegistNum(){return this.RegistNum.getValue();}
    
    public Field TrademarkNum;
    public void setTrademarkNum(String TrademarkNum){this.TrademarkNum.setValue(TrademarkNum);}
    public String getTrademarkNum(){return this.TrademarkNum.getValue();}
    
    public Field TrademarkNo;
    public void setTrademarkNo(String TrademarkNo){this.TrademarkNo.setValue(TrademarkNo);}
    public String getTrademarkNo(){return this.TrademarkNo.getValue();}
    
    public Field ExpiryDate;
    public void setExpiryDate(String ExpiryDate){this.ExpiryDate.setValue(ExpiryDate);}
    public String getExpiryDate(){return this.ExpiryDate.getValue();}
    
    public Field ExtendDate;
    public void setExtendDate(String ExtendDate){this.ExtendDate.setValue(ExtendDate);}
    public String getExtendDate(){return this.ExtendDate.getValue();}
    
    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}
    
    public Field ClosedDate;
    public void setClosedDate(String ClosedDate){this.ClosedDate.setValue(ClosedDate);}
    public String getClosedDate(){return this.ClosedDate.getValue();}
    
    public Field TrademarkImg;
    public void setTrademarkImg(String TrademarkImg){this.TrademarkImg.setValue(TrademarkImg);}
    public String getTrademarkImg(){return this.TrademarkImg.getValue();}
    
    public Field Color;
    public void setColor(String Color){this.Color.setValue(Color);}
    public String getColor(){return this.Color.getValue();}
    
    public Field NoBelongDesc;
    public void setNoBelongDesc(String NoBelongDesc){this.NoBelongDesc.setValue(NoBelongDesc);}
    public String getNoBelongDesc(){return this.NoBelongDesc.getValue();}
    
    public Field ChtWordsinMark;
    public void setChtWordsinMark(String ChtWordsinMark){this.ChtWordsinMark.setValue(ChtWordsinMark);}
    public String getChtWordsinMark(){return this.ChtWordsinMark.getValue();}
    
    public Field EngWordsinMark;
    public void setEngWordsinMark(String EngWordsinMark){this.EngWordsinMark.setValue(EngWordsinMark);}
    public String getEngWordsinMark(){return this.EngWordsinMark.getValue();}
    
    public Field JapWordsinMark;
    public void setJapWordsinMark(String JapWordsinMark){this.JapWordsinMark.setValue(JapWordsinMark);}
    public String getJapWordsinMark(){return this.JapWordsinMark.getValue();}
    
    public Field Significance;
    public void setSignificance(String Significance){this.Significance.setValue(Significance);}
    public String getSignificance(){return this.Significance.getValue();}
    
    public Field GraphDesc;
    public void setGraphDesc(String GraphDesc){this.GraphDesc.setValue(GraphDesc);}
    public String getGraphDesc(){return this.GraphDesc.getValue();}
    
    public Field DesignMark;
    public void setDesignMark(String DesignMark){this.DesignMark.setValue(DesignMark);}
    public String getDesignMark(){return this.DesignMark.getValue();}
    
    public Field TabText;
    public void setTabText(String TabText){this.TabText.setValue(TabText);}
    public String getTabText(){return this.TabText.getValue();}
    

    public void init() {
        super.init();
        this.setProgramId("jsp.TrademarkCase");
        this.setTableName("TrademarkCase");

        this.Office = new Field("Office", this.getTableName());
        this.Office.setDbType("varchar(50)");
        this.Office.setCheckEmpty(true);
        
        this.TrademarkType = new Field("TrademarkType", this.getTableName());
        this.TrademarkType.setDbType("varchar(50)");
        this.TrademarkType.setCheckEmpty(true);

        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("nvarchar(500)");
        this.Title.setCheckEmpty(true);
        this.Title.setSearchCondition(Cnstnts.LIKE);
        
        this.AttorneyDate = new Field("AttorneyDate", this.getTableName());
        this.AttorneyDate.setDbType("varchar(10)");
        
        this.AttorneyNum = new Field("AttorneyNum", this.getTableName());
        this.AttorneyNum.setDbType("varchar(50)");
        
        this.FillingDate = new Field("FillingDate", this.getTableName());
        this.FillingDate.setDbType("varchar(10)");
        
        this.FillingNum = new Field("FillingNum", this.getTableName());
        this.FillingNum.setDbType("varchar(50)");
        
        this.PublicationDate = new Field("PublicationDate", this.getTableName());
        this.PublicationDate.setDbType("nvarchar(10)");
        
        this.PublicationNum = new Field("PublicationNum", this.getTableName());
        this.PublicationNum.setDbType("nvarchar(50)");
        
        this.RegistDate = new Field("RegistDate", this.getTableName());
        this.RegistDate.setDbType("nvarchar(10)");
        
        this.RegistNum = new Field("RegistNum", this.getTableName());
        this.RegistNum.setDbType("nvarchar(50)");        
        
        this.TrademarkNum = new Field("TrademarkNum", this.getTableName());
        this.TrademarkNum.setDbType("nvarchar(50)");

        this.TrademarkNo = new Field("TrademarkNo", this.getTableName());
        this.TrademarkNo.setDbType("varchar(50)");
        
        this.ExpiryDate = new Field("ExpiryDate", this.getTableName());
        this.ExpiryDate.setDbType("nvarchar(10)");
        
        this.ExtendDate = new Field("ExtendDate", this.getTableName());
        this.ExtendDate.setDbType("nvarchar(10)");

        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");

        this.ClosedDate = new Field("ClosedDate", this.getTableName());
        this.ClosedDate.setDbType("nvarchar(10)");
        
        this.TrademarkImg = new Field("TrademarkImg", this.getTableName());
        this.TrademarkImg.setDbType("nvarchar(100)");
        
        this.Color = new Field("Color", this.getTableName());
        this.Color.setDbType("nvarchar(50)");
        
        this.NoBelongDesc = new Field("NoBelongDesc", this.getTableName());
        this.NoBelongDesc.setDbType("nvarchar(500)");
        
        this.ChtWordsinMark = new Field("ChtWordsinMark", this.getTableName());
        this.ChtWordsinMark.setDbType("nvarchar(500)");
        
        this.EngWordsinMark = new Field("EngWordsinMark", this.getTableName());
        this.EngWordsinMark.setDbType("nvarchar(500)");
        
        this.JapWordsinMark = new Field("JapWordsinMark", this.getTableName());
        this.JapWordsinMark.setDbType("nvarchar(500)");
        
        this.Significance = new Field("Significance", this.getTableName());
        this.Significance.setDbType("nvarchar(500)");
        
        this.GraphDesc = new Field("GraphDesc", this.getTableName());
        this.GraphDesc.setDbType("nvarchar(500)");
        
        this.DesignMark = new Field("DesignMark", this.getTableName());
        this.DesignMark.setDbType("nvarchar(100)");
        
        this.TabText = new Field("TabText", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

	public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.Office);
        this.DbFields.add(this.TrademarkType);
        this.DbFields.add(this.Title);
        this.DbFields.add(this.AttorneyDate);
        this.DbFields.add(this.AttorneyNum);
        this.DbFields.add(this.FillingDate);
        this.DbFields.add(this.FillingNum);
        this.DbFields.add(this.PublicationDate);
        this.DbFields.add(this.PublicationNum);
        this.DbFields.add(this.RegistDate);
        this.DbFields.add(this.RegistNum);
        this.DbFields.add(this.TrademarkNum);
        this.DbFields.add(this.TrademarkNo);
        this.DbFields.add(this.ExpiryDate);
        this.DbFields.add(this.ExtendDate);
        this.DbFields.add(this.Status);        
        this.DbFields.add(this.ClosedDate);
        this.DbFields.add(this.TrademarkImg);
        this.DbFields.add(this.Color);
        this.DbFields.add(this.NoBelongDesc);
        this.DbFields.add(this.ChtWordsinMark);
        this.DbFields.add(this.EngWordsinMark);
        this.DbFields.add(this.JapWordsinMark);
        this.DbFields.add(this.Significance);
        this.DbFields.add(this.GraphDesc);
        this.DbFields.add(this.DesignMark);
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
			String onChange = "doAjaxRequest(\"TrademarkCase\",\"dbActionMode\",\"dbActionMode\",\"bodyDiv\",\"innerHTML\")";
			SelectOneTag selectItem = new SelectOneTag(Cnstnts.DB_ACTION_MODE,
					onChange, this.getDbActionMode(), this.getDbActionList());

			rtnString = selectItem.toString();
		}
		return rtnString;
	}

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.TrademarkType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.TrademarkType.setSelectList(new Category().getChildList(this.TrademarkType));

            this.Office.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Office.setSelectList(new Category().getChildList("PatentOffice"));
            this.Office.setAnotherField(this.TrademarkType);
            rtnString += this.printHtml(this.Office);
            
        	this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("TrademarkStatus"));
            
        	this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Title.setSize(20);
        	this.Title.setAnotherField(this.Status);
            rtnString += this.printHtml(this.Title);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	this.TrademarkType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.TrademarkType.setSelectList(new Category().getChildList(this.TrademarkType));

            this.Office.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Office.setSelectList(new Category().getChildList("PatentOffice"));
            this.Office.setAnotherField(this.TrademarkType);
            rtnString += this.printHtml(this.Office);
            
            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Title.setCols(82);
            this.Title.setRows(2);
            rtnString += this.printHtml(this.Title);
            
            this.AttorneyNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.AttorneyDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.AttorneyDate.setAnotherField(this.AttorneyNum);
            this.AttorneyDate.setColspan(1);
            rtnString += this.printHtml(this.AttorneyDate);
            
            this.FillingNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.FillingDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.FillingDate.setAnotherField(this.FillingNum);
            this.FillingDate.setColspan(1);
            rtnString += this.printHtml(this.FillingDate);
            
            this.PublicationNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.PublicationDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.PublicationDate.setAnotherField(this.PublicationNum);
            this.PublicationDate.setColspan(1);
            rtnString += this.printHtml(this.PublicationDate);
            
            this.RegistNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.RegistDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.RegistDate.setAnotherField(this.RegistNum);
            this.RegistDate.setColspan(1);
            rtnString += this.printHtml(this.RegistDate);
            
            this.TrademarkNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.TrademarkNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TrademarkNum.setColspan(1);
            this.TrademarkNum.setAnotherField(this.TrademarkNo);
            rtnString += this.printHtml(this.TrademarkNum);
            
            this.ExtendDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.ExpiryDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ExpiryDate.setAnotherField(this.ExtendDate);
            this.ExpiryDate.setColspan(1);
            rtnString += this.printHtml(this.ExpiryDate);
            
            this.ClosedDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("TrademarkCaseStatus"));
            this.Status.setAnotherField(this.ClosedDate);
            this.Status.setColspan(1);
            rtnString += this.printHtml(this.Status);
                        
            if(this.TabText.getValue().trim().length()==0){
            	this.TabText.setValue("TrademarkSecondPage");
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
								"  doAjaxRequest('TrademarkCase','tabText','tabText','detailDiv','innerHTML')"+
								"}"+
								"</script>";
            	
            	rtnString += "<tr><td colspan=4>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.TrademarkCase.TrademarkSecondPage")+"' "+
            						   	"id='TrademarkSecondPage' onClick='resetFrame(\"TrademarkSecondPage\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.TrademarkCategory.title")+"' "+
            							"id='TrademarkCategory' onClick='resetFrame(\"TrademarkCategory\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.TrademarkApplicant.title")+"' "+
            							"id='TrademarkApplicant' onClick='resetFrame(\"TrademarkApplicant\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.TrademarkInventor.title")+"' "+
            							"id='TrademarkInventor' onClick='resetFrame(\"TrademarkInventor\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.TrademarkPriority.title")+"' "+
            							"id='TrademarkPriority' onClick='resetFrame(\"TrademarkPriority\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.TrademarkAttorney.title")+"' "+
            							"id='TrademarkAttorney' onClick='resetFrame(\"TrademarkAttorney\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.TrademarkDocument.title")+"' "+
            							"id='TrademarkDocument' onClick='resetFrame(\"TrademarkDocument\")'/>"+
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

        this.TrademarkType.setListWidth("10%");
        this.TrademarkType.setMapingPrpt(categoryPrpt);
        this.TrademarkType.setNotShowCode(true);
        
        this.Office.setListWidth("10%");
        this.Office.setMapingPrpt(categoryPrpt);
        this.Office.setNotShowCode(true);

        this.Status.setListWidth("10%");
        this.Status.setMapingPrpt(categoryPrpt);
        this.Status.setNotShowCode(true);
        
        this.AttorneyDate.setListWidth("10%");
        this.AttorneyDate.setAlign(Cnstnts.CENTER);
        
        this.ClosedDate.setListWidth("10%");
        this.ClosedDate.setAlign(Cnstnts.CENTER);

        Field[] showField = {this.FlowKey, this.TrademarkType, this.Office, this.Title, 
        					 this.AttorneyDate, this.ClosedDate, this.Status};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.Title);
        whereStr = Util.addWhereSQL(whereStr, this.TrademarkType);
        whereStr = Util.addWhereSQL(whereStr, this.Office);
        whereStr = Util.addWhereSQL(whereStr, this.Status);
        whereStr = this.getDataAuthorityWhereSQL(whereStr);
        String SQL = "select * from TrademarkCase "+whereStr;
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
        	TrademarkCase preObj = (TrademarkCase) userInfo.getObj(this.getTableName());
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
        if(this.getTabText().equals("TrademarkCategory")){
        	rtnString = new TrademarkCategory().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkApplicant")){
        	rtnString = new TrademarkApplicant().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkInventor")){
        	rtnString = new TrademarkInventor().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkAttorney")){
        	rtnString = new TrademarkAttorney().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkPriority")){
        	rtnString = new TrademarkPriority().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkDocument")){
        	rtnString = new TrademarkDocument().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkSecondPage")){
        	rtnString = "<table width='100%' " + this.getTableBgcolor() + ">";
        	
            this.TrademarkImg.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.TrademarkImg);
            
            rtnString += "<tr"+Cnstnts.DEFAULT_TR_BGCOLOR_1+"><td colspan='2'>" +
             			 "<table width='100%' " + this.getTableBgcolor() + ">";
            
            this.ChtWordsinMark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.ChtWordsinMark.setCols(40);
            rtnString += this.printHtml(this.ChtWordsinMark);
            
            this.EngWordsinMark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.EngWordsinMark.setCols(40);
            rtnString += this.printHtml(this.EngWordsinMark);
            	
        	this.JapWordsinMark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        	this.JapWordsinMark.setCols(40);
            rtnString += this.printHtml(this.JapWordsinMark);
            
            this.DesignMark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.DesignMark.setCols(40);
            rtnString += this.printHtml(this.DesignMark);
            
            rtnString += "</table></td><td colspan='2' align='center'>";
            if(this.TrademarkImg.getValue().trim().length()>0){
            	rtnString += "<img src='"+this.TrademarkImg.getValue()+"' width='300'>";
            }
            rtnString += "</td><tr>";
            
            this.GraphDesc.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.GraphDesc.setCols(40);
            
            this.Significance.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Significance.setCols(40);
            this.Significance.setAnotherField(this.GraphDesc);
            this.Significance.setColspan(1);
            rtnString += this.printHtml(this.Significance);
            
            this.Color.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Color.setCols(40);
            
            this.NoBelongDesc.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.NoBelongDesc.setCols(40);
            this.NoBelongDesc.setAnotherField(this.Color);
            this.NoBelongDesc.setColspan(1);
            rtnString += this.printHtml(this.NoBelongDesc);
            
            rtnString += "</table>";
        } else {
        	rtnString += this.TrademarkImg.printHiddenTag();
        	rtnString += this.Color.printHiddenTag();
        	rtnString += this.NoBelongDesc.printHiddenTag();
        	rtnString += this.ChtWordsinMark.printHiddenTag();
        	rtnString += this.EngWordsinMark.printHiddenTag();
        	rtnString += this.JapWordsinMark.printHiddenTag();
        	rtnString += this.Significance.printHiddenTag();
        	rtnString += this.GraphDesc.printHiddenTag();
        	rtnString += this.DesignMark.printHiddenTag();
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
		sqlList.add("delete from TrademarkCategory where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkApplicant where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkDocument where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkInventor where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkAttorney where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkPriority where ParentId='"+this.getFlowKey()+"'");
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