package deepspot.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.Element;

import com.athenasoft.ooutil.OoConverter;

import deepspot.basic.CaseMasterBean;
import deepspot.basic.Cnstnts;
import deepspot.basic.DbUtil;
import deepspot.basic.Field;
import deepspot.basic.SelectItem;
import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.html.SelectOneTag;
import deepspot.util.Util;

public class PatentCase extends CaseMasterBean {

    public PatentCase(){this.init();}

    public PatentCase(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ContactDate;
    public void setContactDate(String ContactDate){this.ContactDate.setValue(ContactDate);}
    public String getContactDate(){return this.ContactDate.getValue();}
    
    public Field Referrals;
    public void setReferrals(String Referrals){this.Referrals.setValue(Referrals);}
    public String getReferrals(){return this.Referrals.getValue();}


    public Field Matter;
    public void setMatter(String Matter){this.Matter.setValue(Matter);}
    public String getMatter(){return this.Matter.getValue();}

    public Field SpecialRequest;
    public void setSpecialRequest(String SpecialRequest){this.SpecialRequest.setValue(SpecialRequest);}
    public String getSpecialRequest(){return this.SpecialRequest.getValue();}
    
    public Field IsCharge;
    public void setIsCharge(String IsCharge){this.IsCharge.setValue(IsCharge);}
    public String getIsCharge(){return this.IsCharge.getValue();}
    
   public Field IsPayment;
   public void setIsPayment(String IsPayment){this.IsPayment.setValue(IsPayment);}
   public String getIsPayment(){return this.IsPayment.getValue();}
    
    public Field ToDosStatus;
    public void setToDosStatus(String ToDosStatus){this.ToDosStatus.setValue(ToDosStatus);}
    public String getToDosStatus(){return this.ToDosStatus.getValue();}

    public Field CaseStartDate;
    public void setCaseStartDate(String CaseStartDate){this.CaseStartDate.setValue(CaseStartDate);}
    public String getCaseStartDate(){return this.CaseStartDate.getValue();}

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
    public void setNotFinished(String NotFinished){this.NotFinished.setValue(NotFinished);}
    public String getNotFinished(){return this.NotFinished.getValue();}
    
    public Field CaseAttribute;
    public void setCaseAttribute(String CaseAttribute){this.CaseAttribute.setValue(CaseAttribute);}
    public String getCaseAttribute(){return this.CaseAttribute.getValue();}
    
    public Field PatentCaseType;
    public void setPatentCaseType(String PatentCaseType){this.PatentCaseType.setValue(PatentCaseType);}
    public String getPatentCaseType(){return this.PatentCaseType.getValue();}
    
    public Field DeliveryDate;
    public void setDeliveryDate(String DeliveryDate){this.DeliveryDate.setValue(DeliveryDate);}
    public String getDeliveryDate(){return this.DeliveryDate.getValue();}
    
    public Field Remark;
    public void setRemark(String Remark){this.Remark.setValue(Remark);}
    public String getRemark(){return this.Remark.getValue();}
    
    public Field Ids;
    public void setIds(String Ids){this.Ids.setValue(Ids);}
    public String getIds(){return this.Ids.getValue();}
    
    public Field Priority;
    public void setPriority(String Priority){this.Priority.setValue(Priority);}
    public String getPriority(){return this.Priority.getValue();}
    
    public Field IdsCaseNo;
    public void setIdsCaseNo(String IdsCaseNo){this.IdsCaseNo.setValue(IdsCaseNo);}
    public String getIdsCaseNo(){return this.IdsCaseNo.getValue();}
    
    public Field PriorityCaseNo;
    public void setPriorityCaseNo(String PriorityCaseNo){this.PriorityCaseNo.setValue(PriorityCaseNo);}
    public String getPriorityCaseNo(){return this.PriorityCaseNo.getValue();}
    
    public Field OtherCaseNo;
    public void setOtherCaseNo(String OtherCaseNo){this.OtherCaseNo.setValue(OtherCaseNo);}
    public String getOtherCaseNo(){return this.OtherCaseNo.getValue();}
    
    public Field SerialMotherCase;
    public void setSerialMotherCase(String SerialMotherCase){this.SerialMotherCase.setValue(SerialMotherCase);}
    public String getSerialMotherCase(){return this.SerialMotherCase.getValue();}
    
    public Field Entity;
    public void setEntity(String Entity){this.Entity.setValue(Entity);}
    public String getEntity(){return this.Entity.getValue();}
    
    public Field LastSchedule;
    public void setLastSchedule(String LastSchedule){this.LastSchedule.setValue(LastSchedule);}
    public String getLastSchedule(){return this.LastSchedule.getValue();}
    
    public Field InternalNo;
    public void setInternalNo(String InternalNo){this.InternalNo.setValue(InternalNo);}
    public String getInternalNo(){return this.InternalNo.getValue();}
    
    public Field Attorney;
    public void setAttorney(String Attorney){this.Attorney.setValue(Attorney);}
    public String getAttorney(){return this.Attorney.getValue();}
    
    public Field PriorityDeadLine;
    public void setPriorityDeadLine(String PriorityDeadLine){this.PriorityDeadLine.setValue(PriorityDeadLine);}
    public String getPriorityDeadLine(){return this.PriorityDeadLine.getValue();}
    
    public Field WrittenMan;
    public void setWrittenMan(String WrittenMan){this.WrittenMan.setValue(WrittenMan);}
    public String getWrittenMan(){return this.WrittenMan.getValue();}

    public Field WrittenFinishedDate;
    public void setWrittenFinishedDate(String WrittenFinishedDate){this.WrittenFinishedDate.setValue(WrittenFinishedDate);}
    public String getWrittenFinishedDate(){return this.WrittenFinishedDate.getValue();}

    public Field MappingMan;
    public void setMappingMan(String MappingMan){this.MappingMan.setValue(MappingMan);}
    public String getMappingMan(){return this.MappingMan.getValue();}
    
    public Field MappingFinishedDate;
    public void setMappingFinishedDate(String MappingFinishedDate){this.MappingFinishedDate.setValue(MappingFinishedDate);}
    public String getMappingFinishedDate(){return this.MappingFinishedDate.getValue();}
    
    public Field TranslateMan;
    public void setTranslateMan(String TranslateMan){this.TranslateMan.setValue(TranslateMan);}
    public String getTranslateMan(){return this.TranslateMan.getValue();}
    
    public Field TranslateFinishedDate;
    public void setTranslateFinishedDate(String TranslateFinishedDate){this.TranslateFinishedDate.setValue(TranslateFinishedDate);}
    public String getTranslateFinishedDate(){return this.TranslateFinishedDate.getValue();}
    
    public Field RejectionMan;
    public void setRejectionMan(String RejectionMan){this.RejectionMan.setValue(RejectionMan);}
    public String getRejectionMan(){return this.RejectionMan.getValue();}
    
    public Field RejectionFinishedDate;
    public void setRejectionFinishedDate(String RejectionFinishedDate){this.RejectionFinishedDate.setValue(RejectionFinishedDate);}
    public String getRejectionFinishedDate(){return this.RejectionFinishedDate.getValue();}
    
    public Field ReplyMan;
    public void setReplyMan(String ReplyMan){this.ReplyMan.setValue(ReplyMan);}
    public String getReplyMan(){return this.ReplyMan.getValue();}
    
    public Field ReplyFinishedDate;
    public void setReplyFinishedDate(String ReplyFinishedDate){this.ReplyFinishedDate.setValue(ReplyFinishedDate);}
    public String getReplyFinishedDate(){return this.ReplyFinishedDate.getValue();}
    
    public Field ReplyFinishedDateDept;
    public void setReplyFinishedDateDept(String ReplyFinishedDateDept){this.ReplyFinishedDateDept.setValue(ReplyFinishedDateDept);}
    public String getReplyFinishedDateDept(){return this.ReplyFinishedDateDept.getValue();}
    
    public String SignOutFlag;
    public void setSignOutFlag(String SignOutFlag){this.SignOutFlag=SignOutFlag;}
    public String getSignOutFlag(){return this.SignOutFlag;}
    
    public Field AutoPay;
    public void setAutoPay(String AutoPay){this.AutoPay.setValue(AutoPay);}
    public String getAutoPay(){return this.AutoPay.getValue();}
    
    public Field PaymentConfirming;
    public void setPaymentConfirming(String PaymentConfirming){this.PaymentConfirming.setValue(PaymentConfirming);}
    public String getPaymentConfirming(){return this.PaymentConfirming.getValue();}

    public Field AttorneyNum;
    public void setAttorneyNum(String AttorneyNum){this.AttorneyNum.setValue(AttorneyNum);}
    public String getAttorneyNum(){return this.AttorneyNum.getValue();}
    
    public Field EnglishTitle;
    public void setEnglishTitle(String EnglishTitle){this.EnglishTitle.setValue(EnglishTitle);}
    public String getEnglishTitle(){return this.EnglishTitle.getValue();}
    
    public Field ApplyTransDate;
    public void setApplyTransDate(String ApplyTransDate){this.ApplyTransDate.setValue(ApplyTransDate);}
    public String getApplyTransDate(){return this.ApplyTransDate.getValue();}

    public Field ApplyTransTo;
    public void setApplyTransTo(String ApplyTransTo){this.ApplyTransTo.setValue(ApplyTransTo);}
    public String getApplyTransTo(){return this.ApplyTransTo.getValue();}
    
    public Field RightTransDate;
    public void setRightTransDate(String RightTransDate){this.RightTransDate.setValue(RightTransDate);}
    public String getRightTransDate(){return this.RightTransDate.getValue();}

    public Field RightTransTo;
    public void setRightTransTo(String RightTransTo){this.RightTransTo.setValue(RightTransTo);}
    public String getRightTransTo(){return this.RightTransTo.getValue();}
    
    public Field FromCase;
    public void setFromCase(String FromCase){this.FromCase.setValue(FromCase);}
    public String getFromCase(){return this.FromCase.getValue();}
    
    public Field ApplicantCopyCheck;
    public void setApplicantCopyCheck(String ApplicantCopyCheck){this.ApplicantCopyCheck.setValue(ApplicantCopyCheck);}
    public String getApplicantCopyCheck(){return this.ApplicantCopyCheck.getValue();}
    
    public Field AttorneyCopyCheck;
    public void setAttorneyCopyCheck(String AttorneyCopyCheck){this.AttorneyCopyCheck.setValue(AttorneyCopyCheck);}
    public String getAttorneyCopyCheck(){return this.AttorneyCopyCheck.getValue();}
    
    public Field InventorCopyCheck;
    public void setInventorCopyCheck(String InventorCopyCheck){this.InventorCopyCheck.setValue(InventorCopyCheck);}
    public String getInventorCopyCheck(){return this.InventorCopyCheck.getValue();}
    
    public Field PriorityCopyCheck;
    public void setPriorityCopyCheck(String PriorityCopyCheck){this.PriorityCopyCheck.setValue(PriorityCopyCheck);}
    public String getPriorityCopyCheck(){return this.PriorityCopyCheck.getValue();}
    
    public Field CaseApplicantNames;
    public void setCaseApplicantNames(String CaseApplicantNames){this.CaseApplicantNames.setValue(CaseApplicantNames);}
    public String getCaseApplicantNames(){return this.CaseApplicantNames.getValue();}
    
    public Field CaseInventorNames;
    public void setCaseInventorNames(String CaseInventorNames){this.CaseInventorNames.setValue(CaseInventorNames);}
    public String getCaseInventorNames(){return this.CaseInventorNames.getValue();}
    
    public Field PriorityDate;
    public void setPriorityDate(String PriorityDate){this.PriorityDate.setValue(PriorityDate);}
    public String getPriorityDate(){return this.PriorityDate.getValue();}
    
    public Field PriorityNo;
    public void setPriorityNo(String PriorityNo){this.PriorityNo.setValue(PriorityNo);}
    public String getPriorityNo(){return this.PriorityNo.getValue();}

    public Field PctNationalPhase;
    public void setPctNationalPhase(String PctNationalPhase){this.PctNationalPhase.setValue(PctNationalPhase);}
    public String getPctNationalPhase(){return this.PctNationalPhase.getValue();}
    
    public Field ImageUrl;

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl.setValue(ImageUrl);
    }

    public String getImageUrl() {
        return this.ImageUrl.getValue();
    }
    
    public String cond1;

    public void setCond1(String cond1) {
        this.cond1 = cond1;
    }

    public String getCond1() {
        return this.cond1;
    }
    
    public String cond2;

    public void setCond2(String cond2) {
        this.cond2 = cond2;
    }

    public String getCond2() {
        return this.cond2;
    }
    
    public String cond3;

    public void setCond3(String cond3) {
        this.cond3 = cond3;
    }

    public String getCond3() {
        return this.cond3;
    }
    
