package deepspot.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.util.Util;

public class Applicant extends MasterBean {

    public Applicant(){this.init();}

    public Applicant(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Summary;
    public void setSummary(String Summary){this.Summary.setValue(Summary);}
    public String getSummary(){return this.Summary.getValue();}

    public Field Client;
    public void setClient(String Client){this.Client.setValue(Client);}
    public String getClient(){return this.Client.getValue();}

    public Field Nationality;
    public void setNationality(String Nationality){this.Nationality.setValue(Nationality);}
    public String getNationality(){return this.Nationality.getValue();}

    public Field IdType;
    public void setIdType(String IdType){this.IdType.setValue(IdType);}
    public String getIdType(){return this.IdType.getValue();}

    public Field Names;
    public void setNames(String Names){this.Names.setValue(Names);}
    public String getNames(){return this.Names.getValue();}

    public Field EnglishNames;
    public void setEnglishNames(String EnglishNames){this.EnglishNames.setValue(EnglishNames);}
    public String getEnglishNames(){return this.EnglishNames.getValue();}

    public Field IdNo;
    public void setIdNo(String IdNo){this.IdNo.setValue(IdNo);}
    public String getIdNo(){return this.IdNo.getValue();}

    public Field CompanyReq;
    public void setCompanyReq(String CompanyReq){this.CompanyReq.setValue(CompanyReq);}
    public String getCompanyReq(){return this.CompanyReq.getValue();}

    public Field EnglishCompanyReq;
    public void setEnglishCompanyReq(String EnglishCompanyReq){this.EnglishCompanyReq.setValue(EnglishCompanyReq);}
    public String getEnglishCompanyReq(){return this.EnglishCompanyReq.getValue();}

    public Field TelNo;
    public void setTelNo(String TelNo){this.TelNo.setValue(TelNo);}
    public String getTelNo(){return this.TelNo.getValue();}

    public Field Mobile;
    public void setMobile(String Mobile){this.Mobile.setValue(Mobile);}
    public String getMobile(){return this.Mobile.getValue();}

    public Field Fax;
    public void setFax(String Fax){this.Fax.setValue(Fax);}
    public String getFax(){return this.Fax.getValue();}

    public Field Email;
    public void setEmail(String Email){this.Email.setValue(Email);}
    public String getEmail(){return this.Email.getValue();}

    public Field Zip;
    public void setZip(String Zip){this.Zip.setValue(Zip);}
    public String getZip(){return this.Zip.getValue();}

    public Field State;
    public void setState(String State){this.State.setValue(State);}
    public String getState(){return this.State.getValue();}

    public Field City;
    public void setCity(String City){this.City.setValue(City);}
    public String getCity(){return this.City.getValue();}

    public Field Address;
    public void setAddress(String Address){this.Address.setValue(Address);}
    public String getAddress(){return this.Address.getValue();}

    public Field EnglishAddress;
    public void setEnglishAddress(String EnglishAddress){this.EnglishAddress.setValue(EnglishAddress);}
    public String getEnglishAddress(){return this.EnglishAddress.getValue();}

    public Field Memo;
    public void setMemo(String Memo){this.Memo.setValue(Memo);}
    public String getMemo(){return this.Memo.getValue();}

    public Field Appendix;
    public void setAppendix(String Appendix){this.Appendix.setValue(Appendix);}
    public String getAppendix(){return this.Appendix.getValue();}

    public Field Birthday;
    public void setBirthday(String Birthday){this.Birthday.setValue(Birthday);}
    public String getBirthday(){return this.Birthday.getValue();}
    
    public Field IsAddInventor;
    public void setIsAddInventor(String IsAddInventor){this.IsAddInventor.setValue(IsAddInventor);}
    public String getIsAddInventor(){return this.IsAddInventor.getValue();}
    
    public void init() {
        super.init();
        this.setProgramId("jsp.Applicant");
        this.setTableName("Applicant");

        this.Summary = new Field("Summary", this.getTableName());
        this.Summary.setDbType("nvarchar(200)");

        this.Client = new Field("Client", this.getTableName());
        this.Client.setCheckEmpty(true);
        this.Client.setDbType("varchar(50)");

        this.Nationality = new Field("Nationality", this.getTableName());
        this.Nationality.setDbType("varchar(50)");

        this.IdType = new Field("IdType", this.getTableName());
        this.IdType.setDbType("varchar(50)");

        this.Names = new Field("Names", this.getTableName());
        this.Names.setDbType("nvarchar(100)");
        this.Names.setSearchCondition(Cnstnts.LEFT);

        this.EnglishNames = new Field("EnglishNames", this.getTableName());
        this.EnglishNames.setDbType("nvarchar(100)");

        this.IdNo = new Field("IdNo", this.getTableName());
        this.IdNo.setDbType("varchar(50)");

        this.CompanyReq = new Field("CompanyReq", this.getTableName());
        this.CompanyReq.setDbType("nvarchar(100)");

        this.EnglishCompanyReq = new Field("EnglishCompanyReq", this.getTableName());
        this.EnglishCompanyReq.setDbType("nvarchar(100)");

        this.TelNo = new Field("TelNo", this.getTableName());
        this.TelNo.setDbType("varchar(50)");

        this.Mobile = new Field("Mobile", this.getTableName());
        this.Mobile.setDbType("varchar(50)");

        this.Fax = new Field("Fax", this.getTableName());
        this.Fax.setDbType("varchar(50)");

        this.Email = new Field("Email", this.getTableName());
        this.Email.setDbType("varchar(50)");

        this.Zip = new Field("Zip", this.getTableName());
        this.Zip.setDbType("varchar(50)");

        this.State = new Field("State", this.getTableName());
        this.State.setDbType("nvarchar(50)");

        this.City = new Field("City", this.getTableName());
        this.City.setDbType("nvarchar(50)");

        this.Address = new Field("Address", this.getTableName());
        this.Address.setDbType("nvarchar(100)");

        this.EnglishAddress = new Field("EnglishAddress", this.getTableName());
        this.EnglishAddress.setDbType("nvarchar(100)");

        this.Memo = new Field("Memo", this.getTableName());
        this.Memo.setDbType("nvarchar(200)");

        this.Appendix = new Field("Appendix", this.getTableName());
        this.Appendix.setDbType("varchar(100)");

        this.Birthday = new Field("Birthday", this.getTableName());
        this.Birthday.setDbType("varchar(20)");
        
        this.IsAddInventor= new Field("IsAddInventor",this.getTableName());
        this.IsAddInventor.setDbType("char(1)");
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.Summary);

        this.DbFields.add(this.Client);

        this.DbFields.add(this.Nationality);

        this.DbFields.add(this.IdType);

        this.DbFields.add(this.Names);

        this.DbFields.add(this.EnglishNames);

        this.DbFields.add(this.IdNo);

        this.DbFields.add(this.CompanyReq);

        this.DbFields.add(this.EnglishCompanyReq);

        this.DbFields.add(this.TelNo);

        this.DbFields.add(this.Mobile);

        this.DbFields.add(this.Fax);

        this.DbFields.add(this.Email);

        this.DbFields.add(this.Zip);

        this.DbFields.add(this.State);

        this.DbFields.add(this.City);

        this.DbFields.add(this.Address);

        this.DbFields.add(this.EnglishAddress);

        this.DbFields.add(this.Memo);

        this.DbFields.add(this.Appendix);
        
        this.DbFields.add(this.Birthday);
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Names.setSize(10);
            
            this.IdType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.IdType.setSelectList(new Category().getChildList(this.IdType));
            this.IdType.setAnotherField(this.Names);
            
            this.Nationality.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Nationality.setSelectList(new Category().getChildList("PatentOffice"));
            this.Nationality.setAnotherField(this.IdType);
            rtnString += this.printHtml(this.Nationality);
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
            Field ClientName = new Field("ClientName",this.getTableName());
            ClientName.setValue(clientName);
            ClientName.setSize(40);
            ClientName.setReadonly(true);
            if(this.canEdit()){
            	ClientName.setButtonValue(this.getUserInfo().getMsg("jsp.Applicant.QueryClient"));
                ClientName.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=Client\",\"Client\",800,600)");
            }
            
