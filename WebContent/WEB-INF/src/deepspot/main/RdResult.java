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

public class RdResult extends MasterBean {

    public RdResult(){this.init();}

    public RdResult(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field AcademicYear;
    public void setAcademicYear(String AcademicYear){this.AcademicYear.setValue(AcademicYear);}
    public String getAcademicYear(){return this.AcademicYear.getValue();}

    public Field MainSerialNo;
    public void setMainSerialNo(String MainSerialNo){this.MainSerialNo.setValue(MainSerialNo);}
    public String getMainSerialNo(){return this.MainSerialNo.getValue();}

    public Field ProjectTitle;
    public void setProjectTitle(String ProjectTitle){this.ProjectTitle.setValue(ProjectTitle);}
    public String getProjectTitle(){return this.ProjectTitle.getValue();}

    public Field SponsorProjectNum;
    public void setSponsorProjectNum(String SponsorProjectNum){this.SponsorProjectNum.setValue(SponsorProjectNum);}
    public String getSponsorProjectNum(){return this.SponsorProjectNum.getValue();}

    public Field LeaderCode;
    public void setLeaderCode(String LeaderCode){this.LeaderCode.setValue(LeaderCode);}
    public String getLeaderCode(){return this.LeaderCode.getValue();}

    public Field Leader;
    public void setLeader(String Leader){this.Leader.setValue(Leader);}
    public String getLeader(){return this.Leader.getValue();}

    public Field LeaderOrder;
    public void setLeaderOrder(String LeaderOrder){this.LeaderOrder.setValue(LeaderOrder);}
    public String getLeaderOrder(){return this.LeaderOrder.getValue();}

    public Field Department;
    public void setDepartment(String Department){this.Department.setValue(Department);}
    public String getDepartment(){return this.Department.getValue();}

    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}

    public Field Notes;
    public void setNotes(String Notes){this.Notes.setValue(Notes);}
    public String getNotes(){return this.Notes.getValue();}

    public Field CoWriter;
    public void setCoWriter(String CoWriter){this.CoWriter.setValue(CoWriter);}
    public String getCoWriter(){return this.CoWriter.getValue();}

    public Field CoWriterOrg;
    public void setCoWriterOrg(String CoWriterOrg){this.CoWriterOrg.setValue(CoWriterOrg);}
    public String getCoWriterOrg(){return this.CoWriterOrg.getValue();}

    public Field Budget;
    public void setBudget(String Budget){this.Budget.setValue(Budget);}
    public String getBudget(){return this.Budget.getValue();}

    public Field BudgetinManagement;
    public void setBudgetinManagement(String BudgetinManagement){this.BudgetinManagement.setValue(BudgetinManagement);}
    public String getBudgetinManagement(){return this.BudgetinManagement.getValue();}

    public Field SponsorSource;
    public void setSponsorSource(String SponsorSource){this.SponsorSource.setValue(SponsorSource);}
    public String getSponsorSource(){return this.SponsorSource.getValue();}

    public Field StartDate;
    public void setStartDate(String StartDate){this.StartDate.setValue(StartDate);}
    public String getStartDate(){return this.StartDate.getValue();}

    public Field FinishDate;
    public void setFinishDate(String FinishDate){this.FinishDate.setValue(FinishDate);}
    public String getFinishDate(){return this.FinishDate.getValue();}

    public Field CloseDate;
    public void setCloseDate(String CloseDate){this.CloseDate.setValue(CloseDate);}
    public String getCloseDate(){return this.CloseDate.getValue();}

