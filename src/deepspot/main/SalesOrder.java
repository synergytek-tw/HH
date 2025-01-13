package deepspot.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import com.athenasoft.ooutil.OoConverter;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.Html;
import deepspot.util.DB;
import deepspot.util.Util;

public class SalesOrder extends MasterBean {

	public SalesOrder() {
		this.init();
	}
    public String changeInvoiceTitle1;

	public String getChangeInvoiceTitle1() {
		return changeInvoiceTitle1;
	}

	public void setChangeInvoiceTitle1(String changeInvoiceTitle1) {
		this.changeInvoiceTitle1 = changeInvoiceTitle1;
	}

	public SalesOrder(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public Field AttorneyCase;

	public void setAttorneyCase(String AttorneyCase) {
		this.AttorneyCase.setValue(AttorneyCase);
	}

	public String getAttorneyCase() {
		return this.AttorneyCase.getValue();
	}
    
    public Field SoStatus;
    public void setSoStatus(String SoStatus){this.SoStatus.setValue(SoStatus);}
    public String getSoStatus(){return this.SoStatus.getValue();}
    
    public Field RenewalLogKey;
    public void setRenewalLogKey(String RenewalLogKey){this.RenewalLogKey.setValue(RenewalLogKey);}
    public String getRenewalLogKey(){return this.RenewalLogKey.getValue();}

	public Field AttorneyTitle;

	public void setAttorneyTitle(String AttorneyTitle) {
		this.AttorneyTitle.setValue(AttorneyTitle);
	}

	public String getAttorneyTitle() {
		return this.AttorneyTitle.getValue();
	}

	public Field ParentId;

	public void setParentId(String ParentId) {
		this.ParentId.setValue(ParentId);
	}

	public String getParentId() {
		return this.ParentId.getValue();
	}

	public Field SoNo;

	public void setSoNo(String SoNo) {
		this.SoNo.setValue(SoNo);
	}

	public String getSoNo() {
		return this.SoNo.getValue();
	}

	public Field Client;

	public void setClient(String Client) {
		this.Client.setValue(Client);
	}

	public String getClient() {
		return this.Client.getValue();
	}

	public Field ClientName;

	public void setClientName(String ClientName) {
		this.ClientName.setValue(ClientName);
	}

	public String getClientName() {
		return this.ClientName.getValue();
	}
	
	public Field ServiceProjectCode;
	
	public void setServiceProjectCode(String ServiceProjectCode) {
		this.ServiceProjectCode.setValue(ServiceProjectCode);
	}
	
	public String getServiceProjectCode() {
		return this.ServiceProjectCode.getValue();
	}

	public Field OriginalTitle;

	public void setOriginalTitle(String OriginalTitle) {
		this.OriginalTitle.setValue(OriginalTitle);
	}

	public String getOriginalTitle() {
		return this.OriginalTitle.getValue();
	}

	public Field InCharge;

	public void setInCharge(String InCharge) {
		this.InCharge.setValue(InCharge);
	}

	public String getInCharge() {
		return this.InCharge.getValue();
	}
	
	public Field Remark;

	public void setRemark(String Remark) {
		this.Remark.setValue(Remark);
	}

	public String getRemark() {
		return this.Remark.getValue();
	}
	
	public Field QuotationDate;

	public void setQuotationDate(String QuotationDate) {
		this.QuotationDate.setValue(QuotationDate);
	}

	public String getQuotationDate() {
		return this.QuotationDate.getValue();
	}

	public Field CreateDate;

	public void setCreateDate(String CreateDate) {
		this.CreateDate.setValue(CreateDate);
	}

	public String getCreateDate() {
		return this.CreateDate.getValue();
	}

	public Field RelatedCaseNo;

	public void setRelatedCaseNo(String RelatedCaseNo) {
		this.RelatedCaseNo.setValue(RelatedCaseNo);
	}

	public String getRelatedCaseNo() {
		return this.RelatedCaseNo.getValue();
	}
	
	public Field CaseKind;
	
	public void setCaseKind(String CaseKind) {
		this.CaseKind.setValue(CaseKind);
	}
	
	public String getCaseKind() {
		return this.CaseKind.getValue();
	}
	
	public Field PatentOffice;
	
	public void setPatentOffice(String PatentOffice) {
		this.PatentOffice.setValue(PatentOffice);
	}
	
	public String getPatentOffice() {
		return this.PatentOffice.getValue();
	}
	
	public Field PatentType;
	
	public void setPatentType(String PatentType) {
		this.PatentType.setValue(PatentType);
	}
	
	public String getPatentType() {
		return this.PatentType.getValue();
	}
	
	public Field CaseNo;
	
	public void setCaseNo(String CaseNo) {
		this.CaseNo.setValue(CaseNo);
	}
	
	public String getCaseNo() {
		return this.CaseNo.getValue();
	}
	
	public String toInvoiceFlag;

	public String getToInvoiceFlag() {
		return toInvoiceFlag;
	}

	public void setToInvoiceFlag(String toInvoiceFlag) {
		this.toInvoiceFlag = toInvoiceFlag;
	}
	
	public String toPaymentFlag;

	public String getToPaymentFlag() {
		return toPaymentFlag;
	}

	public void setToPaymentFlag(String toPaymentFlag) {
		this.toPaymentFlag = toPaymentFlag;
	}
	
	public String toInvalidFlag;

	public String getToInvalidFlag() {
		return toInvalidFlag;
	}

	public void setToInvalidFlag(String toInvalidFlag) {
		this.toInvalidFlag = toInvalidFlag;
	}
	
	public String toCanInvoiceFlag;
	
	public String getToCanInvoiceFlag() {
		return toCanInvoiceFlag;
	}
	
	public void setToCanInvoiceFlag(String toCanInvoiceFlag) {
		this.toCanInvoiceFlag = toCanInvoiceFlag;
	}
	
	public String fromCaseFlag;
	
	public String getFromCaseFlag() {
		return fromCaseFlag;
	}
	
	public void setFromCaseFlag(String fromCaseFlag) {
		this.fromCaseFlag = fromCaseFlag;
	}
	
	private String[] MarkKeys;

	public void setMarkKeys(String[] markKeys) {
		this.MarkKeys = markKeys;
	}

	public String[] getMarkKeys() {
		return this.MarkKeys;
	}
	
	public String patentIn;

	public String getPatentIn() {
		return patentIn;
	}

	public void setPatentIn(String patentIn) {
		this.patentIn = patentIn;
	}
	
	public String changeOS01Flag;

	public String getChangeOS01Flag() {
		return changeOS01Flag;
	}

	public void setChangeOS01Flag(String changeOS01Flag) {
		this.changeOS01Flag = changeOS01Flag;
	}
    
    public Field Attorney;
    public void setAttorney(String Attorney){this.Attorney.setValue(Attorney);}
    public String getAttorney(){return this.Attorney.getValue();}
    
    public Field BillingContact;
    public void setBillingContact(String BillingContact){this.BillingContact.setValue(BillingContact);}
    public String getBillingContact(){return this.BillingContact.getValue();}
    
    public Field InvoiceTitle1;
    public void setInvoiceTitle1(String InvoiceTitle1){this.InvoiceTitle1.setValue(InvoiceTitle1);}
    public String getInvoiceTitle1(){return this.InvoiceTitle1.getValue();}
    
    public Field RegisteredNo;
    public void setRegisteredNo(String RegisteredNo){this.RegisteredNo.setValue(RegisteredNo);}
    public String getRegisteredNo(){return this.RegisteredNo.getValue();}


    public Field PriorityRight;
    public void setPriorityRight(String PriorityRight){this.PriorityRight.setValue(PriorityRight);}
    public String getPriorityRight(){return this.PriorityRight.getValue();}

    public Field PriorityDate1;
    public void setPriorityDate1(String PriorityDate1){this.PriorityDate1.setValue(PriorityDate1);}
    public String getPriorityDate1(){return this.PriorityDate1.getValue();}

    public Field PRCountry;
    public void setPRCountry(String PRCountry){this.PRCountry.setValue(PRCountry);}
    public String getPRCountry(){return this.PRCountry.getValue();}

    public Field PriorityDate2;
    public void setPriorityDate2(String PriorityDate2){this.PriorityDate2.setValue(PriorityDate2);}
    public String getPriorityDate2(){return this.PriorityDate2.getValue();}

    public Field PriorityNo1;
    public void setPriorityNo1(String PriorityNo1){this.PriorityNo1.setValue(PriorityNo1);}
    public String getPriorityNo1(){return this.PriorityNo1.getValue();}

    public Field PriorityNo2;
    public void setPriorityNo2(String PriorityNo2){this.PriorityNo2.setValue(PriorityNo2);}
    public String getPriorityNo2(){return this.PriorityNo2.getValue();}

    public Field Novelty;
    public void setNovelty(String Novelty){this.Novelty.setValue(Novelty);}
    public String getNovelty(){return this.Novelty.getValue();}

    public Field Published;
    public void setPublished(String Published){this.Published.setValue(Published);}
    public String getPublished(){return this.Published.getValue();}

    public Field NotYetPub;
    public void setNotYetPub(String NotYetPub){this.NotYetPub.setValue(NotYetPub);}
    public String getNotYetPub(){return this.NotYetPub.getValue();}

    public Field FuturePuDate;
    public void setFuturePuDate(String FuturePuDate){this.FuturePuDate.setValue(FuturePuDate);}
    public String getFuturePuDate(){return this.FuturePuDate.getValue();}

    public Field ClaimNovelty;
    public void setClaimNovelty(String ClaimNovelty){this.ClaimNovelty.setValue(ClaimNovelty);}
    public String getClaimNovelty(){return this.ClaimNovelty.getValue();}

    public Field Dateline;
    public void setDateline(String Dateline){this.Dateline.setValue(Dateline);}
    public String getDateline(){return this.Dateline.getValue();}

    public Field SignedDoc;
    public void setSignedDoc(String SignedDoc){this.SignedDoc.setValue(SignedDoc);}
    public String getSignedDoc(){return this.SignedDoc.getValue();}

    public Field Others1;
    public void setOthers1(String Others1){this.Others1.setValue(Others1);}
    public String getOthers1(){return this.Others1.getValue();}

    public Field SugAssignTo;
    public void setSugAssignTo(String SugAssignTo){this.SugAssignTo.setValue(SugAssignTo);}
    public String getSugAssignTo(){return this.SugAssignTo.getValue();}

    public Field ApplicantAdd;
    public void setApplicantAdd(String ApplicantAdd){this.ApplicantAdd.setValue(ApplicantAdd);}
    public String getApplicantAdd(){return this.ApplicantAdd.getValue();}

    public Field ContactAdd;
    public void setContactAdd(String ContactAdd){this.ContactAdd.setValue(ContactAdd);}
    public String getContactAdd(){return this.ContactAdd.getValue();}

    public Field InvContactAdd;
    public void setInvContactAdd(String InvContactAdd){this.InvContactAdd.setValue(InvContactAdd);}
    public String getInvContactAdd(){return this.InvContactAdd.getValue();}

    public Field BillSendTo;
    public void setBillSendTo(String BillSendTo){this.BillSendTo.setValue(BillSendTo);}
    public String getBillSendTo(){return this.BillSendTo.getValue();}

    public Field InvoiceItem;
    public void setInvoiceItem(String InvoiceItem){this.InvoiceItem.setValue(InvoiceItem);}
    public String getInvoiceItem(){return this.InvoiceItem.getValue();}

    public Field FilingFee;
    public void setFilingFee(String FilingFee){this.FilingFee.setValue(FilingFee);}
    public String getFilingFee(){return this.FilingFee.getValue();}

    public Field ExamFee;
    public void setExamFee(String ExamFee){this.ExamFee.setValue(ExamFee);}
    public String getExamFee(){return this.ExamFee.getValue();}

    public Field PRFee;
    public void setPRFee(String PRFee){this.PRFee.setValue(PRFee);}
    public String getPRFee(){return this.PRFee.getValue();}

    public Field ExPageFee;
    public void setExPageFee(String ExPageFee){this.ExPageFee.setValue(ExPageFee);}
    public String getExPageFee(){return this.ExPageFee.getValue();}

    public Field TransFee;
    public void setTransFee(String TransFee){this.TransFee.setValue(TransFee);}
    public String getTransFee(){return this.TransFee.getValue();}

    public Field TransWordNum;
    public void setTransWordNum(String TransWordNum){this.TransWordNum.setValue(TransWordNum);}
    public String getTransWordNum(){return this.TransWordNum.getValue();}

    public Field NatPhaFee;
    public void setNatPhaFee(String NatPhaFee){this.NatPhaFee.setValue(NatPhaFee);}
    public String getNatPhaFee(){return this.NatPhaFee.getValue();}

    public Field MiscFee;
    public void setMiscFee(String MiscFee){this.MiscFee.setValue(MiscFee);}
    public String getMiscFee(){return this.MiscFee.getValue();}

    public Field Other2;
    public void setOther2(String Other2){this.Other2.setValue(Other2);}
    public String getOther2(){return this.Other2.getValue();}

    public Field BillSendDoc1;
    public void setBillSendDoc1(String BillSendDoc1){this.BillSendDoc1.setValue(BillSendDoc1);}
    public String getBillSendDoc1(){return this.BillSendDoc1.getValue();}

    public Field BillSendDoc2;
    public void setBillSendDoc2(String BillSendDoc2){this.BillSendDoc2.setValue(BillSendDoc2);}
    public String getBillSendDoc2(){return this.BillSendDoc2.getValue();}

    public Field BillSendDoc3;
    public void setBillSendDoc3(String BillSendDoc3){this.BillSendDoc3.setValue(BillSendDoc3);}
    public String getBillSendDoc3(){return this.BillSendDoc3.getValue();}

    public Field BillSendDoc4;
    public void setBillSendDoc4(String BillSendDoc4){this.BillSendDoc4.setValue(BillSendDoc4);}
    public String getBillSendDoc4(){return this.BillSendDoc4.getValue();}

    public Field BillSendDoc41;
    public void setBillSendDoc41(String BillSendDoc41){this.BillSendDoc41.setValue(BillSendDoc41);}
    public String getBillSendDoc41(){return this.BillSendDoc41.getValue();}

    public Field BillSendDoc5;
    public void setBillSendDoc5(String BillSendDoc5){this.BillSendDoc5.setValue(BillSendDoc5);}
    public String getBillSendDoc5(){return this.BillSendDoc5.getValue();}

    public Field BillSendDoc6;
    public void setBillSendDoc6(String BillSendDoc6){this.BillSendDoc6.setValue(BillSendDoc6);}
    public String getBillSendDoc6(){return this.BillSendDoc6.getValue();}

    public Field BillSendDoc7;
    public void setBillSendDoc7(String BillSendDoc7){this.BillSendDoc7.setValue(BillSendDoc7);}
    public String getBillSendDoc7(){return this.BillSendDoc7.getValue();}

    public Field BillSendDoc7Doc;
    public void setBillSendDoc7Doc(String BillSendDoc7Doc){this.BillSendDoc7Doc.setValue(BillSendDoc7Doc);}
    public String getBillSendDoc7Doc(){return this.BillSendDoc7Doc.getValue();}

    public Field BillSendDoc7Num;
    public void setBillSendDoc7Num(String BillSendDoc7Num){this.BillSendDoc7Num.setValue(BillSendDoc7Num);}
    public String getBillSendDoc7Num(){return this.BillSendDoc7Num.getValue();}

    public Field BillAdd;
    public void setBillAdd(String BillAdd){this.BillAdd.setValue(BillAdd);}
    public String getBillAdd(){return this.BillAdd.getValue();}

    public Field Others1Memo;
    public void setOthers1Memo(String Others1Memo){this.Others1Memo.setValue(Others1Memo);}
    public String getOthers1Memo(){return this.Others1Memo.getValue();}

    public Field Others2Memo;
    public void setOthers2Memo(String Others2Memo){this.Others2Memo.setValue(Others2Memo);}
    public String getOthers2Memo(){return this.Others2Memo.getValue();}

    public Field ShowItem;
    public void setShowItem(String ShowItem){this.ShowItem.setValue(ShowItem);}
    public String getShowItem(){return this.ShowItem.getValue();}
    
    public Field InternalNo;
    public void setInternalNo(String InternalNo){this.InternalNo.setValue(InternalNo);}
    public String getInternalNo(){return this.InternalNo.getValue();}
    
    public Field NewCaseOthers;
    public void setNewCaseOthers(String NewCaseOthers){this.NewCaseOthers.setValue(NewCaseOthers);}
    public String getNewCaseOthers(){return this.NewCaseOthers.getValue();}
    
    public Field OldCaseOthers;
    public void setOldCaseOthers(String OldCaseOthers){this.OldCaseOthers.setValue(OldCaseOthers);}
    public String getOldCaseOthers(){return this.OldCaseOthers.getValue();}
    
    public Field OldCase;
    public void setOldCase(String OldCase){this.OldCase.setValue(OldCase);}
    public String getOldCase(){return this.OldCase.getValue();}
    
    public Field NewCase;
    public void setNewCase(String NewCase){this.NewCase.setValue(NewCase);}
    public String getNewCase(){return this.NewCase.getValue();}
    
    public Field Paper1;
    public void setPaper1(String Paper1){this.Paper1.setValue(Paper1);}
    public String getPaper1(){return this.Paper1.getValue();}
    
    public Field ElectronicFiles1;
    public void setElectronicFiles1(String ElectronicFiles1){this.ElectronicFiles1.setValue(ElectronicFiles1);}
    public String getElectronicFiles1(){return this.ElectronicFiles1.getValue();}
    
    public Field Files1;
    public void setFiles1(String Files1){this.Files1.setValue(Files1);}
    public String getFiles1(){return this.Files1.getValue();}
    
    public Field Files1Other;
    public void setFiles1Other(String Files1Other){this.Files1Other.setValue(Files1Other);}
    public String getFiles1Other(){return this.Files1Other.getValue();}
    
    public Field Paper2;
    public void setPaper2(String Paper2){this.Paper2.setValue(Paper2);}
    public String getPaper2(){return this.Paper2.getValue();}
    
    public Field ElectronicFiles2;
    public void setElectronicFiles2(String ElectronicFiles2){this.ElectronicFiles2.setValue(ElectronicFiles2);}
    public String getElectronicFiles2(){return this.ElectronicFiles2.getValue();}
    
    public Field Files2;
    public void setFiles2(String Files2){this.Files2.setValue(Files2);}
    public String getFiles2(){return this.Files2.getValue();}
    
    public Field Files2Other;
    public void setFiles2Other(String Files2Other){this.Files2Other.setValue(Files2Other);}
    public String getFiles2Other(){return this.Files2Other.getValue();}
    
    public Field PriorityCount;
    public void setPriorityCount(String PriorityCount){this.PriorityCount.setValue(PriorityCount);}
    public String getPriorityCount(){return this.PriorityCount.getValue();}
    
    public Field ClientContect;
    public void setClientContect(String ClientContect){this.ClientContect.setValue(ClientContect);}
    public String getClientContect(){return this.ClientContect.getValue();}
    
    public Field BillingInfo101;
    public void setBillingInfo101(String BillingInfo101){this.BillingInfo101.setValue(BillingInfo101);}
    public String getBillingInfo101(){return this.BillingInfo101.getValue();}
    
    public Field BillingInfo102;
    public void setBillingInfo102(String BillingInfo102){this.BillingInfo102.setValue(BillingInfo102);}
    public String getBillingInfo102(){return this.BillingInfo102.getValue();}
    
    public Field BillingInfo103;
    public void setBillingInfo103(String BillingInfo103){this.BillingInfo103.setValue(BillingInfo103);}
    public String getBillingInfo103(){return this.BillingInfo103.getValue();}
    
    public Field BillingInfo104;
    public void setBillingInfo104(String BillingInfo104){this.BillingInfo104.setValue(BillingInfo104);}
    public String getBillingInfo104(){return this.BillingInfo104.getValue();}

	public void init() {
		super.init();
		this.setProgramId("jsp.SalesOrder");
		this.setTableName("SalesOrder");
		
		//新增送出後畫面要停留在該筆資料編輯畫面。
		this.setKeepInMaintain(true);
        
        this.RenewalLogKey = new Field("RenewalLogKey", this.getTableName());
        this.RenewalLogKey.setDbType("varchar(50)"); 
        
        this.SoStatus = new Field("SoStatus", this.getTableName());
        this.SoStatus.setDbType("varchar(50)"); 

		this.AttorneyTitle = new Field("AttorneyTitle", this.getTableName());
		this.AttorneyTitle.setDbType("varchar(50)");

		this.InvoiceTitle1 = new Field("InvoiceTitle1", this.getTableName());
		this.InvoiceTitle1.setDbType("varchar(50)");

		this.RegisteredNo = new Field("RegisteredNo", this.getTableName());
		this.RegisteredNo.setDbType("varchar(50)");

		this.BillingContact = new Field("BillingContact", this.getTableName());
		this.BillingContact.setDbType("varchar(200)");
        
        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");
        this.ParentId.setSearchCondition(Cnstnts.LIKE);
        
        this.SoNo = new Field("SoNo", this.getTableName());
        this.SoNo.setDbType("varchar(50)");
        
        this.Client = new Field("Client", this.getTableName());
        this.Client.setDbType("varchar(50)");
        
        this.ClientName = new Field("ClientName", this.getTableName());
        this.ClientName.setDbType("varchar(100)");

		this.AttorneyCase = new Field("AttorneyCase", this.getTableName());
		this.AttorneyCase.setDbType("varchar(50)");
        
        this.ServiceProjectCode = new Field("ServiceProjectCode", this.getTableName());
        this.ServiceProjectCode.setDbType("varchar(100)");

		this.OriginalTitle = new Field("OriginalTitle", this.getTableName());
		this.OriginalTitle.setDbType("varchar(500)");

		this.InCharge = new Field("InCharge", this.getTableName());
		this.InCharge.setDbType("varchar(50)");

		this.Remark = new Field("Remark", this.getTableName());
		this.Remark.setDbType("varchar(500)");

		this.QuotationDate = new Field("QuotationDate", this.getTableName());
		this.QuotationDate.setDbType("varchar(10)");

		this.CreateDate = new Field("CreateDate", this.getTableName());
		this.CreateDate.setDbType("varchar(10)");

		this.RelatedCaseNo = new Field("RelatedCaseNo", this.getTableName());
		this.RelatedCaseNo.setDbType("varchar(100)");
		
		this.CaseKind = new Field("CaseKind", this.getTableName());
		this.CaseKind.setDbType("varchar(50)");
		
		this.PatentOffice = new Field("PatentOffice", this.getTableName());
		this.PatentOffice.setDbType("varchar(1000)");
//		this.PatentOffice.setCheckEmpty(true);
		
		this.PatentType = new Field("PatentType", this.getTableName());
		this.PatentType.setDbType("varchar(1000)");

		this.CaseNo = new Field("CaseNo", this.getTableName());
		this.CaseNo.setDbType("varchar(50)");

		this.OldCaseOthers = new Field("OldCaseOthers", this.getTableName());
		this.OldCaseOthers.setDbType("varchar(50)");

		this.OldCase = new Field("OldCase", this.getTableName());
		this.OldCase.setDbType("varchar(50)");

		this.NewCaseOthers = new Field("NewCaseOthers", this.getTableName());
		this.NewCaseOthers.setDbType("varchar(50)");

		this.NewCase = new Field("NewCase", this.getTableName());
		this.NewCase.setDbType("varchar(50)");

		this.InternalNo = new Field("InternalNo", this.getTableName());
		this.InternalNo.setDbType("varchar(50)");
		
		this.Attorney = new Field("Attorney", this.getTableName());
		this.Attorney.setDbType("varchar(50)");
		
		this.PriorityRight = new Field("PriorityRight", this.getTableName());
        this.PriorityRight.setDbType("varchar(50)");

        this.PriorityDate1 = new Field("PriorityDate1", this.getTableName());
        this.PriorityDate1.setDbType("varchar(50)");

        this.PriorityNo1 = new Field("PriorityNo1", this.getTableName());
        this.PriorityNo1.setDbType("varchar(50)");

        this.PriorityNo2 = new Field("PriorityNo2", this.getTableName());
        this.PriorityNo2.setDbType("varchar(50)");

        this.PRCountry = new Field("PRCountry", this.getTableName());
        this.PRCountry.setDbType("varchar(50)");

        this.PriorityDate2 = new Field("PriorityDate2", this.getTableName());
        this.PriorityDate2.setDbType("varchar(50)");

        this.Novelty = new Field("Novelty", this.getTableName());
        this.Novelty.setDbType("varchar(50)");

        this.Published = new Field("Published", this.getTableName());
        this.Published.setDbType("varchar(50)");

        this.NotYetPub = new Field("NotYetPub", this.getTableName());
        this.NotYetPub.setDbType("varchar(50)");

        this.FuturePuDate = new Field("FuturePuDate", this.getTableName());
        this.FuturePuDate.setDbType("varchar(50)");

        this.ClaimNovelty = new Field("ClaimNovelty", this.getTableName());
        this.ClaimNovelty.setDbType("varchar(50)");

        this.Dateline = new Field("Dateline", this.getTableName());
        this.Dateline.setDbType("varchar(50)");

        this.SignedDoc = new Field("SignedDoc", this.getTableName());
        this.SignedDoc.setDbType("varchar(50)");

        this.Others1 = new Field("Others1", this.getTableName());
        this.Others1.setDbType("varchar(50)");

        this.SugAssignTo = new Field("SugAssignTo", this.getTableName());
        this.SugAssignTo.setDbType("varchar(50)");

        this.ApplicantAdd = new Field("ApplicantAdd", this.getTableName());
        this.ApplicantAdd.setDbType("varchar(500)");

        this.ContactAdd = new Field("ContactAdd", this.getTableName());
        this.ContactAdd.setDbType("varchar(500)");

        this.InvContactAdd = new Field("InvContactAdd", this.getTableName());
        this.InvContactAdd.setDbType("varchar(500)");

        this.BillSendTo = new Field("BillSendTo", this.getTableName());
        this.BillSendTo.setDbType("varchar(500)");

        this.InvoiceItem = new Field("InvoiceItem", this.getTableName());
        this.InvoiceItem.setDbType("varchar(50)");

        this.FilingFee = new Field("FilingFee", this.getTableName());
        this.FilingFee.setDbType("varchar(50)");

        this.ExamFee = new Field("ExamFee", this.getTableName());
        this.ExamFee.setDbType("varchar(50)");

        this.PRFee = new Field("PRFee", this.getTableName());
        this.PRFee.setDbType("varchar(50)");

        this.ExPageFee = new Field("ExPageFee", this.getTableName());
        this.ExPageFee.setDbType("varchar(50)");

        this.TransFee = new Field("TransFee", this.getTableName());
        this.TransFee.setDbType("varchar(50)");

        this.TransWordNum = new Field("TransWordNum", this.getTableName());
        this.TransWordNum.setDbType("int");
        this.TransWordNum.setDecimal(0);

        this.NatPhaFee = new Field("NatPhaFee", this.getTableName());
        this.NatPhaFee.setDbType("varchar(50)");

        this.MiscFee = new Field("MiscFee", this.getTableName());
        this.MiscFee.setDbType("varchar(50)");

        this.Other2 = new Field("Other2", this.getTableName());
        this.Other2.setDbType("varchar(50)");

        this.BillSendDoc1 = new Field("BillSendDoc1", this.getTableName());
        this.BillSendDoc1.setDbType("varchar(50)");

        this.BillSendDoc2 = new Field("BillSendDoc2", this.getTableName());
        this.BillSendDoc2.setDbType("varchar(50)");

        this.BillSendDoc3 = new Field("BillSendDoc3", this.getTableName());
        this.BillSendDoc3.setDbType("varchar(50)");

        this.BillSendDoc4 = new Field("BillSendDoc4", this.getTableName());
        this.BillSendDoc4.setDbType("varchar(50)");

        this.BillSendDoc41 = new Field("BillSendDoc41", this.getTableName());
        this.BillSendDoc41.setDbType("varchar(50)");

        this.BillSendDoc5 = new Field("BillSendDoc5", this.getTableName());
        this.BillSendDoc5.setDbType("varchar(50)");

        this.BillSendDoc6 = new Field("BillSendDoc6", this.getTableName());
        this.BillSendDoc6.setDbType("varchar(50)");

        this.BillSendDoc7 = new Field("BillSendDoc7", this.getTableName());
        this.BillSendDoc7.setDbType("varchar(50)");

        this.BillSendDoc7Doc = new Field("BillSendDoc7Doc", this.getTableName());
        this.BillSendDoc7Doc.setDbType("varchar(50)");

        this.BillSendDoc7Num = new Field("BillSendDoc7Num", this.getTableName());
        this.BillSendDoc7Num.setDbType("int");

        this.BillAdd = new Field("BillAdd", this.getTableName());
        this.BillAdd.setDbType("varchar(500)");

        this.Others1Memo = new Field("Others1Memo", this.getTableName());
        this.Others1Memo.setDbType("varchar(500)");

        this.Others2Memo = new Field("Others2Memo", this.getTableName());
        this.Others2Memo.setDbType("varchar(500)");

        this.ShowItem = new Field("ShowItem", this.getTableName());
        this.ShowItem.setDbType("varchar(50)");

        this.Paper1 = new Field("Paper1", this.getTableName());
        this.Paper1.setDbType("varchar(50)");

        this.ElectronicFiles1 = new Field("ElectronicFiles1", this.getTableName());
        this.ElectronicFiles1.setDbType("varchar(50)");

        this.Files1 = new Field("Files1", this.getTableName());
        this.Files1.setDbType("varchar(50)");

        this.Files1Other = new Field("Files1Other", this.getTableName());
        this.Files1Other.setDbType("varchar(50)");

        this.Paper2 = new Field("Paper2", this.getTableName());
        this.Paper2.setDbType("varchar(50)");

        this.ElectronicFiles2 = new Field("ElectronicFiles2", this.getTableName());
        this.ElectronicFiles2.setDbType("varchar(50)");

        this.Files2 = new Field("Files2", this.getTableName());
        this.Files2.setDbType("varchar(50)");

        this.Files2Other = new Field("Files2Other", this.getTableName());
        this.Files2Other.setDbType("varchar(50)");

        this.ClientContect = new Field("ClientContect", this.getTableName());
        this.ClientContect.setDbType("varchar(50)");

        this.BillingInfo101 = new Field("BillingInfo101", this.getTableName());
        this.BillingInfo101.setDbType("varchar(50)");

        this.BillingInfo102 = new Field("BillingInfo102", this.getTableName());
        this.BillingInfo102.setDbType("varchar(50)");

        this.BillingInfo103 = new Field("BillingInfo103", this.getTableName());
        this.BillingInfo103.setDbType("varchar(50)");

        this.BillingInfo104 = new Field("BillingInfo104", this.getTableName());
        this.BillingInfo104.setDbType("varchar(50)");

        this.PriorityCount = new Field("PriorityCount", this.getTableName());
        this.PriorityCount.setDbType("int");
        this.PriorityCount.setDecimal(0);

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();

	}

	public void setDbFields() {
		super.setDbFields();
		
		this.DbFields.add(this.RenewalLogKey);
		
		this.DbFields.add(this.BillingInfo101);
		
		this.DbFields.add(this.BillingInfo102);
		
		this.DbFields.add(this.BillingInfo103);
		
		this.DbFields.add(this.BillingInfo104);
		
		this.DbFields.add(this.ClientContect);
		
		this.DbFields.add(this.PriorityCount);
		
		this.DbFields.add(this.Paper1);
		
		this.DbFields.add(this.ElectronicFiles1);
		
		this.DbFields.add(this.Files1);
		
		this.DbFields.add(this.Files1Other);
		
		this.DbFields.add(this.Paper2);
		
		this.DbFields.add(this.ElectronicFiles2);
		
		this.DbFields.add(this.Files2);
		
		this.DbFields.add(this.Files2Other);
		
		this.DbFields.add(this.NewCaseOthers);
		
		this.DbFields.add(this.NewCase);
		
		this.DbFields.add(this.OldCaseOthers);
		
		this.DbFields.add(this.OldCase);
		
		this.DbFields.add(this.ShowItem);
		
		this.DbFields.add(this.Others1Memo);
		
		this.DbFields.add(this.Others2Memo);
		
		this.DbFields.add(this.BillAdd);
		
		this.DbFields.add(this.PriorityRight);

        this.DbFields.add(this.PriorityDate1);

        this.DbFields.add(this.PriorityNo1);
        
        this.DbFields.add(this.PriorityNo2);

        this.DbFields.add(this.PRCountry);

        this.DbFields.add(this.PriorityDate2);

        this.DbFields.add(this.Novelty);

        this.DbFields.add(this.Published);

        this.DbFields.add(this.NotYetPub);

        this.DbFields.add(this.FuturePuDate);

        this.DbFields.add(this.ClaimNovelty);

        this.DbFields.add(this.Dateline);

        this.DbFields.add(this.SignedDoc);

        this.DbFields.add(this.Others1);

        this.DbFields.add(this.SugAssignTo);

        this.DbFields.add(this.ApplicantAdd);

        this.DbFields.add(this.ContactAdd);

        this.DbFields.add(this.InvContactAdd);

        this.DbFields.add(this.BillSendTo);

        this.DbFields.add(this.InvoiceItem);

        this.DbFields.add(this.FilingFee);

        this.DbFields.add(this.ExamFee);

        this.DbFields.add(this.PRFee);

        this.DbFields.add(this.ExPageFee);

        this.DbFields.add(this.TransFee);

        this.DbFields.add(this.TransWordNum);

        this.DbFields.add(this.NatPhaFee);

        this.DbFields.add(this.MiscFee);

        this.DbFields.add(this.Other2);

        this.DbFields.add(this.BillSendDoc1);

        this.DbFields.add(this.BillSendDoc2);

        this.DbFields.add(this.BillSendDoc3);

        this.DbFields.add(this.BillSendDoc4);

        this.DbFields.add(this.BillSendDoc41);

        this.DbFields.add(this.BillSendDoc5);
        this.DbFields.add(this.BillSendDoc6);
        this.DbFields.add(this.BillSendDoc7);
        this.DbFields.add(this.BillSendDoc7Doc);
        this.DbFields.add(this.BillSendDoc7Num);
		this.DbFields.add(this.InvoiceTitle1);
		this.DbFields.add(this.RegisteredNo);
		this.DbFields.add(this.BillingContact);
		this.DbFields.add(this.Attorney);
		this.DbFields.add(this.AttorneyCase);

        this.DbFields.add(this.SoStatus);
		this.DbFields.add(this.AttorneyTitle);
		this.DbFields.add(this.ParentId);
		this.DbFields.add(this.SoNo);
		this.DbFields.add(this.Client);
		this.DbFields.add(this.ClientName);
		this.DbFields.add(this.ServiceProjectCode);
		this.DbFields.add(this.OriginalTitle);
		this.DbFields.add(this.InCharge);
		this.DbFields.add(this.Remark);
		this.DbFields.add(this.QuotationDate);
		this.DbFields.add(this.CreateDate);
		this.DbFields.add(this.RelatedCaseNo);
		this.DbFields.add(this.CaseKind);
		this.DbFields.add(this.PatentOffice);
		this.DbFields.add(this.PatentType);
		this.DbFields.add(this.CaseNo);
		this.DbFields.add(this.InternalNo);
	}

	public String printFunctionBar() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		StringBuffer strBfr = new StringBuffer();
		strBfr.append(newLine + "<div id='functionBarDiv'><table id='functionBar' " + this.getTableBgcolor() + ">");
		strBfr.append(newLine + "<tr>");
		strBfr.append(newLine + "<td width='60%'>");
		strBfr.append(newLine + "<div class='logTitle'>");
		strBfr.append(newLine + this.getPageTitle());
		strBfr.append(Html.getReflashImg(this.getUserInfo()));
		strBfr.append(Html.getPrintImg(this.getUserInfo()));
		strBfr.append(this.getHelpImg());
		strBfr.append(this.getSwitchModeImg());
		strBfr.append(this.getExportXlsImg());
		strBfr.append(newLine + "</div>");
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "<td align='right'>");
		strBfr.append(this.getSoBtn());
		strBfr.append(this.getPrintBtn());
		strBfr.append(this.getClearBtn());
		strBfr.append(this.getSubmitBtn());
		strBfr.append(this.getPreRecordImg());
		strBfr.append(this.getNextRecordImg());
		strBfr.append(this.getDbActionSelectItem());
		strBfr.append(this.getSearchImg());
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "</tr>");
		strBfr.append(newLine + "</table></div>");
		return strBfr.toString();
	}
	
	public String getSoBtn() throws Exception {
		String btn = "";
		
		if(this.getPageActionMode().equals(Cnstnts.SEARCH)) {
			return btn;
		}
		
		if(Util.compareTo(this.getPatentIn(), "true") &&
				Util.compareTo(this.getSoStatus(), "OS00")) {
			btn += "<input type='hidden' name='changeOS01Flag' id='changeOS01Flag'>";
			btn += "<input type='button' " +
				"value='" + this.getUserInfo().getMsg("jsp.SalesOrder.ToOS01Btn") + "' " +
				"onclick='document.input.changeOS01Flag.value=true;setValue();'>";
			
//			if(!Util.compareTo(this.getSoStatus(), "OS02")) {
//				btn += "<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToInvalid")+"' onclick='document.input.toInvalidFlag.value=\"true\";setValue();'/>" +
//						"<input type='hidden' id='toInvalidFlag' name='toInvalidFlag' />";
//			}
		}
		

		if(!Util.compareTo(this.getPatentIn(), "true")){
			
//			if(Util.compareTo(this.getSoStatus(), "OS01")){
//				btn += "<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToCanInvoiceBtn")+"' onclick='document.input.toCanInvoiceFlag.value=\"true\";setValue();'/>" +
//						"<input type='hidden' id='toCanInvoiceFlag' name='toCanInvoiceFlag' />";
//			}
//			else{
				//請款需為可請款狀態、作廢需不能為已請款狀態等限制的規則改到master的狀態扭
				if(Util.compareTo(this.getSoStatus(), "OS01")) {
					btn += "<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToInvoiceBtn")+"' onclick='document.input.toInvoiceFlag.value=\"true\";setValue();'/>" +
							"<input type='hidden' id='toInvoiceFlag' name='toInvoiceFlag' />" +
	//							"<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToPaymentBtn")+"' onclick='document.input.toPaymentFlag.value=\"true\";setValue();'/>" +
							"<input type='hidden' id='toPaymentFlag' name='toPaymentFlag' />";
				}
				//作廢按鈕
//				if(!Util.compareTo(this.getSoStatus(), "OS02")) {
//					btn += "<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToInvalid")+"' onclick='document.input.toInvalidFlag.value=\"true\";setValue();'/>" +
//							"<input type='hidden' id='toInvalidFlag' name='toInvalidFlag' />";
//				}
//			}
		}
		
		/*
[上午 09:45:18] Janny Kuo: 都出現作廢扭，作廢要去檢核訂單狀態若為已請款，要去看 請款單 是否存在，
若不存在或存在了但狀態為invoicestatus05-作廢了就可以讓該訂單作廢，若請款單存在狀態非為作廢，
則出現提醒視窗，"該訂單已請款不可作廢"
		 */
		btn += "<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToInvalid")+"' onclick='document.input.toInvalidFlag.value=\"true\";setValue();'/>" +
				"<input type='hidden' id='toInvalidFlag' name='toInvalidFlag' />";
		
		return btn;
	}
	
	public String getSubmitBtn() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		//因為查詢列表直接用update模式進來
		//如果權限只有開查詢的話，會造成暫存按鈕還是出現，因為以為是update
		//所以要重新設定模式
		if(!this.getUserInfo().hasPrivilege(this.getProgramId(), this.getDbActionMode())) {
			this.setDbActionMode(Cnstnts.QUERY);
		}
		if((Util.compareTo(this.getSoStatus(), "OS02") ||
				Util.compareTo(this.getSoStatus(), "OS03")) &&
				!Util.compareTo(this.getDbActionMode(), Cnstnts.PRINT)) {
			this.setDbActionMode(Cnstnts.QUERY);
		}
		else {
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
			if (this.canSubmit()) {
				
				if (!this.getApplicant().equals(this.getUserInfo().getAttribute("emp_id"))) {
					if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
						if (!this.getUserInfo().canUpdateAll(this.getProgramId()) &&
								!this.getInCharge().equals(this.getUserInfo().getAttribute("emp_id"))) {
							if (!this.getUserInfo().canUpdateDept(this.getProgramId())) {
								this.setDbActionMode(Cnstnts.QUERY);
								return rtnString;
							} else {
								if (!this.getCreateDept().equals(this.getUserInfo().getAttribute("dept_id"))) {
									if (!this.chkInDept()) {
										this.setDbActionMode(Cnstnts.QUERY);
										return rtnString;
									}
								}
							}
						}
					}
					if (Cnstnts.DELETE.equals(this.getDbActionMode())) {
						if (!this.getUserInfo().canDeleteAll(this.getProgramId())) {
							if (!this.getUserInfo().canDeleteDept(this.getProgramId())) {
								this.setDbActionMode(Cnstnts.QUERY);
								return rtnString;
							} else {
								if (!this.getCreateDept().equals(this.getUserInfo().getAttribute("dept_id"))) {
									if (!this.chkInDept()) {
										this.setDbActionMode(Cnstnts.QUERY);
										return rtnString;
									}
								}
							}
						}
					}
				}
				rtnString += Html.getSubmitBtn(this.getUserInfo(), this.getDbActionMode());
			}
		}
		return rtnString;
	}
	
	public String printHtmlBody() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine + "<table id='bodyTable' "
				+ this.getTableBgcolor() + ">";
		
		if (this.onSearchMode()) {
			rtnString += super.FlowKey.printHiddenTag();
			rtnString += this.printSearchTable();
		} else {
			rtnString += super.FlowKey.printHiddenTag();
			rtnString += this.printMaintainTable();
		}
		rtnString += newLine + "</table>";
		if (this.onSearchMode()) {
			rtnString += this.printSearchReasult();
		}
		return rtnString;
	}
	
	
	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {
			resetFieldData("cond1", getCond1(), getFullSearchText1());
			resetFieldData("cond2", getCond2(), getFullSearchText2());

			this.FlowKey.setHtmlType(Cnstnts.HTML_TAG_TEXT);

			this.ParentId.setHtmlType(Cnstnts.HTML_TAG_TEXT);

			this.SoNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

			this.Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.ClientName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.ServiceProjectCode.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.OriginalTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.Remark.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.RelatedCaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.CaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

			this.Attorney.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Attorney.setSelectList(new Attorney().getList());

			this.CaseKind.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.CaseKind.setSelectList(new Category().getChildList("StandardTaskCaseType"));
			
			this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.PatentOffice.setSelectList(new Category().getChildList(this.PatentOffice));

			this.SoStatus.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.SoStatus.setSelectList(new Category().getChildList("SoStatus"));
			
			List<SelectItem> selectItems = new ArrayList<SelectItem>();
			selectItems.addAll(new Category().getChildList("PatentType"));
			selectItems.addAll(new Category().getChildList("TrademarkType"));
			selectItems.addAll(new Category().getChildList("MainType"));
			selectItems.addAll(new Category().getChildList("CopyrightMainType"));
			
			this.PatentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.PatentType.setSelectList(selectItems);
			
			List<SelectItem> items = new Employee().getList();
			this.InCharge.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.InCharge.setSelectList(items);

			/************* new search area **************/
			rtnString += genSearchCondScript("fullSearchText1");
			rtnString += Cnstnts.NEW_LINE
					+ genSearchCondScript("fullSearchText2");

			rtnString += Cnstnts.NEW_LINE
					+ "<tr bgcolor='#E9EDF4'><td width='20%' align='right'>"
					+ genSearchCondList("cond1")
					+ "</td><td width='25%'><div id='cond1_div'></div></td>"
					+ "<td width='25%'>" + genSqlCondList("sqlCond1") + "</td>";

			rtnString += Cnstnts.NEW_LINE
					+ "<tr bgcolor='#E9EDF4'><td width='20%' align='right'>"
					+ genSearchCondList("cond2")
					+ "</td><td width='25%'><div id='cond2_div'></div></td>"
					+ "<td width='25%'>" + genSqlCondList("sqlCond2") + "</td>";

			rtnString += Cnstnts.NEW_LINE
					+ "<tr bgcolor='#E9EDF4'><td width='20%' align='right'>"
					+ genSearchDateList()
					+ "</td>"
					+ "<td>"
					+ "<input type='text' id='startDate' name='startDate' value='' size='10' onChange='checkdate(this);'/>"
					+ "~"
					+ "<input type='text' id='endDate' name='endDate' value='' size='10'  onChange='checkdate(this);'/>"
					+ "<input type='button' value='"
					+ this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1")
					+ "' onclick='addMonthToDate(0, \"startDate\");addMonthToDate(1, \"endDate\");'>"
					+ "<input type='button' value='"
					+ this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2")
					+ "' onclick='addMonthToDate(0, \"startDate\");addMonthToDate(3, \"endDate\");'>"
					+ "　　　　" + "</td>";
			rtnString += Cnstnts.NEW_LINE + "<td>&nbsp;</td>";// +
																// this.getSearchImg()
																// +
																// this.getClearBtn()
																// +
																// this.getShowAllBtn()
																// + "</td>";

			this.AttorneyCase.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			this.AttorneyCase.setAfterText("　　");
			rtnString += this.printHtml(this.AttorneyCase);
			
			rtnString += Cnstnts.NEW_LINE
					+ "<script>"
					+ "changeDiv1(document.getElementById('cond1'), 'cond1_div');"
					+ "changeDiv2(document.getElementById('cond2'), 'cond2_div');"
					+ "document.input.startDate.value='" + getStartDate() + "';"
					+ "document.input.endDate.value='" + getEndDate() + "';"
					+ "$.datepicker.setDefaults( $.datepicker.regional[ \"zh-TW\" ] );" 
	        		+ "$( \"#startDate,#endDate\" ).datepicker({" 
					+ "showOn: \"button\"," 
					+ "buttonImage: \"img/calendar.gif\"," 
					+ "buttonImageOnly: true," 
					+ "changeMonth: true," 
					+ "changeYear: true," 
					+ "dateFormat: \"yy-mm-dd\"" 
					+ "});" 
					+ "</script>";
			/************* new search area end **************/
			//
			// rtnString +="<Script>"+
			// "function setScheduleDateOne(){" +
			// "var d = new Date();" +
			// "document.getElementById('" +
			// this.FeeScheduleDate.getTagName()+"').value=d.format('yyyy-MM-dd');"+
			// "var d2=DateAdd('m',1,d);"+
			// "document.getElementById('" +
			// this.FeeScheduleDateTo.getTagName()+"').value=d2.format('yyyy-MM-dd');"+
			// "}"+
			// "function setScheduleDateTwo(){" +
			// "var d = new Date();" +
			// "document.getElementById('" +
			// this.FeeScheduleDate.getTagName()+"').value=d.format('yyyy-MM-dd');"+
			// "var d2=DateAdd('m',3,d);"+
			// "document.getElementById('" +
			// this.FeeScheduleDateTo.getTagName()+"').value=d2.format('yyyy-MM-dd');"+
			// "}"+
			// "</Script>";
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
if (this.onMaintainMode()) {
			
			Category category = new Category();
			
			this.ParentId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			this.SoNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.SoNo.setAnotherField(this.ParentId);
			this.SoNo.setColspan(1);
			rtnString += this.printHtml(this.SoNo);
			
			String caseNo = "";
			String patentOffice = "";
			String patentType = "";
			String OriginalTitle = "";
			String EnglishTitle = "";
			String InternalNo = "";
			String invoiceTitle1 = "";
			String registeredNo = "";
			String client = "";
			String inCharge = "";
			String serviceProjectCode = "";

			if(!Util.isEmpty(this.getCaseNo()) && Util.compareTo(this.getChangeCaseNo(), "true")) {
				caseNo = this.getCaseNo();
				String unionSql = 
				"select CONCAT(p.flowkey, ';STC01') as flowkey from patentcase p where caseno = '" + this.getCaseNo() + "' " +
				"union " +
				"select CONCAT(p.flowkey, ';STC02') as flowkey from trademarkcase p  where caseno = '" + this.getCaseNo() + "' " +
				"union " +
				"select CONCAT(p.flowkey, ';STC03') as flowkey from legalcase p where caseno = '" + this.getCaseNo() + "'  " +
				"union " +
				"select CONCAT(p.flowkey, ';STC04') as flowkey from copyrightcase p where caseno = '" + this.getCaseNo() + "' ";
				if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
					unionSql = 
							"select (p.flowkey+ ';STC01') as flowkey from patentcase p where caseno = '" + this.getCaseNo() + "' " +
							"union " +
							"select (p.flowkey+ ';STC02') as flowkey from trademarkcase p  where caseno = '" + this.getCaseNo() + "' " +
							"union " +
							"select (p.flowkey+ ';STC03') as flowkey from legalcase p where caseno = '" + this.getCaseNo() + "'  " +
							"union " +
							"select (p.flowkey+ ';STC04') as flowkey from copyrightcase p where caseno = '" + this.getCaseNo() + "' ";
							
				}
				List<String> keys = this.getDbUtil().getValueList(unionSql, "flowkey");
				if(keys!=null && keys.size() > 0) {
					
					String key = keys.get(0);
					String releatedCaseNo = key.split(";")[0];
					String kind = key.split(";")[1];
					
					System.out.println(unionSql);
					System.out.println(key);
					
					this.setRelatedCaseNo(releatedCaseNo);
					this.setCaseKind(kind);

					if(Util.compareTo(kind, "STC01")) {
						patentOffice = this.getDbUtil().getFieldValue("select patentOffice from patentcase where flowkey='" + releatedCaseNo + "'", "patentOffice");
						patentType = this.getDbUtil().getFieldValue("select patentType from patentcase where flowkey='" + releatedCaseNo + "'", "patentType");
						OriginalTitle = this.getDbUtil().getFieldValue("select Title from patentcase where flowkey='" + releatedCaseNo + "'", "Title");
						EnglishTitle = this.getDbUtil().getFieldValue("select EnglishTitle from patentcase where flowkey='" + releatedCaseNo + "'", "EnglishTitle");
						InternalNo = this.getDbUtil().getFieldValue("select InternalNo from patentcase where flowkey='" + releatedCaseNo + "'", "InternalNo");
						client = this.getDbUtil().getFieldValue("select client from patentcase where flowkey='" + releatedCaseNo + "'", "client");
						serviceProjectCode = this.getDbUtil().getFieldValue("select serviceProjectCode from patentcase where flowkey='" + releatedCaseNo + "'", "serviceProjectCode");
//						sqls.add("update patentcase set QuotationFlowKey='" + qu.getFlowKey() + "' where flowkey ='" + releatedCaseNo + "'");
					}
					else if(Util.compareTo(kind, "STC02")) {
						patentOffice = this.getDbUtil().getFieldValue("select office from trademarkcase where flowkey='" + releatedCaseNo + "'", "office");
						patentType = this.getDbUtil().getFieldValue("select trademarkType from trademarkcase where flowkey='" + releatedCaseNo + "'", "trademarkType");
						OriginalTitle = this.getDbUtil().getFieldValue("select Title from trademarkcase where flowkey='" + releatedCaseNo + "'", "Title");
						EnglishTitle = this.getDbUtil().getFieldValue("select EnglishTitle from trademarkcase where flowkey='" + releatedCaseNo + "'", "EnglishTitle");
						InternalNo = this.getDbUtil().getFieldValue("select InternalNo from trademarkcase where flowkey='" + releatedCaseNo + "'", "InternalNo");
						client = this.getDbUtil().getFieldValue("select client from trademarkcase where flowkey='" + releatedCaseNo + "'", "client");
						serviceProjectCode = this.getDbUtil().getFieldValue("select serviceProjectCode from trademarkcase where flowkey='" + releatedCaseNo + "'", "serviceProjectCode");
//						sqls.add("update trademarkcase set QuotationFlowKey='" + qu.getFlowKey() + "' where flowkey ='" + releatedCaseNo + "'");
					}
					else if(Util.compareTo(kind, "STC03")) {
						patentType = this.getDbUtil().getFieldValue("select mainType from legalcase where flowkey='" + releatedCaseNo + "'", "maintype");
						OriginalTitle = this.getDbUtil().getFieldValue("select Title from legalcase where flowkey='" + releatedCaseNo + "'", "Title");
						EnglishTitle = this.getDbUtil().getFieldValue("select EnglishTitle from legalcase where flowkey='" + releatedCaseNo + "'", "EnglishTitle");
						InternalNo = this.getDbUtil().getFieldValue("select TmpField_09 from legalcase where flowkey='" + releatedCaseNo + "'", "TmpField_09");
						client = this.getDbUtil().getFieldValue("select client from legalcase where flowkey='" + releatedCaseNo + "'", "client");
						serviceProjectCode = this.getDbUtil().getFieldValue("select serviceProjectCode from legalcase where flowkey='" + releatedCaseNo + "'", "serviceProjectCode");
//						sqls.add("update legalcase set QuotationFlowKey='" + qu.getFlowKey() + "' where flowkey ='" + releatedCaseNo + "'");
					}
					else if(Util.compareTo(kind, "STC04")) {
						patentOffice = this.getDbUtil().getFieldValue("select office from copyrightcase where flowkey='" + releatedCaseNo + "'", "office");
						patentType = this.getDbUtil().getFieldValue("select mainType from copyrightcase where flowkey='" + releatedCaseNo + "'", "mainType");
						OriginalTitle = this.getDbUtil().getFieldValue("select Title from copyrightcase where flowkey='" + releatedCaseNo + "'", "Title");
						EnglishTitle = this.getDbUtil().getFieldValue("select EnglishTitle from copyrightcase where flowkey='" + releatedCaseNo + "'", "EnglishTitle");
						InternalNo = this.getDbUtil().getFieldValue("select TmpField_06 from copyrightcase where flowkey='" + releatedCaseNo + "'", "TmpField_06");
						client = this.getDbUtil().getFieldValue("select client from copyrightcase where flowkey='" + releatedCaseNo + "'", "client");
						serviceProjectCode = this.getDbUtil().getFieldValue("select serviceProjectCode from copyrightcase where flowkey='" + releatedCaseNo + "'", "serviceProjectCode");
//						sqls.add("update copyrightcase set QuotationFlowKey='" + qu.getFlowKey() + "' where flowkey ='" + releatedCaseNo + "'");
					}
				}
				else {
					this.setRelatedCaseNo("");
					this.setCaseKind("");
					this.setCaseNo("");
					this.setInternalNo("");
					
					rtnString += "<script>alert('" + this.getUserInfo().getMsg("jsp.SalesOrder.CaseNoError") + "');</script>";
				}

				this.PatentOffice.setValue(patentOffice);
				this.PatentType.setValue(patentType);
				this.OriginalTitle.setValue(OriginalTitle + "/" + EnglishTitle);
				this.InternalNo.setValue(InternalNo);
				this.ServiceProjectCode.setValue(serviceProjectCode);
				
				this.Client.setValue(client);
				if(this.Client.getValue().trim().length()>0){
	            	Client cli = new Client(this.Client.getValue());
	            	this.InCharge.setValue(cli.getSponsor());
	            	this.RegisteredNo.setValue(cli.RegisteredNo.getValue());
	            	this.InvoiceTitle1.setValue(cli.InvoiceTitle1.getValue());
	            	this.RegisteredNo.setValue(cli.RegisteredNo.getValue());
	            	this.SoStatus.setValue("OS00");
	            	this.ClientName.setValue(cli.CompanyName.getValue());
	            	this.BillingContact.setValue(cli.BillingContact.getValue());
				}
				
			}
			
			rtnString += this.RelatedCaseNo.printHiddenTag();
			
			this.CaseKind.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.CaseKind.setSelectList(category.getChildList("StandardTaskCaseType"));
			this.CaseKind.setOnChange("setValue()");
			
			if(!Util.isEmpty(this.getRelatedCaseNo()) && !Util.isEmpty(this.getCaseKind())){
				String caseNoString = ""; 
				if(Util.compareTo(this.getCaseKind(), "STC01")){
					PatentCase caseObj = new PatentCase(this.getRelatedCaseNo());
					if(caseObj != null){
						caseNoString = caseObj.getCaseNo();
					}
				}else if(Util.compareTo(this.getCaseKind(), "STC02")){
					TrademarkCase caseObj = new TrademarkCase(this.getRelatedCaseNo());
					if(caseObj != null){
						caseNoString = caseObj.getCaseNo();
					}
				}else if(Util.compareTo(this.getCaseKind(), "STC03")){
					LegalCase caseObj = new LegalCase(this.getRelatedCaseNo());
					if(caseObj != null){
						caseNoString = caseObj.getCaseNo();
					}
				}else if(Util.compareTo(this.getCaseKind(), "STC04")){
					CopyrightCase caseObj = new CopyrightCase(this.getRelatedCaseNo());
					if(caseObj != null){
						caseNoString = caseObj.getCaseNo();
					}
				}
				if(!Util.isEmpty(caseNoString)){
					this.CaseNo.setValue(caseNoString);
				}
			}

            String typeStr = "PatentType";
            if(this.CaseKind.getValue().equals("STC01")){ //專利案件
	        	typeStr = "PatentType";
	        }else if(this.CaseKind.getValue().equals("STC02")){ //商標案件
	        	typeStr = "TrademarkType";
	        }else if(this.CaseKind.getValue().equals("STC03")){ //法律案件
	        	typeStr = "MainType";
	        }else if(this.CaseKind.getValue().equals("STC04")){ //著作權案件
	        	typeStr = "CopyrightMainType";
	        }
            this.PatentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentType.setSelectList(category.getChildList(typeStr));
			this.PatentType.setAnotherField(this.CaseKind);
			//this.PatentType.setValue(Util.getPatentTypeNameByOffice(this.getPatentType(), this.getPatentOffice()));
			this.PatentType.setColspan(1);
			rtnString += this.printHtml(this.PatentType);
			
			this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.PatentOffice.setSelectList(category.getChildList(this.PatentOffice));

			this.AttorneyCase.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
			this.AttorneyCase.setAnotherField(this.PatentOffice);
            this.AttorneyCase.setColspan(1);
			rtnString += this.printHtml(this.AttorneyCase);

			this.Attorney.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Attorney.setSelectList(new Attorney().getList("Firm", false, true));
			this.Attorney.setOnChange("resetAttorneyCase()");
			this.Attorney.setSize(80);

			this.InternalNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.InternalNo.setAnotherField(this.Attorney);
			this.InternalNo.setColspan(1);
			rtnString += this.printHtml(this.InternalNo);
			
			this.SoStatus.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.SoStatus.setSelectList(category.getChildList(this.SoStatus));

			this.CaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.CaseNo.setAnotherField(this.SoStatus);
			this.CaseNo.setColspan(1);
			this.CaseNo.setOnChange("document.input.changeCaseNo.value=true;setValue()");
			rtnString += this.printHtml(this.CaseNo);
			
        	List<SelectItem> items2 = new ArrayList<SelectItem>();
//            if(!Util.isEmpty(this.Client.getValue())) {
//            	String sql2 = "select FlowKey, Title from serviceproject where Client = '" + this.Client.getValue() + "' order by flowkey";
//            	items2 = this.getDbUtil().getSelectItemList(sql2, "Title");
//            }
        	String sql2 = "select FlowKey, Title from serviceproject order by flowkey";
        	items2 = this.getDbUtil().getSelectItemList(sql2, "Title");
            this.ServiceProjectCode.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
            this.ServiceProjectCode.setSelectList(items2);
            this.ServiceProjectCode.setColspan(3);
        	rtnString += this.printHtml(this.ServiceProjectCode);

        	rtnString += "<input type='hidden' name='changeInvoiceTitle1' id='changeInvoiceTitle1'>";
			if(!Util.isEmpty(this.getChangeInvoiceTitle1()) &&
	        		this.getChangeInvoiceTitle1().startsWith("true")) {
	        	if(this.getChangeInvoiceTitle1().indexOf("%") != -1) {
	        		this.setInvoiceTitle1(this.getChangeInvoiceTitle1().split("%")[1]);
	        	}
	        	if(!Util.isEmpty(this.getInvoiceTitle1())) {
	        		InvTitle inv = new InvTitle(this.getInvoiceTitle1());
	            	this.RegisteredNo.setValue(inv.getRegisteredNo());
	        	}
	        	else {
	            	this.RegisteredNo.setValue("");
	        	}
	        }
            this.RegisteredNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
			
			this.ClientName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.ClientName.setSize(40);
			this.ClientName.setLength(100);
			
//			this.Client.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
			this.Client.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.Client.setSelectList(new Client().getList("FlowKey", false, true));
//            this.Client.setAutocompleteLabelFieldId(this.ClientName.getTagName());
            this.Client.setOnChange("setValue()");
            this.Client.setAnotherField(this.RegisteredNo);
            this.Client.setColspan(1);
//            this.Client.setStyle("width:150px;");
//            this.Client.setAfterText("<input type='text' size='50' id='clientName' name='clientName' value='" + this.getClientName() + "'>");
			rtnString += this.printHtml(this.Client);
			
			rtnString += this.ClientName.printHiddenTag();
			
			this.AttorneyTitle.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.AttorneyTitle.setSelectList(category.getChildList(this.AttorneyTitle));
            this.AttorneyTitle.setColspan(3);
            rtnString += this.printHtml(this.AttorneyTitle);
            

			List<SelectItem> items = new Employee().getList();
			this.InCharge.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.InCharge.setSelectList(items);
			
//			this.InvoiceTitle1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			
			String sql = "select a.flowkey, InvoiceTitle from invtitle a " +
            		"where a.parentid = '" + this.getClient() + "' ";
			this.InvoiceTitle1.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.InvoiceTitle1.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("InvoiceTitle", ""), false, false));
            this.InvoiceTitle1.setAnotherField(this.InCharge);
            this.InvoiceTitle1.setColspan(1);
            this.InvoiceTitle1.setOnChange("document.input.changeInvoiceTitle1.value=true;setValue()");
			rtnString += this.printHtml(this.InvoiceTitle1);

            
			this.OriginalTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.OriginalTitle.setSize(80);
			this.OriginalTitle.setLength(300);
            this.OriginalTitle.setColspan(3);
			if(Util.compareTo(this.getPatentIn(), "true") &&
					Util.compareTo(this.getSoStatus(), "OS00")) {
				this.OriginalTitle.setOnChange("updateSODRemark(\"" + this.getFlowKey() + "\", this.value, \"OriginalTitle\")");
			}
			rtnString += this.printHtml(this.OriginalTitle);
			
			sql = "select FlowKey, Names from applicant where " +
					"Client = '" + this.getClient() + "' " +
					"and ShowInClient ='Y' " +
					"and (ApplicantKind like '%CLK01;%' or ApplicantKind like '%CLK06;%' or ApplicantKind like '%CLK07;%') ";
			this.ClientContect.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.ClientContect.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("Names", ""), false));

            sql = "select a.flowkey, concat(a.Department, ' ' , a.Names, ' ', a.Title) as Names from applicant a " +
            		"where a.ShowInClient = 'Y' " +
            		"and a.Client = '" + this.getClient() + "' " +
            		"and a.ApplicantKind like '%CLK02;%'";
            if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
            	sql = "select a.flowkey, (a.Department+ ' ' + a.Names+ ' '+ a.Title) as Names from applicant a " +
                		"where a.ShowInClient = 'Y' " +
                		"and a.Client = '" + this.getClient() + "' " +
                		"and a.ApplicantKind like '%CLK02;%'";
            }
            if(Util.isEmpty(this.getBillingContact()) &&
            		!Util.isEmpty(this.getClient())) {
            	Client cli = new Client(this.getClient());
            	this.BillingContact.setValue(cli.getBillingContact());
            }
    		this.BillingContact.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    		this.BillingContact.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("Names", ""), false, false));
    		this.BillingContact.setColspan(1);
    		this.BillingContact.setAnotherField(this.ClientContect);
			rtnString += this.printHtml(this.BillingContact);
			