            this.Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Client.setAnotherField(ClientName);
            this.Client.setOnChange("setValue()");
            rtnString += this.printHtml(this.Client);

            this.IdNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.IdType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.IdType.setSelectList(new Category().getChildList(this.IdType));
            this.IdType.setOnChange("setValue()");
            this.IdType.setAnotherField(this.IdNo);
            
            this.Nationality.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Nationality.setSelectList(new Category().getChildList("PatentOffice"));
            this.Nationality.setAnotherField(this.IdType);
            rtnString += this.printHtml(this.Nationality);
            
            this.EnglishNames.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishNames.setSize(30);

            this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Names.setAnotherField(this.EnglishNames);
            this.Names.setSize(30);
            this.Names.setColspan(1);
            rtnString += this.printHtml(this.Names);
            
            if(this.IdType.getValue().equals("Id01")){
            	this.CompanyReq.setValue(Cnstnts.EMPTY_STRING);
            	this.EnglishCompanyReq.setValue(Cnstnts.EMPTY_STRING);
            	rtnString += this.CompanyReq.printHiddenTag();
            	rtnString += this.EnglishCompanyReq.printHiddenTag();
            } else {
            	this.EnglishCompanyReq.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.EnglishCompanyReq.setSize(30);
                
                this.CompanyReq.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.CompanyReq.setAnotherField(this.EnglishCompanyReq);
                this.CompanyReq.setSize(30);
                this.CompanyReq.setColspan(1);
                rtnString += this.printHtml(this.CompanyReq);
            }
            
