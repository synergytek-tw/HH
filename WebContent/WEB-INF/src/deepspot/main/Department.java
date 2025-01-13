package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.Html;
import deepspot.util.Util;

public class Department extends MasterBean {

	public Field Dept_name;
	public void setDept_name(String Dept_name) {
		this.Dept_name.setValue(Dept_name);
	}
	public String getDept_name() {
		return this.Dept_name.getValue();
	}

	public Field Parent_id;
	public void setParent_id(String Parent_id) {
		this.Parent_id.setValue(Parent_id);
	}
	public String getParent_id() {
		return this.Parent_id.getValue();
	}

	public Field Signer_Emp_id;
	public void setSigner_Emp_id(String Signer_Emp_id) {
		this.Signer_Emp_id.setValue(Signer_Emp_id);
	}
	public String getSigner_Emp_id() {
		return this.Signer_Emp_id.getValue();
	}

	public Field Dept_code;
	public void setDept_code(String Dept_code) {
		this.Dept_code.setValue(Dept_code);
	}
	public String getDept_code() {
		return this.Dept_code.getValue();
	}

	public Field CanApprove;
	public void setCanApprove(String CanApprove) {
		this.CanApprove.setValue(CanApprove);
	}
	public String getCanApprove() {
		return this.CanApprove.getValue();
	}

	public Field SubjectControler;
	public void setSubjectControler(String SubjectControler) {
		this.SubjectControler.setValue(SubjectControler);
	}
	public String getSubjectControler() {
		return this.SubjectControler.getValue();
	}
	
	public Field PatentEngineer;
	public void setPatentEngineer(String PatentEngineer) {
		this.PatentEngineer.setValue(PatentEngineer);
	}
	public String getPatentEngineer() {
		return this.PatentEngineer.getValue();
	}

	public Field SubDeptFlag;
	public void setSubDeptFlag(String SubDeptFlag) {
		this.SubDeptFlag.setValue(SubDeptFlag);
	}
	public String getSubDeptFlag() {
		return this.SubDeptFlag.getValue();
	}
	
	public Field CompanyFlag;
	public void setCompanyFlag(String CompanyFlag) {
		this.CompanyFlag.setValue(CompanyFlag);
	}
	public String getCompanyFlag() {
		return this.CompanyFlag.getValue();
	}
	
	public boolean isCompany(){
		if(this.CompanyFlag.getValue().equals("Y")){
			return true;
		} else {
			return false;
		}
	}

	public Department() {
		this.init();
	}

	public Department(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.Department");
		this.setTableName("Department");

		this.Dept_name = new Field("Dept_name", this.getTableName());
		this.Dept_name.setCheckEmpty(true);
		
		this.Parent_id = new Field("Parent_id", this.getTableName());
		
		this.Signer_Emp_id = new Field("Signer_Emp_id", this.getTableName());
		
		this.Dept_code = new Field("Dept_code", this.getTableName());
		
		this.CanApprove = new Field("CanApprove", this.getTableName());
		
		this.SubjectControler = new Field("SubjectControler", this.getTableName());
		
		this.PatentEngineer = new Field("PatentEngineer", this.getTableName());
		
		this.SubDeptFlag = new Field("SubDeptFlag", this.getTableName());
		
		this.CompanyFlag = new Field("CompanyFlag", this.getTableName());

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}

	public void setDbFields() {
		super.setDbFields();
		this.DbFields.add(this.Dept_name);
		this.DbFields.add(this.Parent_id);
		this.DbFields.add(this.Signer_Emp_id);
		this.DbFields.add(this.Dept_code);
		this.DbFields.add(this.CanApprove);
		this.DbFields.add(this.SubjectControler);
		this.DbFields.add(this.PatentEngineer);
		this.DbFields.add(this.SubDeptFlag);
		this.DbFields.add(this.CompanyFlag);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {			
			this.Parent_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Parent_id.setSelectList(this.getMenuList());
			rtnString += this.printHtml(this.Parent_id);
		}
		return rtnString;
	}
	
