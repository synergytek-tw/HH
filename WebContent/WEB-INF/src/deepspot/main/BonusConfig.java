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

public class BonusConfig extends MasterBean {

    public BonusConfig(){this.init();}

    public BonusConfig(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field BonusAmount;
    public void setBonusAmount(String BonusAmount){this.BonusAmount.setValue(BonusAmount);}
    public String getBonusAmount(){return this.BonusAmount.getValue();}

    public Field BonusDiscription;
    public void setBonusDiscription(String BonusDiscription){this.BonusDiscription.setValue(BonusDiscription);}
    public String getBonusDiscription(){return this.BonusDiscription.getValue();}

    public Field BonusStatus;
    public void setBonusStatus(String BonusStatus){this.BonusStatus.setValue(BonusStatus);}
    public String getBonusStatus(){return this.BonusStatus.getValue();}

    public Field BonusTitle;
    public void setBonusTitle(String BonusTitle){this.BonusTitle.setValue(BonusTitle);}
    public String getBonusTitle(){return this.BonusTitle.getValue();}

    public Field Currency;
    public void setCurrency(String Currency){this.Currency.setValue(Currency);}
    public String getCurrency(){return this.Currency.getValue();}

    public Field Formular;
    public void setFormular(String Formular){this.Formular.setValue(Formular);}
    public String getFormular(){return this.Formular.getValue();}

    public Field NextBonusStatus;
    public void setNextBonusStatus(String NextBonusStatus){this.NextBonusStatus.setValue(NextBonusStatus);}
    public String getNextBonusStatus(){return this.NextBonusStatus.getValue();}

    public Field NtdwoTaxAmount;
    public void setNtdwoTaxAmount(String NtdwoTaxAmount){this.NtdwoTaxAmount.setValue(NtdwoTaxAmount);}
    public String getNtdwoTaxAmount(){return this.NtdwoTaxAmount.getValue();}

    public Field AfterCheck;
    public void setAfterCheck(String AfterCheck){this.AfterCheck.setValue(AfterCheck);}
    public String getAfterCheck(){return this.AfterCheck.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.BonusConfig");
        this.setTableName("BonusConfig");

        this.BonusAmount = new Field("BonusAmount", this.getTableName());
        this.BonusAmount.setDbType("varchar(8)");

        this.BonusDiscription = new Field("BonusDiscription", this.getTableName());
        this.BonusDiscription.setDbType("varchar(500)");

        this.BonusStatus = new Field("BonusStatus", this.getTableName());
        this.BonusStatus.setDbType("varchar(50)");

        this.BonusTitle = new Field("BonusTitle", this.getTableName());
        this.BonusTitle.setDbType("varchar(50)");

        this.Currency = new Field("Currency", this.getTableName());
        this.Currency.setDbType("varchar(50)");

        this.Formular = new Field("Formular", this.getTableName());
        this.Formular.setDbType("varchar(50)");

        this.NextBonusStatus = new Field("NextBonusStatus", this.getTableName());
        this.NextBonusStatus.setDbType("varchar(50)");

        this.NtdwoTaxAmount = new Field("NtdwoTaxAmount", this.getTableName());
        this.NtdwoTaxAmount.setDbType("varchar(8)");

        this.AfterCheck = new Field("AfterCheck", this.getTableName());
        this.AfterCheck.setDbType("varchar(1)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.BonusAmount);

        this.DbFields.add(this.BonusDiscription);

        this.DbFields.add(this.BonusStatus);

        this.DbFields.add(this.BonusTitle);

        this.DbFields.add(this.Currency);

        this.DbFields.add(this.Formular);

        this.DbFields.add(this.NextBonusStatus);

        this.DbFields.add(this.NtdwoTaxAmount);

        this.DbFields.add(this.AfterCheck);

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
            this.BonusAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.BonusAmount);

            this.BonusDiscription.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.BonusDiscription);

            this.BonusStatus.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.BonusStatus);

            this.BonusTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.BonusTitle);

            this.Currency.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Currency);

            this.Formular.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Formular);

            this.NextBonusStatus.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.NextBonusStatus);

            this.NtdwoTaxAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.NtdwoTaxAmount);

            this.AfterCheck.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.AfterCheck);

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
            BonusConfig preObj = (BonusConfig) userInfo.getObj(this.getTableName());
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