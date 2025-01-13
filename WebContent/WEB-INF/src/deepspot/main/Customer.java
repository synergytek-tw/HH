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

public class Customer extends MasterBean {

    public Customer(){this.init();}

    public Customer(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Names;
    public void setNames(String Names){this.Names.setValue(Names);}
    public String getNames(){return this.Names.getValue();}
    
    public Field CustomerType;
    public void setCustomerType(String CustomerType){this.CustomerType.setValue(CustomerType);}
    public String getCustomerType(){return this.CustomerType.getValue();}
    
    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}
    
    public Field BonusParent;
    public void setBonusParent(String BonusParent){this.BonusParent.setValue(BonusParent);}
    public String getBonusParent(){return this.BonusParent.getValue();}

    public Field TelNo;
    public void setTelNo(String TelNo){this.TelNo.setValue(TelNo);}
    public String getTelNo(){return this.TelNo.getValue();}

    public Field Fax;
    public void setFax(String Fax){this.Fax.setValue(Fax);}
    public String getFax(){return this.Fax.getValue();}
    
    public Field CellNo;
    public void setCellNo(String CellNo){this.CellNo.setValue(CellNo);}
    public String getCellNo(){return this.CellNo.getValue();}

    public Field Email;
    public void setEmail(String Email){this.Email.setValue(Email);}
    public String getEmail(){return this.Email.getValue();}

    public Field Contact;
    public void setContact(String Contact){this.Contact.setValue(Contact);}
    public String getContact(){return this.Contact.getValue();}

    public Field Address;
    public void setAddress(String Address){this.Address.setValue(Address);}
    public String getAddress(){return this.Address.getValue();}
    
    public Field Birthday;
    public void setBirthday(String Birthday){this.Birthday.setValue(Birthday);}
    public String getBirthday(){return this.Birthday.getValue();}
    
    public Field Sex;
    public void setSex(String Sex){this.Sex.setValue(Sex);}
    public String getSex(){return this.Sex.getValue();}
    
    public Field RegisteredAddress;
    public void setRegisteredAddress(String RegisteredAddress){this.RegisteredAddress.setValue(RegisteredAddress);}
    public String getRegisteredAddress(){return this.RegisteredAddress.getValue();}
    
    public Field SameFlag;
    public void setSameFlag(String SameFlag){this.SameFlag.setValue(SameFlag);}
    public String getSameFlag(){return this.SameFlag.getValue();}

    public Field EnterpriseNo;
    public void setEnterpriseNo(String EnterpriseNo){this.EnterpriseNo.setValue(EnterpriseNo);}
    public String getEnterpriseNo(){return this.EnterpriseNo.getValue();}

    public Field CollectType;
    public void setCollectType(String CollectType){this.CollectType.setValue(CollectType);}
    public String getCollectType(){return this.CollectType.getValue();}

    public Field PriceDiscount;
    public void setPriceDiscount(String PriceDiscount){this.PriceDiscount.setValue(PriceDiscount);}
    public String getPriceDiscount(){return this.PriceDiscount.getValue();}

    public Field SpecialDiscount;
    public void setSpecialDiscount(String SpecialDiscount){this.SpecialDiscount.setValue(SpecialDiscount);}
    public String getSpecialDiscount(){return this.SpecialDiscount.getValue();}
    
    public Field PvRate;
    public void setPvRate(String PvRate){this.PvRate.setValue(PvRate);}
    public String getPvRate(){return this.PvRate.getValue();}

    public Field SaleDept;
    public void setSaleDept(String SaleDept){this.SaleDept.setValue(SaleDept);}
    public String getSaleDept(){return this.SaleDept.getValue();}
    
    public Field Salesponsor;
    public void setSalesponsor(String Salesponsor){this.Salesponsor.setValue(Salesponsor);}
    public String getSalesponsor(){return this.Salesponsor.getValue();}
    
    public Field IsVia;
    public void setIsVia(String IsVia){this.IsVia.setValue(IsVia);}
    public String getIsVia(){return this.IsVia.getValue();}
    
