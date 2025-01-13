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

public class Employee extends MasterBean {

	public Field Emp_name;
	public void setEmp_name(String Emp_name) {
		this.Emp_name.setValue(Emp_name);
	}
	public String getEmp_name() {
		return this.Emp_name.getValue();
	}
	
	public Field EngName;
	public void setEngName(String EngName) {
		this.EngName.setValue(EngName);
	}
	public String getEngName() {
		return this.EngName.getValue();
	}
	
	public Field Id_no;
	public void setId_no(String Id_no) {
		this.Id_no.setValue(Id_no);
	}
	public String getId_no() {
		return this.Id_no.getValue();
	}
	
	public Field Dept_id;
	public void setDept_id(String Dept_id) {
		this.Dept_id.setValue(Dept_id);
	}
	public String getDept_id() {
		return this.Dept_id.getValue();
	}
	
	public Field Agent_Emp_id;
	public void setAgent_Emp_id(String Agent_Emp_id) {
		this.Agent_Emp_id.setValue(Agent_Emp_id);
	}
	public String getAgent_Emp_id() {
		return this.Agent_Emp_id.getValue();
	}
	
	public Field Tel_no;
	public void setTel_no(String Tel_no) {
		this.Tel_no.setValue(Tel_no);
	}
	public String getTel_no() {
		return this.Tel_no.getValue();
	}
	
	public Field Extension;
	public void setExtension(String Extension) {
		this.Extension.setValue(Extension);
	}
	public String getExtension() {
		return this.Extension.getValue();
	}
	
	public Field Mobile_no;
	public void setMobile_no(String Mobile_no) {
		this.Mobile_no.setValue(Mobile_no);
	}
	public String getMobile_no() {
		return this.Mobile_no.getValue();
	}
	
	public Field Email;
	public void setEmail(String Email) {
		this.Email.setValue(Email);
	}
	public String getEmail() {
		return this.Email.getValue();
	}
	
	public Field Address;
	public void setAddress(String Address) {
		this.Address.setValue(Address);
	}
	public String getAddress() {
		return this.Address.getValue();
	}
	
	public Field RegisterAddress;
	public void setRegisterAddress(String RegisterAddress) {
		this.RegisterAddress.setValue(RegisterAddress);
	}
	public String getRegisterAddress() {
		return this.RegisterAddress.getValue();
	}
	
	public Field Title;
	public void setTitle(String Title) {
		this.Title.setValue(Title);
	}
	public String getTitle() {
		return this.Title.getValue();
	}
	
	public Field OnBoard_date;
	public void setOnBoard_date(String OnBoard_date) {
		this.OnBoard_date.setValue(OnBoard_date);
	}
	public String getOnBoard_date() {
		return this.OnBoard_date.getValue();
	}
	
	public Field Leaves_date;
	public void setLeaves_date(String Leaves_date) {
		this.Leaves_date.setValue(Leaves_date);
	}
	public String getLeaves_date() {
		return this.Leaves_date.getValue();
	}
	
	public Field Birthday;
	public void setBirthday(String Birthday) {
		this.Birthday.setValue(Birthday);
	}
	public String getBirthday() {
		return this.Birthday.getValue();
	}
	
	public Field Job_Degree;
	public void setJob_Degree(String Job_Degree) {
		this.Job_Degree.setValue(Job_Degree);
	}
	public String getJob_Degree() {
		return this.Job_Degree.getValue();
	}
	
	public Field Salary_Point;
	public void setSalary_Point(String Salary_Point) {
		this.Salary_Point.setValue(Salary_Point);
	}
	public String getSalary_Point() {
		return this.Salary_Point.getValue();
	}
	
	public Field GroupType;
	public void setGroupType(String GroupType) {
		this.GroupType.setValue(GroupType);
	}
	public String getGroupType() {
		return this.GroupType.getValue();
	}
	
	public Field ResearchCenter;
	public void setResearchCenter(String ResearchCenter) {
		this.ResearchCenter.setValue(ResearchCenter);
	}
	public String getResearchCenter() {
		return this.ResearchCenter.getValue();
	}
	