//			this.ServiceProjectCode.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//			this.ServiceProjectCode.setLength(100);
//			this.ServiceProjectCode.setAnotherField(this.InCharge);
//			this.ServiceProjectCode.setColspan(1);
//			rtnString += this.printHtml(this.ServiceProjectCode);
			
			this.QuotationDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			
			this.CreateDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.CreateDate.setAnotherField(this.QuotationDate);
			this.CreateDate.setColspan(1);
			rtnString += this.printHtml(this.CreateDate);
			
			this.Remark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			this.Remark.setLength(250);
			this.Remark.setRows(2);
			this.Remark.setCols(80);
			this.Remark.setColspan(5);
			if(Util.compareTo(this.getPatentIn(), "true") &&
					Util.compareTo(this.getSoStatus(), "OS00")) {
				this.Remark.setOnChange("updateSODRemark(\"" + this.getFlowKey() + "\", this.value, \"Remark2\")");
			}
					
			rtnString += this.printHtml(this.Remark);
			
			//委辦單項目
//			this.ShowItem.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
//			this.ShowItem.setOnChange("setValue();");
//			this.ShowItem.setColspan(5);
//			rtnString += this.printHtml(this.ShowItem);
			if(this.getCanEditField(this.PriorityRight)) {
				setFieldEditable(true);
			}
			else {
				setFieldEditable(false);
			}
			
			items = category.getChildList("ShowItem", false);
			
