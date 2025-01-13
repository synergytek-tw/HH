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

public class BillManageDetail extends MasterBean {

    public BillManageDetail(){this.init();}

    public BillManageDetail(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field AmountIncludeTax;
    public void setAmountIncludeTax(String AmountIncludeTax){this.AmountIncludeTax.setValue(AmountIncludeTax);}
    public String getAmountIncludeTax(){return this.AmountIncludeTax.getValue();}

    public Field AttorneyIncomeTax;
    public void setAttorneyIncomeTax(String AttorneyIncomeTax){this.AttorneyIncomeTax.setValue(AttorneyIncomeTax);}
    public String getAttorneyIncomeTax(){return this.AttorneyIncomeTax.getValue();}

    public Field Currency;
    public void setCurrency(String Currency){this.Currency.setValue(Currency);}
    public String getCurrency(){return this.Currency.getValue();}

    public Field InvoiceAmount;
    public void setInvoiceAmount(String InvoiceAmount){this.InvoiceAmount.setValue(InvoiceAmount);}
    public String getInvoiceAmount(){return this.InvoiceAmount.getValue();}

    public Field InvoiceDate;
    public void setInvoiceDate(String InvoiceDate){this.InvoiceDate.setValue(InvoiceDate);}
    public String getInvoiceDate(){return this.InvoiceDate.getValue();}

    public Field InvoiceNo;
    public void setInvoiceNo(String InvoiceNo){this.InvoiceNo.setValue(InvoiceNo);}
    public String getInvoiceNo(){return this.InvoiceNo.getValue();}

    public Field InvoiceType;
    public void setInvoiceType(String InvoiceType){this.InvoiceType.setValue(InvoiceType);}
    public String getInvoiceType(){return this.InvoiceType.getValue();}

    public Field NtdwoTaxAmount;
    public void setNtdwoTaxAmount(String NtdwoTaxAmount){this.NtdwoTaxAmount.setValue(NtdwoTaxAmount);}
    public String getNtdwoTaxAmount(){return this.NtdwoTaxAmount.getValue();}

    public Field Paid;
    public void setPaid(String Paid){this.Paid.setValue(Paid);}
    public String getPaid(){return this.Paid.getValue();}

    public Field ShouldPay;
    public void setShouldPay(String ShouldPay){this.ShouldPay.setValue(ShouldPay);}
    public String getShouldPay(){return this.ShouldPay.getValue();}

    public Field TaxAmount;
    public void setTaxAmount(String TaxAmount){this.TaxAmount.setValue(TaxAmount);}
    public String getTaxAmount(){return this.TaxAmount.getValue();}

    public Field TaxAmount2;
    public void setTaxAmount2(String TaxAmount2){this.TaxAmount2.setValue(TaxAmount2);}
    public String getTaxAmount2(){return this.TaxAmount2.getValue();}

    public Field Taxed;
    public void setTaxed(String Taxed){this.Taxed.setValue(Taxed);}
    public String getTaxed(){return this.Taxed.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.BillManageDetail");
        this.setTableName("BillManageDetail");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.AmountIncludeTax = new Field("AmountIncludeTax", this.getTableName());
        this.AmountIncludeTax.setDbType("varchar(8)");

        this.AttorneyIncomeTax = new Field("AttorneyIncomeTax", this.getTableName());
        this.AttorneyIncomeTax.setDbType("varchar(8)");

        this.Currency = new Field("Currency", this.getTableName());
        this.Currency.setDbType("varchar(50)");

        this.InvoiceAmount = new Field("InvoiceAmount", this.getTableName());
        this.InvoiceAmount.setDbType("varchar(8)");

        this.InvoiceDate = new Field("InvoiceDate", this.getTableName());
        this.InvoiceDate.setDbType("varchar(10)");

        this.InvoiceNo = new Field("InvoiceNo", this.getTableName());
        this.InvoiceNo.setDbType("varchar(15)");

        this.InvoiceType = new Field("InvoiceType", this.getTableName());
        this.InvoiceType.setDbType("varchar(50)");

        this.NtdwoTaxAmount = new Field("NtdwoTaxAmount", this.getTableName());
        this.NtdwoTaxAmount.setDbType("varchar(8)");

        this.Paid = new Field("Paid", this.getTableName());
        this.Paid.setDbType("varchar(1)");

        this.ShouldPay = new Field("ShouldPay", this.getTableName());
        this.ShouldPay.setDbType("varchar(8)");

        this.TaxAmount = new Field("TaxAmount", this.getTableName());
        this.TaxAmount.setDbType("varchar(8)");

        this.TaxAmount2 = new Field("TaxAmount2", this.getTableName());
        this.TaxAmount2.setDbType("varchar(8)");

        this.Taxed = new Field("Taxed", this.getTableName());
        this.Taxed.setDbType("varchar(1)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.AmountIncludeTax);

        this.DbFields.add(this.AttorneyIncomeTax);

        this.DbFields.add(this.Currency);

        this.DbFields.add(this.InvoiceAmount);

        this.DbFields.add(this.InvoiceDate);

        this.DbFields.add(this.InvoiceNo);

        this.DbFields.add(this.InvoiceType);

        this.DbFields.add(this.NtdwoTaxAmount);

        this.DbFields.add(this.Paid);

        this.DbFields.add(this.ShouldPay);

        this.DbFields.add(this.TaxAmount);

        this.DbFields.add(this.TaxAmount2);

        this.DbFields.add(this.Taxed);

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
            this.ParentId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ParentId);

            this.AmountIncludeTax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.AmountIncludeTax);

            this.AttorneyIncomeTax.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.AttorneyIncomeTax);

            this.Currency.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Currency);

            this.InvoiceAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.InvoiceAmount);

            this.InvoiceDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.InvoiceDate);

            this.InvoiceNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.InvoiceNo);

            this.InvoiceType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.InvoiceType);

            this.NtdwoTaxAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.NtdwoTaxAmount);

            this.Paid.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Paid);

            this.ShouldPay.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ShouldPay);

            this.TaxAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.TaxAmount);

            this.TaxAmount2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.TaxAmount2);

            this.Taxed.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Taxed);

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
            BillManageDetail preObj = (BillManageDetail) userInfo.getObj(this.getTableName());
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