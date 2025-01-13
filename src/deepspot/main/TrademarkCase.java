package deepspot.main;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.athenasoft.ooutil.OoConverter;

import deepspot.basic.CaseMasterBean;
import deepspot.basic.Cnstnts;
import deepspot.basic.DbUtil;
import deepspot.basic.Field;
import deepspot.basic.SelectItem;
import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.html.SelectOneTag;
import deepspot.util.DB;
import deepspot.util.Util;

public class TrademarkCase extends CaseMasterBean {

    public TrademarkCase(){this.init();}

    public TrademarkCase(String FlowKey) {
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

    public Field NoSDate;
    public void setNoSDate(String NoSDate){this.NoSDate.setValue(NoSDate);}
    public String getNoSDate(){return this.NoSDate.getValue();}

    public Field SpecialRequest;
    public void setSpecialRequest(String SpecialRequest){this.SpecialRequest.setValue(SpecialRequest);}
    public String getSpecialRequest(){return this.SpecialRequest.getValue();}

    public Field TrademarkKind;
    public void setTrademarkKind(String TrademarkKind){this.TrademarkKind.setValue(TrademarkKind);}
    public String getTrademarkKind(){return this.TrademarkKind.getValue();}
    
    public Field IsCharge;
    public void setIsCharge(String IsCharge){this.IsCharge.setValue(IsCharge);}
    public String getIsCharge(){return this.IsCharge.getValue();}
    
   public Field IsPayment;
   public void setIsPayment(String IsPayment){this.IsPayment.setValue(IsPayment);}
   public String getIsPayment(){return this.IsPayment.getValue();}
    
    public Field ToDosStatus;
    public void setToDosStatus(String ToDosStatus){this.ToDosStatus.setValue(ToDosStatus);}
    public String getToDosStatus(){return this.ToDosStatus.getValue();}

    public Field Office;
    public void setOffice(String Office){this.Office.setValue(Office);}
    public String getOffice(){return this.Office.getValue();}
    
    public Field TrademarkType;
    public void setTrademarkType(String TrademarkType){this.TrademarkType.setValue(TrademarkType);}
    public String getTrademarkType(){return this.TrademarkType.getValue();}
    
    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}
    
    public Field AttorneyDate;
    public void setAttorneyDate(String AttorneyDate){this.AttorneyDate.setValue(AttorneyDate);}
    public String getAttorneyDate(){return this.AttorneyDate.getValue();}
    
    public Field AttorneyNum;
    public void setAttorneyNum(String AttorneyNum){this.AttorneyNum.setValue(AttorneyNum);}
    public String getAttorneyNum(){return this.AttorneyNum.getValue();}
    
    public Field FillingDate;
    public void setFillingDate(String FillingDate){this.FillingDate.setValue(FillingDate);}
    public String getFillingDate(){return this.FillingDate.getValue();}
    
    public Field FillingNum;
    public void setFillingNum(String FillingNum){this.FillingNum.setValue(FillingNum);}
    public String getFillingNum(){return this.FillingNum.getValue();}
    
    public Field PublicationDate;
    public void setPublicationDate(String PublicationDate){this.PublicationDate.setValue(PublicationDate);}
    public String getPublicationDate(){return this.PublicationDate.getValue();}
    
    public Field PublicationNum;
    public void setPublicationNum(String PublicationNum){this.PublicationNum.setValue(PublicationNum);}
    public String getPublicationNum(){return this.PublicationNum.getValue();}
    
    public Field RegistDate;
    public void setRegistDate(String RegistDate){this.RegistDate.setValue(RegistDate);}
    public String getRegistDate(){return this.RegistDate.getValue();}
    
    public Field RegistNum;
    public void setRegistNum(String RegistNum){this.RegistNum.setValue(RegistNum);}
    public String getRegistNum(){return this.RegistNum.getValue();}
    
    public Field TrademarkNum;
    public void setTrademarkNum(String TrademarkNum){this.TrademarkNum.setValue(TrademarkNum);}
    public String getTrademarkNum(){return this.TrademarkNum.getValue();}
    
    public Field TrademarkNo;
    public void setTrademarkNo(String TrademarkNo){this.TrademarkNo.setValue(TrademarkNo);}
    public String getTrademarkNo(){return this.TrademarkNo.getValue();}
    
    public Field ExpiryDate;
    public void setExpiryDate(String ExpiryDate){this.ExpiryDate.setValue(ExpiryDate);}
    public String getExpiryDate(){return this.ExpiryDate.getValue();}
    