//			String checked = "";
//			rtnString += "<tr bgcolor=\"#E9EDF4\">" +
//					"<td align=\"right\" width=\"20%\" valign=top></td>" +
//					"<td colspan=\"3\">";
//			int index = 1;
//			for(SelectItem item : items) {
//				checked = "";
//				if(item.getKey().equals(this.getShowItem())) {
//					checked = " checked ";
//				}
//				rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
//						"id=\"" + this.ShowItem.getTagName() + "\" " +
//						"name=\"" + this.ShowItem.getTagName() + "\" " + checked + " " +
//						"onchange='setValue()'>" + 
//						item.getValue();
//				
//				List<SelectItem> items2 = category.getChildList(item.getKey(), false);
//				for(SelectItem item2 : items2) {
//					checked = "";
//					if(item.getKey().equals("NewCase")) {
//						if(item2.getKey().equals(this.getNewCase())) {
//							checked = " checked ";
//						}
//
//						rtnString += "<input type=\"radio\" value=\"" + item2.getKey() + "\" " +
//								"id=\"" + this.NewCase.getTagName() + "\" " +
//								"name=\"" + this.NewCase.getTagName() + "\" " + checked + ">" + 
//								item2.getValue();
//					}
//					if(item.getKey().equals("OldCase")) {
//						if(item2.getKey().equals(this.getOldCase())) {
//							checked = " checked ";
//						}
//
//						rtnString += "<input type=\"radio\" value=\"" + item2.getKey() + "\" " +
//								"id=\"" + this.OldCase.getTagName() + "\" " +
//								"name=\"" + this.OldCase.getTagName() + "\" " + checked + ">" + 
//								item2.getValue();
//					}
//				}
//				
//				if(item.getKey().equals("NewCase")) {
//					this.NewCaseOthers.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//					this.NewCaseOthers.setLength(500);
//					rtnString += Html.printTag(this.NewCaseOthers, this.getUserInfo());
//				}
//				if(item.getKey().equals("OldCase")) {
//					this.OldCaseOthers.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//					this.OldCaseOthers.setLength(500);
//					rtnString += Html.printTag(this.OldCaseOthers, this.getUserInfo());
//				}
//				
//				
//				rtnString += "<br>";
//				index++;
//			}
//			rtnString += "</td></tr>";
//			
//			rtnString += printItemHtml();
			
			if (this.FlowKey.getValue().trim().length() > 0) {
				rtnString += this.printTabAreaHtml();
			}
		}
		return rtnString;
	}
	
	public void setFieldEditable(boolean editable) {
		this.PriorityRight.setCanEdit(editable);
		this.TransWordNum.setCanEdit(editable);
		this.PriorityDate1.setCanEdit(editable);
		this.PRCountry.setCanEdit(editable);
		this.PriorityDate2.setCanEdit(editable);
		this.PriorityNo1.setCanEdit(editable);
		this.PriorityNo2.setCanEdit(editable);
		this.Novelty.setCanEdit(editable);
		this.Published.setCanEdit(editable);
		this.NotYetPub.setCanEdit(editable);
		this.FuturePuDate.setCanEdit(editable);
		this.ClaimNovelty.setCanEdit(editable);
		this.Dateline.setCanEdit(editable);
		this.SignedDoc.setCanEdit(editable);
		this.Others1.setCanEdit(editable);
		this.SugAssignTo.setCanEdit(editable);
		this.ApplicantAdd.setCanEdit(editable);
		this.ContactAdd.setCanEdit(editable);
		this.InvContactAdd.setCanEdit(editable);
		this.BillAdd.setCanEdit(editable);
		this.Others1Memo.setCanEdit(editable);
		this.Others2Memo.setCanEdit(editable);
		this.BillSendTo.setCanEdit(editable);
		this.InvoiceItem.setCanEdit(editable);
		this.FilingFee.setCanEdit(editable);
		this.ExamFee.setCanEdit(editable);
		this.PRFee.setCanEdit(editable);
		this.ExPageFee.setCanEdit(editable);
		this.TransFee.setCanEdit(editable);
		this.NatPhaFee.setCanEdit(editable);
		this.MiscFee.setCanEdit(editable);
		this.Other2.setCanEdit(editable);
		this.BillSendDoc1.setCanEdit(editable);
		this.BillSendDoc2.setCanEdit(editable);
		this.BillSendDoc3.setCanEdit(editable);
		this.BillSendDoc4.setCanEdit(editable);
		this.BillSendDoc5.setCanEdit(editable);
		this.BillSendDoc6.setCanEdit(editable);
		this.BillSendDoc7.setCanEdit(editable);
		this.BillSendDoc7Doc.setCanEdit(editable);
		this.BillSendDoc7Num.setCanEdit(editable);
		this.NewCaseOthers.setCanEdit(editable);
		this.OldCaseOthers.setCanEdit(editable);
		this.NewCase.setCanEdit(editable);
		this.OldCase.setCanEdit(editable);
		this.Files1Other.setCanEdit(editable);
		this.Files1.setCanEdit(editable);
		this.ElectronicFiles1.setCanEdit(editable);
		this.Paper1.setCanEdit(editable);
		this.Files2Other.setCanEdit(editable);
		this.Files2.setCanEdit(editable);
		this.ElectronicFiles2.setCanEdit(editable);
		this.Paper2.setCanEdit(editable);
		this.BillSendDoc41.setCanEdit(editable);
		this.PriorityCount.setCanEdit(editable);
		this.BillingContact.setCanEdit(editable);
		this.ClientContect.setCanEdit(editable);
	}
	
	public String printItemHtml() throws Exception {
		String rtnString = "";
		if (this.onMaintainMode()) {
			if(!Util.isEmpty(this.getShowItem())) {
				
				

				Category category = new Category();

				this.PriorityDate1.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
				this.PriorityDate2.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
				
				this.PRCountry.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
				this.PRCountry.setSelectList(category.getChildList("PatentOffice"));
				
				List<SelectItem> items = category.getChildList("PriorityRight", false);
				
				String checked = "";
				if(Util.compareTo(this.getShowItem(), "NewCase")) {
					rtnString += "<tr bgcolor=\"#E9EDF4\">" +
							"<td align=\"right\" width=\"20%\" valign=top><font color=red size=1>必填*</font>" + this.getAlias(this.PriorityRight) + "</td>" +
							"<td colspan=\"3\">";
					int index = 1;
					for(SelectItem item : items) {
						checked = "";
						if(item.getKey().equals(this.getPriorityRight())) {
							checked = " checked ";
						}
						rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
								"id=\"" + this.PriorityRight.getTagName() + "\" " +
								"name=\"" + this.PriorityRight.getTagName() + "\" " + checked + ">" + 
								item.getValue();
						if(index == 2) {
							rtnString += "&nbsp;&nbsp;" + this.getAlias(this.PRCountry) + Html.printTag(this.PRCountry, this.getUserInfo());
							this.PriorityCount.setSize(6);
							rtnString += "&nbsp;&nbsp;" + this.getAlias(this.PriorityCount) + Html.printTag(this.PriorityCount, this.getUserInfo());
							rtnString += "&nbsp;&nbsp;" + this.getAlias(this.PriorityNo1) + Html.printTag(this.PriorityNo1, this.getUserInfo());
							rtnString += "&nbsp;&nbsp;" + this.getAlias(this.PriorityDate1) + Html.printTag(this.PriorityDate1, this.getUserInfo());
						}
						rtnString += "<br>";
						index++;
					}
					rtnString += "</td></tr>";
					
	
					this.FuturePuDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
					
					items = category.getChildList("Novelty", false);
					rtnString += "<tr bgcolor=\"#E9EDF4\">" +
							"<td align=\"right\" width=\"20%\" valign=top>" + this.getAlias(this.Novelty) + "</td>" +
							"<td colspan=\"3\">";
					for(SelectItem item : items) {
						checked = "";
						if(item.getKey().equals(this.getNovelty())) {
							checked = " checked ";
						}
						rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
								"id=\"" + this.Novelty.getTagName() + "\" " +
								"name=\"" + this.Novelty.getTagName() + "\" " + checked + ">" +
								item.getValue();
					}
					rtnString += "<br>";
					rtnString += this.getAlias(this.FuturePuDate) + Html.printTag(this.FuturePuDate, this.getUserInfo());
					
					rtnString += "<br>";
					items = category.getChildList("ClaimNovelty", false);
					for(SelectItem item : items) {
						checked = "";
						if(item.getKey().equals(this.getClaimNovelty())) {
							checked = " checked ";
						}
						rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
								"id=\"" + this.ClaimNovelty.getTagName() + "\" " +
								"name=\"" + this.ClaimNovelty.getTagName() + "\" " + checked + ">" +
								item.getValue();
					}
					rtnString += this.getAlias(this.ClaimNovelty);
					rtnString += "</td></tr>";
				}
				
				this.Dateline.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
				this.Dateline.setColspan(3);
				rtnString += this.printHtml(this.Dateline);
				
//				this.Others1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//				rtnString += "<tr bgcolor=\"#E9EDF4\">" +
//						"<td align=\"right\" width=\"20%\" valign=top>" + this.getAlias(this.SignedDoc) + "</td>" +
//						"<td colspan=\"3\">";
//				items = category.getChildList("SignedDoc", false);
//				for(SelectItem item : items) {
//					checked = "";
//					if(item.getKey().equals(this.getSignedDoc())) {
//						checked = " checked ";
//					}
//					rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
//							"id=\"" + this.SignedDoc.getTagName() + "\" " +
//							"name=\"" + this.SignedDoc.getTagName() + "\" " + checked + ">" +
//							item.getValue();
//				}
//				rtnString += Html.printTag(this.Others1, this.getUserInfo());
//				rtnString += "</td></tr>";
//				
//				
				this.SugAssignTo.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
				this.SugAssignTo.setSelectList(new Employee().getList());
				this.SugAssignTo.setColspan(3);
				rtnString += this.printHtml(this.SugAssignTo);
				

				this.ApplicantAdd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
				this.ApplicantAdd.setLength(500);
				this.ApplicantAdd.setSize(80);
				this.ApplicantAdd.setColspan(3);
//				this.ApplicantAdd.setCheckEmpty(true);
				rtnString += this.printHtml(this.ApplicantAdd);
				
				this.ClientContect.setHtmlType(Cnstnts.HTML_TAG_TEXT);
				this.ClientContect.setSize(80);
				this.ClientContect.setColspan(3);
				rtnString += this.printHtml(this.ClientContect);
				
				
				
				
				this.BillingContact.setHtmlType(Cnstnts.HTML_TAG_TEXT);
				this.BillingContact.setSize(80);
				this.BillingContact.setColspan(3);
				rtnString += this.printHtml(this.BillingContact);
				
//				this.ContactAdd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//				this.ContactAdd.setLength(500);
//				this.ContactAdd.setSize(80);
//				this.ContactAdd.setColspan(3);
//				this.ContactAdd.setCheckEmpty(true);
//				rtnString += this.printHtml(this.ContactAdd);
				
				this.InvContactAdd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
				this.InvContactAdd.setLength(500);
				this.InvContactAdd.setSize(80);
				this.InvContactAdd.setColspan(3);
				rtnString += this.printHtml(this.InvContactAdd);
				
//				this.BillSendTo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//				this.BillSendTo.setLength(500);
//				this.BillSendTo.setSize(80);
//				this.BillSendTo.setColspan(3);
//				this.BillSendTo.setCheckEmpty(true);
//				rtnString += this.printHtml(this.BillSendTo);
				
//				this.BillAdd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//				this.BillAdd.setLength(500);
//				this.BillAdd.setSize(80);
//				this.BillAdd.setColspan(3);
//				this.BillAdd.setCheckEmpty(true);
//				rtnString += this.printHtml(this.BillAdd);
				
//				rtnString += "<tr bgcolor=\"#E9EDF4\">" +
//						"<td align=\"right\" width=\"20%\" valign=top><font color=red size=1>必填*</font>" + this.getAlias(this.InvoiceItem) + "</td>" +
//						"<td colspan=\"3\">";
//				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
//						"id=\"" + this.FilingFee.getTagName() + "\" " +
//						"name=\"" + this.FilingFee.getTagName() + "\" " +
//						(Util.compareTo(this.FilingFee.getValue(), "Y")?" checked ":"") + ">" +
//						this.getAlias(this.FilingFee) + "&nbsp;&nbsp;";
//				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
//						"id=\"" + this.ExamFee.getTagName() + "\" " +
//						"name=\"" + this.ExamFee.getTagName() + "\" " +
//						(Util.compareTo(this.ExamFee.getValue(), "Y")?" checked ":"") + ">" +
//						this.getAlias(this.ExamFee) + "&nbsp;&nbsp;";
//				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
//						"id=\"" + this.PRFee.getTagName() + "\" " +
//						"name=\"" + this.PRFee.getTagName() + "\" " +
//						(Util.compareTo(this.PRFee.getValue(), "Y")?" checked ":"") + ">" +
//						this.getAlias(this.PRFee) + "&nbsp;&nbsp;";
//				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
//						"id=\"" + this.ExPageFee.getTagName() + "\" " +
//						"name=\"" + this.ExPageFee.getTagName() + "\" " +
//						(Util.compareTo(this.ExPageFee.getValue(), "Y")?" checked ":"") + ">" +
//						this.getAlias(this.ExPageFee) + "&nbsp;&nbsp;";
//				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
//						"id=\"" + this.TransFee.getTagName() + "\" " +
//						"name=\"" + this.TransFee.getTagName() + "\" " +
//						(Util.compareTo(this.TransFee.getValue(), "Y")?" checked ":"") + ">" +
//						this.getAlias(this.TransFee) + "&nbsp;";
//				this.TransWordNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//				this.TransWordNum.setSize(10);
//				rtnString += "(" + this.getAlias(this.TransWordNum) + Html.printTag(this.TransWordNum, this.getUserInfo()) + ")";
//				rtnString += "<br>";
//
//				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
//						"id=\"" + this.NatPhaFee.getTagName() + "\" " +
//						"name=\"" + this.NatPhaFee.getTagName() + "\" " +
//						(Util.compareTo(this.NatPhaFee.getValue(), "Y")?" checked ":"") + ">" +
//						this.getAlias(this.NatPhaFee) + "&nbsp;&nbsp;";
//				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
//						"id=\"" + this.MiscFee.getTagName() + "\" " +
//						"name=\"" + this.MiscFee.getTagName() + "\" " +
//						(Util.compareTo(this.MiscFee.getValue(), "Y")?" checked ":"") + ">" +
//						this.getAlias(this.MiscFee) + "&nbsp;&nbsp;";
//				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
//						"id=\"" + this.Other2.getTagName() + "\" " +
//						"name=\"" + this.Other2.getTagName() + "\" " +
//						(Util.compareTo(this.Other2.getValue(), "Y")?" checked ":"") + ">" +
//						this.getAlias(this.Other2) + "&nbsp;";
//				this.Others2Memo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//				this.Others2Memo.setLength(500);
//				rtnString += Html.printTag(this.Others2Memo, this.getUserInfo());
//				
//				rtnString += "</td></tr>";
				
				
				rtnString += "<tr bgcolor=\"#E9EDF4\">" +
						"<td align=\"right\" width=\"20%\" valign=top>" + this.getUserInfo().getMsg("jsp.SalesOrder.BillSendDocText1") + "</td>" +
						"<td colspan=\"3\">";
				rtnString += "<table border=0 width=100%>";
				rtnString += "<tr><td width=6% valign=top>" + this.getUserInfo().getMsg("jsp.SalesOrder.BillSendDocText2") + "</td>";
				rtnString += "<td>";
				
//				rtnString += this.getAlias(this.BillSendDoc1);
//				items = category.getChildList("BillSendDoc1", false);
//				for(SelectItem item : items) {
//					checked = "";
//					if(item.getKey().equals(this.BillSendDoc1.getValue())) {
//						checked = " checked ";
//					}
//					rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
//							"id=\"" + this.BillSendDoc1.getTagName() + "\" " +
//							"name=\"" + this.BillSendDoc1.getTagName() + "\" " + checked + ">" +
//							item.getValue();
//				}
//				rtnString += "<br>";
				rtnString += this.getUserInfo().getMsg("jsp.SalesOrder.Info1");
				rtnString += "<br>";
//				rtnString += this.getUserInfo().getMsg("jsp.SalesOrder.Info3");
//				rtnString += "<br>";
				
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.BillingInfo101.getTagName() + "\" " +
						"name=\"" + this.BillingInfo101.getTagName() + "\" " +
						(Util.compareTo(this.BillingInfo101.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.BillingInfo101) + "&nbsp;&nbsp;";
				
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.BillingInfo102.getTagName() + "\" " +
						"name=\"" + this.BillingInfo102.getTagName() + "\" " +
						(Util.compareTo(this.BillingInfo102.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.BillingInfo102) + "&nbsp;&nbsp;";
				
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.BillingInfo103.getTagName() + "\" " +
						"name=\"" + this.BillingInfo103.getTagName() + "\" " +
						(Util.compareTo(this.BillingInfo103.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.BillingInfo103) + "&nbsp;&nbsp;";
				
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.BillingInfo104.getTagName() + "\" " +
						"name=\"" + this.BillingInfo104.getTagName() + "\" " +
						(Util.compareTo(this.BillingInfo104.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.BillingInfo104) + "&nbsp;&nbsp;";
				rtnString += "<br>";
				
				rtnString += this.getUserInfo().getMsg("jsp.SalesOrder.Info2");
				rtnString += "<br>";
				
				
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.Paper1.getTagName() + "\" " +
						"name=\"" + this.Paper1.getTagName() + "\" " +
						(Util.compareTo(this.Paper1.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.Paper1) + "&nbsp;&nbsp;";
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.ElectronicFiles1.getTagName() + "\" " +
						"name=\"" + this.ElectronicFiles1.getTagName() + "\" " +
						(Util.compareTo(this.ElectronicFiles1.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.ElectronicFiles1) + "&nbsp;&nbsp;";
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.Files1.getTagName() + "\" " +
						"name=\"" + this.Files1.getTagName() + "\" " +
						(Util.compareTo(this.Files1.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.Files1) + "&nbsp;&nbsp;";
				this.Files1Other.setHtmlType(Cnstnts.HTML_TAG_TEXT);
				this.Files1Other.setLength(500);
				rtnString += Html.printTag(this.Files1Other, this.getUserInfo());
				
				
//				rtnString += this.getAlias(this.BillSendDoc2);
//				items = category.getChildList("BillSendDoc2", false);
//				for(SelectItem item : items) {
//					checked = "";
//					if(item.getKey().equals(this.BillSendDoc2.getValue())) {
//						checked = " checked ";
//					}
//					rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
//							"id=\"" + this.BillSendDoc2.getTagName() + "\" " +
//							"name=\"" + this.BillSendDoc2.getTagName() + "\" " + checked + ">" +
//							item.getValue();
//				}
//				rtnString += "<br>";
				
				rtnString += "</td></tr>";
				rtnString += "<tr><td>&nbsp;</td><td>&nbsp;</td></tr>";
				
				rtnString += "<tr><td width=6% valign=top>" + this.getUserInfo().getMsg("jsp.SalesOrder.BillSendDocText3") + "</td>";
				rtnString += "<td>";
				
//				rtnString += this.getAlias(this.BillSendDoc3);
//				items = category.getChildList("BillSendDoc3", false);
//				for(SelectItem item : items) {
//					checked = "";
//					if(item.getKey().equals(this.BillSendDoc3.getValue())) {
//						checked = " checked ";
//					}
//					rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
//							"id=\"" + this.BillSendDoc3.getTagName() + "\" " +
//							"name=\"" + this.BillSendDoc3.getTagName() + "\" " + checked + ">" +
//							item.getValue();
//				}
//				rtnString += "<br>";

				rtnString += this.getUserInfo().getMsg("jsp.SalesOrder.Info1");
				rtnString += "<br>";
				rtnString += this.getAlias(this.BillSendDoc4);
				items = category.getChildList("BillSendDoc4", false);
				rtnString += "(";
				for(SelectItem item : items) {
					checked = "";
					if(item.getKey().equals(this.BillSendDoc4.getValue())) {
						checked = " checked ";
					}
					rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
							"id=\"" + this.BillSendDoc4.getTagName() + "\" " +
							"name=\"" + this.BillSendDoc4.getTagName() + "\" " + checked + ">" +
							item.getValue();
				}
				rtnString += ")";
				
				rtnString += this.getAlias(this.BillSendDoc41);
				items = category.getChildList("BillSendDoc41", false);
				rtnString += "(";
				for(SelectItem item : items) {
					checked = "";
					if(item.getKey().equals(this.BillSendDoc41.getValue())) {
						checked = " checked ";
					}
					rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
							"id=\"" + this.BillSendDoc41.getTagName() + "\" " +
							"name=\"" + this.BillSendDoc41.getTagName() + "\" " + checked + ">" +
							item.getValue();
				}
				rtnString += ")";
				
				rtnString += "<br>";
				
				
				
				rtnString += this.getAlias(this.BillSendDoc5);
				items = category.getChildList("BillSendDoc5", false);
				rtnString += "(";
				for(SelectItem item : items) {
					checked = "";
					if(item.getKey().equals(this.BillSendDoc5.getValue())) {
						checked = " checked ";
					}
					rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
							"id=\"" + this.BillSendDoc5.getTagName() + "\" " +
							"name=\"" + this.BillSendDoc5.getTagName() + "\" " + checked + ">" +
							item.getValue();
				}
				rtnString += ")";
				rtnString += "&nbsp;&nbsp;";
				
				rtnString += "、" + this.getAlias(this.BillSendDoc6);
				items = category.getChildList("BillSendDoc6", false);
//				rtnString += "(";
//				for(SelectItem item : items) {
//					checked = "";
//					if(item.getKey().equals(this.BillSendDoc6.getValue())) {
//						checked = " checked ";
//					}
//					rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
//							"id=\"" + this.BillSendDoc6.getTagName() + "\" " +
//							"name=\"" + this.BillSendDoc6.getTagName() + "\" " + checked + ">" +
//							item.getValue();
//				}
//				rtnString += ")";
				rtnString += "<br>";
				
				
//				rtnString += this.getAlias(this.BillSendDoc7);
//				items = category.getChildList("BillSendDoc7", false);
//				index = 1;
//				for(SelectItem item : items) {
//					checked = "";
//					if(item.getKey().equals(this.BillSendDoc7.getValue())) {
//						checked = " checked ";
//					}
//					rtnString += "<input type=\"radio\" value=\"" + item.getKey() + "\" " +
//							"id=\"" + this.BillSendDoc7.getTagName() + "\" " +
//							"name=\"" + this.BillSendDoc7.getTagName() + "\" " + checked + ">" +
//							item.getValue();
//					if(index == 1) {
//						rtnString += "<br>";
//					}
//					index++;
//				}
//				this.BillSendDoc7Doc.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//				this.BillSendDoc7Num.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//				this.BillSendDoc7Num.setSize(10);
//				
//				rtnString += Html.printTag(this.BillSendDoc7Doc, this.getUserInfo()) + this.getAlias(this.BillSendDoc7Doc);
//				rtnString += "&nbsp;&nbsp;";
//				rtnString += Html.printTag(this.BillSendDoc7Num, this.getUserInfo()) + this.getAlias(this.BillSendDoc7Num);
//				rtnString += "<br>";
				
				rtnString += this.getUserInfo().getMsg("jsp.SalesOrder.Info2");
				rtnString += "<br>";
				
				
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.Paper2.getTagName() + "\" " +
						"name=\"" + this.Paper2.getTagName() + "\" " +
						(Util.compareTo(this.Paper2.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.Paper2) + "&nbsp;&nbsp;";
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.ElectronicFiles2.getTagName() + "\" " +
						"name=\"" + this.ElectronicFiles2.getTagName() + "\" " +
						(Util.compareTo(this.ElectronicFiles2.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.ElectronicFiles2) + "&nbsp;&nbsp;";
				rtnString += "<input type=\"checkbox\" value=\"Y\" " +
						"id=\"" + this.Files2.getTagName() + "\" " +
						"name=\"" + this.Files2.getTagName() + "\" " +
						(Util.compareTo(this.Files2.getValue(), "Y")?" checked ":"") + ">" +
						this.getAlias(this.Files2) + "&nbsp;&nbsp;";
				this.Files2Other.setHtmlType(Cnstnts.HTML_TAG_TEXT);
				this.Files2Other.setLength(500);
				rtnString += Html.printTag(this.Files2Other, this.getUserInfo());

				rtnString += "<br>";
				
				rtnString += "</td></tr>";
				
				rtnString += "</table>";
				
				rtnString += "</td></tr>";
			}
			else {
				rtnString += this.PriorityRight.printHiddenTag();
				rtnString += this.TransWordNum.printHiddenTag();
				rtnString += this.PriorityDate1.printHiddenTag();
				rtnString += this.PRCountry.printHiddenTag();
				rtnString += this.PriorityDate2.printHiddenTag();
				rtnString += this.PriorityNo1.printHiddenTag();
				rtnString += this.PriorityNo2.printHiddenTag();
				rtnString += this.Novelty.printHiddenTag();
				rtnString += this.Published.printHiddenTag();
				rtnString += this.NotYetPub.printHiddenTag();
				rtnString += this.FuturePuDate.printHiddenTag();
				rtnString += this.ClaimNovelty.printHiddenTag();
				rtnString += this.Dateline.printHiddenTag();
				rtnString += this.SignedDoc.printHiddenTag();
				rtnString += this.Others1.printHiddenTag();
				rtnString += this.SugAssignTo.printHiddenTag();
				rtnString += this.ApplicantAdd.printHiddenTag();
				rtnString += this.ContactAdd.printHiddenTag();
				rtnString += this.InvContactAdd.printHiddenTag();
				rtnString += this.BillAdd.printHiddenTag();
				rtnString += this.Others1Memo.printHiddenTag();
				rtnString += this.Others2Memo.printHiddenTag();
				rtnString += this.BillSendTo.printHiddenTag();
				rtnString += this.InvoiceItem.printHiddenTag();
				rtnString += this.FilingFee.printHiddenTag();
				rtnString += this.ExamFee.printHiddenTag();
				rtnString += this.PRFee.printHiddenTag();
				rtnString += this.ExPageFee.printHiddenTag();
				rtnString += this.TransFee.printHiddenTag();
				rtnString += this.NatPhaFee.printHiddenTag();
				rtnString += this.MiscFee.printHiddenTag();
				rtnString += this.Other2.printHiddenTag();
				rtnString += this.BillSendDoc1.printHiddenTag();
				rtnString += this.BillSendDoc2.printHiddenTag();
				rtnString += this.BillSendDoc3.printHiddenTag();
				rtnString += this.BillSendDoc4.printHiddenTag();
				rtnString += this.BillSendDoc5.printHiddenTag();
				rtnString += this.BillSendDoc6.printHiddenTag();
				rtnString += this.BillSendDoc7.printHiddenTag();
				rtnString += this.BillSendDoc7Doc.printHiddenTag();
				rtnString += this.BillSendDoc7Num.printHiddenTag();
				rtnString += this.Paper1.printHiddenTag();
				rtnString += this.ElectronicFiles1.printHiddenTag();
				rtnString += this.Files1.printHiddenTag();
				rtnString += this.Files1Other.printHiddenTag();
				rtnString += this.Paper2.printHiddenTag();
				rtnString += this.ElectronicFiles2.printHiddenTag();
				rtnString += this.Files2.printHiddenTag();
				rtnString += this.Files2Other.printHiddenTag();
				rtnString += this.NewCaseOthers.printHiddenTag();
				rtnString += this.OldCaseOthers.printHiddenTag();
				rtnString += this.OldCase.printHiddenTag();
				rtnString += this.NewCase.printHiddenTag();
				rtnString += this.ClientContect.printHiddenTag();
				rtnString += this.BillingContact.printHiddenTag();
			}
		}
		
		return rtnString;
	}

	public String printTabAreaHtml() throws Exception {
		String rtnString = "";
		if (this.onMaintainMode()) {
			if (this.FlowKey.getValue().trim().length() > 0
					&& !this.getDbActionMode().equals(Cnstnts.INSERT)) {
				int index = (int) (Math.random() * 1000);
				String TabSelect = Cnstnts.EMPTY_STRING;
				rtnString += "<script type='text/javascript'>createSalesorderTabs1('tabs" + index
						+ "');</script>";

				rtnString += "<tr><td colspan=4>" + "<div id='tabs" + index
						+ "'><ul>";
				rtnString += "<li><a href='#tabs-1'>"+ this.getUserInfo().getMsg("jsp.SalesOrder_detail.title")+ "</a></li>";
				
				Groups group = new Groups();
				//請款紀錄tab調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
				if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
					rtnString += "<li><a href='#tabs-2'>"+ this.getUserInfo().getMsg("jsp.SalesOrder.InvoiceRecordTabTitle")+ "</a></li>";
				}
				if(!Util.compareTo(this.patentIn, "true")) {
					rtnString += "<li><a href='#tabs-3'>"+ this.getUserInfo().getMsg("jsp.SalesOrder.CaseInfoTabTitle")+ "</a></li>";
				}
				rtnString += "</ul>";

				/**** tabs-1 ****/
				rtnString += "<div id='tabs-1'>";
				rtnString += "<div class='indent'>";
				rtnString += "<table width=95% border=0>";
				rtnString += "<tr><td valign=top align=left>";
				
//				if(Util.compareTo(this.getPatentIn(), "true") && 
//						this.getDbActionMode().equals(Cnstnts.UPDATE)) {
//					rtnString += "<input type='hidden' name='changeOS01Flag' id='changeOS01Flag'>";
//					rtnString += "<input type='button' " +
//						"value='" + this.getUserInfo().getMsg("jsp.SalesOrder.ToOS01Btn") + "' " +
//						"onclick='document.input.changeOS01Flag.value=true;setValue();'>";
//				}
				
				rtnString += "</td></tr>";
				rtnString += "<tr><td valign=top>";
				rtnString += "<div id='updateSalesOrder_detailDiv' name='updateSalesOrder_detailDiv'></div>";
				rtnString += "<div id='SalesOrder_detailDiv' name='SalesOrder_detailDiv'>";
				rtnString += "<span style='float:right;'>" +
						"<input type='hidden' id='fromCaseFlag' name='fromCaseFlag' />";
//				if(!Util.compareTo(this.getPatentIn(), "true")){
//					if(Util.compareTo(this.getFromCaseFlag(), "true")){
//						rtnString += "<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToCanInvoiceBtn")+"' onclick='document.input.toCanInvoiceFlag.value=\"true\";setValue();'/>" +
//						"<input type='hidden' id='toCanInvoiceFlag' name='toCanInvoiceFlag' />";
//					}else{
//						rtnString += "<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToInvoiceBtn")+"' onclick='document.input.toInvoiceFlag.value=\"true\";setValue();'/>" +
//						"<input type='hidden' id='toInvoiceFlag' name='toInvoiceFlag' />" +
////									"<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToPaymentBtn")+"' onclick='document.input.toPaymentFlag.value=\"true\";setValue();'/>" +
//						"<input type='hidden' id='toPaymentFlag' name='toPaymentFlag' />" +
//						"<input type='button' value='"+this.getUserInfo().getMsg("jsp.SalesOrder.ToInvalid")+"' onclick='document.input.toInvalidFlag.value=\"true\";setValue();'/>" +
//						"<input type='hidden' id='toInvalidFlag' name='toInvalidFlag' />";
//					}
//				}
				rtnString += "</span>";
				
				Date befDate = new Date();
				rtnString += new SalesOrder_detail().getSearchReasult(this.getUserInfo(), this.getFlowKey());
				Date aftDate = new Date();
				//System.out.println("1 " + (aftDate.getTime() - befDate.getTime()));

				rtnString += "</div></td></tr></table>";
				rtnString += "</div>";
				rtnString += "</div>";
				/**** tabs-1 end ****/

				//請款紀錄tab調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
				if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
				/**** tabs-2 ****/
				rtnString += "<div id='tabs-2'>";
				rtnString += "<div class='indent'>";
				rtnString += "<table width=95% border=0><tr><td valign=top>";
				rtnString += "<div id='updateInvoiceTableHtmlDiv' name='updateInvoiceTableHtmlDiv'></div>";
				rtnString += "<div id='InvoiceTableHtmlDiv' name='InvoiceTableHtmlDiv'>";
				
				befDate = new Date();
				rtnString += printInvoiceTableHtml();
				aftDate = new Date();
				//System.out.println("2 " + (aftDate.getTime() - befDate.getTime()));
				
				rtnString += "</div></td></tr></table>";
				rtnString += "</div>";
				rtnString += "</div>";
				/**** tabs-2 end ****/
				}

				/**** tabs-3 ****/
				if(!Util.compareTo(this.patentIn, "true")) {
					rtnString += "<div id='tabs-3'>";
					rtnString += "<div class='indent'>";
					rtnString += "<table width=95% border=0><tr><td valign=top>";
					rtnString += "<div id='updateCaseDataHtmlDiv' name='updateCaseDataHtmlDiv'></div>";
					rtnString += "<div id='CaseDataHtmlDiv' name='CaseDataHtmlDiv'>";
					if(!Util.isEmpty(this.getCaseKind()) && !Util.isEmpty(this.getRelatedCaseNo())){
						if(Util.compareTo(this.getCaseKind(), "STC01")){
							befDate = new Date();
							rtnString += "<input type='hidden' name='frameurl' id='frameurl' value='PatentCase.jsp?flowKey="+this.getRelatedCaseNo()+"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain&_modeLockFlag=true'>";
							rtnString += "<iframe id='caseframe' src=\"\" width=\"100%\" height=\"1000\" scrolling=\"yes\" frameborder=\"1\"></iframe>";
							aftDate = new Date();
							//System.out.println("3 " + (aftDate.getTime() - befDate.getTime()));
						}else if(Util.compareTo(this.getCaseKind(), "STC02")){
							befDate = new Date();
							rtnString += "<input type='hidden' name='frameurl' id='frameurl' value='TrademarkCase.jsp?flowKey="+this.getRelatedCaseNo()+"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain&_modeLockFlag=true'>";
							rtnString += "<iframe id='caseframe' src=\"\" width=\"100%\" height=\"800\" scrolling=\"yes\" frameborder=\"1\"></iframe>";
							aftDate = new Date();
							//System.out.println("3 " + (aftDate.getTime() - befDate.getTime()));
						}else if(Util.compareTo(this.getCaseKind(), "STC03")){
							rtnString += "<input type='hidden' name='frameurl' id='frameurl' value='LegalCase.jsp?flowKey="+this.getRelatedCaseNo()+"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain&_modeLockFlag=true'>";
							befDate = new Date();
							rtnString += "<iframe id='caseframe' src=\"\" width=\"100%\" height=\"600\" scrolling=\"yes\" frameborder=\"1\"></iframe>";
							aftDate = new Date();
							//System.out.println("3 " + (aftDate.getTime() - befDate.getTime()));
						}else if(Util.compareTo(this.getCaseKind(), "STC04")){
							befDate = new Date();
							rtnString += "<input type='hidden' name='frameurl' id='frameurl' value='CopyrightCase.jsp?flowKey="+this.getRelatedCaseNo()+"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain&_modeLockFlag=true'>";
							rtnString += "<iframe id='caseframe' src=\"\" width=\"100%\" height=\"600\" scrolling=\"yes\" frameborder=\"1\"></iframe>";
							aftDate = new Date();
							//System.out.println("3 " + (aftDate.getTime() - befDate.getTime()));
						}
					}else{
						rtnString += "<span style='float:center;'><font color='red' size='3'>"+this.getUserInfo().getMsg("jsp.SalesOrder.NoCaseInfo")+"</font></span>";
					}
	
					rtnString += "</div></td></tr></table>";
					rtnString += "</div>";
					rtnString += "</div>";
				}
				/**** tabs-3 end ****/

				rtnString += "</div>";

				String scriptText = "<script>"
						+ "function openTabFrame(jspName,dbActionMode,flowkey,frameHight,IFrameDiv,DataDiv){"
						+ "  var frameWidth=document.getElementById('functionBar').offsetWidth;"
						+ "  var tabFramDiv=document.getElementById(IFrameDiv);"
						+ "  var varDataDiv=document.getElementById(DataDiv);"
						+

						"  var srcUrl=jspName+'.jsp?_pageActionMode=maintain&_dbActionMode='+dbActionMode;"
						+ "  if(dbActionMode.match('^insert') == 'insert'){"
						+ "    srcUrl += '&parentId='+flowkey;"
						+ "  } else {"
						+ "    srcUrl += '&_getDataFlag=true&flowKey='+flowkey;"
						+ "  }"
						+ "  varDataDiv.style.display='none';"
						+ "  tabFramDiv.style.display='';"
						+ "  tabFramDiv.innerHTML=\"<iframe "
						+ "src='\"+srcUrl+\"' height='\"+frameHight+\"' width='\"+(frameWidth-80)+\"'></iframe>\";"
						+ "}"
						+ "function closeTabFrame(IFrameDiv,DataDiv){"
						+ "  var tabFramDiv=document.getElementById(IFrameDiv);"
						+ "  var varDataDiv=document.getElementById(DataDiv);"
						+ "  tabFramDiv.style.display='none';"
						+ "  varDataDiv.style.display='';" + "}"
						+ "function resetFrame(newTabText){"
						+ "  var IFramDiv='update'+newTabText+'Div';"
						+ "  var DataDiv=newTabText+'Div'; "
						+ "  closeTabFrame(IFramDiv,DataDiv);"
						+ "  doPatentCaseAjaxRequest('SalesOrder',newTabText,'"
						+ this.getFlowKey() + "',DataDiv,'innerHTML')" + "}"
						+ "</script>";
				rtnString += scriptText;
				rtnString += "</td></tr>";
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

		Properties empPrpt = null;
		try {
			empPrpt = new Employee().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Properties attorneyPrpt = null;
		try {
			attorneyPrpt = new Attorney().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.Attorney.setListWidth("10%");
		this.Attorney.setMapingPrpt(attorneyPrpt);
		this.Attorney.setNotShowCode(true);

		this.ParentId.setListWidth("10%");
		this.SoNo.setListWidth("10%");
		this.CaseNo.setListWidth("10%");
		this.ClientName.setListWidth("10%");
		this.Remark.setListWidth("10%");

		this.InCharge.setListWidth("10%");
		this.InCharge.setMapingPrpt(empPrpt);
		this.InCharge.setNotShowCode(true);


		this.SoStatus.setListWidth("10%");
		this.SoStatus.setMapingPrpt(categoryPrpt);
		this.SoStatus.setNotShowCode(true);
		
		this.CreateDate.setListWidth("10%");


		Field[] showField = { this.ParentId, this.SoNo, this.CaseNo,
				this.ClientName, this.InCharge, this.CreateDate, this.Remark, this.SoStatus,
				this.Attorney};

		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;

		if (!Util.isEmpty(getCond1())) {
			boolean searchLike = true;
			String like = Cnstnts.LIKE;
			if (getCond1().equalsIgnoreCase("ClientName")) {
				if (!Util.isEmpty(getFullSearchText1())) {
					if (whereStr.trim().length() > 0) {
						whereStr += " And p.client in (select c.flowkey from client c where c.CompanyName like '%"
								+ this.getFullSearchText1() + "%') ";
					} else {
						whereStr = " where p.client in (select c.flowkey from client c where c.CompanyName like '%"
								+ this.getFullSearchText1() + "%') ";
					}
				}
			}
			else {
				if (!Util.isEmpty(getFullSearchText1())) {
					if (whereStr.indexOf("where") != -1) {
						whereStr += " and p."
								+ getCond1()
								+ " "
								+ like
								+ " '"
								+ ((searchLike) ? '%' + getFullSearchText1() + '%'
										: getFullSearchText1()) + "' ";
					} else {
						whereStr += " where p."
								+ getCond1()
								+ " "
								+ like
								+ " '"
								+ ((searchLike) ? '%' + getFullSearchText1() + '%'
										: getFullSearchText1()) + "' ";
					}
				}
			}
		} else {
			if (!Util.isEmpty(getFullSearchText1())) {
				// 全文檢索
				if (whereStr.indexOf("where") != -1) {
					whereStr += " and ";
				} else {
					whereStr += " where ";
				}

				whereStr += "(p.FlowKey like '%"
						+ getFullSearchText1()
						+ "%' or "
						+ "p.SoNo like '%"
						+ getFullSearchText1()
						+ "%' or "
						+ "p.ParentId like '%"
						+ getFullSearchText1()
						+ "%' or "
						+ "p.Client like '%"
						+ getFullSearchText1()
						+ "%' or "
						+ "p.ServiceProjectCode like '%"
						+ getFullSearchText1()
						+ "%' or "
						+ "p.OriginalTitle like '%"
						+ getFullSearchText1()
						+ "%' or "
						+ "p.Remark like '%"
						+ getFullSearchText1()
						+ "%' or "
						+ "p.RelatedCaseNo like '%"
						+ getFullSearchText1()
						+ "%' or "
						+ "p.Client in (select cc.FlowKey from Client cc where CompanyName like '%"
						+ this.getFullSearchText1()
						+ "%') or "
						+ "p.InCharge in (select cc.FlowKey from Employee cc where Emp_Name like '%"
						+ this.getFullSearchText1()
						+ "%')";
				whereStr += ")";
			}
		}

		if (!Util.isEmpty(getCond2())) {

			boolean searchLike = true;
			String like = Cnstnts.LIKE;
			if (getSqlCond1().equals("not")) {
				like = " not like ";
			}

			if (getSqlCond1().equals("not")) {
				if (!Util.isEmpty(getFullSearchText2())) {
					if (whereStr.indexOf("where") != -1) {
						whereStr += " and p."
							+ getCond2()
							+ " "
							+ like
							+ " '"
							+ ((searchLike) ? '%' + getFullSearchText2() + '%'
									: getFullSearchText2()) + "' ";
					} else {
						whereStr += " where p."
							+ getCond2()
							+ " "
							+ like
							+ " '"
							+ ((searchLike) ? '%' + getFullSearchText2() + '%'
									: getFullSearchText2()) + "' ";
					}
				}
			} else {
				if (!Util.isEmpty(getFullSearchText2())) {
					if (whereStr.indexOf("where") != -1) {
						whereStr += " "
								+ getSqlCond1()
								+ " p."
								+ getCond2()
								+ " "
								+ like
								+ " '"
								+ ((searchLike) ? '%' + getFullSearchText2() + '%'
										: getFullSearchText2()) + "' ";
					} else {
						whereStr += " where p."
								+ getCond2()
								+ " "
								+ like
								+ " '"
								+ ((searchLike) ? '%' + getFullSearchText2() + '%'
										: getFullSearchText2()) + "' ";
					}
				}
			}
		} else {
			if (!Util.isEmpty(getFullSearchText2())) {

				// 全文檢索
				if (getSqlCond1() != null && getSqlCond1().equals("not")) {
					if (whereStr.indexOf("where") != -1) {
						whereStr += " and ";
					} else {
						whereStr += " where ";
					}

					whereStr += "(p.FlowKey  not like  '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.SoNo  not like  '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.ParentId  not like  '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.Client  not like  '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.ServiceProjectCode  not like  '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.OriginalTitle  not like  '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.Remark  not like  '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.RelatedCaseNo  not like  '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.Client in (select cc.FlowKey from Client cc where CompanyName not like '%"
							+ this.getFullSearchText2() + "%') or "
							+ "p.InCharge in(select cc.FlowKey from Employee cc where Emp_Name not like '%"
							+ this.getFullSearchText2()
							+ "%')";
					whereStr += ")";
				} else {
					if (whereStr.indexOf("where") != -1) {
						whereStr += " and ";
					} else {
						whereStr += " where ";
					}
					whereStr += "(p.FlowKey like '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.SoNo like '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.ParentId like '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.Client like '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.ServiceProjectCode like '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.OriginalTitle like '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.Remark like '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.RelatedCaseNo like '%"
							+ getFullSearchText2()
							+ "%' or "
							+ "p.Client in (select cc.FlowKey from Client cc where CompanyName like '%"
							+ this.getFullSearchText2() + "%') or "
							+ "p.InCharge in (select cc.FlowKey from Employee cc where Emp_Name like '%"
							+ this.getFullSearchText2()
							+ "%')";

					whereStr += ")";
				}
			}
		}

		if (!Util.isEmpty(getCond3())) {
			if (getSqlCond2().equals("not")) {
				if (whereStr.indexOf("where") != -1) {
					whereStr += " and p." + getCond3() + " not between '"
							+ getStartDate() + "' and '" + getEndDate() + "' ";
				} else {
					whereStr += " where p." + getCond3() + " between '"
							+ getStartDate() + "' and '" + getEndDate() + "' ";
				}
			} else {
				if (whereStr.indexOf("where") != -1) {
					whereStr += " " + getSqlCond2() + " p." + getCond3()
							+ " between '" + getStartDate() + "' and '"
							+ getEndDate() + "' ";
				} else {
					whereStr += " where p." + getCond3() + " between '"
							+ getStartDate() + "' and '" + getEndDate() + "' ";
				}
			}
		}
		
		
		
		/*
1.登入的帳號，判斷若登入者的部門為AC00下階的（或者部門代碼第3-4碼為AC） 
就過濾掉條件僅 狀態 可請款和已請款的訂單才顯示，排序預設為可請款的在上面， 
		 */
		if(Util.compareTo(this.getUserInfo().getAttribute("dept_id"), "AC00") ||
				(this.getUserInfo().getAttribute("dept_id").length() > 4 && 
				Util.compareTo(this.getUserInfo().getAttribute("dept_id").substring(2, 4), "AC"))) {
			if (whereStr.indexOf("where") != -1) {
				whereStr += " and p.SoStatus in ('OS01', 'OS02') ";
			} else {
				whereStr += " where p.SoStatus in ('OS01', 'OS02') ";
			}
		}

		whereStr = Util.addWhereSQL(whereStr, this.AttorneyCase);
//		whereStr = this.getDataAuthorityWhereSQL(whereStr);
		
		/*
		針對.報價單、內部訂單、客戶資料、聯絡人
		四個功能去寫死讓業務和業助欄位可以進行檢視、編輯。so 僅檢視
		 */
		String whereStr2 = "";
		
		whereStr2 = this.getDataAuthorityWhereSQL(whereStr2);

		if (!this.getUserInfo().canQueryAll(this.getProgramId())) {
			whereStr2 = whereStr2.replace("where", "where (") + " or" +
					" p.incharge = '" + this.getUserInfo().getAttribute("emp_id") + "') ";
		}
		
		if(whereStr2.indexOf("where") == -1) {
			whereStr2 += whereStr;
		}
		else if(whereStr2.indexOf("where") != -1 && whereStr.indexOf("where") != -1) {
			whereStr2 += " and " + whereStr.replaceFirst("where", " ");
		}
				
		String SQL = "select * from SalesOrder p " + whereStr2;
		
		if(Util.compareTo(this.getUserInfo().getAttribute("dept_id"), "AC00") ||
				(this.getUserInfo().getAttribute("dept_id").length() > 4 && 
				Util.compareTo(this.getUserInfo().getAttribute("dept_id").substring(2, 4), "AC"))) {
			if(this.getOrderKey().equalsIgnoreCase("flowkey")) {
				SQL += " order by sostatus";
			}
			else {
				SQL = Util.addOrderSQL(SQL, this.getOrderKey(), this.getOrderSequence());
			}
		}
		else {
			SQL = Util.addOrderSQL(SQL, this.getOrderKey(), this.getOrderSequence());
		}
		
		
		System.out.println(SQL);
		return this.doSearch(SQL);
	}

	public List<Object[]> doSearch(String SQL) throws Exception {
		if (this.getPageNo() == 0) {
			this.setPageNo(1);
		}
		int recordCount = 0;

		List<Object[]> rtnList = new ArrayList<Object[]>();

		Iterator<?> itr = this.getDbUtil().getList(SQL, this.getShowField())
				.iterator();
		while (itr.hasNext()) {
			Object[] record = (Object[]) itr.next();
			recordCount++;
			if (recordCount <= this.getPageNo() * this.getPageRecords()
					&& recordCount > (this.getPageNo() - 1)
							* this.getPageRecords()) {
				rtnList.add(record);
			}
		}
		this.setFindRecords(recordCount);
		return rtnList;
	}

	public void setPreObj(UserBean userInfo) {
		if (userInfo.getObj(this.getTableName()) != null) {
			SalesOrder preObj = (SalesOrder) userInfo.getObj(this.getTableName());
			if (this.onBtnDeleteDetail() && this.getDeleteItems() != null
					&& this.getDeleteItems().length > 0) {
				for (int i = 0; i < this.getDeleteItems().length; i++) {
					int seqNo = Integer.parseInt(this.getDeleteItems()[i]);
					preObj.getDetails().remove(seqNo - i);
				}
			}
			this.setSearchResult(preObj.getSearchResult());
			if (!this.getDataFromDB()) {
				this.setDetails(preObj.getDetails());
			}
		}
	}

	public boolean checkInsertError() throws Exception {
		if (super.checkInsertError()) {
			return true;
		} else {
			if(Util.compareTo(this.getDbActionMode(), Cnstnts.INSERT) && Util.isEmpty(this.getSoNo())) {
				this.setSoNo(FlowEngin.getPkeyNo("SO" + Util.getDate().replaceAll(Util.defaultConnectChar, ""), 3, false, "."));
			}
			if(Util.compareTo(this.getShowItem(), "NewCase")) {
				if(this.getCanEditField(this.PriorityRight)) {
					if(Util.isEmpty(this.getPriorityRight())) {
						String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
								+ PriorityRight.getName())
								+ this.getUserInfo().getMsg("jsp.common.EmptyError");
						this.setTagId(PriorityRight.getTagName());
						this.setErrorMessage(errorMsg);
						return true;
					}
				}
			}
//			if(this.getCanEditField(this.ApplicantAdd)) {
//				if(Util.isEmpty(this.getApplicantAdd())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ ApplicantAdd.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(ApplicantAdd.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.ContactAdd)) {
//				if(Util.isEmpty(this.getContactAdd())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ ContactAdd.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(ContactAdd.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.BillSendTo)) {
//				if(Util.isEmpty(this.getBillSendTo())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ BillSendTo.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(BillSendTo.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.BillAdd)) {
//				if(Util.isEmpty(this.getBillAdd())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ BillAdd.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(BillAdd.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.FilingFee)) {
//				if(Util.isEmpty(this.FilingFee.getValue()) && 
//						Util.isEmpty(this.ExamFee.getValue()) && 
//						Util.isEmpty(this.PRFee.getValue()) && 
//						Util.isEmpty(this.ExPageFee.getValue()) && 
//						Util.isEmpty(this.TransFee.getValue()) && 
//						Util.isEmpty(this.NatPhaFee.getValue()) && 
//						Util.isEmpty(this.MiscFee.getValue()) && 
//						Util.isEmpty(this.Other2 .getValue())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ InvoiceItem.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(FilingFee.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.BillSendDoc1)) {
//				if(Util.isEmpty(this.BillSendDoc1.getValue())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ BillSendDoc1.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(BillSendDoc1.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.BillSendDoc2)) {
//				if(Util.isEmpty(this.BillSendDoc2.getValue())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ BillSendDoc2.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(BillSendDoc2.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.BillSendDoc3)) {
//				if(Util.isEmpty(this.BillSendDoc3.getValue())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ BillSendDoc3.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(BillSendDoc3.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.BillSendDoc4)) {
//				if(Util.isEmpty(this.BillSendDoc4.getValue())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ BillSendDoc4.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(BillSendDoc4.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.BillSendDoc5)) {
//				if(Util.isEmpty(this.BillSendDoc5.getValue())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ BillSendDoc5.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(BillSendDoc5.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.BillSendDoc6)) {
//				if(Util.isEmpty(this.BillSendDoc6.getValue())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ BillSendDoc6.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(BillSendDoc6.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
//			if(this.getCanEditField(this.BillSendDoc7)) {
//				if(Util.isEmpty(this.BillSendDoc7.getValue())) {
//					String errorMsg = this.getUserInfo().getMsg(this.getProgramId() + "."
//							+ BillSendDoc7.getName())
//							+ this.getUserInfo().getMsg("jsp.common.EmptyError");
//					this.setTagId(BillSendDoc7.getTagName());
//					this.setErrorMessage(errorMsg);
//					return true;
//				}
//			}
			return false;
		}
	}

	public boolean checkUpdateError() throws Exception {
		return this.checkInsertError();
	}

	public boolean checkDeleteError() throws Exception {
		if (super.checkDeleteError()) {
			return true;
		} else {
			return false;
		}
	}


	public void doAction(UserBean userInfo) throws Exception {
		this.setUserInfo(userInfo);
		if (this.getApplicant().trim().length() == 0 || this.canEdit()) {
			this.setApplicant(userInfo.getAttribute("emp_id"));
		}
		if (this.getCreateDept().trim().length() == 0 || this.canEdit()) {
			this.setCreateDept(userInfo.getAttribute("dept_id"));
		}
		if (!this.getModeLockFlag().equals(Cnstnts.TRUE_FLAG)) {
			if (this.getProgramMode().equals("M")) {
				this.setPageActionMode(Cnstnts.MAINTAIN);
				this.setModeLockFlag(Cnstnts.TRUE_FLAG);
			} else if (this.getProgramMode().equals("S")) {
				this.setPageActionMode(Cnstnts.SEARCH);
				this.setModeLockFlag(Cnstnts.TRUE_FLAG);
			}
		}
		if (Cnstnts.PRINT.equals(this.getDbActionMode())
				&& Cnstnts.MAINTAIN.equals(this.getPageActionMode())
				&& this.onBtnSubmit() && this.getFlowKey().trim().length() > 0) {
			this.doPrintProcess();
		}
		if (Cnstnts.EXPORTCSV.equals(this.getDbActionMode())
				&& Cnstnts.SEARCH.equals(this.getPageActionMode())) {
			this.doExportCsvProcess();
		}
		if (Cnstnts.EXPORTXLS.equals(this.getDbActionMode())
				&& Cnstnts.SEARCH.equals(this.getPageActionMode())) {
			this.doExportXlsProcess();
		}
		if(Util.compareTo(this.getChangeOS01Flag(), "true")) {
			doChangeStatusProcess("OS01");
		}
		if (Util.compareTo(this.getToInvoiceFlag(), "true")) {
			this.doInvoiceProcess(this.getMarkKeys());
		}
		if (Util.compareTo(this.getToPaymentFlag(), "true")) {
//			this.doPaymentProcess();
			//System.out.println("getToPaymentFlag");
			for(String key :this.getMarkKeys()){
				//System.out.println(key);
			}
		}
		if (Util.compareTo(this.getToInvalidFlag(), "true")) {
			this.doInvalidProcess(this.getMarkKeys());
		}
		if ((Cnstnts.SIGN.equals(this.getDbActionMode()) || Cnstnts.CLOSE
				.equals(this.getDbActionMode()))
				&& Cnstnts.MAINTAIN.equals(this.getPageActionMode())
				&& this.getFlowKey().trim().length() > 0) {
			Flow f = new Flow(this.getFlowKey());
			this.setFlowStep(f.getFinished_steps() + 1);
			this.setFlowStepName(FlowEngin.getStep_name(
					Util.getFlowInfo(f.getFlow_id()), this.getFlowStep()));
		} else {
			this.setFlowStepName(Cnstnts.EMPTY_STRING);
			this.setFlowStep(0);
		}
		if (this.getDataFromDB()) {
			this.setPreObj(userInfo);
			this.getAttribute();
		} else {
			if (userInfo.getObj(this.getTableName()) != null) {
				this.setPreObj(userInfo);
				if (this.canAccessDB())
					this.dbExecute();
				if (this.onBtnClear()) {
					this.clearAttribute();
					this.setSearchResult(null);
				}
				if (!this.getDbActionMode().equals(Cnstnts.INSERT)
						&& this.FlowKey.getValue().trim().length() == 0
						&& this.getPageActionMode().equals(Cnstnts.MAINTAIN)) {
					this.clearAttribute();
				}
			}
		}
	}
	
	public void doChangeStatusProcess(String status) throws Exception {
		List<String> sqls = new ArrayList<String>();
		
//		if(this.getMarkKeys() != null && this.getMarkKeys().length > 0) {
//			for(String key : this.getMarkKeys()) {
//				sqls.add("update salesorder_detail set SoStatus ='" + status + "' where flowkey ='" + key + "';");
//			}
//		}
		this.SoStatus.setValue(status);
		String dbAction = this.getDbActionMode();
		this.setDbActionMode(Cnstnts.UPDATE);
		try {
			this.update();
		}
		catch(Exception e) {}
		this.setDbActionMode(dbAction);
		
		//sqls.add("update salesorder set SoStatus ='" + status + "' where flowkey ='" + this.getFlowKey() + "';");
		sqls.add("update salesorder_detail set SoStatus ='" + status + "' where parentid ='" + this.getFlowKey() + "';");
		this.setJavascriptCode("window.opener.setValue();");
		this.getDbUtil().executeUpdate(sqls);
		
		if(Util.compareTo(status, "OS01")) {
			sendMail(new Quotation(this.getParentId()));
			
			this.setJavascriptCode("window.opener.dbActionMode.value=\"update\";window.opener.setValue();");
		}
	}
	
	public void sendMail(Quotation qu) throws Exception {
		/*
3. 案件內關連訂單分頁點開的內部訂單，按下"可請款"按鈕-->e-mail通知財會(可選擇加入其他人或是共用帳號)  
(1) 通知對象：財會共用帳號: accounting@essenptl.com
(2) 標題: [轉可請款] 案件編號XXXX；客戶名稱:XXXX
(3) 內容:關連訂單(內部訂單)的欄位，如下:
關連報價單號                內部訂單號                    案件編號                 客戶名稱           業務人員     立案日期              備註          訂單狀態
CC20130916.011      SO20130917.014      TP130268-TW     中華大學          江昌倫          2013-09-17                         可請款
						 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(new Date());

		Properties clientProp = null;
		Properties applicantProp = null;
		Properties empProp = null;
		Properties categoryProp = null;
		Properties matterProp = null;
		try {
			clientProp = new Client().getNamesPrpts();
			categoryProp = new Category().getNamesPrpts();
			empProp = new Employee().getNamesPrpts();
		} catch (Exception e) {
		}
		Vector mailDataVtr = new Vector();

		String caseno = "";
		if(Util.compareTo(this.getCaseKind(), "STC01")) {
			String mailTitle = "[轉可請款] 案件編號:" + caseno + "；客戶名稱:" + qu.getClientName();
			String mailContent = "<table width='400' border=1>";
			mailContent += "<tr><td>關連報價單號</td><td>" + qu.getFlowKey() + "</td></tr>";
			mailContent += "<tr><td>內部訂單號</td><td>" + this.getSoNo() + "</td></tr>";
			mailContent += "<tr><td>案件編號</td><td>" + this.getCaseNo() + "</td></tr>";
			mailContent += "<tr><td>客戶名稱</td><td>" + qu.getClientName() + "</td></tr>";
			mailContent += "<tr><td>業務人員</td><td>" + empProp.getProperty(qu.getInCharge()) + "</td></tr>";
			//mailContent += "<tr><td>立案日期</td><td>" + this.getCreateDate() + "</td></tr>";
			mailContent += "<tr><td>備註</td><td>" + this.getRemark() + "</td></tr>";
			mailContent += "<tr><td>訂單狀態</td><td>" + categoryProp.getProperty(this.getSoStatus()) + "</td></tr>";
			mailContent += "</table>";

			String ClientContect = "";
			String AssignedTo = "";
			String TaskCreator ="";
			String AssignedToSupervisor = "";
			/* 發信時間改成抓todos的提醒日期 */
			String mailTime = Util.getDate() + " 08:00:00";


			MailManager mailCheck = new MailManager("MailManager");

//			MailThreadConfig_detail mailData = new MailThreadConfig_detail();
//			mailData.setSourceTableName("Quotation.sendMail01");
//			mailData.setPKey(Util.getNo("Mail" + Util.getDayOfYear(), 2));
//			mailData.setTitle(mailTitle);
//			mailData.setMailTime(mailTime);
//			mailData.setContent(mailContent);
//			mailData.setMailTo("jlinkuo@synergytek.com.tw");
//			mailDataVtr.add(mailData);
//			Util.sendMailDirect("accounting@essenptl.com", mailContent, mailTitle);
			
			if(!Util.isEmpty(qu.getNotifyTarget2())) {
				//System.out.println("NotifyTarget="+qu.getNotifyTarget2());
				String[] targets = qu.getNotifyTarget2().split(";");
				for(String target : targets) {
					if (!Util.isEmpty(target)) {
//						mailData = new MailThreadConfig_detail();
//						mailData.setSourceTableName("Quotation.sendMail01");
//						mailData.setPKey(Util.getNo("Mail" + Util.getDayOfYear(), 2));
//						mailData.setTitle(mailTitle);
//						mailData.setMailTime(mailTime);
//						mailData.setContent(mailContent);
//						mailData.setMailTo("ymli680215@gmail.com");
//						mailDataVtr.add(mailData);
						if(Util.chkEmail(target)) {
							Util.sendMailDirect(target, mailContent, mailTitle, this.getDbUtil());
						}
					}
				}
			}
		}
		
//		new MailThreadConfig_detail().insert(Cnstnts.EMPTY_STRING, mailDataVtr.iterator());
	}

	public void clearAttribute() {
		super.clearAttribute();
		this.setClientName(Cnstnts.EMPTY_STRING);
	}

	public void resetFieldData(String divName, String fieldName, String value) {
		if (fieldName == null) {
			return;
		}

		if (fieldName.equalsIgnoreCase("FlowKey")) {
			setFlowKey(value);
		}
		if (fieldName.equalsIgnoreCase("CreateDept")) {
			if (divName.equals("cond1")) {
				setDataDept(value);
				setCreateDept(value);
				setApplicant(getFullSearchText3());
			} else if (divName.equals("cond2")) {
				setDataDept2(value);
				setCreateDept(value);
				setApplicant(getFullSearchText4());
			}
		}
		if (fieldName.equalsIgnoreCase("SoStatus")) {
			setSoStatus(value);
		}
		if (fieldName.equalsIgnoreCase("ParentId")) {
			setParentId(value);
		}
		if (fieldName.equalsIgnoreCase("SoNo")) {
			setSoNo(value);
		}
		if (fieldName.equalsIgnoreCase("Client")) {
			setClient(value);
		}
		if (fieldName.equalsIgnoreCase("ClientName")) {
			setClientName(value);
		}
		if (fieldName.equalsIgnoreCase("ServiceProjectCode")) {
			setServiceProjectCode(value);
		}
		if (fieldName.equalsIgnoreCase("OriginalTitle")) {
			setOriginalTitle(value);
		}
		if (fieldName.equalsIgnoreCase("InCharge")) {
			setInCharge(value);
		}
		if (fieldName.equalsIgnoreCase("Remark")) {
			setRemark(value);
		}
		if (fieldName.equalsIgnoreCase("RelatedCaseNo")) {
			setRelatedCaseNo(value);
		}
		if (fieldName.equalsIgnoreCase("CaseKind")) {
			setCaseKind(value);
		}
		if (fieldName.equalsIgnoreCase("PatentOffice")) {
			setPatentOffice(value);
		}
		if (fieldName.equalsIgnoreCase("PatentType")) {
			setPatentType(value);
		}
		if (fieldName.equalsIgnoreCase("Attorney")) {
			setAttorney(value);
		}
	}

	public String checkSelected(String condName, String optionName) {
		String result = "";
		if (condName.equals("cond1")) {
			if (getCond1().equals(optionName)) {
				result = "selected";
			}
		} else if (condName.equals("cond2")) {
			if (getCond2().equals(optionName)) {
				result = "selected";
			}
		}
		return result;
	}

	public String genSearchCondList(String name) throws Exception {
		String function = "1";

		String htmlCode = "";
		if (name.equals("cond1")) {
			htmlCode = "<select  id='" + name + "' name='" + name
					+ "' onChange=\"changeDiv" + function + "(this, '" + name
					+ "_div');\">" + Cnstnts.NEW_LINE;

			if (getCond1() == null) {
				setCond1("");
			}

			htmlCode += "<option "
					+ checkSelected(name, "ParentId")
					+ " value='ParentId'>"
					+ this.getUserInfo().getMsg("jsp.SalesOrder.ParentId")
					+ "</option>"
					+ Cnstnts.NEW_LINE 
					+ "<option "
					+ checkSelected(name, "SoNo")
					+ " value='SoNo'>"
					+ this.getUserInfo().getMsg(
							"jsp.SalesOrder.SoNo")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+ "<option "
					+ checkSelected(name, "CaseNo")
					+ " value='CaseNo'>"
					+ this.getUserInfo().getMsg(
							"jsp.SalesOrder.CaseNo") + "</option>"
					+ Cnstnts.NEW_LINE
					+ "<option "
					+ checkSelected(name, "Client")
					+ " value='Client'>"
					+ this.getUserInfo().getMsg("jsp.SalesOrder.Client")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+ "<option "
					+ checkSelected(name, "ClientName")
					+ " value='ClientName'>"
					+ this.getUserInfo().getMsg("jsp.SalesOrder.ClientName")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+ "<option "
					+ checkSelected(name, "ServiceProjectCode")
					+ " value='ServiceProjectCode'>"
					+ this.getUserInfo().getMsg("jsp.SalesOrder.ServiceProjectCode")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+ "<option "
					+ checkSelected(name, "OriginalTitle")
					+ " value='OriginalTitle'>"
					+ this.getUserInfo().getMsg("jsp.SalesOrder.OriginalTitle")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+ "<option "
					+ checkSelected(name, "Remark")
					+ " value='Remark'>"
					+ this.getUserInfo().getMsg(
							"jsp.SalesOrder.Remark") + "</option>"
					+ Cnstnts.NEW_LINE + "</select>";
		}
		if (name.equals("cond2")) {
			if (getCond2() == null) {
				setCond2("");
			}
			function = "2";

			htmlCode = "<select  id='" + name + "' name='" + name
					+ "' onChange=\"changeDiv" + function + "(this, '" + name
					+ "_div');setValue();\">" + Cnstnts.NEW_LINE;

			htmlCode += // "<option value=''>" +
						// this.getUserInfo().getMsg("jsp.Quotation.FullSearch")
						// + "</option>" +Cnstnts.NEW_LINE +
					"<option "
					+ checkSelected(name, "Attorney")
					+ " value='Attorney'>"
					+ this.getUserInfo().getMsg(
							"jsp.SalesOrder.Attorney")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+ "<option "
					+ checkSelected(name, "InCharge")
					+ " value='InCharge'>"
					+ this.getUserInfo().getMsg(
							"jsp.SalesOrder.InCharge")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+"<option "
					+ checkSelected(name, "CaseKind")
					+ " value='CaseKind'>"
					+ this.getUserInfo().getMsg(
							"jsp.SalesOrder.CaseKind")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+"<option "
					+ checkSelected(name, "PatentOffice")
					+ " value='PatentOffice'>"
					+ this.getUserInfo().getMsg(
							"jsp.SalesOrder.PatentOffice")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+"<option "
					+ checkSelected(name, "PatentType")
					+ " value='PatentType'>"
					+ this.getUserInfo().getMsg(
							"jsp.SalesOrder.PatentType")
					+ "</option>"
					+ Cnstnts.NEW_LINE
					+"<option "
					+ checkSelected(name, "SoStatus")
					+ " value='SoStatus'>"
					+ this.getUserInfo().getMsg(
							"jsp.SalesOrder.SoStatus")
					+ "</option>"
					+ Cnstnts.NEW_LINE + "</select>";
		}
		return htmlCode;
	}

	public String genSearchDateList() throws Exception {
		if (getCond3() == null) {
			setCond3("");
		}

		String htmlCode = "<select name='cond3' onChange=\"document.input.startDate.value='';document.input.endDate.value='';\">"
				+ Cnstnts.NEW_LINE
				+ "<option "
				+ (getCond3().equals("") ? "selected" : "")
				+ " value=''>"
				+ this.getUserInfo().getMsg("jsp.account.select")
				+ "</option>"
				+ Cnstnts.NEW_LINE
				+ "<option "
				+ (getCond3().equals("QuotationDate") ? "selected" : "")
				+ " value='QuotationDate'>"
				+ this.getUserInfo().getMsg("jsp.SalesOrder.QuotationDate")
				+ "</option>" 
				+ Cnstnts.NEW_LINE
				+ "<option "
				+ (getCond3().equals("CreateDate") ? "selected" : "")
				+ " value='CreateDate'>"
				+ this.getUserInfo().getMsg("jsp.SalesOrder.CreateDate")
				+ "</option>"
				+ Cnstnts.NEW_LINE + "</select>";

		return htmlCode;
	}

	public String genSqlCondList(String name) throws Exception {
		String value = "";
		if (name.equals("sqlCond1")) {
			value = getSqlCond1();
		} else if (name.equals("sqlCond2")) {
			value = getSqlCond2();
		}
		String htmlCode = "<select name='" + name + "'>" + Cnstnts.NEW_LINE
				+ "<option value='and' "
				+ (value.equalsIgnoreCase("and") ? "selected" : "")
				+ ">AND</option>" + Cnstnts.NEW_LINE + "<option value='or' "
				+ (value.equalsIgnoreCase("or") ? "selected" : "")
				+ ">OR</option>" + Cnstnts.NEW_LINE + "<option value='not' "
				+ (value.equalsIgnoreCase("not") ? "selected" : "")
				+ ">NOT</option>" + Cnstnts.NEW_LINE + "</select>";

		return htmlCode;
	}

	public String genSearchCondScript(String name) throws Exception {
		if (getFullSearchText1() == null) {
			setFullSearchText1("");
		}
		if (getFullSearchText2() == null) {
			setFullSearchText2("");
		}

		String scriptCode = "<script language=\"javascript\">"
				+ Cnstnts.NEW_LINE;
		if (name.equalsIgnoreCase("fullSearchText1")) {
			scriptCode += "function changeDiv1(selecter, div) {"
					+ Cnstnts.NEW_LINE
					+ "var id = selecter[selecter.selectedIndex].value;"
					+ Cnstnts.NEW_LINE + "var htmlCode;" + Cnstnts.NEW_LINE;
			
			scriptCode += "if(id == '' || id == 'FlowKey' || id == 'ParentId' || id == 'SoNo' || id == 'FlowKey' || id == 'Client' || id == 'ClientName' || id == 'ServiceProjectCode' "
					+ " || id == 'OriginalTitle' || id == 'Remark' || id == 'CaseNo' ) {"
					+ Cnstnts.NEW_LINE
					+ "htmlCode = \"<input type='text' id='"
					+ name
					+ "' name='"
					+ name
					+ "' maxLength='200' value='"
					+ getFullSearchText1()
					+ "'/>\";"
					+ Cnstnts.NEW_LINE
					+ "}"
					+ Cnstnts.NEW_LINE;

		} else if (name.equalsIgnoreCase("fullSearchText2")) {
			scriptCode += "function changeDiv2(selecter, div) {"
					+ Cnstnts.NEW_LINE
					+ "var id = selecter[selecter.selectedIndex].value;"
					+ Cnstnts.NEW_LINE + "var htmlCode;" + Cnstnts.NEW_LINE;

			scriptCode += "if(id == '' || id == 'FlowKey' || id == 'ApplyNo' || id == 'LicenseNo' || id == 'Title' || id == 'OriginalTitle' "
					+ " || id == 'Client'|| id == 'ClientName' || id == 'SerialMotherCase' || id == 'InternalNo' || id == 'Country') {"
					+ Cnstnts.NEW_LINE
					+ "htmlCode = \"<input type='text' id='"
					+ name
					+ "' name='"
					+ name
					+ "' maxLength='200' value='"
					+ getFullSearchText2()
					+ "'/>\";"
					+ Cnstnts.NEW_LINE
					+ "}"
					+ Cnstnts.NEW_LINE;
		}

		String oldName = "";
		String inputValue = "";
		// if(name.equals("fullSearchText1")) {
		// inputValue = this.getFullSearchText1();
		//
		// oldName = this.CreateDept.getName();
		// this.CreateDept.setName(name);
		// scriptCode += "else if(id == 'CreateDept') {" + Cnstnts.NEW_LINE +
		// "htmlCode = \"" +
		// getSearchDeptListHtml(super.getDataDept()).replaceAll("\n", "") +
		// "   " +
		// getSearchCreatorListHtml(super.getDataDept(),
		// getCreator()).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
		// "}" + Cnstnts.NEW_LINE;
		// this.CreateDept.setName(oldName);
		// }
		// else if(name.equals("fullSearchText2")) {
		// inputValue = this.getFullSearchText2();
		//
		// oldName = this.CreateDept.getName();
		// this.CreateDept.setName(name);
		// scriptCode += "else if(id == 'CreateDept') {" + Cnstnts.NEW_LINE +
		// "htmlCode = \"" + getSearchDeptListHtml(DataDept2).replaceAll("\n",
		// "") + "   " + getSearchCreatorListHtml(DataDept2,
		// Creator2).replaceAll("\n", "") + "\";" + Cnstnts.NEW_LINE +
		// "}" + Cnstnts.NEW_LINE;
		// this.CreateDept.setName(oldName);
		// }

		oldName = this.InCharge.getName();
		this.InCharge.setName(name);
		scriptCode += "else if(id == 'InCharge') {" + Cnstnts.NEW_LINE
				+ "htmlCode = \""
				+ printTag(this.InCharge).replaceAll("\n", "") + "\";"
				+ Cnstnts.NEW_LINE + "}" + Cnstnts.NEW_LINE;
		this.InCharge.setName(oldName);
		
		oldName = this.CaseKind.getName();
		this.CaseKind.setName(name);
		scriptCode += "else if(id == 'CaseKind') {" + Cnstnts.NEW_LINE
		+ "htmlCode = \""
		+ printTag(this.CaseKind).replaceAll("\n", "") + "\";"
		+ Cnstnts.NEW_LINE + "}" + Cnstnts.NEW_LINE;
		this.CaseKind.setName(oldName);
		
		oldName = this.Attorney.getName();
		this.Attorney.setName(name);
		scriptCode += "else if(id == 'Attorney') {" + Cnstnts.NEW_LINE
		+ "htmlCode = \""
		+ printTag(this.Attorney).replaceAll("\n", "") + "\";"
		+ Cnstnts.NEW_LINE + "}" + Cnstnts.NEW_LINE;
		this.Attorney.setName(oldName);
		
		oldName = this.SoStatus.getName();
		this.SoStatus.setName(name);
		scriptCode += "else if(id == 'SoStatus') {" + Cnstnts.NEW_LINE
		+ "htmlCode = \""
		+ printTag(this.SoStatus).replaceAll("\n", "") + "\";"
		+ Cnstnts.NEW_LINE + "}" + Cnstnts.NEW_LINE;
		this.SoStatus.setName(oldName);
		
		oldName = this.PatentOffice.getName();
		this.PatentOffice.setName(name);
		scriptCode += "else if(id == 'PatentOffice') {" + Cnstnts.NEW_LINE
		+ "htmlCode = \""
		+ printTag(this.PatentOffice).replaceAll("\n", "") + "\";"
		+ Cnstnts.NEW_LINE + "}" + Cnstnts.NEW_LINE;
		this.PatentOffice.setName(oldName);
		
		oldName = this.PatentType.getName();
		this.PatentType.setName(name);
		scriptCode += "else if(id == 'PatentType') {" + Cnstnts.NEW_LINE
		+ "htmlCode = \""
		+ printTag(this.PatentType).replaceAll("\n", "") + "\";"
		+ Cnstnts.NEW_LINE + "}" + Cnstnts.NEW_LINE;
		this.PatentType.setName(oldName);


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

		if (name.equalsIgnoreCase("fullSearchText1")) {
			scriptCode = scriptCode.replaceAll("dataDept", "fullSearchText1")
					.replaceAll("creater", "fullSearchText3");
		}
		if (name.equalsIgnoreCase("fullSearchText2")) {
			scriptCode = scriptCode.replaceAll("dataDept", "fullSearchText2")
					.replaceAll("creater", "fullSearchText4");
		}

		return scriptCode;
	}
	
	public boolean getCanEditField(Field field) {
		if(this.onSearchMode()) {
			return true;
		}
		//5.只有已立案 可請款狀態可編輯，、已請款、作廢的就不可編輯
		if(Util.compareTo(this.getSoStatus(), "OS02") ||
				Util.compareTo(this.getSoStatus(), "OS03")) {
			return false;
		}
//		if(Util.compareTo(this.getPatentIn(), "true") &&
//				Util.compareTo(this.getSoStatus(), "OS00") &&
//				(field.getName().equals(this.Remark.getName()) ||
//						field.getName().equals(this.OriginalTitle.getName()))) {
//			return true;
//		}
		if (this.canEdit() || this.onSearchMode()) {
			if(field.getName().equals(this.ParentId.getName()) ||
					field.getName().equals(this.SoNo.getName()) ||
					field.getName().equals(this.CaseKind.getName()) ||
					field.getName().equals(this.PatentOffice.getName()) ||
					field.getName().equals(this.PatentType.getName()) ||
					field.getName().equals(this.InternalNo.getName()) ||
					field.getName().equals(this.OriginalTitle.getName()) /*||
					field.getName().equals(this.CaseNo.getName()) ||
					field.getName().equals(this.Client.getName()) ||
					field.getName().equals(this.ClientName.getName()) ||
					field.getName().equals(this.ServiceProjectCode.getName()) ||
					field.getName().equals(this.InCharge.getName()) ||
					field.getName().equals(this.Remark.getName()) ||
					field.getName().equals(this.QuotationDate.getName()) ||
					field.getName().equals(this.CreateDate.getName()) ||
					field.getName().equals(this.SoStatus.getName()) ||
					field.getName().equals(this.BillingContact.getName()) ||
					field.getName().equals(this.InvoiceTitle1.getName()) ||
					field.getName().equals(this.RegisteredNo.getName()) ||
					field.getName().equals(this.Attorney.getName()) ||
					field.getName().equals(this.AttorneyCase.getName()) ||
					field.getName().equals(this.AttorneyTitle.getName())*/	
					) {
				return false;
			}
			
			return true;
		} else {
			return false;
		}
	}

	public String printAjaxQuotationSalesOrderTable(UserBean userInfo, String flowkey, boolean canAssesFlag) throws Exception {
		this.setUserInfo(userInfo);
		this.setParentId(flowkey);
		
		return printQuotationSalesOrderTable(canAssesFlag, 1);
	}
	
	public String printAjaxCaseSalesOrderTable(UserBean userInfo, String flowkey, boolean canAssesFlag) throws Exception {
		this.setUserInfo(userInfo);
		this.setRelatedCaseNo(flowkey);
		
		return printCaseSalesOrderTable(canAssesFlag, 2);
	}
	
	public String printAjaxSPSalesOrderTable(UserBean userInfo, String flowkey, boolean canAssesFlag) throws Exception {
		this.setUserInfo(userInfo);
		this.setRelatedCaseNo(flowkey);
		
		return printCaseSalesOrderTable(canAssesFlag, 3);
	}
	
	public String printQuotationSalesOrderTable(boolean canAssesFlag, int type) throws Exception {
		Properties empPrpt = new Employee().getNamesPrpts();
		
		StringBuffer strBfr = new StringBuffer();
		
		
		char newLine = Cnstnts.NEW_LINE;
		
		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText11=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Quotation.FlowKey")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.SoNo")+"</td>";
		String thText4="<td align='center' width='17%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.ClientName")+"</td>";
		String thText5="<td align='center' width='17%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.OriginalTitle")+"</td>";
		String thText6="<td align='center' width='17%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.InCharge")+"</td>";
		String thText7="<td align='center' width='17%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.CreateDate")+"</td>";
		String thText12=Cnstnts.EMPTY_STRING;
		

		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText11+thText2+thText3+
									thText4+thText5+thText6+thText7+thText12+"</tr>");
		
		String SQL = "select flowkey from salesorder where parentid='" + this.getParentId() + "' order by flowkey ";
		if(type ==2) {
			SQL = "select flowkey from salesorder where RelatedCaseNo='" + this.getRelatedCaseNo() + "' order by flowkey ";
		}
		List<String> keys = this.getDbUtil().getValueList(SQL, "flowkey");
		
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(String key : keys){
			SalesOrder so = new SalesOrder(key);

			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText11 = "";

			String tdText2="<td align='center'>"+so.getParentId()+"</td>";
			String tdText3="<td align='center'>"+so.getSoNo()+"</td>";
			String tdText4="<td align='center'>"+so.getClientName()+"</td>";
			String tdText5="<td align='center'>"+so.getOriginalTitle()+"</td>";
			String tdText6="<td align='center'>"+empPrpt.getProperty(so.getInCharge())+"</td>";
			String tdText7="<td align='center'>"+so.getCreateDate()+"</td>";

			String tdText12=Cnstnts.EMPTY_STRING;
			String onclick = "";
			if(canAssesFlag){ 
//				tdText12 = "<td align='center'>" +
//						"<input type='button' value='" + this.getUserInfo().getMsg("jsp.Quotation.RemoveReleatedBtn") + "'" +
//								"onclick='deleteReleatedCase(\"" + this.getFlowKey() + "\",\"" + key + "\")'>" +
//						"</td>";
				onclick = " style='cursor: hand' onclick='openAppendix(\"SalesOrder.jsp?_pageActionMode=maintain" +
						"&flowKey=" + key + 
						"&_dbActionMode=update&_getDataFlag=true\",\"SalesOrder\",800,600)'";
			}

			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText12;

			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+" " + onclick + ">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
	
	public String printCaseSalesOrderTable(boolean canAssesFlag, int type) throws Exception {
		Properties empPrpt = new Employee().getNamesPrpts();
		Properties catePrpt = new Category().getNamesPrpts();
		
		StringBuffer strBfr = new StringBuffer();
		
		char newLine = Cnstnts.NEW_LINE;
		
		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText11=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='14%'>"+this.getUserInfo().getMsg("jsp.Quotation.FlowKey")+"</td>";
		String thText3="<td align='center' width='14%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.SoNo")+"</td>";
		String thText4="<td align='center' width='14%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.ClientName")+"</td>";
		String thText5="<td align='center' width='14%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.OriginalTitle")+"</td>";
		String thText6="<td align='center' width='14%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.InCharge")+"</td>";
		String thText7="<td align='center' width='14%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.CreateDate")+"</td>";
		String thText8="<td align='center' width='14%'>"+this.getUserInfo().getMsg("jsp.SalesOrder.SoStatus")+"</td>";
		String thText12=Cnstnts.EMPTY_STRING;


		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText11+thText2+thText3+
									thText4+thText5+thText6+thText7+thText8+thText12+"</tr>");
		
		String SQL = "select flowkey from salesorder where parentid='" + this.getParentId() + "' order by flowkey ";
		if(type ==2) {
			SQL = "select flowkey from salesorder where RelatedCaseNo='" + this.getRelatedCaseNo() + "' order by flowkey ";
		}
		if(type ==3) {
			SQL = "select flowkey from salesorder where serviceProjectCode='" + this.getRelatedCaseNo() + "' order by flowkey ";
		}
		List<String> keys = this.getDbUtil().getValueList(SQL, "flowkey");
		
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(String key : keys){
			//內部訂單在搜尋列表，mouse on之後出現泡泡呈現內容抓該筆明細的欄位：工作項目”&”工作說明  （每一組用分隔隔開或者enter折行也可）
			String sql2 = "SELECT GROUP_CONCAT( CONCAT( TodosTitle,  '&', taskdescription ) SEPARATOR  ';' ) as value FROM salesorder_detail WHERE ParentId = '" + key + "'";
			String value = "";//this.getDbUtil().getFieldValue(sql2, "value");
			
			sql2 = "SELECT CONCAT( TodosTitle,  '&', taskdescription )  as value FROM salesorder_detail WHERE ParentId = '" + key + "'";
			if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
				sql2 = "SELECT ( TodosTitle+  '&'+ taskdescription )  as value FROM salesorder_detail WHERE ParentId = '" + key + "'";
			}
			List<String> values = this.getDbUtil().getValueList(sql2, "value");
			for(String value2 : values) {
				value += value2 + ";";
			}
			SalesOrder so = new SalesOrder(key);

			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText11 = "";

			String tdText2="<td align='center'>"+so.getParentId()+"</td>";
			String tdText3="<td align='center'>"+so.getSoNo()+"</td>";
			String tdText4="<td align='center'>"+so.getClientName()+"</td>";
			String tdText5="<td align='center'>"+so.getOriginalTitle()+"</td>";
			String tdText6="<td align='center'>"+empPrpt.getProperty(so.getInCharge())+"</td>";
			String tdText7="<td align='center'>"+so.getCreateDate()+"</td>";
			String tdText8="<td align='center'>"+catePrpt.getProperty(so.getSoStatus())+"</td>";

			String tdText12=Cnstnts.EMPTY_STRING;

			String onclick = "";
			if(canAssesFlag){
				onclick = " style='cursor: hand' onclick='openAppendix(\"SalesOrder.jsp?_pageActionMode=maintain" +
						"&patentIn=true&flowKey=" + key + 
						"&relatedCaseNo=" + this.getRelatedCaseNo() + "&_dbActionMode=update&_getDataFlag=true\",\"SalesOrder\",1200,600)'";
			}

			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8+tdText12;

			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr title='" + value + "' "+bgColor+" " + onclick + ">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
	
	public void doInvalidProcess(String[] keys) throws Exception{
		boolean checkStatusOk = true;
		String sql = "";
		//改為一次申請全部明細
		sql = "select flowkey from SalesOrder_detail where parentid ='" + this.getFlowKey() + "'";
		List<String> keyList = this.getDbUtil().getValueList(sql, "flowkey");
		if(keyList == null || keyList.isEmpty()) {
			keys = new String[0];
		}
		else {
			keys = new String[keyList.size()];
			for(int i=0;i<keys.length;i++) {
				keys[i] = keyList.get(i);
			}
		}
				
		if(keys != null && keys.length > 0){
			for(String key : keys){
				//System.out.println(key);
				SalesOrder_detail sod = new SalesOrder_detail(key);
//				if(sod != null && Util.compareTo(sod.getSoStatus(), "OS02")){
//					checkStatusOk = false;
//					break;
//				}
				
				if(!Util.isEmpty(sod.getFlowKey())){
					sql = "select flowkey from invoicedetail where SoDetailFk = '"+sod.getFlowKey()+"'";
					String invoiceFlowKey = this.getDbUtil().getFieldValue(sql, "flowkey");
					if(!Util.isEmpty(invoiceFlowKey)){
						InvoiceDetail invoiceDetail = new InvoiceDetail(invoiceFlowKey);
						if(invoiceDetail != null){
							Invoice invoice = new Invoice(invoiceDetail.getParentId());
							if(invoice != null && (Util.isEmpty(invoice.getFlowKey()) ||  
									!Util.compareTo(invoice.getInvoiceStatus(), "InvoiceStatus05"))){
								checkStatusOk = false;
								break;
							}
						}
					}
				}
			}
			if(!checkStatusOk){
				this.setErrorMessage(this.getUserInfo().getMsg("jsp.SalesOrder.ToInvalidNotice"));
			}else{
				int i = 0;
				boolean doInvalid = false;
				StringBuilder sb = new StringBuilder("");
				for(String key : keys){
					i++;
					if(i==1){
						sb.append("'"+key+"'");
					}else{
						sb.append(",'"+key+"'");
					}
				}
				sql = "UPDATE SalesOrder_detail set SoStatus = 'OS03' where FlowKey in ("+sb.toString()+")";
				doInvalid = this.getDbUtil().executeUpdate(sql);
				
				//this.getDbUtil().executeUpdate("update salesorder set SoStatus ='OS03' where FlowKey ='" + this.getFlowKey() + "';");
				this.setSoStatus("OS03");
				this.setDbActionMode(Cnstnts.UPDATE);
				try {
					this.update();
				}
				catch(Exception e) {
					
				}
				if(doInvalid){
					if(Util.compareTo(this.getPatentIn(), "true")) {
						this.setJavascriptCode("window.opener.setValue();");
					}
					this.setMessage(this.getUserInfo().getMsg("jsp.SalesOrder.DoToInvalid"));
				}
			}
		}
	}
	
	public void doInvoiceProcess(String[] keys) throws Exception{
		//System.out.println("doInvoiceProcess");
		boolean checkCanDoProcess = true;
		int errorNum = 0;
		String govCurrency = "";
		String attorneyCurrency = "";
		String serviceCurrency = "";
		int govCount = 1;
		int attorneyCount = 1;
		int serviceCount = 1;
		
		//改為一次申請全部明細
		String sql = "select flowkey from SalesOrder_detail where parentid ='" + this.getFlowKey() + "'";
		List<String> keyList = this.getDbUtil().getValueList(sql, "flowkey");
		if(keyList == null || keyList.isEmpty()) {
			keys = new String[0];
		}
		else {
			keys = new String[keyList.size()];
			for(int i=0;i<keys.length;i++) {
				keys[i] = keyList.get(i);
			}
		}
		if(keys != null && keys.length > 0){
			/*
那個內部訂單點請款按鈕 那個地方的檢核你幫忙看一下
[下午 02:47:29] Janny Kuo: 就是要先把那裡的檢核拿掉，就是點了之後還是直接就寫入到資料庫 然後畫面到請款單 編輯狀態，
等客戶在去點儲存時才去檢核科目幣別的條件 （這個條件應該現在就有在）
			 */
//			for(String key : keys){
//				SalesOrder_detail so_d = new SalesOrder_detail(key);
//				if(!Util.compareTo(so_d.getSoStatus(), "OS01")){
//					checkCanDoProcess =false;
//					errorNum = 1;
//					break;
//				}
//				if(Util.compareTo(so_d.getAccountTitle(), "AccountTitle01")){
//					if(govCount == 1){
//						govCurrency = so_d.getCurrency();
//					}else{
//						if(!Util.compareTo(govCurrency, so_d.getCurrency())){
//							checkCanDoProcess =false;
//							errorNum = 2;
//							break;
//						}
//					}
//					govCount ++;
//				}else if(Util.compareTo(so_d.getAccountTitle(), "AccountTitle02")){
//					if(attorneyCount == 1){
//						attorneyCurrency = so_d.getCurrency();
//					}else{
//						if(!Util.compareTo(attorneyCurrency, so_d.getCurrency())){
//							checkCanDoProcess =false;
//							errorNum = 2;
//							break;
//						}
//					}
//					attorneyCount ++;
//				}else if(Util.compareTo(so_d.getAccountTitle(), "AccountTitle03")){
//					if(serviceCount == 1){
//						serviceCurrency = so_d.getCurrency();
//					}else{
//						if(!Util.compareTo(serviceCurrency, so_d.getCurrency())){
//							checkCanDoProcess =false;
//							errorNum = 2;
//							break;
//						}
//					}
//					serviceCount ++;
//				}
//			}
		}
		else {
			checkCanDoProcess = false;
			errorNum = 3;
		}
		
		if(!checkCanDoProcess){
			if(errorNum == 1){
				this.setMessage(this.getUserInfo().getMsg("jsp.SalesOrder.DoToInvoiceNotice2"));
			}
			else if(errorNum == 2){
				this.setMessage(this.getUserInfo().getMsg("jsp.SalesOrder.DoToInvoiceNotice"));
			}
			else if(errorNum == 3){
				this.setMessage(this.getUserInfo().getMsg("jsp.SalesOrder.DoToInvoiceNotice3"));
			}
		}else{
			String matter = "";
			String firstServiceProjetCode = "";
			List<String> sqls = new ArrayList<String>();
			
			String firstKey = keys[0];
			SalesOrder_detail sodFirst = new SalesOrder_detail(firstKey);
			if(!Util.isEmpty(sodFirst.getMatterName())){
				matter = sodFirst.getMatterName();
			}
			
			Invoice invoice = new Invoice();
			invoice.setDbFields();
			invoice.setFlowKey(FlowEngin.getFlowKey(invoice.getProgramId()));
			invoice.setApplicant(this.getUserInfo().getAttribute("emp_id"));
			invoice.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
			invoice.setMatter(matter);
			invoice.setAttorneyTitle(this.getAttorneyTitle());
			invoice.setNote(this.getRemark());
			invoice.setSoKey(this.getFlowKey());
			
			boolean hasCaseNo = false;
			if(Util.compareTo(this.getCaseKind(), "STC01")){
				PatentCase patent = new PatentCase(this.getRelatedCaseNo());
				invoice.setCaseNo(patent.getCaseNo());
				invoice.setCaseNo2(patent.getCaseNo2());
				invoice.setTitle(patent.getTitle() + "/" + patent.getEnglishTitle());
				invoice.setOffice(patent.getPatentOffice());
				invoice.setSubType(patent.getPatentType());
				invoice.setApplyNo(patent.getApplyNo());
//				invoice.setClient(patent.getClient());
				invoice.setCaseType(patent.getPatentCaseType());
				invoice.setInternalNo(patent.getInternalNo());
				invoice.setApplyDate(patent.getApplyDate());
				invoice.setIssueDate(patent.getIssueDate());
				invoice.setIssueNo(patent.getIssueNo());
				invoice.setClientContect(patent.getClientContect());
				invoice.setTaskCreator(patent.getInCharge());
				invoice.setIndependentClaim(patent.getIndependentClaim());
				invoice.setDependentClaim(patent.getDependentClaim());
				invoice.setBillingContact(new Client(patent.getClient()).getBillingContact());
				invoice.setRegisterNo(patent.getLicenseNo());
				invoice.setMatter(patent.getMatter());

				/*
				 * 請款單-維護模式裡案件資料分頁中的申請人欄位（<jsp.Invoice.CaseClient value="申請人"/>） 
				 * 要改去抓取對應案件中的申請人分頁的 申請人名稱（<jsp.PatentApplicant.ApplicantName value="申請人名稱"/>），若遇該案件有多筆申請人的情況，就以分號( AAA;BBB )相隔呈現 
				 */
//				String sql2 = "select GROUP_CONCAT( concat(ApplicantName,' ',EnglishNames) SEPARATOR  ';' ) as value from PatentApplicant where parentid = '" +this.getRelatedCaseNo()+ "' ";
//				invoice.setCaseClient(this.getDbUtil().getFieldValue(sql2, "value"));
				
				
				firstServiceProjetCode = patent.getServiceProjectCode();
				
				invoice.setServiceProjectCode(firstServiceProjetCode);
				if(!Util.isEmpty(firstServiceProjetCode)) {
					ServiceProject project = new ServiceProject(firstServiceProjetCode);
					//請款單的免費服務時數=服務專案的每月扣抵上限
					invoice.setFreeServiceNumberOfMonth(project.getMonthDeductibleHourMaximum());
					invoice.setTwdHourlyCharge(project.getTwdHourlyCharge());
				}
				/*
				 * TaskDescription = 程序名稱
				 */
				//請款項目說明要帶入第一筆明細的工作項目
				
//				Properties cateProp = new Category().getNamesPrpts();
//				cateProp.putAll(new PatentMatterConfig().getNamesPrpts());
//				invoice.setTaskDescription(cateProp.getProperty(invoice.getMatter()));
				
			}else if(Util.compareTo(this.getCaseKind(), "STC02")){
				TrademarkCase patent = new TrademarkCase(this.getRelatedCaseNo());
				invoice.setCaseNo(patent.getCaseNo());
				invoice.setCaseNo2(patent.getCaseNo2());
				//4. 從內部訂單轉請款單時時加判斷 若為商標案則案件名稱呈現為”商標名稱/商標分類” (例：商標ABC/第20類)
				invoice.setTitle(patent.getTitle());
				invoice.setOffice(patent.getOffice());
				invoice.setSubType(patent.getTrademarkType());
				invoice.setApplyNo(patent.getFillingNum());
//				invoice.setClient(patent.getClient());
				invoice.setCaseType(patent.getTrademarkCaseType());
				invoice.setInternalNo(patent.getInternalNo());
				invoice.setApplyDate(patent.getFillingDate());
				invoice.setIssueDate(patent.getIssueDate());
				invoice.setIssueNo(patent.getIssueNo());
				invoice.setClientContect(patent.getClientContect());
				invoice.setTaskCreator(patent.getSales());
				invoice.setBillingContact(new Client(patent.getClient()).getBillingContact());
				invoice.setRegisterNo(patent.getRegistNum());
				invoice.setMatter(patent.getMatter());
				/*
				 * 請款單-維護模式裡案件資料分頁中的申請人欄位（<jsp.Invoice.CaseClient value="申請人"/>） 
				 * 要改去抓取對應案件中的申請人分頁的 申請人名稱（<jsp.PatentApplicant.ApplicantName value="申請人名稱"/>），若遇該案件有多筆申請人的情況，就以分號( AAA;BBB )相隔呈現 
				 */
//				String sql2 = "select GROUP_CONCAT( concat(ApplicantName,' ',IFNULL( EnglishNames,  '' ) ) SEPARATOR  ';' ) as value from trademarkApplicant where parentid = '" +this.getRelatedCaseNo()+ "' ";
//				invoice.setCaseClient(this.getDbUtil().getFieldValue(sql2, "value"));
				
				firstServiceProjetCode = patent.getServiceProjectCode();
				
				invoice.setServiceProjectCode(firstServiceProjetCode);
				if(!Util.isEmpty(firstServiceProjetCode)) {
					ServiceProject project = new ServiceProject(firstServiceProjetCode);
					//請款單的免費服務時數=服務專案的每月扣抵上限
					invoice.setFreeServiceNumberOfMonth(project.getMonthDeductibleHourMaximum());
					invoice.setTwdHourlyCharge(project.getTwdHourlyCharge());
				}
				
				/*
				 * TaskDescription = 程序名稱
				 */
//				Properties cateProp = new Category().getNamesPrpts();
//				cateProp.putAll(new PatentMatterConfig().getNamesPrpts());
//				invoice.setTaskDescription(cateProp.getProperty(invoice.getMatter()));
				
				invoice.setTrademarkClassification(patent.getTrademarkClassification());
				
			}else if(Util.compareTo(this.getCaseKind(), "STC03")){
				LegalCase patent = new LegalCase(this.getRelatedCaseNo());
				invoice.setCaseNo(patent.getCaseNo());
				invoice.setCaseNo2(patent.getCaseNo2());
				invoice.setTitle(patent.getTitle() + "/" + patent.getEnglishTitle());
				invoice.setOffice("");
				invoice.setSubType(patent.getMainType());
				invoice.setApplyNo(patent.getTmpField_04());
				invoice.setApplyDate(patent.getRealStartDate());
//				invoice.setClient(patent.getClient());
				invoice.setCaseType(patent.getMainType());
				invoice.setClientContect(patent.getClientContect());
				invoice.setTaskCreator(patent.getInCharge());
				invoice.setBillingContact(new Client(patent.getClient()).getBillingContact());
				/*
				 * 請款單-維護模式裡案件資料分頁中的申請人欄位（<jsp.Invoice.CaseClient value="申請人"/>） 
				 * 要改去抓取對應案件中的申請人分頁的 申請人名稱（<jsp.PatentApplicant.ApplicantName value="申請人名稱"/>），若遇該案件有多筆申請人的情況，就以分號( AAA;BBB )相隔呈現 
				 */
//				String sql2 = "select GROUP_CONCAT( concat(ApplicantName,' ',IFNULL( EnglishNames,  '' ) ) SEPARATOR  ';' ) as value from legalapplicant where parentid = '" +this.getRelatedCaseNo()+ "' ";
//				invoice.setCaseClient(this.getDbUtil().getFieldValue(sql2, "value"));
				
				invoice.setInternalNo(patent.getTmpField_09());
				
				firstServiceProjetCode = patent.getServiceProjectCode();
				
				invoice.setServiceProjectCode(firstServiceProjetCode);
				if(!Util.isEmpty(firstServiceProjetCode)) {
					ServiceProject project = new ServiceProject(firstServiceProjetCode);
					//請款單的免費服務時數=服務專案的每月扣抵上限
					invoice.setFreeServiceNumberOfMonth(project.getMonthDeductibleHourMaximum());
					invoice.setTwdHourlyCharge(project.getTwdHourlyCharge());
				}
				/*
				 * TaskDescription = 程序名稱
				 */
//				Properties cateProp = new Category().getNamesPrpts();
//				cateProp.putAll(new PatentMatterConfig().getNamesPrpts());
//				invoice.setTaskDescription(cateProp.getProperty(invoice.getMatter()));
				
			}else if(Util.compareTo(this.getCaseKind(), "STC04")){
				CopyrightCase patent = new CopyrightCase(this.getRelatedCaseNo());
				invoice.setCaseNo(patent.getCaseNo());
				invoice.setCaseNo2(patent.getCaseNo2());
				invoice.setTitle(patent.getTitle() + "/" + patent.getEnglishTitle());
				invoice.setOffice(patent.getOffice());
				invoice.setSubType(patent.getMainType());
				invoice.setApplyNo(patent.getTmpField_01());
				invoice.setApplyDate(patent.getTargetFinishDate());
//				invoice.setClient(patent.getClient());
				invoice.setCaseType(patent.getMainType());
				invoice.setClientContect(patent.getClientContect());
				invoice.setTaskCreator(patent.getInCharge());
				invoice.setBillingContact(new Client(patent.getClient()).getBillingContact());
				invoice.setRegisterNo(patent.getTmpField_02());
				invoice.setMatter(patent.getMatter());

				/*
				 * 請款單-維護模式裡案件資料分頁中的申請人欄位（<jsp.Invoice.CaseClient value="申請人"/>） 
				 * 要改去抓取對應案件中的申請人分頁的 申請人名稱（<jsp.PatentApplicant.ApplicantName value="申請人名稱"/>），若遇該案件有多筆申請人的情況，就以分號( AAA;BBB )相隔呈現 
				 */
//				String sql2 = "select GROUP_CONCAT( concat(ApplicantName,' ',IFNULL( EnglishNames,  '' ) ) SEPARATOR  ';' ) as value from copyrightapplicant where parentid = '" +this.getRelatedCaseNo()+ "' ";
//				invoice.setCaseClient(this.getDbUtil().getFieldValue(sql2, "value"));
				
				invoice.setInternalNo(patent.getTmpField_06());
				
				firstServiceProjetCode = patent.getServiceProjectCode();
				
				invoice.setServiceProjectCode(firstServiceProjetCode);
				if(!Util.isEmpty(firstServiceProjetCode)) {
					ServiceProject project = new ServiceProject(firstServiceProjetCode);
					//請款單的免費服務時數=服務專案的每月扣抵上限
					invoice.setFreeServiceNumberOfMonth(project.getMonthDeductibleHourMaximum());
					invoice.setTwdHourlyCharge(project.getTwdHourlyCharge());
				}
				
				/*
				 * TaskDescription = 程序名稱
				 */
//				Properties cateProp = new Category().getNamesPrpts();
//				cateProp.putAll(new PatentMatterConfig().getNamesPrpts());
//				invoice.setTaskDescription(cateProp.getProperty(invoice.getMatter()));
			}
			
			//必須要有案號才可以產生請款單
			if(Util.isEmpty(invoice.getCaseNo())) {
				this.setMessage(this.getUserInfo().getMsg("jsp.SalesOrder.CaseNoEmptyError"));
				return;
			}
			
			double govFeeAmount = 0;
			double attorneyFee = 0;
			double serviceFeeAmount = 0;
			
			double govFee = 0;
			double attorneyFeeNtd = 0;
			double serviceFee = 0;
			
			double totalTax = 0;
			double totalUntaxedAmount = 0;
			double totalTax2 = 0;
			double serviceFeeDeductTTax2 = 0;
			
			double totalRequestPayNtdAmount = 0;
			
			String firstTask = "";
			StringBuilder sb = new StringBuilder("");
			if(keys != null && keys.length > 0){
				int i = 0;
				for(String key : keys){
					i++;
					if(i==1){
						sb.append("'"+key+"'");
					}else{
						sb.append(",'"+key+"'");
					}
					
					double twdAmount = 0;
					double taxAmount = 0;
					double includeTaxAmount = 0;
					double notIncludeTaxAmount = 0;
					
					SalesOrder_detail sod = new SalesOrder_detail(key);
					InvoiceDetail invoiceDetail = new InvoiceDetail();
					invoiceDetail.setDbFields();
					invoiceDetail.setParentId(invoice.getFlowKey());
					invoiceDetail.setFlowKey(Util.getNo(invoiceDetail.getParentId(),3));
					invoiceDetail.setApplicant(this.getUserInfo().getAttribute("emp_id"));
					invoiceDetail.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
					
					invoiceDetail.setTodosId("");
					invoiceDetail.setSoDetailFk(sod.getFlowKey());
					invoiceDetail.setTaskDescription(sod.getTaskDescription());
					invoiceDetail.setTodosTitle(sod.getTodosTitle());
					if(i==1) {
						firstTask = sod.getTodosTitle();
					}
					
					invoiceDetail.setAccountTitle(sod.getAccountTitle());
					invoiceDetail.setCurrency(sod.getCurrency());
					invoiceDetail.setAmount(sod.getAmount());
					invoiceDetail.setTaxType(sod.getTaxType());
					invoiceDetail.setTaxInclude(sod.getTaxInclude());
					invoiceDetail.setTaxAmount(sod.getTaxAmount());
					invoiceDetail.setNotIncludeTaxAmount(sod.getNotIncludeTaxAmount());
					invoiceDetail.setIncludeTaxAmount(sod.getIncludeTaxAmount());
					invoiceDetail.setExchangeRate(sod.getExchangeRate());
					invoiceDetail.setTwdAmount(Util.round(Util.stringToDouble(sod.getTwdAmount()), 0)+"");
					//System.out.println("sod.getTwdAmount()="+sod.getTwdAmount());
					//System.out.println("invoiceDetail.getTwdAmount()="+invoiceDetail.getTwdAmount());
					invoiceDetail.setDiscountAmount("0");
					invoiceDetail.setAlreadyWriteOffAmount("0");
					invoiceDetail.setNotYetWriteOff(sod.getTwdAmount());
					invoiceDetail.setMemo(sod.getRemark());
					
					invoiceDetail.setRequestPayAmount("0");
					invoiceDetail.setNotYetRequestPayAmount("0");
					invoiceDetail.setUnit(sod.getUnit());
					invoiceDetail.setUnitPrice(sod.getUnitPrice());
					invoiceDetail.setQuantity(sod.getQuantity());
					invoiceDetail.setInvoiceAmount(sod.getAmount());
					invoiceDetail.setInvoiceCurrency(sod.getCurrency());
					invoiceDetail.setInvoiceExchangeRate("1");
					
					try {
						includeTaxAmount = Double.parseDouble(sod.getIncludeTaxAmount());
					} catch (Exception e) {
						includeTaxAmount = 0;
						e.printStackTrace();
					}
					try {
						notIncludeTaxAmount = Double.parseDouble(sod.getNotIncludeTaxAmount());
					} catch (Exception e) {
						notIncludeTaxAmount = 0;
						e.printStackTrace();
					}
					try {
						twdAmount = Double.parseDouble(sod.getTwdAmount());
					} catch (Exception e) {
						twdAmount = 0;
						e.printStackTrace();
					}
					try {
						taxAmount = Double.parseDouble(sod.getTaxAmount());
					} catch (Exception e) {
						taxAmount = 0;
						e.printStackTrace();
					}
					
					if(Util.compareTo(sod.getAccountTitle(), "AccountTitle01")){
						govFeeAmount = govFeeAmount + includeTaxAmount;
						govFee = govFee + twdAmount;
					}else if(Util.compareTo(sod.getAccountTitle(), "AccountTitle02")){
						attorneyFee = attorneyFee + includeTaxAmount;
						attorneyFeeNtd = attorneyFeeNtd + twdAmount;
					}else if(Util.compareTo(sod.getAccountTitle(), "AccountTitle03")){
						serviceFeeAmount = serviceFeeAmount + includeTaxAmount;
						serviceFee = serviceFee + twdAmount;
					}
					
					if(Util.compareTo(sod.getTaxType(), "TaxT01")){
						totalTax2 = totalTax2 + twdAmount;
						serviceFeeDeductTTax2 = serviceFeeDeductTTax2 + notIncludeTaxAmount;
						//他方扣繳=稅額*匯率
						invoiceDetail.setTax2((int)Util.round(Util.stringToDouble(invoiceDetail.getTaxAmount())*
								Util.stringToDouble(invoiceDetail.getExchangeRate()), 0) + "");
						//他方扣繳預設打勾
						invoiceDetail.setWithholding("Y");
					}else if(Util.compareTo(sod.getTaxType(), "TaxT02") ||
							Util.compareTo(sod.getTaxType(), "TaxT03") ||
							Util.compareTo(sod.getTaxType(), "TaxT04") ||
							Util.compareTo(sod.getTaxType(), "TaxT05")){
						totalTax = totalTax + taxAmount;
						totalUntaxedAmount = totalUntaxedAmount + notIncludeTaxAmount;
						
						//營業稅=稅額*匯率
						invoiceDetail.setTax((int)Util.round(Util.stringToDouble(invoiceDetail.getTaxAmount())*
								Util.stringToDouble(invoiceDetail.getExchangeRate()), 0) + "");
					}
					
					totalRequestPayNtdAmount = totalRequestPayNtdAmount + twdAmount;
					
					String insert = this.getDbUtil().getInsertSQL(invoiceDetail.getTableName(), invoiceDetail.getDbFields());
					//System.out.println(insert);
					sqls.add(insert);
				}
				
			}
			invoice.setGovFeeAmount(govFeeAmount+"");
			invoice.setAttorneyFee(attorneyFee+"");
			invoice.setServiceFeeAmount(serviceFeeAmount+"");
			invoice.setGovFee((int)Util.round(govFee,0)+"");
			invoice.setAttorneyFeeNtd((int)Util.round(attorneyFeeNtd,0)+"");
			invoice.setServiceFee((int)Util.round(serviceFee,0)+"");
			invoice.setTotalTax2((int)Util.round(totalTax2,0)+"");
			invoice.setTotalTax((int)Util.round(totalTax,0)+"");
			invoice.setTotalUntaxedAmount((int)Util.round(totalUntaxedAmount,0)+"");
			invoice.setTotalRequestPayNtdAmount((int)Util.round(totalRequestPayNtdAmount,0)+"");
			invoice.setTotalDiscountAmount("0");
			invoice.setTotalWriteOffAmount("0");
			invoice.setClient(this.getClient());
			invoice.setClientName(this.getClientName());
			invoice.setInvoiceTitle(this.getClientName());
			//請款項目說明要帶入第一筆明細的工作項目
			invoice.setTaskDescription(firstTask);;
			//請款項目說明要帶入第一筆明細的工作項目
			
			//將"代理人"欄位帶到請款單的 客戶名稱（代理人代碼帶入客戶代碼）;
			if(Util.compareTo(this.getAttorneyCase(), "Y")) {
				invoice.setClient(this.getAttorney());
				if(!Util.isEmpty(this.getAttorney())) {
					invoice.setClientName(new Attorney(this.getAttorney()).getFirm());
				}
				invoice.setInvoiceTitle(invoice.getClientName());
			}

			invoice.setBillingContact(this.getBillingContact());
			invoice.setClientContect(this.getClientContect());
			invoice.setRegisteredNo(this.getRegisteredNo());
			invoice.setInvoiceTitle(new InvTitle(this.getInvoiceTitle1()).getInvoiceTitle());
			
			
			invoice.setTotalAmountDeductTTax2((int)Util.round((totalRequestPayNtdAmount - totalTax2),0)+"");
			
			//String sql2 = this.getDbUtil().getInsertSQL(invoice.getTableName(), invoice.getDbFields());
			//sqls.add(sql2);
			invoice.setDbActionMode(Cnstnts.INSERT);
			invoice.setUserInfo(this.getUserInfo());
			invoice.insert();
			
			sql = "UPDATE SalesOrder_detail set SoStatus = 'OS02' where FlowKey in ("+sb.toString()+")";
			sqls.add(sql);
			sqls.add("update salesorder set SoStatus ='OS02' where FlowKey ='" + this.getFlowKey() + "';");
			
			if(this.getDbUtil().executeUpdate(sqls)) {
				this.setMessage(this.getUserInfo().getMsg("jsp.SalesOrder.DoToInvoice"));
				this.setForwardPage("Invoice.jsp?_flowKey=" + invoice.getFlowKey() + 
        				"&_getDataFlag=true&_pageActionMode=maintain&_dbActionMode=update");
			}
			
		}
	}
	
	
	
	public String printInvoiceTableHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		boolean canAssesFlag = this.getDbActionMode().equals(Cnstnts.UPDATE)?true:false;

		char newLine = Cnstnts.NEW_LINE;

		
		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Invoice.InvoiceNo")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Invoice.VoucherDate")+"</td>";
		String thText4="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Invoice.TotalRequestPayNtdAmount")+"</td>";
		String thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Invoice.TotalWriteOffAmount")+"</td>";
		String thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Invoice.TotalDiscountAmount")+"</td>";
		String thText7="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Invoice.InvoiceStatus")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
