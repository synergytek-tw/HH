package deepspot.main;

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

import com.athenasoft.ooutil.OoConverter;

import deepspot.basic.Cnstnts;
import deepspot.basic.DbUtil;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.util.Util;

public class Payment extends MasterBean {

    public Payment(){this.init();}

    public Payment(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

	private String[] MarkKeys;
    public void setMarkKeys(String[] markKeys){this.MarkKeys=markKeys;}
    public String[] getMarkKeys(){return this.MarkKeys;}
	
    public String doPayment;

    public String getDoPayment() {
		return doPayment;
	}

	public void setDoPayment(String doPayment) {
		this.doPayment = doPayment;
	}

	public Field PayToParty;
    public void setPayToParty(String PayToParty){this.PayToParty.setValue(PayToParty);}
    public String getPayToParty(){return this.PayToParty.getValue();}

    public Field CovEntity;
    public void setCovEntity(String CovEntity){this.CovEntity.setValue(CovEntity);}
    public String getCovEntity(){return this.CovEntity.getValue();}

    public Field PayToPartyName;
    public void setPayToPartyName(String PayToPartyName){this.PayToPartyName.setValue(PayToPartyName);}
    public String getPayToPartyName(){return this.PayToPartyName.getValue();}

    public Field AttorneyId;
    public void setAttorneyId(String AttorneyId){this.AttorneyId.setValue(AttorneyId);}
    public String getAttorneyId(){return this.AttorneyId.getValue();}

    public Field PaymentDate;
    public void setPaymentDate(String PaymentDate){this.PaymentDate.setValue(PaymentDate);}
    public String getPaymentDate(){return this.PaymentDate.getValue();}

    public Field ApDate;
    public void setApDate(String ApDate){this.ApDate.setValue(ApDate);}
    public String getApDate(){return this.ApDate.getValue();}

    public Field PaymentDateTo;
    public void setPaymentDateTo(String PaymentDateTo){this.PaymentDateTo.setValue(PaymentDateTo);}
    public String getPaymentDateTo(){return this.PaymentDateTo.getValue();}

    public Field ApDateTo;
    public void setApDateTo(String ApDateTo){this.ApDateTo.setValue(ApDateTo);}
    public String getApDateTo(){return this.ApDateTo.getValue();}

    public Field TotalPaymentNtdAmount;
    public void setTotalPaymentNtdAmount(String TotalPaymentNtdAmount){this.TotalPaymentNtdAmount.setValue(TotalPaymentNtdAmount);}
    public String getTotalPaymentNtdAmount(){return this.TotalPaymentNtdAmount.getValue();}

    public Field TotalWriteOffAmount;
    public void setTotalWriteOffAmount(String TotalWriteOffAmount){this.TotalWriteOffAmount.setValue(TotalWriteOffAmount);}
    public String getTotalWriteOffAmount(){return this.TotalWriteOffAmount.getValue();}
    
    public Field TotalDiscountAmount;
    public void setTotalDiscountAmount(String TotalDiscountAmount){this.TotalDiscountAmount.setValue(TotalDiscountAmount);}
    public String getTotalDiscountAmount(){return this.TotalDiscountAmount.getValue();}

    public Field NotYetWriteOff;
    public void setNotYetWriteOff(String NotYetWriteOff){this.NotYetWriteOff.setValue(NotYetWriteOff);}
    public String getNotYetWriteOff(){return this.NotYetWriteOff.getValue();}

    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}

    public Field CaseNo;
    public void setCaseNo(String CaseNo){this.CaseNo.setValue(CaseNo);}
    public String getCaseNo(){return this.CaseNo.getValue();}

    public Field Office;
    public void setOffice(String Office){this.Office.setValue(Office);}
    public String getOffice(){return this.Office.getValue();}

    public Field SubType;
    public void setSubType(String SubType){this.SubType.setValue(SubType);}
    public String getSubType(){return this.SubType.getValue();}

    public Field ApplyNo;
    public void setApplyNo(String ApplyNo){this.ApplyNo.setValue(ApplyNo);}
    public String getApplyNo(){return this.ApplyNo.getValue();}

    public Field InvoiceNo;
    public void setInvoiceNo(String InvoiceNo){this.InvoiceNo.setValue(InvoiceNo);}
    public String getInvoiceNo(){return this.InvoiceNo.getValue();}

    public Field InCharge;
    public void setInCharge(String InCharge){this.InCharge.setValue(InCharge);}
    public String getInCharge(){return this.InCharge.getValue();}

    public Field CaseType;
    public void setCaseType(String CaseType){this.CaseType.setValue(CaseType);}
    public String getCaseType(){return this.CaseType.getValue();}

    public Field Matter;
    public void setMatter(String Matter){this.Matter.setValue(Matter);}
    public String getMatter(){return this.Matter.getValue();}
    
    public Field PaymentNo;
    public void setPaymentNo(String PaymentNo){this.PaymentNo.setValue(PaymentNo);}
    public String getPaymentNo(){return this.PaymentNo.getValue();}

    public Field ReceiptDate;
    public void setReceiptDate(String ReceiptDate){this.ReceiptDate.setValue(ReceiptDate);}
    public String getReceiptDate(){return this.ReceiptDate.getValue();}

    public Field ReceiptDateTo;
    public void setReceiptDateTo(String ReceiptDateTo){this.ReceiptDateTo.setValue(ReceiptDateTo);}
    public String getReceiptDateTo(){return this.ReceiptDateTo.getValue();}
      
    public Field Amount;
    public void setAmount(String Amount){this.Amount.setValue(Amount);}
    public String getAmount(){return this.Amount.getValue();}
     
    public Field ExchangeRate;
    public void setExchangeRate(String ExchangeRate){this.ExchangeRate.setValue(ExchangeRate);}
    public String getExchangeRate(){return this.ExchangeRate.getValue();}

    public Field Currency;
    public void setCurrency(String Currency){this.Currency.setValue(Currency);}
    public String getCurrency(){return this.Currency.getValue();}
    
    private String DoWriteOffFlag;

	public String getDoWriteOffFlag() {
		return DoWriteOffFlag;
	}

	public void setDoWriteOffFlag(String doWriteOffFlag) {
		DoWriteOffFlag = doWriteOffFlag;
	}
	
	private String ApWriteOffLogKey;

	public String getApWriteOffLogKey() {
		return ApWriteOffLogKey;
	}

	public void setApWriteOffLogKey(String apWriteOffLogKey) {
		ApWriteOffLogKey = apWriteOffLogKey;
	}

    
    public Field ServiceFee;
    public void setServiceFee(String ServiceFee){this.ServiceFee.setValue(ServiceFee);}
    public String getServiceFee(){return this.ServiceFee.getValue();}
    
    public Field GovFee;
    public void setGovFee(String AttorneyFee){this.GovFee.setValue(AttorneyFee);}
    public String getGovFee(){return this.GovFee.getValue();}
    
    public Field ServiceFeeNtd;
    public void setServiceFeeNtd(String ServiceFeeNtd){this.ServiceFeeNtd.setValue(ServiceFeeNtd);}
    public String getServiceFeeNtd(){return this.ServiceFeeNtd.getValue();}
    
    public Field GovFeeNtd;
    public void setGovFeeNtd(String AttorneyFeeNtd){this.GovFeeNtd.setValue(AttorneyFeeNtd);}
    public String getGovFeeNtd(){return this.GovFeeNtd.getValue();}

    public Field TotalTax;
    public void setTotalTax(String TotalTax){this.TotalTax.setValue(TotalTax);}
    public String getTotalTax(){return this.TotalTax.getValue();}

    public Field TotalTax2;
    public void setTotalTax2(String TotalTax2){this.TotalTax2.setValue(TotalTax2);}
    public String getTotalTax2(){return this.TotalTax2.getValue();}

    public Field TotalRequestPayNtdAmount;
    public void setTotalRequestPayNtdAmount(String TotalRequestPayNtdAmount){this.TotalRequestPayNtdAmount.setValue(TotalRequestPayNtdAmount);}
    public String getTotalRequestPayNtdAmount(){return this.TotalRequestPayNtdAmount.getValue();}
    
    public Field TotalWithHolding;
    public void setTotalWithHolding(String TotalWithHolding){this.TotalWithHolding.setValue(TotalWithHolding);}
    public String getTotalWithHolding(){return this.TotalWithHolding.getValue();}
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

    public Field TotalAmountDeductTTax2;
    public void setTotalAmountDeductTTax2(String TotalAmountDeductTTax2){this.TotalAmountDeductTTax2.setValue(TotalAmountDeductTTax2);}
    public String getTotalAmountDeductTTax2(){return this.TotalAmountDeductTTax2.getValue();}

    
    public Field ServiceFeeDeductTTax2;
    public void setServiceFeeDeductTTax2(String ServiceFeeDeductTTax2){this.ServiceFeeDeductTTax2.setValue(ServiceFeeDeductTTax2);}
    public String getServiceFeeDeductTTax2(){return this.ServiceFeeDeductTTax2.getValue();}
    
    public Field Note;
    public void setNote(String Note){this.Note.setValue(Note);}
    public String getNote(){return this.Note.getValue();}
    
    public Field OriginalCurrency;
    public void setOriginalCurrency(String OriginalCurrency){this.OriginalCurrency.setValue(OriginalCurrency);}
    public String getOriginalCurrency(){return this.OriginalCurrency.getValue();}
    
    public Field OriginalCurrencyAmount;
    public void setOriginalCurrencyAmount(String OriginalCurrencyAmount){this.OriginalCurrencyAmount.setValue(OriginalCurrencyAmount);}
    public String getOriginalCurrencyAmount(){return this.OriginalCurrencyAmount.getValue();}

    public Field IpType;
    public void setIpType(String IpType){this.IpType.setValue(IpType);}
    public String getIpType(){return this.IpType.getValue();}
    
    public String changeFee1;
    public String changeFee2;
    public String changeFee3;
    public String changeFee4;
    
    public String getChangeFee1() {
		return changeFee1;
	}

	public void setChangeFee1(String changeFee1) {
		this.changeFee1 = changeFee1;
	}

	public String getChangeFee2() {
		return changeFee2;
	}

	public void setChangeFee2(String changeFee2) {
		this.changeFee2 = changeFee2;
	}

	public String getChangeFee3() {
		return changeFee3;
	}

	public void setChangeFee3(String changeFee3) {
		this.changeFee3 = changeFee3;
	}

	public String getChangeFee4() {
		return changeFee4;
	}

	public void setChangeFee4(String changeFee4) {
		this.changeFee4 = changeFee4;
	}
    public String changeFee11;
    public String changeFee21;
    public String changeFee31;
    public String changeFee41;
	
	public String getChangeFee11() {
		return changeFee11;
	}

	public void setChangeFee11(String changeFee11) {
		this.changeFee11 = changeFee11;
	}

	public String getChangeFee21() {
		return changeFee21;
	}

	public void setChangeFee21(String changeFee21) {
		this.changeFee21 = changeFee21;
	}

	public String getChangeFee31() {
		return changeFee31;
	}

	public void setChangeFee31(String changeFee31) {
		this.changeFee31 = changeFee31;
	}

	public String getChangeFee41() {
		return changeFee41;
	}

	public void setChangeFee41(String changeFee41) {
		this.changeFee41 = changeFee41;
	}

	public String changeCurrency;

	public String getChangeCurrency() {
		return changeCurrency;
	}

	public void setChangeCurrency(String changeCurrency) {
		this.changeCurrency = changeCurrency;
	}

    public Field WriteOffRecode;
    public void setWriteOffRecode(String WriteOffRecode){this.WriteOffRecode.setValue(WriteOffRecode);}
    public String getWriteOffRecode(){return this.WriteOffRecode.getValue();}

    public Field InternalInvoiceNo;
    public void setInternalInvoiceNo(String InternalInvoiceNo){this.InternalInvoiceNo.setValue(InternalInvoiceNo);}
    public String getInternalInvoiceNo(){return this.InternalInvoiceNo.getValue();}

