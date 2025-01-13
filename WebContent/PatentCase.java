package deepspot.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.athenasoft.ooutil.OoConverter;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.HiddenTag;
import deepspot.html.SelectOneTag;
import deepspot.util.Util;

public class PatentCase extends MasterBean {

    public PatentCase(){this.init();}

    public PatentCase(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field CaseStartDate;
    public void setCaseStartDate(String CaseStartDate){this.CaseStartDate.setValue(CaseStartDate);}
    public String getCaseStartDate(){return this.CaseStartDate.getValue();}

    public Field CreateTime;
    public void setCreateTime(String CreateTime){this.CreateTime.setValue(CreateTime);}
    public String getCreateTime(){return this.CreateTime.getValue();}

    public Field Summary;
    public void setSummary(String Summary){this.Summary.setValue(Summary);}
    public String getSummary(){return this.Summary.getValue();}
    
    public Field CaseType;
    public void setCaseType(String CaseType){this.CaseType.setValue(CaseType);}
    public String getCaseType(){return this.CaseType.getValue();}

    public Field IdeaId;
    public void setIdeaId(String IdeaId){this.IdeaId.setValue(IdeaId);}
    public String getIdeaId(){return this.IdeaId.getValue();}

    public Field FamilyOrder;
    public void setFamilyOrder(String FamilyOrder){this.FamilyOrder.setValue(FamilyOrder);}
    public String getFamilyOrder(){return this.FamilyOrder.getValue();}
    
    public Field Client;
    public void setClient(String Client){this.Client.setValue(Client);}
    public String getClient(){return this.Client.getValue();}
    
    public Field ClientName;
    public void setClientName(String ClientName){this.ClientName.setValue(ClientName);}
    public String getClientName(){return this.ClientName.getValue();}

    public Field PatentOffice;
    public void setPatentOffice(String PatentOffice){this.PatentOffice.setValue(PatentOffice);}
    public String getPatentOffice(){return this.PatentOffice.getValue();}

    public Field PatentType;
    public void setPatentType(String PatentType){this.PatentType.setValue(PatentType);}
    public String getPatentType(){return this.PatentType.getValue();}

    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}

    public Field OriginalTitle;
    public void setOriginalTitle(String OriginalTitle){this.OriginalTitle.setValue(OriginalTitle);}
    public String getOriginalTitle(){return this.OriginalTitle.getValue();}

    public Field ApplyDate;
    public void setApplyDate(String ApplyDate){this.ApplyDate.setValue(ApplyDate);}
    public String getApplyDate(){return this.ApplyDate.getValue();}

    public Field ApplyNo;
    public void setApplyNo(String ApplyNo){this.ApplyNo.setValue(ApplyNo);}
    public String getApplyNo(){return this.ApplyNo.getValue();}

    public Field PublishDate;
    public void setPublishDate(String PublishDate){this.PublishDate.setValue(PublishDate);}
    public String getPublishDate(){return this.PublishDate.getValue();}

    public Field PublishNo;
    public void setPublishNo(String PublishNo){this.PublishNo.setValue(PublishNo);}
    public String getPublishNo(){return this.PublishNo.getValue();}
    
    public Field IssueDate;
    public void setIssueDate(String IssueDate){this.IssueDate.setValue(IssueDate);}
    public String getIssueDate(){return this.IssueDate.getValue();}

    public Field IssueNo;
    public void setIssueNo(String IssueNo){this.IssueNo.setValue(IssueNo);}
    public String getIssueNo(){return this.IssueNo.getValue();}
    
    public Field LicenseDate;
    public void setLicenseDate(String LicenseDate){this.LicenseDate.setValue(LicenseDate);}
    public String getLicenseDate(){return this.LicenseDate.getValue();}

    public Field LicenseNo;
    public void setLicenseNo(String LicenseNo){this.LicenseNo.setValue(LicenseNo);}
    public String getLicenseNo(){return this.LicenseNo.getValue();}
    
    public Field FeeScheduleDate;
    public void setFeeScheduleDate(String FeeScheduleDate){
    	this.FeeScheduleDate.setValue(FeeScheduleDate);
    }
    public String getFeeScheduleDate(){return this.FeeScheduleDate.getValue();}
    
    public Field FeeScheduleDateTo;
    public void setFeeScheduleDateTo(String FeeScheduleDateTo){
    	this.FeeScheduleDateTo.setValue(FeeScheduleDateTo);
    }
    public String getFeeScheduleDateTo(){return this.FeeScheduleDateTo.getValue();}