//		if(canAssesFlag){
//			String insertImg = Cnstnts.EMPTY_STRING;  
//			thText1 = "<td align='center' width='1%'>"+insertImg+"</td>";
//			thText8 = "<td align='center' width='1%'></td>";
//		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText7+thText8+"</tr>");
		
//		String SQL = "select i.* from Invoice i "+
//					 "where i.flowkey in (select ii.parentid from invoicedetail ii where ii.SoDetailFk in (select s.flowkey from salesorder_detail s where s.parentid = '"+this.getFlowKey()+"') )";
		String SQL = "select i.* from invoice i where i.sokey = '" + this.getFlowKey() + "'";
		Invoice applicant = new Invoice();
		applicant.setDbFields();
		List<Field> fieldList = applicant.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String InvoiceNo = Cnstnts.EMPTY_STRING;
			String VoucherDate = Cnstnts.EMPTY_STRING;
			String TotalRequestPayNtdAmount = Cnstnts.EMPTY_STRING;
			String TotalWriteOffAmount = Cnstnts.EMPTY_STRING;
			String TotalDiscountAmount = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String InvoiceStatus = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("InvoiceNo")){
					InvoiceNo = field.getValue();
				}
				if(field.getName().equals("VoucherDate")){
					VoucherDate = field.getValue();
				}
				if(field.getName().equals("TotalRequestPayNtdAmount")){
					TotalRequestPayNtdAmount = field.getValue();
				}
				if(field.getName().equals("TotalWriteOffAmount")){
					TotalWriteOffAmount = field.getValue();
				}
				if(field.getName().equals("TotalDiscountAmount")){
					TotalDiscountAmount = field.getValue();
				}
				if(field.getName().equals("InvoiceStatus")){
					InvoiceStatus = field.getValue();
				}
			}
			String onClick = " onClick='openAppendix(\"Invoice.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=update&_getDataFlag=true&_pageActionMode=maintain&_modeLockFlag=true"+
			  					"\",\"Invoice\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'"+onClick+">"+InvoiceNo+"</td>";
			String tdText3="<td align='center'"+onClick+">"+VoucherDate+"</td>";
			String tdText4="<td align='center'"+onClick+">"+TotalRequestPayNtdAmount+"</td>";
			String tdText5="<td align='center'"+onClick+">"+TotalWriteOffAmount+"</td>";
			String tdText6="<td align='center'"+onClick+">"+TotalDiscountAmount+"</td>";
			String tdText7="<td align='center'"+onClick+">"+categoryPrpt.getProperty(InvoiceStatus)+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
