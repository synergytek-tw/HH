package deepspot.main;

import java.util.ArrayList;
import java.util.List;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.QueryBean;
import deepspot.html.Html;
import deepspot.util.Util;

public class ToDosQuery extends QueryBean{

	public ToDosQuery() throws Exception {this.init();}
	
	public Field Matter;
    public void setMatter(String Matter){this.Matter.setValue(Matter);}
    public String getMatter(){return this.Matter.getValue();}
    
    public Field AssignedTo;
    public void setAssignedTo(String AssignedTo){this.AssignedTo.setValue(AssignedTo);}
    public String getAssignedTo(){return this.AssignedTo.getValue();}
    
    public Field TaskDescription;
    public void setTaskDescription(String TaskDescription){this.TaskDescription.setValue(TaskDescription);}
    public String getTaskDescription(){return this.TaskDescription.getValue();}
	
	public Field LegalDueDate;
    public void setLegalDueDate(String LegalDueDate){this.LegalDueDate.setValue(LegalDueDate);}
    public String getLegalDueDate(){return this.LegalDueDate.getValue();}
    
    public Field LegalDueDateTo;
    public void setLegalDueDateTo(String LegalDueDateTo){this.LegalDueDateTo.setValue(LegalDueDateTo);}
    public String getLegalDueDateTo(){return this.LegalDueDateTo.getValue();}

    public Field AttorneyDueDate;
    public void setAttorneyDueDate(String AttorneyDueDate){this.AttorneyDueDate.setValue(AttorneyDueDate);}
    public String getAttorneyDueDate(){return this.AttorneyDueDate.getValue();}
    
    public Field AttorneyDueDateTo;
    public void setAttorneyDueDateTo(String AttorneyDueDateTo){this.AttorneyDueDateTo.setValue(AttorneyDueDateTo);}
    public String getAttorneyDueDateTo(){return this.AttorneyDueDateTo.getValue();}
    
    public Field InternalDueDate;
    public void setInternalDueDate(String InternalDueDate){this.InternalDueDate.setValue(InternalDueDate);}
    public String getInternalDueDate(){return this.InternalDueDate.getValue();}
    
    public Field InternalDueDateTo;
    public void setInternalDueDateTo(String InternalDueDateTo){this.InternalDueDateTo.setValue(InternalDueDateTo);}
    public String getInternalDueDateTo(){return this.InternalDueDateTo.getValue();}
    
    public Field Finished; 
    public void setFinished(String Finished){this.Finished.setValue(Finished);}
    public String getFinished(){return this.Finished.getValue();}
    
    public Field FinishedDate;
    public void setFinishedDate(String FinishedDate){this.FinishedDate.setValue(FinishedDate);}
    public String getFinishedDate(){return this.FinishedDate.getValue();}
    
    public Field FinishedDateTo;
    public void setFinishedDateTo(String FinishedDateTo){this.FinishedDateTo.setValue(FinishedDateTo);}
    public String getFinishedDateTo(){return this.FinishedDateTo.getValue();}
    
    public void init() throws Exception {
        super.init();
        
        this.setProgramId("jsp.ToDosQuery");
        
        this.Matter = new Field("Matter","ToDos");
        
        this.AssignedTo = new Field("AssignedTo","ToDos");
        
        this.TaskDescription = new Field("TaskDescription","ToDos");
        this.TaskDescription.setSearchCondition(Cnstnts.LIKE);
        
        this.LegalDueDate = new Field("LegalDueDate","ToDos");

        this.LegalDueDateTo = new Field("LegalDueDateTo","ToDos");
        
        this.AttorneyDueDate = new Field("AttorneyDueDate","ToDos");
        
        this.AttorneyDueDateTo = new Field("AttorneyDueDateTo","ToDos");
        
        this.InternalDueDate = new Field("InternalDueDate","ToDos");
        
        this.InternalDueDateTo = new Field("InternalDueDateTo","ToDos");
        
        this.FinishedDate = new Field("FinishedDate","ToDos");
        
        this.FinishedDateTo = new Field("FinishedDateTo","ToDos");
    }

    public String printMainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        
        this.AssignedTo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        
        this.Matter.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Matter.setAnotherField(this.AssignedTo);
        rtnString += this.printHtml(this.Matter);
        
        this.TaskDescription.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        rtnString += this.printHtml(this.TaskDescription);
        
        this.LegalDueDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        
        this.LegalDueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.LegalDueDate.setAnotherField(this.LegalDueDateTo);
        rtnString += this.printHtml(this.LegalDueDate);
        
        this.AttorneyDueDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        
        this.AttorneyDueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.AttorneyDueDate.setAnotherField(this.AttorneyDueDateTo);
        rtnString += this.printHtml(this.AttorneyDueDate);
        
        this.InternalDueDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        
        this.InternalDueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.InternalDueDate.setAnotherField(this.InternalDueDateTo);
        rtnString += this.printHtml(this.InternalDueDate);
        
        this.FinishedDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        
        this.FinishedDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.FinishedDate.setAnotherField(this.FinishedDateTo);
        rtnString += this.printHtml(this.FinishedDate);
        