	public Field MedicalCenter;
	public void setMedicalCenter(String MedicalCenter) {
		this.MedicalCenter.setValue(MedicalCenter);
	}
	public String getMedicalCenter() {
		return this.MedicalCenter.getValue();
	}
	
	public Field Skill;
	public void setSkill(String Skill) {
		this.Skill.setValue(Skill);
	}
	public String getSkill() {
		return this.Skill.getValue();
	}
	
	public Field ContractFlag1;
	public void setContractFlag1(String ContractFlag1) {
		this.ContractFlag1.setValue(ContractFlag1);
	}
	public String getContractFlag1() {
		return this.ContractFlag1.getValue();
	}
	
	public Field ContractFlag2;
	public void setContractFlag2(String ContractFlag2) {
		this.ContractFlag2.setValue(ContractFlag2);
	}
	public String getContractFlag2() {
		return this.ContractFlag2.getValue();
	}
	
	public Field ContractPaper1;
	public void setContractPaper1(String ContractPaper1) {
		this.ContractPaper1.setValue(ContractPaper1);
	}
	public String getContractPaper1() {
		return this.ContractPaper1.getValue();
	}
	
	public Field ContractPaper2;
	public void setContractPaper2(String ContractPaper2) {
		this.ContractPaper2.setValue(ContractPaper2);
	}
	public String getContractPaper2() {
		return this.ContractPaper2.getValue();
	}
	
	public Employee() {
		this.init();
	}

	public Employee(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}
	