	public void init() {
        super.init();
        this.setProgramId("jsp.Payment");
        this.setTableName("Payment");
        
        this.setNotShowDeptFieldOnSearch(true);
        this.setKeepInMaintain(true);

        this.WriteOffRecode = new Field("WriteOffRecode", this.getTableName());
        this.WriteOffRecode.setDbType("varchar(1000)");

        this.InternalInvoiceNo = new Field("InternalInvoiceNo", this.getTableName());
        this.InternalInvoiceNo.setDbType("varchar(1000)");
        this.InternalInvoiceNo.setCheckEmpty(true);
        
        this.IpType = new Field("IpType", this.getTableName());
        
        this.FlowKey.setSearchCondition(Cnstnts.LIKE);

        this.PayToParty = new Field("PayToParty", this.getTableName());
        this.PayToParty.setDbType("nvarchar(50)");
        this.PayToParty.setSearchCondition(Cnstnts.LIKE);
        this.PayToParty.setCheckEmpty(true);

        this.CovEntity = new Field("CovEntity", this.getTableName());
        this.CovEntity.setDbType("varchar(50)");

        this.PayToPartyName = new Field("PayToPartyName", this.getTableName());
        this.PayToPartyName.setDbType("varchar(100)");
        this.PayToPartyName.setSearchCondition(Cnstnts.LIKE);
//        this.PayToPartyName.setCheckEmpty(true);

        this.AttorneyId = new Field("AttorneyId", this.getTableName());
        this.AttorneyId.setDbType("varchar(50)");

        this.PaymentDate = new Field("PaymentDate", this.getTableName());
        this.PaymentDate.setDbType("varchar(10)");

        this.AttorneyId = new Field("AttorneyId", this.getTableName());
        this.AttorneyId.setDbType("varchar(50)");

        this.PaymentDate = new Field("PaymentDate", this.getTableName());
        this.PaymentDate.setDbType("varchar(10)");

        this.ApDate = new Field("ApDate", this.getTableName());
        this.ApDate.setDbType("varchar(10)");

        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("varchar(500)");
        this.Title.setSearchCondition(Cnstnts.LIKE);
        
        this.CaseNo = new Field("CaseNo", this.getTableName());
        this.CaseNo.setDbType("varchar(50)");
        this.CaseNo.setSearchCondition(Cnstnts.LIKE);
        this.CaseNo.setCheckEmpty(true);

        this.Office = new Field("Office", this.getTableName());
        this.Office.setDbType("varchar(50)");

        this.SubType = new Field("SubType", this.getTableName());
        this.SubType.setDbType("varchar(50)");

        this.ApplyNo = new Field("ApplyNo", this.getTableName());
        this.ApplyNo.setDbType("varchar(50)");
        this.ApplyNo.setSearchCondition(Cnstnts.LIKE);

        this.InvoiceNo = new Field("InvoiceNo", this.getTableName());
        this.InvoiceNo.setDbType("varchar(50)");
        this.InvoiceNo.setSearchCondition(Cnstnts.LIKE);

        this.InCharge = new Field("InCharge", this.getTableName());
        this.InCharge.setDbType("varchar(50)");

        this.CaseType = new Field("CaseType", this.getTableName());
        this.CaseType.setDbType("varchar(50)");

        this.Matter = new Field("Matter", this.getTableName());
        this.Matter.setDbType("varchar(50)");
//        this.Matter.setCheckEmpty(true);

        this.ReceiptDate = new Field("ReceiptDate", this.getTableName());
        this.ReceiptDate.setDbType("varchar(10)");

        this.ReceiptDateTo = new Field("ReceiptDateTo", this.getTableName());

        this.PaymentDateTo = new Field("PaymentDateTo", this.getTableName());

        this.ApDateTo = new Field("ApDateTo", this.getTableName());

        this.TotalPaymentNtdAmount = new Field("TotalPaymentNtdAmount", this.getTableName());
        this.TotalPaymentNtdAmount.setDbType("int");

        this.TotalWriteOffAmount = new Field("TotalWriteOffAmount", this.getTableName());
        this.TotalWriteOffAmount.setDbType("float");
        this.TotalWriteOffAmount.setDecimal(2);
        this.TotalWriteOffAmount.setAlign(Cnstnts.RIGHT);

        this.TotalDiscountAmount = new Field("TotalDiscountAmount", this.getTableName());
        this.TotalDiscountAmount.setDbType("float");
        this.TotalDiscountAmount.setDecimal(2);

        this.NotYetWriteOff = new Field("NotYetWriteOff", this.getTableName());

        this.PaymentNo = new Field("PaymentNo", this.getTableName());
        this.PaymentNo.setDbType("varchar(50)");
        this.PaymentNo.setSearchCondition(Cnstnts.LIKE);

        this.Currency = new Field("Currency", this.getTableName());
        this.Currency.setDbType("varchar(50)");
        
        this.Amount = new Field("Amount", this.getTableName());
        this.Amount.setDbType("float");
        this.Amount.setDecimal(2);
        
        this.ExchangeRate = new Field("ExchangeRate", this.getTableName());
        this.ExchangeRate.setDbType("float");
        this.ExchangeRate.setDecimal(4);
        
        this.Note = new Field("Note", this.getTableName());
        this.Note.setDbType("varchar(200)");

        this.TotalTax = new Field("TotalTax", this.getTableName());
        this.TotalTax.setDbType("int");

        this.TotalTax2 = new Field("TotalTax2", this.getTableName());
        this.TotalTax2.setDbType("int");
        
        this.ServiceFee = new Field("ServiceFee", this.getTableName());
        this.ServiceFee.setDbType("float");
        this.ServiceFee.setDecimal(2);

        this.GovFee = new Field("GovFee", this.getTableName());
        this.GovFee.setDbType("float");
        this.GovFee.setDecimal(2);
        
        this.ServiceFeeNtd = new Field("ServiceFeeNtd", this.getTableName());
        this.ServiceFeeNtd.setDbType("int");

        this.GovFeeNtd = new Field("GovFeeNtd", this.getTableName());
        this.GovFeeNtd.setDbType("int");
        
        this.TotalRequestPayNtdAmount = new Field("TotalRequestPayNtdAmount", this.getTableName());
        this.TotalRequestPayNtdAmount.setDbType("int");
        this.TotalRequestPayNtdAmount.setTextAlign(Cnstnts.RIGHT);

        this.NotYetWriteOff = new Field("NotYetWriteOff", this.getTableName());
        this.NotYetWriteOff.setDbType("varchar(1)");
        this.NotYetWriteOff.setTextAlign(Cnstnts.RIGHT);
		
		this.TotalWithHolding = new Field("TotalWithHolding", this.getTableName());
        this.TotalWithHolding.setDbType("int");
        this.TotalWithHolding.setTextAlign(Cnstnts.RIGHT);
        
        this.AttorneyCurrency = new Field("AttorneyCurrency", this.getTableName());
        this.AttorneyCurrency.setDbType("varchar(50)");
        
        this.AttorneyFee = new Field("AttorneyFee", this.getTableName());
        this.AttorneyFee.setDbType("float");
        this.AttorneyFee.setDecimal(2);
        this.AttorneyFee.setTextAlign(Cnstnts.RIGHT);
        
        this.AttorneyFeeNtd = new Field("AttorneyFeeNtd", this.getTableName());
        this.AttorneyFeeNtd.setDbType("int");
        this.AttorneyFeeNtd.setTextAlign(Cnstnts.RIGHT);
        
        this.OtherCurrency = new Field("OtherCurrency", this.getTableName());
        this.OtherCurrency.setDbType("varchar(50)");
        
        this.OtherFee = new Field("OtherFee", this.getTableName());
        this.OtherFee.setDbType("float");
        this.OtherFee.setDecimal(2);
        this.OtherFee.setTextAlign(Cnstnts.RIGHT);
        
        this.OtherFeeNtd = new Field("OtherFeeNtd", this.getTableName());
        this.OtherFeeNtd.setDbType("int");
        this.OtherFeeNtd.setTextAlign(Cnstnts.RIGHT);
        
        this.TotalAmountDeductTTax2 = new Field("TotalAmountDeductTTax2", this.getTableName());
        this.TotalAmountDeductTTax2.setDbType("int");
        
        this.ServiceFeeDeductTTax2 = new Field("ServiceFeeDeductTTax2", this.getTableName());
        this.ServiceFeeDeductTTax2.setDbType("int");	
        
        this.OriginalCurrency = new Field("OriginalCurrency", this.getTableName());
        this.OriginalCurrency.setDbType("varchar(50)");

        this.OriginalCurrencyAmount = new Field("OriginalCurrencyAmount", this.getTableName());
        this.OriginalCurrencyAmount.setDbType("float");
        this.OriginalCurrencyAmount.setDecimal(2);
        this.OriginalCurrencyAmount.setAlign(Cnstnts.RIGHT);
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();

        this.DbFields.add(this.WriteOffRecode);
        
        this.DbFields.add(this.Amount);
        
        this.DbFields.add(this.ExchangeRate);
        
        this.DbFields.add(this.Currency);
        
        this.DbFields.add(this.PayToParty);

        this.DbFields.add(this.CovEntity);

        this.DbFields.add(this.PayToPartyName);

        this.DbFields.add(this.AttorneyId);

        this.DbFields.add(this.PaymentDate);

        this.DbFields.add(this.ApDate);

        this.DbFields.add(this.TotalPaymentNtdAmount);

        this.DbFields.add(this.TotalWriteOffAmount);

        this.DbFields.add(this.TotalDiscountAmount);

        this.DbFields.add(this.Title);

        this.DbFields.add(this.CaseNo);

        this.DbFields.add(this.Office);

        this.DbFields.add(this.SubType);

        this.DbFields.add(this.ApplyNo);

        this.DbFields.add(this.InvoiceNo);

        this.DbFields.add(this.InCharge);

        this.DbFields.add(this.CaseType);

        this.DbFields.add(this.Matter);
        
        this.DbFields.add(this.PaymentNo);

        this.DbFields.add(this.ReceiptDate);

        this.DbFields.add(this.TotalAmountDeductTTax2);
        
        this.DbFields.add(this.ServiceFeeDeductTTax2);

        this.DbFields.add(this.OriginalCurrency);
        
        this.DbFields.add(this.OriginalCurrencyAmount);
        
        this.DbFields.add(this.Note);
        
        this.DbFields.add(this.AttorneyFeeNtd);
        
        this.DbFields.add(this.OtherFeeNtd);
        
        this.DbFields.add(this.GovFeeNtd);
        
        this.DbFields.add(this.ServiceFeeNtd);
        
        this.DbFields.add(this.TotalWithHolding);
        
        this.DbFields.add(this.TotalTax);
        
        this.DbFields.add(this.TotalTax2);
        
        this.DbFields.add(this.GovFee);
        
        this.DbFields.add(this.ServiceFee);
        
        this.DbFields.add(this.AttorneyFee);
        
        this.DbFields.add(this.OtherFee);
        
        this.DbFields.add(this.InternalInvoiceNo);
    }
    
