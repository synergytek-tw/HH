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

public class ServiceProject extends MasterBean {

    public ServiceProject(){this.init();}

    public ServiceProject(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field SerialCaseID;
    public void setSerialCaseID(String SerialCaseID){this.SerialCaseID.setValue(SerialCaseID);}
    public String getSerialCaseID(){return this.SerialCaseID.getValue();}

    public Field Title;
    public void setTitle(String Title){this.Title.setValue(Title);}
    public String getTitle(){return this.Title.getValue();}

    public Field Description;
    public void setDescription(String Description){this.Description.setValue(Description);}
    public String getDescription(){return this.Description.getValue();}

    public Field ServiceTypeMain;
    public void setServiceTypeMain(String ServiceTypeMain){this.ServiceTypeMain.setValue(ServiceTypeMain);}
    public String getServiceTypeMain(){return this.ServiceTypeMain.getValue();}

    public Field ServiceTypeSub;
    public void setServiceTypeSub(String ServiceTypeSub){this.ServiceTypeSub.setValue(ServiceTypeSub);}
    public String getServiceTypeSub(){return this.ServiceTypeSub.getValue();}

    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}

    public Field StartDate;
    public void setStartDate(String StartDate){this.StartDate.setValue(StartDate);}
    public String getStartDate(){return this.StartDate.getValue();}

    public Field DueDate;
    public void setDueDate(String DueDate){this.DueDate.setValue(DueDate);}
    public String getDueDate(){return this.DueDate.getValue();}

    public Field EndDate;
    public void setEndDate(String EndDate){this.EndDate.setValue(EndDate);}
    public String getEndDate(){return this.EndDate.getValue();}

    public Field FileName1;
    public void setFileName1(String FileName1){this.FileName1.setValue(FileName1);}
    public String getFileName1(){return this.FileName1.getValue();}

    public Field FileUrl1;
    public void setFileUrl1(String FileUrl1){this.FileUrl1.setValue(FileUrl1);}
    public String getFileUrl1(){return this.FileUrl1.getValue();}

    public Field FileName2;
    public void setFileName2(String FileName2){this.FileName2.setValue(FileName2);}
    public String getFileName2(){return this.FileName2.getValue();}

    public Field FileUrl2;
    public void setFileUrl2(String FileUrl2){this.FileUrl2.setValue(FileUrl2);}
    public String getFileUrl2(){return this.FileUrl2.getValue();}

    public Field FileName3;
    public void setFileName3(String FileName3){this.FileName3.setValue(FileName3);}
    public String getFileName3(){return this.FileName3.getValue();}

    public Field FileUrl3;
    public void setFileUrl3(String FileUrl3){this.FileUrl3.setValue(FileUrl3);}
    public String getFileUrl3(){return this.FileUrl3.getValue();}

    public Field Client;
    public void setClient(String Client){this.Client.setValue(Client);}
    public String getClient(){return this.Client.getValue();}

    public Field ClientName;
    public void setClientName(String ClientName){this.ClientName.setValue(ClientName);}
    public String getClientName(){return this.ClientName.getValue();}

    public Field ProjectMgr;
    public void setProjectMgr(String ProjectMgr){this.ProjectMgr.setValue(ProjectMgr);}
    public String getProjectMgr(){return this.ProjectMgr.getValue();}

    public Field ClientContect;
    public void setClientContect(String ClientContect){this.ClientContect.setValue(ClientContect);}
    public String getClientContect(){return this.ClientContect.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.ServiceProject");
        this.setTableName("ServiceProject");

        this.SerialCaseID = new Field("SerialCaseID", this.getTableName());
        this.SerialCaseID.setDbType("varchar(50)");

        this.Title = new Field("Title", this.getTableName());
        this.Title.setDbType("varchar(100)");

        this.Description = new Field("Description", this.getTableName());
        this.Description.setDbType("varchar(200)");

        this.ServiceTypeMain = new Field("ServiceTypeMain", this.getTableName());
        this.ServiceTypeMain.setDbType("varchar(50)");

        this.ServiceTypeSub = new Field("ServiceTypeSub", this.getTableName());
        this.ServiceTypeSub.setDbType("varchar(50)");

        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");

        this.StartDate = new Field("StartDate", this.getTableName());
        this.StartDate.setDbType("varchar(50)");

        this.DueDate = new Field("DueDate", this.getTableName());
        this.DueDate.setDbType("varchar(50)");

        this.EndDate = new Field("EndDate", this.getTableName());
        this.EndDate.setDbType("varchar(50)");

        this.FileName1 = new Field("FileName1", this.getTableName());
        this.FileName1.setDbType("varchar(50)");

        this.FileUrl1 = new Field("FileUrl1", this.getTableName());
        this.FileUrl1.setDbType("varchar(100)");

        this.FileName2 = new Field("FileName2", this.getTableName());
        this.FileName2.setDbType("varchar(50)");

        this.FileUrl2 = new Field("FileUrl2", this.getTableName());
        this.FileUrl2.setDbType("varchar(100)");

        this.FileName3 = new Field("FileName3", this.getTableName());
        this.FileName3.setDbType("varchar(50)");

        this.FileUrl3 = new Field("FileUrl3", this.getTableName());
        this.FileUrl3.setDbType("varchar(100)");

        this.Client = new Field("Client", this.getTableName());
        this.Client.setDbType("varchar(50)");

        this.ClientName = new Field("ClientName", this.getTableName());
        this.ClientName.setDbType("varchar(50)");

        this.ProjectMgr = new Field("ProjectMgr", this.getTableName());
        this.ProjectMgr.setDbType("varchar(50)");

        this.ClientContect = new Field("ClientContect", this.getTableName());
        this.ClientContect.setDbType("varchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.SerialCaseID);

        this.DbFields.add(this.Title);

        this.DbFields.add(this.Description);

        this.DbFields.add(this.ServiceTypeMain);

        this.DbFields.add(this.ServiceTypeSub);

        this.DbFields.add(this.Status);

        this.DbFields.add(this.StartDate);

        this.DbFields.add(this.DueDate);

        this.DbFields.add(this.EndDate);

        this.DbFields.add(this.FileName1);

        this.DbFields.add(this.FileUrl1);

        this.DbFields.add(this.FileName2);

        this.DbFields.add(this.FileUrl2);

        this.DbFields.add(this.FileName3);

        this.DbFields.add(this.FileUrl3);

        this.DbFields.add(this.Client);

        this.DbFields.add(this.ClientName);

        this.DbFields.add(this.ProjectMgr);

        this.DbFields.add(this.ClientContect);

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
            this.SerialCaseID.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.SerialCaseID);

            this.Title.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Title);

            this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Description);

            this.ServiceTypeMain.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ServiceTypeMain);

            this.ServiceTypeSub.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ServiceTypeSub);

            this.Status.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Status);

            this.StartDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.StartDate);

            this.DueDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.DueDate);

            this.EndDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.EndDate);

            this.FileName1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.FileName1);

            this.FileUrl1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.FileUrl1);

            this.FileName2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.FileName2);

            this.FileUrl2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.FileUrl2);

            this.FileName3.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.FileName3);

            this.FileUrl3.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.FileUrl3);

            this.Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Client);

            this.ClientName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ClientName);

            this.ProjectMgr.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ProjectMgr);

            this.ClientContect.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ClientContect);

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
            ServiceProject preObj = (ServiceProject) userInfo.getObj(this.getTableName());
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