    public Field ExtendDate;
    public void setExtendDate(String ExtendDate){this.ExtendDate.setValue(ExtendDate);}
    public String getExtendDate(){return this.ExtendDate.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.RdResult");
        this.setTableName("RdResult");

        this.AcademicYear = new Field("AcademicYear", this.getTableName());
        this.AcademicYear.setDbType("varchar(50)");

        this.MainSerialNo = new Field("MainSerialNo", this.getTableName());
        this.MainSerialNo.setDbType("varchar(50)");

        this.ProjectTitle = new Field("ProjectTitle", this.getTableName());
        this.ProjectTitle.setDbType("varchar(200)");

        this.SponsorProjectNum = new Field("SponsorProjectNum", this.getTableName());
        this.SponsorProjectNum.setDbType("varchar(50)");

        this.LeaderCode = new Field("LeaderCode", this.getTableName());
        this.LeaderCode.setDbType("varchar(50)");

        this.Leader = new Field("Leader", this.getTableName());
        this.Leader.setDbType("varchar(50)");

        this.LeaderOrder = new Field("LeaderOrder", this.getTableName());
        this.LeaderOrder.setDbType("int");

        this.Department = new Field("Department", this.getTableName());
        this.Department.setDbType("varchar(50)");

        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("varchar(50)");

        this.Notes = new Field("Notes", this.getTableName());
        this.Notes.setDbType("varchar(200)");

        this.CoWriter = new Field("CoWriter", this.getTableName());
        this.CoWriter.setDbType("varchar(50)");

        this.CoWriterOrg = new Field("CoWriterOrg", this.getTableName());
        this.CoWriterOrg.setDbType("varchar(50)");

        this.Budget = new Field("Budget", this.getTableName());
        this.Budget.setDbType("int");

        this.BudgetinManagement = new Field("BudgetinManagement", this.getTableName());
        this.BudgetinManagement.setDbType("int");

        this.SponsorSource = new Field("SponsorSource", this.getTableName());
        this.SponsorSource.setDbType("varchar(50)");

        this.StartDate = new Field("StartDate", this.getTableName());
        this.StartDate.setDbType("varchar(50)");

        this.FinishDate = new Field("FinishDate", this.getTableName());
        this.FinishDate.setDbType("varchar(50)");

        this.CloseDate = new Field("CloseDate", this.getTableName());
        this.CloseDate.setDbType("varchar(50)");

        this.ExtendDate = new Field("ExtendDate", this.getTableName());
        this.ExtendDate.setDbType("varchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.AcademicYear);

        this.DbFields.add(this.MainSerialNo);

        this.DbFields.add(this.ProjectTitle);

        this.DbFields.add(this.SponsorProjectNum);

        this.DbFields.add(this.LeaderCode);

        this.DbFields.add(this.Leader);

        this.DbFields.add(this.LeaderOrder);

        this.DbFields.add(this.Department);

        this.DbFields.add(this.Title);

        this.DbFields.add(this.Notes);

        this.DbFields.add(this.CoWriter);

        this.DbFields.add(this.CoWriterOrg);

        this.DbFields.add(this.Budget);

        this.DbFields.add(this.BudgetinManagement);

        this.DbFields.add(this.SponsorSource);

        this.DbFields.add(this.StartDate);

        this.DbFields.add(this.FinishDate);

        this.DbFields.add(this.CloseDate);

        this.DbFields.add(this.ExtendDate);

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
            this.AcademicYear.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.AcademicYear);

            this.MainSerialNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.MainSerialNo);

            this.ProjectTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ProjectTitle);

            this.SponsorProjectNum.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.SponsorProjectNum);

            this.LeaderCode.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.LeaderCode);

            this.Leader.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Leader);

            this.LeaderOrder.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.LeaderOrder);

            this.Department.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Department);

            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Title);

            this.Notes.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Notes);

            this.CoWriter.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.CoWriter);

            this.CoWriterOrg.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.CoWriterOrg);

            this.Budget.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Budget);

            this.BudgetinManagement.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.BudgetinManagement);

            this.SponsorSource.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.SponsorSource);

            this.StartDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.StartDate);

            this.FinishDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.FinishDate);

            this.CloseDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.CloseDate);

            this.ExtendDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ExtendDate);

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
        return super.getNamesPrpts(this.RdResult);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            RdResult preObj = (RdResult) userInfo.getObj(this.getTableName());
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