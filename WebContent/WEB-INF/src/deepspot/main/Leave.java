package deepspot.main;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.html.HiddenTag;
import deepspot.util.Util;

public class Leave extends MasterBean {

    public Leave(){this.init();}

    public Leave(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field DeptSigner1;
    public void setDeptSigner1(String DeptSigner1){this.DeptSigner1.setValue(DeptSigner1);}
    public String getDeptSigner1(){return this.DeptSigner1.getValue();}

    public Field DeptSigner2;
    public void setDeptSigner2(String DeptSigner2){this.DeptSigner2.setValue(DeptSigner2);}
    public String getDeptSigner2(){return this.DeptSigner2.getValue();}

    public Field Agent;
    public void setAgent(String Agent){this.Agent.setValue(Agent);}
    public String getAgent(){return this.Agent.getValue();}

    public Field ApplyTime;
    public void setApplyTime(String ApplyTime){this.ApplyTime.setValue(ApplyTime);}
    public String getApplyTime(){return this.ApplyTime.getValue();}

    public Field LeaveType;
    public void setLeaveType(String LeaveType){this.LeaveType.setValue(LeaveType);}
    public String getLeaveType(){return this.LeaveType.getValue();}

    public Field DateFrom;
    public void setDateFrom(String DateFrom){this.DateFrom.setValue(DateFrom);}
    public String getDateFrom(){return this.DateFrom.getValue();}

    public Field DateTo;
    public void setDateTo(String DateTo){this.DateTo.setValue(DateTo);}
    public String getDateTo(){return this.DateTo.getValue();}

    public Field LeaveDay;
    public void setLeaveDay(String LeaveDay){this.LeaveDay.setValue(LeaveDay);}
    public String getLeaveDay(){return this.LeaveDay.getValue();}

    public Field LeaveHour;
    public void setLeaveHour(String LeaveHour){this.LeaveHour.setValue(LeaveHour);}
    public String getLeaveHour(){return this.LeaveHour.getValue();}

    public Field Reason;
    public void setReason(String Reason){this.Reason.setValue(Reason);}
    public String getReason(){return this.Reason.getValue();}
    
    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.Leave");
        this.setTableName("Leave");

        this.DeptSigner1 = new Field("DeptSigner1", this.getTableName());

        this.DeptSigner2 = new Field("DeptSigner2", this.getTableName());

        this.Agent = new Field("Agent", this.getTableName());
        this.Agent.setCheckEmpty(true);

        this.ApplyTime = new Field("ApplyTime", this.getTableName());

        this.LeaveType = new Field("LeaveType", this.getTableName());
        this.LeaveType.setCheckEmpty(true);

        this.DateFrom = new Field("DateFrom", this.getTableName());
        this.DateFrom.setCheckEmpty(true);

        this.DateTo = new Field("DateTo", this.getTableName());
        this.DateTo.setCheckEmpty(true);

        this.LeaveDay = new Field("LeaveDay", this.getTableName());

        this.LeaveHour = new Field("LeaveHour", this.getTableName());

        this.Reason = new Field("Reason", this.getTableName());
        this.Reason.setCheckEmpty(true);
        
        this.Status = new Field("Status", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DeptSigner1.setDbType("varchar(50)");
        this.DbFields.add(this.DeptSigner1);

        this.DeptSigner2.setDbType("varchar(50)");
        this.DbFields.add(this.DeptSigner2);

        this.Agent.setDbType("varchar(50)");
        this.DbFields.add(this.Agent);

        this.ApplyTime.setDbType("varchar(20)");
        this.DbFields.add(this.ApplyTime);

        this.LeaveType.setDbType("varchar(50)");
        this.DbFields.add(this.LeaveType);

        this.DateFrom.setDbType("varchar(20)");
        this.DbFields.add(this.DateFrom);

        this.DateTo.setDbType("varchar(20)");
        this.DbFields.add(this.DateTo);

        this.LeaveDay.setDbType("int");
        this.DbFields.add(this.LeaveDay);

        this.LeaveHour.setDbType("int");
        this.DbFields.add(this.LeaveHour);

        this.Reason.setDbType("nvarchar(500)");
        this.DbFields.add(this.Reason);
    }
    
    public String printHiddenTags(){
  	  HashMap<String,String> hm = new HashMap<String,String>();
  	  hm.put("submitFlag",Cnstnts.EMPTY_STRING);
  	  hm.put("getDataFlag",Cnstnts.EMPTY_STRING);
  	  hm.put("clearFlag",Cnstnts.EMPTY_STRING);
  	  hm.put("deleteDetail",Cnstnts.EMPTY_STRING);
  	  hm.put("closeReject",Cnstnts.EMPTY_STRING);
  	  hm.put("doSearchFlag",Cnstnts.EMPTY_STRING);
  	  hm.put("backToSrcSigner",Cnstnts.EMPTY_STRING);
  	  hm.put("tagId",Cnstnts.EMPTY_STRING);
  	  hm.put("recordIndex",Cnstnts.EMPTY_STRING);
  	  hm.put("orderKey",this.getOrderKey());
  	  hm.put("currentRecord",String.valueOf(this.getCurrentRecord()));
  	  hm.put("pageRecords",String.valueOf(this.getPageRecords()));
  	  hm.put("orderSequence",this.getOrderSequence());
  	  hm.put("modeLockFlag",this.getModeLockFlag());
  	  hm.put("pageActionMode",this.getPageActionMode());
  	  hm.put("createDept",this.getCreateDept());
  	  return new HiddenTag().print(hm);
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.Status.setSelectList(new Category().getChildList(this.Status));
        	
        	this.LeaveType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.LeaveType.setSelectList(new Category().getChildList(this.LeaveType));
            this.LeaveType.setAnotherField(this.Status);
            rtnString += this.printHtml(this.LeaveType);
            
            this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME2);

            this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME1);
            this.DateFrom.setAnotherField(this.DateTo);
            rtnString += this.printHtml(this.DateFrom);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	if(this.canEdit()){
        		Department department= new Department(this.getUserInfo().getAttribute("dept_id"));
        		this.DeptSigner1.setValue(department.Signer_Emp_id.getValue());
        		if(department.CanApprove.getValue().equals("Y")){
        			this.DeptSigner2.setValue(department.Signer_Emp_id.getValue());
        		} else {
        			department= new Department(department.Parent_id.getValue());
        			this.DeptSigner2.setValue(department.Signer_Emp_id.getValue());
        		}
        		if(this.Agent.getValue().trim().length()==0){
        			this.Agent.setValue(new Employee(this.Applicant.getValue()).getAgent_Emp_id());
        		}
            	this.LeaveHour.setButtonValue(this.getUserInfo().getMsg("jsp.Leave.autoCompute"));
            	this.LeaveHour.setButtonClick("computeDayAndHour(\"dateFrom\",\"dateTo\",\"leaveDay\",\"leaveHour\",\"No\")");
            }
        	
