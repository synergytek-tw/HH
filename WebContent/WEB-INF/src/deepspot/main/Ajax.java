package deepspot.main;

import deepspot.basic.Cnstnts;
import deepspot.basic.DbUtil;;

public class Ajax {
	public Ajax(){}
	
	public Ajax(UserBean userInfo, String className){
		this.userInfo = userInfo;
		this.className = className;
	}
	
	private UserBean userInfo;
	public void setUserInfo(UserBean userInfo){
		this.userInfo = userInfo;
	}
	public UserBean getUserInfo(){
		return this.userInfo;
	}
	
	private String className;
	public void setClassName(String className){
		this.className = className;
	}
	public String getClassName(){
		return this.className;
	}
	
	private String dataValue;
	public void setDataValue(String dataValue){
		this.dataValue = dataValue;
	}
	public String getDataValue(){
		return this.dataValue;
	}
	
	private String otherValue;
	public void setOtherValue(String otherValue){
		this.otherValue = otherValue;
	}
	public String getOtherValue(){
		return this.otherValue;
	}
	
	private String flashMode;
	public void setFlashMode(String flashMode){
		this.flashMode = flashMode;
	}
	public String getFlashMode(){
		return this.flashMode;
	}
    
    public String onAjaxRequest(String dataValue,String otherValue,String flashMode) throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	this.dataValue = dataValue;
    	this.otherValue = otherValue;
    	this.flashMode = flashMode;
    	
