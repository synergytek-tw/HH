package deepspot.main;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;




import com.athenasoft.ooutil.OoConverter;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.util.Config;
import deepspot.util.DB;
import deepspot.util.Util;



public class Client extends MasterBean {
	//private Pattern pattern = Pattern.compile("^([a-zA-Z]){2}$");
	//private Pattern pattern2 = Pattern.compile("^[a-zA-Z]{2}[0-9]{2}$");
	
    public Client(){this.init();}

    public Client(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }
	
	public String changeClientContact;


	public String getChangeClientContact() {
		return changeClientContact;
	}

	public void setChangeClientContact(String changeClientContact) {
		this.changeClientContact = changeClientContact;
	}
	
    public Field Summary;
    public void setSummary(String Summary){this.Summary.setValue(Summary);}
    public String getSummary(){return this.Summary.getValue();}
    
    public Field Datalack;
    public void setDatalack(String Datalack){this.Datalack.setValue(Datalack);}
    public String getDatalack(){return this.Datalack.getValue();}

    public Field ClientContect;
    public void setClientContect(String ClientContect){this.ClientContect.setValue(ClientContect);}
    public String getClientContect(){return this.ClientContect.getValue();}

    public Field Nationality;
    public void setNationality(String Nationality){this.Nationality.setValue(Nationality);}
    public String getNationality(){return this.Nationality.getValue();}

    public Field Entity;
    public void setEntity(String Entity){this.Entity.setValue(Entity);}
    public String getEntity(){return this.Entity.getValue();}

    public Field CompanyName;
    public void setCompanyName(String CompanyName){this.CompanyName.setValue(CompanyName);}
    public String getCompanyName(){return this.CompanyName.getValue();}

    public Field EnglishCompanyName;
    public void setEnglishCompanyName(String EnglishCompanyName){this.EnglishCompanyName.setValue(EnglishCompanyName);}
    public String getEnglishCompanyName(){return this.EnglishCompanyName.getValue();}

    public Field RegisteredNo;
    public void setRegisteredNo(String RegisteredNo){this.RegisteredNo.setValue(RegisteredNo);}
    public String getRegisteredNo(){return this.RegisteredNo.getValue();}

    public Field InCharge;
    public void setInCharge(String InCharge){this.InCharge.setValue(InCharge);}
    public String getInCharge(){return this.InCharge.getValue();}

    public Field Contact;
    public void setContact(String Contact){this.Contact.setValue(Contact);}
    public String getContact(){return this.Contact.getValue();}
    
    public Field Contact2;
    public void setContact2(String Contact2){this.Contact2.setValue(Contact2);}
    public String getContact2(){return this.Contact2.getValue();}

    public Field Tel1;
    public void setTel1(String Tel1){this.Tel1.setValue(Tel1);}
    public String getTel1(){return this.Tel1.getValue();}

    public Field Tel2;
    public void setTel2(String Tel2){this.Tel2.setValue(Tel2);}
    public String getTel2(){return this.Tel2.getValue();}

    public Field Mobile;
    public void setMobile(String Mobile){this.Mobile.setValue(Mobile);}
    public String getMobile(){return this.Mobile.getValue();}

    public Field Fax1;
    public void setFax1(String Fax1){this.Fax1.setValue(Fax1);}
    public String getFax1(){return this.Fax1.getValue();}

    public Field Fax2;
    public void setFax2(String Fax2){this.Fax2.setValue(Fax2);}
    public String getFax2(){return this.Fax2.getValue();}

    public Field Email;
    public void setEmail(String Email){this.Email.setValue(Email);}
    public String getEmail(){return this.Email.getValue();}

    public Field WebSite;
    public void setWebSite(String WebSite){this.WebSite.setValue(WebSite);}
    public String getWebSite(){return this.WebSite.getValue();}

    public Field Msn;
    public void setMsn(String Msn){this.Msn.setValue(Msn);}
    public String getMsn(){return this.Msn.getValue();}

    public Field Skype;
    public void setSkype(String Skype){this.Skype.setValue(Skype);}
    public String getSkype(){return this.Skype.getValue();}

    public Field Zip1;
    public void setZip1(String Zip1){this.Zip1.setValue(Zip1);}
    public String getZip1(){return this.Zip1.getValue();}

    public Field Zip2;
    public void setZip2(String Zip2){this.Zip2.setValue(Zip2);}
    public String getZip2(){return this.Zip2.getValue();}

    public Field Address1;
    public void setAddress1(String Address1){this.Address1.setValue(Address1);}
    public String getAddress1(){return this.Address1.getValue();}

    public Field EnglishAddress1;
    public void setEnglishAddress1(String EnglishAddress1){this.EnglishAddress1.setValue(EnglishAddress1);}
    public String getEnglishAddress1(){return this.EnglishAddress1.getValue();}

    public Field Address2;
    public void setAddress2(String Address2){this.Address2.setValue(Address2);}
    public String getAddress2(){return this.Address2.getValue();}

    public Field EnglishAddress2;
    public void setEnglishAddress2(String EnglishAddress2){this.EnglishAddress2.setValue(EnglishAddress2);}
    public String getEnglishAddress2(){return this.EnglishAddress2.getValue();}

    public Field OwnershipType;
    public void setOwnershipType(String OwnershipType){this.OwnershipType.setValue(OwnershipType);}
    public String getOwnershipType(){return this.OwnershipType.getValue();}

    public Field Category;
    public void setCategory(String Category){this.Category.setValue(Category);}
    public String getCategory(){return this.Category.getValue();}

    public Field Industry;
    public void setIndustry(String Industry){this.Industry.setValue(Industry);}
    public String getIndustry(){return this.Industry.getValue();}

    public Field StockId;
    public void setStockId(String StockId){this.StockId.setValue(StockId);}
    public String getStockId(){return this.StockId.getValue();}

    public Field Credit;
    public void setCredit(String Credit){this.Credit.setValue(Credit);}
    public String getCredit(){return this.Credit.getValue();}

    public Field Revenue;
    public void setRevenue(String Revenue){this.Revenue.setValue(Revenue);}
    public String getRevenue(){return this.Revenue.getValue();}

    public Field Currency;
    public void setCurrency(String Currency){this.Currency.setValue(Currency);}
    public String getCurrency(){return this.Currency.getValue();}

    public Field InvoiceTitle;
    public void setInvoiceTitle(String InvoiceTitle){this.InvoiceTitle.setValue(InvoiceTitle);}
    public String getInvoiceTitle(){return this.InvoiceTitle.getValue();}

    public Field Memo;
    public void setMemo(String Memo){this.Memo.setValue(Memo);}
    public String getMemo(){return this.Memo.getValue();}

    public Field Appendix;
    public void setAppendix(String Appendix){this.Appendix.setValue(Appendix);}
    public String getAppendix(){return this.Appendix.getValue();}
    
    public Field FirstCaseDate;
    public void setFirstCaseDate(String FirstCaseDate){this.FirstCaseDate.setValue(FirstCaseDate);}
    public String getFirstCaseDate(){return this.FirstCaseDate.getValue();}
    
    public Field TotalCase;
    public void setTotalCase(String TotalCase){this.TotalCase.setValue(TotalCase);}
    public String getTotalCase(){return this.TotalCase.getValue();}
    
    public Field Sponsor;
    public void setSponsor(String Sponsor){this.Sponsor.setValue(Sponsor);}
    public String getSponsor(){return this.Sponsor.getValue();}
    
    public Field Payment;
    public void setPayment(String Payment){this.Payment.setValue(Payment);}
    public String getPayment(){return this.Payment.getValue();}
    
    public Field AlertDay;
    public void setAlertDay(String AlertDay){this.AlertDay.setValue(AlertDay);}
    public String getAlertDay(){return this.AlertDay.getValue();}
    
    public Field AddFlag;
    public void setAddFlag(String AddFlag){this.AddFlag.setValue(AddFlag);}
    public String getAddFlag(){return this.AddFlag.getValue();}
    
    public Field Email2;
    public void setEmail2(String Email2){this.Email2.setValue(Email2);}
    public String getEmail2(){return this.Email2.getValue();}
    
    public Field Email3;
    public void setEmail3(String Email3){this.Email3.setValue(Email3);}
    public String getEmail3(){return this.Email3.getValue();}
    
    public Field AccountingContact;
    public void setAccountingContact(String AccountingContact){this.AccountingContact.setValue(AccountingContact);}
    public String getAccountingContact(){return this.AccountingContact.getValue();}
    
    public Field Accounting;
    public void setAccounting(String Accounting){this.Accounting.setValue(Accounting);}
    public String getAccounting(){return this.Accounting.getValue();}
    
    public Field AccountingContactTel;
    public void setAccountingContactTel(String AccountingContactTel){this.AccountingContactTel.setValue(AccountingContactTel);}
    public String getAccountingContactTel(){return this.AccountingContactTel.getValue();}
    
    public Field AccountingContactFax;
    public void setAccountingContactFax(String AccountingContactFax){this.AccountingContactFax.setValue(AccountingContactFax);}
    public String getAccountingContactFax(){return this.AccountingContactFax.getValue();}
    
    public Field AccountingTel;
    public void setAccountingTel(String AccountingTel){this.AccountingTel.setValue(AccountingTel);}
    public String getAccountingTel(){return this.AccountingTel.getValue();}
    
    public Field AccountingFax;
    public void setAccountingFax(String AccountingFax){this.AccountingFax.setValue(AccountingFax);}
    public String getAccountingFax(){return this.AccountingFax.getValue();}
    
    public Field AccountingAddr;
    public void setAccountingAddr(String AccountingAddr){this.AccountingAddr.setValue(AccountingAddr);}
    public String getAccountingAddr(){return this.AccountingAddr.getValue();}
    
    public Field AlsoAddContact;
    public void setAlsoAddContact(String AlsoAddContact){this.AlsoAddContact.setValue(AlsoAddContact);}
    public String getAlsoAddContact(){return this.AlsoAddContact.getValue();}
    
    public Field LastName;
    public void setLastName(String LastName){this.LastName.setValue(LastName);}
    public String getLastName(){return this.LastName.getValue();}
    
    public Field FirstName;
    public void setFirstName(String FirstName){this.FirstName.setValue(FirstName);}
    public String getFirstName(){return this.FirstName.getValue();}
    
    public Field EnglishLastName;
    public void setEnglishLastName(String EnglishLastName){this.EnglishLastName.setValue(EnglishLastName);}
    public String getEnglishLastName(){return this.EnglishLastName.getValue();}
    
    public Field EnglishFirstName;
    public void setEnglishFirstName(String EnglishFirstName){this.EnglishFirstName.setValue(EnglishFirstName);}
    public String getEnglishFirstName(){return this.EnglishFirstName.getValue();}
    
    public Field Identity;
    public void setIdentity(String Identity){this.Identity.setValue(Identity);}
    public String getIdentity(){return this.Identity.getValue();}
    
    public Field GuanAccountDate;
    public void setGuanAccountDate(String GuanAccountDate){this.GuanAccountDate.setValue(GuanAccountDate);}
    public String getGuanAccountDate(){return this.GuanAccountDate.getValue();}
    
    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}
    
    public Field InvoiceTitle1;
    public void setInvoiceTitle1(String InvoiceTitle1){this.InvoiceTitle1.setValue(InvoiceTitle1);}
    public String getInvoiceTitle1(){return this.InvoiceTitle1.getValue();}
    
    public Field InvoiceTitle2;
    public void setInvoiceTitle2(String InvoiceTitle2){this.InvoiceTitle2.setValue(InvoiceTitle2);}
    public String getInvoiceTitle2(){return this.InvoiceTitle2.getValue();}
    
    public Field RegisteredNo2;
    public void setRegisteredNo2(String RegisteredNo2){this.RegisteredNo2.setValue(RegisteredNo2);}
    public String getRegisteredNo2(){return this.RegisteredNo2.getValue();}
    
    public Field AccountingEmail;
    public void setAccountingEmail(String AccountingEmail){this.AccountingEmail.setValue(AccountingEmail);}
    public String getAccountingEmail(){return this.AccountingEmail.getValue();}
    
    public Field FlowKey2;
    public void setFlowKey2(String FlowKey2){this.FlowKey2.setValue(FlowKey2);}
    public String getFlowKey2(){return this.FlowKey2.getValue();}

    public Field AddressSearch;
    public void setAddressSearch(String AddressSearch){this.AddressSearch.setValue(AddressSearch);}
    public String getAddressSearch(){return this.AddressSearch.getValue();}
    
    public Field ContactCompany;
    public void setContactCompany(String ContactCompany){this.ContactCompany.setValue(ContactCompany);}
    public String getContactCompany(){return this.ContactCompany.getValue();}
    
    public Field ContactDept;
    public void setContactDept(String ContactDept){this.ContactDept.setValue(ContactDept);}
    public String getContactDept(){return this.ContactDept.getValue();}
    
    public Field Introduce;
    public void setIntroduce(String Introduce){this.Introduce.setValue(Introduce);}
    public String getIntroduce(){return this.Introduce.getValue();}
    
    public Field UploadDoc;
    public void setUploadDoc(String UploadDoc){this.UploadDoc.setValue(UploadDoc);}
    public String getUploadDoc(){return this.UploadDoc.getValue();}
    
    public Field UploadDoc2;
    public void setUploadDoc2(String UploadDoc2){this.UploadDoc2.setValue(UploadDoc2);}
    public String getUploadDoc2(){return this.UploadDoc2.getValue();}
    
    public Field UploadDoc3;
    public void setUploadDoc3(String UploadDoc3){this.UploadDoc3.setValue(UploadDoc3);}
    public String getUploadDoc3(){return this.UploadDoc3.getValue();}
    
    public Field UploadDocName;
    public void setUploadDocName(String UploadDocName){this.UploadDocName.setValue(UploadDocName);}
    public String getUploadDocName(){return this.UploadDocName.getValue();}
    
    public Field UploadDocName2;
    public void setUploadDocName2(String UploadDocName2){this.UploadDocName2.setValue(UploadDocName2);}
    public String getUploadDocName2(){return this.UploadDocName2.getValue();}
    
    public Field UploadDocName3;
    public void setUploadDocName3(String UploadDocName3){this.UploadDocName3.setValue(UploadDocName3);}
    public String getUploadDocName3(){return this.UploadDocName3.getValue();}
    
    public Field AccountingOffice;
    public void setAccountingOffice(String AccountingOffice){this.AccountingOffice.setValue(AccountingOffice);}
    public String getAccountingOffice(){return this.AccountingOffice.getValue();}
    
    public Field AccountingMissTel;
    public void setAccountingMissTel(String AccountingMissTel){this.AccountingMissTel.setValue(AccountingMissTel);}
    public String getAccountingMissTel(){return this.AccountingMissTel.getValue();}
    
    public Field AccountingMissFax;
    public void setAccountingMissFax(String AccountingMissFax){this.AccountingMissFax.setValue(AccountingMissFax);}
    public String getAccountingMissFax(){return this.AccountingMissFax.getValue();}
    
    public Field AccountingOfficeTel;
    public void setAccountingOfficeTel(String AccountingOfficeTel){this.AccountingOfficeTel.setValue(AccountingOfficeTel);}
    public String getAccountingOfficeTel(){return this.AccountingOfficeTel.getValue();}
    
    public Field AccountingOfficeFax;
    public void setAccountingOfficeFax(String AccountingOfficeFax){this.AccountingOfficeFax.setValue(AccountingOfficeFax);}
    public String getAccountingOfficeFax(){return this.AccountingOfficeFax.getValue();}
    
    public Field AccountingOfficeAddr;
    public void setAccountingOfficeAddr(String AccountingOfficeAddr){this.AccountingOfficeAddr.setValue(AccountingOfficeAddr);}
    public String getAccountingOfficeAddr(){return this.AccountingOfficeAddr.getValue();}
    
    public Field LastCaseDate;
    public void setLastCaseDate(String LastCaseDate){this.LastCaseDate.setValue(LastCaseDate);}
    public String getLastCaseDate(){return this.LastCaseDate.getValue();}
    
    public Field BankBranches;
    public void setBankBranches(String BankBranches){this.BankBranches.setValue(BankBranches);}
    public String getBankBranches(){return this.BankBranches.getValue();}
    
    public Field BankBranches2;
    public void setBankBranches2(String BankBranches2){this.BankBranches2.setValue(BankBranches2);}
    public String getBankBranches2(){return this.BankBranches2.getValue();}
    
    public Field GroupName;
    public void setGroupName(String GroupName){this.GroupName.setValue(GroupName);}
    public String getGroupName(){return this.GroupName.getValue();}
    
    public String genFlowKeyFlag;

	public String getGenFlowKeyFlag() {
		return genFlowKeyFlag;
	}

	public void setGenFlowKeyFlag(String genFlowKeyFlag) {
		this.genFlowKeyFlag = genFlowKeyFlag;
	}
    
    public Field ContactRecord;
    public void setContactRecord(String ContactRecord){this.ContactRecord.setValue(ContactRecord);}
    public String getContactRecord(){return this.ContactRecord.getValue();}
    
    public Field SalesChangeList;
    public void setSalesChangeList(String SalesChangeList){this.SalesChangeList.setValue(SalesChangeList);}
    public String getSalesChangeList(){return this.SalesChangeList.getValue();}
    
    public Field CaseADChangeList;
    public void setCaseADChangeList(String CaseADChangeList){this.CaseADChangeList.setValue(CaseADChangeList);}
    public String getCaseADChangeList(){return this.CaseADChangeList.getValue();}
    
    public String changeSales;
    
    public String getChangeSales() {
		return changeSales;
	}

	public void setChangeSales(String changeSales) {
		this.changeSales = changeSales;
	}
	
	public String changeCaseAD;

	public String getChangeCaseAD() {
		return changeCaseAD;
	}

	public void setChangeCaseAD(String changeCaseAD) {
		this.changeCaseAD = changeCaseAD;
	}
    
    public Field CaseAD;
    public void setCaseAD(String CaseAD){this.CaseAD.setValue(CaseAD);}
    public String getCaseAD(){return this.CaseAD.getValue();}
    
    public Field SponsorAssistant;
    public void setSponsorAssistant(String SponsorAssistant){this.SponsorAssistant.setValue(SponsorAssistant);}
    public String getSponsorAssistant(){return this.SponsorAssistant.getValue();}
    
    public Field SponsorAssistantName;
    public void setSponsorAssistantName(String SponsorAssistantName){this.SponsorAssistantName.setValue(SponsorAssistantName);}
    public String getSponsorAssistantName(){return this.SponsorAssistantName.getValue();}
    
    public Field BillingContact;
    public void setBillingContact(String BillingContact){this.BillingContact.setValue(BillingContact);}
    public String getBillingContact(){return this.BillingContact.getValue();}
    