	public void init() {
		super.init();
		this.setProgramId("jsp.Employee");
		this.setTableName("Employee");
		
		this.Emp_name = new Field("Emp_name", this.getTableName());
		this.Emp_name.setCheckEmpty(true);
		this.Emp_name.setSearchCondition(Cnstnts.LIKE);
		
		this.EngName = new Field("EngName", this.getTableName());
		
		this.Agent_Emp_id = new Field("Agent_Emp_id", this.getTableName());
		
		this.Id_no = new Field("Id_no", this.getTableName());
		
		this.Dept_id = new Field("Dept_id", this.getTableName());
		this.Dept_id.setCheckEmpty(true);
		
		this.Tel_no = new Field("Tel_no", this.getTableName());
		this.Tel_no.setSearchCondition(Cnstnts.LIKE);
		
		this.Extension = new Field("Extension", this.getTableName());
		
		this.Mobile_no = new Field("Mobile_no", this.getTableName());
		this.Mobile_no.setSearchCondition(Cnstnts.LIKE);
		
		this.Email = new Field("Email", this.getTableName());
		
		this.Address = new Field("Address", this.getTableName());
		this.Address.setSearchCondition(Cnstnts.LIKE);
		
		this.RegisterAddress = new Field("RegisterAddress", this.getTableName());
		
		this.Title = new Field("Title", this.getTableName());
		this.Title.setCheckEmpty(true);
		
		this.OnBoard_date = new Field("OnBoard_date", this.getTableName());
		
		this.Leaves_date = new Field("Leaves_date", this.getTableName());
		
		this.Birthday = new Field("Birthday", this.getTableName());
		
		this.Job_Degree = new Field("Job_Degree", this.getTableName());
		
		this.Salary_Point = new Field("Salary_Point", this.getTableName());
		
		this.GroupType = new Field("GroupType", this.getTableName());
		
		this.ResearchCenter = new Field("ResearchCenter", this.getTableName());
		
		this.MedicalCenter = new Field("MedicalCenter", this.getTableName());
		
		this.Skill = new Field("Skill", this.getTableName());
		
		this.ContractFlag1 = new Field("ContractFlag1", this.getTableName());
		
		this.ContractFlag2 = new Field("ContractFlag2", this.getTableName());
		
		this.ContractPaper1 = new Field("ContractPaper1", this.getTableName());
		
		this.ContractPaper2 = new Field("ContractPaper2", this.getTableName());

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}
	
	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {	
			this.GroupType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.GroupType.setSelectList(new Category().getChildList(this.GroupType));
			
			this.Skill.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Skill.setSelectList(new Category().getChildList(this.Skill));
			this.Skill.setAnotherField(this.GroupType);
			
			this.Dept_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Dept_id.setSelectList(new Department().getRootTreeList());
			this.Dept_id.setAnotherField(this.Skill);
			rtnString += this.printHtml(this.Dept_id);
			
			this.Id_no.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.Emp_name.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Emp_name.setAnotherField(this.Id_no);
			rtnString += this.printHtml(this.Emp_name);
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {
			this.EngName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.Emp_name.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Emp_name.setColspan(1);
			this.Emp_name.setAnotherField(this.EngName);
			rtnString += this.printHtml(this.Emp_name);
			
			this.Title.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Title.setSelectList(new Category().getGroupList(this.Title));
			
			this.Dept_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Dept_id.setSelectList(new Department().getRootTreeList());
			this.Dept_id.setAnotherField(this.Title);
			this.Dept_id.setColspan(1);
			rtnString += this.printHtml(this.Dept_id);
			
			this.GroupType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.GroupType.setSelectList(new Category().getChildList(this.GroupType));
			
			this.Skill.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Skill.setSelectList(new Category().getChildList(this.Skill));
			this.Skill.setAnotherField(this.GroupType);
			this.Skill.setColspan(1);
			rtnString += this.printHtml(this.Skill);
			
			this.ResearchCenter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.ResearchCenter.setSelectList(new Category().getChildList(this.ResearchCenter));
			
			this.MedicalCenter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.MedicalCenter.setSelectList(new Category().getChildList(this.MedicalCenter));
			this.MedicalCenter.setAnotherField(this.ResearchCenter);
			this.MedicalCenter.setColspan(1);
			rtnString += this.printHtml(this.MedicalCenter);
			
			this.Birthday.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			
			this.Id_no.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Id_no.setColspan(1);
			this.Id_no.setAnotherField(this.Birthday);
			rtnString += this.printHtml(this.Id_no);

			this.Mobile_no.setHtmlType(Cnstnts.HTML_TAG_TEXT);

			this.Tel_no.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Tel_no.setColspan(1);
			this.Tel_no.setAnotherField(this.Mobile_no);
			rtnString += this.printHtml(this.Tel_no);
			
			this.Email.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Email.setSize(50);
			rtnString += this.printHtml(this.Email);

			this.Address.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			this.Address.setCols(60);
			this.Address.setRows(2);
			rtnString += this.printHtml(this.Address);
			
			this.RegisterAddress.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			this.RegisterAddress.setCols(60);
			this.RegisterAddress.setRows(2);
			rtnString += this.printHtml(this.RegisterAddress);
			
			this.Leaves_date.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			
			this.OnBoard_date.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.OnBoard_date.setColspan(1);
			this.OnBoard_date.setAnotherField(this.Leaves_date);
			rtnString += this.printHtml(this.OnBoard_date);
			
			this.ContractPaper1.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
			
			this.ContractFlag1.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			this.ContractFlag1.setAnotherField(this.ContractPaper1);
			rtnString += this.printHtml(this.ContractFlag1);
			
			this.ContractPaper2.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
			
			this.ContractFlag2.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			this.ContractFlag2.setAnotherField(this.ContractPaper2);
			rtnString += this.printHtml(this.ContractFlag2);
			
			if(this.getFlowKey().trim().length()>0){
				rtnString += "<tr><td colspan=4>"+
					Html.printTable("jsp.Employee.DraftRelationList",new Draft().getRelationList(
							this.getFlowKey(), this.getUserInfo()), this.getUserInfo())+"</td></tr>";
			}
		}
		return rtnString;
	}
	
