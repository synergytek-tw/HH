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

public class BonusDetail extends MasterBean {

    public BonusDetail(){this.init();}

    public BonusDetail(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Amount;
    public void setAmount(String Amount){this.Amount.setValue(Amount);}
    public String getAmount(){return this.Amount.getValue();}

    public Field BonusPayStatus;
    public void setBonusPayStatus(String BonusPayStatus){this.BonusPayStatus.setValue(BonusPayStatus);}
    public String getBonusPayStatus(){return this.BonusPayStatus.getValue();}

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field BonusTitle;
    public void setBonusTitle(String BonusTitle){this.BonusTitle.setValue(BonusTitle);}
    public String getBonusTitle(){return this.BonusTitle.getValue();}

    public Field Currency;
    public void setCurrency(String Currency){this.Currency.setValue(Currency);}
    public String getCurrency(){return this.Currency.getValue();}

    public Field DraftNo;
    public void setDraftNo(String DraftNo){this.DraftNo.setValue(DraftNo);}
    public String getDraftNo(){return this.DraftNo.getValue();}

    public Field Inventors;
    public void setInventors(String Inventors){this.Inventors.setValue(Inventors);}
    public String getInventors(){return this.Inventors.getValue();}

    public Field NtuAmount;
    public void setNtuAmount(String NtuAmount){this.NtuAmount.setValue(NtuAmount);}
    public String getNtuAmount(){return this.NtuAmount.getValue();}

    public Field PatentCaseNo;
    public void setPatentCaseNo(String PatentCaseNo){this.PatentCaseNo.setValue(PatentCaseNo);}
    public String getPatentCaseNo(){return this.PatentCaseNo.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.BonusDetail");
        this.setTableName("BonusDetail");

        this.Amount = new Field("Amount", this.getTableName());
        this.Amount.setDbType("varchar(8)");

        this.BonusPayStatus = new Field("BonusPayStatus", this.getTableName());
        this.BonusPayStatus.setDbType("varchar(50)");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.BonusTitle = new Field("BonusTitle", this.getTableName());
        this.BonusTitle.setDbType("varchar(50)");

        this.Currency = new Field("Currency", this.getTableName());
        this.Currency.setDbType("varchar(8)");

        this.DraftNo = new Field("DraftNo", this.getTableName());
        this.DraftNo.setDbType("varchar(15)");

        this.Inventors = new Field("Inventors", this.getTableName());
        this.Inventors.setDbType("varchar(15)");

        this.NtuAmount = new Field("NtuAmount", this.getTableName());
        this.NtuAmount.setDbType("varchar(8)");

        this.PatentCaseNo = new Field("PatentCaseNo", this.getTableName());
        this.PatentCaseNo.setDbType("varchar(15)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.Amount);

        this.DbFields.add(this.BonusPayStatus);

        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.BonusTitle);

        this.DbFields.add(this.Currency);

        this.DbFields.add(this.DraftNo);

        this.DbFields.add(this.Inventors);

        this.DbFields.add(this.NtuAmount);

        this.DbFields.add(this.PatentCaseNo);

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
            this.Amount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Amount);

            this.BonusPayStatus.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.BonusPayStatus);

            this.ParentId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ParentId);

            this.BonusTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.BonusTitle);

            this.Currency.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Currency);

            this.DraftNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.DraftNo);

            this.Inventors.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Inventors);

            this.NtuAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.NtuAmount);

            this.PatentCaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PatentCaseNo);

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
            BonusDetail preObj = (BonusDetail) userInfo.getObj(this.getTableName());
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