//    public Field Title2;
//    public void setTitle2(String Title2){this.Title2.setValue(Title2);}
//    public String getTitle2(){return this.Title2.getValue();}
    
    public Field Zip3;
    public void setZip3(String Zip3){this.Zip3.setValue(Zip3);}
    public String getZip3(){return this.Zip3.getValue();}
    
    public Field Zip4;
    public void setZip4(String Zip4){this.Zip4.setValue(Zip4);}
    public String getZip4(){return this.Zip4.getValue();}
    
    public Field Tel1ExNo;
    public void setTel1ExNo(String Tel1ExNo){this.Tel1ExNo.setValue(Tel1ExNo);}
    public String getTel1ExNo(){return this.Tel1ExNo.getValue();}
    
    public Field Tel2ExNo;
    public void setTel2ExNo(String Tel2ExNo){this.Tel2ExNo.setValue(Tel2ExNo);}
    public String getTel2ExNo(){return this.Tel2ExNo.getValue();}
    
    public Field BillingContactEmail;
    public void setBillingContactEmail(String BillingContactEmail){this.BillingContactEmail.setValue(BillingContactEmail);}
    public String getBillingContactEmail(){return this.BillingContactEmail.getValue();}
    
    public Field Email1;
    public void setEmail1(String Email1){this.Email1.setValue(Email1);}
    public String getEmail1(){return this.Email1.getValue();}
    
    public Field Tel;
    public void setTel(String Tel){this.Tel.setValue(Tel);}
    public String getTel(){return this.Tel.getValue();}
    
    public Field Zip;
    public void setZip(String Zip){this.Zip.setValue(Zip);}
    public String getZip(){return this.Zip.getValue();}
    
    public Field Attorney;
    public void setAttorney(String Attorney){this.Attorney.setValue(Attorney);}
    public String getAttorney(){return this.Attorney.getValue();}
    
    public String changeBillingContact2;

	public String getChangeBillingContact2() {
		return changeBillingContact2;
	}

	public void setChangeBillingContact2(String changeBillingContact2) {
		this.changeBillingContact2 = changeBillingContact2;
	}
    public String changeInvoiceTitle1;

	public String getChangeInvoiceTitle1() {
		return changeInvoiceTitle1;
	}

	public void setChangeInvoiceTitle1(String changeInvoiceTitle1) {
		this.changeInvoiceTitle1 = changeInvoiceTitle1;
	}
	public String changeContact;


	public String getChangeContact() {
		return changeContact;
	}

	public void setChangeContact(String changeContact) {
		this.changeContact = changeContact;
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
        this.setProgramId("jsp.Client");
        this.setTableName("Client");
        
        this.useFieldWidth = true;
        this.showSearchResultList = true;
        this.showPrintNewDocImg = true;
        
        this.SalesChangeList = new Field("SalesChangeList", this.getTableName());
        this.SalesChangeList.setDbType("varchar(50)");
        
        this.BillingContact = new Field("BillingContact", this.getTableName());
        this.BillingContact.setDbType("varchar(15)");
//        this.BillingContact.setCheckEmpty(true);
        
        this.SponsorAssistantName = new Field("SponsorAssistantName", this.getTableName());
        this.SponsorAssistantName.setDbType("nvarchar(300)");
        
        this.SponsorAssistant = new Field("SponsorAssistant", this.getTableName());
        this.SponsorAssistant.setDbType("nvarchar(300)");
        
        this.CaseAD = new Field("CaseAD", this.getTableName());
        this.CaseAD.setDbType("varchar(50)");
//        this.CaseAD.setCheckEmpty(true);
      
        //新增送出後畫面要停留在該筆資料編輯畫面。
      	this.setKeepInMaintain(true);
      		
        this.FlowKey.setSearchCondition(Cnstnts.LIKE);
        

        this.Datalack = new Field("Datalack", this.getTableName());
        this.Datalack.setDbType("nvarchar(200)");

        this.Summary = new Field("Summary", this.getTableName());
        this.Summary.setDbType("nvarchar(200)");

        this.FlowKey2 = new Field("FlowKey2", this.getTableName());
        this.FlowKey2.setDbType("varchar(50)");

        this.ClientContect = new Field("ClientContect", this.getTableName());
        this.ClientContect.setDbType("nvarchar(50)");

        this.Nationality = new Field("Nationality", this.getTableName());
        this.Nationality.setDbType("nvarchar(50)");
        this.Nationality.setCheckEmpty(true);

        this.Entity = new Field("Entity", this.getTableName());
        this.Entity.setDbType("nvarchar(50)");
//        this.Entity.setCheckEmpty(true);

        this.CompanyName = new Field("CompanyName", this.getTableName());
        this.CompanyName.setDbType("nvarchar(200)");
        this.CompanyName.setSearchCondition(Cnstnts.LIKE);
        this.CompanyName.setCheckEmpty(true);;

        this.EnglishCompanyName = new Field("EnglishCompanyName", this.getTableName());
        this.EnglishCompanyName.setDbType("varchar(200)");
        this.EnglishCompanyName.setSearchCondition(Cnstnts.LIKE);

        this.RegisteredNo = new Field("RegisteredNo", this.getTableName());
        this.RegisteredNo.setDbType("varchar(50)");

        this.InCharge = new Field("InCharge", this.getTableName());
        this.InCharge.setDbType("nvarchar(50)");
        //this.InCharge.setSearchCondition(Cnstnts.LIKE);
        
        this.Contact = new Field("Contact", this.getTableName());
        this.Contact.setDbType("nvarchar(50)");
        this.Contact.setSearchCondition(Cnstnts.LIKE);
        
        this.Contact2 = new Field("Contact2", this.getTableName());
        this.Contact2.setDbType("nvarchar(50)");
        this.Contact2.setSearchCondition(Cnstnts.LIKE);

        this.Tel1 = new Field("Tel1", this.getTableName());
        this.Tel1.setDbType("varchar(100)");

        this.Tel2 = new Field("Tel2", this.getTableName());
        this.Tel2.setDbType("varchar(50)");

        this.Mobile = new Field("Mobile", this.getTableName());
        this.Mobile.setDbType("varchar(50)");

        this.Fax1 = new Field("Fax1", this.getTableName());
        this.Fax1.setDbType("varchar(50)");

        this.Fax2 = new Field("Fax2", this.getTableName());
        this.Fax2.setDbType("varchar(50)");

        this.Email = new Field("Email", this.getTableName());
        this.Email.setDbType("varchar(50)");

        this.WebSite = new Field("WebSite", this.getTableName());
        this.WebSite.setDbType("varchar(50)");

        this.Msn = new Field("Msn", this.getTableName());
        this.Msn.setDbType("varchar(50)");

        this.Skype = new Field("Skype", this.getTableName());
        this.Skype.setDbType("varchar(50)");

        this.Attorney = new Field("Attorney", this.getTableName());
        this.Attorney.setDbType("varchar(50)");

        this.Zip1 = new Field("Zip1", this.getTableName());
        this.Zip1.setDbType("varchar(50)");

        this.Zip2 = new Field("Zip2", this.getTableName());
        this.Zip2.setDbType("varchar(50)");

        this.Address1 = new Field("Address1", this.getTableName());
        this.Address1.setDbType("nvarchar(100)");
        this.Address1.setSearchCondition(Cnstnts.LIKE);

        this.EnglishAddress1 = new Field("EnglishAddress1", this.getTableName());
        this.EnglishAddress1.setDbType("nvarchar(100)");

        this.Address2 = new Field("Address2", this.getTableName());
        this.Address2.setDbType("nvarchar(100)");
//        this.Address2.setCheckEmpty(true);

        this.EnglishAddress2 = new Field("EnglishAddress2", this.getTableName());
        this.EnglishAddress2.setDbType("nvarchar(100)");

        this.OwnershipType = new Field("OwnershipType", this.getTableName());
        this.OwnershipType.setDbType("varchar(50)");

        this.Category = new Field("Category", this.getTableName());
        this.Category.setDbType("varchar(50)");
        this.Category.setCheckEmpty(true);

        this.Industry = new Field("Industry", this.getTableName());
        this.Industry.setDbType("varchar(50)");

        this.StockId = new Field("StockId", this.getTableName());
        this.StockId.setDbType("varchar(50)");

        this.Credit = new Field("Credit", this.getTableName());
        this.Credit.setDbType("varchar(50)");

        this.Revenue = new Field("Revenue", this.getTableName());
        this.Revenue.setDbType("varchar(50)");

        this.Currency = new Field("Currency", this.getTableName());
        this.Currency.setDbType("nvarchar(50)");

        this.InvoiceTitle = new Field("InvoiceTitle", this.getTableName());
        this.InvoiceTitle.setDbType("nvarchar(100)");

        this.Memo = new Field("Memo", this.getTableName());
        this.Memo.setDbType("nvarchar(200)");

        this.Appendix = new Field("Appendix", this.getTableName());
        this.Appendix.setDbType("varchar(100)");
        
        this.Sponsor = new Field("Sponsor", this.getTableName());
        this.Sponsor.setDbType("nvarchar(50)");
//        this.Sponsor.setSearchCondition(Cnstnts.LIKE);
        this.Sponsor.setCheckEmpty(true);
        
        this.Payment = new Field("Payment", this.getTableName());
        this.Payment.setDbType("nvarchar(50)");
        
        this.FirstCaseDate = new Field("FirstCaseDate", this.getTableName());
        
        this.TotalCase = new Field("TotalCase", this.getTableName());
        
        this.AddFlag = new Field("AddFlag", this.getTableName());
        
        this.Email2 = new Field("Email2", this.getTableName());
        this.Email2.setDbType("nvarchar(50)");
        
        this.Email3 = new Field("Email3", this.getTableName());
        this.Email3.setDbType("nvarchar(50)");
        
        this.AccountingContact = new Field("AccountingContact", this.getTableName());
        this.AccountingContact.setDbType("varchar(50)");
        
        this.Accounting = new Field("Accounting", this.getTableName());
        this.Accounting.setDbType("varchar(50)");
        
        this.AccountingContactTel = new Field("AccountingContactTel", this.getTableName());
        this.AccountingContactTel.setDbType("varchar(50)");
        
        this.AccountingContactFax = new Field("AccountingContactFax", this.getTableName());
        this.AccountingContactFax.setDbType("varchar(50)");
        
        this.AccountingTel = new Field("AccountingTel", this.getTableName());
        this.AccountingTel.setDbType("varchar(50)");
        
        this.AccountingFax = new Field("AccountingFax", this.getTableName());
        this.AccountingFax.setDbType("varchar(50)");
        
        this.AccountingAddr = new Field("AccountingAddr", this.getTableName());
        this.AccountingAddr.setDbType("varchar(50)");
        
        this.AlsoAddContact = new Field("AlsoAddContact", this.getTableName());
        this.AlsoAddContact.setDbType("varchar(50)");
        
        this.LastName = new Field("LastName", this.getTableName());
        this.LastName.setDbType("nvarchar(50)");
        
        this.FirstName = new Field("FirstName", this.getTableName());
        this.FirstName.setDbType("nvarchar(50)");
        
        this.EnglishLastName = new Field("EnglishLastName", this.getTableName());
        this.EnglishLastName.setDbType("nvarchar(50)");
        
        this.EnglishFirstName = new Field("EnglishFirstName", this.getTableName());
        this.EnglishFirstName.setDbType("nvarchar(50)");
        
        this.Identity = new Field("Identity", this.getTableName());
        this.Identity.setDbType("varchar(50)");
        this.Identity.setCheckEmpty(true);
        
        this.GuanAccountDate = new Field("GuanAccountDate", this.getTableName());
        this.GuanAccountDate.setDbType("varchar(50)");
        
        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("nvarchar(100)");
        
        this.InvoiceTitle1 = new Field("InvoiceTitle1", this.getTableName());
        this.InvoiceTitle1.setDbType("varchar(100)");
        
        this.InvoiceTitle2 = new Field("InvoiceTitle2", this.getTableName());
        this.InvoiceTitle2.setDbType("varchar(50)");
        
        this.RegisteredNo2 = new Field("RegisteredNo2", this.getTableName());
        this.RegisteredNo2.setDbType("varchar(50)");
        
        this.AccountingEmail = new Field("AccountingEmail", this.getTableName());
        this.AccountingEmail.setDbType("varchar(50)");
        
        this.ContactCompany = new Field("ContactCompany", this.getTableName());
        this.ContactCompany.setDbType("varchar(100)");
        
        this.ContactDept = new Field("ContactDept", this.getTableName());
        this.ContactDept.setDbType("varchar(100)");
        
        this.Introduce = new Field("Introduce", this.getTableName());
        this.Introduce.setDbType("varchar(50)");
        
        this.UploadDoc = new Field("UploadDoc", this.getTableName());
        this.UploadDoc.setDbType("varchar(50)");
        
        this.UploadDoc2 = new Field("UploadDoc2", this.getTableName());
        this.UploadDoc2.setDbType("varchar(50)");
        
        this.UploadDoc3 = new Field("UploadDoc3", this.getTableName());
        this.UploadDoc3.setDbType("varchar(50)");
        
        this.UploadDocName = new Field("UploadDocName", this.getTableName());
        this.UploadDocName.setDbType("nvarchar(50)");
        
        this.UploadDocName2 = new Field("UploadDocName2", this.getTableName());
        this.UploadDocName2.setDbType("nvarchar(50)");
        
        this.UploadDocName3 = new Field("UploadDocName3", this.getTableName());
        this.UploadDocName3.setDbType("nvarchar(50)");
        
        this.AccountingOffice = new Field("AccountingOffice", this.getTableName());
        this.AccountingOffice.setDbType("varchar(50)");
        
        this.AccountingMissTel = new Field("AccountingMissTel", this.getTableName());
        this.AccountingMissTel.setDbType("varchar(50)");
        
        this.AccountingMissFax = new Field("AccountingMissFax", this.getTableName());
        this.AccountingMissFax.setDbType("varchar(50)");
        
        this.AccountingOfficeTel = new Field("AccountingOfficeTel", this.getTableName());
        this.AccountingOfficeTel.setDbType("varchar(50)");
        
        this.AccountingOfficeFax = new Field("AccountingOfficeFax", this.getTableName());
        this.AccountingOfficeFax.setDbType("varchar(50)");
        
        this.AccountingOfficeAddr = new Field("AccountingOfficeAddr", this.getTableName());
        this.AccountingOfficeAddr.setDbType("varchar(200)");
        
        this.LastCaseDate = new Field("LastCaseDate", this.getTableName());
        
        this.AddressSearch = new Field("AddressSearch", this.getTableName());

        this.BankBranches = new Field("BankBranches", this.getTableName());
        this.BankBranches.setDbType("varchar(100)");
        
        this.BankBranches2 = new Field("BankBranches2", this.getTableName());
        this.BankBranches2.setDbType("varchar(100)");
        
        this.GroupName = new Field("GroupName", this.getTableName());
        this.GroupName.setDbType("nvarchar(50)");
        this.GroupName.setSearchCondition(Cnstnts.LIKE);
        
        this.ContactRecord = new Field("ContactRecord", this.getTableName());
        this.ContactRecord.setDbType("varchar(60000)");
        
//        this.Title2 = new Field("Title2", this.getTableName());
//        this.Title2.setDbType("varchar(50)");
        
        this.Zip3 = new Field("Zip3", this.getTableName());
        this.Zip3.setDbType("varchar(50)");
        
        this.Zip4 = new Field("Zip4", this.getTableName());
        this.Zip4.setDbType("varchar(50)");
        
        this.Tel1ExNo = new Field("Tel1ExNo", this.getTableName());
        this.Tel1ExNo.setDbType("varchar(50)");
        
        this.Tel2ExNo = new Field("Tel2ExNo", this.getTableName());
        this.Tel2ExNo.setDbType("varchar(50)");
        
        this.BillingContactEmail = new Field("BillingContactEmail", this.getTableName());
        this.BillingContactEmail.setDbType("varchar(100)");
        
        this.Email1 = new Field("Email1", this.getTableName());
        this.Email1.setDbType("varchar(100)");
        
        this.Tel = new Field("Tel", this.getTableName());
        this.Tel.setDbType("varchar(50)");
        
        this.Zip = new Field("Zip", this.getTableName());
        this.Zip.setDbType("varchar(50)");
        
        this.CaseADChangeList = new Field("CaseADChangeList", this.getTableName());
        this.CaseADChangeList.setDbType("varchar(50)");
        
        this.setOrderKey(this.CompanyName.getName());
        this.setOrderSequence(Cnstnts.ASC);
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
//        this.DbFields.add(this.Title2);
        this.DbFields.add(this.ClientContect);
        this.DbFields.add(this.Attorney);
        this.DbFields.add(this.Zip3);
        this.DbFields.add(this.Zip4);
        this.DbFields.add(this.Tel1ExNo);
        this.DbFields.add(this.Tel2ExNo);
        this.DbFields.add(this.BillingContactEmail);
        this.DbFields.add(this.Email1);
        this.DbFields.add(this.Tel);
        this.DbFields.add(this.Zip);
        
        this.DbFields.add(this.BillingContact);
        this.DbFields.add(this.SponsorAssistantName);
        this.DbFields.add(this.SponsorAssistant);
        this.DbFields.add(this.Summary);

        this.DbFields.add(this.CaseAD);

        this.DbFields.add(this.Nationality);

        this.DbFields.add(this.ContactRecord);

        this.DbFields.add(this.Entity);

        this.DbFields.add(this.CompanyName);

        this.DbFields.add(this.EnglishCompanyName);

        this.DbFields.add(this.RegisteredNo);

        this.DbFields.add(this.InCharge);

        this.DbFields.add(this.Contact);

        this.DbFields.add(this.Tel1);

        this.DbFields.add(this.Tel2);

        this.DbFields.add(this.Mobile);

        this.DbFields.add(this.Fax1);

        this.DbFields.add(this.Fax2);

        this.DbFields.add(this.Email);

        this.DbFields.add(this.WebSite);

        this.DbFields.add(this.Msn);

        this.DbFields.add(this.Skype);

        this.DbFields.add(this.Zip1);

        this.DbFields.add(this.Zip2);

        this.DbFields.add(this.Address1);

        this.DbFields.add(this.EnglishAddress1);

        this.DbFields.add(this.Address2);

        this.DbFields.add(this.EnglishAddress2);

        this.DbFields.add(this.OwnershipType);

        this.DbFields.add(this.Category);

        this.DbFields.add(this.Industry);

        this.DbFields.add(this.StockId);

        this.DbFields.add(this.Credit);

        this.DbFields.add(this.Revenue);

        this.DbFields.add(this.Currency);

        this.DbFields.add(this.InvoiceTitle);

        this.DbFields.add(this.Memo);

        this.DbFields.add(this.Appendix);
        
        this.DbFields.add(this.Sponsor);
        
        this.DbFields.add(this.Payment);
        
        this.DbFields.add(this.Email2);
        
        this.DbFields.add(this.Email3);
        
        this.DbFields.add(this.AccountingContact);
        
        this.DbFields.add(this.Accounting);
        
        this.DbFields.add(this.AccountingContactTel);
        
        this.DbFields.add(this.AccountingContactFax);
        
        this.DbFields.add(this.AccountingTel);
        
        this.DbFields.add(this.AccountingFax);
        
        this.DbFields.add(this.AccountingAddr);
        
        this.DbFields.add(this.LastName);
        
        this.DbFields.add(this.FirstName);
        
        this.DbFields.add(this.EnglishLastName);
        
        this.DbFields.add(this.EnglishFirstName);
        
        this.DbFields.add(this.Identity);
        
        this.DbFields.add(this.GuanAccountDate);
        
        this.DbFields.add(this.Title);
        
        this.DbFields.add(this.InvoiceTitle1);
        
        this.DbFields.add(this.InvoiceTitle2);
        
        this.DbFields.add(this.RegisteredNo2);
        
        this.DbFields.add(this.AccountingEmail);
        
        this.DbFields.add(this.ContactCompany);
        
        this.DbFields.add(this.ContactDept);
        
        this.DbFields.add(this.Introduce);
        
        this.DbFields.add(this.UploadDoc);
        
        this.DbFields.add(this.UploadDoc2);
        
        this.DbFields.add(this.UploadDoc3);
        
        this.DbFields.add(this.UploadDocName);
        
        this.DbFields.add(this.UploadDocName2);
        
        this.DbFields.add(this.UploadDocName3);
        
        this.DbFields.add(this.AccountingOffice);
        
        this.DbFields.add(this.AccountingMissTel);
        
        this.DbFields.add(this.AccountingMissFax);
        
        this.DbFields.add(this.AccountingOfficeTel);
        
        this.DbFields.add(this.AccountingOfficeFax);
        
        this.DbFields.add(this.AccountingOfficeAddr);
        
        this.DbFields.add(this.BankBranches);
        
        this.DbFields.add(this.BankBranches2);
        
        this.DbFields.add(this.GroupName);
        
        this.DbFields.add(this.Datalack);
    }
    
    
    public String printHtmlBody() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine + "<table id='bodyTable' " + this.getTableBgcolor() + ">";

		if (this.onSearchMode()) {
			this.FlowKey.setCheckEmpty(false);
			rtnString += this.printSearchTable();
			
			rtnString += "<tr bgcolor='#E9EDF4'><td colspan='4' width='100%'><table width='100%' bgcolor='#F9FAFC'>";
			rtnString += "<tr><td width=85%><table width='100%'>";
			rtnString += this.printResultFieldHtml();
			rtnString += Cnstnts.NEW_LINE + "</table></td><td bgcolor='#E9EDF4' valign='top'>";
			rtnString += "<input type='checkbox' onClick='selectAllResultField(this);'>" + this.getUserInfo().getMsg("jsp.common.SelectAll");
			rtnString += Cnstnts.NEW_LINE + "</tr></table></td></tr>"; 
		} else {
			rtnString += this.printMaintainTable();
		}
		rtnString += newLine + "</table>";
		if (this.onSearchMode()) {
			rtnString += this.printSearchReasult();
		}
		return rtnString;
	}
    
    public String printHiddenTags(){
    	String rtnString = super.printHiddenTags();
    	HashMap<String,String> hm = new HashMap<String,String>();
    	hm.put("genFlowKeyFlag",Cnstnts.EMPTY_STRING);
  	  	rtnString += new HiddenTag().print(hm);
  	  	return rtnString;
    }
    
    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.GroupName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
        	this.FlowKey.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.FlowKey.setAnotherField(this.GroupName);
            this.FlowKey.setColspan(1);
			this.FlowKey.setCheckEmpty(false);
			rtnString += this.printHtml(this.FlowKey);
			
        	this.EnglishCompanyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.EnglishCompanyName.setLength(200);
        	
        	this.CompanyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.CompanyName.setAnotherField(this.EnglishCompanyName);
        	this.CompanyName.setLength(200);
            this.CompanyName.setColspan(1);
        	rtnString += this.printHtml(this.CompanyName);
        	
        	this.Category.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Category.setSelectList(new Category().getChildList(this.Category));
        	
        	this.Identity.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Identity.setSelectList(new Category().getChildList(this.Identity));
            this.Identity.setAnotherField(this.Category);
            this.Identity.setColspan(1);
            rtnString += this.printHtml(this.Identity);
        	
        	
        	this.Contact.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
        	this.InCharge.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InCharge.setColspan(1);
        	this.InCharge.setAnotherField(this.Contact);
        	rtnString+=this.printHtml(this.InCharge);
        	
        	this.Tel1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
        	this.RegisteredNo.setMapingPrpt(null);
        	this.RegisteredNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.RegisteredNo.setColspan(1);
        	this.RegisteredNo.setAnotherField(this.Tel1);
        	rtnString+=this.printHtml(this.RegisteredNo);

        	this.Sponsor.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.Sponsor.setSelectList(new Employee().getList());
        	
        	this.AddressSearch.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.AddressSearch.setAnotherField(this.Sponsor);
            this.AddressSearch.setColspan(1);
        	rtnString += this.printHtml(this.AddressSearch);       
        	
        	
        	this.Datalack.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        	
        	this.CaseAD.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CaseAD.setSelectList(new Employee().getList());
            this.CaseAD.setAnotherField(this.Datalack);
            this.CaseAD.setColspan(1);
            rtnString += this.printHtml(this.CaseAD);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	
            rtnString += this.Summary.printHiddenTag();
            
          //輸入後儲存在編輯狀態，該欄位旁出現按鈕 查詢關係企業，點選之後可列出所有此欄位填寫相同名稱之客戶資料
            if(!Util.isEmpty(this.GroupName.getValue()) &&
            		this.getDbActionMode().equals(Cnstnts.UPDATE)) {
            	this.GroupName.setButtonValue(this.getUserInfo().getMsg("jsp.Client.SearchGroupNumber"));
                this.GroupName.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=ClientGroup&QueryText4=" + this.getFlowKey() +"\",\"Group\",800,600)");
            }
            this.GroupName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.FlowKey.setAnotherField(this.GroupName);
            this.FlowKey.setColspan(1);
            if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
        		this.FlowKey.setReadonly(false);
        		this.FlowKey.setHtmlType(Cnstnts.HTML_TAG_TEXT);
	            this.FlowKey.setLength(4);
				this.FlowKey.setCheckEmpty(true);

				if(!Util.compareTo(this.AddFlag.getValue(), "Y")) {
					this.AddFlag.setValue("Y");
				}
            	this.AddFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);

            	this.FlowKey.setAnotherField(this.AddFlag);
            	
            	//取消客戶編號邏輯，直接以四碼流水碼編碼
        		if(Util.compareTo(getGenFlowKeyFlag(), "true") || Util.isEmpty(this.getFlowKey())){
        			String sql = "select flowkey from client where flowkey regexp '^[0-9]{4}$' order by flowkey desc";
        			if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
        				sql = "select flowkey from client where flowkey like '[0-9][0-9][0-9][0-9]' order by flowkey desc";
        			}
        			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
	    			int max = 1;
	    			String number = "0001";
	    			if(keys != null && !keys.isEmpty()) {
	    				String key = keys.get(0);
	    				max = Integer.parseInt(key) + 1;
	    				number = String.format("%04d", max);
	    			}
	    			this.FlowKey.setValue(number);
        		}
        		
	        	this.FlowKey.setAfterText("<input type='button' value='" + 
	        			this.getUserInfo().getMsg("jsp.Client.GetFlowKey") + 
	        			"' onclick='document.input.genFlowKeyFlag.value=\"true\";setValue();'>");
	        	rtnString += this.printHtml(this.FlowKey);
        	}
        	else {
        		this.FlowKey.setReadonly(true);
        		this.FlowKey.setAfterText("");
        		rtnString += this.printHtml(this.FlowKey);
        	}
            
            this.Attorney.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            rtnString += this.Attorney.printHiddenTag();
            
            if(Util.isEmpty(this.getSponsor())){
            	this.Sponsor.setValue(this.getUserInfo().getAttribute("emp_id"));
            }
            
            //該欄位僅G01權限者可編輯
            this.Sponsor.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Sponsor.setSelectList(new Employee().getList());
            
            this.CaseAD.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CaseAD.setSelectList(new Employee().getList());
            this.CaseAD.setAnotherField(this.Sponsor);
            
            this.Category.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Category.setSelectList(new Category().getChildList(this.Category));
            this.Category.setAnotherField(this.CaseAD);
            rtnString += this.printHtml(this.Category);
            
            /*
             * 客戶資料的業務欄位旁，新增按鈕 “帶入業務”，點選之後另開視窗顯示業務部人員清單，
             * 可勾選後帶入該欄位（以分號分隔員工編號儲存），在該欄位內的人員皆可開立此客戶的報價單。
             */
            rtnString += this.SponsorAssistant.printHiddenTag();

            this.SponsorAssistantName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.SponsorAssistantName.setSize(100);
            if(getCanEditField(this.SponsorAssistantName)){
            	this.SponsorAssistantName.setAfterText("<input type='button' value='" + 
            			this.getUserInfo().getMsg("jsp.Client.SponsorAssistantBtn") + 
            			"' onclick='openAppendix(\"QueryCheckForm.jsp?queryClass=Sales" +
            			//"&_queryText2=" + this.getClient() +"&QueryText4=" + this.getClient() +"" +
            			"&QueryText5=" + this.getFlowKey() + "\",\"Sales\",800,600)'>");
            }
            rtnString += this.printHtml(this.SponsorAssistantName);
            

            this.CompanyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
          	this.CompanyName.setSize(82);
          	this.CompanyName.setLength(200);
          	rtnString += this.printHtml(this.CompanyName);
          	
            this.EnglishCompanyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
          	this.EnglishCompanyName.setSize(82);
          	this.EnglishCompanyName.setLength(200);
          	rtnString += this.printHtml(this.EnglishCompanyName);
            