    public String startDate;

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        if(startDate == null) {
            startDate = "";
        }
        return this.startDate;
    }
    
    public String endDate;

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        if(endDate == null) {
            endDate = "";
        }
        return this.endDate;
    }
    
    public String sqlCond1;

    public void setSqlCond1(String sqlCond1) {
        this.sqlCond1 = sqlCond1;
    }

    public String getSqlCond1() {
        if(sqlCond1 == null) {
        	sqlCond1 = "";
        }
        return this.sqlCond1;
    }
    
    public String sqlCond2;

    public void setSqlCond2(String sqlCond2) {
        this.sqlCond2 = sqlCond2;
    }

    public String getSqlCond2() {
        if(sqlCond2 == null) {
        	sqlCond2 = "";
        }
        return this.sqlCond2;
    }
    
    public String allSearchCond;

    public void setAllSearchCond(String allSearchCond) {
        this.allSearchCond = allSearchCond;
    }

    public String getAllSearchCond() {
        if(allSearchCond == null) {
        	allSearchCond = "";
        }
        return this.allSearchCond;
    }
    
    
    public String fullSearchText1;

    public void setFullSearchText1(String fullSearchText1) {
        this.fullSearchText1 = fullSearchText1;
    }

    public String getFullSearchText1() {
    	if(Util.isEmpty(fullSearchText1)) {
    		return "";
    	}
        return this.fullSearchText1;
    }
    
    public String fullSearchText2;

    public void setFullSearchText2(String fullSearchText2) {
        this.fullSearchText2 = fullSearchText2;
    }

    public String getFullSearchText2() {
    	if(Util.isEmpty(fullSearchText2)) {
    		return "";
    	}
        return this.fullSearchText2;
    }
    
    public String fullSearchText3;

    public void setFullSearchText3(String fullSearchText3) {
        this.fullSearchText3 = fullSearchText3;
    }

    public String getFullSearchText3() {
        if(fullSearchText3 == null) {
        	fullSearchText3 = "";
        }
        return this.fullSearchText3;
    }
    
    public String fullSearchText4;

    public void setFullSearchText4(String fullSearchText4) {
        this.fullSearchText4 = fullSearchText4;
    }

    public String getFullSearchText4() {
        if(fullSearchText4 == null) {
        	fullSearchText4 = "";
        }
        return this.fullSearchText4;
    }
    
    private String Creator2 = Cnstnts.EMPTY_STRING;

	public void setCreator2(String Creator2) {
		this.Creator2 = Creator2;
	}

	public String getCreator2() {
		return this.Creator2;
	}

	private String DataDept2 = Cnstnts.EMPTY_STRING;

	public void setDataDept2(String DataDept2) {
		this.DataDept2 = DataDept2;
	}

	public String getDataDept2() {
		return this.DataDept2;
	}
	
	public List<Field> searchCondFieldList1;

    public List<Field> getSearchCondFieldList1() {
		return searchCondFieldList1;
	}

	public void setSearchCondFieldList1(List<Field> searchCondFieldList1) {
		this.searchCondFieldList1 = searchCondFieldList1;
	}
	
	public List<Field> searchCondFieldList2;

	public List<Field> getSearchCondFieldList2() {
		return searchCondFieldList2;
	}

	public void setSearchCondFieldList2(List<Field> searchCondFieldList2) {
		this.searchCondFieldList2 = searchCondFieldList2;
	}
	
	public List<Field> searchCondFieldList3;

	public List<Field> getSearchCondFieldList3() {
		return searchCondFieldList3;
	}

	public void setSearchCondFieldList3(List<Field> searchCondFieldList3) {
		this.searchCondFieldList3 = searchCondFieldList3;
	}
    
    public Field ClientContect;
    public void setClientContect(String ClientContect){this.ClientContect.setValue(ClientContect);}
    public String getClientContect(){return this.ClientContect.getValue();}
    
    public Field CaseApplicant;
    public void setCaseApplicant(String CaseApplicant){this.CaseApplicant.setValue(CaseApplicant);}
    public String getCaseApplicant(){return this.CaseApplicant.getValue();}
    
    public Field CaseInventor;
    public void setCaseInventor(String CaseInventor){this.CaseInventor.setValue(CaseInventor);}
    public String getCaseInventor(){return this.CaseInventor.getValue();}
    
    public Field Country;
    public void setCountry(String Country){this.Country.setValue(Country);}
    public String getCountry(){return this.Country.getValue();}
    
	
	private String[] MarkKeys;
    public void setMarkKeys(String[] markKeys){this.MarkKeys=markKeys;}
    public String[] getMarkKeys(){return this.MarkKeys;}
    
    private String processType;

    public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}
	/*
	 private String newInsertFlag;

	 public String getNewInsertFlag() {
			return newInsertFlag;
	 }

	 public void setNewInsertFlag(String newInsertFlag) {
			this.newInsertFlag = newInsertFlag;
	 }
	*/
	private String oldCaseFlowKey;

	public String getOldCaseFlowKey() {
		return oldCaseFlowKey;
	}

	public void setOldCaseFlowKey(String oldCaseFlowKey) {
		this.oldCaseFlowKey = oldCaseFlowKey;
	}
    
    public Field ServiceProjectCode;
    public void setServiceProjectCode(String ServiceProjectCode){this.ServiceProjectCode.setValue(ServiceProjectCode);}
    public String getServiceProjectCode(){return this.ServiceProjectCode.getValue();}
    
    public Field QuotationFlowKey;
    public void setQuotationFlowKey(String QuotationFlowKey){this.QuotationFlowKey.setValue(QuotationFlowKey);}
    public String getQuotationFlowKey(){return this.QuotationFlowKey.getValue();}
    
    public Field FromCaseNo;
    public void setFromCaseNo(String FromCaseNo){this.FromCaseNo.setValue(FromCaseNo);}
    public String getFromCaseNo(){return this.FromCaseNo.getValue();}
    
    public Field CaseNo2;
    public void setCaseNo2(String CaseNo2){this.CaseNo2.setValue(CaseNo2);}
    public String getCaseNo2(){return this.CaseNo2.getValue();}
    
    public Field CaseNo;
    public void setCaseNo(String CaseNo){this.CaseNo.setValue(CaseNo);}
    public String getCaseNo(){return this.CaseNo.getValue();}
    
    public String copyApplicantFlag;
	
	public String getCopyApplicantFlag() {
		return copyApplicantFlag;
	}

	public void setCopyApplicantFlag(String copyApplicantFlag) {
		this.copyApplicantFlag = copyApplicantFlag;
	}
	
	public String financialFlag;

	public String getFinancialFlag() {
		return financialFlag;
	}

	public void setFinancialFlag(String financialFlag) {
		this.financialFlag = financialFlag;
	}
	
	
	
    public Field CaseAD;
    public void setCaseAD(String CaseAD){this.CaseAD.setValue(CaseAD);}
    public String getCaseAD(){return this.CaseAD.getValue();}
    
    public Field CaseAssignedTo;
    public void setCaseAssignedTo(String CaseAssignedTo){this.CaseAssignedTo.setValue(CaseAssignedTo);}
    public String getCaseAssignedTo(){return this.CaseAssignedTo.getValue();}
    
    public Field CloseDate;
    public void setCloseDate(String CloseDate){this.CloseDate.setValue(CloseDate);}
    public String getCloseDate(){return this.CloseDate.getValue();}
	
	public void init() {
        super.init();
        this.setProgramId("jsp.PatentCase");
        this.setTableName("PatentCase");
        
        CaseKind = "P";
        
        this.useFieldWidth = true;
        this.searchListMarkKeys = true;
        this.Referrals = new Field("Referrals", this.getTableName());
        this.Referrals.setDbType("varchar(50)");
        
        this.ContactDate = new Field("ContactDate", this.getTableName());
        this.ContactDate.setDbType("varchar(50)");
        
        this.CloseDate = new Field("CloseDate", this.getTableName());
        this.CloseDate.setDbType("varchar(50)");
        
        this.CaseAssignedTo = new Field("CaseAssignedTo", this.getTableName());
        this.CaseAssignedTo.setDbType("varchar(50)");
        this.CaseAssignedTo.setFieldWidth(4);
        
        this.CaseAD = new Field("CaseAD", this.getTableName());
        this.CaseAD.setDbType("varchar(50)");
        this.CaseAD.setFieldWidth(4);

        this.SpecialRequest = new Field("SpecialRequest", this.getTableName());
        this.SpecialRequest.setDbType("varchar(500)");

        this.Matter = new Field("Matter", "ToDos");
        this.Matter.setDbType("varchar(50)");
        
        this.IsCharge = new Field("IsCharge","ToDos");
        this.IsCharge.setDbType("char(1)");
        this.IsCharge.setFieldWidth(4);
        
        this.IsPayment = new Field("IsPayment","ToDos");
        this.IsPayment.setDbType("char(1)");
        
        this.ToDosStatus = new Field("ToDosStatus", "ToDos");
        this.ToDosStatus.setDbType("varchar(50)");
        
        this.FlowKey.setSearchCondition(Cnstnts.LIKE);
        
        this.ImageUrl = new Field("ImageUrl", this.getTableName());
        this.ImageUrl.setDbType("varchar(100)");
        this.ImageUrl.setFieldWidth(10);
        this.ImageUrl.setIsShowImage(true);
        
        this.CaseStartDate= new Field("CaseStartDate",this.getTableName());
        this.CaseStartDate.setDbType("varchar(20)");
        this.CaseStartDate.setFieldWidth(10);

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
        
        this.CaseAttribute = new Field("CaseAttribute", this.getTableName());
        this.CaseAttribute.setDbType("varchar(50)");
        
        this.PatentCaseType = new Field("PatentCaseType", this.getTableName());
        this.PatentCaseType.setDbType("varchar(50)");
        this.PatentCaseType.setFieldWidth(3);
        
        this.ClientName = new Field("ClientName", this.getTableName());
        this.ClientName.setSearchCondition(Cnstnts.LIKE);
        this.ClientName.setFieldWidth(10);
        
        this.NotFinished = new Field("NotFinished", this.getTableName());

        this.PatentOffice = new Field("PatentOffice", this.getTableName());
        this.PatentOffice.setDbType("varchar(50)");
        this.PatentOffice.setCheckEmpty(true);
        this.PatentOffice.setSize(10);
        this.PatentOffice.setFieldWidth(3);

        this.PatentType = new Field("PatentType", this.getTableName());
        this.PatentType.setDbType("varchar(50)");
        this.PatentType.setCheckEmpty(true);
        this.PatentType.setFieldWidth(3);

        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("nvarchar(500)");
        this.Title.setFieldWidth(20);
//        this.Title.setCheckEmpty(true);
        this.Title.setSearchCondition(Cnstnts.LIKE);
        
        this.EnglishTitle = new Field("EnglishTitle", this.getTableName());
        this.EnglishTitle.setDbType("nvarchar(500)");
        this.EnglishTitle.setFieldWidth(20);
        this.EnglishTitle.setSearchCondition(Cnstnts.LIKE);

        this.OriginalTitle = new Field("OriginalTitle", this.getTableName());
        this.OriginalTitle.setCheckEmpty(true);
        this.OriginalTitle.setDbType("nvarchar(500)");
        this.OriginalTitle.setFieldWidth(20);
        this.OriginalTitle.setSearchCondition(Cnstnts.LIKE);
        
        this.ApplyDate = new Field("ApplyDate", this.getTableName());
        this.ApplyDate.setDbType("varchar(10)");
        this.ApplyDate.setFieldWidth(10);

        this.ApplyNo = new Field("ApplyNo", this.getTableName());
        this.ApplyNo.setDbType("varchar(50)");
        this.ApplyNo.setSearchCondition(Cnstnts.LIKE);
        this.ApplyNo.setFieldWidth(14);
        
        
        this.PublishDate = new Field("PublishDate", this.getTableName());
        this.PublishDate.setDbType("varchar(10)");
        this.PublishDate.setFieldWidth(10);

        this.PublishNo = new Field("PublishNo", this.getTableName());
        this.PublishNo.setDbType("varchar(50)");
        this.PublishNo.setFieldWidth(14);
        
        this.IssueDate = new Field("IssueDate", this.getTableName());
        this.IssueDate.setDbType("varchar(10)");
        this.IssueDate.setFieldWidth(10);

        this.IssueNo = new Field("IssueNo", this.getTableName());
        this.IssueNo.setDbType("varchar(50)");
        this.IssueNo.setFieldWidth(9);
        
        
        this.LicenseDate = new Field("LicenseDate", this.getTableName());
        this.LicenseDate.setDbType("varchar(10)");
        this.LicenseDate.setFieldWidth(10);

        this.LicenseNo = new Field("LicenseNo", this.getTableName());
        this.LicenseNo.setDbType("varchar(50)");
        this.LicenseNo.setSearchCondition(Cnstnts.LIKE);
        this.LicenseNo.setFieldWidth(9);

        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");
        this.Status.setFieldWidth(4);
        this.Status.setCheckEmpty(true);

        this.GiveupCode = new Field("GiveupCode", this.getTableName());
        this.GiveupCode.setDbType("varchar(50)");

        this.InCharge = new Field("InCharge", this.getTableName());
        this.InCharge.setDbType("varchar(50)");
        this.InCharge.setFieldWidth(4);

        this.OutsourceDate = new Field("OutsourceDate", this.getTableName());
        this.OutsourceDate.setDbType("varchar(10)");
        
        this.FeeScheduleDate = new Field("FeeScheduleDate", this.getTableName());
        this.FeeScheduleDate.setDbType("varchar(10)");
        this.FeeScheduleDate.setFieldWidth(10);
        
        this.FeeScheduleDateTo = new Field("FeeScheduleDateTo", this.getTableName());
        
        this.FeeSchedule = new Field("FeeSchedule", this.getTableName());
        this.FeeSchedule.setDbType("float");
        this.FeeSchedule.setDecimal(1);
        this.FeeSchedule.setFieldWidth(2);
        
        this.SignOutId = new Field("SignOutId", this.getTableName());
        this.SignOutId.setDbType("varchar(50)");
        
        this.SignOutTime = new Field("SignOutTime", this.getTableName());
        this.SignOutTime.setDbType("varchar(20)");
        
        this.SignOutName = new Field("SignOutName", this.getTableName());
        this.SignOutName.setDbType("nvarchar(50)");
        
        this.ProjectCode = new Field("ProjectCode", this.getTableName());
        this.ProjectCode.setDbType("nvarchar(50)");
        
        this.Keyword = new Field("Keyword", this.getTableName());
        this.Keyword.setDbType("nvarchar(50)");
        
        this.TechCategory = new Field("TechCategory", this.getTableName());
        this.TechCategory.setDbType("nvarchar(50)");
        
        this.FuncCategory = new Field("FuncCategory", this.getTableName());
        this.FuncCategory.setDbType("nvarchar(50)");
        
        this.Ipc = new Field("Ipc", this.getTableName());
        this.Ipc.setDbType("nvarchar(500)");
        
        this.Uspc = new Field("Uspc", this.getTableName());
        this.Uspc.setDbType("nvarchar(500)");
        
        this.Fi = new Field("Fi", this.getTableName());
        this.Fi.setDbType("nvarchar(500)");
        
        this.Locarno = new Field("Locarno", this.getTableName());
        this.Locarno.setDbType("nvarchar(500)");
        
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
        this.RightBeginDate.setFieldWidth(10);
        
        this.RightEndDate = new Field("RightEndDate", this.getTableName());
        this.RightEndDate.setDbType("nvarchar(10)");
        this.RightEndDate.setFieldWidth(10);
        
        this.PctAppDate = new Field("PctAppDate", this.getTableName());
        this.PctAppDate.setDbType("nvarchar(10)");
        
        this.PctAppNo = new Field("PctAppNo", this.getTableName());
        this.PctAppNo.setDbType("nvarchar(50)");
        this.PctAppNo.setFieldWidth(14);
        
        this.PctPublishDate = new Field("PctPublishDate", this.getTableName());
        this.PctPublishDate.setDbType("nvarchar(10)");
        
        this.WipoNo = new Field("WipoNo", this.getTableName());
        this.WipoNo.setDbType("nvarchar(50)");
        
        this.NationalPhaseDate = new Field("NationalPhaseDate", this.getTableName());
        this.NationalPhaseDate.setDbType("nvarchar(10)");
        
        this.DeliveryDate = new Field("DeliveryDate", this.getTableName());
        this.DeliveryDate.setDbType("varchar(10)");
        this.DeliveryDate.setFieldWidth(10);
        
        this.Remark = new Field("Remark", this.getTableName());
        this.Remark.setDbType("text");
        
        this.Ids = new Field("Ids", this.getTableName());
        this.Ids.setDbType("varchar(1)");
        
        this.Priority = new Field("Priority", this.getTableName());
        this.Priority.setDbType("varchar(1)");
        
        this.IdsCaseNo = new Field("IdsCaseNo", this.getTableName());
        this.IdsCaseNo.setDbType("varchar(50)");
        
        this.PriorityCaseNo = new Field("PriorityCaseNo", this.getTableName());
        this.PriorityCaseNo.setDbType("varchar(50)");
        
        this.OtherCaseNo = new Field("OtherCaseNo", this.getTableName());
        this.OtherCaseNo.setDbType("varchar(50)");
        
        this.SerialMotherCase = new Field("SerialMotherCase", this.getTableName());
        this.SerialMotherCase.setDbType("varchar(50)");
//        this.SerialMotherCase.setCheckEmpty(true);
        this.SerialMotherCase.setFieldWidth(11);
        
        this.Entity = new Field("Entity", this.getTableName());
        this.Entity.setDbType("varchar(50)");
        
        this.LastSchedule = new Field("LastSchedule", this.getTableName());
        this.LastSchedule.setDbType("varchar(50)");
        this.LastSchedule.setFieldWidth(20);
        
        this.InternalNo = new Field("InternalNo", this.getTableName());
        this.InternalNo.setDbType("varchar(50)");
        this.InternalNo.setFieldWidth(11);
        
        this.Attorney = new Field("Attorney", this.getTableName());
        this.Attorney.setDbType("varchar(50)");
        this.Attorney.setFieldWidth(8);
        
        this.PriorityDeadLine = new Field("PriorityDeadLine", this.getTableName());
        this.PriorityDeadLine.setDbType("varchar(10)");

        this.WrittenMan = new Field("WrittenMan", this.getTableName());
        this.WrittenMan.setDbType("varchar(50)");

        this.WrittenFinishedDate = new Field("WrittenFinishedDate", this.getTableName());
        this.WrittenFinishedDate.setDbType("varchar(10)");

        this.MappingMan = new Field("MappingMan", this.getTableName());
        this.MappingMan.setDbType("nvarchar(50)");
        
        this.MappingFinishedDate = new Field("MappingFinishedDate", this.getTableName());
        this.MappingFinishedDate.setDbType("varchar(10)");
        
        this.TranslateMan = new Field("TranslateMan", this.getTableName());
        this.TranslateMan.setDbType("varchar(50)");

        
        this.TranslateFinishedDate = new Field("TranslateFinishedDate", this.getTableName());
        this.TranslateFinishedDate.setDbType("varchar(10)");
        
        this.RejectionMan = new Field("RejectionMan", this.getTableName());
        this.RejectionMan.setDbType("varchar(50)");
        
        this.RejectionFinishedDate = new Field("RejectionFinishedDate", this.getTableName());
        this.RejectionFinishedDate.setDbType("varchar(10)");
        
        this.ReplyMan = new Field("ReplyMan", this.getTableName());
        this.ReplyMan.setDbType("varchar(50)");
                
        this.ReplyFinishedDate = new Field("ReplyFinishedDate", this.getTableName());
        this.ReplyFinishedDate.setDbType("varchar(10)");
        
        this.AutoPay = new Field("AutoPay", this.getTableName());
        this.AutoPay.setDbType("varchar(1)");
        
        this.PaymentConfirming = new Field("PaymentConfirming", this.getTableName());
        this.PaymentConfirming.setDbType("varchar(1)");
        
        this.CaseInventor = new Field("CaseInventor", this.getTableName());
        this.CaseInventor.setDbType("varchar(50)");
        
        this.CaseApplicant = new Field("CaseApplicant", this.getTableName());
        this.CaseApplicant.setDbType("varchar(50)");
        
        this.Country = new Field("Country", this.getTableName());
        this.Country.setDbType("varchar(50)");
        
        this.ClientContect = new Field("ClientContect", this.getTableName());
        this.ClientContect.setDbType("varchar(50)");
        this.ClientContect.setFieldWidth(4);
        
        this.AttorneyNum = new Field("AttorneyNum", this.getTableName());
        this.AttorneyNum.setDbType("varchar(50)");
        this.AttorneyNum.setFieldWidth(10);
        
        this.ApplyTransDate = new Field("ApplyTransDate", this.getTableName());
        this.ApplyTransDate.setDbType("varchar(10)");
        
        this.ApplyTransTo = new Field("ApplyTransTo", this.getTableName());
        this.ApplyTransTo.setDbType("varchar(200)");
        
        this.RightTransDate = new Field("RightTransDate", this.getTableName());
        this.RightTransDate.setDbType("varchar(10)");
        
        this.RightTransTo = new Field("RightTransTo", this.getTableName());
        this.RightTransTo.setDbType("varchar(200)");
        
        this.FromCase = new Field("FromCase", this.getTableName());
        this.FromCase.setDbType("varchar(50)");
        
        this.ApplicantCopyCheck = new Field("ApplicantCopyCheck", this.getTableName());
        this.ApplicantCopyCheck.setDbType("varchar(50)");
        
        this.AttorneyCopyCheck = new Field("AttorneyCopyCheck", this.getTableName());
        this.AttorneyCopyCheck.setDbType("varchar(50)");
        
        this.InventorCopyCheck = new Field("InventorCopyCheck", this.getTableName());
        this.InventorCopyCheck.setDbType("varchar(50)");
        
        this.PriorityCopyCheck = new Field("PriorityCopyCheck", this.getTableName());
        this.PriorityCopyCheck.setDbType("varchar(50)");
        
        this.CaseApplicantNames = new Field("CaseApplicantNames", this.getTableName());
        this.CaseApplicantNames.setDbType("varchar(50)");
        this.CaseApplicantNames.setFieldWidth(10);
        
        this.CaseInventorNames = new Field("CaseInventorNames", this.getTableName());
        this.CaseInventorNames.setDbType("varchar(50)");
        this.CaseInventorNames.setFieldWidth(8);
        
        this.PriorityDate = new Field("PriorityDate", this.getTableName());
        this.PriorityDate.setDbType("varchar(50)");
        this.PriorityDate.setFieldWidth(10);
        
        this.PriorityNo = new Field("PriorityNo", this.getTableName());
        this.PriorityNo.setDbType("varchar(50)");
        this.PriorityNo.setFieldWidth(14);
        
        this.ServiceProjectCode = new Field("ServiceProjectCode", this.getTableName());
        this.ServiceProjectCode.setDbType("varchar(50)");
        
        this.QuotationFlowKey = new Field("QuotationFlowKey", this.getTableName());
        this.QuotationFlowKey.setDbType("varchar(50)");
        
        this.CaseNo2 = new Field("CaseNo2", this.getTableName());
        this.CaseNo2.setDbType("varchar(50)");
        this.CaseNo2.setFieldWidth(11);
        
        this.CaseNo = new Field("CaseNo", this.getTableName());
        this.CaseNo.setDbType("varchar(50)");
        this.CaseNo.setCheckEmpty(true);
        this.CaseNo.setFieldWidth(11);

        this.PctNationalPhase = new Field("PctNationalPhase", this.getTableName());
        this.PctNationalPhase.setDbType("varchar(50)");
        
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
        this.DbFields.add(this.SpecialRequest);
        this.DbFields.add(this.CloseDate);
        this.DbFields.add(this.ClientName);
        this.DbFields.add(this.CaseAssignedTo);
        this.DbFields.add(this.ServiceProjectCode);
        this.DbFields.add(this.CaseAD);
        
        this.DbFields.add(this.CaseStartDate);
        this.DbFields.add(this.ImageUrl);
        this.DbFields.add(this.CaseNo);
        this.DbFields.add(this.CaseNo2);

        this.DbFields.add(this.Summary);

        this.DbFields.add(this.IdeaId);

        this.DbFields.add(this.FamilyOrder);
        
        this.DbFields.add(this.Client);
        
        this.DbFields.add(this.CaseAttribute);

        this.DbFields.add(this.PatentOffice);

        this.DbFields.add(this.PatentType);
        this.DbFields.add(this.PatentCaseType);

        this.DbFields.add(this.Title);
        
        this.DbFields.add(this.EnglishTitle);

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
        
        this.DbFields.add(this.DeliveryDate);
        
        this.DbFields.add(this.Remark);
        
        this.DbFields.add(this.OtherCaseNo);
        
        this.DbFields.add(this.PriorityCaseNo);
        
        this.DbFields.add(this.IdsCaseNo);
        
        this.DbFields.add(this.Priority);
        
        this.DbFields.add(this.Ids);
        
        this.DbFields.add(this.SerialMotherCase);
        
        this.DbFields.add(this.Entity);
        
        this.DbFields.add(this.LastSchedule);
        
        this.DbFields.add(this.InternalNo);
        
        this.DbFields.add(this.Attorney);
        
        this.DbFields.add(this.PriorityDeadLine);

        this.DbFields.add(this.WrittenMan);

        this.DbFields.add(this.WrittenFinishedDate);

        this.DbFields.add(this.MappingMan);
        
        this.DbFields.add(this.MappingFinishedDate);
        
        this.DbFields.add(this.TranslateMan);
        
        this.DbFields.add(this.TranslateFinishedDate);
        
        this.DbFields.add(this.RejectionMan);
        
        this.DbFields.add(this.RejectionFinishedDate);
        
        this.DbFields.add(this.ReplyMan);
        
        this.DbFields.add(this.ReplyFinishedDate);
        
        this.DbFields.add(this.AutoPay);
        
        this.DbFields.add(this.PaymentConfirming);
        
        this.DbFields.add(this.ClientContect);
        
        this.DbFields.add(this.AttorneyNum);
        
        this.DbFields.add(this.ApplyTransDate);
        
        this.DbFields.add(this.ApplyTransTo);
        
        this.DbFields.add(this.RightTransDate);
        
        this.DbFields.add(this.RightTransTo);
        
        this.DbFields.add(this.FromCase);
        this.DbFields.add(this.QuotationFlowKey);
        this.DbFields.add(this.PctNationalPhase);
        this.DbFields.add(this.Referrals);
        this.DbFields.add(this.ContactDate);
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

		/*
         * 1.增加一列表式tab "權限"，專利商標法務案件的權限就來讀這個tab，如示意圖，此tab僅預設成員可進行編輯，
         * 預設成員為admin以及G01。增加來源成員為員工，選了之後可選擇可否檢視、編輯（亦可列印）、
         * 可否看到此tab，預設成員所有選項皆打勾，且不可被編輯刪除。
         */

		boolean editable = true;
		
		CasePrivilege cp = new CasePrivilege(this.getUserInfo().getAttribute("emp_id"), this.getUserInfo().getAttribute("dept_id"), this.getCaseKind(), this.getFlowKey());;
        if(!Util.isAdminOrG01(this.getUserInfo()) && !cp.isEditable()) {
        	editable = false;
        }
        
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())
				&& this.getDbActionList() == null) {
			//沒有案件權限
			if(Util.isEmpty(cp.getFlowKey())) {
				this.setDbActionList(getUserInfo().getDbActionList(this.getProgramId()));
			}
			else {
				/*
				 * 有案件權限，不過也要判斷這筆資料是否為正常有權限找出的資料
				 * 不是的話就只單獨看案件權限設定
				 */
				if(this.canFindData()) {
					this.setDbActionList(getUserInfo().getDbActionList(this.getProgramId(), cp));
				}
				else {
					this.setDbActionList(getUserInfo().getDbActionList(cp));
				}
			}
		}
		
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())){
			String onChange = "setPatentCaseValue()";
			List<String[]> dbActionList = this.getDbActionList();
			//新增資料的模式下 按鈕應該僅呈現如下，而能使用的按鈕僅有“清空”、“送出”、“儲存並新增”，其他皆呈現disable的按鈕
			if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
				for(int i=0;i<dbActionList.size();i++) {
					String[] dbAction = dbActionList.get(i);
					
					if(dbAction.length == 2) {
						String[] newAction = {dbAction[0], dbAction[1], Cnstnts.FALSE_FLAG};
						dbAction = newAction;
					}
					else if(dbAction.length == 3) {
						dbAction[3] = Cnstnts.FALSE_FLAG;
					}
					
					dbActionList.set(i, dbAction);
				}
			}
			SelectOneTag selectItem = new SelectOneTag(Cnstnts.DB_ACTION_MODE,
					onChange, this.getDbActionMode(), dbActionList);

			rtnString = selectItem.toButtonString();
		}
		return rtnString;
	}

	public String printHtmlBody() throws Exception {
		sout("DO printHtmlBody!");
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine + "<table id='bodyTable' " + getTableBgcolor() + ">";
		sout("0rtnString=>" + rtnString.substring(0, (rtnString.length()<1000?rtnString.length():1000)));
		
		if (this.onSearchMode()) {
//			rtnString += super.FlowKey.printHiddenTag();
//			rtnString += this.printSearchTable();
			
			rtnString += newLine + "<tr bgcolor='#E9EDF4'><td colspan='4'>";
			rtnString += newLine + "<table border='0' bgcolor='#F9FAFC' width='100%'><tr><td width='100%'>";
			rtnString += newLine + "<table border='0' bgcolor='#F9FAFC' width='100%' align='right'>";
			rtnString += super.FlowKey.printHiddenTag();
			rtnString += this.printSearchTable();
			rtnString += newLine + "</table>";
			rtnString += newLine + "</td></tr>";
			rtnString += newLine + "</table></td></tr>";
			
			rtnString += "<tr bgcolor='#E9EDF4'><td colspan='3' width='85%'><table width='100%' bgcolor='#F9FAFC'>";
			rtnString += this.printResultFieldHtml();
			rtnString += Cnstnts.NEW_LINE + "</table></td><td width='15%' bgcolor='#E9EDF4' valign='top'>";
			rtnString += "<input type='checkbox' onClick='selectAllResultField(this);'>" + this.getUserInfo().getMsg("jsp.common.SelectAll");
			rtnString += Cnstnts.NEW_LINE + "</td></tr>";

		} else {
			sout("DO else!");
			Date date = new Date();
			rtnString += "<tr><td colspan='3' width='80%'><table width='100%'>";
			rtnString += "<input type='hidden' name='dbActionMode' id='dbActionMode' value='" + this.getDbActionMode() + "'>";
			rtnString += this.printMaintainTable();
			sout("1rtnString=>" + rtnString.substring(0, (rtnString.length()<1000?rtnString.length():1000)));
			
			//System.out.println("= m 01 " + (new Date().getTime() - date.getTime()));
			date = new Date();
			
			//新增代表圖示上方基本欄位處, 上載後，可呈現縮圖，目前版面有點滿，
            //排版要重排將目前兩欄的欄位整個往左移出空間讓縮圖呈現在右邊。
            rtnString += Cnstnts.NEW_LINE + "</table></td><td width='20%' bgcolor='#E9EDF4'><table width='100%'>";
			rtnString += this.printUploadImageHtml();
            rtnString += Cnstnts.NEW_LINE + "</table></td></tr>";
			
			//System.out.println("= m 02 " + (new Date().getTime() - date.getTime()));
			date = new Date();
			
            rtnString += "<tr width='100%' align='right'><td colspan='4'>";
            if(!this.getDbActionMode().equals(Cnstnts.PRINT)) {
            	rtnString += this.getSubmitBtn();
            }
			
			//System.out.println("= m 03 " + (new Date().getTime() - date.getTime()));
			date = new Date();
			
			rtnString += Cnstnts.NEW_LINE + "</td></tr>";
            
            rtnString += this.printTabAreaHtml();
			
			//System.out.println("= m 04 " + (new Date().getTime() - date.getTime()));
			date = new Date();
			
		}
		rtnString += newLine + "</table>";
		 
		if (this.onSearchMode()) {
//			this.setResultFields();
			rtnString += this.printSearchReasult();
		}
		return rtnString;
	}

    
    public String printUploadImageHtml() throws Exception {
    	String rtnString = "";
    	if(this.onMaintainMode()) {
    		this.ImageUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
    		this.ImageUrl.setSize(10);
    		rtnString += this.printHtml(this.ImageUrl);

    		if(!Util.isEmpty(this.ImageUrl.getValue())) {
    			rtnString += "<tr><td colspan='4'><img src='" + this.ImageUrl.getValue() + "' width='260' height='195'></td></tr>";
    		}
    		else {
    			rtnString += "<tr><td></td></tr>";
    		}
    	}
    	return rtnString;
    }
    
    public String printTabAreaHtml() throws Exception {
    	String rtnString = "";
    	if(this.onMaintainMode()) {
            rtnString += this.SignOutId.printHiddenTag();

            rtnString += this.Summary.printHiddenTag();
            
            if(this.TabText.getValue().trim().length() == 0) {
                this.TabText.setValue("PatentSecondPage");
            }
            rtnString += this.TabText.printHiddenTag();
            

        	Date date = new Date();
            if(this.FlowKey.getValue().trim().length() > 0 &&
            		this.getDbActionMode().equals(Cnstnts.INSERT) &&
        			!this.getClearFlag().equals(Cnstnts.TRUE_FLAG)) {
                
            	
            	String TabSelect = Cnstnts.EMPTY_STRING;
            	rtnString += "<script type='text/javascript'>$(function(){$('#tabs').tabs(" +TabSelect + ");});</script>";
            	rtnString += "<script type='text/javascript'>$(function(){$('#tabs2').tabs(" +TabSelect + ");});</script>";
            	
            	//System.out.println("==t 1 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	
            	rtnString += "<tr><td colspan=4>"+
				"<div id='tabs'><ul>"+
				"<li><a href='#tabs-1'>"+this.getUserInfo().getMsg("jsp.PatentCase.PatentOther")+"</a></li>" ;
            	rtnString += "</ul>";
            	 /**** tabs-1 ****/
            	rtnString +="<div id='tabs-1'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateDetailTableDiv' name='updateDetailTableDiv'></div>";
	            rtnString +="<div id='DetailTableDiv' name='DetailTableDiv'>";
	            rtnString += printDetailTable();
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-1 end ****/

            	//System.out.println("==t 3 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	
    	        rtnString += "</div>";

                rtnString += "</td></tr>";
    		}
            
            if(this.FlowKey.getValue().trim().length() > 0 && !this.getDbActionMode().equals(Cnstnts.INSERT) ) {
            	//[下午 04:27:55] Ray Chu: 如果客戶想要PatentCase裡面的期限管制如果有未完成的事項的話，
                //進入到該案後，代辦事項的按鈕的字會呈現紅色&（未完成件數）
                String countSql = "SELECT count(1) as count  FROM todos  WHERE toDosStatus != 'TDS02' and  ParentId = '" + this.getFlowKey() + "'";
                String count = this.getDbUtil().getFieldValue(countSql, new Field("count"));

            	//System.out.println("==t 4 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

            	
            	rtnString += "<tr><td colspan=4>"+
						"<div id='tabs'><ul>"+
						"<li><a href='#tabs-1'>"+this.getUserInfo().getMsg("jsp.PatentCase.PatentOther")+"</a></li>" +
						"<li><a href='#tabs-2'>"+this.getUserInfo().getMsg("jsp.PatentDocument.title")+"</a></li>";
            	if(count.equals("0")) {
            		rtnString += "<li><a href='#tabs-3'>"+this.getUserInfo().getMsg("jsp.ToDos.title")+"</a></li>";
            	}
            	else {
            		rtnString += "<li><a href='#tabs-3'><font color='red'>" + this.getUserInfo().getMsg("jsp.ToDos.title") + 
            							"(" + count +  ")"+"</font></a></li>";
            	}

            	/*
                 * 1.增加一列表式tab "權限"，專利商標法務案件的權限就來讀這個tab，如示意圖，此tab僅預設成員可進行編輯，
                 * 預設成員為admin以及G01。
                 */
        		CasePrivilege cp2 = new CasePrivilege(this.getUserInfo().getAttribute("emp_id"), this.getUserInfo().getAttribute("dept_id"), this.getCaseKind(), this.getFlowKey());;
                if(Util.isAdminOrG01(this.getUserInfo()) || cp2.isTabable()) {
                	rtnString += "<li><a href='#tabs-15'>"+this.getUserInfo().getMsg("jsp.CasePrivilege.title")+"</a></li>";
                }
            	rtnString += "<li><a href='#tabs-4'>"+this.getUserInfo().getMsg("jsp.PatentApplicant.title")+"</a></li>";
            	rtnString += "<li><a href='#tabs-5'>"+this.getUserInfo().getMsg("jsp.PatentInventor.title")+"</a></li>";
            	rtnString += "<li><a href='#tabs-6'>"+this.getUserInfo().getMsg("jsp.PatentAttorney.title")+"</a></li>";
            	

            	//優先權tab若有key資料，頁籤上的"優先權"變紅字
            	countSql = "SELECT count(1) as count  FROM PatentPriority WHERE  ParentId = '" + this.getFlowKey() + "'";
            	int countInt = this.getDbUtil().getSqlIntValue(countSql, "count");
            	if(countInt > 0) {
            		rtnString += "<li><a href='#tabs-7'><font color='red'>"+this.getUserInfo().getMsg("jsp.PatentPriority.title")+"</font></a></li>";
            	}
            	else {
            		rtnString += "<li><a href='#tabs-7'>"+this.getUserInfo().getMsg("jsp.PatentPriority.title")+"</a></li>";
            	}
            	rtnString += "<li><a href='#tabs-11'>"+this.getUserInfo().getMsg("jsp.PatentCitation.title")+"</a></li>";
            	

            	/*
            	 * 其中“美國IDS”的Tab僅會顯示在該筆PatentCase的PatentOffice為“US”的時候才會顯示
            	 * 其中“歐洲IDS”的Tab僅會顯示在該筆PatentCase的PatentOffice為“EP”的時候才會顯示
            	 */
            	if(Util.compareTo(this.getPatentOffice(), "US")) {
            		rtnString += "<li><a href='#tabs-12'>"+this.getUserInfo().getMsg("jsp.PatentCitation.USHeader")+"</a></li>";
            	}
            	else if(Util.compareTo(this.getPatentOffice(), "EP")) {
            		rtnString += "<li><a href='#tabs-13'>"+this.getUserInfo().getMsg("jsp.PatentCitation.EPHeader")+"</a></li>";
            	}
            	rtnString += "<li><a href='#tabs-14'>"+this.getUserInfo().getMsg("jsp.PatentCase.RenewalLogTab.title")+"</a></li>";

				
            	Groups group = new Groups();
            	//關聯訂單tab調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
				if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
            	rtnString += "<li><a href='#tabs-c6'>"+ this.getUserInfo().getMsg("jsp.Quotation.Tab3") + "</a></li>";
				}

    			rtnString += "<li><a href='#tabs-sm'>"+ this.getUserInfo().getMsg("jsp.SignedManage.ReleatedSigned") + "</a></li>";
            	rtnString += "</ul>";

	            /**** tabs-1 ****/
            	rtnString +="<div id='tabs-1'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateDetailTableDiv' name='updateDetailTableDiv'></div>";
	            rtnString +="<div id='DetailTableDiv' name='DetailTableDiv'>";
	            rtnString += printDetailTable();
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-1 end ****/

            	//System.out.println("==t 9 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            /**** tabs-2 ****/
            	rtnString +="<div id='tabs-2'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updatePatentDocumentDiv' name='updatePatentDocumentDiv'></div>";
	            rtnString +="<div id='PatentDocumentDiv' name='PatentDocumentDiv'>";
	            //rtnString += new PatentDocument().getSearchReasult(this.getUserInfo(), this.getFlowKey());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-2 end ****/

            	//System.out.println("==t 10 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            /**** tabs-3 ****/
	            /*
	             * 2013/1/8
	             * "已請款台幣總金額  - 已收款台幣總金額 – 他方扣繳台幣總額(資料來源：Invoice.TotalWithHolding)  = 未收款台幣總金額"
	             */
//	            String count1 = "";
//	            String count2 = "";
//	            String count3 = "";
//	            String count4 = "";
//	            DecimalFormat df = new DecimalFormat("###,###");
//	            
//	            String SQL = "select sum(requestPayAmount) as Count from todos where parentid ='" + this.getFlowKey() + "'";
//	            count1 = this.getDbUtil().getFieldValue(SQL, "Count");
//	            
//	            SQL = "select sum(AlreadyWriteOffAmount) as Count from invoicedetail where todosid in (select flowkey from todos where parentid ='" + this.getFlowKey() + "')";
//	            count2 = this.getDbUtil().getFieldValue(SQL, "Count");
//	            
//	            String sql = "select sum(Tax2) as Count from invoicedetail " +
//	            		"where todosid in (select flowkey from todos where parentid ='" + this.getFlowKey() + "') " +
//	            		"and WithHolding='Y'";
//	            count4 = this.getDbUtil().getFieldValue(sql, "Count");
//
//            	//System.out.println("==t 11 " + (new Date().getTime() - date.getTime()));
//            	date = new Date();
//            	
//
//	            double requestPayAmount = 0;
//	            if(count1 != null && count1.trim().length()> 0){
//	            	requestPayAmount = Double.parseDouble(count1);
//	            	count1 = df.format(Double.parseDouble(count1))+"";
//	            }else{
//	            	count1 = "0";
//	            }
//	            double receiveNtdAmount = 0;
//	            if(count2 != null && count2.trim().length() >0){
//	            	receiveNtdAmount = Double.parseDouble(count2);
//	            	count2 = df.format(Double.parseDouble(count2))+"";
//	            }else{
//	            	count2 = "0";
//	            }
//	            double TotalWithHolding = 0;
//	            if(count4 != null && count4.trim().length() >0){
//	            	TotalWithHolding = Double.parseDouble(count4);
//	            	count4 = df.format(Double.parseDouble(count4))+"";
//	            }else{
//	            	count4 = "0";
//	            }
//	            count3 =  df.format((int)(requestPayAmount - receiveNtdAmount - TotalWithHolding)) + "";
	            

            	//System.out.println("==t 12 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            
            	rtnString +="<div id='tabs-3'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
//	            rtnString +="<tr>";
//	            rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.RequestPayNtdAmount") + " : " + count1 + "</td>";
//	            rtnString +="<td align='center'>-</td>";
//	            rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.ReceiveNtdAmount") + " : " +  count2 + "</td>";
//	            rtnString +="<td align='center'>-</td>";
//	            rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.TotalWithHolding") + " : " +  count4 + "</td>";
//	            rtnString +="<td align='center'>=</td>";
//	            rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.NotYetReceiveNtdAmount") + " : " +  count3 + "</td>";
//	            rtnString +="</tr>";
	            /*
以子tab按鈕方式區分為兩tab：程序代辦(收費或付費項目無勾選的代辦事項) 與 財務代辦(收費或付費項目有勾選的代辦事項)，代辦儲存後即依據前述規則呈現在相應tab，在tab下仍可打開編輯。
	             */
	            /*
	    		 * 代辦事項tab列表上方新增過濾（搜尋）欄位條件，案件性質、狀態、□收費項目、□付費項目（若未勾選則預設為非Y去搜尋）
	    		 */
	    		String tr = "<tr><td valign=top colspan='12'>";
	    		
	    		if(this.getDbActionMode().equals(Cnstnts.UPDATE)) {
	    			String rtnString2 = "";
	    			/*
	    			 * 2013/8/2 simon
1.四個案件的代辦事項分頁，點選批次新增時，出現的搜尋畫面直接跳到 標準期限設定sop的搜尋列表，且過濾預設只搜尋“非收付費項目沒有勾的”
	    			 */
	    			/*
	    			 *  帶入資料
	    			 *  若是QuotationFlowKey存在，就抓該案件報價單的報價資料
	    			 *  不然就抓取同客戶同類別的報價來顯示
	    			 *  在不行就改顯示sop畫面
	    			 */
//	    			sql = "select count(1) as count from Quotation_detail " +
//	    					"where parentid in ( " +
//	    					"select flowkey from quotation where Client = '" + this.getClient() + "' and PatentType ='" + this.getPatentType() + "' " +
//	    					")";
//	    			int count9 = this.getDbUtil().getSqlIntValue(sql, "count");
//
//	    			if(!Util.isEmpty(this.getQuotationFlowKey())) {
//	    				rtnString2 = "<input type='button' "
//	    						+ "value='" + this.getUserInfo().getMsg("jsp.ToDosQuery.MultiInsertBtn") + "' "
//	    						+ "onclick='openAppendix(\"Quotation_detail.jsp?_pageActionMode=maintain&documentIn=true&parentId="
//	    						+ this.getFlowKey() + "&documentType=P&quotationFlowKey=" + this.getQuotationFlowKey() + "\",\"QueryTodos\",800,600)'/>";
//	    			}
//	    			else if(count9 > 0) {
//	    				rtnString2 = "<input type='button' "
//	    						+ "value='" + this.getUserInfo().getMsg("jsp.ToDosQuery.MultiInsertBtn") + "' "
//	    						+ "onclick='openAppendix(\"Quotation_detail.jsp?_pageActionMode=maintain&documentIn=true&parentId="
//	    						+ this.getFlowKey() + "&documentType=P" +
//	    						"&client=" + this.getClient() + "" +
//	    						"&patentType=" + this.getPatentType() + "" +
//	    						"\",\"QueryTodos\",800,600)'/>";
//	    			}
//	    			else {
	    				rtnString2 = "<input type='button' "
	    					+ "value='" + this.getUserInfo().getMsg("jsp.ToDosQuery.MultiInsertBtn") + "' "
	    					+ "onclick='openAppendix(\"StandardTask.jsp?_pageActionMode=search&doSearchFlag=true&_dbActionMode=query" +
	    							"&documentIn=true&parentId=" + this.getFlowKey() + 
	    							"&documentType=P&caseKind=STC01\",\"QueryTodos\",800,600)'/>";
//	    			}
	    			tr += rtnString2;
	    			tr += "　　";
	    		}

            	//System.out.println("==t 13 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

//	    		tr += this.getUserInfo().getMsg("jsp.ToDos.DataChange") + ":";
//	    		tr += "<input type=\"button\" id='FinancialToDosTabBtn' value=\"" + this.getUserInfo().getMsg("jsp.ToDos.FinancialToDosTab") + "\" onclick=\"showHideTodosDiv('PatentToDosDiv', 'PatentToDosDiv2')\">";
//	    		tr += "<input type=\"button\" id='MatterToDosTabBt' value=\"" + this.getUserInfo().getMsg("jsp.ToDos.MatterToDosTab") + "\" onclick=\"showHideTodosDiv('PatentToDosDiv2', 'PatentToDosDiv')\">";
	            
	    		tr += "　　";
	    		
	    		String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig " +
	            		"where casekind ='STC01' " +
	            		"and patentoffice like '%" + this.getPatentOffice() + ",%' " +
	            		"and patenttype like '%" + this.getPatentType() + ",%' " +
	            		"order by flowkey";
	    		//List<SelectItem> items = this.getDbUtil().getSelectItemList(sql, "MatterName");
	            List<SelectItem> items = Util.findCasePatentMatterConfig(this.getDbUtil(), "STC01", 
	            		this.getPatentOffice(), this.getPatentType());
	            this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	            this.Matter.setSelectList(items);
	            this.Matter.setCanEdit(true);
	            tr += getAlias(this.Matter) + Html.printTag(this.Matter, this.getUserInfo());

            	//System.out.println("==t 14 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            this.ToDosStatus.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	        	this.ToDosStatus.setSelectList(new Category().getChildList(this.ToDosStatus));
	        	this.ToDosStatus.setCanEdit(true);
	            tr += getAlias(this.ToDosStatus) + Html.printTag(this.ToDosStatus, this.getUserInfo());

            	//System.out.println("==t 15 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

//	            this.IsPayment.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
//	        	this.IsPayment.setCanEdit(true);
//	        	this.IsPayment.setAfterText("　　");
//	            tr += getAlias(this.IsPayment) + Html.printTag(this.IsPayment, this.getUserInfo());
//	            
//	            this.IsCharge.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
//	        	this.IsCharge.setCanEdit(true);
//	            tr += getAlias(this.IsCharge) + Html.printTag(this.IsCharge, this.getUserInfo());
	            tr += "<input type='hidden' name='isPayment' id='isPayment' value=''>";
	            tr += "<input type='hidden' name='isCharge' id='isCharge' value=''>";
	            
	            if(Util.isEmpty(this.getFinancialFlag())) {
	            	this.setFinancialFlag("Y");
	            }
	            tr += "<input type='hidden' name='financialFlag' id='financialFlag' value='" + this.getFinancialFlag() + "'>";
	            
	            tr += "<input type=\"button\" value=\"搜尋\" onclick=\"searchTodos('PatentCase','PatentToDos');\">";
	            tr += "<input type=\"button\" value=\"清空\" onclick=\"searchTodos2('PatentCase','PatentToDos');\">";
	            tr += "</td></tr>";

            	//System.out.println("==t 16 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            rtnString += tr;
	    		
	            rtnString +="<tr><td valign=top colspan='12'>";
	            rtnString +="<div id='updatePatentToDosDiv' name='updatePatentToDosDiv'></div>";
	            
	            rtnString +="<div id='PatentToDosDiv' name='PatentToDosDiv'>";
	            //rtnString += new PatentToDos().getSearchReasult(this.getUserInfo(), this.getFlowKey(), this.getFinancialFlag());
	            rtnString +="</div>";

            	//System.out.println("==t 17 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

//	            rtnString +="<div id='PatentToDosDiv2' name='PatentToDosDiv2'>";
//	            rtnString += new PatentToDos().getSearchReasult(this.getUserInfo(), this.getFlowKey(), "N");
//	            rtnString +="</div>";
	            
	            rtnString +="</td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            
	            rtnString += "<script>showHideTodosDiv('PatentToDosDiv2', 'PatentToDosDiv');</script>";
	            /**** tabs-3 end ****/
	            
	            /**** tabs-4 ****/
            	rtnString +="<div id='tabs-4'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0>";
	            rtnString +="<tr><td align=left>";
	            rtnString +="<input type='button' value='" + 
	            				this.getUserInfo().getMsg("jsp.PatentInventor.InsertToApplicantBtn") +
	            				"' onclick='openAppendix(\"QueryCheckForm.jsp?queryClass=PatentApplicant2&_queryText2=" + this.getClient() +
	            				"&QueryText4=" + this.getClient() +"&QueryText5=" + this.getFlowKey() + "\",\"Applicants\",800,600)'>";
	            rtnString +="<input type='button' value='" + this.getUserInfo().getMsg("jsp.PatentInventor.CopyOrderBtn") + "' onclick='openAppendix(\"OrderSortableForm.jsp?queryClass=PatentApplicant&QueryText5=" + this.getFlowKey() + "\",\"PatentApplicant\",800,600)'>";
	            rtnString +="</td></tr>";
	            rtnString +="<tr><td valign=top>";
	            rtnString +="<div id='updatePatentApplicantDiv' name='updatePatentApplicantDiv'></div>";
	            rtnString +="<div id='PatentApplicantDiv' name='PatentApplicantDiv'>";
	            //rtnString += new PatentApplicant().getSearchReasult(this.getUserInfo(), this.getFlowKey());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-4 end ****/
            	//System.out.println("==t 18 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            
	            /**** tabs-5 ****/
            	rtnString +="<div id='tabs-5'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0>";
	            rtnString +="<tr><td align=left>";
	            rtnString +="<input type='button' value='" + this.getUserInfo().getMsg("jsp.PatentInventor.CopyInventorBtn") + "' onclick='openAppendix(\"QueryCheckForm.jsp?queryClass=PatentInventor2&_queryText2=" + this.getClient() +"&QueryText4=" + this.getClient() +"&QueryText5=" + this.getFlowKey() + "\",\"Applicants\",800,600)'>";
	            rtnString +="<input type='button' value='" + this.getUserInfo().getMsg("jsp.PatentInventor.CopyApplicantBtn") + "' onclick='this.disabled=true;document.input.copyApplicantFlag.value=true;setValue();'>";
	            rtnString +="<input type='button' value='" + this.getUserInfo().getMsg("jsp.PatentInventor.CopyOrderBtn") + "' onclick='openAppendix(\"OrderSortableForm.jsp?queryClass=PatentInventor&QueryText5=" + this.getFlowKey() + "\",\"PatentInventor\",800,600)'>";
	            rtnString +="</td></tr>";
	            rtnString +="<tr><td valign=top>";
	            rtnString +="<div id='updatePatentInventorDiv' name='updatePatentInventorDiv'></div>";
	            rtnString +="<div id='PatentInventorDiv' name='PatentInventorDiv'>";
//	            rtnString += new PatentInventor().getSearchReasult(this.getUserInfo(), this.getFlowKey());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-5 end ****/

            	//System.out.println("==t 19 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            /**** tabs-6 ****/
            	rtnString +="<div id='tabs-6'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updatePatentAttorneyDiv' name='updatePatentAttorneyDiv'></div>";
	            rtnString +="<div id='PatentAttorneyDiv' name='PatentAttorneyDiv'>";
//	            rtnString += new PatentAttorney().getSearchReasult(this.getUserInfo(), this.getFlowKey());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-6 end ****/

            	//System.out.println("==t 20 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            /**** tabs-7 ****/
            	rtnString +="<div id='tabs-7'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updatePatentPriorityDiv' name='updatePatentPriorityDiv'></div>";
	            rtnString +="<div id='PatentPriorityDiv' name='PatentPriorityDiv'>";
//	            rtnString += new PatentPriority().getSearchReasult(this.getUserInfo(), this.getFlowKey());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-7 end ****/

            	//System.out.println("==t 21 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            /**** tabs-11 ****/
            	rtnString +="<div id='tabs-11'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updatePatentCitationDiv' name='updatePatentCitationDiv'></div>";
	            rtnString +="<div id='PatentCitationDiv' name='PatentCitationDiv'>";
//	            rtnString += new PatentCitation().getSearchReasult(this.getUserInfo(), this.getFlowKey());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-11 end ****/

            	//System.out.println("==t 22 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            if(Util.compareTo(this.getPatentOffice(), "US")) {
	            /**** tabs-12 ****/
            	rtnString +="<div id='tabs-12'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString += "<a href='http://www.uspto.gov/patents/process/file/efs/guidance/updated_IDS.pdf'>IDS提交文件(http://www.uspto.gov/patents/process/file/efs/guidance/updated_IDS.pdf)</a><br>";
	            rtnString +="<div id='updatePatentCitationUsDiv' name='updatePatentCitationUsDiv'></div>";
	            rtnString +="<div id='PatentCitationUsDiv' name='PatentCitationUsDiv'>";
//	            rtnString += new PatentCitationUs().getSearchReasult(this.getUserInfo(), this.getFlowKey(), this.getMarkKeys());

	            
	            rtnString +="</div>";
	            if(this.getDbActionMode().equals(Cnstnts.UPDATE)) {
	            	rtnString += Cnstnts.NEW_LINE + "<table width='100%'><tr><td colspan='3' width='30%'></td><td align='right'>";
	            	rtnString += Cnstnts.NEW_LINE + "<input type='button' value='確認提交IDS' onclick='document.input.processType.value=\"confirmIDS\";setValue();'>&nbsp;";
	            	rtnString += Cnstnts.NEW_LINE + "<input type='button' value='無需提交IDS' onclick='document.input.processType.value=\"unconfirmIDS\";setValue();'>&nbsp;";
	            	rtnString += Cnstnts.NEW_LINE + "<input type='button' value='產生IDS列印檔' onclick='exportIDS();'>&nbsp;";
	            	if(Util.compareTo(this.getProcessType(), "printIDS") &&
	            			!Util.isEmpty(this.getOutputFile())) {
	            		rtnString += Cnstnts.NEW_LINE + "<input type='button' style='cursor: hand' " + 
	            				   "value='下載IDS XML檔' "+
	            				   "onClick='printPdf(\""+this.getOutputFile()+"\")'/>&nbsp;";
	            	}
	            	rtnString += Cnstnts.NEW_LINE + "</td></tr></table>";
	    		}
	            rtnString += "</td></tr></table>";

	            rtnString +="</div>";
	            rtnString +="</div>";

            	//System.out.println("==t 23 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            /**** tabs-12 end ****/
	            }
	            
	            if(Util.compareTo(this.getPatentOffice(), "EP")) {
	            /**** tabs-13 ****/
            	rtnString +="<div id='tabs-13'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updatePatentCitationEpDiv' name='updatePatentCitationEpDiv'></div>";
	            rtnString +="<div id='PatentCitationEpDiv' name='PatentCitationEpDiv'>";
//	            rtnString += new PatentCitationEp().getSearchReasult(this.getUserInfo(), this.getFlowKey(), this.getMarkKeys());
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-13 end ****/
	            }

            	//System.out.println("==t 24 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            /**** tabs-14 ****/
	            String count1 = "";
	            String count2 = "";
	            String count3 = "";
	            String count4 = "";
            	//String count5 = "";
	            String SQL = "select sum(%s) as Count from RenewalLog where ParentId ='" + this.getFlowKey() + "' and KeepMaintain='Y'";
            	//String SQL2 = "select sum(NtdPtoFee+NtdServiceFee+NtdAttorneyFee+NtdOtherFee) as Count from RenewalLog  where ParentId ='" + this.getFlowKey() + "'";
            	count1 = this.getDbUtil().getFieldValue(String.format(SQL, "NtdPtoFee"), "Count");
            	count2 = this.getDbUtil().getFieldValue(String.format(SQL, "NtdServiceFee"), "Count");
            	count3 = this.getDbUtil().getFieldValue(String.format(SQL, "NtdAttorneyFee"), "Count");
            	count4 = this.getDbUtil().getFieldValue(String.format(SQL, "NtdOtherFee"), "Count");
            	//count5 = this.getDbUtil().getFieldValue(SQL2, "Count");

            	//System.out.println("==t 25 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

            	rtnString +="<div id='tabs-14'>";
            	rtnString +="<div class='indent'>";
				rtnString +="<table width=95% border=0><tr><td valign=top>";
				//rtnString +="<tr><td align='center' colspan='5' style='font-size: 17;'><b>"+ this.getUserInfo().getMsg("jsp.PatentCase.CaseTotalFee") + "</b></td></tr>";
	            rtnString +="<tr>";
	            rtnString +="<td>" + this.getUserInfo().getMsg("jsp.RenewalLog.NtdPtoFee") + " : " + count1 + "</td>";
	            rtnString +="<td>" + this.getUserInfo().getMsg("jsp.RenewalLog.NtdServiceFee") + " : " +  count2 + "</td>";
	            rtnString +="<td>" + this.getUserInfo().getMsg("jsp.RenewalLog.NtdAttorneyFee") + " : " +  count3 + "</td>";
	            rtnString +="<td>" + this.getUserInfo().getMsg("jsp.RenewalLog.NtdOtherFee") + " : " +  count4 + "</td>";
	            //rtnString +="<td>" + this.getUserInfo().getMsg("jsp.PatentCase.TotalNtd") + " : " +  count5 + "</td>";
	            rtnString +="</tr>";
	            rtnString +="<tr><td valign=top colspan='5'>";
	            rtnString +="<div id='updateRenewalLogDiv' name='updateRenewalLogDiv'></div>";
		        rtnString +="<div id='RenewalLogDiv' name='RenewalLogDiv'>";
		        //rtnString += printCaseRenewalLogListTableHtml();
		        
	            rtnString +="</div></td></tr>";
	            rtnString +="</table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-14 end ****/

            	//System.out.println("==t 26 " + (new Date().getTime() - date.getTime()));
            	date = new Date();
            	

	            /**** tabs-15 ****/
	            /*
                 * 1.增加一列表式tab "權限"，專利商標法務案件的權限就來讀這個tab，如示意圖，此tab僅預設成員可進行編輯，
                 * 預設成員為admin以及G01。
                 */
                if(Util.isAdminOrG01(this.getUserInfo()) || cp2.isTabable()) {
                	rtnString +="<div id='tabs-15'>";
		            rtnString +="<div class='indent'>";
		            rtnString +="<table width=95% border=0><tr><td valign=top>";
		            rtnString +="<div id='updateCasePrivilegeDiv' name='updateCasePrivilegeDiv'></div>";
		            rtnString +="<div id='CasePrivilegeDiv' name='CasePrivilegeDiv'>";
		            //rtnString += new CasePrivilege().getSearchReasult(this.getUserInfo(), this.getFlowKey(), this.getCaseKind(), "E");
		            
		            rtnString +="</div></td></tr></table>";

	            	//System.out.println("==t 27 " + (new Date().getTime() - date.getTime()));
	            	date = new Date();
	            	

		            rtnString +="<br/>";
		            
		            rtnString +="<table width=95% border=0><tr><td valign=top>";
		            rtnString +="<div id='updateCasePrivilege2Div' name='updateCasePrivilege2Div'></div>";
		            rtnString +="<div id='CasePrivilege2Div' name='CasePrivilege2Div'>";
		            //rtnString += new CasePrivilege().getSearchReasult(this.getUserInfo(), this.getFlowKey(), this.getCaseKind(), "D");
		            
		            rtnString +="</div></td></tr></table>";
		            rtnString +="</div>";
		            rtnString +="</div>";
	            	//System.out.println("==t 28 " + (new Date().getTime() - date.getTime()));
	            	date = new Date();
	            	

                }
	            /**** tabs-15 end ****/
                
              //關聯訂單tab調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
				if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
                /**** tabs-6 ****/
				rtnString += "<div id='tabs-c6'>";
				rtnString += "<div class='indent'>";
				rtnString +="<table width=95% border=0>";
	            rtnString +="<tr><td align=left>";
	            rtnString +="</td></tr>";
	            rtnString +="<tr><td valign=top>";
				rtnString += "<div id='updateSalesOrderDiv' name='updateSalesOrderDiv'></div>";
				rtnString += "<div id='SalesOrderDiv' name='SalesOrderDiv'>";
				boolean canAssesFlag = false;
				if(this.getDbActionMode().equals(Cnstnts.UPDATE)) {
					canAssesFlag = true;
				}
				//rtnString += new SalesOrder().printAjaxCaseSalesOrderTable(this.getUserInfo(), this.getFlowKey(), canAssesFlag);

				rtnString += "</div></td></tr></table>";
				rtnString += "</div>";
				rtnString += "</div>";
				/**** tabs-6 end ****/
				}

				
				/**** tabs-sm ****/
	        	rtnString +="<div id='tabs-sm'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateSignedMangeDiv' name='updateSignedMangeDiv'></div>";
	            rtnString +="<div id='SignedMangeDiv' name='SignedMangeDiv'>";
	            rtnString += printSignedMangeTable();
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-sm end ****/
	            
	            rtnString += "</div>";
	            
	            rtnString += "<script type='text/javascript'>createPatentTabs1();</script>";
            	rtnString += "<script type='text/javascript'>$(function(){$('#tabs2').tabs();});</script>";
            
	            
	            String scriptText = "<script>"+
							"function openTabFrame(jspName,dbActionMode,flowkey,frameHight,IFrameDiv,DataDiv){"+
							"  var frameWidth=document.getElementById('functionBar').offsetWidth;"+
							"  var tabFramDiv=document.getElementById(IFrameDiv);"+
							"  var varDataDiv=document.getElementById(DataDiv);" +
							
							"  var srcUrl=jspName+'.jsp?_pageActionMode=maintain&_dbActionMode='+dbActionMode;"+
							"  if(dbActionMode.match('^insert') == 'insert'){"+
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
						    "  doPatentCaseAjaxRequest('PatentCase',newTabText,'"+this.getFlowKey()+"',DataDiv,'innerHTML')"+
						    "}"+
							"</script>";
	            rtnString += scriptText;
	            rtnString += "</td></tr>";
            }
    	}
    	
		return rtnString;
    }
    
    public String printHiddenTags(){
    	String rtnString = super.printHiddenTags();
    	HashMap<String,String> hm = new HashMap<String,String>();
    	hm.put("signOutFlag",Cnstnts.EMPTY_STRING);
    	hm.put("processType",Cnstnts.EMPTY_STRING);
    	hm.put("changeInsertFlag", this.getChangeInsertFlag());
    	hm.put("copyApplicantFlag",Cnstnts.EMPTY_STRING);
  	  	rtnString += new HiddenTag().print(hm);
  	  	return rtnString;
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	resetFieldData("cond1", getCond1(), getFullSearchText1());
        	resetFieldData("cond2", getCond2(), getFullSearchText2());
        	resetFieldData("cond11", getCond11(), getFullSearchText11());
        	
        	this.LicenseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
              
            this.ApplyNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
        	this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("RightStatus"));
            
        	this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Title.setSize(20);
        	
        	this.OriginalTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.OriginalTitle.setSize(20);
            
            this.PatentCaseType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentCaseType.setSelectList(new Category().getChildList(this.PatentCaseType));
            
            this.PatentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentType.setSelectList(new Category().getChildList(this.PatentType));

            this.Attorney.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Attorney.setSelectList(new Attorney().getList());
            
            this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.PatentOffice.setSelectList(new Category().getChildList(this.PatentOffice));

            this.SerialMotherCase.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            List<SelectItem> items = new Employee().getList();
            this.CaseAD.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CaseAD.setSelectList(items);
            
            this.InCharge.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.InCharge.setSelectList(items);
            
            this.Referrals.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Referrals.setSelectList(items);
            
            this.CaseAssignedTo.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CaseAssignedTo.setSelectList(items);
            
            this.ClientName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            
            this.FeeScheduleDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.FeeScheduleDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.FeeScheduleDateTo.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1"));
            this.FeeScheduleDateTo.setButtonClick("setScheduleDateOne();");
            
            this.FeeScheduleDateTo.setSecondButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2"));
            this.FeeScheduleDateTo.setSecondButtonClick("setScheduleDateTwo();");
            
            
            String sql = "select FlowKey, Names from applicant where ShowInClient ='Y' and ApplicantKind like '%CLK01;%' ";
            this.ClientContect.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.ClientContect.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("Names", ""), false));
            
            /*************  new search area **************/
            rtnString += genSearchCondScript("fullSearchText1");
            rtnString += genSearchCondScript("fullSearchText11");
            rtnString += Cnstnts.NEW_LINE + genSearchCondScript("fullSearchText2");
            
            rtnString += Cnstnts.NEW_LINE
                        + "<tr bgcolor='#E9EDF4'><td width='20%' align='right'>"
                        + genSearchCondList("cond1")
                        + "</td><td width='25%'><div id='cond1_div'></div></td>"
                        + "<td width='25%'>" + genSqlCondList("sqlCond1") + "</td>";

            rtnString += Cnstnts.NEW_LINE
                        + "<tr bgcolor='#E9EDF4'><td width='20%' align='right'>"
                        + genSearchCondList("cond11")
                        + "</td><td width='25%'><div id='cond11_div'></div></td>"
                        + "<td width='25%'>" + genSqlCondList("sqlCond11") + "</td>";

            rtnString += Cnstnts.NEW_LINE
                        + "<tr bgcolor='#E9EDF4'><td width='20%' align='right'>"
                        + genSearchCondList("cond2")
                        + "</td><td width='25%'><div id='cond2_div'></div></td>"
                        + "<td width='25%'>" + genSqlCondList("sqlCond2") + "</td>";
            
            rtnString += Cnstnts.NEW_LINE + 
            "<tr bgcolor='#E9EDF4'><td width='20%' align='right'>" + 
            genSearchDateList() + 
            "</td>" +
            "<td>" +
            "<input type='text' id='startDate' name='startDate' value='' size='10' onChange='checkdate(this);'/>" +
            "~" +
            "<input type='text' id='endDate' name='endDate' value='' size='10'  onChange='checkdate(this);'/>" +
            "<input type='button' value='" + this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1") + 
	        	"' onclick='addMonthToDate(-1, \"startDate\");addMonthToDate(0, \"endDate\");'>" +
	        "<input type='button' value='" + this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2") + 
	        	"' onclick='addMonthToDate(-3, \"startDate\");addMonthToDate(0, \"endDate\");'>" +
            "　　　　" + 
            "</td>";
            this.NewCaseCheck.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.NewCaseCheck.setCanEdit(true);
            rtnString += Cnstnts.NEW_LINE + "<td>" +
            		Html.printTag(this.NewCaseCheck, this.getUserInfo()) + Html.getAlias(this.NewCaseCheck, this.getUserInfo()) + 
            		"</td></tr>";
            
            /*
            if(Util.isAdminOrG01(this.getUserInfo())) {
            	rtnString += Cnstnts.NEW_LINE + 
                    "<tr bgcolor='#E9EDF4'><td width='20%' align='right'>where</td>" +
                    "<td colspan='2'><input type='text' id='searchWhereSql' name='searchWhereSql' size='100' value='" + this.getSearchWhereSql() + "'></td></tr>";
            }
            */
            
            
            rtnString += Cnstnts.NEW_LINE +
                    "<script>" + 
                    "changeDiv1(document.getElementById('cond1'), 'cond1_div');" +
                    "changeDiv11(document.getElementById('cond11'), 'cond11_div');" +
                    "changeDiv2(document.getElementById('cond2'), 'cond2_div');" +
                    "document.input.startDate.value='" + getStartDate() + "';" +
                    "document.input.endDate.value='" + getEndDate() + "';" + 
                    "$.datepicker.setDefaults( $.datepicker.regional[ \"zh-TW\" ] );" +
	        		"$( \"#startDate,#endDate\" ).datepicker({" +
					"showOn: \"button\"," +
					"buttonImage: \"img/calendar.gif\"," +
					"buttonImageOnly: true," +
					"changeMonth: true," +
					"changeYear: true," +
					"dateFormat: \"yy-mm-dd\"" +
					"});" +
                    "</script>";
            /*************  new search area end **************/
            
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
        	Date date = new Date();
        	Category cate = new Category();
        	if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
        		
        		//20110819於既有案件中新增功能可以複製該筆資料的“發明人”、“申請人”、“代理人”、“優先權”資料
        		if(!Util.isEmpty(oldCaseFlowKey) && Util.isEmpty(this.getFromCase())){
        			this.FromCase.setValue(this.getOldCaseFlowKey());
        			this.FlowKey.setValue("");
        			
        			if(!Util.compareTo(this.getChangeInsertFlag(), "true")) {
        				this.setChangeInsertFlag("true");
        				
        				//複製master資料（基本資料tab除外）
        				//this.InternalNo.setValue("");
        	            
        		    	this.CaseStartDate.setValue("");
        		        this.ApplyNo.setValue("");
        		        this.ApplyDate.setValue("");
        		        this.PublishNo.setValue("");
        		        this.PublishDate.setValue("");
        		        this.IssueNo.setValue("");
        		        this.IssueDate.setValue("");
        		        this.LicenseNo.setValue("");
        		        this.LicenseDate.setValue("");
        		        this.IdeaId.setValue("");
        		        this.DeliveryDate.setValue("");
        		        this.FeeSchedule.setValue("");
        		        this.FeeScheduleDate.setValue("");
        		        this.ExamineDueDate.setValue("");
        		        this.ExamineDate.setValue("");
        		        this.ClientContect.setValue("");
        		        this.OutsourceDate.setValue("");
        		        this.Attorney.setValue("");
        		        this.AttorneyNum.setValue("");
//        		        this.PriorityDeadLine.setValue("");
        		        this.RightBeginDate.setValue("");
        		        this.AutoPay.setValue("");
        		        this.PaymentConfirming.setValue("");
        		        this.GiveupCode.setValue("");
        		        this.RightEndDate.setValue("");
        		        this.Remark.setValue("");
        		    	this.Updater.setValue("");
        		        this.UpdateTime.setValue("");
        	            this.setCaseNo("");
        	            this.setCaseNo2("");
        		        this.Title.setValue("");
        		        this.EnglishTitle.setValue("");
        		        this.LastSchedule.setValue("");
        		        this.InternalNo.setValue("");
        		        this.Entity.setValue("");
        		        this.Status.setValue("");
        			}
        		}
        		if(!Util.isEmpty(this.getFromCase())) {
        			this.InternalNoCheck.setCanEdit(true);
        			this.InternalNoCheck.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        			
            		this.PriorityCopyCheck.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            		this.PriorityCopyCheck.setAfterText(this.getUserInfo().getMsg("jsp.PatentCase.PriorityCopyCheck2")+
            				Html.printTag(this.InternalNoCheck, this.getUserInfo()) + this.getAlias(this.InternalNoCheck));

            		this.InventorCopyCheck.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            		this.InventorCopyCheck.setAnotherField(this.PriorityCopyCheck);

            		this.AttorneyCopyCheck.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            		this.AttorneyCopyCheck.setAnotherField(this.InventorCopyCheck);

            		this.ApplicantCopyCheck.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            		this.ApplicantCopyCheck.setAnotherField(this.AttorneyCopyCheck);
            		
            		this.FromCase.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            		this.FromCase.setCanEdit(false);
            		this.FromCase.setReadonly(true);
            		this.FromCase.setAnotherField(this.ApplicantCopyCheck);
            		rtnString += this.printHtml(this.FromCase);
            		
            		this.CreateTime.setValue("");
            		this.Creator.setValue("");
            	}
        		rtnString += this.Entity.printHiddenTag();
        		/*
        		 * 20110524 : 案件編號自動編碼為該當年之西元年後兩碼目前案件編號最大號碼再加一。並且除自動編碼外可手動輸入案件編號。
        		 * 
        		 * 專利案件代碼為：“西元年後兩碼”“流水碼四碼”“國家碼”
新增一"產生案件編號功能"(只有在新增模式才會出現)，點選時會先檢查國家別是否已經填入資料，
若沒有就會出現提醒視窗，若有，則依據上述條件自動產生專利案件代碼
        		 */
        		this.CaseNo.setReadonly(false);