    public Field FeeSchedule;
    public void setFeeSchedule(String FeeSchedule){this.FeeSchedule.setValue(FeeSchedule);}
    public String getFeeSchedule(){return this.FeeSchedule.getValue();}

    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}

    public Field GiveupCode;
    public void setGiveupCode(String GiveupCode){this.GiveupCode.setValue(GiveupCode);}
    public String getGiveupCode(){return this.GiveupCode.getValue();}

    public Field InCharge;
    public void setInCharge(String InCharge){this.InCharge.setValue(InCharge);}
    public String getInCharge(){return this.InCharge.getValue();}

    public Field OutsourceDate;
    public void setOutsourceDate(String OutsourceDate){this.OutsourceDate.setValue(OutsourceDate);}
    public String getOutsourceDate(){return this.OutsourceDate.getValue();}
    
    public Field SignOutId;
    public void setSignOutId(String SignOutId){this.SignOutId.setValue(SignOutId);}
    public String getSignOutId(){return this.SignOutId.getValue();}
    
    public Field SignOutName;
    public void setSignOutName(String SignOutName){this.SignOutName.setValue(SignOutName);}
    public String getSignOutName(){return this.SignOutName.getValue();}
    
    public Field SignOutTime;
    public void setSignOutTime(String SignOutTime){this.SignOutTime.setValue(SignOutTime);}
    public String getSignOutTime(){return this.SignOutTime.getValue();}
    
    public Field UpdateTime;
    public void setUpdateTime(String UpdateTime){this.UpdateTime.setValue(UpdateTime);}
    public String getUpdateTime(){return this.UpdateTime.getValue();}
    
    public Field Updater;
    public void setUpdater(String Updater){this.Updater.setValue(Updater);}
    public String getUpdater(){return this.Updater.getValue();}
    
    public Field Creator;
    public void setCreator(String Creator){this.Creator.setValue(Creator);}
    public String getCreator(){return this.Creator.getValue();}
    
    public Field ProjectCode;
    public void setProjectCode(String ProjectCode){this.ProjectCode.setValue(ProjectCode);}
    public String getProjectCode(){return this.ProjectCode.getValue();}
    
    public Field Keyword;
    public void setKeyword(String Keyword){this.Keyword.setValue(Keyword);}
    public String getKeyword(){return this.Keyword.getValue();}
    
    public Field TechCategory;
    public void setTechCategory(String TechCategory){this.TechCategory.setValue(TechCategory);}
    public String getTechCategory(){return this.TechCategory.getValue();}
    
    public Field FuncCategory;
    public void setFuncCategory(String FuncCategory){this.FuncCategory.setValue(FuncCategory);}
    public String getFuncCategory(){return this.FuncCategory.getValue();}
    
    public Field Ipc;
    public void setIpc(String Ipc){this.Ipc.setValue(Ipc);}
    public String getIpc(){return this.Ipc.getValue();}
    
    public Field Uspc;
    public void setUspc(String Uspc){this.Uspc.setValue(Uspc);}
    public String getUspc(){return this.Uspc.getValue();}
    
    public Field Fi;
    public void setFi(String Fi){this.Fi.setValue(Fi);}
    public String getFi(){return this.Fi.getValue();}
    
    public Field Locarno;
    public void setLocarno(String Locarno){this.Locarno.setValue(Locarno);}
    public String getLocarno(){return this.Locarno.getValue();}
    
    public Field Gattezz;
    public void setGattezz(String Gattezz){this.Gattezz.setValue(Gattezz);}
    public String getGattezz(){return this.Gattezz.getValue();}
    
    public Field ExamineDate;
    public void setExamineDate(String ExamineDate){this.ExamineDate.setValue(ExamineDate);}
    public String getExamineDate(){return this.ExamineDate.getValue();}
    
    public Field ExamineDueDate;
    public void setExamineDueDate(String ExamineDueDate){this.ExamineDueDate.setValue(ExamineDueDate);}
    public String getExamineDueDate(){return this.ExamineDueDate.getValue();}
    
    public Field TechReportApply;
    public void setTechReportApply(String TechReportApply){this.TechReportApply.setValue(TechReportApply);}
    public String getTechReportApply(){return this.TechReportApply.getValue();}
    
    public Field IndependentClaim;
    public void setIndependentClaim(String IndependentClaim){this.IndependentClaim.setValue(IndependentClaim);}
    public String getIndependentClaim(){return this.IndependentClaim.getValue();}
    
    public Field DependentClaim;
    public void setDependentClaim(String DependentClaim){this.DependentClaim.setValue(DependentClaim);}
    public String getDependentClaim(){return this.DependentClaim.getValue();}
    
    public Field Drawing;
    public void setDrawing(String Drawing){this.Drawing.setValue(Drawing);}
    public String getDrawing(){return this.Drawing.getValue();}
    
    public Field TotalPage;
    public void setTotalPage(String TotalPage){this.TotalPage.setValue(TotalPage);}
    public String getTotalPage(){return this.TotalPage.getValue();}
    
    public Field RightBeginDate;
    public void setRightBeginDate(String RightBeginDate){this.RightBeginDate.setValue(RightBeginDate);}
    public String getRightBeginDate(){return this.RightBeginDate.getValue();}
    
    public Field RightEndDate;
    public void setRightEndDate(String RightEndDate){this.RightEndDate.setValue(RightEndDate);}
    public String getRightEndDate(){return this.RightEndDate.getValue();}
    
    public Field PctAppDate;
    public void setPctAppDate(String PctAppDate){this.PctAppDate.setValue(PctAppDate);}
    public String getPctAppDate(){return this.PctAppDate.getValue();}
    
    public Field PctAppNo;
    public void setPctAppNo(String PctAppNo){this.PctAppNo.setValue(PctAppNo);}
    public String getPctAppNo(){return this.PctAppNo.getValue();}
    
    public Field PctPublishDate;
    public void setPctPublishDate(String PctPublishDate){this.PctPublishDate.setValue(PctPublishDate);}
    public String getPctPublishDate(){return this.PctPublishDate.getValue();}
    
    public Field WipoNo;
    public void setWipoNo(String WipoNo){this.WipoNo.setValue(WipoNo);}
    public String getWipoNo(){return this.WipoNo.getValue();}
    
    public Field NationalPhaseDate;
    public void setNationalPhaseDate(String NationalPhaseDate){this.NationalPhaseDate.setValue(NationalPhaseDate);}
    public String getNationalPhaseDate(){return this.NationalPhaseDate.getValue();}
    
    public Field TabText;
    public void setTabText(String TabText){this.TabText.setValue(TabText);}
    public String getTabText(){return this.TabText.getValue();}
    
    public Field NotFinished;
    public void setNotNotFinished(String NotFinished){this.NotFinished.setValue(NotFinished);}
    public String getNotNotFinished(){return this.NotFinished.getValue();}
    
    public String SignOutFlag;
    public void setSignOutFlag(String SignOutFlag){this.SignOutFlag=SignOutFlag;}
    public String getSignOutFlag(){return this.SignOutFlag;}

    public void init() {
        super.init();
        this.setProgramId("jsp.PatentCase");
        this.setTableName("PatentCase");
        
        this.FlowKey.setSearchCondition(Cnstnts.LIKE);
        
        this.CaseStartDate= new Field("CaseStartDate",this.getTableName());
        this.CaseStartDate.setDbType("varchar(20)");
        
        this.CreateTime = new Field("CreateTime", this.getTableName());
        this.CreateTime.setDbType("varchar(20)");

        this.Summary = new Field("Summary", this.getTableName());
        this.Summary.setDbType("nvarchar(200)");

        this.IdeaId = new Field("IdeaId", this.getTableName());
        this.IdeaId.setDbType("varchar(50)");

        this.FamilyOrder = new Field("FamilyOrder", this.getTableName());
        this.FamilyOrder.setDbType("varchar(50)");
        
        this.Client = new Field("Client", this.getTableName());
        this.Client.setDbType("varchar(50)");
        this.Client.setCheckEmpty(true);
        this.Client.setSearchCondition(Cnstnts.LIKE);
        
        this.ClientName = new Field("ClientName", this.getTableName());
        this.ClientName.setSearchCondition(Cnstnts.LIKE);
        this.NotFinished = new Field("NotFinished", this.getTableName());

        this.PatentOffice = new Field("PatentOffice", this.getTableName());
        this.PatentOffice.setDbType("varchar(50)");

        this.PatentType = new Field("PatentType", this.getTableName());
        this.PatentType.setDbType("varchar(50)");

        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("nvarchar(500)");
        this.Title.setCheckEmpty(true);
        this.Title.setSearchCondition(Cnstnts.LIKE);

        this.OriginalTitle = new Field("OriginalTitle", this.getTableName());
        this.OriginalTitle.setDbType("nvarchar(500)");

        this.ApplyDate = new Field("ApplyDate", this.getTableName());
        this.ApplyDate.setDbType("varchar(10)");

        this.ApplyNo = new Field("ApplyNo", this.getTableName());
        this.ApplyNo.setDbType("varchar(50)");
        this.ApplyNo.setSearchCondition(Cnstnts.LIKE);
        this.PublishDate = new Field("PublishDate", this.getTableName());
        this.PublishDate.setDbType("varchar(10)");

        this.PublishNo = new Field("PublishNo", this.getTableName());
        this.PublishNo.setDbType("varchar(50)");
        
        this.IssueDate = new Field("IssueDate", this.getTableName());
        this.IssueDate.setDbType("varchar(10)");

        this.IssueNo = new Field("IssueNo", this.getTableName());
        this.IssueNo.setDbType("varchar(50)");
        
        
        this.LicenseDate = new Field("LicenseDate", this.getTableName());
        this.LicenseDate.setDbType("varchar(10)");

        this.LicenseNo = new Field("LicenseNo", this.getTableName());
        this.LicenseNo.setDbType("varchar(50)");
        this.LicenseNo.setSearchCondition(Cnstnts.LIKE);

        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");

        this.GiveupCode = new Field("GiveupCode", this.getTableName());
        this.GiveupCode.setDbType("varchar(50)");

        this.InCharge = new Field("InCharge", this.getTableName());
        this.InCharge.setDbType("varchar(50)");

        this.OutsourceDate = new Field("OutsourceDate", this.getTableName());
        this.OutsourceDate.setDbType("varchar(10)");
        
        this.FeeScheduleDate = new Field("FeeScheduleDate", this.getTableName());
        this.FeeScheduleDate.setDbType("varchar(10)");
        
        this.FeeScheduleDateTo = new Field("FeeScheduleDateTo", this.getTableName());
        
        this.FeeSchedule = new Field("FeeSchedule", this.getTableName());
        this.FeeSchedule.setDbType("varchar(50)");
        
        this.SignOutId = new Field("SignOutId", this.getTableName());
        this.SignOutId.setDbType("varchar(50)");
        
        this.SignOutTime = new Field("SignOutTime", this.getTableName());
        this.SignOutTime.setDbType("varchar(20)");
        
        this.SignOutName = new Field("SignOutName", this.getTableName());
        this.SignOutName.setDbType("nvarchar(50)");
        
        this.UpdateTime = new Field("UpdateTime", this.getTableName());
        this.UpdateTime.setDbType("varchar(20)");
        
        this.Updater = new Field("Updater", this.getTableName());
        this.Updater.setDbType("varchar(50)");
        
        this.Creator = new Field("Creator", this.getTableName());
        this.Creator.setDbType("nvarchar(50)");
        
        this.ProjectCode = new Field("ProjectCode", this.getTableName());
        this.ProjectCode.setDbType("nvarchar(50)");
        
        this.Keyword = new Field("Keyword", this.getTableName());
        this.Keyword.setDbType("nvarchar(50)");
        
        this.TechCategory = new Field("TechCategory", this.getTableName());
        this.TechCategory.setDbType("nvarchar(50)");
        
        this.FuncCategory = new Field("FuncCategory", this.getTableName());
        this.FuncCategory.setDbType("nvarchar(50)");
        
        this.Ipc = new Field("Ipc", this.getTableName());
        this.Ipc.setDbType("nvarchar(50)");
        
        this.Uspc = new Field("Uspc", this.getTableName());
        this.Uspc.setDbType("nvarchar(50)");
        
        this.Fi = new Field("Fi", this.getTableName());
        this.Fi.setDbType("nvarchar(50)");
        
        this.Locarno = new Field("Locarno", this.getTableName());
        this.Locarno.setDbType("nvarchar(50)");
        
        this.Gattezz = new Field("Gattezz", this.getTableName());
        this.Gattezz.setDbType("nvarchar(50)");
        
        this.ExamineDate = new Field("ExamineDate", this.getTableName());
        this.ExamineDate.setDbType("nvarchar(10)");
        
        this.ExamineDueDate = new Field("ExamineDueDate", this.getTableName());
        this.ExamineDueDate.setDbType("nvarchar(10)");
        
        this.TechReportApply = new Field("TechReportApply", this.getTableName());
        this.TechReportApply.setDbType("char(1)");
        
        this.IndependentClaim = new Field("IndependentClaim", this.getTableName());
        this.IndependentClaim.setDbType("int");
        
        this.DependentClaim = new Field("DependentClaim", this.getTableName());
        this.DependentClaim.setDbType("int");
        
        this.Drawing = new Field("Drawing", this.getTableName());
        this.Drawing.setDbType("int");
        
        this.TotalPage = new Field("TotalPage", this.getTableName());
        this.TotalPage.setDbType("int");
        
        this.RightBeginDate = new Field("RightBeginDate", this.getTableName());
        this.RightBeginDate.setDbType("nvarchar(10)");
        
        this.RightEndDate = new Field("RightEndDate", this.getTableName());
        this.RightEndDate.setDbType("nvarchar(10)");
        
        this.PctAppDate = new Field("PctAppDate", this.getTableName());
        this.PctAppDate.setDbType("nvarchar(10)");
        
        this.PctAppNo = new Field("PctAppNo", this.getTableName());
        this.PctAppNo.setDbType("nvarchar(50)");
        
        this.PctPublishDate = new Field("PctPublishDate", this.getTableName());
        this.PctPublishDate.setDbType("nvarchar(10)");
        
        this.WipoNo = new Field("WipoNo", this.getTableName());
        this.WipoNo.setDbType("nvarchar(50)");
        
        this.NationalPhaseDate = new Field("NationalPhaseDate", this.getTableName());
        this.NationalPhaseDate.setDbType("nvarchar(10)");
        
        this.TabText = new Field("TabText", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    private List<List<Field>> InventorDetails;
    
    public void setInventorDetails(ArrayList<List<Field>> Details) {
    	this.InventorDetails = Details;
	}
    
    public List<List<Field>> getInventorDetails(String FlowKey) {
		return null;
	}
    
    public List<List<Field>> getInventorDetails() {
    	return this.InventorDetails;
	}

	public void setDbFields() {
        super.setDbFields();
        
        this.DbFields.add(this.CaseStartDate);
        
        this.DbFields.add(this.CreateTime);

        this.DbFields.add(this.Summary);

        this.DbFields.add(this.IdeaId);

        this.DbFields.add(this.FamilyOrder);
        
        this.DbFields.add(this.Client);

        this.DbFields.add(this.PatentOffice);

        this.DbFields.add(this.PatentType);

        this.DbFields.add(this.Title);

        this.DbFields.add(this.OriginalTitle);

        this.DbFields.add(this.ApplyDate);

        this.DbFields.add(this.ApplyNo);

        this.DbFields.add(this.PublishDate);

        this.DbFields.add(this.PublishNo);
        
        this.DbFields.add(this.IssueDate);

        this.DbFields.add(this.IssueNo);
        
        this.DbFields.add(this.LicenseDate);
        
        this.DbFields.add(this.LicenseNo);

        this.DbFields.add(this.Status);
        
        this.DbFields.add(this.FeeScheduleDate);
        
        this.DbFields.add(this.FeeSchedule);

        this.DbFields.add(this.GiveupCode);

        this.DbFields.add(this.InCharge);

        this.DbFields.add(this.OutsourceDate);
        
        this.DbFields.add(this.SignOutId);
        
        this.DbFields.add(this.SignOutName);
        
        this.DbFields.add(this.SignOutTime);
        
        this.DbFields.add(this.UpdateTime);
        
        this.DbFields.add(this.Updater);
        
        this.DbFields.add(this.Creator);
        
        this.DbFields.add(this.ProjectCode);
        
        this.DbFields.add(this.Keyword);
        
        this.DbFields.add(this.TechCategory);
        
        this.DbFields.add(this.FuncCategory);
        
        this.DbFields.add(this.Ipc);
        
        this.DbFields.add(this.Uspc);
        
        this.DbFields.add(this.Fi);
        
        this.DbFields.add(this.Locarno);
        
        this.DbFields.add(this.Gattezz);
        
        this.DbFields.add(this.ExamineDate);
        
        this.DbFields.add(this.ExamineDueDate);
        
        this.DbFields.add(this.TechReportApply);
        
        this.DbFields.add(this.IndependentClaim);
        
        this.DbFields.add(this.DependentClaim);
        
        this.DbFields.add(this.Drawing);
        
        this.DbFields.add(this.TotalPage);
        
        this.DbFields.add(this.RightBeginDate);
        
        this.DbFields.add(this.RightEndDate);
        
        this.DbFields.add(this.PctAppDate);
        
        this.DbFields.add(this.PctAppNo);
        
        this.DbFields.add(this.PctPublishDate);
        
        this.DbFields.add(this.WipoNo);
        
        this.DbFields.add(this.NationalPhaseDate);
    }
	
	protected String getDbActionSelectItem() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;

		if ((Cnstnts.TRUE_FLAG.equals(this.getModeLockFlag()) 
				&& !this.getProgramMode().equals("M"))
					|| (Cnstnts.MAINTAIN.equals(this.getPageActionMode()) 
						&& (Cnstnts.SIGN.equals(this.getDbActionMode())
							|| Cnstnts.CLOSE.equals(this.getDbActionMode()) 
								|| Cnstnts.ENDING.equals(this.getDbActionMode())))
									|| Cnstnts.SEARCH.equals(this.getPageActionMode())) {
			rtnString = new HiddenTag("dbActionMode", this.getDbActionMode()).toString();
			return rtnString;
		}
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())
				&& this.getDbActionList() == null) {
			this.setDbActionList(getUserInfo().getDbActionList(this.getProgramId()));
		}

		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())){
			String onChange = "doAjaxRequest(\"PatentCase\",\"dbActionMode\",\"dbActionMode\",\"bodyDiv\",\"innerHTML\")";
			SelectOneTag selectItem = new SelectOneTag(Cnstnts.DB_ACTION_MODE,
					onChange, this.getDbActionMode(), this.getDbActionList());

			rtnString = selectItem.toString();
		}
		return rtnString;
	}

    
    public String printHiddenTags(){
    	String rtnString = super.printHiddenTags();
    	HashMap<String,String> hm = new HashMap<String,String>();
    	hm.put("signOutFlag",Cnstnts.EMPTY_STRING);
  	  	rtnString += new HiddenTag().print(hm);
  	  	return rtnString;
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	
        	  this.LicenseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
              
              this.ApplyNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
              this.ApplyNo.setAnotherField(this.LicenseNo);
              rtnString += this.printHtml(this.ApplyNo);
        	
        	this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("RightStatus"));
            
        	this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Title.setSize(20);
        	this.Title.setAnotherField(this.Status);
            rtnString += this.printHtml(this.Title);
            
            this.PatentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentType.setSelectList(new Category().getChildList(this.PatentType));

            this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentOffice.setSelectList(new Category().getChildList(this.PatentOffice));
            this.PatentOffice.setAnotherField(this.PatentType);
            rtnString += this.printHtml(this.PatentOffice);
            
            this.InCharge.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.InCharge.setSelectList(new Employee().getList());
            
            this.ClientName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ClientName.setAnotherField(this.InCharge);
            
            this.Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Client.setAnotherField(this.ClientName);
            rtnString += this.printHtml(this.Client);
            
          
            
            this.FeeScheduleDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.FeeScheduleDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.FeeScheduleDate.setAnotherField(this.FeeScheduleDateTo);
            
            this.FeeScheduleDateTo.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1"));
            this.FeeScheduleDateTo.setButtonClick("setScheduleDateOne();");
            
            this.FeeScheduleDateTo.setSecondButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2"));
            this.FeeScheduleDateTo.setSecondButtonClick("setScheduleDateTwo();");
            rtnString += this.printHtml(this.FeeScheduleDate);
            
            rtnString +="<Script>"+
            "function setScheduleDateOne(){" +
            "var d = new Date();" +
            "document.getElementById('" + this.FeeScheduleDate.getTagName()+"').value=d.format('yyyy-MM-dd');"+
            "var d2=DateAdd('m',1,d);"+
            "document.getElementById('" + this.FeeScheduleDateTo.getTagName()+"').value=d2.format('yyyy-MM-dd');"+
            "}"+
            "function setScheduleDateTwo(){" +
            "var d = new Date();" +
            "document.getElementById('" + this.FeeScheduleDate.getTagName()+"').value=d.format('yyyy-MM-dd');"+
            "var d2=DateAdd('m',3,d);"+
            "document.getElementById('" + this.FeeScheduleDateTo.getTagName()+"').value=d2.format('yyyy-MM-dd');"+
            "}"+
            "</Script>";
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	
        	
          
            
            String clientName = Cnstnts.EMPTY_STRING;
            if(this.Client.getValue().trim().length()>0){
            	clientName = new Client(this.Client.getValue()).getCompanyName();
            }
            this.ClientName.setValue(clientName);
            this.ClientName.setSize(40);
            this.ClientName.setReadonly(true);
            if(this.canEdit()){
            	if(this.getDbActionMode().equals(Cnstnts.INSERT) 
            			|| (this.getDbActionMode().equals(Cnstnts.UPDATE) 
            					&& this.getUserInfo().getAttribute("emp_id").equals(this.getSignOutId()))){
            		this.ClientName.setButtonValue(this.getUserInfo().getMsg("jsp.Applicant.QueryClient"));
            		this.ClientName.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=Client\",\"Client\",800,600)");
            	}
            }
            
            this.Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Client.setAnotherField(this.ClientName);
            this.Client.setOnChange("setValue()");
            //this.Client.setMapingPrpt(null);
            rtnString += this.printHtml(this.Client);

            this.PatentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentType.setSelectList(new Category().getChildList(this.PatentType));

            this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentOffice.setSelectList(new Category().getChildList(this.PatentOffice));
            this.PatentOffice.setAnotherField(this.PatentType);
            this.PatentOffice.setColspan(1);
            rtnString += this.printHtml(this.PatentOffice);

            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Title.setSize(82);
            rtnString += this.printHtml(this.Title);

            this.OriginalTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.OriginalTitle.setSize(82);
            rtnString += this.printHtml(this.OriginalTitle);

            this.CaseStartDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.IdeaId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            
            this.CaseStartDate.setAnotherField(this.IdeaId);
            this.CaseStartDate.setColspan(1);
            rtnString += this.printHtml(this.CaseStartDate);
            
            this.ApplyNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.ApplyDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ApplyDate.setAnotherField(this.ApplyNo);
            this.ApplyDate.setColspan(1);
            rtnString += this.printHtml(this.ApplyDate);

            this.PublishNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.PublishDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.PublishDate.setAnotherField(this.PublishNo);
            this.PublishDate.setColspan(1);
            rtnString += this.printHtml(this.PublishDate);
            
            this.IssueNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.IssueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.IssueDate.setAnotherField(this.IssueNo);
            if(this.canEdit()){
            	this.IssueDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SameAsPublishInfo"));
            	this.IssueDate.setButtonClick("document.input.issueDate.value=document.input.publishDate.value;"+
            								  "document.input.issueNo.value=document.input.publishNo.value");
            }
            this.IssueDate.setColspan(1);
            rtnString += this.printHtml(this.IssueDate);
            
            this.LicenseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.LicenseDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.LicenseDate.setAnotherField(this.LicenseNo);
            if(this.canEdit()){
            	this.LicenseDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SameAsIssueInfo"));
            	this.LicenseDate.setButtonClick("document.input.licenseDate.value=document.input.issueDate.value;"+
				  								"document.input.licenseNo.value=document.input.issueNo.value");
            }
            this.LicenseDate.setColspan(1);
            rtnString += this.printHtml(this.LicenseDate);
            
            List<SelectItem> feeItems = new ArrayList<SelectItem>();
            feeItems.add(new SelectItem("1","1"));
            feeItems.add(new SelectItem("2","2"));
            feeItems.add(new SelectItem("3","3"));
            feeItems.add(new SelectItem("3.5","3.5"));
            feeItems.add(new SelectItem("4","4"));
            feeItems.add(new SelectItem("5","5"));
            feeItems.add(new SelectItem("6","6"));
            feeItems.add(new SelectItem("7","7"));
            feeItems.add(new SelectItem("7.5","7.5"));
            feeItems.add(new SelectItem("8","8"));
            feeItems.add(new SelectItem("9","9"));
            feeItems.add(new SelectItem("10","10"));
            feeItems.add(new SelectItem("11","11"));
            feeItems.add(new SelectItem("11.5","11.5"));
            feeItems.add(new SelectItem("12","12"));
            
            this.FeeSchedule.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.FeeSchedule.setSelectList(feeItems);
            this.FeeSchedule.setSize(1);

            this.FeeScheduleDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.FeeScheduleDate.setAnotherField(this.FeeSchedule);
            this.FeeScheduleDate.setColspan(1);
            rtnString += this.printHtml(this.FeeScheduleDate);
            
            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("RightStatus"));

            this.InCharge.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.InCharge.setSelectList(new Employee().getList());
            this.InCharge.setAnotherField(this.Status);
            this.InCharge.setColspan(1);
            rtnString += this.printHtml(this.InCharge);
        	
        	this.Updater.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Updater.setReadonly(true);
            
            this.UpdateTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.UpdateTime.setReadonly(true);
            this.UpdateTime.setAnotherField(this.Updater);
            this.UpdateTime.setColspan(1);
            rtnString += this.printHtml(this.UpdateTime);
            
            if(this.getSignOutId().trim().length()>0){
            	this.SignOutName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.SignOutName.setReadonly(true);
                
                this.SignOutTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.SignOutTime.setReadonly(true);
                this.SignOutTime.setAnotherField(this.SignOutName);
                this.SignOutTime.setColspan(1);
                rtnString += this.printHtml(this.SignOutTime);
            } else {
            	rtnString += this.SignOutName.printHiddenTag();
            	rtnString += this.SignOutTime.printHiddenTag();
            }
            
            rtnString += this.SignOutId.printHiddenTag();
            
            rtnString += this.Summary.printHiddenTag();
            
            if(this.TabText.getValue().trim().length()==0){
            	this.TabText.setValue("PatentSecondPage");
            }
            rtnString += this.TabText.printHiddenTag();
            
            if(this.FlowKey.getValue().trim().length()>0){
            	String scriptText = Cnstnts.EMPTY_STRING;
            	String tabDivText = Cnstnts.EMPTY_STRING;
            	String resetBtn = "resetBtn('"+this.getTabText()+"');";   
            	scriptText = "<script>"+resetBtn+
            					"function openToDosTabFrame(jspName,dbActionMode,flowkey,frameHight,para){"+
            					"  var frameWidth=document.getElementById('functionBar').offsetWidth;"+
            					"  var tabFramDiv=document.getElementById('tabDiv');"+
            					"  var srcUrl=jspName+'.jsp?_pageActionMode=maintain&_dbActionMode='+dbActionMode+para;"+
            					"  if(dbActionMode=='insert'){"+
            					"    srcUrl += '&parentId='+flowkey;"+
            					"  } else {"+
            					"    srcUrl += '&_getDataFlag=true&flowKey='+flowkey;"+
            					"  }"+
            					"  document.all.Fram.height=frameHight;" + 
            					"  tabFramDiv.style.display='';" +
            					
            					"  Fram.location.href=srcUrl;" +
            					//"  tabFramDiv.innerHTML=\"<iframe "+
            					//	"src='\"+srcUrl+\"' height='\"+frameHight+\"' width='\"+(frameWidth-10)+\"'></iframe>\";"+
            					"}"+
            					"function openTabFrame(jspName,dbActionMode,flowkey,frameHight){"+
								"  var frameWidth=document.getElementById('functionBar').offsetWidth;"+
								"  var tabFramDiv=document.getElementById('tabDiv');"+
								"  var srcUrl=jspName+'.jsp?_pageActionMode=maintain&_dbActionMode='+dbActionMode;"+
								"  if(dbActionMode=='insert'){"+
								"    srcUrl += '&parentId='+flowkey;"+
								"  } else {"+
								"    srcUrl += '&_getDataFlag=true&flowKey='+flowkey;"+
								"  }"+
								"  tabFramDiv.style.display='';" +
								"  tabFramDiv.innerHTML=\"<iframe id='Fram' "+
									"src='\"+srcUrl+\"' height='\"+frameHight+\"' width='\"+(frameWidth-10)+\"'></iframe>\";"+
								"}"+
								"function closeTabFrame(){"+
								"  var tabFramDiv=document.getElementById('tabDiv');"+
								"  tabFramDiv.style.display='none';" +
								"}"+
								"function resetBtn(newTabText){"+
								"  for(x=0;x<document.input.elements.length;x++){"+
								"    if(document.input.elements[x].type=='button'){"+
								"      document.input.elements[x].disabled=false;"+
								"    }"+
								"  }"+
								"  document.getElementById(newTabText).disabled=true;"+
								"}"+
								"function resetFrame(newTabText){"+
								"  resetBtn(newTabText);"+
								"  document.getElementById(newTabText).disabled=true;"+
								"  document.input.tabText.value=newTabText;"+
								"  closeTabFrame();"+
								"  doAjaxRequest('" + this.getTableName() + "','tabText','tabText','detailDiv','innerHTML');"+
								"}"+
								"function setPCStatus(varStatus){"+
								"   document.getElementById('status').value=varStatus;"+
            					"}" +
								"</script>";
            	tabDivText = "<tr><td><div id='tabDiv' name='tabDiv'></div></td></tr>";
            	
            	rtnString += "<tr><td colspan=4>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.PatentCase.PatentOther")+"' "+
            						   	"id='PatentSecondPage' onClick='resetFrame(\"PatentSecondPage\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.PatentDocument.title")+"' "+
            							"id='PatentDocument' onClick='resetFrame(\"PatentDocument\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.PatentApplicant.title")+"' "+
            							"id='PatentApplicant' onClick='resetFrame(\"PatentApplicant\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.PatentInventor.title")+"' "+
            							"id='PatentInventor' onClick='resetFrame(\"PatentInventor\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.PatentAttorney.title")+"' "+
            							"id='PatentAttorney' onClick='resetFrame(\"PatentAttorney\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.PatentPriority.title")+"' "+
            							"id='PatentPriority' onClick='resetFrame(\"PatentPriority\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.ToDos.title")+"' "+
            							"id='ToDos' onClick='resetFrame(\"ToDos\")'/>"+
            				 "</td></tr>"+scriptText+
            				 "<tr"+Cnstnts.DEFAULT_TR_BGCOLOR_1+"><td colspan='4'>"+
            				 "<table width='100%'>"+tabDivText+
            				 	"<tr><td><div id='detailDiv' name='detailDiv'>"+
            				 					this.printDetailTable()+"</div></td></tr>"+
            				 "</table></td></tr>";
            }
           
        }
        return rtnString;
    }

    public void setSearchListPrpts() {
    	Properties categoryPrpt = null;
    	try {
			categoryPrpt = new Category().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.FlowKey.setListWidth("10%");
		
        this.PatentOffice.setListWidth("8%");
        this.PatentOffice.setMapingPrpt(categoryPrpt);
        this.PatentOffice.setNotShowCode(true);

        this.PatentType.setListWidth("8%");
        this.PatentType.setMapingPrpt(categoryPrpt);
        this.PatentType.setNotShowCode(true);

        this.Title.setListWidth("28%");

        this.ClientName.setListWidth("14%");
        //try {
		//	this.Client.setMapingPrpt(new Client().getNamesPrpts());
		//} catch (Exception e1) {
		//	e1.printStackTrace();
		//}
		//this.Client.setNotShowCode(true);

        this.FeeScheduleDate.setListWidth("10%");
        this.FeeScheduleDate.setAlign(Cnstnts.CENTER);

        this.InCharge.setListWidth("10%");
        try {
			this.InCharge.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

        this.Status.setListWidth("10%");
        this.Status.setMapingPrpt(categoryPrpt);
        this.Status.setNotShowCode(true);
        
        this.NotFinished.setListWidth("4%");
        this.NotFinished.setAlign(Cnstnts.RIGHT);

        Field[] showField = {this.FlowKey, this.PatentOffice, this.PatentType, 
        		this.Title, this.ClientName, this.FeeScheduleDate, this.FeeSchedule,
        		this.Status, this.NotFinished};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
       
        
        
        whereStr = Util.addWhereSQL(whereStr, this.Title);
        whereStr = Util.addWhereSQL(whereStr, this.PatentOffice);
        whereStr = Util.addWhereSQL(whereStr, this.PatentType);
        whereStr = Util.addWhereSQL(whereStr, this.Status);
        whereStr = Util.addWhereSQL(whereStr, this.Client);
        whereStr = Util.addWhereSQL(whereStr, this.ApplyNo);
        whereStr = Util.addWhereSQL(whereStr, this.LicenseNo);
        whereStr = Util.addWhereSQL(whereStr,this.InCharge);
        whereStr = Util.addBetweenSQL(whereStr, this.FeeScheduleDate, this.FeeScheduleDateTo);
        whereStr = this.getDataAuthorityWhereSQL(whereStr);
        whereStr =whereStr.replaceAll("Applicant", "p.Applicant").replaceAll(" FlowKey", " p.FlowKey").replaceAll(" InCharge", " p.InCharge").replaceAll(" CreateDept", " p.CreateDept");
        if(this.ClientName.getValue().trim().length()>0){
        	if(whereStr.trim().length()>0)
        	{
        		whereStr += " And p.Client in(select FlowKey from Client where CompanyName like '%"+
				this.getClientName()+"%') ";
        	}
        	else
        	{
        		whereStr = " where p.Client in(select FlowKey from Client where CompanyName like '%"+
				this.getClientName()+"%') ";
        	}
        	
        }
        String SQL = Cnstnts.EMPTY_STRING;
        SQL = "select Todos.NotFinished, p.*,IFNULL(c.CompanyName,'') as ClientName "+
        	"from PatentCase p "+
        	  "left join Client c on p.Client=c.FlowKey " +
        	  "left join(select ParentId, count(FlowKey) as NotFinished from Todos "+
        	  			"where Finished!='Y' group by ParentId) as Todos "+
        	  			"on p.FlowKey=Todos.ParentId "+whereStr;
        SQL = Util.addOrderSQL(SQL, this.getOrderKey(), this.getOrderSequence());
       
        return this.doSearch(SQL);
    }
    
    public List<Object[]> doSearch(String SQL) throws Exception{
  	  	if(this.getPageNo()==0){
  	  		this.setPageNo(1);
  	  	}
        int recordCount=0;
        
        List<Object[]> rtnList = new ArrayList<Object[]>();
        
        Iterator itr = this.getDbUtil().getList(SQL, this.getShowField()).iterator();
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
        return super.getNamesPrpts(this.Summary);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            PatentCase preObj = (PatentCase) userInfo.getObj(this.getTableName());
            if(this.onBtnDeleteDetail()
                    && this.getDeleteItems()!=null
            				   && this.getDeleteItems().length>0){
                for(int i=0;i<this.getDeleteItems().length;i++){
                    int seqNo = Integer.parseInt(this.getDeleteItems()[i]);
                    preObj.getDetails().remove(seqNo-i);
                }
            }
            if(Cnstnts.INSERT.equals(this.getDbActionMode())){
            	userInfo.setObj("PatentCaseInternal",null);
            }
            if(Cnstnts.DELETE.equals(this.getDbActionMode())){
            	userInfo.setObj("PatentCaseInternal",null);
            	
            }
            if(Cnstnts.UPDATE.equals(this.getDbActionMode())){
            	userInfo.setObj("PatentCaseInternal",null);
            	
            }
            this.setSearchResult(preObj.getSearchResult());
            if (!this.getDataFromDB()) {
                this.setDetails(preObj.getDetails());
            }
        }
    }

    public boolean checkInsertError() throws Exception {
        if(super.checkInsertError()){
            return true;
        } else {
        	PatentCase orginalCase = new PatentCase(this.getFlowKey());
        	if(orginalCase.getSignOutId().trim().length()>0){
        		if(!orginalCase.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))){
        			this.setErrorMessage(this.getErrorMessage(this.SignOutId)+" ["+
        					this.getUserInfo().getMsg("jsp.PatentCase.SignOutName")+" : "+
        					orginalCase.getSignOutName()+"]["+
        					this.getUserInfo().getMsg("jsp.PatentCase.SignOutTime")+" : "+
        					orginalCase.getSignOutTime()+"]");
        			return true;
        		} else {
        			this.setSignOutId(Cnstnts.EMPTY_STRING);
        		}
        	}
        	if(Cnstnts.INSERT.equals(this.getDbActionMode()) 
        			&& this.getCreateTime().trim().length()==0){
        		this.setCreateTime(Util.getDateTime());
        		this.setCreator(this.getUserInfo().getAttribute("user_name"));
        	}
        	if(Cnstnts.UPDATE.equals(this.getDbActionMode()) 
        			|| Cnstnts.INSERT.equals(this.getDbActionMode())){
        		this.setUpdateTime(Util.getDateTime());
        		this.setUpdater(this.getUserInfo().getAttribute("user_name"));
        		if(Cnstnts.TRUE_FLAG.equals(this.getSignOutFlag())){
            		orginalCase.setSignOutId(this.getUserInfo().getAttribute("emp_id"));
            		orginalCase.setSignOutName(this.getUserInfo().getAttribute("user_name"));
            		orginalCase.setSignOutTime(Util.getDateTime());
            		orginalCase.update();
            		this.getAttribute();
            		this.setErrorMessage(this.getUserInfo().getMsg("jsp.PatentCase.SignOut"));
            		return true;
        		} else {
        			this.setSignOutId(Cnstnts.EMPTY_STRING);
            		this.setSignOutName(Cnstnts.EMPTY_STRING);
            		this.setSignOutTime(Cnstnts.EMPTY_STRING);
        		}
        	}
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
    
    public void doAction(UserBean userInfo) throws Exception {
    	super.doAction(userInfo);
    	if(this.getPageActionMode().equals(Cnstnts.MAINTAIN)){
    		if(this.getSignOutId().equals(userInfo.getAttribute("emp_id"))
    				&& (!this.getDbActionMode().equals(Cnstnts.UPDATE) 
    						&& !this.getDbActionMode().equals(Cnstnts.PRINT))){
    			this.setDbActionMode(Cnstnts.UPDATE);
    		}
    	}
    }
    
    public String getSubmitBtn() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if(this.getDbActionMode().equals(Cnstnts.PRINT)){
			List<SelectItem> sampleDocs = new ReportDefine().getList(this.getProgramId());
			if(sampleDocs.size()==0){
				return Cnstnts.EMPTY_STRING;
			} else {
				rtnString = "<select id='sampleDoc' name='sampleDoc'>";
				for(Iterator itr=sampleDocs.iterator();itr.hasNext();){
					SelectItem option = (SelectItem)itr.next();
					String selected = Cnstnts.EMPTY_STRING;
					if(this.getSampleDoc().equals(option.getKey())){
						selected=Cnstnts.SELECTED;
					}
					rtnString += "  <option value='"+option.getKey()+"'"+selected+">"+
									option.getValue()+"</option>";
				}
				rtnString += "</select>";
			}
		}
		if(this.getSignOutId().trim().length()==0 
				&& Cnstnts.UPDATE.equals(this.getDbActionMode())
						&& this.getFlowKey().trim().length()>0){
			rtnString += "<input type='button' style='cursor: hand' " +
			   "value='" + this.getUserInfo().getMsg("jsp.common.signOut")+"' " +
			   "onClick='this.disabled=true;document.input.signOutFlag.value=\"true\";setSubmitValue(\"update\")'/>";;
			return rtnString;
		} else {
			if(this.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id")) 
					|| Cnstnts.INSERT.equals(this.getDbActionMode()) 
							|| Cnstnts.PRINT.equals(this.getDbActionMode())){
				return rtnString+super.getSubmitBtn();
			}
		}
		return rtnString;
	}
    
    @SuppressWarnings("unchecked")
    public String printDetailTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        
        
        if(this.getTabText().equals("PatentDocument")){
        	rtnString = new PatentDocument().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("PatentApplicant")){
        	rtnString = new PatentApplicant().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("PatentInventor")){
        	rtnString = new PatentInventor().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("PatentAttorney")){
        	rtnString = new PatentAttorney().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("PatentPriority")){
        	rtnString = new PatentPriority().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("ToDos")){
        	rtnString = new ToDos().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("PatentSecondPage")){
        	rtnString="<table width='100%' " + this.getTableBgcolor() + ">";
        	
        	this.Keyword.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.ProjectCode.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ProjectCode.setAnotherField(this.Keyword);
            this.ProjectCode.setColspan(1);
            rtnString += this.printHtml(this.ProjectCode);
        	
            this.FuncCategory.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.TechCategory.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TechCategory.setAnotherField(this.FuncCategory);
            this.TechCategory.setColspan(1);
            rtnString += this.printHtml(this.TechCategory);
            
            this.Uspc.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.Ipc.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Ipc.setAnotherField(this.Uspc);
            this.Ipc.setColspan(1);
            rtnString += this.printHtml(this.Ipc);
            
            this.Locarno.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.Fi.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Fi.setAnotherField(this.Locarno);
            this.Fi.setColspan(1);
            rtnString += this.printHtml(this.Fi);
            
            this.TechReportApply.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            
            this.Gattezz.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Gattezz.setAnotherField(this.TechReportApply);
            this.Gattezz.setColspan(1);
            rtnString += this.printHtml(this.Gattezz);
            
            this.ExamineDueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.ExamineDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ExamineDate.setAnotherField(this.ExamineDueDate);
            this.ExamineDate.setColspan(1);
            rtnString += this.printHtml(this.ExamineDate);
            
            this.DependentClaim.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.DependentClaim.setSize(5);
            
            this.IndependentClaim.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.IndependentClaim.setSize(5);
            this.IndependentClaim.setAnotherField(this.DependentClaim);
            this.IndependentClaim.setColspan(1);
            rtnString += this.printHtml(this.IndependentClaim);
            
            this.TotalPage.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalPage.setSize(5);
            
            this.Drawing.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Drawing.setSize(5);
            this.Drawing.setAnotherField(this.TotalPage);
            this.Drawing.setColspan(1);
            rtnString += this.printHtml(this.Drawing);
            
            this.RightEndDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.RightBeginDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.RightBeginDate.setAnotherField(this.RightEndDate);
            this.RightBeginDate.setColspan(1);
            rtnString += this.printHtml(this.RightBeginDate);
            
            this.PctAppNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.PctAppDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.PctAppDate.setAnotherField(this.PctAppNo);
            this.PctAppDate.setColspan(1);
            rtnString += this.printHtml(this.PctAppDate);
            
            this.WipoNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.PctPublishDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.PctPublishDate.setAnotherField(this.WipoNo);
            this.PctPublishDate.setColspan(1);
            rtnString += this.printHtml(this.PctPublishDate);
            
            this.NationalPhaseDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            rtnString += this.printHtml(this.NationalPhaseDate);
            
            this.GiveupCode.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.GiveupCode.setSelectList(new Category().getChildList(this.GiveupCode));
            
            this.OutsourceDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.OutsourceDate.setAnotherField(this.GiveupCode);
            this.OutsourceDate.setColspan(1);
            rtnString += this.printHtml(this.OutsourceDate);

            this.Creator.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Creator.setReadonly(true);

            this.CreateTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.CreateTime.setReadonly(true);
            this.CreateTime.setAnotherField(this.Creator);
            this.CreateTime.setColspan(1);
            rtnString += this.printHtml(this.CreateTime);
            
            
            rtnString += "</table>";
        } else {
        	rtnString += this.ProjectCode.printHiddenTag();
        	rtnString += this.Keyword.printHiddenTag();
        	
        	rtnString += this.FuncCategory.printHiddenTag();
        	rtnString += this.TechCategory.printHiddenTag();
        	
        	rtnString += this.Ipc.printHiddenTag();
        	rtnString += this.Uspc.printHiddenTag();
        	
        	rtnString += this.Fi.printHiddenTag();
        	rtnString += this.Locarno.printHiddenTag();
        	
        	rtnString += this.Gattezz.printHiddenTag();
        	rtnString += this.TechReportApply.printHiddenTag();
        	
        	rtnString += this.ExamineDate.printHiddenTag();
        	rtnString += this.ExamineDueDate.printHiddenTag();
        	
        	rtnString += this.IndependentClaim.printHiddenTag();
        	rtnString += this.DependentClaim.printHiddenTag();
        	
        	rtnString += this.Drawing.printHiddenTag();
        	rtnString += this.TotalPage.printHiddenTag();
        	
        	rtnString += this.RightBeginDate.printHiddenTag();
        	rtnString += this.RightEndDate.printHiddenTag();
        	
        	rtnString += this.PctAppDate.printHiddenTag();
        	rtnString += this.PctAppNo.printHiddenTag();
        	rtnString += this.PctPublishDate.printHiddenTag();
             
            rtnString += this.GiveupCode.printHiddenTag();
         	rtnString += this.OutsourceDate.printHiddenTag();
        	
        	rtnString += this.Creator.printHiddenTag();
        	rtnString += this.CreateTime.printHiddenTag();
        	rtnString += this.CaseStartDate.printHiddenTag();
        }
        return rtnString;
    }
    
    public boolean canEdit() {
		if (this.getFlowKey() == null) {
			return false;
		}
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())){
			if(Cnstnts.INSERT.equals(this.getDbActionMode())){
				return true;
			} else {
				if(Cnstnts.UPDATE.equals(this.getDbActionMode())){
					if(this.getFlowKey().trim().length()>0 
							&& this.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}		
			}		
		} else {
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
			if (this.getApplicant().trim().length() == 0) {
				this.setApplicant(this.getUserInfo().getAttribute("emp_id"));
			}
			if (this.getCreateDept().trim().length() == 0) {
				this.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
			}
			if (Cnstnts.SIGN.equals(this.getDbActionMode())) {
				this.doSignProcess();
				this.doApproveProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.signForm.send"));
				this.setForwardPage("menu.jsp");
			} else if (Cnstnts.CLOSE.equals(this.getDbActionMode())) {
				this.doCloseProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.closeForm.closed"));
				this.setForwardPage("menu.jsp");
			} else if (Cnstnts.INSERT.equals(this.getDbActionMode())) {
				if (this.insert()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
									  this.FlowKey.getValue(), 
									  this.getProgramId(), 
									  this.getUserInfo().getAttribute("emp_id"), 
									  this.getApplicant(),
									  this.getTableName(), 
									  this.getAliasName());
					}
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
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
								  	  this.FlowKey.getValue(), 
								  	  this.getProgramId(), 
								  	  this.getUserInfo().getAttribute("emp_id"), 
								  	  this.getApplicant(),
								  	  this.getTableName(), 
								  	  this.getAliasName());
					}
					this.doOtherUpdateProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.update"));
					this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=search"+
																"&doSearchFlag=true");
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
    
    public boolean delete() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.setDbFields();
		if (this.hasBindingFlow()) {
			sqlList.add("delete from Flow where FlowKey='" + this.getFlowKey()
					+ "'");
			sqlList.add("delete from Flow_detail where FlowKey='"
					+ this.getFlowKey() + "'");
		}
		sqlList.add("delete from PatentApplicant where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from PatentDocument where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from PatentInventor where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from PatentAttorney where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from PatentPriority where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from ToDos where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from "+this.getTableName()+" where FlowKey='"+this.getFlowKey()+"'");
		if (this.getDetails() != null) {
			sqlList.add("delete from " + this.getTableName()
					+ "_detail where FlowKey='" + this.getFlowKey() + "'");
		}
		if (new Program(this.getProgramId()).getLogDelete().equals("1")) {
			sqlList.add(this.getLogSQL(null));
		}
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
    	String outputFile = "PatentCase/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".doc";
    	String outputDoc = "file:///"+Util.getDocPath()+outputFile;
    	
    	if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		
    		String SQL = "select p.*, c.Names as PatentOfficeName, cc.Names as PatentTypeName, "+
    							"cl.CompanyName "+
    					 "from PatentCase p "+
    					 "inner join Client cl on p.Client=cl.FlowKey "+
    					 "inner join Category c on p.PatentOffice=c.FlowKey "+
    					 "inner join Category cc on p.PatentType=cc.FlowKey "+
    					 "where p.FlowKey='"+this.getFlowKey()+"'";
    		HashMap<String, String> fieldMap = this.getAttributesMap();
    		fieldMap.put("PatentOfficeName","");
    		fieldMap.put("PatentTypeName","");
    		fieldMap.put("CompanyName","");
    		Map data = this.getDocMap(SQL,fieldMap);
    		/*
    		Map data = this.getBasicDocMap();
    		for(Iterator itr=data.keySet().iterator();itr.hasNext();){
    			String key = itr.next().toString();
    			System.out.println(key+" : "+data.get(key));
    		}
    		*/
    		
    		Properties categoryPrpt = new Category().getNamesPrpts();
    		
    		char newLine = Cnstnts.NEW_LINE;
    		String detailData = Cnstnts.EMPTY_STRING;
    		SQL = "select a.*,p.ApplicantOrder from "+
    			  "(select ApplicantId,ApplicantOrder from PatentApplicant where ParentId='"+
    			  			   this.getFlowKey()+"') p "+
    			  "inner join Applicant a "+
    			  "on a.FlowKey=p.ApplicantId "+
    			  "order by p.ApplicantOrder";
    		Applicant applicant = new Applicant();
    		applicant.setDbFields();
        	List<List<Field>> applicantdataLst = applicant.getDbUtil().getFieldsList(SQL, applicant.getDbFields());
        	int i=1;
        	for(Iterator itr=applicantdataLst.iterator();itr.hasNext();i++){ 
                String Nationality = Cnstnts.EMPTY_STRING;
                String IdType = Cnstnts.EMPTY_STRING;
                String IdNo = Cnstnts.EMPTY_STRING;
                String Names = Cnstnts.EMPTY_STRING;
                String EnglishNames = Cnstnts.EMPTY_STRING;
                String CompanyReq = Cnstnts.EMPTY_STRING;
                String EnglishCompanyReq = Cnstnts.EMPTY_STRING;
                String Address = Cnstnts.EMPTY_STRING;
                String EnglishAddress = Cnstnts.EMPTY_STRING;
                String TelNo = Cnstnts.EMPTY_STRING;
                String Fax = Cnstnts.EMPTY_STRING;
                String Email = Cnstnts.EMPTY_STRING;
                List<Field> detailFieldsLst = (List<Field>)itr.next();
            	for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
                    Field detailField = (Field)fieldsItr.next();
                    if(detailField.getName().equals("Nationality")){
                    	Nationality = detailField.getValue();
                    }
                    if(detailField.getName().equals("IdType")){
                    	IdType = detailField.getValue();
                    }
                    if(detailField.getName().equals("IdNo")){
                    	IdNo = detailField.getValue();
                    }
                    if(detailField.getName().equals("Names")){
                    	Names = detailField.getValue();
                    }
                    if(detailField.getName().equals("EnglishNames")){
                    	EnglishNames = detailField.getValue();
                    }
                    if(detailField.getName().equals("CompanyReq")){
                    	CompanyReq = detailField.getValue();
                    }
                    if(detailField.getName().equals("EnglishCompanyReq")){
                    	EnglishCompanyReq = detailField.getValue();
                    }
                    if(detailField.getName().equals("Address")){
                    	Address = detailField.getValue();
                    }
                    if(detailField.getName().equals("EnglishAddress")){
                    	EnglishAddress = detailField.getValue();
                    }
                    if(detailField.getName().equals("TelNo")){
                    	TelNo = detailField.getValue();
                    }
                    if(detailField.getName().equals("Fax")){
                    	Fax = detailField.getValue();
                    }
                    if(detailField.getName().equals("Email")){
                    	Email = detailField.getValue();
                    }
                }
            	detailData += newLine +"(" + this.getUserInfo().getMsg("jsp.Applicant.printDoc.1") +
            					  i + this.getUserInfo().getMsg("jsp.PatentApplicant.title") + ")";
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.Nationality") + " : ";
            	if(Nationality.equals("TW")){
            		detailData += this.getUserInfo().getMsg("jsp.common.CheckBox.Selected");
            	} else {
            		detailData += this.getUserInfo().getMsg("jsp.common.CheckBox.Empty");
            	}
            	detailData += this.getUserInfo().getMsg("jsp.Applicant.printDoc.2");
            	if(Nationality.equals("CN")){
            		detailData += "         "+this.getUserInfo().getMsg("jsp.common.CheckBox.Selected");
            	} else {
            		detailData += "         "+this.getUserInfo().getMsg("jsp.common.CheckBox.Empty");
            	}
            	detailData += this.getUserInfo().getMsg("jsp.Applicant.printDoc.3");
            	
            	String NationalityName = Cnstnts.EMPTY_STRING;
            	if(Nationality.equals("TW") || Nationality.equals("CN")){
            		detailData += newLine + "       "+this.getUserInfo().getMsg("jsp.common.CheckBox.Empty");
            	} else {
            		detailData += newLine + "       "+this.getUserInfo().getMsg("jsp.common.CheckBox.Selected");
            		NationalityName = categoryPrpt.getProperty(Nationality);
            	}
            	detailData += this.getUserInfo().getMsg("jsp.Applicant.printDoc.4")+NationalityName;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.IdType")+" : ";
            	if(IdType.equals("Id01")){
            		detailData += this.getUserInfo().getMsg("jsp.common.CheckBox.Selected");
            	} else {
            		detailData += this.getUserInfo().getMsg("jsp.common.CheckBox.Empty");
            	}
            	detailData += this.getUserInfo().getMsg("jsp.Applicant.printDoc.5");
            	
            	if(IdType.equals("Id01")){
            		detailData += "       "+this.getUserInfo().getMsg("jsp.common.CheckBox.Empty");
            	} else {
            		detailData += "       "+this.getUserInfo().getMsg("jsp.common.CheckBox.Selected");
            	}
            	detailData += this.getUserInfo().getMsg("jsp.Applicant.printDoc.6");
            	
            	detailData += newLine + "ID : "+IdNo;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.printDoc.7")+
            								this.getUserInfo().getMsg("jsp.Applicant.printDoc.8")+Names;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.printDoc.9")+EnglishNames;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.CompanyReq")+" : "+
											this.getUserInfo().getMsg("jsp.Applicant.printDoc.8")+CompanyReq;

            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.printDoc.9")+EnglishCompanyReq;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.Address")+" : "+
											this.getUserInfo().getMsg("jsp.Applicant.printDoc.8")+Address;

            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.printDoc.9")+EnglishAddress;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.printDoc.10");
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.printDoc.11")+TelNo;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.Fax")+" : "+Fax;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.Email")+" : "+Email;
            }
    		data.put("${ApplicantSize}", applicantdataLst.size()+Cnstnts.EMPTY_STRING);
    		data.put("${ApplicantsData}", detailData);
    		
    		detailData = Cnstnts.EMPTY_STRING;
    		SQL = "select a.*,p.AttorneyType from "+
    			  "(select Attorney,AttorneyType from PatentAttorney where ParentId='"+
    			  			   this.getFlowKey()+"') p "+
    			  "inner join Attorney a "+
    			  "on a.FlowKey=p.Attorney "+
    			  "order by p.AttorneyType";
    		Attorney attorney = new Attorney();
    		attorney.setDbFields();
        	List<List<Field>> attorneydataLst = attorney.getDbUtil().getFieldsList(SQL, attorney.getDbFields());
        	i=1;
        	for(Iterator itr=attorneydataLst.iterator();itr.hasNext();i++){ 
                String IdNo = Cnstnts.EMPTY_STRING;
                String LastName = Cnstnts.EMPTY_STRING;
                String FirstName = Cnstnts.EMPTY_STRING;
                String CertificateNo = Cnstnts.EMPTY_STRING;
                String Address1 = Cnstnts.EMPTY_STRING;
                String Tel1 = Cnstnts.EMPTY_STRING;
                String Fax1 = Cnstnts.EMPTY_STRING;
                String Email = Cnstnts.EMPTY_STRING;
                List<Field> detailFieldsLst = (List<Field>)itr.next();
            	for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
                    Field detailField = (Field)fieldsItr.next();
                    if(detailField.getName().equals("IdNo")){
                    	IdNo = detailField.getValue();
                    }
                    if(detailField.getName().equals("LastName")){
                    	LastName = detailField.getValue();
                    }
                    if(detailField.getName().equals("FirstName")){
                    	FirstName = detailField.getValue();
                    }
                    if(detailField.getName().equals("CertificateNo")){
                    	CertificateNo = detailField.getValue();
                    }
                    if(detailField.getName().equals("Address1")){
                    	Address1 = detailField.getValue();
                    }
                    if(detailField.getName().equals("Tel1")){
                    	Tel1 = detailField.getValue();
                    }
                    if(detailField.getName().equals("Fax1")){
                    	Fax1 = detailField.getValue();
                    }
                    if(detailField.getName().equals("Email")){
                    	Email = detailField.getValue();
                    }
                }
            	detailData += newLine +"(" + this.getUserInfo().getMsg("jsp.Applicant.printDoc.1") +
            					  i + this.getUserInfo().getMsg("jsp.PatentAttorney.title") + ")";
            	
            	detailData += newLine + "ID : "+IdNo;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Inventors.LastName")+
								this.getUserInfo().getMsg("jsp.Inventors.FirstName")+" :  ";

            	detailData += this.getUserInfo().getMsg("jsp.Inventors.LastName")+" : "+LastName;

            	detailData += "      " + this.getUserInfo().getMsg("jsp.Inventors.FirstName")+" : "+FirstName;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Attorney.CertificateNo")+" : "+CertificateNo;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.Address")+" : "+Address1;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.printDoc.11")+Tel1;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.Fax")+" : "+Fax1;
            	
            	detailData += newLine + this.getUserInfo().getMsg("jsp.Applicant.Email")+" : "+Email;
            }
    		data.put("${AttorneySize}", attorneydataLst.size()+Cnstnts.EMPTY_STRING);
    		data.put("${AttorneyData}", detailData);
    		
    		detailData = Cnstnts.EMPTY_STRING;
    		SQL = "select i.*,p.InventorOrder from "+
    			  "(select Inventor,InventorOrder from PatentInventor where ParentId='"+this.getFlowKey()+"') p "+
    			  "inner join Inventors i on p.Inventor=i.FlowKey "+
    			  "order by InventorOrder";
    		Inventors inventor = new Inventors();
    		inventor.setDbFields();
    		List<List<Field>> inventordataLst = inventor.getDbUtil().getFieldsList(SQL, inventor.getDbFields());
    		i=1;
    		for(Iterator itr=inventordataLst.iterator();itr.hasNext();i++){ 
    			String Nationality = Cnstnts.EMPTY_STRING;
    			String IdNo = Cnstnts.EMPTY_STRING;
    			String LastName = Cnstnts.EMPTY_STRING;
    			String EnglishLastName = Cnstnts.EMPTY_STRING;
    			String FirstName = Cnstnts.EMPTY_STRING;
    			String EnglishFirstName = Cnstnts.EMPTY_STRING;
    			
    			List<Field> detailFieldsLst = (List<Field>)itr.next();
    			for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
    				Field detailField = (Field)fieldsItr.next();
    				if(detailField.getName().equals("Nationality")){
    					Nationality = detailField.getValue();
    				}
    				if(detailField.getName().equals("IdNo")){
    					IdNo = detailField.getValue();
    				}
    				if(detailField.getName().equals("LastName")){
    					LastName = detailField.getValue();
    				}
    				if(detailField.getName().equals("EnglishLastName")){
    					EnglishLastName = detailField.getValue();
    				}
    				if(detailField.getName().equals("FirstName")){
    					FirstName = detailField.getValue();
    				}
    				if(detailField.getName().equals("EnglishFirstName")){
    					EnglishFirstName = detailField.getValue();
    				}
    			}
    			detailData += newLine +"(" + this.getUserInfo().getMsg("jsp.Applicant.printDoc.1") +
      					  	i + this.getUserInfo().getMsg("jsp.PatentInventor.title") + ")";
      	
    			detailData += newLine + "ID : "+IdNo;
      	
    			detailData += "      " + this.getUserInfo().getMsg("jsp.Inventors.Nationality")+ " : " +
    							categoryPrpt.getProperty(Nationality)+Nationality;
      	
    			detailData += newLine + this.getUserInfo().getMsg("jsp.Inventors.LastName")+
    							this.getUserInfo().getMsg("jsp.Inventors.FirstName")+" :  ";
    			
    			detailData += this.getUserInfo().getMsg("jsp.Inventors.LastName")+" : "+LastName;
    			
    			detailData += "      " + this.getUserInfo().getMsg("jsp.Inventors.FirstName")+" : "+FirstName;
    			
    			detailData += newLine +"            "+EnglishLastName + "         " +EnglishFirstName;
      	
    		}
    		data.put("${InventorSize}", inventordataLst.size()+Cnstnts.EMPTY_STRING);
    		data.put("${InventorsData}", detailData);
    		
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
    
    public void clearAttribute() {
		super.clearAttribute();
		this.setClientName(Cnstnts.EMPTY_STRING);
		this.setFeeScheduleDateTo(Cnstnts.EMPTY_STRING);
	}

}