    public Field ExtendDate;
    public void setExtendDate(String ExtendDate){this.ExtendDate.setValue(ExtendDate);}
    public String getExtendDate(){return this.ExtendDate.getValue();}
    
    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}
    
    public Field ClosedDate;
    public void setClosedDate(String ClosedDate){this.ClosedDate.setValue(ClosedDate);}
    public String getClosedDate(){return this.ClosedDate.getValue();}
    
    public Field TrademarkImg;
    public void setTrademarkImg(String TrademarkImg){this.TrademarkImg.setValue(TrademarkImg);}
    public String getTrademarkImg(){return this.TrademarkImg.getValue();}
    
    public Field Color;
    public void setColor(String Color){this.Color.setValue(Color);}
    public String getColor(){return this.Color.getValue();}
    
    public Field NoBelongDesc;
    public void setNoBelongDesc(String NoBelongDesc){this.NoBelongDesc.setValue(NoBelongDesc);}
    public String getNoBelongDesc(){return this.NoBelongDesc.getValue();}
    
    public Field ChtWordsinMark;
    public void setChtWordsinMark(String ChtWordsinMark){this.ChtWordsinMark.setValue(ChtWordsinMark);}
    public String getChtWordsinMark(){return this.ChtWordsinMark.getValue();}
    
    public Field EngWordsinMark;
    public void setEngWordsinMark(String EngWordsinMark){this.EngWordsinMark.setValue(EngWordsinMark);}
    public String getEngWordsinMark(){return this.EngWordsinMark.getValue();}
    
    public Field JapWordsinMark;
    public void setJapWordsinMark(String JapWordsinMark){this.JapWordsinMark.setValue(JapWordsinMark);}
    public String getJapWordsinMark(){return this.JapWordsinMark.getValue();}
    
    public Field Significance;
    public void setSignificance(String Significance){this.Significance.setValue(Significance);}
    public String getSignificance(){return this.Significance.getValue();}
    
    public Field GraphDesc;
    public void setGraphDesc(String GraphDesc){this.GraphDesc.setValue(GraphDesc);}
    public String getGraphDesc(){return this.GraphDesc.getValue();}
    
    public Field DesignMark;
    public void setDesignMark(String DesignMark){this.DesignMark.setValue(DesignMark);}
    public String getDesignMark(){return this.DesignMark.getValue();}
    
    public Field TabText;
    public void setTabText(String TabText){this.TabText.setValue(TabText);}
    public String getTabText(){return this.TabText.getValue();}
    
    public Field TrademarkCaseType;
    public void setTrademarkCaseType(String TrademarkCaseType){this.TrademarkCaseType.setValue(TrademarkCaseType);}
    public String getTrademarkCaseType(){return this.TrademarkCaseType.getValue();}
    
    public Field Client;
    public void setClient(String Client){this.Client.setValue(Client);}
    public String getClient(){return this.Client.getValue();}
    
    public Field ClientName;
    public void setClientName(String ClientName){this.ClientName.setValue(ClientName);}
    public String getClientName(){return this.ClientName.getValue();}
    
    public Field MarkType;
    public void setMarkType(String MarkType){this.MarkType.setValue(MarkType);}
    public String getMarkType(){return this.MarkType.getValue();}
    
    public Field ExpiryDateTo;
    public void setExpiryDateTo(String ExpiryDateTo){this.ExpiryDateTo.setValue(ExpiryDateTo);}
    public String getExpiryDateTo(){return this.ExpiryDateTo.getValue();}
    
    public Field OathDate;
    public void setOathDate(String OathDate){this.OathDate.setValue(OathDate);}
    public String getOathDate(){return this.OathDate.getValue();}
    
    public Field OathYear;
    public void setOathYear(String OathYear){this.OathYear.setValue(OathYear);}
    public String getOathYear(){return this.OathYear.getValue();}
    
    public Field TrademarkCaseStatus;
    public void setTrademarkCaseStatus(String TrademarkCaseStatus){this.TrademarkCaseStatus.setValue(TrademarkCaseStatus);}
    public String getTrademarkCaseStatus(){return this.TrademarkCaseStatus.getValue();}
    
    public Field TrademarkCaseCloseStatus;
    public void setTrademarkCaseCloseStatus(String TrademarkCaseCloseStatus){this.TrademarkCaseCloseStatus.setValue(TrademarkCaseCloseStatus);}
    public String getTrademarkCaseCloseStatus(){return this.TrademarkCaseCloseStatus.getValue();}
    
    public Field Sales;
    public void setSales(String Sales){this.Sales.setValue(Sales);}
    public String getSales(){return this.Sales.getValue();}
    
    public Field ExtendTime;
    public void setExtendTime(String ExtendTime){this.ExtendTime.setValue(ExtendTime);}
    public String getExtendTime(){return this.ExtendTime.getValue();}
    
    public Field IssueDate;
    public void setIssueDate(String IssueDate){this.IssueDate.setValue(IssueDate);}
    public String getIssueDate(){return this.IssueDate.getValue();}
    
    public Field IssueNo;
    public void setIssueNo(String IssueNo){this.IssueNo.setValue(IssueNo);}
    public String getIssueNo(){return this.IssueNo.getValue();}
    
    public Field TrademarkClassification;
    public void setTrademarkClassification(String TrademarkClassification){this.TrademarkClassification.setValue(TrademarkClassification);}
    public String getTrademarkClassification(){return this.TrademarkClassification.getValue();}
    
    public Field GoodsServices;
    public void setGoodsServices(String GoodsServices){this.GoodsServices.setValue(GoodsServices);}
    public String getGoodsServices(){return this.GoodsServices.getValue();}
      
    public Field GroupCode;
    public void setGroupCode(String GroupCode){this.GroupCode.setValue(GroupCode);}
    public String getGroupCode(){return this.GroupCode.getValue();}
    
    public Field ClientContect;
    public void setClientContect(String ClientContect){this.ClientContect.setValue(ClientContect);}
    public String getClientContect(){return this.ClientContect.getValue();}
    
    public Field LastSchedule;
    public void setLastSchedule(String LastSchedule){this.LastSchedule.setValue(LastSchedule);}
    public String getLastSchedule(){return this.LastSchedule.getValue();}
    
    public Field AttorneyNo;
    public void setAttorneyNo(String AttorneyNo){this.AttorneyNo.setValue(AttorneyNo);}
    public String getAttorneyNo(){return this.AttorneyNo.getValue();}
    
    public Field SerialMotherCase;
    public void setSerialMotherCase(String SerialMotherCase){this.SerialMotherCase.setValue(SerialMotherCase);}
    public String getSerialMotherCase(){return this.SerialMotherCase.getValue();}
    
    public Field PriorityCaseNo;
    public void setPriorityCaseNo(String PriorityCaseNo){this.PriorityCaseNo.setValue(PriorityCaseNo);}
    public String getPriorityCaseNo(){return this.PriorityCaseNo.getValue();}
    
    public Field Attorney;
    public void setAttorney(String Attorney){this.Attorney.setValue(Attorney);}
    public String getAttorney(){return this.Attorney.getValue();}
        
    public Field InternalNo;
    public void setInternalNo(String InternalNo){this.InternalNo.setValue(InternalNo);}
    public String getInternalNo(){return this.InternalNo.getValue();}
        
    public Field Remark;
    public void setRemark(String Remark){this.Remark.setValue(Remark);}
    public String getRemark(){return this.Remark.getValue();}
    
    public Field FromCase;
    public void setFromCase(String FromCase){this.FromCase.setValue(FromCase);}
    public String getFromCase(){return this.FromCase.getValue();}
    
    public Field ApplicantCopyCheck;
    public void setApplicantCopyCheck(String ApplicantCopyCheck){this.ApplicantCopyCheck.setValue(ApplicantCopyCheck);}
    public String getApplicantCopyCheck(){return this.ApplicantCopyCheck.getValue();}
    
    public Field AttorneyCopyCheck;
    public void setAttorneyCopyCheck(String AttorneyCopyCheck){this.AttorneyCopyCheck.setValue(AttorneyCopyCheck);}
    public String getAttorneyCopyCheck(){return this.AttorneyCopyCheck.getValue();}
    
    public Field PriorityCopyCheck;
    public void setPriorityCopyCheck(String PriorityCopyCheck){this.PriorityCopyCheck.setValue(PriorityCopyCheck);}
    public String getPriorityCopyCheck(){return this.PriorityCopyCheck.getValue();}
    
    private String oldCaseFlowKey;

	public String getOldCaseFlowKey() {
		return oldCaseFlowKey;
	}

	public void setOldCaseFlowKey(String oldCaseFlowKey) {
		this.oldCaseFlowKey = oldCaseFlowKey;
	}
    
    public Field PaymentConfirming;
    public void setPaymentConfirming(String PaymentConfirming){this.PaymentConfirming.setValue(PaymentConfirming);}
    public String getPaymentConfirming(){return this.PaymentConfirming.getValue();}
    
    public Field AutoPay;
    public void setAutoPay(String AutoPay){this.AutoPay.setValue(AutoPay);}
    public String getAutoPay(){return this.AutoPay.getValue();}
    
    public Field ServiceProjectCode;
    public void setServiceProjectCode(String ServiceProjectCode){this.ServiceProjectCode.setValue(ServiceProjectCode);}
    public String getServiceProjectCode(){return this.ServiceProjectCode.getValue();}
    
    public Field QuotationFlowKey;
    public void setQuotationFlowKey(String QuotationFlowKey){this.QuotationFlowKey.setValue(QuotationFlowKey);}
    public String getQuotationFlowKey(){return this.QuotationFlowKey.getValue();}
	
	public String financialFlag;

	public String getFinancialFlag() {
		return financialFlag;
	}

	public void setFinancialFlag(String financialFlag) {
		this.financialFlag = financialFlag;
	}
	
	public String changeInsertFlag;

	public String getChangeInsertFlag() {
		return changeInsertFlag;
	}

	public void setChangeInsertFlag(String changeInsertFlag) {
		this.changeInsertFlag = changeInsertFlag;
	}
    
    public Field CaseNo;
    public void setCaseNo(String CaseNo){this.CaseNo.setValue(CaseNo);}
    public String getCaseNo(){return this.CaseNo.getValue();}
    
    public Field CaseNo2;
    public void setCaseNo2(String CaseNo2){this.CaseNo2.setValue(CaseNo2);}
    public String getCaseNo2(){return this.CaseNo2.getValue();}
    
    public Field CaseAD;
    public void setCaseAD(String CaseAD){this.CaseAD.setValue(CaseAD);}
    public String getCaseAD(){return this.CaseAD.getValue();}
    
    public Field CaseApplicantNames;
    public void setCaseApplicantNames(String CaseApplicantNames){this.CaseApplicantNames.setValue(CaseApplicantNames);}
    public String getCaseApplicantNames(){return this.CaseApplicantNames.getValue();}
    
    public Field EnglishTitle;
    public void setEnglishTitle(String EnglishTitle){this.EnglishTitle.setValue(EnglishTitle);}
    public String getEnglishTitle(){return this.EnglishTitle.getValue();}
    
    public Field CaseAssignedTo;
    public void setCaseAssignedTo(String CaseAssignedTo){this.CaseAssignedTo.setValue(CaseAssignedTo);}
    public String getCaseAssignedTo(){return this.CaseAssignedTo.getValue();}
	
    public void init() {
        super.init();
        this.setProgramId("jsp.TrademarkCase");
        this.setTableName("TrademarkCase");
        
        CaseKind = "T";

        this.useFieldWidth = true;
        this.searchListMarkKeys = true;
        this.Referrals = new Field("Referrals", this.getTableName());
        this.Referrals.setDbType("varchar(50)");
        
        this.ContactDate = new Field("ContactDate", this.getTableName());
        this.ContactDate.setDbType("varchar(50)");
        
        this.CaseAssignedTo = new Field("CaseAssignedTo", this.getTableName());
        this.CaseAssignedTo.setDbType("varchar(50)");
        
        
        this.EnglishTitle = new Field("EnglishTitle", this.getTableName());
        this.EnglishTitle.setDbType("nvarchar(500)");
        this.EnglishTitle.setSearchCondition(Cnstnts.LIKE);
        
        this.CaseApplicantNames = new Field("CaseApplicantNames", this.getTableName());
        this.CaseApplicantNames.setDbType("varchar(50)");
        
        this.CaseAD = new Field("CaseAD", this.getTableName());
        this.CaseAD.setDbType("varchar(50)");
        
        this.CaseNo2 = new Field("CaseNo2", this.getTableName());
        this.CaseNo2.setDbType("varchar(50)");
        
        this.CaseNo = new Field("CaseNo", this.getTableName());
        this.CaseNo.setDbType("varchar(50)");
        
        this.SpecialRequest = new Field("SpecialRequest", this.getTableName());
        this.SpecialRequest.setDbType("varchar(500)");
        
        this.NoSDate = new Field("NoSDate", this.getTableName());
        this.NoSDate.setDbType("varchar(50)");
        
        this.TrademarkKind = new Field("TrademarkKind", this.getTableName());
        this.TrademarkKind.setDbType("varchar(50)");

        this.Matter = new Field("Matter", "ToDos");
        this.Matter.setDbType("varchar(50)");
        
        this.IsCharge = new Field("IsCharge","ToDos");
        this.IsCharge.setDbType("char(1)");
        
        this.IsPayment = new Field("IsPayment","ToDos");
        this.IsPayment.setDbType("char(1)");
        
        this.ToDosStatus = new Field("ToDosStatus", "ToDos");
        this.ToDosStatus.setDbType("varchar(50)");
        
        this.FlowKey.setSearchCondition(Cnstnts.LIKE);

        this.Office = new Field("Office", this.getTableName());
        this.Office.setDbType("varchar(50)");
        this.Office.setCheckEmpty(true);
        
        this.TrademarkType = new Field("TrademarkType", this.getTableName());
        this.TrademarkType.setDbType("varchar(50)");
        this.TrademarkType.setCheckEmpty(true);

        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("nvarchar(500)");
        this.Title.setCheckEmpty(true);
        this.Title.setSearchCondition(Cnstnts.LIKE);
        
        this.AttorneyDate = new Field("AttorneyDate", this.getTableName());
        this.AttorneyDate.setDbType("varchar(10)");
        
        this.AttorneyNum = new Field("AttorneyNum", this.getTableName());
        this.AttorneyNum.setDbType("varchar(50)");
        
        this.FillingDate = new Field("FillingDate", this.getTableName());
        this.FillingDate.setDbType("varchar(10)");
        
        this.FillingNum = new Field("FillingNum", this.getTableName());
        this.FillingNum.setDbType("varchar(50)");
        
        this.PublicationDate = new Field("PublicationDate", this.getTableName());
        this.PublicationDate.setDbType("nvarchar(10)");
        
        this.PublicationNum = new Field("PublicationNum", this.getTableName());
        this.PublicationNum.setDbType("nvarchar(50)");
        
        this.RegistDate = new Field("RegistDate", this.getTableName());
        this.RegistDate.setDbType("nvarchar(10)");
        
        this.RegistNum = new Field("RegistNum", this.getTableName());
        this.RegistNum.setDbType("nvarchar(50)");        
        
        this.TrademarkNum = new Field("TrademarkNum", this.getTableName());
        this.TrademarkNum.setDbType("nvarchar(50)");

        this.TrademarkNo = new Field("TrademarkNo", this.getTableName());
        this.TrademarkNo.setDbType("varchar(50)");
        
        this.ExpiryDate = new Field("ExpiryDate", this.getTableName());
        this.ExpiryDate.setDbType("nvarchar(10)");
        
        this.ExtendDate = new Field("ExtendDate", this.getTableName());
        this.ExtendDate.setDbType("nvarchar(10)");

        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");

        this.ClosedDate = new Field("ClosedDate", this.getTableName());
        this.ClosedDate.setDbType("nvarchar(10)");
        
        this.TrademarkImg = new Field("TrademarkImg", this.getTableName());
        this.TrademarkImg.setDbType("nvarchar(100)");
        this.TrademarkImg.setIsShowImage(true);
        
        this.Color = new Field("Color", this.getTableName());
        this.Color.setDbType("nvarchar(50)");
        
        this.NoBelongDesc = new Field("NoBelongDesc", this.getTableName());
        this.NoBelongDesc.setDbType("nvarchar(500)");
        
        this.ChtWordsinMark = new Field("ChtWordsinMark", this.getTableName());
        this.ChtWordsinMark.setDbType("nvarchar(500)");
        
        this.EngWordsinMark = new Field("EngWordsinMark", this.getTableName());
        this.EngWordsinMark.setDbType("nvarchar(500)");
        
        this.JapWordsinMark = new Field("JapWordsinMark", this.getTableName());
        this.JapWordsinMark.setDbType("nvarchar(500)");
        
        this.Significance = new Field("Significance", this.getTableName());
        this.Significance.setDbType("nvarchar(500)");
        
        this.GraphDesc = new Field("GraphDesc", this.getTableName());
        this.GraphDesc.setDbType("nvarchar(500)");
        
        this.DesignMark = new Field("DesignMark", this.getTableName());
        this.DesignMark.setDbType("nvarchar(100)");
        
        this.TabText = new Field("TabText", this.getTableName());
        
        this.TrademarkCaseType = new Field("TrademarkCaseType", this.getTableName());
        this.TrademarkCaseType.setDbType("varchar(50)");
//        this.TrademarkCaseType.setCheckEmpty(true);
        
        this.Client = new Field("Client", this.getTableName());
        this.Client.setDbType("varchar(50)");
        this.Client.setCheckEmpty(true);
        this.Client.setSearchCondition(Cnstnts.LIKE);
        
        this.ClientName = new Field("ClientName", this.getTableName());
        this.ClientName.setSearchCondition(Cnstnts.LIKE);
        
        this.MarkType = new Field("MarkType", this.getTableName());
        this.MarkType.setDbType("varchar(50)");
        
        this.ExpiryDateTo = new Field("ExpiryDateTo", this.getTableName());
        this.ExpiryDateTo.setDbType("varchar(10)");
        
        this.OathDate = new Field("OathDate", this.getTableName());
        this.OathDate.setDbType("varchar(10)");
        
        this.OathYear = new Field("OathYear", this.getTableName());
        this.OathYear.setDbType("varchar(50)");
        
        this.TrademarkCaseStatus = new Field("TrademarkCaseStatus", this.getTableName());
        this.TrademarkCaseStatus.setDbType("varchar(50)");
        
        this.TrademarkCaseCloseStatus = new Field("TrademarkCaseCloseStatus", this.getTableName());
        this.TrademarkCaseCloseStatus.setDbType("varchar(50)");
        
        this.Sales = new Field("Sales", this.getTableName());
        this.Sales.setDbType("varchar(50)");
        this.Sales.setCheckEmpty(true);
        
        this.ExtendTime = new Field("ExtendTime", this.getTableName());
        this.ExtendTime.setDbType("varchar(10)");
        
        this.IssueDate = new Field("IssueDate", this.getTableName());
        this.IssueDate.setDbType("nvarchar(10)");
        
        this.IssueNo = new Field("IssueNo", this.getTableName());
        this.IssueNo.setDbType("nvarchar(50)");
        
        this.TrademarkClassification = new Field("TrademarkClassification", this.getTableName());
        this.TrademarkClassification.setDbType("nvarchar(500)");
        
        this.GoodsServices = new Field("GoodsServices", this.getTableName());
        this.GoodsServices.setDbType("nvarchar(500)");
        
        this.GroupCode = new Field("GroupCode", this.getTableName());
        this.GroupCode.setDbType("nvarchar(500)");
//        this.GroupCode.setCheckEmpty(true);
        
        this.ClientContect = new Field("ClientContect", this.getTableName());
        this.ClientContect.setDbType("varchar(50)");
                
        this.LastSchedule = new Field("LastSchedule", this.getTableName());
        this.LastSchedule.setDbType("varchar(200)");
        
        this.AttorneyNo = new Field("AttorneyNo", this.getTableName());
        this.AttorneyNo.setDbType("varchar(50)");
        

        this.SerialMotherCase = new Field("SerialMotherCase", this.getTableName());
        this.SerialMotherCase.setDbType("varchar(50)");
//        this.SerialMotherCase.setCheckEmpty(true);
        
        this.PriorityCaseNo = new Field("PriorityCaseNo", this.getTableName());
        this.PriorityCaseNo.setDbType("varchar(50)");
        
        this.Attorney = new Field("Attorney", this.getTableName());
        this.Attorney.setDbType("varchar(50)");
        
        this.InternalNo = new Field("InternalNo", this.getTableName());
        this.InternalNo.setDbType("varchar(50)");
        
        this.Remark = new Field("Remark", this.getTableName());
        this.Remark.setDbType("varchar(500)");
        
        this.PaymentConfirming = new Field("PaymentConfirming", this.getTableName());
        this.PaymentConfirming.setDbType("varchar(1)");
        
        this.AutoPay = new Field("AutoPay", this.getTableName());
        this.AutoPay.setDbType("varchar(1)");
        
        this.ServiceProjectCode = new Field("ServiceProjectCode", this.getTableName());
        this.ServiceProjectCode.setDbType("varchar(50)");
        
        this.FromCase = new Field("FromCase", this.getTableName());
        this.FromCase.setDbType("varchar(50)");
        
        this.ApplicantCopyCheck = new Field("ApplicantCopyCheck", this.getTableName());
        this.ApplicantCopyCheck.setDbType("varchar(50)");
        
        this.AttorneyCopyCheck = new Field("AttorneyCopyCheck", this.getTableName());
        this.AttorneyCopyCheck.setDbType("varchar(50)");
        
        this.PriorityCopyCheck = new Field("PriorityCopyCheck", this.getTableName());
        this.PriorityCopyCheck.setDbType("varchar(50)");
        
        this.ServiceProjectCode = new Field("ServiceProjectCode", this.getTableName());
        this.ServiceProjectCode.setDbType("varchar(50)");
        
        this.QuotationFlowKey = new Field("QuotationFlowKey", this.getTableName());
        this.QuotationFlowKey.setDbType("varchar(50)");
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

	public void setDbFields() {
        super.setDbFields();
        
        this.DbFields.add(this.NoSDate);
        
        this.DbFields.add(this.SpecialRequest);
        
        this.DbFields.add(this.TrademarkKind);
        this.DbFields.add(this.CaseAssignedTo);
        this.DbFields.add(this.EnglishTitle);

        this.DbFields.add(this.CaseNo);
        this.DbFields.add(this.CaseAD);
        this.DbFields.add(this.CaseNo2);
        this.DbFields.add(this.ServiceProjectCode);
        this.DbFields.add(this.Remark);
        this.DbFields.add(this.ClientContect);
        this.DbFields.add(this.Office);
        this.DbFields.add(this.TrademarkType);
        this.DbFields.add(this.TrademarkCaseType);
        this.DbFields.add(this.Title);
        this.DbFields.add(this.AttorneyDate);
        this.DbFields.add(this.AttorneyNum);
        this.DbFields.add(this.FillingDate);
        this.DbFields.add(this.FillingNum);
        this.DbFields.add(this.PublicationDate);
        this.DbFields.add(this.PublicationNum);
        this.DbFields.add(this.RegistDate);
        this.DbFields.add(this.RegistNum);
        this.DbFields.add(this.TrademarkNum);
        this.DbFields.add(this.TrademarkNo);
        this.DbFields.add(this.ExpiryDate);
        this.DbFields.add(this.ExtendDate);
        this.DbFields.add(this.Status);        
        this.DbFields.add(this.ClosedDate);
        this.DbFields.add(this.TrademarkImg);
        this.DbFields.add(this.Color);
        this.DbFields.add(this.NoBelongDesc);
        this.DbFields.add(this.ChtWordsinMark);
        this.DbFields.add(this.EngWordsinMark);
        this.DbFields.add(this.JapWordsinMark);
        this.DbFields.add(this.Significance);
        this.DbFields.add(this.GraphDesc);
        this.DbFields.add(this.DesignMark);
        this.DbFields.add(this.Client);
        this.DbFields.add(this.MarkType);
        this.DbFields.add(this.ExpiryDateTo);
        this.DbFields.add(this.OathDate);
        this.DbFields.add(this.OathYear);
        this.DbFields.add(this.TrademarkCaseStatus);
        this.DbFields.add(this.TrademarkCaseCloseStatus);
        this.DbFields.add(this.Sales);
        this.DbFields.add(this.ExtendTime);
        this.DbFields.add(this.IssueDate);
        this.DbFields.add(this.IssueNo);
        this.DbFields.add(this.TrademarkClassification);
        this.DbFields.add(this.GoodsServices);
        this.DbFields.add(this.GroupCode);
        this.DbFields.add(this.LastSchedule);
        this.DbFields.add(this.AttorneyNo);
        this.DbFields.add(this.SerialMotherCase);
        this.DbFields.add(this.PriorityCaseNo);
        this.DbFields.add(this.Attorney);
        this.DbFields.add(this.InternalNo);
        
        this.DbFields.add(this.PaymentConfirming);
        this.DbFields.add(this.AutoPay);
        
        this.DbFields.add(this.FromCase);
        this.DbFields.add(this.QuotationFlowKey);
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

//		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())){
//			String onChange = "setValue()";
//			SelectOneTag selectItem = new SelectOneTag(Cnstnts.DB_ACTION_MODE,
//					onChange, this.getDbActionMode(), this.getDbActionList());
//
//			rtnString = selectItem.toString();
//		}
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())){
//			String onChange = "setValue()";
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
	
	public String printHtmlBody() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine + "<table id='bodyTable' " + getTableBgcolor() + ">";
		
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
			rtnString += "<input type='hidden' name='dbActionMode' id='dbActionMode' value='" + this.getDbActionMode() + "'>";
			rtnString += "<tr><td colspan='3' width='75%'><table width='100%'>";
			rtnString += this.printMaintainTable();
			//新增代表圖示上方基本欄位處, 上載後，可呈現縮圖，目前版面有點滿，
            //排版要重排將目前兩欄的欄位整個往左移出空間讓縮圖呈現在右邊。
            rtnString += Cnstnts.NEW_LINE + "</table></td><td width='25%' bgcolor='#E9EDF4'><table width='100%'>";
			rtnString += this.printUploadImageHtml();
            rtnString += Cnstnts.NEW_LINE + "</table></td></tr>";
            
            rtnString += "<tr width='100%' align='right'><td colspan='4'>";
            if(!this.getDbActionMode().equals(Cnstnts.PRINT)) {
            	rtnString += this.getSubmitBtn();
            }
			rtnString += Cnstnts.NEW_LINE + "</td></tr>";
            
           
            rtnString += this.printTabAreaHtml();
		}
		rtnString += newLine + "</table>";
		 
		if (this.onSearchMode()) {
//			this.setResultFields();
			rtnString += this.printSearchReasult();
		}
		return rtnString;
	}
    
    public String printHiddenTags(){
    	String rtnString = super.printHiddenTags();
    	HashMap<String,String> hm = new HashMap<String,String>();
    	hm.put("entity",Cnstnts.EMPTY_STRING);
    	hm.put("changeInsertFlag", this.getChangeInsertFlag());
  	  	rtnString += new HiddenTag().print(hm);
  	  	return rtnString;
    }
	
	public String printUploadImageHtml() throws Exception {
    	String rtnString = "";
    	if(this.onMaintainMode()) {
    		this.TrademarkImg.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
    		this.TrademarkImg.setSize(25);
    		rtnString += this.printHtml(this.TrademarkImg);

    		if(!Util.isEmpty(this.TrademarkImg.getValue())) {
    			rtnString += "<tr><td colspan='4'><img src='" + this.TrademarkImg.getValue() + "' width='260' height='195'></td></tr>";
    		}
    		else {
    			rtnString += "<tr><td></td></tr>";
    		}
    	}
    	return rtnString;
    }
	
	public String printTabAreaHtml() throws Exception {
		String rtnString = "";
		if(this.FlowKey.getValue().trim().length()>0){
        	
        	//[下午 04:27:55] Ray Chu: 如果客戶想要PatentCase裡面的期限管制如果有未完成的事項的話，
            //進入到該案後，代辦事項的按鈕的字會呈現紅色&（未完成件數）
            String countSql = "SELECT count(1) as count  FROM todos  WHERE toDosStatus != 'TDS02' and  ParentId LIKE '" + this.getFlowKey() + "'";
            DbUtil dbUtil = new DbUtil();
            String count = dbUtil.getFieldValue(countSql, new Field("count"));
            
            String TabSelect = Cnstnts.EMPTY_STRING;
            rtnString += "<script type='text/javascript'>createTrademarkTabs1();</script>";
        	rtnString += "<script type='text/javascript'>$(function(){$('#tabs2').tabs(" +TabSelect + ");});</script>";
        	
        	rtnString += "<tr><td colspan=4>"+
					"<div id='tabs'><ul>"+
					"<li><a href='#tabs-1'>"+this.getUserInfo().getMsg("jsp.TrademarkCase.TrademarkSecondPage")+"</a></li>";
        	rtnString += "<li><a href='#tabs-6'>"+this.getUserInfo().getMsg("jsp.TrademarkDocument.title")+"</a></li>";
        	if(count.equals("0")) {
				rtnString += "<li><a href='#tabs-7'>"+this.getUserInfo().getMsg("jsp.ToDos.title")+"</a></li>";
			}
			else {
				rtnString += "<li><a href='#tabs-7'><font color='red'>" + this.getUserInfo().getMsg("jsp.ToDos.title") + 
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
        	rtnString += "<li><a href='#tabs-2'>"+this.getUserInfo().getMsg("jsp.TrademarkApplicant.title")+"</a></li>";
//			rtnString += "<li><a href='#tabs-3'>"+this.getUserInfo().getMsg("jsp.TrademarkInventor.title")+"</a></li>";
			rtnString += "<li><a href='#tabs-5'>"+this.getUserInfo().getMsg("jsp.TrademarkAttorney.title")+"</a></li>";

        	//優先權tab若有key資料，頁籤上的"優先權"變紅字
        	countSql = "SELECT count(1) as count  FROM TrademarkPriority WHERE  ParentId = '" + this.getFlowKey() + "'";
        	int countInt = this.getDbUtil().getSqlIntValue(countSql, "count");
        	if(countInt > 0) {
        		rtnString +="<li><a href='#tabs-4'><font color='red'>"+this.getUserInfo().getMsg("jsp.TrademarkPriority.title")+"</font></a></li>";
        	}
        	else {
        		rtnString +="<li><a href='#tabs-4'>"+this.getUserInfo().getMsg("jsp.TrademarkPriority.title")+"</a></li>";
        	}
			
			rtnString += "<li><a href='#tabs-8'>"+this.getUserInfo().getMsg("jsp.TrademarkCase.RenewalLogTab.title")+"</a></li>";

        	Groups group = new Groups();
        	//關聯訂單tab調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
			if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
					!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
					!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
			rtnString += "<li><a href='#tabs-c6'>"+ this.getUserInfo().getMsg("jsp.Quotation.Tab3") + "</a></li>";
			}
			rtnString += "<li><a href='#tabs-sm'>"+ this.getUserInfo().getMsg("jsp.SignedManage.ReleatedSigned") + "</a></li>";

        	//20170802 for plusproject tmMonitor function
        	String canShowTmMonitor = "true";
        	if(Util.compareTo(this.getOffice(), "TW")){
        		if(canShowTmMonitor.equals(this.getUserInfo().getAttribute("showTmMonitor"))){
        			rtnString += "<li><a href='#tabs-10'>"+this.getUserInfo().getMsg("jsp.TrademarkMonitor.title")+"</a></li>";
        			rtnString += "<li><a href='#tabs-11' onClick='reloadFrame(\"TrademarkMonitorListFrame\")'>"+this.getUserInfo().getMsg("jsp.TrademarkMonitorList.title")+"</a></li>";
        		}
        	}
        	
			
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

            /**** tabs-2 ****/
        	rtnString +="<div id='tabs-2'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0>";
            rtnString +="<tr><td align=left>";
            rtnString +="<input type='button' value='" + 
            				this.getUserInfo().getMsg("jsp.PatentInventor.InsertToApplicantBtn") +
            				"' onclick='openAppendix(\"QueryCheckForm.jsp?queryClass=TrademarkApplicant2&_queryText2=" + this.getClient() +
            				"&QueryText4=" + this.getClient() +"&QueryText5=" + this.getFlowKey() + "\",\"Applicants\",800,600)'>";
            rtnString +="<input type='button' value='" + this.getUserInfo().getMsg("jsp.PatentInventor.CopyOrderBtn") + "' onclick='openAppendix(\"OrderSortableForm.jsp?queryClass=TrademarkApplicant&QueryText5=" + this.getFlowKey() + "\",\"TrademarkApplicant\",800,600)'>";
            rtnString +="</td></tr>";
            rtnString +="<tr><td valign=top>";
            rtnString +="<div id='updateTrademarkApplicantDiv' name='updateTrademarkApplicantDiv'></div>";
            rtnString +="<div id='TrademarkApplicantDiv' name='TrademarkApplicantDiv'>";
            //rtnString += new TrademarkApplicant().getSearchReasult(this.getUserInfo(),this.getFlowKey());
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-2 end ****/

            /**** tabs-3 ****/
//        	rtnString +="<div id='tabs-3'>";
//            rtnString +="<div class='indent'>";
//            rtnString +="<table width=95% border=0><tr><td valign=top>";
//            rtnString +="<div id='updateTrademarkInventorDiv' name='updateTrademarkInventorDiv'></div>";
//            rtnString +="<div id='TrademarkInventorDiv' name='TrademarkInventorDiv'>";
//            rtnString += new TrademarkInventor().getSearchReasult(this.getUserInfo(),this.getFlowKey());
//            
//            rtnString +="</div></td></tr></table>";
//            rtnString +="</div>";
//            rtnString +="</div>";
            /**** tabs-3 end ****/

            /**** tabs-4 ****/
        	rtnString +="<div id='tabs-4'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateTrademarkPriorityDiv' name='updateTrademarkPriorityDiv'></div>";
            rtnString +="<div id='TrademarkPriorityDiv' name='TrademarkPriorityDiv'>";
//            rtnString += new TrademarkPriority().getSearchReasult(this.getUserInfo(),this.getFlowKey());
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-4 end ****/

            /**** tabs-5 ****/
        	rtnString +="<div id='tabs-5'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateTrademarkAttorneyDiv' name='updateTrademarkAttorneyDiv'></div>";
            rtnString +="<div id='TrademarkAttorneyDiv' name='TrademarkAttorneyDiv'>";
//            rtnString += new TrademarkAttorney().getSearchReasult(this.getUserInfo(),this.getFlowKey());
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-5 end ****/

            /**** tabs-6 ****/
        	rtnString +="<div id='tabs-6'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateTrademarkDocumentDiv' name='updateTrademarkDocumentDiv'></div>";
            rtnString +="<div id='TrademarkDocumentDiv' name='TrademarkDocumentDiv'>";
//            rtnString += new TrademarkDocument().getSearchReasult(this.getUserInfo(),this.getFlowKey());
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-6 end ****/

            /**** tabs-7 ****/
            /*
             * 2013/1/8
             * "已請款台幣總金額  - 已收款台幣總金額 – 他方扣繳台幣總額(資料來源：Invoice.TotalWithHolding)  = 未收款台幣總金額"
             */
            String count1 = "";
            String count2 = "";
            String count3 = "";
            String count4 = "";
//            DecimalFormat df = new DecimalFormat("###,###");
//            
//            String SQL = "select sum(requestPayAmount) as Count from todos where parentid ='" + this.getFlowKey() + "'";
//            count1 = this.getDbUtil().getFieldValue(SQL, "Count");
//            
//            SQL = "select sum(AlreadyWriteOffAmount) as Count from invoicedetail where todosid in (select flowkey from todos where parentid ='" + this.getFlowKey() + "')";
//            count2 = this.getDbUtil().getFieldValue(SQL, "Count");
//            
//            String sql = "select sum(Tax2) as Count from invoicedetail " +
//            		"where todosid in (select flowkey from todos where parentid ='" + this.getFlowKey() + "') " +
//            		"and WithHolding='Y'";
//            count4 = this.getDbUtil().getFieldValue(sql, "Count");
//            
//            double requestPayAmount = 0;
//            if(count1 != null && count1.trim().length()> 0){
//            	requestPayAmount = Double.parseDouble(count1);
//            	count1 = df.format(Double.parseDouble(count1))+"";
//            }else{
//            	count1 = "0";
//            }
//            double receiveNtdAmount = 0;
//            if(count2 != null && count2.trim().length() >0){
//            	receiveNtdAmount = Double.parseDouble(count2);
//            	count2 = df.format(Double.parseDouble(count2))+"";
//            }else{
//            	count2 = "0";
//            }
//            double TotalWithHolding = 0;
//            if(count4 != null && count4.trim().length() >0){
//            	TotalWithHolding = Double.parseDouble(count4);
//            	count4 = df.format(Double.parseDouble(count4))+"";
//            }else{
//            	count4 = "0";
//            }
//            count3 =  df.format((int)(requestPayAmount - receiveNtdAmount - TotalWithHolding)) + "";
        	rtnString +="<div id='tabs-7'>";
        	rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
//            rtnString +="<tr>";
//            rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.RequestPayNtdAmount") + " : " + count1 + "</td>";
//            rtnString +="<td align='center'>-</td>";
//            rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.ReceiveNtdAmount") + " : " +  count2 + "</td>";
//            rtnString +="<td align='center'>-</td>";
//            rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.TotalWithHolding") + " : " +  count4 + "</td>";
//            rtnString +="<td align='center'>=</td>";
//            rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.NotYetReceiveNtdAmount") + " : " +  count3 + "</td>";
//            rtnString +="</tr>";
            /*
以子tab按鈕方式區分為兩tab：程序代辦(收費或付費項目無勾選的代辦事項) 與 財務代辦(收費或付費項目有勾選的代辦事項)，代辦儲存後即依據前述規則呈現在相應tab，在tab下仍可打開編輯。
             */
            /*
    		 * 代辦事項tab列表上方新增過濾（搜尋）欄位條件，案件性質、狀態、□收費項目、□付費項目（若未勾選則預設為非Y去搜尋）
    		 */
    		String tr = "<tr><td valign=top colspan='12'>";
    		
    		if(this.getDbActionMode().equals(Cnstnts.UPDATE)) {
    			String rtnString2 = "";/*
    			 * 2013/8/2 simon
1.四個案件的代辦事項分頁，點選批次新增時，出現的搜尋畫面直接跳到 標準期限設定sop的搜尋列表，且過濾預設只搜尋“非收付費項目沒有勾的”
    			 */
    			/*
    			 *  帶入資料
    			 *  若是QuotationFlowKey存在，就抓該案件報價單的報價資料
    			 *  不然就抓取同客戶同類別的報價來顯示
    			 *  在不行就改顯示sop畫面
    			 */
//    			sql = "select count(1) as count from Quotation_detail " +
//    					"where parentid in ( " +
//    					"select flowkey from quotation where Client = '" + this.getClient() + "' and PatentType ='" + this.getTrademarkType() + "' " +
//    					")";
//    			int count9 = this.getDbUtil().getSqlIntValue(sql, "count");
//
//    			if(!Util.isEmpty(this.getQuotationFlowKey())) {
//    				rtnString2 = "<input type='button' "
//    						+ "value='" + this.getUserInfo().getMsg("jsp.ToDosQuery.MultiInsertBtn") + "' "
//    						+ "onclick='openAppendix(\"Quotation_detail.jsp?_pageActionMode=maintain&documentIn=true&parentId="
//    						+ this.getFlowKey() + "&documentType=T&quotationFlowKey=" + this.getQuotationFlowKey() + "\",\"QueryTodos\",800,600)'/>";
//    			}
//    			else if(count9 > 0) {
//    				rtnString2 = "<input type='button' "
//    						+ "value='" + this.getUserInfo().getMsg("jsp.ToDosQuery.MultiInsertBtn") + "' "
//    						+ "onclick='openAppendix(\"Quotation_detail.jsp?_pageActionMode=maintain&documentIn=true&parentId="
//    						+ this.getFlowKey() + "&documentType=T" +
//    						"&client=" + this.getClient() + "" +
//    						"&patentType=" + this.getTrademarkType() + "" +
//    						"\",\"QueryTodos\",800,600)'/>";
//    			}
//    			else {
    				rtnString2 = "<input type='button' "
    					+ "value='" + this.getUserInfo().getMsg("jsp.ToDosQuery.MultiInsertBtn") + "' "
    					+ "onclick='openAppendix(\"StandardTask.jsp?_pageActionMode=search&doSearchFlag=true&_dbActionMode=query" +
    							"&documentIn=true&parentId=" + this.getFlowKey() + 
    							"&documentType=T&caseKind=STC02\",\"QueryTodos\",800,600)'/>";
//    			}
    			tr += rtnString2;
    			tr += "　　";
    		}
    		
//    		tr += this.getUserInfo().getMsg("jsp.ToDos.DataChange") + ":";
//    		tr += "<input type=\"button\" id='FinancialToDosTabBtn' value=\"" + this.getUserInfo().getMsg("jsp.ToDos.FinancialToDosTab") + "\" onclick=\"showHideTodosDiv('TrademarkToDosDiv', 'TrademarkToDosDiv2')\">";
//    		tr += "<input type=\"button\" id='MatterToDosTabBt' value=\"" + this.getUserInfo().getMsg("jsp.ToDos.MatterToDosTab") + "\" onclick=\"showHideTodosDiv('TrademarkToDosDiv2', 'TrademarkToDosDiv')\">";
            
    		tr += "　　";
    		
    		
    		String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig " +
            		"where casekind ='STC02' " +
            		"and patentoffice like '%" + this.getOffice() + ",%' " +
            		"and patenttype like '%" + this.getTrademarkType() + ",%' " +
            		"order by flowkey";
    		//List<SelectItem> items = this.getDbUtil().getSelectItemList(sql, "MatterName");
            List<SelectItem> items = Util.findCasePatentMatterConfig(this.getDbUtil(), "STC02", 
            		this.getOffice(), this.getTrademarkType());
            this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Matter.setSelectList(items);
            this.Matter.setCanEdit(true);
            tr += getAlias(this.Matter) + Html.printTag(this.Matter, this.getUserInfo());

            this.ToDosStatus.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.ToDosStatus.setSelectList(new Category().getChildList(this.ToDosStatus));
        	this.ToDosStatus.setCanEdit(true);
            tr += getAlias(this.ToDosStatus) + Html.printTag(this.ToDosStatus, this.getUserInfo());
        	
//            this.IsPayment.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
//        	this.IsPayment.setCanEdit(true);
//        	this.IsPayment.setAfterText("　　");
//            tr += getAlias(this.IsPayment) + Html.printTag(this.IsPayment, this.getUserInfo());
//            
//            this.IsCharge.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
//        	this.IsCharge.setCanEdit(true);
//            tr += getAlias(this.IsCharge) + Html.printTag(this.IsCharge, this.getUserInfo());
            tr += "<input type='hidden' name='isPayment' id='isPayment' value=''>";
            tr += "<input type='hidden' name='isCharge' id='isCharge' value=''>";
            
            if(Util.isEmpty(this.getFinancialFlag())) {
            	this.setFinancialFlag("Y");
            }
            tr += "<input type='hidden' name='financialFlag' id='financialFlag' value='" + this.getFinancialFlag() + "'>";
            
            
            tr += "<input type=\"button\" value=\"搜尋\" onclick=\"searchTodos('TrademarkCase','TrademarkToDos')\">";
            tr += "<input type=\"button\" value=\"清空\" onclick=\"searchTodos2('TrademarkCase','TrademarkToDos')\">";
            tr += "</td></tr>";
            
            rtnString += tr;
            
            rtnString +="<tr><td valign=top colspan='12'>";
            rtnString +="<div id='updateTrademarkToDosDiv' name='updateTrademarkToDosDiv'></div>";
            rtnString +="<div id='TrademarkToDosDiv' name='TrademarkToDosDiv'>";
//            rtnString += new TrademarkToDos().getSearchReasult(this.getUserInfo(),this.getFlowKey());
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            
            rtnString += "<script>showHideTodosDiv('TrademarkToDosDiv2', 'TrademarkToDosDiv');</script>";
            /**** tabs-7 end ****/
            

            
            /**** tabs-8 ****/
            count1 = "";
        	count2 = "";
        	count3 = "";
        	count4 = "";
        	//String count5 = "";
        	String SQL = "select sum(%s) as Count from RenewalLog where ParentId ='" + this.getFlowKey() + "' and KeepMaintain='Y'";
        	//String SQL2 = "select sum(NtdPtoFee+NtdServiceFee+NtdAttorneyFee+NtdOtherFee) as Count from RenewalLog  where ParentId ='" + this.getFlowKey() + "'";
        	count1 = this.getDbUtil().getFieldValue(String.format(SQL, "NtdPtoFee"), "Count");
        	count2 = this.getDbUtil().getFieldValue(String.format(SQL, "NtdServiceFee"), "Count");
        	count3 = this.getDbUtil().getFieldValue(String.format(SQL, "NtdAttorneyFee"), "Count");
        	count4 = this.getDbUtil().getFieldValue(String.format(SQL, "NtdOtherFee"), "Count");
        	//count5 = this.getDbUtil().getFieldValue(SQL2, "Count");
        	
        	rtnString +="<div id='tabs-8'>";
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
//	        rtnString += printCaseRenewalLogListTableHtml();
	        
            rtnString +="</div></td></tr>";
            rtnString +="</table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-8 end ****/
            
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
//	            rtnString += new CasePrivilege().getSearchReasult(this.getUserInfo(), this.getFlowKey(), this.getCaseKind(), "E");
	            
	            rtnString +="</div></td></tr></table>";
	            
	            rtnString +="<br/>";
	            
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updateCasePrivilege2Div' name='updateCasePrivilege2Div'></div>";
	            rtnString +="<div id='CasePrivilege2Div' name='CasePrivilege2Div'>";
//	            rtnString += new CasePrivilege().getSearchReasult(this.getUserInfo(), this.getFlowKey(), this.getCaseKind(), "D");
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
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
//			rtnString += new SalesOrder().printAjaxCaseSalesOrderTable(this.getUserInfo(), this.getFlowKey(), canAssesFlag);

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
            
			
			
			
			

			
        	//20170802 for plusproject tmMonitor function
			if(Util.compareTo(this.getOffice(), "TW")){
				if(canShowTmMonitor.equals(this.getUserInfo().getAttribute("showTmMonitor"))){
					
					/**** tabs-10 ****/
					rtnString += "<div id='tabs-10'>";
					rtnString += "<div class='indent'>";
					rtnString += "<table width=100% border=0><tr><td valign=top>";
					
					//rtnString += "<iframe src=\"TrademarkMonitor.jsp?tmarkName="+this.getTitle()+"&caseNo="+this.getCaseNo()+"&preLoad=true\" width=\"100%\" height=\"400px\" frameborder=\"0\" scrolling=\"auto\"></iframe>";
					rtnString += "<iframe id=\"TrademarkMonitorFrame\" src=\"\" width=\"100%\" height=\"400px\" frameborder=\"0\" scrolling=\"auto\"></iframe>";
					
					rtnString += "</td></tr></table>";
					rtnString += "</div>";
					rtnString += "</div>";
					/**** tabs-10 end ****/
					
					/**** tabs-11 ****/
					rtnString += "<div id='tabs-11'>";
					rtnString += "<div class='indent'>";
					rtnString += "<table width=100% border=0><tr><td valign=top>";
					
					rtnString += "<iframe id=\"TrademarkMonitorListFrame\" src=\"TrademarkMonitorList.jsp?caseNo="+this.getCaseNo()+"\" width=\"100%\" height=\"400px\" frameborder=\"0\" scrolling=\"auto\"></iframe>";
					
					rtnString += "</td></tr></table>";
					rtnString += "</div>";
					rtnString += "</div>";
					/**** tabs-11 end ****/
				}
			}
			
			
			
            rtnString += "</div>";
            
            
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
					    "  doPatentCaseAjaxRequest('TrademarkCase',newTabText,'"+this.getFlowKey()+"',DataDiv,'innerHTML')"+
					    "}";
            if(Util.compareTo(this.getOffice(), "TW")){
            	if(canShowTmMonitor.equals(this.getUserInfo().getAttribute("showTmMonitor"))){
            		scriptText += "function reloadFrame(ifrmname){"+
            				"document.getElementById(ifrmname).contentWindow.location.reload();"+
            				"}";
            		
            		scriptText += " var urlValue = encodeURI(encodeURI(\"TrademarkMonitor.jsp?tmarkName="+this.getTitle()+"&caseNo="+this.getCaseNo()+"&preLoad=true\"));";
            		scriptText += " console.log(urlValue);";
            		scriptText += " $('#TrademarkMonitorFrame').attr('src',urlValue);";
            	}
            }
            scriptText += "</script>";
            rtnString += scriptText;
            rtnString += "</td></tr>";
	
        }
		
		return rtnString;
	}

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	resetFieldData("cond1", getCond1(), getFullSearchText1());
        	resetFieldData("cond2", getCond2(), getFullSearchText2());
        	resetFieldData("cond11", getCond11(), getFullSearchText11());
        	
        	String sql = "select FlowKey, Names from applicant where ShowInClient ='Y' and ApplicantKind like '%CLK01;%' ";
            this.ClientContect.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.ClientContect.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("Names", ""), false));
            
        	this.TrademarkCaseType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.TrademarkCaseType.setSelectList(new Category().getChildList(this.TrademarkCaseType));
            
        	this.TrademarkType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.TrademarkType.setSelectList(new Category().getChildList(this.TrademarkType));