//        		if(Util.compareTo(getGenFlowKeyFlag(), "true")) {
//	        		if(Util.isEmpty(this.getCaseNo()) &&
//	        				!Util.isEmpty(this.getPatentOffice())) {
//	        			String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
//	        			String sql = "select CaseNo from patentcase where CaseNo like '" + year +"%' order by CaseNo desc";
//		    			List<String> keys = this.getDbUtil().getValueList(sql, "CaseNo");
//		    			int max = 1;
//		    			if(keys != null && !keys.isEmpty()) {
//		    				String key = keys.get(0);
//		    				max = Integer.parseInt( key.substring(2, 6) ) + 1;
//		    			}
//		    			this.CaseNo.setValue(year + String.format("%04d", max) + this.getPatentOffice());
//	        		}
//        		}
        		 
        		
        		 if(this.Client.getValue().trim().length()>0){
                 	Client cli = new Client(this.Client.getValue());
//            		if(!Util.isEmpty(cli.getSponsor()) && Util.isEmpty(this.getInCharge())) {
//	            		this.InCharge.setValue(cli.getSponsor());
//	            	}
            		if(!Util.isEmpty(cli.getEntity()) && Util.isEmpty(this.getEntity())) {
	            		this.Entity.setValue(cli.getEntity());
	            	}
                 }
        		
        	}
        	else {
        		rtnString += this.FromCase.printHiddenTag();
        	}
        	
        	//System.out.println("=m 1 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
        	rtnString += this.QuotationFlowKey.printHiddenTag();
        	rtnString += this.FlowKey.printHiddenTag();

            /*
"案件編號2"旁也新增"產生案件編號"按鈕，編號規則：
部門代碼兩碼（看creator部門代碼前兩碼）＋目前規則（西元年後兩碼＋流水碼四碼＋國家碼兩碼），
流水碼檢查依據為案件編號 以及案件編號2 中該部門當年的流水號最後一碼往後加。
如 若台北所TP 下某個人新增了一個案子為TP130005TW 再案件編號，該案的案件編號2 
另一個上海所SH人登入所編的號碼可能為 SH130003TW，隔天若上海所新建一個中國案子，
在案件編號 點產生編號，應該要產生SH130004CN, 台北所進來在案件編號2 點產生編號 應該產生 TP130006CN
             */
        	
        	/*20200524 HH
			
			產生編號按鈕的給號規則
			1.申請國家=TW：申請國家英文代碼-專利類別對應代碼-西元年後二碼-四碼流水號
			　(例TW-I-20-0001)
			(1)申請國家英文代碼=TW
			(2)專利類別對應代碼：通用類別/備註(I-發明；U-新型；D-設計；DD-衍生設計；O-其他)
			(3)四碼流水號：每年重置，TW專利流水號共用，不管專利類別
			
			2.申請國家非TW：P-客戶代碼-專利類別對應代碼-西元年後二碼-四碼流水號
			　(例P-客戶代碼-D-20-0001)
			(1)客戶代碼：資料源為客戶資料/客戶代碼
			(2)專利類別對應代碼：通用類別/備註(I-發明；U-新型；D-設計；DD-衍生設計；O-其他)
			(3)四碼流水號：每年重置，不同的客戶各自跑此類(此客戶非TW專利)的流水號 (不用管專利類別)
			
        	 */

        	if(Util.compareTo(getGenFlowKeyFlag(), "true") ||
        			Util.compareTo(getGenFlowKeyFlag2(), "true")) {
        		String key = generateCaseNo();

        		if(Util.compareTo(this.getGenFlowKeyFlag(), "true")) {
    				this.CaseNo.setValue(key);
    			}
    			else if(Util.compareTo(this.getGenFlowKeyFlag2(), "true")) {
    				this.CaseNo2.setValue(key);
    			}
    		}
        	if(this.getDbActionMode().equals(Cnstnts.UPDATE) || 
	        		this.getDbActionMode().equals(Cnstnts.INSERT)) {
	        	this.CaseNo.setAfterText("<input type='button' value='" + 
	        			this.getUserInfo().getMsg("jsp.PatentCase.GetFlowKey") + "' " +
	        			"onclick='getPatentFlowKey();'>");
	    		
	        	this.CaseNo2.setAfterText("<input type='button' value='" + 
	        			this.getUserInfo().getMsg("jsp.PatentCase.GetFlowKey") + "' " +
	        			"onclick='getPatentFlowKey2();'>");
        	}
        	
        	
        	//System.out.println("=m 2 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
        	
        	this.CaseNo2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.CaseNo.setAnotherField(this.CaseNo2);
            this.CaseNo.setColspan(1);
        	rtnString += this.printHtml(this.CaseNo);
        	
        	//客戶不為空的時候，就去抓取這個客戶的服務專案資料
            List<SelectItem> items2 = new ArrayList<SelectItem>();
//            if(!Util.isEmpty(this.Client.getValue())) {
//            	String sql2 = "select FlowKey, Title from serviceproject where Client = '" + this.Client.getValue() + "' order by flowkey";
//            	items2 = this.getDbUtil().getSelectItemList(sql2, "Title");
//            }
            String sql2 = "select FlowKey, Title from serviceproject  order by flowkey";
        	items2 = this.getDbUtil().getSelectItemList(sql2, "Title");
            this.ServiceProjectCode.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
            this.ServiceProjectCode.setSelectList(items2);
            this.ServiceProjectCode.setColspan(3);
        	rtnString += this.printHtml(this.ServiceProjectCode);
        	
        	rtnString += "<input type='hidden' name='oldCaseFlowKey' id='oldCaseFlowKey' value='" + (Util.isEmpty(this.getOldCaseFlowKey())?"":getOldCaseFlowKey()) + "'>";
        	
            String clientName = Cnstnts.EMPTY_STRING;
            List<SelectItem> clients = new ArrayList<SelectItem>();
            Client cli = null;
            if(this.Client.getValue().trim().length()>0){
            	cli = new Client(this.Client.getValue());
            	clientName = cli.getCompanyName();
            	
            	clients = cli.getList();
            	
            	//四類案件中案件新增時選擇客戶後，若將該客戶的 負責程序 欄位有記載，就帶入該案件的 負責程序。
            	//1.案件新增時，要把客戶資料裡的(sales)業務人員 欄位以及 "大小實體" 欄位有資料的帶到案件裡。
//            	if(Util.compareTo(this.getChangeClientFlag(), "true")) {
	            	
	            	
	            	if(Util.compareTo(this.getDbActionMode(), Cnstnts.INSERT)) {
	            		if(!Util.isEmpty(cli.getSponsor())) {
		            		this.InCharge.setValue(cli.getSponsor());
		            	}
	            		if(!Util.isEmpty(cli.getEntity())) {
		            		this.Entity.setValue(cli.getEntity());
		            	}
	            		
	            		if(!Util.isEmpty(cli.getCaseAD())) {
		            		this.CaseAD.setValue(cli.getCaseAD());
		            	}
	            	}
//            	}
            }
            else {
            	clients = new Client().getList();
            }
        	//System.out.println("=m 3 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
            this.ClientName.setValue(clientName);
            this.ClientName.setSize(40);
            this.ClientName.setReadonly(true);
            if(this.canEdit()){
            	if(this.getDbActionMode().equals(Cnstnts.INSERT) 
            			|| (this.getDbActionMode().equals(Cnstnts.UPDATE) 
            					/*&& this.getUserInfo().getAttribute("emp_id").equals(this.getSignOutId()))*/)){
            		this.ClientName.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SearchClient"));
            		this.ClientName.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=Client\",\"Client\",800,600)");
            		
            		if(!Util.isEmpty(this.getClient())) {
                		this.ClientName.setSecondButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.EditClient"));
                		this.ClientName.setSecondButtonClick("openAppendix(\"Client.jsp?flowKey="+this.getClient()
    							+"&_dbActionMode=update&_getDataFlag=true&_pageActionMode=maintain\",\"Client\",800,600)");
                	}
            	}
            }
            else{
            	if(this.getDbActionMode().equals(Cnstnts.QUERY) && !Util.isEmpty(this.Client.getValue())){
            		this.ClientName.setAfterText("&nbsp<img src='img/search03.gif' style='cursor: hand' "
							+ "title='"
							+ this.getUserInfo().getMsg("jsp.PatentCase.OpenClientInfo")
							+ "' "
							+ "onClick='openAppendix(\"Client.jsp?flowKey="+this.getClient()
							+"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain\",\"Client\",800,600)'>");
            	}
            }
            if(Util.compareTo(this.getDbActionMode(), Cnstnts.INSERT)) {
	            this.Client.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
	            this.Client.setCallbackFunction("document.input.changeClientFlag.value=true;setValue();");
	            this.Client.setAutocompleteLabelFieldId(this.ClientName.getTagName());
            }
            else {
            	this.Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            }
            
            this.Client.setSelectList(clients);
            this.Client.setOnChange("setValue()");
            this.Client.setAnotherField(this.ClientName);
            this.Client.setColspan(1);
            rtnString += this.printHtml(this.Client);

        	//System.out.println("=m 4 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
            

        	//System.out.println("=m 5 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
            this.PctNationalPhase.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            
            this.PatentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentType.setSelectList(cate.getChildList(this.PatentType));
            this.PatentType.setAnotherField(this.PctNationalPhase);
            this.PatentType.setColspan(1);
            this.PatentType.setOnChange("changeRightDate()");
            rtnString += this.printHtml(this.PatentType);

        	//System.out.println("=m 6 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
            String sql = "";
            if(Util.isEmpty(this.getPriorityDeadLine()) && !Util.isEmpty(this.getFlowKey())){
            	sql = "select prioritydate from patentpriority where parentid = '"+this.getFlowKey()+"' order by prioritydate asc ";
            	String priorityDeadLine = "";
            	priorityDeadLine = this.getDbUtil().getFieldValue(sql, "prioritydate");
            	if(!Util.isEmpty(priorityDeadLine)){
            		this.PriorityDeadLine.setValue(priorityDeadLine);
            	}
            }
            
            this.PriorityDeadLine.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.PatentOffice.setMapingPrpt(null);