        	this.Agent.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Agent.setSelectList(new Employee().getList());
        	
            this.Applicant.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Applicant.setMapingPrpt(new Employee().getNamesPrpts());
            this.Applicant.setAnotherField(this.Agent);
            rtnString += this.printHtml(this.Applicant);

            this.ApplyTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ApplyTime.setReadonly(true);

            this.LeaveType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.LeaveType.setSelectList(new Category().getChildList(this.LeaveType));
            this.LeaveType.setAnotherField(this.ApplyTime);
            rtnString += this.printHtml(this.LeaveType);
            
            this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME2);

            this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME1);
            this.DateFrom.setAnotherField(this.DateTo);
            rtnString += this.printHtml(this.DateFrom);
            
            this.LeaveHour.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.LeaveHour.setSize(1);

            this.LeaveDay.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.LeaveDay.setSize(1);
            this.LeaveDay.setAnotherField(this.LeaveHour);
            rtnString += this.printHtml(this.LeaveDay);

            this.Reason.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            rtnString += this.printHtml(this.Reason);

            rtnString += this.DeptSigner1.printHiddenTag();
            
            rtnString += this.DeptSigner2.printHiddenTag();
        }
        return rtnString;
    }

    public void setSearchListPrpts() {
        this.FlowKey.setListWidth("13%");

        this.Applicant.setListWidth("12%");
        try {
			this.Applicant.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

        this.LeaveType.setListWidth("10%");
        try {
			this.LeaveType.setMapingPrpt(new Category().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        this.Reason.setListWidth("25%");
        
        this.DateFrom.setListWidth("15%");
        this.DateFrom.setAlign(Cnstnts.CENTER);
        
        this.DateTo.setListWidth("15%");
        this.DateTo.setAlign(Cnstnts.CENTER);
        
        this.LeaveDay.setListWidth("5%");
        this.LeaveDay.setDbType(Cnstnts.INT);
        this.LeaveDay.setSubTotalFlag(true);
        
        this.LeaveHour.setListWidth("5%");
        this.LeaveHour.setDbType(Cnstnts.INT);
        this.LeaveHour.setSubTotalFlag(true);
        
        Field[] showField = {this.FlowKey, this.Applicant,this.LeaveType, this.Reason,
        					 this.DateFrom, this.DateTo, this.LeaveDay, this.LeaveHour};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        String dateFrom = "2000-01-01 00:00:00";
        String dateTo = "2100-12-31 23:59:59";
        if(this.DateFrom.getValue().trim().length()>0){
        	dateFrom = this.DateFrom.getValue();
        }
        if(this.DateTo.getValue().trim().length()>0){
        	dateTo = this.DateTo.getValue();
        }
        whereStr = "where ((DateFrom between '"+dateFrom+"' and '"+dateTo+"') or ("+
                   "DateTo between '"+dateFrom+"' and '"+dateTo+"'))";
        if(this.Status.getValue().trim().length()>0){
        	whereStr += " and FlowKey in(select FlowKey from Flow where Status='"+
        				this.Status.getValue()+"' and Form_tableName='Leave')";
        }
        whereStr = Util.addWhereSQL(whereStr, this.LeaveType);
        return this.doSearch(whereStr);
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Reason);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            Leave preObj = (Leave) userInfo.getObj(this.getTableName());
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
        	if(this.Agent.getValue().equals(this.Applicant.getValue())){
        		this.setErrorMessage(this.getErrorMessage(this.Agent));
        		return true;
        	}
        	if(Integer.parseInt(this.LeaveDay.getValue())==0 
        			&& Integer.parseInt(this.LeaveHour.getValue())==0){
        		this.setErrorMessage(this.getErrorMessage(this.LeaveDay));
        		return true;
        	}
        	this.ApplyTime.setValue(Util.getDateTime());
        	this.setAliasName(new Category(this.LeaveType.getValue()).getNames()+"-"+this.Reason.getValue());
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

}