    	if("PatentCase".equals(this.className)){
    		rtnString = this.doPatentCaseRequest();
    	}
    	if("LegalCase".equals(this.className)){
    		rtnString = this.doLegalCaseRequest();
    	}
    	if("TrademarkCase".equals(this.className)){
    		rtnString = this.doTrademarkCaseRequest();
    	}
    	if("Contract".equals(this.className)){
    		rtnString = this.doContractRequest();
    	}
    	if("Draft".equals(this.className)
    			|| "DraftReExamineOffice".equals(this.className)
    					|| "DraftTechExamineOffice".equals(this.className)){
    		rtnString = this.doDraftRequest();
    	}
    	return rtnString;
  	}
    
    private String doDraftRequest() throws Exception{
    	//System.out.println("into doDraftRequest() - Ajax.java");
    	if(this.dataValue.equals("DraftPatent")){
    		return new DraftPatent().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	} else
    	if(this.dataValue.equals("DraftOffice")){
    		return new DraftOffice().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	} else
    	if(this.dataValue.equals("DraftDocument")){
    		return new DraftDocument().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	} else
    	if(this.dataValue.equals("DraftAttachment")){
    		return new DraftAttachment().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	} else
    	if(this.dataValue.equals("DraftPic")){
    		return new DraftPic().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	} else
    	if(this.dataValue.equals("DraftRecommend")){
    		return new DraftRecommend().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	} else
    	if(this.dataValue.equals("DraftInventor")){
    		return new DraftInventor().getAjaxReasult(this.getUserInfo(),this.otherValue);
    	} else
    	if(this.dataValue.equals("DraftAssignExaminer")){
    		return new DraftAssignExaminer().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	} else
    	if(this.otherValue.equals("LoadRecommend")){
    		DraftAssignExaminer draftAssignExaminer = new DraftAssignExaminer();
    		draftAssignExaminer.doLoadRecommend(this.getUserInfo(), this.dataValue);
    		return draftAssignExaminer.getAjaxReasult(this.getUserInfo(),this.dataValue);	    		
    	} else
    	if(this.otherValue.equals("CreateTechExamine")){
    		DraftAssignExaminer draftAssignExaminer = new DraftAssignExaminer();
    		draftAssignExaminer.doCreateTechExamine(this.getUserInfo(),this.dataValue);
    		return new DraftTechExamine().getAjaxReasult(this.getUserInfo(),this.dataValue);	
    	} else
		if(this.otherValue.equals("CreateReExamine")){
    		DraftAssignExaminer draftAssignExaminer = new DraftAssignExaminer();
    		draftAssignExaminer.doCreateReExamine(this.getUserInfo(),this.dataValue);
    		return new DraftReExamine().getAjaxReasult(this.getUserInfo(),this.dataValue);	
    	} else
    	if(this.otherValue.indexOf("&")!=0 && "DraftTechExamineOffice".equals(this.className)){
    		String data[] = this.otherValue.split("&");
    		String SQL = "update DraftTechExamineOffice set "+data[0]+"='"+this.dataValue+"' where FlowKey='"+data[1]+"'";
    		//System.out.println(SQL);
    		new DbUtil().executeUpdate(SQL);
    		return this.dataValue;	
    	} else
    	if(this.otherValue.indexOf("&")!=0 && "DraftReExamineOffice".equals(this.className)){
    		String data[] = this.otherValue.split("&");
    		String SQL = "update DraftReExamineOffice set "+data[0]+"='"+data[2]+"' where FlowKey='"+data[1]+"'";
    		//System.out.println(SQL);
    		new DbUtil().executeUpdate(SQL);
    		return this.dataValue;	
    	} else
		if(this.otherValue.indexOf("&")!=0 && "Draft".equals(this.className)){
    		String data[] = this.otherValue.split("&");
    		String SQL = "update Draft set "+data[0]+"='"+this.dataValue+"' where FlowKey='"+data[1]+"'";
    		//System.out.println(SQL);
    		new DbUtil().executeUpdate(SQL);
    		return this.dataValue;	
    	} else
    	return Cnstnts.EMPTY_STRING;
    }
    
    private String doPatentCaseRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	PatentCase patentCase = (PatentCase)this.userInfo.getObj(this.className);
    	if(this.otherValue.equals("dbActionMode")){
    		patentCase.setDbActionMode(dataValue);
    		rtnString=patentCase.printBodyDiv();
    	} 
    	if(this.otherValue.equals("pageActionMode")){
    		patentCase.setPageActionMode(dataValue);
    		rtnString=patentCase.printBodyDiv();
    	} 
    	if(this.otherValue.equals("doSearchFlag")){
    		patentCase.setDoSearchFlag(dataValue);
    		rtnString=patentCase.printBodyDiv();
    	}
    	if(this.otherValue.equals("tabText")){
    		patentCase.setTabText(dataValue);
        	rtnString=patentCase.printDetailTable();
    	}
    	return rtnString;
    }
    
    private String doLegalCaseRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	LegalCase legalCase = (LegalCase)this.userInfo.getObj(this.className);
    	if(this.otherValue.equals("dbActionMode")){
    		legalCase.setDbActionMode(dataValue);
    		rtnString=legalCase.printBodyDiv();
    	} 
    	if(this.otherValue.equals("pageActionMode")){
    		legalCase.setPageActionMode(dataValue);
    		rtnString=legalCase.printBodyDiv();
    	} 
    	if(this.otherValue.equals("doSearchFlag")){
    		legalCase.setDoSearchFlag(dataValue);
    		rtnString=legalCase.printBodyDiv();
    	}
    	if(this.otherValue.equals("tabText")){
    		legalCase.setTabText(dataValue);
        	rtnString=legalCase.printDetailTable();
    	}
    	return rtnString;
    }
    
    private String doTrademarkCaseRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	TrademarkCase trademarkCase = (TrademarkCase)this.userInfo.getObj(this.className);
    	if(this.otherValue.equals("dbActionMode")){
    		trademarkCase.setDbActionMode(dataValue);
    		rtnString=trademarkCase.printBodyDiv();
    	} 
    	if(this.otherValue.equals("pageActionMode")){
    		trademarkCase.setPageActionMode(dataValue);
    		rtnString=trademarkCase.printBodyDiv();
    	} 
    	if(this.otherValue.equals("doSearchFlag")){
    		trademarkCase.setDoSearchFlag(dataValue);
    		rtnString=trademarkCase.printBodyDiv();
    	}
    	if(this.otherValue.equals("tabText")){
    		trademarkCase.setTabText(dataValue);
        	rtnString=trademarkCase.printDetailTable();
    	}
    	return rtnString;
    }
    
    private String doContractRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	Contract RequestObj = (Contract)this.userInfo.getObj(this.className);
    	if(this.otherValue.equals("dbActionMode")){
    		RequestObj.setDbActionMode(dataValue);
    		rtnString=RequestObj.printBodyDiv();
    	} 
    	if(this.otherValue.equals("pageActionMode")){
    		RequestObj.setPageActionMode(dataValue);
    		rtnString=RequestObj.printBodyDiv();
    	} 
    	if(this.otherValue.equals("doSearchFlag")){
    		RequestObj.setDoSearchFlag(dataValue);
    		rtnString=RequestObj.printBodyDiv();
    	}
    	if(this.otherValue.equals("tabText")){
    		RequestObj.setTabText(dataValue);
        	rtnString=RequestObj.printDetailTable();
    	}
    	return rtnString;
    }
}
