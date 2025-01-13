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

public class StandardTask extends MasterBean {

    public StandardTask(){this.init();}

    public StandardTask(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field StdTodosId;
    public void setStdTodosId(String StdTodosId){this.StdTodosId.setValue(StdTodosId);}
    public String getStdTodosId(){return this.StdTodosId.getValue();}

    public Field BaseDate;
    public void setBaseDate(String BaseDate){this.BaseDate.setValue(BaseDate);}
    public String getBaseDate(){return this.BaseDate.getValue();}

    public Field LegalDueDate1;
    public void setLegalDueDate1(String LegalDueDate1){this.LegalDueDate1.setValue(LegalDueDate1);}
    public String getLegalDueDate1(){return this.LegalDueDate1.getValue();}

    public Field MatterName;
    public void setMatterName(String MatterName){this.MatterName.setValue(MatterName);}
    public String getMatterName(){return this.MatterName.getValue();}

    public Field PatentOffice;
    public void setPatentOffice(String PatentOffice){this.PatentOffice.setValue(PatentOffice);}
    public String getPatentOffice(){return this.PatentOffice.getValue();}

    public Field PatentType;
    public void setPatentType(String PatentType){this.PatentType.setValue(PatentType);}
    public String getPatentType(){return this.PatentType.getValue();}

    public Field TaskDescription;
    public void setTaskDescription(String TaskDescription){this.TaskDescription.setValue(TaskDescription);}
    public String getTaskDescription(){return this.TaskDescription.getValue();}

    public Field TodosTitle;
    public void setTodosTitle(String TodosTitle){this.TodosTitle.setValue(TodosTitle);}
    public String getTodosTitle(){return this.TodosTitle.getValue();}

    public Field RemindDate;
    public void setRemindDate(String RemindDate){this.RemindDate.setValue(RemindDate);}
    public String getRemindDate(){return this.RemindDate.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.StandardTask");
        this.setTableName("StandardTask");

        this.StdTodosId = new Field("StdTodosId", this.getTableName());
        this.StdTodosId.setDbType("varchar(10)");

        this.BaseDate = new Field("BaseDate", this.getTableName());
        this.BaseDate.setDbType("varchar(8)");

        this.LegalDueDate1 = new Field("LegalDueDate1", this.getTableName());
        this.LegalDueDate1.setDbType("nvarchar(8)");

        this.MatterName = new Field("MatterName", this.getTableName());
        this.MatterName.setDbType("varchar(20)");

        this.PatentOffice = new Field("PatentOffice", this.getTableName());
        this.PatentOffice.setDbType("varchar(50)");

        this.PatentType = new Field("PatentType", this.getTableName());
        this.PatentType.setDbType("varchar(50)");

        this.TaskDescription = new Field("TaskDescription", this.getTableName());
        this.TaskDescription.setDbType("varchar(100)");

        this.TodosTitle = new Field("TodosTitle", this.getTableName());
        this.TodosTitle.setDbType("varchar(20)");

        this.RemindDate = new Field("RemindDate", this.getTableName());
        this.RemindDate.setDbType("varchar(8)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.StdTodosId);

        this.DbFields.add(this.BaseDate);

        this.DbFields.add(this.LegalDueDate1);

        this.DbFields.add(this.MatterName);

        this.DbFields.add(this.PatentOffice);

        this.DbFields.add(this.PatentType);

        this.DbFields.add(this.TaskDescription);

        this.DbFields.add(this.TodosTitle);

        this.DbFields.add(this.RemindDate);

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
            this.StdTodosId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.StdTodosId);

            this.BaseDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.BaseDate);

            this.LegalDueDate1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.LegalDueDate1);

            this.MatterName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.MatterName);

            this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PatentOffice);

            this.PatentType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.PatentType);

            this.TaskDescription.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.TaskDescription);

            this.TodosTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.TodosTitle);

            this.RemindDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.RemindDate);

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
            StandardTask preObj = (StandardTask) userInfo.getObj(this.getTableName());
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