    public String printHiddenTags(){
    	String rtnString = super.printHiddenTags();
    	HashMap<String,String> hm = new HashMap<String,String>();
    	hm.put("doWriteOffFlag",Cnstnts.EMPTY_STRING);
    	hm.put("apWriteOffLogKey",Cnstnts.EMPTY_STRING);
    	hm.put("changeFee1",Cnstnts.EMPTY_STRING);
    	hm.put("changeFee2",Cnstnts.EMPTY_STRING);
    	hm.put("changeFee3",Cnstnts.EMPTY_STRING);
    	hm.put("changeFee4",Cnstnts.EMPTY_STRING);
    	hm.put("changeFee11",Cnstnts.EMPTY_STRING);
    	hm.put("changeFee21",Cnstnts.EMPTY_STRING);
    	hm.put("changeFee31",Cnstnts.EMPTY_STRING);
    	hm.put("changeFee41",Cnstnts.EMPTY_STRING);
    	hm.put("changeCurrency",Cnstnts.EMPTY_STRING);
    	hm.put("doPayment",Cnstnts.EMPTY_STRING);
  	  	rtnString += new HiddenTag().print(hm);
  	  	return rtnString;
    }public String getSubmitBtn() throws Exception {
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
		
		return rtnString + super.getSubmitBtn();
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
        	if(Util.compareTo(this.getDbActionMode(), Cnstnts.INSERT)) {
        		this.FlowKey.setValue("");
        	}
			rtnString += this.FlowKey.printHiddenTag();
			Date date = new Date();
			rtnString += this.printMaintainTable();
			////System.out.println("====1 " + (new Date().getTime()-date.getTime()));
			
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

        	this.CaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.CaseNo.setColspan(3);
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
        	this.IpType.setOnChange("setValue();");
        	
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
    				String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig where casekind ='STC04'";
    				this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    				items = DbUtil.getSelectItemList(sql, "MatterName");
                	
    				this.SubType.setSelectList(new Category().getChildList("SubType"));
    				this.SubType.setAliasName(this.getUserInfo().getMsg("jsp.ToDosQuery.SubType"));
    			}
    			else if (this.getIpType().equals("C")) {
    				String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig where casekind ='STC04'";
    				this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    				items = DbUtil.getSelectItemList(sql, "MatterName");
                	
    				this.SubType.setSelectList(new Category().getChildList("CopyrightSubType"));
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

        	this.PayToPartyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.PayToPartyName.setCheckEmpty(false);
            
        	items = new ArrayList<SelectItem>();
        	items.add(new SelectItem("A", "代理人"));
        	items.add(new SelectItem("B", "政府機關"));
        	items.add(new SelectItem("C", "其他"));
            this.PayToParty.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PayToParty.setSelectList(new Category().getChildList("PayToParty"));
            this.PayToParty.setAnotherField(this.PayToPartyName);
            this.PayToParty.setColspan(1);
            this.PayToParty.setCheckEmpty(false);
            rtnString += this.printHtml(this.PayToParty);
            
            this.PaymentNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
            this.InvoiceNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceNo.setAnotherField(this.PaymentNo);
            this.InvoiceNo.setColspan(1);
            rtnString += this.printHtml(this.InvoiceNo);
        	
            this.NotYetWriteOff.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            
            this.InCharge.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.InCharge.setSelectList(new Employee().getList());
        	this.InCharge.setAnotherField(this.NotYetWriteOff);
            this.InCharge.setColspan(1);
            rtnString += this.printHtml(this.InCharge);
            
            this.ApDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ApDateTo.setCanEdit(true);
            
            this.ApDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ApDate.setAfterText(this.getAlias(this.ApDateTo) + 
        			Html.printTag(this.ApDateTo, this.getUserInfo()));
            this.ApDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1"));
            this.ApDate.setButtonClick("addMonthToDate(0, \"apDate\");addMonthToDate(1, \"apDateTo\");");
            
            this.ApDate.setSecondButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2"));
            this.ApDate.setSecondButtonClick("addMonthToDate(0, \"apDate\");addMonthToDate(3, \"apDateTo\");");
            
            
            this.PaymentDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.PaymentDateTo.setCanEdit(true);
            
            this.PaymentDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.PaymentDate.setAnotherField(this.ApDate);
            this.PaymentDate.setColspan(1);
            this.PaymentDate.setAfterText(this.getAlias(this.PaymentDateTo) + 
        			Html.printTag(this.PaymentDateTo, this.getUserInfo()));
            this.PaymentDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1"));
            this.PaymentDate.setButtonClick("addMonthToDate(0, \"paymentDate\");addMonthToDate(1, \"paymentDateTo\");");
            
            this.PaymentDate.setSecondButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2"));
            this.PaymentDate.setSecondButtonClick("addMonthToDate(0, \"paymentDate\");addMonthToDate(3, \"paymentDateTo\");");
            rtnString += this.printHtml(this.PaymentDate);
            
            
            this.ReceiptDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ReceiptDateTo.setCanEdit(true);
            
            this.ReceiptDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ReceiptDate.setColspan(3);
            this.ReceiptDate.setAfterText(this.getAlias(this.ReceiptDateTo) + 
        			Html.printTag(this.ReceiptDateTo, this.getUserInfo()));
            this.ReceiptDate.setButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate1"));
            this.ReceiptDate.setButtonClick("addMonthToDate(0, \"receiptDate\");addMonthToDate(1, \"receiptDateTo\");");
            
            this.ReceiptDate.setSecondButtonValue(this.getUserInfo().getMsg("jsp.PatentCase.QueryDate2"));
            this.ReceiptDate.setSecondButtonClick("addMonthToDate(0, \"receiptDate\");addMonthToDate(3, \"receiptDateTo\");");
            rtnString += this.printHtml(this.ReceiptDate);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	//剛進入新增的時候，要把金額欄位全部清空，以防新增複製的時候，金額也帶過來
        	if(Util.compareTo(this.getDbActionMode(), Cnstnts.INSERT) &&
        			!Util.compareTo(this.getInitFlag(), "true")) {
        		this.TotalPaymentNtdAmount.setValue("");
        		this.TotalWriteOffAmount.setValue("");
        		this.TotalDiscountAmount.setValue("");
        		this.Amount.setValue("");
        		this.TotalRequestPayNtdAmount.setValue("");
        		this.TotalTax.setValue("");
        		this.TotalTax2.setValue("");
        		this.TotalWriteOffAmount.setValue("");
        		this.TotalDiscountAmount.setValue("");
        		this.ServiceFee.setValue("");
        		this.ServiceFeeNtd.setValue("");
        		this.GovFee.setValue("");
        		this.GovFeeNtd.setValue("");
        		this.TotalWithHolding.setValue("");
        		this.AttorneyFee.setValue("");
        		this.AttorneyFeeNtd.setValue("");
        		this.OtherFee.setValue("");
        		this.TotalAmountDeductTTax2.setValue("");
        		this.OtherFeeNtd.setValue("");
        		this.ServiceFeeDeductTTax2.setValue("");
        		this.OriginalCurrencyAmount.setValue("");
        		
        		this.setInitFlag("true");
        	}
        	
        	rtnString += this.ApplyNo.printHiddenTag();
        	
        	/*
        	此部分欄位會依據付款對象的選擇來變動：
        	“付款對象”的下拉選項有三種，“代理人”、“政府機關”、“其他”。
        	而當未選擇任何付款對象的時候欄位呈現僅呈現“付款對象”、“付款對象名稱”

        	若當選擇“代理人”時，則呈現欄位為“付款對象”、“付款對象名稱”及“查詢代理人”的按鈕，
        	使用者可以利用查詢代理人的功能將所選擇之代理人名稱帶入此“付款對象名稱”欄位內，
        	並且若付款對象是選擇代理人且將資料帶入“付款對象名稱”欄位後，於AttorneyId欄位內記錄此代理人的flowkey。

        	若當選擇“政府機關”時，則呈現的欄位為“付款對象”、“單位名稱”、“付款對象名稱”，
        	使用者可以利用“單位名稱”下拉選單選擇欲選擇之政府機關單位名稱，當選擇完成後
        	就將此選擇的政府機關單位的名稱帶入“付款對象名稱”的欄位內。

        	當若選擇“其他”時，所顯示的欄位不變仍然是“付款對象”、“付款對象名稱”，
        	而此時使用者可以自行輸入付款對象的名稱。
        	 */
        	if(Util.compareTo(this.getPayToParty(), "PayToParty02")) {
           		this.CovEntity.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
           		this.CovEntity.setSelectList(new Category().getChildList("CovEntity"));
           		this.CovEntity.setOnChange("setValue()");
            }
        	List<SelectItem> items = new ArrayList<SelectItem>();
        	items = new ArrayList<SelectItem>();
        	items.add(new SelectItem("A", "代理人"));
        	items.add(new SelectItem("B", "政府機關"));
        	items.add(new SelectItem("C", "其他"));
        	
        	if(Util.isEmpty(this.PayToParty.getValue())) {
        		this.PayToParty.setValue("PayToParty01");
        	}
            this.PayToParty.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PayToParty.setSelectList(new Category().getChildList("PayToParty"));
       		this.PayToParty.setOnChange("setValue()");
        	this.PayToParty.setCheckEmpty(true);
       		if(Util.compareTo(this.getPayToParty(), "PayToParty02")) {
       			this.PayToParty.setAnotherField(this.CovEntity);
                this.PayToParty.setColspan(1);
       		}
       		else {
                this.PayToParty.setColspan(3);
       		}
            rtnString += this.printHtml(this.PayToParty);
            

            this.PaymentNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.PayToPartyName.setColspan(1);
            this.PayToPartyName.setAnotherField(this.PaymentNo);
        	this.PayToPartyName.setCheckEmpty(true);

            if(Util.compareTo(this.getPayToParty(), "PayToParty01") || Util.compareTo(this.getPayToParty(), "PayToParty04") || Util.compareTo(this.getPayToParty(), "")) {
	            this.PayToPartyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	        	if(this.canEdit() && (Util.compareTo(this.getPayToParty(), "PayToParty01") || Util.compareTo(this.getPayToParty(), "PayToParty04"))){
	            	if(this.getDbActionMode().equals(Cnstnts.INSERT) 
	            			|| (this.getDbActionMode().equals(Cnstnts.UPDATE))){
	            		this.PayToPartyName.setButtonValue(this.getUserInfo().getMsg("jsp.PatentAttorney.QueryAttorney"));
	            		this.PayToPartyName.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=PaymentAttorney\",\"Client\",800,600)");
	            	}
	            }
	            rtnString += this.printHtml(this.PayToPartyName);
	            rtnString += this.AttorneyId.printHiddenTag();
            }
            else if(Util.compareTo(this.getPayToParty(), "PayToParty02")) {
	            this.PayToPartyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            if(!Util.isEmpty(this.getCovEntity())) {
	            	this.PayToPartyName.setValue(new Category().getNamesPrpts().getProperty(this.getCovEntity()));
	            }
	            rtnString += this.printHtml(this.PayToPartyName);
            }
            else if(Util.compareTo(this.getPayToParty(), "PayToParty03")) {
	            this.PayToPartyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            rtnString += this.printHtml(this.PayToPartyName);
            }
            

            rtnString += "<input type='hidden' name='entity' id='entity'>";
            
            this.ReceiptDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.InvoiceNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceNo.setAnotherField(this.ReceiptDate);
            this.InvoiceNo.setColspan(1);
            rtnString += this.printHtml(this.InvoiceNo);

            
            this.ApDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.PaymentDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.PaymentDate.setAnotherField(this.ApDate);
            this.PaymentDate.setColspan(1);
            rtnString += this.printHtml(this.PaymentDate);
            
        	items = new ArrayList<SelectItem>();
        	items.addAll(new Category().getChildList("PatentCaseType"));
        	items.addAll(new Category().getChildList("TrademarkCaseType"));
        	items.addAll(new Category().getChildList("MainType"));
        	items.addAll(new Category().getChildList("CopyrightMainType"));
            
        	this.CaseType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        	this.CaseType.setSelectList(items);
        	
        	if(Util.compareTo(this.getChangeCaseNo(), "true")) {
        		String caseType = "";
            	String office = "";
            	String title = "";
            	String SubType = "";
            	
            	String sql = "select 'P' as CaseType, flowkey from patentcase p" +
            			" where p.caseno='" + this.getCaseNo() + "'" +
            			" union " +
            			"select 'T' as CaseType, flowkey from trademarkcase t" +
            			" where t.caseno='" + this.getCaseNo() + "'" +
//            			" union " +
//            			"select 'C' as CaseType, flowkey from copyrightcase t" +
//            			" where t.caseno='" + this.getCaseNo() + "'" +
            			" union " +
            			"select 'L' as CaseType, flowkey from legalcase l" +
            			" where l.caseno='" + this.getCaseNo() + "'";
            	List<Object[]>  caseTypes = this.getDbUtil().getList(sql, new String[]{"CaseType", "flowkey"});
            	if (!caseTypes.isEmpty()) {
            		String caseTypeMark = caseTypes.get(0)[1].toString();
            		String flowkey = caseTypes.get(0)[2].toString();
            		if (caseTypeMark.equals("P")) {
						PatentCase caseInfos = new PatentCase(flowkey);
						Client clientInfos = new Client(caseInfos.getClient());
						
						caseType = "專利案件";
						office = caseInfos.getPatentOffice();
						title = caseInfos.getTitle();
						SubType = caseInfos.getPatentType();
						
						
					} 
					else if (caseTypeMark.equals("T")) {
						TrademarkCase caseInfos = new TrademarkCase(flowkey);
						Client clientInfos = new Client(caseInfos.getClient());
						
						caseType = "商標案件";
						office = caseInfos.getOffice();
						title = caseInfos.getTitle();
						SubType = caseInfos.getTrademarkType();
						
					} 
					else if (caseTypeMark.equals("L")) {
						LegalCase caseInfos = new LegalCase(flowkey);
						Client clientInfos = new Client(caseInfos.getClient());
						
						caseType = "法律案件";
						title = caseInfos.getTitle();
						SubType = caseInfos.getSubType();
						
					}
//					else if (caseTypeMark.equals("c")) {
//						CopyrightCase caseInfos = new CopyrightCase(flowkey);
//						Client clientInfos = new Client(caseInfos.getClient());
//						
//						caseType = "著作權案件";
//						office = caseInfos.getOffice();
//						title = caseInfos.getTitle();
//						SubType = caseInfos.getSubType();
//						
//					}
//            		
            		this.CaseType.setValue(caseType);
            		this.Office.setValue(office);
            		this.Title.setValue(title);
            		this.SubType.setValue(SubType);
            	}
        	}
                    	
        	this.CaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.CaseNo.setAnotherField(this.CaseType);
            this.CaseNo.setColspan(1);
            this.CaseNo.setOnChange("document.input.changeCaseNo.value=\"true\";setValue();");
            this.CaseNo.setSetCaseNoAutoField(true);
            rtnString += this.printHtml(this.CaseNo);
            
        	this.Office.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Office.setSelectList(new Category().getChildList("PatentOffice"));

        	items = new ArrayList<SelectItem>();
            items.addAll(new Category().getChildList("PatentType"));
            items.addAll(new Category().getChildList("TrademarkType"));
            items.addAll(new Category().getChildList("SubType"));
            items.addAll(new Category().getChildList("CopyrightSubType"));
            
