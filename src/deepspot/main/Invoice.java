package deepspot.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBodyImpl;

import com.athenasoft.ooutil.OoConverter;

import deepspot.basic.Cnstnts;
import deepspot.basic.DbUtil;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.util.DB;
import deepspot.util.Util;
import deepspot.util.VelocityHelper;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;

public class Invoice extends MasterBean {

    public Invoice(){
    	this.init();
    	this.setOrderKey("InvoiceNo");
		this.setOrderSequence(Cnstnts.DESC);
    }

    public Invoice(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Client;
    public void setClient(String Client){this.Client.setValue(Client);}
    public String getClient(){return this.Client.getValue();}

    public Field AssignedTo;
    public void setAssignedTo(String AssignedTo){this.AssignedTo.setValue(AssignedTo);}
    public String getAssignedTo(){return this.AssignedTo.getValue();}

    public Field ClientName;
    public void setClientName(String ClientName){this.ClientName.setValue(ClientName);}
    public String getClientName(){return this.ClientName.getValue();}

    public Field InvoiceType;
    public void setInvoiceType(String InvoiceType){this.InvoiceType.setValue(InvoiceType);}
    public String getInvoiceType(){return this.InvoiceType.getValue();}

    public Field PaymentTerm;
    public void setPaymentTerm(String PaymentTerm){this.PaymentTerm.setValue(PaymentTerm);}
    public String getPaymentTerm(){return this.PaymentTerm.getValue();}

    public Field AttorneyTitle;
    public void setAttorneyTitle(String AttorneyTitle){this.AttorneyTitle.setValue(AttorneyTitle);}
    public String getAttorneyTitle(){return this.AttorneyTitle.getValue();}

    public Field InvoiceTitle;
    public void setInvoiceTitle(String InvoiceTitle){this.InvoiceTitle.setValue(InvoiceTitle);}
    public String getInvoiceTitle(){return this.InvoiceTitle.getValue();}

    public Field InvoiceDate;
    public void setInvoiceDate(String InvoiceDate){this.InvoiceDate.setValue(InvoiceDate);}
    public String getInvoiceDate(){return this.InvoiceDate.getValue();}

    public Field ArDate;
    public void setArDate(String ArDate){this.ArDate.setValue(ArDate);}
    public String getArDate(){return this.ArDate.getValue();}

    public Field TotalTax;
    public void setTotalTax(String TotalTax){this.TotalTax.setValue(TotalTax);}
    public String getTotalTax(){return this.TotalTax.getValue();}

    public Field TotalTax2;
    public void setTotalTax2(String TotalTax2){this.TotalTax2.setValue(TotalTax2);}
    public String getTotalTax2(){return this.TotalTax2.getValue();}

    public Field TotalRequestPayNtdAmount;
    public void setTotalRequestPayNtdAmount(String TotalRequestPayNtdAmount){this.TotalRequestPayNtdAmount.setValue(TotalRequestPayNtdAmount);}
    public String getTotalRequestPayNtdAmount(){return this.TotalRequestPayNtdAmount.getValue();}

    public Field TotalWriteOffAmount;
    public void setTotalWriteOffAmount(String TotalWriteOffAmount){this.TotalWriteOffAmount.setValue(TotalWriteOffAmount);}
    public String getTotalWriteOffAmount(){return this.TotalWriteOffAmount.getValue();}

    public Field TotalDiscountAmount;
    public void setTotalDiscountAmount(String TotalDiscountAmount){this.TotalDiscountAmount.setValue(TotalDiscountAmount);}
    public String getTotalDiscountAmount(){return this.TotalDiscountAmount.getValue();}

    public Field NotYetWriteOff;
    public void setNotYetWriteOff(String NotYetWriteOff){this.NotYetWriteOff.setValue(NotYetWriteOff);}
    public String getNotYetWriteOff(){return this.NotYetWriteOff.getValue();}

    public Field ArDateTo;
    public void setArDateTo(String ArDateTo){this.ArDateTo.setValue(ArDateTo);}
    public String getArDateTo(){return this.ArDateTo.getValue();}

    public Field InvoiceDateTo;
    public void setInvoiceDateTo(String InvoiceDateTo){this.InvoiceDateTo.setValue(InvoiceDateTo);}
    public String getInvoiceDateTo(){return this.InvoiceDateTo.getValue();}
    
    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}
    
    public Field CaseNo;
    public void setCaseNo(String CaseNo){this.CaseNo.setValue(CaseNo);}
    public String getCaseNo(){return this.CaseNo.getValue();}
    
    public Field CaseNo2;
    public void setCaseNo2(String CaseNo2){this.CaseNo2.setValue(CaseNo2);}
    public String getCaseNo2(){return this.CaseNo2.getValue();}

    public Field Office;
    public void setOffice(String Office){this.Office.setValue(Office);}
    public String getOffice(){return this.Office.getValue();}

    public Field SubType;
    public void setSubType(String SubType){this.SubType.setValue(SubType);}
    public String getSubType(){return this.SubType.getValue();}
    
    public Field Matter;
    public void setMatter(String Matter){this.Matter.setValue(Matter);}
    public String getMatter(){return this.Matter.getValue();}
    
    public Field ServiceFee;
    public void setServiceFee(String ServiceFee){this.ServiceFee.setValue(ServiceFee);}
    public String getServiceFee(){return this.ServiceFee.getValue();}
    
    public Field GovFee;
    public void setGovFee(String AttorneyFee){this.GovFee.setValue(AttorneyFee);}
    public String getGovFee(){return this.GovFee.getValue();}
    
    public Field ApplyNo;
    public void setApplyNo(String ApplyNo){this.ApplyNo.setValue(ApplyNo);}
    public String getApplyNo(){return this.ApplyNo.getValue();}
    
    public Field InvoiceNo;
    public void setInvoiceNo(String InvoiceNo){this.InvoiceNo.setValue(InvoiceNo);}
    public String getInvoiceNo(){return this.InvoiceNo.getValue();}
    
    public Field InvoiceNoTo;
    public void setInvoiceNoTo(String InvoiceNoTo){this.InvoiceNoTo.setValue(InvoiceNoTo);}
    public String getInvoiceNoTo(){return this.InvoiceNoTo.getValue();}
    
    public Field CaseType;
    public void setCaseType(String CaseType){this.CaseType.setValue(CaseType);}
    public String getCaseType(){return this.CaseType.getValue();}
    
    public Field InCharge;
    public void setInCharge(String InCharge){this.InCharge.setValue(InCharge);}
    public String getInCharge(){return this.InCharge.getValue();}
    
    public Field VoucherDate;
    public void setVoucherDate(String VoucherDate){this.VoucherDate.setValue(VoucherDate);}
    public String getVoucherDate(){return this.VoucherDate.getValue();}
    
    public Field VoucherDateTo;
    public void setVoucherDateTo(String VoucherDateTo){this.VoucherDateTo.setValue(VoucherDateTo);}
    public String getVoucherDateTo(){return this.VoucherDateTo.getValue();}
    
    public Field BillDate;
    public void setBillDate(String BillDate){this.BillDate.setValue(BillDate);}
    public String getBillDate(){return this.BillDate.getValue();}
    
    public Field Note;
    public void setNote(String Note){this.Note.setValue(Note);}
    public String getNote(){return this.Note.getValue();}
    
    public Field TotalWithHolding;
    public void setTotalWithHolding(String TotalWithHolding){this.TotalWithHolding.setValue(TotalWithHolding);}
    public String getTotalWithHolding(){return this.TotalWithHolding.getValue();}
    
    public Field TaskDescription;
    public void setTaskDescription(String TaskDescription){this.TaskDescription.setValue(TaskDescription);}
    public String getTaskDescription(){return this.TaskDescription.getValue();}
    
    public Field InternalNo;
    public void setInternalNo(String InternalNo){this.InternalNo.setValue(InternalNo);}
    public String getInternalNo(){return this.InternalNo.getValue();}
    
    public Field ApplyDate;
    public void setApplyDate(String ApplyDate){this.ApplyDate.setValue(ApplyDate);}
    public String getApplyDate(){return this.ApplyDate.getValue();}

    
    public Field IssueDate;
    public void setIssueDate(String IssueDate){this.IssueDate.setValue(IssueDate);}
    public String getIssueDate(){return this.IssueDate.getValue();}

    
    public Field IssueNo;
    public void setIssueNo(String IssueNo){this.IssueNo.setValue(IssueNo);}
    public String getIssueNo(){return this.IssueNo.getValue();}

    
    public Field ClientContect;
    public void setClientContect(String ClientContect){this.ClientContect.setValue(ClientContect);}
    public String getClientContect(){return this.ClientContect.getValue();}

    
    public Field InvoiceStatus;
    public void setInvoiceStatus(String InvoiceStatus){this.InvoiceStatus.setValue(InvoiceStatus);}
    public String getInvoiceStatus(){return this.InvoiceStatus.getValue();}

    
    public Field AttorneyCurrency;
    public void setAttorneyCurrency(String AttorneyCurrency){this.AttorneyCurrency.setValue(AttorneyCurrency);}
    public String getAttorneyCurrency(){return this.AttorneyCurrency.getValue();}

    
    public Field AttorneyFee;
    public void setAttorneyFee(String AttorneyFee){this.AttorneyFee.setValue(AttorneyFee);}
    public String getAttorneyFee(){return this.AttorneyFee.getValue();}

    
    public Field AttorneyFeeNtd;
    public void setAttorneyFeeNtd(String AttorneyFeeNtd){this.AttorneyFeeNtd.setValue(AttorneyFeeNtd);}
    public String getAttorneyFeeNtd(){return this.AttorneyFeeNtd.getValue();}

    
    public Field OtherCurrency;
    public void setOtherCurrency(String OtherCurrency){this.OtherCurrency.setValue(OtherCurrency);}
    public String getOtherCurrency(){return this.OtherCurrency.getValue();}

    
    public Field OtherFee;
    public void setOtherFee(String OtherFee){this.OtherFee.setValue(OtherFee);}
    public String getOtherFee(){return this.OtherFee.getValue();}

    
    public Field OtherFeeNtd;
    public void setOtherFeeNtd(String OtherFeeNtd){this.OtherFeeNtd.setValue(OtherFeeNtd);}
    public String getOtherFeeNtd(){return this.OtherFeeNtd.getValue();}
    
    public Field RegisterNo;
    public void setRegisterNo(String RegisterNo){this.RegisterNo.setValue(RegisterNo);}
    public String getRegisterNo(){return this.RegisterNo.getValue();}
    
    public Field TotalUntaxedAmount;
    public void setTotalUntaxedAmount(String TotalUntaxedAmount){this.TotalUntaxedAmount.setValue(TotalUntaxedAmount);}
    public String getTotalUntaxedAmount(){return this.TotalUntaxedAmount.getValue();}
    
    public Field ServiceProjectCode;
    public void setServiceProjectCode(String ServiceProjectCode){this.ServiceProjectCode.setValue(ServiceProjectCode);}
    public String getServiceProjectCode(){return this.ServiceProjectCode.getValue();}
    
    private String DoWriteOffFlag;

	public String getDoWriteOffFlag() {
		return DoWriteOffFlag;
	}

	public void setDoWriteOffFlag(String doWriteOffFlag) {
		DoWriteOffFlag = doWriteOffFlag;
	}
	
	private String ArWriteOffLogKey;

	public String getArWriteOffLogKey() {
		return ArWriteOffLogKey;
	}

	public void setArWriteOffLogKey(String arWriteOffLogKey) {
		ArWriteOffLogKey = arWriteOffLogKey;
	}
	
	private String getTitleType;

	public String getgetTitleType() {
		return getTitleType;
	}

	public void setgetTitleType(String arWriteOffLogKey) {
		getTitleType = arWriteOffLogKey;
	}

    
    public Field TotalAmountDeductTTax2;
    public void setTotalAmountDeductTTax2(String TotalAmountDeductTTax2){this.TotalAmountDeductTTax2.setValue(TotalAmountDeductTTax2);}
    public String getTotalAmountDeductTTax2(){return this.TotalAmountDeductTTax2.getValue();}

    
    public Field ServiceFeeDeductTTax2;
    public void setServiceFeeDeductTTax2(String ServiceFeeDeductTTax2){this.ServiceFeeDeductTTax2.setValue(ServiceFeeDeductTTax2);}
    public String getServiceFeeDeductTTax2(){return this.ServiceFeeDeductTTax2.getValue();}

    public Field TaskCreator;
    public void setTaskCreator(String TaskCreator){this.TaskCreator.setValue(TaskCreator);}
    public String getTaskCreator(){return this.TaskCreator.getValue();}
    
    public Field TrademarkClassification;
    public void setTrademarkClassification(String TrademarkClassification){this.TrademarkClassification.setValue(TrademarkClassification);}
    public String getTrademarkClassification(){return this.TrademarkClassification.getValue();}
    
    public String createInvoiceNoFlag;
	
    public String getCreateInvoiceNoFlag() {
		return createInvoiceNoFlag;
	}

	public void setCreateInvoiceNoFlag(String createInvoiceNoFlag) {
		this.createInvoiceNoFlag = createInvoiceNoFlag;
	}
    
    public Field FreeServiceNumberOfMonth;
    public void setFreeServiceNumberOfMonth(String FreeServiceNumberOfMonth){this.FreeServiceNumberOfMonth.setValue(FreeServiceNumberOfMonth);}
    public String getFreeServiceNumberOfMonth(){return this.FreeServiceNumberOfMonth.getValue();}
    
    public Field InvoiceMonth;
    public void setInvoiceMonth(String InvoiceMonth){this.InvoiceMonth.setValue(InvoiceMonth);}
    public String getInvoiceMonth(){return this.InvoiceMonth.getValue();}
    
    public Field RegisteredNo;
    public void setRegisteredNo(String RegisteredNo){this.RegisteredNo.setValue(RegisteredNo);}
    public String getRegisteredNo(){return this.RegisteredNo.getValue();}
    
    public Field InvoiceNumber;
    public void setInvoiceNumber(String InvoiceNumber){this.InvoiceNumber.setValue(InvoiceNumber);}
    public String getInvoiceNumber(){return this.InvoiceNumber.getValue();}
    
    public Field ReceiptNumber;
    public void setReceiptNumber(String ReceiptNumber){this.ReceiptNumber.setValue(ReceiptNumber);}
    public String getReceiptNumber(){return this.ReceiptNumber.getValue();}
    
    public Field TwdHourlyCharge;
    public void setTwdHourlyCharge(String TwdHourlyCharge){this.TwdHourlyCharge.setValue(TwdHourlyCharge);}
    public String getTwdHourlyCharge(){return this.TwdHourlyCharge.getValue();}
    
    public Field TwdDeductionAmount;
    public void setTwdDeductionAmount(String TwdDeductionAmount){this.TwdDeductionAmount.setValue(TwdDeductionAmount);}
    public String getTwdDeductionAmount(){return this.TwdDeductionAmount.getValue();}
    
    public Field TotalAmountAfterDiscount;
    public void setTotalAmountAfterDiscount(String TotalAmountAfterDiscount){this.TotalAmountAfterDiscount.setValue(TotalAmountAfterDiscount);}
    public String getTotalAmountAfterDiscount(){return this.TotalAmountAfterDiscount.getValue();}
    
    public Field TimesheetMerge;
    public void setTimesheetMerge(String TimesheetMerge){this.TimesheetMerge.setValue(TimesheetMerge);}
    public String getTimesheetMerge(){return this.TimesheetMerge.getValue();}
    
    public Field MultiTodos;
    public void setMultiTodos(String MultiTodos){this.MultiTodos.setValue(MultiTodos);}
    public String getMultiTodos(){return this.MultiTodos.getValue();}
    
    public Field IndependentClaim;
    public void setIndependentClaim(String IndependentClaim){this.IndependentClaim.setValue(IndependentClaim);}
    public String getIndependentClaim(){return this.IndependentClaim.getValue();}
    
    public Field DependentClaim;
    public void setDependentClaim(String DependentClaim){this.DependentClaim.setValue(DependentClaim);}
    public String getDependentClaim(){return this.DependentClaim.getValue();}
    
    public Field ServiceFeeAmount;
    public void setServiceFeeAmount(String ServiceFeeAmount){this.ServiceFeeAmount.setValue(ServiceFeeAmount);}
    public String getServiceFeeAmount(){return this.ServiceFeeAmount.getValue();}
    
    public Field ServiceFeeCurrency;
    public void setServiceFeeCurrency(String ServiceFeeCurrency){this.ServiceFeeCurrency.setValue(ServiceFeeCurrency);}
    public String getServiceFeeCurrency(){return this.ServiceFeeCurrency.getValue();}
    
    public Field GovFeeAmount;
    public void setGovFeeAmount(String GovFeeAmount){this.GovFeeAmount.setValue(GovFeeAmount);}
    public String getGovFeeAmount(){return this.GovFeeAmount.getValue();}
    
    public Field GovFeeCurrency;
    public void setGovFeeCurrency(String GovFeeCurrency){this.GovFeeCurrency.setValue(GovFeeCurrency);}
    public String getGovFeeCurrency(){return this.GovFeeCurrency.getValue();}

    public Field IpType;
    public void setIpType(String IpType){this.IpType.setValue(IpType);}
    public String getIpType(){return this.IpType.getValue();}
    
    public String genReceiptNumberFlag;
    
	public String getGenReceiptNumberFlag() {
		return genReceiptNumberFlag;
	}

	public void setGenReceiptNumberFlag(String genReceiptNumberFlag) {
		this.genReceiptNumberFlag = genReceiptNumberFlag;
	}
    
    public Field BillingContact;
    public void setBillingContact(String BillingContact){this.BillingContact.setValue(BillingContact);}
    public String getBillingContact(){return this.BillingContact.getValue();}
    
    public Field CaseClient;
    public void setCaseClient(String CaseClient){this.CaseClient.setValue(CaseClient);}
    public String getCaseClient(){return this.CaseClient.getValue();} 
    
    public Field SoKey;
    public void setSoKey(String SoKey){this.SoKey.setValue(SoKey);}
    public String getSoKey(){return this.SoKey.getValue();} 
    
    public Field Title2;
    public void setTitle2(String Title2){this.Title2.setValue(Title2);}
    public String getTitle2(){return this.Title2.getValue();}
    
    public Field AmountReceipts;
    public void setAmountReceipts(String AmountReceipts){this.AmountReceipts.setValue(AmountReceipts);}
    public String getAmountReceipts(){return this.AmountReceipts.getValue();}
    
    public Field AmountReceivable;
    public void setAmountReceivable(String AmountReceivable){this.AmountReceivable.setValue(AmountReceivable);}
    public String getAmountReceivable(){return this.AmountReceivable.getValue();}
    
    public Field TotalIncludeTaxAmount;
    public void setTotalIncludeTaxAmount(String TotalIncludeTaxAmount){this.TotalIncludeTaxAmount.setValue(TotalIncludeTaxAmount);}
    public String getTotalIncludeTaxAmount(){return this.TotalIncludeTaxAmount.getValue();}
    
    public Field TotalNotIncludeTaxAmount;
    public void setTotalNotIncludeTaxAmount(String TotalNotIncludeTaxAmount){this.TotalNotIncludeTaxAmount.setValue(TotalNotIncludeTaxAmount);}
    public String getTotalNotIncludeTaxAmount(){return this.TotalNotIncludeTaxAmount.getValue();}
    
    public Field TotalNotIncludeTaxAmountNtd;
    public void setTotalNotIncludeTaxAmountNtd(String TotalNotIncludeTaxAmountNtd){this.TotalNotIncludeTaxAmountNtd.setValue(TotalNotIncludeTaxAmountNtd);}
    public String getTotalNotIncludeTaxAmountNtd(){return this.TotalNotIncludeTaxAmountNtd.getValue();}
    
    public Field AttorneyBillNo;
    public void setAttorneyBillNo(String AttorneyBillNo){this.AttorneyBillNo.setValue(AttorneyBillNo);}
    public String getAttorneyBillNo(){return this.AttorneyBillNo.getValue();}
    
    public Field AccountReceivableDay;
    public void setAccountReceivableDay(String AccountReceivableDay){this.AccountReceivableDay.setValue(AccountReceivableDay);}
    public String getAccountReceivableDay(){return this.AccountReceivableDay.getValue();}
    
    public String reloadFlag;

	public String getReloadFlag() {
		return reloadFlag;
	}

	public void setReloadFlag(String reloadFlag) {
		this.reloadFlag = reloadFlag;
	}
	
	private String[] MarkKeys;

	public void setMarkKeys(String[] markKeys) {
		this.MarkKeys = markKeys;
	}

	public String[] getMarkKeys() {
		return this.MarkKeys;
	}

	public void init() {
        super.init();
        this.useFieldWidth = true;
        this.openBlankDetail = true;
        this.bbActionSelectItemToButton = true;
        this.showPrintNewDocImg = true;
        
        this.setProgramId("jsp.Invoice");
        this.setTableName("Invoice");
        
        this.setOrderKey("InvoiceNo");
        this.setOrderSequence(Cnstnts.DESC);
        
        this.AmountReceivable = new Field("AmountReceivable", this.getTableName());
        this.AmountReceivable.setDbType("float");
        this.AmountReceivable.setDecimal(2);
        
        this.AmountReceipts = new Field("AmountReceipts", this.getTableName());
        this.AmountReceipts.setDbType("float");
        this.AmountReceipts.setDecimal(2);
        
        this.Title2 = new Field("Title2", this.getTableName());
        this.Title2.setDbType("varchar(50)");
        
        this.SoKey = new Field("SoKey", this.getTableName());
        this.SoKey.setDbType("varchar(50)");
        
        this.CaseClient = new Field("CaseClient", this.getTableName());
        this.CaseClient.setDbType("varchar(200)");
        
        this.BillingContact = new Field("BillingContact", this.getTableName());
        this.BillingContact.setDbType("varchar(200)");
        
        this.IpType = new Field("IpType", this.getTableName());
        
        this.FlowKey.setSearchCondition(Cnstnts.LIKE);

        this.AssignedTo = new Field("AssignedTo", this.getTableName());
        this.AssignedTo.setDbType("varchar(50)");

        this.Client = new Field("Client", this.getTableName());
        this.Client.setDbType("varchar(50)");
        this.Client.setSearchCondition(Cnstnts.LIKE);
        this.Client.setCheckEmpty(true);

        this.ClientName = new Field("ClientName", this.getTableName());
        this.ClientName.setDbType("varchar(100)");
        this.ClientName.setSearchCondition(Cnstnts.LIKE);
        this.ClientName.setCheckEmpty(true);

        this.InvoiceType = new Field("InvoiceType", this.getTableName());
        this.InvoiceType.setDbType("nvarchar(50)");
//        this.InvoiceType.setCheckEmpty(true);

        this.PaymentTerm = new Field("PaymentTerm", this.getTableName());
        this.PaymentTerm.setDbType("varchar(50)");

        this.AttorneyTitle = new Field("AttorneyTitle", this.getTableName());
        this.AttorneyTitle.setDbType("varchar(50)");
        this.AttorneyTitle.setSearchCondition(Cnstnts.LIKE);
        this.AttorneyTitle.setCheckEmpty(true);

        this.InvoiceTitle = new Field("InvoiceTitle", this.getTableName());
        this.InvoiceTitle.setDbType("varchar(50)");
        this.InvoiceTitle.setSearchCondition(Cnstnts.LIKE);

        this.InvoiceDate = new Field("InvoiceDate", this.getTableName());
        this.InvoiceDate.setDbType("varchar(10)");

        this.ArDate = new Field("ArDate", this.getTableName());
        this.ArDate.setDbType("varchar(10)");

        this.TotalTax = new Field("TotalTax", this.getTableName());
        this.TotalTax.setDbType("int");

        this.TotalTax2 = new Field("TotalTax2", this.getTableName());
        this.TotalTax2.setDbType("int");
        
        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("varchar(50)");
        this.Title.setSearchCondition(Cnstnts.LIKE);

        this.CaseNo = new Field("CaseNo", this.getTableName());
        this.CaseNo.setDbType("varchar(50)");
        this.CaseNo.setSearchCondition(Cnstnts.LIKE);

        this.CaseNo2 = new Field("CaseNo2", this.getTableName());
        this.CaseNo2.setDbType("varchar(50)");
        this.CaseNo2.setSearchCondition(Cnstnts.LIKE);
        
        this.Office = new Field("Office", this.getTableName());
        this.Office.setDbType("varchar(50)");

        this.SubType = new Field("SubType", this.getTableName());
        this.SubType.setDbType("varchar(50)");
        
        this.Matter = new Field("Matter", this.getTableName());
        this.Matter.setDbType("varchar(50)");
        
        this.ApplyNo = new Field("ApplyNo", this.getTableName());
        this.ApplyNo.setDbType("varchar(50)");
        this.ApplyNo.setSearchCondition(Cnstnts.LIKE);
        
        this.InvoiceNo = new Field("InvoiceNo", this.getTableName());
        this.InvoiceNo.setDbType("varchar(50)");
        this.InvoiceNo.setSearchCondition(Cnstnts.LIKE);
        
        this.InvoiceNoTo = new Field("InvoiceNoTo", this.getTableName());
        this.InvoiceNoTo.setDbType("varchar(50)");
        
        this.CaseType = new Field("CaseType", this.getTableName());
        this.CaseType.setDbType("varchar(50)");
        
        this.InCharge = new Field("InCharge", this.getTableName());
        this.InCharge.setDbType("varchar(50)");
        
        this.VoucherDate = new Field("VoucherDate", this.getTableName());
        this.VoucherDate.setDbType("varchar(10)");
        
        this.VoucherDateTo = new Field("VoucherDateTo", this.getTableName());
        this.VoucherDateTo.setDbType("varchar(10)");
        
        this.BillDate = new Field("BillDate", this.getTableName());
        this.BillDate.setDbType("varchar(10)");
        
        this.Note = new Field("Note", this.getTableName());
        this.Note.setDbType("varchar(200)");
        
        this.ServiceFee = new Field("ServiceFee", this.getTableName());
        this.ServiceFee.setDbType("int");

        this.GovFee = new Field("GovFee", this.getTableName());
        this.GovFee.setDbType("int");
        
        this.TotalRequestPayNtdAmount = new Field("TotalRequestPayNtdAmount", this.getTableName());
        this.TotalRequestPayNtdAmount.setDbType("int");

        this.TotalWriteOffAmount = new Field("TotalWriteOffAmount", this.getTableName());
        this.TotalWriteOffAmount.setDbType("int");

        this.TotalDiscountAmount = new Field("TotalDiscountAmount", this.getTableName());
        this.TotalDiscountAmount.setDbType("int");

        this.NotYetWriteOff = new Field("NotYetWriteOff", this.getTableName());
        this.NotYetWriteOff.setDbType("varchar(1)");

		this.InvoiceDateTo = new Field("InvoiceDateTo", this.getTableName());

		this.ArDateTo = new Field("ArDateTo", this.getTableName());
		
		this.TotalWithHolding = new Field("TotalWithHolding", this.getTableName());
        this.TotalWithHolding.setDbType("int");
		
		this.InternalNo = new Field("InternalNo", this.getTableName());
		this.InternalNo.setDbType("varchar(50)");
        
        this.TaskDescription = new Field("TaskDescription", this.getTableName());
        this.TaskDescription.setDbType("varchar(500)");
        this.TaskDescription.setSearchCondition(Cnstnts.LIKE);
        
        this.ApplyDate = new Field("ApplyDate", this.getTableName());
        this.ApplyDate.setDbType("varchar(10)");
        
        this.IssueDate = new Field("IssueDate", this.getTableName());
        this.IssueDate.setDbType("varchar(10)");
        
        this.IssueNo = new Field("IssueNo", this.getTableName());
        this.IssueNo.setDbType("varchar(50)");
        
        this.ClientContect = new Field("ClientContect", this.getTableName());
        this.ClientContect.setDbType("varchar(50)");
        
        this.InvoiceStatus = new Field("InvoiceStatus", this.getTableName());
        this.InvoiceStatus.setDbType("varchar(50)");
        
        this.AttorneyCurrency = new Field("AttorneyCurrency", this.getTableName());
        this.AttorneyCurrency.setDbType("varchar(50)");
        
        this.GovFeeCurrency = new Field("GovFeeCurrency", this.getTableName());
        this.GovFeeCurrency.setDbType("varchar(50)");
        
        this.ServiceFeeCurrency = new Field("ServiceFeeCurrency", this.getTableName());
        this.ServiceFeeCurrency.setDbType("varchar(50)");
        
        this.GovFeeAmount = new Field("GovFeeAmount", this.getTableName());
        this.GovFeeAmount.setDbType("float");
        this.GovFeeAmount.setDecimal(2);
        
        this.ServiceFeeAmount = new Field("ServiceFeeAmount", this.getTableName());
        this.ServiceFeeAmount.setDbType("float");
        this.ServiceFeeAmount.setDecimal(2);
        
        this.AttorneyFee = new Field("AttorneyFee", this.getTableName());
        this.AttorneyFee.setDbType("float");
        this.AttorneyFee.setDecimal(2);
        
        this.AttorneyFeeNtd = new Field("AttorneyFeeNtd", this.getTableName());
        this.AttorneyFeeNtd.setDbType("int");
        
        this.OtherCurrency = new Field("OtherCurrency", this.getTableName());
        this.OtherCurrency.setDbType("varchar(50)");
        
        this.OtherFee = new Field("OtherFee", this.getTableName());
        this.OtherFee.setDbType("varchar(50)");
        
        this.OtherFeeNtd = new Field("OtherFeeNtd", this.getTableName());
        this.OtherFeeNtd.setDbType("varchar(50)");
        
        this.TotalAmountDeductTTax2 = new Field("TotalAmountDeductTTax2", this.getTableName());
        this.TotalAmountDeductTTax2.setDbType("int");
        
        this.ServiceFeeDeductTTax2 = new Field("ServiceFeeDeductTTax2", this.getTableName());
        this.ServiceFeeDeductTTax2.setDbType("int");

        this.TaskCreator = new Field("TaskCreator", this.getTableName());
        this.TaskCreator.setDbType("varchar(50)");
        
        this.TrademarkClassification = new Field("TrademarkClassification", this.getTableName());
        this.TrademarkClassification.setDbType("nvarchar(500)");
        
        this.RegisterNo = new Field("RegisterNo", this.getTableName());
        this.RegisterNo.setDbType("varchar(50)");
        
        this.ServiceProjectCode = new Field("ServiceProjectCode", this.getTableName());
        this.ServiceProjectCode.setDbType("varchar(50)");

        this.TotalUntaxedAmount = new Field("TotalUntaxedAmount", this.getTableName());
        this.TotalUntaxedAmount.setDbType("int");
        
        this.InvoiceMonth = new Field("InvoiceMonth", this.getTableName());
        this.InvoiceMonth.setDbType("varchar(50)");
        
        this.FreeServiceNumberOfMonth = new Field("FreeServiceNumberOfMonth", this.getTableName());
        this.FreeServiceNumberOfMonth.setDbType("float");
        this.FreeServiceNumberOfMonth.setDecimal(1);
        
        this.TwdHourlyCharge = new Field("TwdHourlyCharge", this.getTableName());
        this.TwdHourlyCharge.setDbType("int");
        
        this.RegisteredNo = new Field("RegisteredNo", this.getTableName());
        this.RegisteredNo.setDbType("varchar(50)");
        
        this.InvoiceNumber = new Field("InvoiceNumber", this.getTableName());
        this.InvoiceNumber.setDbType("varchar(50)");
        
        this.ReceiptNumber = new Field("ReceiptNumber", this.getTableName());
        this.ReceiptNumber.setDbType("varchar(50)");
        this.ReceiptNumber.setSearchCondition(Cnstnts.LIKE);

        this.InvoiceMonth = new Field("InvoiceMonth", this.getTableName());
        this.InvoiceMonth.setDbType("varchar(50)");
        
        this.FreeServiceNumberOfMonth = new Field("FreeServiceNumberOfMonth", this.getTableName());
        this.FreeServiceNumberOfMonth.setDbType("float");
        this.FreeServiceNumberOfMonth.setDecimal(1);
        
        this.TwdHourlyCharge = new Field("TwdHourlyCharge", this.getTableName());
        this.TwdHourlyCharge.setDbType("int");
        
        this.TwdDeductionAmount = new Field("TwdDeductionAmount", this.getTableName());
        this.TwdDeductionAmount.setDbType("int");
        
        this.TotalAmountAfterDiscount = new Field("TotalAmountAfterDiscount", this.getTableName());
        this.TotalAmountAfterDiscount.setDbType("int");
        
        this.TimesheetMerge = new Field("TimesheetMerge", this.getTableName());
        this.TimesheetMerge.setDbType("varchar(1)");
        
        this.MultiTodos = new Field("MultiTodos", this.getTableName());
        this.MultiTodos.setDbType("varchar(1)");
        
        this.IndependentClaim = new Field("IndependentClaim", this.getTableName());
        this.IndependentClaim.setDbType("int");
        
        this.DependentClaim = new Field("DependentClaim", this.getTableName());
        this.DependentClaim.setDbType("int");
        
        this.TotalIncludeTaxAmount = new Field("TotalIncludeTaxAmount", this.getTableName());
        this.TotalIncludeTaxAmount.setDbType("float");
        this.TotalIncludeTaxAmount.setDecimal(2);
        
        this.TotalNotIncludeTaxAmount = new Field("TotalNotIncludeTaxAmount", this.getTableName());
        this.TotalNotIncludeTaxAmount.setDbType("float");
        this.TotalNotIncludeTaxAmount.setDecimal(2);
        
        this.TotalNotIncludeTaxAmountNtd = new Field("TotalNotIncludeTaxAmountNtd", this.getTableName());
        this.TotalNotIncludeTaxAmountNtd.setDbType("int");
        this.TotalNotIncludeTaxAmountNtd.setDecimal(0);
        
        this.AccountReceivableDay = new Field("AccountReceivableDay", this.getTableName());
        this.AccountReceivableDay.setDbType("varchar(200)");
        
        this.AttorneyBillNo = new Field("AttorneyBillNo", this.getTableName());
        this.AttorneyBillNo.setDbType("varchar(200)");
        this.AttorneyBillNo.setSearchCondition(Cnstnts.LIKE);
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.AttorneyBillNo);
        this.DbFields.add(this.CaseNo2);
        this.DbFields.add(this.TotalIncludeTaxAmount);
        this.DbFields.add(this.TotalNotIncludeTaxAmount);
        this.DbFields.add(this.AmountReceipts);
        this.DbFields.add(this.AmountReceivable);
        this.DbFields.add(this.SoKey);
        this.DbFields.add(this.Title2);
        this.DbFields.add(this.AssignedTo);
        this.DbFields.add(this.CaseClient);
        this.DbFields.add(this.BillingContact);
        this.DbFields.add(this.InternalNo);
        this.DbFields.add(this.ApplyNo);
        this.DbFields.add(this.ApplyDate);
        this.DbFields.add(this.IssueDate);
        this.DbFields.add(this.IssueNo);
        this.DbFields.add(this.ClientContect);
        this.DbFields.add(this.InvoiceStatus);
        
