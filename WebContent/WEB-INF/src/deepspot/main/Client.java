package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.util.Util;

public class Client extends MasterBean {

    public Client(){this.init();}

    public Client(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Summary;
    public void setSummary(String Summary){this.Summary.setValue(Summary);}
    public String getSummary(){return this.Summary.getValue();}

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

    public void init() {
        super.init();
        this.setProgramId("jsp.Client");
        this.setTableName("Client");
        this.FlowKey.setSearchCondition(Cnstnts.LIKE);
        this.Summary = new Field("Summary", this.getTableName());
        this.Summary.setDbType("nvarchar(200)");

        this.Nationality = new Field("Nationality", this.getTableName());
        this.Nationality.setDbType("nvarchar(50)");

        this.Entity = new Field("Entity", this.getTableName());
        this.Entity.setDbType("nvarchar(50)");

        this.CompanyName = new Field("CompanyName", this.getTableName());
        this.CompanyName.setDbType("nvarchar(100)");
        this.CompanyName.setSearchCondition(Cnstnts.LIKE);
        this.CompanyName.setCheckEmpty(true);

        this.EnglishCompanyName = new Field("EnglishCompanyName", this.getTableName());
        this.EnglishCompanyName.setDbType("varchar(100)");
        this.EnglishCompanyName.setSearchCondition(Cnstnts.LIKE);

        this.RegisteredNo = new Field("RegisteredNo", this.getTableName());
        this.RegisteredNo.setDbType("varchar(50)");

        this.InCharge = new Field("InCharge", this.getTableName());
        this.InCharge.setDbType("nvarchar(50)");
        this.InCharge.setSearchCondition(Cnstnts.LIKE);
        this.Contact = new Field("Contact", this.getTableName());
        this.Contact.setDbType("nvarchar(50)");
        this.Contact.setSearchCondition(Cnstnts.LIKE);

        this.Tel1 = new Field("Tel1", this.getTableName());
        this.Tel1.setDbType("varchar(50)");

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

        this.Zip1 = new Field("Zip1", this.getTableName());
        this.Zip1.setDbType("varchar(50)");

        this.Zip2 = new Field("Zip2", this.getTableName());
        this.Zip2.setDbType("varchar(50)");

        this.Address1 = new Field("Address1", this.getTableName());
        this.Address1.setDbType("nvarchar(100)");
        this.Address1.setSearchCondition(Cnstnts.LIKE);

        this.EnglishAddress1 = new Field("EnglishAddress1", this.getTableName());
        this.EnglishAddress1.setDbType("varchar(100)");

        this.Address2 = new Field("Address2", this.getTableName());
        this.Address2.setDbType("nvarchar(100)");

        this.EnglishAddress2 = new Field("EnglishAddress2", this.getTableName());
        this.EnglishAddress2.setDbType("varchar(100)");

        this.OwnershipType = new Field("OwnershipType", this.getTableName());
        this.OwnershipType.setDbType("varchar(50)");

        this.Category = new Field("Category", this.getTableName());
        this.Category.setDbType("varchar(50)");

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
        this.Sponsor.setSearchCondition(Cnstnts.LIKE);
        this.Payment = new Field("Payment", this.getTableName());
        this.Payment.setDbType("nvarchar(50)");
        
        this.AlertDay = new Field("AlertDay", this.getTableName());
        this.AlertDay.setDbType("int");
        
        this.FirstCaseDate = new Field("FirstCaseDate", this.getTableName());
        
        this.TotalCase = new Field("TotalCase", this.getTableName());
        
        this.AddFlag = new Field("AddFlag", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.Summary);

        this.DbFields.add(this.Nationality);

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
        
        this.DbFields.add(this.AlertDay);
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.EnglishCompanyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
        	this.CompanyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.CompanyName.setAnotherField(this.EnglishCompanyName);
        	rtnString += this.printHtml(this.CompanyName);
        	
        	this.InCharge.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	rtnString+=this.printHtml(this.InCharge);
        	
        	
        	this.Category.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.Category.setSelectList(new Category().getChildList(this.Category));
        	
        	this.Address1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Address1.setAnotherField(this.Category);
        	
        	this.Sponsor.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Contact.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
        	rtnString += this.printHtml(this.Address1);
        	rtnString+=this.printHtml(this.Sponsor);
        	rtnString+=this.printHtml(this.Contact);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
            rtnString += this.Summary.printHiddenTag();
            
            this.InCharge.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.CompanyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.CompanyName.setSize(30);
            this.CompanyName.setAnotherField(this.InCharge);
            this.CompanyName.setColspan(1);
            rtnString += this.printHtml(this.CompanyName);
            
            this.Nationality.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Nationality.setSelectList(new Category().getChildList(this.Nationality));

            this.EnglishCompanyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishCompanyName.setSize(30);
            this.EnglishCompanyName.setAnotherField(this.Nationality);
            this.EnglishCompanyName.setColspan(1);
            rtnString += this.printHtml(this.EnglishCompanyName);

            this.Category.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Category.setSelectList(new Category().getChildList(this.Category));

            this.InvoiceTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InvoiceTitle.setAnotherField(this.Category);
            this.InvoiceTitle.setColspan(1);
            rtnString += this.printHtml(this.InvoiceTitle);
            
            List<SelectItem> CreditItems = new ArrayList<SelectItem>();
            CreditItems.add(new SelectItem("AA","AA"));
            CreditItems.add(new SelectItem("A","A"));
            CreditItems.add(new SelectItem("B","B"));
            CreditItems.add(new SelectItem("C","C"));
            CreditItems.add(new SelectItem("D","D"));
            
            this.Credit.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Credit.setSelectList(CreditItems);
            
            this.RegisteredNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.RegisteredNo.setAnotherField(this.Credit);
            this.RegisteredNo.setColspan(1);
            rtnString += this.printHtml(this.RegisteredNo);
            
            this.Mobile.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Contact.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Contact.setAnotherField(this.Mobile);
            this.Contact.setColspan(1);
            rtnString += this.printHtml(this.Contact);

            this.Tel2.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Tel1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Tel1.setAnotherField(this.Tel2);
            this.Tel1.setColspan(1);
            rtnString += this.printHtml(this.Tel1);
            
            this.Fax2.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Fax1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Fax1.setAnotherField(this.Fax2);
            this.Fax1.setColspan(1);
            rtnString += this.printHtml(this.Fax1);

            this.WebSite.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.WebSite.setSize(30);
            
            this.Email.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Email.setSize(30);
            this.Email.setAnotherField(this.WebSite);
            this.Email.setColspan(1);
            rtnString += this.printHtml(this.Email);

            this.Msn.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Msn.setSize(30);

            this.Skype.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Skype.setSize(30);
            this.Skype.setAnotherField(this.Msn);
            this.Skype.setColspan(1);
            rtnString += this.printHtml(this.Skype);

            this.Address1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Address1.setSize(60);
            
            this.Zip1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Zip1.setSize(5);
            this.Zip1.setAnotherField(this.Address1);
            rtnString += this.printHtml(this.Zip1);

            this.Address2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Address2.setSize(60);
            
            this.Zip2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Zip2.setSize(5);
            this.Zip2.setAnotherField(this.Address2);
            rtnString += this.printHtml(this.Zip2);

            this.EnglishAddress1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishAddress1.setSize(70);
            rtnString += this.printHtml(this.EnglishAddress1);

            this.EnglishAddress2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishAddress2.setSize(70);
            rtnString += this.printHtml(this.EnglishAddress2);
            
            this.Entity.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            
            this.OwnershipType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.OwnershipType.setAnotherField(this.Entity);
            this.OwnershipType.setColspan(1);
            rtnString += this.printHtml(this.OwnershipType);

            this.Industry.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);

            this.StockId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.StockId.setAnotherField(this.Industry);
            this.StockId.setColspan(1);
            rtnString += this.printHtml(this.StockId);

            this.Currency.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Revenue.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Revenue.setAnotherField(this.Currency);
            this.Revenue.setColspan(1);
            rtnString += this.printHtml(this.Revenue);
            
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
            
            this.Sponsor.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Sponsor.setSelectList(new Employee().getList());
            
            this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Memo.setCols(62);
            this.Memo.setRows(2);
            this.Memo.setAnotherField(this.Sponsor);
            rtnString += this.printHtml(this.Memo);

            this.Appendix.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            if(Cnstnts.INSERT.equals(this.getDbActionMode())){
            	this.AddFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            	this.Appendix.setAnotherField(this.AddFlag);
            }
            rtnString += this.printHtml(this.Appendix);

            rtnString += printCaseDetail();
        }
        return rtnString;
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
    	this.FlowKey.setListWidth("10%");
        this.CompanyName.setListWidth("15%");
        
