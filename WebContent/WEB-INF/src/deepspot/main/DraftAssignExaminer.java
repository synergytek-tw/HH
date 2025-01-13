package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.html.Html;
import deepspot.util.Util;

public class DraftAssignExaminer extends MultiDetail {

    public DraftAssignExaminer(){this.init();}

    public DraftAssignExaminer(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field EmpId;
    public void setEmpId(String EmpId){this.EmpId.setValue(EmpId);}
    public String getEmpId(){return this.EmpId.getValue();}
    
    public Field GroupType;
    public void setGroupType(String GroupType){this.GroupType.setValue(GroupType);}
    public String getGroupType(){return this.GroupType.getValue();}
    
    public Field Name;
    public void setName(String Name){this.Name.setValue(Name);}
    public String getName(){return this.Name.getValue();}
    
    public Field Institution;
    public void setInstitution(String Institution){this.Institution.setValue(Institution);}
    public String getInstitution(){return this.Institution.getValue();}

    public Field Dept;
    public void setDept(String Dept){this.Dept.setValue(Dept);}
    public String getDept(){return this.Dept.getValue();}

    public Field Central;
    public void setCentral(String Central){this.Central.setValue(Central);}
    public String getCentral(){return this.Central.getValue();}
        
    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}
    
    public Field Phone;
    public void setPhone(String Phone){this.Phone.setValue(Phone);}
    public String getPhone(){return this.Phone.getValue();}
    
    public Field Address;
    public void setAddress(String Address){this.Address.setValue(Address);}
    public String getAddress(){return this.Address.getValue();}
    
    public Field Email;
    public void setEmail(String Email){this.Email.setValue(Email);}
    public String getEmail(){return this.Email.getValue();}
    
    
    final int FRAME_HEIGHT = 220;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftAssignExaminer");
        this.setTableName("DraftAssignExaminer");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.EmpId = new Field("EmpId",this.getTableName());
        this.EmpId.setDbType("varchar(50)");
        
        this.GroupType = new Field("GroupType", this.getTableName());
        this.GroupType.setDbType("varchar(50)");
        this.GroupType.setCheckEmpty(true);
        
        this.Name = new Field("Name", this.getTableName());
        this.Name.setDbType("varchar(50)");
        this.Name.setCheckEmpty(true);
        
        this.Institution = new Field("Institution", this.getTableName());
        this.Institution.setDbType("varchar(100)");

        this.Dept = new Field("Dept", this.getTableName());
        this.Dept.setDbType("varchar(50)");

        this.Central = new Field("Central",this.getTableName());
        this.Central.setDbType("varchar(100)");
        
        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("nvarchar(50)");
        
        this.Phone = new Field("Phone", this.getTableName());
        this.Phone.setDbType("nvarchar(50)");

        this.Address = new Field("Address", this.getTableName());
        this.Address.setDbType("nvarchar(100)");

