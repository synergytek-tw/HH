package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import com.athenasoft.ooutil.OoConverter;

import deepspot.basic.Cnstnts;
import deepspot.basic.DraftMasterBean;
import deepspot.basic.Field;
import deepspot.basic.SelectItem;
import deepspot.html.Html;
import deepspot.util.Util;

public class Draft extends DraftMasterBean {

    public Draft(){this.init();}

    public Draft(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }
  
    public Field CompanyId;
    public void setCompanyId(String CompanyId){this.CompanyId.setValue(CompanyId);}
    public String getCompanyId(){return this.CompanyId.getValue();}
    
    public Field DeptId;
    public void setDeptId(String DeptId){this.DeptId.setValue(DeptId);}
    public String getDeptId(){return this.DeptId.getValue();}
    
    public Field InventorId;
    public void setInventorId(String InventorId){this.InventorId.setValue(InventorId);}
    public String getInventorId(){return this.InventorId.getValue();}
    
    public Field DoNotExamine;
    public void setDoNotExamine(String DoNotExamine){this.DoNotExamine.setValue(DoNotExamine);}
    public String getDoNotExamine(){return this.DoNotExamine.getValue();}
    
    public Field DraftNo;
    public void setDraftNo(String DraftNo){this.DraftNo.setValue(DraftNo);}
    public String getDraftNo(){return this.DraftNo.getValue();}
    
    public Field ApplyDate;
    public void setApplyDate(String ApplyDate){this.ApplyDate.setValue(ApplyDate);}
    public String getApplyDate(){return this.ApplyDate.getValue();}
    
    public Field DeptName;
    public void setDeptName(String DeptName){this.DeptName.setValue(DeptName);}
    public String getDeptName(){return this.DeptName.getValue();}
    
    public Field ApplicantName;
    public void setApplicantName(String ApplicantName){this.ApplicantName.setValue(ApplicantName);}
    public String getApplicantName(){return this.ApplicantName.getValue();}
 
    public Field CloserName;
    public void setCloserName(String CloserName){this.CloserName.setValue(CloserName);}
    public String getCloserName(){return this.CloserName.getValue();}
    
    public Field CloseTime;
    public void setCloseTime(String CloseTime){this.CloseTime.setValue(CloseTime);}
    public String getCloseTime(){return this.CloseTime.getValue();}
   
