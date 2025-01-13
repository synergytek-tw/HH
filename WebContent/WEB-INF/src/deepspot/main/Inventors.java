package deepspot.main;

import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.util.Util;

public class Inventors extends MasterBean {

    public Inventors(){this.init();}

    public Inventors(String FlowKey) {
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
    
    public Field Company;
    public void setCompany(String Company){this.Company.setValue(Company);}
    public String getCompany(){return this.Company.getValue();}    

    public Field Department;
    public void setDepartment(String Department){this.Department.setValue(Department);}
    public String getDepartment(){return this.Department.getValue();}

    public Field Nationality;
    public void setNationality(String Nationality){this.Nationality.setValue(Nationality);}
    public String getNationality(){return this.Nationality.getValue();}

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
    
    public Field IdNo;
    public void setIdNo(String IdNo){this.IdNo.setValue(IdNo);}
    public String getIdNo(){return this.IdNo.getValue();}
    
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

    public void init() {
        super.init();
        this.setProgramId("jsp.Inventors");
        this.setTableName("Inventors");

        this.Summary = new Field("Summary", this.getTableName());
        this.Summary.setDbType("nvarchar(200)");

        this.Client = new Field("Client", this.getTableName());
        this.Client.setDbType("varchar(50)");
        
        this.Company = new Field("Company", this.getTableName());
        this.Company.setDbType("varchar(50)");
        
        this.Department = new Field("Department", this.getTableName());
        this.Department.setDbType("nvarchar(50)");

        this.Nationality = new Field("Nationality", this.getTableName());
        this.Nationality.setDbType("varchar(50)");
        this.Nationality.setCheckEmpty(true);

        this.LastName = new Field("LastName", this.getTableName());
        this.LastName.setDbType("nvarchar(50)");
        this.LastName.setCheckEmpty(true);
        this.LastName.setSearchCondition(Cnstnts.LIKE);

        this.FirstName = new Field("FirstName", this.getTableName());
        this.FirstName.setDbType("nvarchar(50)");
        this.FirstName.setCheckEmpty(true);
        this.LastName.setSearchCondition(Cnstnts.LIKE);

        this.EnglishLastName = new Field("EnglishLastName", this.getTableName());
        this.EnglishLastName.setDbType("varchar(50)");
        this.EnglishLastName.setSearchCondition(Cnstnts.LIKE);

        this.EnglishFirstName = new Field("EnglishFirstName", this.getTableName());
        this.EnglishFirstName.setDbType("varchar(50)");
        this.EnglishFirstName.setSearchCondition(Cnstnts.LIKE);

        this.IdNo = new Field("IdNo", this.getTableName());
        this.IdNo.setDbType("varchar(50)");

        this.Zip = new Field("Zip", this.getTableName());
        this.Zip.setDbType("varchar(50)");

        this.State = new Field("State", this.getTableName());
        this.State.setDbType("nvarchar(50)");

        this.City = new Field("City", this.getTableName());
        this.City.setDbType("nvarchar(50)");

        this.Address = new Field("Address", this.getTableName());
        this.Address.setDbType("nvarchar(200)");

        this.EnglishAddress = new Field("EnglishAddress", this.getTableName());
        this.EnglishAddress.setDbType("varchar(200)");

        this.Memo = new Field("Memo", this.getTableName());
        this.Memo.setDbType("nvarchar(200)");

        this.Appendix = new Field("Appendix", this.getTableName());
        this.Appendix.setDbType("varchar(100)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.Summary);

        this.DbFields.add(this.Client);
        
        this.DbFields.add(this.Company);
        
        this.DbFields.add(this.Department);

        this.DbFields.add(this.Nationality);

        this.DbFields.add(this.LastName);

        this.DbFields.add(this.FirstName);

        this.DbFields.add(this.EnglishLastName);

        this.DbFields.add(this.EnglishFirstName);

        this.DbFields.add(this.IdNo);

        this.DbFields.add(this.Zip);

        this.DbFields.add(this.State);

        this.DbFields.add(this.City);

        this.DbFields.add(this.Address);

        this.DbFields.add(this.EnglishAddress);

        this.DbFields.add(this.Memo);

        this.DbFields.add(this.Appendix);
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {     
        	this.FirstName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.FirstName.setSize(10);
            
            this.LastName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.LastName.setSize(10);
            this.LastName.setAnotherField(this.FirstName);
            
            this.Nationality.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Nationality.setSelectList(new Category().getChildList(this.Nationality));
            this.Nationality.setAnotherField(this.LastName);
            rtnString += this.printHtml(this.Nationality);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	this.Department.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Company.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Company.setAnotherField(this.Department);
            this.Company.setColspan(1);
            rtnString += this.printHtml(this.Company);
            
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

            this.FirstName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.LastName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.LastName.setAnotherField(this.FirstName);
            this.LastName.setColspan(1);
            rtnString += this.printHtml(this.LastName);

            this.EnglishFirstName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.EnglishLastName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishLastName.setAnotherField(this.EnglishFirstName);
            this.EnglishLastName.setColspan(1);
            rtnString += this.printHtml(this.EnglishLastName);
            
            this.IdNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.Nationality.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Nationality.setSelectList(new Category().getChildList(this.Nationality));
            this.Nationality.setAnotherField(this.IdNo);
            this.Nationality.setColspan(1);
            rtnString += this.printHtml(this.Nationality);

            this.Address.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Address.setSize(60);
            rtnString += this.printHtml(this.Address);

            this.EnglishAddress.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.EnglishAddress.setSize(60);
            rtnString += this.printHtml(this.EnglishAddress);
            
            this.City.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.State.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.State.setAnotherField(this.City);

            this.Zip.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Zip.setAnotherField(this.State);
            this.Zip.setSize(5);
            rtnString += this.printHtml(this.Zip);

            this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Memo.setRows(2);
            this.Memo.setCols(60);
            rtnString += this.printHtml(this.Memo);

            this.Appendix.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.Appendix);
            
            rtnString += this.Appendix.printHiddenTag();
        }
        return rtnString;
    }

    public void setSearchListPrpts() {
        this.Client.setListWidth("20%");

        this.LastName.setListWidth("10%");

        this.FirstName.setListWidth("10%");
        
        this.Nationality.setListWidth("10%");

        this.IdNo.setListWidth("10%");

        this.Address.setListWidth("40%");

        Field[] showField = {this.Client, this.LastName, this.FirstName, 
        					 this.Nationality, this.IdNo, this.Address};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.Nationality);
        whereStr = Util.addWhereSQL(whereStr, this.LastName);
        whereStr = Util.addWhereSQL(whereStr, this.FirstName);
        return this.doSearch(whereStr);
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Summary);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            Inventors preObj = (Inventors) userInfo.getObj(this.getTableName());
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