//            this.PatentOffice.setSelectList(cate.getChildList(this.PatentOffice));
            this.PatentOffice.setOnChange("setValue()");
            this.PatentOffice.setAnotherField(this.PriorityDeadLine);
            this.PatentOffice.setColspan(1);
            if(this.canEdit()){
            	if(this.getDbActionMode().equals(Cnstnts.INSERT) 
            			|| (this.getDbActionMode().equals(Cnstnts.UPDATE))) {
		            this.PatentOffice.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryOffice"));
		    		this.PatentOffice.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=PatentOffice\",\"PatentOffice\",800,600)");
            	}
            }
    		if(!Util.isEmpty(this.getPatentOffice())) {
    			this.PatentOffice.setValue(this.getPatentOffice().toUpperCase());
            	String officeName = cate.getNamesPrpts().getProperty(this.getPatentOffice());
            	if(Util.isEmpty(officeName)) {
            		this.PatentOffice.setValue("");
            		this.PatentOffice.setAfterText("<script>alert('" + this.getUserInfo().getMsg("jsp.PatentCase.QueryOfficeError") + "');</script>");
            	}
            	else {
            		this.PatentOffice.setAfterText("(" + officeName + ")");
            	}
            }
            rtnString += this.printHtml(this.PatentOffice);

        	//System.out.println("=m 7 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
            this.SerialMotherCase.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            if(!Util.isEmpty(this.getSerialMotherCase()) && (this.getDbActionMode().equals(Cnstnts.UPDATE) ||
            		this.getDbActionMode().equals(Cnstnts.QUERY))) {
	            this.SerialMotherCase.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SearchSerialMotherCase"));
	            this.SerialMotherCase.setButtonClick(
            		"openAppendix(\"PatentCase.jsp?_pageActionMode=search&_dbActionMode=query&doSearchFlag=true&" +
            		"cond1=SerialMotherCase&fullSearchText1=" + this.getSerialMotherCase() + "\",\"PatentCase\",800,600)");
            }
            else{ 
            	if(Util.isEmpty(this.getSerialMotherCase()) && (this.getDbActionMode().equals(Cnstnts.UPDATE) ||
            	this.getDbActionMode().equals(Cnstnts.QUERY))) {
	            this.SerialMotherCase.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SearchSerialMotherCase"));
	            this.SerialMotherCase.setButtonClick(
            		"openAppendix(\"PatentCase.jsp?_pageActionMode=search&_dbActionMode=query&doSearchFlag=true&" +
            		"cond1=CaseNo&fullSearchText1=" + this.getCaseNo() + "\",\"PatentCase\",800,600)");
            	}
            }

            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE_COLOR);
            this.Status.setSelectList(cate.getChildList("RightStatus"));
            this.Status.setAnotherField(this.SerialMotherCase);
            this.Status.setColspan(1);
            rtnString += this.printHtml(this.Status);

        	//System.out.println("=m 8 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
        	//System.out.println("=m 9 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
            this.OriginalTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.OriginalTitle.setSize(82);
            this.OriginalTitle.setLength(500);
            rtnString += this.printHtml(this.OriginalTitle);

        	//System.out.println("=m 10 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Title.setSize(82);
            this.Title.setLength(500);
            rtnString += this.printHtml(this.Title);

        	//System.out.println("=m 11 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
            this.EnglishTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishTitle.setSize(82);
            this.EnglishTitle.setLength(500);
            rtnString += this.printHtml(this.EnglishTitle);

        	//System.out.println("=m 12 " + (new Date().getTime() - date.getTime()));
        	date = new Date();


            List<SelectItem> items = new Employee().getList();

            this.ContactDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.InCharge.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.InCharge.setSelectList(items);
            this.InCharge.setAnotherField(this.ContactDate);
            
            this.CaseAssignedTo.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CaseAssignedTo.setSelectList(items);
            this.CaseAssignedTo.setAnotherField(this.InCharge);
            
            if(this.getDbActionMode().equals(Cnstnts.INSERT) && !Util.isEmpty(this.getClient())) {
				this.Referrals.setValue(cli.getSponsor());
			}
            this.Referrals.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Referrals.setSelectList(items);
            this.Referrals.setAnotherField(this.CaseAssignedTo);
            
            //1.四種案件下面都新增欄位 "負責程序"(CaseAD)下拉欄位 來源為員工，位置在master業務人員欄位右側
            this.CaseAD.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CaseAD.setSelectList(items);
            this.CaseAD.setAnotherField(this.Referrals);
            rtnString += this.printHtml(this.CaseAD);
        	
            this.LastSchedule.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.LastSchedule.setSize(82);
            this.LastSchedule.setLength(200);
            rtnString += this.printHtml(this.LastSchedule);

        	//System.out.println("=m 13 " + (new Date().getTime() - date.getTime()));
        	date = new Date();
        	
            rtnString += this.TabText.printHiddenTag();
            
           
        }
        return rtnString;
    }
    
    public void setSearchListPrpts() {
    	Properties categoryPrpt = null;
    	Properties employeePrpt = null;
    	try {
			categoryPrpt = new Category().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			employeePrpt = new Employee().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.CaseNo.setListWidth("10%");
		this.CaseNo2.setListWidth("10%");
		
        this.PatentOffice.setListWidth("6%");
        this.PatentOffice.setMapingPrpt(categoryPrpt);
        this.PatentOffice.setNotShowCode(true);

        this.PatentType.setListWidth("8%");
//        this.PatentType.setMapingPrpt(categoryPrpt);
//        this.PatentType.setNotShowCode(true);
        
        this.PatentCaseType.setListWidth("6%");
        this.PatentCaseType.setMapingPrpt(categoryPrpt);
        this.PatentCaseType.setNotShowCode(true);

        this.Title.setListWidth("10%");

        this.ClientName.setListWidth("14%");
        //try {
		//	this.Client.setMapingPrpt(new Client().getNamesPrpts());
		//} catch (Exception e1) {
		//	e1.printStackTrace();
		//}
		//this.Client.setNotShowCode(true);

//        this.FeeScheduleDate.setListWidth("8%");
//        this.FeeScheduleDate.setAlign(Cnstnts.CENTER);
        
        this.CaseAD.setListWidth("8%");
		this.CaseAD.setMapingPrpt(employeePrpt);
		this.CaseAD.setNotShowCode(true);

        this.InCharge.setListWidth("10%");
		this.InCharge.setMapingPrpt(employeePrpt);
		this.InCharge.setNotShowCode(true);

        this.CaseAssignedTo.setListWidth("10%");
		this.CaseAssignedTo.setMapingPrpt(employeePrpt);
		this.CaseAssignedTo.setNotShowCode(true);

        this.ClientContect.setListWidth("10%");
        try {
			this.ClientContect.setMapingPrpt(new Applicant().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.ClientContect.setNotShowCode(true);
		

        this.Status.setListWidth("8%");
        this.Status.setMapingPrpt(categoryPrpt);
        this.Status.setNotShowCode(true);
        
        this.ClientName.setListWidth("5%");
        
        
        Field[] showField = {this.CaseNo, this.PatentType, this.PatentOffice, 
        		this.Title, this.ClientName, this.CaseAD, this.InCharge, this.Status};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }


    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        
        boolean hasInventor = false;
        boolean hasApplicant = false;
        
        String patentinventor = "";
        String patentapplicant = "";
        if(Util.isEmpty(this.getSearchWhereSql())) {
	        if(!Util.isEmpty(getCond1())) {
	        	boolean searchLike = true;
	        	String like = Cnstnts.LIKE;
	
	        	if(!Util.isEmpty(getFullSearchText1())){
		        	if(getCond1().equalsIgnoreCase("ClientName")) {
		        		
		        			if(getFullSearchText1().indexOf(" ") != -1) {
		        				String sql = "";
		        				String[] conds = getFullSearchText1().split("\\s+");
		        				String condSql = "";
		        				for(int i=0;i<conds.length;i++) {
		        					if(i==0) {
		        						sql = "p.Client in(select cc.FlowKey from Client cc where CompanyName like '%"+conds[i]+"%')";
		        						condSql = " where CompanyName like '%"+conds[i]+"%' ";
		        					}
		        					else {
		        						sql += " or p.Client in(select cc.FlowKey from Client cc where CompanyName like '%"+conds[i]+"%')";
		        						condSql += " or CompanyName like '%"+conds[i]+"%' ";
		        					}
		        				}
		        				condSql = "select cc.FlowKey from Client cc " + condSql;
		        				List<String> conds2 = this.getDbUtil().getValueList(condSql, "FlowKey");
		        				String cond = Util.arrayToIncond(conds2.toArray());
		        				
		        				if(whereStr.trim().length()>0) {
			                		whereStr += "and (" + sql + ")";
			                	}
			                	else {
			                		whereStr += "where (" + sql + ")";
			                	}
		        			}
		        			else {
		        				String condSql = "select cc.FlowKey from Client cc where CompanyName like '%"+this.getFullSearchText1()+"%'";
		        				List<String> conds = this.getDbUtil().getValueList(condSql, "FlowKey");
		        				String cond = Util.arrayToIncond(conds.toArray());
		        				
			                	if(whereStr.trim().length()>0) {
			                		whereStr += " And p.Client in(" + cond + ") ";
			                	}
			                	else {
			                		whereStr = " where p.Client in(" + cond + ") ";
			                	}
		        			}
		            }
		        	else  if(getCond1().equalsIgnoreCase("ClientContect")) {
		        		if(!Util.isEmpty(getFullSearchText1())){
		                	if(whereStr.trim().length()>0) {
		                		whereStr += " And ClientContect in (select c.FlowKey from applicant c where c.Names like '%"+
		        				this.getFullSearchText1()+"%') ";
		                	}
		                	else {
		                		whereStr = " where ClientContect in (select c.FlowKey from applicant c where c.Names like '%"+
		        				this.getFullSearchText1()+"%') ";
		                	}
		                }
		            }
		        	else  if(getCond1().equalsIgnoreCase("PriorityNo")) {
		        		if(!Util.isEmpty(getFullSearchText1())){
		                	if(whereStr.trim().length()>0) {
		                		whereStr += " And p.flowkey in (select c.parentid from patentpriority c where c.applyno like '%"+
		        				this.getFullSearchText1()+"%') ";
		                	}
		                	else {
		                		whereStr = " where p.flowkey in (select c.parentid from patentpriority c where c.applyno like '%"+
		        				this.getFullSearchText1()+"%') ";
		                	}
		                }
		            }
		        	else if(getCond1().equalsIgnoreCase("CaseApplicant")) {
		        		hasApplicant = true;

		        			if(getFullSearchText1().indexOf(" ") != -1) {
		        				String sql = "";
		        				String[] conds = getFullSearchText1().split("\\s+");
		        				String condSql = "";
		        				for(int i=0;i<conds.length;i++) {
		        					if(i==0) {
		        						sql = "p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName like '%"+conds[i]+"%')";
		        						condSql = " pa.ApplicantName like '%"+conds[i]+"%' ";
		        					}
		        					else {
		        						sql += "or p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName like '%"+conds[i]+"%')";
		        						condSql += " or pa.ApplicantName like '%"+conds[i]+"%' ";
		        					}
		        				}
		        				patentapplicant = condSql;
		        				//condSql = "select pa.parentid from patentapplicant pa " + condSql;
//		        				List<String> conds2 = this.getDbUtil().getValueList(condSql, "parentid");
//		        				String cond = Util.arrayToIncond(conds2.toArray());
		        				
		        				if(whereStr.trim().length()>0) {
//			                		whereStr += "and p.flowkey in (" + cond + ")";
		        					whereStr += " and (" + condSql + ") ";
			                	}
			                	else {
			                		//whereStr += "where p.flowkey in (" + sql + ")";
			                		whereStr += " where (" + condSql + ") ";
			                	}
		        			}
		        			else {
		        				String condSql = "select pa.parentid from patentapplicant pa where pa.ApplicantName like '%"+this.getFullSearchText1()+"%'";
		        				List<String> conds = this.getDbUtil().getValueList(condSql, "parentid");
		        				String cond = Util.arrayToIncond(conds.toArray());
		        				
			                	if(whereStr.trim().length()>0) {
			                		whereStr += " And p.flowkey in (" + cond + ") ";
//			                		whereStr += " and pa.ApplicantName like '%"+this.getFullSearchText1()+"%' ";
			                	}
			                	else {
			                		whereStr += " where p.flowkey in (" + cond + ") ";
//			                		whereStr = " where pa.ApplicantName like '%"+this.getFullSearchText1()+"%' ";
			                	}
		        			}
		            }
	
		        	else if(getCond1().equalsIgnoreCase("CaseInventor")) {
		        		hasInventor = true;
		        		
		        		//1.下拉選單新增「發明人」，搜尋發明人tab姓名列出結果，並可用空隔當做or 輸入多個條件
		        			if(getFullSearchText1().indexOf(" ") != -1) {
		        				String sql = "";
		        				String[] conds = getFullSearchText1().split("\\s+");
		        				String condSql = "";
		        				for(int i=0;i<conds.length;i++) {
		        					if(i==0) {
		        						sql = "p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName like '%"+conds[i]+"%')";
		        						condSql = " pi.InventorName like '%"+conds[i]+"%' ";
		        					}
		        					else {
		        						sql += "or p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName like '%"+conds[i]+"%')";
		        						condSql += " or pi.InventorName like '%"+conds[i]+"%' ";
		        					}
		        				}
		        				//condSql = "select pa.parentid from patentinventor pa " + condSql;
//		        				List<String> conds2 = this.getDbUtil().getValueList(condSql, "parentid");
//		        				String cond = Util.arrayToIncond(conds2.toArray());
		        				
		        				if(whereStr.trim().length()>0) {
			                		//whereStr += "and p.flowkey in (" + sql + ")";
		        					whereStr += " and (" + condSql + ") ";
			                	}
			                	else {
			                		//whereStr += "where p.flowkey in(" + sql + ")";
			                		whereStr += " where (" + condSql + ") ";
			                	}
		        			}
		        			else {
//		        				String condSql = "select pa.parentid from patentinventor pa where pa.InventorName like '%"+this.getFullSearchText1()+"%'";
//		        				List<String> conds = this.getDbUtil().getValueList(condSql, "parentid");
//		        				String cond = Util.arrayToIncond(conds.toArray());
		        				
			                	if(whereStr.trim().length()>0) {
			                		//whereStr += " And p.flowkey in (" + cond + ") ";
			                		whereStr += " and pi.InventorName like '%"+this.getFullSearchText1()+"%' ";
			                	}
			                	else {
			                		//whereStr = " where p.flowkey in (" + cond + ") ";
			                		whereStr += " where pi.InventorName like '%"+this.getFullSearchText1()+"%' ";
			                	}
		        			}
		            }
		        	else if(getCond1().equalsIgnoreCase("PatentOffice")) {
	            		if(!Util.isEmpty(getFullSearchText1())){
	                    	if(whereStr.trim().length()>0) {
	                    		whereStr += " And p.patentoffice in (select pa.flowkey from category pa where pa.Names like '%"+
	            				this.getFullSearchText1()+"%') ";
	                    	}
	                    	else {
	                    		whereStr = " where p.patentoffice in (select pa.flowkey from category pa where pa.Names like '%"+
	            				this.getFullSearchText1()+"%') ";
	                    	}
	                    }
	                }
		        	else  if(getCond1().equalsIgnoreCase("CaseNo")) {
		        		if(!Util.isEmpty(getFullSearchText1())){
		                	if(whereStr.trim().length()>0) {
		                		whereStr += " And (CaseNo  like '%"+ this.getFullSearchText1()+"%' or CaseNo2  like '%"+ this.getFullSearchText1()+"%') ";
		                	}
		                	else {
		                		whereStr += " where (CaseNo  like '%"+ this.getFullSearchText1()+"%' or CaseNo2  like '%"+ this.getFullSearchText1()+"%') ";
		                	}
		                }
		            }
		        	else {	
		        		if(getFullSearchText1().indexOf(" ") != -1) {
	        				String sql = "";
	        				String[] conds = getFullSearchText1().split("\\s+");
	        				for(int i=0;i<conds.length;i++) {
	        					if(i==0) {
	        						sql = "p." + getCond1() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText1()+'%':getFullSearchText1()) + "'";
	        					}
	        					else {
	        						sql += "or p." + getCond1() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText1()+'%':getFullSearchText1()) + "'";
	        					}
	        				}
	        				
	        				if(whereStr.trim().length()>0) {
		                		whereStr += "and (" + sql + ")";
		                	}
		                	else {
		                		whereStr += "where (" + sql + ")";
		                	}
	        			}
		        		else {
			        		if(whereStr.indexOf("where") != -1) {
			                    whereStr += " and p." + getCond1() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText1()+'%':getFullSearchText1()) + "' ";
			                }
			                else {
			                    whereStr += " where p." + getCond1() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText1()+'%':getFullSearchText1()) + "' ";
			                }
		        		}
		        	}
	        	}
	        }
	        else {
	        	if(!Util.isEmpty(getFullSearchText1())) {
		        	//全文檢索
		        	if(whereStr.indexOf("where") != -1) {
		                whereStr += " and ";
		            }
		            else {
		                whereStr += " where ";
		            }
		        	
	        		if(getFullSearchText1().indexOf(" ") != -1) {
	    				String sql = "";
	    				String[] conds = getFullSearchText1().split("\\s+");
	    				for(int i=0;i<conds.length;i++) {
	    					if(i==0) {
	    						sql = "(p.CaseNo like '%" + conds[i] + "%' or "
	    								+ "p.CaseNo2 like '%" + conds[i] + "%' or "
	    	    						+ "p.ApplyNo like '%" + conds[i] + "%' or "
	    	    						+ "p.LicenseNo like '%" + conds[i] + "%' or "
	    	    						+ "p.Title like '%" + conds[i] + "%' or "
	    	    						+ "p.OriginalTitle like '%" + conds[i] + "%' or "
	    	    						+ "p.Client like '%" + conds[i] + "%' or "
	    	    						+ "p.Client in(select cc.FlowKey from Client cc where CompanyName like '%"+ conds[i]+"%') or "
	    	    						+ "p.PatentCaseType like '%" + conds[i] + "%' or "
	    	    						+ "p.PatentType like '%" + conds[i] + "%' or "
	    	    						+ "p.PatentOffice like '%" + conds[i] + "%' or "
	    	    						+ "p.Status like '%" + conds[i] + "%' or "
	    	    						+ "p.InCharge like '%" + conds[i] + "%' or "
	    	    						+ "p.CaseAssignedTo like '%" + conds[i] + "%' or "
	    	    						+ "p.InternalNo like '%" + conds[i] + "%' or "
	    	    						+ "p.ClientContect in (select c.FlowKey from applicant c where c.Names like '%"+
	    	    						conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName like '%"+conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName like '%"+conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentpriority pa where pa.applyno like '%"+conds[i]+"%') or "
	    	    						+ "p.SerialMotherCase like '%" + conds[i] + "%'" ;
	    	    	        	
	    						sql += ")";
	    					}
	    					else {
	    						sql += "or (p.CaseNo like '%" + conds[i] + "%' or "
	    								+ "p.CaseNo2 like '%" + conds[i] + "%' or "
	    	    						+ "p.ApplyNo like '%" + conds[i] + "%' or "
	    	    						+ "p.LicenseNo like '%" + conds[i] + "%' or "
	    	    						+ "p.Title like '%" + conds[i] + "%' or "
	    	    						+ "p.OriginalTitle like '%" + conds[i] + "%' or "
	    	    						+ "p.Client like '%" + conds[i] + "%' or "
	    	    						+ "p.Client in(select cc.FlowKey from Client cc where CompanyName like '%"+ conds[i]+"%') or "
	    	    						+ "p.PatentCaseType like '%" + conds[i] + "%' or "
	    	    						+ "p.PatentType like '%" + conds[i] + "%' or "
	    	    						+ "p.PatentOffice like '%" + conds[i] + "%' or "
	    	    						+ "p.Status like '%" + conds[i] + "%' or "
	    	    						+ "p.InCharge like '%" + conds[i] + "%' or "
	    	    	    				+ "p.CaseAssignedTo like '%" + conds[i] + "%' or "
	    	    						+ "p.InternalNo like '%" + conds[i] + "%' or "
   	    								+ "p.ClientContect in(select c.FlowKey from applicant c where c.Names like '%"+
   	    								conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName like '%"+conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName like '%"+conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentpriority pa where pa.applyno like '%"+conds[i]+"%') or "
	    	    						+ "p.SerialMotherCase like '%" + conds[i] + "%'" ;
	    	    	        	
	    						sql += ")";
	    					}
	    				}
	    				
	    				if(whereStr.trim().length()>0) {
	                		whereStr += " (" + sql + ")";
	                	}
	                	else {
	                		whereStr += " (" + sql + ")";
	                	}
	    			}
	        		else {
	        			whereStr += "(p.CaseNo like '%" + getFullSearchText1() + "%' or "
	        					+ "p.CaseNo2 like '%" + getFullSearchText1() + "%' or "
	    						+ "p.ApplyNo like '%" + getFullSearchText1() + "%' or "
	    						+ "p.LicenseNo like '%" + getFullSearchText1() + "%' or "
	    						+ "p.Title like '%" + getFullSearchText1() + "%' or "
	    						+ "p.OriginalTitle like '%" + getFullSearchText1() + "%' or "
	    						+ "p.Client like '%" + getFullSearchText1() + "%' or "
	    						+ "p.Client in(select cc.FlowKey from Client cc where CompanyName like '%"+ this.getFullSearchText1()+"%') or "
	    						+ "p.PatentCaseType like '%" + getFullSearchText1() + "%' or "
	    						+ "p.PatentType like '%" + getFullSearchText1() + "%' or "
	    						+ "p.PatentOffice like '%" + getFullSearchText1() + "%' or "
	    						+ "p.Status like '%" + getFullSearchText1() + "%' or "
	    						+ "p.InCharge like '%" + getFullSearchText1() + "%' or "
	    	    				+ "p.CaseAssignedTo like '%" + getFullSearchText1() + "%' or "
	    						+ "p.InternalNo like '%" + getFullSearchText1() + "%' or "
	    						+ "p.ClientContect in(select c.FlowKey from applicant c where c.Names like '%"+
				        				this.getFullSearchText1()+"%') or "
	    						+ "p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName like '%"+this.getFullSearchText1()+"%') or "
	    						+ "p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName like '%"+this.getFullSearchText1()+"%') or "
	    						+ "p.flowkey in (select pa.parentid from patentpriority pa where pa.applyno like '%"+this.getFullSearchText1()+"%') or "
	    						+ "p.SerialMotherCase like '%" + getFullSearchText1() + "%'" ;
	    	        	
	    	        	whereStr += ")";
	        		}
		        	
		        	
	        	}
	        }
	        
	        if(!Util.isEmpty(getCond11())) {
	        	boolean searchLike = true;
	        	String like = Cnstnts.LIKE;
	        	String sqlCond = " and ";
	       		if(getSqlCond1().equals("not")) {
	       			like = " not like ";
	       		}
	       		
	       		if(getSqlCond1().equals("or")) {
	       			sqlCond = " or ";
	       		}
	        	
	        	if(!Util.isEmpty(getFullSearchText11())){
		        	if(getCond11().equalsIgnoreCase("ClientName")) {
		        		
		        			if(getFullSearchText11().indexOf(" ") != -1) {
		        				String sql = "";
		        				String[] conds = getFullSearchText11().split("\\s+");
		        				String condSql = "";
		        				for(int i=0;i<conds.length;i++) {
		        					if(i==0) {
		        						sql = "p.Client in(select cc.FlowKey from Client cc where CompanyName " + like + " '%"+conds[i]+"%')";
		        						condSql = " where CompanyName " + like + " '%"+conds[i]+"%' ";
		        					}
		        					else {
		        						sql += " or p.Client in(select cc.FlowKey from Client cc where CompanyName " + like + " '%"+conds[i]+"%')";
		        						condSql += " or CompanyName " + like + " '%"+conds[i]+"%' ";
		        					}
		        				}
		        				condSql = "select cc.FlowKey from Client cc " + condSql;
		        				List<String> conds2 = this.getDbUtil().getValueList(condSql, "FlowKey");
		        				String cond = Util.arrayToIncond(conds2.toArray());
		        				
		        				if(whereStr.trim().length()>0) {
			                		whereStr += " " + sqlCond + " (" + sql + ")";
			                	}
			                	else {
			                		whereStr += "where (" + sql + ")";
			                	}
		        			}
		        			else {
		        				String condSql = "select cc.FlowKey from Client cc where CompanyName " + like + " '%"+this.getFullSearchText11()+"%'";
		        				List<String> conds = this.getDbUtil().getValueList(condSql, "FlowKey");
		        				String cond = Util.arrayToIncond(conds.toArray());
		        				
			                	if(whereStr.trim().length()>0) {
			                		whereStr += " " + sqlCond + " p.Client in(" + cond + ") ";
			                	}
			                	else {
			                		whereStr = " where p.Client in(" + cond + ") ";
			                	}
		        			}
		            }
		        	else  if(getCond11().equalsIgnoreCase("ClientContect")) {
		        		if(!Util.isEmpty(getFullSearchText11())){
		                	if(whereStr.trim().length()>0) {
		                		whereStr += " " + sqlCond + " ClientContect in (select c.FlowKey from applicant c where c.Names " + like + " '%"+
		        				this.getFullSearchText11()+"%') ";
		                	}
		                	else {
		                		whereStr = " where ClientContect in (select c.FlowKey from applicant c where c.Names " + like + " '%"+
		        				this.getFullSearchText11()+"%') ";
		                	}
		                }
		            }
		        	else if(getCond11().equalsIgnoreCase("CaseApplicant")) {
		        		hasApplicant = true;

		        			if(getFullSearchText11().indexOf(" ") != -1) {
		        				String sql = "";
		        				String[] conds = getFullSearchText11().split("\\s+");
		        				String condSql = "";
		        				for(int i=0;i<conds.length;i++) {
		        					if(i==0) {
		        						sql = "p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName " + like + " '%"+conds[i]+"%')";
		        						condSql = " pa.ApplicantName " + like + " '%"+conds[i]+"%' ";
		        					}
		        					else {
		        						sql += "or p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName " + like + " '%"+conds[i]+"%')";
		        						condSql += " or pa.ApplicantName " + like + " '%"+conds[i]+"%' ";
		        					}
		        				}
		        				patentapplicant = condSql;
		        				//condSql = "select pa.parentid from patentapplicant pa " + condSql;
//		        				List<String> conds2 = this.getDbUtil().getValueList(condSql, "parentid");
//		        				String cond = Util.arrayToIncond(conds2.toArray());
		        				
		        				if(whereStr.trim().length()>0) {
//			                		whereStr += "and p.flowkey in (" + cond + ")";
		        					whereStr += " " + sqlCond + " (" + condSql + ") ";
			                	}
			                	else {
			                		//whereStr += "where p.flowkey in (" + sql + ")";
			                		whereStr += " where (" + condSql + ") ";
			                	}
		        			}
		        			else {
		        				String condSql = "select pa.parentid from patentapplicant pa where pa.ApplicantName " + like + " '%"+this.getFullSearchText11()+"%'";
		        				List<String> conds = this.getDbUtil().getValueList(condSql, "parentid");
		        				String cond = Util.arrayToIncond(conds.toArray());
		        				
			                	if(whereStr.trim().length()>0) {
			                		whereStr += " " + sqlCond + " p.flowkey in (" + cond + ") ";
//			                		whereStr += " " + sqlCond + " pa.ApplicantName " + like + " '%"+this.getFullSearchText11()+"%' ";
			                	}
			                	else {
			                		whereStr += " And p.flowkey in (" + cond + ") ";
//			                		whereStr = " where pa.ApplicantName " + like + " '%"+this.getFullSearchText11()+"%' ";
			                	}
		        			}
		            }
	
		        	else if(getCond11().equalsIgnoreCase("CaseInventor")) {
		        		hasInventor = true;

		        		//1.下拉選單新增「發明人」，搜尋發明人tab姓名列出結果，並可用空隔當做or 輸入多個條件
		        			if(getFullSearchText11().indexOf(" ") != -1) {
		        				String sql = "";
		        				String[] conds = getFullSearchText11().split("\\s+");
		        				String condSql = "";
		        				for(int i=0;i<conds.length;i++) {
		        					if(i==0) {
		        						sql = "p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName " + like + " '%"+conds[i]+"%')";
		        						condSql = " pi.InventorName " + like + " '%"+conds[i]+"%' ";
		        					}
		        					else {
		        						sql += "or p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName " + like + " '%"+conds[i]+"%')";
		        						condSql += " or pi.InventorName " + like + " '%"+conds[i]+"%' ";
		        					}
		        				}
		        				//condSql = "select pa.parentid from patentinventor pa " + condSql;
//		        				List<String> conds2 = this.getDbUtil().getValueList(condSql, "parentid");
//		        				String cond = Util.arrayToIncond(conds2.toArray());
		        				
		        				if(whereStr.trim().length()>0) {
			                		//whereStr += "and p.flowkey in (" + sql + ")";
		        					whereStr += " " + sqlCond + " (" + condSql + ") ";
			                	}
			                	else {
			                		//whereStr += "where p.flowkey in(" + sql + ")";
			                		whereStr += " where (" + condSql + ") ";
			                	}
		        			}
		        			else {
//		        				String condSql = "select pa.parentid from patentinventor pa where pa.InventorName like '%"+this.getFullSearchText11()+"%'";
//		        				List<String> conds = this.getDbUtil().getValueList(condSql, "parentid");
//		        				String cond = Util.arrayToIncond(conds.toArray());
		        				
			                	if(whereStr.trim().length()>0) {
			                		//whereStr += " And p.flowkey in (" + cond + ") ";
			                		whereStr += " " + sqlCond + " pi.InventorName " + like + " '%"+this.getFullSearchText11()+"%' ";
			                	}
			                	else {
			                		//whereStr = " where p.flowkey in (" + cond + ") ";
			                		whereStr += " where pi.InventorName " + like + " '%"+this.getFullSearchText11()+"%' ";
			                	}
		        			}
		            }
		        	else if(getCond11().equalsIgnoreCase("PatentOffice")) {
	            		if(!Util.isEmpty(getFullSearchText11())){
	                    	if(whereStr.trim().length()>0) {
	                    		whereStr += " " + sqlCond + " p.patentoffice in (select pa.flowkey from category pa where pa.Names " + like + " '%"+
	            				this.getFullSearchText11()+"%') ";
	                    	}
	                    	else {
	                    		whereStr = " where p.patentoffice in (select pa.flowkey from category pa where pa.Names " + like + " '%"+
	            				this.getFullSearchText11()+"%') ";
	                    	}
	                    }
	                }
		        	else  if(getCond11().equalsIgnoreCase("PriorityNo")) {
		        		if(!Util.isEmpty(getFullSearchText11())){
		                	if(whereStr.trim().length()>0) {
		                		whereStr += " " + sqlCond + " p.flowkey in (select c.parentid from patentpriority c where c.applyno " + like + " '%"+
		        				this.getFullSearchText11()+"%') ";
		                	}
		                	else {
		                		whereStr = " where p.flowkey in (select c.parentid from patentpriority c where c.applyno " + like + " '%"+
		        				this.getFullSearchText11()+"%') ";
		                	}
		                }
		            }
		        	else  if(getCond11().equalsIgnoreCase("CaseNo")) {
		        		if(!Util.isEmpty(getFullSearchText11())){
		        			if(getSqlCond1().equals("not")) {
			                	if(whereStr.trim().length()>0) {
			                		whereStr += " " + sqlCond + " (CaseNo  " + like + " '%"+ this.getFullSearchText11()+"%' and CaseNo2  " + like + " '%"+ this.getFullSearchText11()+"%') ";
			                	}
			                	else {
			                		whereStr += " where (CaseNo  " + like + " '%"+ this.getFullSearchText11()+"%' and CaseNo2  " + like + " '%"+ this.getFullSearchText11()+"%') ";
			                	}
		        			}
		        			else {
			                	if(whereStr.trim().length()>0) {
			                		whereStr += " " + sqlCond + " (CaseNo  " + like + " '%"+ this.getFullSearchText11()+"%' or CaseNo2  " + like + " '%"+ this.getFullSearchText11()+"%') ";
			                	}
			                	else {
			                		whereStr += " where (CaseNo  " + like + " '%"+ this.getFullSearchText11()+"%' or CaseNo2  " + like + " '%"+ this.getFullSearchText11()+"%') ";
			                	}
		        			}
		                }
		            }
		        	else {	
		        		if(getFullSearchText11().indexOf(" ") != -1) {
	        				String sql = "";
	        				String[] conds = getFullSearchText11().split("\\s+");
	        				for(int i=0;i<conds.length;i++) {
	        					if(i==0) {
	        						sql = "p." + getCond11() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText11()+'%':getFullSearchText11()) + "'";
	        					}
	        					else {
	        						sql += "or p." + getCond11() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText11()+'%':getFullSearchText11()) + "'";
	        					}
	        				}
	        				
	        				if(whereStr.trim().length()>0) {
		                		whereStr += "" + sqlCond + " (" + sql + ")";
		                	}
		                	else {
		                		whereStr += "where (" + sql + ")";
		                	}
	        			}
		        		else {
			        		if(whereStr.indexOf("where") != -1) {
			                    whereStr += " " + sqlCond + " p." + getCond11() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText11()+'%':getFullSearchText11()) + "' ";
			                }
			                else {
			                    whereStr += " where p." + getCond11() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText11()+'%':getFullSearchText11()) + "' ";
			                }
		        		}
		        	}
	        	}
	        }
	        else {
	        	if(!Util.isEmpty(getFullSearchText11())) {
	        		boolean searchLike = true;
		        	String like = Cnstnts.LIKE;
		       		if(getSqlCond1().equals("not")) {
		       			like = " not like ";
		       		}
		       		
		        	//全文檢索
		        	if(whereStr.indexOf("where") != -1) {
		                whereStr += " and ";
		            }
		            else {
		                whereStr += " where ";
		            }
		        	
	        		if(getFullSearchText11().indexOf(" ") != -1) {
	    				String sql = "";
	    				String[] conds = getFullSearchText11().split("\\s+");
	    				for(int i=0;i<conds.length;i++) {
	    					if(i==0) {
	    						sql = "(p.CaseNo " + like + " '%" + conds[i] + "%' or "
	    								+ "p.CaseNo2 " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.ApplyNo " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.LicenseNo " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.Title " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.OriginalTitle " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.Client " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.Client in(select cc.FlowKey from Client cc where CompanyName " + like + " '%"+ conds[i]+"%') or "
	    	    						+ "p.PatentCaseType " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.PatentType " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.PatentOffice " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.Status " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.InCharge " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.CaseAssignedTo " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.InternalNo " + like + " '%" + conds[i] + "%' or "
	    	    	    				+ "p.ClientContect in(select c.FlowKey from applicant c where c.Names " + like + " '%"+
	    	    	    				conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName " + like + " '%"+conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName " + like + " '%"+conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentpriority pa where pa.applyno " + like + " '%"+conds[i]+"%') or "
	    	    						+ "p.SerialMotherCase " + like + " '%" + conds[i] + "%'" ;
	    	    	        	
	    						sql += ")";
	    					}
	    					else {
	    						sql += "or (p.CaseNo " + like + " '%" + conds[i] + "%' or "
	    								+ "p.CaseNo2 " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.ApplyNo " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.LicenseNo " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.Title " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.OriginalTitle " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.Client " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.Client in(select cc.FlowKey from Client cc where CompanyName " + like + " '%"+ conds[i]+"%') or "
	    	    						+ "p.PatentCaseType " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.PatentType " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.PatentOffice " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.Status " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.InCharge " + like + " '%" + conds[i] + "%' or "
	    	    	    				+ "p.CaseAssignedTo " + like + " '%" + conds[i] + "%' or "
	    	    						+ "p.InternalNo " + like + " '%" + conds[i] + "%' or "
	    	    	    				+ "p.ClientContect in(select c.FlowKey from applicant c where c.Names " + like + " '%"+
	    	    	    				conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName " + like + " '%"+conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName " + like + " '%"+conds[i]+"%') or "
	    	    						+ "p.flowkey in (select pa.parentid from patentpriority pa where pa.applyno " + like + " '%"+conds[i]+"%') or "
	    	    						+ "p.SerialMotherCase " + like + " '%" + conds[i] + "%'" ;
	    	    	        	
	    						sql += ")";
	    					}
	    				}
	    				
	    				if(whereStr.trim().length()>0) {
	                		whereStr += " (" + sql + ")";
	                	}
	                	else {
	                		whereStr += " (" + sql + ")";
	                	}
	    			}
	        		else {
	        			whereStr += "(p.CaseNo " + like + " '%" + getFullSearchText11() + "%' or "
	        					+ "p.CaseNo2 " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.ApplyNo " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.LicenseNo " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.Title " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.OriginalTitle " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.Client " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.Client in(select cc.FlowKey from Client cc where CompanyName " + like + " '%"+ this.getFullSearchText11()+"%') or "
	    						+ "p.PatentCaseType " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.PatentType " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.PatentOffice " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.Status " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.InCharge " + like + " '%" + getFullSearchText11() + "%' or "
	    	    				+ "p.CaseAssignedTo " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.InternalNo " + like + " '%" + getFullSearchText11() + "%' or "
	    						+ "p.ClientContect in(select c.FlowKey from applicant c where c.Names " + like + " '%"+
				        				this.getFullSearchText11()+"%') or "
	    						+ "p.flowkey in (select pa.parentid from patentapplicant pa where pa.ApplicantName " + like + " '%"+this.getFullSearchText11()+"%') or "
	    						+ "p.flowkey in (select pa.parentid from patentinventor pa where pa.InventorName " + like + " '%"+this.getFullSearchText11()+"%') or "
	    						+ "p.flowkey in (select pa.parentid from patentpriority pa where pa.applyno " + like + " '%"+this.getFullSearchText11()+"%') or "
	    						+ "p.SerialMotherCase " + like + " '%" + getFullSearchText11() + "%'" ;
	    	        	
	    	        	whereStr += ")";
	        		}
		        	
		        	
	        	}
	        }
	
	        if(!Util.isEmpty(getCond2())) {
	        	
	        	boolean searchLike = false;
	        	String like = Cnstnts.LIKE;
	       		if(getSqlCond11().equals("not")) {
	       			like = " not like ";
	       		}
	        	
	            if(getSqlCond11().equals("not")) {
	            	if(getCond2().equalsIgnoreCase("Country")) {
	            		if(!Util.isEmpty(getFullSearchText2())){
	                    	if(whereStr.trim().length()>0) {
	                    		whereStr += " And p.patentoffice not in (select pa.flowkey from category pa where pa.Names like '%"+
	            				this.getFullSearchText2()+"%') ";
	                    	}
	                    	else {
	                    		whereStr = " where p.patentoffice not in (select pa.flowkey from category pa where pa.Names like '%"+
	            				this.getFullSearchText2()+"%') ";
	                    	}
	                    }
	                }
	            	else {
	                    if(whereStr.indexOf("where") != -1) {
	                        whereStr += " and p." + getCond2() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText2()+'%':getFullSearchText2()) + "' ";
	                    }
	                    else {
	                        whereStr += " where p." + getCond2() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText2()+'%':getFullSearchText2()) + "' ";
	                    }
	            	}
	            }
	            else {
	            	if(getCond2().equalsIgnoreCase("Country")) {
	            		if(!Util.isEmpty(getFullSearchText2())){
	                    	if(whereStr.trim().length()>0) {
	                    		whereStr += " " + getSqlCond11() + " p.patentoffice in (select pa.flowkey from category pa where pa.Names like '%"+
	            				this.getFullSearchText2()+"%') ";
	                    	}
	                    	else {
	                    		whereStr = " where p.patentoffice in (select pa.flowkey from category pa where pa.Names like '%"+
	            				this.getFullSearchText2()+"%') ";
	                    	}
	                    }
	                }
	            	else if(!Util.isEmpty(getFullSearchText2())){
	                    if(whereStr.indexOf("where") != -1) {
	                        whereStr += " " + getSqlCond11() + " p." + getCond2() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText2()+'%':getFullSearchText2()) + "' ";
	                    }
	                    else {
	                        whereStr += " where p." + getCond2() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText2()+'%':getFullSearchText2()) + "' ";
	                    }
	            	}
	            }
	        }
	        else {
	        	if(!Util.isEmpty(getFullSearchText2())) {
	        		
		        	//全文檢索
		        	if(getSqlCond11() != null && getSqlCond11().equals("not")) {
		        		if(whereStr.indexOf("where") != -1) {
		                    whereStr += " and ";
		                }
		                else {
		                    whereStr += " where ";
		                }
	
		        		whereStr += "(p.CaseNo  not like  '%" + getFullSearchText2() + "%' or "
		        					+ "p.CaseNo2  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.ApplyNo  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.LicenseNo  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.Title  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.OriginalTitle  not like  '%" + getFullSearchText2() + "%' or "
									//+ "p.Client  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.Client in(select cc.FlowKey from Client cc where CompanyName not like '%"+
			        				this.getFullSearchText2()+"%') or "
									+ "ClientName  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.PatentCaseType  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.PatentType  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.PatentOffice  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.Status  not like  '%" + getFullSearchText2() + "%' or "
									+ "p.InCharge  not like  '%" + getFullSearchText2() + "%' or " 
									+ "p.CaseAssignedTo  not like  '%" + getFullSearchText2() + "%' or " 
									+ "p.InternalNo not like '%" + getFullSearchText2() + "%' or "
									+ "p.ClientContect not like '%" + getFullSearchText2() + "%' or "
		        					+ "p.SerialMotherCase not like '%" + getFullSearchText2() + "%'" ;
			        	whereStr += ")";
					} else {
						if(whereStr.indexOf("where") != -1) {
			                whereStr += " and ";
			            }
			            else {
			                whereStr += " where ";
			            }
						whereStr += "(p.CaseNo like '%" + getFullSearchText2() + "%' or "
								+ "p.CaseNo2 like  '%" + getFullSearchText2() + "%' or "
								+ "p.ApplyNo like '%" + getFullSearchText2() + "%' or "
								+ "p.LicenseNo like '%" + getFullSearchText2() + "%' or "
								+ "p.Title like '%" + getFullSearchText2() + "%' or "
								+ "p.OriginalTitle like '%" + getFullSearchText2() + "%' or "
								+ "p.Client like '%" + getFullSearchText2() + "%' or "
								//+ "ClientName like '%" + getFullSearchText2() + "%' or "
								+ "p.Client in(select cc.FlowKey from Client cc where CompanyName like '%"+
		        				this.getFullSearchText2()+"%') or "
								+ "p.PatentCaseType like '%" + getFullSearchText2() + "%' or "
								+ "p.PatentType like '%" + getFullSearchText2() + "%' or "
								+ "p.PatentOffice like '%" + getFullSearchText2() + "%' or "
								+ "p.Status like '%" + getFullSearchText2() + "%' or "
								+ "p.InCharge like '%" + getFullSearchText2() + "%' or " 
								+ "p.InternalNo like '%" + getFullSearchText2() + "%' or " 
								+ "p.CaseAssignedTo like '%" + getFullSearchText2() + "%' or "
								+ "p.ClientContect like '%" + getFullSearchText2() + "%' or "
		        				+ "p.SerialMotherCase like '%" + getFullSearchText2() + "%'" ;
	
			        	whereStr += ")";
					}
	        	}
	        }
	
	        if(!Util.isEmpty(getCond3())) {
	            if(getSqlCond2().equals("not")) {
	                if(whereStr.indexOf("where") != -1) {
	                    whereStr += " and p." + getCond3() + " not between '" + getStartDate() + "' and '" + getEndDate() + "' ";
	                }
	                else {
	                    whereStr += " where p." + getCond3() + " between '" + getStartDate() + "' and '" + getEndDate() + "' ";
	                }
	            }
	            else {
	                if(whereStr.indexOf("where") != -1) {
	                    whereStr += " " + getSqlCond2() + " p." + getCond3() + " between '" + getStartDate() + "' and '" + getEndDate() + "' "; 
	                }
	                else {
	                    whereStr += " where p." + getCond3() + " between '" + getStartDate() + "' and '" + getEndDate() + "' ";
	                }
	            }
	        }
	        
	        if(Util.compareTo(this.getNewCaseCheck(), "Y")) {
	        	if(whereStr.indexOf("where") != -1) {
	                whereStr += " and p.caseno = '' "; 
	            }
	            else {
	            	whereStr += " where p.caseno = '' ";
	            }
	        }
        }
        else {
        	whereStr = " where " +  this.getSearchWhereSql();
        }
        
        if(Util.compareTo(this.getQuotationIn(), "true")) {
        	if(whereStr.indexOf("where") != -1) {
        		whereStr += " and p.quotationFlowKey = '" + this.getQuotationFlowKey() + "' "; 
            }
            else {
            	whereStr += " where p.quotationFlowKey = '" + this.getQuotationFlowKey() + "' ";
            }
        }
        
        whereStr = this.getDataAuthorityWhereSQL(whereStr);
        String SQL = Cnstnts.EMPTY_STRING;
        SQL = "select distinct p.* , '' as CaseInventorNames" +
        	", '' as PriorityDate, '' as PriorityNo "+
        	"from PatentCase p ";
        	if(hasInventor) {
        		SQL += " left join patentinventor pi on p.flowkey = pi.parentid ";
        	}
        	if(hasApplicant) {
        		SQL += " left join patentapplicant pa on p.flowkey = pa.parentid ";
        	}
        	  
        	SQL += whereStr.replaceAll("CreateDept", "p.CreateDept").replaceAll(" FlowKey", " p.FlowKey").replaceAll(" Applicant "," p.Applicant ");
        if (Cnstnts.EXPORTCSV.equals(this.getDbActionMode()) ||
        		Cnstnts.EXPORTXLS.equals(this.getDbActionMode())) {
        	SQL = "select distinct p.* , '' as CaseInventorNames" +
                	", '' as PriorityDate, '' as PriorityNo "+
                	"from PatentCase p ";
        	if(hasInventor) {
        		SQL += " left join patentinventor pi on p.flowkey = pi.parentid ";
        	}
        	if(hasApplicant) {
        		SQL += " left join patentapplicant pa on p.flowkey = pa.parentid ";
        	}
        	SQL += whereStr.replaceAll("CreateDept", "p.CreateDept").replaceAll(" FlowKey", " p.FlowKey").replaceAll(" Applicant "," p.Applicant ");
        }
        //SQL = Util.addOrderSQL(SQL, "p." + this.getOrderKey(), this.getOrderSequence());
        SQL = Util.addOrderSQL(SQL, this.getOrderKey(), this.getOrderSequence());
        System.out.println(SQL);
        return this.doSearch(SQL);
    }
    
    public List<Object[]> doSearch(String SQL) throws Exception{
  	  	if(this.getPageNo()==0){
  	  		this.setPageNo(1);
  	  	}
  	  	int priorityNoIndex = 0;
	  	boolean hasPriorityNo = false;
  	  	int priorityDateIndex = 0;
	  	boolean hasPriorityDate = false;
  	  	int applicantIndex = 0;
	  	boolean hasApplicant = false;
	  	int inventorIndex = 0;
	  	boolean hasInventor = false;
	  	int patentTypeIndex = 0;
	  	boolean hasPatentType = false;
	  	int titleIndex = 0;
	  	boolean hasTitle = false;
	  	int clientNameIndex = 0;
	  	boolean hasClientName = false;
	  	for(int i=0;i<this.getShowField().length;i++) {
	  		Field field = this.getShowField()[i];
	  		if(field.getName().equals("CaseApplicantNames")) {
	  			hasApplicant = true;
	  			applicantIndex = i + 1;
	  		}
	  		if(field.getName().equals("PriorityDate")) {
	  			hasPriorityDate = true;
	  			priorityDateIndex = i + 1;
	  		}
	  		if(field.getName().equals("PriorityNo")) {
	  			hasPriorityNo = true;
	  			priorityNoIndex = i + 1;
	  		}
	  		if(field.getName().equals("CaseInventorNames")) {
	  			hasInventor = true;
	  			inventorIndex = i + 1;
	  		}
	  		if(field.getName().equals("PatentType")) {
	  			hasPatentType = true;
	  			patentTypeIndex = i + 1;
	  		}
	  		if(field.getName().equals("Title")) {
	  			hasTitle = true;
	  			titleIndex = i + 1;
	  		}
	  		if(field.getName().equals("ClientName")) {
	  			hasClientName = true;
	  			clientNameIndex = i + 1;
	  		}
	  	}
	  	
        int recordCount=0;
        
        List<Object[]> rtnList = new ArrayList<Object[]>();

	  	String SQL2 = SQL;
		if(SQL2.indexOf("order by") != -1) {
			SQL2 = SQL2.substring(0, SQL2.indexOf("order by"));
		}
        String sql2 = "select count(*) as count from (" + SQL2 + ") as t";
		int totalCount = this.getDbUtil().getSqlIntValue(sql2, "count");

		String limitSQL = SQL + " LIMIT " + (this.getPageNo() - 1)*this.getPageRecords() + " , " + this.getPageRecords();
		//System.out.println(limitSQL);
		
        Date befDate = new Date();
        Iterator itr = null;
        if (Cnstnts.EXPORTCSV.equals(this.getDbActionMode()) ||
        		Cnstnts.EXPORTXLS.equals(this.getDbActionMode())) {
        	itr = this.getDbUtil().getList(SQL, this.getShowField()).iterator();
        }
        else {
        	itr = this.getDbUtil().getList(SQL, this.getShowField()).iterator();
        }
        Date aftDate = new Date();
		//System.out.println("1 " + (aftDate.getTime() - befDate.getTime()));
		
        while(itr.hasNext()){
      	  Object[] record = (Object[])itr.next();
      	  recordCount++;
      	  
      	  if(recordCount<=this.getPageNo()*this.getPageRecords()
      			  && recordCount>(this.getPageNo()-1)*this.getPageRecords()){
	      		if (hasPriorityDate) {
					String sql = "select PriorityDate from patentpriority where ParentId = '"
							+ record[0] + "' and PriorityDate is not null  ";
					List<String> signingNames = this.getDbUtil().getValueList(
							sql, "PriorityDate");
					String signingName = "";
					for (String s : signingNames) {
						signingName += s + ";";
					}
					record[priorityDateIndex] = signingName;
				}
	      		if (hasTitle && !Cnstnts.EXPORTCSV.equals(this.getDbActionMode())&&
	            		!Cnstnts.EXPORTXLS.equals(this.getDbActionMode())) {
          			String value = record[titleIndex].toString();
    				if(value.length() > 8)  {
    					value = value.substring(0, 8) + "...";
    				}
    				
    				record[titleIndex] = value;
    			}
	      		if (hasClientName && !Cnstnts.EXPORTCSV.equals(this.getDbActionMode()) &&
	            		!Cnstnts.EXPORTXLS.equals(this.getDbActionMode())) {
          			String value = record[clientNameIndex].toString();
    				if(value.length() > 8)  {
    					value = value.substring(0, 8) + "...";
    				}
    				
    				record[clientNameIndex] = value;
    			}
	      		if (hasPriorityNo) {
					String sql = "select ApplyNo from patentpriority where ParentId = '"
							+ record[0] + "' and ApplyNo is not null  ";
					List<String> signingNames = this.getDbUtil().getValueList(
							sql, "ApplyNo");
					String signingName = "";
					for (String s : signingNames) {
						signingName += s + ";";
					}
					record[priorityNoIndex] = signingName;
				}
				if (hasApplicant) {
					String sql = "select applicantName from PatentApplicant where ParentId = '"
							+ record[0] + "' and applicantname is not null   ";
					List<String> signingNames = this.getDbUtil().getValueList(
							sql, "applicantName");
					String signingName = "";
					for (String s : signingNames) {
						signingName += s + ";";
					}
					record[applicantIndex] = signingName;
				}
				if (hasInventor) {
					String sql = "select InventorName from PatentInventor where ParentId = '"
							+ record[0] + "' and InventorName is not null   ";
					List<String> signingNames = this.getDbUtil().getValueList(
							sql, "InventorName");
					String signingName = "";
					for (String s : signingNames) {
						signingName += s + ";";
					}
					record[inventorIndex] = signingName;
				}
				if (hasPatentType) {
					String sql = "select patentoffice from PatentCase where flowkey = '"
							+ record[0] + "'  ";
					String office = this.getDbUtil().getFieldValue(sql,
							"patentoffice");
					record[patentTypeIndex] = Util.getPatentTypeNameByOffice(record[patentTypeIndex].toString(), office);
				}

				rtnList.add(record);
      	  }
        }
        this.setFindRecords(totalCount);
        //this.setFindRecords(recordCount);
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
    	/*
		 * 專利案件代碼為：客戶代碼-PXXX(流水碼)國家碼
新增一"產生案件編號功能"(只有在新增模式才會出現)，點選時會先檢查客戶代碼以及國家別是否已經填入資料，
若沒有就會出現提醒視窗，若有，則依據上述條件自動產生專利案件代碼
		 */
//    	if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
//	    	if(Util.isEmpty(this.getFlowKey())) {
//	    		if(!Util.isEmpty(this.getPatentOffice())) {
//	    			String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
//	    			String sql = "select flowkey from patentcase where flowkey like '" + year + "%' order by flowkey desc";
//	    			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
//	    			int max = 1;
//	    			if(keys != null && !keys.isEmpty()) {
//	    				String key = keys.get(0);
//	    				max = Integer.parseInt( key.substring(2, 6) ) + 1;
//	    			}
//	    			this.FlowKey.setValue(year + String.format("%04d", max) + this.getPatentOffice());
//	    		}
//	    		else {
//	    			this.setErrorMessage("請輸入申請國家!");
//	    			return true;
//	    		}
//	    	}
//	    	else {
////	    		String flowKey = FlowEngin.getPkeyNo(this.getClient()+"-P", 3, false, "") + this.getPatentOffice();
//	    		String oldFlowKey = this.getFlowKey();
//	    		String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
//	    		String sql = "select count(1) as Count from PatentCase where flowkey like '" + oldFlowKey + "%'";
//	    		
//	    		int count = Integer.parseInt(this.getDbUtil().getFieldValue(sql, "Count"));
//	    		
//	    		sql = "select flowkey from patentcase where flowkey like '" + year +"%' order by flowkey desc";
//    			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
//    			int max = 1;
//    			if(keys != null && !keys.isEmpty()) {
//    				String key = keys.get(0);
//    				
//    				max = Integer.parseInt( key.substring(2, 6) ) + 1;
//    			}
//    			String flowkey = year + String.format("%04d", max) + this.getPatentOffice();
//	
//	    		if(count > 0) {
//	    			this.setErrorMessage("案件編號 " + this.getFlowKey() + "已經被使用，已將案件編號修改為" + flowkey);
//	    			this.setFlowKey(flowkey);
//	    			return true;
//	    		}
//	    	}
//    	}
    	
        if(super.checkInsertError()){
            return true;
        } else {
        	if(Util.isEmpty(this.getCaseStartDate()) && 
            		this.getDbActionMode().equals(Cnstnts.INSERT)) {
            	this.setCaseStartDate(Util.getDate());
            }
    		
//        	if(Cnstnts.INSERT.equals(this.getDbActionMode()) 
//        			&& Util.isEmpty(this.getTitle())){
//        		this.Title.setValue(this.getOriginalTitle());
//        	}
        	
        	PatentCase orginalCase = new PatentCase(this.getFlowKey());
        	if(Cnstnts.INSERT.equals(this.getDbActionMode()) 
        			&& this.getCreateTime().trim().length()==0){
        		this.setCreateTime(Util.getDateTime());
        		this.setCreator(this.getUserInfo().getAttribute("user_name"));
        	}
        	if(Cnstnts.UPDATE.equals(this.getDbActionMode()) 
        			|| Cnstnts.INSERT.equals(this.getDbActionMode())){
        		this.setUpdateTime(Util.getDateTime());
        		this.setUpdater(this.getUserInfo().getAttribute("user_name"));
        	}
        	
        	if(this.Client.getValue().trim().length()>0){
            	Client cli = new Client(this.Client.getValue());
            	this.setClientName(cli.getCompanyName());
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

    
    public String getSubmitBtn() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (Cnstnts.TRUE_FLAG.equals(this.getModeLockFlag())) {
			return Cnstnts.EMPTY_STRING;
		}
		if(this.getDbActionMode().equals(Cnstnts.PRINT) && this.getPageActionMode().equals(Cnstnts.MAINTAIN)){
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

		String btn = super.getSubmitBtn();
		if(Util.isEmpty(btn) && Util.compareTo(this.getPageActionMode(), Cnstnts.MAINTAIN)) {
			/*
	         * 1.增加一列表式tab "權限"，專利商標法務案件的權限就來讀這個tab，如示意圖，此tab僅預設成員可進行編輯，
	         * 預設成員為admin以及G01。增加來源成員為員工，選了之後可選擇可否檢視、編輯（亦可列印）、
	         * 可否看到此tab，預設成員所有選項皆打勾，且不可被編輯刪除。
	         */
	    	CasePrivilege cp = new CasePrivilege(this.getUserInfo().getAttribute("emp_id"), this.getUserInfo().getAttribute("dept_id"), this.getCaseKind(), this.getFlowKey());;
	        if(Util.isEmpty(cp.getFlowKey())) {
	        	//表示沒有設定案件權限，就要判斷是否為admin g01
	        	if(Util.isAdminOrG01(this.getUserInfo()) &&
	        			!this.getDbActionMode().equals(Cnstnts.QUERY)) {
	        		btn = Html.getSubmitBtn(this.getUserInfo(), this.getDbActionMode());
	        	}
	        	else {
	        		
	        	}
	        }
	        else {
	        	//要判斷是否有目前dbactionmode的權限
	        	if(cp.hasPrivilege(this.getDbActionMode())) {
	        		btn = Html.getSubmitBtn(this.getUserInfo(), this.getDbActionMode());
		        }
	        }
		}
		return rtnString+btn;
	}
    
    
    
    public String printDetailTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if(this.getTabText().equals("PatentDocument")) {
            rtnString = new PatentDocument().getSearchReasult(this
                        .getUserInfo(), this.getFlowKey());
        }
        if(this.getTabText().equals("PatentApplicant")) {
            rtnString = new PatentApplicant().getSearchReasult(this
                        .getUserInfo(), this.getFlowKey());
        }
        if(this.getTabText().equals("PatentInventor")) {
            rtnString = new PatentInventor().getSearchReasult(this
                        .getUserInfo(), this.getFlowKey());
        }
        if(this.getTabText().equals("PatentAttorney")) {
            rtnString = new PatentAttorney().getSearchReasult(this
                        .getUserInfo(), this.getFlowKey());
        }
        if(this.getTabText().equals("PatentPriority")) {
            rtnString = new PatentPriority().getSearchReasult(this
                        .getUserInfo(), this.getFlowKey());
        }
        if(this.getTabText().equals("PatentToDos")) {
            rtnString = new PatentToDos().getSearchReasult(this.getUserInfo(), this
                        .getFlowKey(), "N");
        }
        if(this.getTabText().equals("PatentSecondPage")) {

            rtnString +="<table width='95%'><tr><td>"+
						"<div id='tabs2'><ul>"+
						"<li><a href='#tabs-8'>"+this.getUserInfo().getMsg("jsp.PatentCase.BasicData")+"</a></li>" +
						"<li><a href='#tabs-9'>"+this.getUserInfo().getMsg("jsp.PatentCase.OtherData")+"</a></li>" +
						"<li><a href='#tabs-10'>"+this.getUserInfo().getMsg("jsp.PatentSponsor.title")+"</a></li>";
			rtnString += "</ul>";
			
            // 詳細資料tab
			/**** tabs-8 ****/
        	rtnString +="<div id='tabs-8'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateBasicDataDiv' name='updateBasicDataDiv'></div>";
            rtnString +="<div id='BasicDataDiv' name='BasicDataDiv'>";

            rtnString += printBaseDataHtml();
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-8 end ****/


            /**** tabs-9 ****/
        	rtnString +="<div id='tabs-9'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateOtherDataDiv' name='updateOtherDataDiv'></div>";
            rtnString +="<div id='OtherDataDiv' name='OtherDataDiv'>";

            rtnString += printOtherDataHtml();

            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-9 end ****/


            /**** tabs-10 ****/
        	rtnString +="<div id='tabs-10'>";
        	rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updatePatentSponsorDiv' name='updatePatentSponsorDiv'></div>";
            rtnString +="<div id='PatentSponsorDiv' name='PatentSponsorDiv'>";
            rtnString += printSponsorHtml();
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-10 end ****/
            
            rtnString += "</td></tr></table>";
        }
        else {
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
        	rtnString += this.WipoNo.printHiddenTag();
        	rtnString += this.Entity.printHiddenTag();
             
            rtnString += this.GiveupCode.printHiddenTag();
         	rtnString += this.OutsourceDate.printHiddenTag();
        	
        	rtnString += this.Creator.printHiddenTag();
        	rtnString += this.CreateTime.printHiddenTag();
        	rtnString += this.CaseStartDate.printHiddenTag();
        }
        return rtnString;
    }
    
    public String printSponsorHtml() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;

		rtnString += "<table width='100%' " + this.getTableBgcolor() + ">";

		this.WrittenFinishedDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
		
		List<SelectItem> items = new Employee().getList();
		this.WrittenMan.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
		this.WrittenMan.setSelectList(items);
		this.WrittenMan.setAnotherField(this.WrittenFinishedDate);
		this.WrittenMan.setColspan(1);
		rtnString += this.printHtml(this.WrittenMan);

		this.MappingFinishedDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

		this.MappingMan.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
		this.MappingMan.setSelectList(items);
		this.MappingMan.setAnotherField(this.MappingFinishedDate);
		this.MappingMan.setColspan(1);
		rtnString += this.printHtml(this.MappingMan);

		this.TranslateFinishedDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

		this.TranslateMan.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
		this.TranslateMan.setSelectList(items);
		this.TranslateMan.setAnotherField(this.TranslateFinishedDate);
		this.TranslateMan.setColspan(1);
		rtnString += this.printHtml(this.TranslateMan);

		this.RejectionFinishedDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

		this.RejectionMan.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
		this.RejectionMan.setSelectList(items);
		this.RejectionMan.setAnotherField(this.RejectionFinishedDate);
		this.RejectionMan.setColspan(1);
		rtnString += this.printHtml(this.RejectionMan);

		this.ReplyFinishedDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

		this.ReplyMan.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
		this.ReplyMan.setSelectList(items);
		this.ReplyMan.setAnotherField(this.ReplyFinishedDate);
		this.ReplyMan.setColspan(1);
		rtnString += this.printHtml(this.ReplyMan);
		rtnString += "</table>";

		return rtnString;
    }
    
    public String printOtherDataHtml() throws Exception {
    	String rtnString = "";
    	
    	// 其他資料tab
        rtnString += "<table width='100%' " + this.getTableBgcolor() + ">";

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
        
        this.DependentClaim.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.DependentClaim.setSize(5);
        
        this.IndependentClaim.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.IndependentClaim.setSize(5);
        this.IndependentClaim.setAnotherField(this.DependentClaim);
        this.IndependentClaim.setColspan(1);
        rtnString += this.printHtml(this.IndependentClaim);
        
        
        this.Drawing.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Drawing.setSize(5);
        
        this.TotalPage.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.TotalPage.setSize(5);
        this.TotalPage.setAnotherField(this.Drawing);
        this.TotalPage.setColspan(1);
        rtnString += this.printHtml(this.TotalPage);
        
        this.Uspc.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.Uspc.setRows(2);
        this.Uspc.setCols(35);
        
        this.Ipc.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.Ipc.setRows(2);
        this.Ipc.setCols(35);
        this.Ipc.setAnotherField(this.Uspc);
        this.Ipc.setColspan(1);
        rtnString += this.printHtml(this.Ipc);
        
        this.Locarno.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.Locarno.setRows(2);
        this.Locarno.setCols(35);
        
        this.Fi.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.Fi.setRows(2);
        this.Fi.setCols(35);
        this.Fi.setAnotherField(this.Locarno);
        this.Fi.setColspan(1);
        rtnString += this.printHtml(this.Fi);
        
        this.Gattezz.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        
        this.TechReportApply.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        this.TechReportApply.setAnotherField(this.Gattezz);
        this.TechReportApply.setColspan(1);
        rtnString += this.printHtml(this.TechReportApply);
        
        if(Cnstnts.UPDATE.equals(this.getDbActionMode())){
			if(!Util.isEmpty(this.getFlowKey())) {
				this.IdsCaseNo.setCanEdit(true);
				this.PriorityCaseNo.setCanEdit(true);
			}
        }
        else {
        	this.IdsCaseNo.setCanEdit(false);
        	this.PriorityCaseNo.setCanEdit(false);
        }
        this.PriorityCaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Priority.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        this.Priority.setAfterText(Html.getAlias(this.PriorityCaseNo, this.getUserInfo()) + Html.printTag(this.PriorityCaseNo, this.getUserInfo()));
        
        this.IdsCaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Ids.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        this.Ids.setAnotherField(this.Priority);
        this.Ids.setColspan(1);
        this.Ids.setAfterText(Html.getAlias(this.IdsCaseNo, this.getUserInfo()) + Html.printTag(this.IdsCaseNo, this.getUserInfo()));
        rtnString += this.printHtml(this.Ids);
        
        this.OtherCaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.OtherCaseNo.setColspan(3);
        rtnString += this.printHtml(this.OtherCaseNo);
        
//        this.PctAppNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        
//        this.PctAppDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
//        this.PctAppDate.setAnotherField(this.PctAppNo);
//        this.PctAppDate.setColspan(1);
//        rtnString += this.printHtml(this.PctAppDate);
        
//        this.WipoNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        
//        this.PctPublishDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
//        this.PctPublishDate.setAnotherField(this.WipoNo);
//        this.PctPublishDate.setColspan(1);
//        rtnString += this.printHtml(this.PctPublishDate);
        
        this.NationalPhaseDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        rtnString += this.printHtml(this.NationalPhaseDate);

        this.ApplyTransTo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.ApplyTransTo.setSize(30);
        
        this.ApplyTransDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.ApplyTransDate.setAnotherField(this.ApplyTransTo);
        this.ApplyTransDate.setColspan(1);
        rtnString += this.printHtml(this.ApplyTransDate);
        
        this.RightTransTo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.RightTransTo.setSize(30);
        
        this.RightTransDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.RightTransDate.setAnotherField(this.RightTransTo);
        this.RightTransDate.setColspan(1);
        rtnString += this.printHtml(this.RightTransDate);
        
        rtnString += "</table>";
        
        return rtnString;
    }
    
    public String printBaseDataHtml() throws Exception {
    	String rtnString = "";
    	
    	Category category = new Category();
    	
    	rtnString += "<table width='100%' " + this.getTableBgcolor() + ">";

    	boolean Readonly = false;

        this.InternalNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        
        if(Util.isEmpty(this.getCaseStartDate()) && 
        		this.getDbActionMode().equals(Cnstnts.INSERT)) {
        	this.setCaseStartDate(Util.getDate());
        }
    	this.CaseStartDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.CaseStartDate.setAnotherField(this.InternalNo);
        this.CaseStartDate.setColspan(1);
        rtnString += this.printHtml(this.CaseStartDate);
        
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
        
        this.ApplyNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.ApplyNo.setOnChange("checkNumber(this, 8)");
        
        this.ApplyDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.ApplyDate.setAnotherField(this.ApplyNo);
        this.ApplyDate.setColspan(1);
        this.ApplyDate.setBgcolor(" bgcolor='#FFCCCC' ");
        this.ApplyDate.setOnChange("changeRightDate()");
        this.ApplyDate.setOpenCalendarTextOnChange("changeRightDate()");
        rtnString += this.printHtml(this.ApplyDate);

        this.IdeaId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        
        this.DeliveryDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.DeliveryDate.setColspan(1);
        this.DeliveryDate.setAnotherField(this.IdeaId);
        if(this.canEdit()){
        	this.DeliveryDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SameAsApplyDate"));
        	this.DeliveryDate.setButtonClick("document.input.deliveryDate.value=document.input.applyDate.value;");
        }
        rtnString += this.printHtml(this.DeliveryDate);
        
        this.ExamineDueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        
        //提實審日旁邊增加”同申請日”按鈕、專利權起始日旁邊增加”同公告日”按鈕、專利權終止日預設為申請日加”(發明)20 年、(新型)10 年、(設計)12 年”(但可手動改)
        this.ExamineDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.ExamineDate.setAnotherField(this.ExamineDueDate);
        this.ExamineDate.setColspan(1);
        if(this.canEdit()){
        	this.ExamineDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SameAsApplyDate"));
        	this.ExamineDate.setButtonClick("document.input.examineDate.value=document.input.applyDate.value;");
        }
        rtnString += this.printHtml(this.ExamineDate);
        
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
        
        this.Entity.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        this.Entity.setSelectList(category.getChildList("Entity"));
        
      //提實審日旁邊增加”同申請日”按鈕、專利權起始日旁邊增加”同公告日”按鈕、專利權終止日預設為申請日加”(發明)20 年、(新型)10 年、(設計)12 年”(但可手動改)
        this.RightBeginDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.RightBeginDate.setAnotherField(this.Entity);
        this.RightBeginDate.setColspan(1);
        if(this.canEdit()){
        	this.RightBeginDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SameAsIssueDate"));
        	this.RightBeginDate.setButtonClick("document.input.rightBeginDate.value=document.input.issueDate.value;");
        }
        rtnString += this.printHtml(this.RightBeginDate);
        
        /*
	        此欄位選項會根據此案件的client欄位資料來篩選Applicant table中資料client欄位資料
	        等於此案件client欄位資料的Applicant資料，而顯示出此Applicant的Names
         */
        String sql = "select FlowKey, Names from applicant where Client = '" + this.getClient() + "' and ShowInClient ='Y' and ApplicantKind like '%CLK01;%' ";
        this.ClientContect.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        this.ClientContect.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("Names", ""), false));
                        
        this.OutsourceDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.OutsourceDate.setAnotherField(this.ClientContect);
        this.OutsourceDate.setColspan(1);
        rtnString += this.printHtml(this.OutsourceDate);
        
        this.Attorney.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        this.Attorney.setSelectList(new Attorney().getList());
        this.Attorney.setSize(30);
        
        this.AttorneyNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.AttorneyNum.setAnotherField(Attorney);
        this.AttorneyNum.setColspan(1);
        rtnString += this.printHtml(this.AttorneyNum);
        
        this.FeeSchedule.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.FeeSchedule.setSize(2);

        this.FeeScheduleDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.FeeScheduleDate.setAnotherField(this.FeeSchedule);
        this.FeeScheduleDate.setColspan(1);
        rtnString += this.printHtml(this.FeeScheduleDate);
        
        this.AutoPay.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        
        this.PaymentConfirming.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        this.PaymentConfirming.setAnotherField(this.AutoPay);
        this.PaymentConfirming.setColspan(1);
        rtnString += this.printHtml(this.PaymentConfirming);        
        
        this.GiveupCode.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.GiveupCode.setSelectList(category.getChildList(this.GiveupCode));
        
        this.RightEndDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.RightEndDate.setAnotherField(this.GiveupCode);
        this.RightEndDate.setColspan(1);
        rtnString += this.printHtml(this.RightEndDate);
        

        this.CloseDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.CloseDate.setColspan(3);
        rtnString += this.printHtml(this.CloseDate);
        
        
        
        this.SpecialRequest.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.SpecialRequest.setColspan(3);
        this.SpecialRequest.setCols(60);
        this.SpecialRequest.setRows(3);
        this.SpecialRequest.setLength(500);
        rtnString += this.printHtml(this.SpecialRequest);
        

        
        this.Remark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.Remark.setColspan(3);
        this.Remark.setCols(60);
        this.Remark.setRows(3);
        rtnString += this.printHtml(this.Remark);
        
        this.Updater.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Updater.setReadonly(true);
        
        this.UpdateTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.UpdateTime.setReadonly(true);
        this.UpdateTime.setAnotherField(this.Updater);
        this.UpdateTime.setColspan(1);
        rtnString += this.printHtml(this.UpdateTime);
        
        this.Creator.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Creator.setReadonly(true);

        this.CreateTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.CreateTime.setReadonly(true);
        this.CreateTime.setAnotherField(this.Creator);
        this.CreateTime.setColspan(1);
        rtnString += this.printHtml(this.CreateTime);
        
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

        rtnString += "</table>";
        
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
							/*&& this.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))*/) {
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
					this.setSearchCond();
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
					this.setSearchCond();
					this.doOtherUpdateProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.update"));
					//新增“暫存”的按鈕，當點「暫存」按鈕後仍然保持在編輯模式，而頁面仍停留在按按鈕前的頁面。
					if(!Util.isEmpty(this.getTmpInsertFlag()) && this.getTmpInsertFlag().equalsIgnoreCase("true")) {
//						this.setDbActionMode(Cnstnts.UPDATE);
//						this.setPageActionMode(Cnstnts.MAINTAIN);
						this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=maintain"+
									"&_dbActionMode=update&_getDataFlag=true&_flowKey="+this.getFlowKey() );
					}//新增“編輯完成”按鈕，當點“編輯完成”按鈕後切換回檢視模式，但頁面仍停留在按按鈕前的頁面。
					else if(!Util.isEmpty(this.getEditCompleteFlag()) && this.getEditCompleteFlag().equalsIgnoreCase("true")) {
//						this.setDbActionMode(Cnstnts.QUERY);
//						this.setPageActionMode(Cnstnts.MAINTAIN);
						this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=maintain"+
									"&_dbActionMode=query&_getDataFlag=true&_flowKey="+this.getFlowKey() );
					}
