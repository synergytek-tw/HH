package deepspot.main;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class DraftTechExamineOffice extends MultiDetail {

    public DraftTechExamineOffice(){this.init();}

    public DraftTechExamineOffice(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field OfficeName;
    public void setOfficeName(String OfficeName){this.OfficeName.setValue(OfficeName);}
    public String getOfficeName(){return this.OfficeName.getValue();}
    
    public Field Command;
    public void setCommand(String Command){this.Command.setValue(Command);}
    public String getCommand(){return this.Command.getValue();}
    
    public Field UploadFile;
    public void setUploadFile(String UploadFile){this.UploadFile.setValue(UploadFile);}
    public String getUploadFile(){return this.UploadFile.getValue();}
    
    public Field Result;
    public void setResult(String Result){this.Result.setValue(Result);}
    public String getResult(){return this.Result.getValue();}
    
    final int FRAME_HEIGHT = 140;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftTechExamineOffice");
        this.setTableName("DraftTechExamineOffice");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");
        
        this.Command = new Field("Command",this.getTableName());
        this.Command.setDbType("varchar(500)");
       
        this.OfficeName = new Field("OfficeName", this.getTableName());
        this.OfficeName.setDbType("nvarchar(50)");
        
        this.Result = new Field("Result", this.getTableName());
        this.Result.setDbType("nvarchar(50)");
        this.Result.setCheckEmpty(true);
        
        this.UploadFile = new Field("UploadFile", this.getTableName());
        this.UploadFile.setDbType("nvarchar(100)");
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.Command);
        this.DbFields.add(this.Result);
        this.DbFields.add(this.OfficeName);
        this.DbFields.add(this.UploadFile);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	
        	this.Result.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.Result.setSelectList(new Category().getChildList("TechExamineResult"));
        	
        	this.OfficeName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.OfficeName.setAnotherField(this.Result);
            rtnString += this.printHtml(this.OfficeName);
            
            this.Command.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Command.setCols(60);
            rtnString += this.printHtml(this.Command);
            
            this.UploadFile.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
    		rtnString += this.printHtml(this.UploadFile);
        }
        return rtnString;
    }
   
    protected String getAjaxReasult(UserBean userInfo,String parentId) throws Exception {
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printAjaxReasult();
    }
    
    public String printAjaxReasult() throws Exception {
		return this.printSearchReasult();
	}
    
}