//            this.TrademarkType.setAnotherField(this.TrademarkCaseType);

            this.Office.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.Office.setSelectList(new Category().getChildList("PatentOffice"));
//            this.Office.setAnotherField(this.TrademarkType);
//            rtnString += this.printHtml(this.Office);
            
            List<SelectItem> items = new Employee().getList();
            this.CaseAD.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CaseAD.setSelectList(items);
            
            this.Referrals.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Referrals.setSelectList(items);
            
            this.CaseAssignedTo.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CaseAssignedTo.setSelectList(items);
            
            this.Attorney.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Attorney.setSelectList(new Attorney().getList());
            
        	this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("TrademarkCaseStatus"));
            
        	this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Title.setSize(20);
//        	this.Title.setAnotherField(this.Status);
//            rtnString += this.printHtml(this.Title);
        	
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
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	
        	if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
        		//2012/09/18於既有案件中新增功能可以複製該筆資料的“發明人”、“申請人”、“代理人”、“優先權”資料
        		if(!Util.isEmpty(oldCaseFlowKey) && Util.isEmpty(this.getFromCase())){
        			this.FromCase.setValue(this.getOldCaseFlowKey());
        			this.FlowKey.setValue("");
        			
        			if(!Util.compareTo(this.getChangeInsertFlag(), "true")) {
        				this.setChangeInsertFlag("true");
        				
        				//複製master資料（基本資料tab除外）
//        				this.InternalNo.setValue("");
        	            this.AttorneyDate.setValue("");
        	            this.FillingNum.setValue("");
        	            this.FillingDate.setValue("");
        	            this.PublicationNum.setValue("");
        	            this.PublicationDate.setValue("");
        	            this.IssueNo.setValue("");
        	            this.IssueDate.setValue("");
        	            this.RegistNum.setValue("");
        	            this.RegistDate.setValue("");
        	            this.TrademarkNo.setValue("");
        	            this.TrademarkNum.setValue("");
        	            this.OathYear.setValue("");
        	            this.OathDate.setValue("");
        	            this.ExpiryDateTo.setValue("");
        	            this.ExpiryDate.setValue("");
        	            this.AutoPay.setValue("");
        	            this.PaymentConfirming.setValue("");
        	            this.Attorney.setValue("");
        	            this.AttorneyNo.setValue("");
        	            this.AttorneyNum.setValue("");
        	            this.ExtendTime.setValue("");
        	            this.TrademarkCaseCloseStatus.setValue("");
        	            this.ClosedDate.setValue("");
        	            this.PriorityCaseNo.setValue("");
        	            this.ClientContect.setValue("");
        	            this.EngWordsinMark.setValue("");
        	            this.ChtWordsinMark.setValue("");
        	        	this.DesignMark.setValue("");
        	            this.JapWordsinMark.setValue("");
        	            this.GraphDesc.setValue("");
        	            this.Significance.setValue("");
        	            this.Remark.setValue("");
        	            this.Updater.setValue("");
        	            this.UpdateTime.setValue("");
        	            this.setCaseNo("");
        	            this.setCaseNo2("");
        		        this.Title.setValue("");
        		        this.EnglishTitle.setValue("");
        		        this.LastSchedule.setValue("");
        		        this.InternalNo.setValue("");
        		        this.Status.setValue("");
        			}
        		}
        		if(!Util.isEmpty(this.getFromCase())) {
        			this.InternalNoCheck.setCanEdit(true);
        			this.InternalNoCheck.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        			
            		this.PriorityCopyCheck.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            		this.PriorityCopyCheck.setAfterText(this.getUserInfo().getMsg("jsp.TrademarkCase.PriorityCopyCheck2")+
            				Html.printTag(this.InternalNoCheck, this.getUserInfo()) + this.getAlias(this.InternalNoCheck));

            		this.AttorneyCopyCheck.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            		this.AttorneyCopyCheck.setAnotherField(this.PriorityCopyCheck);

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
        	}
        	else {
        		rtnString += this.FromCase.printHiddenTag();
        	}

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

        	rtnString += this.QuotationFlowKey.printHiddenTag();
        	rtnString += this.FlowKey.printHiddenTag();
        	
        	if(this.getDbActionMode().equals(Cnstnts.UPDATE) || 
	        		this.getDbActionMode().equals(Cnstnts.INSERT)) {
	        	this.CaseNo.setAfterText("<input type='button' value='" + 
	        			this.getUserInfo().getMsg("jsp.PatentCase.GetFlowKey") + "' " +
	        			"onclick='getTrademarkFlowKey();'>");
	    		
	        	this.CaseNo2.setAfterText("<input type='button' value='" + 
	        			this.getUserInfo().getMsg("jsp.PatentCase.GetFlowKey") + "' " +
	        			"onclick='getTrademarkFlowKey2();'>");
        	}
        	
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
    		
        	this.SerialMotherCase.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.SerialMotherCase.setColspan(3);
        	if(this.getDbActionMode().equals(Cnstnts.UPDATE) ||
            		this.getDbActionMode().equals(Cnstnts.QUERY)) {
	            this.SerialMotherCase.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SearchSerialMotherCase"));
	            this.SerialMotherCase.setButtonClick(
            		"openAppendix(\"TrademarkCase.jsp?_pageActionMode=search&_dbActionMode=query&doSearchFlag=true&" +
            		"cond1=SerialMotherCase&fullSearchText1=" + this.getSerialMotherCase() + "\",\"TrademarkCase\",800,600)");
            }
            else{ 
            	if(Util.isEmpty(this.getSerialMotherCase()) && (this.getDbActionMode().equals(Cnstnts.UPDATE) ||
            	this.getDbActionMode().equals(Cnstnts.QUERY))) {
	            this.SerialMotherCase.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SearchSerialMotherCase"));
	            this.SerialMotherCase.setButtonClick(
            		"openAppendix(\"TrademarkCase.jsp?_pageActionMode=search&_dbActionMode=query&doSearchFlag=true&" +
            		"cond1=CaseNo&fullSearchText1=" + this.getCaseNo() + "\",\"PatentCase\",800,600)");
            	}
            }
            rtnString += this.printHtml(this.SerialMotherCase);
            
            Client cli = null;
        	String clientName = Cnstnts.EMPTY_STRING;
            if(this.Client.getValue().trim().length()>0){
            	cli = new Client(this.Client.getValue());
            	clientName = cli.getCompanyName();
            	
            	//四類案件中案件新增時選擇客戶後，若將該客戶的 負責程序 欄位有記載，就帶入該案件的 負責程序。
            	//1.案件新增時，要把客戶資料裡的(sales)業務人員 欄位以及 "大小實體" 欄位有資料的帶到案件裡。
//            	if(Util.compareTo(this.getChangeClientFlag(), "true")) {
	            	
	            	
	            	if(Util.compareTo(this.getDbActionMode(), Cnstnts.INSERT)) {
//	            		if(!Util.isEmpty(cli.getSponsor())) {
//		            		this.Sales.setValue(cli.getSponsor());
//		            	}
	            		if(!Util.isEmpty(cli.getCaseAD())) {
		            		this.CaseAD.setValue(cli.getCaseAD());
		            	}
//	            		if(!Util.isEmpty(cli.getEntity())) {
//		            		this.Entity.setValue(cli.getEntity());
//		            	}
	            	}
//            	}
            }
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
            
            if(Util.compareTo(this.getDbActionMode(), Cnstnts.INSERT)) {
	            this.Client.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
	            this.Client.setCallbackFunction("document.input.changeClientFlag.value=true;setValue();");
	            this.Client.setAutocompleteLabelFieldId(this.ClientName.getTagName());
            }
            else {
            	this.Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                
            }
            this.Client.setSelectList(new Client().getList());
            this.Client.setOnChange("setValue()");
            this.Client.setAnotherField(this.ClientName);
            this.Client.setColspan(1);
            this.Client.setMapingPrpt(null);
            rtnString += this.printHtml(this.Client);
            
            
            this.TrademarkKind.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.TrademarkKind.setSelectList(new Category().getChildList("TrademarkKind"));
            
            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("TrademarkCaseStatus"));
            this.Status.setAnotherField(this.TrademarkKind);
            
            this.Color.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Color.setSelectList(new Category().getChildList("Color"));   
            this.Color.setAnotherField(this.Status);
            
        	this.TrademarkType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.TrademarkType.setSelectList(new Category().getChildList(this.TrademarkType));
            this.TrademarkType.setAnotherField(this.Color);
            rtnString += this.printHtml(this.TrademarkType);