        return rtnString;
    }
    
    public void doAction(UserBean userInfo) throws Exception{
    	this.setUserInfo(userInfo);
    	this.resetMessage();
  		if(this.onBtnSubmit()){
  			this.setRunFlag(true);
  		}
  	}
    
    public String printResultTable() throws Exception{
  		String rtnString = Cnstnts.EMPTY_STRING;
  		if(this.onBtnSubmit() && this.runFlag()){
  			String whereSQL = Cnstnts.EMPTY_STRING;
  			if(this.Matter.getValue().trim().length()>0){
  				whereSQL = "where Matter in(select FlowKey from Category where Names like '%"+
  							this.getMatter()+"%')";
  			}
  			if(this.AssignedTo.getValue().trim().length()>0){
  				if(whereSQL.trim().length()==0){
  					whereSQL = "where AssignedTo in(select FlowKey from Employee where Emp_name like '%"+
								this.getAssignedTo()+"%')";
  				} else {
  					whereSQL += " and AssignedTo in(select FlowKey from Employee where Emp_name like '%"+
					this.getAssignedTo()+"%')";
  				}
  			}
  			whereSQL = Util.addWhereSQL(whereSQL, this.TaskDescription);
  			whereSQL = Util.addBetweenSQL(whereSQL, this.AttorneyDueDate, this.AttorneyDueDateTo);
  			whereSQL = Util.addBetweenSQL(whereSQL, this.LegalDueDate, this.LegalDueDateTo);
  			whereSQL = Util.addBetweenSQL(whereSQL, this.InternalDueDate, this.InternalDueDateTo);
  			whereSQL = Util.addBetweenSQL(whereSQL, this.FinishedDate, this.FinishedDateTo);
  			
  			String SQL = "select 'ToDos' as LinkPage1, t.FlowKey as LinkFlowKey1, "+
  						 "cc.Names as Matter, t.TaskDescription, "+
  						 "e.Emp_name as AssignedTo, t.LegalDueDate, "+
  						 "t.InternalDueDate, t.FinishedDate, t.Appendix, "+
  						 "'PatentCase' as LinkPage2, p.Flowkey as LinkFlowKey2, "+
  						 "c.Names as PatentOffice "+
  						 "from ToDos t "+
  						 "inner join PatentCase p on t.ParentId=p.FlowKey "+
  						 "inner join Employee e on t.AssignedTo=e.FlowKey "+
  						 "inner join Category c on p.PatentOffice=c.FlowKey "+
  						 "inner join Category cc on t.Matter=cc.FlowKey "+whereSQL;
  			
  			List<Field> dataFields = new ArrayList<Field>();
  			Field LinkPage1 = new Field("LinkPage1","ToDos");
  	    	LinkPage1.setShowFlag(false);
  	    	dataFields.add(LinkPage1);
  	    	
  	    	Field LinkFlowKey1 = new Field("LinkFlowKey1","ToDos");
  	    	LinkFlowKey1.setShowFlag(false);
  	    	dataFields.add(LinkFlowKey1);
  	    	
  	    	Field LinkPage2 = new Field("LinkPage2","ToDos");
  	    	LinkPage2.setShowFlag(false);
  	    	dataFields.add(LinkPage2);
  	    	
  	    	Field LinkFlowKey2 = new Field("LinkFlowKey2","ToDos");
  	    	LinkFlowKey2.setAliasName(this.getUserInfo().getMsg("jsp.PatentCase.FlowKey"));
  	    	LinkFlowKey2.setLinkFlag2(true);
  	    	LinkFlowKey2.setLinkMode2(Cnstnts.OPEN_APPENDIX);
  	    	LinkFlowKey2.setLinkParameter2("&linkMode=openAppendix&modeLockFlag=true");
  	    	LinkFlowKey2.setDbActionMode2(Cnstnts.QUERY);
  	    	dataFields.add(LinkFlowKey2);
  	    	
  	    	Field PatentOffice = new Field("PatentOffice","PatentCase");
  	    	PatentOffice.setAlign(Cnstnts.CENTER);
  	    	dataFields.add(PatentOffice);
  	    	
  	    	this.Matter.setAlign(Cnstnts.CENTER);
  	    	dataFields.add(this.Matter);
  	    	
  	    	this.TaskDescription.setLinkFlag1(true);
  	    	this.TaskDescription.setLinkMode1(Cnstnts.OPEN_APPENDIX);
  	    	this.TaskDescription.setLinkParameter1("&linkMode=openAppendix&modeLockFlag=true");
  	    	this.TaskDescription.setDbActionMode1(Cnstnts.QUERY);
  	    	dataFields.add(this.TaskDescription);
  	    	
  	    	this.AssignedTo.setAlign(Cnstnts.CENTER);
  	    	dataFields.add(this.AssignedTo);
  	    	
  	    	this.LegalDueDate.setAlign(Cnstnts.CENTER);
  	    	dataFields.add(this.LegalDueDate);
  	    	
  	    	this.InternalDueDate.setAlign(Cnstnts.CENTER);
  	    	dataFields.add(this.InternalDueDate);
  	    	
  	    	Field Appendix = new Field("Appendix","ToDos");
  	    	Appendix.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
  	    	Appendix.setAlign(Cnstnts.CENTER);
  	    	dataFields.add(Appendix);
  	    	
  			rtnString += Html.printTable("jsp.ToDos.title", 
  						 this.getDbUtil().getFieldsList(SQL, dataFields), 
  						 this.getUserInfo());
  		}
		return rtnString;
    }

}