//					this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=search"+
//																"&doSearchFlag=true");
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
		sqlList.add("delete from casePrivilege where CaseKey='"+this.getFlowKey()+"'");
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
    
    public boolean insert() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.FlowKey.setValue(this.FlowKey.getValue().trim());
		this.setDbFields();
		
		//複製master資料（基本資料tab除外）
		
		//sqlList.add(this.getDbUtil().getInsertSQL(this.getTableName(), this.DbFields));
		if(Util.compareTo(this.getInternalNoCheck(), "Y")) {
			String sql = "select InternalNo from patentcase where flowkey='" + this.getFromCase() + "'";
			String InternalNo = this.getDbUtil().getFieldValue(sql, "InternalNo");
			this.setInternalNo(InternalNo);
		}
		super.insert();
		
		//20110819於既有案件中新增功能可以複製該筆資料的“發明人”、“申請人”、“代理人”、“優先權”資料
		if(Util.compareTo(this.getApplicantCopyCheck(), "Y")) {
			String sql = "select flowkey from PatentApplicant where parentid='" + this.getFromCase() + "'";
			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
			for(String key : keys) {
				PatentApplicant clazz = new PatentApplicant(key);
				clazz.setFlowKey(FlowEngin.getPkeyNo(this.getFlowKey(), 3, false, "."));
				clazz.setParentId(this.getFlowKey());
				
				sqlList.add(this.getDbUtil().getInsertSQL("PatentApplicant", clazz.getDbFields()));
			}
		}
		if(Util.compareTo(this.getAttorneyCopyCheck(), "Y")) {
			String sql = "select flowkey from PatentAttorney where parentid='" + this.getFromCase() + "'";
			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
			for(String key : keys) {
				PatentAttorney clazz = new PatentAttorney(key);
				clazz.setFlowKey(FlowEngin.getPkeyNo(this.getFlowKey(), 3, false, "."));
				clazz.setParentId(this.getFlowKey());
				
				sqlList.add(this.getDbUtil().getInsertSQL("PatentAttorney", clazz.getDbFields()));
			}
		}
		if(Util.compareTo(this.getInventorCopyCheck(), "Y")) {
			String sql = "select flowkey from PatentInventor where parentid='" + this.getFromCase() + "'";
			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
			for(String key : keys) {
				PatentInventor clazz = new PatentInventor(key);
				clazz.setFlowKey(FlowEngin.getPkeyNo(this.getFlowKey(), 3, false, "."));
				clazz.setParentId(this.getFlowKey());
				
				sqlList.add(this.getDbUtil().getInsertSQL("PatentInventor", clazz.getDbFields()));
			}
		}
		if(Util.compareTo(this.getPriorityCopyCheck(), "Y")) {
			String sql = "select flowkey from PatentPriority where parentid='" + this.getFromCase() + "'";
			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
			for(String key : keys) {
				PatentPriority clazz = new PatentPriority(key);
				clazz.setFlowKey(FlowEngin.getPkeyNo(this.getFlowKey(), 3, false, "."));
				clazz.setParentId(this.getFlowKey());
				
				sqlList.add(this.getDbUtil().getInsertSQL("PatentPriority", clazz.getDbFields()));
			}
		}
		
		//1. 負責程序人員CaseAD 若儲存後，自動將該人員也寫入案件權限列表（權限勾選：檢視＋編輯＋列印＋Tab ）
