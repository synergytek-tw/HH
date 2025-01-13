package deepspot.main;

import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.html.Html;
import deepspot.util.Util;

public class ErrorReport extends MasterBean {

    public ErrorReport(){this.init();}

    public ErrorReport(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ApplyTime;
    public void setApplyTime(String ApplyTime){this.ApplyTime.setValue(ApplyTime);}
    public String getApplyTime(){return this.ApplyTime.getValue();}

    public Field ErrorType;
    public void setErrorType(String ErrorType){this.ErrorType.setValue(ErrorType);}
    public String getErrorType(){return this.ErrorType.getValue();}

    public Field Description;
    public void setDescription(String Description){this.Description.setValue(Description);}
    public String getDescription(){return this.Description.getValue();}

    public Field DocUrl;
    public void setDocUrl(String DocUrl){this.DocUrl.setValue(DocUrl);}
    public String getDocUrl(){return this.DocUrl.getValue();}

    public Field Suggest;
    public void setSuggest(String Suggest){this.Suggest.setValue(Suggest);}
    public String getSuggest(){return this.Suggest.getValue();}

    public Field Response;
    public void setResponse(String Response){this.Response.setValue(Response);}
    public String getResponse(){return this.Response.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.ErrorReport");
        this.setTableName("ErrorReport");

        this.ApplyTime = new Field("ApplyTime", this.getTableName());

        this.ErrorType = new Field("ErrorType", this.getTableName());
        this.ErrorType.setCheckEmpty(true);

        this.Description = new Field("Description", this.getTableName());
        this.Description.setCheckEmpty(true);
        this.Description.setSearchCondition(Cnstnts.LIKE);

        this.DocUrl = new Field("DocUrl", this.getTableName());

        this.Suggest = new Field("Suggest", this.getTableName());

        this.Response = new Field("Response", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.ApplyTime.setDbType("varchar(20)");
        this.DbFields.add(this.ApplyTime);

        this.ErrorType.setDbType("varchar(50)");
        this.DbFields.add(this.ErrorType);

        this.Description.setDbType("nvarchar(500)");
        this.DbFields.add(this.Description);

        this.DocUrl.setDbType("varchar(100)");
        this.DbFields.add(this.DocUrl);

        this.Suggest.setDbType("nvarchar(500)");
        this.DbFields.add(this.Suggest);

        this.Response.setDbType("nvarchar(500)");
        this.DbFields.add(this.Response);
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
            this.ErrorType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.ErrorType.setSelectList(new Category().getChildList(this.ErrorType));
            rtnString += this.printHtml(this.ErrorType);

            this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Description);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
            this.ApplyTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ApplyTime.setReadonly(true);

            this.ErrorType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.ErrorType.setSelectList(new Category().getChildList(this.ErrorType));
            this.ErrorType.setAnotherField(this.ApplyTime);
            rtnString += this.printHtml(this.ErrorType);

            this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Description.setRows(6);
            this.Description.setCols(60);
            rtnString += this.printHtml(this.Description);

            this.DocUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.DocUrl);

            this.Suggest.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Suggest.setCols(60);
            rtnString += this.printHtml(this.Suggest);

            if(this.getDbActionMode().equals(Cnstnts.INSERT)){
        		rtnString += this.Response.printHiddenTag();
        	} else {
        		this.Response.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
                this.Response.setCols(60);
                rtnString += this.printHtml(this.Response);
        	}
        }
        return rtnString;
    }

    public void setSearchListPrpts() {
        this.Applicant.setListWidth("8%");
        try {
			this.Applicant.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.Applicant.setNotShowCode(true);

        this.ApplyTime.setListWidth("12%");

        this.ErrorType.setListWidth("10%");
        try {
			this.ErrorType.setMapingPrpt(new Category().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.ErrorType.setNotShowCode(true);

        this.Description.setListWidth("35%");

        this.Response.setListWidth("35%");

        Field[] showField = {this.Applicant, this.ApplyTime, this.ErrorType, this.Description, this.Response};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.ErrorType);
        whereStr = Util.addWhereSQL(whereStr, this.Description);
        return this.doSearch(whereStr);
    }

    public String printTag(Field field) throws Exception{
    	if(this.canEdit() || this.onSearchMode()){
    		if(this.getFlowStep()==1 && field.getName().equals(this.Response.getName())){
  	  			field.setCanEdit(false);
  	  		} else {
  	  			field.setCanEdit(true);
  	  		}
  	  	} else {
  	  		if(this.getFlowStep()==1 && field.getName().equals(this.Response.getName())){
	  			field.setCanEdit(true);
	  		} else {
	  			field.setCanEdit(false);
	  		}
  	  	}
    	String rtnString = Html.printTag(field, this.getUserInfo());
    	if(field.getAnotherField()!=null && field.getColspan()>1){
    		rtnString += getAlias(field.getAnotherField())+ printTag(field.getAnotherField());
    	}
    	return rtnString;
    }
    
    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Description);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            ErrorReport preObj = (ErrorReport) userInfo.getObj(this.getTableName());
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

    public boolean checkSignError() throws Exception{
    	if(this.getFlowStep()==1 && this.Response.getValue().trim().length()==0){
    		this.setErrorMessage(Util.getMsg("jsp.ErrorReport.Response.Error", 
    				this.getUserInfo().getAttribute("language")));
    		return true;
    	}
  	  	return false;
    }
    
    public boolean checkInsertError() throws Exception {
        if(super.checkInsertError()){
            return true;
        } else {
        	if(this.getDbActionMode().equals(Cnstnts.INSERT)){
        		this.ApplyTime.setValue(Util.getDateTime());
        		this.Response.setValue(Cnstnts.EMPTY_STRING);
        	}
        	this.setAliasName(this.Description.getValue());
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
    
    public void doSignProcess() throws Exception{
    	if(this.getFlowStep()==1){
    		this.update();
    	}
  	  	super.doSignProcess();
    }
    
}