//            this.FirstName.setHtmlType(Cnstnts.HTML_TAG_TEXT);

//            this.LastName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.LastName.setSize(30);
//            this.LastName.setAnotherField(this.FirstName);
//            this.LastName.setColspan(1);
//            rtnString += this.printHtml(this.LastName);
            
//            this.EnglishFirstName.setHtmlType(Cnstnts.HTML_TAG_TEXT);

//            this.EnglishLastName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.EnglishLastName.setSize(30);
//            this.EnglishLastName.setAnotherField(this.EnglishFirstName);
//            this.EnglishLastName.setColspan(1);
//            rtnString += this.printHtml(this.EnglishLastName);
            
            

            this.Identity.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Identity.setSelectList(new Category().getChildList(this.Identity));
            this.Identity.setOnChange("setValue()");
            
            this.Nationality.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Nationality.setSelectList(new Category().getChildList("PatentOffice"));
            this.Nationality.setAnotherField(this.Identity);
            this.Nationality.setOnChange("setValue()");
            this.Nationality.setColspan(1);
            rtnString += this.printHtml(this.Nationality);


        	this.Datalack.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.Datalack.setColspan(3);
            rtnString += this.printHtml(this.Datalack);
            
            if(!Util.isEmpty(this.getFlowKey()) &&
            		!this.getDbActionMode().equals(Cnstnts.INSERT)) {
            	rtnString += printTabAreaHtml();
            }
        }
        return rtnString;
    }
    
    public String printTabAreaHtml() throws Exception {
    	String rtnString = "";
    	if(this.FlowKey.getValue().trim().length() > 0) {
    		boolean canShowTabs6 = false;
        	Groups group = new Groups();
        	//未收款資訊tab調整為G012、G013、G014不可看到(只要跨到3個任一群組就不能看)
			if(!group.inGorup("G012", this.getUserInfo().getAttribute("emp_id")) &&
					!group.inGorup("G013", this.getUserInfo().getAttribute("emp_id")) &&
					!group.inGorup("G014", this.getUserInfo().getAttribute("emp_id"))) {
				canShowTabs6 = true;
			}
        	String TabSelect = Cnstnts.EMPTY_STRING;
        	rtnString += "<script type='text/javascript'>createClientTabs();</script>";
        	
        	rtnString += "<tr><td colspan=4>"+
					"<div id='tabs'><ul>";
//        	rtnString += "<li><a href='#tabs-2'>"+this.getUserInfo().getMsg("jsp.Client.Tabs2")+"</a></li>";
        	rtnString += "<li><a href='#tabs-4'>"+this.getUserInfo().getMsg("jsp.Client.ContactInfoTab")+"</a></li>";
        	rtnString += "<li><a href='#tabs-11'>"+this.getUserInfo().getMsg("jsp.Client.Tabs11")+"</a></li>";
//        	rtnString += "<li><a href='#tabs-12'>"+this.getUserInfo().getMsg("jsp.Client.Tabs12")+"</a></li>";
//        	rtnString += "<li><a href='#tabs-1'>"+this.getUserInfo().getMsg("jsp.Client.Tabs1")+"</a></li>";
//        	rtnString += "<li><a href='#tabs-9'>"+this.getUserInfo().getMsg("jsp.Client.Tabs7")+"</a></li>";
//        	rtnString += "<li><a href='#tabs-10'>"+this.getUserInfo().getMsg("jsp.Client.Tabs10")+"</a></li>";
        	rtnString += "<li><a href='#tabs-13'>"+this.getUserInfo().getMsg("jsp.Client.Tabs13")+"</a></li>";
        	rtnString += "<li><a href='#tabs-3'>"+this.getUserInfo().getMsg("jsp.Client.Tabs3")+"</a></li>";
        	rtnString += "<li><a href='#tabs-5'>"+this.getUserInfo().getMsg("jsp.Client.Tabs5")+"</a></li>";
        	if(canShowTabs6) {
        		rtnString += "<li><a href='#tabs-6'>"+this.getUserInfo().getMsg("jsp.Client.Tabs6")+"</a></li>";
        	}
        	rtnString += "<li><a href='#tabs-7'>"+this.getUserInfo().getMsg("jsp.Client.LastQuotation1")+"</a></li>";
//        	rtnString += "<li><a href='#tabs-8'>"+this.getUserInfo().getMsg("jsp.Client.LastQuotation2")+"</a></li>";
        	rtnString += "</ul>";
        	
            /**** tabs-4 ****/
        	rtnString +="<div id='tabs-4'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateContactInfoTableDiv' name='updateContactInfoTableDiv'></div>";
            rtnString +="<div id='ContactInfoTableDiv' name='ContactInfoTableDiv'>";
            rtnString += printContactInfoTable();
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-4 end ****/
        	
            /**** tabs-11 ****/
        	rtnString +="<div id='tabs-11'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateContactInfoTableDiv' name='updateContactInfoTableDiv'></div>";
            rtnString +="<div id='ContactInfoTableDiv' name='ContactInfoTableDiv'>";
            rtnString += printContactRecordTable();
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-11 end ****/
            
            /**** tabs-12 ****/
//        	rtnString +="<div id='tabs-12'>";
//            rtnString +="<div class='indent'>";
//            rtnString +="<table width=95% border=0><tr><td valign=top>";
//            rtnString +="<div id='updateClientBillingDiv' name='updateClientBillingDiv'></div>";
//            rtnString +="<div id='ClientBillingDiv' name='ClientBillingDiv'>";
//            rtnString += new ClientBilling().getSearchReasult(this.getUserInfo(), this.getFlowKey());
//            
//            rtnString +="</div></td></tr></table>";
//            rtnString +="</div>";
//            rtnString +="</div>";
            /**** tabs-12 end ****/
            
            /**** tabs-1 ****/
//        	rtnString +="<div id='tabs-1'>";
//            rtnString +="<div class='indent'>";
//            rtnString +="<table width=95% border=0><tr><td valign=top>";
//            rtnString +="<div id='updateDetailTableDiv' name='updateDetailTableDiv'></div>";
//            rtnString +="<div id='DetailTableDiv' name='DetailTableDiv'>";
//            rtnString += ();
//            
//            rtnString +="</div></td></tr></table>";
//            rtnString +="</div>";
//            rtnString +="</div>";
            /**** tabs-1 end ****/

            /**** tabs-2 ****/
//        	rtnString +="<div id='tabs-2'>";
//            rtnString +="<div class='indent'>";
//            rtnString +="<table width=95% border=0><tr><td valign=top>";
//            rtnString +="<div id='updateClientApplicantDiv' name='updateClientApplicantDiv'></div>";
//            rtnString +="<div id='ClientApplicantDiv' name='ClientApplicantDiv'>";
//            rtnString += printApplicantTableHtml();
//            
//            rtnString +="</div></td></tr></table>";
//            rtnString +="</div>";
//            rtnString +="</div>";
            /**** tabs-2 end ****/

            /**** tabs-9 ****/
//        	rtnString +="<div id='tabs-9'>";
//            rtnString +="<div class='indent'>";
//            rtnString +="<table width=95% border=0><tr><td valign=top>";
//            rtnString +="<div id='updateClientAppTableDiv' name='updateClientAppTableDiv'></div>";
//            rtnString +="<div id='ClientAppTableDiv' name='ClientAppTableDiv'>";
//            //rtnString += printApplicantTableHtml2();
//            
//            rtnString +="</div></td></tr></table>";
//            rtnString +="</div>";
//            rtnString +="</div>";
            /**** tabs-9 end ****/

            /**** tabs-10 ****/
//        	rtnString +="<div id='tabs-10'>";
//            rtnString +="<div class='indent'>";
//            rtnString +="<table width=95% border=0><tr><td valign=top>";
//            rtnString +="<div id='updateInventorTableDiv' name='updateInventorTableDiv'></div>";
//            rtnString +="<div id='InventorTableDiv' name='InventorTableDiv'>";
////            rtnString += printInventorTableHtml();
//            
//            rtnString +="</div></td></tr></table>";
//            rtnString +="</div>";
//            rtnString +="</div>";
            /**** tabs-10 end ****/
            
            /**** tabs-13 ****/
            rtnString +="<div id='tabs-13'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateClientDocumentDiv' name='updateClientDocumentDiv'></div>";
            rtnString +="<div id='ClientDocumentDiv' name='ClientDocumentDiv'>";
//            rtnString += printCaseTableHtml();
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-13 end ****/

            /**** tabs-3 ****/
        	rtnString +="<div id='tabs-3'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateCaseTableDiv' name='updateCaseTableDiv'></div>";
            rtnString +="<div id='CaseTableDiv' name='PatentToDosDiv'>";
//            rtnString += printCaseTableHtml();
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-3 end ****/
            
            /**** tabs-5 ****/
        	rtnString +="<div id='tabs-5'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateServiceProjectDiv' name='updateServiceProjectDiv'></div>";
            rtnString +="<div id='ServiceProjectDiv' name='ServiceProjectDiv'>";
//            rtnString += printServiceProjectTableHtml();
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-5 end ****/
            
            if(canShowTabs6) {
            	/**** tabs-6 ****/
            	//count1 是“已請款台幣總金額”
            	//count2 是“已收款台幣總金額”
            	//count4 是“他方扣繳台幣總額”
            	//count1 - count2 -count 4 = count3 是 “已請款台幣總金額” - “已收款台幣總金額”- 他方扣繳台幣總額(資料來源：Invoice.TotalWithHolding)  = “未收款台幣總金額”
            	String count1 = "";
            	String count2 = "";
            	String count3 = "";
            	String count4 = "";
            	DecimalFormat df = new DecimalFormat("###,###");
            	
            	String SQL = "select sum(AmountReceivable) as Count from invoice where client='" + this.getFlowKey() + "' ";
            	count1 = this.getDbUtil().getFieldValue(SQL, "Count");
            	
            	SQL = "select sum(receiveNtdAmount) as Count from receiptmanage where client = '" + this.getFlowKey() + "'";
            	count2 = this.getDbUtil().getFieldValue(SQL, "Count");
            	
            	String sql = "select sum(i.TotalWithHolding) as TotalWithHolding from "
            			+ "(select ROUND(" + DB.SQL_IFNULL + "(ids.TWHAmount,0), 0) as TotalWithHolding " +
            			"from Invoice i " +
            			"left join ( " +
            			"select id.parentid,sum(id.Tax2) as TWHAmount from invoicedetail id " +
            			"where id.WithHolding='Y' group by id.parentid ) as ids on i.FlowKey= ids.parentid " +
            			"where i.client ='" + this.getFlowKey() + "') i";
            	count4 = this.getDbUtil().getFieldValue(sql, "TotalWithHolding");
            	
            	double requestPayAmount = 0;
            	if(count1 != null && count1.trim().length()> 0){
            		requestPayAmount = Double.parseDouble(count1);
            		count1 = df.format(Double.parseDouble(count1))+"";
            	}else{
            		count1 = "0";
            	}
            	double receiveNtdAmount = 0;
            	if(count2 != null && count2.trim().length() >0){
            		receiveNtdAmount = Double.parseDouble(count2);
            		count2 = df.format(Double.parseDouble(count2))+"";
            	}else{
            		count2 = "0";
            	}
            	double TotalWithHolding = 0;
            	if(count4 != null && count4.trim().length() >0){
            		TotalWithHolding = Double.parseDouble(count4);
            		count4 = df.format(Double.parseDouble(count4))+"";
            	}else{
            		count4 = "0";
            	}
            	count3 =  df.format((int)(requestPayAmount - receiveNtdAmount - TotalWithHolding)) + "";
            	
            	/*
            	 * 2013/1/6
            	 * 修正計算公式為："已請款台幣總金額  - 已收款台幣總金額 - 他方扣繳台幣總額(資料來源：Invoice.TotalWithHolding)  = 未收款台幣總金額 ”
            	 */
            	rtnString +="<div id='tabs-6'>";
            	rtnString +="<div class='indent'>";
            	rtnString +="<table width=95% border=0><tr><td valign=top>";
            	rtnString +="<tr>";
            	rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.RequestPayNtdAmount") + " : " + count1 + "</td>";
            	rtnString +="<td align='center'>-</td>";
            	rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.ReceiveNtdAmount") + " : " +  count2 + "</td>";
            	rtnString +="<td align='center'>-</td>";
            	rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.TotalWithHolding") + " : " +  count4 + "</td>";
            	rtnString +="<td align='center'>=</td>";
            	rtnString +="<td align='center'>" + this.getUserInfo().getMsg("jsp.Client.NotYetReceiveNtdAmount") + " : " +  count3 + "</td>";
            	rtnString +="</tr>";
            	rtnString +="<tr><td valign=top colspan='7'>";
            	rtnString +="<div id='updateNotYetWriteOffInvoiceDiv' name='updateNotYetWriteOffInvoiceDiv'></div>";
            	rtnString +="<div id='NotYetWriteOffInvoiceDiv' name='NotYetWriteOffInvoiceDiv'>";
//            rtnString += printNotYetWriteOffInvoiceTableHtml();
            	
            	rtnString +="</div></td></tr></table>";
            	rtnString +="</div>";
            	rtnString +="</div>";
            	/**** tabs-6 end ****/
            }
            

//            sql = "select flowkey from Quotation where client = '" + this.getFlowKey() + "' and BasicQuotation = 'Y' order by QuotationDate desc";
//            List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
//            
//            sql = "select flowkey from Quotation where client = '" + this.getFlowKey() + "' and (QuotationDate is not null and QuotationDate != '') order by QuotationDate desc";
//            keys.addAll(this.getDbUtil().getValueList(sql, "flowkey"));
            
            /**** tabs-7 ****/
        	rtnString +="<div id='tabs-7'>";
            rtnString +="<div class='indent'>";
            rtnString +="<table width=95% border=0><tr><td valign=top>";
            rtnString +="<div id='updateQuotation1Div' name='updateQuotation1Div'></div>";
            rtnString +="<div id='Quotation1Div' name='Quotation1Div'>";
//            if(keys != null && keys.size() > 0) {
//            	Quotation cc = new Quotation(keys.get(0));
//            	cc.setDbFields();
//            	cc.setUserInfo(this.getUserInfo());
//            	cc.setDbActionMode(Cnstnts.QUERY);
//            	cc.setPageActionMode(Cnstnts.MAINTAIN);
//            	
//            	if(this.getUserInfo().getObj("Quotation") == null) {
//            		this.getUserInfo().setObj("Quotation", cc);
//            	}
//            	
//            	rtnString += cc.printMaintainTable();
//            }
            
            rtnString +="</div></td></tr></table>";
            rtnString +="</div>";
            rtnString +="</div>";
            /**** tabs-7 end ****/
            
            /**** tabs-8 ****/
//        	rtnString +="<div id='tabs-8'>";
//            rtnString +="<div class='indent'>";
//            rtnString +="<table width=95% border=0><tr><td valign=top>";
//            rtnString +="<div id='updateQuotation2Div' name='updateQuotation2Div'></div>";
//            rtnString +="<div id='Quotation2Div' name='Quotation2Div'>";
////            if(keys != null && keys.size() > 1) {
////            	Quotation cc = new Quotation(keys.get(1));
////            	cc.setDbFields();
////            	cc.setUserInfo(this.getUserInfo());
////            	cc.setDbActionMode(Cnstnts.QUERY);
////            	cc.setPageActionMode(Cnstnts.MAINTAIN);
////            	rtnString += cc.printMaintainTable();
////            }
//            
//            rtnString +="</div></td></tr></table>";
//            rtnString +="</div>";
//            rtnString +="</div>";
            /**** tabs-8 end ****/
            
            rtnString += "</div>";
        
            
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
					    "  doPatentCaseAjaxRequest('Client',newTabText,'"+this.getFlowKey()+"',DataDiv,'innerHTML')"+
					    "}"+
						"</script>";
            rtnString += scriptText;
            rtnString += "</td></tr>";
        }
    	
    	
        
        return rtnString;
    }
    
    public String printContactInfoTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;

        rtnString += "<table width='100%' " + this.getTableBgcolor() + ">";
        
        //若所選的客戶資料 國籍=TW且身分類別為法人，則下列必填："發票抬頭" 、"負責人"、"登記地址"
        //（若所選的客戶資料 國籍非TW或身分類別為個人，則"發票抬頭" 非必填）
        if(!Util.isEmpty(this.getFlowKey()) &&
        		Util.compareTo(this.getDbActionMode(), Cnstnts.UPDATE)) {
        	this.InCharge.setCheckEmpty(true);
	        this.Entity.setCheckEmpty(true);
	        this.InvoiceTitle1.setCheckEmpty(true);

	        if(!Util.compareTo(this.getNationality(), "TW") ||
	        		Util.compareTo(this.getIdentity(), "Identity01")) {
//	        	this.RegisteredNo.setCheckEmpty(false);
	        	this.InCharge.setCheckEmpty(false);
	        	this.Address1.setCheckEmpty(false);
		        this.InvoiceTitle1.setCheckEmpty(false);
	        }
	        else {
//	        	this.RegisteredNo.setCheckEmpty(true);
	        	this.Address1.setCheckEmpty(true);
	        }

	        
//	        this.Contact.setCheckEmpty(true);
        }
        //this.RegisteredNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        