//			if(canAssesFlag){ 
//				String insertImg = Cnstnts.EMPTY_STRING;
//				tdText1 = "<td align='center'>"+insertImg+"</td>";
//				String deleteImg = Cnstnts.EMPTY_STRING;
//				tdText8 = "<td align='center'>"+deleteImg+"</td>";
//			}
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


	public String printSearchReasult() throws Exception {
		resetShowField();
		
		if (this.onBtnSearch() || Util.compareTo(this.getDoExportCsvFlag(), "true")) {
		//if (this.onBtnSearch()) {
			this.setSearchResult(this.getSearchList());
		}

		StringBuffer strBfr = new StringBuffer();
		if (this.getShowField() == null || this.getShowField().length == 0
				|| this.getSearchResult() == null) {
			return strBfr.toString();
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		if (this.getFindRecords() > 0) {
			int totalPages = ((this.getFindRecords() - (this.getFindRecords() % this
					.getPageRecords())) / this.getPageRecords()) + 1;
			if (this.getFindRecords() % this.getPageRecords() == 0)
				totalPages -= 1;
			if (this.getPageNo() == 0 || this.getPageNo() > totalPages)
				this.setPageNo(1);
			strBfr.append(newLine + "  <tr><td align='center' colspan='"
					+ this.getShowField().length + "'>");
			String selected10 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 10) {
				selected10 = " selected";
			}
			String selected20 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 20) {
				selected20 = " selected";
			}
			String selected50 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 50) {
				selected50 = " selected";
			}
			String selected100 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 100) {
				selected100 = " selected";
			}
			String selected200 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 200) {
				selected200 = " selected";
			}
			strBfr.append(newLine
							+ "    "
							+ this.getUserInfo().getMsg("jsp.common.findTotal")
							+ this.getFindRecords()
							+ getUserInfo().getMsg("jsp.common.datas")
							+ "/"
							+ this.getUserInfo().getMsg("jsp.common.prePage")
							+ "<select id='pageRecords' name='pageRecords' "
							+ "onChange='document.input.doSearchFlag.value=\"true\";"
							+ "document.input.pageNo.value=\"1\";setValue()'>"
							+ "<option value='10'" + selected10
							+ ">10</option>" + "<option value='20'"
							+ selected20 + ">20</option>"
							+ "<option value='50'" + selected50
							+ ">50</option>" + "<option value='100'"
							+ selected100 + ">100</option>"
							+ "<option value='200'" + selected200
							+ ">200</option>" + "</select>"
							+ this.getUserInfo().getMsg("jsp.common.datas")
							+ "/"
							+ this.getUserInfo().getMsg("jsp.common.total")
							+ totalPages
							+ this.getUserInfo().getMsg("jsp.common.page"));
			if (this.getPageNo() > 2) {
				strBfr.append(newLine
								+ "    <img src='img/icon_03.gif' style='cursor: hand' border='0' "
								+ "title='"
								+ this.getUserInfo().getMsg(
										"jsp.common.firstPage")
								+ "' "
								+ "onClick='document.input.pageNo.value=\"1\";"
								+ "document.input.doSearchFlag.value=\"true\";setValue()'/>");
			}
			if (this.getPageNo() > 1) {
				strBfr.append(newLine
								+ "    <img src='img/icon_06.gif' style='cursor: hand' border='0' "
								+ "title='"
								+ this.getUserInfo().getMsg(
										"jsp.common.backPage")
								+ "' "
								+ "onClick='document.input.pageNo.value=\""
								+ (this.getPageNo() - 1)
								+ "\";"
								+ "document.input.doSearchFlag.value=\"true\";setValue()'/>");
			}
			strBfr.append(newLine
							+ "    <select id='pageNo' name='pageNo' "
							+ "onChange='document.input.doSearchFlag.value=\"true\";setValue()'>");
			for (int i = 1; i <= totalPages; i++) {
				String selectedStr = Cnstnts.EMPTY_STRING;
				if (i == this.getPageNo())
					selectedStr = Cnstnts.SELECTED;
				strBfr.append(newLine + "      <option value='" + i + "'"
						+ selectedStr + ">");
				strBfr.append(newLine + "        "
						+ this.getUserInfo().getMsg("jsp.function.page1") + i
						+ this.getUserInfo().getMsg("jsp.function.page2"));
				strBfr.append(newLine + "      </option>");
			}
			strBfr.append(newLine + "    </select>");
			if (totalPages > this.getPageNo()) {
				strBfr.append(newLine
								+ "    <img src='img/icon_05.gif' style='cursor: hand' border='0' "
								+ "title='"
								+ this.getUserInfo().getMsg(
										"jsp.common.forward")
								+ "' "
								+ "onClick='document.input.pageNo.value=\""
								+ (this.getPageNo() + 1)
								+ "\";"
								+ "document.input.doSearchFlag.value=\"true\";setValue()'/>");
			}
			if (totalPages > this.getPageNo() + 1) {
				strBfr.append(newLine
								+ "    <img src='img/icon_04.gif' style='cursor: hand' border='0' "
								+ "title='"
								+ this.getUserInfo().getMsg(
										"jsp.common.lastPage")
								+ "' "
								+ "onClick='document.input.pageNo.value=\""
								+ totalPages
								+ "\";"
								+ "document.input.doSearchFlag.value=\"true\";setValue()'/>");
			}
			strBfr.append(newLine + "  </td></tr>");
		}
		strBfr.append(newLine + "  <tr" + this.getThBgcolor()
				+ " style='cursor: hand' " + "title='"
				+ this.getUserInfo().getMsg("jsp.common.reOrder") + "'>");
		for (int i = 0; i < this.getShowField().length; i++) {
			String fieldName = this.getShowField()[i].getName();
			strBfr.append(newLine + "    <td align='center' onClick='setOrderKey(\""
					+ fieldName + "\")'" + ">");
			strBfr.append(newLine
					+ "      "
					+ this.getUserInfo().getMsg(
							this.getProgramId() + "." + fieldName));
			if (this.getOrderKey().equals(fieldName)) {
				String imgSrc = "img/up_pointer.png";
				if (this.getOrderSequence().equals(Cnstnts.DESC))
					imgSrc = "img/down_pointer.png";
				strBfr.append(" <img src='" + imgSrc + "'>");
			}
			strBfr.append(newLine + "    </td>");
		}
		strBfr.append(newLine + "  </tr>");
		if (this.getSearchResult().size() > 0) {
			boolean showSubTotal = false;
			for (int i = 0; i < this.getSearchResult().size(); i++) {
				Object[] data = this.getSearchResult().get(i);
				String trBgcolor = this.getTrBgcolor1();
				if (i % 2 == 0)
					trBgcolor = this.getTrBgcolor2();
				//內部訂單在搜尋列表，mouse on之後出現泡泡呈現內容抓該筆明細的欄位：工作項目”&”工作說明  （每一組用分隔隔開或者enter折行也可）
				String sql2 = "SELECT GROUP_CONCAT( CONCAT( TodosTitle,  '&', taskdescription ) SEPARATOR  ';' ) as value FROM salesorder_detail WHERE ParentId = '" + data[0].toString() + "'";
				String value = "";//this.getDbUtil().getFieldValue(sql2, "value");
				
				sql2 = "SELECT CONCAT( TodosTitle,  '&', taskdescription )  as value FROM salesorder_detail WHERE ParentId = '" + data[0].toString() + "'";
				if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
					sql2 = "SELECT ( TodosTitle+  '&'+ taskdescription )  as value FROM salesorder_detail WHERE ParentId = '" + data[0].toString() + "'";
				}
				List<String> values = this.getDbUtil().getValueList(sql2, "value");
				for(String value2 : values) {
					value += value2 + ";";
				}
				
				strBfr.append(newLine + "  <tr" + trBgcolor
						+ " style='cursor: hand' " + "title='"
						//+ this.getUserInfo().getMsg("jsp.common.viewDetail")
						+ value
						+ "' "
						+ "onClick='document.input.currentRecord.value=\""
						+ (i + 1) + "\";document.input.dbActionMode.value=\"update\";"
						+"gotoData(\"" + data[0].toString()
						+ "\")'>");
				for (int j = 1; j < data.length; j++) {
					String showData = Cnstnts.EMPTY_STRING;

						if (data[j] != null) {
							showData = data[j].toString();
						}
						if (this.getShowField()[j - 1].subTotalFlag()
								&& this.getShowField()[j - 1].getDbType().equals(
										Cnstnts.INT)) {
							this.getShowField()[j - 1].setAlign(Cnstnts.RIGHT);
							int subTotal = this.getShowField()[j - 1].getSubTotal();
							if (showData.trim().length() == 0) {
								showData = "0";
							}
							this.getShowField()[j - 1].setSubtotal(subTotal
									+ Integer.parseInt(showData));
							showSubTotal = true;
							showData = Util
									.outFormat(Integer.parseInt(showData), 3);
						}
						if (this.getShowField()[j - 1].getMapingPrpt() != null) {
							String mapingName = this.getShowField()[j - 1]
							    					.getMapingPrpt().getProperty(showData);
							if(mapingName==null){
								mapingName = Cnstnts.EMPTY_STRING;
							}
							if (this.getShowField()[j - 1].notShowCode()) {
								showData = mapingName;
							} else {
								showData += "-" + mapingName;
							}
						}
						if (this.getShowField()[j - 1].getHtmlType().equals(
										Cnstnts.HTML_TAG_OPEN_UPLOAD)){
							if (!showData.equals("")){
								showData = "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
								  "onClick='openAppendix(\""+showData+"\",\"DocumentUrl\",600,400)'>";
							}
							
						}
						else if(this.getShowField()[j - 1].getIsShowImage() && !Util.isEmpty(showData)) {
								strBfr.append(newLine + "    <td "
										+ this.getShowField()[j - 1].printListWidth()
										+ this.getShowField()[j - 1].printAlign() + ">"
										+ "<img width='80' height='60' src='" + showData + "'></td>");
						}
						else {
							strBfr.append(newLine + "    <td "
									+ this.getShowField()[j - 1].printListWidth()
									+ this.getShowField()[j - 1].printAlign() + ">"
									+ showData + "</td>");
						}
				}
				strBfr.append(newLine + "  </tr>");
			}
			if (showSubTotal) {
				strBfr.append(newLine + "  <tr>");
				for (int i = 0; i < this.getShowField().length; i++) {
					if (this.getShowField()[i].subTotalFlag()
							&& this.getShowField()[i].getDbType().equals(
									Cnstnts.INT)) {
						strBfr.append(newLine
								+ "    <td align='right'>"
								+ Util.outFormat(this.getShowField()[i]
										.getSubTotal(), 3) + "</td>");
					} else {
						strBfr.append(newLine + "    <td></td>");
					}
				}
				strBfr.append(newLine + "  </tr>");
			}
		} else {
			strBfr.append(newLine + "  <tr" + this.getTrBgcolor1() + ">");
			strBfr.append(newLine + "    <td align='center' colspan='"
					+ this.getShowField().length + "'>"
					+ this.getUserInfo().getMsg("jsp.common.noRecords")
					+ "</td>");
			strBfr.append(newLine + "  </tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
	
	public boolean update() throws Exception {
		System.out.println("into update " + this.getRelatedCaseNo());
		boolean result = super.update();
		System.out.println("update " + result);
		if(result) {
			System.out.println("update " + this.getRelatedCaseNo());
			if(!Util.isEmpty(this.getRelatedCaseNo())) {
				List<String> sqls = new ArrayList<String>();
				sqls.add("update patentcase set QuotationFlowKey='' where QuotationFlowKey ='" + this.getParentId() + "'");
				sqls.add("update trademarkcase set QuotationFlowKey='' where QuotationFlowKey ='" + this.getParentId() + "'");
				sqls.add("update legalcase set QuotationFlowKey='' where QuotationFlowKey ='" + this.getParentId() + "'");
				sqls.add("update copyrightcase set QuotationFlowKey='' where QuotationFlowKey ='" + this.getParentId() + "'");
				if(Util.compareTo(this.getCaseKind(), "STC01")) {
					sqls.add("update patentcase set QuotationFlowKey='" + this.getParentId() + "' where flowkey ='" + this.getRelatedCaseNo() + "'");
				}
				else if(Util.compareTo(this.getCaseKind(), "STC02")) {
					sqls.add("update trademarkcase set QuotationFlowKey='" + this.getParentId() + "' where flowkey ='" + this.getRelatedCaseNo() + "'");
				}
				else if(Util.compareTo(this.getCaseKind(), "STC03")) {
					sqls.add("update legalcase set QuotationFlowKey='" + this.getParentId() + "' where flowkey ='" + this.getRelatedCaseNo() + "'");
				}
				else if(Util.compareTo(this.getCaseKind(), "STC04")) {
					sqls.add("update copyrightcase set QuotationFlowKey='" + this.getParentId() + "' where flowkey ='" + this.getRelatedCaseNo() + "'");
				}
				for(String s : sqls) {
					System.out.println("=== " + s);
				}
				return this.getDbUtil().executeUpdate(sqls);
			}
			
			return true;
		}
		
		return false;
	}

	
	public boolean delete() throws Exception {
		if(super.delete()) {
			if(!Util.isEmpty(this.getRegisteredNo())) {
				List<String> sqls = new ArrayList<String>();
				sqls.add("update patentcase set QuotationFlowKey='' where QuotationFlowKey ='" + this.getParentId() + "'");
				sqls.add("update trademarkcase set QuotationFlowKey='' where QuotationFlowKey ='" + this.getParentId() + "'");
				sqls.add("update legalcase set QuotationFlowKey='' where QuotationFlowKey ='" + this.getParentId() + "'");
				sqls.add("update copyrightcase set QuotationFlowKey='' where QuotationFlowKey ='" + this.getParentId() + "'");
				
				for(String s : sqls) {
					System.out.println("=== " + s);
				}
				return this.getDbUtil().executeUpdate(sqls);
			}
			
			return true;
		}
		
		return false;
	}
	
	public void doPrintProcess() throws Exception {
    	String outFile = this.makeDoc();
    	System.out.println(outFile);
    	if(outFile!=null){
    		this.setOutputFile(outFile);
    	}
	}
	
    @SuppressWarnings("unchecked")
	public String makeDoc() throws Exception{
    	////System.out.println("getSampleDoc=" +getSampleDoc());
    	if(this.getSampleDoc().trim().length()==0){
    		return null;
    	}
    	OoConverter oc = new OoConverter("localhost", "8100");
    	String sampleDoc = "file:///"+Util.getTomcatPath()+this.getSampleDoc();
    	String outputFile = "SalesOrder/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".doc";
    	String outputDoc = "file:///"+Util.getDocPath()+outputFile;
    	
    	if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		SalesOrder invoice = new SalesOrder(this.getFlowKey());
    		invoice.setDbFields();
    		
    		Properties empProp = new Employee().getNamesPrpts();
    		Properties cateProp = new Category().getNamesPrpts();
    		Properties attorneyProp = new Attorney().getNamesPrpts();
    		Properties matterProp = new PatentMatterConfig().getNamesPrpts();
    		matterProp.putAll(cateProp);
    		
    		Map<String, String> data = new HashMap<String, String>();
    		Calendar calendar = Calendar.getInstance();
    		data.put("${today}", (calendar.get(Calendar.YEAR) - 1911) + "年" +
    				(calendar.get(Calendar.MONTH) + 1) + "月" +
    				calendar.get(Calendar.DAY_OF_MONTH) + "日");
    		data.put("${InvoiceTitle}", cateProp.get(invoice.getAttorneyTitle())+"");
    		
    		List<Field> dbFields = invoice.getDbFields();
    		
    		Properties applicantProp = new Applicant().getNamesPrpts();
    		Properties clientProp = new Client().getNamesPrpts();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
    		SimpleDateFormat ad_sdf = new SimpleDateFormat("yyyy/MM/dd");
    		SimpleDateFormat roc_sdf = new SimpleDateFormat("年MM月dd日");
    		int GovFee = 0;
    		int AttorneyFeeNtd = 0;
    		for(Field field : dbFields) {
    			data.put("${"+ field.getName() + "}", 
    					(field.getValue()==null || field.getValue().equalsIgnoreCase("null"))?"":field.getValue());
    			
//    			if(field.getValue() != null && !field.getValue().equalsIgnoreCase("null")) {
        			String name = field.getName();
        			String value = (field.getValue()==null || field.getValue().equalsIgnoreCase("null"))?"":field.getValue();
        			if(name.endsWith("Date") || name.endsWith("DateTo") ||
        					name.equalsIgnoreCase("DeadLine")) {

        				//將日期轉換成年月日
        				data = Util.putDateToMap(name, value, data);
        			}
        			else if(field.getName().equals("Attorney")) {
	    				data.put("${"+ field.getName() + "}", (attorneyProp.get(field.getValue()) == null ?"":attorneyProp.get(field.getValue()))+"");
	    			}
        			else if(field.getName().equals("InCharge")||
	    					field.getName().equals("TaskCreator")) {
	    				data.put("${"+ field.getName() + "}", (empProp.get(field.getValue()) == null ?"":empProp.get(field.getValue()))+"");
	    			}
//	    			else if(field.getName().equals("CaseClient")) {
//	    				data.put("${"+ field.getName() + "}", (clientProp.get(field.getValue()) == null ?"":clientProp.get(field.getValue())));
//	    			}
	    			else if(field.getName().equals("Matter")) {
	    				data.put("${"+ field.getName() + "}", (matterProp.get(field.getValue()) == null ?"":matterProp.get(field.getValue()))+"");
	    			}
	    			else if(field.getName().equals("PatentOffice") ||
	    					field.getName().equals("PatentType")||
	    					field.getName().equals("SubType")||
	    					field.getName().equals("InvoiceType")||
	    					field.getName().equals("Matter")||
	    					field.getName().equals("CaseType")||
	    					field.getName().equals("SoStatus")||
	    					field.getName().equals("CaseKind")||
	    					field.getName().equals("AttorneyTitle")||
	    					field.getName().equals("InvoiceStatus")) {
	    				data.put("${"+ field.getName() + "}", (cateProp.get(field.getValue()) == null ?"":cateProp.get(field.getValue()))+"");
	    			}
	    			else if(name.equalsIgnoreCase("ClientContect")) {
	    				value = applicantProp.getProperty(value);
	    				data.put("${"+ field.getName() + "}", value);
	    			}
        			
        			//下列欄位在一般套印時請呈現大寫：${ServiceFee} 和 ${GovFee} 和 ${AttorneyFeeNtd} 
        			//另要有一變數顯示此兩欄位的加總 ${AttorneyFeeNtd}+${GovFee}
        			//上述變數在範本文件中要怎麼定義在請提供
        			if(field.getName().equals("ServiceFee") ||
        					field.getName().equals("GovFee") ||
        					field.getName().equals("AttorneyFee") ||
        					field.getName().equals("TotalTax") ||
        					field.getName().equals("TotalTax2") ||
        					field.getName().equals("TotalRequestPayNtdAmount") ||
        					field.getName().equals("TotalDiscountAmount") ||
        					field.getName().equals("TotalWithHolding") ||
        					field.getName().equals("AttorneyFeeNtd") ||
        					field.getName().equals("OtherFeeNtd") ||
        					field.getName().equals("TotalAmountDeductTTax2") ||
        					field.getName().equals("ServiceFeeDeductTTax2") ||
        					field.getName().equals("TotalUntaxedAmount") ||
        					field.getName().equals("TwdDeductionAmount") ||
        					field.getName().equals("TotalAmountAfterDiscount") ||
        					field.getName().equals("TotalUntaxedAmount") ||
        					field.getName().equals("TotalUntaxedAmount") ||
        					field.getName().equals("TotalUntaxedAmount")) {
        				data.put("${ROC_" + field.getName() + "}", Util.numberToRocString(field.getValue()));
        			}
        			
        			if(field.getName().equals("ServiceFee") ||
        					field.getName().equals("GovFee") ||
        					field.getName().equals("AttorneyFee") ||
        					field.getName().equals("TotalTax") ||
        					field.getName().equals("TotalTax2") ||
        					field.getName().equals("TotalRequestPayNtdAmount") ||
        					field.getName().equals("TotalDiscountAmount") ||
        					field.getName().equals("TotalWithHolding") ||
        					field.getName().equals("AttorneyFeeNtd") ||
        					field.getName().equals("OtherFeeNtd") ||
        					field.getName().equals("TotalAmountDeductTTax2") ||
        					field.getName().equals("ServiceFeeDeductTTax2") ||
        					field.getName().equals("TotalUntaxedAmount") ||
        					field.getName().equals("TwdDeductionAmount") ||
        					field.getName().equals("TotalAmountAfterDiscount") ||
        					field.getName().equals("TotalUntaxedAmount") ||
        					field.getName().equals("TotalUntaxedAmount") ||
        					field.getName().equals("TotalUntaxedAmount")) {
        				data.put("${" + field.getName() + "}", Util.formatNumber(Util.stringToInt(field.getValue()), "###,###"));
        			}
        			
        			if(
        					field.getName().equals("GovFeeAmount") ||
        					field.getName().equals("ServiceFeeAmount")) {
        				data.put("${" + field.getName() + "}", Util.formatNumber(Util.stringToDouble(field.getValue()), "###,###.00"));
        			}
        			
        			if(field.getName().equals("AttorneyFeeNtd")) {
        				AttorneyFeeNtd = Integer.parseInt(field.getValue());
        			}
        			if(field.getName().equals("GovFee")) {
        				GovFee = Integer.parseInt(field.getValue());
        			}
        			if(name.equalsIgnoreCase("Client")) {
        				data.put("${Client}", value);
        				data.put("${ClientName}", new Client().getNamesPrpts().getProperty(value));
        			}
        			if(name.equalsIgnoreCase("ClientName")) {
        				
        			}
//    			}
    		}
    		

			if(!Util.isEmpty(this.getClient())) {
				Client client = new Client(this.getClient());

				data.putAll(client.getDocMap());
			}
    		
			data.put("${BillingContact}", this.getBillingContact());
			for(String key : data.keySet()) {
				if(data.get(key) == null) {
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
}
