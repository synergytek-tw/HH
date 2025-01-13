package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.util.Util;

public class Category extends MasterBean {

	public Field Names;

	public void setNames(String Names) {
		this.Names.setValue(Names);
	}

	public String getNames() {
		return this.Names.getValue();
	}

	public Field ParentId;

	public void setParentId(String ParentId) {
		this.ParentId.setValue(ParentId);
	}

	public String getParentId() {
		return this.ParentId.getValue();
	}

	public Field CategoryFlag;

	public void setCategoryFlag(String CategoryFlag) {
		this.CategoryFlag.setValue(CategoryFlag);
	}

	public String getCategoryFlag() {
		return this.CategoryFlag.getValue();
	}
	
	public Field CategoryGroup;

	public void setCategoryGroup(String CategoryGroup) {
		this.CategoryGroup.setValue(CategoryGroup);
	}

	public String getCategoryGroup() {
		return this.CategoryGroup.getValue();
	}
	
	public Field SubjectId_D;

	public void setSubjectId_D(String SubjectId_D) {
		this.SubjectId_D.setValue(SubjectId_D);
	}

	public String getSubjectId_D() {
		return this.SubjectId_D.getValue();
	}
	
	public Field SubjectId_C;

	public void setSubjectId_C(String SubjectId_C) {
		this.SubjectId_C.setValue(SubjectId_C);
	}

	public String getSubjectId_C() {
		return this.SubjectId_C.getValue();
	}
	
	public Field Helper;

	public void setHelper(String Helper) {
		this.Helper.setValue(Helper);
	}

	public String getHelper() {
		return this.Helper.getValue();
	}
	
	public Field Sponsor;

	public void setSponsor(String Sponsor) {
		this.Sponsor.setValue(Sponsor);
	}

	public String getSponsor() {
		return this.Sponsor.getValue();
	}
	
	public Field Controler;

	public void setControler(String Controler) {
		this.Controler.setValue(Controler);
	}

	public String getControler() {
		return this.Controler.getValue();
	}
	
	public Field Rate;

	public void setRate(String Rate) {
		this.Rate.setValue(Rate);
	}

	public String getRate() {
		return this.Rate.getValue();
	}
	
	public Field Memo;

	public void setMemo(String Memo) {
		this.Memo.setValue(Memo);
	}

	public String getMemo() {
		return this.Memo.getValue();
	}

	public Category() {
		this.init();
	}

	public Category(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.Category");
		this.setTableName("Category");

		this.Names = new Field("Names", this.getTableName());
		this.Names.setSearchCondition(Cnstnts.LIKE);
		this.Names.setCheckEmpty(true);
		
		this.ParentId = new Field("ParentId", this.getTableName());
		
		this.CategoryFlag = new Field("CategoryFlag", this.getTableName());
		
		this.CategoryGroup = new Field("CategoryGroup", this.getTableName());
		
		this.SubjectId_D = new Field("SubjectId_D", this.getTableName());
		
		this.SubjectId_C = new Field("SubjectId_C", this.getTableName());
		
		this.Helper = new Field("Helper", this.getTableName());
		
		this.Sponsor = new Field("Sponsor", this.getTableName());
		
		this.Controler = new Field("Controler", this.getTableName());
		
		this.Memo = new Field("Memo", this.getTableName());
		
		this.Rate = new Field("Rate", this.getTableName());
		this.Rate.setValue("1");

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}

	public void setDbFields() {
		super.setDbFields();
		
		this.Names.setDbType("nvarchar(50)");
		this.DbFields.add(this.Names);
		
		this.ParentId.setDbType("varchar(50)");
		this.DbFields.add(this.ParentId);
		
		this.CategoryFlag.setDbType("char(1)");
		this.DbFields.add(this.CategoryFlag);
		
		this.CategoryGroup.setDbType("varchar(50)");
		this.DbFields.add(this.CategoryGroup);
		
		this.SubjectId_D.setDbType("varchar(50)");
		this.DbFields.add(this.SubjectId_D);
		
		this.SubjectId_C.setDbType("varchar(50)");
		this.DbFields.add(this.SubjectId_C);
		
		this.Helper.setDbType("varchar(50)");
		this.DbFields.add(this.Helper);
		
		this.Sponsor.setDbType("varchar(50)");
		this.DbFields.add(this.Sponsor);
		
		this.Controler.setDbType("varchar(50)");
		this.DbFields.add(this.Controler);
		
		this.Rate.setDbType("float");
		this.DbFields.add(this.Rate);
		
		this.Memo.setDbType("nvarchar(200)");
		this.DbFields.add(this.Memo);
	}
	
