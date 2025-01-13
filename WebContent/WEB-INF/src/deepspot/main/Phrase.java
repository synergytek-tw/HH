package deepspot.main;

import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.util.Util;

public class Phrase extends MasterBean {

	public Field Description;

	public void setDescription(String Description) {
		this.Description.setValue(Description);
	}

	public String getDescription() {
		return this.Description.getValue();
	}

	public Phrase() {
		this.init();
	}

	public Phrase(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.Phrase");
		this.setTableName("Phrase");

		this.Description = new Field("Description", this.getTableName());
		this.Description.setCheckEmpty(true);
		this.Description.setSearchCondition(Cnstnts.LIKE);

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}

	public void setDbFields() {
		super.setDbFields();
		this.DbFields.add(this.Description);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {			
			this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			rtnString += this.printHtml(this.Description);
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {

			this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Description.setSize(50);
			rtnString += this.printHtml(this.Description);
		}
		return rtnString;
	}

	public void setSearchListPrpts() {
		this.FlowKey.setListWidth("20%");
		this.Applicant.setListWidth("20%");
		try {
			this.Applicant.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		this.Description.setListWidth("60%");

		Field[] showField = { this.FlowKey, this.Applicant, this.Description };
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Description);
		return this.doSearch(whereStr);
	}

	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Description);
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			Phrase preObj = (Phrase) userInfo.getObj(this.getTableName());
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
	
	public List<SelectItem> getList(String applicant) throws Exception {
		String SQL = "select * from " + this.getTableName()
					 + " where Applicant='" + applicant + "'";
		return this.getDbUtil().getSelectItemList(SQL, this.FlowKey, this.Description);
	}

}