//            this.TrademarkCaseType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//            this.TrademarkCaseType.setSelectList(new Category().getChildList(this.TrademarkCaseType));
//            this.TrademarkCaseType.setAnotherField(this.TrademarkType);
//            this.TrademarkCaseType.setColspan(1);
//            rtnString += this.printHtml(this.TrademarkCaseType);
            
            this.MarkType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.MarkType.setSelectList(new Category().getChildList("MarkType"));
                        
//            this.Office.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//            this.Office.setSelectList(new Category().getChildList("PatentOffice"));

            this.Office.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Office.setMapingPrpt(null);
            this.Office.setOnChange("setValue()");
            this.Office.setAnotherField(this.MarkType);
            this.Office.setColspan(1);
            this.Office.setSize(10);
            if(this.canEdit()){
            	if(this.getDbActionMode().equals(Cnstnts.INSERT) 
            			|| (this.getDbActionMode().equals(Cnstnts.UPDATE))) {
		            this.Office.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryOffice"));
		    		this.Office.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=Office\",\"Office\",800,600)");
            	}
            }
    		if(!Util.isEmpty(this.getOffice())) {
    			this.Office.setValue(this.getOffice().toUpperCase());
            	String officeName = new Category().getNamesPrpts().getProperty(this.getOffice());
            	if(Util.isEmpty(officeName)) {
            		this.Office.setValue("");
            		this.Office.setAfterText("<script>alert('" + this.getUserInfo().getMsg("jsp.PatentCase.QueryOfficeError") + "');</script>");
            	}
            	else {
            		this.Office.setAfterText("(" + officeName + ")");
            	}
            }
            rtnString += this.printHtml(this.Office);
            
            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Title.setCols(82);
            this.Title.setRows(2);
            this.Title.setColspan(3);
            rtnString += this.printHtml(this.Title);
            
            this.EnglishTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishTitle.setSize(82);
            this.EnglishTitle.setLength(500);
            rtnString += this.printHtml(this.EnglishTitle);
            
            this.GoodsServices.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.GoodsServices.setCols(40);
            this.GoodsServices.setRows(2);
            this.GoodsServices.setLength(2000);
            
            this.TrademarkClassification.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.TrademarkClassification.setCols(40);
            this.TrademarkClassification.setRows(2);
            this.TrademarkClassification.setAnotherField(this.GoodsServices);
            this.TrademarkClassification.setColspan(1);
            rtnString += this.printHtml(this.TrademarkClassification);
            
            this.NoBelongDesc.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.NoBelongDesc.setCols(40);
            this.NoBelongDesc.setRows(2);

            this.GroupCode.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.GroupCode.setCols(40);
            this.GroupCode.setRows(2);
            this.GroupCode.setAnotherField(this.NoBelongDesc);
            this.GroupCode.setColspan(1);
            rtnString += this.printHtml(this.GroupCode);
 
/*
            this.GraphDesc.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.GraphDesc.setCols(40);
            
            this.Significance.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Significance.setCols(40);
            this.Significance.setAnotherField(this.GraphDesc);
            this.Significance.setColspan(1);
            rtnString += this.printHtml(this.Significance);
*/            

            List<SelectItem> items = new Employee().getList();

            this.ContactDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.Sales.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Sales.setSelectList(items);
            this.Sales.setAnotherField(this.ContactDate);
            
            this.CaseAssignedTo.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CaseAssignedTo.setSelectList(items);
            this.CaseAssignedTo.setAnotherField(this.Sales);
            
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
            
            /*
            “最新進度”欄位資料是將最新建立的一筆收發文內的欄位資料組成的，
            組成方式為：“收發文日”+“ ”+“收發類型”+“ ”+“對象”+“ ”+“文件類別”+“ ”+“文件名稱”
            (每項資料中間需空格一格)
            例如：
            2010-06-10 收文 智慧局 信函 XXXXXXXXX
            2010-04-03 發文 楊盟工業有限公司 傳真 OOOOOO
                         */           
//            String LastSchedule = "";
//            sql = "select FlowKey from TrademarkDocument where parentid='" + this.getFlowKey() +
//            			"' and (DocumentDate is not null and DocumentDate != '') order by FlowKey desc";
//            List<String> keys = this.getDbUtil().getValueList(sql, "FlowKey");
//            if(!keys.isEmpty()) {
//            	Properties categoryProp = new Category().getNamesPrpts();
//            	
//            	TrademarkDocument doc = new TrademarkDocument(keys.get(0));
//            	
//            	String documentTarget = "";
//            	if(Util.compareTo(doc.getDocumentUnit(), "DU01")) {
//            		documentTarget = categoryProp.getProperty(doc.getDocumentTarget());
//                }
//                else if(Util.compareTo(doc.getDocumentUnit(), "DU02")) {
//                	documentTarget = new Attorney().getNamesPrpts().getProperty(doc.getDocumentTarget());
//                }
//                else if(Util.compareTo(doc.getDocumentUnit(), "DU03")) {
//                	documentTarget = new Client().getNamesPrpts().getProperty(doc.getDocumentTarget());
//                }
//            	
//            	
//            	LastSchedule = doc.getDocumentDate() + " " + categoryProp.getProperty(doc.getDocumentKind()) + " " +
//            				documentTarget + " " + 
//            				categoryProp.getProperty(doc.getDocumentType()) + " " +
//            				doc.getDocumentName();
//            }
            this.LastSchedule.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.LastSchedule.setSize(82);
            this.LastSchedule.setLength(200);