        	this.SubType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.SubType.setSelectList(items);
            this.SubType.setAnotherField(this.Office);
            this.SubType.setColspan(1);
        	rtnString += this.printHtml(this.SubType);
        	
        	
            this.InternalInvoiceNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            if(this.getDbActionMode().equals(Cnstnts.INSERT) 
        			|| (this.getDbActionMode().equals(Cnstnts.UPDATE))){
	            this.InternalInvoiceNo.setButtonValue(this.getUserInfo().getMsg("jsp.Payment.QueryInvoiceNo"));
	    		this.InternalInvoiceNo.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=InternalInvoiceNo"
	    				+ "&queryText1=" + this.getCaseNo() + "\",\"Invoice\",800,600)");
            }
            
            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Title.setSize(60);
            this.Title.setLength(250);
            this.Title.setColspan(1);
            this.Title.setAnotherField(this.InternalInvoiceNo);
            rtnString += this.printHtml(this.Title);
        	
        	items = new ArrayList<SelectItem>();
            String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig";
            items.addAll(DbUtil.getSelectItemList(sql,"MatterName"));
        	

        	this.InCharge.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.InCharge.setSelectList(new Employee().getList());
        	
        	this.Matter.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.Matter.setSelectList(items);
            this.Matter.setAnotherField(this.InCharge);
            this.Matter.setColspan(1);
            rtnString += this.printHtml(this.Matter);
            
            rtnString += this.printAmoutHtml();

        }

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
			    "  doPatentCaseAjaxRequest('Payment',newTabText,'"+this.getFlowKey()+"',DataDiv,'innerHTML')"+
			    "}"+
				"</script>";

		rtnString += this.printTabAreaHtml();

        return rtnString;
    }
    
    public String printAmoutHtml() throws Exception {
    	String rtnString = "";
    	
    	Category cate = new Category(this.getOriginalCurrency());
    	
      if(Util.compareTo(this.getChangeFee1(), "true") ||
    		  Util.compareTo(this.getChangeFee2(), "true") ||
    		  Util.compareTo(this.getChangeFee3(), "true") ||
    		  Util.compareTo(this.getChangeFee4(), "true")) {
    	  String OriginalCurrencyAmount = (Util.stringToDouble(this.GovFee.getValue()) +
    			  Util.stringToDouble(this.AttorneyFee.getValue()) +
    			  Util.stringToDouble(this.ServiceFee.getValue()) +
    			  Util.stringToDouble(this.OtherFee.getValue())) + "";
    	  this.OriginalCurrencyAmount.setValue(OriginalCurrencyAmount);
      }
      this.OriginalCurrencyAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      
      this.OriginalCurrency.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
      this.OriginalCurrency.setSelectList(new Category().getChildList(this.Currency));
      this.OriginalCurrency.setAnotherField(this.OriginalCurrencyAmount);
      this.OriginalCurrency.setOnChange("document.input.changeCurrency.value=true;setValue()");
      this.OriginalCurrency.setColspan(1);
      rtnString += this.printHtml(this.OriginalCurrency);

      if((Util.compareTo(this.getChangeFee1(), "true") ||
    		  Util.compareTo(this.getChangeCurrency(), "true")) && cate != null) {
    	  String ntd = ((int)Util.round(Util.stringToDouble(this.GovFee.getValue()) *
    			  Util.stringToDouble(cate.getRate()), 0)) + "";
    	  this.GovFeeNtd.setValue( ntd );
      }
      this.GovFeeNtd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.GovFeeNtd.setOnChange("document.input.changeFee11.value=true;setValue();");

      this.GovFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.GovFee.setAnotherField(this.GovFeeNtd);
      this.GovFee.setOnChange("document.input.changeFee1.value=true;setValue();");
      this.GovFee.setColspan(1);
      rtnString += this.printHtml(this.GovFee);

      if((Util.compareTo(this.getChangeFee2(), "true") ||
    		  Util.compareTo(this.getChangeCurrency(), "true")) && cate != null) {
    	  String ntd = ((int)Util.round(Util.stringToDouble(this.AttorneyFee.getValue()) *
    			  Util.stringToDouble(cate.getRate()), 0)) + "";
    	  this.AttorneyFeeNtd.setValue( ntd );
      }

      this.AttorneyFeeNtd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.AttorneyFeeNtd.setOnChange("document.input.changeFee21.value=true;setValue();");

      this.AttorneyFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.AttorneyFee.setAnotherField(this.AttorneyFeeNtd);
      this.AttorneyFee.setColspan(1);
      this.AttorneyFee.setOnChange("document.input.changeFee2.value=true;setValue();");
      rtnString += this.printHtml(this.AttorneyFee);

      if((Util.compareTo(this.getChangeFee3(), "true") ||
    		  Util.compareTo(this.getChangeCurrency(), "true")) && cate != null) {
    	  String ntd = ((int)Util.round(Util.stringToDouble(this.ServiceFee.getValue()) *
    			  Util.stringToDouble(cate.getRate()), 0)) + "";
    	  this.ServiceFeeNtd.setValue( ntd );
      }

      this.ServiceFeeNtd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.ServiceFeeNtd.setOnChange("document.input.changeFee31.value=true;setValue();");

      this.ServiceFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.ServiceFee.setAnotherField(this.ServiceFeeNtd);
      this.ServiceFee.setColspan(1);
      this.ServiceFee.setOnChange("document.input.changeFee3.value=true;setValue();");
      rtnString += this.printHtml(this.ServiceFee);

      if((Util.compareTo(this.getChangeFee4(), "true") ||
    		  Util.compareTo(this.getChangeCurrency(), "true")) && cate != null) {
    	  String ntd = ((int)Util.round(Util.stringToDouble(this.OtherFee.getValue()) *
    			  Util.stringToDouble(cate.getRate()), 0)) + "";
    	  this.OtherFeeNtd.setValue( ntd );
      }

      this.OtherFeeNtd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.OtherFeeNtd.setOnChange("document.input.changeFee41.value=true;setValue();");

      this.OtherFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.OtherFee.setAnotherField(this.OtherFeeNtd);
      this.OtherFee.setColspan(1);
      this.OtherFee.setOnChange("document.input.changeFee4.value=true;setValue();");
      rtnString += this.printHtml(this.OtherFee);

      this.TotalTax2.setHtmlType(Cnstnts.HTML_TAG_TEXT);

      this.TotalTax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.TotalTax.setAnotherField(this.TotalTax2);
      this.TotalTax.setColspan(1);
      rtnString += this.printHtml(this.TotalTax);

      this.TotalWriteOffAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);

      this.TotalDiscountAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.TotalDiscountAmount.setAnotherField(this.TotalWriteOffAmount);
      this.TotalDiscountAmount.setColspan(1);
      rtnString += this.printHtml(this.TotalDiscountAmount);

      if((Util.compareTo(this.getChangeFee1(), "true") ||
    		  Util.compareTo(this.getChangeFee2(), "true") ||
    		  Util.compareTo(this.getChangeFee3(), "true") ||
    		  Util.compareTo(this.getChangeFee4(), "true") ||
    		  Util.compareTo(this.getChangeFee11(), "true") ||
    		  Util.compareTo(this.getChangeFee21(), "true") ||
    		  Util.compareTo(this.getChangeFee31(), "true") ||
    		  Util.compareTo(this.getChangeFee41(), "true") ||
    		  Util.compareTo(this.getChangeCurrency(), "true"))) {
    	  String ntd = (Util.stringToInt(this.GovFeeNtd.getValue()) +
    			  Util.stringToInt(this.AttorneyFeeNtd.getValue()) +
    			  Util.stringToInt(this.ServiceFeeNtd.getValue()) +
    			  Util.stringToInt(this.OtherFeeNtd.getValue())) + "";
    	  this.TotalPaymentNtdAmount.setValue( ntd );
      }
      this.TotalPaymentNtdAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      
      this.Note.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
      this.Note.setAnotherField(this.TotalPaymentNtdAmount);
      this.Note.setRows(2);
      this.Note.setCols(65);
      this.Note.setColspan(1);
      rtnString += this.printHtml(this.Note);
  	
      return rtnString;
    }
    

    
    public String printAmoutHtml_origin() throws Exception {
    	String rtnString = "";
    	

//      sql = "select sum(i.Amount) as count from PaymentDetail i where i.ParentId='" + this.getFlowKey() + "'";
      String sql = "select if(sum(if(i.paymentdetailtype='D',i.payment,i.amount)) is null , 0 , sum(if(i.paymentdetailtype='D',i.payment,i.amount))) as count from paymentdetail i where i.parentid = '" + this.getFlowKey() + "'";
      String originalCurrencyAmount = this.getDbUtil().getFieldValue(sql, "count");
      
      this.OriginalCurrencyAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//      this.OriginalCurrencyAmount.setValue(originalCurrencyAmount);
      
//      sql = "select i.PaymentCurrency as count from PaymentDetail i where i.ParentId='" + this.getFlowKey() + "'";
//      List<String> originalCurrencylist = this.getDbUtil().getValueList(sql,"count");
      
      this.OriginalCurrency.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
      this.OriginalCurrency.setSelectList(new Category().getChildList(this.Currency));
//      if(originalCurrencylist.size()>0){
//      	this.OriginalCurrency.setValue(originalCurrencylist.get(0));
//      }
      this.OriginalCurrency.setAnotherField(this.OriginalCurrencyAmount);
      this.OriginalCurrency.setColspan(1);
      
      rtnString += this.printHtml(this.OriginalCurrency);

      /*
       * “代收政府規費台幣總額”欄位是自動計算此筆Invoice底下所有PaymentDetail
       * 符合PaymentDetail中TodosId所關連的Todos資料的AccountTitle欄位為AccountTitle01的資料，
       * 自動加總PaymentDetail的PaymentAmount欄位資料
       */
      sql = "select if(sum(PaymentAmount) is null , 0 , sum(PaymentAmount)) as count from PaymentDetail i, todos t " +
	    		"where i.ParentId ='" + this.getFlowKey() + "' " +
	    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle01'";
	    String sum = this.getDbUtil().getFieldValue(sql, "count");
      this.GovFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//  	this.GovFee.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");
  	
  	 /*
       * “服務費台幣總額”欄位是自動計算此筆Invoice底下
       * 所有PaymentDetail符合PaymentDetail中TodosId所關連的Todos資料的AccountTitle欄位
       * 為AccountTitle03的資料，自動加總PaymentDetail的PaymentAmount欄位資料
       */
      sql = "select if(sum(PaymentAmount) is null , 0 , sum(PaymentAmount)) as count from PaymentDetail i, todos t " +
      		"where i.ParentId ='" + this.getFlowKey() + "' " +
      		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle03'";
      sum = this.getDbUtil().getFieldValue(sql, "count");
      int ServiceFee = (int)Util.round(Util.stringToDouble(sum), 0);
  	
      //“執行業務所得稅總額(TotalTax2)”為此筆請款單中的所有
      //“請款明細(PaymentDetail)”的“10%執行業務所得稅(Tax2)”總和
      sql = "select if(sum(Tax2) is null , 0 , sum(Tax2)) as count from PaymentDetail where ParentId ='" + this.getFlowKey() + "'";
      sum = this.getDbUtil().getFieldValue(sql, "count");
      int TotalTax2 = (int)Util.round(Util.stringToDouble(sum), 0);
      
    //"服務費台幣扣繳後總額"(ServiceFeeDeductTTax2) =服務費台幣總額-執行業務所得稅總額
  	this.ServiceFeeDeductTTax2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//  	this.ServiceFeeDeductTTax2.setValue((ServiceFee-TotalTax2)+"");
  	this.ServiceFeeDeductTTax2.setValue((Util.stringToInt(this.getServiceFee())-Util.stringToInt(this.getTotalTax2()))+"");
  	this.ServiceFeeDeductTTax2.setAnotherField(this.GovFee);
  	
      this.ServiceFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.ServiceFee.setAnotherField(this.ServiceFeeDeductTTax2);
      this.ServiceFee.setOnChange("setValue()");
//  	this.ServiceFee.setValue(ServiceFee+"");
      rtnString += this.printHtml(this.ServiceFee);

      //“營業稅總額(TotalTax)”欄位為此筆請款單中所有
  	//“請款明細(PaymentDetail)”的“5%營業稅(Tax)”總和
  	sql = "select if(sum(Tax) is null , 0 , sum(Tax)) as count from PaymentDetail where ParentId ='" + this.getFlowKey() + "'";
      sum = this.getDbUtil().getFieldValue(sql, "count");
      this.TotalTax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//      this.TotalTax.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");
  	
      //“執行業務所得稅總額(TotalTax2)”為此筆請款單中的所有
      //“請款明細(PaymentDetail)”的“10%執行業務所得稅(Tax2)”總和
      sql = "select if(sum(Tax2) is null , 0 , sum(Tax2)) as count from PaymentDetail where ParentId ='" + this.getFlowKey() + "'";
      sum = this.getDbUtil().getFieldValue(sql, "count");
  	this.TotalTax2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//  	this.TotalTax2.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");
  	this.TotalTax2.setAnotherField(this.TotalTax);
      this.TotalTax2.setOnChange("setValue()");
  	
  	sql = "select if(sum(Tax2) is null , 0 , sum(Tax2)) as count from PaymentDetail where WithHolding='Y' and ParentId ='" + this.getFlowKey() + "'";
      sum = this.getDbUtil().getFieldValue(sql,"count"); 
      this.TotalWithHolding.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.TotalWithHolding.setCanEdit(false);
//      this.TotalWithHolding.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");
      this.TotalWithHolding.setAnotherField(this.TotalTax2);
      rtnString += this.printHtml(this.TotalWithHolding);
      
      /*
       * “複代理費台幣總額”欄位是自動計算此筆Invoice底下
       * 所有PaymentDetail符合PaymentDetail中TodosId所關連的Todos資料的AccountTitle欄位
       * 為AccountTitle02的資料，自動加總PaymentDetail的PaymentAmount欄位資料
       */
//      sql = "select sum(t.Amount) as count from PaymentDetail i, todos t " +
//	    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//	    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle02'";
//	    sum = this.getDbUtil().getFieldValue(sql, "count");
//      this.AttorneyFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//      this.AttorneyFee.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");
//      
//      sql = "select t.currency from PaymentDetail i, todos t " +
//	    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//	    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle02' " +
//	    		"and t.currency != ''";
//      this.AttorneyCurrency.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//      this.AttorneyCurrency.setSelectList(new Category().getChildList("Currency"));
//      this.AttorneyCurrency.setAnotherField(this.AttorneyFee);
//      this.AttorneyCurrency.setValue(this.getDbUtil().getFieldValue(sql, "currency"));
//      
//      sql = "select sum(PaymentAmount) as count from PaymentDetail i, todos t " +
//	    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//	    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle02'";
//	    sum = this.getDbUtil().getFieldValue(sql, "count");
//      this.AttorneyFeeNtd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//      this.AttorneyFeeNtd.setAnotherField(this.AttorneyCurrency);
//  	this.AttorneyFeeNtd.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");
//      rtnString += this.printHtml(this.AttorneyFeeNtd);
      
      /*
       * 20120216
       * (4) 其他款項的付款幣別、原弊金額、台幣金額應該是加到 master欄位的其他費用幣別、其他費用金額、其他費用台幣金額

       * “其他費用台幣總額”欄位是自動計算此筆Invoice底下
       * 所有PaymentDetail符合PaymentDetail中TodosId所關連的Todos資料的AccountTitle欄位
       * 為AccountTitle04的資料，自動加總PaymentDetail的PaymentAmount欄位資料
       */
//      sql = "select sum(t.Amount) as count from PaymentDetail i, todos t " +
//	    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//	    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle04'";
//	    sum = this.getDbUtil().getFieldValue(sql, "count");
//	    sql = "select sum(i.Amount) as count from PaymentDetail i " +
//	    		"where i.ParentId ='" + this.getFlowKey() + "' and i.PaymentDetailType = 'O'";
//	    String sum2 = this.getDbUtil().getFieldValue(sql, "count");

//      this.OtherFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//      this.OtherFee.setValue((int)(Util.round(Util.stringToDouble(sum), 0) + Util.round(Util.stringToDouble(sum2), 0))+"");
//      
//      sql = "select t.currency from PaymentDetail i, todos t " +
//	    		"where i.ParentId ='" + this.getFlowKey() + "' " +
//	    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle04' " +
//	    		"and t.currency != ''";
//      String currency = this.getDbUtil().getFieldValue(sql, "currency");
//      this.OtherCurrency.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//      this.OtherCurrency.setSelectList(new Category().getChildList("Currency"));
//      this.OtherCurrency.setAnotherField(this.OtherFee);
//      this.OtherCurrency.setValue(currency);
      

		
      //“折讓總額(TotalDiscountAmount)”此筆請款單中的所有
      //“請款明細(PaymentDetail)”的“折讓金額(DiscountAmount)”總和
  	sql = "select if(sum(DiscountAmount) is null , 0 , sum(DiscountAmount)) as count from PaymentDetail where ParentId ='" + this.getFlowKey() + "'";
      sum = this.getDbUtil().getFieldValue(sql, "count");
      this.TotalDiscountAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//  	this.TotalDiscountAmount.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");
      
      sql = "select if(sum(PaymentAmount) is null , 0 , sum(PaymentAmount)) as count from PaymentDetail i, todos t " +
	    		"where i.ParentId ='" + this.getFlowKey() + "' " +
	    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle02'";
	    sum = this.getDbUtil().getFieldValue(sql, "count");
	    this.AttorneyFeeNtd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	    this.AttorneyFeeNtd.setAnotherField(this.TotalDiscountAmount);
//		this.AttorneyFeeNtd.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");

      sql = "select if(sum(PaymentAmount) is null , 0 , sum(PaymentAmount)) as count from PaymentDetail i, todos t " +
	    		"where i.ParentId ='" + this.getFlowKey() + "' " +
	    		"and t.flowkey = i.todosid and t.accounttitle = 'AccountTitle04'";
	    sum = this.getDbUtil().getFieldValue(sql, "count");
	    sql = "select if(sum(PaymentAmount) is null , 0 , sum(PaymentAmount)) as count from PaymentDetail i " +
	    		"where i.ParentId ='" + this.getFlowKey() + "' and i.PaymentDetailType ='O'";
	    String sum2 = this.getDbUtil().getFieldValue(sql, "count");

      this.OtherFeeNtd.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.OtherFeeNtd.setAnotherField(this.AttorneyFeeNtd);
//  	this.OtherFeeNtd.setValue((int)(Util.round(Util.stringToDouble(sum), 0) + Util.round(Util.stringToDouble(sum2), 0))+"");
      rtnString += this.printHtml(this.OtherFeeNtd);
      
  	
      //“已沖銷總額(TotalWriteOffAmount)”為此筆請款單中的所有
      //“請款明細(PaymentDetail)”的“已沖銷金額(AlreadyWriteOffAmount)”總和
  	sql = "select if(sum(AlreadyWriteOffAmount) is null , 0 , sum(AlreadyWriteOffAmount)) as count from PaymentDetail where ParentId ='" + this.getFlowKey() + "'";
      sum = this.getDbUtil().getFieldValue(sql, "count");
  	this.TotalWriteOffAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//  	this.TotalWriteOffAmount.setValue((int)Util.round(Util.stringToDouble(sum), 0)+"");

  	//“請款台幣總額(TotalPaymentAmountNtdAmount)”欄位為此筆請款單中的所有
  	//“請款明細(PaymentDetail)”的“本次請款金額(PaymentAmount)”總和
  	sql = "select if(sum(PaymentAmount) is null , 0 , sum(PaymentAmount)) as count from PaymentDetail where ParentId ='" + this.getFlowKey() + "'";
      sum = this.getDbUtil().getFieldValue(sql, "count");
      int TotalPaymentNtdAmount = (int)Util.round(Util.stringToDouble(sum), 0);
      
  	//TotalAmountDeductTTax2=請款台幣總額-執行業務所得稅總額。
  	this.TotalAmountDeductTTax2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.TotalAmountDeductTTax2.setAnotherField(this.TotalWriteOffAmount);
//      this.TotalAmountDeductTTax2.setValue((TotalPaymentNtdAmount-TotalTax2)+"");
      this.TotalAmountDeductTTax2.setValue((Util.stringToInt(this.getTotalPaymentNtdAmount())-Util.stringToInt(this.getTotalTax2()))+"");
  	
      this.TotalPaymentNtdAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      this.TotalPaymentNtdAmount.setAnotherField(this.TotalAmountDeductTTax2);
      this.TotalPaymentNtdAmount.setOnChange("setValue()");
//  	this.TotalPaymentNtdAmount.setValue(TotalPaymentNtdAmount+"");
      rtnString += this.printHtml(this.TotalPaymentNtdAmount);
      
      return rtnString;
    }
    
    public String printTabAreaHtml() throws Exception {
    	String rtnString = "";
    	if(this.onMaintainMode()) {
            if(this.FlowKey.getValue().trim().length() > 0) {
            	boolean canShowTabs3 = false;
            	Groups group = new Groups();
            	//相關請款資訊tab調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
				if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
						!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
					canShowTabs3 = true;
				}
            	
            	String TabSelect = Cnstnts.EMPTY_STRING;
            	rtnString += "<script type='text/javascript'>$(function(){$('#tabs').tabs(" +TabSelect + ");});</script>";
            	rtnString += "<tr><td colspan=4>"+
				"<div id='tabs'><ul>"+
				"<li><a href='#tabs-1'>"+this.getUserInfo().getMsg("jsp.PaymentDetail.title")+"</a></li>" +
				"<li><a href='#tabs-2'>"+this.getUserInfo().getMsg("jsp.ApWriteoffLog.title")+"</a></li>";
            	if(canShowTabs3) {
            		rtnString += "<li><a href='#tabs-3'>"+this.getUserInfo().getMsg("jsp.Payment.ReleatedInvoiceInfo")+"</a></li>";
            	}
            	rtnString += "</ul>";
            	
            	/**** tabs-1 ****/
            	rtnString +="<div id='tabs-1'>";
            	rtnString += "<fieldset><legend>"+this.getUserInfo().getMsg("jsp.PaymentDetail.PaymentDetail")+"</legend>";
	        	rtnString +="<div class='indent'>";
				rtnString += "<table width=95% border=0><tr><td valign=top>";
				rtnString +="<div id='updatePaymentDetailDiv' name='updatePaymentDetailDiv'></div>";
				rtnString +="<div id='PaymentDetailDiv' name='PaymentDetailDiv'>";
				PaymentDetail detail = new PaymentDetail();
				detail.init();
				detail.setUserInfo(this.getUserInfo());
				rtnString += detail.printSearchReasult();

				rtnString += "</div></td></tr></table>";
				rtnString +="</div></fieldset></br>"; 
				
				rtnString += "<fieldset><legend>"+this.getUserInfo().getMsg("jsp.PaymentDetail.PaymentOther")+"</legend>";
	        	rtnString +="<div class='indent'>";
				rtnString += "<table width=95% border=0><tr><td valign=top>";
				rtnString +="<div id='updatePaymentOtherDiv' name='updatePaymentOtherDiv'></div>";
				rtnString +="<div id='PaymentOtherDiv' name='PaymentOtherDiv'>";
				rtnString += detail.printOtherReasult();

				rtnString += "</div></td></tr></table>";
				rtnString +="</div></fieldset></br>"; 

	            rtnString +="</div>";
	            /**** tabs-1 end ****/
	            
	            /**** tabs-2 ****/
	            rtnString +="<div id='tabs-2'>";
            	rtnString += "<fieldset><legend>"+this.getUserInfo().getMsg("jsp.ApWriteoffLog.PaymentDetailHeader")+"</legend>";
	        	rtnString +="<div class='indent'>";
				rtnString += "<table width=95% border=0><tr><td valign=top>";
				rtnString += "<div id='updateLegalReleatedCaseDiv' name='updateLegalReleatedCaseDiv'></div>";
				rtnString += "<div id='LegalReleatedCaseDiv' name='LegalReleatedCaseDiv'>";
				ApWriteoffLog log = new ApWriteoffLog();
	            log.init();
	            rtnString += log.getSearchReasult2(this.getUserInfo(), this.getFlowKey(), "D");

				rtnString += "</div></td></tr></table>";
				rtnString +="</div></fieldset></br>"; 
				
//				rtnString += "<fieldset><legend>"+this.getUserInfo().getMsg("jsp.ApWriteoffLog.PaymentOtherHeader")+"</legend>";
//	        	rtnString +="<div class='indent'>";
//				rtnString += "<table width=95% border=0><tr><td valign=top>";
//				rtnString += "<div id='updateLegalReleatedDocumentDiv' name='updateLegalReleatedDocumentDiv'></div>";
//				rtnString += "<div id='LegalReleatedDocumentDiv' name='LegalReleatedDocumentDiv'>";
//				rtnString += log.getSearchReasult2(this.getUserInfo(), this.getFlowKey(), "O");
//
//				rtnString += "</div></td></tr></table>";
//				rtnString +="</div></fieldset></br>"; 

	            rtnString +="</div>";
	            /**** tabs-2 end ****/
	            
	            /**** tabs-3 ****/
            	if(canShowTabs3) {
            		rtnString +="<div id='tabs-3'>";
            		rtnString +="<div class='indent'>";
            		rtnString +="<table width=95% border=0><tr><td valign=top>";
            		rtnString +="<div id='updateReleatedInvoiceInfoDiv' name='updateReleatedInvoiceInfoDiv'></div>";
            		rtnString +="<div id='ReleatedInvoiceInfoDiv' name='ReleatedInvoiceInfoDiv'>";
            		rtnString += printReleatedInvoiceInfo();
            		
            		rtnString +="</div></td></tr></table>";
            		rtnString +="</div>";
            		rtnString +="</div>";
            	}
	            /**** tabs-3 end ****/
	            
	            
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
						    "  doPatentCaseAjaxRequest('Payment',newTabText,'"+this.getFlowKey()+"',DataDiv,'innerHTML')"+
						    "}"+
							"</script>";
			    rtnString += scriptText;
			    rtnString += "</td></tr>";
            }
    	}
    	
		return rtnString;
    }
    
    @SuppressWarnings("unchecked")
	public String printReleatedTodosReasult() throws Exception {
		if (this.onBtnSearch()) {
			this.setSearchResult(this.getSearchList());
		}

		StringBuffer strBfr = new StringBuffer();

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

    	Properties matterPrpt = null;
    	try {
    		matterPrpt = new PatentMatterConfig().getNamesPrpts();
    		matterPrpt.putAll(categoryPrpt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='9%'>案件編號</td>";
		String thText21="<td align='center' width='9%'>"+this.getUserInfo().getMsg("jsp.ToDos.Matter")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Invoice.Title")+"</td>";
		String thText4="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Invoice.ClientName")+"</td>";
		String thText5="<td align='center' width='9%'>"+this.getUserInfo().getMsg("jsp.ToDos.Finished")+"</td>";
		String thText6="<td align='center' width='9%'>"+this.getUserInfo().getMsg("jsp.ToDos.AccountTitle")+"</td>";
		String thText7="<td align='center' width='9%'>"+this.getUserInfo().getMsg("jsp.ToDos.Currency")+"</td>";
		String thText8="<td align='center' width='9%'>"+this.getUserInfo().getMsg("jsp.ToDos.Amount")+"</td>";
		String thText9="<td align='center' width='9%'>"+this.getUserInfo().getMsg("jsp.ToDos.RequestPayAmount")+"</td>";
		String thText10="<td align='center' width='9%'>"+this.getUserInfo().getMsg("jsp.ToDos.NotYetRequestPayAmount")+"</td>";
		String thText11="<td align='center' width='9%'>"+this.getUserInfo().getMsg("jsp.PaymentOther.NtdAmount")+"</td>";
		String thText12="<td align='center' width='9%'>"+this.getUserInfo().getMsg("jsp.Payment.TotalPaymentWriteOffAmount")+"</td>";
		String thText13=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText13 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText21+thText3+thText4+thText5+thText6+
				thText7+thText8+thText9+thText10+thText11+thText12+thText13+"</tr>");
		int i=0;
		String SQL = "select FlowKey from todos where parentid = '" + this.getCaseNo() + "' " +
				"and Matter ='" + this.getMatter() + "' " +
				"and IsPayment='Y' order by flowkey";
		List<String> keys = this.getDbUtil().getValueList(SQL, "FlowKey");
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		double RequestPayAmount = 0;
		double NotYetRequestPayAmount = 0;
		for(String key : keys){
			ToDos todos = new ToDos(key);
			
			String sql = "select 'P' as caseType, p.FlowKey from patentcase p where p.flowkey = '" + todos.getParentId() + "' " +
					"union " +
					"select 'L' as caseType, p.FlowKey from legalcase p  where p.flowkey = '" + todos.getParentId() + "' " +
					"union " +
					"select 'T' as caseType, p.FlowKey from trademarkcase p  where p.flowkey = '" + todos.getParentId() + "'" ;
//					"union " +
//					"select 'C' as caseType, p.FlowKey from copyrightcase p  where p.flowkey = '" + todos.getParentId() + "'";
			List<Object[]> objs = this.getDbUtil().getList(sql, new String[]{"caseType"});
			String clientName = "";
			if(!objs.isEmpty()) {
				Object[] obj = objs.get(0);
				if ("P".equals(obj[1])) {
					PatentCase patent = new PatentCase(obj[0] + "");
					clientName = clientPrpt.getProperty(patent.getClient());
				}
				else if ("L".equals(obj[1])) {
					LegalCase patent = new LegalCase(obj[0] + "");
					clientName = clientPrpt.getProperty(patent.getClient());
				}
				else if ("T".equals(obj[1])) {
					TrademarkCase patent = new TrademarkCase(obj[0] + "");
					clientName = clientPrpt.getProperty(patent.getClient());
				}
			}
			
			sql = "select sum(WriteOffAmount) as count from apwriteofflog where Reversal ='' and TodosId = '"+key+"'";
			String totalPaymentWriteOffAmount = "0";
			String count = this.getDbUtil().getFieldValue(sql, "count");
			if(!Util.isEmpty(count) && !Util.compareTo(count, "0")){
				totalPaymentWriteOffAmount = count;
			}
			
			RequestPayAmount += Util.stringToDouble(todos.getRequestPayAmount());
			NotYetRequestPayAmount += Util.stringToDouble(todos.getNotYetRequestPayAmount());
			
			String onClick = "";
			
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+todos.getParentId()+"</td>";
			String tdText21="<td align='center'>"+matterPrpt.getProperty(todos.getMatter())+"</td>";
			String tdText3="<td>"+todos.getTaskDescription()+"</td>";
			String tdText4="<td>"+clientName+"</td>";
			String tdText5="<td align='center'>"+Util.getBooleanImg(todos.getFinished())+"</td>";
			String tdText6="<td>"+categoryPrpt.getProperty(todos.getAccountTitle())+"</td>";
			String tdText7="<td align='center'>"+categoryPrpt.getProperty(todos.getCurrency())+"</td>";
			String tdText8="<td align='center'>"+todos.getAmount()+"</td>";
			String tdText9="<td align='center'>"+todos.getRequestPayAmount()+"</td>";
			String tdText10="<td align='center'>"+todos.getNotYetRequestPayAmount()+"</td>";
			String tdText11="<td align='center'>"+todos.getTwdAmount()+"</td>";
			String tdText12="<td align='center'>"+totalPaymentWriteOffAmount+"</td>";
			String tdText13=Cnstnts.EMPTY_STRING;
			
			printValue = tdText1+tdText2+tdText21+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8+tdText9+tdText10+tdText11+tdText12+tdText13;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}

			i++;
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		String result = "應請款總額為 %s 元     未請款餘額為 %s 元";
		
		return String.format(result, Util.round(RequestPayAmount, 0), 
				Util.round(NotYetRequestPayAmount, 0)) + strBfr.toString();
    }

    
    @SuppressWarnings("unchecked")
	public String printReleatedInvoiceReasult() throws Exception {
		if (this.onBtnSearch()) {
			this.setSearchResult(this.getSearchList());
		}

		StringBuffer strBfr = new StringBuffer();

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

    	Properties matterPrpt = null;
    	try {
    		matterPrpt = new PatentMatterConfig().getNamesPrpts();
    		matterPrpt.putAll(categoryPrpt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.Invoice.InvoiceNo")+"</td>";
		String thText21="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.Invoice.CaseNo")+"</td>";
		String thText3="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.Invoice.Matter")+"</td>";
		String thText4="<td align='center' width='13%'>"+this.getUserInfo().getMsg("jsp.Invoice.Title")+"</td>";
		String thText5="<td align='center' width='13%'>"+this.getUserInfo().getMsg("jsp.Invoice.ClientName")+"</td>";
		String thText6="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.Invoice.InvoiceDate")+"</td>";
		String thText7="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.Invoice.TotalRequestPayNtdAmount")+"</td>";
		String thText8="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.Invoice.ArDate")+"</td>";
		String thText9="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.Invoice.TotalWriteOffAmount")+"</td>";
		String thText10="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.ReceiptManage.ReceiveDate")+"</td>";
		String thText13=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText13 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText21+thText3+thText4+thText5+thText6+
				thText7+thText8+thText9+thText10+thText13+"</tr>");
		int i=0;
		String SQL = "select FlowKey from invoice where CaseNo = '" + this.getCaseNo() + "' and Matter ='" + this.getMatter() + "' order by invoiceno";
		List<String> keys = this.getDbUtil().getValueList(SQL, "FlowKey");
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		double TotalRequestPayNtdAmount = 0;
		double TotalWriteOffAmount = 0;
		for(String key : keys){
			Invoice invoice = new Invoice(key);
			
			TotalRequestPayNtdAmount += Util.stringToDouble(invoice.getTotalRequestPayNtdAmount());
			TotalWriteOffAmount += Util.stringToDouble(invoice.getTotalWriteOffAmount());
			
			String[] fields = {"ReceiveDate"};
			String sql = "select distinct rm.receiveDate as ReceiveDate , rm.FlowKey as FlowKey from receiptmanage rm left join arwriteofflog ar on rm.flowkey = ar.receiptId left join Invoice i on i.flowKey = ar.invoiceId where i.FlowKey = '"+key+"' order by rm.receiveDate asc";
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
			
			String onClick = "";
			
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+invoice.getInvoiceNo()+"</td>";
			String tdText21="<td>"+invoice.getCaseNo()+"</td>";
			String tdText3="<td align='center'>"+matterPrpt.getProperty(invoice.getMatter())+"</td>";
			String tdText4="<td>"+invoice.getTitle()+"</td>";
			String tdText5="<td>"+invoice.getClientName()+"</td>";
			String tdText6="<td>"+invoice.getInvoiceDate()+"</td>";
			String tdText7="<td align='center'>"+invoice.getTotalRequestPayNtdAmount()+"</td>";
			String tdText8="<td>"+invoice.getArDate()+"</td>";
			String tdText9="<td align='center'>"+invoice.getTotalWriteOffAmount()+"</td>";
			String tdText10="<td>"+receiveDateList+"</td>";
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

		String result = "已請款金額為 %s 元      已入帳金額為 %s 元";
		
		return String.format(result, Util.round(TotalRequestPayNtdAmount, 0), 
				Util.round(TotalWriteOffAmount, 0)) + strBfr.toString();
    }
    
    public String printReleatedInvoiceInfo() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	