	public void setSearchListPrpts() {
		
		this.FlowKey.setListWidth("12%");
		this.Emp_name.setListWidth("12%");
		this.Title.setListWidth("12%");
		try {
			this.Title.setMapingPrpt(new Category().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.Tel_no.setListWidth("15%");
		this.Mobile_no.setListWidth("15%");
		this.RegisterAddress.setListWidth("34%");

		Field[] showField = { this.FlowKey, this.Emp_name, this.Title,
				this.Tel_no, this.Mobile_no, this.RegisterAddress };
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}
	
	public void setDbFields() {
		super.setDbFields();
		this.Emp_name.setDbType("nvarchar(50)");
		this.DbFields.add(this.Emp_name);
		
		this.EngName.setDbType("nvarchar(50)");
		this.DbFields.add(this.EngName);
		
		this.Agent_Emp_id.setDbType("varchar(50)");
		this.DbFields.add(this.Agent_Emp_id);
		
		this.Id_no.setDbType("varchar(12)");
		this.DbFields.add(this.Id_no);
		
		this.Dept_id.setDbType("varchar(50)");
		this.DbFields.add(this.Dept_id);
		
		this.Tel_no.setDbType("varchar(50)");
		this.DbFields.add(this.Tel_no);
		
		this.Extension.setDbType("varchar(50)");
		this.DbFields.add(this.Extension);
		
		this.Mobile_no.setDbType("varchar(50)");
		this.DbFields.add(this.Mobile_no);
		
		this.Email.setDbType("varchar(50)");
		this.DbFields.add(this.Email);
		
		this.Address.setDbType("nvarchar(200)");
		this.DbFields.add(this.Address);
		
		this.RegisterAddress.setDbType("nvarchar(200)");
		this.DbFields.add(this.RegisterAddress);
		
		this.Title.setDbType("varchar(50)");
		this.DbFields.add(this.Title);
		
		this.OnBoard_date.setDbType("varchar(10)");
		this.DbFields.add(this.OnBoard_date);
		
		this.Leaves_date.setDbType("varchar(10)");
		this.DbFields.add(this.Leaves_date);
		
		this.Birthday.setDbType("varchar(10)");
		this.DbFields.add(this.Birthday);
		
		this.Job_Degree.setDbType("varchar(50)");
		this.DbFields.add(this.Job_Degree);
		
		this.Salary_Point.setDbType("varchar(50)");
		this.DbFields.add(this.Salary_Point);
		
		this.GroupType.setDbType("varchar(50)");
		this.DbFields.add(this.GroupType);
		
		this.MedicalCenter.setDbType("varchar(50)");
		this.DbFields.add(this.MedicalCenter);
		
		this.ResearchCenter.setDbType("varchar(50)");
		this.DbFields.add(this.ResearchCenter);
		
		this.Skill.setDbType("varchar(50)");
		this.DbFields.add(this.Skill);
		
		this.ContractFlag1.setDbType("char(1)");
		this.DbFields.add(this.ContractFlag1);
		
		this.ContractFlag2.setDbType("char(1)");
		this.DbFields.add(this.ContractFlag2);
		
		this.ContractPaper1.setDbType("varchar(50)");
		this.DbFields.add(this.ContractPaper1);
		
		this.ContractPaper2.setDbType("varchar(50)");
		this.DbFields.add(this.ContractPaper2);
	}
	
	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Emp_name);
		whereStr = Util.addWhereSQL(whereStr, this.Dept_id);
		whereStr = Util.addWhereSQL(whereStr, this.Id_no);
		whereStr = Util.addWhereSQL(whereStr, this.Address);
		whereStr = Util.addWhereSQL(whereStr, this.GroupType);
		whereStr = Util.addWhereSQL(whereStr, this.Skill);
		return this.doSearch(whereStr);
	}
	