//            this.LastSchedule.setValue(LastSchedule);
            rtnString += this.printHtml(this.LastSchedule);
            
            if(this.TabText.getValue().trim().length()==0){
            	this.TabText.setValue("TrademarkSecondPage");
            }
            rtnString += this.TabText.printHiddenTag();
            
            
           
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
    	Properties clientPrpt = null;
    	try {
    		clientPrpt = new Client().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties employeePrpt = null;
		try {
			employeePrpt = new Employee().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
        
		this.CaseNo.setListWidth("10%");
		this.CaseNo2.setListWidth("10%");

        this.Title.setListWidth("10%");

        this.TrademarkType.setListWidth("5%");
        this.TrademarkType.setMapingPrpt(categoryPrpt);
        this.TrademarkType.setNotShowCode(true);
        
        this.TrademarkCaseType.setListWidth("5%");
        this.TrademarkCaseType.setMapingPrpt(categoryPrpt);
        this.TrademarkCaseType.setNotShowCode(true);
        
        this.Office.setListWidth("5%");
        this.Office.setMapingPrpt(categoryPrpt);
        this.Office.setNotShowCode(true);
        
        this.MarkType.setListWidth("5%");
        this.MarkType.setMapingPrpt(categoryPrpt);
        this.MarkType.setNotShowCode(true);

        this.Status.setListWidth("5%");
        this.Status.setMapingPrpt(categoryPrpt);
        this.Status.setNotShowCode(true);
        
        this.TrademarkClassification.setListWidth("5%");
        this.TrademarkClassification.setAlign(Cnstnts.CENTER);
        
        this.ClosedDate.setListWidth("8%");
        this.ClosedDate.setAlign(Cnstnts.CENTER);
        
        this.FillingNum.setListWidth("7%");
        this.FillingNum.setAlign(Cnstnts.CENTER);
        
        this.ClientName.setListWidth("15%");
        
        this.CaseAD.setListWidth("5%");
        this.CaseAD.setMapingPrpt(employeePrpt);
        this.CaseAD.setNotShowCode(true);
        
        this.Sales.setListWidth("5%");
        this.Sales.setMapingPrpt(employeePrpt);
        this.Sales.setNotShowCode(true);
        
        this.ClientName.setListWidth("5%");

        Field[] showField = {this.CaseNo, this.TrademarkType, this.MarkType, 
        		this.Office, this.Title, this.ClientName, this.TrademarkClassification, this.FillingNum, this.CaseAD, this.Sales, this.Status};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        boolean hasApplicant = false;
        
        if(Util.isEmpty(this.getSearchWhereSql())) {
	        if(!Util.isEmpty(getCond1())) {
	        	boolean searchLike = true;
	        	String like = Cnstnts.LIKE;
	
	        	if(getCond1().equalsIgnoreCase("ClientName")) {
	        		if(!Util.isEmpty(getFullSearchText1())){
	        			if(getFullSearchText1().indexOf(" ") != -1) {
	        				String sql = "";
	        				String[] conds = getFullSearchText1().split("\\s+");
	        				for(int i=0;i<conds.length;i++) {
	        					if(i==0) {
	        						sql = "Client in (select c.FlowKey from Client c where c.CompanyName like '%"+
	        								conds[i]+"%')";
	        					}
	        					else {
	        						sql += "or Client in (select c.FlowKey from Client c where c.CompanyName like '%"+
	        								conds[i]+"%')";
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
			                	if(whereStr.trim().length()>0) {
			                		whereStr += " And Client in (select c.FlowKey from Client c where c.CompanyName like '%"+
			        				this.getFullSearchText1()+"%') ";
			                	}
			                	else {
			                		whereStr = " where Client in (select c.FlowKey from Client c where c.CompanyName like '%"+
			        				this.getFullSearchText1()+"%') ";
			                	}
	    	        		}
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
	                		whereStr += " And flowkey in (select c.parentid from trademarkpriority c where c.applyno like '%"+
	        				this.getFullSearchText1()+"%') ";
	                	}
	                	else {
	                		whereStr = " where flowkey in (select c.parentid from trademarkpriority c where c.applyno like '%"+
	        				this.getFullSearchText1()+"%') ";
	                	}
	                }
	            }
	        	else if(getCond1().equalsIgnoreCase("CaseApplicantName")) {
	        		hasApplicant = true;

	        			if(getFullSearchText1().indexOf(" ") != -1) {
	        				String sql = "";
	        				String[] conds = getFullSearchText1().split("\\s+");
	        				String condSql = "";
	        				for(int i=0;i<conds.length;i++) {
	        					if(i==0) {
	        						sql = "flowkey in (select pa.parentid from trademarkapplicant pa where pa.ApplicantName like '%"+conds[i]+"%')";
	        						condSql = " pa.ApplicantName like '%"+conds[i]+"%' ";
	        					}
	        					else {
	        						sql += "or flowkey in (select pa.parentid from trademarkapplicant pa where pa.ApplicantName like '%"+conds[i]+"%')";
	        						condSql += " or pa.ApplicantName like '%"+conds[i]+"%' ";
	        					}
	        				}
//	        				patentapplicant = condSql;
	        				//condSql = "select pa.parentid from patentapplicant pa " + condSql;
//	        				List<String> conds2 = this.getDbUtil().getValueList(condSql, "parentid");
//	        				String cond = Util.arrayToIncond(conds2.toArray());
	        				
	        				if(whereStr.trim().length()>0) {
//		                		whereStr += "and p.flowkey in (" + cond + ")";
	        					whereStr += " and (" + condSql + ") ";
		                	}
		                	else {
		                		//whereStr += "where p.flowkey in (" + sql + ")";
		                		whereStr += " where (" + condSql + ") ";
		                	}
	        			}
	        			else {
	        				String condSql = "select pa.parentid from trademarkapplicant pa where pa.ApplicantName like '%"+this.getFullSearchText1()+"%'";
	        				List<String> conds = this.getDbUtil().getValueList(condSql, "parentid");
	        				String cond = Util.arrayToIncond(conds.toArray());
	        				
		                	if(whereStr.trim().length()>0) {
		                		whereStr += " And flowkey in (" + cond + ") ";
//		                		whereStr += " and pa.ApplicantName like '%"+this.getFullSearchText1()+"%' ";
		                	}
		                	else {
		                		whereStr += " where flowkey in (" + cond + ") ";
//		                		whereStr = " where pa.ApplicantName like '%"+this.getFullSearchText1()+"%' ";
		                	}
	        			}
	            }
	        	else if(getCond1().equalsIgnoreCase("Office")) {
	        		if(!Util.isEmpty(getFullSearchText1())){
	                	if(whereStr.trim().length()>0) {
	                		whereStr += " And office in (select pa.flowkey from category pa where pa.Names like '%"+
	        				this.getFullSearchText1()+"%' or pa.flowkey like '%"+
	        				this.getFullSearchText1()+"%') ";
	                	}
	                	else {
	                		whereStr = " where office in (select pa.flowkey from category pa where pa.Names like '%"+
	        				this.getFullSearchText1()+"%' or pa.flowkey like '%"+
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
	    						sql = getCond1() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText1()+'%':getFullSearchText1()) + "'";
	    					}
	    					else {
	    						sql += getCond1() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText1()+'%':getFullSearchText1()) + "'";
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
		                    whereStr += " and " + getCond1() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText1()+'%':getFullSearchText1()) + "' ";
		                }
		                else {
		                    whereStr += " where " + getCond1() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText1()+'%':getFullSearchText1()) + "' ";
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
	    						sql = "(CaseNo like '%" + conds[i] + "%' or "
	    								+ "CaseNo2 like '%" + conds[i] + "%' or "
	    								+ "FillingNum like '%" + conds[i] + "%' or "
	    								+ "RegistNum like '%" + conds[i] + "%' or "
	    								+ "Title like '%" + conds[i] + "%' or "
	    								+ "Client like '%" + conds[i] + "%' or "
	    								+ "Client in (select c.FlowKey from Client c where c.CompanyName like '%"+ conds[i]+"%') or "
	    								+ "TrademarkNum like '%" + conds[i] + "%' or "
	    								+ "TrademarkNo like '%" + conds[i] + "%' or "
	    								+ "TrademarkCaseType like '%" + conds[i] + "%' or "
	    								+ "TrademarkType like '%" + conds[i] + "%' or "
	    								+ "Sales like '%" + conds[i] + "%' or "
	    	    						+ "CaseAssignedTo like '%" + conds[i] + "%' or "
	    								+ "Status like '%" + conds[i] + "%' or "
	    								+ "Color like '%" + conds[i] + "%' or "
	    								+ "SerialMotherCase like '%" + conds[i] + "%' or "
	    								+ "PriorityCaseNo like '%" + conds[i] + "%' or "
	    	    						+ "TrademarkClassification like '%" + conds[i] + "%' or "
	       	    						+ "ClientContect in(select c.FlowKey from applicant c where c.Names like '%"+
	       	    								conds[i]+"%') or "
	    	    						+ "flowkey in (select pa.parentid from trademarkpriority pa where pa.applyno like '%"+conds[i]+"%') or "
	    								+ "Office like '%" + conds[i] + "%'" ;
	    						sql += ")";
	    					}
	    					else {
	    						sql += " or (CaseNo like '%" + conds[i] + "%' or "
	    								+ "CaseNo2 like '%" + conds[i] + "%' or "
	    								+ "FillingNum like '%" + conds[i] + "%' or "
	    								+ "RegistNum like '%" + conds[i] + "%' or "
	    								+ "Title like '%" + conds[i] + "%' or "
	    								+ "Client like '%" + conds[i] + "%' or "
	    								//+ "ClientName like '%" + conds[i] + "%' or "
	    								+ "Client in (select c.FlowKey from Client c where c.CompanyName like '%"+ conds[i]+"%') or "
	    								+ "TrademarkNum like '%" + conds[i] + "%' or "
	    								+ "TrademarkNo like '%" + conds[i] + "%' or "
	    								+ "TrademarkCaseType like '%" + conds[i] + "%' or "
	    								+ "TrademarkType like '%" + conds[i] + "%' or "
	    								+ "Sales like '%" + conds[i] + "%' or "
	    	    						+ "CaseAssignedTo like '%" + conds[i] + "%' or "
	    								+ "Status like '%" + conds[i] + "%' or "
	    								+ "Color like '%" + conds[i] + "%' or "
	    								+ "SerialMotherCase like '%" + conds[i] + "%' or "
	    								+ "PriorityCaseNo like '%" + conds[i] + "%' or "
	       	    						+ "ClientContect in(select c.FlowKey from applicant c where c.Names like '%"+
	       	    								conds[i]+"%') or "
	    	    	    				+ "TrademarkClassification like '%" + conds[i] + "%' or "
	    	    	    				+ "flowkey in (select pa.parentid from trademarkpriority pa where pa.applyno like '%"+conds[i]+"%') or "
	    								+ "Office like '%" + conds[i] + "%'" ;
	    	    	        	
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
			        	whereStr += "(CaseNo like '%" + getFullSearchText1() + "%' or "
								+ "CaseNo2 like '%" + getFullSearchText1() + "%' or "
								+ "FillingNum like '%" + getFullSearchText1() + "%' or "
								+ "RegistNum like '%" + getFullSearchText1() + "%' or "
								+ "Title like '%" + getFullSearchText1() + "%' or "
								+ "Client like '%" + getFullSearchText1() + "%' or "
								+ "Client in (select c.FlowKey from Client c where c.CompanyName like '%"+
		        				this.getFullSearchText1()+"%') or "
								+ "TrademarkNum like '%" + getFullSearchText1() + "%' or "
								+ "TrademarkNo like '%" + getFullSearchText1() + "%' or "
								+ "TrademarkCaseType like '%" + getFullSearchText1() + "%' or "
								+ "TrademarkType like '%" + getFullSearchText1() + "%' or "
								+ "Sales like '%`" + getFullSearchText1() + "%' or "
								+ "CaseAssignedTo like '%`" + getFullSearchText1() + "%' or "
								+ "Status like '%" + getFullSearchText1() + "%' or "
								+ "Color like '%" + getFullSearchText1() + "%' or "
								+ "SerialMotherCase like '%" + getFullSearchText1() + "%' or "
								+ "PriorityCaseNo like '%" + getFullSearchText1() + "%' or "
	    	    				+ "TrademarkClassification like '%" + getFullSearchText1() + "%' or "
	    			    		+ "ClientContect in(select c.FlowKey from applicant c where c.Names like '%"+
				        				this.getFullSearchText1()+"%') or "
	    	    	    		+ "flowkey in (select pa.parentid from trademarkapplicant pa where pa.ApplicantName like '%"+getFullSearchText1()+"%') or "
	    	    	    		+ "flowkey in (select pa.parentid from trademarkpriority pa where pa.applyno like '%"+getFullSearchText1()+"%') or "
								+ "Office like '%" + getFullSearchText1() + "%'" ;
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
	
	        	if(getCond11().equalsIgnoreCase("ClientName")) {
	        		if(!Util.isEmpty(getFullSearchText11())){
	        			if(getFullSearchText11().indexOf(" ") != -1) {
	        				String sql = "";
	        				String[] conds = getFullSearchText11().split("\\s+");
	        				for(int i=0;i<conds.length;i++) {
	        					if(i==0) {
	        						sql = "Client in (select c.FlowKey from Client c where c.CompanyName " + like + " '%"+
	        								conds[i]+"%')";
	        					}
	        					else {
	        						sql += "or Client in (select c.FlowKey from Client c where c.CompanyName " + like + " '%"+
	        								conds[i]+"%')";
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
	        				if(getFullSearchText11().indexOf(" ") != -1) {
	            				String sql = "";
	            				String[] conds = getFullSearchText11().split("\\s+");
	            				for(int i=0;i<conds.length;i++) {
	            					if(i==0) {
	            						sql = "p." + getCond11() + like + " '" + ((searchLike)?'%'+getFullSearchText11()+'%':getFullSearchText11()) + "'";
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
			                	if(whereStr.trim().length()>0) {
			                		whereStr += " " + sqlCond + " Client in (select c.FlowKey from Client c where c.CompanyName " + like + " '%"+
			        				this.getFullSearchText11()+"%') ";
			                	}
			                	else {
			                		whereStr = " where Client in (select c.FlowKey from Client c where c.CompanyName " + like + " '%"+
			        				this.getFullSearchText11()+"%') ";
			                	}
	    	        		}
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
	        	else if(getCond11().equalsIgnoreCase("Office")) {
	        		if(!Util.isEmpty(getFullSearchText11())){
	                	if(whereStr.trim().length()>0) {
	                		whereStr += " " + sqlCond + " office in (select pa.flowkey from category pa where pa.Names " + like + " '%"+
	        				this.getFullSearchText11()+"%' or pa.flowkey " + like + " '%"+
	        				this.getFullSearchText11()+"%') ";
	                	}
	                	else {
	                		whereStr = " where office in (select pa.flowkey from category pa where pa.Names " + like + " '%"+
	        				this.getFullSearchText11()+"%' or pa.flowkey " + like + " '%"+
	        				this.getFullSearchText11()+"%') ";
	                	}
	                }
	            }
	        	else if(getCond11().equalsIgnoreCase("CaseApplicantName")) {
	        		hasApplicant = true;

	        			if(getFullSearchText11().indexOf(" ") != -1) {
	        				String sql = "";
	        				String[] conds = getFullSearchText11().split("\\s+");
	        				String condSql = "";
	        				for(int i=0;i<conds.length;i++) {
	        					if(i==0) {
	        						sql = "p.flowkey in (select pa.parentid from trademarkapplicant pa where pa.ApplicantName " + like + " '%"+conds[i]+"%')";
	        						condSql = " pa.ApplicantName " + like + " '%"+conds[i]+"%' ";
	        					}
	        					else {
	        						sql += "or p.flowkey in (select pa.parentid from trademarkapplicant pa where pa.ApplicantName " + like + " '%"+conds[i]+"%')";
	        						condSql += " or pa.ApplicantName " + like + " '%"+conds[i]+"%' ";
	        					}
	        				}
//	        				patentapplicant = condSql;
	        				condSql = "select pa.parentid from trademarkapplicant pa " + condSql;
	        				List<String> conds2 = this.getDbUtil().getValueList(condSql, "parentid");
	        				String cond = Util.arrayToIncond(conds2.toArray());
	        				
	        				if(whereStr.trim().length()>0) {
//		                		whereStr += "and flowkey in (" + cond + ")";
	        					whereStr += " " + sqlCond + " (" + condSql + ") ";
		                	}
		                	else {
//		                		whereStr += "where flowkey in (" + sql + ")";
		                		whereStr += " where (" + condSql + ") ";
		                	}
	        			}
	        			else {
	        				String condSql = "select pa.parentid from trademarkapplicant pa where pa.ApplicantName " + like + " '%"+this.getFullSearchText11()+"%'";
	        				List<String> conds = this.getDbUtil().getValueList(condSql, "parentid");
	        				String cond = Util.arrayToIncond(conds.toArray());
	        				
		                	if(whereStr.trim().length()>0) {
		                		whereStr += " " + sqlCond + " flowkey in (" + cond + ") ";
//		                		whereStr += " " + sqlCond + " pa.ApplicantName " + like + " '%"+this.getFullSearchText11()+"%' ";
		                	}
		                	else {
		                		whereStr += " where flowkey in (" + cond + ") ";
//		                		whereStr = " where pa.ApplicantName " + like + " '%"+this.getFullSearchText11()+"%' ";
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
	        	else  if(getCond11().equalsIgnoreCase("PriorityNo")) {
	        		if(!Util.isEmpty(getFullSearchText11())){
	                	if(whereStr.trim().length()>0) {
	                		whereStr += " " + sqlCond + " flowkey in (select c.parentid from trademarkpriority c where c.applyno " + like + " '%"+
	        				this.getFullSearchText11()+"%') ";
	                	}
	                	else {
	                		whereStr = " where flowkey in (select c.parentid from trademarkpriority c where c.applyno " + like + " '%"+
	        				this.getFullSearchText11()+"%') ";
	                	}
	                }
	            }
	        	else {
	        		if(getFullSearchText11().indexOf(" ") != -1) {
	    				String sql = "";
	    				String[] conds = getFullSearchText11().split("\\s+");
	    				for(int i=0;i<conds.length;i++) {
	    					if(i==0) {
	    						sql = getCond11() + " " + " + like + " + " '" + ((searchLike)?'%'+getFullSearchText11()+'%':getFullSearchText11()) + "'";
	    					}
	    					else {
	    						sql += getCond11() + " " + " + like + " + " '" + ((searchLike)?'%'+getFullSearchText11()+'%':getFullSearchText11()) + "'";
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
		                    whereStr += " " + sqlCond + " " + getCond11() + " " + " + like + " + " '" + ((searchLike)?'%'+getFullSearchText11()+'%':getFullSearchText11()) + "' ";
		                }
		                else {
		                    whereStr += " where " + getCond11() + " " + " + like + " + " '" + ((searchLike)?'%'+getFullSearchText11()+'%':getFullSearchText11()) + "' ";
		                }
	        		}
	        	}
	        }
	        else {
	        	if(!Util.isEmpty(getFullSearchText11())) {
	        		boolean searchLike = true;
		        	String like = Cnstnts.LIKE;
		       		if(getSqlCond11().equals("not")) {
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
	    						sql = "(CaseNo " + like + " '%" + conds[i] + "%' or "
	    								+ "CaseNo2 " + like + " '%" + conds[i] + "%' or "
	    								+ "FillingNum " + like + " '%" + conds[i] + "%' or "
	    								+ "RegistNum " + like + " '%" + conds[i] + "%' or "
	    								+ "Title " + like + " '%" + conds[i] + "%' or "
	    								+ "Client " + like + " '%" + conds[i] + "%' or "
	    								+ "Client in (select c.FlowKey from Client c where c.CompanyName " + like + " '%"+ conds[i]+"%') or "
	    								+ "TrademarkNum " + like + " '%" + conds[i] + "%' or "
	    								+ "TrademarkNo " + like + " '%" + conds[i] + "%' or "
	    								+ "TrademarkCaseType " + like + " '%" + conds[i] + "%' or "
	    								+ "TrademarkType " + like + " '%" + conds[i] + "%' or "
	    								+ "Sales " + like + " '%" + conds[i] + "%' or "
	    	    						+ "CaseAssignedTo " + like + " '%" + conds[i] + "%' or "
	    								+ "Status " + like + " '%" + conds[i] + "%' or "
	    								+ "Color " + like + " '%" + conds[i] + "%' or "
	    								+ "SerialMotherCase " + like + " '%" + conds[i] + "%' or "
	    								+ "PriorityCaseNo " + like + " '%" + conds[i] + "%' or "
	    	    						+ "TrademarkClassification " + like + " '%" + conds[i] + "%' or "
	    	    	    				+ "ClientContect in(select c.FlowKey from applicant c where c.Names " + like + " '%"+
	    	    	    						conds[i]+"%') or "
	    	    						+ "flowkey in (select pa.parentid from trademarkpriority pa where pa.applyno " + like + " '%"+conds[i]+"%') or "
	    								+ "Office " + like + " '%" + conds[i] + "%'" ;
	    						sql += ")";
	    					}
	    					else {
	    						sql += " or (CaseNo " + like + " '%" + conds[i] + "%' or "
	    								+ "CaseNo2 " + like + " '%" + conds[i] + "%' or "
	    								+ "FillingNum " + like + " '%" + conds[i] + "%' or "
	    								+ "RegistNum " + like + " '%" + conds[i] + "%' or "
	    								+ "Title " + like + " '%" + conds[i] + "%' or "
	    								+ "Client " + like + " '%" + conds[i] + "%' or "
	    								//+ "ClientName " + like + " '%" + conds[i] + "%' or "
	    								+ "Client in (select c.FlowKey from Client c where c.CompanyName " + like + " '%"+ conds[i]+"%') or "
	    								+ "TrademarkNum " + like + " '%" + conds[i] + "%' or "
	    								+ "TrademarkNo " + like + " '%" + conds[i] + "%' or "
	    								+ "TrademarkCaseType " + like + " '%" + conds[i] + "%' or "
	    								+ "TrademarkType " + like + " '%" + conds[i] + "%' or "
	    								+ "Sales " + like + " '%" + conds[i] + "%' or "
	    	    						+ "CaseAssignedTo " + like + " '%" + conds[i] + "%' or "
	    								+ "Status " + like + " '%" + conds[i] + "%' or "
	    								+ "Color " + like + " '%" + conds[i] + "%' or "
	    								+ "SerialMotherCase " + like + " '%" + conds[i] + "%' or "
	    								+ "PriorityCaseNo " + like + " '%" + conds[i] + "%' or "
	    	    	    				+ "TrademarkClassification " + like + " '%" + conds[i] + "%' or "
	    	    						+ "ClientContect in(select c.FlowKey from applicant c where c.Names " + like + " '%"+
	    	    						conds[i]+"%') or "
	    	    	    				+ "flowkey in (select pa.parentid from trademarkpriority pa where pa.applyno " + like + " '%"+conds[i]+"%') or "
	    								+ "Office " + like + " '%" + conds[i] + "%'" ;
	    	    	        	
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
			        	whereStr += "(CaseNo like '%" + getFullSearchText11() + "%' or "
								+ "CaseNo2 like '%" + getFullSearchText11() + "%' or "
								+ "FillingNum like '%" + getFullSearchText11() + "%' or "
								+ "RegistNum like '%" + getFullSearchText11() + "%' or "
								+ "Title like '%" + getFullSearchText11() + "%' or "
								+ "Client like '%" + getFullSearchText11() + "%' or "
								+ "Client in (select c.FlowKey from Client c where c.CompanyName like '%"+
		        				this.getFullSearchText11()+"%') or "
								+ "TrademarkNum like '%" + getFullSearchText11() + "%' or "
								+ "TrademarkNo like '%" + getFullSearchText11() + "%' or "
								+ "TrademarkCaseType like '%" + getFullSearchText11() + "%' or "
								+ "TrademarkType like '%" + getFullSearchText11() + "%' or "
								+ "Sales like '%`" + getFullSearchText11() + "%' or "
								+ "CaseAssignedTo like '%`" + getFullSearchText11() + "%' or "
								+ "Status like '%" + getFullSearchText11() + "%' or "
								+ "Color like '%" + getFullSearchText11() + "%' or "
								+ "SerialMotherCase like '%" + getFullSearchText11() + "%' or "
								+ "PriorityCaseNo like '%" + getFullSearchText11() + "%' or "
								+ "ClientContect in(select c.FlowKey from applicant c where c.Names " + like + " '%"+
				        				this.getFullSearchText11()+"%') or "
	    	    				+ "TrademarkClassification like '%" + getFullSearchText11() + "%' or "
	    				        + "p.flowkey in (select pa.parentid from trademarkapplicant pa where pa.ApplicantName " + like + " '%"+this.getFullSearchText11()+"%') or "
	    				        + "p.flowkey in (select pa.parentid from trademarkpriority pa where pa.applyno " + like + " '%"+this.getFullSearchText11()+"%') or "
								+ "Office like '%" + getFullSearchText11() + "%'" ;
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
	        	
	       		if(!Util.isEmpty(getFullSearchText2())) {
		            if(getSqlCond11().equals("not")) {
		            	
		                    if(whereStr.indexOf("where") != -1) {
		                        whereStr += " and " + getCond2() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText2()+'%':getFullSearchText2()) + "' ";
		                    }
		                    else {
		                        whereStr += " where " + getCond2() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText2()+'%':getFullSearchText2()) + "' ";
		                    }
		            }
		            else {
		                    if(whereStr.indexOf("where") != -1) {
		                        whereStr += " " + getSqlCond11() + " " + getCond2() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText2()+'%':getFullSearchText2()) + "' ";
		                    }
		                    else {
		                        whereStr += " where " + getCond2() + " " + like + " '" + ((searchLike)?'%'+getFullSearchText2()+'%':getFullSearchText2()) + "' ";
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
	
		        		whereStr += "(CaseNo not like '%" + getFullSearchText2() + "%' or "
								+ "CaseNo2 not like '%" + getFullSearchText2() + "%' or "
								+ "FillingNum not like '%" + getFullSearchText2() + "%' or "
								+ "RegistNum not like '%" + getFullSearchText2() + "%' or "
								+ "Title not like '%" + getFullSearchText2() + "%' or "
								+ "Client not like '%" + getFullSearchText2() + "%' or "
								//+ "ClientName not like '%" + getFullSearchText2() + "%' or "
								+ "Client in (select c.FlowKey from Client c where c.CompanyName not like '%"+
		        				this.getFullSearchText2()+"%') or "
								+ "TrademarkNum not like '%" + getFullSearchText2() + "%' or "
								+ "TrademarkNo not like '%" + getFullSearchText2() + "%' or "
								+ "TrademarkCaseType not like '%" + getFullSearchText2() + "%' or "
								+ "TrademarkType not like '%" + getFullSearchText2() + "%' or "
								+ "Sales not like '%" + getFullSearchText2() + "%' or "
								+ "CaseAssignedTo not like '%" + getFullSearchText2() + "%' or "
								+ "Status not like '%" + getFullSearchText2() + "%' or "
								+ "Color not like '%" + getFullSearchText2() + "%' or "
								+ "SerialMotherCase not like '%" + getFullSearchText2() + "%' or "
								+ "PriorityCaseNo not like '%" + getFullSearchText2() + "%' or "
								+ "Office not like '%" + getFullSearchText2() + "%'" ;
			        	whereStr += ")";
					} else {
						if(whereStr.indexOf("where") != -1) {
			                whereStr += " and ";
			            }
			            else {
			                whereStr += " where ";
			            }
						whereStr += "(CaseNo like '%" + getFullSearchText2() + "%' or "
								+ "CaseNo2 like '%" + getFullSearchText2() + "%' or "
								+ "FillingNum like '%" + getFullSearchText2() + "%' or "
								+ "RegistNum like '%" + getFullSearchText2() + "%' or "
								+ "Title like '%" + getFullSearchText2() + "%' or "
								+ "Client like '%" + getFullSearchText2() + "%' or "
								//+ "ClientName like '%" + getFullSearchText2() + "%' or "
								+ "Client in (select c.FlowKey from Client c where c.CompanyName like '%"+
		        				this.getFullSearchText2()+"%') or "
								+ "TrademarkNum like '%" + getFullSearchText2() + "%' or "
								+ "TrademarkNo like '%" + getFullSearchText2() + "%' or "
								+ "TrademarkCaseType like '%" + getFullSearchText2() + "%' or "
								+ "TrademarkType like '%" + getFullSearchText2() + "%' or "
								+ "Sales like '%" + getFullSearchText2() + "%' or "
								+ "CaseAssignedTo like '%" + getFullSearchText2() + "%' or "
								+ "Status like '%" + getFullSearchText2() + "%' or "
								+ "Color like '%" + getFullSearchText2() + "%' or "
								+ "SerialMotherCase like '%" + getFullSearchText2() + "%' or "
								+ "PriorityCaseNo like '%" + getFullSearchText2() + "%' or "
								+ "Office like '%" + getFullSearchText2() + "%'" ;
	
			        	whereStr += ")";
					}
	        	}
	        }
	
	        if(!Util.isEmpty(getCond3())) {
	            if(getSqlCond2().equals("not")) {
	                if(whereStr.indexOf("where") != -1) {
	                    whereStr += " and " + getCond3() + " not between '" + getStartDate() + "' and '" + getEndDate() + "' ";
	                }
	                else {
	                    whereStr += " where " + getCond3() + " between '" + getStartDate() + "' and '" + getEndDate() + "' ";
	                }
	            }
	            else {
	                if(whereStr.indexOf("where") != -1) {
	                    whereStr += " " + getSqlCond2() + " " + getCond3() + " between '" + getStartDate() + "' and '" + getEndDate() + "' "; 
	                }
	                else {
	                    whereStr += " where " + getCond3() + " between '" + getStartDate() + "' and '" + getEndDate() + "' ";
	                }
	            }
	        }
	
	        
	        if(Util.compareTo(this.getNewCaseCheck(), "Y")) {
	        	if(whereStr.indexOf("where") != -1) {
	                whereStr += " and caseno = '' "; 
	            }
	            else {
	            	whereStr += " where caseno = '' ";
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
        String conds = "(select IFNULL(if(length(c.CompanyName)> 12,concat(substr(c.CompanyName, 1, 4), '...'), c.CompanyName),'') from Client c where Client=c.FlowKey) as ClientName ";
        if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
        	conds = "(select "
        			+ "ISNULL(case when len(c.CompanyName)> 12 then SUBSTRING(c.CompanyName, 1, 4) + '...' else c.CompanyName end,'') from Client c where Client=c.FlowKey"
        			+ ") as ClientName ";
        }
        String SQL = "select *, '' as CaseApplicantNames, "
        		+ conds
        		+ "" +
        		"from TrademarkCase "+whereStr;
        if (Cnstnts.EXPORTCSV.equals(this.getDbActionMode()) ||
        		Cnstnts.EXPORTXLS.equals(this.getDbActionMode())) {
        	SQL = "select *, '' as CaseApplicantNames, (select c.CompanyName from Client c where Client=c.FlowKey) as ClientName " +
            		"from TrademarkCase "+whereStr;
        }
        SQL = Util.addOrderSQL(SQL, this.getOrderKey(), this.getOrderSequence());
//        System.out.println(SQL);
        return this.doSearch(SQL);
    }
    
    public List<Object[]> doSearch(String SQL) throws Exception{
  	  	if(this.getPageNo()==0){
  	  		this.setPageNo(1);
  	  	}
        int recordCount=0;
        

  	  	int applicantIndex = 0;
	  	boolean hasApplicant = false;
	  	int titleIndex = 0;
	  	boolean hasTitle = false;
	  	for(int i=0;i<this.getShowField().length;i++) {
	  		Field field = this.getShowField()[i];
	  		if(field.getName().equals("CaseApplicantNames")) {
	  			hasApplicant = true;
	  			applicantIndex = i + 1;
	  		}
	  		if(field.getName().equals("Title")) {
	  			hasTitle = true;
	  			titleIndex = i + 1;
	  		}
	  	}
        
        List<Object[]> rtnList = new ArrayList<Object[]>();
        
        Iterator<?> itr = this.getDbUtil().getList(SQL, this.getShowField()).iterator();
        while(itr.hasNext()){
      	  Object[] record = (Object[])itr.next();
      	  recordCount++;
      	  if(recordCount<=this.getPageNo()*this.getPageRecords()
      			  && recordCount>(this.getPageNo()-1)*this.getPageRecords()){
      		if (hasApplicant) {
				String sql = "select applicantName from TrademarkApplicant where ParentId = '"
						+ record[0] + "' and applicantname is not null   ";
				List<String> signingNames = this.getDbUtil().getValueList(
						sql, "applicantName");
				String signingName = "";
				for (String s : signingNames) {
					signingName += s + ";";
				}
				record[applicantIndex] = signingName;
			}
      		if (hasTitle && !Cnstnts.EXPORTCSV.equals(this.getDbActionMode()) &&
            		!Cnstnts.EXPORTXLS.equals(this.getDbActionMode())) {
      			String value = record[titleIndex].toString();
				if(value.length() > 8)  {
					value = value.substring(0, 8) + "...";
				}
				
				record[titleIndex] = value;
			}
      		
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
        	TrademarkCase preObj = (TrademarkCase) userInfo.getObj(this.getTableName());
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
    
    public boolean checkInsertError() throws Exception {
    	/*
		 * 專利案件代碼為：“西元年後兩碼”“流水碼四碼”“國家碼”
新增一"產生案件編號功能"(只有在新增模式才會出現)，點選時會先檢查國家別是否已經填入資料，
若沒有就會出現提醒視窗，若有，則依據上述條件自動產生專利案件代碼
		 */
    	if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
    		if(Util.isEmpty(this.getAttorneyDate()) && 
            		this.getDbActionMode().equals(Cnstnts.INSERT)) {
            	this.setAttorneyDate(Util.getDate());
            }
    		
//	    	if(Util.isEmpty(this.getFlowKey())) {
//	    		if(!Util.isEmpty(this.getOffice())) {
//	    			String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
//	    			String sql = "select flowkey from TrademarkCase where flowkey like '" + year + "%' order by flowkey desc";
//	    			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
//	    			int max = 1;
//	    			if(keys != null && !keys.isEmpty()) {
//	    				String key = keys.get(0);
//	    				max = Integer.parseInt( key.substring(2, 6) ) + 1;
//	    			}
//	    			this.FlowKey.setValue( year + String.format("%04d", max) + this.getOffice());
//	    		}
//	    		else {
//	    			this.setErrorMessage("請輸入申請國家!");
//	    			return true;
//	    		}
//	    	}
//	    	else {
////	    		String flowKey = FlowEngin.getPkeyNo(this.getClient()+"-T", 3, false, "") + this.getPatentOffice();
//	    		String oldFlowKey = this.getFlowKey();
//	    		String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
//	    		String sql = "select count(1) as Count from TrademarkCase where flowkey like '" + oldFlowKey + "%'";
//
//	    		int count = Integer.parseInt(this.getDbUtil().getFieldValue(sql, "Count"));
//	    		
//	    		sql = "select flowkey from TrademarkCase where flowkey like '" + year +"%' order by flowkey desc";
//    			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
//    			int max = 1;
//    			if(keys != null && !keys.isEmpty()) {
//    				String key = keys.get(0);
//    				max = Integer.parseInt( key.substring(2, 6) ) + 1;
//    			}
//    			String flowkey = year + String.format("%04d", max) + this.getOffice();
//	
//	    		if(count > 0) {
//	    			this.setErrorMessage("案件編號 " + this.getFlowKey() + "已經被使用，已將案件編號修改為" + flowkey);
//	    			this.setFlowKey(flowkey);
//	    			return true;
//	    		}
//	    	}
    	}
    	
        if(super.checkInsertError()){
            return true;
        } else {
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
    
    public String printDetailTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if(this.getTabText().equals("TrademarkCategory")){
        	rtnString = new TrademarkCategory().getSearchReasult(this.getUserInfo(),this.getFlowKey());
       }
        if(this.getTabText().equals("TrademarkApplicant")){
        	rtnString = new TrademarkApplicant().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkInventor")){
        	rtnString = new TrademarkInventor().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkAttorney")){
        	rtnString = new TrademarkAttorney().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkPriority")){
        	rtnString = new TrademarkPriority().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkDocument")){
        	rtnString = new TrademarkDocument().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("TrademarkToDos")) {
            rtnString = new TrademarkToDos().getSearchReasult(this.getUserInfo(), this
                        .getFlowKey());
        }
        if(this.getTabText().equals("TrademarkSecondPage")){
        	rtnString = "<table width='100%' " + this.getTableBgcolor() + ">";
        	            
            this.InternalNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                        
            if(Util.isEmpty(this.getAttorneyDate()) && 
            		this.getDbActionMode().equals(Cnstnts.INSERT)) {
            	this.setAttorneyDate(Util.getDate());
            }
            this.AttorneyDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.AttorneyDate.setAnotherField(this.InternalNo);
            this.AttorneyDate.setColspan(1);
            rtnString += this.printHtml(this.AttorneyDate);
            
            this.FillingNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.FillingDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.FillingDate.setAnotherField(this.FillingNum);
            this.FillingDate.setColspan(1);
            rtnString += this.printHtml(this.FillingDate);
            
            this.PublicationNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.PublicationDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.PublicationDate.setAnotherField(this.PublicationNum);
            this.PublicationDate.setColspan(1);
            rtnString += this.printHtml(this.PublicationDate);
            
            this.IssueNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.IssueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.IssueDate.setAnotherField(this.IssueNo);
            this.IssueDate.setColspan(1);
            rtnString += this.printHtml(this.IssueDate);
            
            this.RegistNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.RegistDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.RegistDate.setAnotherField(this.RegistNum);
            this.RegistDate.setColspan(1);
            rtnString += this.printHtml(this.RegistDate);
            
            this.TrademarkNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.TrademarkNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TrademarkNum.setColspan(1);
            this.TrademarkNum.setAnotherField(this.TrademarkNo);
            rtnString += this.printHtml(this.TrademarkNum);
            
//            this.ExtendDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
//            
//            this.ExpiryDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
//            this.ExpiryDateTo.setAnotherField(this.ExtendDate);
//            
//            this.ExpiryDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
//            this.ExpiryDate.setAnotherField(this.ExpiryDateTo);
//            this.ExpiryDate.setColspan(3);
//            rtnString += this.printHtml(this.ExpiryDate);
            
            
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
            this.OathYear.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.OathYear.setSelectList(feeItems);
            
            this.OathDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.OathDate.setAnotherField(this.OathYear);
            this.OathDate.setColspan(1);
            rtnString += this.printHtml(this.OathDate);
            
//            this.ExtendTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ExpiryDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.ExpiryDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ExpiryDate.setAnotherField(this.ExpiryDateTo);
            this.ExpiryDate.setColspan(1);
            rtnString += this.printHtml(this.ExpiryDate);
            
            this.AutoPay.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            
            this.PaymentConfirming.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.PaymentConfirming.setAnotherField(this.AutoPay);
            this.PaymentConfirming.setColspan(1);
            rtnString += this.printHtml(this.PaymentConfirming);
           
            this.Attorney.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Attorney.setSelectList(new Attorney().getList());
            this.Attorney.setSize(30);
            
            this.AttorneyNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AttorneyNo.setAnotherField(this.Attorney);
            this.AttorneyNo.setColspan(1);
            rtnString += this.printHtml(this.AttorneyNo);
            
            this.AttorneyNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.ExtendTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ExtendTime.setAnotherField(this.AttorneyNum);
            this.ExtendTime.setColspan(1);
            rtnString += this.printHtml(this.ExtendTime);
            
            this.TrademarkCaseCloseStatus.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.TrademarkCaseCloseStatus.setSelectList(new Category().getChildList("TrademarkCaseCloseStatus"));
            
            this.ClosedDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ClosedDate.setAnotherField(this.TrademarkCaseCloseStatus);
            this.ClosedDate.setColspan(1);
            rtnString +=this.printHtml(this.ClosedDate);
            
            //詳細資料tab 欄位"主張優先權案號" 隱藏
//            this.PriorityCaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.PriorityCaseNo.printHiddenTag();
            
            this.NoSDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            /*
    此欄位選項會根據此案件的client欄位資料來篩選Applicant table中資料client欄位資料
    等於此案件client欄位資料的Applicant資料，而顯示出此Applicant的Names
             */
            String sql = "select FlowKey, Names from applicant where Client = '" + this.getClient() + "' and ShowInClient ='Y'  and ApplicantKind like '%CLK01;%'";
            this.ClientContect.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.ClientContect.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("Names", ""), false));
            this.ClientContect.setAnotherField(this.NoSDate);
            this.ClientContect.setColspan(1);
            rtnString += this.printHtml(this.ClientContect);
            
//            this.Sales.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            //this.ExtendTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            //this.TrademarkCaseStatus.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            //this.TrademarkCaseStatus.setSelectList(new Category().getChildList("TrademarkCaseStatus"));
            //this.TrademarkCaseStatus.setAnotherField(this.Sales);
            //this.TrademarkCaseStatus.setColspan(1);
            //rtnString += this.printHtml(this.TrademarkCaseStatus);
            
//            sql = "select FlowKey, Emp_name from employee order by flowkey";
//            items = this.getDbUtil().getSelectItemList(sql, "Emp_name");
//            this.Sales.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//            this.Sales.setSelectList(items);
//            
//            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//            this.Status.setSelectList(new Category().getChildList("TrademarkCaseStatus"));
//            this.Status.setAnotherField(this.Sales);
//            this.Status.setColspan(1);
//            rtnString += this.printHtml(this.Status);
            
            this.EngWordsinMark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.EngWordsinMark.setCols(40);
            this.EngWordsinMark.setRows(2);
            
            this.ChtWordsinMark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.ChtWordsinMark.setCols(40);
            this.ChtWordsinMark.setRows(2);
            this.ChtWordsinMark.setColspan(1);
            this.ChtWordsinMark.setAnotherField(this.EngWordsinMark);
            rtnString += this.printHtml(this.ChtWordsinMark);
            	
        	this.DesignMark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        	this.DesignMark.setCols(40);
        	this.DesignMark.setRows(2);
            
            this.JapWordsinMark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.JapWordsinMark.setCols(40);
            this.JapWordsinMark.setRows(2);
            this.JapWordsinMark.setColspan(1);
            this.JapWordsinMark.setAnotherField(this.DesignMark);
            rtnString += this.printHtml(this.JapWordsinMark);
            
            this.GraphDesc.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.GraphDesc.setCols(40);
            this.GraphDesc.setRows(2);
            
            this.Significance.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Significance.setCols(40);
            this.Significance.setRows(2);
            this.Significance.setAnotherField(this.GraphDesc);
            this.Significance.setColspan(1);
            rtnString += this.printHtml(this.Significance);
            

            this.SpecialRequest.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.SpecialRequest.setColspan(3);
            this.SpecialRequest.setCols(60);
            this.SpecialRequest.setRows(3);
            this.SpecialRequest.setLength(500);
            rtnString += this.printHtml(this.SpecialRequest);
            
            this.Remark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Remark.setCols(70);
            this.Remark.setRows(2);
            this.Remark.setColspan(3);
            this.Remark.setLength(500);
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
  
            rtnString += "</table>";
        } else {

        	rtnString += this.AttorneyNum.printHiddenTag();
        	rtnString += this.AttorneyDate.printHiddenTag();
        	rtnString += this.FillingNum.printHiddenTag();
        	rtnString += this.FillingDate.printHiddenTag();
        	rtnString += this.PublicationNum.printHiddenTag();
        	rtnString += this.PublicationDate.printHiddenTag();
        	rtnString += this.RegistNum.printHiddenTag();
        	rtnString += this.RegistDate.printHiddenTag();
        	rtnString += this.TrademarkNo.printHiddenTag();
        	rtnString += this.TrademarkNum.printHiddenTag();
        	rtnString += this.OathYear.printHiddenTag();
        	rtnString += this.OathDate.printHiddenTag();
        	rtnString += this.ClosedDate.printHiddenTag();
        	rtnString += this.Status.printHiddenTag();
        	rtnString += this.TrademarkCaseCloseStatus.printHiddenTag();
        	rtnString += this.TrademarkCaseStatus.printHiddenTag();
        	rtnString += this.Sales.printHiddenTag();
        	rtnString += this.GraphDesc.printHiddenTag();
        	rtnString += this.Significance.printHiddenTag();
        	rtnString += this.Color.printHiddenTag();
        	rtnString += this.NoBelongDesc.printHiddenTag();
        	rtnString += this.Creator.printHiddenTag();
        	rtnString += this.CreateTime.printHiddenTag();
        }
        return rtnString;
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
		sqlList.add("delete from TrademarkCategory where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkApplicant where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkDocument where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkInventor where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkAttorney where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from TrademarkPriority where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from ToDos where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from casePrivilege where CaseKey='"+this.getFlowKey()+"'");
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
    
    public boolean insert() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.FlowKey.setValue(this.FlowKey.getValue().trim());
		this.setDbFields();
		//sqlList.add(this.getDbUtil().getInsertSQL(this.getTableName(), this.DbFields));
		if(Util.compareTo(this.getInternalNoCheck(), "Y")) {
			String sql = "select InternalNo from trademarkcase where flowkey='" + this.getFromCase() + "'";
			String InternalNo = this.getDbUtil().getFieldValue(sql, "InternalNo");
			this.setInternalNo(InternalNo);
		}
		super.insert();
		
		//20120918於既有案件中新增功能可以複製該筆資料的“申請人”、“代理人”、“優先權”資料
		if(Util.compareTo(this.getApplicantCopyCheck(), "Y")) {
			String sql = "select flowkey from TrademarkApplicant where parentid='" + this.getFromCase() + "'";
			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
			for(String key : keys) {
				TrademarkApplicant clazz = new TrademarkApplicant(key);
				clazz.setFlowKey(FlowEngin.getPkeyNo(this.getFlowKey(), 3, false, "."));
				clazz.setParentId(this.getFlowKey());
				
				sqlList.add(this.getDbUtil().getInsertSQL("TrademarkApplicant", clazz.getDbFields()));
			}
		}
		if(Util.compareTo(this.getAttorneyCopyCheck(), "Y")) {
			String sql = "select flowkey from TrademarkAttorney where parentid='" + this.getFromCase() + "'";
			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
			for(String key : keys) {
				TrademarkAttorney clazz = new TrademarkAttorney(key);
				clazz.setFlowKey(FlowEngin.getPkeyNo(this.getFlowKey(), 3, false, "."));
				clazz.setParentId(this.getFlowKey());
				
				sqlList.add(this.getDbUtil().getInsertSQL("TrademarkAttorney", clazz.getDbFields()));
			}
		}
		if(Util.compareTo(this.getPriorityCopyCheck(), "Y")) {
			String sql = "select flowkey from TrademarkPriority where parentid='" + this.getFromCase() + "'";
			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
			for(String key : keys) {
				TrademarkPriority clazz = new TrademarkPriority(key);
				clazz.setFlowKey(FlowEngin.getPkeyNo(this.getFlowKey(), 3, false, "."));
				clazz.setParentId(this.getFlowKey());
				
				sqlList.add(this.getDbUtil().getInsertSQL("TrademarkPriority", clazz.getDbFields()));
			}
		}

		
		//1. 負責程序人員CaseAD 若儲存後，自動將該人員也寫入案件權限列表（權限勾選：檢視＋編輯＋列印＋Tab ）
//		if(!Util.isEmpty(this.getCaseAD())) {
			createPrivilege("111001", this.getCaseAD(), this.getCaseKind() + "C");
//		}
		
//		if(!Util.isEmpty(this.getSales())) {
			createPrivilege("100000", this.getSales(), this.getCaseKind() + "S");
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
					"PatentType='" + this.getTrademarkType() + "', PatentOffice='" + this.getOffice() + "', " +
					"OriginalTitle='" + this.getTitle() + "/" + this.getEnglishTitle() + "', CaseKind='STC02' " +
					"where RelatedCaseNo ='" + this.getFlowKey() + "'");
			
			//1. 負責程序人員CaseAD 若儲存後，自動將該人員也寫入案件權限列表（權限勾選：檢視＋編輯＋列印＋Tab ）
//			if(!Util.isEmpty(this.getCaseAD())) {
				createPrivilege("111001", this.getCaseAD(), this.getCaseKind() + "C");
//			}
			
//			if(!Util.isEmpty(this.getSales())) {
				createPrivilege("100000", this.getSales(), this.getCaseKind() + "S");
//			}
			//承辦人員 改為 業務主管，該案件資料新增後若該欄位編輯儲存，將該人員加入案件清單權限為V 檢視，當該欄位修改儲存將該案件權限清單該人員舊的換掉，替換為新儲存的。
//			if(!Util.isEmpty(this.getCaseAssignedTo())) {
				createPrivilege("100000", this.getCaseAssignedTo(), this.getCaseKind() + "A");
//			}
			
			
			return updateToDosValue(this);
		}
		
		return false;
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
    	String outputFile = "TrademarkCase/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".doc";
    	String outputDoc = "file:///"+Util.getDocPath()+outputFile;
    	if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		
    		String SQL = "";
    		
    		Map data = new HashMap();
    		
    		String attorneyAddress = Cnstnts.EMPTY_STRING;
    		String attorneyContact = Cnstnts.EMPTY_STRING;
    		
    		Properties categoryProp = new Category().getNamesPrpts();
    		Properties employeeProp = new Employee().getNamesPrpts();
    		Properties attorneyProp = new Attorney().getNamesPrpts();
    		Properties applicantProp = new Applicant().getNamesPrpts();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
    		
    		TrademarkCase trade = new TrademarkCase(this.getFlowKey());
    		List<Field> fields = trade.getDbFields();
    		
//    		SQL = "select p.* from trademarkCase p where p.FlowKey='"+this.getFlowKey()+"'";
//    		this.setDbFields();
//    		List<Field> fields = this.getDbFields();
//    		this.getDbUtil().getAttribute(SQL, fields);
    		for(Field field : fields) {
    			String name = field.getName();
    			String value = field.getValue();
    			
    			if(name.endsWith("Date") || name.endsWith("DateTo") ||
    					name.equalsIgnoreCase("DeadLine") ||
    					name.equalsIgnoreCase("ExtendTime")) {

//    				try {
//    					value = sdf2.format(sdf.parse(value));
//    				}
//    				catch(Exception e) {}
    				//將日期轉換成年月日
    				data = Util.putDateToMap(name, value, data);
    			}
    			else if(name.equalsIgnoreCase("Office") ||
    					name.equalsIgnoreCase("TrademarkType") ||
    					name.equalsIgnoreCase("Status") ||
    					name.equalsIgnoreCase("Color") ||
    					name.equalsIgnoreCase("TrademarkCaseType") ||
    					name.equalsIgnoreCase("MarkType") ||
    					name.equalsIgnoreCase("TrademarkCaseStatus") ||
    					name.equalsIgnoreCase("TrademarkCaseCloseStatus")) {
    				value = categoryProp.getProperty(value);
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
    			else if(name.equalsIgnoreCase("CaseAD") ||
    					name.equalsIgnoreCase("Sales") ||
    					name.equalsIgnoreCase("CaseAssignedTo")) {
    				value = employeeProp.getProperty(value);
    			}
    			else if(name.equalsIgnoreCase("Client")) {
    				data.put("${ClientName}", new Client().getNamesPrpts().getProperty(value));
    			}

    			data.put("${" + name + "}", value);
    		}
    		
    		data.put("${TrademarkAttorneyAddress}", attorneyAddress);
    		data.put("${TrademarkAttorneyContact}", attorneyContact);
    		
    		String trademarkinventor = "";
			SQL = "select p.InventorName from trademarkinventor p " +
					"where p.parentid ='" + this.getFlowKey() + "' " +
					"order by CAST(p.InventorOrder AS DECIMAL(10))";
			List<String> names = this.getDbUtil().getValueList(SQL, "InventorName");
			for(int j=0;j<names.size();j++) {
				String s = names.get(j);
				if(j==0) {
					trademarkinventor += s;
				}
				else {
					trademarkinventor += ";" + s;
				}
			}
			data.put("${TrademarkInventors}", trademarkinventor);
			
			String trademarkapplicant  = "";
			SQL = "select a.Names from trademarkapplicant  p left join applicant as a on a.FlowKey = p.ApplicantId " +
					"where p.parentid ='" + this.getFlowKey() + "' " +
					"order by CAST(p.ApplicantOrder AS DECIMAL(10))";
			names = this.getDbUtil().getValueList(SQL, "Names");
			for(int j=0;j<names.size();j++) {
				String s = names.get(j);
				if(j==0) {
					trademarkapplicant += s;
				}
				else {
					trademarkapplicant += ";" + s;
				}
			}
			data.put("${TrademarkApplicants}", trademarkapplicant);
			
			String trademarkApplicantIdNo  = Cnstnts.EMPTY_STRING;
			String trademarkApplicantAddress= Cnstnts.EMPTY_STRING;
			String trademarkApplicantAddress2= Cnstnts.EMPTY_STRING;
			String trademarkApplicantEnglishAddress= Cnstnts.EMPTY_STRING;
			String trademarkApplicantEnglishAddress2= Cnstnts.EMPTY_STRING;
			
			String trademarkApplicantCompanyReq= Cnstnts.EMPTY_STRING;
			
			
			SQL = "select p.flowkey, a.IdNo, a.Address, a.Address2, a.EnglishAddress, a.EnglishAddress2, a.CompanyReq from trademarkapplicant p left join applicant as a on a.FlowKey = p.ApplicantId  " +
					"where p.parentid ='" + this.getFlowKey() + "'";
			List<Object[]> applicantValues = this.getDbUtil().getList(SQL, new String[]{"IdNo", "Address", "Address2", "EnglishAddress", "EnglishAddress2","CompanyReq"});
			for(int k=0;k<applicantValues.size();k++) {
				Object[] s = applicantValues.get(k);
				if(k==0) {
					trademarkApplicantIdNo += s[1];
					trademarkApplicantAddress += s[2];
					trademarkApplicantAddress2 += s[3];
					trademarkApplicantEnglishAddress += s[4];
					trademarkApplicantEnglishAddress2 += s[5];
					trademarkApplicantCompanyReq += s[6];
				}
				else {
					trademarkApplicantIdNo += ";" + s[1];
					trademarkApplicantAddress += ";" + s[2];
					trademarkApplicantAddress2 += ";" + s[3];
					trademarkApplicantEnglishAddress += ";" + s[4];
					trademarkApplicantEnglishAddress2 += ";" + s[5];
					trademarkApplicantCompanyReq += ";" + s[6];
				}
			}
			data.put("${TrademarkApplicantsIdNo}", trademarkApplicantIdNo);
			data.put("${TrademarkApplicantsAddress}", trademarkApplicantAddress);
			data.put("${TrademarkApplicantsAddress2}", trademarkApplicantAddress2);
			data.put("${TrademarkApplicantsEnglishAddress}", trademarkApplicantEnglishAddress);
			data.put("${TrademarkApplicantsEnglishAddress2}", trademarkApplicantEnglishAddress2);
			data.put("${TrademarkApplicantsCompanyReq}", trademarkApplicantCompanyReq);
			
			String attorneyNames = Cnstnts.EMPTY_STRING;
			
			SQL = "select a.* from "+
	    			  "(select Attorney from trademarkattorney where ParentId='"+
	    			  			   this.getFlowKey()+"') p "+
	    			  "inner join Attorney a "+
	    			  "on a.FlowKey=p.Attorney ";
			Attorney attorney = new Attorney();
    		attorney.setDbFields();
        	List<List<Field>> attorneydataLst = attorney.getDbUtil().getFieldsList(SQL, attorney.getDbFields());
        	int i=1;
        	for(Iterator itr=attorneydataLst.iterator();itr.hasNext();i++){ 
                String LastName = Cnstnts.EMPTY_STRING;
                String FirstName = Cnstnts.EMPTY_STRING;
                List<Field> detailFieldsLst = (List<Field>)itr.next();
            	for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
                    Field detailField = (Field)fieldsItr.next();
                    if(detailField.getName().equals("LastName")){
                    	LastName = detailField.getValue();
                    }
                    if(detailField.getName().equals("FirstName")){
                    	FirstName = detailField.getValue();
                    }
                }
            	if(attorneyNames.length() > 0){
            		attorneyNames += ";";
            	}
            	attorneyNames += LastName + FirstName;
            	
            	
            }
        	data.put("${AttorneyNames}", attorneyNames);
			System.out.println("${AttorneyNames}"+" "+attorneyNames);
			
			
			String trademarkcategory  = "";
			SQL = "select NiceClassification from trademarkcategory where parentid ='" + this.getFlowKey() + "'";
			names = this.getDbUtil().getValueList(SQL, "NiceClassification");
			for(int j=0;j<names.size();j++) {
				String s = names.get(j);
				if(j==0) {
					trademarkcategory += s;
				}
				else {
					trademarkcategory += ";" + s;
				}
			}
			data.put("${TrademarkCategorys}", trademarkcategory);
			char newLine = Cnstnts.NEW_LINE;
			String patentpriority  = "";
			SQL = "select p.flowkey, a.names, p.PriorityDate, p.ApplyNo from trademarkpriority  p left join category a on a.flowkey=p.Country  where p.parentid ='" + this.getFlowKey() + "'";
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
			data.put("${TrademarkPrioritys"  + "}", patentpriority);
			
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
				setCreater(getFullSearchText3());
        	}
        	else if (divName.equals("cond2")) {
				setDataDept2(value);
				setCreateDept(value);
				setApplicant(getFullSearchText4());
				setCreater2(getFullSearchText4());
        	}
        }
        if(fieldName.equalsIgnoreCase("Title")) {
        	setTitle(value);
        }
        if(fieldName.equalsIgnoreCase("Status")) {
        	setStatus(value);
        }
        if(fieldName.equalsIgnoreCase("FillingNum")) {
        	setFillingNum(value);
        }
        if(fieldName.equalsIgnoreCase("RegistNum")) {
        	setRegistNum(value);
        }
        if(fieldName.equalsIgnoreCase("TrademarkNum")) {
        	setTrademarkNum(value);
        }
        if(fieldName.equalsIgnoreCase("TrademarkNo")) {
        	setTrademarkNo(value);
        }
        if(fieldName.equalsIgnoreCase("TrademarkCaseType")) {
        	setTrademarkCaseType(value);
        }
        if(fieldName.equalsIgnoreCase("TrademarkType")) {
        	setTrademarkType(value);
        }
        if(fieldName.equalsIgnoreCase("Client")) {
        	setClient(value);
        }
        if(fieldName.equalsIgnoreCase("Office")) {
        	setOffice(value);
        }
        if(fieldName.equalsIgnoreCase("Color")) {
        	setColor(value);
        }
        if(fieldName.equalsIgnoreCase("Sales")) {
        	setSales(value);
        }
        if(fieldName.equalsIgnoreCase("SerialMotherCase")) {
        	setSerialMotherCase(value);
        }
        if(fieldName.equalsIgnoreCase("PriorityCaseNo")) {
        	setPriorityCaseNo(value);
        }
        if(fieldName.equalsIgnoreCase("TrademarkClassification")) {
        	setTrademarkClassification(value);
        }
        if(fieldName.equalsIgnoreCase("CaseAD")) {
        	setCaseAD(value);
        }
        if(fieldName.equalsIgnoreCase("InternalNo")) {
        	setInternalNo(value);
        }
        if(fieldName.equalsIgnoreCase("AttorneyNo")) {
        	setCaseAD(value);
        }
        if(fieldName.equalsIgnoreCase("Attorney")) {
        	setAttorney(value);
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
            	"<option " + checkSelected(name, "CaseNo") + " value='CaseNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.CaseNo") + "</option>" +Cnstnts.NEW_LINE +
            	"<option " + checkSelected(name, "ClientName") + " value='ClientName'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.ClientName") + "</option>" +Cnstnts.NEW_LINE +
            	//"<option " + checkSelected(name, "CaseNo2") + " value='CaseNo2'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.CaseNo2") + "</option>" +Cnstnts.NEW_LINE +
            	"<option " + checkSelected(name, "Title") + " value='Title'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Title") + "</option>" +Cnstnts.NEW_LINE +
//            	"<option " + checkSelected(name, "Client") + " value='Client'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Client") + "</option>" + Cnstnts.NEW_LINE +
            	"<option " + checkSelected(name, "FillingNum") + " value='FillingNum'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.FillingNum") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "RegistNum") + " value='RegistNum'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.RegistNum") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "TrademarkNum") + " value='TrademarkNum'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.TrademarkNum") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "TrademarkNo") + " value='TrademarkNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.TrademarkNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "InternalNo") + " value='InternalNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.InternalNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "AttorneyNo") + " value='AttorneyNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.AttorneyNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "SerialMotherCase") + " value='SerialMotherCase'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.SerialMotherCase") + "</option>" +Cnstnts.NEW_LINE +
//	    		"<option " + checkSelected(name, "PriorityCaseNo") + " value='PriorityCaseNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.PriorityCaseNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "TrademarkClassification") + " value='TrademarkClassification'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.TrademarkClassification") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Office") + " value='Office'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Office") + "</option>" +Cnstnts.NEW_LINE +
	    		//新增"申請人" 要去找的是專利案件裡面 申請人Table的資料 抓的欄位是"聯絡人姓名名稱"
	    		"<option " + checkSelected(name, "CaseApplicantName") + " value='CaseApplicantName'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseApplicantNames") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "PriorityNo") + " value='PriorityNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.PriorityNo") + "</option>" +Cnstnts.NEW_LINE +
	    		//"<option value=''>" + this.getUserInfo().getMsg("jsp.PatentCase.FullSearch") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "ClientContect") + " value='ClientContect'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.ClientContect") + "</option>" +Cnstnts.NEW_LINE +
	    		"</select>";
        }
        if(name.equals("cond11")) {
        	htmlCode = "<select  id='" + name + "' name='" + name + "' onChange=\"changeDiv11(this, '" + name + "_div');\">" + Cnstnts.NEW_LINE;
        	
            if(getCond11() == null) {
                setCond11("");
            }
            
            htmlCode += 
            	"<option " + checkSelected(name, "CaseNo") + " value='CaseNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.CaseNo") + "</option>" +Cnstnts.NEW_LINE +
            	"<option " + checkSelected(name, "ClientName") + " value='ClientName'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.ClientName") + "</option>" +Cnstnts.NEW_LINE +
            	//"<option " + checkSelected(name, "CaseNo2") + " value='CaseNo2'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.CaseNo2") + "</option>" +Cnstnts.NEW_LINE +
            	"<option " + checkSelected(name, "Title") + " value='Title'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Title") + "</option>" +Cnstnts.NEW_LINE +