//        this.InvoiceTitle1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.InvoiceTitle1.setColspan(1);
//        this.InvoiceTitle1.setAnotherField(this.RegisteredNo);
//        this.InvoiceTitle1.setLength(100);
        //rtnString += this.printHtml(this.InvoiceTitle1);
        
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
        if(!Util.isEmpty(this.getChangeClientContact()) &&
        		this.getChangeClientContact().startsWith("true")) {
        	if(this.getChangeClientContact().indexOf("%") != -1) {
        		this.setClientContect(this.getChangeClientContact().split("%")[1]);
        	}
        }
		rtnString += "<input type='hidden' name='changeClientContact' id='changeClientContact'>";
		String sql2 = "select FlowKey, Names from applicant where " +
				"Client = '" + this.getFlowKey() + "' " +
				"and ShowInClient ='Y' " +
				"and (ApplicantKind like '%CLK01;%' or ApplicantKind like '%CLK06;%' or ApplicantKind like '%CLK07;%') ";
        this.ClientContect.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//        	        this.ClientContect.setOnChange("document.input.changeClientContact.value=true;setValue()");
        this.ClientContect.setSelectList(this.getDbUtil().getSelectItemList(sql2, new Field("Names", ""), false));
        this.ClientContect.setButtonValue(this.getUserInfo().getMsg("jsp.function.insert"));
		this.ClientContect.setButtonClick("openAppendix(\"Applicant.jsp?_pageActionMode=maintain" + "&_dbActionMode=insert&quotationIn2=true&_client=" + this.getFlowKey() + "\",\"AddApplicant\",800,600)");
		this.ClientContect.setSecondButtonValue(this.getUserInfo().getMsg("jsp.function.update"));
		this.ClientContect.setSecondButtonClick("openAppendix(\"Applicant.jsp?_getDataFlag=true&_pageActionMode=maintain&_dbActionMode=update&quotationIn2=true&flowKey=" + this.getClientContect() + "\",\"AddApplicant\",800,600)");
        
//    	this.RegisteredNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//    	this.RegisteredNo.setLength(100);
    	
        //發票抬頭的下拉選單包含 "母公司或集團名稱"欄位相同的客戶代碼的發票抬頭資料
        String sql = "select a.flowkey, InvoiceTitle from invtitle a " +
        		"where a.parentid = '" + this.getFlowKey() + "' ";
        if(!Util.isEmpty(this.getGroupName())) {
        	sql += " or a.parentid in (select c.flowkey from client c where c.GroupName = '" + this.getGroupName() + "' ) ";
        }
		this.InvoiceTitle1.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
		this.InvoiceTitle1.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("InvoiceTitle", ""), false, false));
        this.InvoiceTitle1.setColspan(1);
        this.InvoiceTitle1.setAnotherField(this.ClientContect);
        this.InvoiceTitle1.setLength(100);
        this.InvoiceTitle1.setButtonValue(this.getUserInfo().getMsg("jsp.function.insert"));
		this.InvoiceTitle1.setButtonClick("openAppendix(\"InvTitle.jsp?_modelLockFlag=true&_pageActionMode=maintain&_dbActionMode=insert&clientIn=true&_parentId=" + this.getFlowKey() + "\",\"InvTitle\",800,600)");
        this.InvoiceTitle1.setSecondButtonValue(this.getUserInfo().getMsg("jsp.function.update"));
		this.InvoiceTitle1.setSecondButtonClick("openAppendix(\"InvTitle.jsp?_getDataFlag=true&_pageActionMode=maintain&_dbActionMode=update&clientIn=true&flowKey=" + this.getInvoiceTitle1() + "\",\"InvTitle\",800,600)");
//		this.InvoiceTitle1.setOnChange("document.input.changeInvoiceTitle1.value=true;setValue()");
        rtnString += this.printHtml(this.InvoiceTitle1);



        this.Entity.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        this.Entity.setSelectList(new Category().getChildList(this.Entity));
        
        this.InCharge.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.InCharge.setColspan(1);
        this.InCharge.setAnotherField(this.Entity);
        rtnString += this.printHtml(this.InCharge);
        
        this.Address1.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.Address1.setRows(2);
        this.Address1.setCols(60);
        this.Address1.setLength(100);
                    
        this.Zip1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Zip1.setSize(5);
        
        String addressString = "<tr bgcolor='#E9EDF4'>";
        addressString += Cnstnts.NEW_LINE + "    <td align='right' width='20%'>" + getAlias(this.Zip1) + "</td>";
        addressString += Cnstnts.NEW_LINE + "    <td colspan=3><table><tr><td>" + this.printTag(this.Zip1) +"</td><td>&nbsp&nbsp&nbsp&nbsp"+ getAlias(this.Address1) + "</td><td>" + this.printTag(this.Address1) + "</td></tr></table></td>";
        addressString += Cnstnts.NEW_LINE + "  </tr>";
        rtnString += addressString;

        this.Address2.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.Address2.setRows(2);
        this.Address2.setCols(60);
        this.Address2.setLength(100);
        
        this.Zip2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Zip2.setSize(5);
        
        String address2String = "<tr bgcolor='#E9EDF4'>";
        address2String += Cnstnts.NEW_LINE + "    <td align='right' width='20%'>" + getAlias(this.Zip2)  + "</td>";
        address2String += Cnstnts.NEW_LINE + "    <td colspan=3><table><tr><td>" + this.printTag(this.Zip2)+"&nbsp&nbsp&nbsp&nbsp"+ getAlias(this.Address2) + "</td><td>" + this.printTag(this.Address2) + "</td></tr></table></td>";
        address2String += Cnstnts.NEW_LINE + "  </tr>";
        rtnString += address2String;
        
        this.EnglishAddress1.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.EnglishAddress1.setLength(100);
        this.EnglishAddress1.setRows(2);
        this.EnglishAddress1.setCols(60);
        
        this.Zip3.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Zip3.setSize(5);
        
        String address3String = "<tr bgcolor='#E9EDF4'>";
        address3String += Cnstnts.NEW_LINE + "    <td align='right' width='20%'>" + getAlias(this.Zip3) + "</td>";
        address3String += Cnstnts.NEW_LINE + "    <td colspan=3><table><tr><td>" + this.printTag(this.Zip3) + "&nbsp&nbsp&nbsp&nbsp"+ getAlias(this.EnglishAddress1) + "</td><td>" + this.printTag(this.EnglishAddress1) + "</td></tr></table></td>";
        address3String += Cnstnts.NEW_LINE + "  </tr>";
        rtnString += address3String;
        
        this.EnglishAddress2.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        this.EnglishAddress2.setLength(100);
        this.EnglishAddress2.setRows(2);
        this.EnglishAddress2.setCols(60);
        
        this.Zip4.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Zip4.setSize(5);
        
        String address4String = "<tr bgcolor='#E9EDF4'>";
        address4String += Cnstnts.NEW_LINE + "    <td align='right' width='20%'>" + getAlias(this.Zip4) + "</td>";
        address4String += Cnstnts.NEW_LINE + "    <td colspan=3><table><tr><td>" + this.printTag(this.Zip4) + "&nbsp&nbsp&nbsp&nbsp"+ getAlias(this.EnglishAddress2) + "</td><td>" + this.printTag(this.EnglishAddress2) + "</td></tr></table></td>";
        address4String += Cnstnts.NEW_LINE + "  </tr>";
        rtnString += address4String;
        
        this.Email.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        
        this.Fax1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Fax1.setAnotherField(this.Email);

        this.Tel.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Tel.setAnotherField(this.Fax1);
        this.Tel.setLength(100);
        rtnString += this.printHtml(this.Tel);
        

//        if(!Util.isEmpty(this.getChangeContact()) &&
//        		this.getChangeContact().startsWith("true")) {
//        	if(this.getChangeContact().indexOf("%") != -1) {
//        		this.setContact(this.getChangeContact().split("%")[1]);
//        	}
//        	if(!Util.isEmpty(this.getContact())) {
//        		Applicant app = new Applicant(this.getContact());
//        		this.Tel1.setValue(app.getTelNo());
//        		this.Skype.setValue(app.getSkype());
//        		this.Mobile.setValue(app.getMobile());
//        		this.Fax2.setValue(app.getFax());
//        		this.Email1.setValue(app.getEmail());
//        		this.Email2.setValue(app.getEmail2());
//        	}
//        }
//		rtnString += "<input type='hidden' name='changeContact' id='changeContact'>";
//		sql = "select FlowKey, Names from applicant where " +
//				"Client = '" + this.getFlowKey() + "' " +
//				"and ShowInClient ='Y' " +
//				"and ApplicantKind ='CLK01' ";
//        this.Contact.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//        this.Contact.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("Names", ""), false));
//        this.Contact.setOnChange("document.input.changeContact.value=true;setValue()");
//        this.Contact.setButtonValue(this.getUserInfo().getMsg("jsp.function.insert"));
//		this.Contact.setButtonClick("openAppendix(\"Applicant.jsp?_pageActionMode=maintain" + "&_dbActionMode=insert&clientIn3=true&_client=" + this.getFlowKey() + "\",\"AddApplicant\",800,600)");
//		this.Contact.setSecondButtonValue(this.getUserInfo().getMsg("jsp.function.update"));
//		this.Contact.setSecondButtonClick("openAppendix(\"Applicant.jsp?_getDataFlag=true&_pageActionMode=maintain&_dbActionMode=update&clientIn3=true&flowKey=" + this.getContact() + "\",\"AddApplicant\",800,600)");
////        this.Contact.setHtmlType(Cnstnts.HTML_TAG_TEXT);
////        this.Contact.setColspan(3);
//        rtnString += this.printHtml(this.Contact);
//        
//        if(Util.compareTo(this.getDbActionMode(), Cnstnts.UPDATE)) {
//        	this.Tel2ExNo.setCanEdit(true);
//        }
//        this.Tel2ExNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Tel2ExNo.setSize(6);
//
//        this.Tel2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Tel2.setAfterText(Html.getAlias(this.Tel2ExNo, this.getUserInfo()) + " " +
//        		Html.printTag(this.Tel2ExNo, this.getUserInfo()));
//        
//        if(Util.compareTo(this.getDbActionMode(), Cnstnts.UPDATE)) {
//        	this.Tel1ExNo.setCanEdit(true);
//        }
//        this.Tel1ExNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Tel1ExNo.setSize(6);
//        
//        this.Tel1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Tel1.setAnotherField(this.Tel2);
//        this.Tel1.setAfterText(Html.getAlias(this.Tel1ExNo, this.getUserInfo()) + " " +
//        		Html.printTag(this.Tel1ExNo, this.getUserInfo()));
//        this.Tel1.setLength(100);
//        this.Tel1.setColspan(1);
//        rtnString += this.printHtml(this.Tel1);
//        
//        this.Email1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Email1.setSize(30);
//        
//        this.Mobile.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Mobile.setAnotherField(this.Email1);
//        this.Mobile.setColspan(1);
//        rtnString += this.printHtml(this.Mobile);
//        
//        this.Email3.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Email3.setSize(30);
//        
//        this.Email2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Email2.setSize(30);
//        this.Email2.setAnotherField(this.Email3);
//        this.Email2.setColspan(1);
//        rtnString += this.printHtml(this.Email2);
//        
//        
//
//        this.Fax2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Fax2.setSize(30);
//        
//        this.Skype.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//        this.Skype.setAnotherField(this.Fax2);
//        this.Skype.setColspan(1);
//        rtnString += this.printHtml(this.Skype);


        if(!Util.isEmpty(this.getChangeBillingContact2()) &&
        		this.getChangeBillingContact2().startsWith("true")) {
        	System.out.println(this.getChangeBillingContact2());
        	if(this.getChangeBillingContact2().indexOf("%") != -1) {
        		this.setBillingContact(this.getChangeBillingContact2().split("%")[1]);
        	}
        	if(Util.isEmpty(this.getBillingContact())) {
        		this.AccountingMissFax.setValue("");
        		this.AccountingMissTel.setValue("");
        		this.BillingContactEmail.setValue("");
        	}
        	else {
        		Applicant applicant = new Applicant(this.getBillingContact());
        		this.AccountingMissFax.setValue(applicant.getFax());
        		this.AccountingMissTel.setValue(applicant.getTelNo());
        		this.BillingContactEmail.setValue(applicant.getEmail());
        	}
        }
        

        this.BillingContactEmail.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.BillingContactEmail.setLength(100);

        rtnString += "<input type='hidden' name='changeBillingContact2' id='changeBillingContact2'>";
      //顯示組合該筆資料的：部門 姓名 稱謂
        sql = "select a.flowkey, concat(a.Department, ' ' , a.Names, ' ', a.Title) as Names from applicant a " +
        		"where a.ShowInClient = 'Y' " +
        		"and a.Client = '" + this.getFlowKey() + "' " +
        		"and a.ApplicantKind like '%CLK02;%'";
        if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
        	sql = "select a.flowkey, (a.Department+' '+a.Names+' '+a.Title) as Names from applicant a " +
            		"where a.ShowInClient = 'Y' " +
            		"and a.Client = '" + this.getFlowKey() + "' " +
            		"and a.ApplicantKind like '%CLK02;%'";
        }
        this.BillingContact.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
		this.BillingContact.setSelectList(this.getDbUtil().getSelectItemList(sql, new Field("Names", ""), false, false));
        this.BillingContact.setColspan(1);
        this.BillingContact.setAnotherField(this.BillingContactEmail);
        this.BillingContact.setOnChange("document.input.changeBillingContact2.value=true;setValue()");
        this.BillingContact.setButtonValue(this.getUserInfo().getMsg("jsp.function.insert"));
		this.BillingContact.setButtonClick("openAppendix(\"Applicant.jsp?_pageActionMode=maintain" + "&_dbActionMode=insert&clientIn2=true&_client=" + this.getFlowKey() + "\",\"AddApplicant\",800,600)");
		this.BillingContact.setSecondButtonValue(this.getUserInfo().getMsg("jsp.function.update"));
		this.BillingContact.setSecondButtonClick("openAppendix(\"Applicant.jsp?_getDataFlag=true&_pageActionMode=maintain&_dbActionMode=update&clientIn2=true&flowKey=" + this.getBillingContact() + "\",\"AddApplicant\",800,600)");
        rtnString += this.printHtml(this.BillingContact);

        this.AccountingMissFax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        
        this.AccountingMissTel.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.AccountingMissTel.setColspan(1);
        this.AccountingMissTel.setAnotherField(this.AccountingMissFax);
        rtnString += this.printHtml(this.AccountingMissTel);
        
        
        this.AccountingTel.setHtmlType(Cnstnts.HTML_TAG_TEXT);
      
        this.Accounting.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Accounting.setColspan(1);
        this.Accounting.setAnotherField(this.AccountingTel);
        rtnString += this.printHtml(this.Accounting);
        
        this.Payment.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        List<SelectItem> paymentItems = new ArrayList<SelectItem>();
        paymentItems.add(new SelectItem("TT","TT"));
        paymentItems.add(new SelectItem("30d","30d"));
        paymentItems.add(new SelectItem("45d","45d"));
        paymentItems.add(new SelectItem("60d","60d"));
        paymentItems.add(new SelectItem("75d","75d"));
        paymentItems.add(new SelectItem("90d","90d"));
        this.Payment.setSelectList(paymentItems);
        
        this.GuanAccountDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.GuanAccountDate.setAnotherField(this.Payment);
        this.GuanAccountDate.setColspan(1);
        rtnString += this.printHtml(this.GuanAccountDate);
        
        this.Industry.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        this.Industry.setSelectList(new Category().getChildList(this.Industry));
        
        
        List<SelectItem> CreditItems = new ArrayList<SelectItem>();
        CreditItems.add(new SelectItem("AA","AA"));
        CreditItems.add(new SelectItem("A","A"));
        CreditItems.add(new SelectItem("B","B"));
        CreditItems.add(new SelectItem("C","C"));
        CreditItems.add(new SelectItem("D","D"));
        
        this.Credit.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        this.Credit.setSelectList(CreditItems);
        this.Credit.setAnotherField(this.Industry);
        this.Credit.setColspan(1);
        rtnString += this.printHtml(this.Credit);
        

        this.WebSite.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.WebSite.setSize(30);
        
        this.Revenue.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.Revenue.setColspan(3);
        this.Revenue.setAnotherField(this.WebSite);
        this.Revenue.setColspan(1);
        rtnString += this.printHtml(this.Revenue);
        
        this.UploadDoc.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
        
        this.UploadDocName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.UploadDocName.setAnotherField(this.UploadDoc);
        //this.UploadDocName.setColspan(1);
        rtnString += this.printHtml(this.UploadDocName);
        
        this.UploadDoc2.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
        
        this.UploadDocName2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.UploadDocName2.setAnotherField(this.UploadDoc2);
        //this.UploadDocName2.setColspan(1);
        rtnString += this.printHtml(this.UploadDocName2);
        
        this.UploadDoc3.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
        
        this.UploadDocName3.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.UploadDocName3.setAnotherField(this.UploadDoc3);
        //this.UploadDocName3.setColspan(1);
        rtnString += this.printHtml(this.UploadDocName3);

        this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
       	this.Memo.setCols(62);
        this.Memo.setRows(2);
        rtnString += this.printHtml(this.Memo);
        
        rtnString += this.RegisteredNo2.printHiddenTag();
        rtnString += this.InvoiceTitle2.printHiddenTag();
        rtnString += this.ContactDept.printHiddenTag();
        rtnString += this.ContactCompany.printHiddenTag();
        rtnString += this.Msn.printHiddenTag();
        rtnString += this.Introduce.printHiddenTag();
        rtnString += this.AccountingOffice.printHiddenTag();
        rtnString += this.AccountingOfficeTel.printHiddenTag();
        rtnString += this.AccountingOfficeAddr.printHiddenTag();
        rtnString += this.AccountingOfficeFax.printHiddenTag();
        rtnString += this.Currency.printHiddenTag();
//        rtnString += this.AlertDay.printHiddenTag();
        rtnString += this.OwnershipType.printHiddenTag();
        rtnString += this.StockId.printHiddenTag();

        rtnString += "</table>";
        
        return rtnString;
    }
    
    public String printContactRecordTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;

        	rtnString += "<table width='100%' " + this.getTableBgcolor() + ">";
        	
        	this.ContactRecord.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.ContactRecord.setRows(6);
            this.ContactRecord.setCols(80);
            this.ContactRecord.setLength(60000);
            this.ContactRecord.setColspan(3);
            rtnString += this.printHtml(this.ContactRecord);
        	
        	rtnString += "</table>";
        	
        	return rtnString;
    }
    
    public String printDetailTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;

        	rtnString += "<table width='100%' " + this.getTableBgcolor() + ">";
        	
        	this.RegisteredNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.InvoiceTitle1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceTitle1.setColspan(1);
            this.InvoiceTitle1.setAnotherField(this.RegisteredNo);
            this.InvoiceTitle1.setLength(100);
            rtnString += this.printHtml(this.InvoiceTitle1);
            
            this.RegisteredNo2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.InvoiceTitle2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceTitle2.setColspan(1);
            this.InvoiceTitle2.setAnotherField(this.RegisteredNo2);
            rtnString += this.printHtml(this.InvoiceTitle2);

            
            this.BankBranches2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.BankBranches.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.BankBranches.setColspan(1);
            this.BankBranches.setAnotherField(this.BankBranches2);
            rtnString += this.printHtml(this.BankBranches);