//    	rtnString += printReleatedTodosReasult();
//    	rtnString += "<br/><br/>";
    	rtnString += printReleatedInvoiceReasult();
    	
    	return rtnString;
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
		
    	this.CaseNo.setListWidth("7%");
    	
    	this.Title.setListWidth("10%");
    	
    	this.PayToPartyName.setListWidth("10%");
    	
    	this.PaymentDate.setListWidth("7%");
    	
    	this.ReceiptDate.setListWidth("7%");
    	
    	this.OriginalCurrency.setListWidth("7%");
    	this.OriginalCurrency.setMapingPrpt(categoryPrpt);
    	this.OriginalCurrency.setNotShowCode(true);
    	
    	this.OriginalCurrencyAmount.setListWidth("7%");
//    	this.ApDate.setListWidth("7%");
    	
    	this.Currency.setListWidth("8%");
        this.Currency.setMapingPrpt(categoryPrpt);
        this.Currency.setNotShowCode(true);
    	
    	this.Amount.setListWidth("8%");
    	
    	this.ExchangeRate.setListWidth("7%");
    	
    	this.TotalWriteOffAmount.setListWidth("8%");
    	
    	this.Office.setListWidth("7%");
        this.Office.setMapingPrpt(categoryPrpt);
        this.Office.setNotShowCode(true);
    	
    	this.Matter.setListWidth("8%");
        this.Matter.setMapingPrpt(patentMatterConfigPrpt);
        this.Matter.setNotShowCode(true);
        
        this.PaymentNo.setListWidth("8%");
        
        this.InvoiceNo.setListWidth("8%");
        
        this.TotalPaymentNtdAmount.setListWidth("8%");
    	
        Field[] showField = {this.InvoiceNo, this.PaymentDate, this.PayToPartyName, this.CaseNo,
        		this.OriginalCurrency, this.OriginalCurrencyAmount,
        		this.TotalPaymentNtdAmount, this.TotalWriteOffAmount};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
    	String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.CaseNo);
        whereStr = Util.addWhereSQL(whereStr, this.SubType);
        whereStr = Util.addWhereSQL(whereStr, this.Office);
        whereStr = Util.addWhereSQL(whereStr, this.Title);
        whereStr = Util.addWhereSQL(whereStr, this.Matter);
        whereStr = Util.addWhereSQL(whereStr, this.InCharge);
        whereStr = Util.addWhereSQL(whereStr, this.ApplyNo);
        whereStr = Util.addWhereSQL(whereStr, this.InvoiceNo);
        whereStr = Util.addWhereSQL(whereStr, this.PaymentNo);
        whereStr = Util.addWhereSQL(whereStr, this.PayToParty);
        whereStr = Util.addWhereSQL(whereStr, this.PayToPartyName);
        whereStr = Util.addWhereSQL(whereStr, this.FlowKey);
        whereStr = Util.addBetweenSQL(whereStr, PaymentDate, PaymentDateTo);
        whereStr = Util.addBetweenSQL(whereStr, ApDate, ApDateTo);
        whereStr = Util.addBetweenSQL(whereStr, ReceiptDate, ReceiptDateTo);
        
        /*
         * 當勾選此“尚未沖銷之付款單”欄位時，可以搜尋各筆付款單中的付款明細(PaymentDetail)Table中
         * 搜尋邏輯應為：已沖銷總額-TotalWriteOffAmount<原幣總金額-OriginalCurrencyAmount的付款單
         */
        if(Util.compareTo(this.getNotYetWriteOff(), "Y")) {
//        	String sql = "select ParentId from PaymentDetail where NotYetWriteOff > 0";
        	String sql = "select flowkey from payment where TotalWriteOffAmount < OriginalCurrencyAmount"; 
        	String where = this.getDbUtil().getInCondSql(sql, "flowkey");
        	
        	if(Util.isEmpty(where)) {
        		where = "''";
        	}

        	if(whereStr.indexOf("where") != -1) {
       			whereStr += " and flowkey in (" + where + ")";
       		}
       		else {
       			whereStr = " where flowkey in (" + where + ")";
       		}
        }
        whereStr = this.getDataAuthorityWhereSQL(whereStr);
        String SQL = "select * from Payment " + whereStr;