    public Field AmountFlag;
    public void setAmountFlag(String AmountFlag){this.AmountFlag.setValue(AmountFlag);}
    public String getAmountFlag(){return this.AmountFlag.getValue();}
    
    public Field Bank;
    public void setBank(String Bank){this.Bank.setValue(Bank);}
    public String getBank(){return this.Bank.getValue();}
    
    public Field Branch;
    public void setBranch(String Branch){this.Branch.setValue(Branch);}
    public String getBranch(){return this.Branch.getValue();}
    
    public Field AccountingName;
    public void setAccountingName(String AccountingName){this.AccountingName.setValue(AccountingName);}
    public String getAccountingName(){return this.AccountingName.getValue();}
    
    public Field AccountingNo;
    public void setAccountingNo(String AccountingNo){this.AccountingNo.setValue(AccountingNo);}
    public String getAccountingNo(){return this.AccountingNo.getValue();}
    
    public Field ApplyDate;
    public void setApplyDate(String ApplyDate){this.ApplyDate.setValue(ApplyDate);}
    public String getApplyDate(){return this.ApplyDate.getValue();}
    
    public Field MembershipDate;
    public void setMembershipDate(String MembershipDate){this.MembershipDate.setValue(MembershipDate);}
    public String getMembershipDate(){return this.MembershipDate.getValue();}
    
    public Field QualificationsDate;
    public void setQualificationsDate(String QualificationsDate){this.QualificationsDate.setValue(QualificationsDate);}
    public String getQualificationsDate(){return this.QualificationsDate.getValue();}
    
    public Field HasChildFlag;
    public void setHasChildFlag(String HasChildFlag){this.HasChildFlag.setValue(HasChildFlag);}
    public String getHasChildFlag(){return this.HasChildFlag.getValue();}
    
    public Field QueryId;
    public void setQueryId(String QueryId){this.QueryId.setValue(QueryId);}
    public String getQueryId(){return this.QueryId.getValue();}
    
    public Field QueryKey;
    public void setQueryKey(String QueryKey){this.QueryKey.setValue(QueryKey);}
    public String getQueryKey(){return this.QueryKey.getValue();}
    
    public Field Year;
    public void setYear(String Year){this.Year.setValue(Year);}
    public String getYear(){return this.Year.getValue();}
    