        this.InCharge.setListWidth("10%");
        
        this.Contact.setListWidth("10%");
        
        this.Fax1.setListWidth("10%");
        
        this.Tel1.setListWidth("10%");
        
        this.Address1.setListWidth("20%");
        
        this.Category.setListWidth("6%");
        this.Category.setNotShowCode(true);
        try {
			this.Category.setMapingPrpt(new Category().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Properties clientCaseDatePrpt = new Properties();
		String SQL = "select Client as FlowKey, substr(CreateTime,1,10) as CreateTime "+
	  	  			 "from PatentCase where Client!='' order by CreateTime desc";
		try {
			clientCaseDatePrpt = this.getDbUtil().getFieldPrpts(SQL, "CreateTime");
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.FirstCaseDate.setListWidth("10%");
		this.FirstCaseDate.setNotShowCode(true);
		this.FirstCaseDate.setMapingPrpt(clientCaseDatePrpt);
		
		this.TotalCase.setListWidth("4%");
		this.TotalCase.setAlign(Cnstnts.RIGHT);
        
        Field[] showField = {this.FlowKey, this.CompanyName, this.InCharge, this.Contact,this.Tel1, 
        		this.Fax1, this.Address1, this.Category, this.FirstCaseDate, this.TotalCase};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.Address1);
        whereStr = Util.addWhereSQL(whereStr, this.Category);
        whereStr = Util.addWhereSQL(whereStr, this.CompanyName);
        whereStr = Util.addWhereSQL(whereStr, this.EnglishCompanyName);
        whereStr = Util.addWhereSQL(whereStr,this.InCharge);
        whereStr = Util.addWhereSQL(whereStr, this.Sponsor);
        whereStr = Util.addWhereSQL(whereStr, this.Contact);
        whereStr = this.getDataAuthorityWhereSQL(whereStr);
        String SQL = Cnstnts.EMPTY_STRING;
        SQL = "select c.Flowkey as FirstCaseDate, CaseTotal.TotalCase, c.* from Client c "+
        	  "left join(select client, count(client) as TotalCase from patentcase "+
        	  			"where client !='' group by client) as CaseTotal on c.FlowKey=CaseTotal.client "+whereStr;
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
        return super.getNamesPrpts(this.CompanyName);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
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
    
    public boolean insert() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.FlowKey.setValue(this.FlowKey.getValue().trim());
		this.setDbFields();
		sqlList.add(this.getDbUtil().getInsertSQL(this.getTableName(), this.DbFields));
		if (this.getAddFlag().equals("Y")) {
			Applicant applicant = new Applicant();
			applicant.setDbFields();
			applicant.CreateDept.setValue(this.CreateDept.getValue());
			applicant.Applicant.setValue(this.Applicant.getValue());
			applicant.Client.setValue(this.FlowKey.getValue());
			applicant.Nationality.setValue(this.Nationality.getValue());
			applicant.IdType.setValue("Id02");
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
			applicant.EnglishAddress.setValue(this.EnglishAddress1.getValue());
			applicant.FlowKey.setValue(Util.getAutoNo(applicant.getProgramId()));
			sqlList.add(applicant.getDbUtil().getInsertSQL(applicant.getTableName(), applicant.DbFields));
		}
		return this.getDbUtil().executeUpdate(sqlList);
	}

}