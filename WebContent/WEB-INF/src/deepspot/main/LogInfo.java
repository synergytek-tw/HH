package deepspot.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.util.Util;

public class LogInfo extends MasterBean {

	public Field UpdateUserId;

	public void setUpdateUserId(String UpdateUserId) {
		this.UpdateUserId.setValue(UpdateUserId);
	}

	public String getUpdateUserId() {
		return this.UpdateUserId.getValue();
	}

	public Field CreateTable;

	public void setCreateTable(String CreateTable) {
		this.CreateTable.setValue(CreateTable);
	}

	public String getCreateTable() {
		return this.CreateTable.getValue();
	}
	
	public Field SrcFlowKey;

	public void setSrcFlowKey(String SrcFlowKey) {
		this.SrcFlowKey.setValue(SrcFlowKey);
	}

	public String getSrcFlowKey() {
		return this.SrcFlowKey.getValue();
	}

	public Field UpdateUserName;

	public void setUpdateUserName(String UpdateUserName) {
		this.UpdateUserName.setValue(UpdateUserName);
	}

	public String getUpdateUserName() {
		return this.UpdateUserName.getValue();
	}

	public Field UpdateTime;

	public void setUpdateTime(String UpdateTime) {
		this.UpdateTime.setValue(UpdateTime);
	}

	public String getUpdateTime() {
		return this.UpdateTime.getValue();
	}

	public Field Action;

	public void setAction(String Action) {
		this.Action.setValue(Action);
	}

	public String getAction() {
		return this.Action.getValue();
	}

	public Field ActionInfo;

	public void setActionInfo(String ActionInfo) {
		this.ActionInfo.setValue(ActionInfo);
	}

	public String getActionInfo() {
		return this.ActionInfo.getValue();
	}

	public LogInfo() {
		this.init();
	}

	public LogInfo(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.LogInfo");
		this.setTableName("LogInfo");

		this.CreateTable = new Field("CreateTable", this.getTableName());
		this.CreateTable.setCheckEmpty(true);
		
		this.SrcFlowKey = new Field("SrcFlowKey", this.getTableName());
		this.SrcFlowKey.setCheckEmpty(true);
		
		this.UpdateUserId = new Field("UpdateUserId", this.getTableName());
		this.UpdateUserId.setCheckEmpty(true);
		
		this.UpdateUserName = new Field("UpdateUserName", this.getTableName());
		this.UpdateUserName.setCheckEmpty(true);
		this.UpdateUserName.setSearchCondition(Cnstnts.LIKE);
		
		this.UpdateTime = new Field("UpdateTime", this.getTableName());
		this.UpdateTime.setCheckEmpty(true);
		
		this.Action = new Field("Action", this.getTableName());
		this.Action.setCheckEmpty(true);
		
		this.ActionInfo = new Field("ActionInfo", this.getTableName());
		this.ActionInfo.setCheckEmpty(true);

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}

	public void setDbFields() {
		super.setDbFields();
		this.DbFields.add(this.CreateTable);
		this.DbFields.add(this.SrcFlowKey);
		this.DbFields.add(this.UpdateUserId);
		this.DbFields.add(this.UpdateUserName);
		this.DbFields.add(this.UpdateTime);
		this.DbFields.add(this.Action);
		this.DbFields.add(this.ActionInfo);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {			
			this.SrcFlowKey.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.CreateTable.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.CreateTable.setAnotherField(this.SrcFlowKey);
			rtnString += this.printHtml(this.CreateTable);

			this.Action.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Action.setSelectList(new Category().getChildList(this.Action));
			rtnString += this.printHtml(this.Action);
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {
			this.SrcFlowKey.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.CreateTable.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.CreateTable.setAnotherField(this.SrcFlowKey);
			rtnString += this.printHtml(this.CreateTable);
			
			this.UpdateUserName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.UpdateUserId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.UpdateUserId.setSelectList(new Employee().getList());
			this.UpdateUserId.setAnotherField(this.UpdateUserName);
			rtnString += this.printHtml(this.UpdateUserId);

			this.UpdateTime.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME);
			
			this.Action.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Action.setSelectList(new Category().getChildList(this.Action));
			this.Action.setAnotherField(this.UpdateTime);
			rtnString += this.printHtml(this.Action);

			this.ActionInfo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			this.ActionInfo.setRows(6);
			this.ActionInfo.setCols(60);
			rtnString += this.printHtml(this.ActionInfo);
		}
		return rtnString;
	}

