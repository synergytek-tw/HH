package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.html.Html;

public class DraftOffice extends MultiDetail {

    public DraftOffice(){this.init();}

    public DraftOffice(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field PatentOffice;
    public void setPatentOffice(String PatentOffice){this.PatentOffice.setValue(PatentOffice);}
    public String getPatentOffice(){return this.PatentOffice.getValue();}
    
    public Field Priority;
    public void setPriority(String Priority){this.Priority.setValue(Priority);}
    public String getPriority(){return this.Priority.getValue();}
    
    public Field Reason;
    public void setReason(String Reason){this.Reason.setValue(Reason);}
    public String getReason(){return this.Reason.getValue();}
    
    public Field Result;
    public void setResult(String Result){this.Result.setValue(Result);}
    public String getResult(){return this.Result.getValue();}
    
    public Field AgentNo;
    public void setAgentNo(String AgentNo){this.AgentNo.setValue(AgentNo);}
    public String getAgentNo(){return this.AgentNo.getValue();}
    
    public Field PatentCaseNo;
    public void setPatentCaseNo(String PatentCaseNo){this.PatentCaseNo.setValue(PatentCaseNo);}
    public String getPatentCaseNo(){return this.PatentCaseNo.getValue();}
    
    public Field PatentType;
    public void setPatentType(String PatentType){this.PatentType.setValue(PatentType);}
    public String getPatentType(){return this.PatentType.getValue();}
    
    private int FRAME_HEIGHT = 120;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftOffice");
        this.setTableName("DraftOffice");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");
        
        this.Priority = new Field("Priority",this.getTableName());
        this.Priority.setDbType("int");
       
        this.PatentOffice = new Field("PatentOffice", this.getTableName());
        this.PatentOffice.setCheckEmpty(true);
        this.PatentOffice.setDbType("nvarchar(50)");
        
        this.Reason = new Field("Reason", this.getTableName());
        this.Reason.setDbType("nvarchar(500)");
        
        this.Result = new Field("Result", this.getTableName());
        this.Result.setDbType("varchar(50)");
        
        this.AgentNo = new Field("AgentNo", this.getTableName());
        this.AgentNo.setCheckEmpty(true);
        this.AgentNo.setDbType("varchar(50)");
        
        this.PatentCaseNo = new Field("PatentCaseNo", this.getTableName());
        this.PatentCaseNo.setDbType("varchar(50)");
        
        this.PatentType = new Field("PatentType", this.getTableName());
        this.PatentType.setCheckEmpty(true);
        this.PatentType.setDbType("varchar(50)");
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.Priority);
        this.DbFields.add(this.PatentOffice);
        this.DbFields.add(this.Reason);
        this.DbFields.add(this.Result);
        this.DbFields.add(this.AgentNo);
        this.DbFields.add(this.PatentCaseNo);
        this.DbFields.add(this.PatentType);
    }
    /*
    private List<SelectItem> getCanSelectOfficeList(Field field) throws Exception {
		String SQL="select * from Category " +
				   "where ParentId='"+field.getName()+"' and FlowKey not in(" +
				   		"select PatentOffice from DraftOffice where ParentId='"+this.getParentId()+"') " +
				   "order by FlowKey";
		return this.getDbUtil().getSelectItemList(SQL, new Field("Names"));
	}
	*/
    public String printMaintainTable() throws Exception {
        String rtnString = "<table id='bodyTable' " + this.getTableBgcolor() + ">";
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	rtnString += this.PatentCaseNo.printHiddenTag();
        	
        	this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.PatentOffice.setSelectList(new Category().getChildList(this.PatentOffice));
        	
        	if(this.getPriority().trim().length()==0 
        			|| this.getPriority().equals("0")){        	
        		this.setPriority(this.getPriorityNum());
        	}
        	this.Priority.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Priority.setSize(1);
        	this.Priority.setAnotherField(this.PatentOffice);
            rtnString += this.printHtml(this.Priority);
    		
    		if(Integer.parseInt(this.getPriority())>1 && this.getAgentNo().trim().length()==0){
				String SQL = "select AgentNo from DraftOffice " +
				 			 "where ParentId='"+this.getParentId()+"' and Priority=1";
				this.setAgentNo(this.getDbUtil().getFieldValue(SQL, this.AgentNo));
    		}
    		this.AgentNo.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    		this.AgentNo.setSelectList(new Attorney().getList());
    		
    		this.PatentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    		this.PatentType.setSelectList(new Category().getChildList(this.PatentType));
    		this.PatentType.setAnotherField(this.AgentNo);
    		rtnString += this.printHtml(this.PatentType);

    		this.Result.setValue("OR01");
    		rtnString += this.Result.printHiddenTag();
        }
        return rtnString+"</table>";
    }
    
    private String getPriorityNum() {
		String SQL = "select count(*)+1 as OrderNum from DraftOffice where ParentId='"+this.getParentId()+"'";
		return this.getDbUtil().getFieldValue(SQL, new Field("OrderNum"));
	}
    
    public void setSearchListPrpts() {
    	Properties OfficePrpt = null;
    	try {
    		OfficePrpt = new Category().getChildPrpts("PatentOffice");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.Priority.setListWidth("10");
		this.Priority.setAlign(Cnstnts.CENTER);

        this.PatentOffice.setListWidth("20%");
        this.PatentOffice.setMapingPrpt(OfficePrpt);
        this.PatentOffice.setNotShowCode(true);

        this.Reason.setListWidth("70%");

        Field[] showField = {this.Priority, this.PatentOffice, this.Reason};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftOffice preObj = (DraftOffice) userInfo.getObj(this.getTableName());
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
    	this.setDoSearchFlag(Cnstnts.TRUE_FLAG);
		this.setPageActionMode(Cnstnts.SEARCH);
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasult();
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasult() throws Exception {
		StringBuffer strBfr = new StringBuffer();
		
		Draft parentObj = (Draft)this.getUserInfo().getObj("Draft");
		
		boolean inG01Group = new Groups().inGorup("G01", 
				this.getUserInfo().getAttribute("emp_id"));
		
		boolean canAssesFlag = false;
		if(inG01Group && (parentObj.getStatus().equals("DS06") 
				|| (parentObj.getStatus().equals("DS01") 
						&& parentObj.getDoNotExamine().equals("Y")))
								&& parentObj.getDbActionMode().equals(Cnstnts.UPDATE)){
			canAssesFlag = true;
		}
		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thInsert=Cnstnts.EMPTY_STRING;
		String thText1="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.DraftOffice.Priority")+"</td>";
		String thText2="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.DraftOffice.PatentOffice")+"</td>";
		String thText3="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.DraftOffice.PatentType")+"</td>";
		String thText4="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.DraftOffice.AgentNo")+"</td>";
		String thDelete=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(\"" + this.getTableName()+"\",\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftOfficeDiv" +"\",\"DraftOfficeDiv\""+")'/>";
			thInsert = "<td align='center' width='3%'>"+insertImg+"</td>";
			thDelete = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thInsert+
								thText1+thText2+thText3+thText4+thDelete+"</tr>");
		
		String SQL = "select * from DraftOffice where ParentId='"+this.getParentId()+"'";
		
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		Properties agentPrpt = new Attorney().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			DraftOffice obj = new DraftOffice();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					obj.FlowKey.setValue(field.getValue());
				}
				if(field.getName().equals("Priority")){
					obj.Priority.setValue(field.getValue());
				}
				if(field.getName().equals("PatentOffice")){
					obj.PatentOffice.setValue(categoryPrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("Reason")){
					obj.Reason.setValue(field.getValue());
				}
				if(field.getName().equals("Result")){
					obj.Result.setValue(categoryPrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("AgentNo")){
					obj.AgentNo.setValue(agentPrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("PatentType")){
					obj.PatentType.setValue(categoryPrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("PatentCaseNo")){
					obj.PatentCaseNo.setValue(field.getValue());
				}
			}
			
			String tdEdit=Cnstnts.EMPTY_STRING;
			String tdText1="<td align='center'>"+obj.getPriority()+"</td>";
			String tdText2="<td>"+obj.getPatentOffice()+"</td>";
			String tdText3="<td>"+obj.getPatentType()+"</td>";
			String tdText4="<td>"+obj.getAgentNo()+"</td>";
			String tdDelete=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String editImg = Cnstnts.EMPTY_STRING;
				String deleteImg = Cnstnts.EMPTY_STRING;
				if(obj.getPatentCaseNo().trim().length()==0){
					editImg = "<img src='img/edit2.gif' style='cursor: hand' "+
			 				"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
			 				"onClick='openTabFrame(\"" + this.getTableName()+"\",\"update\",\""+
			 				obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftOfficeDiv" +
			 				"\",\"DraftOfficeDiv\""+")'/>";
					
					deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
							"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
							"onClick='openTabFrame(\"" + this.getTableName()+"\",\"delete\",\""+
							obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftOfficeDiv" +
							"\",\"DraftOfficeDiv\""+")'/>";
				}
				tdEdit = "<td align='center'>"+editImg+"</td>";
				tdDelete = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdEdit+tdText1+tdText2+tdText3+tdText4+tdDelete;
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
			int officeCount = findList.size();
			
			SQL = "select count(*) as CountNum from DraftOffice " +
	      	  	  "where ParentId='"+this.getParentId()+"' and PatentCaseNo!=''";
			Field CountNum = new Field("CountNum"); 
			int applyCount = Integer.parseInt(this.getDbUtil().getFieldValue(SQL,CountNum));
			
			if(applyCount != officeCount){
				String CreatePatentCaseBtn = "<input type='button' " +
					"value='"+this.getUserInfo().getMsg("jsp.DraftOffice.CreatePatentCase")+"' "+
					"onClick='this.disabled=true;document.input.tabText.value=\"CreatePatentCase\";setValue()'/>";
				strBfr.append(newLine + CreatePatentCaseBtn);
			}
		}
		
		return strBfr.toString();
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
			String cancelBtn = "<input type='button' onClick='parent.closeTabFrame(\"updateDraftOfficeDiv" +"\",\"DraftOfficeDiv\")' value='"+
								this.getUserInfo().getMsg("jsp.closeForm.cancel")+"'>";
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

	public boolean getHasApplyOffice(String parentId) {
		String SQL = "select count(*) as OfficeNum from DraftOffice " +
					 "where ParentId='"+parentId+"'";
		if(Integer.parseInt(this.getDbUtil().getFieldValue(SQL, new Field("OfficeNum")))>0){
			return true;
		} else {
			return false;
		}
	}
}