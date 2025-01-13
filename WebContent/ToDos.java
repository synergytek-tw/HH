package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.html.Html;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDos extends MultiDetail {

    public ToDos(){this.init();}

    public ToDos(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }
    public Field StartDate;
    public void setStartDate(String StartDate){this.StartDate.setValue(StartDate);}
    public String getStartDate(){return this.StartDate.getValue();}
    
    public Field TaskDescription;
    public void setTaskDescription(String TaskDescription){this.TaskDescription.setValue(TaskDescription);}
    public String getTaskDescription(){return this.TaskDescription.getValue();}

    public Field Matter;
    public void setMatter(String Matter){this.Matter.setValue(Matter);}
    public String getMatter(){return this.Matter.getValue();}

    public Field SrcModule;
    public void setSrcModule(String SrcModule){this.SrcModule.setValue(SrcModule);}
    public String getSrcModule(){return this.SrcModule.getValue();}

    public Field TaskCreator;
    public void setTaskCreator(String TaskCreator){this.TaskCreator.setValue(TaskCreator);}
    public String getTaskCreator(){return this.TaskCreator.getValue();}

    public Field TaskSponsor;
    public void setTaskSponsor(String TaskSponsor){this.TaskSponsor.setValue(TaskSponsor);}
    public String getTaskSponsor(){return this.TaskSponsor.getValue();}

    public Field AssignedTo;
    public void setAssignedTo(String AssignedTo){this.AssignedTo.setValue(AssignedTo);}
    public String getAssignedTo(){return this.AssignedTo.getValue();}

    public Field Attorney;
    public void setAttorney(String Attorney){this.Attorney.setValue(Attorney);}
    public String getAttorney(){return this.Attorney.getValue();}

    public Field InterestedParty;
    public void setInterestedParty(String InterestedParty){this.InterestedParty.setValue(InterestedParty);}
    public String getInterestedParty(){return this.InterestedParty.getValue();}

    public Field LegalDueDate;
    public void setLegalDueDate(String LegalDueDate){this.LegalDueDate.setValue(LegalDueDate);}
    public String getLegalDueDate(){return this.LegalDueDate.getValue();}

    public Field AttorneyDueDate;
    public void setAttorneyDueDate(String AttorneyDueDate){this.AttorneyDueDate.setValue(AttorneyDueDate);}
    public String getAttorneyDueDate(){return this.AttorneyDueDate.getValue();}

    public Field InternalDueDate;
    public void setInternalDueDate(String InternalDueDate){this.InternalDueDate.setValue(InternalDueDate);}
    public String getInternalDueDate(){return this.InternalDueDate.getValue();}

    public Field Alert;
    public void setAlert(String Alert){this.Alert.setValue(Alert);}
    public String getAlert(){return this.Alert.getValue();}

    public Field AlertDate;
    public void setAlertDate(String AlertDate){this.AlertDate.setValue(AlertDate);}
    public String getAlertDate(){return this.AlertDate.getValue();}

    public Field AlertBeforeDays;
    public void setAlertBeforeDays(String AlertBeforeDays){this.AlertBeforeDays.setValue(AlertBeforeDays);}
    public String getAlertBeforeDays(){return this.AlertBeforeDays.getValue();}

    public Field Finished;
    public void setFinished(String Finished){this.Finished.setValue(Finished);}
    public String getFinished(){return this.Finished.getValue();}

    public Field FinishedDate;
    public void setFinishedDate(String FinishedDate){this.FinishedDate.setValue(FinishedDate);}
    public String getFinishedDate(){return this.FinishedDate.getValue();}

    public Field Points;
    public void setPoints(String Points){this.Points.setValue(Points);}
    public String getPoints(){return this.Points.getValue();}

    public Field WorkingHours;
    public void setWorkingHours(String WorkingHours){this.WorkingHours.setValue(WorkingHours);}
    public String getWorkingHours(){return this.WorkingHours.getValue();}

    public Field Grade;
    public void setGrade(String Grade){this.Grade.setValue(Grade);}
    public String getGrade(){return this.Grade.getValue();}

    public Field Currency;
    public void setCurrency(String Currency){this.Currency.setValue(Currency);}
    public String getCurrency(){return this.Currency.getValue();}

    public Field PtoFee;
    public void setPtoFee(String PtoFee){this.PtoFee.setValue(PtoFee);}
    public String getPtoFee(){return this.PtoFee.getValue();}

    public Field ServiceFee;
    public void setServiceFee(String ServiceFee){this.ServiceFee.setValue(ServiceFee);}
    public String getServiceFee(){return this.ServiceFee.getValue();}

    public Field AttorneyFee;
    public void setAttorneyFee(String AttorneyFee){this.AttorneyFee.setValue(AttorneyFee);}
    public String getAttorneyFee(){return this.AttorneyFee.getValue();}

    public Field OtherFee;
    public void setOtherFee(String OtherFee){this.OtherFee.setValue(OtherFee);}
    public String getOtherFee(){return this.OtherFee.getValue();}

    public Field Memo;
    public void setMemo(String Memo){this.Memo.setValue(Memo);}
    public String getMemo(){return this.Memo.getValue();}

    public Field Appendix;
    public void setAppendix(String Appendix){this.Appendix.setValue(Appendix);}
    public String getAppendix(){return this.Appendix.getValue();}
    
    public Field LinkMode;
    public void setLinkMode(String LinkMode){this.LinkMode.setValue(LinkMode);}
    public String getLinkMode(){return this.LinkMode.getValue();}
    
    public Field IsCharge;
    public void setIsCharge(String IsCharge){this.IsCharge.setValue(IsCharge);}
    public String getIsCharge(){return this.IsCharge.getValue();}
    
    public Field IsRequestPay;
    public void setIsRequestPay(String IsRequestPay){this.IsRequestPay.setValue(IsRequestPay);}
    public String getIsRequestPay(){return this.IsRequestPay.getValue();}
    
    public Field ClientName;
    public void setClientName(String ClientName){this.ClientName.setValue(ClientName);}
    public String getClientName(){return this.ClientName.getValue();}
    
    
    
    final int FRAME_HEIGHT = 340;

    public void init() {
        super.init();
        this.setProgramId("jsp.ToDos");
        this.setTableName("ToDos");
        this.StartDate = new Field("StartDate",this.getTableName());
        this.StartDate.setDbType("varchar(20)");
        
        this.TaskDescription = new Field("TaskDescription", this.getTableName());
        this.TaskDescription.setDbType("nvarchar(200)");
        this.TaskDescription.setCheckEmpty(true);

        this.Matter = new Field("Matter", this.getTableName());
        this.Matter.setDbType("varchar(50)");
        this.Matter.setCheckEmpty(true);

        this.SrcModule = new Field("SrcModule", this.getTableName());
        this.SrcModule.setDbType("varchar(50)");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.TaskCreator = new Field("TaskCreator", this.getTableName());
        this.TaskCreator.setDbType("varchar(50)");

        this.TaskSponsor = new Field("TaskSponsor", this.getTableName());
        this.TaskSponsor.setDbType("varchar(50)");

        this.AssignedTo = new Field("AssignedTo", this.getTableName());
        this.AssignedTo.setDbType("varchar(50)");
        this.AssignedTo.setCheckEmpty(true);

        this.Attorney = new Field("Attorney", this.getTableName());
        this.Attorney.setDbType("varchar(50)");

        this.InterestedParty = new Field("InterestedParty", this.getTableName());
        this.InterestedParty.setDbType("varchar(200)");

        this.LegalDueDate = new Field("LegalDueDate", this.getTableName());
        this.LegalDueDate.setDbType("varchar(10)");

        this.AttorneyDueDate = new Field("AttorneyDueDate", this.getTableName());
        this.AttorneyDueDate.setDbType("varchar(10)");

        this.InternalDueDate = new Field("InternalDueDate", this.getTableName());
        this.InternalDueDate.setDbType("varchar(10)");

        this.Alert = new Field("Alert", this.getTableName());
        this.Alert.setDbType("char(1)");

        this.AlertDate = new Field("AlertDate", this.getTableName());
        this.AlertDate.setDbType("varchar(10)");

        this.AlertBeforeDays = new Field("AlertBeforeDays", this.getTableName());
        this.AlertBeforeDays.setDbType("int");

        this.Finished = new Field("Finished", this.getTableName());
        this.Finished.setDbType("char(1)");

        this.IsCharge = new Field("IsCharge",this.getTableName());
        this.IsCharge.setDbType("char(1)");
        
        this.IsRequestPay = new Field("IsRequestPay",this.getTableName());
        this.IsRequestPay.setDbType("char(1)");
        
        this.ClientName=new Field("ClientName",this.getTableName());
        this.ClientName.setDbType("varchar(50)");
        
        this.FinishedDate = new Field("FinishedDate", this.getTableName());
        this.FinishedDate.setDbType("varchar(10)");

        this.Points = new Field("Points", this.getTableName());
        this.Points.setDbType("int");

        this.WorkingHours = new Field("WorkingHours", this.getTableName());
        this.WorkingHours.setDbType("int");

        this.Grade = new Field("Grade", this.getTableName());
        this.Grade.setDbType("varchar(50)");

        this.Currency = new Field("Currency", this.getTableName());
        this.Currency.setDbType("varchar(50)");

        this.PtoFee = new Field("PtoFee", this.getTableName());
        this.PtoFee.setDbType("float");

        this.ServiceFee = new Field("ServiceFee", this.getTableName());
        this.ServiceFee.setDbType("float");

        this.AttorneyFee = new Field("AttorneyFee", this.getTableName());
        this.AttorneyFee.setDbType("float");

        this.OtherFee = new Field("OtherFee", this.getTableName());
        this.OtherFee.setDbType("float");

        this.Memo = new Field("Memo", this.getTableName());
        this.Memo.setDbType("nvarchar(200)");

        this.Appendix = new Field("Appendix", this.getTableName());
        this.Appendix.setDbType("varchar(100)");
        
        this.LinkMode = new Field("LinkMode", this.getTableName());

        
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        
        this.DbFields.add(this.StartDate);
        
        this.DbFields.add(this.TaskDescription);

        this.DbFields.add(this.Matter);

        this.DbFields.add(this.SrcModule);

        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.TaskCreator);

        this.DbFields.add(this.TaskSponsor);

        this.DbFields.add(this.AssignedTo);

        this.DbFields.add(this.Attorney);

        this.DbFields.add(this.InterestedParty);

        this.DbFields.add(this.LegalDueDate);

        this.DbFields.add(this.AttorneyDueDate);

        this.DbFields.add(this.InternalDueDate);

        this.DbFields.add(this.Alert);

        this.DbFields.add(this.AlertDate);

        this.DbFields.add(this.AlertBeforeDays);

        this.DbFields.add(this.Finished);

        this.DbFields.add(this.FinishedDate);
        
        this.DbFields.add(this.IsCharge);
        
        this.DbFields.add(this.IsRequestPay);
        
        this.DbFields.add(this.Points);

        this.DbFields.add(this.WorkingHours);

        this.DbFields.add(this.Grade);

        this.DbFields.add(this.Currency);

        this.DbFields.add(this.PtoFee);

        this.DbFields.add(this.ServiceFee);

        this.DbFields.add(this.AttorneyFee);

        this.DbFields.add(this.OtherFee);

        this.DbFields.add(this.Memo);

        this.DbFields.add(this.Appendix);
    }
    
    public String printFunctionBar() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		StringBuffer strBfr = new StringBuffer();
		strBfr.append(newLine + "<table id='functionBar' " + this.getTableBgcolor() + ">");
		strBfr.append(newLine + "<tr>");
		strBfr.append(newLine + "<td width='60%'>");
		strBfr.append(newLine + "<div class='logTitle'>");
		strBfr.append(newLine + this.getPageTitle());
		strBfr.append(newLine + "</div>");
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "<td align='right'>");
		if(!this.getDbActionMode().equals(Cnstnts.QUERY)){
			if(this.getLinkMode().trim().length()==0){
				String cancelBtn = "<input type='button' onClick='parent.closeTabFrame()' value='"+
				this.getUserInfo().getMsg("jsp.closeForm.cancel")+"'>";
				strBfr.append(cancelBtn);
			}	
			strBfr.append(Html.getDetailSubmitBtn(this.getUserInfo(), this.getDbActionMode()));
		}
		strBfr.append(this.getDbActionSelectItem());
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "</tr>");
		strBfr.append(newLine + "</table>");
		return strBfr.toString();
	}
    
    public boolean getCanEditField(Field field) {
		if (this.canEdit() || this.onSearchMode()) {
			if(this.getDbActionMode().equals(Cnstnts.INSERT) || this.onSearchMode()){
				return true;
			}
			if(this.TaskCreator.getValue().equals(this.getUserInfo().getAttribute("emp_id"))){
				return true;
			} else {
				if(this.AssignedTo.getValue().equals(this.getUserInfo().getAttribute("emp_id"))){
					if(field.getName().equals(this.Finished.getName())
							|| field.getName().equals(this.FinishedDate.getName())
								|| field.getName().equals(this.Memo.getName())
									|| field.getName().equals(this.Appendix.getName())){
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	rtnString += this.SrcModule.printHiddenTag();
        	rtnString += this.TaskCreator.printHiddenTag();
        	rtnString += this.TaskSponsor.printHiddenTag();
        	rtnString += this.Attorney.printHiddenTag();
        	rtnString += this.InterestedParty.printHiddenTag();
        	rtnString += this.LinkMode.printHiddenTag();
        	
        	this.AssignedTo.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.AssignedTo.setSelectList(new Employee().getList());

            this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Matter.setSelectList(new Category().getChildList(this.Matter));
            this.Matter.setAnotherField(this.AssignedTo);
            rtnString += this.printHtml(this.Matter);
        	
            this.TaskDescription.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.TaskDescription.setCols(82);
            this.TaskDescription.setRows(2);
            rtnString += this.printHtml(this.TaskDescription);
            
            this.LegalDueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            if(this.getDbActionMode().equals(Cnstnts.INSERT)){
            	String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            	this.StartDate.setValue(date);
            	
            }
            
            this.StartDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.StartDate.setAnotherField(this.LegalDueDate);
            rtnString += this.printHtml(this.StartDate);
            
            this.InternalDueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.AttorneyDueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.AttorneyDueDate.setAnotherField(this.InternalDueDate);
            rtnString += this.printHtml(this.AttorneyDueDate);
            
            
            
            this.AlertBeforeDays.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AlertBeforeDays.setSize(1);
            
            this.AlertDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.AlertDate.setAnotherField(this.AlertBeforeDays);

            this.Alert.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.Alert.setAnotherField(this.AlertDate);
            rtnString += this.printHtml(this.Alert);
            
            this.WorkingHours.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.WorkingHours.setSize(5);
            
            this.Grade.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Grade.setSize(5);
            this.Grade.setAnotherField(this.WorkingHours);

            
            //rtnString += this.printHtml(this.IsCharge);
            

            this.Currency.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Currency.setSelectList(new Category().getChildList(this.Currency));
            this.Currency.setSize(5);
            
            this.IsCharge.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.IsCharge.setAnotherField(this.Currency);
            
            
            this.IsRequestPay.setHtmlType(Cnstnts.HTML_TAG_DISABLE_CHECKBOX);
            this.IsRequestPay.setCanEdit(false);
            this.Currency.setAnotherField(this.IsRequestPay);
           
            rtnString += this.printHtml(this.IsCharge);
            
            
            this.Points.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Points.setSize(5);
            this.Points.setAnotherField(this.Grade);
            rtnString += this.printHtml(this.Points);
            
            
            
            this.OtherFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.OtherFee.setSize(5);
            
            this.AttorneyFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AttorneyFee.setSize(5);
            this.AttorneyFee.setAnotherField(this.OtherFee);
            
            this.ServiceFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ServiceFee.setSize(5);
            this.ServiceFee.setAnotherField(this.AttorneyFee);

            this.PtoFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.PtoFee.setSize(5);
            this.PtoFee.setAnotherField(this.ServiceFee);
            rtnString += this.printHtml(this.PtoFee);
            
            if(this.getDbActionMode().equals(Cnstnts.UPDATE) &&
            		this.getAssignedTo().equals(this.getUserInfo().getAttribute("emp_id"))){
            	rtnString += "<tr"+Cnstnts.DEFAULT_TR_BGCOLOR_1+"><td colspan=4 align=center>---------- "+
   			 				 this.getUserInfo().getMsg("jsp.ToDos.AssignedToCanEdit")+" ----------</td></tr>";
            }
            
            this.FinishedDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

            this.Finished.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.Finished.setAnotherField(this.FinishedDate);
            rtnString += this.printHtml(this.Finished);

            this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Memo.setCols(82);
            this.Memo.setRows(2);
            rtnString += this.printHtml(this.Memo);

            this.Appendix.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.Appendix);
            
            
            
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            ToDos preObj = (ToDos) userInfo.getObj(this.getTableName());
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
    
    protected String getSearchReasult(UserBean userInfo,String parentId) throws Exception {
    	this.setDoSearchFlag(Cnstnts.TRUE_FLAG);
		this.setPageActionMode(Cnstnts.SEARCH);
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasult();
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasult() throws Exception {
		if (this.onBtnSearch()) {
			this.setSearchResult(this.getSearchList());
		}

		StringBuffer strBfr = new StringBuffer();
		if (this.getShowField() == null || this.getShowField().length == 0
				|| this.getSearchResult() == null) {
			return strBfr.toString();
		}
		
		boolean canAssesFlag = false;
		PatentCase parentObj = (PatentCase)this.getUserInfo().getObj("PatentCase");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE) 
				&& parentObj.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.Matter")+"</td>";
		String thText7="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.StartDate")+"</td>";
		String thText11="<td align='center' width='5%'>"+this.getUserInfo().getMsg("jsp.ToDos.IsCharge")+"</td>";
		String thText3="<td align='center' width='25%'>"+this.getUserInfo().getMsg("jsp.ToDos.TaskDescription")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.AssignedTo")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.InternalDueDate")+"</td>";
		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.LegalDueDate")+"</td>";

		String thText10="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.FinishedDate")+"</td>";
		String thText8="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.Appendix")+"</td>";
		String thText9=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText9 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText7+thText11+thText3+
									thText4+thText5+thText6+thText10+thText8+thText9+"</tr>");
		
		String SQL = "select t.*, c.Names, e.Emp_name from ToDos t "+
					 "inner join Category c on t.Matter=c.FlowKey "+
					 "inner join Employee e on t.AssignedTo=e.FlowKey "+
					 "where t.ParentId='"+this.getParentId()+"'";
		ToDos task = new ToDos();
		task.setDbFields();
		List<Field> fieldList = task.getDbFields();
		fieldList.add(new Field("Names"));
		fieldList.add(new Field("Emp_name"));
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String Names = Cnstnts.EMPTY_STRING;
			String IsCharge= Cnstnts.EMPTY_STRING ;
			
			String TaskDescription = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String Emp_name = Cnstnts.EMPTY_STRING;
			String InternalDueDate = Cnstnts.EMPTY_STRING;
			String LegalDueDate = Cnstnts.EMPTY_STRING;
			String StartDate=Cnstnts.EMPTY_STRING;
			String FinishedDate = Cnstnts.EMPTY_STRING;
			String Appendix = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("Names")){
					Names = field.getValue();
				}
				if(field.getName().equals("IsCharge")){
					IsCharge = field.getValue();
				}
				if(field.getName().equals("TaskDescription")){
					TaskDescription = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Emp_name")){
					Emp_name = field.getValue();
				}
				if(field.getName().equals("InternalDueDate")){
					InternalDueDate = field.getValue();
				}
				if(field.getName().equals("LegalDueDate")){
					LegalDueDate = field.getValue();
				}
				if(field.getName().equals("StartDate")){
					StartDate=field.getValue();
				}
				if(field.getName().equals("FinishedDate")){
					FinishedDate = field.getValue();
				}
				if(field.getName().equals("Appendix")){
					Appendix = field.getValue();
					if(Appendix.trim().length()>0){
						Appendix = "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
								   "onClick='openAppendix(\""+Appendix+"\",\"Appendix\",800,600)'/>";
					}
				}
			}
			String onClick = " onClick='openAppendix(\"ToDos.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=query&getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,400)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'>"+Names+"</td>";
			String tdText10="<td align='center'>"+StartDate+"</td>";
			String tdText11="<td align='center'>"+IsCharge+"</td>";
			String tdText3="<td"+onClick+">"+TaskDescription+"</td>";
			String tdText4="<td align='center'>"+Emp_name+"</td>";
			String tdText5="<td align='center'>"+InternalDueDate+"</td>";
			String tdText6="<td align='center'>"+LegalDueDate+"</td>";
			
			String tdText7="<td align='center'>"+FinishedDate+"</td>";
			String tdText8="<td align='center'>"+Appendix+"</td>";
			String tdText9=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(getElementById(\"tabText\").value,\"update\",\""+
								 		FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(getElementById(\"tabText\").value,\"delete\",\""+
				 						FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
				tdText9 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText10+tdText11+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8+tdText9;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}

    public boolean checkInsertError() throws Exception {
        if(super.checkInsertError()){
            return true;
        } else {
        	if(this.getDbActionMode().equals(Cnstnts.UPDATE)
        			&& this.Finished.getValue().equals("Y")
        					&& this.FinishedDate.getValue().trim().length()==0){
        		this.setErrorMessage(this.getErrorMessage(this.FinishedDate));
        		return true;
        	}
        	if(this.getDbActionMode().equals(Cnstnts.INSERT)){
        		this.setTaskCreator(this.getUserInfo().getAttribute("emp_id"));
        	}
        	this.setApplicant(this.getTaskCreator());
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
    
    public boolean dbExecute() throws Exception {
		this.resetError();
		if (this.getUserInfo() == null) {
			this.setErrorMessage("no userInfo object");
			return false;
		}
		if (this.checkHasError()) {
			return false;
		} else {
			if (this.getApplicant().trim().length() == 0) {
				this.setApplicant(this.getUserInfo().getAttribute("emp_id"));
			}
			if (this.getCreateDept().trim().length() == 0) {
				this.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
			}
			if (Cnstnts.SIGN.equals(this.getDbActionMode())) {
				this.doSignProcess();
				this.doApproveProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.signForm.send"));
				this.setForwardPage("menu.jsp");
			} else if (Cnstnts.CLOSE.equals(this.getDbActionMode())) {
				this.doCloseProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.closeForm.closed"));
				this.setForwardPage("menu.jsp");
			} else if (Cnstnts.INSERT.equals(this.getDbActionMode())) {
				if (this.insert()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
									  this.FlowKey.getValue(), 
									  this.getProgramId(), 
									  this.getUserInfo().getAttribute("emp_id"), 
									  this.getApplicant(),
									  this.getTableName(), 
									  this.getAliasName());
					}
					this.doOtherInsertProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.insert"));
				} else {
					this.setErrorMessage(this.getTableName() + ".insert() error!!");
					return false;
				}
			} else if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
				if (this.update()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
								  	  this.FlowKey.getValue(), 
								  	  this.getProgramId(), 
								  	  this.getUserInfo().getAttribute("emp_id"), 
								  	  this.getApplicant(),
								  	  this.getTableName(), 
								  	  this.getAliasName());
					}
					this.doOtherUpdateProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.update"));
					if(this.LinkMode.getValue().equals(Cnstnts.HREF)){
						this.setForwardPage("menu.jsp");
					}
				} else {
					this.setErrorMessage(this.getTableName() + ".update() error!!");
					return false;
				}
			} else if (Cnstnts.DELETE.equals(this.getDbActionMode())) {
				if (this.delete()) {
					this.doOtherDeleteProcess();
					this.clearAttribute();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.delete"));
				} else {
					this.setErrorMessage(this.getTableName() + ".delete() error!!");
					return false;
				}
			}
			return true;
		}
	}
    
    public List<List<Field>> getNotFinishedList(String empId, UserBean userInfo) throws Exception{
    	String SQL = "select  'ToDos' as LinkPage1, t.FlowKey as LinkFlowKey1, "+
    						"cc.Names as Matter, t.TaskDescription,t.Alert, "+
    						"e.Emp_name as AssignedTo, t.LegalDueDate, "+
    						"t.InternalDueDate,t.AttorneyDueDate, t.FinishedDate, t.Appendix, "+
    						"'PatentCase' as LinkPage2, p.Flowkey as LinkFlowKey2, "+
    						"c.Names as PatentOffice,'' as AlertType,t.IsCharge, "+
    						"cl.CompanyName as ClientName " +
    				 "from ToDos t "+
    				 "left join PatentCase p on t.ParentId=p.FlowKey "+
    				 "left join Employee e on t.AssignedTo=e.FlowKey "+
    				 "left join Category c on p.PatentOffice=c.FlowKey "+
    				 "left join Category cc on t.Matter=cc.FlowKey "+
    				 "left join Client cl on p.Client=cl.FlowKey " +
    				 "where AssignedTo='"+empId+"' and Finished!='Y'";
    	List<Field> dataFields = new ArrayList<Field>();
    	
    	
    	
    	Field LinkPage1 = new Field("LinkPage1",this.getTableName());
    	LinkPage1.setShowFlag(false);
    	dataFields.add(LinkPage1);
    	
    	Field LinkFlowKey1 = new Field("LinkFlowKey1",this.getTableName());
    	LinkFlowKey1.setShowFlag(false);
    	dataFields.add(LinkFlowKey1);
    	
    	Field LinkPage2 = new Field("LinkPage2",this.getTableName());
    	LinkPage2.setShowFlag(false);
    	dataFields.add(LinkPage2);
    	
    	Field LinkFlowKey2 = new Field("LinkFlowKey2",this.getTableName());
    	LinkFlowKey2.setAliasName(userInfo.getMsg("jsp.PatentCase.FlowKey"));
    	LinkFlowKey2.setLinkFlag2(true);
    	LinkFlowKey2.setLinkMode2(Cnstnts.OPEN_APPENDIX);
    	LinkFlowKey2.setLinkParameter2("&linkMode=openAppendix&modeLockFlag=true");
    	LinkFlowKey2.setDbActionMode2(Cnstnts.QUERY);
    	//LinkFlowKey2.setListWidth("14%");
    	dataFields.add(LinkFlowKey2);
    	
    	Field PatentOffice = new Field("PatentOffice","PatentCase");
    	PatentOffice.setAlign(Cnstnts.CENTER);
    	//PatentOffice.setListWidth("10%");
    	dataFields.add(PatentOffice);
    	
    	//this.Matter.setAlign(Cnstnts.CENTER);
    	//this.Matter.setListWidth("8%");
    	//dataFields.add(this.Matter);
    	
    	this.Alert.setAlign(Cnstnts.CENTER);
    	dataFields.add(this.Alert);
    	
    	this.ClientName.setAlign(Cnstnts.LEFT);
    	dataFields.add(this.ClientName);
    	//this.IsCharge.setAlign(Cnstnts.CENTER);
    	//dataFields.add(this.IsCharge);
    	
    	this.TaskDescription.setLinkFlag1(true);
    	this.TaskDescription.setLinkMode1(Cnstnts.HREF);
    	this.TaskDescription.setLinkParameter1("&linkMode=href");
    	this.TaskDescription.setDbActionMode1(Cnstnts.UPDATE);
    	//this.TaskDescription.setListWidth("36%");
    	dataFields.add(this.TaskDescription);
    	
    	this.AssignedTo.setAlign(Cnstnts.CENTER);
    	//this.AssignedTo.setListWidth("8%");
    	dataFields.add(this.AssignedTo);
    	
    	this.LegalDueDate.setAlign(Cnstnts.CENTER);
    	//this.LegalDueDate.setListWidth("12%");
    	dataFields.add(this.LegalDueDate);
    	
    	this.AttorneyDueDate.setShowFlag(false);
    	dataFields.add(this.AttorneyDueDate);
    	
    	this.InternalDueDate.setAlign(Cnstnts.CENTER);
    	//this.InternalDueDate.setListWidth("12%");
    	dataFields.add(this.InternalDueDate);
    	
    	this.Appendix.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
    	this.Appendix.setAlign(Cnstnts.CENTER);
    	//this.Appendix.setListWidth("5%");
    	dataFields.add(this.Appendix);
    	
    	Field AlertType = new Field("AlertType",this.getTableName());
    	AlertType.setHtmlType(Cnstnts.HTML_TAG_IMG);
    	AlertType.setAlign(Cnstnts.CENTER);
    	dataFields.add(AlertType);
    	
    	return this.getDbUtil().getFieldsList(SQL, dataFields);
    }
    protected String getSearchReasultInternal(UserBean userInfo,String parentId) throws Exception {
    	this.setDoSearchFlag(Cnstnts.TRUE_FLAG);
		this.setPageActionMode(Cnstnts.SEARCH);
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasultInternal();
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasultInternal() throws Exception {
		if (this.onBtnSearch()) {
			this.setSearchResult(this.getSearchList());
		}

		StringBuffer strBfr = new StringBuffer();
		if (this.getShowField() == null || this.getShowField().length == 0
				|| this.getSearchResult() == null) {
			return strBfr.toString();
		}
		
		boolean canAssesFlag = false;
		PatentCaseInternal parentObj = (PatentCaseInternal)this.getUserInfo().getObj("PatentCaseInternal");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE) 
				&& parentObj.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.Matter")+"</td>";
		String thText7="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.StartDate")+"</td>";
		String thText11="<td align='center' width='5%'>"+this.getUserInfo().getMsg("jsp.ToDos.IsCharge")+"</td>";
		String thText3="<td align='center' width='25%'>"+this.getUserInfo().getMsg("jsp.ToDos.TaskDescription")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.AssignedTo")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.InternalDueDate")+"</td>";
		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.LegalDueDate")+"</td>";

		String thText10="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.FinishedDate")+"</td>";
		String thText8="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.Appendix")+"</td>";
		String thText9=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText9 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText7+thText11+thText3+
									thText4+thText5+thText6+thText10+thText8+thText9+"</tr>");
		
		String SQL = "select t.*, c.Names, e.Emp_name from ToDos t "+
					 "inner join Category c on t.Matter=c.FlowKey "+
					 "inner join Employee e on t.AssignedTo=e.FlowKey "+
					 "where t.ParentId='"+this.getParentId()+"'";
		ToDos task = new ToDos();
		task.setDbFields();
		List<Field> fieldList = task.getDbFields();
		fieldList.add(new Field("Names"));
		fieldList.add(new Field("Emp_name"));
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String Names = Cnstnts.EMPTY_STRING;
			String IsCharge= Cnstnts.EMPTY_STRING ;
			
			String TaskDescription = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String Emp_name = Cnstnts.EMPTY_STRING;
			String InternalDueDate = Cnstnts.EMPTY_STRING;
			String LegalDueDate = Cnstnts.EMPTY_STRING;
			String StartDate=Cnstnts.EMPTY_STRING;
			String FinishedDate = Cnstnts.EMPTY_STRING;
			String Appendix = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("Names")){
					Names = field.getValue();
				}
				if(field.getName().equals("IsCharge")){
					IsCharge = field.getValue();
				}
				if(field.getName().equals("TaskDescription")){
					TaskDescription = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Emp_name")){
					Emp_name = field.getValue();
				}
				if(field.getName().equals("InternalDueDate")){
					InternalDueDate = field.getValue();
				}
				if(field.getName().equals("LegalDueDate")){
					LegalDueDate = field.getValue();
				}
				if(field.getName().equals("StartDate")){
					StartDate=field.getValue();
				}
				if(field.getName().equals("FinishedDate")){
					FinishedDate = field.getValue();
				}
				if(field.getName().equals("Appendix")){
					Appendix = field.getValue();
					if(Appendix.trim().length()>0){
						Appendix = "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
								   "onClick='openAppendix(\""+Appendix+"\",\"Appendix\",800,600)'/>";
					}
				}
			}
			String onClick = " onClick='openAppendix(\"ToDos.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=query&getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,400)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'>"+Names+"</td>";
			String tdText10="<td align='center'>"+StartDate+"</td>";
			String tdText11="<td align='center'>"+IsCharge+"</td>";
			String tdText3="<td"+onClick+">"+TaskDescription+"</td>";
			String tdText4="<td align='center'>"+Emp_name+"</td>";
			String tdText5="<td align='center'>"+InternalDueDate+"</td>";
			String tdText6="<td align='center'>"+LegalDueDate+"</td>";
			
			String tdText7="<td align='center'>"+FinishedDate+"</td>";
			String tdText8="<td align='center'>"+Appendix+"</td>";
			String tdText9=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(getElementById(\"tabText\").value,\"update\",\""+
								 		FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(getElementById(\"tabText\").value,\"delete\",\""+
				 						FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
				tdText9 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText10+tdText11+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8+tdText9;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
}