        this.DbFields.add(this.Client);

        this.DbFields.add(this.ClientName);

        this.DbFields.add(this.InvoiceType);

        this.DbFields.add(this.PaymentTerm);

        this.DbFields.add(this.AttorneyTitle);

        this.DbFields.add(this.InvoiceTitle);

        this.DbFields.add(this.InvoiceDate);

        this.DbFields.add(this.ArDate);

        this.DbFields.add(this.TotalTax);

        this.DbFields.add(this.TotalTax2);

        this.DbFields.add(this.TotalRequestPayNtdAmount);

        this.DbFields.add(this.TotalWriteOffAmount);

        this.DbFields.add(this.TotalDiscountAmount);
        
        this.DbFields.add(this.Title);
        
        this.DbFields.add(this.CaseNo);
        
        this.DbFields.add(this.Office);
        
        this.DbFields.add(this.SubType);
        
        this.DbFields.add(this.Matter);
        
        this.DbFields.add(this.ServiceFee);
        
        this.DbFields.add(this.GovFee);
        
        this.DbFields.add(this.InvoiceNo);

        this.DbFields.add(this.CaseType);

        this.DbFields.add(this.InCharge);

        this.DbFields.add(this.VoucherDate);

        this.DbFields.add(this.BillDate);

        this.DbFields.add(this.Note);
        
        this.DbFields.add(this.TaskDescription);

        this.DbFields.add(this.TotalAmountDeductTTax2);
        
        this.DbFields.add(this.ServiceFeeDeductTTax2);
        
        this.DbFields.add(this.TaskCreator);
        
        this.DbFields.add(this.TrademarkClassification);
        
        this.DbFields.add(this.RegisterNo);
        
        this.DbFields.add(this.TotalUntaxedAmount);
        
        this.DbFields.add(this.ServiceProjectCode);

        this.DbFields.add(this.InvoiceMonth);

        this.DbFields.add(this.FreeServiceNumberOfMonth);

        this.DbFields.add(this.TwdHourlyCharge);

        this.DbFields.add(this.RegisteredNo);

        this.DbFields.add(this.InvoiceNumber);

        this.DbFields.add(this.ReceiptNumber);

        this.DbFields.add(this.TwdDeductionAmount);

        this.DbFields.add(this.TotalAmountAfterDiscount);

        this.DbFields.add(this.TimesheetMerge);

        this.DbFields.add(this.MultiTodos);

        this.DbFields.add(this.AttorneyFeeNtd);
        
        this.DbFields.add(this.IndependentClaim);
        
        this.DbFields.add(this.DependentClaim);
        
        this.DbFields.add(this.GovFeeAmount);
        
        this.DbFields.add(this.ServiceFeeAmount);
        
        this.DbFields.add(this.AttorneyFee);
        