            this.Mobile.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.TelNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TelNo.setAnotherField(this.Mobile);
            this.TelNo.setColspan(1);
            rtnString += this.printHtml(this.TelNo);

            this.Fax.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Email.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Email.setAnotherField(this.Fax);
            this.Email.setSize(30);
            this.Email.setColspan(1);
            rtnString += this.printHtml(this.Email);
            
            this.City.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.State.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.State.setAnotherField(this.City);

            this.Zip.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Zip.setAnotherField(this.State);
            this.Zip.setSize(5);
            rtnString += this.printHtml(this.Zip);
            
            this.Address.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Address.setSize(60);
            rtnString += this.printHtml(this.Address);

            this.EnglishAddress.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishAddress.setSize(60);
            rtnString += this.printHtml(this.EnglishAddress);
            
            

            this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Memo.setRows(2);
            this.Memo.setCols(60);
            rtnString += this.printHtml(this.Memo);

            this.Appendix.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.Appendix);

            this.Birthday.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR );
            
            if(Cnstnts.INSERT.equals(this.getDbActionMode())){
            	 if(this.IdType.getValue().equals("Id01")){
            		 this.IsAddInventor.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
                 	 this.Birthday.setAnotherField(this.IsAddInventor);
            		 
            	 }
            	
            }
            rtnString +=this.printHtml(this.Birthday);
            
            
            rtnString += this.Summary.printHiddenTag();
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
        this.Client.setListWidth("20%");

        this.IdType.setListWidth("10%");

        this.Names.setListWidth("20%");
        
        this.Nationality.setListWidth("10%");
        this.Nationality.setMapingPrpt(categoryPrpt);
        this.Nationality.setNotShowCode(true);
        this.IdNo.setListWidth("10%");

        this.Address.setListWidth("30%");

        Field[] showField = {this.Client, this.Names, this.IdType, 
        					 this.Nationality, this.IdNo, this.Address};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.Nationality);
        whereStr = Util.addWhereSQL(whereStr, this.Names);
        whereStr = Util.addWhereSQL(whereStr, this.IdType);
        return this.doSearch(whereStr);
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Names);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            Applicant preObj = (Applicant) userInfo.getObj(this.getTableName());
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
    @SuppressWarnings("unchecked")
	public boolean insert() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.FlowKey.setValue(this.FlowKey.getValue().trim());
		this.setDbFields();
		sqlList.add(this.getDbUtil().getInsertSQL(this.getTableName(), this.DbFields));
		if (this.getIsAddInventor().equals("Y")) {
			Inventors inventor = new Inventors();
			inventor.setDbFields();
			inventor.CreateDept.setValue(this.CreateDept.getValue());
			inventor.Applicant.setValue(this.Applicant.getValue());
			inventor.Client.setValue(this.FlowKey.getValue());
			inventor.Nationality.setValue(this.Nationality.getValue());
			
			inventor.LastName.setValue(this.Names.getValue());
			inventor.FirstName.setValue("");
			
			inventor.EnglishLastName.setValue(this.EnglishNames.getValue());
			inventor.EnglishFirstName.setValue("");
			inventor.Company.setValue("");
			inventor.Department.setValue("");
			inventor.IdNo.setValue("");
			
			//inventor.EnglishNames.setValue(this.EnglishCompanyName.getValue());
			//inventor.IdNo.setValue(this.RegisteredNo.getValue());
			//inventor.CompanyReq.setValue(this.InCharge.getValue());
			//inventor.TelNo.setValue(this.Tel1.getValue());
			//inventor.Mobile.setValue(this.Mobile.getValue());
			//inventor.Fax.setValue(this.Fax1.getValue());
			//inventor.Email.setValue(this.Email.getValue());
			inventor.Zip.setValue(this.Zip.getValue());
			inventor.State.setValue(this.State.getValue());
			inventor.City.setValue(this.City.getValue());
			
			inventor.Address.setValue(this.Address.getValue());
			inventor.EnglishAddress.setValue(this.EnglishAddress.getValue());
			inventor.Memo.setValue(this.Memo.getValue());
			inventor.Appendix.setValue(this.Appendix.getValue());
			inventor.FlowKey.setValue(Util.getAutoNo(inventor.getProgramId()));
			sqlList.add(inventor.getDbUtil().getInsertSQL(inventor.getTableName(), inventor.DbFields));
		}
		return this.getDbUtil().executeUpdate(sqlList);
	}
}