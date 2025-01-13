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

public class HourlyCharge extends MasterBean {

    public HourlyCharge(){this.init();}

    public HourlyCharge(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field SalaryPoint;
    public void setSalaryPoint(String SalaryPoint){this.SalaryPoint.setValue(SalaryPoint);}
    public String getSalaryPoint(){return this.SalaryPoint.getValue();}

    public Field HourlyRate;
    public void setHourlyRate(String HourlyRate){this.HourlyRate.setValue(HourlyRate);}
    public String getHourlyRate(){return this.HourlyRate.getValue();}

    public Field Currency;
    public void setCurrency(String Currency){this.Currency.setValue(Currency);}
    public String getCurrency(){return this.Currency.getValue();}

    public Field Command;
    public void setCommand(String Command){this.Command.setValue(Command);}
    public String getCommand(){return this.Command.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.HourlyCharge");
        this.setTableName("HourlyCharge");

        this.SalaryPoint = new Field("SalaryPoint", this.getTableName());
        this.SalaryPoint.setDbType("varchar(50)");

        this.HourlyRate = new Field("HourlyRate", this.getTableName());
        this.HourlyRate.setDbType("varchar(10)");

        this.Currency = new Field("Currency", this.getTableName());
        this.Currency.setDbType("varchar(50)");

        this.Command = new Field("Command", this.getTableName());
        this.Command.setDbType("varchar(200)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.SalaryPoint);

        this.DbFields.add(this.HourlyRate);

        this.DbFields.add(this.Currency);

        this.DbFields.add(this.Command);

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
            this.SalaryPoint.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.SalaryPoint);

            this.HourlyRate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.HourlyRate);

            this.Currency.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Currency);

            this.Command.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Command);

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
        return super.getNamesPrpts(this.Summary);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            HourlyCharge preObj = (HourlyCharge) userInfo.getObj(this.getTableName());
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