        this.DbFields.add(this.AccountReceivableDay);
    }
    
    
    public String printHiddenTags(){
    	String rtnString = super.printHiddenTags();
    	HashMap<String,String> hm = new HashMap<String,String>();
    	hm.put("doWriteOffFlag",Cnstnts.EMPTY_STRING);
    	hm.put("arWriteOffLogKey",Cnstnts.EMPTY_STRING);
    	hm.put("getTitleType",Cnstnts.EMPTY_STRING);
    	rtnString += new HiddenTag().print(hm);
  	  	return rtnString;
    }

	public String getPrintBtn() throws Exception {
		if (this.onBtnSubmit()){
			if(this.getOutputFile().trim().length() > 0){
				return Html.getPrintBtn(this.getOutputFile(), this.getUserInfo());
			}
		} 
		return Cnstnts.EMPTY_STRING;
	}
    

	public String printHtmlBody() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine + "<table id='bodyTable' " + this.getTableBgcolor() + ">";

		
		if (this.onSearchMode()) {
			//rtnString += this.printHtml(this.FlowKey);
//			rtnString += this.FlowKey.printHiddenTag();
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
			//rtnString += this.printFlowKey();
			rtnString += this.FlowKey.printHiddenTag();
			Date date = new Date();
			rtnString += this.printMaintainTable();
			////System.out.println("====1 " + (new Date().getTime()-date.getTime()));
			date = new Date();
			
			rtnString += this.printTabAreaHtml();
			////System.out.println("====2 " + (new Date().getTime()-date.getTime()));
			date = new Date();
		}
		rtnString += newLine + "</table>";
		if (this.onSearchMode()) {
			rtnString += this.printSearchReasult();
		}
		return rtnString;
	}

    public List<SelectItem> getDocList(String ProgramId, String pageMode) throws Exception {
		String SQL = "select SampleDocument as FlowKey, Names from ReportDefine "
				+ "where ReportProgramId='"+ProgramId+"' "
						+ "and flowkey not like 'Multi%' "
						+ "order by flowkey ";
		return this.getDbUtil().getSelectItemList(SQL, "FlowKey" , "Names");
	}
    
    public List<SelectItem> getDocListForSearch(String ProgramId) throws Exception {
    	String flowKeyPrefix = "Multi";
		String SQL = "select SampleDocument as FlowKey, Names from ReportDefine "
				+ "where ReportProgramId='"+ProgramId+"' "
						+ "and flowkey like '" + flowKeyPrefix + "%' "
						+ "order by flowkey ";
		return this.getDbUtil().getSelectItemList(SQL, "FlowKey" , "Names");
	}
	
	public String getSubmitBtn() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		
		List<SelectItem> sampleDocs = null;
		if(this.getPageActionMode().equals(Cnstnts.SEARCH)) {
			sampleDocs = this.getDocListForSearch(this.getProgramId());
		}
		else if(this.getDbActionMode().equals(Cnstnts.PRINT) && this.getPageActionMode().equals(Cnstnts.MAINTAIN)) {
			sampleDocs = this.getDocList(this.getProgramId(), this.getPageActionMode());
		}
		
		if(sampleDocs == null || sampleDocs.size()==0){
//			return Cnstnts.EMPTY_STRING;
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
			//搜尋模式要有套印按鈕
			if (Cnstnts.SEARCH.equals(this.getPageActionMode())) {
				String btn = "<input type='button' style='cursor: hand' "
						+ "value='" + this.getUserInfo().getMsg("jsp.common.submit") + "' "
						+ "onClick='this.disabled=true;document.input.doPrint.value=true;setSubmitValue(\""
						+ Cnstnts.PRINT + "\")'/>";
				rtnString += btn;
				rtnString += "<input type='hidden' name='doPrint' id='doPrint'>";
			}
		}

		//因為查詢列表直接用update模式進來
		//如果權限只有開查詢的話，會造成暫存按鈕還是出現，因為以為是update
		//所以要重新設定模式

		if(this.getProgramId().startsWith("jsp.changePwd")) {
			this.setDbActionMode(Cnstnts.UPDATE);
		}
		else {
			if(!this.getUserInfo().hasPrivilege(this.getProgramId(), this.getDbActionMode())) {
				this.setDbActionMode(Cnstnts.QUERY);
			}
		}
		if (this.canSubmit()) {
			if (!this.getApplicant().equals(this.getUserInfo().getAttribute("emp_id"))) {
				if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
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
				if (Cnstnts.DELETE.equals(this.getUserInfo())) {
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
			rtnString += Html.getSubmitBtn(this.getUserInfo(), this.getDbActionMode());
		}
		return rtnString;
	}

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.TimesheetMerge.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        	
            this.CaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.CaseNo.setColspan(1);
            this.CaseNo.setAnotherField(this.TimesheetMerge);
            rtnString += this.printHtml(this.CaseNo);
            
            /*
        	 * “案件中類(SubType)”欄位選項為通用類別中PatentType、TradeMarkType、SubType的下階層項目，
        	 * 而當“案件種類”有選擇時，則“案件中類”欄位選單選項則會依照所選擇之“案件種類”而顯示該案件種類對應的選項。
        	 */
            this.SubType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            Category category = new Category();
    		List<SelectItem> ipTypeItems = new ArrayList<SelectItem>();
    		ipTypeItems.add(new SelectItem("P", "專利案件"));
    		ipTypeItems.add(new SelectItem("T", "商標案件"));
    		ipTypeItems.add(new SelectItem("L", "法律案件"));
    		ipTypeItems.add(new SelectItem("C", "著作權案件"));
    		
        	this.IpType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.IpType.setSelectList(ipTypeItems);
        	this.IpType.setColspan(3);
        	this.IpType.setOnChange("document.input.doSearchFlag.value=\"true\";setValue();");
        	
        	this.Matter.setColspan(3);
        	
            /*
             * “案件性質(Matter)”欄位之下拉選單選項當沒有選擇任何“案件種類”時則是顯示“專利案件”、
             * “商標案件”、“法律案件”個別的“案件性質”“三種案件”是從“專利程序設定檔”抓取選項；
             * 若有選擇“案件種類”則此“案件性質”就依據所選擇之“案件種類”顯示該種類的“案件狀態”。
             */
            List<SelectItem> items = new ArrayList<SelectItem>();
            if(Util.isEmpty(this.IpType.getValue())) {
            	String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig";
            	items.addAll(DbUtil.getSelectItemList(sql,"MatterName"));
            	
            	this.SubType.setSelectList(null);
            	
            	this.Office.setSelectList(null);
            }
            else {
            	if (this.getIpType().equals("P")) {
    				String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig where casekind ='STC01'";
    				this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    				items = DbUtil.getSelectItemList(sql, "MatterName");
                	
    				this.SubType.setSelectList(new Category().getChildList("PatentType"));
    				this.SubType.setAliasName(this.getUserInfo().getMsg("jsp.ToDosQuery.PatentType"));
    			} else if (this.getIpType().equals("T")) {
    				String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig where casekind ='STC02'";
    				this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    				items = DbUtil.getSelectItemList(sql, "MatterName");
                	
    				this.SubType.setSelectList(new Category().getChildList("TrademarkType"));
    				this.SubType.setAliasName(this.getUserInfo().getMsg("jsp.ToDosQuery.TrademarkType"));
                	
    			} else if (this.getIpType().equals("L")) {
    				String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig where casekind ='STC03'";
    				this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    				items = DbUtil.getSelectItemList(sql, "MatterName");
                	
    				this.SubType.setSelectList(new Category().getChildList("MainType"));
    				this.SubType.setAliasName(this.getUserInfo().getMsg("jsp.ToDosQuery.MainType"));

    			}
    			else if (this.getIpType().equals("C")) {
    				String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig where casekind ='STC04'";
    				this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    				items = DbUtil.getSelectItemList(sql, "MatterName");
                	
    				this.SubType.setSelectList(new Category().getChildList("CopyrightMainType"));
    				this.SubType.setAliasName(this.getUserInfo().getMsg("jsp.ToDosQuery.MainType"));
    			}
            	
            	this.IpType.setColspan(1);
            	this.IpType.setAnotherField(this.SubType);
            	
            	this.Matter.setColspan(1);
            	this.Matter.setAnotherField(this.Office);
            }
            
            rtnString += this.printHtml(this.IpType);
            
        	this.Office.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.Office.setSelectList(new Category().getChildList("PatentOffice"));
            
            this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Matter.setSelectList(items);
            rtnString += this.printHtml(this.Matter);
            
        	this.ApplyNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Title.setAnotherField(this.ApplyNo);
            this.Title.setColspan(1);
            rtnString += this.printHtml(this.Title);
            
        	this.ClientName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ClientName.setCheckEmpty(false);
            
            this.Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Client.setAnotherField(this.ClientName);
            this.Client.setColspan(1);
            this.Client.setCheckEmpty(false);
            rtnString += this.printHtml(this.Client);
            
            this.ReceiptNumber.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.InvoiceTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceTitle.setAnotherField(this.ReceiptNumber);
            this.InvoiceTitle.setColspan(1);
            rtnString += this.printHtml(this.InvoiceTitle);
            
            this.AttorneyBillNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AttorneyBillNo.setLength(200);
            
            this.InvoiceType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.InvoiceType.setSelectList(new Category().getChildList(this.InvoiceType));
            
            this.InvoiceNoTo.setCanEdit(true);
            this.InvoiceNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceNo.setAfterText(" ~ " + Html.printTag(this.InvoiceNoTo, this.getUserInfo()));
            this.InvoiceNo.setColspan(1);
            this.InvoiceNo.setAnotherField(this.AttorneyBillNo);
            rtnString += this.printHtml(this.InvoiceNo);
            
            this.InvoiceStatus.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.InvoiceStatus.setSelectList(new Category().getChildList(this.InvoiceStatus));
            
            this.TaskDescription.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TaskDescription.setAnotherField(this.InvoiceStatus);
            this.TaskDescription.setColspan(1);
            this.TaskDescription.setLength(250);
            rtnString += this.printHtml(this.TaskDescription);

            this.TaskCreator.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.TaskCreator.setSelectList(new Employee().getList());
            
            this.AttorneyTitle.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.AttorneyTitle.setSelectList(new Category().getChildList(this.AttorneyTitle));
            this.AttorneyTitle.setAnotherField(this.TaskCreator);
            this.AttorneyTitle.setColspan(1);
            rtnString += this.printHtml(this.AttorneyTitle);
            
            this.ArDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ArDateTo.setCanEdit(true);
            
            this.ArDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ArDate.setAfterText(this.getAlias(this.ArDateTo) + 
        			Html.printTag(this.ArDateTo, this.getUserInfo()));
            this.ArDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1"));
            this.ArDate.setButtonClick("addMonthToDate(0, \"arDate\");addMonthToDate(1, \"arDateTo\");");
            
            this.ArDate.setSecondButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2"));
            this.ArDate.setSecondButtonClick("addMonthToDate(0, \"arDate\");addMonthToDate(3, \"arDateTo\");");
            
            this.InvoiceDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.InvoiceDateTo.setCanEdit(true);
            
            this.InvoiceDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.InvoiceDate.setAnotherField(this.ArDate);
            this.InvoiceDate.setColspan(1);
            this.InvoiceDate.setAfterText(this.getAlias(this.InvoiceDateTo) + 
        			Html.printTag(this.InvoiceDateTo, this.getUserInfo()));
            this.InvoiceDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1"));
            this.InvoiceDate.setButtonClick("addMonthToDate(0, \"invoiceDate\");addMonthToDate(1, \"invoiceDateTo\");");
            
            this.InvoiceDate.setSecondButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2"));
            this.InvoiceDate.setSecondButtonClick("addMonthToDate(0, \"invoiceDate\");addMonthToDate(3, \"invoiceDateTo\");");
            rtnString += this.printHtml(this.InvoiceDate);

            this.NotYetWriteOff.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            
            this.VoucherDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.VoucherDateTo.setCanEdit(true);
            
            this.VoucherDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.VoucherDate.setAnotherField(this.NotYetWriteOff);
            this.VoucherDate.setColspan(1);
            this.VoucherDate.setAfterText(this.getAlias(this.VoucherDateTo) + 
        			Html.printTag(this.VoucherDateTo, this.getUserInfo()));
            this.VoucherDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1"));
            this.VoucherDate.setButtonClick("addMonthToDate(0, \"voucherDate\");addMonthToDate(1, \"voucherDateTo\");");
            
            this.VoucherDate.setSecondButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2"));
            this.VoucherDate.setSecondButtonClick("addMonthToDate(0, \"voucherDate\");addMonthToDate(3, \"voucherDateTo\");");
            rtnString += this.printHtml(this.VoucherDate);
            
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {  
        	Category category = new Category();
        	
        	
        	rtnString += "<input type='hidden' name='entity' id='entity'>";
        	rtnString += this.TimesheetMerge.printHiddenTag();
        	rtnString += this.MultiTodos.printHiddenTag();
        	rtnString += this.SoKey.printHiddenTag();

            String sql = Cnstnts.EMPTY_STRING;

            SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
            if(Util.isEmpty(VoucherDate.getValue())) {
            	VoucherDate.setValue(Util.getDate());
            }
            this.VoucherDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.VoucherDate.setNextFocusId(this.InvoiceNo.getTagName());
            this.VoucherDate.setColspan(3);
            rtnString += this.printHtml(this.VoucherDate);
            
            /*
1. 單據編號 編碼規則異動：INV-20131024-01 日期部分取用單據日期 後面-nn  一樣是取該日期下前個號碼+1  
點 產生單據編號扭 若 單據日期尚未輸入要出現提醒視窗
             */
            
            /* 20200530
             請款單	維護模式   產生單據編號按鈕的給號規則：INV-YYYYMMDD-nnnn(四碼流水號，每天歸零)
             */
            if(Util.compareTo(this.getCreateInvoiceNoFlag(), "true")) {
            	
            	if(Util.isEmpty(this.getVoucherDate())) {
            		this.setJavascriptCode("alert('" +this.getUserInfo().getMsg("jsp.Invoice.InvoiceNoError2") + "')");
            	}
            	else {
            		String date = this.getVoucherDate().replaceAll(Util.defaultConnectChar, "");
            		String sql2 = "select max(InvoiceNo) as InvoiceNo from invoice " +
            				"where InvoiceNo like '" + "INV-" + date + "-%' " +
            				"and LENGTH(InvoiceNo) = 17 ";
            		int max = 1;
            		try {
            			String InvoiceNo = this.getDbUtil().getFieldValue(sql2, "InvoiceNo");
            			max = Integer.parseInt(InvoiceNo.substring(InvoiceNo.length()-4)) + 1;
            		}
            		catch(Exception e) {}
	            	
	            	this.InvoiceNo.setValue("INV-" + date + "-" + String.format("%04d", max));
            	}
            	
            }
            
            this.InvoiceStatus.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.InvoiceStatus.setSelectList(category.getChildList(this.InvoiceStatus));
            
	        rtnString += "<input type='hidden' name='createInvoiceNoFlag' id='createInvoiceNoFlag'>";
	        String btn = "<input value='" + this.getUserInfo().getMsg("jsp.Invoice.CreateInvoiceNo") + "' type='button' " +
	        		//"onclick='document.input.createInvoiceNoFlag.value=\"true\";setValue();'>";    
	        		"onclick='createInvoiceNo();'>";
	        this.InvoiceNo.setAfterText(btn);

            this.InvoiceNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceNo.setColspan(1);
            this.InvoiceNo.setAnotherField(this.InvoiceStatus);
            this.InvoiceNo.setWidth(" width='15%' ");
            this.InvoiceNo.setNextFocusId(this.AttorneyTitle.getTagName());
            rtnString += this.printHtml(this.InvoiceNo);
            
            rtnString += "<script>setFocus('voucherDate');</script>";
            
            /*
            當單據類別(1)選擇收據時，
            此時單據抬頭(2)的子項目只能有Atitle01-翼勝專利商標事務所、Atitle04-Essen Patent and Trademark Office可做選擇。 
            而此時的收據編碼(3.)要成為必填項目。
            套印(4.)只能有 請款單-翼勝事務所、Invoice-Essen Office、收據-台灣客戶TW案、收據-國外客戶TW案、Letter-翼勝事務所可做選擇。
            
			當單據類別(1)選擇發票時，此時單據抬頭(2)的子項目只能有ATitle02-翼勝智慧資產管理有限公司
			套印(3.)只能有請款單-翼勝公司可供選擇。
			
			當單據類別(1)選擇Invoice時，此時單據抬頭(2)的子項目只能有ATitle03-Essen Intellectual Capital Management Co., Ltd.
			套印(3.)只能有Invoice-Essen供選擇。
        	 */
            this.ReceiptNumber.setCheckEmpty(false);
            List<SelectItem> items = category.getChildList(this.AttorneyTitle);

            this.AttorneyTitle.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.AttorneyTitle.setSelectList(items);
            this.AttorneyTitle.setNextFocusId(this.TaskDescription.getTagName());
            this.AttorneyTitle.setColspan(3);
            this.AttorneyTitle.setStyle("width:380px;");
            this.AttorneyTitle.setOnChange("setValue()");
            rtnString += this.printHtml(this.AttorneyTitle);
            
            this.InvoiceType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.InvoiceType.setSelectList(category.getChildList(this.InvoiceType));
            this.InvoiceType.setSize(30);
            this.InvoiceType.setAnotherField(this.AttorneyTitle);
            this.InvoiceType.setColspan(1);
            this.InvoiceType.setOnChange("setValue()");
//            rtnString += this.printHtml(this.InvoiceType);
            
            Date date = new Date();
            String clientName = Cnstnts.EMPTY_STRING;
            if(this.Client.getValue().trim().length()>0){
            	String sql2 = "select firm as name from attorney where flowkey = '" + this.Client.getValue() + "' " +
            				"union " +
            				"select CompanyName as name from client where flowkey = '" + this.Client.getValue() + "' " ;
            	clientName = this.getDbUtil().getFieldValue(sql2, "name");
            	//clientName = new Client(this.Client.getValue()).getCompanyName();
            	
            }
            ////System.out.println("===11 " + (new Date().getTime() - date.getTime()));
            date = new Date();
            
            this.ClientName.setValue(clientName);
        	this.ClientName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ClientName.setSize(30);
        	this.ClientName.setReadonly(true);
        	this.ClientName.setCheckEmpty(true);
        	if(this.canEdit()){
            	if(this.getDbActionMode().equals(Cnstnts.INSERT) 
            			|| (this.getDbActionMode().equals(Cnstnts.UPDATE))){
            		this.ClientName.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.SearchClient"));
            		this.ClientName.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=InvoiceClient\",\"Client\",800,600)");
            	}
            }
            //多了報價單代理人機制，所以要多放一個代理人資料進來
        	List<SelectItem> item = new Client().getList();
        	item.addAll(new Attorney().getList());
            this.Client.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
            this.Client.setAnotherField(this.ClientName);
        	this.Client.setSelectList(item);
            this.Client.setAutocompleteLabelFieldId(this.ClientName.getTagName());
            this.Client.setOnChange("setValue()");
            this.Client.setColspan(1);
        	this.Client.setCheckEmpty(true);
            rtnString += this.printHtml(this.Client);
            
            ////System.out.println("===12 " + (new Date().getTime() - date.getTime()));
            date = new Date();
            
//            this.Title2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.Title2.setLength(15);
//            rtnString += this.printHtml(this.Title2);
            
            this.RegisteredNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            /*
             * 將該案的客戶資料中的發票抬頭1或發票抬頭2資訊帶入
             */
            String btn1 = "<input type='button' style='cursor: hand' " + 
			   "value='"+this.getUserInfo().getMsg("jsp.Invoice.GetTitle1")+"' "+
			   "onClick='document.input.getTitleType.value=\"getTitle1\";setValue();'/>";
            String btn2 = "<input type='button' style='cursor: hand' " + 
			   "value='"+this.getUserInfo().getMsg("jsp.Invoice.GetTitle2")+"' "+
			   "onClick='document.input.getTitleType.value=\"getTitle2\";setValue();'/>";
            if(Util.compareTo(this.getgetTitleType(), "getTitle1") && !Util.isEmpty(this.getClient())) {
            	Client client = new Client(this.getClient());
            	this.InvoiceTitle.setValue(client.getInvoiceTitle1());
            }
            else if(Util.compareTo(this.getgetTitleType(), "getTitle2") && !Util.isEmpty(this.getClient())) {
            	Client client = new Client(this.getClient());
            	this.InvoiceTitle.setValue(client.getInvoiceTitle2());
            }
            
            ////System.out.println("===13 " + (new Date().getTime() - date.getTime()));
            date = new Date();
            
            if(Util.isEmpty(this.getInvoiceTitle()) && 
            		(this.getDbActionMode().equals(Cnstnts.UPDATE) || this.getDbActionMode().equals(Cnstnts.INSERT)) ) {
            	this.InvoiceTitle.setValue(this.getClientName());
            }
            
            this.InvoiceTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceTitle.setSize(70);
            this.InvoiceTitle.setAnotherField(this.RegisteredNo);
//            if(this.getDbActionMode().equals(Cnstnts.UPDATE)) {
//            	this.InvoiceTitle.setAfterText(btn1 + btn2);
//            }
            rtnString += this.printHtml(this.InvoiceTitle);
            
            this.TaskDescription.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TaskDescription.setSize(70);
            this.TaskDescription.setLength(250);
            if(Util.compareTo(this.getAttorneyTitle(), "ATitle01") ||
        			Util.compareTo(this.getAttorneyTitle(), "ATitle04")) {
            	this.TaskDescription.setNextFocusId(this.ReceiptNumber.getTagName());
            }
            if(Util.compareTo(this.getAttorneyTitle(), "ATitle02")) {
            	this.TaskDescription.setNextFocusId(this.InvoiceNumber.getTagName());
            }
            rtnString += this.printHtml(this.TaskDescription);
            
            
            
            this.ArDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            rtnString += this.ArDate.printHiddenTag();
            //單據寄出日不用帶入當天
//            if(Util.isEmpty(InvoiceDate.getValue())) {
//            	InvoiceDate.setValue(Util.getDate());
//            }
            this.InvoiceDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.InvoiceDate.setAnotherField(this.ArDate);
            this.InvoiceDate.setColspan(1);
            rtnString += this.InvoiceDate.printHiddenTag();
//            rtnString += this.printHtml(this.InvoiceDate);
            
            
            
            ////System.out.println("===14 " + (new Date().getTime() - date.getTime()));
            date = new Date();
            
            this.BillDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.BillDate.setAnotherField(this.InvoiceStatus);
            this.BillDate.setColspan(1);
            rtnString += this.BillDate.printHiddenTag();
            //rtnString += this.printHtml(this.BillDate);
            
            rtnString += "<input type='hidden' name='genReceiptNumberFlag' id='genReceiptNumberFlag'>";
            //規則為民國年加四碼流水號 流水號從系統中最大的值加1去編 如 1020543 系統中原流水號為三碼新的編碼要改四碼
        	this.ReceiptNumber.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ReceiptNumber.setAfterText("<input type='button' value='" + 
        			this.getUserInfo().getMsg("jsp.Invoice.GetReceiptNumber") + "' " +
        			"onclick='document.input.genReceiptNumberFlag.value=true;setValue();'>");
        	if(Util.compareTo(this.getGenReceiptNumberFlag(), "true")) {
        		this.ReceiptNumber.setValue(generateCaseNo());
        	}
        	
            this.InvoiceNumber.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceNumber.setAnotherField(this.ReceiptNumber);
            this.InvoiceNumber.setColspan(1);
            rtnString += this.printHtml(this.InvoiceNumber);
            
            //System.out.println("===110 " + (new Date().getTime() - date.getTime()));
            date = new Date();
        	
            //未稅金額 2014/4/27
            //當明細的 AccountTile=AccountTile01將該筆明細同科目的NotIncludeTaxAmount總和帶入 master的GovFeeAmount  (代收政府規費金額)
            sql = "select " + DB.SQL_IFNULL + "(sum(NotIncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
            		"and accounttitle = 'AccountTitle01'";
            
            String govFeeAmount = "0";
            govFeeAmount = this.getDbUtil().getFieldValue(sql, "count");
        	
        	this.GovFeeAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.GovFeeAmount.setValue(Util.round(Util.stringToDouble(govFeeAmount), 2)+"");
        	
        	////System.out.println("===111 " + (new Date().getTime() - date.getTime()));
            date = new Date();
        	
        	sql = "select i.invoiceCurrency as currency from InvoiceDetail i " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and i.accounttitle = 'AccountTitle01' " +
		    		"and i.invoiceCurrency != ''";
            this.GovFeeCurrency.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.GovFeeCurrency.setSelectList(category.getChildList("Currency"));
        	this.GovFeeCurrency.setValue(this.getDbUtil().getFieldValue(sql, "currency"));
            
        	////System.out.println("===112 " + (new Date().getTime() - date.getTime()));
            date = new Date();
        	
        	//當明細的 AccountTile=AccountTile01將該筆明細同科目的TwdAmount總和帶入 master的GovFee (代收政府規費台幣總額)
    		sql = "select " + DB.SQL_IFNULL + "(sum(round(NotIncludeTaxAmount*ExchangeRate,2)),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
    		"and accounttitle = 'AccountTitle01'";
     
    		String govFee = "0";
    		govFee = this.getDbUtil().getFieldValue(sql, "count");
        	
            this.GovFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.GovFee.setValue((int)Util.round(Util.stringToDouble(govFee), 0)+"");
            
        	this.GovFeeAmount.setAnotherField(this.GovFee);
        	this.GovFeeAmount.setBeforeText(this.GovFeeCurrency.getValue());
//            rtnString += this.printHtml(this.GovFeeAmount);
        	

        	rtnString += "<tr bgcolor='#E9EDF4'>" +
        			"<td align='right' width='20%'>" + this.getAlias(this.GovFeeAmount) + "</td>" +
        			"<td>&nbsp;&nbsp;" + (Util.isEmpty(this.GovFeeCurrency.getValue())?"　 　":this.GovFeeCurrency.getValue()) + 
        				"<input title='" + this.convertMoneyFormat(this.GovFeeAmount.getValue(), this.GovFeeCurrency.getValue()) + "' type='text' size='20' maxlength='50' " +
        					"id='" + this.GovFeeAmount.getTagName() + "' " +
        					"name='" + this.GovFeeAmount.getTagName() + "' " +
        					"value='" + this.convertMoneyFormat(this.GovFeeAmount.getValue(), this.GovFeeCurrency.getValue()) + "' readonly=''></td>" +
        			"<td align='right' width='16%'>&nbsp;</td>" +
        			"<td>&nbsp;&nbsp;NTD" +
        			"<input title='" + this.convertMoneyFormat(this.GovFee.getValue(), "NTD") + "' type='text' size='20' maxlength='50' " +
        					"id='" + this.GovFee.getTagName() + "' " +
        					"name='" + this.GovFee.getTagName() + "' " +
        					"value='" + this.convertMoneyFormat(this.GovFee.getValue(), "NTD") + "' readonly=''></td>" +
        			"</tr>";
        	
//        	rtnString += "<tr bgcolor='#E9EDF4'>" +
//        			"<td align='right' width='20%'>" + this.getAlias(this.GovFeeAmount) + 
//        			"</td><td colspan='3'><table width='100%' style='table-layout:fixed'><tr>" + 
//        			"<td width='7%'>&nbsp;" + this.GovFeeCurrency.getValue() + "</td>" +  
//        			"<td width='43%'>" + 
//        				"<input title='" + this.GovFeeAmount.getValue() + "' type='text' size='20' maxlength='50' " +
//        				"id='" + this.GovFeeAmount.getTagName() + "' " +
//        				"name='" + this.GovFeeAmount.getTagName() + "' " +
//        				"value='" + this.GovFeeAmount.getValue() + "' readonly=''>" + "</td>" + 
//        			"<td width='7%'>NTD</td>" +
//        			"<td width='43%'>" + 
//        				"<input title='" + this.GovFee.getValue() + "' type='text' size='20' maxlength='50' " +
//        				"id='" + this.GovFee.getTagName() + "' " +
//        				"name='" + this.GovFee.getTagName() + "' " +
//        				"value='" + this.GovFee.getValue() + "' readonly=''>" + "</td></tr></table>" +
//        			"</td></tr>";
            
        	//System.out.println("===113 " + (new Date().getTime() - date.getTime()));
            date = new Date();
            
            //未稅金額 2014/4/27
            //當明細的 AccountTile=AccountTile02將該筆明細同科目的NotIncludeTaxAmount總和帶入 master的AttorneyFee  (複代理費金額)
            sql = "select " + DB.SQL_IFNULL + "(sum(NotIncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
    		"and accounttitle = 'AccountTitle02'";

    		String attorneyFee = "0";
    		attorneyFee = this.getDbUtil().getFieldValue(sql, "count");
            
            this.AttorneyFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AttorneyFee.setValue(Util.round(Util.stringToDouble(attorneyFee), 2)+"");
            
            ////System.out.println("===114 " + (new Date().getTime() - date.getTime()));
            date = new Date();
            
            sql = "select i.invoiceCurrency as currency from InvoiceDetail i " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and i.accounttitle = 'AccountTitle02' " +
		    		"and i.invoiceCurrency != ''";
            this.AttorneyCurrency.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.AttorneyCurrency.setSelectList(category.getChildList("Currency"));
            this.AttorneyCurrency.setValue(this.getDbUtil().getFieldValue(sql, "currency"));
            
            //當明細的 AccountTile=AccountTile02將該筆明細同科目的TwdAmount總和帶入 master的AttorneyFeeNtd  (複代理費台幣金額) 
    		sql = "select " + DB.SQL_IFNULL + "(sum(round(NotIncludeTaxAmount*ExchangeRate,2)),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
    		"and accounttitle = 'AccountTitle02'";
     
    		String attorneyFeeNtd = "0";
    		attorneyFeeNtd = this.getDbUtil().getFieldValue(sql, "count");
            
            this.AttorneyFeeNtd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.AttorneyFeeNtd.setValue((int)Util.round(Util.stringToDouble(attorneyFeeNtd), 0)+"");
        	
        	this.AttorneyFee.setAnotherField(this.AttorneyCurrency);
        	this.AttorneyFee.setBeforeText(this.AttorneyCurrency.getValue());
            //rtnString += this.printHtml(this.AttorneyFee);
        	
        	rtnString += "<tr bgcolor='#E9EDF4'>" +
        			"<td align='right' width='20%'>" + this.getAlias(this.AttorneyFee) + "</td>" +
        			"<td>&nbsp;&nbsp;" + (Util.isEmpty(this.AttorneyCurrency.getValue())?"　 　":this.AttorneyCurrency.getValue()) + 
        				"<input title='" + this.convertMoneyFormat(this.AttorneyFee.getValue(), this.AttorneyCurrency.getValue()) + "' type='text' size='20' maxlength='50' " +
        					"id='" + this.AttorneyFee.getTagName() + "' " +
        					"name='" + this.AttorneyFee.getTagName() + "' " +
        					"value='" + this.convertMoneyFormat(this.AttorneyFee.getValue(), this.AttorneyCurrency.getValue()) + "' readonly=''></td>" +
        			"<td align='right' width='16%'>&nbsp;</td>" +
        			"<td>&nbsp;&nbsp;NTD" +
        			"<input title='" + this.convertMoneyFormat(this.AttorneyFeeNtd.getValue(), "NTD") + "' type='text' size='20' maxlength='50' " +
        					"id='" + this.AttorneyFeeNtd.getTagName() + "' " +
        					"name='" + this.AttorneyFeeNtd.getTagName() + "' " +
        					"value='" + this.convertMoneyFormat(this.AttorneyFeeNtd.getValue(), "NTD") + "' readonly=''></td>" +
        			"</tr>";
        	
//        	rtnString += "<tr bgcolor='#E9EDF4'>" +
//        			"<td align='right' width='20%'>" + this.getAlias(this.AttorneyFee) + 
//        			"</td><td colspan='3'><table width='100%' style='table-layout:fixed'><tr>" + 
//        			"<td width='7%'>&nbsp;" + this.AttorneyCurrency.getValue() + "</td>" +  
//        			"<td width='43%'>" + 
//        				"<input title='" + this.AttorneyFee.getValue() + "' type='text' size='20' maxlength='50' " +
//        				"id='" + this.AttorneyFee.getTagName() + "' " +
//        				"name='" + this.AttorneyFee.getTagName() + "' " +
//        				"value='" + this.AttorneyFee.getValue() + "' readonly=''>" + "</td>" + 
//        			"<td width='7%'>NTD</td>" +
//        			"<td width='43%'>" + 
//        				"<input title='" + this.AttorneyFeeNtd.getValue() + "' type='text' size='20' maxlength='50' " +
//        				"id='" + this.AttorneyFeeNtd.getTagName() + "' " +
//        				"name='" + this.AttorneyFeeNtd.getTagName() + "' " +
//        				"value='" + this.AttorneyFeeNtd.getValue() + "' readonly=''>" + "</td></tr></table>" +
//        			"</td></tr>";
            
        	//未稅金額
            //當明細的 AccountTile=AccountTile03 將該筆明細同科目的NotIncludeTaxAmount總和帶入 master的ServiceFeeAmount  (服務費金額)
		    sql = "select " + DB.SQL_IFNULL + "(sum(NotIncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
					"and accounttitle = 'AccountTitle03'";
		    String serviceFeeAmount = "0";
		    serviceFeeAmount = this.getDbUtil().getFieldValue(sql, "count");
		    
		    ////System.out.println("===15 " + (new Date().getTime() - date.getTime()));
            date = new Date();
		    
            this.ServiceFeeAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ServiceFeeAmount.setValue(Util.round(Util.stringToDouble(serviceFeeAmount), 2)+"");
        	
        	sql = "select i.invoiceCurrency as currency from InvoiceDetail i " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and i.accounttitle = 'AccountTitle03' " +
		    		"and i.invoiceCurrency != ''";
            this.ServiceFeeCurrency.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.ServiceFeeCurrency.setSelectList(category.getChildList("Currency"));
        	this.ServiceFeeCurrency.setValue(this.getDbUtil().getFieldValue(sql, "currency"));
        	
        	////System.out.println("===16 " + (new Date().getTime() - date.getTime()));
            date = new Date();
            
            //未稅金額＊明細內”匯率”2014/4/27
        	//當明細的 AccountTile=AccountTile03 將該筆明細同科目的TwdAmount總和帶入 master的ServiceFee (服務費台幣總額)
        	sql = "select " + DB.SQL_IFNULL + "(sum(round(NotIncludeTaxAmount*ExchangeRate,2)),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
    				"and accounttitle = 'AccountTitle03' ";
        	String serviceFee = "0";
        	serviceFee = this.getDbUtil().getFieldValue(sql, "count");
        	
        	////System.out.println("===17 " + (new Date().getTime() - date.getTime()));
            date = new Date();
        	
            this.ServiceFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ServiceFee.setValue(serviceFee);
        	
        	this.ServiceFeeAmount.setAnotherField(this.ServiceFeeCurrency);
        	this.ServiceFeeAmount.setBeforeText(this.ServiceFeeCurrency.getValue());
            //rtnString += this.printHtml(this.ServiceFeeAmount);
        	

        	rtnString += "<tr bgcolor='#E9EDF4'>" +
        			"<td align='right' width='20%'>" + this.getAlias(this.ServiceFeeAmount) + "</td>" +
        			"<td>&nbsp;&nbsp;" + (Util.isEmpty(this.ServiceFeeCurrency.getValue())?"　 　":this.ServiceFeeCurrency.getValue()) + 
        				"<input title='" + this.convertMoneyFormat(this.ServiceFeeAmount.getValue(), this.ServiceFeeCurrency.getValue()) + "' type='text' size='20' maxlength='50' " +
        					"id='" + this.ServiceFeeAmount.getTagName() + "' " +
        					"name='" + this.ServiceFeeAmount.getTagName() + "' " +
        					"value='" + this.convertMoneyFormat(this.ServiceFeeAmount.getValue(), this.ServiceFeeCurrency.getValue()) + "' readonly=''></td>" +
        			"<td align='right' width='16%'>&nbsp;</td>" +
        			"<td>&nbsp;&nbsp;NTD" +
        			"<input title='" + this.convertMoneyFormat(this.ServiceFee.getValue(), "NTD") + "' type='text' size='20' maxlength='50' " +
        					"id='" + this.ServiceFee.getTagName() + "' " +
        					"name='" + this.ServiceFee.getTagName() + "' " +
        					"value='" + this.convertMoneyFormat(this.ServiceFee.getValue(), "NTD") + "' readonly=''></td>" +
        			"</tr>";
        	
//        	rtnString += "<table width='100%' style='table-layout:fixed'><tr>" + 
//        			"<td width='4%'>&nbsp;" + this.ServiceFeeCurrency.getValue() + "</td>" +  
//        			"<td width='46%'>" + 
//        				"<input title='" + this.ServiceFeeAmount.getValue() + "' type='text' size='20' maxlength='50' " +
//        				"id='" + this.ServiceFeeAmount.getTagName() + "' " +
//        				"name='" + this.ServiceFeeAmount.getTagName() + "' " +
//        				"value='" + this.ServiceFeeAmount.getValue() + "' readonly=''>" + "</td>" + 
//        			"<td width='3%'>NTD</td>" +
//        			"<td width='47%'>" + 
//        				"<input title='" + this.ServiceFee.getValue() + "' type='text' size='20' maxlength='50' " +
//        				"id='" + this.ServiceFee.getTagName() + "' " +
//        				"name='" + this.ServiceFee.getTagName() + "' " +
//        				"value='" + this.ServiceFee.getValue() + "' readonly=''>" + "</td></tr></table>" +
//        			"</td></tr>";
            //抓第一筆明細幣別當作預設幣別
        	sql = "select i.invoiceCurrency as currency from InvoiceDetail i " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and i.invoiceCurrency != '' order by i.flowkey ";
        	String currency = this.getDbUtil().getFieldValue(sql, "currency");
        	
        	sql = "select " + DB.SQL_IFNULL + "(sum(round(NotIncludeTaxAmount*ExchangeRate,2)),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
        			"and accounttitle in ('AccountTitle01', 'AccountTitle02', 'AccountTitle03')";
        	String TotalNotIncludeTaxAmountNtd = "0";
        	//TotalNotIncludeTaxAmountNtd = this.getDbUtil().getFieldValue(sql, "count");
        	TotalNotIncludeTaxAmountNtd = (Util.stringToInt(this.convertMoneyFormat(this.getGovFee(), "NTD")) +
        			Util.stringToInt(this.convertMoneyFormat(this.getServiceFee(), "NTD")) + 
        			Util.stringToInt(this.convertMoneyFormat(this.getAttorneyFeeNtd(), "NTD"))) + "";

        	this.TotalNotIncludeTaxAmountNtd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.TotalNotIncludeTaxAmountNtd.setBeforeText("&nbsp;&nbsp;NTD");
        	this.TotalNotIncludeTaxAmountNtd.setValue(this.convertMoneyFormat(TotalNotIncludeTaxAmountNtd, "NTD"));
        	
        	sql = "select " + DB.SQL_IFNULL + "(sum(NotIncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"'";
             
            String TotalNotIncludeTaxAmount = "0";
            TotalNotIncludeTaxAmount = this.getDbUtil().getFieldValue(sql, "count");
            		
            this.TotalNotIncludeTaxAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.TotalNotIncludeTaxAmount.setColspan(1);
            this.TotalNotIncludeTaxAmount.setAnotherField(this.TotalNotIncludeTaxAmountNtd);
        	this.TotalNotIncludeTaxAmount.setBeforeText("&nbsp;&nbsp;" + currency);
        	this.TotalNotIncludeTaxAmount.setValue(this.convertMoneyFormat(TotalNotIncludeTaxAmount, currency));
            rtnString += this.printHtml(this.TotalNotIncludeTaxAmount);
            
            sql = "select if(sum(Tax2) is null , 0 , sum(Tax2)) as count from InvoiceDetail where WithHolding='Y' and ParentId ='" + this.getFlowKey() + "'";
            String sum = this.getDbUtil().getFieldValue(sql,"count"); 
            this.TotalWithHolding.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalWithHolding.setCanEdit(false);
            this.TotalWithHolding.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");
            
            ////System.out.println("===18 " + (new Date().getTime() - date.getTime()));
            date = new Date();

            //當明細的TaxType稅別為10%執行業務所得(TaxT01)，將該筆明細同稅別的TaxAmount總和，帶入 master的TotalTax2（假設執行業務所得只有台灣有為台幣）  (執行業務所得稅總額)
            sql = "select if(sum(Tax2) is null , 0 , sum(Tax2)) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
    				"and TaxType = 'TaxT01'";
     
    		String totalTax2 = "0";
    		totalTax2 = this.getDbUtil().getFieldValue(sql, "count");
            
        	this.TotalTax2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.TotalTax2.setValue(this.convertMoneyFormat((int)Util.round(Util.stringToDouble(totalTax2), 0)+"", "NTD"));
        	this.TotalTax2.setBeforeText("&nbsp;&nbsp;NTD");
        	
        	////System.out.println("===19 " + (new Date().getTime() - date.getTime()));
            date = new Date();
        	
        	//當明細的TaxType稅別為10%執行業務所得(TaxT01)，將該筆明細同稅別的NotIncludeTaxAmount總和，帶入 master的ServiceFeeDeductTTax2  (服務費台幣扣繳後總額)
        	sql = "select " + DB.SQL_IFNULL + "(sum(NotIncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
    			"and TaxType = 'TaxT01' ";
        	String serviceFeeDeductTTax2 = "0";
        	serviceFeeDeductTTax2 = this.getDbUtil().getFieldValue(sql, "count");
        	
        	this.ServiceFeeDeductTTax2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ServiceFeeDeductTTax2.setValue((int)Util.round(Util.stringToDouble(serviceFeeDeductTTax2),0)+"");
        	
            

            
            
            //當明細的TaxType稅別為營業稅類別，將該筆明細同稅別的TaxAmount總和，帶入 master的TotalTax (營業稅總額)
    		sql = "select " + DB.SQL_IFNULL + "(sum(taxamount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
    		"and TaxType != 'TaxT01' and TaxType != ''";
     
    		String totalTax = "0";
    		totalTax = this.getDbUtil().getFieldValue(sql, "count");

            this.TotalTax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalTax.setValue(this.convertMoneyFormat((int)Util.round(Util.stringToDouble(totalTax), 0)+"", "NTD"));
            

            this.TotalTax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalTax.setAnotherField(TotalTax2);
            this.TotalTax.setColspan(1);
        	this.TotalTax.setBeforeText("&nbsp;&nbsp;NTD");
            rtnString += this.printHtml(this.TotalTax);
            
            sql = "select " + DB.SQL_IFNULL + "(sum(IncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"'";
            
            String TotalIncludeTaxAmount = "0";
            TotalIncludeTaxAmount = this.getDbUtil().getFieldValue(sql, "count");
            		
            this.TotalIncludeTaxAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.TotalIncludeTaxAmount.setColspan(3);
        	this.TotalIncludeTaxAmount.setBeforeText("&nbsp;&nbsp;" + currency);
        	this.TotalIncludeTaxAmount.setValue(this.convertMoneyFormat(Util.round(Util.stringToDouble(TotalIncludeTaxAmount), 2)+"", currency));
            rtnString += this.printHtml(this.TotalIncludeTaxAmount);

        	//請款單的預收金額欄位旁邊顯示：已收款未沖銷台幣總額 nnnnnn 元 (計算該客戶 收款管理中 可沖銷餘額 的總額）
            sql = "select " + DB.SQL_IFNULL + "(sum(WriteOffBalance),0) as count from ReceiptManage where Client = '"+this.getClient()+"' ";
    		String WriteOffBalance = "0";
    		WriteOffBalance = this.getDbUtil().getFieldValue(sql, "count");
    		
            //“預收金額”整數數字欄位(手key，幣別限定不可編輯)，"應收金額" 也是要新增的整數數字欄位 計算邏輯=本次請款總額-預收金額
            this.AmountReceipts.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AmountReceipts.setColspan(3);
        	this.AmountReceipts.setBeforeText("&nbsp;&nbsp;" + currency);
        	this.AmountReceipts.setAfterText(String.format("已收款未沖銷台幣總額 %s 元", WriteOffBalance));
        	this.AmountReceipts.setOnChange("setValue();");
        	this.AmountReceipts.setValue(this.convertMoneyFormat(this.getAmountReceipts(), currency));
            rtnString += this.printHtml(this.AmountReceipts);

            //janny 2014/5/6 這個錯誤 是 你畫面上應收金額的邏輯改一下就好了  未稅請款總額＋營業稅5%-預收金額 就好了
            String AmountReceivable = Util.round(
            		Util.stringToDouble(this.TotalNotIncludeTaxAmount.getValue()) +
            		Util.stringToDouble(this.TotalTax.getValue()) - 
            		Util.stringToDouble(this.AmountReceipts.getValue()),  2) + "";
            this.AmountReceivable.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AmountReceivable.setColspan(3);
        	this.AmountReceivable.setBeforeText("&nbsp;&nbsp;" + currency);
        	this.AmountReceivable.setValue(this.convertMoneyFormat(AmountReceivable, currency));
            rtnString += this.printHtml(this.AmountReceivable);
            
            //將所有明細的AlreadyWriteOffAmount總和，帶入master的TotalWriteOffAmount  (已沖銷總額)
    		sql = "select " + DB.SQL_IFNULL + "(sum(AlreadyWriteOffAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' ";
    		String totalWriteOffAmount = "0";
    		totalWriteOffAmount = this.getDbUtil().getFieldValue(sql, "count");
            
    		//計算條件：當已沖銷總額小於應收金額，算出當天日期與請款日期的天數差；若已沖銷總額大於等於應收金額，此欄位直接顯示0
    		this.AccountReceivableDay.setHtmlType(Cnstnts.HTML_TAG_TEXT);
    		BigDecimal b1 = new BigDecimal(totalWriteOffAmount);
    		BigDecimal b2 = new BigDecimal(AmountReceivable);
    		if(b1.compareTo(b2) < 0) {
    			this.AccountReceivableDay.setValue(Util.getDiffDate(Util.toDate(this.getVoucherDate(), "yyyy-MM-dd"), Util.toDate(Util.getDate(), "yyyy-MM-dd")) + "");
    		}
    		else {
    			this.AccountReceivableDay.setValue("0");
    		}
    		
    		
            this.TotalWriteOffAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.TotalWriteOffAmount.setValue((int)Util.round(Util.stringToDouble(totalWriteOffAmount), 0)+"");
            this.TotalWriteOffAmount.setColspan(1);
            this.TotalWriteOffAmount.setAnotherField(AccountReceivableDay);
        	this.TotalWriteOffAmount.setBeforeText("&nbsp;&nbsp;NTD");
        	this.TotalWriteOffAmount.setValue(this.convertMoneyFormat(totalWriteOffAmount, "NTD"));
            rtnString += this.printHtml(this.TotalWriteOffAmount);
            
        	//將所有明細的DiscountAmount總和，帶入master的TotalDiscountAmount  (折扣加收總額)
    		sql = "select " + DB.SQL_IFNULL + "(sum(DiscountAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' ";
     
    		String totalDiscountAmount = "0";
    		totalDiscountAmount = this.getDbUtil().getFieldValue(sql, "count");
        	
            this.TotalDiscountAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalDiscountAmount.setAnotherField(this.TotalWriteOffAmount);
        	this.TotalDiscountAmount.setValue((int)Util.round(Util.stringToDouble(totalDiscountAmount), 0)+"");
            //rtnString += this.printHtml(this.TotalDiscountAmount);
        	
        	rtnString += this.TotalDiscountAmount.printHiddenTag();
        	rtnString += this.TotalWriteOffAmount.printHiddenTag();

            //當明細的TaxType稅別為營業稅類別，將該筆明細同稅別的NotIncludeTaxAmount總和，帶入 master的TotalUntaxedAmount  (營業稅未稅總額)
    		sql = "select " + DB.SQL_IFNULL + "(sum(NotIncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
    		"and TaxType != 'TaxT01' and TaxType != ''";
     
    		String totalUntaxedAmount = "0";
    		totalUntaxedAmount = this.getDbUtil().getFieldValue(sql, "count");
            
            int TotalUntaxedAmount = (int)Util.round(Util.stringToDouble(totalUntaxedAmount), 0);
            this.TotalUntaxedAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalUntaxedAmount.setValue(TotalUntaxedAmount+"");
            
            //將所有明細的TwdAmount總和，帶入master的TotalRequestPayNtdAmount  (請款台幣總額)
            //請款單mster 欄位 請款台幣總額 計算邏輯（原為：所有明細的TwdAmount總和）增加一個判斷是當明細任一選 
            //台灣營業稅 5% 則， 請款台幣總額 計算式改為：明細所有"含稅金額"(IncludeTaxAmount)的總額
            sql = "select count(1) as count from invoicedetail " +
            		"where parentId = '"+this.getFlowKey()+"' " +
            		"and TaxType = 'TaxT02'";
            int count2 = this.getDbUtil().getSqlIntValue(sql, "count");
            if(count2 > 0) {
            	sql = "select " + DB.SQL_IFNULL + "(sum(IncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' ";
            }
            else {
            	sql = "select " + DB.SQL_IFNULL + "(sum(TwdAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' ";
            }
     
    		String totalRequestPayNtdAmount = "0";
    		totalRequestPayNtdAmount = this.getDbUtil().getFieldValue(sql, "count");
    		if(count2 > 0) {
    			totalRequestPayNtdAmount = ((int)Util.round(Util.stringToDouble(totalRequestPayNtdAmount), 0)) + "";
    		}
            
            //TotalAmountDeductTTax2 value="請款台幣扣繳後總額"  = TotalRequestPayNtdAmount - TotalTax2
    		String totalAmountDeductTTax2 = "0";
    		totalAmountDeductTTax2 = Util.stringToDouble(totalRequestPayNtdAmount) - Util.stringToDouble(totalTax2) + "";
            
        	this.TotalAmountDeductTTax2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalAmountDeductTTax2.setValue((int)Util.round(Util.stringToDouble(totalAmountDeductTTax2),0)+"");
            
            		
            
            
            if(!Util.isEmpty(this.getServiceProjectCode())) {
            rtnString += "<tr bgcolor='#E9EDF4'><td colspan='4' align='center'>" +
            		"------------------------------" + this.getUserInfo().getMsg("jsp.Invoice.ServiceCodeField") + "------------------------------" + 
            		"</td></tr>";
            
            this.ServiceProjectCode.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ServiceProjectCode);
            
            this.FreeServiceNumberOfMonth.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.FreeServiceNumberOfMonth.setSize(10);
            this.FreeServiceNumberOfMonth.setLength(10);
            
            this.InvoiceMonth.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceMonth.setAnotherField(this.FreeServiceNumberOfMonth);
            this.InvoiceMonth.setColspan(1);
            rtnString += this.printHtml(this.InvoiceMonth);
            
            //數字 =FreeServiceNumberOfMonth*TwdHourlyCharge
            int TwdDeductionAmount = 0;
            try {
            	TwdDeductionAmount = (int)(Double.parseDouble(this.getTwdHourlyCharge()) * Double.parseDouble(this.getFreeServiceNumberOfMonth()));
            }
            catch(Exception e){}
            this.TwdDeductionAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TwdDeductionAmount.setSize(8);
            this.TwdDeductionAmount.setLength(8);
            this.TwdDeductionAmount.setValue(TwdDeductionAmount + "");
            
            this.TwdHourlyCharge.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TwdHourlyCharge.setAnotherField(this.TwdDeductionAmount);
            this.TwdHourlyCharge.setColspan(1);
            this.TwdHourlyCharge.setSize(10);
            this.TwdHourlyCharge.setLength(10);
            this.TwdHourlyCharge.setOnChange("setValue()");
            rtnString += this.printHtml(this.TwdHourlyCharge);

            //數字=台幣請款總額-折扣台幣總額
            int TotalAmountAfterDiscount = (int)(Util.stringToDouble(totalRequestPayNtdAmount) - Util.stringToDouble(totalDiscountAmount));
            this.TotalAmountAfterDiscount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalAmountAfterDiscount.setColspan(3);
            this.TotalAmountAfterDiscount.setValue(TotalAmountAfterDiscount + "");
            rtnString += this.printHtml(this.TotalAmountAfterDiscount);
            
            rtnString += "<tr bgcolor='#E9EDF4'><td colspan='4' align='center'>" +
            		"--------------------------------------------------" + "------------------------------" + 
            		"</td></tr>";
            }
            
            

            this.TotalRequestPayNtdAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalRequestPayNtdAmount.setColspan(3);
            //rtnString += this.printHtml(this.TotalRequestPayNtdAmount);
            
            this.AttorneyBillNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//          this.AttorneyBillNo.setColspan(3);
            this.AttorneyBillNo.setLength(200);
            this.AttorneyBillNo.setSize(40);
