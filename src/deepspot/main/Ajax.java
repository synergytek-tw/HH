package deepspot.main;

import java.util.List;

import deepspot.basic.Cnstnts;
import deepspot.basic.DbUtil;
import deepspot.util.Util;

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
//    	this.otherValue = java.net.URLDecoder.decode(otherValue,"UTF-8");
    	System.out.println("ajax " +  java.net.URLDecoder.decode(otherValue,"UTF-8") );
    	this.flashMode = flashMode;
    	if("Authority".equals(this.className)){
    		rtnString = this.doAuthorityRequest();
    	}
    	if("GoodsApply".equals(this.className)){
    		rtnString = this.doGoodsApplyRequest();
    	} 
    	if("PatentCase".equals(this.className)){
    		rtnString = this.doPatentCaseRequest();
    	}
    	if("CasePrivilege".equals(this.className)){
    		rtnString = this.doCasePrivilegeRequest();
    	}
    	if("Invoice".equals(this.className)){
    		rtnString = this.doInvoiceRequest();
    	}
    	if("Payment".equals(this.className)){
    		rtnString = this.doPaymentRequest();
    	}
    	if("BillManage".equals(this.className)){
    		rtnString = this.doBillManageRequest();
    	}
    	if("PatentCaseInternal".equals(this.className)){
    		rtnString = this.doPatentCaseInternalRequest();
    	}
    	if("Contract".equals(this.className)){
    		rtnString = this.doContractRequest();
    	}
    	if("Client".equals(this.className)){
    		rtnString = this.doClientRequest();
    	}
        if("Receivable".equals(this.className)){
            rtnString = this.doReceivableRequest();
        }

    	if("LegalCase".equals(this.className)){
    		rtnString = this.doLegalCaseRequest();
    	}
    	if("TrademarkCase".equals(this.className)){
    		rtnString = this.doTrademarkCaseRequest();
    	}
    	if("Quotation".equals(this.className)){
    		rtnString = this.doQuotationRequest();
    	}
    	if("SalesOrder".equals(this.className)){
    		rtnString = this.doSalesOrderRequest();
    	}
    	if("CopyrightCase".equals(this.className)){
    		rtnString = this.doCopyrightCaseRequest();
    	}
        
        if(this.className.equals("ReceiptManage")) {
        	rtnString = this.doReceiptManageRequest();
        }
        if(this.className.equals("ServiceProject")) {
        	rtnString = this.doServiceProjectRequest();
        }
    	
    	if("Draft".equals(this.className)
    			|| "DraftReExamineOffice".equals(this.className)
    					|| "DraftTechExamineOffice".equals(this.className)
    					|| "DraftOffice".equals(this.className)){
    		rtnString = this.doDraftRequest();
    	}
    	return rtnString;
  	}

    private String doCopyrightCaseRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	CopyrightCase copyrightCase = (CopyrightCase)this.userInfo.getObj(this.className);
    	if(this.dataValue.equals("CopyrightColleagues")){
    		rtnString = new CopyrightColleagues().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("SalesOrder")){
    		boolean canAssesFlag = false;
			if(copyrightCase.getDbActionMode().equals(Cnstnts.UPDATE)) {
				canAssesFlag = true;
			}
			rtnString = new SalesOrder().printAjaxCaseSalesOrderTable(this.getUserInfo(), copyrightCase.getFlowKey(), canAssesFlag);	
    	}
    	else if(this.dataValue.equals("CopyrightDocument")){
    		rtnString = new CopyrightDocument().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("CopyrightApplicant")){
    		rtnString = new CopyrightApplicant().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("CopyrightPriority")){
    		rtnString = new CopyrightPriority().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("CopyrightAttorney")){
    		rtnString = new CopyrightAttorney().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("CasePrivilege")){
    		rtnString = new CopyrightCasePrivilege().getAjaxReasult2(this.getUserInfo(),this.otherValue, "E");	
    	}
    	else if(this.dataValue.equals("CasePrivilege2")){
    		rtnString = new CopyrightCasePrivilege().getAjaxReasult2(this.getUserInfo(),this.otherValue, "D");	
    	}
    	else if(this.dataValue.equals("CopyrightToDos") ||
    			this.dataValue.equals("CopyrightToDos2")){

    		String[] params = this.otherValue.split("&");
    		if(params != null && params.length >= 3) {
    			rtnString = new CopyrightToDos().getAjaxReasult(this.getUserInfo(),params);
    		}
    		else {
    			rtnString = new CopyrightToDos().getAjaxReasult(this.getUserInfo(),this.otherValue);
    		}
    	}
    	if(this.otherValue.equals("dbActionMode")){
    		copyrightCase.setDbActionMode(dataValue);
    		rtnString=copyrightCase.printBodyDiv();
    	} 
    	if(this.otherValue.equals("pageActionMode")){
    		copyrightCase.setPageActionMode(dataValue);
    		rtnString=copyrightCase.printBodyDiv();
    	} 
    	if(this.otherValue.equals("doSearchFlag")){
    		copyrightCase.setDoSearchFlag(dataValue);
    		rtnString=copyrightCase.printBodyDiv();
    	}
    	if(this.otherValue.equals("tabText")){
    		copyrightCase.setTabText(dataValue);
        	rtnString=copyrightCase.printDetailTable();
    	}
    	return rtnString;
    }

    
    private String doDraftRequest() throws Exception{
    	// System.out.println("into doDraftRequest() - Ajax.java");
		if (this.dataValue.equals("DraftPatent")) {
			return new DraftPatent().getAjaxReasult(this.getUserInfo(),
					this.otherValue);
		} 
		else if(this.otherValue.indexOf("BonusStatus") != -1
				&& "DraftOffice".equals(this.className)) {
			String data[] = this.otherValue.split("&");
			String SQL = "update Draft set BonusStatus ='"
					+ dataValue + "' where FlowKey='" + data[1] + "'";
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		}
		else if (this.dataValue.equals("SendMail01")) {
			return new Draft().sendMail01(this.getUserInfo(),
					this.otherValue);
		}
		else if (this.dataValue.equals("DraftOffice")) {
			return new DraftOffice().getAjaxReasult(this.getUserInfo(),
					this.otherValue);
		}
		else if (this.dataValue.equals("DraftDocument")) {
			return new DraftDocument().getAjaxReasult(this.getUserInfo(),
					this.otherValue);
		} else if (this.dataValue.equals("DraftAttachment")) {
			return new DraftAttachment().getAjaxReasult(this.getUserInfo(),
					this.otherValue);
		} else if (this.dataValue.equals("DraftPic")) {
			return new DraftPic().getAjaxReasult(this.getUserInfo(),
					this.otherValue);
		} 
    	else if(this.otherValue.equals("LoadDeptLeader")){
    		DraftAssignExaminer draftAssignExaminer = new DraftAssignExaminer();
    		draftAssignExaminer.doLoadDeptLeader(this.getUserInfo(), this.dataValue);
    		return draftAssignExaminer.getAjaxReasult(this.getUserInfo(),this.dataValue);	    		
    	} 
    	else if (this.dataValue.equals("DraftRecommend")) {
			return new DraftRecommend().getAjaxReasult(this.getUserInfo(),
					this.otherValue);
		} else if (this.dataValue.equals("DraftInventor")) {
			return new DraftInventor().getAjaxReasult(this.getUserInfo(),
					this.otherValue);
		} else if (this.dataValue.equals("DraftAssignExaminer")) {
			return new DraftAssignExaminer().getAjaxReasult(this.getUserInfo(),
					this.otherValue);
		} else if (this.otherValue.equals("LoadRecommend")) {
			DraftAssignExaminer draftAssignExaminer = new DraftAssignExaminer();
			draftAssignExaminer.doLoadRecommend(this.getUserInfo(),
					this.dataValue);
			return draftAssignExaminer.getAjaxReasult(this.getUserInfo(),
					this.dataValue);
		} else if (this.otherValue.equals("BackToEdit")) {
			DraftTechExamine draftTechExamine = new DraftTechExamine();
			draftTechExamine.doBackToEdit(this.getUserInfo(), this.dataValue, "BackToEdit");
			return "";
		} else if (this.otherValue.equals("Reject")) {
			DraftTechExamine draftTechExamine = new DraftTechExamine();
			draftTechExamine.doBackToEdit(this.getUserInfo(), this.dataValue, "Reject");
			return "";
		} else if (this.otherValue.equals("CreateTechExamine")) {
			DraftAssignExaminer draftAssignExaminer = new DraftAssignExaminer();
			draftAssignExaminer.doCreateTechExamine(this.getUserInfo(),
					this.dataValue);
			return new DraftTechExamine().getAjaxReasult(this.getUserInfo(),
					this.dataValue);
		} else if (this.otherValue.equals("CreateReExamine")) {
			DraftAssignExaminer draftAssignExaminer = new DraftAssignExaminer();
			draftAssignExaminer.doCreateReExamine(this.getUserInfo(),
					this.dataValue);
			return new DraftReExamine().getAjaxReasult(this.getUserInfo(),
					this.dataValue);
		} 
		else if (this.otherValue.indexOf("&") != 0
				&& "DraftTechExamineOffice".equals(this.className)) {
			String data[] = this.otherValue.split("&");
			String SQL = "update DraftTechExamineOffice set " + data[0] + "='"
					+ this.dataValue + "' where FlowKey='" + data[1] + "'";
			// System.out.println(SQL);
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		} 
		else if (this.otherValue.indexOf("&") != 0
				&& "DraftReExamineOffice".equals(this.className)) {
			String data[] = this.otherValue.split("&");
			String SQL = "update DraftReExamineOffice set " + data[0] + "='"
					+ data[2] + "' where FlowKey='" + data[1] + "'";
			// System.out.println(SQL);
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		}
		else if (this.otherValue.indexOf("&") != 0
				&& "Draft".equals(this.className)) {
			String data[] = this.otherValue.split("&");
			if(this.dataValue.indexOf("\"") != -1) {
				this.dataValue = this.dataValue.replaceAll("\"", "\"\"");
			}
			String SQL = "update Draft set " + data[0] + "=\"" + this.dataValue
					+ "\" where FlowKey='" + data[1] + "'";
			// System.out.println(SQL);
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		} else
			return Cnstnts.EMPTY_STRING;
    }
    
    private String doReceiptManageRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	ReceiptManage receivable = (ReceiptManage)this.userInfo.getObj(this.className);

    	if("ReceiptManage".equalsIgnoreCase(this.className)){
    		String SQL = null;
    	
    		if(Util.compareTo(this.dataValue, "Y")) {
    			SQL = "update invoicedetail set Withholding='"+this.dataValue+"', tax2 = 0.1*InvoiceAmount where FlowKey='"+this.otherValue+"'";
    		}
    		else if(Util.compareTo(this.dataValue, "N")) {
    			SQL = "update invoicedetail set Withholding='"+this.dataValue+"', tax2 = 0 where FlowKey='"+this.otherValue+"'";
    		}
//    		SQL = "update invoicedetail set Withholding='"+this.dataValue+"' where FlowKey='"+this.otherValue+"'";
    		System.out.println(SQL);
    		new DbUtil().executeUpdate(SQL);
    		return this.dataValue;	
    	} 
    	return rtnString;
    }
    
    private String doServiceProjectRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	ServiceProject receivable = (ServiceProject)this.userInfo.getObj(this.className);
    	if(this.dataValue.equals("ServiceProjectMember")){
    		rtnString = new ServiceProjectMember().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("ServiceProjectOpponent")){
    		rtnString = new ServiceProjectOpponent().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("ServiceProjectDocument")){
    		rtnString = new ServiceProjectDocument().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("ServiceProjectToDos") ||
    			this.dataValue.equals("ServiceProjectToDos2")){

    		String[] params = this.otherValue.split("&");
    		if(params != null && params.length >= 3) {
    			rtnString = new ServiceProjectToDos().getAjaxReasult(this.getUserInfo(),params);
    		}
    		else {
    			rtnString = new ServiceProjectToDos().getAjaxReasult(this.getUserInfo(),this.otherValue);
    		}
    	}
    	if(this.dataValue.equals("ServiceProjectFeeRecord")){
    		rtnString = new ServiceProjectFeeRecord().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	return rtnString;
    }
    
    private String doReceivableRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	Receivable receivable = (Receivable)this.userInfo.getObj(this.className);
    	if(this.otherValue.equals("InvoiceNo")){
    		rtnString = doGetMaxInvoiceNoRequest(receivable);
    	} 
    	if(this.otherValue.equals("AttorneyTitle")){
    		rtnString = receivable.getAttorneyTitle(dataValue);
    	} 
    	return rtnString;
    }
    

    private String doGetMaxInvoiceNoRequest(Receivable receivable) throws Exception{
        String rtnString = Cnstnts.EMPTY_STRING;
        if(receivable != null && dataValue.trim().length()>0){
            rtnString = receivable.getMaxInvoiceNo(dataValue);
        }
        return rtnString;
    }
    
    private String doLegalCaseRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	LegalCase legalCase = (LegalCase)this.userInfo.getObj(this.className);
    	if(this.dataValue.equals("LegalColleagues")){
    		rtnString = new LegalColleagues().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("SalesOrder")){
    		boolean canAssesFlag = false;
			if(legalCase.getDbActionMode().equals(Cnstnts.UPDATE)) {
				canAssesFlag = true;
			}
			rtnString = new SalesOrder().printAjaxCaseSalesOrderTable(this.getUserInfo(), legalCase.getFlowKey(), canAssesFlag);	
    	}
    	else if(this.dataValue.equals("LegalDocument")){
    		rtnString = new LegalDocument().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("LegalApplicant")){
    		rtnString = new LegalApplicant().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("LegalOpponent")){
    		rtnString = new LegalOpponent().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("LegalRelative")){
    		rtnString = new LegalRelative().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("LegalSitting")){
    		rtnString = new LegalSitting().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("LegalPriority")){
    		rtnString = new LegalPriority().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("LegalAttorney")){
    		rtnString = new LegalAttorney().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("CasePrivilege")){
    		rtnString = new LegalCasePrivilege().getAjaxReasult2(this.getUserInfo(),this.otherValue, "E");	
    	}
    	else if(this.dataValue.equals("CasePrivilege2")){
    		rtnString = new LegalCasePrivilege().getAjaxReasult2(this.getUserInfo(),this.otherValue, "D");	
    	}
    	else if(this.dataValue.equals("LegalDocument")){
    		rtnString = new LegalDocument().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("LegalToDos") ||
    			this.dataValue.equals("LegalToDos2")){

    		String[] params = this.otherValue.split("&");
    		if(params != null && params.length >= 3) {
    			rtnString = new LegalToDos().getAjaxReasult(this.getUserInfo(),params);
    		}
    		else {
    			rtnString = new LegalToDos().getAjaxReasult(this.getUserInfo(),this.otherValue);
    		}
    	}
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
    	if(this.dataValue.equals("TrademarkApplicant")){
    		rtnString = new TrademarkApplicant().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("RenewalLog")){
    		rtnString = trademarkCase.printCaseRenewalLogListTableHtml();	
    	}
    	else if(this.dataValue.equals("SalesOrder")){
    		boolean canAssesFlag = false;
			if(trademarkCase.getDbActionMode().equals(Cnstnts.UPDATE)) {
				canAssesFlag = true;
			}
			rtnString = new SalesOrder().printAjaxCaseSalesOrderTable(this.getUserInfo(), trademarkCase.getFlowKey(), canAssesFlag);	
    	}
    	else if(this.dataValue.equals("TrademarkInventor")){
    		rtnString = new TrademarkInventor().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("TrademarkPriority")){
    		rtnString = new TrademarkPriority().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("TrademarkAttorney")){
    		rtnString = new TrademarkAttorney().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("TrademarkDocument")){
    		rtnString = new TrademarkDocument().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("CasePrivilege")){
    		rtnString = new TrademarkCasePrivilege().getAjaxReasult2(this.getUserInfo(),this.otherValue, "E");	
    	}
    	else if(this.dataValue.equals("CasePrivilege2")){
    		rtnString = new TrademarkCasePrivilege().getAjaxReasult2(this.getUserInfo(),this.otherValue, "D");	
    	}
    	else if(this.dataValue.equals("TrademarkToDos") ||
    			this.dataValue.equals("TrademarkToDos2")){
    		String[] params = this.otherValue.split("&");
    		if(params != null && params.length >= 3) {
    			rtnString = new TrademarkToDos().getAjaxReasult(this.getUserInfo(),params);
    		}
    		else {
    			rtnString = new TrademarkToDos().getAjaxReasult(this.getUserInfo(),this.otherValue);
    		}
    	}
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
    

    private String doQuotationRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	Quotation commissionedCase = (Quotation)this.userInfo.getObj(this.className);
    	if(this.dataValue.equals("Quotation_detail")){
    		rtnString = new Quotation_detail().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	if(this.dataValue.equals("QuotationApplicant")){
    		rtnString = new QuotationApplicant().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	if(this.dataValue.equals("QuotationInventor")){
    		rtnString = new QuotationInventor().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	return rtnString;
    }
    
    private String doSalesOrderRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;

    	if(this.dataValue.equals("SalesOrder_detail")){
    		rtnString = new SalesOrder_detail().getSearchReasult(this.getUserInfo(),this.otherValue);
        	return rtnString;
    	}
    	if(this.dataValue.equals("SalesOrderPriority")){
    		rtnString = new SalesOrderPriority().getSearchReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if (this.otherValue.indexOf("&") != 0) {
			String data[] = this.otherValue.split("&");
			if(Util.compareTo(data[0], "TaskDescription")) {
				String SQL = "update SalesOrder_Detail set " + data[0] + "='"
						+ this.dataValue + "' where FlowKey='" + data[1] + "'";
				System.out.println(SQL);
				new DbUtil().executeUpdate(SQL);
			}
			return "";
		}
    	else if(this.dataValue.equals("RemoveRelatedCase")){
    		String quotationKey = this.getOtherValue().split(";")[0];
    		String soKey = this.getOtherValue().split(";")[1];
    		//�N��w���ץ����p����
    		DbUtil dbtil = new DbUtil();
    		dbtil.executeUpdate("update SalesOrder set parentid = '', RelatedCaseNo = '' where flowkey ='" + soKey + "'");
    		dbtil.executeUpdate("update salesorder_detail set SoStatus = 'OS03' where parentid ='" + soKey + "'");
    		
    		rtnString = new SalesOrder().printAjaxQuotationSalesOrderTable(this.getUserInfo(), quotationKey, true);	
    	}
    	return rtnString;
    }
    
    private String doGoodsApplyRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	GoodsApply goodsApply = (GoodsApply)this.userInfo.getObj(this.className);
    	if(otherValue.trim().length()>0){
    		rtnString=goodsApply.onAjaxRequest(dataValue,otherValue,flashMode);
        } else {
        	rtnString=goodsApply.onAjaxRequest(dataValue,flashMode);
        }
    	return rtnString;
    }
    private String doPatentCaseInternalRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	
    	
    	PatentCaseInternal patentCaseInternal = (PatentCaseInternal)this.userInfo.getObj(this.className);
    	
    	if(this.otherValue.equals("dbActionMode")){
    		patentCaseInternal.setDbActionMode(dataValue);
    		rtnString=patentCaseInternal.printBodyDiv();
    	} 
    	if(this.otherValue.equals("pageActionMode")){
    		patentCaseInternal.setPageActionMode(dataValue);
    		rtnString=patentCaseInternal.printBodyDiv();
    	} 
    	if(this.otherValue.equals("doSearchFlag")){
    		patentCaseInternal.setDoSearchFlag(dataValue);
    		rtnString=patentCaseInternal.printBodyDiv();
    	}
    	if(this.otherValue.equals("tabText")){
    		patentCaseInternal.setTabText(dataValue);
        	rtnString=patentCaseInternal.printDetailTable();
    	}
    	return rtnString;
    }
    
    
    private String doCasePrivilegeRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	
    	System.out.println(this.otherValue);

    	if(this.dataValue.equals("CasePrivilege")){
    		rtnString = new PatentCasePrivilege().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	
    	return rtnString;
    }
    private String doPatentCaseRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	PatentCase patentCase = (PatentCase)this.userInfo.getObj(this.className);
    	if(this.dataValue.equals("PatentDocument")){
    		rtnString = new PatentDocument().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("PatentCitation")){
    		rtnString = new PatentCitation().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("RenewalLog")){
    		rtnString = patentCase.printCaseRenewalLogListTableHtml();	
    	}
    	else if(this.dataValue.equals("PatentCitationUs")){
    		rtnString = new PatentCitationUs().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("PatentCitationEp")){
    		rtnString = new PatentCitationEp().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("CasePrivilege")){
    		rtnString = new PatentCasePrivilege().getAjaxReasult2(this.getUserInfo(),this.otherValue, "E");	
    	}
    	else if(this.dataValue.equals("CasePrivilege2")){
    		rtnString = new PatentCasePrivilege().getAjaxReasult2(this.getUserInfo(),this.otherValue, "D");	
    	}
    	else if(this.dataValue.equals("PatentToDos") ||
    			this.dataValue.equals("PatentToDos2")){
    		String[] params = this.otherValue.split("&");
    		if(params != null && params.length >= 3) {
    			rtnString = new PatentToDos().getAjaxReasult(this.getUserInfo(),params);
    		}
    		else {
    			rtnString = new PatentToDos().getAjaxReasult(this.getUserInfo(),this.otherValue);
    		}
    	}
    	else if(this.dataValue.equals("SalesOrder")){
    		boolean canAssesFlag = false;
			if(patentCase.getDbActionMode().equals(Cnstnts.UPDATE)) {
				canAssesFlag = true;
			}
			rtnString = new SalesOrder().printAjaxCaseSalesOrderTable(this.getUserInfo(), patentCase.getFlowKey(), canAssesFlag);	
    	}
    	else if(this.dataValue.equals("PatentApplicant")){
    		rtnString = new PatentApplicant().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("PatentInventor")){
    		rtnString = new PatentInventor().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("PatentAttorney")){
    		rtnString = new PatentAttorney().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("PatentPriority")){
    		rtnString = new PatentPriority().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.otherValue.equals("dbActionMode")){
    		patentCase.setDbActionMode(dataValue);
    		rtnString=patentCase.printBodyDiv();
    	} 
    	else if(this.otherValue.equals("pageActionMode")){
    		patentCase.setPageActionMode(dataValue);
    		rtnString=patentCase.printBodyDiv();
    	} 
    	else if(this.otherValue.equals("doSearchFlag")){
    		patentCase.setDoSearchFlag(dataValue);
    		rtnString=patentCase.printBodyDiv();
    	}
    	else if(this.otherValue.equals("tabText")){
    		patentCase.setTabText(dataValue);
        	rtnString=patentCase.printDetailTable();
    	}
    	return rtnString;
    }

    private String doInvoiceRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	Invoice invoice = (Invoice)this.userInfo.getObj(this.className);
    	if(this.dataValue.equals("InvoiceDetail")){
    		rtnString = new InvoiceDetail().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	return rtnString;
    }

    private String doPaymentRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	Payment payment = (Payment)this.userInfo.getObj(this.className);
    	if(this.dataValue.equals("PaymentDetail")){
    		rtnString = new PaymentDetail().getAjaxReasult(this.getUserInfo(),this.otherValue);	
    	}
    	else if(this.dataValue.equals("PaymentOther")){
    		rtnString = new PaymentDetail().getAjaxReasult2(this.getUserInfo(),this.otherValue);	
    	}
    	return rtnString;
    }

    private String doBillManageRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	BillManage billManage = (BillManage)this.userInfo.getObj(this.className);
    	if(this.otherValue.equals("dbActionMode")){
    		billManage.setDbActionMode(dataValue);
    		rtnString=billManage.printBodyDiv();
    	} 
    	if(this.otherValue.equals("pageActionMode")){
    		billManage.setPageActionMode(dataValue);
    		rtnString=billManage.printBodyDiv();
    	} 
    	if(this.otherValue.equals("doSearchFlag")){
    		billManage.setDoSearchFlag(dataValue);
    		rtnString=billManage.printBodyDiv();
    	}
    	if(this.otherValue.equals("tabText")){
    		billManage.setTabText(dataValue);
        	rtnString=billManage.printDetailTable();
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

    
    private String doClientRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	System.out.println(this.dataValue);
    	if(this.dataValue.equals("ClientApplicant")){
    		String client = this.getOtherValue().split(";")[0];
    		String applicant = this.getOtherValue().split(";")[1];
    		//�N��w���p���H��ƪ����s����
    		new DbUtil().executeUpdate("update applicant set showinclient = 'N' where flowkey ='" + applicant + "'");
    		rtnString = new Client().printApplicantTableHtml(this.getUserInfo(), client);	
    	}
    	if(this.dataValue.equals("ClientApplicant2")){
    		String client = this.getOtherValue();
    		rtnString = new Client().printApplicantTableHtml(this.getUserInfo(), client);	
    	}
    	if(this.dataValue.equals("ClientBilling")){
    		String client = this.getOtherValue();
    		rtnString = new ClientBilling().getAjaxReasult(this.getUserInfo(),this.otherValue);
    	}
    	if(this.dataValue.equals("ClientAppTable")){
//    		Client client = new Client(this.getOtherValue());
//    		client.setUserInfo(this.getUserInfo());
    		Client client = (Client)this.getUserInfo().getObj("Client");
    		rtnString = client.printApplicantTableHtml2();	
    	}
    	if(this.dataValue.equals("InventorTable")){
//    		Client client = new Client(this.getOtherValue());
//    		client.setUserInfo(this.getUserInfo());
    		Client client = (Client)this.getUserInfo().getObj("Client");
    		rtnString = client.printInventorTableHtml();	
    	}
    	if(this.dataValue.equals("CaseTable")){
    		Client client = (Client)this.getUserInfo().getObj("Client");
    		rtnString = client.printCaseTableHtml();	
    	}
    	if(this.dataValue.equals("ClientDocument")){
    		//Client client = (Client)this.getUserInfo().getObj("Client");
    		//rtnString = client.printCaseTableHtml();	
    		rtnString = new ClientDocument().getAjaxReasult(this.getUserInfo(),this.otherValue);
    	}
    	if(this.dataValue.equals("ServiceProject")){
    		Client client = (Client)this.getUserInfo().getObj("Client");
    		rtnString = client.printServiceProjectTableHtml();	
    	}
    	if(this.dataValue.equals("NotYetWriteOffInvoice")){
    		Client client = (Client)this.getUserInfo().getObj("Client");
    		rtnString = client.printNotYetWriteOffInvoiceTableHtml();	
    	}
    	if(this.dataValue.equals("Quotation1")){
    		DbUtil db = new DbUtil();
    		Client client = (Client)this.getUserInfo().getObj("Client");
    		
    		String sql = "select flowkey from Quotation where client = '" + client.getFlowKey() + "' and BasicQuotation = 'Y' order by QuotationDate desc";
            List<String> keys = db.getValueList(sql, "flowkey");
            
            sql = "select flowkey from Quotation where client = '" + client.getFlowKey() + "' and (QuotationDate is not null and QuotationDate != '') order by QuotationDate desc";
            keys.addAll(db.getValueList(sql, "flowkey"));
            if(keys != null && keys.size() > 0) {
//            	Quotation cc = new Quotation(keys.get(0));
//            	cc.setDbFields();
//            	cc.setUserInfo(this.getUserInfo());
//            	cc.setDbActionMode(Cnstnts.QUERY);
//            	cc.setPageActionMode(Cnstnts.MAINTAIN);
//            	
//            	if(this.getUserInfo().getObj("Quotation") == null) {
//            		this.getUserInfo().setObj("Quotation", cc);
//            	}
//            	
//            	rtnString = cc.printMaintainTable();
            	rtnString = "<iframe width='100%' height=600 src='Quotation.jsp?dbActionModequery&pageActionMode=maintain&modeLockFlag=true&flowKey=" + keys.get(0) + "'>";
            }
    	}
    	if(this.dataValue.equals("Quotation2")){
    		DbUtil db = new DbUtil();
    		Client client = (Client)this.getUserInfo().getObj("Client");
    		
    		String sql = "select flowkey from Quotation where client = '" + client.getFlowKey() + "' and BasicQuotation = 'Y' order by QuotationDate desc";
            List<String> keys = db.getValueList(sql, "flowkey");
            
            sql = "select flowkey from Quotation where client = '" + client.getFlowKey() + "' and (QuotationDate is not null and QuotationDate != '') order by QuotationDate desc";
            keys.addAll(db.getValueList(sql, "flowkey"));
           
            if(keys != null && keys.size() > 1) {
//            	Quotation cc = new Quotation(keys.get(1));
//            	cc.setDbFields();
//            	cc.setUserInfo(this.getUserInfo());
//            	cc.setDbActionMode(Cnstnts.QUERY);
//            	cc.setPageActionMode(Cnstnts.MAINTAIN);
//            	rtnString = cc.printMaintainTable();
            	rtnString = "<iframe width='100%' height=600 src='Quotation.jsp?dbActionModequery&pageActionMode=maintain&modeLockFlag=true&flowKey=" + keys.get(1) + "'>";
            }
    	}
    	return rtnString;
    }
    
    private String doAuthorityRequest() throws Exception{
    	String rtnString = Cnstnts.EMPTY_STRING;
    	if(this.otherValue.indexOf("ResetPersonalAuthority") != -1) {
			String SQL = "delete from Authority where AuthorityType ='Employee' "
					+ " and KeyValue ='" + dataValue + "'";
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		}
    	if(this.otherValue.indexOf("ResetAllPersonalAuthority") != -1) {
			String SQL = "delete from Authority where AuthorityType ='Employee' ";
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		}
    	if(this.otherValue.indexOf("ResetGroupsAuthority") != -1) {
			String SQL = "delete from Authority where AuthorityType ='Groups' "
					+ " and KeyValue ='" + dataValue + "'";
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		}
    	if(this.otherValue.indexOf("ResetAllGroupsAuthority") != -1) {
			String SQL = "delete from Authority where AuthorityType ='Groups' ";
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		}
    	if(this.otherValue.indexOf("ResetDepartmentAuthority") != -1) {
			String SQL = "delete from Authority where AuthorityType ='Department' "
					+ " and KeyValue ='" + dataValue + "'";
			System.out.println(SQL);
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		}
    	if(this.otherValue.indexOf("ResetAllDepartmentAuthority") != -1) {
			String SQL = "delete from Authority where AuthorityType ='Department' ";
			new DbUtil().executeUpdate(SQL);
			return this.dataValue;
		}
    	return rtnString;
    }
    
}
