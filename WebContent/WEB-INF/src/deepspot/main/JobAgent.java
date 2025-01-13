package deepspot.main;

import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.util.Util;

public class JobAgent extends MasterBean {

	public Field Agent;

	public void setAgent(String Agent) {
		this.Agent.setValue(Agent);
	}

	public String getAgent() {
		return this.Agent.getValue();
	}

	public Field Emp_id;

	public void setEmp_id(String Emp_id) {
		this.Emp_id.setValue(Emp_id);
	}

	public String getEmp_id() {
		return this.Emp_id.getValue();
	}

	public Field TimeFrom;

	public void setTimeFrom(String TimeFrom) {
		this.TimeFrom.setValue(TimeFrom);
	}

	public String getTimeFrom() {
		return this.TimeFrom.getValue();
	}

	public Field TimeTo;

	public void setTimeTo(String TimeTo) {
		this.TimeTo.setValue(TimeTo);
	}

	public String getTimeTo() {
		return this.TimeTo.getValue();
	}

	public JobAgent(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public JobAgent() {
		this.init();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.JobAgent");
		this.setTableName("JobAgent");

		this.Agent = new Field("Agent", this.getTableName());
		this.Agent.setCheckEmpty(true);
		
		this.Emp_id = new Field("Emp_id", this.getTableName());
		this.Emp_id.setCheckEmpty(true);
		
		this.TimeFrom = new Field("TimeFrom", this.getTableName());
		this.TimeFrom.setCheckEmpty(true);
		
		this.TimeTo = new Field("TimeTo", this.getTableName());
		this.TimeTo.setCheckEmpty(true);

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}

	public void setDbFields() {
		super.setDbFields();
		this.DbFields.add(this.Agent);
		this.DbFields.add(this.Emp_id);
		this.DbFields.add(this.TimeFrom);
		this.DbFields.add(this.TimeTo);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {			
			List<SelectItem> selectList = new Employee().getList();
			
			this.Agent.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Agent.setSelectList(selectList);

			this.Emp_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Emp_id.setSelectList(selectList);
			this.Emp_id.setColspan(1);
			this.Emp_id.setAnotherField(this.Agent);
			rtnString += this.printHtml(this.Emp_id);

			this.TimeTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME);

			this.TimeFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME);
			this.TimeFrom.setColspan(1);
			this.TimeFrom.setAnotherField(this.TimeTo);
			rtnString += this.printHtml(this.TimeFrom);
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {
			List<SelectItem> selectList = new Employee().getList();
			
			this.Agent.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Agent.setSelectList(selectList);

			this.Emp_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Emp_id.setSelectList(selectList);
			this.Emp_id.setColspan(1);
			this.Emp_id.setAnotherField(this.Agent);
			rtnString += this.printHtml(this.Emp_id);

			this.TimeTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME);

			this.TimeFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME);
			this.TimeFrom.setColspan(1);
			this.TimeFrom.setAnotherField(this.TimeTo);
			rtnString += this.printHtml(this.TimeFrom);
		}
		return rtnString;
	}

	public void setSearchListPrpts() {
		Properties empNamesPrpt=null;
		try {
			empNamesPrpt = new Employee().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.FlowKey.setListWidth("12%");
		this.Agent.setListWidth("22%");
		this.Agent.setMapingPrpt(empNamesPrpt);
		this.Emp_id.setListWidth("22%");
		this.Emp_id.setMapingPrpt(empNamesPrpt);
		this.TimeFrom.setListWidth("22%");
		this.TimeTo.setListWidth("22%");

		Field[] showField = { this.FlowKey, this.Emp_id, this.Agent,
								this.TimeFrom, this.TimeTo};
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Emp_id);
		whereStr = Util.addWhereSQL(whereStr, this.Agent);
		whereStr = Util.addBetweenSQL(whereStr, this.TimeFrom, this.TimeTo);
		return this.doSearch(whereStr);
	}

	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Emp_id);
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			JobAgent preObj = (JobAgent) userInfo.getObj(this.getTableName());
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
		 * if(this.getFlowStep()==1 && this.JobAgentType.trim().length()==0){
		 * this.setErrorMessage(this.getUserInfo().getMsg("prg.JobAgent.JobAgentType"));
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

	public String getAgent(String emp_id, String thisTime) {
		String SQL = "select * from " + this.getTableName()
				+ " where Emp_id='"+emp_id+"'"
				+ " and TimeFrom between '2000-01-01 00:00:00' and '"+thisTime+"'"
				+ " and TimeTo between '"+thisTime+"' and '2100-12-31 23:59:59'";
		String rtnString = this.getDbUtil().getFieldValue(SQL, this.Agent);
		if(rtnString.equals(Cnstnts.EMPTY_STRING)){
			rtnString = emp_id;
		}
		return rtnString;
	}

}