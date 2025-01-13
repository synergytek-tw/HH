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

public class ValueAddProjectDocument extends MasterBean {

    public ValueAddProjectDocument(){this.init();}

    public ValueAddProjectDocument(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field DocTitle;
    public void setDocTitle(String DocTitle){this.DocTitle.setValue(DocTitle);}
    public String getDocTitle(){return this.DocTitle.getValue();}

    public Field DocNotes;
    public void setDocNotes(String DocNotes){this.DocNotes.setValue(DocNotes);}
    public String getDocNotes(){return this.DocNotes.getValue();}

    public Field DocUrl;
    public void setDocUrl(String DocUrl){this.DocUrl.setValue(DocUrl);}
    public String getDocUrl(){return this.DocUrl.getValue();}

    public Field DocType;
    public void setDocType(String DocType){this.DocType.setValue(DocType);}
    public String getDocType(){return this.DocType.getValue();}

    public Field DocUploadtime;
    public void setDocUploadtime(String DocUploadtime){this.DocUploadtime.setValue(DocUploadtime);}
    public String getDocUploadtime(){return this.DocUploadtime.getValue();}

    public Field OtherAttachedment1;
    public void setOtherAttachedment1(String OtherAttachedment1){this.OtherAttachedment1.setValue(OtherAttachedment1);}
    public String getOtherAttachedment1(){return this.OtherAttachedment1.getValue();}

    public Field OtherAttachedmentUrl1;
    public void setOtherAttachedmentUrl1(String OtherAttachedmentUrl1){this.OtherAttachedmentUrl1.setValue(OtherAttachedmentUrl1);}
    public String getOtherAttachedmentUrl1(){return this.OtherAttachedmentUrl1.getValue();}

    public Field OtherAttachedment2;
    public void setOtherAttachedment2(String OtherAttachedment2){this.OtherAttachedment2.setValue(OtherAttachedment2);}
    public String getOtherAttachedment2(){return this.OtherAttachedment2.getValue();}

    public Field OtherAttachedmentUrl2;
    public void setOtherAttachedmentUrl2(String OtherAttachedmentUrl2){this.OtherAttachedmentUrl2.setValue(OtherAttachedmentUrl2);}
    public String getOtherAttachedmentUrl2(){return this.OtherAttachedmentUrl2.getValue();}

    public Field OtherAttachedment3;
    public void setOtherAttachedment3(String OtherAttachedment3){this.OtherAttachedment3.setValue(OtherAttachedment3);}
    public String getOtherAttachedment3(){return this.OtherAttachedment3.getValue();}

    public Field OtherAttachedmentUrl3;
    public void setOtherAttachedmentUrl3(String OtherAttachedmentUrl3){this.OtherAttachedmentUrl3.setValue(OtherAttachedmentUrl3);}
    public String getOtherAttachedmentUrl3(){return this.OtherAttachedmentUrl3.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.ValueAddProjectDocument");
        this.setTableName("ValueAddProjectDocument");

        this.DocTitle = new Field("DocTitle", this.getTableName());
        this.DocTitle.setDbType("varchar(50)");

        this.DocNotes = new Field("DocNotes", this.getTableName());
        this.DocNotes.setDbType("varchar(50)");

        this.DocUrl = new Field("DocUrl", this.getTableName());
        this.DocUrl.setDbType("varchar(200)");

        this.DocType = new Field("DocType", this.getTableName());
        this.DocType.setDbType("varchar(50)");

        this.DocUploadtime = new Field("DocUploadtime", this.getTableName());
        this.DocUploadtime.setDbType("varchar(20)");

        this.OtherAttachedment1 = new Field("OtherAttachedment1", this.getTableName());
        this.OtherAttachedment1.setDbType("varchar(100)");

        this.OtherAttachedmentUrl1 = new Field("OtherAttachedmentUrl1", this.getTableName());
        this.OtherAttachedmentUrl1.setDbType("varchar(100)");

        this.OtherAttachedment2 = new Field("OtherAttachedment2", this.getTableName());
        this.OtherAttachedment2.setDbType("varchar(100)");

        this.OtherAttachedmentUrl2 = new Field("OtherAttachedmentUrl2", this.getTableName());
        this.OtherAttachedmentUrl2.setDbType("varchar(100)");

        this.OtherAttachedment3 = new Field("OtherAttachedment3", this.getTableName());
        this.OtherAttachedment3.setDbType("varchar(100)");

        this.OtherAttachedmentUrl3 = new Field("OtherAttachedmentUrl3", this.getTableName());
        this.OtherAttachedmentUrl3.setDbType("varchar(100)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.DocTitle);

        this.DbFields.add(this.DocNotes);

        this.DbFields.add(this.DocUrl);

        this.DbFields.add(this.DocType);

        this.DbFields.add(this.DocUploadtime);

        this.DbFields.add(this.OtherAttachedment1);

        this.DbFields.add(this.OtherAttachedmentUrl1);

        this.DbFields.add(this.OtherAttachedment2);

        this.DbFields.add(this.OtherAttachedmentUrl2);

        this.DbFields.add(this.OtherAttachedment3);

        this.DbFields.add(this.OtherAttachedmentUrl3);

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
            this.DocTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.DocTitle);

            this.DocNotes.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.DocNotes);

            this.DocUrl.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.DocUrl);

            this.DocType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.DocType);

            this.DocUploadtime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.DocUploadtime);

            this.OtherAttachedment1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.OtherAttachedment1);

            this.OtherAttachedmentUrl1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.OtherAttachedmentUrl1);

            this.OtherAttachedment2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.OtherAttachedment2);

            this.OtherAttachedmentUrl2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.OtherAttachedmentUrl2);

            this.OtherAttachedment3.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.OtherAttachedment3);

            this.OtherAttachedmentUrl3.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.OtherAttachedmentUrl3);

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
        return super.getNamesPrpts(this.ValueAddProjectDocument);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            ValueAddProjectDocument preObj = (ValueAddProjectDocument) userInfo.getObj(this.getTableName());
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