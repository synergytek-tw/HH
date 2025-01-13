package deepspot.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.util.Util;

public class MyFavor extends MasterBean {

	public Field Subject;

	public void setSubject(String Subject) {
		this.Subject.setValue(Subject);
	}

	public String getSubject() {
		return this.Subject.getValue();
	}

	public Field Description;

	public void setDescription(String Description) {
		this.Description.setValue(Description);
	}

	public String getDescription() {
		return this.Description.getValue();
	}

	public Field PageUrl;

	public void setPageUrl(String PageUrl) {
		this.PageUrl.setValue(PageUrl);
	}

	public String getPageUrl() {
		return this.PageUrl.getValue();
	}
	
	public Field NewWindow;

	public void setNewWindow(String NewWindow) {
		this.NewWindow.setValue(NewWindow);
	}

	public String getNewWindow() {
		return this.NewWindow.getValue();
	}

	public Field UseMyFile;

	public void setUseMyFile(String UseMyFile) {
		this.UseMyFile.setValue(UseMyFile);
	}

	public String getUseMyFile() {
		return this.UseMyFile.getValue();
	}
	
	public Field FileUrl;

	public void setFileUrl(String FileUrl) {
		this.FileUrl.setValue(FileUrl);
	}

	public String getFileUrl() {
		return this.FileUrl.getValue();
	}

	public Field DateFrom;

	public void setDateFrom(String DateFrom) {
		this.DateFrom.setValue(DateFrom);
	}

	public String getDateFrom() {
		return this.DateFrom.getValue();
	}

	public Field DateTo;

	public void setDateTo(String DateTo) {
		this.DateTo.setValue(DateTo);
	}

	public String getDateTo() {
		return this.DateTo.getValue();
	}

	public MyFavor() {
		this.init();
	}

	public MyFavor(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.MyFavor");
		this.setTableName("MyFavor");

		this.Subject = new Field("Subject", this.getTableName());
		this.Subject.setCheckEmpty(true);
		this.Subject.setSearchCondition(Cnstnts.LIKE);
		
		this.Description = new Field("Description", this.getTableName());
		
		this.PageUrl = new Field("PageUrl", this.getTableName());
		
		this.DateFrom = new Field("DateFrom", this.getTableName());
		this.DateFrom.setCheckEmpty(true);
		
		this.DateTo = new Field("DateTo", this.getTableName());
		this.DateTo.setCheckEmpty(true);
		
		this.NewWindow = new Field("NewWindow", this.getTableName());
		
		this.UseMyFile = new Field("UseMyFile", this.getTableName());
		
		this.FileUrl = new Field("FileUrl", this.getTableName());

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}

	public void setDbFields() {
		super.setDbFields();
		this.DbFields.add(this.Subject);
		this.DbFields.add(this.Description);
		this.DbFields.add(this.PageUrl);
		this.DbFields.add(this.DateFrom);
		this.DbFields.add(this.DateTo);
		this.DbFields.add(this.NewWindow);
		this.DbFields.add(this.UseMyFile);
		this.DbFields.add(this.FileUrl);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {			
			this.Subject.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Subject.setSize(50);
			rtnString += this.printHtml(this.Subject);

			this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.DateFrom.setAnotherField(this.DateTo);
			rtnString += this.printHtml(this.DateFrom);
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {
			this.Subject.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Subject.setSize(50);
			rtnString += this.printHtml(this.Subject);
			
			this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			rtnString += this.printHtml(this.Description);
			
			this.NewWindow.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			
			this.PageUrl.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.PageUrl.setSize(50);
			this.PageUrl.setAnotherField(this.NewWindow);
			rtnString += this.printHtml(this.PageUrl);

			if(this.UseMyFile.getValue().equals("Y")){
				this.FileUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
			} else {
				this.FileUrl.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
			}
			
			this.UseMyFile.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			this.UseMyFile.setOnClick("setValue()");
			this.UseMyFile.setAnotherField(this.FileUrl);
			rtnString += this.printHtml(this.UseMyFile);

			this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			
			this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.DateFrom.setAnotherField(this.DateTo);
			rtnString += this.printHtml(this.DateFrom);
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
		this.Subject.setListWidth("20%");
		this.DateFrom.setListWidth("20%");
		this.DateTo.setListWidth("20%");

		Field[] showField = { this.FlowKey, this.Applicant, 
				this.Subject, this.DateFrom, this.DateTo };
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Subject);
		whereStr = Util.addBetweenSQL(whereStr, this.DateFrom, this.DateTo);
		return this.doSearch(whereStr);
	}
	
	@SuppressWarnings("unchecked")
	public List<HashMap<String,String>> getPersonList(String applicant) {
		String SQL = "select * from " + this.getTableName()
				+ " where Applicant='" + applicant + "' "
				+ " and ('"+Util.getDate()+"' between DateFrom and DateTo)";
		this.setDbFields();
		List<List<Field>> fieldList = this.getDbUtil().getFieldsList(SQL, this.DbFields);
		
		List<HashMap<String,String>> rtnList = new ArrayList<HashMap<String,String>>();
		for(Iterator itr=fieldList.iterator();itr.hasNext();){
			List<Field> fields = (List<Field>) itr.next();
			HashMap<String,String> map = new HashMap<String,String>();
			for(Iterator fieldsItr=fields.iterator();fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				map.put(field.getName(), field.getValue());
			}
			rtnList.add(map);
		}
		return rtnList;
	}

	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Subject);
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			MyFavor preObj = (MyFavor) userInfo.getObj(this.getTableName());
			this.setSearchResult(preObj.getSearchResult());
		}
	}

	public boolean checkInsertError() throws Exception {
		if(super.checkInsertError()){
			return true;
		} else {
			if(this.UseMyFile.getValue().equals("Y")){
				if(this.FileUrl.getValue().trim().length()==0){
					this.setErrorMessage(this.getErrorMessage(this.FileUrl));
					return true;
				}
			} else {
				if(this.PageUrl.getValue().trim().length()==0){
					this.setErrorMessage(this.getErrorMessage(this.PageUrl));
					return true;
				}
			}
			return false;
		}
	}

	public boolean checkUpdateError() throws Exception {
		return this.checkInsertError();
	}

	public boolean checkSignError() throws Exception {
		/*
		 * if(this.getFlowStep()==1 && this.PageUrl.trim().length()==0){
		 * this.setErrorMessage(this.getUserInfo().getMsg("prg.MyFavor.PageUrl"));
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