//		if(!Util.isEmpty(this.getCaseAD())) {
			createPrivilege("111001", this.getCaseAD(), this.getCaseKind() + "C");
//		}
		
//		if(!Util.isEmpty(this.getInCharge())) {
			createPrivilege("100000", this.getInCharge(), this.getCaseKind() + "S");
//		}
		//承辦人員 改為 業務主管，該案件資料新增後若該欄位編輯儲存，將該人員加入案件清單權限為V 檢視，當該欄位修改儲存將該案件權限清單該人員舊的換掉，替換為新儲存的。
//		if(!Util.isEmpty(this.getCaseAssignedTo())) {
			createPrivilege("100000", this.getCaseAssignedTo(), this.getCaseKind() + "A");
//		}
		
		
		if(sqlList != null && !sqlList.isEmpty())
			return this.getDbUtil().executeUpdate(sqlList);
		else
			return true;
	}
	@SuppressWarnings("unchecked")
	public boolean update() throws Exception {
		//每當案件儲存的時候，就去更新所有的所屬todos的serviceprojectcode
		if(super.update()) {
			//四類案件儲存時加SQL將下列欄位更新到該案件內所有關連訂單的對應欄位：案件編號、案件種類、案件類別、國家、案件名稱
			this.getDbUtil().executeUpdate("update salesorder set CaseNo ='" + this.getCaseNo() + "', " +
					"PatentType='" + this.getPatentType() + "', PatentOffice='" + this.getPatentOffice() + "', " +
					"OriginalTitle='" + this.getTitle() + "/" + this.getEnglishTitle() + "', CaseKind='STC01' " +
					"where RelatedCaseNo ='" + this.getFlowKey() + "'");
			
			//1. 負責程序人員CaseAD 若儲存後，自動將該人員也寫入案件權限列表（權限勾選：檢視＋編輯＋列印＋Tab ）
//			if(!Util.isEmpty(this.getCaseAD())) {
				createPrivilege("111001", this.getCaseAD(), this.getCaseKind() + "C");
//			}
			
//			if(!Util.isEmpty(this.getInCharge())) {
				createPrivilege("100000", this.getInCharge(), this.getCaseKind() + "S");
//			}
			
			//承辦人員 改為 業務主管，該案件資料新增後若該欄位編輯儲存，將該人員加入案件清單權限為V 檢視，當該欄位修改儲存將該案件權限清單該人員舊的換掉，替換為新儲存的。
//			if(!Util.isEmpty(this.getCaseAssignedTo())) {
				createPrivilege("100000", this.getCaseAssignedTo(), this.getCaseKind() + "A");
//			}
			
			return updateToDosValue(this);
		}
		
		return false;
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
    							"cl.CompanyName, cl.CompanyName as ClientName "+
    					 "from PatentCase p "+
    					 "inner join Client cl on p.Client=cl.FlowKey "+
    					 "inner join Category c on p.PatentOffice=c.FlowKey "+
    					 "inner join Category cc on p.PatentType=cc.FlowKey "+
    					 "where p.FlowKey='"+this.getFlowKey()+"'";
    		HashMap<String, String> fieldMap = this.getAttributesMap();
    		fieldMap.put("PatentOfficeName","");
    		fieldMap.put("PatentOffice","");
    		fieldMap.put("PatentTypeName","");
    		fieldMap.put("PatentType","");
    		fieldMap.put("CompanyName","");
    		fieldMap.put("ClientName","");
    		Map data = this.getDocMap(SQL,fieldMap);
    		
	  		  if(data.get("PatentOffice") != null && !Util.compareTo(data.get("PatentOffice").toString(), "TW")) {
	  			  String sql = "select names from category where flowkey = '" + data.get("PatentType")  + "-" + data.get("PatentOffice") + "'";
	  			  String names = this.getDbUtil().getFieldValue(sql, "names");
	  			  fieldMap.put("PatentTypeName",names);
	  		  }
	  		  
    		/*
    		Map data = this.getBasicDocMap();
    		for(Iterator itr=data.keySet().iterator();itr.hasNext();){
    			String key = itr.next().toString();
    			//System.out.println(key+" : "+data.get(key));
    		}
    		*/
    		
    		Properties categoryPrpt = new Category().getNamesPrpts();
    		
    		char newLine = Cnstnts.NEW_LINE;
    		String detailData = Cnstnts.EMPTY_STRING;
    		String companyReqData = Cnstnts.EMPTY_STRING;
    		
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
            	
            	if(companyReqData.length() > 0){
        			companyReqData += ";";
        		}
        		companyReqData += CompanyReq; 
            	
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

    		data.put("${ApplicantsCompanyReqData}", companyReqData);
    		
    		
    		String attorneyNames = Cnstnts.EMPTY_STRING;
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
            	if(attorneyNames.length() > 0){
            		attorneyNames += ";";
            	}
            	attorneyNames += LastName + FirstName;
            	
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
        	data.put("${AttorneyNames}", attorneyNames);
    		data.put("${AttorneySize}", attorneydataLst.size()+Cnstnts.EMPTY_STRING);
    		data.put("${AttorneyData}", detailData);
    		
    		detailData = Cnstnts.EMPTY_STRING;
    		SQL = "select i.*,p.InventorOrder from "+
    			  "(select Inventor,InventorOrder from PatentInventor where ParentId='"+this.getFlowKey()+"') p "+
    			  "inner join Applicant i on p.Inventor=i.FlowKey "+
    			  "order by InventorOrder";
//    		//System.out.println(SQL);
    		applicant = new Applicant();
    		applicant.setDbFields();
    		List<List<Field>> inventordataLst = applicant.getDbUtil().getFieldsList(SQL, applicant.getDbFields());
    		i=1;
    		for(Iterator itr=inventordataLst.iterator();itr.hasNext();i++){ 
    			String Nationality = Cnstnts.EMPTY_STRING;
    			String IdNo = Cnstnts.EMPTY_STRING;
//    			String LastName = Cnstnts.EMPTY_STRING;
//    			String EnglishLastName = Cnstnts.EMPTY_STRING;
    			String Names = Cnstnts.EMPTY_STRING;
    			String EnglishNames = Cnstnts.EMPTY_STRING;
    			
    			List<Field> detailFieldsLst = (List<Field>)itr.next();
    			for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
    				Field detailField = (Field)fieldsItr.next();
    				if(detailField.getName().equals("Nationality")){
    					Nationality = detailField.getValue();
    				}
    				if(detailField.getName().equals("IdNo")){
    					IdNo = detailField.getValue();
    				}
//    				if(detailField.getName().equals("LastName")){
//    					LastName = detailField.getValue();
//    				}
    				if(detailField.getName().equals("EnglishNames")){
    					EnglishNames = detailField.getValue();
    				}
    				if(detailField.getName().equals("Names")){
    					Names = detailField.getValue();
    				}
//    				if(detailField.getName().equals("EnglishFirstName")){
//    					EnglishFirstName = detailField.getValue();
//    				}
    			}
    			detailData += newLine +"(" + this.getUserInfo().getMsg("jsp.Applicant.printDoc.1") +
      					  	i + this.getUserInfo().getMsg("jsp.PatentInventor.title") + ")";
      	
    			detailData += newLine + "ID : "+IdNo;
      	
    			detailData += "      " + this.getUserInfo().getMsg("jsp.Inventors.Nationality")+ " : " +
    							categoryPrpt.getProperty(Nationality)+Nationality;
      	
    			detailData += newLine + this.getUserInfo().getMsg("jsp.PatentInventor.Names") + " :  ";
    			
//    			detailData += this.getUserInfo().getMsg("jsp.Inventors.LastName")+" : "+LastName;
    			
    			detailData += Names;
    			
    			detailData += newLine +"            "+EnglishNames;
      	
    		}
    		data.put("${InventorSize}", inventordataLst.size()+Cnstnts.EMPTY_STRING);
    		data.put("${InventorsData}", detailData);
    		
    		
    		String attorneyAddress = Cnstnts.EMPTY_STRING;
    		String attorneyContact = Cnstnts.EMPTY_STRING;
    		
    		/*
    		 * 
    		 * 
    		 */
    		Properties categoryProp = new Category().getNamesPrpts();
    		Properties employeeProp = new Employee().getNamesPrpts();
    		Properties attorneyProp = new Attorney().getNamesPrpts();
    		Properties applicantProp = new Applicant().getNamesPrpts();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
    		SQL = "select p.* from PatentCase p where p.FlowKey='"+this.getFlowKey()+"'";
    		List<Field> fields = this.getDbFields();
    		this.getDbUtil().getAttribute(SQL, fields);
    		for(Field field : fields) {
    			String name = field.getName();
    			String value = field.getValue();
    			Calendar calendar = Calendar.getInstance();
        		data.put("${today}", (calendar.get(Calendar.YEAR) - 1911) + "年" +
        				(calendar.get(Calendar.MONTH) + 1) + "月" +
        				calendar.get(Calendar.DAY_OF_MONTH) + "日");
    			
        		String inChargeTitle ="";
        		SQL = "select Title from Employee where FlowKey = '"+this.getInCharge()+"'";
        		inChargeTitle = this.getDbUtil().getFieldValue(SQL,"Title");
        		data.put("${InChargeTitle}",categoryPrpt.getProperty(inChargeTitle));
        		
    			if(name.endsWith("Date") || name.endsWith("DateTo") ||
    					name.equalsIgnoreCase("DeadLine")) {

//    				try {
//    					value = sdf2.format(sdf.parse(value));
//    				}
//    				catch(Exception e) {}
    				//將日期轉換成年月日
    				data = Util.putDateToMap(name, value, data);
    			}
    			else if(name.equalsIgnoreCase("PatentOffice") ||
    					name.equalsIgnoreCase("Status") ||
    					name.equalsIgnoreCase("PatentCaseType") ||
    					name.equalsIgnoreCase("Entity")) {
    				value = categoryProp.getProperty(value);
    			}
    			else if(name.equalsIgnoreCase("PatentType")) {
    				value = Util.getPatentTypeNameByOffice(value, this.getPatentOffice());
    			}
    			else if(name.equalsIgnoreCase("WrittenMan") ||
    					name.equalsIgnoreCase("MappingMan") ||
    					name.equalsIgnoreCase("TranslateMan") ||
    					name.equalsIgnoreCase("RejectionMan") ||
    					name.equalsIgnoreCase("InCharge") ||
    					name.equalsIgnoreCase("ReplyMan") ||
    					name.equalsIgnoreCase("CaseAssignedTo") ||
    					name.equalsIgnoreCase("CaseAD")) {
    				value = employeeProp.getProperty(value);
    			}
    			else if(name.equalsIgnoreCase("Attorney")) {
    				if(!Util.isEmpty(value)){
    					Attorney attorneyInfo = new Attorney(value);
    					attorneyAddress = attorneyInfo.getAddress1();
    					attorneyContact = attorneyInfo.getContact();
    				}
    				
    				value = attorneyProp.getProperty(value);
    			}
    			else if(name.equalsIgnoreCase("ClientContect")) {
    				value = applicantProp.getProperty(value);
    			}
    			else if(name.equalsIgnoreCase("Client")) {
    				data.put("${ClientName}", new Client().getNamesPrpts().getProperty(value));
    			}

    			data.put("${" + name+ "}", value);
    		}
    		
    		data.put("${PatentAttorneyAddress}", attorneyAddress);
    		data.put("${PatentAttorneyContact}", attorneyContact);
    		
    		String patentinventor = "";
			SQL = "select p.InventorName from patentinventor p " +
					"where p.parentid ='" + this.getFlowKey() + "' " +
					"order by CAST(p.InventorOrder AS DECIMAL(10))";
			List<String> names = this.getDbUtil().getValueList(SQL, "InventorName");
			for(int j=0;j<names.size();j++) {
				String s = names.get(j);
				if(j==0) {
					patentinventor += s;
				}
				else {
					patentinventor += ";" + s;
				}
			}
			data.put("${PatentInventors"  + "}", patentinventor);
			
			String patentapplicant  = "";
			SQL = "select a.Names from patentapplicant  p left join applicant as a on a.FlowKey = p.ApplicantId " +
					"where p.parentid ='" + this.getFlowKey() + "' " +
					"order by CAST(p.ApplicantOrder AS DECIMAL(10))";
			names = this.getDbUtil().getValueList(SQL, "Names");
			for(int j=0;j<names.size();j++) {
				String s = names.get(j);
				if(j==0) {
					patentapplicant += s;
				}
				else {
					patentapplicant += ";" + s;
				}
			}
			data.put("${PatentApplicants}", patentapplicant);
			
			String patentApplicantIdNo  = Cnstnts.EMPTY_STRING;
			String patentApplicantAddress= Cnstnts.EMPTY_STRING;
			String patentApplicantAddress2= Cnstnts.EMPTY_STRING;
			String patentApplicantEnglishAddress= Cnstnts.EMPTY_STRING;
			String patentApplicantEnglishAddress2= Cnstnts.EMPTY_STRING;
			SQL = "select p.flowkey, a.IdNo, a.Address, a.Address2, a.EnglishAddress, a.EnglishAddress2 from patentapplicant p left join applicant as a on a.FlowKey = p.ApplicantId  " +
					"where p.parentid ='" + this.getFlowKey() + "'";
			List<Object[]> applicantValues = this.getDbUtil().getList(SQL, new String[]{"IdNo", "Address", "Address2", "EnglishAddress", "EnglishAddress2"});
			for(int k=0;k<applicantValues.size();k++) {
				Object[] s = applicantValues.get(k);
				if(k==0) {
					patentApplicantIdNo += s[1];
					patentApplicantAddress += s[2];
					patentApplicantAddress2 += s[3];
					patentApplicantEnglishAddress += s[4];
					patentApplicantEnglishAddress2 += s[5];
				}
				else {
					patentApplicantIdNo += ";" + s[1];
					patentApplicantAddress += ";" + s[2];
					patentApplicantAddress2 += ";" + s[3];
					patentApplicantEnglishAddress += ";" + s[4];
					patentApplicantEnglishAddress2 += ";" + s[5];
				}
			}
			data.put("${PatentApplicantsIdNo}", patentApplicantIdNo);
			data.put("${PatentApplicantsAddress}", patentApplicantAddress);
			data.put("${PatentApplicantsAddress2}", patentApplicantAddress2);
			data.put("${PatentApplicantsEnglishAddress}", patentApplicantEnglishAddress);
			data.put("${PatentApplicantsEnglishAddress2}", patentApplicantEnglishAddress2);
			
			String patentpriority  = "";
			SQL = "select p.flowkey, a.names, p.PriorityDate, p.ApplyNo from patentpriority  p left join category a on a.flowkey=p.Country  " +
					"where p.parentid ='" + this.getFlowKey() + "'";
			List<Object[]> values = this.getDbUtil().getList(SQL, new String[]{"names", "PriorityDate", "ApplyNo"});
			for(int j=0;j<values.size();j++) {
				Object[] s = values.get(j);
				if(j==0) {
					patentpriority += s[1] + "/" + s[2] + "/" + s[3];
				}
				else {
					patentpriority += newLine;
					patentpriority += s[1] + "/" + s[2] + "/" + s[3];
				}
			}
			data.put("${Patentprioritys"  + "}", patentpriority);
			
			if(!Util.isEmpty(this.getClient())) {
				Client client = new Client(this.getClient());
				client.setDbFields();
				
				data.putAll(client.getDocMap());
			}

    		for(Object key : data.keySet()) {
    			Object value = data.get(key);
    			if(value == null) {
    				data.put(key, "");
    			}
    		}
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

	public String getSwitchModeImg() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (Cnstnts.TRUE_FLAG.equals(this.getModeLockFlag())) {
			return rtnString;
		}
		if (this.getPageActionMode().equals(Cnstnts.MAINTAIN)) {
			rtnString = "<input type='button' style='cursor: hand' " + 
		   	   "value='"+ getUserInfo().getMsg("jsp.common.serchMode") +"' "+
		   	   "onClick='document.input.pageActionMode.value=\""+Cnstnts.SEARCH+"\";" + 
		   	   			"document.input.clearFlag2.value=\"true\";"+
		   	   			"document.input.clearFlag.value=\"true\";"+
		   	   			//"document.input.doSearchFlag.value=\"true\";" +
		   	   			"setValue()'/>";
		}

		if (this.getPageActionMode().equals(Cnstnts.SEARCH)) {
			Authority auth = this.getUserInfo().getAuthority(this.getProgramId());
		    if(auth==null) auth=new Authority();
		    if(auth.getAllowInsert().equals("1")) {
		    	rtnString = Html.getMaintainModeImg(this.getUserInfo());
		    }
		}

		return rtnString;
	}
    
    public void clearAttribute() {
		super.clearAttribute();
		this.setClientName(Cnstnts.EMPTY_STRING);
		this.setFeeScheduleDateTo(Cnstnts.EMPTY_STRING);
	}
    
    public void resetFieldData(String divName, String fieldName, String value) {
    	if(fieldName == null) {
    		return;
    	}

        if(fieldName.equalsIgnoreCase("FlowKey")) {
        	setFlowKey(value);
        }
        if (fieldName.equalsIgnoreCase("CreateDept")) {
        	if (divName.equals("cond1")) {
							setDataDept(value);
				setCreateDept(value);
				setApplicant(getFullSearchText3());
				setCreator(getFullSearchText3());
        	}
        	else if (divName.equals("cond2")) {
				setDataDept2(value);
				setCreateDept(value);
				setApplicant(getFullSearchText4());
				setCreator2(getFullSearchText4());
        	}
        }
        if(fieldName.equalsIgnoreCase("Title")) {
        	setTitle(value);
        }
        if(fieldName.equalsIgnoreCase("Status")) {
        	setStatus(value);
        }
        if(fieldName.equalsIgnoreCase("PatentOffice")) {
        	setPatentOffice(value);
        }
        if(fieldName.equalsIgnoreCase("PatentType")) {
        	setPatentType(value);
        }
        if(fieldName.equalsIgnoreCase("ApplyNo")) {
        	setApplyNo(value);
        }
        if(fieldName.equalsIgnoreCase("LicenseNo")) {
        	setLicenseNo(value);
        }
        if(fieldName.equalsIgnoreCase("InCharge")) {
        	setInCharge(value);
        }
        if(fieldName.equalsIgnoreCase("PatentCaseType")) {
        	setPatentCaseType(value);
        }
        if(fieldName.equalsIgnoreCase("Client")) {
        	setClient(value);
        }
        if(fieldName.equalsIgnoreCase("InternalNo")) {
        	setInternalNo(value);
        }
        if(fieldName.equalsIgnoreCase("Attorney")) {
        	setAttorney(value);
        }
        if(fieldName.equalsIgnoreCase("CaseAD")) {
        	setCaseAD(value);
        }
        if(fieldName.equalsIgnoreCase("AttorneyNum")) {
        	setAttorneyNum(value);
        }
        if(fieldName.equalsIgnoreCase("CaseAssignedTo")) {
        	setCaseAssignedTo(value);
        }
        if(fieldName.equalsIgnoreCase(this.Referrals.getName())) {
        	setReferrals(value);
        }
    }
    
    public String checkSelected(String condName, String optionName) {
        String result = "";
        if(condName.equals("cond1")) {
            if(getCond1().equals(optionName)) {
                result = "selected";
            }
        }
        else if(condName.equals("cond2")) {
            if(getCond2().equals(optionName)) {
                result = "selected";
            }
        }
        else if(condName.equals("cond11")) {
            if(getCond11().equals(optionName)) {
                result = "selected";
            }
        }
        return result;
    }
    
    
    public String genSearchCondList(String name) throws Exception {
    	String function = "1";

    	String htmlCode = "";
        if(name.equals("cond1")) {
        	htmlCode = "<select  id='" + name + "' name='" + name + "' onChange=\"changeDiv" + function + "(this, '" + name + "_div');\">" + Cnstnts.NEW_LINE;
        	
            if(getCond1() == null) {
                setCond1("");
            }
            
            htmlCode += 
            	"<option " + checkSelected(name, "CaseNo") + " value='CaseNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseNo") + "</option>" +Cnstnts.NEW_LINE +
            	"<option " + checkSelected(name, "ClientName") + " value='ClientName'>" + this.getUserInfo().getMsg("jsp.PatentCase.ClientName") + "</option>" +Cnstnts.NEW_LINE +
            	//"<option " + checkSelected(name, "CaseNo2") + " value='CaseNo2'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseNo2") + "</option>" +Cnstnts.NEW_LINE +
			    "<option " + checkSelected(name, "ApplyNo") + " value='ApplyNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.ApplyNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "LicenseNo") + " value='LicenseNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.LicenseNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "PctAppNo") + " value='PctAppNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.PctAppNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Title") + " value='Title'>" + this.getUserInfo().getMsg("jsp.PatentCase.Title") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "OriginalTitle") + " value='OriginalTitle'>" + this.getUserInfo().getMsg("jsp.PatentCase.OriginalTitle") + "</option>" +Cnstnts.NEW_LINE +
//	    		"<option " + checkSelected(name, "Client") + " value='Client'>" + this.getUserInfo().getMsg("jsp.PatentCase.Client") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "PatentOffice") + " value='PatentOffice'>" + this.getUserInfo().getMsg("jsp.PatentCase.PatentOffice") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "SerialMotherCase") + " value='SerialMotherCase'>" + this.getUserInfo().getMsg("jsp.PatentCase.SerialMotherCase") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "InternalNo") + " value='InternalNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.InternalNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "AttorneyNum") + " value='AttorneyNum'>" + this.getUserInfo().getMsg("jsp.PatentCase.AttorneyNum") + "</option>" +Cnstnts.NEW_LINE +
	    		//新增"申請人" 要去找的是專利案件裡面 申請人Table的資料 抓的欄位是"聯絡人姓名名稱"
	    		"<option " + checkSelected(name, "CaseApplicant") + " value='CaseApplicant'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseApplicant") + "</option>" +Cnstnts.NEW_LINE +
	    		//1.下拉選單新增「發明人」，搜尋發明人tab姓名列出結果，並可用空隔當做or 輸入多個條件
	    		"<option " + checkSelected(name, "CaseInventor") + " value='CaseInventor'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseInventor") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "PriorityNo") + " value='PriorityNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.PriorityNo") + "</option>" +Cnstnts.NEW_LINE +
	    		//"<option value=''>" + this.getUserInfo().getMsg("jsp.PatentCase.FullSearch") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "ClientContect") + " value='ClientContect'>" + this.getUserInfo().getMsg("jsp.PatentCase.ClientContect") + "</option>" +Cnstnts.NEW_LINE +
	    		"</select>";
        }
        else if(name.equals("cond11")) {
        	htmlCode = "<select  id='" + name + "' name='" + name + "' onChange=\"changeDiv11(this, '" + name + "_div');\">" + Cnstnts.NEW_LINE;
        	
            if(getCond11() == null) {
                setCond11("");
            }
            
            htmlCode += 
            	"<option " + checkSelected(name, "CaseNo") + " value='CaseNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseNo") + "</option>" +Cnstnts.NEW_LINE +
            	"<option " + checkSelected(name, "ClientName") + " value='ClientName'>" + this.getUserInfo().getMsg("jsp.PatentCase.ClientName") + "</option>" +Cnstnts.NEW_LINE +
            	//"<option " + checkSelected(name, "CaseNo2") + " value='CaseNo2'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseNo2") + "</option>" +Cnstnts.NEW_LINE +
			    "<option " + checkSelected(name, "ApplyNo") + " value='ApplyNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.ApplyNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "LicenseNo") + " value='LicenseNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.LicenseNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "PctAppNo") + " value='PctAppNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.PctAppNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Title") + " value='Title'>" + this.getUserInfo().getMsg("jsp.PatentCase.Title") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "OriginalTitle") + " value='OriginalTitle'>" + this.getUserInfo().getMsg("jsp.PatentCase.OriginalTitle") + "</option>" +Cnstnts.NEW_LINE +