//            
//            this.AccountingTel.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            
//            this.Accounting.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.Accounting.setColspan(1);
//            this.Accounting.setAnotherField(this.AccountingTel);
//            rtnString += this.printHtml(this.Accounting);
//            
//            this.AccountingEmail.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            
//            this.AccountingFax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.AccountingFax.setColspan(1);
//            this.AccountingFax.setAnotherField(this.AccountingEmail);
//            rtnString += this.printHtml(this.AccountingFax);
            
            
            this.BillingContact.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.BillingContact.setColspan(3);
            this.BillingContact.setLength(15);
            rtnString += this.printHtml(this.BillingContact);
            
            this.AccountingMissFax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.AccountingMissTel.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AccountingMissTel.setColspan(1);
            this.AccountingMissTel.setAnotherField(this.AccountingMissFax);
            rtnString += this.printHtml(this.AccountingMissTel);
            
            this.AccountingOfficeTel.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.AccountingOffice.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AccountingOffice.setColspan(1);
            this.AccountingOffice.setAnotherField(this.AccountingOfficeTel);
            rtnString += this.printHtml(this.AccountingOffice);
            
            this.AccountingOfficeAddr.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AccountingOfficeAddr.setLength(200);
            this.AccountingOfficeAddr.setSize(70);
            
            this.AccountingOfficeFax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AccountingOfficeFax.setColspan(1);
            this.AccountingOfficeFax.setAnotherField(this.AccountingOfficeAddr);
            rtnString += this.printHtml(this.AccountingOfficeFax);
            
            
            this.GuanAccountDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.Currency.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Currency.setColspan(1);
            this.Currency.setAnotherField(this.GuanAccountDate);
            rtnString += this.printHtml(this.Currency);
            
            this.AlertDay.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AlertDay.setSize(1);
            
            this.Payment.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            List<SelectItem> paymentItems = new ArrayList<SelectItem>();
            paymentItems.add(new SelectItem("TT","TT"));
            paymentItems.add(new SelectItem("30d","30d"));
            paymentItems.add(new SelectItem("45d","45d"));
            paymentItems.add(new SelectItem("60d","60d"));
            paymentItems.add(new SelectItem("75d","75d"));
            paymentItems.add(new SelectItem("90d","90d"));
            this.Payment.setSelectList(paymentItems);
            this.Payment.setAnotherField(this.AlertDay);
            this.Payment.setColspan(1);
            rtnString += this.printHtml(this.Payment);
            
            List<SelectItem> CreditItems = new ArrayList<SelectItem>();
            CreditItems.add(new SelectItem("AA","AA"));
            CreditItems.add(new SelectItem("A","A"));
            CreditItems.add(new SelectItem("B","B"));
            CreditItems.add(new SelectItem("C","C"));
            CreditItems.add(new SelectItem("D","D"));
            
            this.Credit.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Credit.setSelectList(CreditItems);
            
            this.Industry.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Industry.setSelectList(new Category().getChildList(this.Industry));
            this.Industry.setAnotherField(this.Credit);
            this.Industry.setColspan(1);
            rtnString += this.printHtml(this.Industry);
            
            this.Revenue.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
        	this.OwnershipType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.OwnershipType.setSelectList(new Category().getChildList(this.OwnershipType));
            this.OwnershipType.setAnotherField(this.Revenue);
            this.OwnershipType.setColspan(1);
            rtnString += this.printHtml(this.OwnershipType);

            
            this.StockId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.StockId.setColspan(3);
            rtnString += this.printHtml(this.StockId);
            
//            this.EnglishAddress1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.EnglishAddress1.setSize(70);
//            rtnString += this.printHtml(this.EnglishAddress1);
//
//            this.EnglishAddress2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.EnglishAddress2.setSize(70);
//            rtnString += this.printHtml(this.EnglishAddress2);
            
            
//            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            
//            this.AccountingFax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            
//            
//            rtnString += this.printHtml(this.AccountingTel);
//
//            this.AccountingAddr.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            
//            this.AccountingEmail.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//            this.AccountingEmail.setColspan(1);
//            this.AccountingEmail.setAnotherField(this.AccountingAddr);
//            rtnString += this.printHtml(this.AccountingEmail);
//            
            this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
           	this.Memo.setCols(62);
            this.Memo.setRows(2);
            rtnString += this.printHtml(this.Memo);