//          rtnString += this.printHtml(this.AttorneyBillNo);
            
            this.Note.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Note.setRows(2);
            this.Note.setCols(50);
            this.Note.setColspan(1);
            this.Note.setAnotherField(this.AttorneyBillNo);
            rtnString += this.printHtml(this.Note);

            rtnString += this.OtherFee.printHiddenTag();
            rtnString += this.OtherCurrency.printHiddenTag();
            rtnString += this.OtherFeeNtd.printHiddenTag();
            rtnString += this.TotalAmountDeductTTax2.printHiddenTag();
            rtnString += this.TotalUntaxedAmount.printHiddenTag();
            rtnString += this.TotalWithHolding.printHiddenTag();
            rtnString += this.TotalDiscountAmount.printHiddenTag();
            rtnString += this.ServiceFeeDeductTTax2.printHiddenTag();
            rtnString += this.TotalRequestPayNtdAmount.printHiddenTag();
            
            rtnString += "<script>setInvoiceBg('" + this.getAttorneyTitle() + "');</script>";

            String scriptText = "<script>"+
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
					    "  doPatentCaseAjaxRequest('Invoice',newTabText,'"+this.getFlowKey()+"',DataDiv,'innerHTML')"+
					    "}"+
						"</script>";
        }
        return rtnString;
    }
    
    public String generateCaseNo() {
    	String caseNo = "";
    	//規則為民國年加四碼流水號 流水號從系統中最大的值加1去編 如 1020543 系統中原流水號為三碼新的編碼要改四碼
    	try {
    			String keyHeader = String.format("%03d", (new GregorianCalendar().get(Calendar.YEAR)-1911));

    			String sql = 
    					"select ReceiptNumber from invoice where ReceiptNumber like '" + keyHeader +"%' and length(ReceiptNumber)=7 order by ReceiptNumber desc";

    			List<String> keys = this.getDbUtil().getValueList(sql, "ReceiptNumber");
    			int max = 1;
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				max = Integer.parseInt( key.substring(keyHeader.length(), keyHeader.length()+4) ) + 1;
    			}
    			
    			caseNo = keyHeader + String.format("%04d", max);
    	}
    	catch(Exception e) {
    		
    	}
    	return caseNo;
    }
    
    public String printTabAreaHtml() throws Exception {
    	String rtnString = "";
    	if(this.onMaintainMode()) {
            if(this.FlowKey.getValue().trim().length() > 0) {
            	String TabSelect = Cnstnts.EMPTY_STRING;
            	rtnString += "<script type='text/javascript'>$(function(){$('#tabs').tabs(" +TabSelect + ");});</script>";
            	rtnString += "<tr><td colspan=4>"+
				"<div id='tabs'><ul>"+
				"<li><a href='#tabs-1'>"+this.getUserInfo().getMsg("jsp.InvoiceDetail.title")+"</a></li>";
            	
            	Groups group = new Groups();
				//調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
				if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
            	rtnString += "<li><a href='#tabs-2'>"+this.getUserInfo().getMsg("jsp.ArWriteoffLog.title")+"</a></li>";
				}

            	//2.按了之後,檢查若所選的工時有包含多個案件或多todos，出現提醒視窗顯示"您所選取欲請款的工時包含一個以上的案件和代辦事項，請款單案件資料頁簽將不顯示"，
            	if(!Util.compareTo(this.getMultiTodos(), "Y")) {
            		rtnString += "<li><a href='#tabs-3'>"+this.getUserInfo().getMsg("jsp.Invoice.CaseInfo")+"</a></li>";
            	}
            	//調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
				if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
            		rtnString += "<li><a href='#tabs-4'>"+this.getUserInfo().getMsg("jsp.Invoice.TimesheetTab")+"</a></li>";
            		rtnString += "<li><a href='#tabs-5'>"+this.getUserInfo().getMsg("jsp.Invoice.PaymentTab")+"</a></li>";
				}
            	rtnString += "</ul>";
            	
            	/**** tabs-1 ****/
            	rtnString +="<div id='tabs-1'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0>";
	            rtnString +="<tr><td align=left>";
	            rtnString +="<input type='button' value='" + 
	            		this.getUserInfo().getMsg("jsp.InvoiceDetail.CopyOrderBtn") + 
	            		"' onclick='openAppendix(\"OrderSortableForm.jsp?queryClass=InvoiceDetail&QueryText5=" + this.getFlowKey() + "\",\"InvoiceDetail\",800,600)'>";
	            rtnString +="</td></tr>";
	            rtnString +="<tr><td valign=top>";
	            rtnString +="<div id='updateInvoiceDetailDiv' name='updateInvoiceDetailDiv'></div>";
	            rtnString +="<div id='InvoiceDetailDiv' name='InvoiceDetailDiv'>";
	            InvoiceDetail detail = new InvoiceDetail();
	            detail.init();
	            detail.setUserInfo(this.getUserInfo());
	            rtnString += detail.printSearchReasult();
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-1 end ****/
	            
	          //調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
				if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
	            /**** tabs-2 ****/
            	rtnString +="<div id='tabs-2'>";
	            rtnString +="<div class='indent'>";
	            rtnString +="<table width=95% border=0><tr><td valign=top>";
	            rtnString +="<div id='updatePatentDocumentDiv' name='updatePatentDocumentDiv'></div>";
	            rtnString +="<div id='PatentDocumentDiv' name='PatentDocumentDiv'>";
	            ArWriteoffLog arWriteoffLog = new ArWriteoffLog();
	            arWriteoffLog.init();
	            arWriteoffLog.setUserInfo(this.getUserInfo());
	            rtnString += arWriteoffLog.printSearchReasult2();
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div>";
	            rtnString +="</div>";
	            /**** tabs-2 end ****/
				}
	            
	            if(!Util.compareTo(this.getMultiTodos(), "Y")) {
	            /**** tabs-3 ****/
            	rtnString +="<div id='tabs-3'>";
	            rtnString +="<div class='indent'>";
	            
	            //2. 設置一個 重新載入 扭 在案件資料分頁右上角，點的時候就去重新取該案件的資料來帶入並存入
	            rtnString += "<input type='hidden' id='reloadFlag' name='reloadFlag'>";
	            rtnString +="<table width=99% border=0>";
	            if(!Util.isEmpty(this.getCaseNo())) {
	            rtnString += "<tr><td align=right colspan='4'>";
	            rtnString +="<input type='button' value='" + this.getUserInfo().getMsg("jsp.Invoice.ReloadBtn") + "' " +
	            		"onclick='this.disabled=true;document.input.reloadFlag.value=true;setValue();'>";
	            rtnString +="</td></tr>";
	            }
	            rtnString +="<tr><td valign=top>";
	            rtnString +="<div id='updateCaseInfoDiv' name='updateCaseInfoDiv'></div>";
	            rtnString +="<div id='CaseInfoDiv' name='CaseInfoDiv'>";
	            
	            this.InternalNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
	        	this.CaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	        	this.CaseNo.setAnotherField(this.InternalNo);
	            this.CaseNo.setColspan(1);
	        	rtnString += this.printHtml(this.CaseNo);
	        	
	        	List<SelectItem> items = new ArrayList<SelectItem>();
	        	
	        	Category category = new Category();
	        	items = new ArrayList<SelectItem>();
	            items.addAll(category.getChildList("PatentType"));
	            items.addAll(category.getChildList("TrademarkType"));
	            items.addAll(category.getChildList("SubType"));
	            items.addAll(category.getChildList("CopyrightMainType"));
	            
	        	items.addAll(category.getChildList("PatentCaseType"));
	        	items.addAll(category.getChildList("CaseType"));
	        	items.addAll(category.getChildList("TrademarkCaseType"));
	        	items.addAll(category.getChildList("MainType"));
	        	items.addAll(category.getChildList("CopyrightMatter"));
	            
	        	this.CaseType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	        	this.CaseType.setSelectList(items);
	        	
	        	if(!Util.compareTo(this.getInitFlag(), "true")) {
	        		this.setInitFlag("true");
	        		this.doReloadProcess();
	        	}
	        	this.CaseClient.setHtmlType(Cnstnts.HTML_TAG_TEXT);
				this.CaseClient.setSize(50);

	        	this.Office.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	            this.Office.setSelectList(category.getChildList("PatentOffice"));
	        	this.Office.setColspan(1);
	        	this.Office.setAnotherField(this.CaseClient);
	        	rtnString += this.printHtml(this.Office);
	        	
	            this.DependentClaim.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.DependentClaim.setSize(5);
	            
	            this.IndependentClaim.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.IndependentClaim.setSize(5);
	            this.IndependentClaim.setAnotherField(this.DependentClaim);
	            this.IndependentClaim.setColspan(1);
	            rtnString += this.printHtml(this.IndependentClaim);
	        	
	        	items = new ArrayList<SelectItem>();
	            String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig";
	            items.addAll(DbUtil.getSelectItemList(sql,"MatterName"));
	        	this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	        	this.Matter.setSelectList(items);

	        	items = new ArrayList<SelectItem>();
	            items.addAll(category.getChildList("PatentType"));
	            items.addAll(category.getChildList("TrademarkType"));
	            items.addAll(category.getChildList("MainType"));
	            items.addAll(category.getChildList("CopyrightMainType"));
	        	this.SubType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	        	this.SubType.setSelectList(items);
	            this.SubType.setAnotherField(this.Matter);
	            this.SubType.setColspan(1);
	            rtnString += this.printHtml(this.SubType);
	            
	            this.TrademarkClassification.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.TrademarkClassification.setCols(40);
	            this.TrademarkClassification.setRows(2);
	            
	            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
	            this.Title.setCols(40);
	            this.Title.setRows(2);
	            this.Title.setAnotherField(this.TrademarkClassification);
	            this.Title.setColspan(1);
	            rtnString += this.printHtml(this.Title);
	            
	            this.ApplyNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            
	        	this.ApplyDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
	        	this.ApplyDate.setSelectList(items);
	            this.ApplyDate.setAnotherField(this.ApplyNo);
	            this.ApplyDate.setColspan(1);
	            rtnString += this.printHtml(this.ApplyDate);
	            
	            this.IssueNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            
	        	this.IssueDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
	        	this.IssueDate.setSelectList(items);
	            this.IssueDate.setAnotherField(this.IssueNo);
	            this.IssueDate.setColspan(1);
	            rtnString += this.printHtml(this.IssueDate);
	        	
	            this.TaskCreator.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	        	this.TaskCreator.setSelectList(new Employee().getList());
	        	
	        	sql = "select FlowKey, Names from applicant where " +
						"Client = '" + this.getClient() + "' " +
						"and ShowInClient ='Y' " +
						"and (ApplicantKind like '%CLK01;%' or ApplicantKind like '%CLK06;%' or ApplicantKind like '%CLK07;%') ";
	            this.ClientContect.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	            this.ClientContect.setSelectList(this.getDbUtil().getSelectItemList(sql, "Names"));
	            this.ClientContect.setAnotherField(this.TaskCreator);
	            this.ClientContect.setColspan(1);
	            this.ClientContect.setSize(50);
	            rtnString += this.printHtml(this.ClientContect);
	            
	            sql = "select a.flowkey, concat(a.Department, ' ' , a.Names, ' ', a.Title) as Names from applicant a " +
	            		"where a.ShowInClient = 'Y' " +
	            		"and a.Client = '" + this.getClient() + "' " +
	            		"and a.ApplicantKind like '%CLK02;%'";
	            if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
	            	sql = "select a.flowkey, (a.Department+' '+a.Names+' '+a.Title) as Names from applicant a " +
		            		"where a.ShowInClient = 'Y' " +
		            		"and a.Client = '" + this.getClient() + "' " +
		            		"and a.ApplicantKind like '%CLK02;%'";
	            }
	            this.BillingContact.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
	    		this.BillingContact.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("Names", ""), false, false));
	    		
//	            this.BillingContact.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//	            this.BillingContact.setLength(200);
//	            this.BillingContact.setSize(50);
	            
	            this.RegisterNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.RegisterNo.setColspan(1);
	            this.RegisterNo.setAnotherField(this.BillingContact);
	            rtnString += this.printHtml(this.RegisterNo);
	            
	            Properties empProp = new Employee().getNamesPrpts();
	            items = new Employee().getList();
	        	this.AssignedTo.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
	        	this.AssignedTo.setSelectList(items);
	            this.AssignedTo.setAutocompleteLabelFieldId("assignedToName");
	            this.AssignedTo.setAfterText("<input type='text' readonly='true' name='assignedToName' id='assignedToName' value='" + empProp.getProperty(this.getAssignedTo()) + "' size='8'>");
	            rtnString += this.printHtml(this.AssignedTo);
	            
	            this.CaseNo2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.CaseNo2.setColspan(3);
	            rtnString += this.printHtml(this.CaseNo2);
	            
	            rtnString +="</div></td></tr></table>";
	            rtnString +="</div></div>";
	            /**** tabs-3 end ****/
	            }
	            
	            /**** tabs-4 ****/
	            //調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
				if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
	            if(Util.compareTo(this.getTimesheetMerge(), "Y")) {
		            rtnString += "<input type='hidden' name='markFinishFlag' id='markFinishFlag'/>";
	            	rtnString +="<div id='tabs-4'>";
		            rtnString +="<div class='indent'>";
		            rtnString +="<table width=95% border=0><tr><td valign=top>";
		            rtnString +="<div id='updateServiceProjectMemberDiv' name='updateServiceProjectMemberDiv'></div>";
		            rtnString +="<div id='ServiceProjectMemberDiv' name='ServiceProjectMemberDiv'>";

		            rtnString +="</div></td></tr></table>";
		            rtnString +="</div>";
		            rtnString +="</div>";
	            }
	            /**** tabs-4 end ****/
				
	            /**** tabs-5 ****/
		            rtnString += "<input type='hidden' name='markFinishFlag' id='markFinishFlag'/>";
	            	rtnString +="<div id='tabs-5'>";
		            rtnString +="<div class='indent'>";
		            rtnString +="<table width=95% border=0><tr><td valign=top>";
		            rtnString +="<div id='updatePaymentDiv' name='updatePaymentDiv'></div>";
		            rtnString +="<div id='PaymentDiv' name='PaymentDiv'>";
		            
		            rtnString += printPaymentHtml();
		            
		            rtnString +="</div></td></tr></table>";
		            rtnString +="</div></div>";
	            /**** tabs-5 end ****/
				}

	            
	            
	            String scriptText = "<script>"+
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
						    "  doPatentCaseAjaxRequest('Invoice',newTabText,'"+this.getFlowKey()+"',DataDiv,'innerHTML')"+
						    "}"+
							"</script>";
			    rtnString += scriptText;
			    rtnString += "</td></tr>";
            }
    	}
    	
		return rtnString;
    }
    
    public String printPaymentHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;Properties categoryPrpt = null;
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

    	Properties matterPrpt = null;
    	try {
    		matterPrpt = new PatentMatterConfig().getNamesPrpts();
    		matterPrpt.putAll(categoryPrpt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		/*
相同案件編號與程序的 請款與沖銷欄位資訊 列表欄位與順序如下：
請款方請款單單號、案件編號、案件程序、付款對象名稱、請款日期、原幣別、原幣總金額、
付款台幣總金額、已沖銷總額、實際付款日
		 */
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.Payment.InvoiceNo")+"</td>";
		String thText3="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Payment.CaseNo")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Payment.Matter")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Payment.PayToPartyName")+"</td>";
		String thText6="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.Payment.PaymentDate")+"</td>";
		String thText7="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Payment.Currency")+"</td>";
		String thText8="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Payment.OriginalCurrencyAmount")+"</td>";
		String thText9="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Payment.TotalPaymentNtdAmount")+"</td>";
		String thText10="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.Payment.TotalPaymentWriteOffAmount")+"</td>";
		String thText11="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PayManage.ReceiveDate")+"</td>";
		String thText13=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText13 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+
				thText7+thText8+thText9+thText10+thText11+thText13+"</tr>");
		int i=0;
		String SQL = "select FlowKey from payment where CaseNo = '" + this.getCaseNo() + "' and Matter ='" + this.getMatter() + "' order by invoiceno";
		List<String> keys = this.getDbUtil().getValueList(SQL, "FlowKey");
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		int TotalRequestPayNtdAmount = 0;
		double TotalWriteOffAmount = 0;
		for(String key : keys){
			Payment payment = new Payment(key);
			
			
			String[] fields = {"ReceiveDate"};
			String sql = "select distinct rm.receiveDate as ReceiveDate , rm.FlowKey as FlowKey from paymanage rm left join apwriteofflog ar on rm.flowkey = ar.PayId left join Payment i on i.flowKey = ar.PaymentId where i.FlowKey = '"+key+"' order by rm.receiveDate asc";
			System.out.println(sql);
			List<Object[]> listField = this.getDbUtil().getList(sql, fields);
			String receiveDateList = "";
			int countNum = 0;
			for(Object[] field :listField){
				countNum++;
				String receiveDate = (String) field[1];
				receiveDateList += receiveDate;
				if(listField.size() != countNum){
					receiveDateList +=";";
				}
			}
			
			sql = "select sum(WriteOffAmount) as count from apwriteofflog where PaymentId = '" + key + "' and Reversal = ''";
			String TotalPaymentWriteOffAmount = this.getDbUtil().getSqlDoubleValue(sql, "count") + "";
			

			TotalRequestPayNtdAmount += Util.stringToInt(payment.getTotalPaymentNtdAmount());
			TotalWriteOffAmount += Util.stringToDouble(TotalPaymentWriteOffAmount);
			
			String onClick = "";
			
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'>"+payment.getInvoiceNo()+"</td>";
			String tdText21="<td align='center'>"+payment.getCaseNo()+"</td>";
			String tdText3="<td align='center'>"+matterPrpt.getProperty(payment.getMatter())+"</td>";
			String tdText4="<td align='center'>"+payment.getPayToPartyName()+"</td>";
			String tdText5="<td align='center'>"+payment.getPaymentDate()+"</td>";
			String tdText6="<td align='center'>"+categoryPrpt.getProperty(payment.getCurrency())+"</td>";
			String tdText7="<td align='center'>"+payment.getOriginalCurrencyAmount()+"</td>";
			String tdText8="<td align='center'>"+payment.getTotalPaymentNtdAmount()+"</td>";
			String tdText9="<td align='center'>"+TotalPaymentWriteOffAmount+"</td>";
			String tdText10="<td align='center'>"+receiveDateList+"</td>";
			String tdText13=Cnstnts.EMPTY_STRING;
			
			printValue = tdText1+tdText2+tdText21+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8+tdText9+tdText10+tdText13;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}

			i++;
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		String result = "付款單台幣總額為 %s 元　　　已支付金額為 %s 元";
		
		return String.format(result, TotalRequestPayNtdAmount, 
				TotalWriteOffAmount) + strBfr.toString();
	}
    
    public String printInvoiceDetailHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.ToDosQuery.FlowKey")+"</td>";
		String thText3="<td align='center' width='11%'>"+this.getUserInfo().getMsg("jsp.ToDosQuery.TaskDescription")+"</td>";
		String thText4="<td align='center' width='11%'>"+this.getUserInfo().getMsg("jsp.ToDosQuery.Matter")+"</td>";
		String thText5="<td align='center' width='11%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.Subject")+"</td>";
		String thText6="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.Currency")+"</td>";
		String thText7="<td align='center' width='40%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.Amount")+"</td>";
		String thText8="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.ToDos.ExchangeRate")+"</td>";
		String thText9="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.ToDos.TwdAmount")+"</td>";
		String thText10="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.InvoiceDetail.InclTaxNtdAmount")+"</td>";
		String thText11="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.InvoiceDetail.RequestPay")+"</td>";
		String thText12="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.InvoiceDetail.Withholding")+"</td>";
		String thText13=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+
				thText7+thText8+thText9+thText10+thText11+thText12+thText13+"</tr>");
		
		String SQL = "select 'P' as C, p.FlowKey, p.PatentCaseType as CaseType, p.PatentOffice as Office, " +
				"	p.PatentType as SubType, p.Title, p.Status from patentcase p where p.client = '" + this.getFlowKey() + "' " +
				"union " +
				"select 'L' as C, p.FlowKey, p.MainType as CaseType, '' as Office, " +
				"	p.SubType as SubType, p.Title, p.Status from legalcase p  where p.client = '" + this.getFlowKey() + "' " +
				"union " +
				"select 'T' as C, p.FlowKey, p.TradeMarkCaseType as CaseType, p.Office as Office, " +
				"	p.TrademarkType as SubType, p.Title, p.Status from trademarkcase p  where p.client = '" + this.getFlowKey() + "'" ;
//				"union " +
//				"select 'C' as C, p.FlowKey, p.MainType as CaseType, p.Office as Office, " +
//				"	p.SubType as SubType, p.Title, p.Status from copyrightcase p  where p.client = '" + this.getFlowKey() + "'";
		List<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("FlowKey", "FlowKey"));
		fieldList.add(new Field("CaseType", "CaseType"));
		fieldList.add(new Field("Office", "Office"));
		fieldList.add(new Field("SubType", "SubType"));
		fieldList.add(new Field("Title", "Title"));
		fieldList.add(new Field("Status", "Status"));
		fieldList.add(new Field("C", "C"));
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String CaseType = Cnstnts.EMPTY_STRING;
			String Office = Cnstnts.EMPTY_STRING;
			String SubType = Cnstnts.EMPTY_STRING;
			String Title = Cnstnts.EMPTY_STRING;
			String Status = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String C = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("CaseType")){
					CaseType = field.getValue();
				}
				if(field.getName().equals("Office")){
					Office = field.getValue();
				}
				if(field.getName().equals("SubType")){
					SubType = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Title")){
					Title = field.getValue();
				}
				if(field.getName().equals("Status")){
					Status = field.getValue();
				}
				if(field.getName().equals("C")){
					C = field.getValue();
				}
			}
			String onClick = "";
			
			if(Util.compareTo(C, "P")) {
				onClick = " onClick='openAppendix(\"PatentCase.jsp?flowKey="+FlowKey+
				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
					"\",\"PatentCase\",800,600)' style='cursor:hand'";
			}
			else if(Util.compareTo(C, "T")) {
				onClick = " onClick='openAppendix(\"TrademarkCase.jsp?flowKey="+FlowKey+
				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
					"\",\"TrademarkCase\",800,600)' style='cursor:hand'";
			}
			else if(Util.compareTo(C, "L")) {
				onClick = " onClick='openAppendix(\"LegalCase.jsp?flowKey="+FlowKey+
				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
					"\",\"LegalCase\",800,600)' style='cursor:hand'";
			}
