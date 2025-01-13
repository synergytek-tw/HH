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

public class ValueAddProjectSearchRange extends MasterBean {

    public ValueAddProjectSearchRange(){this.init();}

    public ValueAddProjectSearchRange(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field TeacherId;
    public void setTeacherId(String TeacherId){this.TeacherId.setValue(TeacherId);}
    public String getTeacherId(){return this.TeacherId.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.ValueAddProjectSearchRange");
        this.setTableName("ValueAddProjectSearchRange");

        this.TeacherId = new Field("TeacherId", this.getTableName());
        this.TeacherId.setDbType("varchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.TeacherId);

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
            this.TeacherId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.TeacherId);

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
        return super.getNamesPrpts(this.ValueAddProjectSearchRange);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            ValueAddProjectSearchRange preObj = (ValueAddProjectSearchRange) userInfo.getObj(this.getTableName());
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