	public String printFlowKey() throws Exception {
		if (this.getDbActionMode().equals(Cnstnts.INSERT)) {
			this.FlowKey.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.FlowKey.setCheckEmpty(true);
		} else {
			this.FlowKey.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.FlowKey.setSelectList(this.getRootTreeList());
			this.FlowKey.setOnChange("document.input.getDataFlag.value=\"true\";setValue()");
		}
		if(this.getUserInfo().programCanInsert("jsp.Employee")
				&& this.getFlowKey().trim().length()>0){
			this.FlowKey.setAfterText("<input type='button' " +
				"value='"+this.getUserInfo().getMsg("jsp.Department.insertEmployee")+"'" +
				"onClick='openAppendix(\"Employee.jsp" +
				"?modeLockFlag=true&pageActionMode=maintain" +
				"&openerSetValue=true&dbActionMode=insert" +
				"&dept_id="+this.getFlowKey()+"\",\"Employee\",800,600)'/>");
		}
		return this.printHtml(this.FlowKey);
	}
	
	public boolean getCanEditField(Field field) {
		if(field.getName().equals(this.FlowKey.getName())){
			return true;
		}
		if (this.canEdit() || this.onSearchMode()) {
			return true;
		} else {
			return false;
		}
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {
			
			this.SubDeptFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			
			this.Dept_name.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Dept_name.setSize(40);
			this.Dept_name.setColspan(1);
			this.Dept_name.setAnotherField(this.SubDeptFlag);
			rtnString += this.printHtml(this.Dept_name);
			
			this.Dept_code.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.Parent_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Parent_id.setColspan(1);
			this.Parent_id.setSelectList(this.getMenuList());
			this.Parent_id.setAnotherField(this.Dept_code);
			rtnString += this.printHtml(this.Parent_id);
			
			this.CanApprove.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			
			this.Signer_Emp_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Signer_Emp_id.setColspan(1);
			this.Signer_Emp_id.setSelectList(new Employee().getGroupsList("G03"));
			this.Signer_Emp_id.setAnotherField(this.CanApprove);
			rtnString += this.printHtml(this.Signer_Emp_id);
			
			this.CompanyFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			
			this.SubjectControler.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.SubjectControler.setSelectList(new Employee().getList());
			this.SubjectControler.setAnotherField(this.CompanyFlag);
			this.SubjectControler.setColspan(1);
			rtnString += this.printHtml(this.SubjectControler);
			
			this.PatentEngineer.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.PatentEngineer.setSelectList(new Employee().getGroupsList("G01"));
			rtnString += this.printHtml(this.PatentEngineer);
			
			if(this.getFlowKey().trim().length()>0){
				rtnString += "<tr><td colspan=4>"+
					Html.printTable("jsp.Employee.title",new Employee().getRelationList(
							this.getFlowKey(), this.getUserInfo()), this.getUserInfo())+"</td></tr>";
			}

		}
		return rtnString;
	}

