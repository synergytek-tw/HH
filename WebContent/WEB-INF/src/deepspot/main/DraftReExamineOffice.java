package deepspot.main;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class DraftReExamineOffice extends MultiDetail {

    public DraftReExamineOffice(){this.init();}

    public DraftReExamineOffice(String FlowKey) {
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
    
    public Field Result;
    public void setResult(String Result){this.Result.setValue(Result);}
    public String getResult(){return this.Result.getValue();}
    
    final int FRAME_HEIGHT = 140;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftReExamineOffice");
        this.setTableName("DraftReExamineOffice");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");
       
        this.OfficeName = new Field("OfficeName", this.getTableName());
        this.OfficeName.setDbType("nvarchar(50)");
        
        this.Result = new Field("Result", this.getTableName());
        this.Result.setDbType("nvarchar(50)");
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.Result);
        this.DbFields.add(this.OfficeName);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	
        	this.OfficeName.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.OfficeName.setSelectList(new Category().getChildList(this.OfficeName));
            rtnString += this.printHtml(this.OfficeName);
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