//            	"<option " + checkSelected(name, "Client") + " value='Client'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Client") + "</option>" + Cnstnts.NEW_LINE +
            	"<option " + checkSelected(name, "FillingNum") + " value='FillingNum'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.FillingNum") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "RegistNum") + " value='RegistNum'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.RegistNum") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "TrademarkNum") + " value='TrademarkNum'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.TrademarkNum") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "TrademarkNo") + " value='TrademarkNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.TrademarkNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "InternalNo") + " value='InternalNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.InternalNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "AttorneyNo") + " value='AttorneyNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.AttorneyNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "SerialMotherCase") + " value='SerialMotherCase'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.SerialMotherCase") + "</option>" +Cnstnts.NEW_LINE +
//	    		"<option " + checkSelected(name, "PriorityCaseNo") + " value='PriorityCaseNo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.PriorityCaseNo") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "TrademarkClassification") + " value='TrademarkClassification'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.TrademarkClassification") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Office") + " value='Office'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Office") + "</option>" +Cnstnts.NEW_LINE +
	    		//新增"申請人" 要去找的是專利案件裡面 申請人Table的資料 抓的欄位是"聯絡人姓名名稱"
	    		"<option " + checkSelected(name, "CaseApplicantName") + " value='CaseApplicantName'>" + this.getUserInfo().getMsg("jsp.PatentCase.CaseApplicantNames") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "PriorityNo") + " value='PriorityNo'>" + this.getUserInfo().getMsg("jsp.PatentCase.PriorityNo") + "</option>" +Cnstnts.NEW_LINE +
	    		//"<option value=''>" + this.getUserInfo().getMsg("jsp.PatentCase.FullSearch") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "ClientContect") + " value='ClientContect'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.ClientContect") + "</option>" +Cnstnts.NEW_LINE +
	    		"</select>";
        }
        if(name.equals("cond2")) {
        	htmlCode = "<select  id='" + name + "' name='" + name + "' onChange=\"changeDiv" + function + "(this, '" + name + "_div');setValue();\">" + Cnstnts.NEW_LINE;
        	
            if(getCond2() == null) {
                setCond2("");
            }
            function = "2";
            
            htmlCode += //"<option value=''>" + this.getUserInfo().getMsg("jsp.TrademarkCase.FullSearch") + "</option>" +Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "TrademarkType") + " value='TrademarkType'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.TrademarkType") + "</option>" +Cnstnts.NEW_LINE +
	    		
	    		"<option " + checkSelected(name, "Color") + " value='Color'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Color") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Status") + " value='Status'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Status") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "CaseAD") + " value='CaseAD'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.CaseAD") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Sales") + " value='Sales'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Sales") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Attorney") + " value='Attorney'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Attorney") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "CaseAssignedTo") + " value='CaseAssignedTo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.CaseAssignedTo") + "</option>" + Cnstnts.NEW_LINE +
	    		"<option " + checkSelected(name, "Referrals") + " value='Referrals'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.Referrals") + "</option>" + Cnstnts.NEW_LINE +
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
                "<option " + (getCond3().equals("AttorneyDate")?"selected":"") + " value='AttorneyDate'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.AttorneyDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("FillingDate")?"selected":"") + " value='FillingDate'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.FillingDate") + "</option>" + Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("RegistDate")?"selected":"") + " value='RegistDate'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.RegistDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("OathDate")?"selected":"") + " value='OathDate'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.OathDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("ExpiryDate")?"selected":"") + " value='ExpiryDate'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.ExpiryDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("ExpiryDateTo")?"selected":"") + " value='ExpiryDateTo'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.ExpiryDateTo") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("ClosedDate")?"selected":"") + " value='ClosedDate'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.ClosedDate") + "</option>" +Cnstnts.NEW_LINE +
                "<option " + (getCond3().equals("ContactDate")?"selected":"") + " value='ContactDate'>" + this.getUserInfo().getMsg("jsp.TrademarkCase.ContactDate") + "</option>" +Cnstnts.NEW_LINE +
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
    		
    		scriptCode += "if(id == '' || id == 'CaseNo' || id == 'CaseNo2' || id == 'FillingNum' || id == 'RegistNum' || id == 'Title' " +
    				" || id == 'Client' || id == 'ClientName' || id == 'TrademarkNum' || id == 'InternalNo'" +
    				" || id == 'TrademarkNo' || id == 'Office' || id == 'SerialMotherCase' || id == 'AttorneyNo'" +
    				" || id == 'Attorney'   || id == 'ClientContect' || id == 'PriorityNo' || id == 'PriorityCaseNo' || id == 'TrademarkClassification' || id == 'CaseApplicantName') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"<input type='text' id='" + name + "' name='" + name + "' maxLength='200' value='" + getFullSearchText1() + "'/>\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    		
    	}
    	else if(name.equalsIgnoreCase("fullSearchText11")) {
    		scriptCode += "function changeDiv11(selecter, div) {" + Cnstnts.NEW_LINE +
				"var id = selecter[selecter.selectedIndex].value;" + Cnstnts.NEW_LINE +
				"var htmlCode;" + Cnstnts.NEW_LINE;
    		
    		scriptCode += "if(id == '' || id == 'CaseNo' || id == 'CaseNo2' || id == 'FillingNum' || id == 'RegistNum' || id == 'Title' " +
    				" || id == 'Client' || id == 'ClientName' || id == 'TrademarkNum' || id == 'InternalNo'" +
    				" || id == 'TrademarkNo' || id == 'Office' || id == 'SerialMotherCase' || id == 'AttorneyNo'" +
    				" || id == 'Attorney'   || id == 'ClientContect' || id == 'PriorityNo' || id == 'PriorityCaseNo' || id == 'TrademarkClassification' || id == 'CaseApplicantName') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"<input type='text' id='" + name + "' name='" + name + "' maxLength='200' value='" + getFullSearchText11() + "'/>\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    		
    	}
    	else if(name.equalsIgnoreCase("fullSearchText2")) {
    		scriptCode += "function changeDiv2(selecter, div) {" + Cnstnts.NEW_LINE +
				"var id = selecter[selecter.selectedIndex].value;" + Cnstnts.NEW_LINE +
				"var htmlCode;" + Cnstnts.NEW_LINE;
		
    		scriptCode += "if(id == '' || id == 'FlowKey' || id == 'FillingNum' || id == 'RegistNum' || id == 'Title' " +
				" || id == 'Client' || id == 'ClientName' || id == 'TrademarkNum' || id == 'TrademarkNo'  || id == 'SerialMotherCase' || id == 'PriorityCaseNo') {" + Cnstnts.NEW_LINE +
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
					getSearchCreatorListHtml(super.getDataDept(), getCreater()).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
					"}" + Cnstnts.NEW_LINE;
	    	this.CreateDept.setName(oldName);

    	}
    	else if(name.equals("fullSearchText11")) {
    		inputValue = this.getFullSearchText11();
    		
    		oldName = this.CreateDept.getName();
	    	this.CreateDept.setName(name);
	    	scriptCode += "else if(id == 'CreateDept') {" + Cnstnts.NEW_LINE +
					"htmlCode = \"" + getSearchDeptListHtml(super.getDataDept()).replaceAll("\n", "") + "   " + 
					getSearchCreatorListHtml(super.getDataDept(), getCreater()).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
					"}" + Cnstnts.NEW_LINE;
	    	this.CreateDept.setName(oldName);

    	}
    	else if(name.equals("fullSearchText2")) {
    		inputValue = this.getFullSearchText2();
    		
    		oldName = this.CreateDept.getName();
	    	this.CreateDept.setName(name);
	    	scriptCode += "else if(id == 'CreateDept') {" + Cnstnts.NEW_LINE +
					"htmlCode = \"" + getSearchDeptListHtml(this.getDataDept2()).replaceAll("\n", "") + "   " + 
					getSearchCreatorListHtml(this.getDataDept2(), this.getCreater2()).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
					"}" + Cnstnts.NEW_LINE;
	    	this.CreateDept.setName(oldName);

    	}