	public void setSearchListPrpts() {
		this.FlowKey.setListWidth("20%");
		this.Dept_name.setListWidth("20%");
		this.Signer_Emp_id.setListWidth("20%");
		try {
			this.Signer_Emp_id.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.Dept_code.setListWidth("20%");
		this.Parent_id.setListWidth("20%");
		try {
			this.Parent_id.setMapingPrpt(this.getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Field[] showField = { this.FlowKey, this.Dept_name, this.Signer_Emp_id,
				this.Dept_code, this.Parent_id };
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Parent_id);
		return this.doSearch(whereStr);
	}

	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Dept_name);
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			Department preObj = (Department) userInfo.getObj(this.getTableName());
			this.setSearchResult(preObj.getSearchResult());
		}
	}

	public boolean checkInsertError() throws Exception {
		if(super.checkInsertError()){
			return true;
		} else {
			if(this.FlowKey.getValue().equals(this.Parent_id.getValue())){
				this.setErrorMessage(this.getErrorMessage(this.Parent_id));
				return true;
			}
			if(this.getDbActionMode().equals(Cnstnts.INSERT)){
				this.setApplicant(this.getUserInfo().getAttribute("emp_id"));
				this.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
			}
			return false;
		}
	}

	public boolean checkUpdateError() throws Exception {
		return this.checkInsertError();
	}

	public boolean checkSignError() throws Exception {
		/*
		 * if(this.getFlowStep()==1 && this.Signer_Emp_id.trim().length()==0){
		 * this.setErrorMessage(this.getUserInfo().getMsg("prg.Department.Signer_Emp_id"));
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
	
	public List<SelectItem> getRootTreeList(){
		SelectItem item = new SelectItem(Cnstnts.EMPTY_STRING,Cnstnts.EMPTY_STRING);
		item.setParentKey(Cnstnts.EMPTY_STRING);
		item.setChildFlag(true);
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		rtnList = this.getTreeList(item);
		return rtnList;
	}
	
	public List<SelectItem> getMenuList(){
		SelectItem item = new SelectItem(Cnstnts.EMPTY_STRING,Cnstnts.EMPTY_STRING);
		item.setParentKey(Cnstnts.EMPTY_STRING);
		item.setOnlyMenuFlag(true);
		item.setChildFlag(true);
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		rtnList = this.getTreeList(item);
		return rtnList;
	}

	public List<SelectItem> getTreeList(SelectItem item) {
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(item.getKey().trim().length()>0){
			item.setLayer(1);
			rtnList.add(item);
		}
		if(!item.hasChild()){
			return rtnList;
		}
		rtnList = this.walkTree(item, rtnList);
		return rtnList;
	}
	
	private List<SelectItem> walkTree(SelectItem item, List<SelectItem> itemList){
		if(!item.hasChild()){
			return itemList;
		}
		for(Iterator<?> itr=this.getChildList(item).iterator();itr.hasNext();){
			SelectItem childItem = (SelectItem)itr.next();
			if(item.onlyMenu()){
				if(childItem.hasChild()){
					itemList.add(childItem);
				}
			} else {
				itemList.add(childItem);
			}
			if(childItem.hasChild()){
				this.walkTree(childItem, itemList);
			}
		}
		return itemList;
	}
	
	public String getCompanyId(String deptId) throws Exception{
		String SQL = "select * from Department where CompanyFlag='Y'";
		Properties companyPrpt = this.getDbUtil().getFieldPrpts(SQL, "CompanyFlag");
		if(companyPrpt.getProperty(deptId)!=null){
			return deptId;
		}
		String rtnDeptId = deptId;
		SQL = "select parent_id from Department where FlowKey='"+deptId+"'";
		String parentId = this.getDbUtil().getFieldValue(SQL, new Field("Parent_id"));
		while(parentId.trim().length()>0){
			if(companyPrpt.getProperty(parentId)!=null){
				return parentId;
			}
			if(parentId.trim().length()>0){
				rtnDeptId = parentId;
			}
			SQL = "select parent_id from Department where FlowKey='"+parentId+"'";
			parentId = this.getDbUtil().getFieldValue(SQL, new Field("Parent_id"));
		}
		return rtnDeptId;
	}
	
	public String getCompanyName(String deptId) throws Exception{
		return new Department(this.getCompanyId(deptId)).getDept_name();
	}
	
	public List<SelectItem> getChildList(SelectItem item){
		return this.getDbUtil().getChildList(item, this.Parent_id, 
											   this.Dept_name, this.SubDeptFlag);
	}
	
	public SelectItem getSelectItem(){
		SelectItem rtnItem = new SelectItem(this.getFlowKey(),this.getDept_name());
		rtnItem.setParentKey(this.getParent_id());
		boolean hasChild = false;
		if(this.getSubDeptFlag().equals("Y")){
			hasChild = true;
		}
		rtnItem.setChildFlag(hasChild);
		return rtnItem;
	}
	
	public List<SelectItem> getCompanyTreeList(){
		return this.getTreeList(this.getSelectItem());
	}
	
	public List<SelectItem> getCompanyTreeList(String deptId) throws Exception{
		return this.getTreeList(new Department(this.getCompanyId(deptId)).getSelectItem());
	}
	
	public List<SelectItem> getCompanyList() throws Exception{
		String SQL = "select * from Department where CompanyFlag='Y'";
		return this.getDbUtil().getSelectItemList(SQL, this.Dept_name);
	}

}