//			else if(Util.compareTo(C, "C")) {
//				onClick = " onClick='openAppendix(\"CopyrightCase.jsp?flowKey="+FlowKey+
//				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
//					"\",\"CopyrightCase\",800,600)' style='cursor:hand'";
//			}
			  					
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td"+onClick+">"+FlowKey+"</td>";
			String tdText3="<td align='center'"+onClick+">"+categoryPrpt.getProperty(CaseType)+"</td>";
			String tdText4="<td align='center'"+onClick+">"+categoryPrpt.getProperty(Office)+"</td>";
			String tdText5="<td align='center'"+onClick+">"+categoryPrpt.getProperty(SubType)+"</td>";
			String tdText6="<td"+onClick+">"+Title+"</td>";
			String tdText7="<td align='center'"+onClick+">"+categoryPrpt.getProperty(Status)+"</td>";
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

    public void setSearchListPrpts() {
    	Properties categoryPrpt = null;
    	try {
			categoryPrpt = new Category().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Properties patentMatterConfigPrpt = null;
        try {
        	patentMatterConfigPrpt = new PatentMatterConfig().getNamesPrpts();
        	patentMatterConfigPrpt.putAll(new Category().getNamesPrpts());
        }
        catch(Exception e) {
            e.printStackTrace();
        }

		Properties empPrpt = null;
        try {
        	empPrpt = new Employee().getNamesPrpts();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Properties radioPrpt = new Properties();
		try {
			radioPrpt.setProperty("Y" , "<img src='img/tick.gif'>" );
			radioPrpt.setProperty("N" , "<img src='img/cross.gif'>" );
		} catch(Exception e) {
			e.printStackTrace();
		}
		
    	this.CaseNo.setListWidth("7%");
    	
//    	this.InternalNo.setListWidth("6%");
    	
    	this.Client.setListWidth("6%");
    	
    	this.ClientName.setListWidth("11%");
    	
    	this.InvoiceTitle.setListWidth("11%");
    	
    	this.Title.setListWidth("10%");
    	
    	
    	
    	this.AttorneyTitle.setListWidth("6%");
        this.AttorneyTitle.setMapingPrpt(categoryPrpt);
        this.AttorneyTitle.setNotShowCode(true);
    	
    	this.Office.setListWidth("6%");
        this.Office.setMapingPrpt(categoryPrpt);
        this.Office.setNotShowCode(true);
    	
        this.TaskDescription.setListWidth("7%");
        
//    	this.Matter.setListWidth("8%");
//        this.Matter.setMapingPrpt(patentMatterConfigPrpt);
//        this.Matter.setNotShowCode(true);
    	
        this.InvoiceNo.setListWidth("6%");
        
//    	this.InvoiceDate.setListWidth("7%");
        
        this.VoucherDate.setListWidth("7%");
    	
//    	this.ArDate.setListWidth("8%");
    	
    	this.TotalIncludeTaxAmount.setListWidth("6%");
    	
    	this.TotalWriteOffAmount.setListWidth("6%");
    	
    	this.TotalTax2.setListWidth("7%");
    	
    	this.TaskCreator.setListWidth("7%");
    	this.TaskCreator.setMapingPrpt(empPrpt);
    	this.TaskCreator.setNotShowCode(true);
    	
    	this.TimesheetMerge.setListWidth("4%");
    	this.TimesheetMerge.setMapingPrpt(radioPrpt);
    	this.TimesheetMerge.setNotShowCode(true);
    	
    	
        Field[] showField = {this.VoucherDate, this.CaseNo,  this.InvoiceNo, this.InvoiceTitle, this.AttorneyTitle, 
        		this.TaskDescription, this.ClientName, this.Office, 
        		this.GovFeeAmount, this.AttorneyFee, this.ServiceFeeAmount, this.TotalTax2,
        		this.TotalTax,this.TotalIncludeTaxAmount,this.ReceiptNumber,this.InvoiceNumber};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
    	this.Office.setMapingPrpt(new Category().getNamesPrpts());
    	
        String whereStr = Cnstnts.EMPTY_STRING;
//        whereStr = Util.addWhereSQL(whereStr, this.CaseNo);
        if(!Util.isEmpty(this.getCaseNo())) {
        	whereStr = " where (i.CaseNo like '%" + this.getCaseNo() + "%' or i.CaseNo2 like '%" + this.getCaseNo() + "%' ) ";
        }
//        whereStr = whereStr.replaceAll(" CaseNo ", " i.CaseNo ");
        whereStr = Util.addWhereSQL(whereStr, this.ApplyNo);
        whereStr = Util.addWhereSQL(whereStr, this.Title);
        whereStr = Util.addWhereSQL(whereStr, this.ClientName);
        whereStr = Util.addWhereSQL(whereStr, this.Client);
        whereStr = Util.addWhereSQL(whereStr, this.InvoiceType);
        whereStr = Util.addWhereSQL(whereStr, this.InvoiceTitle);
        whereStr = Util.addWhereSQL(whereStr, this.Office);
        whereStr = Util.addWhereSQL(whereStr, this.SubType);
        whereStr = Util.addWhereSQL(whereStr, this.Matter);
        whereStr = Util.addWhereSQL(whereStr, this.InvoiceStatus);
        whereStr = Util.addWhereSQL(whereStr, this.TaskDescription);
        whereStr = Util.addWhereSQL(whereStr, this.AttorneyTitle);
        whereStr = Util.addWhereSQL(whereStr, this.TaskCreator);
        whereStr = Util.addWhereSQL(whereStr, this.ReceiptNumber);
        whereStr = Util.addWhereSQL(whereStr, this.AttorneyBillNo);
        whereStr = Util.addBetweenSQL(whereStr, this.InvoiceDate, this.InvoiceDateTo);
        whereStr = Util.addBetweenSQL(whereStr, this.ArDate, this.ArDateTo);
        whereStr = Util.addBetweenSQL(whereStr, this.VoucherDate, this.VoucherDateTo);
        
        if(Util.compareTo(this.getTimesheetMerge(), "Y")) {
        	if(whereStr.indexOf("where") != -1) {
       			whereStr += " and i.TimesheetMerge = 'Y' ";
       		}
       		else {
       			whereStr += " where i.TimesheetMerge = 'Y' ";
       		}
        }
        
        if(!Util.isEmpty(this.InvoiceNo.getValue()) && Util.isEmpty(this.InvoiceNoTo.getValue())) {
        	whereStr = Util.addWhereSQL(whereStr, this.InvoiceNo);
        }
        else if(!Util.isEmpty(this.InvoiceNo.getValue()) && !Util.isEmpty(this.InvoiceNoTo.getValue())) {
        	if(whereStr.indexOf("where") != -1) {
       			whereStr += " and i.InvoiceNo between '" + this.getInvoiceNo() + "' and  '" + this.getInvoiceNoTo() + "'";
       		}
       		else {
       			whereStr += " where i.InvoiceNo between '" + this.getInvoiceNo() + "' and  '" + this.getInvoiceNoTo() + "'";
       		}
        }
        
        /*
         * “尚未沖銷之請款單”checkbox搜尋欄位查詢出來的資料條件應該為請款台幣總額不等於已沖銷總額的資料才對
         */
        if(Util.compareTo(this.getNotYetWriteOff(), "Y")) {
        	//String sql = "select flowkey from Invoice where TotalRequestPayNtdAmount != TotalWriteOffAmount";
        	String sql = "select i.*,ROUND(" + DB.SQL_IFNULL + "(ids.TWHAmount,0)) as TotalWithHolding "+
            "from Invoice i "+
            "left join ( "+
            "select id.parentid,sum(id.Tax2) as TWHAmount from invoicedetail id "+
            "where id.WithHolding='Y' group by id.parentid  ) as ids on i.FlowKey= ids.parentid "+ 
            "where (i.TotalRequestPayNtdAmount - i.TotalWriteOffAmount - " + DB.SQL_IFNULL + "(ids.TWHAmount,0) - i.TotalDiscountAmount ) != 0";
        	String where = this.getDbUtil().getInCondSql(sql, "i.flowkey");
        	
        	if(Util.isEmpty(where)) {
        		where = "''";
        	}

        	if(whereStr.indexOf("where") != -1) {
       			whereStr += " and i.flowkey in (" + where + ")";
       		}
       		else {
       			whereStr = " where i.flowkey in (" + where + ")";
       		}
        }
        
        if(!Util.isEmpty(this.getIpType())) {
        	String cond = "";
        	String table = "";
        	if(Util.compareTo(this.getIpType(), "P")) {
        		table = "patentcase";
        	}
        	else  if(Util.compareTo(this.getIpType(), "T")) {
        		table = "trademarkcase";
        	}
        	else  if(Util.compareTo(this.getIpType(), "C")) {
        		table = "copyrightcase";
        	}
        	else  if(Util.compareTo(this.getIpType(), "L")) {
        		table = "legalcase";
        	}
        	String sql =  "select distinct caseno from " + table;
        	cond = Util.arrayToIncond(this.getDbUtil().getValueList(sql, "caseno").toArray());

        	if(whereStr.indexOf("where") != -1) {
       			whereStr += " and i.caseno in (" + cond + ")";
       		}
       		else {
       			whereStr = " where i.caseno in (" + cond + ")";
       		}
        }
        
        whereStr = this.getDataAuthorityWhereSQL(whereStr);
        
        String SQL = "select i.*,  ROUND(" + DB.SQL_IFNULL + "(ids.TWHAmount,0)) as TotalWithHolding, p.InternalNo as InternalNo "+
        "from Invoice i "+
        "left join ( "+
        "select id.parentid,sum(id.Tax2) as TWHAmount from invoicedetail id "+
        "where id.WithHolding='Y' group by id.parentid ) as ids on i.FlowKey= ids.parentid "+
        "left join patentcase p on p.flowkey=i.caseno "+ whereStr.replaceAll("Applicant", "i.Applicant").replaceAll("CreateDept", "i.CreateDept");
        //5.列表點資料匯出時，匯出的排序先以 "請款日期"欄位遞增asce排序（上往下為舊到新），同一日期在以請款編號(單據編號)由小到大排序（-01, -02.....)
        if (Cnstnts.EXPORTCSV.equals(this.getDbActionMode())/*
				&& Cnstnts.SEARCH.equals(this.getPageActionMode())*/) {
        	SQL += " order by VoucherDate, InvoiceNo ";
        	SQL = SQL.replaceAll(" Title like "," i.Title like ").replaceAll(" Client like "," i.Client like ").replaceAll(" ClientName like "," i.ClientName like ").replaceAll(" ApplyNo like "," i.ApplyNo like ");
        }
        else {
        	SQL = Util.addOrderSQL(SQL, this.getOrderKey(), this.getOrderSequence()).replaceAll(" Title like "," i.Title like ").replaceAll(" ClientName like "," i.ClientName like ").replaceAll(" Client like "," i.Client like ").replaceAll(" ApplyNo like "," i.ApplyNo like ");
        }
        System.out.println(SQL);
        return this.doSearch(SQL);
    }
    
    public List<Object[]> doSearch(String SQL) throws Exception{
  	  	if(this.getPageNo()==0){
  	  		this.setPageNo(1);
  	  	}
        int recordCount=0;
        
        boolean hasGovFeeAmount = false;
        boolean hasServiceFeeAmount = false;
        boolean hasAttorneyFeeAmount = false;
        int hasGovFeeAmountIndex = 0;
        int hasServiceFeeAmountIndex = 0;
        int hasAttorneyFeeAmountIndex = 0;
        int index = 1;
//        for(Field field : this.getShowField()) {
//        	if(field.getName().equals(this.GovFeeAmount.getName())) {
//        		hasGovFeeAmount = true;
//        		hasGovFeeAmountIndex = index;
//        	}
//        	if(field.getName().equals(this.ServiceFeeAmount.getName())) {
//        		hasServiceFeeAmount = true;
//        		hasServiceFeeAmountIndex = index;
//        	}
//        	if(field.getName().equals(this.AttorneyFee.getName())) {
//        		hasAttorneyFeeAmount = true;
//        		hasAttorneyFeeAmountIndex = index;
//        	}
//        	index++;
//        }
        
        List<Object[]> rtnList = new ArrayList<Object[]>();
        
        Iterator itr = this.getDbUtil().getList(SQL, this.getShowField()).iterator();
		while (itr.hasNext()) {
			Object[] record = (Object[]) itr.next();
			String flowkey = record[0].toString();
			String sql = "select TimesheetMerge from invoice where flowkey = '" + flowkey + "'";
			String TimesheetMerge = this.getDbUtil().getFieldValue(sql, "TimesheetMerge");
			if (hasGovFeeAmount) {
				sql = "select " + DB.SQL_IFNULL + "(sum(NotIncludeTaxAmount),0) as count from invoicedetail where parentId = '"+flowkey+"' " +
	            		"and accounttitle = 'AccountTitle01'";
				String sum = this.getDbUtil().getFieldValue(sql, "count");

				record[hasGovFeeAmountIndex] = sum.replaceAll("\\.0000", "").replaceAll("\\.00", "");
			}
			if (hasServiceFeeAmount) {
				/*
	             * 服務費金額(=所有明細科目為03者之本次請款金額加總）
	             */
				sql = "select " + DB.SQL_IFNULL + "(sum(NotIncludeTaxAmount),0) as count from invoicedetail where parentId = '"+flowkey+"' " +
	            		"and accounttitle = 'AccountTitle03'";
	            String sum = this.getDbUtil().getFieldValue(sql, "count");
			    
				record[hasServiceFeeAmountIndex] = sum.replaceAll("\\.0000", "").replaceAll("\\.00", "");
			}
			if (hasAttorneyFeeAmount) {
				sql = "select " + DB.SQL_IFNULL + "(sum(NotIncludeTaxAmount),0) as count from invoicedetail where parentId = '"+flowkey+"' " +
	            		"and accounttitle = 'AccountTitle02'";
		            String sum = this.getDbUtil().getFieldValue(sql, "count");

				record[hasAttorneyFeeAmountIndex] = sum.replaceAll("\\.0000", "").replaceAll("\\.00", "");
			}

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

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            Invoice preObj = (Invoice) userInfo.getObj(this.getTableName());
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
    
    public void resetAmountField() {
    	this.TotalIncludeTaxAmount.setValue(this.getTotalIncludeTaxAmount().replaceAll(",", ""));
    	this.TotalNotIncludeTaxAmount.setValue(this.getTotalNotIncludeTaxAmount().replaceAll(",", ""));
    	this.TotalNotIncludeTaxAmountNtd.setValue(this.getTotalNotIncludeTaxAmountNtd().replaceAll(",", ""));
    	this.AmountReceivable.setValue(this.getAmountReceivable().replaceAll(",", ""));
    	this.AmountReceipts.setValue(this.getAmountReceipts().replaceAll(",", ""));
    	this.GovFee.setValue(this.getGovFee().replaceAll(",", ""));
    	this.GovFeeAmount.setValue(this.getGovFeeAmount().replaceAll(",", ""));
    	this.AttorneyFeeNtd.setValue(this.getAttorneyFeeNtd().replaceAll(",", ""));
    	this.AttorneyFee.setValue(this.getAttorneyFee().replaceAll(",", ""));
    	this.ServiceFee.setValue(this.getServiceFee().replaceAll(",", ""));
    	this.ServiceFeeAmount.setValue(this.getServiceFeeAmount().replaceAll(",", ""));
    	this.TotalTax.setValue(this.getTotalTax().replaceAll(",", ""));
    	this.TotalTax2.setValue(this.getTotalTax2().replaceAll(",", ""));
    }

    public boolean checkInsertError() throws Exception {
    	//拿掉千分位
    	resetAmountField();
    	
    	
    	//“已沖銷總額(TotalWriteOffAmount)”為此筆請款單中的所有
        //“請款明細(InvoiceDetail)”的“已沖銷金額(AlreadyWriteOffAmount)”總和
    	String sql = "select sum(AlreadyWriteOffAmount) as count from InvoiceDetail where ParentId ='" + 
    				this.getFlowKey() + "'";
        String TotalWriteOffAmount = Util.stringToInt(this.getDbUtil().getFieldValue(sql, "count")) + "";
        this.setTotalWriteOffAmount(TotalWriteOffAmount);
        if(super.checkInsertError()){
            return true;
        } else {
        	/*
        	 請款單的 單據編號 和 收據編號  儲存時要檢核是否有重複，有的話要顯示警示視窗
        	[下午 03:32:29] Janny Kuo: 重複提醒視窗之後回原畫面 不能存
        	        	 */
        	if(!Util.isEmpty(this.getInvoiceNo())) {
    			sql = "select count(1) as count from invoice where invoiceNo ='" + this.getInvoiceNo() + "' and flowkey != '" + this.getFlowKey() + "'";
    			int count = this.getDbUtil().getSqlIntValue(sql, "count");
    			if(count > 0) {
//        	    				this.setInvoiceNo("");
    				this.setErrorMessage(this.getUserInfo().getMsg("jsp.Invoice.InvoiceNoError"));
    				return true;
    			}
    		}
    		if(!Util.isEmpty(this.getReceiptNumber())) {
    			sql = "select count(1) as count from invoice where ReceiptNumber ='" + this.getReceiptNumber() + "' and flowkey != '" + this.getFlowKey() + "'";
    			int count = this.getDbUtil().getSqlIntValue(sql, "count");
    			if(count > 0) {
//        	    				this.setReceiptNumber("");
    				this.setErrorMessage(this.getUserInfo().getMsg("jsp.Invoice.ReceiptNumberError"));
    				return true;
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
        	/*
        	 * 當刪除整筆請款單時也必須同時刪除所屬的請款單明細，而刪除請款單及請款單明細時也需進行請款單明細刪除的檢核，
        	 * 若不符合請款明細刪除的條件，則整筆請款單及所屬明細皆無法刪除。
        	 */
        	/*
			 * 可刪除條件為：此筆InvoiceDetail的AlreadyWriteOffAmount=0
			 */
        	String sql = "select count(1) as count from invoicedetail where parentid='" +
        		this.getFlowKey() + "' and AlreadyWriteOffAmount != 0";
        	int count = this.getDbUtil().getSqlIntValue(sql, "count");
        	if(count > 0) {
        		this.setErrorMessage(this.getUserInfo().getMsg("jsp.Invoice.DeleteError"));
        		return true;
        	}
        	
        	//檢查該筆請付款單是否已存在已沖銷資料，若是，則出現警示框顯示內容"該請付款單已進行沖銷，請先回沖後才能刪除資料！"，若否，才可放行刪除資料
        	sql = "select count(1) as count from arwriteofflog where InvoiceId = '" + this.getFlowKey() + "' and (Reversal != 'Y' or Reversal is null) ";
        	count = this.getDbUtil().getSqlIntValue(sql, "count");
        	if(count > 0) {
        		this.setErrorMessage(this.getUserInfo().getMsg("jsp.Invoice.DeleteErrorWithWriteOff"));
        		return true;
        	}
        	
            return false;
        }
    }


    
    public boolean getCanEditField(Field field) {
    	if(this.getPageActionMode().equals(Cnstnts.MAINTAIN)) {
    		if(field.getName().equals(this.TotalTax.getName()) ||
    				field.getName().equals(this.TotalTax2.getName()) ||
    				field.getName().equals(this.TotalRequestPayNtdAmount.getName()) ||
    				field.getName().equals(this.TotalWriteOffAmount.getName()) ||
    				field.getName().equals(this.TotalDiscountAmount.getName()) ||
    				field.getName().equals(this.CaseNo.getName()) ||
    				field.getName().equals(this.CaseNo2.getName()) ||
    				field.getName().equals(this.Office.getName()) ||
    				field.getName().equals(this.SubType.getName()) ||
    				field.getName().equals(this.Matter.getName()) ||
    				field.getName().equals(this.ServiceFee.getName()) ||
    				field.getName().equals(this.GovFee.getName()) ||
    				field.getName().equals(this.Title.getName()) ||
    				field.getName().equals(this.OtherFeeNtd.getName()) ||
    				field.getName().equals(this.OtherFee.getName()) ||
    				field.getName().equals(this.OtherCurrency.getName()) ||
    				field.getName().equals(this.AttorneyFeeNtd.getName()) ||
    				field.getName().equals(this.AttorneyFee.getName()) ||
    				field.getName().equals(this.TotalUntaxedAmount.getName()) ||
    				field.getName().equals(this.GovFeeAmount.getName()) ||
    				field.getName().equals(this.ServiceFeeAmount.getName()) ||
    				field.getName().equals(this.ServiceFeeCurrency.getName()) ||
    				field.getName().equals(this.GovFeeCurrency.getName()) ||
    				field.getName().equals(this.CaseClient.getName()) ||
    				field.getName().equals(this.AmountReceivable.getName()) ||
    				field.getName().equals(this.TotalIncludeTaxAmount.getName()) ||
    				field.getName().equals(this.TotalNotIncludeTaxAmount.getName()) ||
    				field.getName().equals(this.ClientContect.getName()) ||
    				field.getName().equals(this.InvoiceTitle.getName()) ||
    				field.getName().equals(this.AccountReceivableDay.getName()) ||
    				field.getName().equals(this.AttorneyCurrency.getName())) {
    			return false;
    		}
    	}
		if (this.canEdit() || this.onSearchMode()) {
			return true;
		} else {
			return false;
		}
	}

    public void clearAttribute() {
		super.clearAttribute();
		this.InvoiceNoTo.setValue(Cnstnts.EMPTY_STRING);
		this.InvoiceDateTo.setValue(Cnstnts.EMPTY_STRING);
		this.ArDateTo.setValue(Cnstnts.EMPTY_STRING);
		this.NotYetWriteOff.setValue(Cnstnts.EMPTY_STRING);
		this.IpType.setValue(Cnstnts.EMPTY_STRING);
		
	}

    public void doAction(UserBean userInfo) throws Exception {
    	this.setUserInfo(userInfo);
    	
    	if(Util.compareTo(this.getDoWriteOffFlag(), "true")) {
    		doReDoWriteOffProcess();
    	}
    	
		if (this.onBtnSubmit() &&
				(StringUtils.equals("true", this.getRequest().getParameter("doPrint")) || 
						(Cnstnts.PRINT.equals(this.getDbActionMode()) && StringUtils.isNotEmpty(this.getFlowKey())))) {
			this.doPrintProcess();
		}
    	
    	if(Util.compareTo(this.getReloadFlag(), "true")) {
    		doReloadProcess();
    	}

    	super.doAction(userInfo);
    }
    
    public void doReloadProcess() throws Exception {
    	if(StringUtils.isEmpty(this.getCaseNo())) {
    		return;
    	}
    	//2. 設置一個 重新載入 扭 在案件資料分頁右上角，點的時候就去重新取該案件的資料來帶入並存入 
    	String SQL = 
    			"select 'P' as C, p.FlowKey from patentcase p where p.caseno = '" + this.getCaseNo() + "' " +
				"union " +
				"select 'L' as C, p.FlowKey from legalcase p  where p.caseno = '" + this.getCaseNo() + "' " +
				"union " +
				"select 'T' as C, p.FlowKey from trademarkcase p  where p.caseno = '" + this.getCaseNo() + "'" +
				"union " +
				"select 'C' as C, p.FlowKey from copyrightcase p  where p.caseno = '" + this.getCaseNo() + "'" ;
    	List<Object[]> result = this.getDbUtil().getList(SQL, new String[]{"C", "FlowKey"});
    	if(result != null && result.size() > 0) {
    		String type = result.get(0)[1].toString();
    		String FlowKey = result.get(0)[2].toString();
    		if(Util.compareTo(type, "P")) {
    			PatentCase patent = new PatentCase(FlowKey);
    			
				this.setInternalNo(patent.getInternalNo());
				this.setOffice(patent.getPatentOffice());
				/*
				 * 請款單-維護模式裡案件資料分頁中的申請人欄位（<jsp.Invoice.CaseClient value="申請人"/>） 
				 * 要改去抓取對應案件中的申請人分頁的 申請人名稱（<jsp.PatentApplicant.ApplicantName value="申請人名稱"/>），若遇該案件有多筆申請人的情況，就以分號( AAA;BBB )相隔呈現 
				 */
				String sql = "select GROUP_CONCAT( concat(ApplicantName,' '," + DB.SQL_IFNULL + "( EnglishNames,  '' ) ) SEPARATOR  ';' ) as value from patentApplicant where parentid = '" +FlowKey+ "' ";
				sql = "select flowkey, ApplicantName, EnglishNames from patentApplicant where parentid = '" +FlowKey+ "' ";
				List<Object[]> objects = this.getDbUtil().getList(sql, new String[]{"ApplicantName", "EnglishNames"});
				String value = "";
				for(Object[] object : objects) {
					value += object[1] + " " + (Util.isEmpty(object[2].toString())?"":object[2]) + ";";
				}
				this.setCaseClient(value);
				
				this.setCaseType(patent.getPatentCaseType());
				this.setDependentClaim(patent.getDependentClaim());
				this.setIndependentClaim(patent.getIndependentClaim());
				this.setSubType(patent.getPatentType());
				this.setTitle(patent.getTitle());
				this.setApplyNo(patent.getApplyNo());
				this.setApplyDate(patent.getApplyDate());
				this.setIssueNo(patent.getIssueNo());
				this.setIssueDate(patent.getIssueDate());
				this.setTaskCreator(patent.getInCharge());
				this.setClientContect(patent.getClientContect());
				this.setBillingContact(new Client(patent.getClient()).getBillingContact());
				this.setRegisterNo(patent.getLicenseNo());
				this.setCaseNo2(patent.getCaseNo2());
				this.setMatter(patent.getMatter());
				
				//this.setTrademarkClassification(patent.getTrademarkClassification());
    		}
    		else if(Util.compareTo(type, "T")) {
    			TrademarkCase patent = new TrademarkCase(FlowKey);
				this.setInternalNo(patent.getInternalNo());
				this.setOffice(patent.getOffice());

				//this.setCaseClient(patent.getClient());
				//申請人欄位帶入改抓 該案件內 客戶名稱/客戶名稱(英) 欄位組合 中英文中間用空格組合顯示  
				//也就是要用請款單該案件fk 內存的client fk 回去client抓 CompanyName EnglishCompanyName
//				Client client = new Client(patent.getClient());
//				this.setCaseClient(client.getCompanyName() + " " + client.getEnglishCompanyName());
				/*
				 * 請款單-維護模式裡案件資料分頁中的申請人欄位（<jsp.Invoice.CaseClient value="申請人"/>） 
				 * 要改去抓取對應案件中的申請人分頁的 申請人名稱（<jsp.PatentApplicant.ApplicantName value="申請人名稱"/>），若遇該案件有多筆申請人的情況，就以分號( AAA;BBB )相隔呈現 
				 */
				String sql = "select GROUP_CONCAT( concat(ApplicantName,' '," + DB.SQL_IFNULL + "( EnglishNames,  '' ) ) SEPARATOR  ';' ) as value from trademarkapplicant where parentid = '" +FlowKey+ "' ";
				sql = "select flowkey, ApplicantName, EnglishNames from trademarkapplicant where parentid = '" +FlowKey+ "' ";
				List<Object[]> objects = this.getDbUtil().getList(sql, new String[]{"ApplicantName", "EnglishNames"});
				String value = "";
				for(Object[] object : objects) {
					value += object[1] + " " + (Util.isEmpty(object[2].toString())?"":object[2]) + ";";
				}
				this.setCaseClient(value);
				
				this.setCaseType(patent.getTrademarkCaseType());
//				this.setDependentClaim(patent.getDependentClaim());
//				this.setIndependentClaim(patent.getIndependentClaim());
				this.setSubType(patent.getTrademarkType());
				this.setTitle(patent.getTitle());
				this.setApplyNo(patent.getFillingNum());
				this.setApplyDate(patent.getFillingDate());
				this.setIssueNo(patent.getIssueNo());
				this.setIssueDate(patent.getIssueDate());
				this.setTaskCreator(patent.getSales());
				this.setClientContect(patent.getClientContect());
				this.setBillingContact(new Client(patent.getClient()).getBillingContact());
				this.setRegisterNo(patent.getRegistNum());
				this.setCaseNo2(patent.getCaseNo2());
				this.setMatter(patent.getMatter());
				
				this.setTrademarkClassification(patent.getTrademarkClassification());
    		}
    		else if(Util.compareTo(type, "L")) {
    			LegalCase patent = new LegalCase(FlowKey);
				this.setInternalNo(patent.getTmpField_09());
				this.setOffice("");

				//this.setCaseClient(patent.getClient());
				//申請人欄位帶入改抓 該案件內 客戶名稱/客戶名稱(英) 欄位組合 中英文中間用空格組合顯示  
				//也就是要用請款單該案件fk 內存的client fk 回去client抓 CompanyName EnglishCompanyName
//				Client client = new Client(patent.getClient());
//				this.setCaseClient(client.getCompanyName() + " " + client.getEnglishCompanyName());
				/*
				 * 請款單-維護模式裡案件資料分頁中的申請人欄位（<jsp.Invoice.CaseClient value="申請人"/>） 
				 * 要改去抓取對應案件中的申請人分頁的 申請人名稱（<jsp.PatentApplicant.ApplicantName value="申請人名稱"/>），若遇該案件有多筆申請人的情況，就以分號( AAA;BBB )相隔呈現 
				 */
				String sql = "select GROUP_CONCAT( concat(ApplicantName,' '," + DB.SQL_IFNULL + "( EnglishNames,  '' ) ) SEPARATOR  ';' ) as value from legalApplicant where parentid = '" +FlowKey+ "' ";
				sql = "select flowkey, ApplicantName, EnglishNames from legalApplicant where parentid = '" +FlowKey+ "' ";
				List<Object[]> objects = this.getDbUtil().getList(sql, new String[]{"ApplicantName", "EnglishNames"});
				String value = "";
				for(Object[] object : objects) {
					value += object[1] + " " + (Util.isEmpty(object[2].toString())?"":object[2]) + ";";
				}
				this.setCaseClient(value);
				
				this.setCaseType(patent.getMainType());
//				this.setDependentClaim(patent.getDependentClaim());
//				this.setIndependentClaim(patent.getIndependentClaim());
				this.setSubType(patent.getMainType());
				this.setTitle(patent.getTitle());
				this.setApplyNo(patent.getTmpField_04());
				this.setApplyDate(patent.getRealStartDate());
//				this.setIssueNo(patent.getIssueNo());
//				this.setIssueDate(patent.getIssueDate());
				this.setTaskCreator(patent.getInCharge());
				this.setClientContect(patent.getClientContect());
				this.setBillingContact(new Client(patent.getClient()).getBillingContact());
//				this.setRegisterNo(patent.getLicenseNo());
				this.setCaseNo2(patent.getCaseNo2());
				this.setMatter(patent.getMatter());
				
				//this.setTrademarkClassification(patent.getTrademarkClassification());
    		}
    		else if(Util.compareTo(type, "C")) {
    			CopyrightCase patent = new CopyrightCase(FlowKey);
				this.setInternalNo(patent.getTmpField_06());
				this.setOffice(patent.getOffice());

				//this.setCaseClient(patent.getClient());
				//申請人欄位帶入改抓 該案件內 客戶名稱/客戶名稱(英) 欄位組合 中英文中間用空格組合顯示  
				//也就是要用請款單該案件fk 內存的client fk 回去client抓 CompanyName EnglishCompanyName
//				Client client = new Client(patent.getClient());
//				this.setCaseClient(client.getCompanyName() + " " + client.getEnglishCompanyName());
				/*
				 * 請款單-維護模式裡案件資料分頁中的申請人欄位（<jsp.Invoice.CaseClient value="申請人"/>） 
				 * 要改去抓取對應案件中的申請人分頁的 申請人名稱（<jsp.PatentApplicant.ApplicantName value="申請人名稱"/>），若遇該案件有多筆申請人的情況，就以分號( AAA;BBB )相隔呈現 
				 */
				String sql = "select GROUP_CONCAT( concat(ApplicantName,' '," + DB.SQL_IFNULL + "( EnglishNames,  '' ) ) SEPARATOR  ';' ) as value from copyrightApplicant where parentid = '" +FlowKey+ "' ";
				sql = "select flowkey, ApplicantName, EnglishNames from copyrightApplicant where parentid = '" +FlowKey+ "' ";
				List<Object[]> objects = this.getDbUtil().getList(sql, new String[]{"ApplicantName", "EnglishNames"});
				String value = "";
				for(Object[] object : objects) {
					value += object[1] + " " + (Util.isEmpty(object[2].toString())?"":object[2]) + ";";
				}
				this.setCaseClient(value);
				
				this.setCaseType(patent.getMainType());
//				this.setDependentClaim(patent.getDependentClaim());
//				this.setIndependentClaim(patent.getIndependentClaim());
				this.setSubType(patent.getMainType());
				this.setTitle(patent.getTitle());
				this.setApplyNo(patent.getTmpField_01());
				this.setApplyDate(patent.getTargetFinishDate());
//				this.setIssueNo(patent.getIssueNo());
//				this.setIssueDate(patent.getIssueDate());
				this.setTaskCreator(patent.getInCharge());
				this.setClientContect(patent.getClientContect());
				this.setBillingContact(new Client(patent.getClient()).getBillingContact());
				this.setRegisterNo(patent.getTmpField_02());
				this.setCaseNo2(patent.getCaseNo2());
				this.setMatter(patent.getMatter());
				
				//this.setTrademarkClassification(patent.getTrademarkClassification());
    		}
    		
    		if(Util.isEmpty(this.getSoKey())) {
    			this.setBillingContact("");
    		}
    		else {
    			this.setBillingContact(new SalesOrder(this.getSoKey()).getBillingContact());
    		}
    		
    		//拿掉千分位
        	resetAmountField();
        	
    		this.setDbActionMode(Cnstnts.UPDATE);
    		this.update();
    		//this.getDbUtil().executeUpdate(this.getDbUtil().getUpdateSQL(this.getTableName(), this.getDbFields()));
    	}
    }
    
    public void doReDoWriteOffProcess() throws Exception {
    	/*
此“帳款沖回”按鈕功能為將以沖銷之帳款沖回去，因此當執行此功能按鈕後會同時直接影響的資料部分有兩個部分，
一個是InvoiceDetail Table內的AlreadyWriteOffAmount欄位資料，另一個是ReceiptManage Table內的
AlreadyWriteOffAmount欄位資料。而當這兩個欄位資料變更時則會影響其他欄位資料必須重新計算。
此沖回按鈕僅有在編輯模式會出現，且此處的按鈕若是已經執行過沖銷則會於此比沖銷紀錄Reversal欄位中紀錄Y，
而執行過沖回的紀錄之後顯示的帳款沖銷按鈕則為disable。且當執行帳款沖回後會將操作此沖回功能的使用者的員工代碼記錄到DoReversal欄位中。
    	 */
    	List<String> sqls = new ArrayList<String>();
    	if(!Util.isEmpty(this.getArWriteOffLogKey())) {
    		ArWriteoffLog log = new ArWriteoffLog(this.getArWriteOffLogKey());
    		log.setDbFields();
    		log.setDoReversal(this.getUserInfo().getAttribute("emp_id"));
    		log.setReversal("Y");
    		
    		InvoiceDetail detail = new InvoiceDetail(log.getParentId());
    		detail.setDbFields();
    		
    		//當沖回時InvoiceDetail Table內的AlreadyWriteOffAmount欄位資料需減去arwriteofflog Table內的WriteOffAmount欄位資料
    		double AlreadyWriteOffAmount = Util.stringToDouble(detail.getAlreadyWriteOffAmount());
    		AlreadyWriteOffAmount -= Util.stringToDouble(log.getWriteOffAmount());
    		detail.setAlreadyWriteOffAmount(Util.round(AlreadyWriteOffAmount, 3) + "");
    		
    		//C.當InvoiceDetail Table中的AlreadyWriteOffAmount欄位變動時(第7項執行完)則須同時執行1.3、5
    		/*
1.3當InvoiceDetail Table中的RequestPay或AlreadyWriteOffAmount或DiscountAmount欄位資料有變動時則重新計算
InvoiceDetail Table中的NotYetWriteOff欄位﹝NotYetWriteOff=RequestPay-AlreadyWriteOffAmount+DiscountAmount；
若當InvoiceDetail Table中的Withholding=Y時，則NotYetWriteOff=RequestPay-AlreadyWriteOffAmount+DiscountAmount-Tax2﹞
    		 */
    		double NotYetWriteOff = Util.stringToDouble(detail.getNotYetWriteOff());
    		NotYetWriteOff += Util.stringToDouble(log.getWriteOffAmount());
    		detail.setNotYetWriteOff(Util.round(NotYetWriteOff, 3) + "");
    		
    		
    		Invoice invoice = new Invoice(log.getInvoiceId());
    		invoice.setDbFields();
    		/*
    		5.當InvoiceDetail Table中的AlreadyWriteOffAmount欄位變動時則重新計算Invoice Table的TotalWriteOffAmount欄位資料
    		﹝TotalWriteOffAmount=為此筆Invoice中所有InvoiceDetail的AlreadyWriteOffAmount總和﹞
    		*/
    		double TotalWriteOffAmount = Util.stringToDouble(invoice.getTotalWriteOffAmount());
    		TotalWriteOffAmount -= Util.stringToDouble(log.getWriteOffAmount());
    		invoice.setTotalWriteOffAmount(Util.round(TotalWriteOffAmount, 3) + "");
    		
    		
    		ReceiptManage manage = new ReceiptManage(log.getReceiptId());
    		manage.setDbFields();
    		/*
8.當ReceiptManage Table中的AlreadyWriteOffAmount或ReceiveNtdAmount或ExchangeGain或ExchangeLoss欄位資料有變動時
則重新計算ReceiptManage Table中的WriteOffBalance欄位資料
﹝WriteOffBalance=ReceiveNtdAmount-ExchangeGain-ExchangeLoss-AlreadyWriteOffAmount﹞。
    		 */
    		double WriteOffBalance = Util.stringToDouble(manage.getWriteOffBalance());
    		WriteOffBalance += Util.stringToDouble(log.getWriteOffAmount());
    		manage.setWriteOffBalance(Util.round(WriteOffBalance, 3) + "");
    		
    		sqls.add(this.getDbUtil().getUpdateSQL(log.getTableName(), log.getDbFields()));
    		sqls.add(this.getDbUtil().getUpdateSQL(detail.getTableName(), detail.getDbFields()));
    		sqls.add(this.getDbUtil().getUpdateSQL(invoice.getTableName(), invoice.getDbFields()));
    		sqls.add(this.getDbUtil().getUpdateSQL(manage.getTableName(), manage.getDbFields()));

    		if(this.getDbUtil().executeUpdate(sqls)) {
    			/*
        		當沖回時ReceiptManage Table內的AlreadyWriteOffAmount欄位資料需減去arwriteofflog Table內的WriteOffAmount欄位資料，
        		而ReceiptManage Table內的AlreadyWriteOffAmount欄位資料改變則須執行以下重新計算：
        		*/
    			String sql = "select AlreadyWriteOffAmount from ReceiptManage where flowkey='" + manage.getFlowKey() + "'";
        		AlreadyWriteOffAmount = this.getDbUtil().getSqlDoubleValue(sql, "AlreadyWriteOffAmount");
        		AlreadyWriteOffAmount -= Util.stringToDouble(log.getWriteOffAmount());
        		this.getDbUtil().executeUpdate("update ReceiptManage set AlreadyWriteOffAmount=" + Util.round(AlreadyWriteOffAmount, 3) + 
        				" where flowkey='" + manage.getFlowKey() + "'");
        		
    			this.setMessage(this.getUserInfo().getMsg("jsp.ArWriteoffLog.WriteOffFinish"));
    		}
    	}    	
    }

    
    public void doPrintProcess() throws Exception {
    	String outFile = null;
    	if(!Util.isEmpty(getSampleDoc())) {
    		String sql = "select Flowkey from reportdefine where SampleDocument='" + getSampleDoc() + "'";
    		String key = this.getDbUtil().getFieldValue(sql, "Flowkey");

    		if(key.startsWith("InvoiceDoc")) {
    			outFile = this.makeInvoiceExcel();
    		}
    		else if(Util.compareTo(key, "ReceiptDoc")) {
    			outFile = this.makeReceiptDoc();
    		}
    		else if(key.startsWith("Multi") || key.startsWith("Single")) {
    			outFile = this.makeHtmlDoc(key);
    		}
    		else {
    			outFile = this.makeDoc();
    		}
    	}
    	if(outFile!=null){
    		this.setOutputFile(outFile);
    	}
	}

    /**
     * 透過Velocity 將html產生出word文件
     * @return
     * @throws Exception
     */
	public String makeHtmlDoc(String reportKey) throws Exception{
    	if(this.getSampleDoc().trim().length()==0){
    		return null;
    	}
		
		try {
			/*
	    	 * 依選擇底稿指定匯出的檔名
	    	 * 1.進口案："Invoice(請款編號invoiceNo)_案件編號(caseNo)_請款日期(voucherDate)"
	    	 * 2.國內案&出口案："請款明細(請款編號invoiceNo)_申請人名稱(caseClient)_請款日期(voucherDate)"
	    	 * 檔名放在fileName中
	    	 */
			Map<String, Object> params = generateReportParam(reportKey);
			
			String sampleDoc = this.getSampleDoc();
	    	String outputFile = "Invoice/"+params.get("fileName");
	    	
	    	String outputDoc = Util.getDocPath()+outputFile;
	    	
	    	File srcFile = new File(outputDoc);
//	    	FileOutputStream fos = new FileOutputStream(srcFile);
//			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));

			StringWriter sw = new StringWriter();
			
			VelocityHelper helper = VelocityHelper.getInstance();
			helper.render(sampleDoc, params, sw);

//			writer.flush();
//			writer.close();
//			fos.close();
			
			//change margin
			createWord(sw.toString(), srcFile);
			
			return "doc/"+outputFile;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	
	
	private void createWord(String html, File srcFile) {
		if(StringUtils.isEmpty(html) || srcFile == null) {
			return;
		}
		try {
			XWPFDocument doc = new XWPFDocument();
			CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
	        CTPageMar pageMar = sectPr.addNewPgMar();
	        pageMar.setLeft(BigInteger.valueOf(720L));
	        pageMar.setTop(BigInteger.valueOf(720L));
	        pageMar.setRight(BigInteger.valueOf(720L));
	        pageMar.setBottom(BigInteger.valueOf(720L));
	        
			addHtml(doc, "chunk1", html);
			FileOutputStream out = new FileOutputStream(srcFile);
			doc.write(out);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void addHtml(XWPFDocument doc, String id, String html) throws Exception {
		OPCPackage oPCPackage = doc.getPackage();
		PackagePartName partName = PackagingURIHelper.createPartName("/word/" + id + ".html");
		PackagePart part = oPCPackage.createPart(partName, "text/html");
		class HtmlRelation extends POIXMLRelation {
			private HtmlRelation() {
				super("text/html", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/aFChunk",
						"/word/htmlDoc#.html");
			}
		}
		class HtmlDocumentPart extends POIXMLDocumentPart {
			private HtmlDocumentPart(PackagePart part) throws Exception {
				super(part);
			}

			@Override
			protected void commit() throws IOException {
				try (OutputStream out = part.getOutputStream()) {
					try (Writer writer = new OutputStreamWriter(out, "UTF-8")) {
						writer.write(html);
					}
				}
			}
		}
		;
		HtmlDocumentPart documentPart = new HtmlDocumentPart(part);
		doc.addRelation(id, new HtmlRelation(), documentPart);
		CTBodyImpl b = (CTBodyImpl) doc.getDocument().getBody();
		QName ALTCHUNK = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "altChunk");
		XmlComplexContentImpl altchunk = (XmlComplexContentImpl) b.get_store().add_element_user(ALTCHUNK);
		QName ID = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
		SimpleValue target = (SimpleValue) altchunk.get_store().add_attribute_user(ID);
		target.setStringValue(id);
	}
	
	/**
	 * 
			#set($accountTitle = '$params.accountTitle' + $index)
			#set($taskDescription = '$params.taskDescription' + $index)
			#set($invoiceAmount = '$params.invoiceAmount' + $index)
			#set($memo = '$params.memo' + $index)
	 * @return
	 */
	private List<Map<String, String>> getDetailMap(String flowkey) throws Exception {
		List<Map<String, String>> list = null;
		
		String SQL = "select FlowKey from invoiceDetail " +
				"where parentid = '" + flowkey + "' " +
				"order by detailorder, flowkey";
		
		Properties cateProp = new Category().getNamesPrpts();
		List<String> keys = this.getDbUtil().getValueList(SQL, "FlowKey");
		for(String key : keys) {
			if(list == null) {
				list = new ArrayList<Map<String, String>>();
			}
			Map<String, String> map = new HashMap<String, String>();
			
			InvoiceDetail d = new InvoiceDetail(key);
			map.put("accountTitle", cateProp.getProperty(d.getAccountTitle()));
			map.put("accountTitleValue", d.getAccountTitle());
			map.put("taskDescription", d.getTaskDescription());
			map.put("invoiceAmount", Util.trimZero(d.getInvoiceAmount()));
			map.put("memo", d.getMemo());
			map.put("invoiceCurrency", d.getInvoiceCurrency());
			map.put("invoiceExchangeRate", d.getInvoiceExchangeRate());
			
			list.add(map);
		}
		
		return list;
	}
    
	private Map<String, Object> generateReportParam(String reportKey) throws Exception {
		if(StringUtils.equals(reportKey, "SingleImportCase_EnUs")) {
			return generateSingleImportCaseEnUs();
		}
		else if(StringUtils.equals(reportKey, "SingleImportCase_ZhCN")) {
			return generateSingleImportCaseZhCN();
		}
		else if(StringUtils.equals(reportKey, "SingleExportCase_All")) {
			return generateMultiExportCase_All(new String[]{this.getFlowKey()});
		}
		else if(StringUtils.equals(reportKey, "SingleDomesticCase_All")) {
			return generateMultiDomesticCase_All(new String[]{this.getFlowKey()});
		}
		else if(StringUtils.equals(reportKey, "MultiExportCase_All")) {
			return generateMultiExportCase_All(this.getMarkKeys());
		}
		else if(StringUtils.equals(reportKey, "MultiDomesticCase_All")) {
			return generateMultiDomesticCase_All(this.getMarkKeys());
		}
		
		return null;
	}
	
	private String findCase(String caseNo) throws Exception {
		String SQL = 
    			"select 'P' as C, p.FlowKey from patentcase p where p.caseno = '" + caseNo + "' " +
				"union " +
				"select 'L' as C, p.FlowKey from legalcase p  where p.caseno = '" + caseNo + "' " +
				"union " +
				"select 'T' as C, p.FlowKey from trademarkcase p  where p.caseno = '" + caseNo + "'" +
				"union " +
				"select 'C' as C, p.FlowKey from copyrightcase p  where p.caseno = '" + caseNo + "'" ;
    	List<Object[]> result = this.getDbUtil().getList(SQL, new String[]{"C", "FlowKey"});
    	if(result != null && result.size() > 0) {
    		return result.get(0)[1].toString();
    	}
    	
    	return "";
	}

	/*
	 * 進口案INVOICE_專商_單件(英文)
	 */
	private Map<String, Object> generateSingleImportCaseEnUs() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Properties cateProp = new Category().getNamesPrpts();

		//上方標題
		String sql = "select flowkey, Names from category where parentid = '" + this.getAttorneyTitle() + "'";
		List<Object[]> vals = this.getDbUtil().getList(sql, new String[] {"flowkey", "Names"});
		for(Object[] val : vals) {
			String key = val[1].toString().replace(this.getAttorneyTitle() + "_", "");
			if(StringUtils.equals(key, "Subtitle2")) {
				List<String> list = Arrays.asList(val[2].toString().split("<br>"));
				map.put(key, list);
			}
			else {
				map.put(key, val[2].toString());
			}
		}
		//檔案名稱 "Invoice(請款編號invoiceNo)_案件編號(caseNo)_請款日期(voucherDate)"
		map.put("fileName", this.getInvoiceNo()+"_"+this.getCaseNo()+"_"+this.getVoucherDate()+".doc");
		//請款日期
		map.put("voucherDate", this.getVoucherDate());
		//客戶名稱
		map.put("clientName", this.getClientName());
		//案件名稱
		map.put("title", this.getTitle());
		//案件類別subType + 商標分類trademarkClassification
		//若可以希望案件類別=商標時，不顯示案件類別，只要商標分類就好
		if(StringUtils.equals("T", findCase(this.getCaseNo()))) {
			map.put("subType", this.getTrademarkClassification());
		}
		else {
			map.put("subType", cateProp.get(this.getSubType()));
		}
		//請款編號
		map.put("invoiceNo", this.getInvoiceNo());
		//案件編號
		map.put("caseNo", this.getCaseNo());
		//申請號
		map.put("applyNo", this.getApplyNo());
		//客戶案號
		map.put("internalNo", this.getInternalNo());
		//申請人名稱
		map.put("caseClient", this.getCaseClient());
		//申請日
		map.put("applyDate", this.getApplyDate());
		//Re: Taiwan(申請國家)_ Patent/Trademark Application (委辦項目)
		map.put("re", new Category(this.getOffice()).getMemo().trim() + "_" + this.getTaskDescription());
		//申請國家
		map.put("office", this.getOffice());
		//官方规费合计 
		map.put("govFeeAmount", Util.trimZero(this.getGovFeeAmount()));
		//本所服务费合计 
		map.put("serviceFeeAmount", Util.trimZero(this.getServiceFeeAmount()));
		
		sql = "select " + DB.SQL_IFNULL + "(sum(Miscellaneous),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"'";
        String miscellaneous = this.getDbUtil().getFieldValue(sql, "count");
        //雜費
		map.put("miscellaneous", Util.trimZero(miscellaneous));
        
		//小计应付金额 (s=a+b)
		double aplusb = Util.round((Util.stringToDouble(this.getGovFeeAmount()) + Util.stringToDouble(this.getServiceFeeAmount())), 2);
		map.put("aplusb", Util.trimZero(aplusb+""));
		//预收金额抵扣 =預收金額
		map.put("amountReceipts", Util.trimZero(this.getAmountReceipts()));
		//实计应付金额 (s-c) 
		double finalAmount = Util.round((aplusb - Util.stringToDouble(this.getAmountReceipts())), 2);
		map.put("finalAmount", Util.trimZero(finalAmount+""));
		
		//請款明細
		map.put("details", getDetailMap(this.getFlowKey()));
		if(map.get("details") != null) {
			List<Map<String, String>> details = (List<Map<String, String>>)map.get("details");
			
			List<Map<String, String>> details1 = new ArrayList<Map<String, String>>();
			List<Map<String, String>> details2 = new ArrayList<Map<String, String>>();
			for(Map<String, String> map2 : details) {
				if(StringUtils.equalsIgnoreCase("AccountTitle01", map2.get("accountTitleValue"))) {
					details1.add(map2);
				}
				else if(StringUtils.equalsIgnoreCase("AccountTitle03", map2.get("accountTitleValue"))) {
					details2.add(map2);
				}
			}
			map.put("details1", details1);
			map.put("details2", details2);
			//第一筆的請款幣別
			map.put("invoiceCurrency", Util.trimZero(details.get(0).get("invoiceCurrency")));
			//本次請款匯率
			map.put("invoiceExchangeRate", Util.trimZero(details.get(0).get("invoiceExchangeRate")));
		}

		return map;
	}

	/*
	 * 出口案請款明細單_專商_多件單件共用
	 */
	private Map<String, Object> generateMultiExportCase_All(String[] markKeys) throws Exception {
		if(markKeys == null || markKeys.length == 0) {
			return null;
		}
		else {
			String keys = Util.arrayToIncond(markKeys);
			String sql = "SELECT count(DISTINCT(AttorneyTitle)) as count FROM invoice where flowkey in (" + keys + ")";
			if(this.getDbUtil().getSqlIntValue(sql, "count") != 1) {
				this.setMessage(this.getUserInfo().getMsg("jsp.Invoice.AttorneyTitleError1"));
				throw new Exception("data error");
			}
			sql = "SELECT count(DISTINCT(client)) as count FROM invoice where flowkey in (" + keys + ")";
			if(this.getDbUtil().getSqlIntValue(sql, "count") != 1) {
				this.setMessage(this.getUserInfo().getMsg("jsp.Invoice.AttorneyTitleError1"));
				throw new Exception("data error");
			}
		}
		Properties cateProp = new Category().getNamesPrpts();
		
		//如果用第一筆請款單來做標的
		Invoice selectedInvoice = new Invoice(markKeys[0]);
		Map<String, Object> map = new HashMap<String, Object>();

		//檔案名稱 "請款明細(請款編號invoiceNo)_申請人名稱(caseClient)_請款日期(voucherDate)"
		map.put("fileName", selectedInvoice.getInvoiceNo()+"_"+selectedInvoice.getCaseClient()+"_"+selectedInvoice.getVoucherDate()+".doc");
		//上方標題
		String sql = "select flowkey, Names from category where parentid = '" + selectedInvoice.getAttorneyTitle() + "'";
		List<Object[]> vals = this.getDbUtil().getList(sql, new String[] {"flowkey", "Names"});
		for(Object[] val : vals) {
			String key = val[1].toString().replace(selectedInvoice.getAttorneyTitle() + "_", "");
			if(StringUtils.equals(key, "Subtitle2")) {
				List<String> list = Arrays.asList(val[2].toString().split("<br>"));
				map.put(key, list);
			}
			else {
				map.put(key, val[2].toString());
			}
		}
		//請款編號
		if(Cnstnts.MAINTAIN.equals(this.getPageActionMode())) {
			map.put("invoiceNo", selectedInvoice.getInvoiceNo());
		}
		else {
			map.put("invoiceNo", "");
		}
		//請款日期
		map.put("voucherDate", selectedInvoice.getVoucherDate());
		//客戶名稱
		map.put("clientName", selectedInvoice.getClientName());
		
		double totalNotIncludeTaxAmount = 0.0;
		double totalTax = 0.0;
		double amountReceipts = 0.0;
		List<Map<String, String>> invoicelist = new ArrayList<Map<String, String>>();
		for(String key : markKeys) {
			Map<String, String> listMap = new HashMap<String, String>();
			Invoice invoice = new Invoice(key);
			//本所編號 
			listMap.put("caseNo", invoice.getCaseNo());
			//申請案號 
			listMap.put("applyNo", invoice.getApplyNo());
			//案件名稱 
			listMap.put("title", invoice.getTitle() + " - " + invoice.getInternalNo());
			//案件類別subType + 商標分類trademarkClassification
			//若可以希望案件類別=商標時，不顯示案件類別，只要商標分類就好
			if(StringUtils.equals("T", findCase(invoice.getCaseNo()))) {
				listMap.put("subType", invoice.getTrademarkClassification());
			}
			else {
				listMap.put("subType", cateProp.get(invoice.getSubType())+"");
			}
			//請款項目說明taskDescription 抓master
			listMap.put("taskDescription", invoice.getTaskDescription());
			//申請國家office，放中文
			listMap.put("office", new Category(invoice.getOffice()).getNames());
			//未稅請款總額原幣totalNotIncludeTaxAmount
			listMap.put("totalNotIncludeTaxAmount", Util.trimZero(invoice.getTotalNotIncludeTaxAmount()));
			
			amountReceipts += Util.stringToDouble(invoice.getAmountReceipts());
			totalNotIncludeTaxAmount += Util.stringToDouble(invoice.getTotalNotIncludeTaxAmount());
			totalTax += Util.stringToDouble(invoice.getTotalTax());

			invoicelist.add(listMap);
		}
		//請款單資料
		map.put("invoices", invoicelist);
		
		//加總未稅請款總額原幣totalNotIncludeTaxAmount
		map.put("totalNotIncludeTaxAmount", Util.trimZero(totalNotIncludeTaxAmount+""));
		//加總營業稅5% totalTax
		map.put("totalTax", Util.trimZero(totalTax+""));
		//小計應付金額 (s=a+b)
		double aplusb = Util.round((totalNotIncludeTaxAmount + totalTax), 2);
		map.put("aplusb", Util.trimZero(aplusb+""));
		//預收金額amountReceipts加總
		map.put("amountReceipts", Util.trimZero(amountReceipts+""));
		//實際應付金額 (s-c)
		double finalAmount = Util.round((aplusb - amountReceipts), 2);
		map.put("finalAmount", Util.trimZero(finalAmount+""));

		//請款明細
		map.put("details", getDetailMap(selectedInvoice.getFlowKey()));
		if(map.get("details") != null) {
			List<Map<String, String>> details = (List<Map<String, String>>)map.get("details");
			//第一筆的請款幣別
			map.put("invoiceCurrency", Util.trimZero(details.get(0).get("invoiceCurrency")));
			//本次請款匯率
			map.put("invoiceExchangeRate", Util.trimZero(details.get(0).get("invoiceExchangeRate")));
		}
		
		return map;
	}

	/*
	 * 國內案請款明細單_專商_多件單件共用
	 */
	private Map<String, Object> generateMultiDomesticCase_All(String[] markKeys) throws Exception {
		if(markKeys == null || markKeys.length == 0) {
			return null;
		}
		else {
			String keys = Util.arrayToIncond(markKeys);
			String sql = "SELECT count(DISTINCT(AttorneyTitle)) as count FROM invoice where flowkey in (" + keys + ")";
			if(this.getDbUtil().getSqlIntValue(sql, "count") != 1) {
				this.setMessage(this.getUserInfo().getMsg("jsp.Invoice.AttorneyTitleError1"));
				throw new Exception("data error");
			}
			sql = "SELECT count(DISTINCT(client)) as count FROM invoice where flowkey in (" + keys + ")";
			if(this.getDbUtil().getSqlIntValue(sql, "count") != 1) {
				this.setMessage(this.getUserInfo().getMsg("jsp.Invoice.AttorneyTitleError1"));
				throw new Exception("data error");
			}
		}
		Properties cateProp = new Category().getNamesPrpts();
		
		//如果用第一筆請款單來做標的
		Invoice selectedInvoice = new Invoice(markKeys[0]);
		Map<String, Object> map = new HashMap<String, Object>();

		//檔案名稱 "請款明細(請款編號invoiceNo)_申請人名稱(caseClient)_請款日期(voucherDate)"
		map.put("fileName", selectedInvoice.getInvoiceNo()+"_"+selectedInvoice.getCaseClient()+"_"+selectedInvoice.getVoucherDate()+".doc");
		//上方標題
		String sql = "select flowkey, Names from category where parentid = '" + selectedInvoice.getAttorneyTitle() + "'";
		List<Object[]> vals = this.getDbUtil().getList(sql, new String[] {"flowkey", "Names"});
		for(Object[] val : vals) {
			String key = val[1].toString().replace(selectedInvoice.getAttorneyTitle() + "_", "");
			if(StringUtils.equals(key, "Subtitle2")) {
				List<String> list = Arrays.asList(val[2].toString().split("<br>"));
				map.put(key, list);
			}
			else {
				map.put(key, val[2].toString());
			}
		}
		//請款編號
		if(Cnstnts.MAINTAIN.equals(this.getPageActionMode())) {
			map.put("invoiceNo", selectedInvoice.getInvoiceNo());
		}
		else {
			map.put("invoiceNo", "");
		}
		//請款日期
		map.put("voucherDate", selectedInvoice.getVoucherDate());
		//客戶名稱
		map.put("clientName", selectedInvoice.getClientName());
		//申請國家office，放中文
		map.put("office", new Category(selectedInvoice.getOffice()).getNames() + " " + selectedInvoice.getOffice());
		
		double govFeeAmount = 0.0;
		double serviceFeeAmount = 0.0;
		double totalTax2 = 0.0;
		double amountReceipts = 0.0;
		List<Map<String, String>> invoicelist = new ArrayList<Map<String, String>>();
		for(String key : markKeys) {
			Map<String, String> listMap = new HashMap<String, String>();
			Invoice invoice = new Invoice(key);
			//本所編號 
			listMap.put("caseNo", invoice.getCaseNo());
			//申請案號 
			listMap.put("applyNo", invoice.getApplyNo());
			//案件名稱 
			listMap.put("title", invoice.getTitle() + " - " + invoice.getInternalNo());
			//案件類別subType + 商標分類trademarkClassification
			//若可以希望案件類別=商標時，不顯示案件類別，只要商標分類就好
			if(StringUtils.equals("T", findCase(invoice.getCaseNo()))) {
				listMap.put("subType", invoice.getTrademarkClassification());
			}
			else {
				listMap.put("subType", cateProp.get(invoice.getSubType())+"");
			}
			//請款項目說明taskDescription 
			listMap.put("taskDescription", invoice.getTaskDescription());
			//官費總額原幣govFeeAmount
			listMap.put("govFeeAmount", Util.trimZero(invoice.getGovFeeAmount()));
			//本所服務費總額原幣serviceFeeAmount
			listMap.put("serviceFeeAmount", Util.trimZero(invoice.getServiceFeeAmount()));
			
			amountReceipts += Util.stringToDouble(invoice.getAmountReceipts());
			govFeeAmount += Util.stringToDouble(invoice.getGovFeeAmount());
			serviceFeeAmount += Util.stringToDouble(invoice.getServiceFeeAmount());
			totalTax2 += Util.stringToDouble(invoice.getTotalTax2());

			invoicelist.add(listMap);
		}
		//請款單資料
		map.put("invoices", invoicelist);
		
		//加總官費總額原幣govFeeAmount
		map.put("govFeeAmount", Util.trimZero(govFeeAmount+""));
		
		//加總本所服務費原幣總額serviceFeeAmount
		map.put("serviceFeeAmount", Util.trimZero(serviceFeeAmount+""));
		
		//執行業務所得10% totalTax2 加總
		map.put("totalTax2", Util.trimZero(totalTax2+""));
		
		//小計應付金額 (s=a+b+c)
		double aplusb = Util.round((govFeeAmount + serviceFeeAmount + totalTax2), 2);
		map.put("aplusb", Util.trimZero(aplusb+""));
		
		//(d) 預收金額抵 扣
		map.put("amountReceipts", Util.trimZero(amountReceipts+""));
		
		//實際應付金額 (s-d)
		double finalAmount = Util.round((aplusb - amountReceipts), 2);
		map.put("finalAmount", Util.trimZero(finalAmount+""));

		//請款明細
		map.put("details", getDetailMap(selectedInvoice.getFlowKey()));
		if(map.get("details") != null) {
			List<Map<String, String>> details = (List<Map<String, String>>)map.get("details");
			//第一筆的請款幣別
			map.put("invoiceCurrency", Util.trimZero(details.get(0).get("invoiceCurrency")));
			//本次請款匯率
			map.put("invoiceExchangeRate", Util.trimZero(details.get(0).get("invoiceExchangeRate")));
		}
		
		return map;
	}

	/*
	 * 進口案INVOICE_專商_單件(簡中)
	 */
	private Map<String, Object> generateSingleImportCaseZhCN() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Properties cateProp = new Category().getNamesPrpts();
		
		//上方標題
		String sql = "select flowkey, Names from category where parentid = '" + this.getAttorneyTitle() + "'";
		List<Object[]> vals = this.getDbUtil().getList(sql, new String[] {"flowkey", "Names"});
		for(Object[] val : vals) {
			String key = val[1].toString().replace(this.getAttorneyTitle() + "_", "");
			if(StringUtils.equals(key, "Subtitle2")) {
				List<String> list = Arrays.asList(val[2].toString().split("<br>"));
				map.put(key, list);
			}
			else {
				map.put(key, val[2].toString());
			}
		}
		//檔案名稱 "Invoice(請款編號invoiceNo)_案件編號(caseNo)_請款日期(voucherDate)"
		map.put("fileName", this.getInvoiceNo()+"_"+this.getCaseNo()+"_"+this.getVoucherDate()+".doc");
		//請款日期
		map.put("voucherDate", this.getVoucherDate());
		//客戶名稱
		map.put("clientName", this.getClientName());
		//案件名稱
		map.put("title", this.getTitle());
		//案件類別subType + 商標分類trademarkClassification
		//若可以希望案件類別=商標時，不顯示案件類別，只要商標分類就好
		if(StringUtils.equals("T", findCase(this.getCaseNo()))) {
			map.put("subType", this.getTrademarkClassification());
		}
		else {
			map.put("subType", cateProp.get(this.getSubType()));
		}
		//請款編號
		map.put("invoiceNo", this.getInvoiceNo());
		//案件編號
		map.put("caseNo", this.getCaseNo());
		//申請號
		map.put("applyNo", this.getApplyNo());
		//客戶案號
		map.put("internalNo", this.getInternalNo());
		//申請人名稱
		map.put("caseClient", this.getCaseClient());
		//申請日
		map.put("applyDate", this.getApplyDate());
		//申請國家
		map.put("office", this.getOffice() + "-" + new Category(this.getOffice()).getNames());
		//官方规费合计 
		map.put("govFeeAmount", Util.trimZero(this.getGovFeeAmount()));
		//本所服务费合计 
		map.put("serviceFeeAmount", Util.trimZero(this.getServiceFeeAmount()));
		//小计应付金额 (s=a+b)
		double aplusb = Util.round((Util.stringToDouble(this.getGovFeeAmount()) + Util.stringToDouble(this.getServiceFeeAmount())), 2);
		map.put("aplusb", Util.trimZero(aplusb+""));
		//预收金额抵扣 =預收金額
		map.put("amountReceipts", Util.trimZero(this.getAmountReceipts()));
		//实计应付金额 (s-c) 
		double finalAmount = Util.round((aplusb - Util.stringToDouble(this.getAmountReceipts())), 2);
		map.put("finalAmount", Util.trimZero(finalAmount+""));
		
		//請款明細
		map.put("details", getDetailMap(this.getFlowKey()));
		if(map.get("details") != null) {
			List<Map<String, String>> details = (List<Map<String, String>>)map.get("details");
			//第一筆的請款幣別
			map.put("invoiceCurrency", Util.trimZero(details.get(0).get("invoiceCurrency")));
			//本次請款匯率
			map.put("invoiceExchangeRate", Util.trimZero(details.get(0).get("invoiceExchangeRate")));
		}

		return map;
	}

    @SuppressWarnings("unchecked")
	public String makeDoc() throws Exception{
    	////System.out.println("getSampleDoc=" +getSampleDoc());
    	if(this.getSampleDoc().trim().length()==0){
    		return null;
    	}
    	OoConverter oc = new OoConverter("localhost", "8100");
    	String sampleDoc = "file:///"+Util.getTomcatPath()+this.getSampleDoc();
    	String outputFile = "Invoice/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".doc";
    	String outputDoc = "file:///"+Util.getDocPath()+outputFile;
    	
    	if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		Invoice invoice = new Invoice(this.getFlowKey());
    		invoice.setDbFields();
    		invoice.setUserInfo(this.getUserInfo());
    		
    		invoice.doReloadProcess();
    		
    		Properties empProp = new Employee().getNamesPrpts();
    		Properties cateProp = new Category().getNamesPrpts();
    		Properties matterProp = new PatentMatterConfig().getNamesPrpts();
    		matterProp.putAll(cateProp);
    		
    		Map data = new HashMap<String, String>();
    		Calendar calendar = Calendar.getInstance();
    		data.put("${today}", (calendar.get(Calendar.YEAR) - 1911) + "年" +
    				(calendar.get(Calendar.MONTH) + 1) + "月" +
    				calendar.get(Calendar.DAY_OF_MONTH) + "日");
    		data.put("${InvoiceTitle}", cateProp.get(invoice.getAttorneyTitle()));
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat ad_sdf = new SimpleDateFormat("yyyy/MM/dd");
    		data.put("${today2}", ad_sdf.format(sdf.parse(Util.getDate())));
    		
    		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat ad_sdf3 = new SimpleDateFormat("yyyy年MM月dd日");
    		data.put("${today3}", ad_sdf3.format(sdf3.parse(Util.getDate())));
    		
    		data.put("${today4}", (calendar.get(Calendar.YEAR) - 1911) + "/" +
    				String.format("%02d", (calendar.get(Calendar.MONTH) + 1)) + "/" +
    				String.format("%02d", (calendar.get(Calendar.DAY_OF_MONTH))));
    		
    		String invoiceYear ="";
    		String invoiceMonth ="";
    		String realYear= "";
    		
    		if(this.getInvoiceDate().length() >0){    		
    		invoiceYear = this.getInvoiceDate().substring(0,4);
    		invoiceMonth = this.getInvoiceDate().substring(5,7);
    		int y =  Integer.parseInt(invoiceYear);
    		int countYear = y - 1911;
    		realYear = Integer.toString(countYear);}
    		   		
    		
    		data.put("${year}" , realYear );
    		data.put("${month}" , invoiceMonth ); 
    		
    		List<Field> dbFields = invoice.getDbFields();
    		
//    		Properties categoryProp = new Category().getNamesPrpts();
//    		Properties employeeProp = new Employee().getNamesPrpts();
//    		Properties attorneyProp = new Attorney().getNamesPrpts();
    		Properties applicantProp = new Applicant().getNamesPrpts();
    		Properties clientProp = new Client().getNamesPrpts();
    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
    		int GovFee = 0;
    		int AttorneyFeeNtd = 0;
    		
    		int serviceFeeAmount = 0;
    		int totalTax2 = 0;
    		int servicePlusTax2 = 0;
    		
    		for(Field field : dbFields) {
    			data.put("${"+ field.getName() + "}", 
    					(field.getValue()==null || field.getValue().equalsIgnoreCase("null"))?"":field.getValue());
    			
//    			if(field.getValue() != null && !field.getValue().equalsIgnoreCase("null")) {
        			String name = field.getName();
        			String value = (field.getValue()==null || field.getValue().equalsIgnoreCase("null"))?"":field.getValue();
        			if(name.endsWith("Date") || name.endsWith("DateTo") ||
        					name.equalsIgnoreCase("DeadLine")) {
//    					try {
//        					data.put("${AD_" + name + "}", ad_sdf.format(sdf.parse(value)));
//        				}
//        				catch(Exception e) {}
//        				
//    					try {
//    						GregorianCalendar cal = new GregorianCalendar();
//    						cal.setTime(sdf.parse(value));
//        					data.put("${ROC_" + name + "}", (cal.get(Calendar.YEAR) - 1911) + roc_sdf.format(sdf.parse(value)));
//        				}
//        				catch(Exception e) {}
//        				
//        				try {
//        					value = sdf2.format(sdf.parse(value));
//        				}
//        				catch(Exception e) {}

        				//將日期轉換成年月日
        				data = Util.putDateToMap(name, value, data);
        				
//        				////System.out.println(name + " " + value + " " + data.get("${ROC_" + name + "}"));
//        				////System.out.println(name + " " + value + " " + data.get("${AD_" + name + "}"));
        			}
        			else if(field.getName().equals("InCharge")||
	    					field.getName().equals("TaskCreator")) {
	    				data.put("${"+ field.getName() + "}", (empProp.get(field.getValue()) == null ?"":empProp.get(field.getValue())));
	    			}
//	    			else if(field.getName().equals("CaseClient")) {
//	    				data.put("${"+ field.getName() + "}", (clientProp.get(field.getValue()) == null ?"":clientProp.get(field.getValue())));
//	    			}
	    			else if(field.getName().equals("Matter")) {
	    				data.put("${"+ field.getName() + "}", (matterProp.get(field.getValue()) == null ?"":matterProp.get(field.getValue())));
	    			}
	    			else if(field.getName().equals("Office") ||
	    					field.getName().equals("SubType")||
	    					field.getName().equals("InvoiceType")||
	    					field.getName().equals("Matter")||
	    					field.getName().equals("CaseType")||
	    					field.getName().equals("AttorneyTitle")||
	    					field.getName().equals("InvoiceStatus")) {
	    				data.put("${"+ field.getName() + "}", (cateProp.get(field.getValue()) == null ?"":cateProp.get(field.getValue())));
	    			}
	    			else if(name.equalsIgnoreCase("ClientContect")) {
	    				value = applicantProp.getProperty(value);
	    				data.put("${"+ field.getName() + "}", value);
	    			}
        			
        			//下列欄位在一般套印時請呈現大寫：${ServiceFee} 和 ${GovFee} 和 ${AttorneyFeeNtd} 
        			//另要有一變數顯示此兩欄位的加總 ${AttorneyFeeNtd}+${GovFee}
        			//上述變數在範本文件中要怎麼定義在請提供
        			if(
        					field.getName().equals("ServiceFee") ||
        					field.getName().equals("GovFee") ||
//        					field.getName().equals("AttorneyFee") ||
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
        			if(field.getName().equals("ServiceFeeAmount")){
        				serviceFeeAmount = Integer.parseInt(new DecimalFormat("0").format(Double.parseDouble(field.getValue())));
        			}
        			if(field.getName().equals("TotalTax2")){
        				totalTax2 = Integer.parseInt(new DecimalFormat("0").format(Double.parseDouble(field.getValue())));
        			}
        			
//    			}
    		}
    		
    		servicePlusTax2 = serviceFeeAmount + totalTax2;
    		data.put("${ServicePlusTax2}", servicePlusTax2+"");
			
			if(!Util.isEmpty(this.getClient())) {
				Client client = new Client(this.getClient());

				data.putAll(client.getDocMap());
			}
    		
			if(!Util.isEmpty(this.getBillingContact())) {
				data.put("${BillingContact}", new Applicant(this.getBillingContact()).getNames());
			}
			else {
				data.put("${BillingContact}", "");
			}
			data.put("${BillingContact}", this.getBillingContact());
			
    		//data.put("${AttorneyFeeNtd_GovFee}", (GovFee+AttorneyFeeNtd)+"");
    		data.put("${AttorneyFeeNtd_GovFee}", Util.formatNumber((GovFee+AttorneyFeeNtd), "###,###"));
    		data.put("${ROC_AttorneyFeeNtd_GovFee}", Util.numberToRocString((GovFee+AttorneyFeeNtd)+""));
    		
    		/*
    		 * 需要額外處理的欄位
    		 */
    		/*
             * 服務費金額(=所有明細科目為03者之本次請款金額加總）
             */
//            String sql = "select if(sum(i.InvoiceAmount) is null , 0 , sum(i.InvoiceAmount)) as count from InvoiceDetail i, todos t " +
//		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle03'";
//            //若是工時請款產生的，就要直接抓請款明細資料
//            if(Util.compareTo(this.getTimesheetMerge(), "Y")) {
    		String sql = "select " + DB.SQL_IFNULL + "(sum(IncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
					"and accounttitle = 'AccountTitle03'";
//            }
		    String sum = this.getDbUtil().getFieldValue(sql, "count");
		    //data.put("${ServiceFeeAmount}", (int)Util.round(Util.stringToDouble(sum), 0)+"");
		    data.put("${ServiceFeeAmount}", Util.formatNumber(Util.round(Util.stringToDouble(sum), 2), "###,###.00"));
		    
		    sql = "select i.invoiceCurrency as currency from InvoiceDetail i " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and i.accounttitle = 'AccountTitle03' " +
		    		"and i.Currency != ''";
		    String currency =this.getDbUtil().getFieldValue(sql, "currency");
		    data.put("${ServiceFeeCurrency}", (cateProp.get(currency) == null ?"":cateProp.get(currency)));
    		
		    sql = "select if(sum(Tax2) is null , 0 , sum(Tax2)) as count from InvoiceDetail where WithHolding='Y' and ParentId ='" + this.getFlowKey() + "'";
            sum = this.getDbUtil().getFieldValue(sql,"count"); 
            //data.put("${TotalWithHolding}", (int)Util.round(Util.stringToDouble(sum), 0)+"");
            data.put("${TotalWithHolding}", Util.formatNumber((int)Util.round(Util.stringToDouble(sum), 0), "###,###"));
            
            /*
             * 代收政府規費金額(=所有明細科目為01者之本次請款金額加總）
             */
//            sql = "select if(sum(i.InvoiceAmount) is null , 0 , sum(i.InvoiceAmount)) as count from InvoiceDetail i, todos t " +
//		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle01'";
//            //若是工時請款產生的，就要直接抓請款明細資料
//            if(Util.compareTo(this.getTimesheetMerge(), "Y")) {
            sql = "select " + DB.SQL_IFNULL + "(sum(IncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
					"and accounttitle = 'AccountTitle01'";
//            }
            sum = this.getDbUtil().getFieldValue(sql, "count");
            //data.put("${GovFeeAmount}", (int)Util.round(Util.stringToDouble(sum), 0)+"");
            data.put("${GovFeeAmount}", Util.formatNumber(Util.round(Util.stringToDouble(sum), 2), "###,###.00"));
            
            sql = "select i.invoiceCurrency as currency from InvoiceDetail i " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and i.accounttitle = 'AccountTitle01' " +
		    		"and i.Currency != ''";
            currency =this.getDbUtil().getFieldValue(sql, "currency");
		    data.put("${GovFeeCurrency}", (cateProp.get(currency) == null ?"":cateProp.get(currency)));
            /*
             * “複代理費台幣總額”(=所有明細科目為02者之本次請款金額加總）
             */
//            sql = "select if(sum(i.InvoiceAmount) is null , 0 , sum(i.InvoiceAmount)) as count from InvoiceDetail i, todos t " +
//		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle02'";
//            //若是工時請款產生的，就要直接抓請款明細資料
//            if(Util.compareTo(this.getTimesheetMerge(), "Y")) {
		    sql = "select " + DB.SQL_IFNULL + "(sum(IncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
		    		"and accounttitle = 'AccountTitle02'";
//            }
            sum = this.getDbUtil().getFieldValue(sql, "count");
            //data.put("${AttorneyFee}", (int)Util.round(Util.stringToDouble(sum), 0)+"");
            data.put("${AttorneyFee}", Util.formatNumber(Util.round(Util.stringToDouble(sum), 2), "###,###.00"));
            
//            sql = "select if(sum(i.RequestPay) is null , 0 , sum(i.RequestPay)) as count from InvoiceDetail i, todos t " +
//		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle04'";
//            //若是工時請款產生的，就要直接抓請款明細資料
//            if(Util.compareTo(this.getTimesheetMerge(), "Y")) {
//            	sql = "select if(sum(i.RequestPay) is null , 0 , sum(i.RequestPay)) as count from InvoiceDetail i " +
//    		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//    		    		"and i.accounttitle = 'AccountTitle04'";
            sql = "select " + DB.SQL_IFNULL + "(sum(IncludeTaxAmount),0) as count from invoicedetail where parentId = '"+this.getFlowKey()+"' " +
		    		"and accounttitle = 'AccountTitle04'";
//            }
            sum = this.getDbUtil().getFieldValue(sql, "count");
            //data.put("${OtherFee}", (int)Util.round(Util.stringToDouble(sum), 0)+"");
            data.put("${OtherFee}", Util.formatNumber(Util.round(Util.stringToDouble(sum), 2), "###,###.00"));
            
            /*
    		 * 需要額外處理的欄位 end
    		 */
            
    		String total2 = (int)Util.round(Util.stringToDouble(invoice.getServiceFee()) +
    				Util.stringToDouble(invoice.getGovFee()), 0) + "";
    		data.put("${TotalFee}", Util.numberToRocString(total2));
    		
    		//data.put("${TotalFeeNum}", total2);
    		data.put("${TotalFeeNum}", Util.formatNumber(Util.stringToInt(total2), "###,###"));
    		
    		/*
    		 * 若所套印之請款單明細(InvoiceDetail)中有任一筆資料的他方扣繳(WithHolding)為Y時，
    		 * 則此欄位計算為代收政府規費台幣總額(GovFee)”加上(“服務費台幣總額(ServiceFee)”乘以0.9)
    		 */
    		sql = "select count(1) as count from invoicedetail where parentid ='" + this.getFlowKey() + 
    				"' and WithHolding = 'Y'";
    		int count = this.getDbUtil().getSqlIntValue(sql, "count");
    		if(count > 0) {
    			//data.put("${WithHoldingFee}", (int)Util.round(Util.stringToDouble(this.getGovFee()) + Util.stringToDouble(this.getServiceFee())*0.9, 0) + "");
    			data.put("${WithHoldingFee}", Util.formatNumber((int)Util.round(Util.stringToDouble(this.getGovFee()) + Util.stringToDouble(this.getServiceFee())*0.9, 0), "###,###"));
    		}
    		else {
    			data.put("${WithHoldingFee}", "");	
    		}
    		
    		//抓取執行所得10%
    		sql = "select if(sum(Tax2) is null , 0 , sum(Tax2)) as count from InvoiceDetail where ParentId ='" + this.getFlowKey() + "'";
    		double Tax2 = Util.round(this.getDbUtil().getSqlDoubleValue(sql, "count"), 0);
    		//data.put("${Tax2}",  (int)Tax2 + "");
    		data.put("${Tax2}", Util.formatNumber(Tax2, "###,###"));
    		
    		double total = Tax2 + Util.stringToDouble(invoice.getServiceFee());
    		//data.put("${Tax2+ServiceFee}", (int)total + "");
    		data.put("${Tax2+ServiceFee}", Util.formatNumber(total, "###,###"));
    		
    		sql = "select if(sum(RequestPay) is null , 0 , sum(RequestPay)) as count from InvoiceDetail i, todos t " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle02'";
    		double AttorneyFee = this.getDbUtil().getSqlDoubleValue(sql, "count");
    		
    		////System.out.println(sql + " " + AttorneyFee);
    		//data.put("${AttorneyFeeNtd}", (int)AttorneyFee + "");
    		data.put("${AttorneyFeeNtd}", Util.formatNumber(AttorneyFee, "###,###"));
    		
    		sql = "select if(sum(RequestPay) is null , 0 , sum(RequestPay)) as count from InvoiceDetail i, todos t " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle04'";
			double OtherFee = this.getDbUtil().getSqlDoubleValue(sql, "count");
    		//data.put("${OtherFeeNtd}", (int)OtherFee + "");
			data.put("${OtherFeeNtd}", Util.formatNumber(OtherFee, "###,###"));
			
    		total = Util.round(AttorneyFee + OtherFee + Util.stringToDouble(invoice.getServiceFee()) +
    				Util.stringToDouble(invoice.getGovFee()), 0);
    		//data.put("${AttorneyFee+ServiceFee+GovFee}", (int)total + "");
			data.put("${AttorneyFee+ServiceFee+GovFee}", Util.formatNumber(total, "###,###"));
    		
    		//data.put("${AttorneyFee+ServiceFee+GovFee-Tax2}", (int)Util.round(total - Tax2, 0) + "");
			data.put("${AttorneyFee+ServiceFee+GovFee-Tax2}", Util.formatNumber( (int)Util.round(total - Tax2, 0), "###,###"));
    		
    		
    		sql = "select i.invoiceCurrency as currency from InvoiceDetail i " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and i.accounttitle = 'AccountTitle02' " +
		    		"and i.Currency != ''";
    		data.put("${AttorneyCurrency}", cateProp.get(this.getDbUtil().getFieldValue(sql, "currency")));
		    
    		
		    sql = "select if(sum(RequestPay) is null , 0 , sum(RequestPay)) as count from InvoiceDetail i, todos t " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle02'";
		    //data.put("${AttorneyFeeNtd}", this.getDbUtil().getFieldValue(sql, "count"));
			data.put("${AttorneyFeeNtd}", Util.formatNumber(Util.stringToInt(this.getDbUtil().getFieldValue(sql, "count")), "###,###"));
		    
		    sql = "select i.invoiceCurrency as currency from InvoiceDetail i " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and i.accounttitle = 'AccountTitle04' " +
		    		"and i.Currency != ''";
		    data.put("${OtherCurrency}", cateProp.get(this.getDbUtil().getFieldValue(sql, "currency")));
		    
		    sql = "select if(sum(RequestPay) is null , 0 , sum(RequestPay)) as count from InvoiceDetail i, todos t " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle04'";
		    //data.put("${OtherFeeNtd}", this.getDbUtil().getFieldValue(sql, "count"));
		    data.put("${OtherFeeNtd}", Util.formatNumber(Util.stringToInt(this.getDbUtil().getFieldValue(sql, "count")), "###,###"));
    		
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
    
    
    @SuppressWarnings("unchecked")
	public String makeReceiptDoc() throws Exception{
    	////System.out.println("getSampleDoc=" +getSampleDoc());
    	if(this.getSampleDoc().trim().length()==0){
    		return null;
    	}
    	OoConverter oc = new OoConverter("localhost", "8100");
    	String sampleDoc = "file:///"+Util.getTomcatPath()+this.getSampleDoc();
    	String outputFile = "Invoice/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".doc";
    	String outputDoc = "file:///"+Util.getDocPath()+outputFile;
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat roc_sdf = new SimpleDateFormat("年MM月dd日");
		SimpleDateFormat ad_sdf = new SimpleDateFormat("yyyy/MM/dd");
    	
    	if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		Invoice invoice = new Invoice(this.getFlowKey());
    		invoice.setDbFields();
    		invoice.setUserInfo(this.getUserInfo());
    		
    		invoice.doReloadProcess();
    		
    		Properties empProp = new Employee().getNamesPrpts();
    		Properties cateProp = new Category().getNamesPrpts();
    		Properties matterProp = new PatentMatterConfig().getNamesPrpts();
    		matterProp.putAll(cateProp);
    		
    		Map data = new HashMap<String, String>();
    		Calendar calendar = Calendar.getInstance();
    		String TotalNotIncludeTaxAmountNtd = (Util.stringToInt(invoice.convertMoneyFormat(this.getGovFee(), "NTD")) +
        			Util.stringToInt(this.convertMoneyFormat(invoice.getServiceFee(), "NTD")) + 
        			Util.stringToInt(this.convertMoneyFormat(invoice.getAttorneyFeeNtd(), "NTD"))) + "";

    		
    		data.put("${TotalNotIncludeTaxAmountNtd}", TotalNotIncludeTaxAmountNtd);
    		data.put("${VoucherDate}", invoice.getVoucherDate());
    		data.put("${InvoiceTitle}", invoice.getInvoiceTitle());
    		data.put("${CaseNo}", invoice.getCaseNo());
    		data.put("${TaskDescription}", invoice.getTaskDescription());
    		data.put("${ServiceFee}", invoice.getServiceFee());
    		data.put("${GovFee}", invoice.getGovFee());
    		data.put("${Title}", invoice.getTitle());
    		data.put("${InvoiceNo}", invoice.getInvoiceNo());
    		data.put("${InternalNo}", (invoice.getInternalNo()==null)?"":invoice.getInternalNo());
    		
    		//抓取執行所得10%
    		String sql = "select sum(Tax2) as count from InvoiceDetail where ParentId ='" + this.getFlowKey() + "'";
    		double tax2 = Util.round(this.getDbUtil().getSqlDoubleValue(sql, "count"), 0);
    		data.put("${Tax2}",  (int)tax2 + "");
    		data.put("${Tax2}", Util.formatNumber((int)tax2, "###,###"));
    		
    		double total = tax2 + Util.stringToDouble(invoice.getServiceFee());
    		data.put("${Tax2+ServiceFee}", (int)total + "");
    		data.put("${Tax2+ServiceFee}", Util.formatNumber((int)total, "###,###"));
    		
    		//抓取執行所得10%
    		sql = "select sum(Tax2) as count from InvoiceDetail where ParentId ='" + this.getFlowKey() + "'";
    		double Tax2 = Util.round(this.getDbUtil().getSqlDoubleValue(sql, "count"), 0);
    		data.put("${Tax2}", (int)Tax2 + "");
    		data.put("${Tax2}", Util.formatNumber((int)Tax2, "###,###"));
    		
    		sql = "select sum(RequestPay) as count from InvoiceDetail i, todos t " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle02'";
    		double AttorneyFee = this.getDbUtil().getSqlDoubleValue(sql, "count");
    		
//    		////System.out.println(sql + " " + AttorneyFee);
    		data.put("${AttorneyFeeNtd}", (int)AttorneyFee + "");
    		data.put("${AttorneyFeeNtd}", Util.formatNumber((int)AttorneyFee, "###,###"));
    		
    		sql = "select sum(RequestPay) as count from InvoiceDetail i, todos t " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle04'";
			double OtherFee = this.getDbUtil().getSqlDoubleValue(sql, "count");
    		data.put("${OtherFeeNtd}", (int)OtherFee + "");
    		data.put("${OtherFeeNtd}", Util.formatNumber((int)OtherFee, "###,###"));
			
    		total = Util.round(AttorneyFee + OtherFee + Util.stringToDouble(invoice.getServiceFee()) +
    				Util.stringToDouble(invoice.getGovFee()), 0);
    		data.put("${AttorneyFee+ServiceFee+GovFee}", (int)total + "");
    		data.put("${AttorneyFee+ServiceFee+GovFee}", Util.formatNumber((int)total, "###,###"));
    		
    		data.put("${AttorneyFee+ServiceFee+GovFee-Tax2}", (int)Util.round(total - Tax2, 0) + "");
    		data.put("${AttorneyFee+ServiceFee+GovFee-Tax2}", Util.formatNumber((int)Util.round(total - Tax2, 0), "###,###"));

    		Calendar cal = Calendar.getInstance();
    		data.put("${today}", (cal.get(Calendar.YEAR) - 1911) + roc_sdf.format(sdf.parse(Util.getDate())));
    		data.put("${today2}", ad_sdf.format(sdf.parse(Util.getDate())));
    		
    		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat ad_sdf3 = new SimpleDateFormat("yyyy年MM月dd日");
    		data.put("${today3}", ad_sdf3.format(sdf3.parse(Util.getDate())));
    		
    		data.put("${today4}", (calendar.get(Calendar.YEAR) - 1911) + "/" +
    				String.format("%02d", (calendar.get(Calendar.MONTH) + 1)) + "/" +
    				String.format("%02d", (calendar.get(Calendar.DAY_OF_MONTH))));
    		
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
    
    @SuppressWarnings("unchecked")
	public String makeInvoiceDoc() throws Exception{
    	////System.out.println("getSampleDoc=" +getSampleDoc());
    	if(this.getSampleDoc().trim().length()==0){
    		return null;
    	}
    	OoConverter oc = new OoConverter("localhost", "8100");
    	String sampleDoc = "file:///"+Util.getTomcatPath()+this.getSampleDoc();
    	String outputFile = "Invoice/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".doc";
    	String outputDoc = "file:///"+Util.getDocPath()+outputFile;
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat roc_sdf = new SimpleDateFormat("年MM月dd日");
		SimpleDateFormat ad_sdf = new SimpleDateFormat("yyyy/MM/dd");
    	
    	////System.out.println(sampleDoc + " " + outputDoc);
    	if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		Invoice invoice = new Invoice(this.getFlowKey());
    		invoice.setDbFields();
    		invoice.setUserInfo(this.getUserInfo());

    		invoice.doReloadProcess();
    		
    		Properties empProp = new Employee().getNamesPrpts();
    		Properties cateProp = new Category().getNamesPrpts();
    		Properties matterProp = new PatentMatterConfig().getNamesPrpts();
    		matterProp.putAll(cateProp);
    		
    		Map data = new HashMap<String, String>();
    		Calendar calendar = Calendar.getInstance();

    		String TotalNotIncludeTaxAmountNtd = (Util.stringToInt(invoice.convertMoneyFormat(this.getGovFee(), "NTD")) +
        			Util.stringToInt(this.convertMoneyFormat(invoice.getServiceFee(), "NTD")) + 
        			Util.stringToInt(this.convertMoneyFormat(invoice.getAttorneyFeeNtd(), "NTD"))) + "";

    		
    		data.put("${TotalNotIncludeTaxAmountNtd}", TotalNotIncludeTaxAmountNtd);
    		data.put("${VoucherDate}", invoice.getVoucherDate());
    		data.put("${InvoiceTitle}", invoice.getInvoiceTitle());
    		data.put("${CaseNo}", invoice.getCaseNo());
    		data.put("${TaskDescription}", invoice.getTaskDescription());
    		data.put("${ServiceFee}", invoice.getServiceFee());
    		data.put("${GovFee}", invoice.getGovFee());
    		data.put("${InternalNo}", (invoice.getInternalNo()==null)?"":invoice.getInternalNo());
    		
//    		////System.out.println(invoice.getVoucherDate() + " " + data.get("VoucherDate"));
    		
    		//抓取執行所得10%
    		String sql = "select sum(Tax2) as count from InvoiceDetail where ParentId ='" + this.getFlowKey() + "'";
    		double Tax2 = Util.round(this.getDbUtil().getSqlDoubleValue(sql, "count"), 0);
    		data.put("${Tax2}", (int)Tax2 + "");
    		data.put("${Tax2}", Util.formatNumber((int)Tax2, "###,###"));
    		
    		sql = "select sum(RequestPay) as count from InvoiceDetail i, todos t " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle02'";
    		double AttorneyFee = this.getDbUtil().getSqlDoubleValue(sql, "count");
    		
    		////System.out.println(sql + " " + AttorneyFee);
    		data.put("${AttorneyFeeNtd}", (int)AttorneyFee + "");
    		data.put("${AttorneyFeeNtd}", Util.formatNumber((int)AttorneyFee, "###,###"));
    		
    		sql = "select sum(RequestPay) as count from InvoiceDetail i, todos t " +
		    		"where i.ParentId ='" + this.getFlowKey() + "' " +
		    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle04'";
			double OtherFee = this.getDbUtil().getSqlDoubleValue(sql, "count");
    		data.put("${OtherFeeNtd}", (int)OtherFee + "");
    		data.put("${OtherFeeNtd}", Util.formatNumber((int)OtherFee, "###,###"));
			
    		double total = Util.round(AttorneyFee + OtherFee + Util.stringToDouble(invoice.getServiceFee()) +
    				Util.stringToDouble(invoice.getGovFee()), 0);
    		data.put("${Total}", (int)total + "");
    		data.put("${Total}", Util.formatNumber((int)total, "###,###"));
    		
    		data.put("${Final}", (int)Util.round(total - Tax2, 0) + "");
    		data.put("${Final}", Util.formatNumber((int)Util.round(total - Tax2, 0), "###,###"));
    		
    		Calendar cal = Calendar.getInstance();
    		data.put("${today}", (cal.get(Calendar.YEAR) - 1911) + roc_sdf.format(sdf.parse(Util.getDate())));
    		data.put("${today2}", ad_sdf.format(sdf.parse(Util.getDate())));
    		
    		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat ad_sdf3 = new SimpleDateFormat("yyyy年MM月dd日");
    		data.put("${today3}", ad_sdf3.format(sdf3.parse(Util.getDate())));
    		
    		data.put("${today4}", (calendar.get(Calendar.YEAR) - 1911) + "/" +
    				String.format("%02d", (calendar.get(Calendar.MONTH) + 1)) + "/" +
    				String.format("%02d", (calendar.get(Calendar.DAY_OF_MONTH) )));
    		
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
    
    public boolean delete() throws Exception {
		super.delete();
		
		String sql2 = "delete from invoicedetail where parentid ='" + this.getFlowKey() + "'";
		
		/*
		 * 且若符合刪除之條件，則需根據每筆請款明細中的RequestPay資料
		 * 重新計算該請款明細所屬的Todos內的RequestPayAmount及NotYetRequestPayAmount欄位。
		 */
		/*
    	 * 若符合刪除條件且將此筆請款明細刪除，
    	 * 刪除時需重新計算此筆InvoiceDetail的所屬的ToDos的RequestPayAmount及NotYetRequestPayAmount欄位，
    	 * 重新計算方式為將Todos的RequestPayAmount值減去InvoiceDetail的RequestPay值存回Todos的RequestPayAmount，
    	 * 以及將Todos的NotYetRequestPayAmount值加上InvoiceDetail的RequestPay值存回Todos的NotYetRequestPayAmount。
    	 */
		String sql = "select flowkey from invoicedetail where parentid ='" + this.getFlowKey() + "'";
		List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
		for(String key : keys) {
			InvoiceDetail detail = new InvoiceDetail(key);
			ToDos todo = new ToDos(detail.getTodosId());
            
        	String request = Util.round((Util.stringToDouble(todo.getRequestPayAmount()) -
        			Util.stringToDouble(detail.getRequestPay())), 0) + "";
        	
        	String notyet = Util.round((Util.stringToDouble(todo.getNotYetRequestPayAmount()) +
        			Util.stringToDouble(detail.getRequestPay())), 0) + "";
        	
            sql = "update todos set NotYetRequestPayAmount = " + notyet + "," +
            			"RequestPayAmount = " + request + 
            			" where flowkey='" + detail.getTodosId() + "'";

            this.getDbUtil().executeUpdate(sql);
		}
		
		//刪除該請款單時，要刪除該請款與明細，要將相關工時記錄資料的請款狀態欄位改寫回N、若此請款單已有沖銷，並要刪除相關收款管理資料與沖銷記錄。
		sql = "select timesheet_flowkey from invoice_timesheet where invoice_flowkey = '" + this.getFlowKey() + "'";
		keys = this.getDbUtil().getValueList(sql, "timesheet_flowkey");
		if(keys != null && keys.size() > 0) {
			this.getDbUtil().executeUpdate("delete from invoice_timesheet where invoice_flowkey = '" + this.getFlowKey() + "'");
			for(String key : keys) {
				this.getDbUtil().executeUpdate("update timesheetmanagement set Billed = 'TS01' where flowkey = '" + key + "'");
			}
		}
		
		return this.getDbUtil().executeUpdate(sql2);
	}
    public void setResultFields() {
    	this.ResultFields = new LinkedHashMap<String, Field>();
    	
    	Properties attorneyPrpt = null;
   	 	try {
			attorneyPrpt = new Attorney().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}

    	this.ResultFields.put(this.VoucherDate.getName(), this.VoucherDate);
    	this.ResultFields.put(this.CaseNo.getName(), this.CaseNo);
    	this.ResultFields.put(this.CaseNo2.getName(), this.CaseNo2);
        this.ResultFields.put(this.InvoiceNo.getName(), this.InvoiceNo);
        this.ResultFields.put(this.InvoiceTitle.getName(), this.InvoiceTitle);
        this.ResultFields.put(this.AttorneyTitle.getName(), this.AttorneyTitle);
        this.ResultFields.put(this.TaskDescription.getName(), this.TaskDescription);
        this.ResultFields.put(this.Client.getName(), this.Client);
    	this.ResultFields.put(this.ClientName.getName(), this.ClientName);
    	this.ResultFields.put(this.InternalNo.getName(), this.InternalNo);
        this.ResultFields.put(this.Title.getName(), this.Title);
        this.ResultFields.put(this.Office.getName(), this.Office);
        this.ResultFields.put(this.ApplyDate.getName(), this.ApplyDate);
        this.ResultFields.put(this.ApplyNo.getName(), this.ApplyNo);
    	this.ResultFields.put(this.GovFeeAmount.getName(), this.GovFeeAmount);
    	this.ResultFields.put(this.AttorneyFee.getName(), this.AttorneyFee);
    	this.ResultFields.put(this.ServiceFeeAmount.getName(), this.ServiceFeeAmount);
    	this.ResultFields.put(this.TotalTax2.getName(), this.TotalTax2);
    	this.ResultFields.put(this.TotalTax.getName(), this.TotalTax);
    	this.ResultFields.put(this.TotalIncludeTaxAmount.getName(), this.TotalIncludeTaxAmount);
    	this.ResultFields.put(this.ReceiptNumber.getName(), this.ReceiptNumber);
    	this.ResultFields.put(this.InvoiceNumber.getName(), this.InvoiceNumber);
    	this.ResultFields.put(this.AmountReceipts.getName(), this.AmountReceipts);
    	this.ResultFields.put(this.AmountReceivable.getName(), this.AmountReceivable);
    	this.ResultFields.put(this.InCharge.getName(), this.InCharge);
    	this.ResultFields.put(this.AttorneyBillNo.getName(), this.AttorneyBillNo);
    	this.ResultFields.put(this.TotalWriteOffAmount.getName(), this.TotalWriteOffAmount);
    	this.ResultFields.put(this.InvoiceStatus.getName(), this.InvoiceStatus);
    	this.ResultFields.put(this.TimesheetMerge.getName(), this.TimesheetMerge);
        try{
        	this.InvoiceStatus.setMapingPrpt(new Category().getNamesPrpts());
        	this.InvoiceStatus.setNotShowCode(true);
        }catch(Exception e){}
    	this.ResultFields.put(this.AccountReceivableDay.getName(), this.AccountReceivableDay);
    	
    }
    
    @SuppressWarnings("unchecked")
	public String makeInvoiceExcel() throws Exception {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
    	
		List<String> files = new ArrayList<String>();
		int month = new Date().getMonth() + 1;

		List list = new ArrayList();
		
		Invoice invoice = new Invoice(this.getFlowKey());

		String sql = "select flowkey from invoicedetail where parentid = '" + invoice.getFlowKey() + "' order by detailorder, AccountTitle, flowkey";
		List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
		
		sql = "select flowkey from reportdefine where SampleDocument = '" + this.getSampleDoc() + "'";
		String doc = this.getDbUtil().getFieldValue(sql, "flowkey");

		Properties cateProp = new Category().getNamesPrpts();

		double Money1 = 0.0;//服務費合計
		double Money2 = 0.0;//代收複代理人服務費及規費
		double Money3 = 0.0;//營業稅5%
		double Money4 = 0.0;//總金額
		double Money5 = 0.0;
		double Money6 = 0.0;
		double HRS = 0.0;
		String Currency1 = "NTD";
		String Currency2 = "NTD";
		String Currency3 = "NTD";
		String Currency4 = "NTD";
		boolean hasGov = false;
		boolean hasService = false;
		boolean hasAttorney = false;
		String govCurrency = "";
		String serviceCurrency = "";
		String attorneyCurrency = "";
		
		String max = "";
		String min = "";
		/*
[下午 01:51:30] Janny Kuo: [下午 01:49] Janny Kuo: 
<<< 收據請款單 和發票請款單是1,2
[下午 01:51:53] Janny Kuo: 3,5 是外幣
		 */
		if(Util.compareTo(doc, "InvoiceDoc4")) {
			int index = 1;
			String sql2 = "select timesheet_flowkey from invoice_timesheet where invoice_flowkey = '" + invoice.getFlowKey() + "'";
			List<String> tkeys = this.getDbUtil().getValueList(sql2, "timesheet_flowkey");
			
			String cond = Util.arrayToIncond(tkeys.toArray());
			sql2 = "select max(WorkDateStart) as max from TimesheetManagement where flowkey in (" + cond + ")";
			max = this.getDbUtil().getFieldValue(sql2, "max");
			
			sql2 = "select min(WorkDateStart) as min from TimesheetManagement where flowkey in (" + cond + ")";
			min = this.getDbUtil().getFieldValue(sql2, "min");
			
			for(String key : tkeys) {
				Map data = new HashMap();
				TimesheetManagement tm = new TimesheetManagement(key);
				
				data.put("index", index + "");
				data.put("HRS", tm.getChargeHours());
				data.put("RATE",tm.getHourlyCharge());
				data.put("RequestPay", tm.getAmount());
				data.put("TaskDescription", tm.getTaskDescription());
				if(!Util.isEmpty(tm.getWorkDateStart())) {
					Date date = sdf.parse(tm.getWorkDateStart().substring(0, 10));
					data.put("AccountTitle", sdf2.format(date));
				}
				data.put("Currency", tm.getHourlyCurrency());
				
				Money5 += Util.stringToDouble(tm.getAmount());
				
				Currency4 = tm.getHourlyCurrency();
				
				HRS += Util.stringToDouble(tm.getChargeHours());
				
				list.add(data);
				
				index++;
			}
			
			Money6 = Money5;
			
		}
		else if(Util.compareTo(doc, "InvoiceDoc5")) {
			if (keys != null && keys.size() > 0) {
				int index = 1;
				for (String key : keys) {
					Map data = new HashMap();
	
					InvoiceDetail detail = new InvoiceDetail(key);
					data.put("index", index + "");
					data.put("TaskDescription", detail.getTaskDescription());
					data.put("AccountTitle", cateProp.get(detail.getAccountTitle()));
					data.put("Memo", detail.getMemo());
					
					if(Util.compareTo(detail.getAccountTitle(), "AccountTitle01")) {
						data.put("AccountTitle", "Government Fee");
						hasGov = true;
						govCurrency = detail.getInvoiceCurrency();
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle02")) {
						data.put("AccountTitle", "Attorney Fee");
						hasAttorney = true;
						attorneyCurrency = detail.getInvoiceCurrency();
					}
					else  if(Util.compareTo(detail.getAccountTitle(), "AccountTitle03")) {
						data.put("AccountTitle", "Service Fee");
						hasService = true;
						serviceCurrency = detail.getInvoiceCurrency();
					}

					data.put("Currency", detail.getInvoiceCurrency());
					data.put("RequestPay", Util.formatNumber(Util.stringToDouble(detail.getIncludeTaxAmount()), 
							"###,##0.00"));
					
					Currency4 = detail.getInvoiceCurrency();
					
					if(Util.compareTo(detail.getAccountTitle(), "AccountTitle01")) {
						//官費
						Money2 += Util.stringToDouble(detail.getIncludeTaxAmount());
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle02")) {
						//複代理人服務費
						Money3 += Util.stringToDouble(detail.getIncludeTaxAmount());
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle03")) {
						//本所服務費
						Money1 += Util.stringToDouble(detail.getIncludeTaxAmount());
					}
					Money5 += Util.stringToDouble(detail.getIncludeTaxAmount());
					
					list.add(data);
					
					index++;
				}
				
				if(hasGov) {
					Map data = new HashMap();
					data.put("index", "");
					data.put("Memo", "");
					data.put("TaskDescription", "Gov. Fee SubTotal");
					data.put("AccountTitle", "");
					data.put("Currency", govCurrency);
					data.put("RequestPay", Util.formatNumber(Money2, "###,##0.00"));

					list.add(data);
				}
				
				if(hasAttorney) {
					Map data = new HashMap();
					data.put("index", "");
					data.put("Memo", "");
					data.put("TaskDescription", "Att. Fee SubTotal");
					data.put("AccountTitle", "");
					data.put("Currency", attorneyCurrency);
					data.put("RequestPay", Util.formatNumber(Money3, "###,##0.00"));

					list.add(data);
				}
				
				if(hasService) {
					Map data = new HashMap();
					data.put("index", "");
					data.put("Memo", "");
					data.put("TaskDescription", "Service Fee SubTotal");
					data.put("AccountTitle", "");
					data.put("Currency", serviceCurrency);
					data.put("RequestPay", Util.formatNumber(Money1, "###,##0.00"));

					list.add(data);
				}
			}
		}
		else if(Util.compareTo(doc, "InvoiceDoc7")) {
			if (keys != null && keys.size() > 0) {
				int index = 1;
				for (String key : keys) {
					Map data = new HashMap();
	
					InvoiceDetail detail = new InvoiceDetail(key);
					data.put("index", index + "");
					data.put("TaskDescription", detail.getTaskDescription());
					data.put("AccountTitle", cateProp.get(detail.getAccountTitle()));
					data.put("Memo", detail.getMemo());
					
					if(Util.compareTo(detail.getAccountTitle(), "AccountTitle01")) {
						data.put("AccountTitle", "Government Fee");
						hasGov = true;
						govCurrency = detail.getInvoiceCurrency();
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle02")) {
						data.put("AccountTitle", "Attorney Fee");
						hasAttorney = true;
						attorneyCurrency = detail.getInvoiceCurrency();
					}
					else  if(Util.compareTo(detail.getAccountTitle(), "AccountTitle03")) {
						data.put("AccountTitle", "Service Fee");
						hasService = true;
						serviceCurrency = detail.getInvoiceCurrency();
					}

					data.put("Currency", detail.getInvoiceCurrency());
					data.put("RequestPay", Util.formatNumber(Util.stringToDouble(detail.getIncludeTaxAmount()), 
							"###,##0.00"));
					
					Currency4 = detail.getInvoiceCurrency();
					
					if(Util.compareTo(detail.getAccountTitle(), "AccountTitle01")) {
						//官費
						Money2 += Util.stringToDouble(detail.getIncludeTaxAmount());
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle02")) {
						//複代理人服務費
						Money3 += Util.stringToDouble(detail.getIncludeTaxAmount());
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle03")) {
						//本所服務費
						Money1 += Util.stringToDouble(detail.getIncludeTaxAmount());
					}
					Money5 += Util.stringToDouble(detail.getIncludeTaxAmount());
					
					list.add(data);
					
					index++;
				}
				
				if(hasGov) {
					Map data = new HashMap();
					data.put("index", "");
					data.put("Memo", "");
					data.put("TaskDescription", "Gov. Fee SubTotal");
					data.put("AccountTitle", "");
					data.put("Currency", govCurrency);
					data.put("RequestPay", Util.formatNumber(Money2, "###,##0.00"));

					list.add(data);
				}
				
				if(hasAttorney) {
					Map data = new HashMap();
					data.put("index", "");
					data.put("Memo", "");
					data.put("TaskDescription", "Att. Fee SubTotal");
					data.put("AccountTitle", "");
					data.put("Currency", attorneyCurrency);
					data.put("RequestPay", Util.formatNumber(Money3, "###,##0.00"));

					list.add(data);
				}
				
				if(hasService) {
					Map data = new HashMap();
					data.put("index", "");
					data.put("Memo", "");
					data.put("TaskDescription", "Service Fee SubTotal");
					data.put("AccountTitle", "");
					data.put("Currency", serviceCurrency);
					data.put("RequestPay", Util.formatNumber(Money1, "###,##0.00"));

					list.add(data);
				}
			}
		}
		else if(Util.compareTo(doc, "InvoiceDoc2")) {
			if (keys != null && keys.size() > 0) {
				int index = 1;
				for (String key : keys) {
					Map data = new HashMap();
	
					InvoiceDetail detail = new InvoiceDetail(key);
					data.put("index", index + "");
					data.put("TaskDescription", detail.getTaskDescription());
					data.put("Currency", detail.getInvoiceCurrency());
					data.put("RequestPay", detail.getIncludeTaxAmount());
					data.put("RequestPay", Util.formatNumber(Util.round(Util.stringToDouble(detail.getNotIncludeTaxAmount()), 0), "###,##0"));
					data.put("AccountTitle", cateProp.get(detail.getAccountTitle()));
					data.put("Memo", detail.getMemo());
					
					
					
					if(Util.compareTo(detail.getAccountTitle(), "AccountTitle01")) {
						Money2 += Util.round(Util.stringToDouble(detail.getNotIncludeTaxAmount()), 0);
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle02")) {
						//複代理人服務費
						Money2 += Util.round(Util.stringToDouble(detail.getNotIncludeTaxAmount()),0);
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle03")) {
						//本所服務費
						Money1 += Util.round(Util.stringToDouble(detail.getNotIncludeTaxAmount()), 0);
					}
					Money3 += Util.stringToInt(detail.getTax());
					Money4 += Util.round(Util.stringToDouble(detail.getNotIncludeTaxAmount()), 0);
					
					
					list.add(data);
					
					index++;
				}
			}
		}
		else {
			if (keys != null && keys.size() > 0) {
				int index = 1;
				for (String key : keys) {
					Map data = new HashMap();
	
					InvoiceDetail detail = new InvoiceDetail(key);
					data.put("index", index + "");
					data.put("TaskDescription", detail.getTaskDescription());
					data.put("Currency", detail.getInvoiceCurrency());
					data.put("RequestPay", Util.formatNumber(Util.round(Util.stringToDouble(detail.getIncludeTaxAmount()), 0), "###,##0"));
					if(Util.compareTo(doc, "InvoiceDoc3") ||
							Util.compareTo(doc, "InvoiceDoc8")) {
						data.put("RequestPay", detail.getIncludeTaxAmount());
					}
					data.put("AccountTitle", cateProp.get(detail.getAccountTitle()));
					data.put("Memo", detail.getMemo());
					
					if(Util.compareTo(doc, "InvoiceDoc3") ||
							Util.compareTo(doc, "InvoiceDoc8")) {
						if(Util.compareTo(detail.getAccountTitle(), "AccountTitle01")) {
							data.put("AccountTitle", "Government Fee");
							hasGov = true;
							govCurrency = detail.getInvoiceCurrency();
						}
						else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle02")) {
							data.put("AccountTitle", "Attorney Fee");
							hasAttorney = true;
							attorneyCurrency = detail.getInvoiceCurrency();
						}
						else  if(Util.compareTo(detail.getAccountTitle(), "AccountTitle03")) {
							data.put("AccountTitle", "Service Fee");
							hasService = true;
							serviceCurrency = detail.getInvoiceCurrency();
						}

						data.put("Currency", detail.getInvoiceCurrency());
						data.put("RequestPay", Util.formatNumber(
								Util.stringToDouble(detail.getIncludeTaxAmount()), 
								"###,##0.00"));
						
						Currency4 = detail.getInvoiceCurrency();
					}
					
					if(Util.compareTo(detail.getAccountTitle(), "AccountTitle01")) {
						//官費
						if(Util.compareTo(doc, "InvoiceDoc3") ||
								Util.compareTo(doc, "InvoiceDoc8")) {
							Money2 += Util.stringToDouble(detail.getIncludeTaxAmount());
						}
						else {
							Money2 += Util.round(Util.stringToDouble(detail.getIncludeTaxAmount()), 0);
						}
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle02")) {
						if(Util.compareTo(doc, "InvoiceDoc3") ||
								Util.compareTo(doc, "InvoiceDoc8")) {
							Money3 += Util.stringToDouble(detail.getIncludeTaxAmount());
						}
						else {
							Money2 += Util.round(Util.stringToDouble(detail.getIncludeTaxAmount()),0);
						}
					}
					else if(Util.compareTo(detail.getAccountTitle(), "AccountTitle03")) {
						if(Util.compareTo(doc, "InvoiceDoc3") ||
								Util.compareTo(doc, "InvoiceDoc8")) {
							Money1 += Util.stringToDouble(detail.getIncludeTaxAmount());
						}
						else {
							Money1 += Util.round(Util.stringToDouble(detail.getIncludeTaxAmount()), 0);
						}
					}
					
					if(Util.compareTo(doc, "InvoiceDoc3") ||
							Util.compareTo(doc, "InvoiceDoc8")) {
						Money5 += Util.stringToDouble(detail.getIncludeTaxAmount());
					}
					else {
						Money3 += Util.stringToInt(detail.getTax2());
						Money4 += Util.round(Util.stringToDouble(detail.getIncludeTaxAmount()), 0);
					}
					
					list.add(data);
					
					index++;
				}
				if(hasGov) {
					Map data = new HashMap();
					data.put("index", "");
					data.put("Memo", "");
					data.put("TaskDescription", "Gov. Fee SubTotal");
					data.put("AccountTitle", "");
					data.put("Currency", govCurrency);
					data.put("RequestPay", Util.formatNumber(Money2, "###,##0.00"));

					list.add(data);
				}
				
				if(hasAttorney) {
					Map data = new HashMap();
					data.put("index", "");
					data.put("Memo", "");
					data.put("TaskDescription", "Att. Fee SubTotal");
					data.put("AccountTitle", "");
					data.put("Currency", attorneyCurrency);
					data.put("RequestPay", Util.formatNumber(Money3, "###,##0.00"));

					list.add(data);
				}
				
				if(hasService) {
					Map data = new HashMap();
					data.put("index", "");
					data.put("Memo", "");
					data.put("TaskDescription", "Service Fee SubTotal");
					data.put("AccountTitle", "");
					data.put("Currency", serviceCurrency);
					data.put("RequestPay", Util.formatNumber(Money1, "###,##0.00"));

					list.add(data);
				}
			}
		}
		
		if(Util.compareTo(doc, "InvoiceDoc3") ||
				Util.compareTo(doc, "InvoiceDoc8") ||
				Util.compareTo(doc, "InvoiceDoc4")) {
			Money4 = Util.stringToInt(invoice.getTotalAmountDeductTTax2());
		}
		else if(Util.compareTo(doc, "InvoiceDoc2")) {
			Money3 = Util.stringToInt(invoice.getTotalTax());
			Money4 = Util.stringToInt(invoice.getTotalRequestPayNtdAmount());
		}
		else {
			Money3 = Util.stringToInt(invoice.getTotalTax2());
			Money4 = Util.stringToInt(invoice.getTotalAmountDeductTTax2());
		}

		// 主表
		Map data = new HashMap();
		if(Util.compareTo(doc, "InvoiceDoc2")) {
			data.put("Money1", Util.formatNumber((int)Money1, "###,##0") + "");
			data.put("Money2", Util.formatNumber((int)Money2, "###,##0") + "");
			data.put("Money3", Util.formatNumber((int)Money3, "###,##0") + "");
		}
		else if(Util.compareTo(doc, "InvoiceDoc3") ||
				Util.compareTo(doc, "InvoiceDoc8")) {
			data.put("Money1", Util.formatNumber(Money1, "###,##0.00") + "");
			data.put("Money2", Util.formatNumber(Money2, "###,##0.00") + "");
			data.put("Money3", Util.formatNumber(Money3, "###,##0.00") + "");
		}
		else if(Util.compareTo(doc, "InvoiceDoc4")) {
			data.put("Money1", Money1 + "");
			data.put("Money2", Money2 + "");
			data.put("Money3", Money3 + "");
		}
		else if(Util.compareTo(doc, "InvoiceDoc5")) {
			data.put("Money1", Util.formatNumber(Money1, "###,##0.00") + "");
			data.put("Money2", Util.formatNumber(Money2, "###,##0.00") + "");
			data.put("Money3", Util.formatNumber(Money3, "###,##0.00") + "");
		}
		else if(Util.compareTo(doc, "InvoiceDoc7")) {
			data.put("Money1", Util.formatNumber(Money1, "###,##0.00") + "");
			data.put("Money2", Util.formatNumber(Money2, "###,##0.00") + "");
			data.put("Money3", Util.formatNumber(Money3, "###,##0.00") + "");
		}
		else {
			data.put("Money1", Util.formatNumber((int)Money1, "###,##0") + "");
			data.put("Money2", Util.formatNumber((int)Money2, "###,##0") + "");
			data.put("Money3", Util.formatNumber((int)Money3, "###,##0") + "");
		}

		if(Util.compareTo(doc, "InvoiceDoc3") ||
				Util.compareTo(doc, "InvoiceDoc8") ||
				Util.compareTo(doc, "InvoiceDoc4") ||
				Util.compareTo(doc, "InvoiceDoc5") ||
				Util.compareTo(doc, "InvoiceDoc7")) {
			data.put("InvoiceTitle", invoice.getInvoiceTitle());
		}
		else {
			data.put("InvoiceTitle", invoice.getInvoiceTitle() + "   台照");
		}

		data.put("header1", cateProp.get(invoice.getAttorneyTitle()));
		
		String sql2 = "select names from category where parentid='" + doc + "' order by flowkey";;
		List<String> names = this.getDbUtil().getValueList(sql2, "names");
		for(int i=1;i<names.size();i++) {
			data.put("header" + (i+1), names.get(i));
		}
		
		data.put("Note", invoice.getNote());

		data.put("ChineseMoney", Util.numberToRocString((int)Money4+"") + "元 整");
		data.put("ApplyNo", invoice.getApplyNo());
		data.put("ApplyDate", (Util.isEmpty(invoice.getApplyDate())?"":invoice.getApplyDate().replaceAll("-", "/")));
		
		data.put("Applicant", invoice.getClientName());
		if(Util.compareTo(doc, "InvoiceDoc3") ||
				Util.compareTo(doc, "InvoiceDoc8") ||
				Util.compareTo(doc, "InvoiceDoc5") || 
				Util.compareTo(doc, "InvoiceDoc7")) {
			if(Util.isEmpty(invoice.getCaseClient())) {
				data.put("Applicant", "");
			}
			else {
				//data.put("Applicant", new Client(invoice.getCaseClient()).getCompanyName());
				data.put("Applicant", invoice.getCaseClient());
			}
		}
		data.put("CaseAD", invoice.getTaskCreator() + "/" + invoice.getAssignedTo());
		
		if(!Util.isEmpty(max)) {
			max = max.substring(0, 10);
		}
		if(!Util.isEmpty(min)) {
			min = min.substring(0, 10);
		}
		data.put("Period", min + "~" + max);

		// 設定要用來套表的jasperReport檔案路徑
		String reportPath = this.getSampleDoc();
		Employee incharge = new Employee(invoice.getInCharge()); 

		Client client = new Client(invoice.getClient());
		data.put("InvoiceNo", invoice.getInvoiceNo());
		data.put("VoucherDate", (Util.isEmpty(invoice.getVoucherDate())?"":invoice.getVoucherDate().replaceAll("-", "/")));
		String title = invoice.getTitle();
		if(title.equals("/")) {
			title = "";
		}
		else if(title.startsWith("/")) {
			title = title.substring(1);
		}
		else if(title.endsWith("/")) {
			title = title.substring(0, title.length()-1);
		}
		
		data.put("Title", title);
		data.put("CaseNo", invoice.getCaseNo());
		data.put("InternalNo", invoice.getInternalNo());
		data.put("TaskDescription", invoice.getTaskDescription());
		data.put("Currency1", Currency1);
		data.put("Currency2", Currency2);
		data.put("Currency3", Currency3);
		data.put("Currency4", Currency4);
		//愈收金額幣別
		data.put("Currency5", Currency4);
		data.put("HRS", HRS + "");
		
		if(Util.compareTo(doc, "InvoiceDoc4")) {
			data.put("Money3", Util.formatNumber(0.00, "###,##0.00"));
			data.put("Money2", Util.formatNumber(Util.round(Money5, 2), "###,##0.00"));
			data.put("Money4", Util.formatNumber(Util.round(Money5, 2), "###,##0.00"));
		}
		else if(Util.compareTo(doc, "InvoiceDoc3") ||
				Util.compareTo(doc, "InvoiceDoc8") ||
				Util.compareTo(doc, "InvoiceDoc5") || 
				Util.compareTo(doc, "InvoiceDoc7")) {
			data.put("Money4", Util.formatNumber(Util.round(Money5, 2), "###,##0.00"));
		}
		else {
			//改成應收金額
			//data.put("Money4", Util.formatNumber(Util.round(Money4, 0), "###,##0"));
			data.put("Money4", Util.formatNumber(Util.round(Util.stringToDouble(invoice.getAmountReceivable()), 0), "###,##0"));
			//預收金額
			data.put("Money5", Util.formatNumber(Util.round(Util.stringToDouble(invoice.getAmountReceipts()), 0), "###,##0"));
			
			data.put("ChineseMoney", Util.numberToRocString((int)Util.round(Util.stringToDouble(invoice.getAmountReceivable()), 0)+"") + "元 整");
		}
		
		//預收金額
		data.put("AmountReceipts", Util.formatNumber(Util.round(Util.stringToDouble(invoice.getAmountReceipts()), 0), "###,##0"));

		String sampleDoc = Util.getTomcatPath() + reportPath;
		String outputFile = "Invoice/"
				+ Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))
				+ ".xls";
		String outputDoc = Util.getDocPath() + outputFile;
		
		//建立資料夾
		File dir = new File( Util.getDocPath() + "Invoice/");
		if(!dir.exists()) {
			dir.mkdir();
		}

		JRDataSource subJrds = new JRBeanCollectionDataSource(list);

		JasperPrint report = JasperFillManager.fillReport(sampleDoc, data,
				subJrds);
		JExcelApiExporter exporter = new JExcelApiExporter();

		FileOutputStream output = new FileOutputStream(outputDoc);

		List testList = new ArrayList();
		testList.add(report);
		exporter.setParameter(JExcelApiExporterParameter.JASPER_PRINT_LIST,
				testList);
		exporter.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM, output);
		exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.FALSE);
		exporter.setParameter(JExcelApiExporterParameter.IS_IGNORE_GRAPHICS,
				Boolean.FALSE);

		exporter.exportReport();
		output.close();

		// files.add(outputDoc);
		files.add(outputFile);
		long end = new Date().getTime();

		return "doc/" + outputFile;
	}
    
    public String convertMoneyFormat(String moenyString, String currency) {
    	String result = moenyString;
    	
    	try {
    		if(!Util.isEmpty(currency)) {
    			moenyString = moenyString.replaceAll(",", "");
    			if(Util.compareTo(currency, "NTD")) {
    				int money = (int)(Util.round(Util.stringToDouble(moenyString), 0));
    				result = Util.formatNumber(money, Cnstnts.MOENY_FORMAT_1);
    			}
    			else {
    				double money = Util.round(Util.stringToDouble(moenyString), 2);
    				result = Util.formatNumber(money, Cnstnts.MOENY_FORMAT_2);
    				if(result.equals(".00")) {
    					result = "0" + result;
    				}
    			}
    		}
    	}
    	catch(Exception e) {
    		
    	}
    	
    	return result;
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
		
		//要判斷是否有定義欄位寬度
		HashMap<String, Integer> map = Util.getFieldWidthMap(this.getUserInfo(), this.getTableName());
		double totalWidth = 0.0;
		if(this.useFieldWidth) {
			for (Field field : this.getShowField()) {
				try {
					totalWidth += map.get(field.getName());
					field.setFieldWidth(map.get(field.getName()));
				}
				catch(Exception e) {
					System.out.println(field.getName() + " no setting width! ");
				}
			}
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
			
			if(i == 0) {
				strBfr.append(newLine + "    <td align='center'><input type='CheckBox' onClick='markAll()'/></td>");
			}
			
			String fieldName = this.getShowField()[i].getName();
			if(this.useFieldWidth && totalWidth != 0)  {
				strBfr.append(newLine + "    <td align='center' onClick='setOrderKey(\""
					+ fieldName + "\")' width='" + Util.round(this.getShowField()[i].getFieldWidth()/totalWidth*100, 0) + "%'>");
			}
			else {
				strBfr.append(newLine + "    <td align='center' onClick='setOrderKey(\""
						+ fieldName + "\")'" + this.getShowField()[i].printListWidth() + ">");
			}
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
				
				String onClick = Cnstnts.EMPTY_STRING;
				
				strBfr.append(newLine + "  <tr" + trBgcolor
						+ " style='cursor: hand' " + "title='"
						+ this.getUserInfo().getMsg("jsp.common.viewDetail")
						+ "' >");
				
				if(openBlankDetail) {
					onClick = "onClick='openAppendix(\"" + this.getProgramId().replaceFirst("jsp.", "") + ".jsp?_flowKey="+data[0].toString()+
							"&_dbActionMode=update&_getDataFlag=true&_pageActionMode=maintain&_currentRecord="+(i + 1)+
							"\",\"" + this.getProgramId().replaceFirst("jsp.", "") + "\",1000,550)' ";
				}
				else {
					onClick = " onClick='document.input.currentRecord.value=\""
							+ (i + 1) + "\";document.input.dbActionMode.value=\"update\";"
							+"gotoData(\"" + data[0].toString()
							+ "\")' ";
				}
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
						
						if(j-1 == 0) {
							String checked = "";
							if(this.getMarkKeys() != null) {
								for(String s : this.getMarkKeys()) {
									if(s.equals(data[0])) {
										checked = " checked ";
									}
								}
							}
							strBfr.append(newLine + "    <td width='1%' align='center'>"
									+ "<input type='CheckBox' id='markKey' name='markKey' value='"+data[0]+"' " + checked + "/>"
									+ "</td>");
						}
						if (this.getShowField()[j - 1].getHtmlType().equals(
										Cnstnts.HTML_TAG_OPEN_UPLOAD)){
							if (!showData.equals("")){
								showData = "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
								  "onClick='openAppendix(\""+showData+"\",\"DocumentUrl\",600,400)'>";
							}
							
						}
						else if(this.getShowField()[j - 1].getIsShowImage() && !Util.isEmpty(showData)) {
								strBfr.append(newLine + "    <td " + onClick 
//										+ this.getShowField()[j - 1].printListWidth()
										+ this.getShowField()[j - 1].printAlign() + ">"
										+ "<img width='80' height='60' src='" + showData + "'></td>");
						}
						else {
							strBfr.append(newLine + "    <td " + onClick 
//									+ this.getShowField()[j - 1].printListWidth()
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

		String rtnString = "<input type='hidden' id='checkedVaule' name='checkedVaule'/>";
		rtnString+="<script>"+
		 "function markAll(){"+
		 	"var setValue = false;"+
		 	"if(document.input.checkedVaule.value=='true'){"+
		 		"document.input.checkedVaule.value='';"+
		 	"} else {"+
		 		"document.input.checkedVaule.value='true';"+
		 		"setValue = true;"+
		 	"}"+
		 	"for(i=0;i<document.input[\"markKey\"].length;i++){"+
		 		"document.input.markKey[i].checked=setValue;"+
		 	"}"+
		 "}"+
		 "</script>";
		strBfr.append(newLine + rtnString);
		
		return strBfr.toString();
	}
    


}