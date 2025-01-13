package deepspot.main;

import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.util.Util;

public class Attorney extends MasterBean {

    public Attorney(){this.init();}

    public Attorney(String FlowKey) {
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

    public Field Firm;
    public void setFirm(String Firm){this.Firm.setValue(Firm);}
    public String getFirm(){return this.Firm.getValue();}

    public Field Bank;
    public void setBank(String Bank){this.Bank.setValue(Bank);}
    public String getBank(){return this.Bank.getValue();}

    public Field Account;
    public void setAccount(String Account){this.Account.setValue(Account);}
    public String getAccount(){return this.Account.getValue();}

    public Field AccountName;
    public void setAccountName(String AccountName){this.AccountName.setValue(AccountName);}
    public String getAccountName(){return this.AccountName.getValue();}

    public Field LastName;
    public void setLastName(String LastName){this.LastName.setValue(LastName);}
    public String getLastName(){return this.LastName.getValue();}

    public Field FirstName;
    public void setFirstName(String FirstName){this.FirstName.setValue(FirstName);}
    public String getFirstName(){return this.FirstName.getValue();}
    
    public Field FullName;
    public void setFullName(String FullName){this.FullName.setValue(FullName);}
    public String getFullName(){return this.FullName.getValue();}
    
    public Field IdNo;
    public void setIdNo(String IdNo){this.IdNo.setValue(IdNo);}
    public String getIdNo(){return this.IdNo.getValue();}

    public Field CertificateNo;
    public void setCertificateNo(String CertificateNo){this.CertificateNo.setValue(CertificateNo);}
    public String getCertificateNo(){return this.CertificateNo.getValue();}

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

    public Field Msn;
    public void setMsn(String Msn){this.Msn.setValue(Msn);}
    public String getMsn(){return this.Msn.getValue();}

    public Field Skype;
    public void setSkype(String Skype){this.Skype.setValue(Skype);}
    public String getSkype(){return this.Skype.getValue();}

    public Field Zip;
    public void setZip(String Zip){this.Zip.setValue(Zip);}
    public String getZip(){return this.Zip.getValue();}

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

    public Field Memo;
    public void setMemo(String Memo){this.Memo.setValue(Memo);}
    public String getMemo(){return this.Memo.getValue();}

    public Field AttUrl;
    public void setAttUrl(String AttUrl){this.AttUrl.setValue(AttUrl);}
    public String getAttUrl(){return this.AttUrl.getValue();}
    
    public Field BankAddress;
    public void setBankAddress(String BankAddress){this.BankAddress.setValue(BankAddress);}
    public String getBankAddress(){return this.BankAddress.getValue();}
    
    public Field SwiftCode;
    public void setSwiftCode(String SwiftCode){this.SwiftCode.setValue(SwiftCode);}
    public String getSwiftCode(){return this.SwiftCode.getValue();}
    
    public Field RountingNo;
    public void setRountingNo(String RountingNo){this.RountingNo.setValue(RountingNo);}
    public String getRountingNo(){return this.RountingNo.getValue();}
    
    public Field IbanNo;
    public void setIbanNo(String IbanNo){this.IbanNo.setValue(IbanNo);}
    public String getIbanNo(){return this.IbanNo.getValue();}
    
    public void init() {
        super.init();
        this.setProgramId("jsp.Attorney");
        this.setTableName("Attorney");

        this.Summary = new Field("Summary", this.getTableName());
        this.Summary.setDbType("nvarchar(200)");

        this.Nationality = new Field("Nationality", this.getTableName());
        this.Nationality.setDbType("varchar(50)");

        this.Firm = new Field("Firm", this.getTableName());
        this.Firm.setDbType("nvarchar(100)");
        this.Firm.setSearchCondition(Cnstnts.LIKE);
        this.Firm.setCheckEmpty(true);

        this.Bank = new Field("Bank", this.getTableName());
        this.Bank.setDbType("nvarchar(50)");

        this.Account = new Field("Account", this.getTableName());
        this.Account.setDbType("varchar(50)");

        this.AccountName = new Field("AccountName", this.getTableName());
        this.AccountName.setDbType("nvarchar(50)");

        this.LastName = new Field("LastName", this.getTableName());
        this.LastName.setDbType("nvarchar(50)");
        this.LastName.setSearchCondition(Cnstnts.LIKE);

        this.FirstName = new Field("FirstName", this.getTableName());
        this.FirstName.setDbType("nvarchar(50)");
        this.FirstName.setSearchCondition(Cnstnts.LIKE);
        
        this.FullName=new Field("FullName");
        this.FullName.setDbType("nvarchar(100)");
      
        
        this.IdNo = new Field("IdNo", this.getTableName());
        this.IdNo.setDbType("varchar(20)");

        this.CertificateNo = new Field("CertificateNo", this.getTableName());
        this.CertificateNo.setDbType("varchar(50)");

        this.InCharge = new Field("InCharge", this.getTableName());
        this.InCharge.setDbType("nvarchar(50)");

        this.Contact = new Field("Contact", this.getTableName());
        this.Contact.setDbType("nvarchar(50)");

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

        this.Msn = new Field("Msn", this.getTableName());
        this.Msn.setDbType("varchar(50)");

        this.Skype = new Field("Skype", this.getTableName());
        this.Skype.setDbType("varchar(50)");

        this.Zip = new Field("Zip", this.getTableName());
        this.Zip.setDbType("varchar(50)");

        this.Address1 = new Field("Address1", this.getTableName());
        this.Address1.setDbType("nvarchar(100)");

        this.EnglishAddress1 = new Field("EnglishAddress1", this.getTableName());
        this.EnglishAddress1.setDbType("nvarchar(100)");

        this.Address2 = new Field("Address2", this.getTableName());
        this.Address2.setDbType("nvarchar(100)");

        this.EnglishAddress2 = new Field("EnglishAddress2", this.getTableName());
        this.EnglishAddress2.setDbType("nvarchar(100)");
        this.AttUrl=new Field("AttUrl",this.getTableName());
        this.AttUrl.setDbType("varchar(200)");
        this.Memo = new Field("Memo", this.getTableName());
        this.Memo.setDbType("nvarchar(200)");

        this.BankAddress = new Field("BankAddress",this.getTableName());
        this.BankAddress.setDbType("varchar(100)");
        
        this.RountingNo= new Field("RountingNo",this.getTableName());
        this.RountingNo.setDbType("varchar(100)");
        
        this.SwiftCode=new Field("SwiftCode",this.getTableName());
        this.SwiftCode.setDbType("varchar(100)");
        
        this.IbanNo=new Field("IbanNo",this.getTableName());
        this.IbanNo.setDbType("varchar(100)");
        
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.Summary);

        this.DbFields.add(this.Nationality);

        this.DbFields.add(this.Firm);

        this.DbFields.add(this.Bank);

        this.DbFields.add(this.Account);

        this.DbFields.add(this.AccountName);

        this.DbFields.add(this.LastName);

        this.DbFields.add(this.FirstName);
        
        this.DbFields.add(this.IdNo);

        this.DbFields.add(this.CertificateNo);

        this.DbFields.add(this.InCharge);

        this.DbFields.add(this.Contact);

        this.DbFields.add(this.Tel1);

        this.DbFields.add(this.Tel2);

        this.DbFields.add(this.Mobile);

        this.DbFields.add(this.Fax1);

        this.DbFields.add(this.Fax2);

        this.DbFields.add(this.Email);

        this.DbFields.add(this.Msn);

        this.DbFields.add(this.Skype);

        this.DbFields.add(this.Zip);

        this.DbFields.add(this.Address1);

        this.DbFields.add(this.EnglishAddress1);

        this.DbFields.add(this.Address2);

        this.DbFields.add(this.EnglishAddress2);
        this.DbFields.add(this.AttUrl);
        this.DbFields.add(this.Memo);
        
        this.DbFields.add(this.BankAddress);
        this.DbFields.add(this.RountingNo);
        this.DbFields.add(this.IbanNo);
        this.DbFields.add(this.SwiftCode);
        
        
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.Firm.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
        	this.Nationality.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Nationality.setSelectList(new Category().getChildList(this.Nationality));
            this.Nationality.setAnotherField(this.Firm);
            rtnString += this.printHtml(this.Nationality);
            
            this.LastName.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.FirstName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.FirstName.setAnotherField(this.LastName);
            rtnString += this.printHtml(this.FirstName);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
            rtnString += this.Summary.printHiddenTag();
            
            this.Firm.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Firm.setSize(72);
            rtnString += this.printHtml(this.Firm);
            
            this.AttUrl.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AttUrl.setSize(72);
            rtnString+=this.printHtml(this.AttUrl);
            
            this.CertificateNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Nationality.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Nationality.setSelectList(new Category().getChildList(this.Nationality));
            this.Nationality.setAnotherField(this.CertificateNo);
            this.Nationality.setColspan(1);
            rtnString += this.printHtml(this.Nationality);
            
            this.IdNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.FirstName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.FirstName.setAnotherField(this.IdNo);

            this.LastName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.LastName.setAnotherField(this.FirstName);
            rtnString += this.printHtml(this.LastName);

            this.Contact.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.InCharge.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InCharge.setAnotherField(this.Contact);
            this.InCharge.setColspan(1);
            rtnString += this.printHtml(this.InCharge);
            
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
            
            this.Mobile.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Email.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Email.setAnotherField(this.Mobile);
            this.Email.setSize(30);
            this.Email.setColspan(1);
            rtnString += this.printHtml(this.Email);

            this.Msn.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Msn.setSize(30);

            this.Skype.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Skype.setAnotherField(this.Msn);
            this.Skype.setSize(30);
            this.Skype.setColspan(1);
            rtnString += this.printHtml(this.Skype);

            this.AccountName.setHtmlType(Cnstnts.HTML_TAG_TEXT);            

            this.Bank.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Bank.setAnotherField(this.AccountName);
            this.Bank.setColspan(1);
            rtnString += this.printHtml(this.Bank);

            
            
            this.Zip.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.Account.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Account.setAnotherField(this.Zip);
            this.Account.setColspan(1);
            rtnString += this.printHtml(this.Account);

            
            this.SwiftCode.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.BankAddress.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.BankAddress.setAnotherField(this.SwiftCode);
            this.BankAddress.setColspan(1);
            rtnString += this.printHtml(this.BankAddress);
            
            
            this.IbanNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.RountingNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.RountingNo.setAnotherField(this.IbanNo);
            this.RountingNo.setColspan(1);
            rtnString += this.printHtml(this.RountingNo);
            
            
            this.Address1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Address1.setSize(72);
            rtnString += this.printHtml(this.Address1);
            
            this.Address2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Address2.setSize(72);
            rtnString += this.printHtml(this.Address2);

            this.EnglishAddress1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishAddress1.setSize(72);
            rtnString += this.printHtml(this.EnglishAddress1);

            this.EnglishAddress2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishAddress2.setSize(72);
            rtnString += this.printHtml(this.EnglishAddress2);

            this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            rtnString += this.printHtml(this.Memo);

            
            
        }
        return rtnString;
    }

    public void setSearchListPrpts() {
    	this.FlowKey.setListWidth("10%");
    	this.Firm.setListWidth("20%");

        this.Nationality.setListWidth("10%");

        this.FullName.setListWidth("10%");
        
        this.Tel1.setListWidth("10%");

        this.Fax1.setListWidth("10%");

        this.Address1.setListWidth("30%");

        Field[] showField = {this.FlowKey,this.Firm, this.Nationality, this.FullName, 
        					 this.Tel1, this.Fax1, this.Address1};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.Nationality);
        whereStr = Util.addWhereSQL(whereStr, this.Firm);
        whereStr = Util.addWhereSQL(whereStr, this.LastName);
        whereStr = Util.addWhereSQL(whereStr, this.FirstName);
        String alias= Cnstnts.EMPTY_STRING ;
        alias="CONCAT(LastName , FirstName) as FullName ";
        return this.doSearch(whereStr,alias);
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Firm);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            Attorney preObj = (Attorney) userInfo.getObj(this.getTableName());
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

}