//    	oldName = this.ClientContect.getName();
//    	this.ClientContect.setName(name);
//    	scriptCode += "else if(id == 'ClientContect') {" + Cnstnts.NEW_LINE +
//				"htmlCode = \"" + printTag(this.ClientContect).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
//				"}" + Cnstnts.NEW_LINE;
//    	this.ClientContect.setName(oldName);
    	
    	oldName = this.Status.getName();
    	this.Status.setName(name);
    	this.Status.setMapingPrpt(null);
    	scriptCode += "else if(id == 'Status') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.Status).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.Status.setName(oldName);
    	this.Status.setMapingPrpt(new Category().getNamesPrpts());
    	

    	oldName = this.Referrals.getName();
    	this.Referrals.setName(name);
    	scriptCode += "else if(id == 'Referrals') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.Referrals).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.Referrals.setName(oldName);
    	
    	
    	oldName = this.TrademarkType.getName();
    	this.TrademarkType.setName(name);
    	scriptCode += "else if(id == 'TrademarkType') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.TrademarkType).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.TrademarkType.setName(oldName);

    	oldName = this.Attorney.getName();
    	this.Attorney.setName(name);
    	scriptCode += "else if(id == 'Attorney') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.Attorney).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.Attorney.setName(oldName);
    	
    	