    public Field Month;
    public void setMonth(String Month){this.Month.setValue(Month);}
    public String getMonth(){return this.Month.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.Customer");
        this.setTableName("Customer");

        this.Names = new Field("Names", this.getTableName());
        this.Names.setCheckEmpty(true);
        this.Names.setSearchCondition(Cnstnts.LIKE);
        
        this.CustomerType = new Field("CustomerType", this.getTableName());
        
        this.ParentId = new Field("ParentId", this.getTableName());
        
        this.BonusParent = new Field("BonusParent", this.getTableName());

        this.TelNo = new Field("TelNo", this.getTableName());
        this.TelNo.setSearchCondition(Cnstnts.LIKE);

        this.CellNo = new Field("CellNo", this.getTableName());
        
        this.Fax = new Field("Fax", this.getTableName());

        this.Email = new Field("Email", this.getTableName());

        this.Contact = new Field("Contact", this.getTableName());

        this.Address = new Field("Address", this.getTableName());
        this.Address.setSearchCondition(Cnstnts.LIKE);
        
        this.RegisteredAddress = new Field("RegisteredAddress", this.getTableName());
        
        this.SameFlag = new Field("SameFlag", this.getTableName());
        
        this.Bank = new Field("Bank", this.getTableName());
        
        this.Branch = new Field("Branch", this.getTableName());
        
        this.AccountingName = new Field("AccountingName", this.getTableName());
        
        this.AccountingNo = new Field("AccountingNo", this.getTableName());

        this.EnterpriseNo = new Field("EnterpriseNo", this.getTableName());

        this.CollectType = new Field("CollectType", this.getTableName());

        this.PriceDiscount = new Field("PriceDiscount", this.getTableName());
        this.PriceDiscount.setValue("1");

        this.SpecialDiscount = new Field("SpecialDiscount", this.getTableName());
        this.SpecialDiscount.setValue("1");
        
        this.PvRate = new Field("PvRate", this.getTableName());

        this.SaleDept = new Field("SaleDept", this.getTableName());
        
        this.Salesponsor = new Field("Salesponsor", this.getTableName());
        
        this.IsVia = new Field("IsVia", this.getTableName());
        
        this.AmountFlag = new Field("AmountFlag", this.getTableName());
        
        this.ApplyDate = new Field("ApplyDate", this.getTableName());
        
        this.MembershipDate = new Field("MembershipDate", this.getTableName());
        
        this.QualificationsDate = new Field("QualificationsDate", this.getTableName());
        
        this.HasChildFlag = new Field("HasChildFlag", this.getTableName());
        
        this.Birthday = new Field("Birthday", this.getTableName());
        
        this.Sex = new Field("Sex", this.getTableName());
        
        this.Year = new Field("Year", this.getTableName());
        
        this.Month = new Field("Month", this.getTableName());
        
        this.QueryId = new Field("QueryId", this.getTableName());
        
        this.QueryKey = new Field("QueryKey", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.Names.setDbType("nvarchar(100)");
        this.DbFields.add(this.Names);
        
        this.CustomerType.setDbType("varchar(50)");
        this.DbFields.add(this.CustomerType);
        
        this.ParentId.setDbType("varchar(50)");
        this.DbFields.add(this.ParentId);
        
        this.BonusParent.setDbType("varchar(50)");
        this.DbFields.add(this.BonusParent);

        this.TelNo.setDbType("varchar(100)");
        this.DbFields.add(this.TelNo);

        this.CellNo.setDbType("varchar(20)");
        this.DbFields.add(this.CellNo);
        
        this.Fax.setDbType("varchar(20)");
        this.DbFields.add(this.Fax);

        this.Email.setDbType("varchar(50)");
        this.DbFields.add(this.Email);

        this.Contact.setDbType("nvarchar(50)");
        this.DbFields.add(this.Contact);

        this.Address.setDbType("nvarchar(200)");
        this.DbFields.add(this.Address);
        
        this.RegisteredAddress.setDbType("nvarchar(200)");
        this.DbFields.add(this.RegisteredAddress);
        
        this.SameFlag.setDbType("char(1)");
        this.DbFields.add(this.SameFlag);

        this.EnterpriseNo.setDbType("varchar(50)");
        this.DbFields.add(this.EnterpriseNo);

        this.CollectType.setDbType("varchar(50)");
        this.DbFields.add(this.CollectType);

        this.PriceDiscount.setDbType("float");
        this.DbFields.add(this.PriceDiscount);

        this.SpecialDiscount.setDbType("float");
        this.DbFields.add(this.SpecialDiscount);
        
        this.PvRate.setDbType("float");
        this.DbFields.add(this.PvRate);
        
        this.SaleDept.setDbType("varchar(50)");
        this.DbFields.add(this.SaleDept);
        
        this.Salesponsor.setDbType("varchar(50)");
        this.DbFields.add(this.Salesponsor);

        this.IsVia.setDbType("char(1)");
        this.DbFields.add(this.IsVia);
        
        this.AmountFlag.setDbType("char(1)");
        this.DbFields.add(this.AmountFlag);
        
        this.HasChildFlag.setDbType("char(1)");
        this.DbFields.add(this.HasChildFlag);

        this.Bank.setDbType("nvarchar(50)");
        this.DbFields.add(this.Bank);
        
        this.Branch.setDbType("nvarchar(50)");
        this.DbFields.add(this.Branch);
        
        this.AccountingName.setDbType("nvarchar(50)");
        this.DbFields.add(this.AccountingName);
        
        this.AccountingNo.setDbType("varchar(50)");
        this.DbFields.add(this.AccountingNo);
        
        this.ApplyDate.setDbType("varchar(10)");
        this.DbFields.add(this.ApplyDate);
        
        this.MembershipDate.setDbType("varchar(10)");
        this.DbFields.add(this.MembershipDate);
        
        this.QualificationsDate.setDbType("varchar(10)");
        this.DbFields.add(this.QualificationsDate);
        
        this.Birthday.setDbType("varchar(10)");
        this.DbFields.add(this.Birthday);
        
        this.Sex.setDbType("varchar(10)");
        this.DbFields.add(this.Sex);
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	/*
        	this.Salesponsor.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	if(this.canEdit() && this.SaleDept.getValue().trim().length()>0){
            	this.Salesponsor.setSelectList(
            			new Employee().getDepartmentList(this.SaleDept.getValue()));
            } else {
            	this.Salesponsor.setSelectList(new Employee().getList());
            }
        	
        	this.SaleDept.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	if(this.canEdit()){
        		this.SaleDept.setSelectList(new Department().getCompanyTreeList(
            			this.getUserInfo().getAttribute("dept_id")));
        	} else {
        		this.SaleDept.setSelectList(new Department().getList());
        	}
        	this.SaleDept.setOnChange("setValue()");
        	this.SaleDept.setAnotherField(this.Salesponsor);
        	rtnString += this.printHtml(this.SaleDept);
        	        	
        	this.ParentId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ParentId.setMapingPrpt(null);
            
            this.CustomerType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CustomerType.setSelectList(new Category().getChildList(this.CustomerType));
            this.CustomerType.setAnotherField(this.ParentId);
            rtnString += this.printHtml(this.CustomerType);
            */
            this.TelNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
            this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Names.setAnotherField(this.TelNo);
            rtnString += this.printHtml(this.Names);
            
            this.Address.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Address.setRows(2);
            rtnString += this.printHtml(this.Address);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
            this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Names.setSize(50);
            rtnString += this.printHtml(this.Names);
            /*
            this.ParentId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ParentId.setOnChange("setValue()");
            if(this.ParentId.getValue().trim().length()==0){
            	this.ParentId.setMapingPrpt(null);
            } else {
            	rtnString += this.ParentId.printHiddenTag();
            }
            if(this.canEdit()){
            	if(this.ParentId.getValue().trim().length()==0){
            		this.ParentId.setButtonValue(this.getUserInfo().getMsg("jsp.ProductSale.CustomerQuery"));
                    this.ParentId.setButtonClick(
                    		"openAppendix(\"CustomerQuery.jsp?obj_id=parentId\",\"CustomerQuery\",800,600)");
            	} else {
            		this.ParentId.setButtonValue(this.getUserInfo().getMsg("jsp.common.clear"));
                    this.ParentId.setButtonClick("document.input.parentId.value=\"\";setValue()");
            	}
            }
            
            this.CustomerType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CustomerType.setSelectList(new Category().getChildList(this.CustomerType));
            this.CustomerType.setAnotherField(this.ParentId);
            this.CustomerType.setOnChange("setValue()");
            rtnString += this.printHtml(this.CustomerType);
            
            this.Birthday.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.Sex.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Sex.setSelectList(new Category().getChildList(this.Sex));
            this.Sex.setAnotherField(this.Birthday);
            rtnString += this.printHtml(this.Sex);
			*/
            this.Fax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Fax.setSize(10);
            
            this.CellNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.CellNo.setSize(10);
            this.CellNo.setAnotherField(this.Fax);
                        
            this.TelNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TelNo.setSize(15);
            this.TelNo.setAnotherField(this.CellNo);
            rtnString += this.printHtml(this.TelNo);

            this.Email.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Email.setSize(50);
            rtnString += this.printHtml(this.Email);
            /*
            this.RegisteredAddress.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.RegisteredAddress.setRows(2);
            rtnString += this.printHtml(this.RegisteredAddress);
			
            this.SameFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.SameFlag.setOnClick("setValue()");
            
            if(this.SameFlag.getValue().equals("Y")){
            	this.Address.setValue(this.RegisteredAddress.getValue());
            	this.Address.setReadonly(true);
            } else {
            	this.Address.setValue(Cnstnts.EMPTY_STRING);
            }
            */
            this.Address.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Address.setRows(2);
            //this.Address.setAnotherField(this.SameFlag);
            rtnString += this.printHtml(this.Address);
            
            this.Contact.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.EnterpriseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnterpriseNo.setAnotherField(this.Contact);
            rtnString += this.printHtml(this.EnterpriseNo);
            /*
            this.PvRate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.PvRate.setSize(1);
            */
            this.SpecialDiscount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.SpecialDiscount.setSize(1);
            //this.SpecialDiscount.setAnotherField(this.PvRate);
            
            this.PriceDiscount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.PriceDiscount.setSize(1);
            this.PriceDiscount.setAnotherField(this.SpecialDiscount);
            
            this.CollectType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CollectType.setSelectList(new Category().getChildList(this.CollectType));
            this.CollectType.setAnotherField(this.PriceDiscount);
            rtnString += this.printHtml(this.CollectType);
            
            this.AmountFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            
            this.IsVia.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.IsVia.setAnotherField(this.AmountFlag);
            
            if(this.ApplyDate.getValue().trim().length()==0 && this.canEdit()){
            	this.ApplyDate.setValue(Util.getDate());
            }
            this.ApplyDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ApplyDate.setAnotherField(this.IsVia);
            rtnString += this.printHtml(this.ApplyDate);
            /*
            this.Branch.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.Bank.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Bank.setAnotherField(this.Branch);
            rtnString += this.printHtml(this.Bank);
            
            this.AccountingNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.AccountingName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AccountingName.setAnotherField(this.AccountingNo);
            rtnString += this.printHtml(this.AccountingName);	
        	*/
            rtnString += this.BonusParent.printHiddenTag();
            rtnString += this.QualificationsDate.printHiddenTag();
            rtnString += this.MembershipDate.printHiddenTag();
            rtnString += this.SaleDept.printHiddenTag();
            rtnString += this.Salesponsor.printHiddenTag();
            rtnString += this.HasChildFlag.printHiddenTag();
        }
        return rtnString;
    }