        this.Email = new Field("Email", this.getTableName());
        this.Email.setDbType("nvarchar(50)");
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.EmpId);
        this.DbFields.add(this.GroupType);
        this.DbFields.add(this.Name);
        this.DbFields.add(this.Institution);
        this.DbFields.add(this.Dept);
        this.DbFields.add(this.Central);
        this.DbFields.add(this.Title);
        this.DbFields.add(this.Phone);
        this.DbFields.add(this.Address);
        this.DbFields.add(this.Email);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	rtnString += this.EmpId.printHiddenTag();
        	
        	this.Name.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Name.setReadonly(true);
        	this.Name.setButtonValue(this.getUserInfo().getMsg("jsp.DraftRecommend.QueryRecommend"));
        	this.Name.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=DraftAssignExaminer\",\"DraftAssignExaminer\",800,600)");

            this.GroupType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.GroupType.setSelectList(new Category().getChildList(this.GroupType));
            this.GroupType.setAnotherField(this.Name);
            rtnString += this.printHtml(this.GroupType); 
            
            this.Central.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Name.setReadonly(true);
            this.Central.setSize(30);
    		
            this.Institution.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Institution.setReadonly(true);
            this.Institution.setSize(30);
            this.Institution.setAnotherField(this.Central);
            rtnString +=this.printHtml(this.Institution);
            
            this.Phone.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Phone.setReadonly(true);
            
            this.Title.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Title.setSelectList(new Category().getGroupList(this.Title));
            this.Title.setAnotherField(this.Phone);
            
            this.Dept.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Dept.setSelectList(new Department().getRootTreeList());
            this.Dept.setAnotherField(this.Title);
            rtnString += this.printHtml(this.Dept);
            
            this.Address.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Address.setReadonly(true);
            this.Address.setCols(82);
            this.Address.setRows(2);
            rtnString += this.printHtml(this.Address);
            
            this.Email.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Email.setReadonly(true);
            this.Email.setSize(40);
            rtnString += this.printHtml(this.Email);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftAssignExaminer preObj = (DraftAssignExaminer) userInfo.getObj(this.getTableName());
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
    
    protected String getSearchReasult(UserBean userInfo,String parentId) throws Exception {
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasult();
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasult() throws Exception {
		StringBuffer strBfr = new StringBuffer();
		
		boolean canAssesFlag = false;
		Draft parentObj = (Draft)this.getUserInfo().getObj("Draft");
		boolean inG01Group = false;
		if(new Groups().inGorup("G01", this.getUserInfo().getAttribute("emp_id"))){
			inG01Group = true;
		}
		if((parentObj.getStatus().equals("DS02") 
				|| parentObj.getStatus().equals("DS03")) && inG01Group){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='6%'>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.GroupType")+"</td>";
		String thText3="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.Name")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.Institution")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.Dept")+"</td>";
		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.Central")+"</td>";
		String thText7="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.Title")+"</td>";
		String thText8="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.Phone")+"</td>";
		String thText9="<td align='center' width='24%'>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.Address")+"</td>";
		String thText10="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.Email")+"</td>";
		String thText11=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(\"" + this.getTableName()+"\",\"insert\",\""+
							 parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftAssignExaminerDiv" +
							 "\",\"DraftAssignExaminerDiv\""+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText11 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+
								thText1+thText2+thText3+thText4+thText5+thText6+
								thText7+thText8+thText9+thText10+thText11+"</tr>");
		
		Properties categoryPrpt = new Category().getNamesPrpts();
		Properties deptPrpt = new Department().getNamesPrpts();
		
		String SQL = "select * from DraftAssignExaminer where ParentId='"+parentObj.getFlowKey()+"'";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();){
			i++;
			List<Field> dataFields = (List<Field>)itr.next();
			DraftAssignExaminer obj = new DraftAssignExaminer();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					obj.FlowKey.setValue(field.getValue());
				}
				if(field.getName().equals("EmpId")){
					obj.EmpId.setValue(field.getValue());
				}
				if(field.getName().equals("GroupType")){
					obj.GroupType.setValue(categoryPrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("Name")){
					obj.Name.setValue(field.getValue());
				}
				if(field.getName().equals("Institution")){
					obj.Institution.setValue(field.getValue());
				}
				if(field.getName().equals("Dept")){
					obj.Dept.setValue(deptPrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("Central")){
					obj.Central.setValue(field.getValue());
				}
				if(field.getName().equals("Title")){
					obj.Title.setValue(categoryPrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("Phone")){
					obj.Phone.setValue(field.getValue());
				}
				if(field.getName().equals("Address")){
					obj.Address.setValue(field.getValue());
				}
				if(field.getName().equals("Email")){
					obj.Email.setValue(field.getValue());
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+obj.GroupType.getValue()+"</td>";
			String tdText3="<td>"+obj.Name.getValue()+"</td>";
			String tdText4 ="<td>"+obj.Institution.getValue()+"</td>";
			String tdText5="<td>"+obj.Dept.getValue()+"</td>";
			String tdText6="<td>"+obj.Central.getValue()+"</td>";
			String tdText7="<td>"+obj.Title.getValue()+"</td>";
			String tdText8="<td>"+obj.Phone.getValue()+"</td>";
			String tdText9="<td>"+obj.Address.getValue()+"</td>";
			String tdText10="<td>"+obj.Email.getValue()+"</td>";
			String tdText11=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(\"" + this.getTableName()+"\",\"update\",\""+
								 		obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftAssignExaminerDiv" +
								 		"\",\"DraftAssignExaminerDiv\""+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(\"" + this.getTableName()+"\",\"delete\",\""+
				 						obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftAssignExaminerDiv" +
				 						"\",\"DraftAssignExaminerDiv\""+")'/>";
				tdText11 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+
							tdText7+tdText8+tdText9+tdText10+tdText11;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			String onClick = "";
			strBfr.append(newLine + "<tr "+bgColor+onClick+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");
		
		if(canAssesFlag){
			if(this.showLoadRecommendBtn()){
				String LoadRecommendBtn = "<input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.LoadRecommend")+"' "+
						"onClick='this.disabled=true;doAjaxRequest(\"Draft\",\"flowKey\"," +
						"\"LoadRecommend\",\"DraftAssignExaminerDiv\",\"innerHTML\")'/>";
				strBfr.append(newLine + LoadRecommendBtn);
			}
			
			if(this.showCreateExamineFormBtn()){
				String CreateExamineFormBtn = "<input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.CreateExamineForm")+"' "+
						"onClick='this.disabled=true;" +
						"doAjaxRequest(\"Draft\",\"flowKey\",\"CreateTechExamine\",\"DraftTechExamineDiv\",\"innerHTML\");" +
						"setValue()'/>";
				strBfr.append(newLine + CreateExamineFormBtn);
			}
		}
		
		if(parentObj.getStatus().equals("DS02") && inG01Group){
			String BackToEditBtn = "<div><input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftTechExamine.BackToEdit")+"' "+
						"onClick='this.disabled=true;" +
						"document.input.status.value=\"DS04\";" +
						"document.input.dbActionMode.value=\"update\";" +
						"document.input.submitFlag.value=\"true\";setValue()'/>"+
						this.getUserInfo().getMsg("jsp.Draft.LogMemo")+
						"<textarea rows='2' cols='60' id='logMemo' name='logMemo'></textarea></div>";
			strBfr.append(newLine + BackToEditBtn);
		}
		
		return strBfr.toString();
	}
    
    private boolean showCreateExamineFormBtn() {
    	String SQL = "select count(*) as FindCount from DraftAssignExaminer " +
		 	  		 "where ParentId='"+this.getParentId()+"' and FlowKey not in(" +
					 "select FlowKey from DraftTechExamine " +
					 "where ParentId='"+this.getParentId()+"')";
    	int findCount = Integer.parseInt(this.getDbUtil().getFieldValue(SQL, new Field("FindCount")));
    	if(findCount>0){
    		return true;
    	}
    	return false;
    }

	private boolean showLoadRecommendBtn() {
    	String SQL = "select count(*) as FindCount from Groups_detail " +
		 		"where FlowKey='G02' and Emp_id not in(select EmpId from DraftAssignExaminer " +
		 		"where ParentId='"+this.getParentId()+"')";
    	int findCount = Integer.parseInt(this.getDbUtil().getFieldValue(SQL, new Field("FindCount")));
    	if(findCount>0){
    		return true;
    	}
		return false;
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

    public boolean checkDeleteError() throws Exception {
        if(super.checkDeleteError()){
            return true;
        } else {
            return false;
        }
    }
    
    public String printFunctionBar() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		StringBuffer strBfr = new StringBuffer();
		strBfr.append(newLine + "<table id='functionBar' " + this.getTableBgcolor() + ">");
		strBfr.append(newLine + "<tr>");
		strBfr.append(newLine + "<td width='60%'>");
		strBfr.append(newLine + "<div class='logTitle'>");
		strBfr.append(newLine + this.getPageTitle());
		strBfr.append(newLine + "</div>");
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "<td align='right'>");
		if(!this.getDbActionMode().equals(Cnstnts.QUERY)){
			String cancelBtn = "<input type='button' onClick='" +
					"parent.resetFrame(\"DraftAssignExaminer\")' " +
					"value='"+this.getUserInfo().getMsg("jsp.closeForm.cancel")+"'>";
			strBfr.append(cancelBtn);	
			strBfr.append(Html.getDetailSubmitBtn(this.getUserInfo(), this.getDbActionMode()));
		}
		strBfr.append(this.getDbActionSelectItem());
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "</tr>");
		strBfr.append(newLine + "</table>");
		return strBfr.toString();
	}
    
    protected String getAjaxReasult(UserBean userInfo,String parentId) throws Exception {
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printAjaxReasult();
    }
    
    public String printAjaxReasult() throws Exception {
    	return this.printSearchReasult();
	}

	@SuppressWarnings("unchecked")
	public void doLoadRecommend(UserBean userInfo, String parentId) {
		List<String> sqlList = new ArrayList<String>();
		
		Draft parentObj = (Draft)userInfo.getObj("Draft");
		
		String SQL = "select * from Groups_detail " +
					 "where Flowkey='G03' and Emp_id not in(" +
					 		"select EmpId from DraftAssignExaminer " +
					 		"where ParentId='"+parentId+"')";
		Groups_detail groups_detail = new Groups_detail();
		groups_detail.setDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, groups_detail.getDbFields());
		for(Iterator itr=findList.iterator();itr.hasNext();){
			List<Field> dataFields = (List<Field>)itr.next();
			DraftAssignExaminer obj = new DraftAssignExaminer();
			obj.setDbFields();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("Emp_id")){
					Employee emp = new Employee(field.getValue());
					obj.FlowKey.setValue(Util.getNo(parentObj.getFlowKey(), 2));
					obj.CreateDept.setValue(userInfo.getAttribute("dept_id"));
					obj.Applicant.setValue(userInfo.getAttribute("emp_id"));
					obj.ParentId.setValue(parentObj.getFlowKey());
					obj.EmpId.setValue(field.getValue());
					obj.GroupType.setValue(emp.getGroupType());
					obj.Name.setValue(emp.getEmp_name());
					obj.Institution.setValue(emp.getResearchCenter());
					obj.Dept.setValue(new Department(emp.getDept_id()).getDept_name());
					obj.Central.setValue(emp.getMedicalCenter());
					obj.Title.setValue(new Category(emp.getTitle()).getNames());
					obj.Phone.setValue(emp.getTel_no());
					obj.Address.setValue(emp.getAddress());
					obj.Email.setValue(emp.getEmail());
				}
			}
			String insertSQL = obj.getDbUtil().getInsertSQL(obj.getTableName(), obj.getDbFields());
			sqlList.add(insertSQL);
		}
		this.getDbUtil().executeUpdate(sqlList);
	}

	@SuppressWarnings("unchecked")
	public void doCreateTechExamine(UserBean userInfo,String parentId) throws Exception {
		//Properties officePrpt = new Category().getChildPrpts("PatentOffice");
		Properties empPrpt = new Employee().getNamesPrpts();
		String SQL;
		List<String> sqlList = new ArrayList<String>();
		/*
		SQL = "delete from DraftTechExamine " +
			  "where FlowKey not in(select FlowKey from DraftAssignExaminer)";
		sqlList.add(SQL);
		
		SQL = "delete from DraftTechExamineOffice " +
		 	  "where ParentId not in(select FlowKey from DraftTechExamine)";
		sqlList.add(SQL);
		*/
		SQL = "update Draft set Status='DS03' where FlowKey='"+parentId+"'";
		sqlList.add(SQL);
		/*
		SQL = "select * from DraftOffice where ParentId='"+parentId+"'";
		DraftOffice draftOffice = new DraftOffice();
		draftOffice.setDbFields();
		List<List<Field>> officeList = draftOffice.getDbUtil().getFieldsList(SQL, draftOffice.getDbFields());
		*/
		SQL = "select * from DraftAssignExaminer " +
		 	  "where ParentId='"+parentId+"' and FlowKey not in(" +
					 "select FlowKey from DraftTechExamine " +
					 "where ParentId='"+parentId+"')";
		DraftAssignExaminer draftAssignExaminer = new DraftAssignExaminer();
		draftAssignExaminer.setDbFields();
		List<List<Field>> findList = draftAssignExaminer.getDbUtil().getFieldsList(SQL, draftAssignExaminer.getDbFields());
		for(Iterator itr=findList.iterator();itr.hasNext();){
			List<Field> dataFields = (List<Field>)itr.next();
			DraftTechExamine obj = new DraftTechExamine();
			obj.setDbFields();
			obj.setCreateDate(Util.getDate());
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					obj.FlowKey.setValue(field.getValue());
				}
				if(field.getName().equals("CreateDept")){
					obj.CreateDept.setValue(field.getValue());
				}
				if(field.getName().equals("Applicant")){
					obj.Applicant.setValue(field.getValue());
				}
				if(field.getName().equals("ParentId")){
					obj.ParentId.setValue(field.getValue());
				}
				if(field.getName().equals("EmpId")){
					obj.Reviewer.setValue(field.getValue());
					obj.ReviewerName.setValue(empPrpt.getProperty(field.getValue()));
				}
			}
			String insertSQL = obj.getDbUtil().getInsertSQL(obj.getTableName(), obj.getDbFields());
			sqlList.add(insertSQL);
			/*
			for(Iterator officeItr=officeList.iterator();officeItr.hasNext();){
				List<Field> officeFields = (List<Field>)officeItr.next();
				DraftTechExamineOffice officeObj = new DraftTechExamineOffice();
				officeObj.setDbFields();
				officeObj.setFlowKey(Util.getNo(obj.getFlowKey(), 2));
				officeObj.setCreateDept(obj.getCreateDept());
				officeObj.setApplicant(obj.getApplicant());
				officeObj.setParentId(obj.getFlowKey());
				for(Iterator fieldsItr=officeFields.iterator(); fieldsItr.hasNext();){
					Field field = (Field)fieldsItr.next();
					if(field.getName().equals("PatentOffice")){
						officeObj.OfficeName.setValue(officePrpt.getProperty(field.getValue()));
					}
				}
				String insertOfficeSQL = officeObj.getDbUtil().getInsertSQL(officeObj.getTableName(), officeObj.getDbFields());
				sqlList.add(insertOfficeSQL);
			}
			*/
			DraftTechExamineOffice officeObj = new DraftTechExamineOffice();
			officeObj.setDbFields();
			officeObj.setFlowKey(Util.getNo(obj.getFlowKey(), 2));
			officeObj.setCreateDept(obj.getCreateDept());
			officeObj.setApplicant(obj.getApplicant());
			officeObj.setParentId(obj.getFlowKey());
			officeObj.setOfficeName(Cnstnts.EMPTY_STRING);
			String insertOfficeSQL = officeObj.getDbUtil().getInsertSQL(officeObj.getTableName(), officeObj.getDbFields());
			sqlList.add(insertOfficeSQL);
		}
		if(this.getDbUtil().executeUpdate(sqlList)){
			Draft parentObj = (Draft)userInfo.getObj("Draft");
			parentObj.setStatus("DS03");
			parentObj.logStatus();
		}
	}

	@SuppressWarnings("unchecked")
	public void doCreateReExamine(UserBean userInfo,String parentId) throws Exception {
		Properties officePrpt = new Category().getChildPrpts("PatentOffice");
		Properties empPrpt = new Employee().getNamesPrpts();
		String SQL;
		List<String> sqlList = new ArrayList<String>();
		
		SQL = "update Draft set Status='DS05' where FlowKey='"+parentId+"'";
		sqlList.add(SQL);
		Draft draft = (Draft)userInfo.getObj("Draft");
		draft.setStatus("DS05");
		
		SQL = "select * from DraftOffice where ParentId='"+parentId+"'";
		DraftOffice draftOffice = new DraftOffice();
		draftOffice.setDbFields();
		List<List<Field>> officeList = draftOffice.getDbUtil().getFieldsList(SQL, draftOffice.getDbFields());
		
		SQL = "select * from Groups_detail where FlowKey='G02' " +
				//"and ('"+Util.getDate()+"' between DateFrom and DateTo) " +
				"and Emp_id not in(select InventorId from DraftInventor where ParentId='"+parentId+"')";
		Groups_detail groups_detail = new Groups_detail();
		groups_detail.setDbFields();
		List<List<Field>> findList = groups_detail.getDbUtil().getFieldsList(SQL, groups_detail.getDbFields());
		for(Iterator itr=findList.iterator();itr.hasNext();){
			List<Field> dataFields = (List<Field>)itr.next();
			DraftReExamine obj = new DraftReExamine();
			obj.setDbFields();
			obj.setFlowKey(Util.getNo(parentId+".Re", 2));
			obj.setCreateDept(userInfo.getAttribute("dept_id"));
			obj.setApplicant(userInfo.getAttribute("emp_id"));
			obj.setParentId(parentId);
			obj.setCreateDate(Util.getDate());
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("Emp_id")){
					obj.Reviewer.setValue(field.getValue());
					obj.ReviewerName.setValue(empPrpt.getProperty(field.getValue()));
				}
			}
			String insertSQL = obj.getDbUtil().getInsertSQL(obj.getTableName(), obj.getDbFields());
			sqlList.add(insertSQL);
			
			for(Iterator officeItr=officeList.iterator();officeItr.hasNext();){
				List<Field> officeFields = (List<Field>)officeItr.next();
				DraftReExamineOffice officeObj = new DraftReExamineOffice();
				officeObj.setDbFields();
				officeObj.setFlowKey(Util.getNo(obj.getFlowKey(), 2));
				officeObj.setCreateDept(obj.getCreateDept());
				officeObj.setApplicant(obj.getApplicant());
				officeObj.setParentId(obj.getFlowKey());
				for(Iterator fieldsItr=officeFields.iterator(); fieldsItr.hasNext();){
					Field field = (Field)fieldsItr.next();
					if(field.getName().equals("PatentOffice")){
						officeObj.OfficeName.setValue(officePrpt.getProperty(field.getValue()));
					}
				}
				String insertOfficeSQL = officeObj.getDbUtil().getInsertSQL(officeObj.getTableName(), officeObj.getDbFields());
				sqlList.add(insertOfficeSQL);
			}
		}
		this.getDbUtil().executeUpdate(sqlList);
	}

}