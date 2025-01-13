package deepspot.main;

import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;

public class ReportDefine extends MasterBean {

    public ReportDefine(){this.init();}

    public ReportDefine(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Names;
    public void setNames(String Names){this.Names.setValue(Names);}
    public String getNames(){return this.Names.getValue();}

    public Field SampleDocument;
    public void setSampleDocument(String SampleDocument){this.SampleDocument.setValue(SampleDocument);}
    public String getSampleDocument(){return this.SampleDocument.getValue();}

    public Field ReportProgramId;
    public void setReportProgramId(String ReportProgramId){this.ReportProgramId.setValue(ReportProgramId);}
    public String getReportProgramId(){return this.ReportProgramId.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.ReportDefine");
        this.setTableName("ReportDefine");

        this.Names = new Field("Names", this.getTableName());
        this.Names.setDbType("nvarchar(200)");

        this.SampleDocument = new Field("SampleDocument", this.getTableName());
        this.SampleDocument.setDbType("varchar(50)");

        this.ReportProgramId = new Field("ReportProgramId", this.getTableName());
        this.ReportProgramId.setDbType("varchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.Names);

        this.DbFields.add(this.SampleDocument);

        this.DbFields.add(this.ReportProgramId);
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
            this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Names.setSize(50);
            rtnString += this.printHtml(this.Names);

            this.SampleDocument.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.SampleDocument);

            this.ReportProgramId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.ReportProgramId);

        }
        return rtnString;
    }

    public void setSearchListPrpts() {
    	this.FlowKey.setListWidth("15%");
		
		this.Names.setListWidth("35%");
		
		this.SampleDocument.setListWidth("35%");
		
		this.ReportProgramId.setListWidth("15%");
        Field[] showField = {this.FlowKey, this.Names, this.SampleDocument, this.ReportProgramId};
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
            ReportDefine preObj = (ReportDefine) userInfo.getObj(this.getTableName());
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
    
    public List<SelectItem> getList(String ProgramId) throws Exception {
		String SQL = "select SampleDocument as FlowKey, Names from ReportDefine where ReportProgramId='"+ProgramId+"'";
		return this.getDbUtil().getSelectItemList(SQL, this.FlowKey ,this.Names);
	}

}