	protected String getDataAuthorityWhereSQL(String whereStr) throws Exception {
		whereStr = Util.addWhereSQL(whereStr, this.FlowKey);
		whereStr = Util.addWhereOrAnd(whereStr, this.Applicant.getName(),this.getCreator());
		if(this.getDataDept().trim().length()>0){
			String deptStr = "CreateDept in('"+this.getDataDept()+"'";
			Department dept = new Department(this.getDataDept());
			SelectItem item = dept.getSelectItem();
			for (Iterator<?> itr = dept.getTreeList(item).iterator(); itr.hasNext();) {
				SelectItem dptItem = (SelectItem) itr.next();
				deptStr += ",'" + dptItem.getKey() + "'";
			}
			deptStr += ")";
			if (deptStr.length() > 0) {
				if (whereStr.length() > 0) {
					whereStr += " and (" + deptStr + " or Flowkey='" +
								this.getUserInfo().getAttribute("emp_id")+"')";
				} else {
					whereStr = " where (" + deptStr + " or Flowkey='" +
								this.getUserInfo().getAttribute("emp_id")+"')";
				}
			}
		}
		if (!this.getUserInfo().canQueryAll(this.getProgramId())) {
			if (!this.getUserInfo().canQueryDept(this.getProgramId())) {
				if (whereStr.length() > 0) {
					whereStr += " and (Applicant='" + this.getUserInfo().getAttribute("emp_id") + "' " +
									  "or Flowkey='" + this.getUserInfo().getAttribute("emp_id")+"')";
				} else {
					whereStr = " where (Applicant='" + this.getUserInfo().getAttribute("emp_id") + "' " +
									  "or Flowkey='" + this.getUserInfo().getAttribute("emp_id")+"')";
				}
			} else {
				String deptStr = "(CreateDept='" + this.getUserInfo().getAttribute("dept_id") + "'";
				int i = 0;
				Department dept = new Department(this.getUserInfo().getAttribute("dept_id"));
				SelectItem item = dept.getSelectItem();
				for (Iterator<?> itr = dept.getTreeList(item).iterator(); itr.hasNext(); i++) {
					SelectItem dptItem = (SelectItem) itr.next();
					deptStr += ",'" + dptItem.getKey() + "'";
				}
				deptStr += ")";
				if (deptStr.length() > 0) {
					if (whereStr.length() > 0) {
						whereStr += " and (" + deptStr + " or Flowkey='" +
								this.getUserInfo().getAttribute("emp_id")+"')";
					} else {
						whereStr = " where (" + deptStr + " or Flowkey='" +
								this.getUserInfo().getAttribute("emp_id")+"')";
					}
				}
			}
		}
		return whereStr;
	}
	
	public String getSubmitBtn() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if(this.getDbActionMode().equals(Cnstnts.PRINT) 
				&& this.getPageActionMode().equals(Cnstnts.MAINTAIN)){
			List<SelectItem> sampleDocs = new ReportDefine().getList(this.getProgramId());
			if(sampleDocs.size()>0){
				if(sampleDocs.size()>1){
					rtnString = "<select id='sampleDoc' name='sampleDoc'>";
					for(Iterator<SelectItem> itr=sampleDocs.iterator();itr.hasNext();){
						SelectItem option = (SelectItem)itr.next();
						String selected = Cnstnts.EMPTY_STRING;
						if(this.getSampleDoc().equals(option.getKey())){
							selected=Cnstnts.SELECTED;
						}
						rtnString += "  <option value='"+option.getKey()+"'"+selected+">"+
										option.getValue()+"</option>";
					}
					rtnString += "</select>";
				} else {
					rtnString = "<input type='hidden' id='sampleDoc' name='sampleDoc' " +
									   "value='"+sampleDocs.get(0).getValue()+"'/>";
				}				
			}
		}
		
