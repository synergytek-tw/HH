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

public class ValueAddProject extends MasterBean {

    public ValueAddProject(){this.init();}

    public ValueAddProject(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ValueAddProjectTitle;
    public void setValueAddProjectTitle(String ValueAddProjectTitle){this.ValueAddProjectTitle.setValue(ValueAddProjectTitle);}
    public String getValueAddProjectTitle(){return this.ValueAddProjectTitle.getValue();}

    public Field ValueAddProjectAbstract;
    public void setValueAddProjectAbstract(String ValueAddProjectAbstract){this.ValueAddProjectAbstract.setValue(ValueAddProjectAbstract);}
    public String getValueAddProjectAbstract(){return this.ValueAddProjectAbstract.getValue();}

    public Field ProjectType;
    public void setProjectType(String ProjectType){this.ProjectType.setValue(ProjectType);}
    public String getProjectType(){return this.ProjectType.getValue();}

    public Field ProjectStatus;
    public void setProjectStatus(String ProjectStatus){this.ProjectStatus.setValue(ProjectStatus);}
    public String getProjectStatus(){return this.ProjectStatus.getValue();}

    public Field EstimateStartDate;
    public void setEstimateStartDate(String EstimateStartDate){this.EstimateStartDate.setValue(EstimateStartDate);}
    public String getEstimateStartDate(){return this.EstimateStartDate.getValue();}

    public Field EstimateFinishedDate;
    public void setEstimateFinishedDate(String EstimateFinishedDate){this.EstimateFinishedDate.setValue(EstimateFinishedDate);}
    public String getEstimateFinishedDate(){return this.EstimateFinishedDate.getValue();}

    public Field RealStartDate;
    public void setRealStartDate(String RealStartDate){this.RealStartDate.setValue(RealStartDate);}
    public String getRealStartDate(){return this.RealStartDate.getValue();}

    public Field RealFinishedDate;
    public void setRealFinishedDate(String RealFinishedDate){this.RealFinishedDate.setValue(RealFinishedDate);}
    public String getRealFinishedDate(){return this.RealFinishedDate.getValue();}

    public Field TextField1;
    public void setTextField1(String TextField1){this.TextField1.setValue(TextField1);}
    public String getTextField1(){return this.TextField1.getValue();}

    public Field TextField2;
    public void setTextField2(String TextField2){this.TextField2.setValue(TextField2);}
    public String getTextField2(){return this.TextField2.getValue();}

    public Field TextField3;
    public void setTextField3(String TextField3){this.TextField3.setValue(TextField3);}
    public String getTextField3(){return this.TextField3.getValue();}

    public Field TextField4;
    public void setTextField4(String TextField4){this.TextField4.setValue(TextField4);}
    public String getTextField4(){return this.TextField4.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.ValueAddProject");
        this.setTableName("ValueAddProject");

        this.ValueAddProjectTitle = new Field("ValueAddProjectTitle", this.getTableName());
        this.ValueAddProjectTitle.setDbType("varchar(100)");

        this.ValueAddProjectAbstract = new Field("ValueAddProjectAbstract", this.getTableName());
        this.ValueAddProjectAbstract.setDbType("varchar(200)");

        this.ProjectType = new Field("ProjectType", this.getTableName());
        this.ProjectType.setDbType("varchar(50)");

        this.ProjectStatus = new Field("ProjectStatus", this.getTableName());
        this.ProjectStatus.setDbType("varchar(50)");

        this.EstimateStartDate = new Field("EstimateStartDate", this.getTableName());
        this.EstimateStartDate.setDbType("varchar(10)");

        this.EstimateFinishedDate = new Field("EstimateFinishedDate", this.getTableName());
        this.EstimateFinishedDate.setDbType("varchar(10)");

        this.RealStartDate = new Field("RealStartDate", this.getTableName());
        this.RealStartDate.setDbType("varchar(10)");

        this.RealFinishedDate = new Field("RealFinishedDate", this.getTableName());
        this.RealFinishedDate.setDbType("varchar(10)");

        this.TextField1 = new Field("TextField1", this.getTableName());
        this.TextField1.setDbType("varchar(200)");

        this.TextField2 = new Field("TextField2", this.getTableName());
        this.TextField2.setDbType("varchar(200)");

        this.TextField3 = new Field("TextField3", this.getTableName());
        this.TextField3.setDbType("varchar(200)");

        this.TextField4 = new Field("TextField4", this.getTableName());
        this.TextField4.setDbType("varchar(200)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ValueAddProjectTitle);

        this.DbFields.add(this.ValueAddProjectAbstract);

        this.DbFields.add(this.ProjectType);

        this.DbFields.add(this.ProjectStatus);

        this.DbFields.add(this.EstimateStartDate);

        this.DbFields.add(this.EstimateFinishedDate);

        this.DbFields.add(this.RealStartDate);

        this.DbFields.add(this.RealFinishedDate);

        this.DbFields.add(this.TextField1);

        this.DbFields.add(this.TextField2);

        this.DbFields.add(this.TextField3);

        this.DbFields.add(this.TextField4);

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
            this.ValueAddProjectTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ValueAddProjectTitle);

            this.ValueAddProjectAbstract.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ValueAddProjectAbstract);

            this.ProjectType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ProjectType);

            this.ProjectStatus.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ProjectStatus);

            this.EstimateStartDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.EstimateStartDate);

            this.EstimateFinishedDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.EstimateFinishedDate);

            this.RealStartDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.RealStartDate);

            this.RealFinishedDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.RealFinishedDate);

            this.TextField1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.TextField1);

            this.TextField2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.TextField2);

            this.TextField3.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.TextField3);

            this.TextField4.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.TextField4);

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
        return super.getNamesPrpts(this.ValueAddProject);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            ValueAddProject preObj = (ValueAddProject) userInfo.getObj(this.getTableName());
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