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

public class BillManage extends MasterBean {

    public BillManage(){this.init();}

    public BillManage(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field AccountName;
    public void setAccountName(String AccountName){this.AccountName.setValue(AccountName);}
    public String getAccountName(){return this.AccountName.getValue();}

    public Field AccountPayableDate;
    public void setAccountPayableDate(String AccountPayableDate){this.AccountPayableDate.setValue(AccountPayableDate);}
    public String getAccountPayableDate(){return this.AccountPayableDate.getValue();}

    public Field CaseType;
    public void setCaseType(String CaseType){this.CaseType.setValue(CaseType);}
    public String getCaseType(){return this.CaseType.getValue();}

    public Field CostCenter;
    public void setCostCenter(String CostCenter){this.CostCenter.setValue(CostCenter);}
    public String getCostCenter(){return this.CostCenter.getValue();}

    public Field Mobile2;
    public void setMobile2(String Mobile2){this.Mobile2.setValue(Mobile2);}
    public String getMobile2(){return this.Mobile2.getValue();}

    public Field InvoiceSummary;
    public void setInvoiceSummary(String InvoiceSummary){this.InvoiceSummary.setValue(InvoiceSummary);}
    public String getInvoiceSummary(){return this.InvoiceSummary.getValue();}

    public Field Matter;
    public void setMatter(String Matter){this.Matter.setValue(Matter);}
    public String getMatter(){return this.Matter.getValue();}

    public Field PatentOffice;
    public void setPatentOffice(String PatentOffice){this.PatentOffice.setValue(PatentOffice);}
    public String getPatentOffice(){return this.PatentOffice.getValue();}

    public Field PaymentStatus;
    public void setPaymentStatus(String PaymentStatus){this.PaymentStatus.setValue(PaymentStatus);}
    public String getPaymentStatus(){return this.PaymentStatus.getValue();}

    public Field PaymentTerm;
    public void setPaymentTerm(String PaymentTerm){this.PaymentTerm.setValue(PaymentTerm);}
    public String getPaymentTerm(){return this.PaymentTerm.getValue();}

    public Field PaymentType;
    public void setPaymentType(String PaymentType){this.PaymentType.setValue(PaymentType);}
    public String getPaymentType(){return this.PaymentType.getValue();}

    public Field PayoutDate;
    public void setPayoutDate(String PayoutDate){this.PayoutDate.setValue(PayoutDate);}
    public String getPayoutDate(){return this.PayoutDate.getValue();}

    public Field RelatedCaseNo;
    public void setRelatedCaseNo(String RelatedCaseNo){this.RelatedCaseNo.setValue(RelatedCaseNo);}
    public String getRelatedCaseNo(){return this.RelatedCaseNo.getValue();}

    public Field RequestDate;
    public void setRequestDate(String RequestDate){this.RequestDate.setValue(RequestDate);}
    public String getRequestDate(){return this.RequestDate.getValue();}

    public Field Requester;
    public void setRequester(String Requester){this.Requester.setValue(Requester);}
    public String getRequester(){return this.Requester.getValue();}

    public Field PatentType;
    public void setPatentType(String PatentType){this.PatentType.setValue(PatentType);}
    public String getPatentType(){return this.PatentType.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.BillManage");
        this.setTableName("BillManage");

        this.AccountName = new Field("AccountName", this.getTableName());
        this.AccountName.setDbType("varchar(20)");

        this.AccountPayableDate = new Field("AccountPayableDate", this.getTableName());
        this.AccountPayableDate.setDbType("varchar(10)");

        this.CaseType = new Field("CaseType", this.getTableName());
        this.CaseType.setDbType("varchar(50)");

        this.CostCenter = new Field("CostCenter", this.getTableName());
        this.CostCenter.setDbType("varchar(50)");

        this.Mobile2 = new Field("Mobile2", this.getTableName());
        this.Mobile2.setDbType("varchar(50)");

        this.InvoiceSummary = new Field("InvoiceSummary", this.getTableName());
        this.InvoiceSummary.setDbType("varchar(8)");

        this.Matter = new Field("Matter", this.getTableName());
        this.Matter.setDbType("varchar(50)");

        this.PatentOffice = new Field("PatentOffice", this.getTableName());
        this.PatentOffice.setDbType("varchar(50)");

        this.PaymentStatus = new Field("PaymentStatus", this.getTableName());
        this.PaymentStatus.setDbType("varchar(50)");

        this.PaymentTerm = new Field("PaymentTerm", this.getTableName());
        this.PaymentTerm.setDbType("varchar(50)");

        this.PaymentType = new Field("PaymentType", this.getTableName());
        this.PaymentType.setDbType("varchar(50)");

        this.PayoutDate = new Field("PayoutDate", this.getTableName());
        this.PayoutDate.setDbType("varchar(10)");

        this.RelatedCaseNo = new Field("RelatedCaseNo", this.getTableName());
        this.RelatedCaseNo.setDbType("varchar(50)");

        this.RequestDate = new Field("RequestDate", this.getTableName());
        this.RequestDate.setDbType("varchar(10)");

        this.Requester = new Field("Requester", this.getTableName());
        this.Requester.setDbType("varchar(10)");

        this.PatentType = new Field("PatentType", this.getTableName());
        this.PatentType.setDbType("varchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.AccountName);

        this.DbFields.add(this.AccountPayableDate);

        this.DbFields.add(this.CaseType);

        this.DbFields.add(this.CostCenter);

        this.DbFields.add(this.Mobile2);

        this.DbFields.add(this.InvoiceSummary);

        this.DbFields.add(this.Matter);

        this.DbFields.add(this.PatentOffice);

        this.DbFields.add(this.PaymentStatus);

        this.DbFields.add(this.PaymentTerm);

        this.DbFields.add(this.PaymentType);

        this.DbFields.add(this.PayoutDate);

        this.DbFields.add(this.RelatedCaseNo);

        this.DbFields.add(this.RequestDate);

        this.DbFields.add(this.Requester);

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
            this.AccountName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.AccountName);

            this.AccountPayableDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.AccountPayableDate);

            this.CaseType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.CaseType);

            this.CostCenter.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.CostCenter);

            this.Mobile2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Mobile2);

            this.InvoiceSummary.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.InvoiceSummary);

            this.Matter.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Matter);

            this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PatentOffice);

            this.PaymentStatus.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PaymentStatus);

            this.PaymentTerm.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PaymentTerm);

            this.PaymentType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PaymentType);

            this.PayoutDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PayoutDate);

            this.RelatedCaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.RelatedCaseNo);

            this.RequestDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.RequestDate);

            this.Requester.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Requester);

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
        return super.getNamesPrpts(this.Summary);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            BillManage preObj = (BillManage) userInfo.getObj(this.getTableName());
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