	public List<SelectItem> getChildList(Field field) throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		if(field!=null){
			whereStr = " where ParentId='"+field.getName()+"'";
		}
		String SQL="select * from "+this.getTableName()+
					whereStr+" order by FlowKey";
		return this.getDbUtil().getSelectItemList(SQL, this.Names);
	}
	
	public List<SelectItem> getChildList(String parentId) throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		if(parentId!=null){
			whereStr = " where ParentId='"+parentId+"'";
		}
		String SQL="select * from "+this.getTableName()+
						whereStr+" order by FlowKey";
		return this.getDbUtil().getSelectItemList(SQL, this.Names);
	}
	
	public List<SelectItem> getGroupList(Field field) throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		if(field!=null){
			whereStr = " where CategoryGroup='"+field.getName()+"'";
		}
		String SQL="select * from "+this.getTableName()+
					whereStr+" order by FlowKey";
		return this.getDbUtil().getSelectItemList(SQL, this.Names);
	}
	
	public List<SelectItem> getCategoryList() throws Exception {
		String SQL = "select * from "+this.getTableName()+
					 " where CategoryFlag='Y' and "+
					 this.FlowKey.getName()+"!='"+this.FlowKey.getValue()+
					 "' order by FlowKey";
		return this.getDbUtil().getSelectItemList(SQL, this.Names);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {
			this.ParentId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.ParentId.setSelectList(this.getMenuList());
			
			this.CategoryGroup.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.CategoryGroup.setSelectList(this.getMenuList());
			this.CategoryGroup.setColspan(1);
			this.CategoryGroup.setAnotherField(this.ParentId);
			rtnString += this.printHtml(this.CategoryGroup);

			this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			rtnString += this.printHtml(this.Names);
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {
			this.Rate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Rate.setSize(1);
			
			this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Names.setSize(30);
			this.Names.setAnotherField(this.Rate);
			rtnString += this.printHtml(this.Names);

			this.CategoryFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			
			this.ParentId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.ParentId.setSelectList(this.getMenuList());
			this.ParentId.setAnotherField(this.CategoryFlag);
			rtnString += this.printHtml(this.ParentId);
			
			this.SubjectId_C.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			//this.SubjectId_C.setSelectList(new Subject().getRootTreeList());
			
			this.SubjectId_D.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			//this.SubjectId_D.setSelectList(new Subject().getRootTreeList());
			this.SubjectId_D.setAnotherField(this.SubjectId_C);
			rtnString += this.printHtml(this.SubjectId_D);
			
			this.Sponsor.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Sponsor.setSelectList(new Employee().getList());
			
			this.Helper.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Helper.setSelectList(new Employee().getList());
			this.Helper.setAnotherField(this.Sponsor);
			rtnString += this.printHtml(this.Helper);
			
			this.CategoryGroup.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.CategoryGroup.setSelectList(this.getMenuList());
			
			this.Controler.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Controler.setSelectList(new Employee().getList());
			this.Controler.setAnotherField(this.CategoryGroup);
			rtnString += this.printHtml(this.Controler);
			
			this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			rtnString += this.printHtml(this.Memo);
		}
		return rtnString;
	}

	public void setSearchListPrpts() {
		
		Properties categoryPrpts=null;
		try {
			categoryPrpts = this.getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Properties subjectPrpts=null;
		try {
			//subjectPrpts = new Subject().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.FlowKey.setListWidth("10%");
		this.ParentId.setListWidth("20%");
		this.ParentId.setMapingPrpt(categoryPrpts);
		this.CategoryGroup.setListWidth("20%");
		this.CategoryGroup.setMapingPrpt(categoryPrpts);
		this.Names.setListWidth("20%");
		this.SubjectId_D.setListWidth("15%");
		this.SubjectId_D.setMapingPrpt(subjectPrpts);
		this.SubjectId_C.setListWidth("15%");
		this.SubjectId_C.setMapingPrpt(subjectPrpts);

		Field[] showField = {this.FlowKey, this.Names, this.CategoryGroup, 
							 this.ParentId, this.SubjectId_D, this.SubjectId_C};
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Names);
		whereStr = Util.addWhereSQL(whereStr, this.ParentId);
		whereStr = Util.addWhereSQL(whereStr, this.CategoryGroup);
		return this.doSearch(whereStr);
	}

	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Names);
	}
	
	public Properties getChildPrpts(String parentId) throws Exception {
		String SQL = "select * from Category where ParentId='"+parentId+"'";
		return this.getDbUtil().getFieldPrpts(SQL, this.Names.getName());
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			Category preObj = (Category) userInfo.getObj(this.getTableName());
			this.setSearchResult(preObj.getSearchResult());
		}
	}

	public boolean checkInsertError() throws Exception {
		if(super.checkInsertError()){
			return true;
		} else {
			if(this.FlowKey.getValue().equals(this.ParentId.getValue())){
				this.setErrorMessage(this.getErrorMessage(this.ParentId));
				return true;
			} else
			/*
			if(this.SubjectId_D.getValue().trim().length()>0) {
				if(new Subject(this.SubjectId_D.getValue()).getIsCategory().equals("Y")){
					this.setErrorMessage(this.getErrorMessage(this.SubjectId_D));
					return true;
				}	
			}
			if(this.SubjectId_C.getValue().trim().length()>0) {
				if(new Subject(this.SubjectId_C.getValue()).getIsCategory().equals("Y")){
					this.setErrorMessage(this.getErrorMessage(this.SubjectId_C));
					return true;
				}	
			}*/
			return false;
		}
	}

	public boolean checkUpdateError() throws Exception {
		return this.checkInsertError();
	}

	public boolean checkSignError() throws Exception {
		/*
		 * if(this.getFlowStep()==1 && this.LeaveType.trim().length()==0){
		 * this.setErrorMessage(this.getUserInfo().getMsg("prg.Leave.LeaveType"));
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
		if (tagMode.equals("select")) {
			rtnString = "<select id='LeaveType' name='LeaveType'>"
					+ "<option value='1'>A</option>"
					+ "<option value='2'>B</option>" + "</select>";
		}
		if (tagMode.equals("text")) {
			rtnString = "<input type='text' id='LeaveType' name='LeaveType' "
					+ "value='" + dataValue + "' />";
		}
		return rtnString;
	}
	
	public List<SelectItem> getList() throws Exception {
		SelectItem item = new SelectItem(Cnstnts.EMPTY_STRING,Cnstnts.EMPTY_STRING);
		item.setParentKey(Cnstnts.EMPTY_STRING);
		item.setChildFlag(true);
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		rtnList = this.getTreeList(item);
		return rtnList;
	  }
	
	public List<SelectItem> getMenuList() throws Exception{
		SelectItem item = new SelectItem(Cnstnts.EMPTY_STRING,Cnstnts.EMPTY_STRING);
		item.setParentKey(Cnstnts.EMPTY_STRING);
		item.setOnlyMenuFlag(true);
		item.setChildFlag(true);
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		rtnList = this.getTreeList(item);
		return rtnList;
	}

	public List<SelectItem> getTreeList(SelectItem item) throws Exception {
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		rtnList = this.walkTree(item, rtnList);
		return rtnList;
	}
	
	private List<SelectItem> walkTree(SelectItem item, 
									  List<SelectItem> itemList) throws Exception{
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
	
	public List<SelectItem> getChildList(SelectItem item) throws Exception{
		return this.getDbUtil().getChildList(item, this.ParentId, 
											   this.Names, this.CategoryFlag);
	}
	
	public SelectItem getSelectItem(){
		SelectItem rtnItem = new SelectItem(this.getFlowKey(),this.getNames());
		rtnItem.setParentKey(this.getParentId());
		boolean hasChild = false;
		if(this.getCategoryFlag().equals("Y")){
			hasChild = true;
		}
		rtnItem.setChildFlag(hasChild);
		return rtnItem;
	}

}
