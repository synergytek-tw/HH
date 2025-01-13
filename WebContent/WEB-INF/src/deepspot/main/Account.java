package deepspot.main;

import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.util.Util;

public class Account extends MasterBean {

	public Field Password;

	public void setPassword(String Password) {
		this.Password.setValue(Password);
	}

	public String getPassword() {
		return this.Password.getValue();
	}

	public Field Emp_id;

	public void setEmp_id(String Emp_id) {
		this.Emp_id.setValue(Emp_id);
	}

	public String getEmp_id() {
		return this.Emp_id.getValue();
	}

	public Field Language;

	public void setLanguage(String Language) {
		this.Language.setValue(Language);
	}

	public String getLanguage() {
		return this.Language.getValue();
	}
	
	public Field OpenMenu;

	public void setOpenMenu(String OpenMenu) {
		this.OpenMenu.setValue(OpenMenu);
	}

	public String getOpenMenu() {
		return this.OpenMenu.getValue();
	}

	public Field EffectDateFrom;

	public void setEffectDateFrom(String EffectDateFrom) {
		this.EffectDateFrom.setValue(EffectDateFrom);
	}

	public String getEffectDateFrom() {
		return this.EffectDateFrom.getValue();
	}

	public Field EffectDateTo;

	public void setEffectDateTo(String EffectDateTo) {
		this.EffectDateTo.setValue(EffectDateTo);
	}

	public String getEffectDateTo() {
		return this.EffectDateTo.getValue();
	}

	public Account() {
		this.init();
	}

	public Account(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.Account");
		this.setTableName("Account");

		this.Password = new Field("Password", this.getTableName());
		this.Password.setCheckEmpty(true);
		this.Emp_id = new Field("Emp_id", this.getTableName());
		this.Emp_id.setCheckEmpty(true);
		this.Language = new Field("Language", this.getTableName());
		this.Language.setCheckEmpty(true);
		this.OpenMenu = new Field("OpenMenu", this.getTableName());
		this.EffectDateFrom = new Field("EffectDateFrom", this.getTableName());
		this.EffectDateFrom.setCheckEmpty(true);
		this.EffectDateTo = new Field("EffectDateTo", this.getTableName());
		this.EffectDateTo.setCheckEmpty(true);
		
		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}

	public void setDbFields() {
		super.setDbFields();
		this.DbFields.add(this.Password);
		this.DbFields.add(this.Emp_id);
		this.DbFields.add(this.Language);
		this.DbFields.add(this.OpenMenu);
		this.DbFields.add(this.EffectDateFrom);
		this.DbFields.add(this.EffectDateTo);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {			
			this.Emp_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Emp_id.setSelectList(new Employee().getList());
			rtnString += this.printHtml(this.Emp_id);

			this.EffectDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME);
			this.EffectDateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_DATETIME);
			this.EffectDateFrom.setAnotherField(this.EffectDateTo);
			rtnString += this.printHtml(this.EffectDateFrom);
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {
			this.OpenMenu.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			
			this.Password.setHtmlType(Cnstnts.HTML_TAG_PASSWORD);
			this.Password.setColspan(1);
			this.Password.setAnotherField(this.OpenMenu);
			rtnString += this.printHtml(this.Password);
			
			this.Language.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Language.setSelectList(Util.getLanguages());

			this.Emp_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Emp_id.setSelectList(new Employee().getList());
			this.Emp_id.setColspan(1);
			this.Emp_id.setAnotherField(this.Language);
			rtnString += this.printHtml(this.Emp_id);

			this.EffectDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

			this.EffectDateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.EffectDateFrom.setColspan(1);
			this.EffectDateFrom.setAnotherField(this.EffectDateTo);
			rtnString += this.printHtml(this.EffectDateFrom);
		}
		return rtnString;
	}

	public void setSearchListPrpts() {
		this.FlowKey.setListWidth("20%");
		this.Emp_id.setListWidth("20%");
		try {
			this.Emp_id.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		this.Language.setListWidth("20%");
		this.EffectDateFrom.setListWidth("20%");
		this.EffectDateTo.setListWidth("20%");

		Field[] showField = { this.FlowKey, this.Emp_id, this.Language,
				this.EffectDateFrom, this.EffectDateTo};
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Emp_id);
		whereStr = Util.addBetweenSQL(whereStr, this.EffectDateFrom, this.EffectDateTo);
		return this.doSearch(whereStr);
	}

	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Emp_id);
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			Account preObj = (Account) userInfo.getObj(this.getTableName());
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
		 * if(this.getFlowStep()==1 && this.Language.trim().length()==0){
		 * this.setErrorMessage(this.getUserInfo().getMsg("prg.Account.Language"));
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