package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.Html;
import deepspot.util.Util;

public class PatentMatterConfig extends MasterBean {

    public PatentMatterConfig(){this.init();}

    public PatentMatterConfig(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field MatterDisciption;
    public void setMatterDisciption(String MatterDisciption){this.MatterDisciption.setValue(MatterDisciption);}
    public String getMatterDisciption(){return this.MatterDisciption.getValue();}

    public Field MatterID;
    public void setMatterID(String MatterID){this.MatterID.setValue(MatterID);}
    public String getMatterID(){return this.MatterID.getValue();}

    public Field MatterName;
    public void setMatterName(String MatterName){this.MatterName.setValue(MatterName);}
    public String getMatterName(){return this.MatterName.getValue();}

    public Field PatentOffice;
    public void setPatentOffice(String PatentOffice){this.PatentOffice.setValue(PatentOffice);}
    public String getPatentOffice(){return this.PatentOffice.getValue();}

    public Field PatentType;
    public void setPatentType(String PatentType){this.PatentType.setValue(PatentType);}
    public String getPatentType(){return this.PatentType.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.PatentMatterConfig");
        this.setTableName("PatentMatterConfig");

        this.MatterDisciption = new Field("MatterDisciption", this.getTableName());
        this.MatterDisciption.setDbType("varchar(200)");

        this.MatterID = new Field("MatterID", this.getTableName());
        this.MatterID.setDbType("varchar(20)");

        this.MatterName = new Field("MatterName", this.getTableName());
        this.MatterName.setDbType("nvarchar(50)");

        this.PatentOffice = new Field("PatentOffice", this.getTableName());
        this.PatentOffice.setDbType("varchar(50)");

        this.PatentType = new Field("PatentType", this.getTableName());
        this.PatentType.setDbType("varchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.MatterDisciption);

        this.DbFields.add(this.MatterID);

        this.DbFields.add(this.MatterName);

        this.DbFields.add(this.PatentOffice);

        this.DbFields.add(this.PatentType);

    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
            this.MatterDisciption.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.MatterDisciption);

            this.MatterID.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.MatterID);

            this.MatterName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.MatterName);

            this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PatentOffice);

            this.PatentType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PatentType);

        }
        return rtnString;
    }

    public void setSearchListPrpts() {
        Field[] showField = {};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        return this.doSearch(whereStr);
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Names);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            PatentMatterConfig preObj = (PatentMatterConfig) userInfo.getObj(this.getTableName());
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