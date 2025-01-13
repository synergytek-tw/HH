package deepspot.main;

import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.util.Util;

public class Sponsor extends MasterBean {

	public Field Description;

	public void setDescription(String Description) {
		this.Description.setValue(Description);
	}

	public String getDescription() {
		return this.Description.getValue();
	}

	public Field Emp_id;

	public void setEmp_id(String Emp_id) {
		this.Emp_id.setValue(Emp_id);
	}

	public String getEmp_id() {
		return this.Emp_id.getValue();
	}

	public Field Memo;

	public void setMemo(String Memo) {
		this.Memo.setValue(Memo);
	}

	public String getMemo() {
		return this.Memo.getValue();
	}
	
	public Sponsor() {
		this.init();
	}

	public Sponsor(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.Sponsor");
		this.setTableName("Sponsor");

		this.Description = new Field("Description", this.getTableName());
		this.Description.setSearchCondition(Cnstnts.LIKE);
		this.Description.setCheckEmpty(true);
		
		this.Emp_id = new Field("Emp_id", this.getTableName());
		this.Emp_id.setCheckEmpty(true);
		
		this.Memo = new Field("Memo", this.getTableName());

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}

	public void setDbFields() {
		super.setDbFields();
		this.DbFields.add(this.Description);
		this.DbFields.add(this.Emp_id);
		this.DbFields.add(this.Memo);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {			
			this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			rtnString += this.printHtml(this.Description);

			this.Emp_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Emp_id.setSelectList(new Employee().getList());
			rtnString += this.printHtml(this.Emp_id);
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {
			this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			rtnString += this.printHtml(this.Description);

			this.Emp_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Emp_id.setSelectList(new Employee().getList());
			rtnString += this.printHtml(this.Emp_id);

			this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			rtnString += this.printHtml(this.Memo);
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
		
		this.FlowKey.setListWidth("20%");
		this.Description.setListWidth("20%");
		this.Emp_id.setListWidth("20%");
		this.Emp_id.setMapingPrpt(empNamesPrpt);
		this.Memo.setListWidth("40%");

		Field[] showField = {this.FlowKey,this.Emp_id,this.Description,this.Memo};
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Emp_id);
		whereStr = Util.addWhereSQL(whereStr, this.Description);
		return this.doSearch(whereStr);
	}

	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Emp_id);
	}
	
	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			Sponsor preObj = (Sponsor) userInfo.getObj(this.getTableName());
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
		 * if(this.getFlowStep()==1 && this.SponsorsType.trim().length()==0){
		 * this.setErrorMessage(this.getUserInfo().getMsg("prg.Sponsors.SponsorsType"));
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

}