    public void setSearchListPrpts() {
    	this.FlowKey.setListWidth("10%");

        this.Names.setListWidth("20%");

        this.TelNo.setListWidth("15%");

        this.Address.setListWidth("40%");

        this.CellNo.setListWidth("15%");

        Field[] showField = {this.FlowKey, this.Names, this.TelNo, 
        		this.CellNo, this.Address};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
    	this.ParentId.setMapingPrpt(this.getNamesPrpts());
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.Names);
        whereStr = Util.addWhereSQL(whereStr, this.TelNo);
        whereStr = Util.addWhereSQL(whereStr, this.Address);
        whereStr = Util.addWhereSQL(whereStr, this.ParentId);
        whereStr = Util.addWhereSQL(whereStr, this.SaleDept);
        whereStr = Util.addWhereSQL(whereStr, this.Salesponsor);
        whereStr = Util.addWhereSQL(whereStr, this.CustomerType);
        return this.doSearch(whereStr);
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Names);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            Customer preObj = (Customer) userInfo.getObj(this.getTableName());
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
    
    private void setHasChildFlagAll(){
    	List<String> SqlList=new ArrayList<String>();
    	String SQL ="update Customer set HasChildFlag='N'";
    	SqlList.add(SQL);
    	SQL ="update Customer set HasChildFlag='Y' where FlowKey in(select ParentId from Customer where ParentId!='')";
    	SqlList.add(SQL);
    	this.getDbUtil().executeUpdate(SqlList);
    }
    
    public SelectItem getSelectItem(){
    	this.setHasChildFlagAll();
		SelectItem rtnItem = new SelectItem(this.getFlowKey(),this.getNames());
		rtnItem.setParentKey(this.getParentId());
		boolean hasChild = false;
		if(this.getHasChildFlag().equals("Y")){
			hasChild = true;
		}
		rtnItem.setChildFlag(hasChild);
		return rtnItem;
	}
    
    public List<SelectItem> getRootTreeList() {
    	SelectItem item = this.getSelectItem();
    	item.setChildFlag(true);
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		rtnList = this.walkMemberTree(item, rtnList);
		return rtnList;
	}
    
    public List<SelectItem> getMemberTreeList(SelectItem item) {
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		rtnList = this.walkMemberTree(item, rtnList);
		return rtnList;
	}
    
    public List<SelectItem> getMemberTreeList(SelectItem item, Field dateField) {
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		rtnList = this.walkMemberTree(item, rtnList, dateField);
		return rtnList;
	}
    
    public List<SelectItem> getPvTreeList(SelectItem item) throws Exception {
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		rtnList = this.walkPvTree(item, rtnList, this.getCustomerTypePrpts(), new Customer(item.getKey()).getCustomerType());
		return rtnList;
	}
    
    public List<SelectItem> getPvTreeList(SelectItem item, Field dateField) throws Exception {
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		rtnList = this.walkPvTree(item, rtnList, this.getCustomerTypePrpts(), new Customer(item.getKey()).getCustomerType(), dateField);
		return rtnList;
	}
    
    public List<SelectItem> getBonusTreeList(SelectItem item) throws Exception {
    	this.compressBounsOrg();
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		rtnList = this.walkBonusTree(item, rtnList, this.getCustomerTypePrpts(), new Customer(item.getKey()).getCustomerType());
		return rtnList;
	}
    
    public List<SelectItem> getBonusTreeList(SelectItem item, Field dateField) throws Exception {
    	this.compressBounsOrg();
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		rtnList = this.walkBonusTree(item, rtnList, this.getCustomerTypePrpts(), new Customer(item.getKey()).getCustomerType(), dateField);
		return rtnList;
	}
	
	private List<SelectItem> walkMemberTree(SelectItem item, List<SelectItem> itemList){
		if(!item.hasChild()){
			return itemList;
		}
		for(Iterator<?> itr=this.getChildList(item).iterator();itr.hasNext();){
			SelectItem childItem = (SelectItem)itr.next();
			if(item.onlyMenu()){
				if(childItem.hasChild()){
					itemList.add(childItem);
				}
			} else {
				itemList.add(childItem);
			}
			if(childItem.hasChild()){
				this.walkMemberTree(childItem, itemList);
			}
		}
		return itemList;
	}
	
	private List<SelectItem> walkMemberTree(SelectItem item, List<SelectItem> itemList,  Field dateField){
		if(!item.hasChild()){
			return itemList;
		}
		for(Iterator<?> itr=this.getChildList(item, dateField).iterator();itr.hasNext();){
			SelectItem childItem = (SelectItem)itr.next();
			if(item.onlyMenu()){
				if(childItem.hasChild()){
					itemList.add(childItem);
				}
			} else {
				itemList.add(childItem);
			}
			if(childItem.hasChild()){
				this.walkMemberTree(childItem, itemList, dateField);
			}
		}
		return itemList;
	}
	
	private List<SelectItem> walkPvTree(SelectItem item, List<SelectItem> itemList, Properties customerTypePrpts, String customerType){
		if(!item.hasChild()){
			return itemList;
		}
		for(Iterator<?> itr=this.getChildList(item).iterator();itr.hasNext();){
			SelectItem childItem = (SelectItem)itr.next();
			String childType = customerTypePrpts.getProperty(childItem.getKey());
			if(item.onlyMenu()){
				if(customerType.trim().length()>0){
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							itemList.add(childItem);
						} else {
							if(childType.equals("10")){
								itemList.add(childItem);
							}
						}
					} else {
						itemList.add(childItem);
					}
				}
			} else {
				if(customerType.trim().length()>0){
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							itemList.add(childItem);
						} else {
							if(childType.equals("10")){
								itemList.add(childItem);
							}
						}
					} else {
						itemList.add(childItem);
					}
				}
			}
			if(childItem.hasChild()){
				if(customerType.trim().length()>0){
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							this.walkPvTree(childItem, itemList, customerTypePrpts, customerType);
						} else {
							if(childType.equals("10")){
								this.walkPvTree(childItem, itemList, customerTypePrpts, customerType);
							}
						}
					} else {
						this.walkPvTree(childItem, itemList, customerTypePrpts, customerType);
					}
				}
			} 
		}
		return itemList;
	}
	
	private List<SelectItem> walkPvTree(SelectItem item, List<SelectItem> itemList, Properties customerTypePrpts, String customerType, Field dateField){
		if(!item.hasChild()){
			return itemList;
		}
		for(Iterator<?> itr=this.getChildList(item, dateField).iterator();itr.hasNext();){
			SelectItem childItem = (SelectItem)itr.next();
			String childType = customerTypePrpts.getProperty(childItem.getKey());
			if(item.onlyMenu()){
				if(customerType.trim().length()>0){
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							itemList.add(childItem);
						} else {
							if(childType.equals("10")){
								itemList.add(childItem);
							}
						}
					} else {
						itemList.add(childItem);
					}
				}
			} else {
				if(customerType.trim().length()>0){
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							itemList.add(childItem);
						} else {
							if(childType.equals("10")){
								itemList.add(childItem);
							}
						}
					} else {
						itemList.add(childItem);
					}
				}
			}
			if(childItem.hasChild()){
				if(customerType.trim().length()>0){
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							this.walkPvTree(childItem, itemList, customerTypePrpts, customerType, dateField);
						} else {
							if(childType.equals("10")){
								this.walkPvTree(childItem, itemList, customerTypePrpts, customerType);
							}
						}
					} else {
						this.walkPvTree(childItem, itemList, customerTypePrpts, customerType, dateField);
					}
				}
			}
		}
		return itemList;
	}
	
	private List<SelectItem> walkBonusTree(SelectItem item, List<SelectItem> itemList, Properties customerTypePrpts, String customerType){
		if(!item.hasChild()){
			return itemList;
		}
		for(Iterator<?> itr=this.getBonusChildList(item).iterator();itr.hasNext();){
			SelectItem childItem = (SelectItem)itr.next();
			if(item.onlyMenu()){
				if(customerType.trim().length()>0){
					String childType = customerTypePrpts.getProperty(childItem.getKey());
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							itemList.add(childItem);
						}
					} else {
						itemList.add(childItem);
					}
				}
			} else {
				if(customerType.trim().length()>0){
					String childType = customerTypePrpts.getProperty(childItem.getKey());
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							itemList.add(childItem);
						}
					} else {
						itemList.add(childItem);
					}
				}
			}
			if(childItem.hasChild()){
				if(customerType.trim().length()>0){
					String childType = customerTypePrpts.getProperty(childItem.getKey());
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							this.walkBonusTree(childItem, itemList, customerTypePrpts, customerType);
						}
					} else {
						this.walkBonusTree(childItem, itemList, customerTypePrpts, customerType);
					}
				}
			}
		}
		return itemList;
	}
	
	private List<SelectItem> walkBonusTree(SelectItem item, List<SelectItem> itemList, Properties customerTypePrpts, String customerType, Field dateField){
		if(!item.hasChild()){
			return itemList;
		}
		for(Iterator<?> itr=this.getBonusChildList(item, dateField).iterator();itr.hasNext();){
			SelectItem childItem = (SelectItem)itr.next();
			if(item.onlyMenu()){
				if(customerType.trim().length()>0){
					String childType = customerTypePrpts.getProperty(childItem.getKey());
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							itemList.add(childItem);
						}
					} else {
						itemList.add(childItem);
					}
				}
			} else {
				if(customerType.trim().length()>0){
					String childType = customerTypePrpts.getProperty(childItem.getKey());
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							itemList.add(childItem);
						}
					} else {
						itemList.add(childItem);
					}
				}
			}
			if(childItem.hasChild()){
				if(customerType.trim().length()>0){
					String childType = customerTypePrpts.getProperty(childItem.getKey());
					if(childType.trim().length()>0){
						if(Integer.parseInt(customerType)>Integer.parseInt(childType)){
							this.walkBonusTree(childItem, itemList, customerTypePrpts, customerType, dateField);
						}
					} else {
						this.walkBonusTree(childItem, itemList, customerTypePrpts, customerType, dateField);
					}
				}
			}
		}
		return itemList;
	}
	
	public List<SelectItem> getChildList(SelectItem item){
		return this.getDbUtil().getChildList(item, this.ParentId, 
											   this.Names, this.HasChildFlag);
	}
	
	public List<SelectItem> getChildList(SelectItem item, Field dateField){
		return this.getDbUtil().getChildList(item, this.ParentId, 
											   this.Names, this.HasChildFlag, dateField);
	}
	
	public List<SelectItem> getBonusChildList(SelectItem item){
		return this.getDbUtil().getChildList(item, this.BonusParent, 
											   this.Names, this.HasChildFlag);
	}
	
	public List<SelectItem> getBonusChildList(SelectItem item, Field dateField){
		return this.getDbUtil().getChildList(item, this.BonusParent, 
											   this.Names, this.HasChildFlag, dateField);
	}
	
	public Properties getCustomerTypePrpts() throws Exception{
		return this.getDbUtil().getNamesPrpts(this.CustomerType);
	}
	
	public int getOrgPv(SelectItem item, Field dateField, Properties monthPv) throws Exception{
		int orgPv = 0;
		if(monthPv.getProperty(item.getKey())!=null){
			orgPv += Integer.parseInt(monthPv.getProperty(item.getKey()));
		}
		for(Iterator<?> itr=this.getPvTreeList(item,dateField).iterator();itr.hasNext();){
			SelectItem childItem = (SelectItem)itr.next();
			if(monthPv.getProperty(childItem.getKey())!=null){
				orgPv += Integer.parseInt(monthPv.getProperty(childItem.getKey()));
			}
		}
		return orgPv;
	}
	
	public int getGroupPv(SelectItem item, Field dateField, Properties monthPv) throws Exception{
		int orgPv = 0;
		if(monthPv.getProperty(item.getKey())!=null){
			orgPv += Integer.parseInt(monthPv.getProperty(item.getKey()));
		}
		for(Iterator<?> itr=this.getChildList(item,dateField).iterator();itr.hasNext();){
			SelectItem childItem = (SelectItem)itr.next();
			if(monthPv.getProperty(childItem.getKey())!=null){
				orgPv += Integer.parseInt(monthPv.getProperty(childItem.getKey()));
			}
		}
		return orgPv;
	}
	
	public void compressBounsOrg() throws Exception{
		List<String> sqlList = new ArrayList<String>();
		sqlList.add("update Customer set BonusParent=ParentId");
		this.getDbUtil().executeUpdate(sqlList);
		/*
		while(true){
			List<SelectItem> compressList = this.getComPressList();
			if(compressList.size()==0){
				return;
			}
			String SQL = "select FlowKey, BonusParent from Customer";
			Properties Parents = this.getDbUtil().getFieldPrpts(SQL, "BonusParent");
			sqlList.clear();
			for(Iterator itr=compressList.iterator();itr.hasNext();){
				SelectItem item = (SelectItem)itr.next();
				SQL = "update Customer set BonusParent='"+Parents.getProperty(Parents.getProperty(item.getKey()))+"' where FlowKey='"+item.getKey()+"'";
				//System.out.println(SQL);
				sqlList.add(SQL);
			}
			this.getDbUtil().executeUpdate(sqlList);
		}
		*/
	}

}