		if (this.canSubmit()) {
			if (!this.getApplicant().equals(this.getUserInfo().getAttribute("emp_id"))) {
				if (Cnstnts.UPDATE.equals(this.getDbActionMode()) 
						&& !this.getFlowKey().equals(this.getUserInfo().getAttribute("emp_id"))) {
					if (!this.getUserInfo().canUpdateAll(this.getProgramId())) {
						if (!this.getUserInfo().canUpdateDept(this.getProgramId())) {
							return rtnString;
						} else {
							if (!this.getCreateDept().equals(this.getUserInfo().getAttribute("dept_id"))) {
								if (!this.chkInDept()) {
									return rtnString;
								}
							}
						}
					}
				}
				if (Cnstnts.DELETE.equals(this.getDbActionMode())) {
					if (!this.getUserInfo().canDeleteAll(this.getProgramId())) {
						if (!this.getUserInfo().canDeleteDept(this.getProgramId())) {
							return rtnString;
						} else {
							if (!this.getCreateDept().equals(this.getUserInfo().getAttribute("dept_id"))) {
								if (!this.chkInDept()) {
									return rtnString;
								}
							}
						}
					}
				}
			}
			rtnString += Html.getSubmitBtn(this.getUserInfo(), this.getDbActionMode(), null);
		}
		return rtnString;
	}
	
	public boolean getCanEditField(Field field) {
		if (this.canEdit() || this.onSearchMode()) {
			if (!this.getUserInfo().canUpdateAll(this.getProgramId())) {
				if (!this.getUserInfo().canUpdateDept(this.getProgramId())) {
					if(this.getDbActionMode().equals(Cnstnts.UPDATE)
							&& this.getFlowKey().equals(this.getUserInfo().getAttribute("emp_id"))
									&& (field.getName().equals(this.EngName.getName())
									 || field.getName().equals(this.MedicalCenter.getName())
									 || field.getName().equals(this.ResearchCenter.getName())
									 || field.getName().equals(this.Id_no.getName())
									 || field.getName().equals(this.Birthday.getName())
									 || field.getName().equals(this.Tel_no.getName())
									 || field.getName().equals(this.Mobile_no.getName())
									 || field.getName().equals(this.Email.getName())
									 || field.getName().equals(this.Address.getName())
									 || field.getName().equals(this.RegisterAddress.getName()))){
						return true;
					}
					return false;
				} else {
					if (!this.getCreateDept().equals(this.getUserInfo().getAttribute("dept_id"))) {
						try {
							if (!this.chkInDept()) {
								if(this.getDbActionMode().equals(Cnstnts.UPDATE)
										&& this.getFlowKey().equals(this.getUserInfo().getAttribute("emp_id"))
												&& (field.getName().equals(this.EngName.getName())
												 || field.getName().equals(this.MedicalCenter.getName())
												 || field.getName().equals(this.ResearchCenter.getName())
												 || field.getName().equals(this.Id_no.getName())
												 || field.getName().equals(this.Birthday.getName())
												 || field.getName().equals(this.Tel_no.getName())
												 || field.getName().equals(this.Mobile_no.getName())
												 || field.getName().equals(this.Email.getName())
												 || field.getName().equals(this.Address.getName())
												 || field.getName().equals(this.RegisterAddress.getName()))){
									return true;
								}
								return false;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	public List<SelectItem> getDepartmentList(String deptId) throws Exception {
		String SQL = "select * from " + this.getTableName() +
					 " where Dept_id='" + deptId + "'";
		return this.getDbUtil().getSelectItemList(SQL, this.Emp_name);
	}
	
	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Emp_name);
	}
	
	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			Employee preObj = (Employee) userInfo.getObj(this.getTableName());
			this.setSearchResult(preObj.getSearchResult());
		}
	}
	
	public boolean checkInsertError() throws Exception {
		if(super.checkInsertError()){
			return true;
		} else {
			if(this.getFlowKey().equals(this.getAgent_Emp_id())){
				this.setErrorMessage(this.getErrorMessage(this.Agent_Emp_id));
				return true;
			}
			if(this.Id_no.getValue().trim().length()>0 
					&& !Util.chkID(this.Id_no.getValue())){
				this.setErrorMessage(this.getErrorMessage(this.Id_no));
				return true;
			}
			if(this.Email.getValue().trim().length()>0 
					&& !Util.chkEmail(this.Email.getValue())){
				this.setErrorMessage(this.getErrorMessage(this.Email));
				return true;
			}
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
		 * }
		 */
	}

	public void doCloseProcess() throws Exception {
		super.doCloseProcess();
	}

	public String onAjaxRequest(String dataValue, String tagMode) {
		String rtnString = "";
		return rtnString;
	}
	
	public List<SelectItem> getDeptList(String deptId) throws Exception {
		String SQL = "select * from "+this.getTableName()+
					 " where "+this.Dept_id.getName()+"='"+deptId+"'"+
					 " order by FlowKey";
		return this.getDbUtil().getSelectItemList(SQL, this.Emp_name);
	}
	
	public List<SelectItem> getGroupList(String groupStr) throws Exception {
		String SQL = "select * from "+this.getTableName()+
					 " where "+this.Job_Degree.getName()+"='"+groupStr+"'"+
					 " order by FlowKey";
		return this.getDbUtil().getSelectItemList(SQL, this.Emp_name);
	}
	
	public List<SelectItem> getJobList(String job) throws Exception {
		String SQL = "select * from "+this.getTableName()+
					 " where "+this.Title.getName()+"='"+job+"'"+
					 " order by FlowKey";
		return this.getDbUtil().getSelectItemList(SQL, this.Emp_name);
	}
	
	public List<SelectItem> getGroupsList(String groupsId) throws Exception {
		String SQL = "select * from Employee where FlowKey in(" +
				"select Emp_id from Groups_detail where FlowKey='"+groupsId+"') "+
		 			 "order by FlowKey";
		return this.getDbUtil().getSelectItemList(SQL, this.Emp_name);
	}
	
	public List<List<Field>> getRelationList(String deptId, UserBean userInfo) throws Exception{
    	String SQL = "select 'Employee' as LinkPage1, e.FlowKey as LinkFlowKey1, e.Address, "+
    						 "e.Emp_name, e.Id_no, e.Tel_no, e.Email, c.Names as Title "+
    				 "from Employee e "+
    				 "inner join Category c on e.Title=c.FlowKey "+
    				 "where e.FlowKey in(select FlowKey from Employee " +
    				 					"where Dept_id='"+deptId+"') " +
    				 "order by e.FlowKey";
    	List<Field> dataFields = new ArrayList<Field>();
    	
    	Field LinkPage1 = new Field("LinkPage1",this.getTableName());
    	LinkPage1.setShowFlag(false);
    	dataFields.add(LinkPage1);
    	
    	Field LinkFlowKey1 = new Field("LinkFlowKey1",this.getTableName());
    	LinkFlowKey1.setAliasName(userInfo.getMsg("jsp.Employee.FlowKey"));
    	LinkFlowKey1.setLinkFlag1(true);
    	LinkFlowKey1.setLinkMode1(Cnstnts.OPEN_APPENDIX);
    	LinkFlowKey1.setLinkParameter1("&linkMode=openAppendix&modeLockFlag=true");
    	LinkFlowKey1.setDbActionMode1(Cnstnts.QUERY);
    	LinkFlowKey1.setListWidth("10%");
    	dataFields.add(LinkFlowKey1);
    	
    	Field Emp_name = new Field("Emp_name","Employee");
    	Emp_name.setListWidth("10%");
    	Emp_name.setAlign(Cnstnts.CENTER);
    	dataFields.add(Emp_name);
    	
    	Field Title = new Field("Title","Employee");
    	Title.setListWidth("10%");
    	dataFields.add(Title);
    	
    	Field Id_no = new Field("Id_no","Employee");
    	Id_no.setListWidth("10%");
    	dataFields.add(Id_no);
    	
    	Field Tel_no = new Field("Tel_no","Employee");
    	Tel_no.setListWidth("10%");
    	dataFields.add(Tel_no);
    	
    	Field Email = new Field("Email","Employee");
    	Email.setListWidth("20%");
    	dataFields.add(Email);
    	
    	Field Address = new Field("Address","Employee");
    	Address.setListWidth("30%");
    	dataFields.add(Address);
    	
    	return this.getDbUtil().getFieldsList(SQL, dataFields);
    }

}