//        System.out.println(SQL);
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
    
    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            Payment preObj = (Payment) userInfo.getObj(this.getTableName());
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
    	//“已沖銷總額(TotalWriteOffAmount)”為此筆付款單中的所有
        //“付款明細(PaymentDetail)”的“已沖銷金額(AlreadyWriteOffAmount)”總和
//    	String sql = "select sum(AlreadyWriteOffAmount) as count from PaymentDetail where ParentId ='" + 
//    				this.getFlowKey() + "'";
//        String TotalWriteOffAmount = Util.stringToInt(this.getDbUtil().getFieldValue(sql, "count")) + "";
//        this.setTotalWriteOffAmount(TotalWriteOffAmount);
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
        	//檢查該筆請付款單是否已存在已沖銷資料，若是，則出現警示框顯示內容"該請付款單已進行沖銷，請先回沖後才能刪除資料！"，若否，才可放行刪除資料
        	String sql = "select count(1) as count from apwriteofflog where PaymentId = '" + this.getFlowKey() + "' and PaymentDetailType='D'  and (Reversal != 'Y' or Reversal is null)";
        	int count = this.getDbUtil().getSqlIntValue(sql, "count");
        	if(count > 0) {
        		this.setErrorMessage(this.getUserInfo().getMsg("jsp.Payment.DeleteErrorWithWriteOff"));
        		return true;
        	}
        	
            return false;
        }
    }

    public boolean getCanEditField(Field field) {

//    	if(this.getPageActionMode().equals(Cnstnts.MAINTAIN)) {
//    		if(field.getName().equals(this.TotalTax.getName()) ||
//    				field.getName().equals(this.TotalTax2.getName()) ||
//    				field.getName().equals(this.TotalRequestPayNtdAmount.getName()) ||
//    				field.getName().equals(this.TotalWriteOffAmount.getName()) ||
//    				field.getName().equals(this.TotalDiscountAmount.getName()) ||
//    				//field.getName().equals(this.CaseNo.getName()) ||
//    				field.getName().equals(this.Office.getName()) ||
//    				field.getName().equals(this.SubType.getName()) ||
//    				field.getName().equals(this.Matter.getName()) ||
//    				field.getName().equals(this.ServiceFee.getName()) ||
//    				field.getName().equals(this.GovFee.getName()) ||
//    				field.getName().equals(this.Title.getName()) ||
//    				field.getName().equals(this.OtherFeeNtd.getName()) ||
//    				field.getName().equals(this.OtherFee.getName()) ||
//    				field.getName().equals(this.OtherCurrency.getName()) ||
//    				field.getName().equals(this.AttorneyFeeNtd.getName()) ||
//    				field.getName().equals(this.AttorneyFee.getName()) ||
//    				field.getName().equals(this.OriginalCurrency.getName()) ||
//    				field.getName().equals(this.OriginalCurrencyAmount.getName()) ||
//    				field.getName().equals(this.AttorneyCurrency.getName())) {
//    			return false;
//    		}
//    	}
//    	if(field.getName().equals(this.Currency.getName()) ||
//    			field.getName().equals(this.Amount.getName())) {
//    		return false;
//    	}
//    	
//    	if(field.getName().equals(this.TotalDiscountAmount.getName()) ||
//    			field.getName().equals(this.TotalPaymentNtdAmount.getName()) ||
//    			field.getName().equals(this.TotalWriteOffAmount.getName())) {
//    		return false;
//    	}
    	 if(//field.getName().equals(this.CaseNo.getName()) ||
        			field.getName().equals(this.CaseType.getName()) ||
        			field.getName().equals(this.SubType.getName()) ||
        			field.getName().equals(this.TotalWriteOffAmount.getName()) ||
        			field.getName().equals(this.PayToPartyName.getName()) ||
        			field.getName().equals(this.Office.getName()) ||
        			//field.getName().equals(this.Matter.getName()) ||
        			field.getName().equals(this.Title.getName())
        			) {
    		if (this.onSearchMode()) {
        		return true;
        	}
    		else {
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
		
		this.PaymentDateTo.setValue(Cnstnts.EMPTY_STRING);
		this.ApDateTo.setValue(Cnstnts.EMPTY_STRING);
		
	}

    public void doAction(UserBean userInfo) throws Exception {
    	this.setUserInfo(userInfo);
    	if(Util.compareTo(this.getDoWriteOffFlag(), "true")) {
    		doReDoWriteOffProcess_payment();
    	}

    	if(Util.compareTo(this.getDoPayment(), "true")) {
   			doPaymentProcess();
    	}

    	super.doAction(userInfo);
    }
    

    
    public void doReDoWriteOffProcess_payment() throws Exception {
    	/*
此“帳款沖回”按鈕功能為將以沖銷之帳款沖回去，因此當執行此功能按鈕後會同時直接影響的資料部分有兩個部分，
一個是PaymentDetail Table內的AlreadyWriteOffAmount欄位資料，另一個是PaytManage Table內的AlreadyWriteOffAmount欄位資料。
而當這兩個欄位資料變更時則會影響其他欄位資料必須重新計算。

此沖回按鈕僅有在編輯模式會出現，且此處的按鈕若是已經執行過沖銷則會於此比沖銷紀錄Reversal欄位中紀錄Y，
而執行過沖回的紀錄之後顯示的帳款沖銷按鈕則為disable。且當執行帳款沖回後會將操作此沖回功能的使用者的員工代碼記錄到DoReversal欄位中。
    	 */
    	List<String> sqls = new ArrayList<String>();
    	if(!Util.isEmpty(this.getApWriteOffLogKey())) {
    		ApWriteoffLog log = new ApWriteoffLog(this.getApWriteOffLogKey());
    		log.setDbFields();
    		log.setDoReversal(this.getUserInfo().getAttribute("emp_id"));
    		log.setReversal("Y");
    		
    		Payment payment = new Payment(log.getPaymentId());
    		payment.setDbFields();
    		
    		double AlreadyWriteOffAmount = Util.stringToDouble(payment.getTotalWriteOffAmount());
    		AlreadyWriteOffAmount -= Util.stringToDouble(log.getWriteOffAmount());
    		payment.setTotalWriteOffAmount(Util.round(AlreadyWriteOffAmount, 3) + "");
    		this.setTotalWriteOffAmount(Util.round(AlreadyWriteOffAmount, 3) + "");
    		
    		PayManage manage = new PayManage(log.getPayId());
    		manage.setDbFields();
    		/*
6.當PayManage Table中的AlreadyWriteOffAmount或PayNtdAmount或ExchangeGain或ExchangeLoss欄位資料有變動時
則重新計算WriteOffBalance欄位資料﹝等於WriteOffBalance=PayNtdAmount-ExchangeGain-ExchangeLoss-AlreadyWriteOffAmount﹞。
    		 */
    		double WriteOffBalance = Util.stringToDouble(manage.getWriteOffBalance());
    		WriteOffBalance += Util.stringToDouble(log.getWriteOffAmount());
    		manage.setWriteOffBalance(Util.round(WriteOffBalance, 3) + "");
    		
    		sqls.add(this.getDbUtil().getUpdateSQL(log.getTableName(), log.getDbFields()));
    		sqls.add(this.getDbUtil().getUpdateSQL(payment.getTableName(), payment.getDbFields()));
    		sqls.add(this.getDbUtil().getUpdateSQL(manage.getTableName(), manage.getDbFields()));

    		if(this.getDbUtil().executeUpdate(sqls)) {
    			/*
        		當沖回時PaytManage Table內的AlreadyWriteOffAmount欄位資料需減去arwriteofflog Table內的WriteOffAmount欄位資料
        		*/
    			String sql = "select AlreadyWriteOffAmount from PayManage where flowkey='" + manage.getFlowKey() + "'";
        		AlreadyWriteOffAmount = this.getDbUtil().getSqlDoubleValue(sql, "AlreadyWriteOffAmount");
        		AlreadyWriteOffAmount -= Util.stringToDouble(log.getWriteOffAmount());
        		this.getDbUtil().executeUpdate("update PayManage set AlreadyWriteOffAmount=" + Util.round(AlreadyWriteOffAmount, 3) + 
        				" where flowkey='" + manage.getFlowKey() + "'");
        		
    			this.setMessage(this.getUserInfo().getMsg("jsp.ArWriteoffLog.WriteOffFinish"));
    		}
    	}    	
    }
    
    public void doReDoWriteOffProcess() throws Exception {
    	/*
此“帳款沖回”按鈕功能為將以沖銷之帳款沖回去，因此當執行此功能按鈕後會同時直接影響的資料部分有兩個部分，
一個是PaymentDetail Table內的AlreadyWriteOffAmount欄位資料，另一個是PaytManage Table內的AlreadyWriteOffAmount欄位資料。
而當這兩個欄位資料變更時則會影響其他欄位資料必須重新計算。

此沖回按鈕僅有在編輯模式會出現，且此處的按鈕若是已經執行過沖銷則會於此比沖銷紀錄Reversal欄位中紀錄Y，
而執行過沖回的紀錄之後顯示的帳款沖銷按鈕則為disable。且當執行帳款沖回後會將操作此沖回功能的使用者的員工代碼記錄到DoReversal欄位中。
    	 */
    	List<String> sqls = new ArrayList<String>();
    	if(!Util.isEmpty(this.getApWriteOffLogKey())) {
    		ApWriteoffLog log = new ApWriteoffLog(this.getApWriteOffLogKey());
    		log.setDbFields();
    		log.setDoReversal(this.getUserInfo().getAttribute("emp_id"));
    		log.setReversal("Y");
    		
    		PaymentDetail detail = new PaymentDetail(log.getParentId());
    		detail.setDbFields();
    		
    		//當沖回時PaymentDetail Table內的AlreadyWriteOffAmount欄位資料需減去apwriteofflog Table內的WriteOffAmount欄位資料
    		double AlreadyWriteOffAmount = Util.stringToDouble(detail.getAlreadyWriteOffAmount());
    		AlreadyWriteOffAmount -= Util.stringToDouble(log.getWriteOffAmount());
    		detail.setAlreadyWriteOffAmount(Util.round(AlreadyWriteOffAmount, 3) + "");
    		
    		//C.當PaymentDetail Table中的AlreadyWriteOffAmount欄位變動時(第5項執行完)則須同時執行1.3、3
    		/*
1.3當PaymentDetail Table中的PaymentAmount或AlreadyWriteOffAmount或DiscountAmount欄位資料有變動時則
重新計算PaymentDetail Table中的NotYetWriteOff欄位﹝NotYetWriteOff=PaymentAmount-AlreadyWriteOffAmount-DiscountAmount﹞
    		 */
    		double NotYetWriteOff = Util.stringToDouble(detail.getNotYetWriteOff());
    		NotYetWriteOff += Util.stringToDouble(log.getWriteOffAmount());
    		detail.setNotYetWriteOff(Util.round(NotYetWriteOff, 3) + "");
    		
    		
    		Payment payment = new Payment(log.getPaymentId());
    		payment.setDbFields();
    		/*
3.當PaymentDetail Table中的AlreadyWriteOffAmount欄位變動時則重新計算Payment Table的TotalWriteOffAmount欄位資料
﹝TotalWriteOffAmount=為此筆Payment中所有PaymentDetail的AlreadyWriteOffAmount總和﹞
    		*/
    		double TotalWriteOffAmount = Util.stringToDouble(payment.getTotalWriteOffAmount());
    		TotalWriteOffAmount -= Util.stringToDouble(log.getWriteOffAmount());
    		payment.setTotalWriteOffAmount(Util.round(TotalWriteOffAmount, 3) + "");
    		
    		
    		PayManage manage = new PayManage(log.getPayId());
    		manage.setDbFields();
    		/*
6.當PayManage Table中的AlreadyWriteOffAmount或PayNtdAmount或ExchangeGain或ExchangeLoss欄位資料有變動時
則重新計算WriteOffBalance欄位資料﹝等於WriteOffBalance=PayNtdAmount-ExchangeGain-ExchangeLoss-AlreadyWriteOffAmount﹞。
    		 */
    		double WriteOffBalance = Util.stringToDouble(manage.getWriteOffBalance());
    		WriteOffBalance += Util.stringToDouble(log.getWriteOffAmount());
    		manage.setWriteOffBalance(Util.round(WriteOffBalance, 3) + "");
    		
    		sqls.add(this.getDbUtil().getUpdateSQL(log.getTableName(), log.getDbFields()));
    		sqls.add(this.getDbUtil().getUpdateSQL(detail.getTableName(), detail.getDbFields()));
    		sqls.add(this.getDbUtil().getUpdateSQL(payment.getTableName(), payment.getDbFields()));
    		sqls.add(this.getDbUtil().getUpdateSQL(manage.getTableName(), manage.getDbFields()));

    		if(this.getDbUtil().executeUpdate(sqls)) {
    			/*
        		當沖回時PaytManage Table內的AlreadyWriteOffAmount欄位資料需減去arwriteofflog Table內的WriteOffAmount欄位資料
        		*/
    			String sql = "select AlreadyWriteOffAmount from PayManage where flowkey='" + manage.getFlowKey() + "'";
        		AlreadyWriteOffAmount = this.getDbUtil().getSqlDoubleValue(sql, "AlreadyWriteOffAmount");
        		AlreadyWriteOffAmount -= Util.stringToDouble(log.getWriteOffAmount());
        		this.getDbUtil().executeUpdate("update PayManage set AlreadyWriteOffAmount=" + Util.round(AlreadyWriteOffAmount, 3) + 
        				" where flowkey='" + manage.getFlowKey() + "'");
        		
    			this.setMessage(this.getUserInfo().getMsg("jsp.ArWriteoffLog.WriteOffFinish"));
    		}
    	}    	
    }
    

    public boolean delete() throws Exception {
		super.delete();
		
		String sql2 = "delete from paymentdetail where parentid ='" + this.getFlowKey() + "'";
		
		/*
		 * 且若符合刪除之條件，則需根據每筆付款明細中的RequestPay資料
		 * 重新計算該付款明細所屬的Todos內的RequestPayAmount及NotYetRequestPayAmount欄位。
		 */
		/*
    	 * 若符合刪除條件且將此筆付款明細刪除，
    	 * 刪除時需重新計算此筆PaymentDetail的所屬的ToDos的RequestPayAmount及NotYetRequestPayAmount欄位，
    	 * 重新計算方式為將Todos的PayAmount值減掉PaymentDetail的PaymentAmount值存回Todos的PayAmount，
         * 以及將Todos的NotYetPayAmount值加上PaymentsDetail的PaymentAmount值存回Todos的NotYetPayAmount。
    	 */
		String sql = "select flowkey from paymentdetail where parentid ='" + this.getFlowKey() + "'";
		List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
		for(String key : keys) {
			PaymentDetail detail = new PaymentDetail(key);
			ToDos todo = new ToDos(detail.getTodosId());
            
        	String request = Util.round((Util.stringToDouble(todo.getPayAmount()) -
        			Util.stringToDouble(detail.getPaymentAmount())), 0) + "";
        	
        	String notyet = Util.round((Util.stringToDouble(todo.getNotYetPayAmount()) +
        			Util.stringToDouble(detail.getPaymentAmount())), 0) + "";
        	
            sql = "update todos set NotYetPayAmount = " + notyet + "," +
            			"PayAmount = " + request + 
            			" where flowkey='" + detail.getTodosId() + "'";

            this.getDbUtil().executeUpdate(sql);
		}
		
		return this.getDbUtil().executeUpdate(sql2);
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
//		strBfr.append(newLine + "  <tr" + this.getThBgcolor()
//				+ " style='cursor: hand' " + "title='"
//				+ this.getUserInfo().getMsg("jsp.common.reOrder") + "'>");
		strBfr.append(newLine + "  <tr" + this.getThBgcolor() + "'>");
		for (int i = 0; i < this.getShowField().length; i++) {
			if(i == 0) {
				strBfr.append(newLine + "    <td align='center' width='3%'>付款</td>");
			}
			String fieldName = this.getShowField()[i].getName();
//			strBfr.append(newLine + "    <td align='center' onClick='setOrderKey(\""
//					+ fieldName + "\")'" + ">");
			strBfr.append(newLine + "    <td align='center'>");
			strBfr.append(newLine
					+ "      "
					+ this.getUserInfo().getMsg(
							this.getProgramId() + "." + fieldName));
//			if (this.getOrderKey().equals(fieldName)) {
//				String imgSrc = "img/up_pointer.png";
//				if (this.getOrderSequence().equals(Cnstnts.DESC))
//					imgSrc = "img/down_pointer.png";
//				strBfr.append(" <img src='" + imgSrc + "'>");
//			}
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
				
				String onClick = "";
				if(openBlankDetail) {
					strBfr.append(newLine + "  <tr" + trBgcolor
							+ " style='cursor: hand' " + "title='"
							+ this.getUserInfo().getMsg("jsp.common.viewDetail")
							+ "' "
							+ ">");
					
					onClick = "onClick='openAppendix(\"" + this.getProgramId().replaceFirst("jsp.", "") + ".jsp?_flowKey="+data[0].toString()+
							"&_dbActionMode=update&_getDataFlag=true&_pageActionMode=maintain&_currentRecord="+(i + 1)+
							"\",\"" + this.getProgramId().replaceFirst("jsp.", "") + "\",1000,550)'";
				}
				else {
					strBfr.append(newLine + "  <tr" + trBgcolor
							+ " style='cursor: hand' " + "title='"
							+ this.getUserInfo().getMsg("jsp.common.viewDetail")
							+ "' "
							+ ">");
					
					onClick = "onClick='document.input.currentRecord.value=\""
							+ (i + 1) + "\";document.input.dbActionMode.value=\"update\";"
							+"gotoData(\"" + data[0].toString()
							+ "\")'";
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
						
						if(j-1 == 0) {
							
							String disabled1 = "";
							
							Payment Payment = new Payment(data[0]+"");
							if(Util.stringToDouble(Payment.getOriginalCurrencyAmount()) - 
									Util.stringToDouble(Payment.getTotalWriteOffAmount()) <= 0) {
								disabled1 = " disabled ";
							}
							
							strBfr.append(newLine + "    <td>"
								+ "<input type='CheckBox' id='markKey' name='markKey' value='"+data[0]+"' " + disabled1 + "/>"
								+ "</td>");

							strBfr.append(newLine + "    <td " + onClick
									+ this.getShowField()[j - 1].printListWidth()
									+ this.getShowField()[j - 1].printAlign() + ">"
									+ showData + "</td>");
						}
						else {
							strBfr.append(newLine + "    <td " + onClick
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
		strBfr.append(newLine + "  <tr><td align='left' colspan='"
				+ (this.getShowField().length + 2) + "'>");
	strBfr.append(newLine + "<input type='button' value='" + this.getUserInfo().getMsg("jsp.Payment.PaymentBtn") + "' " +
			" onclick='document.input.doPayment.value=\"true\";setValue();'>");
	strBfr.append(newLine + "(" + this.getUserInfo().getMsg("jsp.Payment.PayCheckError") + ")");
	strBfr.append(newLine + "  </td></tr>");
	strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
    
    public void doPaymentProcess() throws Exception {
    	double OriginalCurrencyAmount = 0.0;
    	String todoKey = "";
    	List<String> paymentKeys = new ArrayList<String>();
    	if(this.getMarkKeys() != null && this.getMarkKeys().length > 0) {
    		String PayToParty = "";
    		String currency = "";
    		int index = 0;
    		for(String key : this.getMarkKeys()) {
    			Payment pay = new Payment(key);
    			if(Util.isEmpty(pay.getOriginalCurrency())) {
    				this.setErrorMessage(String.format(this.getUserInfo().getMsg("jsp.Payment.PaymentCurrencyEmptyError"), pay.getFlowKey()));
					return;
    			}
    			if(index == 0) {
    				PayToParty = pay.getPayToParty();
    				currency = pay.getOriginalCurrency();
    			}
    			else {
    				if(!PayToParty.equals(pay.getPayToParty()) ||
    						!currency.equals(pay.getOriginalCurrency())) {
    					this.setErrorMessage(this.getUserInfo().getMsg("jsp.Payment.PayCheckError"));
    					return;
    				}
    			}
    			
    			OriginalCurrencyAmount += Util.stringToDouble(pay.getOriginalCurrencyAmount());
    			index ++;
    			
    			paymentKeys.add(key);
    		}
    		
    		Payment pay = new Payment(this.getMarkKeys()[0]);
    		
    		List<String> sqls = new ArrayList<String>();

    		PayManage payManage = new PayManage();
    		payManage.setDbFields();
    		payManage.setFlowKey(FlowEngin.getFlowKey(payManage.getProgramId()));
    		payManage.setApplicant(this.getUserInfo().getAttribute("emp_id"));
    		payManage.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
    		payManage.setPayToParty(pay.getPayToParty());
    		payManage.setPayToPartyName(pay.getPayToPartyName());
    		payManage.setPayAmount(OriginalCurrencyAmount+"");
    		payManage.setExchangeRate(new Category(pay.getOriginalCurrency()).getRate());
    		payManage.setPayNtdAmount( ((int)(Util.stringToDouble(payManage.getPayAmount())*
    				Util.stringToDouble(payManage.getExchangeRate()))) + "");
    		payManage.setCurrency(pay.getOriginalCurrency());
    		payManage.setReceiveDate(Util.getDate());
    		
    		sqls.add(this.getDbUtil().getInsertSQL(payManage.getTableName(), payManage.getDbFields()));
        	
    		this.getRequest().getSession().setAttribute("paymentKeys", paymentKeys);
    		
        	if(this.getDbUtil().executeUpdate(sqls)) {
        		this.setForwardPage("PayManage.jsp?_flowKey=" + payManage.getFlowKey() + 
						"&_getDataFlag=true&_pageActionMode=maintain&_dbActionMode=update");
        	}
		}
    }
    
    public void setResultFields() {
    	this.ResultFields = new LinkedHashMap<String, Field>();
    	
    	Properties attorneyPrpt = null;
   	 	try {
			attorneyPrpt = new Attorney().getNamesPrpts();
		} catch (Exception e) {
			e.printStackTrace();
		}

    	this.ResultFields.put(this.PaymentNo.getName(), this.PaymentNo);
    	this.ResultFields.put(this.InvoiceNo.getName(), this.InvoiceNo);
    	this.ResultFields.put(this.PaymentDate.getName(), this.PaymentDate);
        this.ResultFields.put(this.PayToPartyName.getName(), this.PayToPartyName);
        this.ResultFields.put(this.CaseNo.getName(), this.CaseNo);
        this.ResultFields.put(this.Title.getName(), this.Title);
        this.ResultFields.put(this.Matter.getName(), this.Matter);
        try{
        	this.Matter.setMapingPrpt(new PatentMatterConfig().getNamesPrpts());
        	this.Matter.setNotShowCode(true);
        }catch(Exception e){}
        this.ResultFields.put(this.ReceiptDate.getName(), this.ReceiptDate);
    	this.ResultFields.put(this.OriginalCurrency.getName(), this.OriginalCurrency);
        try{
        	this.OriginalCurrency.setMapingPrpt(new Category().getNamesPrpts());
        	this.OriginalCurrency.setNotShowCode(true);
        }catch(Exception e){}
    	this.ResultFields.put(this.OriginalCurrencyAmount.getName(), this.OriginalCurrencyAmount);
        this.ResultFields.put(this.TotalPaymentNtdAmount.getName(), this.TotalPaymentNtdAmount);
        this.ResultFields.put(this.TotalWriteOffAmount.getName(), this.TotalWriteOffAmount);
    	
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
    	String outputFile = "Payemnt/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".doc";
    	String outputDoc = "file:///"+Util.getDocPath()+outputFile;
    	
    	if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		
    		String SQL = "select p.* from payment p where p.FlowKey='"+this.getFlowKey()+"'";
    		HashMap<String, String> fieldMap = this.getAttributesMap();
    		Map data = this.getDocMap(SQL,fieldMap);
    		
    		char newLine = Cnstnts.NEW_LINE;
    		String detailData = Cnstnts.EMPTY_STRING;
    		
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

    			if(name.endsWith("Date") || name.endsWith("DateTo") ||
    					name.equalsIgnoreCase("DeadLine")) {
    				//將日期轉換成年月日
    				data = Util.putDateToMap(name, value, data);
    			}
//    			else if(name.equalsIgnoreCase("PatentOffice") ||
//    					name.equalsIgnoreCase("Status") ||
//    					name.equalsIgnoreCase("PatentCaseType") ||
//    					name.equalsIgnoreCase("Entity") ||
//    					name.equalsIgnoreCase("GiveupCode")) {
//    				value = categoryProp.getProperty(value);
//    			}
//    			else if(name.equalsIgnoreCase("PatentType")) {
//    				value = Util.getPatentTypeNameByOffice(value, this.getPatentOffice());
//    			}
//    			else if(name.equalsIgnoreCase("WrittenMan") ||
//    					name.equalsIgnoreCase("MappingMan") ||
//    					name.equalsIgnoreCase("TranslateMan") ||
//    					name.equalsIgnoreCase("RejectionMan") ||
//    					name.equalsIgnoreCase("InCharge") ||
//    					name.equalsIgnoreCase("ReplyMan") ||
//    					name.equalsIgnoreCase("CaseAssignedTo") ||
//    					name.equalsIgnoreCase("CaseAD")) {
//    				value = employeeProp.getProperty(value);
//    			}
//    			else if(name.equalsIgnoreCase("Attorney")) {
//    				value = attorneyProp.getProperty(value);
//    			}
//    			else if(name.equalsIgnoreCase("ClientContect")) {
//    				value = applicantProp.getProperty(value);
//    			}
//    			else if(name.equalsIgnoreCase("Client")) {
//    				data.put("${ClientName}", new Client().getNamesPrpts().getProperty(value));
//    			}

    			data.put("${" + name+ "}", value);
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
}