	public void setSearchListPrpts() {
		this.CreateTable.setListWidth("10%");
		this.SrcFlowKey.setListWidth("10%");
		this.UpdateUserId.setListWidth("10%");
		this.UpdateUserName.setListWidth("10%");
		this.UpdateTime.setListWidth("12%");
		this.Action.setListWidth("10%");
		this.ActionInfo.setListWidth("38%");

		Field[] showField = { this.CreateTable, this.SrcFlowKey, this.UpdateUserId, 
				this.UpdateUserName, this.UpdateTime, this.Action, this.ActionInfo };
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.CreateTable);
		whereStr = Util.addWhereSQL(whereStr, this.SrcFlowKey);
		whereStr = Util.addWhereSQL(whereStr, this.Action);
		return this.doSearch(whereStr);
	}

	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.SrcFlowKey);
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			LogInfo preObj = (LogInfo) userInfo.getObj(this.getTableName());
			this.setSearchResult(preObj.getSearchResult());
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

	public boolean checkSignError() throws Exception {
		/*
		 * if(this.getFlowStep()==1 && this.UpdateUserName.trim().length()==0){
		 * this.setErrorMessage(this.getUserInfo().getMsg("prg.LogInfo.UpdateUserName"));
		 * return true; }
		 */
		return false;
	}

	public void doApproveProcess() throws Exception {
		/*
		 * Flow f = new Flow(this.getFlowKey());
		 * if(Cnstnts.APPROVE.equals(f.getStatus())){
		 *  }
		 */
	}

	public void doCloseProcess() throws Exception {
		super.doCloseProcess();
	}

	public String onAjaxRequest(String dataValue, String tagMode) {
		String rtnString = "";
		return rtnString;
	}

	public String getLogInfoSQL(HashMap<?, ?> beforeMap, HashMap<?, ?> nowMap, 
		  						String language, String dbAction) throws Exception{
		String rtnString = Cnstnts.EMPTY_STRING;
		String logInfo = Cnstnts.EMPTY_STRING;
		if(Cnstnts.DELETE.equals(dbAction)){
			logInfo="["+Util.getMsg(language,"jsp.LogInfo.Delete")+"]";
			if(nowMap!=null && nowMap.size()>0){
				for(Iterator<?> itr=nowMap.keySet().iterator(); itr.hasNext();){
					String keyValue = (String)itr.next();
					logInfo += "["+Util.getMsg(language,"jsp."+(String)nowMap.get("TableName")+"."+
							keyValue)+": "+nowMap.get(keyValue)+"]";
				}
			}
		} else {
			if(beforeMap==null || beforeMap.size()==0){
				return rtnString;
			}
			for(Iterator<?> itr=beforeMap.keySet().iterator(); itr.hasNext();){
				String keyValue = (String)itr.next();
				if(!beforeMap.get(keyValue).equals(nowMap.get(keyValue))){
					logInfo += "["+Util.getMsg(language,"jsp."+(String)nowMap.get("TableName")+"."+keyValue)+":"+
						       beforeMap.get(keyValue)+"->"+nowMap.get(keyValue)+"]";
				}
			}
		}
		if(!logInfo.equals("")){
			String applicant = (String)nowMap.get("Applicant");
			if(applicant.trim().length()==0)
				applicant = (String)beforeMap.get("Applicant");
			this.setApplicant(applicant);
			this.setCreateTable((String)nowMap.get("TableName"));
			this.setSrcFlowKey((String)nowMap.get("FlowKey"));
			this.setUpdateUserId(applicant);
			this.setUpdateUserName(new Employee(applicant).Emp_name.getValue());
			this.setUpdateTime(Util.getDateTime());
			this.setAction(dbAction);
			this.setActionInfo(logInfo);
			this.setFlowKey(FlowEngin.getFlowKey(this.getProgramId()));
			this.setCreateDept(new Employee(applicant).getDept_id());
			
			this.setDbFields();
			rtnString = this.getDbUtil().getInsertSQL(this.getTableName(),this.getDbFields());
		}
		return rtnString;
	}
  
}