//
//            this.Appendix.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
//            rtnString += this.printHtml(this.Appendix);
            
        	rtnString += "</table>";
        
        return rtnString;
    }
    

    
    public String printApplicantTableHtml(UserBean userInfo, String client) throws Exception {
    	this.setFlowKey(client);
    	this.setUserInfo(new UserBean());
    	this.setDbActionMode(Cnstnts.UPDATE);
    	return printApplicantTableHtml();
    }
    
    public String printApplicantTableHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		boolean canAssesFlag = this.getDbActionMode().equals(Cnstnts.UPDATE)?true:false;

		char newLine = Cnstnts.NEW_LINE;

		if(canAssesFlag) { 
			strBfr.append(newLine + "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.import") + "' onclick='openAppendix(\"QueryCheckForm.jsp?queryClass=ClientApplicant&_queryText2=" + this.getFlowKey() +"&queryText4=" + this.getFlowKey() +"&queryText5=" + this.getFlowKey() + "\",\"Applicants\",800,600)'>");
			strBfr.append(newLine + "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.insert") + "' onclick='openAppendix(\"Applicant.jsp?_pageActionMode=maintain" + "&_dbActionMode=insert&clientIn=true&_client=" + this.getFlowKey() + "\",\"AddApplicant\",800,600)'>");
		}
		
		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Applicant.Nationality")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.Names")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Applicant.IdType")+"</td>";
		String thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.TelNo")+"</td>";
		String thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.Email")+"</td>";
		String thText7="<td align='center' width='35%'>"+this.getUserInfo().getMsg("jsp.Applicant.Address")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='1%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='1%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText7+thText8+"</tr>");
		
		String SQL = "select a.* from Applicant a "+
					 "where a.client='"+this.getFlowKey()+"' "+
					 "and a.ShowInClient ='Y' " + 
					 "and (ApplicantKind like '%CLK01;%' or ApplicantKind like '%CLK06;%' or ApplicantKind like '%CLK07;%') " + 
					 "order by a.FlowKey";
		Applicant applicant = new Applicant();
		applicant.setDbFields();
		List<Field> fieldList = applicant.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		Properties clientPrpt = new Client().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String IdType = Cnstnts.EMPTY_STRING;
			String Address = Cnstnts.EMPTY_STRING;
			String Nationality = Cnstnts.EMPTY_STRING;
			String Names = Cnstnts.EMPTY_STRING;
			String EnglishNames = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String TelNo = Cnstnts.EMPTY_STRING;
			String Email = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("IdType")){
					IdType = field.getValue();
				}
				if(field.getName().equals("Address")){
					Address = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Nationality")){
					Nationality = field.getValue();
				}
				if(field.getName().equals("Names")){
					Names = field.getValue();
				}
				if(field.getName().equals("EnglishNames")){
					EnglishNames = field.getValue();
				}
				if(field.getName().equals("TelNo")){
					TelNo = field.getValue();
				}
				if(field.getName().equals("Email")){
					Email = field.getValue();
				}
			}
			String onClick = " onClick='openAppendix(\"Applicant.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=update&_getDataFlag=true&_pageActionMode=maintain&_modeLockFlag=true"+
			  					"&clientIn=true&_client=" + this.getFlowKey() + "\",\"PatentApplicant\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'"+onClick+">"+categoryPrpt.getProperty(Nationality)+"</td>";
			String tdText3="<td"+onClick+">"+Names+"</td>";
			String tdText4="<td align='center'"+onClick+">"+categoryPrpt.getProperty(IdType)+"</td>";
			String tdText5="<td"+onClick+">"+TelNo+"</td>";
			String tdText6="<td"+onClick+">"+Email+"</td>";
			String tdText7="<td"+onClick+">"+Address+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
				 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+ onClick +
				 		"/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
 						"onClick='javascript:deleteClentApplicant(\"" + this.getFlowKey() + "\",\"" + FlowKey + "\")'/>";
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
    
    public String printApplicantTableHtml2() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		
		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;
		
		String SQL = "select distinct(pi.ApplicantId) as Inventor " +
				"from patentapplicant pi, patentcase p " +
				"where p.Client ='" + this.getFlowKey() + "' " +
				"and pi.parentid = p.flowkey ";
		List<String> inventors = this.getDbUtil().getValueList(SQL, "Inventor");

		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.PatentCase.title") + "<br/>");
		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Applicant.FlowKey")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.Nationality")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Applicant.Names")+"</td>";
		String thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.EnglishNames")+"</td>";
		String thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.IdNo")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText8+"</tr>");
		
		
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		Properties clientPrpt = new Client().getNamesPrpts();
		for(String s : inventors){
			Applicant app = new Applicant(s);
			
			String onClick = " onClick='openAppendix(\"Applicant.jsp?flowKey="+app.getFlowKey()+
			  					"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td"+onClick+">"+s+"</td>";
			String tdText3="<td align='center'>"+categoryPrpt.getProperty(app.getNationality())+"</td>";
			String tdText4="<td>"+app.getNames()+"</td>";
			String tdText5="<td>"+app.getEnglishNames()+"</td>";
			String tdText6="<td>"+app.getIdNo()+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "";
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText8;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");
		
		strBfr.append(newLine + "<br/>");
		SQL = "select distinct(pi.ApplicantId) as Inventor " +
				"from legalapplicant pi, legalcase p " +
				"where p.Client ='" + this.getFlowKey() + "' " +
				"and pi.parentid = p.flowkey ";
		inventors = this.getDbUtil().getValueList(SQL, "Inventor");
		
		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.LegalCase.title") + "<br/>");
		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		thText1=Cnstnts.EMPTY_STRING;
		thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Applicant.FlowKey")+"</td>";
		thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.Nationality")+"</td>";
		thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Applicant.Names")+"</td>";
		thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.EnglishNames")+"</td>";
		thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.IdNo")+"</td>";
		thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText8+"</tr>");
		
		i=0;
		for(String s : inventors){
			Applicant app = new Applicant(s);
			
			String onClick = " onClick='openAppendix(\"Applicant.jsp?flowKey="+app.getFlowKey()+
			  					"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td"+onClick+">"+s+"</td>";
			String tdText3="<td align='center'>"+categoryPrpt.getProperty(app.getNationality())+"</td>";
			String tdText4="<td>"+app.getNames()+"</td>";
			String tdText5="<td>"+app.getEnglishNames()+"</td>";
			String tdText6="<td>"+app.getIdNo()+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "";
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText8;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");
		
		
		strBfr.append(newLine + "<br/>");
		SQL = "select distinct(pi.ApplicantId) as Inventor " +
				"from Trademarkapplicant pi, Trademarkcase p " +
				"where p.Client ='" + this.getFlowKey() + "' " +
				"and pi.parentid = p.flowkey ";
		inventors = this.getDbUtil().getValueList(SQL, "Inventor");
		
		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.TrademarkCase.title") + "<br/>");
		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		thText1=Cnstnts.EMPTY_STRING;
		thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Applicant.FlowKey")+"</td>";
		thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.Nationality")+"</td>";
		thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Applicant.Names")+"</td>";
		thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.EnglishNames")+"</td>";
		thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.IdNo")+"</td>";
		thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText8+"</tr>");
		
		i=0;
		for(String s : inventors){
			Applicant app = new Applicant(s);
			
			String onClick = " onClick='openAppendix(\"Applicant.jsp?flowKey="+app.getFlowKey()+
			  					"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td"+onClick+">"+s+"</td>";
			String tdText3="<td"+onClick+" align='center'>"+categoryPrpt.getProperty(app.getNationality())+"</td>";
			String tdText4="<td"+onClick+">"+app.getNames()+"</td>";
			String tdText5="<td"+onClick+">"+app.getEnglishNames()+"</td>";
			String tdText6="<td"+onClick+">"+app.getIdNo()+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "";
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText8;
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
    
    public String printInventorTableHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.Inventor")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.InventorName")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.EnglishNames")+"</td>";
		String thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.Nationality")+"</td>";
		String thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.IdNo")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText8+"</tr>");
		
		
		
		String SQL = "select distinct(pi.Inventor) as Inventor " +
				"from patentinventor pi, patentcase p " +
				"where p.Client ='" + this.getFlowKey() + "' " +
				"and pi.parentid = p.flowkey ";

		List<String> inventors = this.getDbUtil().getValueList(SQL, "Inventor");
		
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		Properties clientPrpt = new Client().getNamesPrpts();
		for(String s : inventors){
			Applicant app = new Applicant(s);
			
			String onClick = " onClick='openAppendix(\"Applicant.jsp?flowKey="+app.getFlowKey()+
			  					"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td"+onClick+">"+s+"</td>";
			String tdText3="<td"+onClick+">"+app.getNames()+"</td>";
			String tdText4="<td align='center'"+onClick+">"+app.getEnglishNames()+"</td>";
			String tdText5="<td align='center'"+onClick+">"+categoryPrpt.getProperty(app.getNationality())+"</td>";
			String tdText6="<td"+onClick+">"+app.getIdNo()+"</td>";
//			String tdText7="<td"+onClick+">"+app.getEmail()+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "";
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText8;
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
    
    public String printCaseTableHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		//在委辦案件tab列表上方新增一"批次業務移轉"按鈕以及下拉選單（來源為員工），選了之後點該按鈕，列表之案件的業務置換改為所選員工
		this.SalesChangeList.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
		this.SalesChangeList.setSelectList(new Employee().getList());
		
		String html = "<input type='hidden' name='changeSales' id='changeSales'>";
		html += this.printTag(this.SalesChangeList);
		
		html += "<input type=\"button\" id='SalesChangeBtn' " +
				"value=\"" + this.getUserInfo().getMsg("jsp.Client.SalesChangeBtn") + "\" " +
				"onclick=\"changeIncharge();\">";
		
		html += "　　";
		
		//2. 在委辦案件tab列表上方新增一"批次程序移轉"按鈕以及下拉選單（來源為員工），選了之後點該按鈕，列表之案件的 "負責程序" 置換改為所選員工
		this.CaseADChangeList.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
		this.CaseADChangeList.setSelectList(new Employee().getList());
		
		html += "<input type='hidden' name='changeCaseAD' id='changeCaseAD'>";
		html += this.printTag(this.CaseADChangeList);
		
		html += "<input type=\"button\" id='CaseADChangeBtn' " +
				"value=\"" + this.getUserInfo().getMsg("jsp.Client.CaseADChangeBtn") + "\" " +
				"onclick=\"changeCaseADFun();\">";
		
		strBfr.append(newLine + html + "<br/>");
		
		/*
		顯示欄位調整方式改為和申請人一樣，專利、商標、法務各分開一個表格，
		顯示欄位調整為：案件種類（專利類別：如PNxx、商標種類:如TTxx、案件種類：如MainTxx）、
		案件編號、申請國家、案件名稱、案件狀態
		 */
		//同一類案件 若超過四筆，不呈現所有清單， 請呈現 more 選項，點了之後另開視窗。
		strBfr.append(newLine + generateCaseTable("P"));
		strBfr.append(newLine + "<br/>");
		
		strBfr.append(newLine + generateCaseTable("T"));
		strBfr.append(newLine + "<br/>");
		
		strBfr.append(newLine + generateCaseTable("L"));
		strBfr.append(newLine + "<br/>");
		
		strBfr.append(newLine + generateCaseTable("C"));
		strBfr.append(newLine + "<br/>");
		
//		String countSQL = "select count(1) as count from patentcase p where p.client = '" + this.getFlowKey() + "' ";
//		int count = this.getDbUtil().getSqlIntValue(countSQL, "count");
//		String SQL = "select 'P' as C, p.FlowKey, p.PatentType as CaseType, p.PatentOffice as Office, " +
//				"	p.PatentType as SubType, p.Title, p.Status from patentcase p where p.client = '" + this.getFlowKey() + "' ";
//		
//		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.PatentCase.title"));
//		
//		String onClick = " onClick='openAppendix(\"Client.jsp?flowKey="+this.getFlowKey()+
//				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain&showCase=true&caseType=P"+
//				"\",\"Client\",800,600)' style='cursor:hand'";
//		if(count > 4) {
//			strBfr.append(onClick);
//		}
//		strBfr.append("<br/>");
//		
//		if(count <= 4) {
//			strBfr.append(generateCaseTable("P"));
//		}
//		strBfr.append(newLine + "<br/>");
//		
//		SQL = "select 'L' as C, p.FlowKey, p.MainType as CaseType, '' as Office, " +
//				"	p.SubType as SubType, p.Title, p.Status from legalcase p  where p.client = '" + this.getFlowKey() + "' ";
//		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.LegalCase.title") + "<br/>");
//		strBfr.append(generateCaseTable(SQL));
//		
//		strBfr.append(newLine + "<br/>");
//		
//		SQL = "select 'T' as C, p.FlowKey, p.TrademarkType as CaseType, p.Office as Office, " +
//				"	p.TrademarkType as SubType, p.Title, p.Status from trademarkcase p  where p.client = '" + this.getFlowKey() + "'";
//		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.TrademarkCase.title") + "<br/>");
//		strBfr.append(generateCaseTable(SQL));
//		
//		strBfr.append(newLine + "<br/>");
//		
//		SQL = "select 'C' as C, p.FlowKey, p.MainType as CaseType, p.Office as Office, " +
//				"	p.SubType as SubType, p.Title, p.Status from CopyrightCase p  where p.client = '" + this.getFlowKey() + "'";
//		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.CopyrightCase.title") + "<br/>");
//		strBfr.append(generateCaseTable(SQL));

		return strBfr.toString();
	}
        
    public String generateCaseTable(String caseType) throws Exception {
    	StringBuffer strBfr = new StringBuffer();
    	
		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		DB db = new DB();
    	String sql = "";
    	String countSQL = "";
    	if(Util.compareTo(caseType, "P")) {
    		countSQL = "select count(1) as count from patentcase p where p.client = '" + this.getFlowKey() + "' ";
    		int count = this.getDbUtil().getSqlIntValue(countSQL, "count");
    		int limit = count;
    		if(count > 4) {
    			limit = 4;
    		}
    		
    		sql = "select 'P' as C, p.CaseNo, p.flowkey, p.PatentType as CaseType, p.PatentOffice as Office, " +
    				"	p.PatentType as SubType, p.Title, p.Status from patentcase p " +
    				"where p.client = '" + this.getFlowKey() + "' limit 0, " + limit;
    		if(db.DBTYPE.equals(Cnstnts.MSSQL)) {
    			sql = "select top " + limit + " 'P' as C, p.CaseNo, p.flowkey, p.PatentType as CaseType, p.PatentOffice as Office, " +
        				"	p.PatentType as SubType, p.Title, p.Status from patentcase p " +
        				"where p.client = '" + this.getFlowKey() + "'";
    		}
    		
    		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.PatentCase.title"));
    		
    		String onClick = " onClick='openAppendix(\"ClientCase.jsp?flowKey="+this.getFlowKey()+
    				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain&caseType=P"+
    				"\",\"ClientCase\",800,600)' style='cursor:hand'";
    		
    		String btn = "<input type='submit' style='cursor: hand' " +
				   	   "value=' More... ' " +
				   	   " " + onClick + "/>";
    		
    		if(count > 4) {
    			strBfr.append(btn);
    		}
    		
    		if(count > 0) {
	    		onClick = " onClick='openAppendix(\"ConnectList.jsp?flowKey="+this.getFlowKey()+
	    				"&_dbActionMode=query&_pageActionMode=search&caseType=P&client="+this.getFlowKey() +
	    				"\",\"ConnectList\",600,600)' style='cursor:hand'";
	    		
	    		btn = "<input type='button' style='cursor: hand' " +
					   	   "value='" + this.getUserInfo().getMsg("jsp.common.exportCsv") + "' " +
					   	   " " + onClick + "/>";
	    		strBfr.append(btn);
    		}
    		
    		strBfr.append("<br/>");
    	}
    	else if(Util.compareTo(caseType, "L")) {
    		countSQL = "select count(1) as count from legalcase p where p.client = '" + this.getFlowKey() + "' ";
    		int count = this.getDbUtil().getSqlIntValue(countSQL, "count");
    		System.out.println(count + " " + countSQL);
    		int limit = count;
    		if(count > 4) {
    			limit = 4;
    		}
    		
    		sql = "select 'L' as C, p.CaseNo, p.flowkey, p.MainType as CaseType, '' as Office, " +
    				"	p.SubType as SubType, p.Title, p.Status from legalcase p  " +
    				"where p.client = '" + this.getFlowKey() + "' limit 0, " + limit;
    		if(db.DBTYPE.equals(Cnstnts.MSSQL)) {
    			sql = "select top " + limit + " 'L' as C, p.CaseNo, p.flowkey, p.MainType as CaseType, '' as Office, " +
    				"	p.SubType as SubType, p.Title, p.Status from legalcase p  " +
    				"where p.client = '" + this.getFlowKey() + "'";
    		}
    		
    		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.LegalCase.title"));
    		

    		String onClick = " onClick='openAppendix(\"ClientCase.jsp?flowKey="+this.getFlowKey()+
    				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain&caseType=L"+
    				"\",\"ClientCase\",800,600)' style='cursor:hand'";
    		
    		String btn = "<input type='submit' style='cursor: hand' " +
				   	   "value=' More... ' " +
				   	   " " + onClick + "/>";
    		
    		if(count > 4) {
    			strBfr.append(btn);
    		}
    		
    		if(count > 0) {
	    		onClick = " onClick='openAppendix(\"ConnectList.jsp?flowKey="+this.getFlowKey()+
	    				"&_dbActionMode=query&_pageActionMode=search&caseType=L&client="+this.getFlowKey() +
	    				"\",\"ConnectList\",600,600)' style='cursor:hand'";
	    		
	    		btn = "<input type='button' style='cursor: hand' " +
					   	   "value='" + this.getUserInfo().getMsg("jsp.common.exportCsv") + "' " +
					   	   " " + onClick + "/>";
	    		
	    		strBfr.append(btn);
    		}
    		
    		strBfr.append("<br/>");
    	}
    	else if(Util.compareTo(caseType, "T")) {
    		countSQL = "select count(1) as count from trademarkcase p where p.client = '" + this.getFlowKey() + "' ";
    		int count = this.getDbUtil().getSqlIntValue(countSQL, "count");
    		int limit = count;
    		if(count > 4) {
    			limit = 4;
    		}
    		
    		sql = "select 'T' as C, p.CaseNo, p.flowkey, p.TrademarkType as CaseType, p.Office as Office, " +
    				"	p.TrademarkType as SubType, p.Title, p.Status from trademarkcase p " +
    				"where p.client = '" + this.getFlowKey() + "' limit 0, " + limit;

    		if(db.DBTYPE.equals(Cnstnts.MSSQL)) {
    			sql = "select top " + limit + " 'T' as C, p.CaseNo, p.flowkey, p.TrademarkType as CaseType, p.Office as Office, " +
    				"	p.TrademarkType as SubType, p.Title, p.Status from trademarkcase p " +
    				"where p.client = '" + this.getFlowKey() + "'";
    		}
    		
    		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.TrademarkCase.title"));
    		

    		String onClick = " onClick='openAppendix(\"ClientCase.jsp?flowKey="+this.getFlowKey()+
    				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain&caseType=T"+
    				"\",\"ClientCase\",800,600)' style='cursor:hand'";
    		
    		String btn = "<input type='submit' style='cursor: hand' " +
				   	   "value=' More... ' " +
				   	   " " + onClick + "/>";
    		
    		if(count > 4) {
    			strBfr.append(btn);
    		}
    		
    		if(count > 0) {
	    		onClick = " onClick='openAppendix(\"ConnectList.jsp?flowKey="+this.getFlowKey()+
	    				"&_dbActionMode=query&_pageActionMode=search&caseType=T&client="+this.getFlowKey() +
	    				"\",\"ConnectList\",600,600)' style='cursor:hand'";
	    		
	    		btn = "<input type='button' style='cursor: hand' " +
					   	   "value='" + this.getUserInfo().getMsg("jsp.common.exportCsv") + "' " +
					   	   " " + onClick + "/>";
	    		strBfr.append(btn);
    		}
    		
    		strBfr.append("<br/>");
    	}
    	else if(Util.compareTo(caseType, "C")) {
    		countSQL = "select count(1) as count from CopyrightCase p where p.client = '" + this.getFlowKey() + "' ";
    		int count = this.getDbUtil().getSqlIntValue(countSQL, "count");
    		int limit = count;
    		if(count > 4) {
    			limit = 4;
    		}
    		
    		sql = "select 'C' as C, p.CaseNo, p.flowkey, p.MainType as CaseType, p.Office as Office, " +
    				"	p.SubType as SubType, p.Title, p.Status from CopyrightCase p " +
    				"where p.client = '" + this.getFlowKey() + "' limit 0, " + limit;

    		if(db.DBTYPE.equals(Cnstnts.MSSQL)) {
    			sql = "select top " + limit + " 'C' as C, p.CaseNo, p.flowkey, p.MainType as CaseType, p.Office as Office, " +
    				"	p.SubType as SubType, p.Title, p.Status from CopyrightCase p " +
    				"where p.client = '" + this.getFlowKey() + "'";
    		}
    		strBfr.append(newLine + this.getUserInfo().getMsg("jsp.CopyrightCase.title"));
    		

    		String onClick = " onClick='openAppendix(\"ClientCase.jsp?flowKey="+this.getFlowKey()+
    				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain&caseType=C"+
    				"\",\"ClientCase\",800,600)' style='cursor:hand'";
    		
    		String btn = "<input type='submit' style='cursor: hand' " +
				   	   "value=' More... ' " +
				   	   " " + onClick + "/>";
    		
    		if(count > 4) {
    			strBfr.append(btn);
    		}
    		
    		if(count > 0) {
	    		onClick = " onClick='openAppendix(\"ConnectList.jsp?flowKey="+this.getFlowKey()+
	    				"&_dbActionMode=query&_pageActionMode=search&caseType=C&client="+this.getFlowKey() +
	    				"\",\"ConnectList\",600,600)' style='cursor:hand'";
	    		
	    		btn = "<input type='button' style='cursor: hand' " +
					   	   "value='" + this.getUserInfo().getMsg("jsp.common.exportCsv") + "' " +
					   	   " " + onClick + "/>";
	    		strBfr.append(btn);
    		}
    		strBfr.append("<br/>");
    	}
		
    	strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentCase.PatentCaseType")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentCase.CaseNo")+"</td>";
		String thText4="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentCase.PatentOffice")+"</td>";
		String thText5="<td align='center' width='25%'>"+this.getUserInfo().getMsg("jsp.LegalCase.Title")+"</td>";
		String thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentCase.Status")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText8+"</tr>");
		
		
		List<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("CaseNo", "CaseNo"));
		fieldList.add(new Field("FlowKey", "FlowKey"));
		fieldList.add(new Field("CaseType", "CaseType"));
		fieldList.add(new Field("Office", "Office"));
		fieldList.add(new Field("SubType", "SubType"));
		fieldList.add(new Field("Title", "Title"));
		fieldList.add(new Field("Status", "Status"));
		fieldList.add(new Field("C", "C"));
		List<List<Field>> findList = this.getDbUtil().getFieldsList(sql, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String CaseType = Cnstnts.EMPTY_STRING;
			String Office = Cnstnts.EMPTY_STRING;
			String CaseNo = Cnstnts.EMPTY_STRING;
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
				if(field.getName().equals("CaseNo")){
					CaseNo = field.getValue();
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
			else if(Util.compareTo(C, "C")) {
				onClick = " onClick='openAppendix(\"CopyrightCase.jsp?flowKey="+FlowKey+
				"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
					"\",\"CopyrightCase\",800,600)' style='cursor:hand'";
			}
			  					
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'"+onClick+">"+categoryPrpt.getProperty(CaseType)+"</td>";
			String tdText3="<td"+onClick+">"+CaseNo+"</td>";
			String tdText4="<td align='center'"+onClick+">"+categoryPrpt.getProperty(Office)+"</td>";
			String tdText5="<td"+onClick+">"+Title+"</td>";
			String tdText6="<td align='center'"+onClick+">"+categoryPrpt.getProperty(Status)+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "";
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText8;
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
    
    
    
    //20120508客戶資料增加服務專案清單Tab
    public String printServiceProjectTableHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.ServiceProject.FlowKey")+"</td>";
		String thText3="<td align='center' width='40%'>"+this.getUserInfo().getMsg("jsp.ServiceProject.Title")+"</td>";
		String thText4="<td align='center' width='11%'>"+this.getUserInfo().getMsg("jsp.ServiceProject.ServiceTypeMain")+"</td>";
		String thText5="<td align='center' width='11%'>"+this.getUserInfo().getMsg("jsp.ServiceProject.ProjectStartDate")+"</td>";
		String thText6="<td align='center' width='11%'>"+this.getUserInfo().getMsg("jsp.ServiceProject.DueDate")+"</td>";
		String thText7="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.ServiceProject.Status")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText7+thText8+"</tr>");
		
		String SQL = "select FlowKey, Title, ServiceTypeMain, ProjectStartDate, DueDate, Status " +
					"from ServiceProject where Client = '" + this.getFlowKey() + "' ";
		List<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("FlowKey", "FlowKey"));
		fieldList.add(new Field("Title", "Title"));
		fieldList.add(new Field("ServiceTypeMain", "ServiceTypeMain"));
		fieldList.add(new Field("ProjectStartDate", "ProjectStartDate"));
		fieldList.add(new Field("DueDate", "DueDate"));
		fieldList.add(new Field("Status", "Status"));
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String FlowKey = Cnstnts.EMPTY_STRING;
			String Title = Cnstnts.EMPTY_STRING;
			String ServiceTypeMain = Cnstnts.EMPTY_STRING;
			String StartDate = Cnstnts.EMPTY_STRING;
			String DueDate = Cnstnts.EMPTY_STRING;
			String Status = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Title")){
					Title = field.getValue();
				}
				if(field.getName().equals("ServiceTypeMain")){
					ServiceTypeMain = field.getValue();
				}
				if(field.getName().equals("StartDate")){
					StartDate = field.getValue();
				}
				if(field.getName().equals("DueDate")){
					DueDate = field.getValue();
				}
				if(field.getName().equals("Status")){
					Status = field.getValue();
				}
			}
			String onClick = "";
			
			onClick = " onClick='openAppendix(\"ServiceProject.jsp?flowKey="+FlowKey+
			"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
				"\",\"ServiceProject\",800,600)' style='cursor:hand'";
			
			
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td"+onClick+">"+FlowKey+"</td>";
			String tdText3="<td"+onClick+">"+Title+"</td>";
			String tdText4="<td align='center'"+onClick+">"+categoryPrpt.getProperty(ServiceTypeMain)+"</td>";
			String tdText5="<td align='center'"+onClick+">"+StartDate+"</td>";
			String tdText6="<td align='center'"+onClick+">"+DueDate+"</td>";
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
    
    public String printNotYetWriteOffInvoiceTableHtml() throws Exception {
		StringBuffer strBfr = new StringBuffer();

		boolean canAssesFlag = false;

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Invoice.CaseNo")+"</td>";
		String thText3="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.Invoice.Title")+"</td>";
		String thText4="<td align='center' width='25%'>"+this.getUserInfo().getMsg("jsp.Invoice.TaskDescription")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Invoice.AmountReceivable")+"</td>";
		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Invoice.TotalWriteOffAmount")+"</td>";
		String thText7="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Invoice.TotalWithHolding")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText7+thText8+"</tr>");
		
		String SQL = "select i.FlowKey as FlowKey, i.CaseNo as CaseNo, i.Title as Title, i.TaskDescription as TaskDescription" +
					", i.TotalRequestPayNtdAmount as TotalRequestPayNtdAmount, i.TotalWriteOffAmount as TotalWriteOffAmount," +
					" i.AmountReceivable, " +
					" ROUND(" + DB.SQL_IFNULL + "(ids.TWHAmount,0),0) as TotalWithHolding from Invoice i " +
					" left join (select id.parentid,sum(id.Tax2) as TWHAmount from invoicedetail id" +
					" where id.WithHolding='Y' group by id.parentid) as ids on i.FlowKey= ids.parentid " +
					" where client = '" + this.getFlowKey() + "' and " +
					"(i.TotalRequestPayNtdAmount - i.TotalWriteOffAmount - " + DB.SQL_IFNULL + "(ids.TWHAmount,0) - i.TotalDiscountAmount ) != 0";
					
		List<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("FlowKey", "FlowKey"));
		fieldList.add(new Field("CaseNo", "CaseNo"));
		fieldList.add(new Field("Title", "Title"));
		fieldList.add(new Field("TaskDescription", "TaskDescription"));
		fieldList.add(new Field("TotalRequestPayNtdAmount", "TotalRequestPayNtdAmount"));
		fieldList.add(new Field("TotalWriteOffAmount", "TotalWriteOffAmount"));
		fieldList.add(new Field("TotalWithHolding", "TotalWithHolding"));
		fieldList.add(new Field("AmountReceivable", "AmountReceivable"));
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties categoryPrpt = new Category().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String FlowKey = Cnstnts.EMPTY_STRING;
			String CaseNo = Cnstnts.EMPTY_STRING;
			String Title = Cnstnts.EMPTY_STRING;
			String TaskDescription = Cnstnts.EMPTY_STRING;
			String TotalRequestPayNtdAmount = Cnstnts.EMPTY_STRING;
			String TotalWriteOffAmount = Cnstnts.EMPTY_STRING;
			String TotalWithHolding = Cnstnts.EMPTY_STRING;
			String AmountReceivable = "";
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("AmountReceivable")){
					AmountReceivable = field.getValue();
				}
				if(field.getName().equals("CaseNo")){
					CaseNo = field.getValue();
				}
				if(field.getName().equals("Title")){
					Title = field.getValue();
				}
				if(field.getName().equals("TaskDescription")){
					TaskDescription = field.getValue();
				}
				if(field.getName().equals("TotalRequestPayNtdAmount")){
					TotalRequestPayNtdAmount = field.getValue();
				}
				if(field.getName().equals("TotalWriteOffAmount")){
					TotalWriteOffAmount = field.getValue();
				}
				if(field.getName().equals("TotalWithHolding")){
					TotalWithHolding = field.getValue();
				}
			}
			String onClick = "";
			
			onClick = " onClick='openAppendix(\"Invoice.jsp?flowKey="+FlowKey+
			"&_dbActionMode=query&_getDataFlag=true&_pageActionMode=maintain"+
				"\",\"Invoice\",800,600)' style='cursor:hand'";
			  					
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'"+onClick+">"+CaseNo+"</td>";
			String tdText3="<td "+onClick+">"+Title+"</td>";
			String tdText4="<td "+onClick+">"+TaskDescription+"</td>";
			String tdText5="<td align='center'"+onClick+">"+AmountReceivable+"</td>";
			String tdText6="<td align='center'"+onClick+">"+TotalWriteOffAmount+"</td>";
			String tdText7="<td align='center'"+onClick+">"+TotalWithHolding+"</td>";
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
    
    @SuppressWarnings("unchecked")
    private String printCaseDetail() throws Exception{
    	if(this.getFlowKey().trim().length()==0){
			return Cnstnts.EMPTY_STRING;
		}
    	String SQL = "select * from PatentCase where Client='"+this.FlowKey.getValue()+"'";
    	PatentCase patentCaseData = new PatentCase();
    	patentCaseData.setDbFields();
		List<List<Field>> dataLst = patentCaseData.getDbUtil().getFieldsList(
					SQL, patentCaseData.getDbFields());
		if(dataLst.size()==0){
			return Cnstnts.EMPTY_STRING;
		}
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine+"<tr><td colspan='4'>";
		rtnString += newLine+"  <table"+Cnstnts.DEFAULT_TABLE_BGCOLOR+">";
		
        rtnString += newLine+"    <tr><td colspan='5'><font size='3'><b>"+
        			 this.getUserInfo().getMsg("jsp.Client.PatentCaseList")+"</b></font></td></tr>";
        rtnString += newLine+"    <tr"+this.getThBgcolor()+">"+
        							"<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentCase.FlowKey")+"</td>"+
        							"<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentCase.PatentOffice")+"</td>"+
        							"<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentCase.PatentType")+"</td>"+
        							"<td align='center' width='40%'>"+this.getUserInfo().getMsg("jsp.PatentCase.Title")+"</td>"+
        							"<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.PatentCase.Status")+"</td>"+
        						  "</tr>";
		int i = 0;
		Properties categoryPrpt = new Category().getNamesPrpts();
        for(Iterator itr=dataLst.iterator(); itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String FlowKey = Cnstnts.EMPTY_STRING,
				   PatentOffice = Cnstnts.EMPTY_STRING,
				   PatentType = Cnstnts.EMPTY_STRING,
				   Title = Cnstnts.EMPTY_STRING,
				   Status = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator();fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("PatentOffice")){
					PatentOffice = categoryPrpt.getProperty(field.getValue());
				}
				if(field.getName().equals("PatentType")){
					PatentType = categoryPrpt.getProperty(field.getValue());
				}
				if(field.getName().equals("Title")){
					Title = field.getValue();
				}
				if(field.getName().equals("Status")){
					Status = categoryPrpt.getProperty(field.getValue());
				}
			}
			String trBgcolor;
            if(i%2==0) {
            	trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
            } else {
            	trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
            }
			rtnString += newLine+"    <tr"+trBgcolor+" style='cursor: hand'"+
										" onClick='openAppendix(\"PatentCase.jsp?_getDataFlag=true"+
										"&_dbActionMode=query&_modeLockFlag=true&_pageActionMode=maintain"+
										"&_flowKey="+FlowKey+"\",\"showForm\",800,600)'>"+
										"<td align='center'>"+FlowKey+"</td>"+
										"<td>"+PatentOffice+"</td>"+
										"<td>"+PatentType+"</td>"+
										"<td>"+Title+"</td>"+
										"<td>"+Status+"</td>"+
									 "</tr>";
		}
        rtnString += newLine+"  </table>";
        rtnString += newLine+"  </td></tr>";
        return rtnString;
    }

    public void setSearchListPrpts() {
    	this.FlowKey.setListWidth("7%");
    	
    	this.GroupName.setListWidth("10%");
    	
        this.CompanyName.setListWidth("12%");
        
        this.Sponsor.setListWidth("7%");
        this.Sponsor.setNotShowCode(true);
        try {
			this.Sponsor.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        this.ClientContect.setListWidth("7%");
        
        this.CaseAD .setListWidth("10%");
        this.CaseAD.setNotShowCode(true);
        try {
			this.CaseAD.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
//        this.Tel1.setListWidth("8%");
                
        this.Nationality.setListWidth("6%");
        this.Nationality.setNotShowCode(true);
        try {
			this.Nationality.setMapingPrpt(new Category().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		this.Identity.setListWidth("6%");
		this.Identity.setNotShowCode(true);
		try {
			this.Identity.setMapingPrpt(new Category().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		Properties clientCaseDatePrpt = new Properties();
//		String SQL = "select a.FlowKey as FlowKey, max( a.CreateTime ) as CreateTime from (" +
//				"select Client as FlowKey, substr(CreateTime,1,10) as CreateTime  from PatentCase where Client!='' and (CreateTime is not null and CreateTime != '') " +
//				"union " +
//				"select Client as FlowKey, substr(AttorneyDate,1,10) as CreateTime  from TrademarkCase where Client!='' and (AttorneyDate is not null and AttorneyDate != '')" +
//				"union " +
//				"select Client as FlowKey, substr(TargetStartDate,1,10) as CreateTime  from LegalCase where Client!='' and (TargetStartDate is not null and TargetStartDate != '')" +
//				") a group by a.FlowKey";// +
//				//" order by CreateTime desc";
//		try {
//			clientCaseDatePrpt = this.getDbUtil().getFieldPrpts(SQL, "CreateTime");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		this.LastCaseDate.setListWidth("8%");
//		this.LastCaseDate.setNotShowCode(true);
//		this.LastCaseDate.setMapingPrpt(clientCaseDatePrpt);
		
        Properties BillingContactPrpt = new Properties();
		String sql = "select a.flowkey, concat(a.Department, ' ' , a.Names, ' ', a.Title) as Name2 from applicant a ";
		if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
			sql = "select a.flowkey, (a.Department+' '+a.Names+' '+a.Title) as Name2 from applicant a ";
		}
		try {
			BillingContactPrpt = this.getDbUtil().getFieldPrpts(sql, "Name2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.BillingContact .setListWidth("10%");
        this.BillingContact.setNotShowCode(true);
        this.BillingContact.setMapingPrpt(BillingContactPrpt);

		this.ClientContect .setListWidth("10%");
        this.ClientContect.setNotShowCode(true);
        this.ClientContect.setMapingPrpt(BillingContactPrpt);
        
        Properties InvoiceTitlePrpt = new Properties();
		sql = "select FlowKey, InvoiceTitle from invtitle ";
		try {
			InvoiceTitlePrpt = this.getDbUtil().getFieldPrpts(sql, "InvoiceTitle");
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.InvoiceTitle1 .setListWidth("10%");
        this.InvoiceTitle1.setNotShowCode(true);
        this.InvoiceTitle1.setMapingPrpt(InvoiceTitlePrpt);
        
//        Properties RegisteredNoPrpt = new Properties();
//		sql = "select FlowKey, RegisteredNo from invtitle ";
//		try {
//			RegisteredNoPrpt = this.getDbUtil().getFieldPrpts(sql, "RegisteredNo");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        this.RegisteredNo .setListWidth("10%");
//        this.RegisteredNo.setNotShowCode(false);
//        this.RegisteredNo.setMapingPrpt(RegisteredNoPrpt);
		
		this.TotalCase.setListWidth("4%");
		this.TotalCase.setAlign(Cnstnts.RIGHT);

		this.EnglishCompanyName.setListWidth("12%");

		this.Attorney.setListWidth("4%");
		try {
			this.Attorney.setMapingPrpt(Util.getBooleanImgProp());
	        this.Attorney.setNotShowCode(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        Field[] showField = {this.FlowKey, this.GroupName, this.CompanyName, this.EnglishCompanyName, 
        		this.Sponsor, this.CaseAD, this.ClientContect, 
        		this.BillingContact, this.InvoiceTitle1};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        
        //whereStr = Util.addWhereSQL(whereStr, this.Address1);
        whereStr = Util.addWhereSQL(whereStr, this.Category);
        whereStr = Util.addWhereSQL(whereStr, this.CompanyName);
        whereStr = Util.addWhereSQL(whereStr,this.InCharge);
        whereStr = Util.addWhereSQL(whereStr, this.Sponsor);
        whereStr = Util.addWhereSQL(whereStr, this.Contact);
        whereStr = Util.addWhereSQL(whereStr, this.Identity);
        whereStr = Util.addWhereSQL(whereStr, this.GroupName);
        whereStr = Util.addWhereSQL(whereStr, this.CompanyName);
        whereStr = Util.addWhereSQL(whereStr, this.EnglishCompanyName);
        whereStr = Util.addWhereSQL(whereStr, this.CaseAD);
        if(Util.compareTo(this.getDatalack(), "Y")) {
        	if(whereStr.indexOf("where") != -1) {
        		whereStr += " and Datalack = 'Y' ";
        	}
        	else {
        		whereStr += " where Datalack = 'Y' ";
        	}
        }if(!Util.isEmpty(this.getAddressSearch())) {
        	if(whereStr.indexOf("where") != -1) {
        		whereStr += " and (address1 like '%" + this.getAddressSearch() + "%' or address2 like '%" + this.getAddressSearch() + "%' or englishaddress2 like '%" + this.getAddressSearch() + "%' or EnglishAddress1 like '%" + this.getAddressSearch() + "%')";
        	}
        	else {
        		whereStr += " where (address1 like '%" + this.getAddressSearch() + "%' or address2 like '%" + this.getAddressSearch() + "%' or englishaddress2 like '%" + this.getAddressSearch() + "%' or EnglishAddress1 like '%" + this.getAddressSearch() + "%')";
        	}
        }
        if(!Util.isEmpty(this.getTel1())) {
        	if(whereStr.indexOf("where") != -1) {
        		whereStr += " and (tel1 like '%" + this.getTel1() + "%' or tel2 like '%" + this.getTel1() + "%')";
        	}
        	else {
        		whereStr += " where (tel1 like '%" + this.getTel1() + "%' or tel2 like '%" + this.getTel1() + "%')";
        	}
        }
        if(!Util.isEmpty(this.getContact())) {
        	String sqll = "select client FROM applicant WHERE ShowInClient = 'Y' " + 
        			"and (ApplicantKind like '%CLK01;%' or ApplicantKind like '%CLK06;%' or ApplicantKind like '%CLK07;%') " + 
        			"and Names like '%" + this.getContact() + "%'";
        	List<String> keys = this.getDbUtil().getValueList(sqll, "client");
        	if(whereStr.indexOf("where") != -1) {
        		whereStr += " and FlowKey in (" + Util.arrayToIncond(keys.toArray())  + ")";
        	}
        	else {
        		whereStr += " where FlowKey in (" + Util.arrayToIncond(keys.toArray())  + ")";
        	}
        }
        if(!Util.isEmpty(this.getRegisteredNo())) {
//        	if(whereStr.indexOf("where") != -1) {
//        		whereStr += " and (RegisteredNo like '%" + this.getRegisteredNo() + 
//        					"%' or RegisteredNo2 like '%" + this.getRegisteredNo() + "%')";
//        	}
//        	else {
//        		whereStr += " where (RegisteredNo like '%" + this.getRegisteredNo() + 
//        					"%' or RegisteredNo2 like '%" + this.getRegisteredNo() + "%')";
//        	}
        	if(whereStr.indexOf("where") != -1) {
        		whereStr += " and (invoicetitle1 in (select i.flowkey from invtitle i where i.RegisteredNo like '%" + this.getRegisteredNo() + "%'))";
        	}
        	else {
        		whereStr += " where (invoicetitle1 in (select i.flowkey from invtitle i where i.RegisteredNo like '%" + this.getRegisteredNo() + "%'))";
        	}
        	
        }
        
        //職稱為業務的員工，在報價資料中新增資料，只能新增客戶之所屬業務欄位=自己的 或者空白的
        /*
		String title = this.getUserInfo().getAttribute("title");
		String isSales = "false";
		if(title.equals("JA99") || title.equals("JA07")) {
			isSales = "true";
		}
		if(Util.compareTo(isSales, "true")) {
			if (whereStr.length() > 0) {
				whereStr += " and (c.Sponsor = '' or c.Sponsor is null or c.Sponsor = '" + this.getUserInfo().getAttribute("emp_id") + "')";
			} else {
				whereStr = " where (c.Sponsor = '' or c.Sponsor is null or c.Sponsor = '" + this.getUserInfo().getAttribute("emp_id") + "')";
			}
		}
		*/
//        whereStr = this.getDataAuthorityWhereSQL(whereStr);
        

        /*
		針對.報價單、內部訂單、客戶資料、聯絡人
		四個功能去寫死讓業務和業助欄位可以進行檢視、編輯。so 僅檢視
		 */
		String whereStr2 = "";
		
		whereStr2 = this.getDataAuthorityWhereSQL(whereStr2);

		if (!this.getUserInfo().canQueryAll(this.getProgramId())) {
//			whereStr2 = whereStr2.replace("where", "where (") + " or" +
//					" p.incharge = '" + this.getUserInfo().getAttribute("emp_id") + "') ";
			if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
				whereStr2 = whereStr2.replace("where", "where (") + " or c.Sponsor = '" + this.getUserInfo().getAttribute("emp_id") + "' " +
						" or c.SponsorAssistant like '%;" +this.getUserInfo().getAttribute("emp_id") + ";%' " + 
						" or c.SponsorAssistant like '" + this.getUserInfo().getAttribute("emp_id") + ";%' ) ";
			}
			else {
				whereStr2 = whereStr2.replace("where", "where (") + " or c.Sponsor = '" + this.getUserInfo().getAttribute("emp_id") + "' " +
						" or c.SponsorAssistant REGEXP '(;" +this.getUserInfo().getAttribute("emp_id") + ";)|(^" + this.getUserInfo().getAttribute("emp_id") + ";)' ) ";
			}
		}
		
		if(whereStr2.indexOf("where") == -1) {
			whereStr2 += whereStr;
		}
		else if(whereStr2.indexOf("where") != -1 && whereStr.indexOf("where") != -1) {
			whereStr2 += " and " + whereStr.replaceFirst("where", " ");
		}

//		if (!this.getUserInfo().canQueryAll(this.getProgramId())) {
//			if (whereStr.indexOf("where") != -1) {
//				whereStr += " or c.Sponsor = '" + this.getUserInfo().getAttribute("emp_id") + "' " +
//						" or c.SponsorAssistant REGEXP '(;" +this.getUserInfo().getAttribute("emp_id") + ";)|(^" + this.getUserInfo().getAttribute("emp_id") + ";)'";
//			} else {
//				whereStr += " where c.Sponsor = '" + this.getUserInfo().getAttribute("emp_id") + "' " +
//						" or c.SponsorAssistant REGEXP '(;" +this.getUserInfo().getAttribute("emp_id") + ";)|(^" + this.getUserInfo().getAttribute("emp_id") + ";)'";;
//			}
//		}

        String SQL = Cnstnts.EMPTY_STRING;
        String unionSql = "select c.client, count(c.client) as TotalCase from (" +
				"select p.flowkey, p.client from patentcase p union select l.flowkey, l.client from legalcase l union select t.flowkey, t.client from trademarkcase t" +
				") as c where c.client !='' group by c.client ";
		SQL = "select c.Flowkey as LastCaseDate, CaseTotal.TotalCase, " +
//				"(SELECT GROUP_CONCAT( Names SEPARATOR  ';' ) as contact FROM applicant WHERE ShowInClient = 'Y' " + 
//				"and (ApplicantKind like '%CLK01;%' or ApplicantKind like '%CLK06;%' or ApplicantKind like '%CLK07;%') " +
//				"and client = c.flowkey) as contact2, " +
				"'' as contact2, " +
				"i.RegisteredNo, c.* from Client c "+
			  "left join (" + unionSql + ") as CaseTotal on c.FlowKey=CaseTotal.client " +
			  "left join invtitle i on i.flowkey = c.invoicetitle1 " + 
			  whereStr2.replaceAll("Applicant", "c.Applicant").replaceAll("FlowKey", "c.FlowKey").replaceAll("CreateDept", "c.CreateDept");
        SQL = Util.addOrderSQL(SQL, this.getOrderKey(), this.getOrderSequence());
        System.out.println(SQL);
        return this.doSearch(SQL);
    }
    
    public List<Object[]> doSearch(String SQL) throws Exception{
    	if(this.getPageNo()==0){
  	  		this.setPageNo(1);
  	  	}
        int recordCount=0;
        
  	  	int contact2Index = 0;
	  	boolean hascontact2 = false;

	  	for(int i=0;i<this.getShowField().length;i++) {
	  		Field field = this.getShowField()[i];
//	  		if(field.getName().equals(this.Contact2.getName())) {
//	  			hascontact2 = true;
//	  			contact2Index = i + 1;
//	  		}
	  	}
        
        List<Object[]> rtnList = new ArrayList<Object[]>();
        
        Iterator itr = this.getDbUtil().getList(SQL, this.getShowField()).iterator();
        while(itr.hasNext()){
      	  Object[] record = (Object[])itr.next();
      	  recordCount++;
      	  if(recordCount<=this.getPageNo()*this.getPageRecords()
      			  && recordCount>(this.getPageNo()-1)*this.getPageRecords()){
//	      		if (hascontact2) {
//	      			String sql = "SELECT Names "
//	      				+ "FROM applicant WHERE ShowInClient = 'Y' "
//	      				+ "and (ApplicantKind like '%CLK01;%' or ApplicantKind like '%CLK06;%' "
//	      				+ "or ApplicantKind like '%CLK07;%') "
//	      				+ "and client = '" + record[0].toString() +  "'";
//	      			String value = "";
//	      			List<String> names = this.getDbUtil().getValueList(sql, "names");
//	      			for(String name : names) {
//	      				value += name + ";";
//	      			}
//	      			record[contact2Index] = value;
//	      		}
      		  rtnList.add(record);
      	  }
        }
        this.setFindRecords(recordCount);
        return rtnList;
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.CompanyName);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null &&
        		userInfo.getObj(this.getTableName()) instanceof Client) {
            Client preObj = (Client) userInfo.getObj(this.getTableName());
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
    	 * 客戶編碼邏輯 AAXX  (AA為自定的兩個英文代碼, XX為此英文代碼的流水號，
    	 * ex. 永豐餘＝YF01, 下一個客戶如果是仰風科技-->YF02, 但如果是台積電的話可能為TG01)
    	 */
    	/*
    	if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
        	
        	Matcher matcher = pattern.matcher(this.getFlowKey());
        	Matcher matcher2 = pattern2.matcher(this.getFlowKey());
        	if(!matcher.matches() && !matcher2.matches()) {
        		this.setErrorMessage(this.getUserInfo().getMsg("jsp.Client.FlowKeyError"));
        		return true;
        	}
        	else if(matcher2.matches()){
        		//String flowKey = FlowEngin.getPkeyNo(this.getFlowKey().substring(0, 2), 2, false, "");
	    		String sql = "select count(1) as Count from client where flowkey='" + this.getFlowKey() + "'";

	    		int count = Integer.parseInt(this.getDbUtil().getFieldValue(sql, "Count"));
	    		
	    		sql = "select flowkey from client where flowkey like '" + this.getFlowKey().substring(0,2)+ "%' order by flowkey desc";
    			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
    			int max = 1;
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				max = Integer.parseInt( key.substring(2, 4) ) + 1;
    			}
    			String flowKey = this.getFlowKey().substring(0,2)+ String.format("%02d", max);      
	
	    		if(count > 0) {
	    			this.setErrorMessage("客戶代碼 " + this.getFlowKey() + "已經被使用，已將客戶代碼修改為" + flowKey);
	    			this.setFlowKey(flowKey);
	    			return true;
	    		}
        	}
        	else {
        		String sql = "select flowkey from client order by flowkey desc";
    			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
    			int max = 1;
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				max = Integer.parseInt(key) + 1;
    			}
    			this.FlowKey.setValue(Integer.toString(max));
        	}
        	
    	}*/
    	//取消客戶編號邏輯，直接以四碼流水碼編碼
    	if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
        	if(!this.getFlowKey().isEmpty()){
        		String sql = "select count(1) as Count from client where flowkey='" + this.getFlowKey() + "'";

        		int count = Integer.parseInt(this.getDbUtil().getFieldValue(sql, "Count"));
        		
        		sql = "select flowkey from client where flowkey REGEXP '^[0-9]{4}$' order by flowkey desc";
        		if(Util.compareTo(DB.DBTYPE, Cnstnts.MSSQL)) {
    				sql = "select flowkey from client where flowkey like '[0-9][0-9][0-9][0-9]' order by flowkey desc";
    			}
        		List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
    			int max = 1;
    			String number = "0001";
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				max = Integer.parseInt(key) + 1;
    				number = String.format("%04d", max);
    			}
    			String flowKey = number;      

        		if(count > 0) {
        			this.setErrorMessage("客戶代碼 " + this.getFlowKey() + "已經被使用，已將客戶代碼修改為" + flowKey);
        			this.setFlowKey(flowKey);
        			return true;
        		}
        	}
        	else{
        		String sql = "select flowkey from client where flowkey REGEXP '^[0-9]{4}$' order by flowkey desc";
    			List<String> keys = this.getDbUtil().getValueList(sql, "flowkey");
    			int max = 1;
    			String number = "0001";
    			if(keys != null && !keys.isEmpty()) {
    				String key = keys.get(0);
    				max = Integer.parseInt(key) + 1;
    				number = String.format("%04d", max);
    			}
    			this.FlowKey.setValue(number);
        	}
        	
        	
    	}
        if(super.checkInsertError()){
            return true;
        } else {
        	if(this.getCompanyName().indexOf("\"") != -1 ||
        			this.getCompanyName().indexOf("'") != -1) {
        		this.setErrorMessage(Html.getAlias(this.CompanyName, this.getUserInfo()) + " " +
        				this.getUserInfo().getMsg("jsp.common.charError") + ": \\\" \\\' ");
        		return true;
        	}
        	if(!Util.isEmpty(this.getFlowKey()) &&
            		Util.compareTo(this.getDbActionMode(), Cnstnts.UPDATE)) {

	        	if(!Util.compareTo(this.getNationality(), "TW") ||
		        		Util.compareTo(this.getIdentity(), "Identity01")) {
		        }
		        else {
//		        	if(Util.isEmpty(this.RegisteredNo.getValue())) {
//		        		this.setErrorMessage(
//		        				Html.getAlias(this.RegisteredNo, this.getUserInfo()) + 
//		        				this.getUserInfo().getMsg("jsp.common.EmptyError"));
//		        		return true;
//		        	}
		        	if(Util.isEmpty(this.InvoiceTitle1.getValue())) {
		        		this.setErrorMessage(
		        				Html.getAlias(this.InvoiceTitle1, this.getUserInfo()) + 
		        				this.getUserInfo().getMsg("jsp.common.EmptyError"));
		        		return true;
		        	}
		        	if(Util.isEmpty(this.InCharge.getValue())) {
		        		this.setErrorMessage(
		        				Html.getAlias(this.InCharge, this.getUserInfo()) + 
		        				this.getUserInfo().getMsg("jsp.common.EmptyError"));
		        		return true;
		        	}
		        	if(Util.isEmpty(this.Entity.getValue())) {
		        		this.setErrorMessage(
		        				Html.getAlias(this.Entity, this.getUserInfo()) + 
		        				this.getUserInfo().getMsg("jsp.common.EmptyError"));
		        		return true;
		        	}
		        }
	        	
//	        	if(Util.isEmpty(this.Address2.getValue())) {
//	        		this.setErrorMessage(
//	        				Html.getAlias(this.Address2, this.getUserInfo()) + 
//	        				this.getUserInfo().getMsg("jsp.common.EmptyError"));
//	        		return true;
//	        	}
	
//	        	if(Util.isEmpty(this.Contact.getValue())) {
//	        		this.setErrorMessage(
//	        				Html.getAlias(this.Contact, this.getUserInfo()) + 
//	        				this.getUserInfo().getMsg("jsp.common.EmptyError"));
//	        		return true;
//	        	}
//	        	if(Util.isEmpty(this.BillingContact.getValue())) {
//	        		this.setErrorMessage(
//	        				Html.getAlias(this.BillingContact, this.getUserInfo()) + 
//	        				this.getUserInfo().getMsg("jsp.common.EmptyError"));
//	        		return true;
//	        	}
        	}
        	/*
        	客戶資料  新增資料時儲存時，欄位"客戶名稱(中)"去比對既有資料，若有全名比對完全符合已存在者，
        	跳出提醒視窗"該名稱之客戶已存在請確認"，不給存跳回原新增視窗。
        	        	 */
        	            	if(!this.getCompanyName().isEmpty()){
        	            		String sql = "select count(1) as Count from client " +
        	            				"where flowkey!='" + this.getFlowKey() + "' and CompanyName ='" + this.getCompanyName() + "'";
        	            		int count = Integer.parseInt(this.getDbUtil().getFieldValue(sql, "Count"));
        	            		if(count > 0) {
        	            			this.setErrorMessage(this.getUserInfo().getMsg("jsp.Client.CompanyNameError"));
        	            			return true;
        	            		}
        	            	}
        	            	
        	this.setCompanyName(this.getCompanyName());
        	this.setEnglishCompanyName(this.getEnglishCompanyName());
//        	this.setCompanyName(this.getLastName() + this.getFirstName());
//        	this.setEnglishCompanyName(this.getEnglishLastName() + this.getEnglishFirstName());
        	
        	if(!Util.isEmpty(this.getInvoiceTitle1())) {
        		InvTitle inv = new InvTitle(this.getInvoiceTitle1());
            	this.RegisteredNo.setValue(inv.getRegisteredNo());
        	}
        	else {
            	this.RegisteredNo.setValue("");
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
    
    @SuppressWarnings("unchecked")
	public boolean insert() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.FlowKey.setValue(this.FlowKey.getValue().trim());
		this.setDbFields();
		sqlList.add(this.getDbUtil().getInsertSQL(this.getTableName(), this.DbFields));
		
		/*
		客戶資料 → 聯絡人：
		
		客戶姓(中) → 姓(中)、
		客戶名(中) → 名(中)、
		客戶姓(英) → 姓(英)、
		客戶名(英) → 名(英)、
		國家                 → 國家/國籍、
		WebSite   → WebSite、
		E-Mail2   → E-Mail2、
		Skybe     →Skype、
		MSN       →MSN
		 */
		if (this.getAddFlag().equals("Y")) {
			Applicant applicant = new Applicant();
			applicant.setDbFields();
			applicant.CreateDept.setValue(this.CreateDept.getValue());
			applicant.Applicant.setValue(this.Applicant.getValue());
			applicant.Client.setValue(this.FlowKey.getValue());
			applicant.Nationality.setValue(this.Nationality.getValue());
			applicant.IdType.setValue(this.Identity.getValue());
			applicant.Names.setValue(this.CompanyName.getValue());
			applicant.EnglishNames.setValue(this.EnglishCompanyName.getValue());
			applicant.IdNo.setValue(this.RegisteredNo.getValue());
			applicant.CompanyReq.setValue(this.InCharge.getValue());
			applicant.TelNo.setValue(this.Tel1.getValue());
			applicant.Mobile.setValue(this.Mobile.getValue());
			applicant.Fax.setValue(this.Fax1.getValue());
			applicant.Email.setValue(this.Email.getValue());
			applicant.Zip.setValue(this.Zip1.getValue());
			applicant.Address.setValue(this.Address1.getValue());
			applicant.Zip2.setValue(this.Zip2.getValue());
			applicant.Address2.setValue(this.Address2.getValue());
			applicant.EnglishAddress.setValue(this.EnglishAddress2.getValue());
			applicant.FlowKey.setValue(Util.getAutoNo(applicant.getProgramId()));
//			applicant.setFirstName(this.getFirstName());
			applicant.setLastName(this.getCompanyName());
//			applicant.setLastName(this.getLastName());
//			applicant.setEnglishFirstName(this.getEnglishFirstName());
			applicant.setEnglishLastName(this.getEnglishCompanyName());
//			applicant.setEnglishLastName(this.getEnglishLastName());
			applicant.setWebSite(this.getWebSite());
			applicant.setEmail2(this.getEmail2());
			applicant.setSkype(this.getSkype());
			applicant.setMsn(this.getMsn());
			sqlList.add(applicant.getDbUtil().getInsertSQL(applicant.getTableName(), applicant.DbFields));
		}
		sqlList.addAll(addClientBillingSql());
		
		boolean result = this.getDbUtil().executeUpdate(sqlList);
		if(result) {
			Config.updatesProperty(this.CompanyName.getTableName() + "_" + this.CompanyName.getName(), this.getFlowKey(), this.CompanyName.getValue());
		}
		
		return result;
	}
    
	public boolean update() throws Exception {
		if(super.update()) {
			/*
客戶資料內的業務人員和負責程序欄位異動的時候，同時也批次覆蓋所有該客戶的委辦案件、關連的內部訂單、
關連的報價單內的業務人員、負責程序 欄位。（"負責程序"只有案件和客戶資料有）
			 */
			Employee incharge = new Employee(this.getSponsor());
			Employee casead = new Employee(this.getCaseAD());
			
			List<String> sqls = new ArrayList<String>();
			sqls.add("update patentcase set clientname = '" + this.getCompanyName() + "'," +
					"InCharge='" + this.getSponsor() + "', CaseAD ='" + this.getCaseAD() + "' where client = '" + this.getFlowKey() + "'");
			sqls.add("update trademarkcase set " +
					"Sales='" + this.getSponsor() + "', CaseAD ='" + this.getCaseAD() + "' where client = '" + this.getFlowKey() + "'");
			sqls.add("update legalcase set " +
					"InCharge='" + this.getSponsor() + "', CaseAD ='" + this.getCaseAD() + "' where client = '" + this.getFlowKey() + "'");
			sqls.add("update copyrightcase set " +
					"InCharge='" + this.getSponsor() + "', CaseAD ='" + this.getCaseAD() + "' where client = '" + this.getFlowKey() + "'");
			sqls.add("update salesorder set InCharge='" + this.getSponsor() + "' where client = '" + this.getFlowKey() + "'");
			sqls.add("update quotation set InCharge='" + this.getSponsor() + "' where client = '" + this.getFlowKey() + "'");
			
			if(!Util.isEmpty(this.getSponsor())) {
				sqls.add("update caseprivilege set EmployeeId = '" + this.getSponsor() + "'," +
						"names = '" + incharge.getEmp_name() + "'," +
						"title = '" + incharge.getTitle() + "' " +
						"where CreateFrom LIKE '%TS' and CreateFrom != casekey ");
				
				sqls.add("update caseprivilege set EmployeeId = '" + this.getSponsor() + "'," +
						"names = '" + incharge.getEmp_name() + "'," +
						"title = '" + incharge.getTitle() + "' " +
						"where CreateFrom LIKE '%PS' and CreateFrom != casekey ");
				
				sqls.add("update caseprivilege set EmployeeId = '" + this.getInCharge() + "'," +
						"names = '" + incharge.getEmp_name() + "'," +
						"title = '" + incharge.getTitle() + "' " +
						"where CreateFrom LIKE '%CS' and CreateFrom != casekey ");
				
				sqls.add("update caseprivilege set EmployeeId = '" + this.getSponsor() + "'," +
						"names = '" + incharge.getEmp_name() + "'," +
						"title = '" + incharge.getTitle() + "' " +
						"where CreateFrom LIKE '%LS' and CreateFrom != casekey ");
			}
			

			if(!Util.isEmpty(this.getCaseAD())) {
				sqls.add("update caseprivilege set EmployeeId = '" + this.getCaseAD() + "'," +
						"names = '" + casead.getEmp_name() + "'," +
						"title = '" + casead.getTitle() + "' " +
						"where CreateFrom LIKE '%TC' and CreateFrom != casekey ");
				
				sqls.add("update caseprivilege set EmployeeId = '" + this.getCaseAD() + "'," +
						"names = '" + casead.getEmp_name() + "'," +
						"title = '" + casead.getTitle() + "' " +
						"where CreateFrom LIKE '%PC' and CreateFrom != casekey ");
				
				sqls.add("update caseprivilege set EmployeeId = '" + this.getCaseAD() + "'," +
						"names = '" + casead.getEmp_name() + "'," +
						"title = '" + casead.getTitle() + "' " +
						"where CreateFrom LIKE '%CC' and CreateFrom != casekey ");
				
				sqls.add("update caseprivilege set EmployeeId = '" + this.getCaseAD() + "'," +
						"names = '" + casead.getEmp_name() + "'," +
						"title = '" + casead.getTitle() + "' " +
						"where CreateFrom LIKE '%LC' and CreateFrom != casekey ");
			}
			
			Config.updatesProperty(this.CompanyName.getTableName() + "_" + this.CompanyName.getName(), this.getFlowKey(), this.CompanyName.getValue());
			this.getDbUtil().executeUpdate(sqls);
			return true;
		}
		
		return false;
	}
	
	public List<String> addClientBillingSql() {
		List<String> sqls = new ArrayList<String>();
		
		String insertSql = "INSERT INTO  clientbilling (CreateDept ,Applicant ,ParentId ,ShowItem ," +
				"NewCase ,OldCase ,TwCase ,AttorneyTitle ," +
				"BillSendDoc1 ,BillSendDoc2 ,BillSendDoc3 ,BillSendDoc4 ," +
				"BillSendDoc5 ,BillSendDoc6 ,BillSendDoc7) " +
				"VALUES ('Demo' , 'admin' , '%s' , '%s' , '%s' , '%s' , '%s' , '%s' , '%s',  '%s',  '%s',  '%s',  '%s',  '%s',  '%s');";
		if(Util.compareTo(this.getNationality(), "TW")) {
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase01", "", "Y", "ATitle01", "Y", "Y","N","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase02", "", "Y", "ATitle01", "Y", "Y","N","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase03", "", "Y", "ATitle01", "Y", "Y","N","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase04", "", "Y", "ATitle01", "Y", "Y","N","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase01", "Y", "ATitle01", "Y", "Y","N","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase02", "Y", "ATitle01", "Y", "Y","N","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase03", "Y", "ATitle01", "Y", "Y","N","Y","N","N","Y"));
			
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase01", "", "N", "ATitle02", "Y", "Y","N","N","Y","Y","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase02", "", "N", "ATitle02", "Y", "Y","N","N","Y","Y","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase03", "", "N", "ATitle02", "Y", "Y","N","N","Y","Y","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase04", "", "N", "ATitle02", "Y", "Y","N","N","Y","Y","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase01", "N", "ATitle02", "Y", "Y","N","N","Y","Y","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase02", "N", "ATitle02", "Y", "Y","N","N","Y","Y","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase03", "N", "ATitle02", "Y", "Y","N","N","Y","Y","N"));
		}
		else {
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase01", "", "Y", "ATitle04", "Y", "N","Y","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase02", "", "Y", "ATitle04", "Y", "N","Y","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase03", "", "Y", "ATitle04", "Y", "N","Y","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase04", "", "Y", "ATitle04", "Y", "N","Y","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase01", "Y", "ATitle04", "Y", "N","Y","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase02", "Y", "ATitle04", "Y", "N","Y","Y","N","N","Y"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase03", "Y", "ATitle04", "Y", "N","Y","Y","N","N","Y"));
			
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase01", "", "N", "ATitle03-S", "Y", "N","Y","N","N","N","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase02", "", "N", "ATitle03-S", "Y", "N","Y","N","N","N","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase03", "", "N", "ATitle03-S", "Y", "N","Y","N","N","N","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "NewCase", "NewCase04", "", "N", "ATitle03-S", "Y", "N","Y","N","N","N","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase01", "N", "ATitle03-S", "Y", "N","Y","N","N","N","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase02", "N", "ATitle03-S", "Y", "N","Y","N","N","N","N"));
			sqls.add(String.format(insertSql, this.getFlowKey(), "OldCase", "", "OldCase03", "N", "ATitle03-S", "Y", "N","Y","N","N","N","N"));
		}
		
		
		return sqls;
	}
	
	public boolean delete() throws Exception {
		if(super.delete()) {
			Config.removeProperty(this.CompanyName.getTableName() + "_" + this.CompanyName.getName(), this.getFlowKey());
			
			return true;
		}
		
		return false;
	}

    public String getSubmitBtn() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
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

		return rtnString+getSubmitBtn2();
	}
    

	public String getSubmitBtn2() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		//因為查詢列表直接用update模式進來
		//如果權限只有開查詢的話，會造成暫存按鈕還是出現，因為以為是update
		//所以要重新設定模式
		boolean salesEdit = false;
		if(this.getSponsor().equals(this.getUserInfo().getAttribute("emp_id"))) {
			salesEdit = true;
		}
		else if(this.getSponsorAssistant().startsWith(this.getUserInfo().getAttribute("emp_id") + ";") ||
				this.getSponsorAssistant().indexOf(";" + this.getUserInfo().getAttribute("emp_id") + ";") != -1) {
			salesEdit = true;
		}
		if(!this.getUserInfo().hasPrivilege(this.getProgramId(), this.getDbActionMode())) {
			this.setDbActionMode(Cnstnts.QUERY);
		}
		if (this.canSubmit()) {
			if (!this.getApplicant().equals(this.getUserInfo().getAttribute("emp_id"))) {
				if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
					if (!this.getUserInfo().canUpdateAll(this.getProgramId()) && !salesEdit) {
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
			rtnString = Html.getSubmitBtn(this.getUserInfo(), this.getDbActionMode());
		}
		return rtnString;
	}
    
    public void doAction(UserBean userInfo) throws Exception {
    	this.setUserInfo(userInfo);
    	
    	//在委辦案件tab列表上方新增一"批次業務移轉"按鈕以及下拉選單（來源為員工），選了之後點該按鈕，列表之案件的業務置換改為所選員工
    	if(Util.compareTo(this.getChangeSales(), "true")) {
    		List<String> sqls = new ArrayList<String>();
    		sqls.add("update patentcase set inCharge ='" + this.getSalesChangeList() + "' where client ='" + this.getFlowKey() + "'");
    		sqls.add("update legalcase set inCharge ='" + this.getSalesChangeList() + "' where client ='" + this.getFlowKey() + "'");
    		sqls.add("update trademarkcase set sales ='" + this.getSalesChangeList() + "' where client ='" + this.getFlowKey() + "'");
    		sqls.add("update copyrightcase set inCharge ='" + this.getSalesChangeList() + "' where client ='" + this.getFlowKey() + "'");
    		sqls.add("update client set sponsor ='" + this.getSalesChangeList() + "' where flowkey ='" + this.getFlowKey() + "'");
    		this.getDbUtil().executeUpdate(sqls);
    		
    		this.Sponsor.setValue(this.getSalesChangeList());
    	}
    	//2. 在委辦案件tab列表上方新增一"批次程序移轉"按鈕以及下拉選單（來源為員工），選了之後點該按鈕，列表之案件的 "負責程序" 置換改為所選員工
    	if(Util.compareTo(this.getChangeCaseAD(), "true")) {
    		List<String> sqls = new ArrayList<String>();
    		sqls.add("update patentcase set CaseAD ='" + this.getCaseADChangeList() + "' where client ='" + this.getFlowKey() + "'");
    		sqls.add("update legalcase set CaseAD ='" + this.getCaseADChangeList() + "' where client ='" + this.getFlowKey() + "'");
    		sqls.add("update trademarkcase set CaseAD ='" + this.getCaseADChangeList() + "' where client ='" + this.getFlowKey() + "'");
    		sqls.add("update copyrightcase set CaseAD ='" + this.getCaseADChangeList() + "' where client ='" + this.getFlowKey() + "'");
    		sqls.add("update client set CaseAD ='" + this.getSalesChangeList() + "' where flowkey ='" + this.getFlowKey() + "'");
    		this.getDbUtil().executeUpdate(sqls);
    		
    		this.CaseAD.setValue(this.getCaseADChangeList());
    	}
    	
    	super.doAction(userInfo);
    }
    
    public void doPrintProcess() throws Exception {
		String outFile = this.makeDoc();
		if (outFile != null) {
			this.setOutputFile(outFile);
		}
	}

	@SuppressWarnings("unchecked")
	public String makeDoc() throws Exception {
		if (this.getSampleDoc().trim().length() == 0) {
			return null;
		}
		OoConverter oc = new OoConverter("localhost", "8100");
		String sampleDoc = "file:///" + Util.getTomcatPath()
				+ this.getSampleDoc();
		String outputFile = "Receivable/"
				+ Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))
				+ ".doc";
		String outputDoc = "file:///" + Util.getDocPath() + outputFile;

		if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		Client client = new Client(this.getFlowKey());
    		client.setDbFields();
    		Properties categoryPrpt = null;
        	try {
    			categoryPrpt = new Category().getNamesPrpts();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		Properties employeePrpt = null;
        	try {
        		employeePrpt = new Employee().getNamesPrpts();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		Properties attorneyPrpt = null;
        	try {
        		attorneyPrpt = new Attorney().getNamesPrpts();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}

    		HashMap<String, String> data = new HashMap<String, String>();
    		
    		Calendar calendar = Calendar.getInstance();
    		data.put("${today}", (calendar.get(Calendar.YEAR) - 1911) + "年" +
    				(calendar.get(Calendar.MONTH) + 1) + "月" +
    				calendar.get(Calendar.DAY_OF_MONTH) + "日");
    		
    		String sponsorTitle ="";
    		String SQL = "select Title from Employee where FlowKey = '"+this.getSponsor()+"'";
    		sponsorTitle = this.getDbUtil().getFieldValue(SQL,"Title");
    		data.put("${SponsorTitle}",categoryPrpt.getProperty(sponsorTitle));
    		
    		for(Field field : client.getDbFields()) {
    			if(Util.isEmpty(field.getValue()) || field.getValue().equals("null")) {
    				data.put("${" + field.getName() + "}", "");
    			}
    			else {
    				String value = "";
	    			if(Util.compareTo(field.getName(), "Nationality") || 
	    					Util.compareTo(field.getName(), "Entity") || 
	    					Util.compareTo(field.getName(), "Identity") || 
	    					Util.compareTo(field.getName(), "Industry") || 
	    					Util.compareTo(field.getName(), "Category") || 
	    					Util.compareTo(field.getName(), "OwnershipType")) {
	    				value = categoryPrpt.getProperty(field.getValue());
	    			}
	    			else if(Util.compareTo(field.getName(), "Sponsor")) {
	    				value = employeePrpt.getProperty(field.getValue());
	    			}
	    			else {
	    				value = field.getValue();
	    			}
	    			if(!Util.isEmpty(value)) {
	    				data.put("${" + field.getName() + "}", value);
	    			}
	    			else {
	    				data.put("${" + field.getName() + "}", "");
	    			}
    			}
    		}
			try {
				oc.convertDocument(sampleDoc, outputDoc, data);
				return "doc/" + outputFile;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	public void clearAttribute() {
		super.clearAttribute();
		this.setAddressSearch(Cnstnts.EMPTY_STRING);
	}
	


	public boolean getCanEditField(Field field) {
		if(this.onSearchMode()) {
			return true;
		}
		if (this.canEdit() || this.onSearchMode()) {

			
			if(field.getName().equals(this.Datalack.getName())) {
				if(Util.compareTo(this.getUserInfo().getAttribute("in_admin"), "true") || 
						Util.compareTo(this.getUserInfo().getAttribute("in_g01"), "true")) {
					return true;
				}
				else {
					return false;
			}}
			//2. "所屬業務" 下拉選單（來源 員工資料），該欄位僅G01權限者可編輯。
			//2013/8/14規格修改：客戶料裡面的"業務人員"與"業務助理"欄位的編輯權限，G01, admin 群組外，請另外增加權限規則：AD00 員工所屬程序部下面的登入可用
			if(field.getName().equals(this.Sponsor.getName()) || field.getName().equals(this.SponsorAssistantName.getName())) {
				Department dept = new Department("AD00");
				SelectItem item = dept.getSelectItem();
				List<SelectItem> deptTreeList = dept.getTreeList(item);
				List<String> deptList = new ArrayList<String>();
				deptList.add("AD00");
				for(SelectItem dptItem : deptTreeList){
					deptList.add(dptItem.getKey());
				}
				
				if(Util.compareTo(this.getUserInfo().getAttribute("in_admin"), "true") || 
						Util.compareTo(this.getUserInfo().getAttribute("in_g01"), "true") || 
						deptList.contains(this.getUserInfo().getAttribute("dept_id"))) {
					return true;
				}
				else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public List<SelectItem> getList() throws Exception {
		return this.getDbUtil().getList(this.FlowKey, this.getNamesPrpts(), false);
	}

	public List<SelectItem> getList(String orderby, boolean withKey, boolean shortName) throws Exception {
		return this.getDbUtil().getList(this.FlowKey, this.getNamesPrpts(), withKey, shortName, orderby);
	}
	
	public Map<String, String> getDocMap() throws Exception {
		Map data = new HashMap<String, String>();
		data.put("${EnglishAddress1}", this.EnglishAddress1.getValue());
		data.put("${EnglishAddress2}", this.EnglishAddress2.getValue());
		data.put("${Address1}", this.Address1.getValue());
		data.put("${Address2}", this.Address2.getValue());
		data.put("${Zip1}", this.Zip1.getValue());
		data.put("${Zip2}", this.Zip2.getValue());
		//改成下拉了
		if(!Util.isEmpty(this.getInvoiceTitle1())) {
			data.put("${InvoiceTitle1}", new InvTitle(this.getInvoiceTitle1()).getInvoiceTitle());
		}
		else {
			data.put("${InvoiceTitle1}", "");
		}
		
		data.put("${InvoiceTitle2}", this.getInvoiceTitle2());
		data.put("${RegisteredNo}", this.getRegisteredNo());
		data.put("${RegisteredNo2}", this.getRegisteredNo2());
		
		//改成下拉了
		if(!Util.isEmpty(this.getBillingContact())) {
			data.put("${BillingContact}", new Applicant(this.getBillingContact()).getNames());
		}
		else {
			data.put("${BillingContact}", "");
		}
		
		return data;
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
    	
   	 	this.ResultFields.put(this.FlowKey.getName(), this.FlowKey);
    	this.ResultFields.put(this.GroupName.getName(), this.GroupName);
    	this.ResultFields.put(this.CompanyName.getName(), this.CompanyName);
        this.ResultFields.put(this.EnglishCompanyName.getName(), this.EnglishCompanyName);
        this.ResultFields.put(this.Sponsor.getName(), this.Sponsor);
    	this.ResultFields.put(this.CaseAD.getName(), this.CaseAD);
    	this.CaseAD.setMapingPrpt(empPrpt);
    	this.CaseAD.setNotShowCode(true);
    	this.ResultFields.put(this.ClientContect.getName(), this.ClientContect);
    	this.ResultFields.put(this.BillingContact.getName(), this.BillingContact);
    	this.ResultFields.put(this.InvoiceTitle1.getName(), this.InvoiceTitle1);
    	this.ResultFields.put(this.TotalCase.getName(), this.TotalCase);
    	this.ResultFields.put(this.Attorney.getName(), this.Attorney);
    	this.ResultFields.put(this.Nationality.getName(), this.Nationality);
    	this.ResultFields.put(this.Identity.getName(), this.Identity);
    	this.ResultFields.put(this.InCharge.getName(), this.InCharge);
    	this.InCharge.setMapingPrpt(empPrpt);
    	this.InCharge.setNotShowCode(true);
    	this.ResultFields.put(this.Address2.getName(), this.Address2);
    	this.ResultFields.put(this.AccountingMissTel.getName(), this.AccountingMissTel);
    	this.ResultFields.put(this.BillingContactEmail.getName(), this.BillingContactEmail);
    	
    	
    }
}