//    	oldName = this.Office.getName();
//    	this.Office.setName(name);
//    	scriptCode += "else if(id == 'Office') {" + Cnstnts.NEW_LINE +
//				"htmlCode = \"" + printTag(this.Office).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
//				"}" + Cnstnts.NEW_LINE;
//    	this.Office.setName(oldName);
    	
    	this.Color.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        this.Color.setSelectList(new Category().getChildList("Color"));
    	oldName = this.Color.getName();
    	this.Color.setName(name);
    	scriptCode += "else if(id == 'Color') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.Color).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.Color.setName(oldName);
    	
		List<SelectItem> items = new Employee().getList();
        this.Sales.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        this.Sales.setSelectList(items);
        
    	oldName = this.Sales.getName();
    	this.Sales.setName(name);
    	scriptCode += "else if(id == 'Sales') {" + Cnstnts.NEW_LINE +
				"htmlCode = \"" + printTag(this.Sales).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
				"}" + Cnstnts.NEW_LINE;
    	this.Sales.setName(oldName);
    	
    	this.CaseAssignedTo.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    	this.CaseAssignedTo.setSelectList(items);
    	
    	oldName = this.CaseAssignedTo.getName();
    	this.CaseAssignedTo.setName(name);
    	scriptCode += "else if(id == 'CaseAssignedTo') {" + Cnstnts.NEW_LINE +
    	"htmlCode = \"" + printTag(this.CaseAssignedTo).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
    	"}" + Cnstnts.NEW_LINE;
    	this.CaseAssignedTo.setName(oldName);
    	
    	this.CaseAD.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    	this.CaseAD.setSelectList(items);
    	
    	oldName = this.CaseAD.getName();
    	this.CaseAD.setName(name);
    	scriptCode += "else if(id == 'CaseAD') {" + Cnstnts.NEW_LINE +
    	"htmlCode = \"" + printTag(this.CaseAD).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
    	"}" + Cnstnts.NEW_LINE;
    	this.CaseAD.setName(oldName);
    	
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
    	
    	Properties categoryPrpt = null;
    	try {
			categoryPrpt = new Category().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
//        this.ResultFields.put(this.CaseNo2.getName(), this.CaseNo2); 
        this.ResultFields.put(this.Title.getName(), this.Title);
        this.ResultFields.put(this.Office.getName(), this.Office);
    	this.ResultFields.put(this.TrademarkType.getName(), this.TrademarkType);
    	this.ResultFields.put(this.Status.getName(), this.Status);
    	this.ResultFields.put(this.FillingDate.getName(), this.FillingDate);
    	this.ResultFields.put(this.FillingNum.getName(), this.FillingNum);
    	this.ResultFields.put(this.PublicationDate.getName(), this.PublicationDate);
    	this.ResultFields.put(this.PublicationNum.getName(), this.PublicationNum);
    	this.ResultFields.put(this.RegistDate.getName(), this.RegistDate);
    	this.ResultFields.put(this.RegistNum.getName(), this.RegistNum);
    	this.ResultFields.put(this.IssueDate.getName(), this.IssueDate);
    	this.ResultFields.put(this.IssueNo.getName(), this.IssueNo);
    	
        this.ResultFields.put(this.MarkType.getName(), this.MarkType);
        this.ResultFields.put(this.TrademarkClassification.getName(), this.TrademarkClassification);
        this.ResultFields.put(this.ClientName.getName(), this.ClientName);
        this.ResultFields.put(this.SerialMotherCase.getName(), this.SerialMotherCase);
        this.ResultFields.put(this.Color.getName(), this.Color);
        this.Color.setMapingPrpt(categoryPrpt);
        this.Color.setNotShowCode(true);
        this.ResultFields.put(this.AttorneyDate.getName(), this.AttorneyDate);
//    	this.ResultFields.put(this.PriorityCaseNo.getName(), this.PriorityCaseNo);
    	this.ResultFields.put(this.OathDate.getName(), this.OathDate);
    	this.ResultFields.put(this.ExpiryDate.getName(), this.ExpiryDate);
    	this.ResultFields.put(this.ExpiryDateTo.getName(), this.ExpiryDateTo);
    	this.ResultFields.put(this.ExtendTime.getName(), this.ExtendTime);
    	this.ResultFields.put(this.LastSchedule.getName(), this.LastSchedule);
    	this.ResultFields.put(this.GoodsServices.getName(), this.GoodsServices);
    	this.ResultFields.put(this.Attorney.getName(), this.Attorney);
    	this.Attorney.setMapingPrpt(attorneyPrpt);
    	this.Attorney.setNotShowCode(true);
    	this.ResultFields.put(this.ClientContect.getName(), this.ClientContect);
    	this.ResultFields.put(this.CaseApplicantNames.getName(), this.CaseApplicantNames);
    	this.ResultFields.put(this.CaseAD.getName(), this.CaseAD);
    	this.CaseAD.setMapingPrpt(empPrpt);
    	this.CaseAD.setNotShowCode(true);
    	this.ResultFields.put(this.Sales.getName(), this.Sales);
    	this.Sales.setMapingPrpt(empPrpt);
    	this.Sales.setNotShowCode(true);
    	this.ResultFields.put(this.ContactDate.getName(), this.ContactDate);
    	this.ResultFields.put(this.AttorneyNo.getName(), this.AttorneyNo);
    	this.ResultFields.put(this.TrademarkImg.getName(), this.TrademarkImg);
    	this.ResultFields.put(this.CaseAssignedTo.getName(), this.CaseAssignedTo);
    	this.ResultFields.put(this.TrademarkImg.getName(), this.TrademarkImg);
    	this.ResultFields.put(this.Referrals.getName(), this.Referrals);
    	this.Referrals.setMapingPrpt(empPrpt);
    	this.Referrals.setNotShowCode(true);
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
    

    
    public String printCaseRenewalLogListTableHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		
		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.TrademarkRenewalLog.FlowKey")+"</td>";
		String thText3="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.TrademarkRenewalLog.ExpiryDateTo")+"</td>";
		String thText4="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.TrademarkRenewalLog.ExtendTime")+"</td>";
		String thText5="<td align='center' width='16%'>"+this.getUserInfo().getMsg("jsp.TrademarkRenewalLog.RenewStatus")+"</td>";
		String thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.TrademarkRenewalLog.KeepMaintain")+"</td>";
		String thText7="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.TrademarkRenewalLog.AddYear")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText7+thText8+"</tr>");
		
		String SQL = "select  r.* from TrademarkRenewalLog r where ParentId='"+this.getFlowKey()+"' order by ExpiryDateTo desc";
		
		TrademarkRenewalLog renewalLog = new TrademarkRenewalLog();
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
			String ExpiryDateTo = Cnstnts.EMPTY_STRING;
			String ExtendTime = Cnstnts.EMPTY_STRING;
			String RenewStatus = Cnstnts.EMPTY_STRING;
			String KeepMaintain = Cnstnts.EMPTY_STRING;
			String AddYear = Cnstnts.EMPTY_STRING;
			
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("ExpiryDateTo")){
					ExpiryDateTo = field.getValue();
				}
				if(field.getName().equals("ExtendTime")){
					ExtendTime = field.getValue();
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
			String onClick = " onClick='openAppendix(\"TrademarkRenewalLog.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"TrademarkRenewalLog\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td"+onClick+">"+FlowKey+"</td>";
			String tdText3="<td"+onClick+">"+ExpiryDateTo+"</td>";
			String tdText4="<td align='center'"+onClick+">"+ExtendTime+"</td>";
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
	
	public void doAction(UserBean userInfo) throws Exception {
    	this.setUserInfo(userInfo);
    	super.doAction(userInfo);
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
		1.申請國家=TW：申請國家英文代碼-TM(固定)西元年後二碼-四碼流水號
		　(例TW-TM20-0001)
		(1)申請國家英文代碼=TW
		(2)TM：固定
		(3)四碼流水號：每年重置，TW商標流水號共用
		
		2.申請國家非TW：T-客戶代碼-西元年後二碼-四碼流水號
		　(例T-客戶代碼-20-0001)
		(1)客戶代碼：資料源為客戶資料/客戶代碼
		(2)四碼流水號：每年重置，不同的客戶各自跑此類(此客戶非TW商標)的流水號
		
    	 */
    	
    	/*20220902 HH
    	 
    	產生編號按鈕的給號規則，紅字為本次新增
		商標:
		申請國家=TW：
		國家代碼-"客戶代碼"-TM(固定)西元年後二碼-四碼流水號　
		(例:TW-CG-TM20-0001)
		
		申請國家非TW：
		"國家代碼"-T-客戶代碼-西元年後二碼-四碼流水號
		(例:US-T-客戶代碼-20-0001)
    	 
    	 */
    	try {
    		String office = this.getOffice();    		    		
    		
    		String year = (Calendar.getInstance().get(Calendar.YEAR) + "").substring(2);
    		String sql = Cnstnts.EMPTY_STRING;
    		if("TW".equals(office)){
    			String client = this.getClient();
    		    			
    			//sql = "select CaseNo from (select CaseNo from trademarkcase where  (LENGTH(CaseNo) - LENGTH(REPLACE(CaseNo, '-', ''))) = 3) as p where CaseNo like 'TW-%-TM"+year+"-%' order by CaseNo desc;";
    			sql = "select SUBSTRING(CaseNo,(LENGTH(SUBSTRING_INDEX(CaseNo,'-TM" + year + "-',1)) + 7) ,LENGTH(CaseNo) -(LENGTH(SUBSTRING_INDEX(CaseNo,'-TM" + year + "-',1)) + 6)) as cc,CaseNo from (select CaseNo from trademarkcase where  (LENGTH(CaseNo) - LENGTH(REPLACE(CaseNo, '-', ''))) = 3) as p where CaseNo like 'TW-%-TM"+year+"-%' order by cast(cc as unsigned) desc;";
    			//List<String> keys = this.getDbUtil().getValueList(sql, "CaseNo");
    			List<String> keys = this.getDbUtil().getValueList(sql, "cc");
    			int max = 1;
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				//caseNumberLength = key.replaceAll(tempCaseNo, "").length();
    				//max = Integer.parseInt( key.substring(key.length() - caseNumberLength, key.length()) ) + 1;
    				max = Integer.parseInt( key ) + 1;
    			}
    			int max2 = max;
    			//sql = "select CaseNo2 from (select CaseNo2 from trademarkcase where  (LENGTH(CaseNo2) - LENGTH(REPLACE(CaseNo2, '-', ''))) = 3) as p where CaseNo2 like 'TW-%-TM"+year+"-%' order by CaseNo2 desc;";
    			sql = "select SUBSTRING(CaseNo2,(LENGTH(SUBSTRING_INDEX(CaseNo2,'-TM" + year + "-',1)) + 7) ,LENGTH(CaseNo2) -(LENGTH(SUBSTRING_INDEX(CaseNo2,'-TM" + year + "-',1)) + 6)) as cc,CaseNo2 from (select CaseNo2 from trademarkcase where  (LENGTH(CaseNo2) - LENGTH(REPLACE(CaseNo2, '-', ''))) = 3) as p where CaseNo2 like 'TW-%-TM"+year+"-%' order by cast(cc as unsigned) desc;";
    			//keys = this.getDbUtil().getValueList(sql, "CaseNo2");
    			keys = this.getDbUtil().getValueList(sql, "cc");
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				//caseNumberLength = key.replaceAll(tempCaseNo, "").length();
    				//max2 = Integer.parseInt( key.substring(key.length() - caseNumberLength, key.length()) ) + 1;
    				max2 = Integer.parseInt( key ) + 1;
    				if(max2 >= max) {
    					max = max2;
    				}
    			}
    			//caseNo =  "TW-TM" + year + "-" + String.format("%04d", max);
    			caseNo =  "TW-"+client+"-TM" + year + "-" + String.format("%04d", max);
    			
    		}else{
    			String client = this.getClient();
    			
    			//sql = "select CaseNo from (select CaseNo from trademarkcase where  (LENGTH(CaseNo) - LENGTH(REPLACE(CaseNo, '-', ''))) = 4) as p where CaseNo like '%-T-"+client+"-"+year+"-%' order by CaseNo desc;";
    			sql = "select SUBSTRING(CaseNo,(LENGTH(SUBSTRING_INDEX(CaseNo,'-"+year+"-',1)) + 5) ,LENGTH(CaseNo) -(LENGTH(SUBSTRING_INDEX(CaseNo,'-"+year+"-',1)) + 4)) as cc, CaseNo from (select CaseNo from trademarkcase where  (LENGTH(CaseNo) - LENGTH(REPLACE(CaseNo, '-', ''))) = 4) as p where CaseNo like '%-T-"+client+"-"+year+"-%' order by cast(cc as unsigned) desc;";
    			//List<String> keys = this.getDbUtil().getValueList(sql, "CaseNo");
    			List<String> keys = this.getDbUtil().getValueList(sql, "cc");
    			int max = 1;
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				//caseNumberLength = key.replaceAll(tempCaseNo, "").length();
    				//max = Integer.parseInt( key.substring(key.length() - caseNumberLength, key.length()) ) + 1;
    				max = Integer.parseInt( key ) + 1;
    			}
    			int max2 = max;
    			//sql = "select CaseNo2 from (select CaseNo2 from trademarkcase where  (LENGTH(CaseNo2) - LENGTH(REPLACE(CaseNo2, '-', ''))) = 4) as p where CaseNo2 like '%-T-"+client+"-"+year+"-%' order by CaseNo2 desc;";
    			sql = "select SUBSTRING(CaseNo2,(LENGTH(SUBSTRING_INDEX(CaseNo2,'-"+year+"-',1)) + 5) ,LENGTH(CaseNo2) -(LENGTH(SUBSTRING_INDEX(CaseNo2,'-"+year+"-',1)) + 4)) as cc, CaseNo2 from (select CaseNo2 from trademarkcase where  (LENGTH(CaseNo2) - LENGTH(REPLACE(CaseNo2, '-', ''))) = 4) as p where CaseNo2 like '%-T-"+client+"-"+year+"-%' order by cast(cc as unsigned) desc;";
    			//keys = this.getDbUtil().getValueList(sql, "CaseNo2");
    			keys = this.getDbUtil().getValueList(sql, "cc");
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				//caseNumberLength = key.replaceAll(tempCaseNo, "").length();
    				//max2 = Integer.parseInt( key.substring(key.length() - caseNumberLength, key.length()) ) + 1;
    				max2 = Integer.parseInt( key ) + 1;
    				if(max2 >= max) {
    					max = max2;
    				}
    			}
    			//caseNo =  "T-" + client + "-" + year + "-" + String.format("%04d", max);
    			caseNo =  office + "-T-" + client + "-" + year + "-" + String.format("%04d", max);
    			
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
							+ "onClick='downloadFile2(\"" + this.getOutputFile() + "\",\"t\",\""+this.getFlowKey()+"\")'/>";					
				}else{
					return Html.getPrintBtn(this.getOutputFile(), this.getUserInfo());
				}
			}
		} 
		return Cnstnts.EMPTY_STRING;
	}
}