//	    		"<option " + checkSelected(name, "Client") + " value='Client'>" + this.getUserInfo().getMsg("jsp.PatentCase.Client") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "PatentOffice") + " value='PatentOffice'>" + this.getUserInfo().getMsg("jsp.PatentCase.PatentOffice") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "SerialMotherCase") + " value='SerialMotherCase'>" + this.getUserInfo().getMsg("jsp.PatentCase.SerialMotherCase") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "InternalNo") + " value='InternalNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.InternalNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "AttorneyNum") + " value='AttorneyNum'>" + this.getUserInfo().getMsg("jsp.PatentCase.AttorneyNum") + "</option>" +Cnstnts.NEW_LINE +
	    		//新增"申請人" 要去找的是專利案件裡面 申請人Table的資料 抓的欄位是"聯絡人姓名名稱"
	    		"<option " + checkSelected(name, "CaseApplicant") + " value='CaseApplicant'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseApplicant") + "</option>" +Cnstnts.NEW_LINE +
	    		//1.下拉選單新增「發明人」，搜尋發明人tab姓名列出結果，並可用空隔當做or 輸入多個條件
	    		"<option " + checkSelected(name, "CaseInventor") + " value='CaseInventor'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseInventor") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "PriorityNo") + " value='PriorityNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.PriorityNo") + "</option>" +Cnstnts.NEW_LINE +
	    		//"<option value=''>" + this.getUserInfo().getMsg("jsp.PatentCase.FullSearch") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "ClientContect") + " value='ClientContect'>" + this.getUserInfo().getMsg("jsp.PatentCase.ClientContect") + "</option>" +Cnstnts.NEW_LINE +
	    		"</select>";
        }
        if(name.equals("cond2")) {
            if(getCond2() == null) {
                setCond2("");
            }
            function = "2";
            
        	htmlCode = "<select  id='" + name + "' name='" + name + "' onChange=\"changeDiv" + function + "(this, '" + name + "_div');setValue();\">" + Cnstnts.NEW_LINE;
            
            htmlCode += //"<option value=''>" + this.getUserInfo().getMsg("jsp.PatentCase.FullSearch") + "</option>" +Cnstnts.NEW_LINE +
	    		//"<option " + checkSelected(name, "PatentCaseType") + " value='PatentCaseType'>" + this.getUserInfo().getMsg("jsp.PatentCase.PatentCaseType") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "PatentType") + " value='PatentType'>" + this.getUserInfo().getMsg("jsp.PatentCase.PatentType") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Status") + " value='Status'>" + this.getUserInfo().getMsg("jsp.PatentCase.Status") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "CaseAD") + " value='CaseAD'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseAD") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "InCharge") + " value='InCharge'>" + this.getUserInfo().getMsg("jsp.PatentCase.InCharge") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Attorney") + " value='Attorney'>" + this.getUserInfo().getMsg("jsp.PatentCase.Attorney") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "CaseAssignedTo") + " value='CaseAssignedTo'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseAssignedTo") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Referrals") + " value='Referrals'>" + this.getUserInfo().getMsg("jsp.PatentCase.Referrals") + "</option>" + Cnstnts.NEW_LINE +
	    		"</select>";
        }
	    return htmlCode;
	}
    
    public String genSearchDateList() throws Exception {
        if(getCond3() == null) {
            setCond3("");
        }

        String htmlCode = "<select name='cond3' onChange=\"document.input.startDate.value='';document.input.endDate.value='';\">" + Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("")?"selected":"") + " value=''>" + this.getUserInfo().getMsg("jsp.account.select") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("CaseStartDate")?"selected":"") + " value='CaseStartDate'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseStartDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("ApplyDate")?"selected":"") + " value='ApplyDate'>" + this.getUserInfo().getMsg("jsp.PatentCase.ApplyDate") + "</option>" + Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("LicenseDate")?"selected":"") + " value='LicenseDate'>" + this.getUserInfo().getMsg("jsp.PatentCase.LicenseDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("ExamineDate")?"selected":"") + " value='ExamineDate'>" + this.getUserInfo().getMsg("jsp.PatentCase.ExamineDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("ExamineDueDate")?"selected":"") + " value='ExamineDueDate'>" + this.getUserInfo().getMsg("jsp.PatentCase.ExamineDueDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("RightBeginDate")?"selected":"") + " value='RightBeginDate'>" + this.getUserInfo().getMsg("jsp.PatentCase.RightBeginDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("RightEndDate")?"selected":"") + " value='RightEndDate'>" + this.getUserInfo().getMsg("jsp.PatentCase.RightEndDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("PriorityDeadLine")?"selected":"") + " value='PriorityDeadLine'>" + this.getUserInfo().getMsg("jsp.PatentCase.PriorityDeadLine") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("ContactDate")?"selected":"") + " value='ContactDate'>" + this.getUserInfo().getMsg("jsp.PatentCase.ContactDate") + "</option>" +Cnstnts.NEW_LINE +
                "</select>";
        
        return htmlCode;
    }
    
    public String genSqlCondList(String name) throws Exception {
    	String value = "";
    	if(name.equals("sqlCond1")) {
    		value = getSqlCond1();
    	}
    	if(name.equals("sqlCond11")) {
    		value = getSqlCond11();
    	}
    	else if(name.equals("sqlCond2")) {
    		value = getSqlCond2();
    	}
        String htmlCode = "<select name='" + name + "'>" + Cnstnts.NEW_LINE +
                "<option value='and' " + (value.equalsIgnoreCase("and")?"selected":"") + ">AND</option>" +Cnstnts.NEW_LINE +
                "<option value='or' " + (value.equalsIgnoreCase("or")?"selected":"") + ">OR</option>" + Cnstnts.NEW_LINE +
                "<option value='not' " + (value.equalsIgnoreCase("not")?"selected":"") + ">NOT</option>" +Cnstnts.NEW_LINE +
                "</select>";
        
        return htmlCode;
    }
    
    public String genSearchCondScript(String name) throws Exception {
    	if(getFullSearchText1() == null) {
    		setFullSearchText1("");
    	}
    	if(getFullSearchText11() == null) {
    		setFullSearchText11("");
    	}
    	if(getFullSearchText2() == null) {
    		setFullSearchText2("");
    	}
    	
    	String scriptCode = "<script language=\"javascript\">" + Cnstnts.NEW_LINE;
    	if(name.equalsIgnoreCase("fullSearchText1")) {
    		scriptCode += "function changeDiv1(selecter, div) {" + Cnstnts.NEW_LINE +
				"var id = selecter[selecter.selectedIndex].value;" + Cnstnts.NEW_LINE +
				"var htmlCode;" + Cnstnts.NEW_LINE;
    		
    		scriptCode += "if(id == '' || id == 'CaseNo' || id == 'CaseNo2' || id == 'ApplyNo' || id == 'LicenseNo' || id == 'Title' || id == 'OriginalTitle' " +
    				" || id == 'Client' || id == 'ClientName' || id == 'PatentOffice' || id == 'SerialMotherCase' || id == 'InternalNo'" +
    				" || id == 'Attorney'    || id == 'ClientContect' || id == 'PriorityNo' || id == 'CaseApplicant' || id == 'CaseInventor' || id == 'PctAppNo' || id == 'AttorneyNum' ) {" + Cnstnts.NEW_LINE +
				"htmlCode = \"<input type='text' id='" + name + "' name='" + name + "' maxLength='200' value='" + getFullSearchText1() + "'/>\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    		
    	}
    	else if(name.equalsIgnoreCase("fullSearchText11")) {
    		scriptCode += "function changeDiv11(selecter, div) {" + Cnstnts.NEW_LINE +
				"var id = selecter[selecter.selectedIndex].value;" + Cnstnts.NEW_LINE +
				"var htmlCode;" + Cnstnts.NEW_LINE;
    		
    		scriptCode += "if(id == '' || id == 'CaseNo' || id == 'CaseNo2' || id == 'ApplyNo' || id == 'LicenseNo' || id == 'Title' || id == 'OriginalTitle' " +
    				" || id == 'Client' || id == 'ClientName' || id == 'PatentOffice' || id == 'SerialMotherCase' || id == 'InternalNo'" +
    				" || id == 'Attorney'    || id == 'ClientContect' || id == 'PriorityNo' || id == 'CaseApplicant' || id == 'CaseInventor' || id == 'PctAppNo' || id == 'AttorneyNum' ) {" + Cnstnts.NEW_LINE +
				"htmlCode = \"<input type='text' id='" + name + "' name='" + name + "' maxLength='200' value='" + getFullSearchText11() + "'/>\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    		
    	}
    	else if(name.equalsIgnoreCase("fullSearchText2")) {
    		scriptCode += "function changeDiv2(selecter, div) {" + Cnstnts.NEW_LINE +
				"var id = selecter[selecter.selectedIndex].value;" + Cnstnts.NEW_LINE +
				"var htmlCode;" + Cnstnts.NEW_LINE;
		
    		scriptCode += "if(id == '' || id == 'FlowKey' || id == 'ApplyNo' || id == 'LicenseNo' || id == 'Title' || id == 'OriginalTitle' " +
				" || id == 'Client' || id == 'ClientName' || id == 'SerialMotherCase' || id == 'InternalNo' || id == 'Country' || id == 'PctAppNo' ) {" + Cnstnts.NEW_LINE +
				"htmlCode = \"<input type='text' id='" + name + "' name='" + name + "' maxLength='200' value='" + getFullSearchText2() + "'/>\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	}
			

    	String oldName = "";
    	String inputValue = "";
    	if(name.equals("fullSearchText1")) {
    		inputValue = this.getFullSearchText1();
    		
    		oldName = this.CreateDept.getName();
	    	this.CreateDept.setName(name);
	    	scriptCode += "else if(id == 'CreateDept') {" + Cnstnts.NEW_LINE +
					"htmlCode = \"" + getSearchDeptListHtml(super.getDataDept()).replaceAll("\n", "") + "   " + 
					getSearchCreatorListHtml(super.getDataDept(), getCreator()).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
					"}" + Cnstnts.NEW_LINE;
	    	this.CreateDept.setName(oldName);


	    	String sql = "select FlowKey, Names from category where parentid='TechCategory2' and memo = '" + inputValue + "'";
	    	String oldName2 = this.TechCategory.getName();
	    	this.TechCategory.setName("fullSearchText3");
	        this.TechCategory.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	    	this.TechCategory.setValue(this.getFullSearchText3());
	        if(!Util.isEmpty(inputValue)) {
	        	this.TechCategory.setSelectList(this.getDbUtil().getSelectItemList(sql, "Names"));
	        }

    	}
    	else if(name.equals("fullSearchText11")) {
    		inputValue = this.getFullSearchText11();
    		
    		oldName = this.CreateDept.getName();
	    	this.CreateDept.setName(name);
	    	scriptCode += "else if(id == 'CreateDept') {" + Cnstnts.NEW_LINE +
					"htmlCode = \"" + getSearchDeptListHtml(super.getDataDept()).replaceAll("\n", "") + "   " + 
					getSearchCreatorListHtml(super.getDataDept(), getCreator()).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
					"}" + Cnstnts.NEW_LINE;
	    	this.CreateDept.setName(oldName);


	    	String sql = "select FlowKey, Names from category where parentid='TechCategory2' and memo = '" + inputValue + "'";
	    	String oldName2 = this.TechCategory.getName();
	    	this.TechCategory.setName("fullSearchText3");
	        this.TechCategory.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	    	this.TechCategory.setValue(this.getFullSearchText3());
	        if(!Util.isEmpty(inputValue)) {
	        	this.TechCategory.setSelectList(this.getDbUtil().getSelectItemList(sql, "Names"));
	        }

    	}
    	else if(name.equals("fullSearchText2")) {
    		inputValue = this.getFullSearchText2();
    		
    		oldName = this.CreateDept.getName();
	    	this.CreateDept.setName(name);
	    	scriptCode += "else if(id == 'CreateDept') {" + Cnstnts.NEW_LINE +
					"htmlCode = \"" + getSearchDeptListHtml(DataDept2).replaceAll("\n", "") + "   " + getSearchCreatorListHtml(DataDept2, Creator2).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
					"}" + Cnstnts.NEW_LINE;
	    	this.CreateDept.setName(oldName);
	    	

	    	String sql = "select FlowKey, Names from category where parentid='TechCategory2' and memo = '" + inputValue + "'";
	    	String oldName2 = this.TechCategory.getName();
	    	this.TechCategory.setName("fullSearchText4");
	        this.TechCategory.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	    	this.TechCategory.setValue(this.getFullSearchText4());
	        if(!Util.isEmpty(inputValue)) {
	        	this.TechCategory.setSelectList(this.getDbUtil().getSelectItemList(sql, "Names"));
	        }

    	}

    	oldName = this.Referrals.getName();
    	this.Referrals.setName(name);
    	scriptCode += "else if(id == 'Referrals') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.Referrals).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.Referrals.setName(oldName);
    	
    	oldName = this.Status.getName();
    	this.Status.setName(name);
    	this.Status.setMapingPrpt(null);
    	scriptCode += "else if(id == 'Status') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.Status).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.Status.setName(oldName);
    	this.Status.setMapingPrpt(new Category().getNamesPrpts());
    	
//    	oldName = this.PatentOffice.getName();
//    	this.PatentOffice.setName(name);
//    	scriptCode += "else if(id == 'PatentOffice') {" + Cnstnts.NEW_LINE +
//				"htmlCode = \"" + printTag(this.PatentOffice).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
//				"}" + Cnstnts.NEW_LINE;
//    	this.PatentOffice.setName(oldName);
    	
    	
    	oldName = this.PatentType.getName();
    	this.PatentType.setName(name);
    	scriptCode += "else if(id == 'PatentType') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.PatentType).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.PatentType.setName(oldName);
    	
//    	oldName = this.ClientContect.getName();
//    	this.ClientContect.setName(name);
//    	scriptCode += "else if(id == 'ClientContect') {" + Cnstnts.NEW_LINE +
//				"htmlCode = \"" + printTag(this.ClientContect).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
//				"}" + Cnstnts.NEW_LINE;
//    	this.ClientContect.setName(oldName);
    	
    	
    	oldName = this.PatentCaseType.getName();
    	this.PatentCaseType.setName(name);
    	scriptCode += "else if(id == 'PatentCaseType') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.PatentCaseType).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.PatentCaseType.setName(oldName);
    	
    	
    	oldName = this.CaseAssignedTo.getName();
    	this.CaseAssignedTo.setName(name);
    	scriptCode += "else if(id == 'CaseAssignedTo') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.CaseAssignedTo).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.CaseAssignedTo.setName(oldName);
    	
    	oldName = this.InCharge.getName();
    	this.InCharge.setName(name);
    	scriptCode += "else if(id == 'InCharge') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.InCharge).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.InCharge.setName(oldName);
    	
    	oldName = this.CaseAD.getName();
    	this.CaseAD.setName(name);
    	scriptCode += "else if(id == 'CaseAD') {" + Cnstnts.NEW_LINE +
    	"htmlCode = \"" + printTag(this.CaseAD).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
    	"}" + Cnstnts.NEW_LINE;
    	this.CaseAD.setName(oldName);

    	oldName = this.Attorney.getName();
    	this.Attorney.setName(name);
    	scriptCode += "else if(id == 'Attorney') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.Attorney).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.Attorney.setName(oldName);
    	
        if(name.equalsIgnoreCase("fullSearchText1")) {
        	scriptCode += "var value = '" + this.getFullSearchText1() + "';" + Cnstnts.NEW_LINE;
    		scriptCode += "if($('#" + name + "').length > 0) {" + Cnstnts.NEW_LINE +
    				"value=$('#fullSearchText1').val();" + Cnstnts.NEW_LINE + 
    				"}" + Cnstnts.NEW_LINE;
    		scriptCode += "document.getElementById(div).innerHTML = htmlCode;" + Cnstnts.NEW_LINE;
    		scriptCode += "document.input.fullSearchText1.value=value;" + Cnstnts.NEW_LINE;
        }
        else {
        	scriptCode += "document.getElementById(div).innerHTML = htmlCode;" + Cnstnts.NEW_LINE;
        }
        
        scriptCode += "}" + Cnstnts.NEW_LINE;
        scriptCode += "</script>";
        
        
        
        if(name.equalsIgnoreCase("fullSearchText1")) {
        	scriptCode = scriptCode.replaceAll("dataDept", "fullSearchText1").replaceAll("creater", "fullSearchText3");
        }
        if(name.equalsIgnoreCase("fullSearchText2")) {
        	scriptCode = scriptCode.replaceAll("dataDept", "fullSearchText2").replaceAll("creater", "fullSearchText4");
        }
        
        return scriptCode;
    }

    public void setResultFields() {
    	this.ResultFields = new LinkedHashMap<String, Field>();
    	
    	Properties attorneyPrpt = null;
   	 	try {
			attorneyPrpt = new Attorney().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}

    	Properties empPrpt = null;
   	 	try {
   	 	empPrpt = new Employee().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
   	 	this.ResultFields.put(this.InternalNo.getName(), this.InternalNo);
    	this.ResultFields.put(this.CaseNo.getName(), this.CaseNo);
//    	this.ResultFields.put(this.CaseNo2.getName(), this.CaseNo2);
        this.ResultFields.put(this.Title.getName(), this.Title);
        this.ResultFields.put(this.PatentOffice.getName(), this.PatentOffice);
    	this.ResultFields.put(this.PatentType.getName(), this.PatentType);
    	this.ResultFields.put(this.Status.getName(), this.Status);
    	this.ResultFields.put(this.ApplyDate.getName(), this.ApplyDate);
    	this.ResultFields.put(this.ApplyNo.getName(), this.ApplyNo);
    	this.ResultFields.put(this.PublishDate.getName(), this.PublishDate);
    	this.ResultFields.put(this.PublishNo.getName(), this.PublishNo);
    	this.ResultFields.put(this.IssueDate.getName(), this.IssueDate);
    	this.ResultFields.put(this.IssueNo.getName(), this.IssueNo);
    	this.ResultFields.put(this.LicenseNo.getName(), this.LicenseNo);
    	this.ResultFields.put(this.PctAppNo.getName(), this.PctAppNo);
    	this.ResultFields.put(this.RightBeginDate.getName(), this.RightBeginDate);
    	this.ResultFields.put(this.RightEndDate.getName(), this.RightEndDate);
    	this.ResultFields.put(this.FeeScheduleDate.getName(), this.FeeScheduleDate);
    	this.ResultFields.put(this.CaseApplicantNames.getName(), this.CaseApplicantNames);
    	this.ResultFields.put(this.CaseInventorNames.getName(), this.CaseInventorNames);
    	this.ResultFields.put(this.ClientContect.getName(), this.ClientContect);
        this.ResultFields.put(this.CaseStartDate.getName(), this.CaseStartDate);
    	this.ResultFields.put(this.PriorityDate.getName(), this.PriorityDate);
    	this.ResultFields.put(this.PriorityNo.getName(), this.PriorityNo);
//        this.ResultFields.put(this.PatentCaseType.getName(), this.PatentCaseType);
        this.ResultFields.put(this.OriginalTitle.getName(), this.OriginalTitle);
        this.ResultFields.put(this.ClientName.getName(), this.ClientName);
        this.ResultFields.put(this.SerialMotherCase.getName(), this.SerialMotherCase);
    	this.ResultFields.put(this.LicenseDate.getName(), this.LicenseDate);
    	this.ResultFields.put(this.FeeSchedule.getName(), this.FeeSchedule);
    	this.ResultFields.put(this.LastSchedule.getName(), this.LastSchedule);
    	this.Attorney.setMapingPrpt(attorneyPrpt);
    	this.Attorney.setNotShowCode(true);
    	this.ResultFields.put(this.Attorney.getName(), this.Attorney);
    	this.ResultFields.put(this.CaseAD.getName(), this.CaseAD);
    	this.CaseAD.setMapingPrpt(empPrpt);
    	this.CaseAD.setNotShowCode(true);
    	this.ResultFields.put(this.InCharge.getName(), this.InCharge);
    	this.InCharge.setMapingPrpt(empPrpt);
    	this.InCharge.setNotShowCode(true);
    	this.ResultFields.put(this.ContactDate.getName(), this.ContactDate);
    	this.ResultFields.put(this.AttorneyNum.getName(), this.AttorneyNum);
    	this.ResultFields.put(this.EnglishTitle.getName(), this.EnglishTitle);
    	this.ResultFields.put(this.CaseAssignedTo.getName(), this.CaseAssignedTo);
    	this.ResultFields.put(this.DeliveryDate.getName(), this.DeliveryDate);
    	this.ResultFields.put(this.ImageUrl.getName(), this.ImageUrl);
    	this.ResultFields.put(this.Referrals.getName(), this.Referrals);
    	this.Referrals.setMapingPrpt(empPrpt);
    	this.Referrals.setNotShowCode(true);
    	
    	
    }

    
    public void doAction(UserBean userInfo) throws Exception {
    	this.setUserInfo(userInfo);
    	super.doAction(userInfo);
    	
    	/*
    	當勾選後按“確認提交IDS”按鈕時則會將勾選的該筆PatentCitation資料的IsUsIds欄位帶入Y，
    	並且在UsIdsDate 欄位帶入今日日期，並在UsStatus欄位帶入“PCS02”。

    	當勾選後按“無需提交IDS”按鈕時則會將勾選的該筆PatentCitation資料的UsStatus欄位帶入“PCS03”。

    	當按“產生IDS套印檔”時則會根據目前此Tab中列表的特定資料，透過I-Report去產生特定格式之套印檔。(此部分套印格式尚未確認)
    	並且會將此列表中UsStatus欄位資料為“PCS02”的PatentCitation資料的UsStatus欄位資料改成“PCS04”
    	*/
    	if(Util.compareTo(this.getPatentOffice(), "US")) {
	    	if(Util.compareTo(this.getProcessType(), "confirmIDS")) {
	    		doConfirmIDSUs();
	    	}
	    	else if(Util.compareTo(this.getProcessType(), "unconfirmIDS")) {
	    		doUnconfirmIDSUs();
	    	}
	    	else if(Util.compareTo(this.getProcessType(), "printIDS")) {
	    		doPrintIDSUs();
	    		doExportXML();
	    	}
    	}
    	else if(Util.compareTo(this.getPatentOffice(), "EP")) {
	    	if(Util.compareTo(this.getProcessType(), "confirmIDS")) {
	    		doConfirmIDSEp();
	    	}
	    	else if(Util.compareTo(this.getProcessType(), "unconfirmIDS")) {
	    		doUnconfirmIDSEp();
	    	}
	    	else if(Util.compareTo(this.getProcessType(), "printIDS")) {
	    		doPrintIDSEp();
	    	}
    	}
    	
    	if(Util.compareTo(this.getCopyApplicantFlag(), "true")) {
    		copyApplicantProcess();
    	}
    	
    }
    
    public void copyApplicantProcess() throws Exception {
    	//“發明人”tab 增加”同申請人”按鈕，點了之後從申請人將身分為自然人的資料增加儲存到申請人tab
    	String sql = "select a.flowkey as flowkey from patentapplicant p, applicant a " +
    			"where p.parentid='" + this.getFlowKey() + "' " +
    			"and p.ApplicantId = a.flowkey " +
    			"and a.IdType = 'Identity01' ";
    	List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
    	List<String> sqls = new ArrayList<String>();
    	if(keys != null && !keys.isEmpty()) {
    		for(String s : keys) {
    			Applicant app = new Applicant(s);
    			
    			PatentInventor pi = new PatentInventor();
    			pi.setDbFields();
    			pi.setFlowKey(FlowEngin.getPkeyNo(this.getFlowKey(), 3, false, "."));
    			pi.setApplicant(this.getUserInfo().getAttribute("emp_id"));
    			pi.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
    			pi.setParentId(this.getFlowKey());
    			pi.setInventor(s);
    			pi.setInventorName(app.getNames());
    			pi.setNationality(app.getNationality());
    			pi.setEnglishNames(app.getEnglishNames());
    			pi.setIdNo(app.getIdNo());
    			sqls.add(this.getDbUtil().getInsertSQL(pi.getTableName(), pi.getDbFields()));
    		}
    		
    		this.getDbUtil().executeUpdate(sqls);
    	}
    }
    
    public void doExportXML() throws Exception {
    	
    	FileInputStream io = new FileInputStream(Util.IDS_XML_PATH);
    	Document doc = Util.parseXML(io, "big5");
    	if (doc != null && 
    			(this.getMarkKeys() != null && this.getMarkKeys().length > 0)) {
    		
    		Element root = doc.getRootElement();
//    		//System.out.println(doc.asXML());

    		//基本資料tab申請號
    		doc.selectSingleNode("//us-application-identification-info/doc-number']").setText(this.getApplyNo());
    		//基本資料tab申請日
    		doc.selectSingleNode("//us-application-identification-info/date']").setText(this.getApplyDate());
    		
    		//發明人tab 排序1發明人名稱(英)
    		String sql = "select Inventor from patentinventor where parentid='" + this.getFlowKey() + "' and InventorOrder = '1' order by flowkey";
    		List<String> keys = this.getDbUtil().getValueList(sql, "Inventor");
    		if(keys != null && !keys.isEmpty()) {
    			Applicant app = new Applicant(keys.get(0));
    			doc.selectSingleNode("//us-first-named-inventor/name']").setText(app.getEnglishNames());
    		}
    		else {
    			doc.selectSingleNode("//us-first-named-inventor/name']").setText("");
    		}
    		
    		//美國IDS tab 事務所內部案號
    		sql = "select internalCaseNo from patentcitation where parentid='" + this.getFlowKey() + "' order by flowkey";
    		keys = this.getDbUtil().getValueList(sql, "internalCaseNo");
    		if(keys != null && !keys.isEmpty()) {
    			doc.selectSingleNode("//us-filing-info/file-reference-id']").setText(keys.get(0));
    		}

    		String inCond = Util.arrayToIncond(this.getMarkKeys());
    		
    		//US Patent 表格* 若在IPS系統中的美國IDS表格中所選為"US.Patent-美國專利"類別之資料 匯入下類表格
    		sql = "select flowkey from patentcitation where SerialMotherCase='" + this.getSerialMotherCase() + "' and flowkey in (" + inCond + ") and CitationType = 'US.Patent' order by flowkey";
    		if(Util.isEmpty(this.getSerialMotherCase())) {
    			sql = "select flowkey from patentcitation where SerialMotherCase='" + this.getFlowKey() + "' and flowkey in (" + inCond + ") and CitationType = 'US.Patent' order by flowkey";
    		}
    		keys = this.getDbUtil().getValueList(sql, "flowkey");
    		if(keys != null && !keys.isEmpty()) {
    			Element uePAtentRoot = root.element("us-patent-cite");
    			int index = 1;
    			for(String key : keys) {
    				PatentCitation pc = new PatentCitation(key);
    				
    				/*
		<us-doc-reference id="dd:id_2" num="1" sequence="">
			<doc-number>1111111</doc-number>
			<name name-type="">111111</name>
			<kind>1</kind>
			<date>2013-01-01</date>
			<class/>
			<subclass/>
			<relevant-portion>1111</relevant-portion>
		</us-doc-reference>
    				 */
    				Element element = uePAtentRoot.addElement("us-doc-reference");
    				element.addAttribute("id", "dd:id_1");
    				element.addAttribute("num", index + "");
    				
    				//美國IDS tab 專利號
    				Element element1 = element.addElement("doc-number");
    				element1.setText(pc.getIssueNo());
    				
    				//美國IDS tab 專利權人／申請人
    				Element element2 = element.addElement("name");
    				element2.addAttribute("name-type", "");
    				element2.setText(pc.getPatenteeApplicant());
    				
    				//美國IDS tab 類別碼（非必填）
    				Element element3 = element.addElement("kind");
    				element3.setText(pc.getKindCode());
    				
    				//美國IDS tab 公告日
    				Element element4 = element.addElement("date");
    				element4.setText(pc.getIssueDate());

    				Element element6 = element.addElement("class");

    				Element element7 = element.addElement("subclass");
    				
    				//美國IDS tab 所在文獻卷、頁數（非必填）
    				Element element5 = element.addElement("relevant-portion");
    				element5.setText(pc.getDocPage());
    				
    				index++;
    			}
    		}
    		
    		
    		//US Patent Application Publications 表格* 若在IPS系統中的美國IDS表格中所選為"US.Pub-美國公開專利"類別匯入下類表格
    		sql = "select flowkey from patentcitation where SerialMotherCase='" + this.getSerialMotherCase() + "' and flowkey in (" + inCond + ")  and CitationType = 'US.Pub' order by flowkey";
    		if(Util.isEmpty(this.getSerialMotherCase())) {
    			sql = "select flowkey from patentcitation where SerialMotherCase='" + this.getFlowKey() + "' and flowkey in (" + inCond + ") and CitationType = 'US.Pub' order by flowkey";
    		}
    		keys = this.getDbUtil().getValueList(sql, "flowkey");
    		if(keys != null && !keys.isEmpty()) {
    			Element uePAtentRoot = root.element("us-pub-appl-cite");
    			int index = 1;
    			for(String key : keys) {
    				PatentCitation pc = new PatentCitation(key);
    				
    				/*
		<us-doc-reference id="dd:id_3" num="1" sequence="">
			<doc-number>20050053725</doc-number>
			<name name-type="">SEIKO EPSON CORP </name>
			<kind>A1</kind>
			<date>2005-03-10</date>
			<class/>
			<subclass/>
		</us-doc-reference>
    				 */
    				Element element = uePAtentRoot.addElement("us-doc-reference");
    				element.addAttribute("id", "dd:id_1");
    				element.addAttribute("num", index + "");
    				
    				//美國IDS tab 公開號
    				Element element1 = element.addElement("doc-number");
    				element1.setText(pc.getPublishNo());
    				
    				//美國IDS tab 專利權人／申請人
    				Element element2 = element.addElement("name");
    				element2.addAttribute("name-type", "");
    				element2.setText(pc.getPatenteeApplicant());
    				
    				//美國IDS tab 類別碼（非必填）
    				Element element3 = element.addElement("kind");
    				element3.setText(pc.getKindCode());
    				
    				//美國IDS tab 公開日
    				Element element4 = element.addElement("date");
    				element4.setText(pc.getPublishDate());

    				Element element6 = element.addElement("class");

    				Element element7 = element.addElement("subclass");
    				
    				//美國IDS tab 所在文獻卷、頁數（非必填）
    				Element element5 = element.addElement("relevant-portion");
    				element5.setText(pc.getDocPage());
    				
    				index++;
    			}
    		}
    		
    		//FOREIGN PATENT DOCUMENTS 表格* 若在IPS系統中的美國IDS表格中所選為 "NonUS.Pub-非美國公開專利"類別則匯入下類表格
    		sql = "select flowkey from patentcitation where SerialMotherCase='" + this.getSerialMotherCase() + "' and flowkey in (" + inCond + ") and CitationType = 'NonUS.Pub' order by flowkey";
    		if(Util.isEmpty(this.getSerialMotherCase())) {
    			sql = "select flowkey from patentcitation where SerialMotherCase='" + this.getFlowKey() + "' and flowkey in (" + inCond + ") and CitationType = 'NonUS.Pub' order by flowkey";
    		}
    		keys = this.getDbUtil().getValueList(sql, "flowkey");
    		if(keys != null && !keys.isEmpty()) {
    			Element uePAtentRoot = root.element("us-foreign-document-cite");
    			int index = 1;
    			for(String key : keys) {
    				PatentCitation pc = new PatentCitation(key);
    				
    				/*
			<us-foreign-doc-reference id="1" num="" sequence="" translation-attached="yes">
				<country>CN</country>
				<doc-number>1576960</doc-number>
				<kind>A</kind>
				<name name-type="">SEIKO EPSON CORP </name>
				<date>2005-02-09</date>
				<class/>
				<subclass/>
				<relevant-portion>2</relevant-portion>
			</us-foreign-doc-reference>
    				 */
    				Element element = uePAtentRoot.addElement("us-foreign-doc-reference");
    				element.addAttribute("id", index + "");
    				element.addAttribute("num", "");
    				element.addAttribute("sequence", "");
    				if(Util.compareTo(pc.getT5(), "Y")) {
    					element.addAttribute("translation-attached", "yes");
    				}
    				else {
    					element.addAttribute("translation-attached", "no");
    				}
    				
    				//美國IDS tab  國家代碼
    				Element element11 = element.addElement("country");
    				element11.setText(pc.getCountryCode());
    				
    				//美國IDS tab 公開號
    				Element element1 = element.addElement("doc-number");
    				element1.setText(pc.getPublishNo());
    				
    				//美國IDS tab 專利權人／申請人
    				Element element2 = element.addElement("name");
    				element2.addAttribute("name-type", "");
    				element2.setText(pc.getPatenteeApplicant());
    				
    				//美國IDS tab 類別碼（非必填）
    				Element element3 = element.addElement("kind");
    				element3.setText(pc.getKindCode());
    				
    				//美國IDS tab 公開日
    				Element element4 = element.addElement("date");
    				element4.setText(pc.getPublishDate());

    				Element element6 = element.addElement("class");

    				Element element7 = element.addElement("subclass");
    				
    				//美國IDS tab 所在文獻卷、頁數（非必填）
    				Element element5 = element.addElement("relevant-portion");
    				element5.setText(pc.getDocPage());
    				
    				index++;
    			}
    		}
    		
    		
    		//NON-PATENT LITERATURE DOCUMENTS 表格* 若在IPS系統中的美國IDS表格中所選為NPL-非專利文獻類別，則匯入下類表格
    		sql = "select flowkey from patentcitation where SerialMotherCase='" + this.getFlowKey() + "' and flowkey in (" + inCond + ") and CitationType = 'NPL' order by flowkey";
    		if(Util.isEmpty(this.getSerialMotherCase())) {
    			sql = "select flowkey from patentcitation where SerialMotherCase='" + this.getSerialMotherCase() + "' and flowkey in (" + inCond + ") and CitationType = 'NPL' order by flowkey";
    		}
    		keys = this.getDbUtil().getValueList(sql, "flowkey");
    		if(keys != null && !keys.isEmpty()) {
    			int index = 1;
    			for(String key : keys) {
    				PatentCitation pc = new PatentCitation(key);
    				
    				/*
		<us-nplcit file="" id="1" medium="" num="" sequence="" translation-attached="yes" type="" url="">
			<text>111111</text>
		</us-nplcit>
    				 */
    				Element element = root.addElement("us-nplcit");
    				element.addAttribute("file", "");
    				element.addAttribute("id", index + "");
    				element.addAttribute("medium", "");
    				element.addAttribute("num", "");
    				element.addAttribute("sequence", "");
    				if(Util.compareTo(pc.getT5(), "Y")) {
    					element.addAttribute("translation-attached", "yes");
    				}
    				else {
    					element.addAttribute("translation-attached", "no");
    				}
    				element.addAttribute("type", "");
    				element.addAttribute("url", "");
    				
    				//美國IDS tab "書目資料：包含作者名稱（大寫）、文章標題、書名或期刊或雜誌或研討會期刊或雜誌或研討會或目錄名、日期、頁數、發行刊期數、出版者：出版社或學會組織、出版地：出版城市或國家 "
    				Element element11 = element.addElement("text");
    				element11.setText(pc.getMemo());
    				
    				index++;
    			}
    		}

        	String outputFile = "PatentCase/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".xml";
        	String zipFile = "PatentCase/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".zip";
        	String outputDoc = Util.getDocPath()+outputFile;
        	String outputZip = Util.getDocPath()+zipFile;
        	File file = new File(Util.getDocPath() + "PatentCase");
        	file.mkdirs();
        	BufferedWriter bw  = new BufferedWriter(new FileWriter(outputDoc));
        	bw.write(doc.asXML());
        	bw.close();
        	
        	List<String> files = new ArrayList<String>();
        	files.add(outputDoc);
        	
        	Util.zip(outputZip, files);
        	
        	setOutputFile("doc/"+zipFile);
    	}
    	
    	
    }

    public void doPrintIDSUs() throws Exception {
    	if(this.MarkKeys != null && this.MarkKeys.length > 0) {
    		List<String> sqls = new ArrayList<String>();
    		
    		for(String key : this.getMarkKeys()) {
            	PatentCitation pc = new PatentCitation(key);
            	pc.setDbFields();
            	if(Util.compareTo(pc.getUsStatus(), "PCS02")) {
    				pc.setUsStatus("PCS04");
    			}
    			
    			sqls.add(this.getDbUtil().getUpdateSQL("PatentCitation", pc.getDbFields()));
            }
    		this.getDbUtil().executeUpdate(sqls);
    	}
	}
    
    public void doConfirmIDSUs() throws Exception {
    	//當勾選後按“確認提交IDS”按鈕時則會將勾選的該筆PatentCitation資料的IsUsIds欄位帶入Y，
    	//並且在UsIdsDate 欄位帶入今日日期，並在UsStatus欄位帶入“PCS02”。
    	if(this.getMarkKeys() != null) {
    		List<String> sqls = new ArrayList<String>();
    		
    		for(String key : this.getMarkKeys()) {
    			PatentCitation pc = new PatentCitation(key);
    			pc.setDbFields();
    			pc.setIsUsIds("Y");
    			pc.setUsIdsDate(Util.getDate());
    			//這兩個狀態變更按鈕功能限制成僅能從PCS01來改變成PCS02或PCS03，
    			//所以若勾選的PatentCitation資料的“狀態”非PCS01則不執行狀態變更。
    			//if(Util.compareTo(pc.getUsStatus(), "PCS01")) {
    				pc.setUsStatus("PCS02");
    			//}
    			
    			sqls.add(this.getDbUtil().getUpdateSQL("PatentCitation", pc.getDbFields()));    			
    		}
//    		for(String s : sqls) {
//    			//System.out.println(s);
//    		}
    		this.getDbUtil().executeUpdate(sqls);
    	}
    }
    
    public void doUnconfirmIDSUs() throws Exception {
    	//當勾選後按“無需提交IDS”按鈕時則會將勾選的該筆PatentCitation資料的UsStatus欄位帶入“PCS03”。
    	if(this.getMarkKeys() != null) {
    		List<String> sqls = new ArrayList<String>();
    		
    		for(String key : this.getMarkKeys()) {
    			PatentCitation pc = new PatentCitation(key);
    			pc.setDbFields();
    			//這兩個狀態變更按鈕功能限制成僅能從PCS01來改變成PCS02或PCS03，
    			//所以若勾選的PatentCitation資料的“狀態”非PCS01則不執行狀態變更。
    			//if(Util.compareTo(pc.getUsStatus(), "PCS01")) {
    				pc.setUsStatus("PCS03");
    			//}
    			
    			sqls.add(this.getDbUtil().getUpdateSQL("PatentCitation", pc.getDbFields()));    			
    		}
//    		for(String s : sqls) {
//    			//System.out.println(s);
//    		}
    		
    		this.getDbUtil().executeUpdate(sqls);
    	}
    }

    public void doPrintIDSEp() throws Exception {
    	if(this.MarkKeys != null && this.MarkKeys.length > 0) {
    		List<String> sqls = new ArrayList<String>();
    		
    		for(String key : this.getMarkKeys()) {
            	PatentCitation pc = new PatentCitation(key);
            	pc.setDbFields();
    			//這兩個狀態變更按鈕功能限制成僅能從PCS01來改變成PCS02或PCS03，
    			//所以若勾選的PatentCitation資料的“狀態”非PCS01則不執行狀態變更。
    			if(Util.compareTo(pc.getEpStatus(), "PCS02")) {
    				pc.setEpStatus("PCS04");
    			}
    			
    			sqls.add(this.getDbUtil().getUpdateSQL("PatentCitation", pc.getDbFields()));
            }
    		this.getDbUtil().executeUpdate(sqls);
    	}
	}
    
    public void doConfirmIDSEp() throws Exception {
    	//當勾選後按“確認提交IDS”按鈕時則會將勾選的該筆PatentCitation資料的IsUsIds欄位帶入Y，
    	//並且在UsIdsDate 欄位帶入今日日期，並在UsStatus欄位帶入“PCS02”。
    	if(this.getMarkKeys() != null) {
    		List<String> sqls = new ArrayList<String>();
    		
    		for(String key : this.getMarkKeys()) {
    			PatentCitation pc = new PatentCitation(key);
    			pc.setDbFields();
    			pc.setIsEpIds("Y");
    			pc.setEpIdsDate(Util.getDate());
    			//這兩個狀態變更按鈕功能限制成僅能從PCS01來改變成PCS02或PCS03，
    			//所以若勾選的PatentCitation資料的“狀態”非PCS01則不執行狀態變更。
    			//if(Util.compareTo(pc.getEpStatus(), "PCS01")) {
    				pc.setEpStatus("PCS02");
    			//}
    			
    			
    			sqls.add(this.getDbUtil().getUpdateSQL("PatentCitation", pc.getDbFields()));    			
    		}
//    		for(String s : sqls) {
//    			//System.out.println(s);
//    		}
    		this.getDbUtil().executeUpdate(sqls);
    	}
    }
    
    public void doUnconfirmIDSEp() throws Exception {
    	//當勾選後按“無需提交IDS”按鈕時則會將勾選的該筆PatentCitation資料的UsStatus欄位帶入“PCS03”。
    	if(this.getMarkKeys() != null) {
    		List<String> sqls = new ArrayList<String>();
    		
    		for(String key : this.getMarkKeys()) {
    			PatentCitation pc = new PatentCitation(key);
    			pc.setDbFields();
    			//這兩個狀態變更按鈕功能限制成僅能從PCS01來改變成PCS02或PCS03，
    			//所以若勾選的PatentCitation資料的“狀態”非PCS01則不執行狀態變更。
    			//if(Util.compareTo(pc.getEpStatus(), "PCS01")) {
    				pc.setEpStatus("PCS03");
    			//}
    			
    			sqls.add(this.getDbUtil().getUpdateSQL("PatentCitation", pc.getDbFields()));    			
    		}
//    		for(String s : sqls) {
//    			//System.out.println(s);
//    		}
    		
    		this.getDbUtil().executeUpdate(sqls);
    	}
    }
    
    public String printCaseRenewalLogListTableHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		
		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.RenewalLog.FlowKey")+"</td>";
		String thText3="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.RenewalLog.FeeScheduleDate")+"</td>";
		String thText4="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.RenewalLog.FeeSchedule")+"</td>";
		String thText5="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.RenewalLog.RenewStatus")+"</td>";
		String thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.RenewalLog.KeepMaintain")+"</td>";
		String thText7="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.RenewalLog.AddYear")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText7+thText8+"</tr>");
		
		String SQL = "select  r.*"+
		"from RenewalLog r "+
		"where ParentId='"+this.getFlowKey()+"' order by FeeScheduleDate desc";
		
		RenewalLog renewalLog = new RenewalLog();
		renewalLog.setDbFields();
		List<Field> fieldList = renewalLog.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		Properties checkMaintainPrpt = new Properties();
		try {
			checkMaintainPrpt.setProperty("Y" , "是" );
			checkMaintainPrpt.setProperty("N" , "否" );
		} catch(Exception e) {
			e.printStackTrace();
		}
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String FlowKey = Cnstnts.EMPTY_STRING;
			String FeeScheduleDate = Cnstnts.EMPTY_STRING;
			String FeeSchedule = Cnstnts.EMPTY_STRING;
			String RenewStatus = Cnstnts.EMPTY_STRING;
			String KeepMaintain = Cnstnts.EMPTY_STRING;
			String AddYear = Cnstnts.EMPTY_STRING;
			
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("FeeScheduleDate")){
					FeeScheduleDate = field.getValue();
				}
				if(field.getName().equals("FeeSchedule")){
					FeeSchedule = field.getValue();
				}
				if(field.getName().equals("RenewStatus")){
					RenewStatus = field.getValue();
				}
				if(field.getName().equals("KeepMaintain")){
					KeepMaintain = field.getValue();
				}
				if(field.getName().equals("AddYear")){
					AddYear = field.getValue();
				}
			}
			String onClick = " onClick='openAppendix(\"RenewalLog.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"RenewalLog\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td"+onClick+">"+FlowKey+"</td>";
			String tdText3="<td"+onClick+">"+FeeScheduleDate+"</td>";
			String tdText4="<td align='center'"+onClick+">"+FeeSchedule+"</td>";
			String tdText5="<td"+onClick+">"+categoryPrpt.getProperty(RenewStatus)+"</td>";
			String tdText6="<td align='center'"+onClick+">"+checkMaintainPrpt.getProperty(KeepMaintain)+"</td>";
			String tdText7="<td align='center'"+onClick+">"+AddYear+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "";
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}


	public boolean getCanEditField(Field field) {
		if (this.canEdit() || this.onSearchMode()) {
			if(Util.compareTo(this.getDbActionMode(), Cnstnts.UPDATE) &&
					field.getName().equals(this.Client.getName())) {
				return false;
			}
			if(field.getName().equals(this.Referrals.getName())) {
				if (this.onSearchMode()) {
					return true;
				}
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
	
	private void sout(Object o){
		System.out.println(this.getClass().getName() + ":" + o);
	}

    
    public String printSignedMangeTable() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		
		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.SignedManage.No")+"</td>";
		String thText3="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.SignedManage.FirstSender")+"</td>";
		String thText4="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.SignedManage.SubmitDate")+"</td>";
		String thText5="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.SignedManage.SignedType")+"</td>";
		String thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.SignedManage.SignedStatus")+"</td>";
		String thText7="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.SignedManage.FinishDate")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText7+thText8+"</tr>");
		
		String SQL = "select  FlowKey from SignedManage r where CaseFlowKey='"+this.getFlowKey()+"' order by SubmitDate desc";
		
		
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		Properties empProp = new Employee().getNamesPrpts();
		
		List<String> keys = this.getDbUtil().getValueList(SQL, "FlowKey");
		for(String key : keys) {
			i++;
			SignedManage sm = new SignedManage(key);
			String onClick = " onClick='openAppendix(\"SignedManage.jsp?flowKey="+key+
  					"&modeLockFlag=true&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
  					"\",\"SignedManage\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'"+onClick+">"+i+"</td>";
			String tdText3="<td align='center'"+onClick+">"+empProp.getProperty(sm.getFirstSender())+"</td>";
			String tdText4="<td align='center'"+onClick+">"+sm.getSubmitDate()+"</td>";
			String tdText5="<td align='center'"+onClick+">"+sm.getSignedType()+"</td>";
			String tdText6="<td align='center'"+onClick+">"+categoryPrpt.getProperty(sm.getSignedStatus())+"</td>";
			String tdText7="<td align='center'"+onClick+">"+sm.getFinishDate()+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "";
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
    
    public String generateCaseNo() {
    	String caseNo = "";
    	
    	/*
    	"案件編號2"旁也新增"產生案件編號"按鈕，編號規則：
    	部門代碼兩碼（看creator部門代碼前兩碼）＋目前規則（西元年後兩碼＋流水碼四碼＋國家碼兩碼），
    	流水碼檢查依據為案件編號 以及案件編號2 中該部門當年的流水號最後一碼往後加。
    	如 若台北所TP 下某個人新增了一個案子為TP130005TW 再案件編號，該案的案件編號2 
    	另一個上海所SH人登入所編的號碼可能為 SH130003TW，隔天若上海所新建一個中國案子，
    	在案件編號 點產生編號，應該要產生SH130004CN, 台北所進來在案件編號2 點產生編號 應該產生 TP130006CN
    	*/
    	
    	/*20200524 HH
		
		產生編號按鈕的給號規則
		1.申請國家=TW：申請國家英文代碼-專利類別對應代碼-西元年後二碼-四碼流水號
		　(例TW-I-20-0001)
		(1)申請國家英文代碼=TW
		(2)專利類別對應代碼：通用類別/備註(I-發明；U-新型；D-設計；DD-衍生設計；O-其他)
		(3)四碼流水號：每年重置，TW專利流水號共用，不管專利類別
		
		2.申請國家非TW：P-客戶代碼-專利類別對應代碼-西元年後二碼-四碼流水號
		　(例P-客戶代碼-D-20-0001)
		(1)客戶代碼：資料源為客戶資料/客戶代碼
		(2)專利類別對應代碼：通用類別/備註(I-發明；U-新型；D-設計；DD-衍生設計；O-其他)
		(3)四碼流水號：每年重置，不同的客戶各自跑此類(此客戶非TW專利)的流水號 (不用管專利類別)
		
    	 */
    	
    	
    	/* 20220902 HH
    	產生編號按鈕的給號規則，紅字為本次新增
		專利:
		申請國家=TW：
		國家代碼-"客戶代碼"-專利類別對應代碼-西元年後二碼-四碼流水號　
		(例"TW-CG-I-20-0001)
		
		申請國家非TW：
		"國家代碼"-P-客戶代碼-專利類別對應代碼-西元年後二碼-四碼流水號
		(例:US-P-客戶代碼-D-20-0001)
    	 
    	 */
    	
    	try {
    		String office = this.getPatentOffice();
    		String patentType = this.getPatentType();
    		String patentTypeCode = Cnstnts.EMPTY_STRING;
    		if(!Util.isEmpty(patentType)){
    			Category pt = new Category(patentType);
    			patentTypeCode = pt.getMemo();
    		}
    		
    		
    		String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
    		String sql = Cnstnts.EMPTY_STRING;
    		if("TW".equals(office)){
    			String clientCode = this.getClient();
    			
    			
    			//sql = "select CaseNo from (select CaseNo from patentcase where  (LENGTH(CaseNo) - LENGTH(REPLACE(CaseNo, '-', ''))) = 4) as p where CaseNo like 'TW-%-%-"+year+"-%' order by CaseNo desc;";
    			sql = "select SUBSTRING(CaseNo,(LENGTH(SUBSTRING_INDEX(CaseNo,'-" + year + "-',1)) + 5) ,LENGTH(CaseNo) -(LENGTH(SUBSTRING_INDEX(CaseNo,'-" + year + "-',1)) + 4)) as cc,CaseNo from (select CaseNo from patentcase where  (LENGTH(CaseNo) - LENGTH(REPLACE(CaseNo, '-', ''))) = 4) as p where CaseNo like 'TW-%-%-"+year+"-%' order by cast(cc as unsigned) desc;";
    			//List<String> keys = this.getDbUtil().getValueList(sql, "CaseNo");
    			List<String> keys = this.getDbUtil().getValueList(sql, "cc");
    			int max = 1;
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				//int lastMark = key.lastIndexOf("-" + year + "-")+4;
    				//max = Integer.parseInt( key.substring(lastMark, key.length()) ) + 1;
    				max = Integer.parseInt( key ) + 1;
    			}
    			int max2 = max;
    			//sql = "select CaseNo2 from (select CaseNo2 from patentcase where  (LENGTH(CaseNo2) - LENGTH(REPLACE(CaseNo2, '-', ''))) = 4) as p where CaseNo2 like 'TW-%-%-"+year+"-%' order by CaseNo2 desc;";
    			sql = "select SUBSTRING(CaseNo2,(LENGTH(SUBSTRING_INDEX(CaseNo2,'-" + year + "-',1)) + 5) ,LENGTH(CaseNo2) -(LENGTH(SUBSTRING_INDEX(CaseNo2,'-" + year + "-',1)) + 4)) as cc,CaseNo2 from (select CaseNo2 from patentcase where  (LENGTH(CaseNo2) - LENGTH(REPLACE(CaseNo2, '-', ''))) = 4) as p where CaseNo2 like 'TW-%-%-"+year+"-%' order by cast(cc as unsigned) desc;";
    			//keys = this.getDbUtil().getValueList(sql, "CaseNo2");
    			keys = this.getDbUtil().getValueList(sql, "cc");
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				//int lastMark = key.lastIndexOf("-" + year + "-")+4;
    				//max2 = Integer.parseInt( key.substring(lastMark, key.length()) ) + 1;
    				max2 = Integer.parseInt( key ) + 1;
    				if(max2 >= max) {
    					max = max2;
    				}
    			}
    			//caseNo =  "TW-" + patentTypeCode + "-" + year + "-" + String.format("%04d", max);
    			caseNo =  "TW-" + clientCode + "-" + patentTypeCode + "-" + year + "-" + String.format("%04d", max);
    			
    		}else{
    			String client = this.getClient();
    			
    			
    			//sql = "select CaseNo from (select CaseNo from patentcase where  (LENGTH(CaseNo) - LENGTH(REPLACE(CaseNo, '-', ''))) = 5) as p where CaseNo like '%-P-"+client+"-%-"+year+"-%' order by CaseNo desc;";
    			sql = "select SUBSTRING(CaseNo,(LENGTH(SUBSTRING_INDEX(CaseNo,'-"+year+"-',1)) + 5) ,LENGTH(CaseNo) -(LENGTH(SUBSTRING_INDEX(CaseNo,'-"+year+"-',1)) + 4)) as cc, CaseNo from (select CaseNo from patentcase where  (LENGTH(CaseNo) - LENGTH(REPLACE(CaseNo, '-', ''))) = 5) as p where CaseNo like '%-P-"+client+"-%-"+year+"-%' order by cast(cc as unsigned) desc;";
    			//List<String> keys = this.getDbUtil().getValueList(sql, "CaseNo");
    			List<String> keys = this.getDbUtil().getValueList(sql, "cc");
    			int max = 1;
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				//int lastMark = key.lastIndexOf("-" + year + "-")+4;
    				//max = Integer.parseInt( key.substring(key.length() - lastMark, key.length()) ) + 1;
    				max = Integer.parseInt( key) + 1;
    			}
    			int max2 = max;
    			//sql = "select CaseNo2 from (select CaseNo2 from patentcase where  (LENGTH(CaseNo2) - LENGTH(REPLACE(CaseNo2, '-', ''))) = 5) as p where CaseNo2 like '%-P-"+client+"-%-"+year+"-%' order by CaseNo2 desc;";
    			sql = "select SUBSTRING(CaseNo2,(LENGTH(SUBSTRING_INDEX(CaseNo2,'-"+year+"-',1)) + 5) ,LENGTH(CaseNo2) -(LENGTH(SUBSTRING_INDEX(CaseNo2,'-"+year+"-',1)) + 4)) as cc, CaseNo2 from (select CaseNo2 from patentcase where  (LENGTH(CaseNo2) - LENGTH(REPLACE(CaseNo2, '-', ''))) = 5) as p where CaseNo2 like '%-P-"+client+"-%-"+year+"-%' order by cast(cc as unsigned) desc;";
    			//keys = this.getDbUtil().getValueList(sql, "CaseNo2");
    			keys = this.getDbUtil().getValueList(sql, "cc");
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				//int lastMark = key.lastIndexOf("-" + year + "-")+4;
    				//max2 = Integer.parseInt( key.substring(key.length() - lastMark, key.length()) ) + 1;
    				max2 = Integer.parseInt( key ) + 1;
    				if(max2 >= max) {
    					max = max2;
    				}
    			}
    			//caseNo =  "P-" + client + "-" +  patentTypeCode + "-" + year + "-" + String.format("%04d", max);
    			caseNo =  office + "-P-" + client + "-" +  patentTypeCode + "-" + year + "-" + String.format("%04d", max);
    			
    		}
    		    			
    	}
    	catch(Exception e) {
    		
    	}
    	return caseNo;
    }
    

	public String getPrintBtn() throws Exception {
		if (this.onBtnSubmit()){
			if(this.getOutputFile().trim().length() > 0){
				if(this.getDbActionMode().equals(Cnstnts.PRINT)){
					return "<input type='button' style='cursor: hand' " + "value='"
							+ this.getUserInfo().getMsg("jsp.common.printPDF") + "' "
							+ "onClick='downloadFile2(\"" + this.getOutputFile() + "\",\"p\",\""+this.getFlowKey()+"\")'/>";					
				}else{
					return Html.getPrintBtn(this.getOutputFile(), this.getUserInfo());
				}
			}
		} 
		return Cnstnts.EMPTY_STRING;
	}
	
	
}