    public Field PatentType;
    public void setPatentType(String PatentType){this.PatentType.setValue(PatentType);}
    public String getPatentType(){return this.PatentType.getValue();}

    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}

    public Field OriginalTitle;
    public void setOriginalTitle(String OriginalTitle){this.OriginalTitle.setValue(OriginalTitle);}
    public String getOriginalTitle(){return this.OriginalTitle.getValue();}
    
    public Field ProjectNo;
    public void setProjectNo(String ProjectNo){this.ProjectNo.setValue(ProjectNo);}
    public String getProjectNo(){return this.ProjectNo.getValue();}

    public Field ProjectName;
    public void setProjectName(String ProjectName){this.ProjectName.setValue(ProjectName);}
    public String getProjectName(){return this.ProjectName.getValue();}

    public Field ProjectFileUrl;
    public void setProjectFileUrl(String ProjectFileUrl){this.ProjectFileUrl.setValue(ProjectFileUrl);}
    public String getProjectFileUrl(){return this.ProjectFileUrl.getValue();}
    
    public Field BeginDate;
    public void setBeginDate(String BeginDate){this.BeginDate.setValue(BeginDate);}
    public String getBeginDate(){return this.BeginDate.getValue();}

    public Field EndDate;
    public void setEndDate(String EndDate){this.EndDate.setValue(EndDate);}
    public String getEndDate(){return this.EndDate.getValue();}

    public Field FinanceDept;
    public void setFinanceDept(String FinanceDept){this.FinanceDept.setValue(FinanceDept);}
    public String getFinanceDept(){return this.FinanceDept.getValue();}
    
    public Field ProjectLeader;
    public void setProjectLeader(String ProjectLeader){this.ProjectLeader.setValue(ProjectLeader);}
    public String getProjectLeader(){return this.ProjectLeader.getValue();}
    
    public Field ProjectFlag;
    public void setProjectFlag(String ProjectFlag){this.ProjectFlag.setValue(ProjectFlag);}
    public String getProjectFlag(){return this.ProjectFlag.getValue();}
    
    public Field ProjectRate;
    public void setProjectRate(String ProjectRate){this.ProjectRate.setValue(ProjectRate);}
    public String getProjectRate(){return this.ProjectRate.getValue();}
    
    public Field ProjectMemo;
    public void setProjectMemo(String ProjectMemo){this.ProjectMemo.setValue(ProjectMemo);}
    public String getProjectMemo(){return this.ProjectMemo.getValue();}
   
    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}
        
    public Field ApplyIndustry;
    public void setApplyIndustry(String ApplyIndustry){this.ApplyIndustry.setValue(ApplyIndustry);}
    public String getApplyIndustry(){return this.ApplyIndustry.getValue();}
    
    public Field ApplyProduct;
    public void setApplyProduct(String ApplyProduct){this.ApplyProduct.setValue(ApplyProduct);}
    public String getApplyProduct(){return this.ApplyProduct.getValue();}
    
    public Field ApplyCompany;
    public void setApplyCompany(String ApplyCompany){this.ApplyCompany.setValue(ApplyCompany);}
    public String getApplyCompany(){return this.ApplyCompany.getValue();}
    
    public Field Summary;
    public void setSummary(String Summary){this.Summary.setValue(Summary);}
    public String getSummary(){return this.Summary.getValue();}
    
    public Field EngSummary;
    public void setEngSummary(String EngSummary){this.EngSummary.setValue(EngSummary);}
    public String getEngSummary(){return this.EngSummary.getValue();}
    
    public Field Purpose;
    public void setPurpose(String Purpose){this.Purpose.setValue(Purpose);}
    public String getPurpose(){return this.Purpose.getValue();}
    
    public Field Advantages;
    public void setAdvantages(String Advantages){this.Advantages.setValue(Advantages);}
    public String getAdvantages(){return this.Advantages.getValue();}
    
    public Field Description;
    public void setDescription(String Description){this.Description.setValue(Description);}
    public String getDescription(){return this.Description.getValue();}
    
    public Field Shortcoming;
    public void setShortcoming(String Shortcoming){this.Shortcoming.setValue(Shortcoming);}
    public String getShortcoming(){return this.Shortcoming.getValue();}
    
    public Field PerferredDesc;
    public void setPerferredDesc(String PerferredDesc){this.PerferredDesc.setValue(PerferredDesc);}
    public String getPerferredDesc(){return this.PerferredDesc.getValue();}
    
    public Field Claims;
    public void setClaims(String Claims){this.Claims.setValue(Claims);}
    public String getClaims(){return this.Claims.getValue();}
    
    public Field PreCaseAgent;
    public void setPreCaseAgent(String PreCaseAgent){this.PreCaseAgent.setValue(PreCaseAgent);}
    public String getPreCaseAgent(){return this.PreCaseAgent.getValue();}
    
    public Field PreCaseDocument;
    public void setPreCaseDocument(String PreCaseDocument){this.PreCaseDocument.setValue(PreCaseDocument);}
    public String getPreCaseDocument(){return this.PreCaseDocument.getValue();}
    
    public Field TabText;
    public void setTabText(String TabText){this.TabText.setValue(TabText);}
    public String getTabText(){return this.TabText.getValue();}
    
    public Field TmpField;
    public void setTmpField(String TmpField){this.TmpField.setValue(TmpField);}
    public String getTmpField(){return this.TmpField.getValue();}
    
    public Field LogMemo;
    public void setLogMemo(String LogMemo){this.LogMemo.setValue(LogMemo);}
    public String getLogMemo(){return this.LogMemo.getValue();}
    
    public boolean isSelf(){
    	if(this.getUserInfo().getAttribute("emp_id").equals(this.getApplicant())){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean inG01Group;
   
    public void init() {
        super.init();
        this.setProgramId("jsp.Draft");
        this.setTableName("Draft");

        this.CompanyId = new Field("CompanyId", this.getTableName());
        this.CompanyId.setDbType("varchar(50)");
        
        this.DeptId = new Field("DeptId", this.getTableName());
        this.DeptId.setDbType("varchar(50)");
        
        this.InventorId = new Field("InventorId", this.getTableName());
        this.InventorId.setDbType("varchar(50)");
        
        this.DoNotExamine = new Field("DoNotExamine", this.getTableName());
        this.DoNotExamine.setDbType("char(1)");
        
        this.DraftNo = new Field("DraftNo", this.getTableName());
        this.DraftNo.setSearchCondition(Cnstnts.LIKE);
        this.DraftNo.setDbType("varchar(50)");
        
        this.DeptName = new Field("DeptName", this.getTableName());
        this.DeptName.setDbType("varchar(50)");
        
        this.ApplicantName = new Field("ApplicantName", this.getTableName());
        this.ApplicantName.setDbType("varchar(50)");
        
        this.ApplyDate = new Field("ApplyDate", this.getTableName());
        this.ApplyDate.setDbType("varchar(10)");

        this.Summary = new Field("Summary", this.getTableName());
        this.Summary.setDbType("varchar(500)");

        this.EngSummary = new Field("EngSummary",this.getTableName());
        this.EngSummary.setDbType("varchar(500)");
        
        this.CloseTime = new Field("CloseTime", this.getTableName());
        this.CloseTime.setDbType("varchar(20)");
        
        this.CloserName = new Field("CloserName", this.getTableName());
        this.CloserName.setDbType("varchar(50)");
        
        this.PatentType = new Field("PatentType", this.getTableName());
        this.PatentType.setDbType("varchar(50)");
        //this.PatentType.setCheckEmpty(true);
        
        this.ProjectNo = new Field("ProjectNo", this.getTableName());
        this.ProjectNo.setDbType("varchar(50)");
        
        this.ProjectName = new Field("ProjectName",this.getTableName());
        this.ProjectName.setDbType("varchar(500)");
        
        this.BeginDate = new Field("BeginDate", this.getTableName());
        this.BeginDate.setDbType("varchar(10)");
        
        this.EndDate = new Field("EndDate", this.getTableName());
        this.EndDate.setDbType("varchar(10)");
        
        this.FinanceDept = new Field("FinanceDept",this.getTableName());
        this.FinanceDept.setDbType("nvarchar(50)");
        
        this.ProjectLeader = new Field("ProjectLeader",this.getTableName());
        this.ProjectLeader.setDbType("nvarchar(50)");
        
        this.ProjectFlag = new Field("ProjectFlag",this.getTableName());
        this.ProjectFlag.setDbType("char(1)");
        
        this.ProjectRate = new Field("ProjectRate",this.getTableName());
        this.ProjectRate.setDbType("varchar(50)");
        
        this.ProjectFileUrl = new Field("ProjectFileUrl",this.getTableName());
        this.ProjectFileUrl.setDbType("varchar(100)");
        
        this.ProjectMemo = new Field("ProjectMemo",this.getTableName());
        this.ProjectMemo.setDbType("varchar(500)");
        
        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("nvarchar(500)");
        this.Title.setCheckEmpty(true);
        this.Title.setSearchCondition(Cnstnts.LIKE);

        this.OriginalTitle = new Field("OriginalTitle", this.getTableName());
        this.OriginalTitle.setDbType("nvarchar(500)");
        this.OriginalTitle.setSearchCondition(Cnstnts.LIKE);
        
        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");
        
        this.ApplyIndustry = new Field("ApplyIndustry",this.getTableName());
        this.ApplyIndustry.setDbType("nvarchar(500)");
        
        this.ApplyProduct = new Field("ApplyProduct",this.getTableName());
        this.ApplyProduct.setDbType("nvarchar(500)");
        
        this.ApplyCompany = new Field("ApplyCompany",this.getTableName());
        this.ApplyCompany.setDbType("nvarchar(500)");
        
        this.Purpose = new Field("Purpose",this.getTableName());
        this.Purpose.setDbType("varchar(500)");
        
        this.Advantages = new Field("Advantages",this.getTableName());
        this.Advantages.setDbType("varchar(500)");
        
        this.Description = new Field("Description",this.getTableName());
        this.Description.setDbType("varchar(500)");
        
        this.Shortcoming = new Field("Shortcoming",this.getTableName());
        this.Shortcoming.setDbType("varchar(500)");
        
        this.PerferredDesc = new Field("PerferredDesc",this.getTableName());
        this.PerferredDesc.setDbType("varchar(500)");
        
        this.Claims = new Field("Claims",this.getTableName());
        this.Claims.setDbType("varchar(500)");
        
        this.PreCaseAgent = new Field("PreCaseAgent",this.getTableName());
        this.PreCaseAgent.setDbType("varchar(50)");
        
        this.PreCaseDocument = new Field("PreCaseDocument",this.getTableName());
        this.PreCaseDocument.setDbType("varchar(100)");
        
        this.TabText = new Field("TabText", this.getTableName());
        
        this.TmpField = new Field("TmpField", this.getTableName());
        
        this.LogMemo = new Field("LogMemo", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

	public void setDbFields() {
        super.setDbFields();
        
        this.DbFields.add(this.CompanyId);
        this.DbFields.add(this.DeptId);
        this.DbFields.add(this.InventorId);
        this.DbFields.add(this.DoNotExamine);
        this.DbFields.add(this.DraftNo);
        
        this.DbFields.add(this.CloserName);
        this.DbFields.add(this.CloseTime);
        this.DbFields.add(this.Title);
        this.DbFields.add(this.OriginalTitle);
        this.DbFields.add(this.ApplyDate);
        this.DbFields.add(this.PatentType);
        this.DbFields.add(this.DeptName);
        this.DbFields.add(this.ApplicantName);
        this.DbFields.add(this.Status);
        
        this.DbFields.add(this.ProjectNo);
        this.DbFields.add(this.ProjectName);
        this.DbFields.add(this.BeginDate);
        this.DbFields.add(this.EndDate);
        this.DbFields.add(this.FinanceDept);
        this.DbFields.add(this.ProjectLeader);
        this.DbFields.add(this.ProjectFlag);
        this.DbFields.add(this.ProjectRate);
        this.DbFields.add(this.ProjectFileUrl);
        this.DbFields.add(this.ProjectMemo);
        
        this.DbFields.add(this.ApplyIndustry);
        this.DbFields.add(this.ApplyCompany);
        this.DbFields.add(this.ApplyProduct);
        this.DbFields.add(this.Summary);
        this.DbFields.add(this.EngSummary);
        this.DbFields.add(this.Purpose);
        this.DbFields.add(this.Advantages);
        this.DbFields.add(this.Description);
        this.DbFields.add(this.Shortcoming);
        this.DbFields.add(this.PerferredDesc);
        this.DbFields.add(this.Claims);
        
        this.DbFields.add(this.PreCaseAgent);
        this.DbFields.add(this.PreCaseDocument);
    }
	
	public String printHtmlBody() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine + "<table id='bodyTable' " + this.getTableBgcolor() + ">";
		rtnString += this.FlowKey.printHiddenTag();
		if (this.onSearchMode()) {
			rtnString += this.printSearchTable();
		} else {
			rtnString += this.printMaintainTable();
		}
		rtnString += newLine + "</table>";
		 
		if (this.onSearchMode()) {
			rtnString += this.printSearchReasult();
		}
		return rtnString;
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
									   "value='"+sampleDocs.get(0).getKey()+"'/>";
				}				
			}
		}
		if (this.canSubmit()) {
			String BtnValue = null;
			if (this.getApplicant().equals(this.getUserInfo().getAttribute("emp_id"))) {
				if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
					if(this.getStatus().equals("DS01") || this.getStatus().equals("DS04")){
						if(!this.getDoNotExamine().equals("Y")){
							String SendToExamineBtn = "<input type='button' " +
									"value='"+this.getUserInfo().getMsg("jsp.DraftRecommend.SendToExamine")+"' "+
									"onClick='this.disabled=true;" +
									"document.input.status.value=\"DS02\";" +
									"document.input.submitFlag.value=\"true\";" +
									"document.input.applyDate.value=\""+Util.getDate()+"\";setValue()'/>";
							rtnString += SendToExamineBtn;
						}
						
						if(this.getStatus().equals("DS04")){
							String cancelDraftBtn = "<input type='button' " +
									"value='"+this.getUserInfo().getMsg("jsp.DraftRecommend.CancelDraft")+"' "+
									"onClick='this.disabled=true;" +
									"document.input.status.value=\"DS08\";" +
									"document.input.submitFlag.value=\"true\";setValue()'/>";
							rtnString += cancelDraftBtn;
							
							String updateBtn = "<input type='button' " +
									"value='"+this.getUserInfo().getMsg("jsp.common.tmpInsert")+"' "+
									"onClick='this.disabled=true;" +
									"document.input.status.value=\"DS01\";" +
									"document.input.submitFlag.value=\"true\";setValue()'/>";
							rtnString += updateBtn;
						}
						
						if(this.getStatus().equals("DS01")){
							BtnValue = this.getUserInfo().getMsg("jsp.common.tmpInsert");
							rtnString += Html.getSubmitBtn(this.getUserInfo(), this.getDbActionMode(), BtnValue);
						}
					}
				} else {
					rtnString += Html.getSubmitBtn(this.getUserInfo(), this.getDbActionMode(), BtnValue);
				}
			} else {
				if (Cnstnts.INSERT.equals(this.getDbActionMode())) {
					rtnString += Html.getSubmitBtn(this.getUserInfo(), this.getDbActionMode(), BtnValue);
				}
			}
		}
		return rtnString;
	}
	
    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.DraftNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	rtnString += this.printHtml(this.DraftNo);
        	
        	this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("DraftStatus"));
            
            this.CompanyId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CompanyId.setSelectList(new Department().getCompanyTreeList("D00"));
            this.CompanyId.setAnotherField(this.Status);
            rtnString += this.printHtml(this.CompanyId);
            
            this.OriginalTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Title.setAnotherField(this.OriginalTitle);
            rtnString += this.printHtml(this.Title);
        }
        return rtnString;
    }
    
    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	this.setCheckEmptyField();
        	rtnString += this.TmpField.printHiddenTag();
        	if(this.getTabText().equals("CreatePatentCase")){
        		this.doCreatePatentCase();
        		rtnString += "<script>alert('"+this.getUserInfo().
        							getMsg("jsp.Draft.PatentCaseCreated")+"')</script>";
        		this.setTabText(Cnstnts.EMPTY_STRING);
        	} 
        	rtnString += this.TabText.printHiddenTag();
        	
        	Groups groups = new Groups();
        	
        	boolean inG01Group = false;
        	if(groups.inGorup("G01", this.getUserInfo().getAttribute("emp_id"))){
        		inG01Group = true;
        	}
        	
        	boolean inG02Group = false;
        	if(groups.inGorup("G02", this.getUserInfo().getAttribute("emp_id"))){
        		inG02Group = true;
        	}
        	
        	boolean isTechExamine = false;
        	if(this.isTechExaminer(this.getUserInfo().getAttribute("emp_id"))){
        		isTechExamine = true;
        	}
        	
        	boolean showTab5 = false;
        	/*
        	if(isSelf() || (inG01Group && this.getStatus().equals("DS02"))){
        		showTab5 = true;
        	}*/
        	
        	boolean showTab6 = false;
        	String TabSelect = Cnstnts.EMPTY_STRING;
        	if((inG01Group || inG02Group || isTechExamine)){
        		showTab6 = true;
        		if(this.getStatus().equals("DS02")
        				|| this.getStatus().equals("DS03")
        						|| this.getStatus().equals("DS05")
        								|| this.getStatus().equals("DS06")){
        			if(showTab5){
            			TabSelect = "{selected:5}";
            		} else {
            			TabSelect = "{selected:4}";
            		}
        		}
        	}

        	rtnString += "<script type='text/javascript'>$(function(){$('#tabs').tabs(" +
        				 TabSelect + ");});</script>";
        	/*
            this.PatentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentType.setSelectList(new Category().getChildList(this.PatentType));
            rtnString += this.printHtml(this.PatentType);
            */
        	if(inG01Group && this.getDbActionMode().equals(Cnstnts.INSERT)){
        		if(this.DoNotExamine.getValue().equals("Y")){        		
            		this.CompanyId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            		this.CompanyId.setSelectList(new Department().getCompanyList());
            		this.CompanyId.setOnChange("setValue()");
            		
            		this.DoNotExamine.setAnotherField(this.CompanyId);
            		this.DoNotExamine.setColspan(1);
            	} else {
            		this.CompanyId.printHiddenTag();
            	}
    			
    			this.DoNotExamine.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            	this.DoNotExamine.setOnClick("setValue()");
            	rtnString += this.printHtml(this.DoNotExamine);
            	
            	if(this.DoNotExamine.getValue().equals("Y")){
            		this.InventorId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            		this.InventorId.setSelectList(new Employee().getDeptList(this.getDeptId()));
            		
            		this.DeptId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            		this.DeptId.setSelectList(new Department().getTreeList(
            				new Department(this.getCompanyId()).getSelectItem()));
            		this.DeptId.setAnotherField(this.InventorId);
            		this.DeptId.setOnChange("setValue()");
            		this.DeptId.setColspan(1);
            		rtnString += this.printHtml(this.DeptId);
            	} else {
            		this.InventorId.printHiddenTag();
            		this.DeptId.printHiddenTag();
            	}
        	} else {
        		if(this.DoNotExamine.getValue().equals("Y")){
        			this.CompanyId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            		this.CompanyId.setSelectList(new Department().getCompanyList());
            		
            		this.DoNotExamine.setAnotherField(this.CompanyId);
            		this.DoNotExamine.setColspan(1);
            		this.DoNotExamine.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
                	rtnString += this.printHtml(this.DoNotExamine);
                	
                	this.InventorId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            		this.InventorId.setSelectList(new Employee().getDeptList(this.getDeptId()));
            		
            		this.DeptId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            		this.DeptId.setSelectList(new Department().getTreeList(
            				new Department(this.getCompanyId()).getSelectItem()));
            		this.DeptId.setAnotherField(this.InventorId);
            		this.DeptId.setColspan(1);
            		rtnString += this.printHtml(this.DeptId);
        		} else {
        			this.DoNotExamine.printHiddenTag();
            		this.CompanyId.printHiddenTag();
            		this.InventorId.printHiddenTag();
            		this.DeptId.printHiddenTag();
        		}
        	}
        	
        	this.ProjectNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
        	this.DraftNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.DraftNo.setReadonly(true);
        	this.DraftNo.setAnotherField(this.ProjectNo);
        	this.DraftNo.setColspan(1);
        	rtnString += this.printHtml(this.DraftNo);
        	
            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Title.setCols(82);
            this.Title.setRows(2);
            rtnString += this.printHtml(this.Title);

            this.OriginalTitle.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.OriginalTitle.setCols(82);
            this.OriginalTitle.setRows(2);
            rtnString += this.printHtml(this.OriginalTitle);
            
            if(this.ApplicantName.getValue().trim().length()>0
            		&& !(this.getDbActionMode().equals(Cnstnts.INSERT))){
            	this.ApplyDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            	this.ApplyDate.setReadonly(true);
            	
            	this.Status.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            	this.Status.setMapingPrpt(new Category().getChildPrpts("DraftStatus"));
            	this.Status.setAnotherField(this.ApplyDate);
            	this.Status.setColspan(1);
                rtnString += this.printHtml(this.Status);
                
                this.ApplicantName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            	this.ApplicantName.setReadonly(true);
            	
            	this.DeptName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            	this.DeptName.setReadonly(true);
            	this.DeptName.setAnotherField(this.ApplicantName);
            	this.DeptName.setColspan(1);
                rtnString += this.printHtml(this.DeptName);
            }
            
            if(this.CloseTime.getValue().trim().length()>0){
            	this.CloserName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            	this.CloserName.setReadonly(true);
            	
            	this.CloseTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            	this.CloseTime.setReadonly(true);
            	this.CloseTime.setAnotherField(this.CloserName);
            	this.CloseTime.setColspan(1);
            	 rtnString += this.printHtml(this.CloseTime);
            }
            
            if(this.FlowKey.getValue().trim().length()>0 
            		&& !(this.getDbActionMode().equals(Cnstnts.INSERT))){
	            rtnString +="<tr><td colspan=4>"+
	            				"<div id='tabs'><ul>"+
	            				"<li><a href='#tabs-1'>"+this.getUserInfo().getMsg("jsp.Draft.Tab1.title")+"</a></li>" +
	            				"<li><a href='#tabs-2'>"+this.getUserInfo().getMsg("jsp.Draft.Tab2.title")+"</a></li>" +
	            				"<li><a href='#tabs-3'>"+this.getUserInfo().getMsg("jsp.Draft.Tab3.title")+"</a></li>" +
	            				"<li><a href='#tabs-4'>"+this.getUserInfo().getMsg("jsp.Draft.Tab4.title")+"</a></li>";
	            if(showTab5){
	            	 rtnString += "<li><a href='#tabs-5'>"+this.getUserInfo().getMsg("jsp.DraftRecommend.title")+"</a></li>";
	            }
	            if(showTab6){
	            	 rtnString += "<li><a href='#tabs-6'>"+this.getUserInfo().getMsg("jsp.Draft.Tab6.title")+"</a></li>";
	            }
	            rtnString += "</ul>";
	              
	            rtnString +="<div id='tabs-1'>";	           
	            /*
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.ProjectLegend")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table  border=0 cellspacing=2 cellpadding=2 width=100%>";
	            
	            this.setCheckEmptyField();
	            
	            this.ProjectName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.ProjectName.setSize(40);
	            
	            this.ProjectNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.ProjectNo.setSize(30);
	            this.ProjectNo.setColspan(1);
	            this.ProjectNo.setAnotherField(this.ProjectName);
	            
	            rtnString += this.printHtml(this.ProjectNo);
	                  
	            this.BeginDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR );
	            this.EndDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
	            this.BeginDate.setAnotherField(this.EndDate);
	            this.BeginDate.setColspan(1);
	            rtnString += this.printHtml(this.BeginDate);	            
	            
	            this.FinanceDept.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.ProjectLeader.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.FinanceDept.setAnotherField(this.ProjectLeader);
	            this.FinanceDept.setColspan(1);
	            rtnString += this.printHtml(this.FinanceDept);
	            
	            this.ProjectRate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.ProjectRate.setAfterText("%");
	            this.ProjectRate.setSize(5);
	            
	            this.ProjectFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
	            this.ProjectFlag.setAnotherField(this.ProjectRate);
	            this.ProjectFlag.setColspan(1);
	            this.ProjectFlag.setOnClick("setValue()");
	            rtnString += this.printHtml(this.ProjectFlag);
	            
	            this.ProjectFileUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
	            rtnString += this.printHtml(this.ProjectFileUrl);
	            
	            this.ProjectMemo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.ProjectMemo.setCols(82);
	            this.ProjectMemo.setRows(2);
	            rtnString += this.printHtml(this.ProjectMemo);
	            
	            rtnString +="</table>"; 
	            rtnString +="</div>";
	            rtnString +="</fieldset></br>"; 
	            */
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftInventor.title")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateDraftInventorDiv' name='updateDraftInventorDiv'></div>";
	            rtnString +="<div id='DraftInventorDiv' name='DraftInventorDiv'>";
	            rtnString += new DraftInventor().printDraftInventors(this.getUserInfo(),this.getFlowKey());
	            rtnString +="</div></td></tr></table>";
	            
	            rtnString +="</div>";
	            rtnString +="</fieldset></br>"; 
	            /*
	            String checkEmpty = Cnstnts.EMPTY_STRING;
	            if(this.getDbActionMode().equals(Cnstnts.UPDATE) && this.canEdit()){
	            	checkEmpty = "<font color='red'>"+this.getUserInfo().getMsg("jsp.common.Require")+"*</font>";
	            }
	            rtnString +="<fieldset><legend>"+checkEmpty+this.getUserInfo().getMsg("jsp.DraftOffice.title")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateDraftOfficeDiv' name='updateDraftOfficeDiv'></div>";
	            rtnString +="<div id='DraftOfficeDiv' name='DraftOfficeDiv'>";
	            rtnString += new DraftOffice().getSearchReasult(this.getUserInfo(),this.getFlowKey());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset>";
	            */
	            rtnString +="</div>";
	            
	            rtnString +="<div id='tabs-2'>";
	            
	            
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.Tab2.Legend.title")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table  border=0 cellspacing=2 cellpadding=2 width=100%>";
	            
	            this.ApplyIndustry.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.ApplyIndustry.setCols(80);
	            this.ApplyIndustry.setRows(2);
	            rtnString += this.printHtml(this.ApplyIndustry);
	            
	            this.ApplyProduct.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.ApplyProduct.setCols(80);
	            this.ApplyProduct.setRows(2);
	            rtnString += this.printHtml(this.ApplyProduct);
	            
	            this.ApplyCompany.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.ApplyCompany.setCols(80);
	            this.ApplyCompany.setRows(2);
	            rtnString += this.printHtml(this.ApplyCompany);
	            
	            rtnString +="</table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset></br>";	    
	            
	            
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.Shortcoming")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table  border=0 cellspacing=2 cellpadding=2 width=100%>";
	            
	            this.Shortcoming.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.Shortcoming.setCols(80);
	            this.Shortcoming.setRows(2);
	            rtnString += this.printHtml(this.Shortcoming);
	            
	            rtnString +="</table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset></br>";
	            
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftDocument.title")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateDraftDocumentDiv' name='updateDraftDocumentDiv'></div>";
	            rtnString +="<div id='DraftDocumentDiv' name='DraftDocumentDiv'>";
	            rtnString += new DraftDocument().getSearchReasult(this.getUserInfo(),this.getFlowKey());
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset></br>";
	            /*
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftPatent.title")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateDraftPatentDiv' name='updateDraftPatentDiv'></div>";
	            rtnString +="<div id='DraftPatentDiv' name='DraftPatentDiv'>";
	            rtnString += new DraftPatent().getSearchReasult(this.getUserInfo(),this.getFlowKey());
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset>";
	            */
	            rtnString +="</div>";
	            rtnString +="<div id='tabs-3'>";
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.SummaryLegend")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0>";
	            
	            this.Summary.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA );
	            this.Summary.setCols(90);
	            this.Summary.setRows(3);
	            rtnString += this.printHtml(this.Summary);	            
	            
	            rtnString +="</table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset><br>";
	            /*
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.EngSummaryLegend")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0>";
	            
	            this.EngSummary.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.EngSummary.setCols(100);
	            this.EngSummary.setRows(5);
	            rtnString += this.printHtml(this.EngSummary );
	            
	            rtnString +="</table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset><br>";
	            */
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.PurposeLegend")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0>";
	            
	            this.Purpose.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.Purpose.setCols(90);
	            this.Purpose.setRows(5);
	            rtnString += this.printHtml(this.Purpose);
	            rtnString +="</table>";
	            
	            rtnString +="</div>";
	            rtnString +="</fieldset></br>";
	            
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.AdvantagesLegend")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0>";
	            this.Advantages.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.Advantages.setCols(90);
	            this.Advantages.setRows(5);
	            rtnString += this.printHtml(this.Advantages);
	            rtnString +="</table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset></br>";
	            
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.DescriptionLegend")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0>";
	            this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.Description.setCols(90);
	            this.Description.setRows(8);
	            rtnString += this.printHtml(this.Description);
	            rtnString +="</table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset></br>";
	            /*
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.PerferredDescLegend")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0>";
	            this.PerferredDesc.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.PerferredDesc.setCols(100);
	            this.PerferredDesc.setRows(5);
	            rtnString += this.printHtml(this.PerferredDesc);
	            rtnString +="</table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset></br>";
	            
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.ClaimsLegend")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0>";
	            this.Claims.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.Claims.setCols(100);
	            this.Claims.setRows(5);
	            rtnString += this.printHtml(this.Claims);
	            rtnString +="</table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset>";
	            */
	            rtnString +="</div>";
	            rtnString +="<div id='tabs-4'>";
	            
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftPic.title")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateDraftPicDiv' name='updateDraftPicDiv'></div>";
	            rtnString +="<div id='DraftPicDiv' name='DraftPicDiv'>";
	            rtnString += new DraftPic().getSearchReasult(this.getUserInfo(),this.getFlowKey());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset><br>";
	            
	            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftAttachment.title")+"</legend>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=100% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateDraftAttachmentDiv' name='updateDraftAttachmentDiv'></div>";
	            rtnString +="<div id='DraftAttachmentDiv' name='DraftAttachmentDiv'>";
	            rtnString += new DraftAttachment().getSearchReasult(this.getUserInfo(),this.getFlowKey());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</fieldset>";
	            rtnString +="</div>";
	            
	            if(showTab5){
	            	rtnString +="<div id='tabs-5'>";
		            
		            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftRecommend.title")+
		            			this.getUserInfo().getMsg("jsp.DraftRecommend.title.memo")+"</legend>";
		            rtnString +="<div class='indent'>";
		            rtnString +="<table width=100% border=0><tr><td valign=top>";
		            rtnString +="<div id='updateDraftRecommendDiv' name='updateDraftRecommendDiv'></div>";
		            rtnString +="<div id='DraftRecommendDiv' name='DraftRecommendDiv'>";
		            rtnString += new DraftRecommend().getSearchReasult(this.getUserInfo(),this.getFlowKey());
		            
		            rtnString +="</div></td></tr></table>";
		            rtnString +="</div>";
		            rtnString +="</fieldset>";
		            
		            rtnString +="</div>";
	            }
	            
	            if(showTab6){
	            	rtnString +="<div id='tabs-6'>";
	            	
	            	if((this.getStatus().equals("DS02") 
	            			||  this.getStatus().equals("DS03")) && inG01Group){
	            		rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftAssignExaminer.title")+"</legend>";
			            rtnString +="<div class='indent'>";
			            rtnString +="<table width=100% border=0><tr><td valign=top>";
			            rtnString +="<div id='updateDraftAssignExaminerDiv' name='updateDraftAssignExaminerDiv'></div>";
			            rtnString +="<div id='DraftAssignExaminerDiv' name='DraftAssignExaminerDiv'>";
			            rtnString += new DraftAssignExaminer().getSearchReasult(this.getUserInfo(),this.getFlowKey());
			            rtnString +="</div></td></tr></table>";
			            rtnString +="</div>";
			            rtnString +="</fieldset><br>";
	            	}
	            	
	            	rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.Draft.PreCaseIndex.Legend")+"</legend>";
		            rtnString +="<div class='indent'>";
		            rtnString +="<table  border=0 cellspacing=2 cellpadding=2 width=100%>";
		            
		            this.PreCaseAgent.setHtmlType(Cnstnts.HTML_TAG_TEXT);
		            this.PreCaseAgent.setOnChange("doAjaxPost(\"Draft\",\"preCaseAgent\",\"PreCaseAgent&"+this.getFlowKey()+"\",\"tmpField\",\"Value\")");
		            rtnString += this.printHtml(this.PreCaseAgent);
		            
		            this.PreCaseDocument.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD2);
		            this.PreCaseDocument.setOnClick("document.input.tmpField.value=\""+this.getFlowKey()+"\";");
		            rtnString += this.printHtml(this.PreCaseDocument);
		            
		            rtnString +="</table>";
		            rtnString +="</div>";
		            rtnString +="</fieldset></br>";
		            
	            	if(this.getStatus().equals("DS02") || this.getStatus().equals("DS03") 
	            			|| this.getStatus().equals("DS05") || this.getStatus().equals("DS06") || this.getStatus().equals("DS07")){
			            rtnString +="<fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.title")+"</legend>";
			            rtnString +="<div class='indent'>";
			            rtnString +="<table width=100% border=0><tr><td valign=top>";
			            rtnString +="<div id='DraftTechExamineDiv' name='DraftTechExamineDiv'>";
			            rtnString += new DraftTechExamine().getSearchReasult(this.getUserInfo(),this.getFlowKey());
			            rtnString +="</div></td></tr></table>";
			            rtnString +="</div>";
			            rtnString +="</fieldset>";
	            	}
	            	/*
	            	if(inG01Group){
	            		rtnString +="<div id='DraftReExamineDiv' name='DraftReExamineDiv'>"+
            						new DraftReExamine().getSearchReasult(this.getUserInfo(),this.getFlowKey());
	            		rtnString +="</div>";
	            	}
	            	
	            	String checkEmpty = Cnstnts.EMPTY_STRING;
		            if(this.getDbActionMode().equals(Cnstnts.UPDATE) && this.canEdit()){
		            	checkEmpty = "<font color='red'>"+this.getUserInfo().getMsg("jsp.common.Require")+"*</font>";
		            }
		            */
	            	if((this.getStatus().equals("DS01") 
	            			&& this.getDoNotExamine().equals("Y")) 
	            					|| this.getStatus().equals("DS06")){
	            		rtnString +="</br><fieldset><legend>"+
	            					this.getUserInfo().getMsg("jsp.DraftOffice.title")+"</legend>";
			            rtnString +="<div class='indent'>";
			            rtnString +="<table width=100% border=0><tr><td valign=top>";
			            rtnString +="<div id='updateDraftOfficeDiv' name='updateDraftOfficeDiv'></div>";
			            rtnString +="<div id='DraftOfficeDiv' name='DraftOfficeDiv'>";
			            rtnString += new DraftOffice().getSearchReasult(this.getUserInfo(),this.getFlowKey());
			            
			            rtnString +="</div></td></tr></table>";
			            rtnString +="</div>";
			            rtnString +="</fieldset>";
	            	}
	            }
            
            	rtnString +="</div></td></tr>";
            	
            	String scriptText = Cnstnts.EMPTY_STRING;
            	 
            	scriptText = "<script>"+
								"function openTabFrame(jspName,dbActionMode,flowkey,frameHight,IFrameDiv,DataDiv){"+
								"  var frameWidth=document.getElementById('functionBar').offsetWidth;"+
								"  var tabFramDiv=document.getElementById(IFrameDiv);"+
								"  var varDataDiv=document.getElementById(DataDiv);" +
								
								"  var srcUrl=jspName+'.jsp?_pageActionMode=maintain&_dbActionMode='+dbActionMode;"+
								"  if(dbActionMode=='insert'){"+
								"    srcUrl += '&parentId='+flowkey;"+
								"  } else {"+
								"    srcUrl += '&_getDataFlag=true&flowKey='+flowkey;"+
								"  }"+
								"  varDataDiv.style.display='none';" +
								"  tabFramDiv.style.display='';" +
								"  tabFramDiv.innerHTML=\"<iframe "+
									"src='\"+srcUrl+\"' height='\"+frameHight+\"' width='\"+(frameWidth-80)+\"'></iframe>\";"+
								"}"+
								"function closeTabFrame(IFrameDiv,DataDiv){"+
								"  var tabFramDiv=document.getElementById(IFrameDiv);"+
								"  var varDataDiv=document.getElementById(DataDiv);" +
								"  tabFramDiv.style.display='none';" +
								"  varDataDiv.style.display='';" +
								"}"+
								"function resetFrame(newTabText){"+
								"  var IFramDiv='update'+newTabText+'Div';" +
								"  var DataDiv=newTabText+'Div'; "+
								"  closeTabFrame(IFramDiv,DataDiv);" +
							    "  doDraftAjaxRequest('Draft',newTabText,'"+this.getFlowKey()+"',DataDiv,'innerHTML')"+
							    "}"+
								"</script>";
            	rtnString += scriptText;
            }           
        }
        rtnString += new DraftLog().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        return rtnString;
    }
    
    private boolean isTechExaminer(String reviewer) {
		String SQL = "select count(Reviewer) as Num from DraftTechExamine " +
					 "where Reviewer='"+reviewer+"' and ParentId='"+this.getFlowKey()+"'";
		if(Integer.parseInt(this.getDbUtil().getFieldValue(SQL, new Field("Num")))>0){
			return true;
		} else {
			return false;
		}
	}

	public boolean canEdit(){
    	if (this.getFlowKey() == null) {
			return false;
		}
		if ((Cnstnts.INSERT.equals(this.getDbActionMode()) 
				|| ((Cnstnts.UPDATE.equals(this.getDbActionMode()) 
						&& Cnstnts.MAINTAIN.equals(this.getPageActionMode())
								&&  this.getFlowKey().trim().length() > 0))
										&& isSelf() && (this.getStatus().equals("DS01"))
												|| this.getStatus().equals("DS04"))) {
			if(this.getCloseTime().trim().length()==0){
				return true;
			} else {
				if(Cnstnts.INSERT.equals(this.getDbActionMode())){
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
    }
    
    public boolean getCanEditField(Field field) {
    	if(field.getName().equals(this.PreCaseAgent.getName()) 
    			|| field.getName().equals(this.PreCaseDocument.getName())){
    		if(this.getStatus().equals("DS02")
    				|| this.getStatus().equals("DS03")
    						|| this.getStatus().equals("DS05")){
    			return true;
    		} else {
    			return false;
    		}
    	}
    	if((field.getName().equals(this.DoNotExamine.getName())
    		|| field.getName().equals(this.CompanyId.getName())
    			|| field.getName().equals(this.DeptId.getName())
    				|| field.getName().equals(this.InventorId.getName()))){
    		if(this.getDbActionMode().equals(Cnstnts.INSERT)){
    			return true;
    		} else {
    			return false;
    		}
    	}
		if (this.canEdit() || this.onSearchMode()) {
			return true;
		} else {
			return false;
		}
	}

    public void setSearchListPrpts() {
    	Properties categoryPrpt = null;
    	try {
			categoryPrpt = new Category().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.DraftNo.setListWidth("10%");
		
        this.DeptName.setListWidth("15%");
        
        this.ApplicantName.setListWidth("15%");
        	
        this.Title.setListWidth("50%");
       
        this.Status.setListWidth("10%");
        this.Status.setMapingPrpt(categoryPrpt);
        this.Status.setNotShowCode(true);

        Field[] showField = {this.DraftNo,this.DeptName,ApplicantName,this.Title, this.Status};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
    	String authoritySQL = this.getDataAuthorityWhereSQL(Cnstnts.EMPTY_STRING).replaceAll("where", "and"); 
        String whereStr = "where ((Applicant='"+this.getUserInfo().getAttribute("emp_id")+"' " +
        				  "or (Applicant!='"+this.getUserInfo().getAttribute("emp_id")+"' " +
        				  "and Status!='DS01')) " + authoritySQL + ") or FlowKey in(" +
        				  "select ParentId from DraftInventor where InventorId='"+
        				  this.getUserInfo().getAttribute("emp_id")+"') ";
        whereStr = Util.addWhereSQL(whereStr, this.Title);
        whereStr = Util.addWhereSQL(whereStr, this.OriginalTitle);
        whereStr = Util.addWhereSQL(whereStr, this.CompanyId);
        whereStr = Util.addWhereSQL(whereStr, this.Status);
        whereStr = Util.addWhereSQL(whereStr, this.DraftNo);
        String SQL = "select * from draft "+whereStr;
        SQL = Util.addOrderSQL(SQL, this.getOrderKey(), this.getOrderSequence());
        return this.doSearch(SQL);
    }
    
    public List<Object[]> doSearch(String SQL) throws Exception{
  	  	if(this.getPageNo()==0){
  	  		this.setPageNo(1);
  	  	}
        int recordCount=0;
        
        List<Object[]> rtnList = new ArrayList<Object[]>();
        
        Iterator<?> itr = this.getDbUtil().getList(SQL, this.getShowField()).iterator();
        while(itr.hasNext()){
      	  Object[] record = (Object[])itr.next();
      	  recordCount++;
      	  if(recordCount<=this.getPageNo()*this.getPageRecords()
      			  && recordCount>(this.getPageNo()-1)*this.getPageRecords()){
      		  rtnList.add(record);
      	  }
        }
        this.setFindRecords(recordCount);
        return rtnList;
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Title);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            Draft draObj = (Draft) userInfo.getObj(this.getTableName());
            if(this.onBtnDeleteDetail()
                    && this.getDeleteItems()!=null
            				   && this.getDeleteItems().length>0){
                for(int i=0;i<this.getDeleteItems().length;i++){
                    int seqNo = Integer.parseInt(this.getDeleteItems()[i]);
                    draObj.getDetails().remove(seqNo-i);
                }
            }
            this.setSearchResult(draObj.getSearchResult());
            if (!this.getDataFromDB()) {
                this.setDetails(draObj.getDetails());
            }
        }
    }

    public boolean checkInsertError() throws Exception {
    	if(!this.getDoNotExamine().equals("Y")
    			&& this.getDbActionMode().equals(Cnstnts.INSERT)){
			this.CompanyId.setValue(new Department().
					getCompanyId(this.getUserInfo().getAttribute("dept_id")));
			this.DeptId.setValue(this.getUserInfo().getAttribute("dept_id"));
			this.InventorId.setValue(this.getUserInfo().getAttribute("emp_id"));
		}
    	this.setCheckEmptyField();
        if(super.checkInsertError()){
            return true;
        } else {
        	/*
        	if(this.getDbActionMode().equals(Cnstnts.UPDATE)
        			&& this.getStatus().equals("DS06")){
        		if(!new DraftOffice().getHasApplyOffice(this.getFlowKey())){
        			this.setStatus("DS03");
        			this.setErrorMessage(this.getUserInfo().getMsg("jsp.Draft.Office.Error"));
        			return true;
        		}
        	}
        	*/
        	if(this.getDbActionMode().equals(Cnstnts.INSERT)){
        		this.setStatus("DS01");
        		this.setDeptName(this.getUserInfo().getAttribute("DeptName"));
        		this.setApplicantName(this.getUserInfo().getAttribute("user_name"));
        		if(this.getFlowKey().trim().length()==0){
        			this.setFlowKey(Util.getNo(Util.getYear()+"D", 4));
        		}
        		Department company = new Department(this.getCompanyId());
        		String companyCode = company.getDept_code();
        		if(companyCode.trim().length()==0){
        			companyCode = this.getCompanyId();
        		}
        		this.setDraftNo(Util.getNo(companyCode+Util.getYear().substring(2), 3));
        	}
            return false;
        }
    }

    private void setCheckEmptyField() {
    	/*
		if(this.getDbActionMode().equals(Cnstnts.UPDATE)){
			this.ProjectNo.setCheckEmpty(true);
			this.BeginDate.setCheckEmpty(true);
			this.FinanceDept.setCheckEmpty(true);
			if(this.getProjectFlag().equals("Y")){
				this.ProjectFileUrl.setCheckEmpty(true);
			}
		}
		*/	
    	if(this.getDbActionMode().equals(Cnstnts.INSERT)){
			this.CompanyId.setCheckEmpty(true);
			this.DeptId.setCheckEmpty(true);
			this.InventorId.setCheckEmpty(true);
		}
	}

	public boolean checkUpdateError() throws Exception {
        if(this.checkInsertError()){
        	return true;
        }
        if(this.getCloseTime().trim().length()>0){
    		this.setErrorMessage(this.getUserInfo().getMsg("jsp.Draft.Status.Update.Error"));
    		return true;
    	}
        if(this.getStatus().equals("DS04") && this.getLogMemo().trim().length()==0){
        	this.setStatus("DS03");
    		this.setErrorMessage(this.getUserInfo().getMsg("jsp.Draft.LogMemo.Error"));
    		return true;
    	}
        if(this.getStatus().equals("DS07")
        				|| this.getStatus().equals("DS08")){
        	this.setCloseTime(Util.getDateTime());
        	this.setCloserName(this.getUserInfo().getAttribute("user_name"));
        }
        return false;
    }

    public boolean checkDeleteError() throws Exception {
        if(super.checkDeleteError()){
            return true;
        } else {
        	if(this.getStatus().equals("DS02") || this.getStatus().equals("DS03")
        			|| this.getStatus().equals("DS05") || this.getStatus().equals("DS06")
        					|| this.getStatus().equals("DS07") || this.getCloseTime().trim().length()>0){
        		this.setErrorMessage(this.getUserInfo().getMsg("jsp.Draft.Status.Delete.Error"));
        		return true;
        	}
            return false;
        }
    }
    
    public boolean dbExecute() throws Exception {
		this.resetError();
		if (this.getUserInfo() == null) {
			this.setErrorMessage("no userInfo object");
			return false;
		}
		if (this.checkHasError()) {
			return false;
		} else {
			if (Cnstnts.INSERT.equals(this.getDbActionMode())) {
				this.setApplicant(this.getUserInfo().getAttribute("emp_id"));
				this.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
				if (this.insert()) {
					this.doOtherInsertProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.insert"));
					if(Cnstnts.TRUE_FLAG.equals(this.getKeepProcessFlag())){
						this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=maintain"+
																	"&_clearFlag=true");
					} else {
						this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=maintain"+
									"&_dbActionMode=update&_getDataFlag=true&_flowKey="+this.getFlowKey());
					}
				} else {
					this.setErrorMessage(this.getTableName() + ".insert() error!!");
					return false;
				}
			} else if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
				if (this.update()) {
					this.doOtherUpdateProcess();
					if(this.getStatus().equals("DS02")
						|| this.getStatus().equals("DS03")
							|| this.getStatus().equals("DS04")
								|| this.getStatus().equals("DS05")
									|| this.getStatus().equals("DS06")
										|| this.getStatus().equals("DS07")
											|| this.getStatus().equals("DS08")){
						this.setMessage(this.getUserInfo().getMsg("jsp.Draft.Status."+this.getStatus()));
						this.logStatus();
					} else{
						this.setMessage(this.getUserInfo().getMsg("jsp.chkData.update"));
					}
					if(this.getStatus().equals("DS06")){
						this.setForwardPage(this.getTableName()+".jsp?_dbActionMode=update" +
								"&_flowKey="+this.getFlowKey()+"&_getDataFlag=true");
					} else {
						this.setForwardPage(this.getTableName()+".jsp" +
								"?_pageActionMode=search&doSearchFlag=true");
					}
				} else {
					this.setErrorMessage(this.getTableName() + ".update() error!!");
					return false;
				}
			} else if (Cnstnts.DELETE.equals(this.getDbActionMode())) {
				if (this.delete()) {
					this.doOtherDeleteProcess();
					this.clearAttribute();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.delete"));
					this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=search"+
									   "&doSearchFlag=true");
				} else {
					this.setErrorMessage(this.getTableName() + ".delete() error!!");
					return false;
				}
			}
			return true;
		}
	}
    
    public void logStatus() throws Exception{
    	DraftLog log = new DraftLog();
    	log.FlowKey.setValue(Util.getNo(this.getFlowKey()+"Log", 2));
    	log.CreateDept.setValue(this.getUserInfo().getAttribute("dept_id"));
    	log.Applicant.setValue(this.getUserInfo().getAttribute("emp_id"));
    	log.ParentId.setValue(this.getFlowKey());
    	log.LogTime.setValue(Util.getDateTime());
    	if(this.getTabText().equals("CreatePatentCase")){
    		log.LogStatus.setValue(this.getUserInfo().getMsg("jsp.Draft.Status.DS06.logStatus"));
        	log.LogMemo.setValue(this.getUserInfo().getMsg("jsp.Draft.Status.DS06.logMemo"));
    	} else {
    		log.LogStatus.setValue(new Category(this.getStatus()).getNames());
        	log.LogMemo.setValue(this.getLogMemo());
    	}
    	log.Logger.setValue(this.getUserInfo().getAttribute("user_name"));
    	log.insert();
    }
    
    public boolean delete() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.setDbFields();
		
		sqlList.add("delete from draftattachment where ParentId='" + this.getFlowKey() + "'");
		sqlList.add("delete from draftdocument where ParentId='" + this.getFlowKey() + "'");
		sqlList.add("delete from draftinventor where ParentId='" + this.getFlowKey() + "'");
		sqlList.add("delete from draftoffice where ParentId='" + this.getFlowKey() + "'");
		sqlList.add("delete from draftpatent where ParentId='" + this.getFlowKey() + "'");
		sqlList.add("delete from draftpic where ParentId='" + this.getFlowKey() + "'");
		sqlList.add("delete from draftrecommend where ParentId='" + this.getFlowKey() + "'");
		sqlList.add("delete from draftlog where ParentId='" + this.getFlowKey() + "'");
		sqlList.add("delete from Draft where FlowKey='"+this.getFlowKey()+"'");

		if (new Program(this.getProgramId()).getLogDelete().equals("1")) {
			sqlList.add(this.getLogSQL(null));
		}
		return this.getDbUtil().executeUpdate(sqlList);
	}

    public boolean insert() throws Exception {
    	List<String> sqlList = new ArrayList<String>();
		this.setDbFields();
		sqlList.add(this.getDbUtil().getInsertSQL(this.getTableName(), this.getDbFields()));
		
		DraftInventor inventor = new DraftInventor();
		inventor.setFlowKey(Util.getNo(this.getFlowKey(), 2));
		inventor.setParentId(this.getFlowKey());
		inventor.setCreateDept(this.getCreateDept());
		inventor.setApplicant(this.getApplicant());
		inventor.setInventorId(this.getInventorId());
		Employee thisInventor = new Employee(this.getInventorId());
		inventor.setInventorOrder("1");
		inventor.setChineseName(thisInventor.getEmp_name());
		inventor.setEnglishName(thisInventor.getEngName());
		inventor.setEmail(thisInventor.getEmail());
		inventor.setAddress(thisInventor.getRegisterAddress());
		inventor.setDbFields();
		sqlList.add(inventor.getDbUtil().getInsertSQL(inventor.getTableName(), inventor.getDbFields()));
		
		return this.getDbUtil().executeUpdate(sqlList);
    }
    
    public void doPrintProcess() throws Exception {
    	String outFile = this.makeDoc();
    	if(outFile!=null){
    		this.setOutputFile(outFile);
    	}
	}
    
    @SuppressWarnings("unchecked")
	public String makeDoc() throws Exception{
    	if(this.getSampleDoc().trim().length()==0){
    		return null;
    	}
    	OoConverter oc = new OoConverter("localhost", "8100");
    	String sampleDoc = "file:///"+Util.getTomcatPath()+this.getSampleDoc();
    	String outputFile = "Draft/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".doc";
    	String outputDoc = "file:///"+Util.getDocPath()+outputFile;
    	
    	if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		char newLine = Cnstnts.NEW_LINE;
    		String SQL = Cnstnts.EMPTY_STRING,
    			   ValueText1 = Cnstnts.EMPTY_STRING,
    			   ValueText2 = Cnstnts.EMPTY_STRING;
    		Properties categoryPrpt = new Category().getNamesPrpts();
    		Employee thisApplicant = new Employee(this.getApplicant());
    		
    		Map data = this.getBasicDocMap();    		
    		data.put("${PatentType}", categoryPrpt.getProperty(this.getPatentType()));
    		
    		data.put("${ApplicantTel}", thisApplicant.getTel_no());
    		data.put("${ApplicantMobile}", thisApplicant.getMobile_no());
    		
    		SQL = "select * from DraftDocument where ParentId='"+this.getFlowKey()+"'";
    		DraftDocument document = new DraftDocument();
    		document.setDbFields();
    		List<List<Field>> documentLst = document.getDbUtil().getFieldsList(SQL, document.getDbFields());
    		int i=0;
    		ValueText1 = this.getUserInfo().getMsg("jsp.DraftDocument.NotyetPublish");
    		for(Iterator itr=documentLst.iterator();itr.hasNext();){
    			i++;
    			DraftDocument obj = new DraftDocument();
    			List<Field> detailFieldsLst = (List<Field>)itr.next();
    			for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
    				Field detailField = (Field)fieldsItr.next();
    				if(detailField.getName().equals("DocumentType")){
    					obj.DocumentType.setValue(categoryPrpt.getProperty(detailField.getValue()));
    				}
    				if(detailField.getName().equals("DocumentDate")){
    					obj.DocumentDate.setValue(detailField.getValue());
    				}
    				if(detailField.getName().equals("DocumentName")){
    					obj.DocumentName.setValue(detailField.getValue());
    				}
    				if(detailField.getName().equals("DocumentArea")){
    					obj.DocumentArea.setValue(detailField.getValue());
    				}
    				if(detailField.getName().equals("DocumentPublication")){
    					obj.DocumentPublication.setValue(detailField.getValue());
    				}
	    		}
    			if(i==1){
    				ValueText1 = this.getUserInfo().getMsg("jsp.DraftDocument.Published")+newLine+newLine;
    			} 
    			ValueText1 += this.getUserInfo().getMsg("jsp.DraftDocument.DocumentType")+" : "+
    							obj.getDocumentType()+newLine;
    			ValueText1 += this.getUserInfo().getMsg("jsp.DraftDocument.DocumentDate")+" : "+
								obj.getDocumentDate()+newLine;
    			ValueText1 += this.getUserInfo().getMsg("jsp.DraftDocument.DocumentName")+" : "+
								obj.getDocumentName()+newLine;
    			ValueText1 += this.getUserInfo().getMsg("jsp.DraftDocument.DocumentArea")+" : "+
								obj.getDocumentArea()+newLine;
    			ValueText1 += this.getUserInfo().getMsg("jsp.DraftDocument.DocumentPublication")+" : "+
								obj.getDocumentPublication()+newLine+newLine;
    		}
    		data.put("${DraftDocument}", ValueText1);
    		data.put("${DraftDocumentNum}", i+Cnstnts.EMPTY_STRING);
    		
    		SQL = "select * from DraftPatent where ParentId='"+this.getFlowKey()+"'";
    		DraftPatent patent = new DraftPatent();
    		patent.setDbFields();
    		List<List<Field>> patentLst = patent.getDbUtil().getFieldsList(SQL, patent.getDbFields());
    		i=0;
    		ValueText1 = Cnstnts.EMPTY_STRING;
    		for(Iterator itr=patentLst.iterator();itr.hasNext();){
    			i++;
    			DraftPatent obj = new DraftPatent();
    			List<Field> detailFieldsLst = (List<Field>)itr.next();
    			for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
    				Field detailField = (Field)fieldsItr.next();
    				if(detailField.getName().equals("PatentNo")){
    					obj.PatentNo.setValue(detailField.getValue());
    				}
    				if(detailField.getName().equals("PatentOffice")){
    					obj.PatentOffice.setValue(categoryPrpt.getProperty(detailField.getValue()));
    				}
	    		}
		    	ValueText1 += i+"."+obj.getPatentOffice()+" : "+obj.getPatentNo()+newLine+newLine;
    		}
    		data.put("${DraftPatent}", ValueText1);
    		data.put("${PatentSearchedNum}", i+Cnstnts.EMPTY_STRING);
    		
    		SQL = "select * from DraftAttachment where ParentId='"+this.getFlowKey()+"'";
    		DraftAttachment attachment = new DraftAttachment();
    		attachment.setDbFields();
    		List<List<Field>> attachmentLst = attachment.getDbUtil().getFieldsList(SQL, attachment.getDbFields());
    		i=0;
    		ValueText1 = Cnstnts.EMPTY_STRING;
    		for(Iterator itr=attachmentLst.iterator();itr.hasNext();){
    			i++;
    			DraftAttachment obj = new DraftAttachment();
    			List<Field> detailFieldsLst = (List<Field>)itr.next();
    			for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
    				Field detailField = (Field)fieldsItr.next();
    				if(detailField.getName().equals("AttachmentDate")){
    					obj.AttachmentDate.setValue(detailField.getValue());
    				}
    				if(detailField.getName().equals("AttachmentName")){
    					obj.AttachmentName.setValue(detailField.getValue());
    				}
	    		}
		    	ValueText1 += i+". "+this.getUserInfo().getMsg("jsp.DraftAttachment.AttachmentName")+" : "+
								obj.getAttachmentName()+newLine;
		    	ValueText1 += "  "+this.getUserInfo().getMsg("jsp.DraftAttachment.AttachmentDate")+" : "+
								obj.getAttachmentDate()+newLine+newLine;
    		}
    		data.put("${DraftAttachment}", ValueText1);
    		data.put("${DraftAttachmentNum}", i+Cnstnts.EMPTY_STRING);
    		
    		SQL = "select * from DraftPic where ParentId='"+this.getFlowKey()+"'";
    		DraftPic draftPic = new DraftPic();
    		draftPic.setDbFields();
    		List<List<Field>> DraftPicLst = draftPic.getDbUtil().getFieldsList(SQL, draftPic.getDbFields());
    		i=0;
    		ValueText1 = Cnstnts.EMPTY_STRING;
    		for(Iterator itr=DraftPicLst.iterator();itr.hasNext();){
    			i++;
    			DraftPic obj = new DraftPic();
    			List<Field> detailFieldsLst = (List<Field>)itr.next();
    			for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
    				Field detailField = (Field)fieldsItr.next();
    				if(detailField.getName().equals("PicName")){
    					obj.PicName.setValue(detailField.getValue());
    				}
	    		}
		    	ValueText1 += i+"."+this.getUserInfo().getMsg("jsp.DraftPic.PicName")+" : "+
								obj.getPicName()+newLine+newLine;
    		}
    		data.put("${DraftPic}", ValueText1);
    		data.put("${DraftPicNum}", i+Cnstnts.EMPTY_STRING);
    		
    		SQL = "select * from DraftInventor " +
    				"where ParentId='"+this.getFlowKey()+"' order by InventorOrder";
    		DraftInventor inventor = new DraftInventor();
    		inventor.setDbFields();
        	List<List<Field>> inventorLst = inventor.getDbUtil().getFieldsList(SQL, inventor.getDbFields());
        	i=0;
        	ValueText1 = Cnstnts.EMPTY_STRING;
        	ValueText2 = Cnstnts.EMPTY_STRING;
        	for(Iterator itr=inventorLst.iterator();itr.hasNext();){ 
        		i++;
        		DraftInventor obj = new DraftInventor();
                List<Field> detailFieldsLst = (List<Field>)itr.next();
            	for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
                    Field detailField = (Field)fieldsItr.next();
                    if(detailField.getName().equals("InventorId")){
                    	obj.InventorId.setValue(detailField.getValue());
                    }
                    if(detailField.getName().equals("ChineseName")){
                    	obj.ChineseName.setValue(detailField.getValue());
                    }
                    if(detailField.getName().equals("EnglishName")){
                    	obj.EnglishName.setValue(detailField.getValue());
                    }
                    if(detailField.getName().equals("Email")){
                    	obj.Email.setValue(detailField.getValue());
                    }
                    if(detailField.getName().equals("Address")){
                    	obj.Address.setValue(detailField.getValue());
                    }
                    if(detailField.getName().equals("ContributionShare")){
                    	obj.ContributionShare.setValue(detailField.getValue()+"%");
                    }
                }
            	ValueText1 += this.getUserInfo().getMsg("jsp.DraftInventor.title")+" "+i+" : "+newLine;
            	ValueText1 += this.getUserInfo().getMsg("jsp.DraftInventor.ChineseName")+" : "+
        						  obj.getChineseName()+"              "+
        						  this.getUserInfo().getMsg("jsp.DraftInventor.EnglishName")+" : "+
        						  obj.getEnglishName()+newLine;
            	ValueText1 += this.getUserInfo().getMsg("jsp.DraftInventor.Address")+" : "+
  				  				  obj.getAddress()+newLine;
            	ValueText1 += this.getUserInfo().getMsg("jsp.DraftInventor.Email")+" : "+
				  				  obj.getEmail()+newLine;
            	ValueText1 += this.getUserInfo().getMsg("jsp.DraftInventor.ContributionShare")+" : "+
				  				  obj.getContributionShare()+newLine+newLine;
        		
            	ValueText2 += this.getUserInfo().getMsg("jsp.DraftInventor.InventorSign")+" : "+newLine+newLine;
            }
    		data.put("${DraftInventors}", ValueText1);
    		data.put("${DraftInventorsSign}", ValueText2);
    		
    		SQL = "select * from DraftOffice " +
					"where ParentId='"+this.getFlowKey()+"' order by Priority";
    		DraftOffice draftOffice = new DraftOffice();
    		draftOffice.setDbFields();
			List<List<Field>> DraftOfficeLst = draftOffice.getDbUtil().getFieldsList(SQL, draftOffice.getDbFields());
			i=0;
			ValueText1 = Cnstnts.EMPTY_STRING;
			ValueText2 = Cnstnts.EMPTY_STRING;
			for(Iterator itr=DraftOfficeLst.iterator();itr.hasNext();){ 
				i++;
				DraftOffice obj = new DraftOffice();
		        List<Field> detailFieldsLst = (List<Field>)itr.next();
		    	for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
		            Field detailField = (Field)fieldsItr.next();
		            if(detailField.getName().equals("PatentOffice")){
		            	obj.PatentOffice.setValue(categoryPrpt.getProperty(detailField.getValue()));
		            }
		            if(detailField.getName().equals("Reason")){
		            	obj.Reason.setValue(detailField.getValue());
		            }
		            if(detailField.getName().equals("Priority")){
		            	obj.Priority.setValue(detailField.getValue());
		            }  
		        }
		    	ValueText1 += this.getUserInfo().getMsg("jsp.DraftOffice.PatentOffice")+" : "+
								  obj.getPatentOffice()+newLine;
		    	ValueText1 += this.getUserInfo().getMsg("jsp.DraftOffice.Reason")+" : "+
					  				  obj.getReason()+newLine+newLine;
				
		    	ValueText2 += obj.getPriority()+". "+obj.getPatentOffice()+newLine;
		    }
			data.put("${DraftOffice}", ValueText1);
			data.put("${DraftOfficePriority}", ValueText2);
    		
    		try {
				oc.convertDocument(sampleDoc, outputDoc, data);
				return "doc/"+outputFile;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
    	}
    	return null;
    }
    
    public String getInventorNum(){
    	String SQL = "select count(*) as InventorNum from DraftInventor where parentId='"+this.getFlowKey()+"'";
    	return this.getDbUtil().getFieldValue(SQL, new Field("InventorNum"));
    }
    
    public List<List<Field>> getPersonalList(String empId, UserBean userInfo) throws Exception{
    	String SQL = "select 'Draft' as LinkPage1, d.FlowKey as LinkFlowKey1, "+
    						 "d.Title, d.ApplyDate, d.DraftNo, c.Names as Status "+
    				 "from Draft d "+
    				 "inner join Category c on d.Status=c.FlowKey "+
    				 "where d.Applicant='"+empId+"' and CloseTime='' " +
    				 "order by d.Status";
    	List<Field> dataFields = new ArrayList<Field>();
    	
    	Field LinkPage1 = new Field("LinkPage1",this.getTableName());
    	LinkPage1.setShowFlag(false);
    	dataFields.add(LinkPage1);
    	
    	Field LinkFlowKey1 = new Field("LinkFlowKey1",this.getTableName());
    	LinkFlowKey1.setAliasName(userInfo.getMsg("jsp.Draft.FlowKey"));
    	LinkFlowKey1.setLinkFlag1(true);
    	LinkFlowKey1.setLinkMode1(Cnstnts.HREF);
    	LinkFlowKey1.setLinkParameter1("&linkMode=href");
    	LinkFlowKey1.setDbActionMode1(Cnstnts.QUERY);
    	LinkFlowKey1.setListWidth("10%");
    	dataFields.add(LinkFlowKey1);
    	
    	Field DraftNo = new Field("DraftNo","Draft");
    	DraftNo.setListWidth("10%");
    	dataFields.add(DraftNo);
    	
    	Field Title = new Field("Title","Draft");
    	Title.setListWidth("50%");
    	dataFields.add(Title);
    	
    	Field ApplyDate = new Field("ApplyDate","Draft");
    	ApplyDate.setListWidth("15%");
    	ApplyDate.setAlign(Cnstnts.CENTER);
    	dataFields.add(ApplyDate);
    	
    	Field Status = new Field("Status","Draft");
    	Status.setListWidth("15%");
    	Status.setAlign(Cnstnts.CENTER);
    	dataFields.add(Status);
    	
    	return this.getDbUtil().getFieldsList(SQL, dataFields);
    }
    
    public List<List<Field>> getRelationList(String empId, UserBean userInfo) throws Exception{
    	String SQL = "select 'Draft' as LinkPage1, d.FlowKey as LinkFlowKey1, "+
    						 "d.Title, d.ApplyDate, d.DraftNo, c.Names as Status "+
    				 "from Draft d "+
    				 "inner join Category c on d.Status=c.FlowKey "+
    				 "where d.FlowKey in(select ParentId from DraftInventor " +
    				 					"where InventorId='"+empId+"') " +
    				 "order by d.Status";
    	List<Field> dataFields = new ArrayList<Field>();
    	
    	Field LinkPage1 = new Field("LinkPage1",this.getTableName());
    	LinkPage1.setShowFlag(false);
    	dataFields.add(LinkPage1);
    	
    	Field LinkFlowKey1 = new Field("LinkFlowKey1",this.getTableName());
    	LinkFlowKey1.setAliasName(userInfo.getMsg("jsp.Draft.FlowKey"));
    	LinkFlowKey1.setLinkFlag1(true);
    	LinkFlowKey1.setLinkMode1(Cnstnts.OPEN_APPENDIX);
    	LinkFlowKey1.setLinkParameter1("&linkMode=openAppendix&modeLockFlag=true");
    	LinkFlowKey1.setDbActionMode1(Cnstnts.QUERY);
    	LinkFlowKey1.setListWidth("15%");
    	LinkFlowKey1.setAlign(Cnstnts.CENTER);
    	dataFields.add(LinkFlowKey1);
    	
    	Field DraftNo = new Field("DraftNo","Draft");
    	DraftNo.setListWidth("15%");
    	DraftNo.setAlign(Cnstnts.CENTER);
    	dataFields.add(DraftNo);
    	
    	Field Title = new Field("Title","Draft");
    	Title.setListWidth("40%");
    	dataFields.add(Title);
    	
    	Field ApplyDate = new Field("ApplyDate","Draft");
    	ApplyDate.setListWidth("15%");
    	ApplyDate.setAlign(Cnstnts.CENTER);
    	dataFields.add(ApplyDate);
    	
    	Field Status = new Field("Status","Draft");
    	Status.setListWidth("15%");
    	Status.setAlign(Cnstnts.CENTER);
    	dataFields.add(Status);
    	
    	return this.getDbUtil().getFieldsList(SQL, dataFields);
    }
    
    public List<List<Field>> getExamineList(String empId, UserBean userInfo) throws Exception{
    	String SQL = "select 'Draft' as LinkPage1, d.FlowKey as LinkFlowKey1, "+
    						"d.ApplicantName, d.Title, d.ApplyDate, d.DraftNo, c.Names as Status "+
    				 "from Draft d "+
    				 "inner join Category c on d.Status=c.FlowKey "+
    				 "where (Status='DS02' or Status='DS03' or Status='DS05' or Status='DS06') " +
    				   "and CloseTime='' " +
    				   "and '"+empId+"' in(select Emp_id from Groups_detail where FlowKey='G01')" +
    				 "order by d.Status";
    	
    	List<Field> dataFields = new ArrayList<Field>();
    	Field LinkPage1 = new Field("LinkPage1",this.getTableName());
    	LinkPage1.setShowFlag(false);
    	dataFields.add(LinkPage1);
    	
    	Field LinkFlowKey1 = new Field("LinkFlowKey1",this.getTableName());
    	LinkFlowKey1.setAliasName(userInfo.getMsg("jsp.Draft.FlowKey"));
    	LinkFlowKey1.setLinkFlag1(true);
    	LinkFlowKey1.setLinkMode1(Cnstnts.HREF);
    	LinkFlowKey1.setLinkParameter1("&linkMode=href");
    	LinkFlowKey1.setDbActionMode1(Cnstnts.QUERY);
    	LinkFlowKey1.setListWidth("10%");
    	dataFields.add(LinkFlowKey1);
    	
    	Field DraftNo = new Field("DraftNo","Draft");
    	DraftNo.setListWidth("10%");
    	dataFields.add(DraftNo);
    	
    	Field ApplyDate = new Field("ApplyDate","Draft");
    	ApplyDate.setAlign(Cnstnts.CENTER);
    	ApplyDate.setListWidth("10%");
    	dataFields.add(ApplyDate);
    	
    	Field ApplicantName = new Field("ApplicantName","Draft");
    	ApplicantName.setAlign(Cnstnts.CENTER);
    	ApplicantName.setListWidth("10%");
    	dataFields.add(ApplicantName);
    	
    	Field Title = new Field("Title","Draft");
    	Title.setListWidth("45%");
    	dataFields.add(Title);
    	
    	Field Status = new Field("Status","Draft");
    	Status.setListWidth("15%");
    	Status.setAlign(Cnstnts.CENTER);
    	dataFields.add(Status);
    	
    	return this.getDbUtil().getFieldsList(SQL, dataFields);
    }

    @SuppressWarnings("unchecked")
	public void doCreatePatentCase() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.setCloseTime(Util.getDateTime());
		this.setCloserName(this.getUserInfo().getAttribute("user_name"));
		String updateSQL = Cnstnts.EMPTY_STRING;
		if(this.getDoNotExamine().equals("Y")
				&& this.getStatus().equals("DS01")){
			updateSQL = ", Status='DS06', ApplyDate='"+Util.getDate()+"' ";
		}
		String SQL = "update Draft set CloseTime='"+Util.getDateTime()+"', " +
				"CloserName='"+this.getUserInfo().getAttribute("user_name")+"' " + updateSQL +
				"where FlowKey='"+this.getFlowKey()+"'";
		sqlList.add(SQL);
		SQL = "select * from DraftInventor " +
		      "where ParentId='"+this.getFlowKey()+"' " +
		      "order by InventorOrder";
		DraftInventor draftInventor = new DraftInventor();
		draftInventor.setDbFields();
		List<List<Field>> inventorList = draftInventor.getDbUtil().getFieldsList(SQL, draftInventor.getDbFields());
		
		SQL = "select * from DraftOffice " +
			  "where ParentId='"+this.getFlowKey()+"' and PatentCaseNo=''";
		DraftOffice office = new DraftOffice();
		office.setDbFields();
		List<List<Field>> officeList = office.getDbUtil().getFieldsList(SQL, office.getDbFields());
		int i=0;
		Properties categoryPrpt = new Category().getNamesPrpts();
		Properties applicantPrpt = new Applicant().getNamesPrpts();
		Properties attorneyPrpt = new Attorney().getNamesPrpts();
		Properties mailAgentPrpt = new Properties();
		for(Iterator itr=officeList.iterator();itr.hasNext();){
			i++;
	        List<Field> detailFieldsLst = (List<Field>)itr.next();
	        String officeName = Cnstnts.EMPTY_STRING;
	        String patentTypeName = Cnstnts.EMPTY_STRING;
	    	for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
	            Field detailField = (Field)fieldsItr.next();
	            if(detailField.getName().equals("FlowKey")){
	            	office.FlowKey.setValue(detailField.getValue());
	            }
	            if(detailField.getName().equals("PatentOffice")){
	            	office.PatentOffice.setValue(detailField.getValue());
	            	officeName = categoryPrpt.getProperty(detailField.getValue());
	            }
	            if(detailField.getName().equals("AgentNo")){
	            	office.AgentNo.setValue(detailField.getValue());
	            }
	            if(detailField.getName().equals("PatentType")){
	            	office.PatentType.setValue(detailField.getValue());
	            	patentTypeName = categoryPrpt.getProperty(detailField.getValue());
	            }
	        }
	    	if(mailAgentPrpt.getProperty(office.getAgentNo())==null){
	    		mailAgentPrpt.setProperty(office.getAgentNo(), 
	    				officeName+" : "+patentTypeName+"<br>");
	    	} else {
	    		mailAgentPrpt.setProperty(office.getAgentNo(), 
	    				mailAgentPrpt.getProperty(office.getAgentNo())+
	    				"&"+officeName+" : "+patentTypeName+"<br>");
	    	}
	    	
	    	PatentCase patentCase = new PatentCase();
	    	patentCase.FlowKey.setValue(this.getFlowKey()+office.getPatentOffice());
	    	patentCase.IdeaId.setValue(this.getFlowKey());
	    	patentCase.FamilyOrder.setValue(i+Cnstnts.EMPTY_STRING);
	    	patentCase.PatentOffice.setValue(office.PatentOffice.getValue());
	    	patentCase.Title.setValue(this.getTitle());
	    	patentCase.OriginalTitle.setValue(this.getOriginalTitle());
	    	patentCase.PatentType.setValue(office.getPatentType());
	    	patentCase.Status.setValue("RS01");
	    	patentCase.CreateDept.setValue(this.getUserInfo().getAttribute("dept_id"));
	    	patentCase.Applicant.setValue(this.getUserInfo().getAttribute("emp_id"));
	    	patentCase.InCharge.setValue(this.getUserInfo().getAttribute("emp_id"));
	    	patentCase.Creator.setValue(this.getUserInfo().getAttribute("user_name"));
	    	patentCase.CreateTime.setValue(Util.getDateTime());
	    	patentCase.ProjectCode.setValue(this.getProjectNo());
	    	patentCase.setDbFields();
	    	sqlList.add(patentCase.getDbUtil().getInsertSQL(patentCase.getTableName(), patentCase.getDbFields()));
	    	
	    	SQL = "update DraftOffice set PatentCaseNo='"+patentCase.getFlowKey()+"' " +
  		  		  "where Flowkey='"+office.getFlowKey()+"'";
	    	sqlList.add(SQL);
	    	
	    	PatentApplicant patentApplicant = new PatentApplicant();
	    	patentApplicant.FlowKey.setValue(patentCase.getFlowKey());
	    	patentApplicant.Applicant.setValue(this.getUserInfo().getAttribute("emp_id"));
	    	patentApplicant.CreateDept.setValue(this.getUserInfo().getAttribute("dept_id"));
	    	patentApplicant.ApplicantId.setValue("A01");
	    	patentApplicant.ApplicantName.setValue(applicantPrpt.getProperty("A01"));
	    	patentApplicant.ParentId.setValue(patentCase.getFlowKey());
	    	patentApplicant.ApplicantOrder.setValue("1");
	    	patentApplicant.setDbFields();
	    	sqlList.add(patentApplicant.getDbUtil().getInsertSQL(patentApplicant.getTableName(), patentApplicant.getDbFields()));
	    	
	    	int j=0;
	    	for(Iterator inventorItr=inventorList.iterator();inventorItr.hasNext();){
				j++;
		        List<Field> fieldsLst = (List<Field>)inventorItr.next();
		        DraftInventor inventor = new DraftInventor();
		    	for(Iterator fieldsItr=fieldsLst.iterator(); fieldsItr.hasNext();){
		            Field detailField = (Field)fieldsItr.next();
		            if(detailField.getName().equals("FlowKey")){
		            	inventor.FlowKey.setValue(detailField.getValue());
		            }
		            if(detailField.getName().equals("InventorId")){
		            	inventor.InventorId.setValue(detailField.getValue());
		            }
		            if(detailField.getName().equals("ChineseName")){
		            	inventor.ChineseName.setValue(detailField.getValue());
		            }
		        }
		    	PatentInventor patentInventor = new PatentInventor();
		    	patentInventor.FlowKey.setValue(Util.getNo(patentCase.getFlowKey(), 2));
		    	patentInventor.CreateDept.setValue(this.getUserInfo().getAttribute("dept_id"));
		    	patentInventor.Applicant.setValue(this.getUserInfo().getAttribute("emp_id"));
		    	patentInventor.ParentId.setValue(patentCase.getFlowKey());
		    	patentInventor.Inventor.setValue(inventor.getInventorId());
		    	patentInventor.InventorName.setValue(inventor.getChineseName());
		    	patentInventor.InventorOrder.setValue(j+Cnstnts.EMPTY_STRING);
		    	patentInventor.InventorType.setValue("IT01");
		    	patentInventor.setDbFields();
		    	sqlList.add(patentInventor.getDbUtil().getInsertSQL(patentInventor.getTableName(), patentInventor.getDbFields()));
	    	}
	    	PatentAttorney patentAttorney = new PatentAttorney();
	    	patentAttorney.FlowKey.setValue(patentCase.getFlowKey());
	    	patentAttorney.CreateDept.setValue(this.getUserInfo().getAttribute("dept_id"));
	    	patentAttorney.Applicant.setValue(this.getUserInfo().getAttribute("emp_id"));
	    	patentAttorney.Attorney.setValue(office.getAgentNo());
	    	patentAttorney.AttorneyName.setValue(attorneyPrpt.getProperty(office.getAgentNo()));
	    	patentAttorney.AttorneyType.setValue("An01");
	    	patentAttorney.ParentId.setValue(patentCase.getFlowKey());
	    	patentAttorney.setDbFields();
	    	sqlList.add(patentAttorney.getDbUtil().getInsertSQL(patentAttorney.getTableName(), patentAttorney.getDbFields()));
	    }
		if(mailAgentPrpt.size()>0){
			Employee thisApplicant = new Employee(this.getApplicant());
			String thisApplicantData = 
				this.getUserInfo().getMsg("jsp.Employee.Emp_name")+":"+thisApplicant.getEmp_name()+"<br>"+
				this.getUserInfo().getMsg("jsp.Employee.Tel_no")+":"+thisApplicant.getTel_no()+"<br>"+
				this.getUserInfo().getMsg("jsp.Employee.Email")+":"+thisApplicant.getEmail();
			Vector mailDataVtr = new Vector();
			SQL = "select * from Category where ParentId='PatentOffice'";
			Properties officePrpt = this.getDbUtil().getFieldPrpts(SQL, "Names");
			for(Iterator itr=mailAgentPrpt.keySet().iterator();itr.hasNext();){
				String agentNo = (String)itr.next();
				String[] officeNo = mailAgentPrpt.getProperty(agentNo).split("&");
				String patentOfficeText = Cnstnts.EMPTY_STRING;
				for(i=0;i<officeNo.length;i++){
					String officeName = officePrpt.getProperty(officeNo[i]);
					if(officeName==null){
						officeName = officeNo[i];
					}
					if(patentOfficeText.trim().length()==0){
						patentOfficeText = officeName;
					} else {
						patentOfficeText += "<br>"+officeName;
					}
				}
				Attorney agent = new Attorney(agentNo);
				if(agent.getEmail().trim().length()>0){
					String mailTitle = this.getUserInfo().getMsg("jsp.Draft.Mail.Title");
					String mailContent = 
						"TO: "+agent.getFirm()+"<br>"+
						"FROM: "+this.getUserInfo().getMsg("jsp.Draft.Mail.Content.01")+"<br><br>"+
						this.getUserInfo().getMsg("jsp.Draft.Mail.Content.02")+agent.getFirm()+
						this.getUserInfo().getMsg("jsp.Draft.Mail.Content.03")+"("+Util.getDate()+")<br>"+
						"<table border=1>" +
						"<tr><th>"+this.getUserInfo().getMsg("jsp.Draft.Mail.Content.table.th01")+"</th>" +
							"<th>"+this.getUserInfo().getMsg("jsp.Draft.Mail.Content.table.th02")+"</th>" +
							"<th>"+this.getUserInfo().getMsg("jsp.Draft.Mail.Content.table.th03")+"</th>" +
							"<th>"+this.getUserInfo().getMsg("jsp.Draft.Mail.Content.table.th04")+"</th>" +
							"<th>"+this.getUserInfo().getMsg("jsp.Draft.Mail.Content.table.th05")+"</th></tr>" +
						"<tr><td>"+this.getTitle()+"</td><td colspan=2>"+patentOfficeText+"</td>" +
							"<td>"+thisApplicantData+"</td><td>AM8:00~PM18:00</td></tr>" +
						"</table>";
					MailThreadConfig_detail mailData = new MailThreadConfig_detail();
					mailData.setSourceTableName("Draft.doCreatePatentCase");
					mailData.setPKey(Util.getNo("DfMail"+Util.getDayOfYear(),2));
					mailData.setCCTo(thisApplicant.getEmail());
					mailData.setTitle(mailTitle);
					mailData.setMailTime(Util.getDateTime());
					mailData.setContent(mailContent);
					mailData.setMailTo(agent.getEmail());
					mailDataVtr.add(mailData);
				}
			}
			new MailThreadConfig_detail().insert(Cnstnts.EMPTY_STRING,mailDataVtr.iterator());
		}
		if(this.getDbUtil().executeUpdate(sqlList)){
			this.logStatus();
		}
	}

}