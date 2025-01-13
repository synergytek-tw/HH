package deepspot.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.athenasoft.ooutil.OoConverter;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.basic.SelectItem;
import deepspot.html.HiddenTag;
import deepspot.util.Util;

public class ClientDocument extends MultiDetail {

    public ClientDocument(){this.init();}

    public ClientDocument(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field DocumentType;
    public void setDocumentType(String DocumentType){this.DocumentType.setValue(DocumentType);}
    public String getDocumentType(){return this.DocumentType.getValue();}

    public Field DocumentUrl;
    public void setDocumentUrl(String DocumentUrl){this.DocumentUrl.setValue(DocumentUrl);}
    public String getDocumentUrl(){return this.DocumentUrl.getValue();}

    public Field DocumentName;
    public void setDocumentName(String DocumentName){this.DocumentName.setValue(DocumentName);}
    public String getDocumentName(){return this.DocumentName.getValue();}
    
    public Field DocumentNo;
    public void setDocumentNo(String DocumentNo){this.DocumentNo.setValue(DocumentNo);}
    public String getDocumentNo(){return this.DocumentNo.getValue();}
    
    public Field DocumentKind;
    public void setDocumentKind(String DocumentKind){this.DocumentKind.setValue(DocumentKind);}
    public String getDocumentKind(){return this.DocumentKind.getValue();}
    
    public Field DocumentDate;
    public void setDocumentDate(String DocumentDate){this.DocumentDate.setValue(DocumentDate);}
    public String getDocumentDate(){return this.DocumentDate.getValue();}
    
    public Field DocumentTarget;
    public void setDocumentTarget(String DocumentTarget){this.DocumentTarget.setValue(DocumentTarget);}
    public String getDocumentTarget(){return this.DocumentTarget.getValue();}
    
    public Field DocumentProcess;
    public void setDocumentProcess(String DocumentProcess){this.DocumentProcess.setValue(DocumentProcess);}
    public String getDocumentProcess(){return this.DocumentProcess.getValue();}
    
    public Field LinkOthers;
    public void setLinkOthers(String LinkOthers){this.LinkOthers.setValue(LinkOthers);}
    public String getLinkOthers(){return this.LinkOthers.getValue();}
    
    public Field Contractor;
    public void setContractor(String Contractor){this.Contractor.setValue(Contractor);}
    public String getContractor(){return this.Contractor.getValue();}
    
    public Field ContractorDept;
    public void setContractorDept(String ContractorDept){this.ContractorDept.setValue(ContractorDept);}
    public String getContractorDept(){return this.ContractorDept.getValue();}
    
    public Field StandardTask;
    public void setStandardTask(String StandardTask){this.StandardTask.setValue(StandardTask);}
    public String getStandardTask(){return this.StandardTask.getValue();}
    
    public Field DeadlineDate;
    public void setDeadlineDate(String DeadlineDate){this.DeadlineDate.setValue(DeadlineDate);}
    public String getDeadlineDate(){return this.DeadlineDate.getValue();}
    
    public Field DocumentUnit;
    public void setDocumentUnit(String DocumentUnit){this.DocumentUnit.setValue(DocumentUnit);}
    public String getDocumentUnit(){return this.DocumentUnit.getValue();}
    
    public Field Remark;
    public void setRemark(String Remark){this.Remark.setValue(Remark);}
    public String getRemark(){return this.Remark.getValue();}
    
    public Field IsAddToDos;
    public void setIsAddToDos(String IsAddToDos){this.IsAddToDos.setValue(IsAddToDos);}
    public String getIsAddToDos(){return this.IsAddToDos.getValue();}
    
    
    public Field Subject;
    public void setSubject(String Subject){this.Subject.setValue(Subject);}
    public String getSubject(){return this.Subject.getValue();}
    
    public Field Amount;
    public void setAmount(String Amount){this.Amount.setValue(Amount);}
    public String getAmount(){return this.Amount.getValue();}
    
    public Field AccountingType;
    public void setAccountingType(String AccountingType){this.AccountingType.setValue(AccountingType);}
    public String getAccountingType(){return this.AccountingType.getValue();}
    
    public Field Currency;
    public void setCurrency(String Currency){this.Currency.setValue(Currency);}
    public String getCurrency(){return this.Currency.getValue();}
    
    public Field CaseStatus;
    public void setCaseStatus(String CaseStatus){this.CaseStatus.setValue(CaseStatus);}
    public String getCaseStatus(){return this.CaseStatus.getValue();}
    
    public Field MaintainLinkOthers;
    public void setMaintainLinkOthers(String MaintainLinkOthers){this.MaintainLinkOthers.setValue(MaintainLinkOthers);}
    public String getMaintainLinkOthers(){return this.MaintainLinkOthers.getValue();}
    
    public String configItemData;
    
    public Field LinkMode;
    public void setLinkMode(String LinkMode){this.LinkMode.setValue(LinkMode);}
    public String getLinkMode(){return this.LinkMode.getValue();}

    public Field DocumentUrl2;
    public void setDocumentUrl2(String DocumentUrl2){this.DocumentUrl2.setValue(DocumentUrl2);}
    public String getDocumentUrl2(){return this.DocumentUrl2.getValue();}

    public Field DocumentUrl3;
    public void setDocumentUrl3(String DocumentUrl3){this.DocumentUrl3.setValue(DocumentUrl3);}
    public String getDocumentUrl3(){return this.DocumentUrl3.getValue();}

    public Field DocumentUrl4;
    public void setDocumentUrl4(String DocumentUrl4){this.DocumentUrl4.setValue(DocumentUrl4);}
    public String getDocumentUrl4(){return this.DocumentUrl4.getValue();}

    public Field DocumentUrl5;
    public void setDocumentUrl5(String DocumentUrl5){this.DocumentUrl5.setValue(DocumentUrl5);}
    public String getDocumentUrl5(){return this.DocumentUrl5.getValue();}

    public Field DocumentUrl6;
    public void setDocumentUrl6(String DocumentUrl6){this.DocumentUrl6.setValue(DocumentUrl6);}
    public String getDocumentUrl6(){return this.DocumentUrl6.getValue();}

    public Field DocumentUrl7;
    public void setDocumentUrl7(String DocumentUrl7){this.DocumentUrl7.setValue(DocumentUrl7);}
    public String getDocumentUrl7(){return this.DocumentUrl7.getValue();}

    public Field DocumentUrl8;
    public void setDocumentUrl8(String DocumentUrl8){this.DocumentUrl8.setValue(DocumentUrl8);}
    public String getDocumentUrl8(){return this.DocumentUrl8.getValue();}
    
    public Field CcSendType;
    public void setCcSendType(String CcSendType){this.CcSendType.setValue(CcSendType);}
    public String getCcSendType(){return this.CcSendType.getValue();}
    
    public Field CcSendDate;
    public void setCcSendDate(String CcSendDate){this.CcSendDate.setValue(CcSendDate);}
    public String getCcSendDate(){return this.CcSendDate.getValue();}
    
    public Field Receiver;
    public void setReceiver(String Receiver){this.Receiver.setValue(Receiver);}
    public String getReceiver(){return this.Receiver.getValue();}

    public Field MailNo;
    public void setMailNo(String MailNo){this.MailNo.setValue(MailNo);}
    public String getMailNo(){return this.MailNo.getValue();}
    
    public Field AttachmentName;
    public void setAttachmentName(String AttachmentName){this.AttachmentName.setValue(AttachmentName);}
    public String getAttachmentName(){return this.AttachmentName.getValue();}
    
    public Field AttachmentName2;
    public void setAttachmentName2(String AttachmentName2){this.AttachmentName2.setValue(AttachmentName2);}
    public String getAttachmentName2(){return this.AttachmentName2.getValue();}
    
    public Field AttachmentName3;
    public void setAttachmentName3(String AttachmentName3){this.AttachmentName3.setValue(AttachmentName3);}
    public String getAttachmentName3(){return this.AttachmentName3.getValue();}
    
    public Field AttachmentName4;
    public void setAttachmentName4(String AttachmentName4){this.AttachmentName4.setValue(AttachmentName4);}
    public String getAttachmentName4(){return this.AttachmentName4.getValue();}
    
    public Field AttachmentName5;
    public void setAttachmentName5(String AttachmentName5){this.AttachmentName5.setValue(AttachmentName5);}
    public String getAttachmentName5(){return this.AttachmentName5.getValue();}
    
    public Field AttachmentName6;
    public void setAttachmentName6(String AttachmentName6){this.AttachmentName6.setValue(AttachmentName6);}
    public String getAttachmentName6(){return this.AttachmentName6.getValue();}
    
    public Field AttachmentName7;
    public void setAttachmentName7(String AttachmentName7){this.AttachmentName7.setValue(AttachmentName7);}
    public String getAttachmentName7(){return this.AttachmentName7.getValue();}
    
    public Field AttachmentName8;
    public void setAttachmentName8(String AttachmentName8){this.AttachmentName8.setValue(AttachmentName8);}
    public String getAttachmentName8(){return this.AttachmentName8.getValue();}
    
    public Field ServiceFee;
    public void setServiceFee(String ServiceFee){this.ServiceFee.setValue(ServiceFee);}
    public String getServiceFee(){return this.ServiceFee.getValue();}
    
    public Field ServiceFeeCurrency;
    public void setServiceFeeCurrency(String ServiceFeeCurrency){this.ServiceFeeCurrency.setValue(ServiceFeeCurrency);}
    public String getServiceFeeCurrency(){return this.ServiceFeeCurrency.getValue();}
    
    public Field ArFee;
    public void setArFee(String ArFee){this.ArFee.setValue(ArFee);}
    public String getArFee(){return this.ArFee.getValue();}
    
    public Field ArFeeCurrency;
    public void setArFeeCurrency(String ArFeeCurrency){this.ArFeeCurrency.setValue(ArFeeCurrency);}
    public String getArFeeCurrency(){return this.ArFeeCurrency.getValue();}
    
    public Field ApFee;
    public void setApFee(String ApFee){this.ApFee.setValue(ApFee);}
    public String getApFee(){return this.ApFee.getValue();}
    
    public Field ApFeeCurrency;
    public void setApFeeCurrency(String ApFeeCurrency){this.ApFeeCurrency.setValue(ApFeeCurrency);}
    public String getApFeeCurrency(){return this.ApFeeCurrency.getValue();}
    
    public Field CreateTime;
    public void setCreateTime(String CreateTime){this.CreateTime.setValue(CreateTime);}
    public String getCreateTime(){return this.CreateTime.getValue();}
    
    public Field HideAttachmentFields;
    public void setHideAttachmentFields(String HideAttachmentFields){this.HideAttachmentFields.setValue(HideAttachmentFields);}
    public String getHideAttachmentFields(){return this.HideAttachmentFields.getValue();}
    
    public String changeDisplayHideFlag;
    
    public String getChangeDisplayHideFlag() {
    	return changeDisplayHideFlag;
    }
    
    public void setChangeDisplayHideFlag(String changeDisplayHideFlag) {
    	this.changeDisplayHideFlag = changeDisplayHideFlag;
    }
    
    public String createDocFlag;
    
    public String getCreateDocFlag() {
		return createDocFlag;
	}

	public void setCreateDocFlag(String createDocFlag) {
		this.createDocFlag = createDocFlag;
	}

	public String getConfigItemData() {
    	if(configItemData != null) {
    		return configItemData;
    	}
    	else {
    		return "";
    	}
    }

    public void setConfigItemData(String configItemData) {
        this.configItemData = configItemData;
    }
    
    public String finishedItemData;

    public String getFinishedItemData() {
    	if(Util.isEmpty(finishedItemData)) {
    		return "";
    	}
		return finishedItemData;
	}

	public void setFinishedItemData(String finishedItemData) {
		this.finishedItemData = finishedItemData;
	}
	
	public String finishedDateData;

	public String getFinishedDateData() {
		return finishedDateData;
	}

	public void setFinishedDateData(String finishedDateData) {
		this.finishedDateData = finishedDateData;
	}

	public String[] Urls;
    

    public String[] getUrls() {
		return Urls;
	}

	public void setUrls(String[] urls) {
		Urls = urls;
	}
	
	public String OutputFile2;

    public String getOutputFile2() {
		return OutputFile2;
	}

	public void setOutputFile2(String outputFile2) {
		OutputFile2 = outputFile2;
	}

	final int FRAME_HEIGHT = 280;
	
	private HttpServletRequest request;

    public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void init() {
        super.init();
        this.setProgramId("jsp.ClientDocument");
        this.setTableName("ClientDocument");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.DocumentType = new Field("DocumentType", this.getTableName());
        //this.DocumentType.setCheckEmpty(true);
        this.DocumentType.setDbType("varchar(50)");

        this.DocumentUrl = new Field("DocumentUrl", this.getTableName());
        //this.DocumentUrl.setCheckEmpty(true);
        this.DocumentUrl.setDbType("varchar(4000)");

        this.DocumentUrl2 = new Field("DocumentUrl2", this.getTableName());
        this.DocumentUrl2.setDbType("varchar(200)");

        this.DocumentUrl3 = new Field("DocumentUrl3", this.getTableName());
        this.DocumentUrl3.setDbType("varchar(200)");

        this.DocumentUrl4 = new Field("DocumentUrl4", this.getTableName());
        this.DocumentUrl4.setDbType("varchar(200)");

        this.DocumentUrl5 = new Field("DocumentUrl5", this.getTableName());
        this.DocumentUrl5.setDbType("varchar(200)");

        this.DocumentUrl6 = new Field("DocumentUrl6", this.getTableName());
        this.DocumentUrl6.setDbType("varchar(200)");

        this.DocumentUrl7 = new Field("DocumentUrl7", this.getTableName());
        this.DocumentUrl7.setDbType("varchar(200)");

        this.DocumentUrl8 = new Field("DocumentUrl8", this.getTableName());
        this.DocumentUrl8.setDbType("varchar(200)");

        this.DocumentName = new Field("DocumentName", this.getTableName());
        this.DocumentName.setCheckEmpty(true);
        this.DocumentName.setDbType("nvarchar(100)");
        
        this.DocumentNo = new Field("DocumentNo", this.getTableName());
        this.DocumentNo.setDbType("varchar(50)");
        
        this.DocumentKind = new Field("DocumentKind", this.getTableName());
        this.DocumentKind.setDbType("varchar(50)");
        this.DocumentKind.setCheckEmpty(true);
        
        this.DocumentTarget = new Field("DocumentTarget", this.getTableName());
        this.DocumentTarget.setDbType("varchar(50)");
        
        this.DocumentDate = new Field("DocumentDate", this.getTableName());
        this.DocumentDate.setDbType("varchar(10)");
        
        this.DocumentProcess = new Field("DocumentProcess", this.getTableName());
        this.DocumentProcess.setDbType("varchar(50)");
        //this.DocumentProcess.setCheckEmpty(true);
        
        this.LinkOthers = new Field("LinkOthers", "");
        this.LinkOthers.setDbType("varchar(1)");
        
        this.Contractor = new Field("Contractor", this.getTableName());
        this.Contractor.setDbType("varchar(50)");
        //this.Contractor.setCheckEmpty(true);
        
        this.ContractorDept = new Field("ContractorDept", this.getTableName());
        this.ContractorDept.setDbType("varchar(50)");
        
        this.StandardTask = new Field("StandardTask", this.getTableName());
        this.StandardTask.setDbType("varchar(1000)");
        
        this.DeadlineDate = new Field("DeadlineDate", this.getTableName());
        this.DeadlineDate.setDbType("varchar(10)");
        
        this.DocumentUnit = new Field("DocumentUnit", this.getTableName());
        this.DocumentUnit.setDbType("varchar(50)");
        this.DocumentUnit.setCheckEmpty(true);
        
        this.Remark = new Field("Remark", this.getTableName());
        this.Remark.setDbType("varchar(500)");
        
        this.Amount = new Field("Amount", this.getTableName());
        this.Amount.setDbType("float");
        this.Amount.setDecimal(2);
        
        this.Subject = new Field("Subject", this.getTableName());
        this.Subject.setDbType("varchar(50)");
        
        this.AccountingType = new Field("AccountingType", this.getTableName());
        this.AccountingType.setDbType("varchar(50)");
        
        this.Currency = new Field("Currency", this.getTableName());
        this.Currency.setDbType("varchar(50)");
        
        this.MaintainLinkOthers = new Field("MaintainLinkOthers", "");
        this.MaintainLinkOthers.setDbType("varchar(1)");

        
        this.StandardTask = new Field("StandardTask", this.getTableName());
        this.StandardTask.setDbType("varchar(1000)");
        
        this.CaseStatus = new Field("CaseStatus", this.getTableName());
        this.CaseStatus.setDbType("varchar(50)");
        
        this.CcSendType = new Field("CcSendType", this.getTableName());
        this.CcSendType.setDbType("varchar(50)");

        this.CcSendDate = new Field("CcSendDate", this.getTableName());
        this.CcSendDate.setDbType("varchar(10)");

        this.Receiver = new Field("Receiver", this.getTableName());
        this.Receiver.setDbType("varchar(100)");

        this.MailNo = new Field("MailNo", this.getTableName());
        this.MailNo.setDbType("varchar(100)");
        
        this.AttachmentName = new Field("AttachmentName", this.getTableName());
        this.AttachmentName.setDbType("varchar(400)");
        
        this.AttachmentName2 = new Field("AttachmentName2", this.getTableName());
        this.AttachmentName2.setDbType("varchar(400)");
        
        this.AttachmentName3 = new Field("AttachmentName3", this.getTableName());
        this.AttachmentName3.setDbType("varchar(400)");
        
        this.AttachmentName4 = new Field("AttachmentName4", this.getTableName());
        this.AttachmentName4.setDbType("varchar(400)");
        
        this.AttachmentName5 = new Field("AttachmentName5", this.getTableName());
        this.AttachmentName5.setDbType("varchar(400)");
        
        this.AttachmentName6 = new Field("AttachmentName6", this.getTableName());
        this.AttachmentName6.setDbType("varchar(400)");
        
        this.AttachmentName7 = new Field("AttachmentName7", this.getTableName());
        this.AttachmentName7.setDbType("varchar(400)");
        
        this.AttachmentName8 = new Field("AttachmentName8", this.getTableName());
        this.AttachmentName8.setDbType("varchar(400)");
        
        this.ServiceFee = new Field("ServiceFee", this.getTableName());
        this.ServiceFee.setDbType("float");
        this.ServiceFee.setDecimal(2);
        
        this.ServiceFeeCurrency = new Field("ServiceFeeCurrency", this.getTableName());
        this.ServiceFeeCurrency.setDbType("varchar(50)");

        this.ArFee = new Field("ArFee", this.getTableName());
        this.ArFee.setDbType("float");
        this.ArFee.setDecimal(2);

        this.ArFeeCurrency = new Field("ArFeeCurrency", this.getTableName());
        this.ArFeeCurrency.setDbType("varchar(50)");

        this.ApFee = new Field("ApFee", this.getTableName());
        this.ApFee.setDbType("float");
        this.ApFee.setDecimal(2);

        this.ApFeeCurrency = new Field("ApFeeCurrency", this.getTableName());
        this.ApFeeCurrency.setDbType("varchar(50)");

        this.CreateTime = new Field("CreateTime", this.getTableName());
        this.CreateTime.setDbType("varchar(20)");
        
        this.HideAttachmentFields = new Field("HideAttachmentFields", this.getTableName());
        
        this.IsAddToDos = new Field("IsAddToDos", "");
        
        this.LinkMode = new Field("LinkMode", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }
    
    public String printHiddenTags() {
        String rtnString = super.printHiddenTags();
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("configItemData", getConfigItemData());
        hm.put("finishedItemData", getConfigItemData());
        hm.put("finishedDateData", getConfigItemData());
        hm.put("createDocFlag", getConfigItemData());
        rtnString += new HiddenTag().print(hm);
        return rtnString;
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.DocumentType);

        this.DbFields.add(this.DocumentUrl);

        this.DbFields.add(this.DocumentUrl2);

        this.DbFields.add(this.DocumentUrl3);

        this.DbFields.add(this.DocumentUrl4);

        this.DbFields.add(this.DocumentUrl5);

        this.DbFields.add(this.DocumentUrl6);

        this.DbFields.add(this.DocumentUrl7);

        this.DbFields.add(this.DocumentUrl8);

        this.DbFields.add(this.DocumentName);
        
        this.DbFields.add(this.DocumentDate);
        
        this.DbFields.add(this.DocumentNo);
        
        this.DbFields.add(this.DocumentKind);
        
        this.DbFields.add(this.DocumentTarget);
        
        this.DbFields.add(this.Contractor);
        
        this.DbFields.add(this.DocumentProcess);
        
        this.DbFields.add(this.ContractorDept);
        
        this.DbFields.add(this.StandardTask);
        
        this.DbFields.add(this.LinkOthers);
        
        this.DbFields.add(this.DeadlineDate);
        
        this.DbFields.add(this.DocumentUnit);
        
        this.DbFields.add(this.Remark);
        
        this.DbFields.add(this.Amount);
        
        this.DbFields.add(this.Subject);
        
        this.DbFields.add(this.AccountingType);
        
        this.DbFields.add(this.Currency);
        
        this.DbFields.add(this.CaseStatus);

        this.DbFields.add(this.CcSendType);

        this.DbFields.add(this.CcSendDate);

        this.DbFields.add(this.Receiver);

        this.DbFields.add(this.MailNo);

        this.DbFields.add(this.AttachmentName);

        this.DbFields.add(this.AttachmentName2);

        this.DbFields.add(this.AttachmentName3);

        this.DbFields.add(this.AttachmentName4);

        this.DbFields.add(this.AttachmentName5);

        this.DbFields.add(this.AttachmentName6);

        this.DbFields.add(this.AttachmentName7);

        this.DbFields.add(this.AttachmentName8);
        
        this.DbFields.add(this.ServiceFee);

        this.DbFields.add(this.ServiceFeeCurrency);

        this.DbFields.add(this.ArFee);

        this.DbFields.add(this.ArFeeCurrency);

        this.DbFields.add(this.ApFee);

        this.DbFields.add(this.ApFeeCurrency);
        
        this.DbFields.add(this.MaintainLinkOthers);
        
        this.DbFields.add(this.CreateTime);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	rtnString += this.CreateTime.printHiddenTag();
        	rtnString += "<input type='hidden' name='insertAddFlag' id='insertAddFlag'>";
        	
        	//PatentCase patent = new PatentCase(this.getParentId());
        	
        	this.DocumentUnit.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.DocumentUnit.setSelectList(new Category().getChildList(this.DocumentUnit));
            this.DocumentUnit.setOnChange("setValue()");
        	
        	this.DocumentKind.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.DocumentKind.setSelectList(new Category().getChildList(this.DocumentKind));
            this.DocumentKind.setAnotherField(this.DocumentUnit);
            this.DocumentKind.setColspan(1);
            rtnString += this.printHtml(this.DocumentKind);
            
            this.DocumentTarget.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.DocumentTarget.setSelectList(null);
            if(Util.compareTo(this.getDocumentUnit(), "DU01")) {
            	this.DocumentTarget.setSelectList(new Category().getChildList(this.DocumentTarget));
            }
            else if(Util.compareTo(this.getDocumentUnit(), "DU02")) {
            	/*
            	if(this.getDbActionMode().equals(Cnstnts.INSERT) && Util.isEmpty(this.getDocumentTarget())) {
            		this.DocumentTarget.setValue(new PatentCase(this.getParentId()).getAttorney());
            	}
            	*/
            	this.DocumentTarget.setSelectList(new Attorney().getList());
            }
            else if(Util.compareTo(this.getDocumentUnit(), "DU03")) {
            	if(this.getDbActionMode().equals(Cnstnts.INSERT) && Util.isEmpty(this.getDocumentTarget())) {
            		this.DocumentTarget.setValue(new PatentCase(this.getParentId()).getClient());
            	}
            	String sql = "select flowkey, CompanyName from client where flowkey ='" + this.getFlowKey() + "'";
            	List<SelectItem> items = this.getDbUtil().getSelectItemList(sql, "Flowkey", "CompanyName");
            	this.DocumentTarget.setSelectList(items);
            }
            else if(Util.compareTo(this.getDocumentUnit(), "DU04")) {
            	this.DocumentTarget.setSelectList(new Employee().getList());
            }
            
            this.DocumentNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.DocumentNo.setAnotherField(this.DocumentTarget);
            this.DocumentNo.setColspan(1);
            rtnString += this.printHtml(this.DocumentNo);
            
//            this.DocumentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//            this.DocumentType.setSelectList(new Category().getChildList(this.DocumentType));
//            rtnString += this.printHtml(this.DocumentType);
            

            this.DeadlineDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
        	this.DocumentDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        	this.DocumentDate.setOnChange("checkDocumentDate();");
        	this.DocumentDate.setAnotherField(this.DeadlineDate);
            this.DocumentDate.setColspan(1);
            rtnString += this.printHtml(this.DocumentDate);
            
            rtnString +="<script>function checkDocumentDate(){" +
            		"var dateStamp = new Date();" +
            		"var nowDate = dateStamp.getFullYear()+\"/\"+(dateStamp.getMonth()+1)+\"/\"+dateStamp.getDate();" +
            		"var documentDate = ($(\"#documentDate\").val()).replace(/\\-/g,\"/\");" +
            		"var now = Date.parse(nowDate);" +
            		"var document = Date.parse(documentDate);" +
            		"if(document > now){" +
            		"	alert(\""+this.getUserInfo().getMsg("jsp.ToDos.DocumentDateError")+"\");" +
            		"};" +
            		"}</script>";
        	/*
            String sql = "SELECT FlowKey, MatterName FROM patentmatterconfig " +
            		"where casekind ='STC01' and forsales != 'Y'  " +
            		"and patentoffice like '%" + patent.getPatentOffice() + ",%' " +
            		"and patenttype like '%" + patent.getPatentType() + ",%' " +
            		"order by flowkey";
          //List<SelectItem> items = this.getDbUtil().getSelectItemList(sql, "MatterName");
            List<SelectItem> items = Util.findCasePatentMatterConfig(this.getDbUtil(), "STC01", 
            		patent.getPatentOffice(), patent.getPatentType());
            this.DocumentProcess.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.DocumentProcess.setSelectList(items);
            this.DocumentProcess.setOnChange("setValue()");
            */
            String contractorName = Cnstnts.EMPTY_STRING;
            if(!Util.isEmpty(this.getContractor())){
            	Employee contractorEmp = new Employee(this.getContractor());
            	if(contractorEmp != null && !Util.isEmpty(contractorEmp.getEmp_name())){
            		contractorName = contractorEmp.getEmp_name();
            	}
            }
            
            List<SelectItem> items = new Employee().getList();
            this.Contractor.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
            this.Contractor.setSelectList(items);
            this.Contractor.setAutocompleteLabelFieldId("contractorName");
            this.Contractor.setAfterText("<input type='text' readonly='true' name='contractorName' id='contractorName' size='10' value='"+contractorName+"'>");
            
            this.DocumentName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.DocumentName.setSize(50);
            this.DocumentName.setColspan(1);
//            this.DocumentName.setAnotherField(this.DocumentProcess);
            this.DocumentName.setAnotherField(this.Contractor);
            rtnString += this.printHtml(this.DocumentName);
            
            items = new Attorney().getList();
        	this.ContractorDept.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.ContractorDept.setSelectList(items);
            
            this.CcSendDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.CcSendType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CcSendType.setSelectList(new Category().getChildList(this.CcSendType));
        	this.CcSendType.setAnotherField(this.CcSendDate);
            this.CcSendType.setColspan(1);
            rtnString += this.printHtml(this.CcSendType);
                        
            this.Receiver.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.MailNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.MailNo.setAnotherField(this.Receiver);
            this.MailNo.setColspan(1);
            rtnString += this.printHtml(this.MailNo);
            
            
            this.Remark.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Remark.setCols(70);
            this.Remark.setRows(3);
            rtnString += this.printHtml(this.Remark);
            
            this.DocumentUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            this.DocumentUrl.setUploadFileDescription(this.AttachmentName.getTagName());
            
            this.AttachmentName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AttachmentName.setAnotherField(this.DocumentUrl);
            this.AttachmentName.setColspan(1);
            this.AttachmentName.setLength(200);
            this.AttachmentName.setSize(40);
            rtnString += this.printHtml(this.AttachmentName);
            
            rtnString += "<input type='hidden' id='changeDisplayHideFlag' name='changeDisplayHideFlag'/>";
            
            if(Util.isEmpty(this.getHideAttachmentFields()) && Util.isEmpty(this.getChangeDisplayHideFlag())){
            	this.HideAttachmentFields.setValue("Y");
            }
            
            if(!Util.compareTo(this.getHideAttachmentFields(), "Y")){
            	this.DocumentUrl2.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
                this.DocumentUrl2.setUploadFileDescription(this.AttachmentName2.getTagName());
                
                this.AttachmentName2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.AttachmentName2.setAnotherField(this.DocumentUrl2);
                this.AttachmentName2.setColspan(1);
                this.AttachmentName2.setLength(200);
                this.AttachmentName2.setSize(40);
                rtnString += this.printHtml(this.AttachmentName2);
                
                this.DocumentUrl3.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
                this.DocumentUrl3.setUploadFileDescription(this.AttachmentName3.getTagName());
                
                this.AttachmentName3.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.AttachmentName3.setAnotherField(this.DocumentUrl3);
                this.AttachmentName3.setColspan(1);
                this.AttachmentName3.setLength(200);
                this.AttachmentName3.setSize(40);
                rtnString += this.printHtml(this.AttachmentName3);
                
                this.DocumentUrl4.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
                this.DocumentUrl4.setUploadFileDescription(this.AttachmentName4.getTagName());
                
                this.AttachmentName4.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.AttachmentName4.setAnotherField(this.DocumentUrl4);
                this.AttachmentName4.setColspan(1);
                this.AttachmentName4.setLength(200);
                this.AttachmentName4.setSize(40);
                rtnString += this.printHtml(this.AttachmentName4);
                
                this.DocumentUrl5.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
                this.DocumentUrl5.setUploadFileDescription(this.AttachmentName5.getTagName());
                
                this.AttachmentName5.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.AttachmentName5.setAnotherField(this.DocumentUrl5);
                this.AttachmentName5.setColspan(1);
                this.AttachmentName5.setLength(200);
                this.AttachmentName5.setSize(40);
                rtnString += this.printHtml(this.AttachmentName5);
                
                this.DocumentUrl6.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
                this.DocumentUrl6.setUploadFileDescription(this.AttachmentName6.getTagName());
                
                this.AttachmentName6.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.AttachmentName6.setAnotherField(this.DocumentUrl6);
                this.AttachmentName6.setColspan(1);
                this.AttachmentName6.setLength(200);
                this.AttachmentName6.setSize(40);
                rtnString += this.printHtml(this.AttachmentName6);
                
                this.DocumentUrl7.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
                this.DocumentUrl7.setUploadFileDescription(this.AttachmentName7.getTagName());
                
                this.AttachmentName7.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.AttachmentName7.setAnotherField(this.DocumentUrl7);
                this.AttachmentName7.setColspan(1);
                this.AttachmentName7.setLength(200);
                this.AttachmentName7.setSize(40);
                rtnString += this.printHtml(this.AttachmentName7);
                
                this.DocumentUrl8.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
                this.DocumentUrl8.setUploadFileDescription(this.AttachmentName8.getTagName());
                
                this.AttachmentName8.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.AttachmentName8.setAnotherField(this.DocumentUrl8);
                this.AttachmentName8.setColspan(1);
                this.AttachmentName8.setLength(200);
                this.AttachmentName8.setSize(40);
                rtnString += this.printHtml(this.AttachmentName8);
            }else{
            	rtnString += this.DocumentUrl2.printHiddenTag();
            	rtnString += this.AttachmentName2.printHiddenTag();
            	rtnString += this.DocumentUrl3.printHiddenTag();
            	rtnString += this.AttachmentName3.printHiddenTag();
            	rtnString += this.DocumentUrl4.printHiddenTag();
            	rtnString += this.AttachmentName4.printHiddenTag();
            	rtnString += this.DocumentUrl5.printHiddenTag();
            	rtnString += this.AttachmentName5.printHiddenTag();
            	rtnString += this.DocumentUrl6.printHiddenTag();
            	rtnString += this.AttachmentName6.printHiddenTag();
            	rtnString += this.DocumentUrl7.printHiddenTag();
            	rtnString += this.AttachmentName7.printHiddenTag();
            	rtnString += this.DocumentUrl8.printHiddenTag();
            	rtnString += this.AttachmentName8.printHiddenTag();
            }
            
            this.HideAttachmentFields.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.HideAttachmentFields.setColspan(5);
            this.HideAttachmentFields.setOnClick("document.input.changeDisplayHideFlag.value=\"true\";setValue();");
            rtnString += this.printHtml(this.HideAttachmentFields);
            
            /*
            items = new Employee().getList();
            this.Contractor.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
            this.Contractor.setSelectList(items);
            this.Contractor.setAutocompleteLabelFieldId("contractorName");
            this.Contractor.setAfterText("<input type='text' readonly='true' name='contractorName' id='contractorName' size='8'>");
            
            this.IsAddToDos.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.IsAddToDos.setAnotherField(Contractor);
            this.IsAddToDos.setAfterText(this.getUserInfo().getMsg("jsp.LegalDocument.IsAddToDos")+ "");
            this.IsAddToDos.setColspan(1);
            rtnString += this.printHtml(this.IsAddToDos);
            */
            rtnString += this.IsAddToDos.printHiddenTag();
            
            
            
            
//            sql = "SELECT FlowKey, MatterName FROM patentmatterconfig " +
//            		"where casekind ='STC01' " +
//            		"and patentoffice like '%" + patent.getPatentOffice() + ",%' " +
//            		"and patenttype like '%" + patent.getPatentType() + ",%' " +
//            		"order by flowkey";
//            List<SelectItem> items = this.getDbUtil().getSelectItemList(sql, "MatterName");
//            this.DocumentProcess.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//            this.DocumentProcess.setSelectList(items);
//            this.DocumentProcess.setOnChange("setValue()");
            /*
            this.LinkOthers.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.LinkOthers.setOnClick("setValue()");
            this.LinkOthers.setAfterText(this.getUserInfo().getMsg("jsp.LegalDocument.LinkOthers")+ "");
//            this.LinkOthers.setAnotherField(this.DocumentProcess);
            this.LinkOthers.setColspan(3);
            rtnString += this.printHtml(this.LinkOthers);
            */
            rtnString += this.LinkOthers.printHiddenTag();

            /*
            this.MaintainLinkOthers.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.MaintainLinkOthers.setOnClick("setValue()");
            this.MaintainLinkOthers.setAfterText(this.getUserInfo().getMsg("jsp.LegalDocument.MaintainLinkOthers"));
            rtnString += this.printHtml(this.MaintainLinkOthers);
            */
            
            rtnString += this.MaintainLinkOthers.printHiddenTag();
            
            /*
            if(Util.compareTo(this.LinkOthers.getValue(), "Y") &&
          		  this.getDbActionMode().equals(Cnstnts.INSERT) &&
            		!Util.isEmpty(patent.getPatentType()) &&
            		!Util.isEmpty(patent.getPatentOffice())) {
            	sql = "SELECT StandardTask FROM ClientDocument WHERE FlowKey = '"
						+ this.FlowKey.getValue() + "' and flowkey != ''";

				HashMap attMap = new HashMap();
				attMap.put("StandardTask", "StandardTask");

				DbUtil dbUtil = new DbUtil();
				HashMap map = dbUtil.getDocMap(sql, attMap);
				if (map.get("${StandardTask}") != null
						&& !map.get("${StandardTask}").equals("")) {
					this.StandardTask.setValue(map.get("${StandardTask}") + "");
				}
        
	            String htmlString = "";
	            htmlString += "<tr bgcolor='#E9EDF4'><td width='17%' align='right' valign=top>"
	                        + getUserInfo().getMsg(
	                                    "jsp.ClientDocument.StandardTask")
	                        + "</td><td colspan='3'>" + Cnstnts.NEW_LINE;
	            
	            htmlString += "<table width='100%' border='1'>";
  	            htmlString += "<tr>";
  	            htmlString += "<td><input type='checkbox' name='all' id='all' onclick='checkAllCheckBox(this, \"configItem\");resetConfigItemValue2();'>" + this.getUserInfo().getMsg("jsp.StandardTask.TodosTitle") + "</td>";
  	            htmlString += "<td width='7%'>" + this.getUserInfo().getMsg("jsp.StandardTask.BaseDate") + "</td>";
  	            htmlString += "<td>" + this.getUserInfo().getMsg("jsp.ToDos.StartDate2") + "</td>";
  	            htmlString += "<td>" + this.getUserInfo().getMsg("jsp.StandardTask.RemindDate") + "</td>";
  	            htmlString += "<td>" + this.getUserInfo().getMsg("jsp.StandardTask.LegalDueDate1") + "</td>";
  	            htmlString += "<td>" + this.getUserInfo().getMsg("jsp.ToDos.AssignedTo") + "</td>";
  	            htmlString += "<td>" + this.getUserInfo().getMsg("jsp.StandardTask.AssignStatus") + "</td>";
//  	            htmlString += "<td width='7%'>" + this.getUserInfo().getMsg("jsp.StandardTask.IsCharge") + "</td>";
//  	            htmlString += "<td width='7%'>" + this.getUserInfo().getMsg("jsp.StandardTask.IsPayment") + "</td>";
//  	            htmlString += "<td>" + this.getUserInfo().getMsg("jsp.StandardTask.AccountTitle") + "</td>";
//  	            htmlString += "<td>" + this.getUserInfo().getMsg("jsp.StandardTask.Currency") + "</td>";
//  	            htmlString += "<td>" + this.getUserInfo().getMsg("jsp.StandardTask.Amount") + "</td>";
//  	            htmlString += "<td>" + this.getUserInfo().getMsg("jsp.StandardTask.TwdAmount") + "</td>";
  	            htmlString += "</tr>";
	            
	            String disabled = " disabled ";
	            if(canEdit()) {
	            	disabled = "  ";
	            }
	            

	            sql = "SELECT FlowKey  FROM standardtask s where s.MatterName = '" + 
	            			this.DocumentProcess.getValue() + "' " +
	            			"and s.PatentType like '%" + patent.getPatentType() + ",%' " +
	            			"and s.PatentOffice like '%" + patent.getPatentOffice() + ",%' " +
	            			"and s.IsPayment != 'Y' and s.IsCharge != 'Y' ";
	            List<String> list = this.getDbUtil().getValueList(sql, "FlowKey");
	            int i = 0;
	            
	            //System.out.println("====================== 蝟餃�憓� " + this.DocumentProcess.getValue() + "-" + 
//	            		patent.getPatentType() + "-" +
//	            		patent.getPatentOffice() +"-" +
//	            		list.size() + 
//	            		"  =================================");

	            Properties cateProp = new Category().getNamesPrpts();
	            for(String item : list) {
	            	if(!Util.isEmpty(item)) {
	            		StandardTask task = new StandardTask(item);
	            		task.setDbFields();
	            		//System.out.println(this.StandardTask.getValue() + " " +
//	            				task.getFlowKey() + "," + " " + 
//	            				this.StandardTask.getValue().indexOf(task.getFlowKey() + ","));
		            	htmlString += "<tr>";
			            htmlString += "<td>" + "<input type='checkbox' name='configItem' value='" + task.getFlowKey() + 
			            		"' onclick='resetConfigItemValue2();'" + 
			            		((this.StandardTask.getValue().indexOf(task.getFlowKey() + ",") != -1) ? "checked": "") + disabled + ">" + 
			            		task.getTodosTitle() + "<br>" + "</td>";
			            
			            htmlString += "<td>" + cateProp.getProperty(task.getBaseDate()) + "</td>";
			            
			            List<Object> result = Util.setToDosDate(task, patent, "P", this);
			            String baseDate = "";
			            ToDos todo = new ToDos();
			            if(result != null && result.size() == 2) {
			            	todo = (ToDos)result.get(0);
			            	baseDate = (String)result.get(1);
			            }
			            
			            task.BaseDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			            task.BaseDate.setName("BaseDate" + i);
			            task.BaseDate.setValue(baseDate);
			            task.BaseDate.setCanEdit(true);
			            htmlString += "<td>" + Html.printTag(task.BaseDate, this.getUserInfo()) + "</td>";
			            
			            task.RemindDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			            task.RemindDate.setName("RemindDate" + i);
			            task.RemindDate.setValue(todo.getAlertDate());
			            task.RemindDate.setCanEdit(true);
			            htmlString += "<td>" + Html.printTag(task.RemindDate, this.getUserInfo()) + "</td>";
			            
			            task.LegalDueDate1.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			            task.LegalDueDate1.setName("LegalDueDate1" + i);
			            task.LegalDueDate1.setValue(todo.getLegalDueDate());
			            task.LegalDueDate1.setCanEdit(true);
			            htmlString += "<td>" + Html.printTag(task.LegalDueDate1, this.getUserInfo()) + "</td>";
			            
			            items = new Employee().getList();
			            todo.AssignedTo.setHtmlType(Cnstnts.HTML_TAG_AUTOCOMPLETE);
			            todo.AssignedTo.setSelectList(items);
			            todo.AssignedTo.setNotShowCode(true);
			            todo.AssignedTo.setName("AssignedTo" + i);
			            todo.AssignedTo.setCanEdit(true);
			            todo.AssignedTo.setSize(10);
			            todo.AssignedTo.setAutocompleteLabelFieldId("assignedToName" + i);
			            todo.AssignedTo.setAfterText("<input type='text' readonly='true' name='assignedToName" + i + "' id='assignedToName" + i + "' size='8'>");
			            htmlString += "<td>" + Html.printTag(todo.AssignedTo, this.getUserInfo()) + "</td>";
			            
			            todo.AssignStatus.setValue(task.getAssignStatus());
			            todo.AssignStatus.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			            todo.AssignStatus.setName("AssignStatus" + i);
			            todo.AssignStatus.setSelectList(new Category().getChildList("AssignStatus"));
			            todo.AssignStatus.setCanEdit(true);
			            htmlString += "<td>" + Html.printTag(todo.AssignStatus, this.getUserInfo()) + "</td>";
			            
//			            task.IsPoints.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
//			            task.IsPoints.setName("IsPoints" + i);
//			            task.IsPoints.setCanEdit(true);
//			            htmlString += "<td>" + Html.printTag(task.IsPoints, this.getUserInfo()) + "</td>";
			            
//			            task.IsCharge.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
//			            task.IsCharge.setName("IsCharge" + i);
//			            task.IsCharge.setCanEdit(true);
//			            htmlString += "<td>" + Html.printTag(task.IsCharge, this.getUserInfo()) + "</td>";
//			            
//			            task.IsPayment.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
//			            task.IsPayment.setName("IsPayment" + i);
//			            task.IsPayment.setCanEdit(true);
//			            htmlString += "<td>" + Html.printTag(task.IsPayment, this.getUserInfo()) + "</td>";
//			            
//			            task.AccountTitle.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//			            task.AccountTitle.setSelectList(new Category().getChildList(task.AccountTitle, false));
//			            task.AccountTitle.setNotShowCode(true);
//			            task.AccountTitle.setName("AccountTitle" + i);
//			            task.AccountTitle.setCanEdit(true);
//			            htmlString += "<td>" + Html.printTag(task.AccountTitle, this.getUserInfo()) + "</td>";
//			            
//			            task.Currency.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
//			            task.Currency.setSelectList(new Category().getChildList(task.Currency, false));
//			            task.Currency.setName("Currency" + i);
//			            task.Currency.setCanEdit(true);
//			            htmlString += "<td>" + Html.printTag(task.Currency, this.getUserInfo()) + "</td>";
//			            
//			            task.Amount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//			            task.Amount.setName("Amount" + i);
//			            task.Amount.setSize(6);
//			            task.Amount.setCanEdit(true);
//			            htmlString += "<td>" + Html.printTag(task.Amount, this.getUserInfo()) + "</td>";
//			            
//			            task.TwdAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
//			            task.TwdAmount.setName("TwdAmount" + i);
//			            task.TwdAmount.setSize(6);
//			            task.TwdAmount.setCanEdit(true);
//			            htmlString += "<td>" + Html.printTag(task.TwdAmount, this.getUserInfo()) + "</td>";
			            
			            htmlString += "</tr>";
			            
//		                htmlString += "<input type='checkbox' name='configItem' value='"
//		                            + item.getKey()
//		                            + "' onclick='resetConfigItemValue();'"
//		                            + ((this.StandardTask.getValue().indexOf(
//		                                        item.getKey() + ",") != -1) ? "checked"
//		                                        : "") + disabled + ">" + item.getValue() + "<br>"
//		                            + Cnstnts.NEW_LINE;
		                i++;
	            	}
	            }
	            
	            if(!Util.compareTo(this.getInitFlag(), "true")) {
	  	        	  this.setInitFlag("true");
	  	          }

		            htmlString += "</table>";
		            htmlString += "<input type='hidden' name='rowIndex' id='rowIndex' value='" + i + "'>";
		            htmlString += "<input type='hidden' name='initFlag' id='initFlag' value='" + this.getInitFlag() + "'>";
		            
	            rtnString += htmlString;
        	}
            
            if(Util.compareTo(this.MaintainLinkOthers.getValue(), "Y")) {
	            rtnString += printDocumentTabHtml();
            }
            */
        }
        return rtnString + printFunctionBar2();
    }
    
    public String getDetailSubmitBtn(UserBean userInfo, String dbActionMode) throws Exception {
		String rtnString = "<input type='button' style='cursor: hand' " +
		   				   "value='" + userInfo.getMsg("jsp.common.submit2")+"' " +
		   				   "onClick='this.disabled=true;resetConfigItemValue2();resetFinishedValue();resetFinishedDateValue();setSubmitValue(\""+dbActionMode+"\")'/>";
		//嚙踝蕭嚙質��嚙踝蕭嚙賢���蕭嚙踝蕭蹓鳴"嚙踝嚙� 嚙賢音嚙踝蕭嚙�"嚙質嚙�"
		if(dbActionMode.equals(Cnstnts.DELETE)) {
			rtnString = "<input type='button' style='cursor: hand' " +
	   				   "value='" + userInfo.getMsg("jsp.common.submit3")+"' " +
	   				   "onClick='this.disabled=true;resetConfigItemValue2();resetFinishedValue();resetFinishedDateValue();setSubmitValue(\""+dbActionMode+"\")'/>";
		}
		return rtnString;
	}
    
    public String printFunctionBar() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		StringBuffer strBfr = new StringBuffer();
		strBfr.append(newLine + "<table id='functionBar' " + this.getTableBgcolor() + ">");
		strBfr.append(newLine + "<tr>");
		strBfr.append(newLine + "<td width='60%'>");
		strBfr.append(newLine + "<div class='logTitle'>");
		strBfr.append(newLine + this.getPageTitle());
		strBfr.append(newLine + "</div>");
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "<td align='right'>");
		
		if(!Util.isEmpty(this.getOutputFile2())) {
			strBfr.append(newLine + "<input type='button' value='" + 
					this.getUserInfo().getMsg("jsp.common.openPrintFile") + 
					"' onClick='printPdf(\""+this.getOutputFile2()+"\")'>");
		}
		if(!this.getDbActionMode().equals(Cnstnts.QUERY)){
			if(this.getLinkMode().trim().length()==0){
//				String cancelBtn = "<input type='button' onClick='parent.resetFrame(\"PatentToDos\");parent.closeTabFrame(\"updateClientDocumentDiv" +"\",\"ClientDocumentDiv\")' value='"+
				String cancelBtn = "<input type='button' onClick='parent.closeTabFrame(\"updateClientDocumentDiv" +"\",\"ClientDocumentDiv\")' value='"+
				this.getUserInfo().getMsg("jsp.closeForm.cancel")+"'>";
				strBfr.append(cancelBtn);
			}	
			strBfr.append(this.getDetailSubmitBtn(this.getUserInfo(), this.getDbActionMode()));
		}
		strBfr.append(this.getDbActionSelectItem());
		if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
			String addBtn = "<input type='button' onClick='resetConfigItemValue2();this.disabled=true;document.input.insertAddFlag.value=\"true\";setSubmitValue(\"InsertAdd\")' value='"+
					this.getUserInfo().getMsg("jsp.common.SubmitAndInsert")+"'>";
			strBfr.append(addBtn);
		}
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "</tr>");
		strBfr.append(newLine + "</table>");
		return strBfr.toString();
	}
    
    public String printFunctionBar2() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		StringBuffer strBfr = new StringBuffer();
		strBfr.append(newLine + "<table id='functionBar' " + this.getTableBgcolor() + ">");
		strBfr.append(newLine + "<tr>");
		strBfr.append(newLine + "<td width='60%'>");
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "<td align='right'>");
		
		if(!Util.isEmpty(this.getOutputFile2())) {
			strBfr.append(newLine + "<input type='button' value='" + 
					this.getUserInfo().getMsg("jsp.common.openPrintFile") + 
					"' onClick='printPdf(\""+this.getOutputFile2()+"\")'>");
		}
		if(!this.getDbActionMode().equals(Cnstnts.QUERY)){
			if(this.getLinkMode().trim().length()==0){
//				String cancelBtn = "<input type='button' onClick='parent.resetFrame(\"PatentToDos\");parent.closeTabFrame(\"updateClientDocumentDiv" +"\",\"ClientDocumentDiv\")' value='"+
				String cancelBtn = "<input type='button' onClick='parent.closeTabFrame(\"updateClientDocumentDiv" +"\",\"ClientDocumentDiv\")' value='"+
				this.getUserInfo().getMsg("jsp.closeForm.cancel")+"'>";
				strBfr.append(cancelBtn);
			}	
			strBfr.append(this.getDetailSubmitBtn(this.getUserInfo(), this.getDbActionMode()));
		}
		strBfr.append(this.getDbActionSelectItem());
		if(this.getDbActionMode().equals(Cnstnts.INSERT)) {
			String addBtn = "<input type='button' onClick='resetConfigItemValue2();this.disabled=true;document.input.insertAddFlag.value=\"true\";setSubmitValue(\"InsertAdd\")' value='"+
					this.getUserInfo().getMsg("jsp.common.SubmitAndInsert")+"'>";
			strBfr.append(addBtn);
		}
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "</tr>");
		strBfr.append(newLine + "</table>");
		return strBfr.toString();
	}

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            ClientDocument preObj = (ClientDocument) userInfo.getObj(this.getTableName());
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
    
    public String printDocumentTabHtml() throws Exception {
		String rtnString = "";
		String TabSelect = Cnstnts.EMPTY_STRING;
		rtnString += "<script type='text/javascript'>$(function(){$('#tabs').tabs("
				+ TabSelect + ");});</script>";

		// tab area
		rtnString += "<tr><td colspan=4>" + "<div id='tabs'><ul>"
				+ "<li><a href='#tabs-1'>"
				+ this.getUserInfo().getMsg("jsp.ClientDocument.TabTitle1")
				+ "</a></li>";
		rtnString += "</ul>";

		/******* tab-1 *******/
		/*
		 * 嚙踐��蕭謕蕭嚙踐�蕭嚙賢�蕭�豲嚙踐��蕭謕蕭嚙質�蕭謕蕭嚙賢�蕭��嚙賡豲嚙踐�蕭嚙賣葡�嚙踐�蕭嚙質�嚙踐�蕭嚙踐�蕭嚙賢��蕭謕蕭嚙質�蕭謕滲嚙踐�蕭嚙踐�蕭嚙質�塚蕭謕蕭嚙質�� 嚙踐�蕭嚙踐�嚙踐�蕭嚙賢�蕭�謘餉麾���蕭嚙賢�蕭�豲嚙踐�蕭嚙賢�蕭�豲嚙踐�蕭嚙賢�蕭�豲嚙踐��蕭��蕭嚙踐�蕭��嚙賡�嚙踝蕭謕嚙踐�蕭嚙踐�蕭嚙賢�蕭�豲嚙踐�
		 * 嚙踐�蕭嚙賢��蕭��嚙踝�蕭�豲嚙踐�蕭嚙賢�蕭��瑣eckbox嚙踐�蕭嚙踐�蕭嚙賢��蕭謕���蕭�豲嚙踐�蕭嚙賢�蕭�豲嚙踐��蕭��嚙踐�蕭嚙賢�蕭�豲嚙踐�蕭嚙踐��蕭謕蕭嚙賢�蕭�豲嚙踐�蕭嚙踝蕭嚙踐�蕭嚙質�eckbox嚙踐�蕭嚙踐�蕭嚙踐�蕭嚙賢�蕭�豲嚙踐�蕭嚙賣腹蹌哨蕭撖∵嚙踐�蕭嚙賢�蕭�豲嚙踐�蕭嚙踐�蕭
		 */
		rtnString += "<div id='tabs-1'>";
		rtnString += "<div class='indent'>";
		rtnString += "<table width=90% border=0><tr><td valign=top>";
		rtnString += "<div id='updateDraftInventorDiv' name='updateDraftInventorDiv'></div>";
		rtnString += "<div id='DraftInventorDiv' name='DraftInventorDiv'>";
		
		String sql = "SELECT t.*, (select c.MatterName from PatentMatterConfig c where t.Matter=c.FlowKey) as Names ," +
				" (select e.Emp_name from  Employee e where t.AssignedTo=e.FlowKey) as Emp_name, " +
				" (select a.Firm from  attorney a where t.Agent=a.FlowKey) as AgentName " +
				" FROM todos t WHERE "
				+ " (t.Finished is null or t.Finished != 'Y') and t.ParentId ='"
				+ this.ParentId.getValue() + "'";

		PatentToDos todos = new PatentToDos();
		todos.setUserInfo(this.getUserInfo());
		todos.setDbFields();
		List<Field> fieldList = todos.getDbFields();
		fieldList.add(new Field("Names"));
		fieldList.add(new Field("Emp_name"));
		fieldList.add(new Field("AgentName"));
		List<List<Field>> findList = this.getDbUtil().getFieldsList(sql, fieldList);
		rtnString += printToDosTable(findList);

		rtnString += "</div></td></tr></table>";

		rtnString += "</div>";
		rtnString += "</div>";
		/******* tab-1-end *******/

		return rtnString;
	}
    
    private String printToDosTable(List<List<Field>> findList) throws Exception {
    	char newLine = Cnstnts.NEW_LINE;
    	StringBuffer strBfr = new StringBuffer();

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.Matter")+"</td>";
		String thText3="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.ToDos.TaskDescription")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.AssignedTo")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.InternalDueDate")+"</td>";
		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.LegalDueDate")+"</td>";
		String thText7="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.StartDate2")+"</td>";
		String thText8="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.Agent")+"</td>";
		String thText9="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.Finish")+"</td>";
		String thText10="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ToDos.FinishedDate")+"</td>";

		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText2+thText3+
									thText4+thText5+thText6+thText7+thText8+thText9+thText10+"</tr>");

		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String Names = Cnstnts.EMPTY_STRING;
			String TaskDescription = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String Emp_name = Cnstnts.EMPTY_STRING;
			String InternalDueDate = Cnstnts.EMPTY_STRING;
			String LegalDueDate = Cnstnts.EMPTY_STRING;
			String StartDate2=Cnstnts.EMPTY_STRING;
			String FinishedDate = Cnstnts.EMPTY_STRING;
			String Appendix = Cnstnts.EMPTY_STRING;
			String AgentName = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("Names")){
					Names = field.getValue();
				}
				if(field.getName().equals("TaskDescription")){
					TaskDescription = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Emp_name")){
					Emp_name = field.getValue();
				}
				if(field.getName().equals("InternalDueDate")){
					InternalDueDate = field.getValue();
				}
				if(field.getName().equals("LegalDueDate")){
					LegalDueDate = field.getValue();
				}
				if(field.getName().equals("StartDate2")){
					StartDate2=field.getValue();
				}
				if(field.getName().equals("FinishedDate")){
					FinishedDate = field.getValue();
				}
				if(field.getName().equals("AgentName")){
					AgentName = field.getValue();
				}
			}
			String onClick = " onClick='openAppendix(\"PatentToDos.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=query&getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,400)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'>"+Names+"</td>";
			String tdText3="<td"+onClick+">"+TaskDescription+"</td>";
			String tdText4="<td align='center'>"+Emp_name+"</td>";
			String tdText5="<td align='center'>"+InternalDueDate+"</td>";
			String tdText6="<td align='center'>"+LegalDueDate+"</td>";
			String tdText7="<td align='center'>"+FinishedDate+"</td>";
			String tdText8="<td align='center'>"+AgentName+"</td>";
			String tdText9=Cnstnts.EMPTY_STRING;
			tdText9 = "<td align='center'><input type=\"checkbox\" id=\"finished\" name=\"finished\" onclick=\"checkFinishDate(this, " + i + ");resetFinishedValue();resetFinishedDateValue();\" value=\"" + FlowKey + "\"></td>";
			
			String date = "<input type=\"text\" onchange=\"checkFinishedDate(this,"+i+");\" size=\"10\" value=\"\" name=\"finishedDate" + i + "\" id=\"finishedDate" + i + "\">" +
					"<img onclick=\"openCalendar('finishedDate" + i + "');\" src=\"img/calendar.gif\">";
			String tdText10 = "<td align='center'>" + date + "</td>";
			
			printValue = tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8+tdText9+tdText10;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		
		return strBfr.toString();
    }
    
    protected String getSearchReasult(UserBean userInfo,String parentId) throws Exception {
    	this.setDoSearchFlag(Cnstnts.TRUE_FLAG);
		this.setPageActionMode(Cnstnts.SEARCH);
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasult();
    }
    
    public boolean insert() throws Exception {
    	Date date = new Date();
    	
        List<String> sqlList = new ArrayList<String>();
        this.setDbFields();

        sqlList.add(this.getDbUtil()
                    .getInsertSQL(getTableName(), this.DbFields));
        
        //System.out.println("== doc 1 " + (new Date().getTime() - date.getTime()));
        date = new Date();

        String sql = "UPDATE ClientDocument  SET StandardTask = '"
                    + this.getConfigItemData()
                    + "' where FlowKey = '"
                    + this.FlowKey.getValue() + "';";
        sqlList.add(sql);

        
        //System.out.println("== doc 2 " + (new Date().getTime() - date.getTime()));
        date = new Date();

    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String today = sdf.format(new Date());
        
        String[] todosFlowkey = this.getFinishedItemData().split(",");
        for(String s : todosFlowkey) {
        	sql = "UPDATE todos  SET Finished = 'Y' , FinishedDate ='"+ today +"' where FlowKey = '"
                + s + "';";
        	sqlList.add(sql);
        }

        
        //System.out.println("== doc 3 " + (new Date().getTime() - date.getTime()));
        date = new Date();

//        PatentCase parentObj = (PatentCase)this.getUserInfo().getObj("PatentCase");
        /*
        List<ToDos> insertTodos = new ArrayList<ToDos>();
        
        if(!Util.isEmpty(this.getIsAddToDos()) &&
        		this.getIsAddToDos().equalsIgnoreCase("Y")) {
        	ToDos todos = new ToDos();
	        todos.init();
	        todos.setDbFields();
	        todos.setDbActionMode(Cnstnts.INSERT);
	        todos.setUserInfo(this.getUserInfo());
	        todos.setCaseType(parentObj.getCaseKind());
	        todos.setProgramId2("jsp.PatentToDos");
	        
	        //System.out.println("== doc 4 " + (new Date().getTime() - date.getTime()));
	        date = new Date();


	        todos.setParentId(this.getParentId());
	        todos.setApplicant(this.getApplicant());
	        todos.setCreateDept(this.getCreateDept());
	        todos.setTaskCreator(this.getApplicant());
	        todos.setAssignedTo(this.getContractor());
	        todos.setTaskDescription(this.getDocumentName());
	        todos.setMatter(this.getDocumentProcess());
	        todos.setLegalDueDate(this.getDeadlineDate());
	        todos.setMemo(this.getRemark());
	        todos.setAgent(this.getContractorDept());
	        todos.setFlowKey(FlowEngin.getPkeyNo(this.getParentId(), 3, false, "."));
			todos.setCaseNo(parentObj.getCaseNo());
			todos.setCaseNo2(parentObj.getCaseNo2());
			todos.setClient(parentObj.getClient());
			todos.setStatus(parentObj.getStatus());
			todos.setOffice(parentObj.getPatentOffice());
			todos.setCaseType(parentObj.getCaseKind());
			todos.setPatentType(parentObj.getPatentType());
			todos.setInternalNo(parentObj.getInternalNo());
	        
	        //System.out.println("== doc 5 " + (new Date().getTime() - date.getTime()));
	        date = new Date();

	        
	        if(Util.isEmpty(this.getContractor())) {
	        	todos.setToDosStatus("TDS00");
	        }
	        else {
	        	todos.setToDosStatus("TDS01");
	        }
//	        String todoSql = this.getDbUtil().getInsertSQL(todos.getTableName(), todos.getDbFields());
//	        sqlList.add(todoSql);
	        insertTodos.add(todos);
	        
	        //System.out.println("== doc 6 " + (new Date().getTime() - date.getTime()));
	        date = new Date();

        }
        */
        
        int number = 6;
        String[] standardTasks = this.getConfigItemData().split(";");
        /*
        for(String standardTask : standardTasks) {
            
            //System.out.println("== doc 7 " + (new Date().getTime() - date.getTime()));
            date = new Date();

        	if(Util.isEmpty(standardTask)) {
        		continue;
        	}
        	String[] taskValues = new String[number];
        	for(int i=0;i<number;i++) {
        		taskValues[i] = "";
        	}
        	System.arraycopy(standardTask.split(","), 0, taskValues, 0, standardTask.split(",").length);

            
            //System.out.println("== doc 8 " + (new Date().getTime() - date.getTime()));
            date = new Date();

        	if(taskValues.length != number) {
        		break;
        	}
        	
        	StandardTask task = new StandardTask(taskValues[0]);
            
            //System.out.println("== doc 9 " + (new Date().getTime() - date.getTime()));
            date = new Date();

        	
        	String baseDate = taskValues[1];
        	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	GregorianCalendar calendar = new GregorianCalendar();
        	String legalDueDate = "";
        	String alertDate = taskValues[2];
        	
        	legalDueDate = taskValues[3];
//        	alertDate = Util.getRemainDate(legalDueDate, task);

            
            //System.out.println("== doc 10 " + (new Date().getTime() - date.getTime()));
            date = new Date();

        	
        	 * 2013/1/8
        	 
        	ToDos todos = new ToDos();
	        todos.init();
	        todos.setDbFields();
	        todos.setDbActionMode(Cnstnts.INSERT);
	        todos.setUserInfo(this.getUserInfo());
	        todos.setCaseType(parentObj.getCaseKind());
	        todos.setProgramId2("jsp.PatentToDos");
	        
	        //System.out.println("== doc 11 " + (new Date().getTime() - date.getTime()));
	        date = new Date();


	        todos.setParentId(this.getParentId());
	        todos.setApplicant(this.getApplicant());
	        todos.setCreateDept(this.getCreateDept());
	        todos.setTaskCreator(this.getApplicant());
	        todos.setAssignedTo(this.getContractor());
	        todos.setAgent(this.getContractorDept());
	        todos.setMatter(this.getDocumentProcess());
	        todos.setMemo(this.getRemark());
	        todos.setTaskDescription(task.getTodosTitle());
	        todos.setFlowKey(FlowEngin.getPkeyNo(this.getParentId(), 3, false, "."));
	        todos.setStartDate2(baseDate);
	        todos.setLegalDueDate(legalDueDate);
	        todos.setAttorneyDueDate(alertDate);
	        todos.setAlertDate(alertDate);
			todos.setCaseNo(parentObj.getCaseNo());
			todos.setCaseNo2(parentObj.getCaseNo2());
			todos.setClient(parentObj.getClient());
			todos.setStatus(parentObj.getStatus());
			todos.setOffice(parentObj.getPatentOffice());
			todos.setCaseType(parentObj.getCaseKind());
			todos.setPatentType(parentObj.getPatentType());
			todos.setInternalNo(parentObj.getInternalNo());
	        
	        //System.out.println("== doc 12 " + (new Date().getTime() - date.getTime()));
	        date = new Date();

	        
	        todos.setAssignStatus(taskValues[5]);
//	        todos.setIsPoints(taskValues[5]);
//	        todos.setIsCharge(taskValues[6]);
//	        todos.setIsPayment(taskValues[7]);
//	        todos.setCurrency(taskValues[8]);
	        todos.setRequestPayAmount("0");
	        todos.setPayAmount("0");
//	        if(taskValues[6].equalsIgnoreCase("Y")){
//	        	todos.setNotYetRequestPayAmount(taskValues[11]);
//	        }else{
	        	todos.setNotYetRequestPayAmount("0");
//	        }
//	        if(taskValues[7].equalsIgnoreCase("Y")){
//	        	todos.setNotYetPayAmount(taskValues[11]);
//	        }else{
	        	todos.setNotYetPayAmount("0");
//	        }
//	        todos.setAmount(taskValues[10]);
//	        todos.setTwdAmount(taskValues[11]);
//	        Category rateCategory = new Category(taskValues[9]);
//	        String rate = rateCategory.getRate();
//	        todos.setExchangeRate(rate);
	        todos.setPoints(task.getPoints());
//	        todos.setAccountTitle(taskValues[8]);
	        todos.setByThePiece("Y");
	        if(!Util.isEmpty(taskValues[4])) {
	        	todos.setAssignedTo(taskValues[4]);
	        	todos.setToDosStatus("TDS01");
	        }
	        else {
	        	todos.setToDosStatus("TDS00");
	        }
	        
	        //System.out.println("== doc 13 " + (new Date().getTime() - date.getTime()));
	        date = new Date();

	        
//	        sql = this.getDbUtil().getInsertSQL(todos.getTableName(), todos.getDbFields());
//	        //System.out.println(sql);
//	        
//	        sqlList.add(sql);
	        
	        insertTodos.add(todos);
	        
	        //System.out.println("== doc 14 " + (new Date().getTime() - date.getTime()));
	        date = new Date();

        }
        */

        boolean result = this.getDbUtil().executeUpdate(sqlList);
        
        //System.out.println("== doc 15 " + (new Date().getTime() - date.getTime()));
        date = new Date();

		if(result) {
			/*
			for(ToDos todos :insertTodos) {
				boolean ok = todos.insert2(todos.getCaseNo());
			}
	        */
	        //System.out.println("== doc 16 " + (new Date().getTime() - date.getTime()));
	        date = new Date();

			
			sqlList = new ArrayList<String>();
			
			if(!Util.isEmpty(this.getProgramId2())) {
				if (new Program(this.getProgramId2()).getLogInsert().equals("1")) {
					sqlList.add(this.getLogSQL(null));
					
					result =  this.getDbUtil().executeUpdate(sqlList);
				}
		        
		        //System.out.println("== doc 17 " + (new Date().getTime() - date.getTime()));
		        date = new Date();

			}
			else {
				Program program = new Program(this.getProgramId());
				if (program != null && program.getLogInsert().equals("1")) {
					sqlList.add(this.getLogSQL(null));
					
					result =  this.getDbUtil().executeUpdate(sqlList);
				}
		        
		        //System.out.println("== doc 18 " + (new Date().getTime() - date.getTime()));
		        date = new Date();

			}
			
			result =  true;
		}
        //��獢辣鞈��
//        parentObj.updateToDosValue(parentObj);
        
        //System.out.println("== doc 19 " + (new Date().getTime() - date.getTime()));
        date = new Date();

            
//        return this.getDbUtil().executeUpdate(getLastScheduleSql());
        return result;
    }

    public boolean update() throws Exception {
    	List<String> sqlList = new ArrayList<String>();
        this.setDbFields();

        sqlList.add(this.getDbUtil()
                    .getUpdateSQL(getTableName(), this.DbFields));

        String sql = "UPDATE ClientDocument  SET StandardTask = '"
                    + this.getConfigItemData()
                    + "' where FlowKey = '"
                    + this.FlowKey.getValue() + "';";
        sqlList.add(sql);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String today = sdf.format(new Date());
        
    	int index = 0;
    	if(this.getFinishedItemData() != null &&
    			this.getFinishedDateData() != null) {
	        String[] todosFlowkey = this.getFinishedItemData().split(",");
	        String[] todosDate = this.getFinishedDateData().split(",");
	        for(String s : todosFlowkey) {
	        	sql = "UPDATE todos  SET Finished = 'Y' , FinishedDate ='"+ todosDate[index] +"', toDosStatus='TDS02' where FlowKey = '"
	                + s + "';";
	        	sqlList.add(sql);
	        	
	        	index++;
	        }
    	}
		if (new Program(this.getProgramId()).getLogUpdate().equals("1")) {
			HashMap beforeMap = this.getAttributesMap(this.FlowKey);
			if (beforeMap != null) {
				sqlList.add(this.getLogSQL(beforeMap));
			}
		}
		
		/*
        if(this.getDbUtil().executeUpdate(sqlList)) {
        	return this.getDbUtil().executeUpdate(getLastScheduleSql());
        }
        */
		
//        return false;
        return this.getDbUtil().executeUpdate(sqlList);
    }
    /*
    public boolean delete() throws Exception {
    	if(super.delete()) {
    		return this.getDbUtil().executeUpdate(getLastScheduleSql());
    	}
    	
    	return false;
    }
    */
    public String getLastScheduleSql() throws Exception {
    	String LastSchedule = "";
		
    	if(!Util.isEmpty(this.getParentId())) {
			String sql = "select FlowKey from ClientDocument where parentid='" + this.getParentId() +
					"' and (DocumentDate is not null and DocumentDate != '') order by DocumentDate desc,FlowKey desc";
	
	
			List<String> keys = this.getDbUtil().getValueList(sql, "FlowKey");
			if(!keys.isEmpty()) {
				Properties categoryProp = new Category().getNamesPrpts();
				
				ClientDocument doc = new ClientDocument(keys.get(0));
				
				String documentTarget = "";
				if(Util.compareTo(doc.getDocumentUnit(), "DU01")) {
					documentTarget = categoryProp.getProperty(doc.getDocumentTarget());
				}
				else if(Util.compareTo(doc.getDocumentUnit(), "DU02")) {
					documentTarget = new Attorney().getNamesPrpts().getProperty(doc.getDocumentTarget());
				}
				else if(Util.compareTo(doc.getDocumentUnit(), "DU03")) {
					documentTarget = new Client().getNamesPrpts().getProperty(doc.getDocumentTarget());
				}
				else if(Util.compareTo(doc.getDocumentUnit(), "DU04")) {
					documentTarget = new Employee().getNamesPrpts().getProperty(doc.getDocumentTarget());
				}
				
				LastSchedule = doc.getDocumentDate() + " " + categoryProp.getProperty(doc.getDocumentKind()) + " " +
							documentTarget + " " + 
							categoryProp.getProperty(doc.getDocumentType()) + " " +
							doc.getDocumentName();
			}
    	}
		this.getUserInfo().setAttribute("LastSchedule", LastSchedule);
		
		return "update patentcase set LastSchedule='" + LastSchedule + "' where flowkey ='" + this.getParentId()+"'";
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasult() throws Exception {
		if (this.onBtnSearch()) {
			this.setSearchResult(this.getSearchList());
		}

		StringBuffer strBfr = new StringBuffer();
		
		boolean canAssesFlag = false;
		Client parentObj = (Client)this.getUserInfo().getObj("Client");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE) 
				/*&& parentObj.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))*/){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;
		
		
		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='7%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentDate")+"</td>";
		String thText3="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentTarget")+"</td>";
		String thText4="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentKind")+"</td>";
		String thText5="<td align='center' width='24%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentName")+"</td>";
//		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentDate")+"</td>";
		String thText7="<td align='center' width='7%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DeadlineDate")+"</td>";
//		String thText8="<td align='center' width='7%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.AccountingType")+"</td>";
//		String thText9="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.Contractor")+"</td>";
//		String thText10="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentProcess")+"</td>";
		String thText11="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentUrl")+"</td>";
		String thText12=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(\"" + this.getTableName()+"\",\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateClientDocumentDiv" +
										 "\",\"ClientDocumentDiv\""+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText12 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+
								thText1+thText2+thText4+thText3+thText5+
								/*thText6+*/thText7+/*thText8+thText9+thText10+*/thText11+thText12+"</tr>");
		
		Properties matterPrpt = new PatentMatterConfig().getNamesPrpts();
		Properties categoryPrpt = new Category().getNamesPrpts();
		Properties attorneyPrpt = new Attorney().getNamesPrpts();
		Properties clientPrpt = new Client().getNamesPrpts();
		Properties employeePrpt = new Employee().getNamesPrpts();
		String SQL = "select a.*, (select MatterName from patentmatterconfig p where p.flowkey=a.DocumentProcess) MatterName from "+this.getTableName()+" a where ParentId='"+this.getParentId()+"' order by DocumentDate desc";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		fieldList.add(new Field("MatterName"));
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String FlowKey = Cnstnts.EMPTY_STRING;
			String DocumentType = Cnstnts.EMPTY_STRING;
			String DocumentUrl = Cnstnts.EMPTY_STRING;
			String DocumentName = Cnstnts.EMPTY_STRING;
			String DocumentNo = Cnstnts.EMPTY_STRING;
			String DocumentDate = Cnstnts.EMPTY_STRING;
			String DocumentKind = Cnstnts.EMPTY_STRING;
			String DocumentTarget = Cnstnts.EMPTY_STRING;
			String DeadlineDate = Cnstnts.EMPTY_STRING;
			String Currency = Cnstnts.EMPTY_STRING;
			String Amount = Cnstnts.EMPTY_STRING;
			String Subject = Cnstnts.EMPTY_STRING;
			String AccountingType = Cnstnts.EMPTY_STRING;
			String MatterName = Cnstnts.EMPTY_STRING;
			String ServiceFee = Cnstnts.EMPTY_STRING;
			String ArFee = Cnstnts.EMPTY_STRING;
			String ApFee = Cnstnts.EMPTY_STRING;
			String ServiceFeeCurrency = Cnstnts.EMPTY_STRING;
			String ArFeeCurrency = Cnstnts.EMPTY_STRING;
			String ApFeeCurrency = Cnstnts.EMPTY_STRING;
			String Contractor = Cnstnts.EMPTY_STRING;
			String DocumentProcess = Cnstnts.EMPTY_STRING;
			String DocumentUnit = "";
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("DocumentType")){
					DocumentType = field.getValue();
				}
				if(field.getName().equals("DocumentUrl")){
					if (! field.getValue().equals("")){
						DocumentUrl = "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
										  "onClick='openAppendix(\""+field.getValue()+"\",\"DocumentUrl\",600,400)'>";
					}
				}
				if(field.getName().equals("DocumentUnit")){
					DocumentUnit = field.getValue();
				}
				if(field.getName().equals("Contractor")){
					Contractor = field.getValue();
				}
				if(field.getName().equals("DocumentProcess")){
					DocumentProcess = field.getValue();
				}
				if(field.getName().equals("DocumentName")){
					DocumentName = field.getValue();
				}
				if(field.getName().equals("DocumentNo")){
					DocumentNo = field.getValue();
				}
				if(field.getName().equals("DocumentDate")){
					DocumentDate = field.getValue();
				}
				if(field.getName().equals("DocumentKind")){
					DocumentKind = field.getValue();
				}
				if(field.getName().equals("DocumentTarget")){
					DocumentTarget = field.getValue();
				}
				if(field.getName().equals("MatterName")){
					MatterName = field.getValue();
				}
				if(field.getName().equals("Currency")){
					Currency = field.getValue();
				}
				if(field.getName().equals("Amount")){
					Amount = field.getValue();
				}
				if(field.getName().equals("Subject")){
					Subject = field.getValue();
				}
				if(field.getName().equals("AccountingType")){
					AccountingType = field.getValue();
				}
				if(field.getName().equals("DeadlineDate")){
					DeadlineDate = field.getValue();
				}
				if(field.getName().equals("ServiceFee")){
					ServiceFee = field.getValue();
				}
				if(field.getName().equals("ArFee")){
					ArFee = field.getValue();
				}
				if(field.getName().equals("ApFee")){
					ApFee = field.getValue();
				}
				if(field.getName().equals("ServiceFeeCurrency")){
					ServiceFeeCurrency = categoryPrpt.getProperty(field.getValue());
				}
				if(field.getName().equals("ArFeeCurrency")){
					ArFeeCurrency = categoryPrpt.getProperty(field.getValue());
				}
				if(field.getName().equals("ApFeeCurrency")){
					ApFeeCurrency = categoryPrpt.getProperty(field.getValue());
				}
			}
			String onClick = " style='cursor: hand' onClick='openAppendix(\"DocumentManage.jsp?_flowKey=" + 
						FlowKey + "&_pageActionMode=maintain&_dbActionMode=query&_getDataFlag=true\",\"DocumentManage\",800,600)' ";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td" + onClick + ">"+DocumentDate+"</td>";
			String tdText3="<td" + onClick + ">"+DocumentTarget+"</td>";
			if(Util.compareTo(DocumentUnit, "DU01")) {
				tdText3="<td" + onClick + ">"+categoryPrpt.getProperty(DocumentTarget)+"</td>";
			}
			else if(Util.compareTo(DocumentUnit, "DU02")) {
				tdText3="<td" + onClick + ">"+attorneyPrpt.getProperty(DocumentTarget)+"</td>";
			}
			else if(Util.compareTo(DocumentUnit, "DU03")) {
				tdText3="<td" + onClick + ">"+clientPrpt.getProperty(DocumentTarget)+"</td>";
			}
			else if(Util.compareTo(DocumentUnit, "DU04")) {
				tdText3="<td" + onClick + ">"+employeePrpt.getProperty(DocumentTarget)+"</td>";
			}
			String tdText4="<td" + onClick + ">"+categoryPrpt.getProperty(DocumentKind) +"</td>";
			String tdText5="<td" + onClick + ">"+DocumentName+"</td>";
//			String tdText6="<td" + onClick + ">"+DocumentDate+"</td>";
			String tdText7="<td" + onClick + "><font color=red>"+DeadlineDate+"</font></td>";
//			String tdText8="<td" + onClick + ">"+categoryPrpt.getProperty(AccountingType) +"</td>";
//			String tdText9="<td" + onClick + ">"+employeePrpt.getProperty(Contractor)+"</td>";
//			String tdText10="<td" + onClick + ">"+MatterName+"</td>";
			String tdText11="<td" + ">"+DocumentUrl+"</td>";
			String tdText12=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(\"" + this.getTableName()+"\",\"update\",\""+
								 		FlowKey+"\","+this.FRAME_HEIGHT+",\"updateClientDocumentDiv" +
										 "\",\"ClientDocumentDiv\""+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(\"" + this.getTableName()+"\",\"delete\",\""+
				 						FlowKey+"\","+this.FRAME_HEIGHT+",\"updateClientDocumentDiv" +
										 "\",\"ClientDocumentDiv\""+")'/>";
				tdText12 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText4+tdText3+tdText5+/*tdText6+*/tdText7+/*tdText8+tdText10+*/tdText11+tdText12;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+" >"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
    
    public boolean checkInsertError() throws Exception {
        if(super.checkInsertError()){
            return true;
        } else {
        	if(Cnstnts.INSERT.equals(this.getDbActionMode()) 
        			&& this.getCreateTime().trim().length()==0){
        		this.setCreateTime(Util.getDate());
        	}
        	//嚙踐��蕭謕嚙賭�蕭�豲嚙踐�蕭嚙賢�蕭�豲蕭嚙賢�蕭�豲嚙踐�蕭嚙踐�蕭嚙踐�蕭嚙質�蕭謕�蕭謕蕭嚙賢�蕭�豲J嚙踐�蕭嚙賢�蕭�豲嚙踐�蕭嚙賢�蕭��蕭
        	if(!Util.isEmpty(this.getFinishedItemData()) &&
        			!Util.isEmpty(this.getFinishedDateData())) {
        		//System.out.println(this.getFinishedItemData() + " " + this.getFinishedDateData());
	        	String[] todosFlowkey = this.getFinishedItemData().split(",");
	            String[] todosDate = this.getFinishedDateData().split(",");
	            if(todosFlowkey.length != todosDate.length) {
	            		setErrorMessage(this.getUserInfo().getMsg("jsp.ToDos.FinishDateEmptyError"));
	            		return true;
	            }
        	}
        	
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

    protected String getSearchReasultInternal(UserBean userInfo,String parentId) throws Exception {
    	this.setDoSearchFlag(Cnstnts.TRUE_FLAG);
		this.setPageActionMode(Cnstnts.SEARCH);
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasultInternal();
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasultInternal() throws Exception {
		if (this.onBtnSearch()) {
			this.setSearchResult(this.getSearchList());
		}

		StringBuffer strBfr = new StringBuffer();
		if (this.getShowField() == null || this.getShowField().length == 0
				|| this.getSearchResult() == null) {
			return strBfr.toString();
		}
		
		boolean canAssesFlag = false;
		PatentCaseInternal parentObj = (PatentCaseInternal)this.getUserInfo().getObj("PatentCaseInternal");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE) 
				&& parentObj.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentType")+"</td>";
		String thText3="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentName")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentNo")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentDate")+"</td>";
		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentKind")+"</td>";
		String thText7="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentTarget")+"</td>";
		String thText8="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentProcess")+"</td>";
		String thText9="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ClientDocument.DocumentUrl")+"</td>";
		String thText10=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(\"" + this.getTableName()+"\",\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateClientDocumentDiv" +
										 "\",\"ClientDocumentDiv\""+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText10 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+
								thText1+thText2+thText3+thText4+thText5+
								thText6+thText7+thText8+thText9+thText10+"</tr>");
		
		Properties categoryPrpt = new Category().getNamesPrpts();
		String SQL = "select * from "+this.getTableName()+" where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String FlowKey = Cnstnts.EMPTY_STRING;
			String DocumentType = Cnstnts.EMPTY_STRING;
			String DocumentUrl = Cnstnts.EMPTY_STRING;
			String DocumentName = Cnstnts.EMPTY_STRING;
			String DocumentNo = Cnstnts.EMPTY_STRING;
			String DocumentDate = Cnstnts.EMPTY_STRING;
			String DocumentKind = Cnstnts.EMPTY_STRING;
			String DocumentTarget = Cnstnts.EMPTY_STRING;
			String DocumentProcess = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("DocumentType")){
					DocumentType = field.getValue();
				}
				if(field.getName().equals("DocumentUrl")){
					DocumentUrl = "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
										  "onClick='openAppendix(\""+field.getValue()+"\",\"DocumentUrl\",600,400)'>";
				}
				if(field.getName().equals("DocumentName")){
					DocumentName = field.getValue();
				}
				if(field.getName().equals("DocumentNo")){
					DocumentNo = field.getValue();
				}
				if(field.getName().equals("DocumentDate")){
					DocumentDate = field.getValue();
				}
				if(field.getName().equals("DocumentKind")){
					DocumentKind = field.getValue();
				}
				if(field.getName().equals("DocumentTarget")){
					DocumentTarget = field.getValue();
				}
				if(field.getName().equals("DocumentProcess")){
					DocumentProcess = field.getValue();
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+categoryPrpt.getProperty(DocumentType)+"</td>";
			String tdText3="<td>"+DocumentName+"</td>";
			String tdText4="<td>"+DocumentNo+"</td>";
			String tdText5="<td>"+DocumentDate+"</td>";
			String tdText6="<td>"+DocumentKind+"</td>";
			String tdText7="<td>"+DocumentTarget+"</td>";
			String tdText8="<td>"+categoryPrpt.getProperty(DocumentProcess)+"</td>";
			String tdText9="<td align='center'>"+DocumentUrl+"</td>";
			String tdText10=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(\"" + this.getTableName()+"\",\"update\",\""+
								 		FlowKey+"\","+this.FRAME_HEIGHT+",\"updateClientDocumentDiv" +
										 "\",\"ClientDocumentDiv\""+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(\"" + this.getTableName()+"\",\"delete\",\""+
				 						FlowKey+"\","+this.FRAME_HEIGHT+",\"updateClientDocumentDiv" +
										 "\",\"ClientDocumentDiv\""+")'/>";
				tdText10 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8+tdText9+tdText10;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			String onClick = "";
			strBfr.append(newLine + "<tr style='cursor:hand'"+bgColor+onClick+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
    
    protected String getAjaxReasult(UserBean userInfo,String parentId) throws Exception {
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printAjaxReasult();
    }
    
    public String printAjaxReasult() throws Exception {
    	return this.printSearchReasult();
	}

    
    public void doAction(UserBean userInfo) throws Exception {
		this.setUserInfo(userInfo);
		if (this.getApplicant().trim().length() == 0 || this.canEdit()) {
			this.setApplicant(userInfo.getAttribute("emp_id"));
		}
		if (this.getCreateDept().trim().length() == 0 || this.canEdit()) {
			this.setCreateDept(userInfo.getAttribute("dept_id"));
		}
		if (!this.getModeLockFlag().equals(Cnstnts.TRUE_FLAG)) {
			if (this.getProgramMode().equals("M")) {
				this.setPageActionMode(Cnstnts.MAINTAIN);
				this.setModeLockFlag(Cnstnts.TRUE_FLAG);
			} else if (this.getProgramMode().equals("S")) {
				this.setPageActionMode(Cnstnts.SEARCH);
				this.setModeLockFlag(Cnstnts.TRUE_FLAG);
			}
		}
		if(Util.compareTo(this.getCreateDocFlag(), "true")) {
			doPrintProcess();
		}
		if (this.getDataFromDB()) {
			this.setPreObj(userInfo);
			this.getAttribute();
		} else {
			if (userInfo.getObj(this.getTableName()) != null) {
				this.setPreObj(userInfo);
				if (this.canAccessDB())
					if(this.dbExecute()){
						userInfo.setAttribute(this.getTableName()+"CloseFrame", "true");
					} else {
						userInfo.setAttribute(this.getTableName()+"CloseFrame", "false");
					}
				if (this.onBtnClear()) {
					this.clearAttribute();
					this.setSearchResult(null);
				}
				if (!this.getDbActionMode().equals(Cnstnts.INSERT)
						&& this.FlowKey.getValue().trim().length() == 0
						&& this.getPageActionMode().equals(Cnstnts.MAINTAIN)) {
					this.clearAttribute();
				}
			}
		}
	}
    
    public void doPrintProcess() throws Exception {
    	String outFile = this.makeDoc();

    	if(outFile!=null){
    		this.setOutputFile2(outFile);
    	}
	}
    
    @SuppressWarnings("unchecked")
	public String makeDoc() throws Exception{
    	List<SelectItem> sampleDocs = new ReportDefine().getList(this.getProgramId());
    	
    	if(sampleDocs == null || sampleDocs.isEmpty()){
    		return null;
    	}
    	String sampleDocPath = sampleDocs.get(0).getKey();
    	
    	OoConverter oc = new OoConverter("localhost", "8100");
    	String sampleDoc = "file:///"+Util.getTomcatPath()+sampleDocPath;
    	String outputFile = "PatentCase/"+Util.getPdfNo(this.getUserInfo().getAttribute("emp_id"))+".doc";
    	String outputDoc = "file:///"+Util.getDocPath()+outputFile;
    	
    	if(sampleDoc.trim().length()>0 && outputDoc.trim().length()>0){
    		
    		Map data = new HashMap<String, String>();
    		
    		Properties cateProp = new Category().getNamesPrpts();
    		
    		PatentCase patent = new PatentCase(this.getParentId());
    		Client client = new Client(patent.getClient());
    		Employee contractor = new Employee(this.getContractor());
    		Department dep = new Department(contractor.getDept_id());
    		Employee incharge = new Employee(patent.getInCharge());
    		Attorney documentTargetA = new Attorney(this.getDocumentTarget());
    		Client documentTargetC = new Client(this.getDocumentTarget());
    		Employee documentTargetE = new Employee(this.getDocumentTarget());
    		
    		if(this.getDocumentUnit().equals("DU01")) {
    			data.put("#{DocumentTarget}", cateProp.get(this.getDocumentTarget()));
			}
			else if(this.getDocumentUnit().equals("DU02")) {
				data.put("#{DocumentTarget}", documentTargetA.getFirm());
			}
			else if(this.getDocumentUnit().equals("DU03")) {
				data.put("#{DocumentTarget}", documentTargetC.getCompanyName());
			}
			else if(this.getDocumentUnit().equals("DU04")) {
				data.put("#{DocumentTarget}", documentTargetE.getEmp_name());
			}
    		
			data.put("#{DocumentDate}", this.getDocumentDate().replaceAll("-", "."));
			data.put("#{DeadlineDate}", this.getDeadlineDate().replaceAll("-", "."));
			data.put("#{CreateTime}", this.getCreateTime().replaceAll("-", "."));
			data.put("#{FlowKey}", this.getParentId());
			data.put("#{Title}", Util.isEmpty(patent.getTitle())?patent.getOriginalTitle():patent.getTitle());
			data.put("#{InCgarge}", incharge.getEmp_name());
			data.put("#{Office}", cateProp.get(patent.getPatentOffice()));
			data.put("#{Type}", cateProp.get(patent.getPatentType()));
			data.put("#{Client}", client.getCompanyName());
			data.put("#{Attachment}", this.getAttachmentName());
			data.put("#{Attachment2}", this.getAttachmentName2());
			data.put("#{Attachment3}", this.getAttachmentName3());
			data.put("#{Attachment4}", this.getAttachmentName4());
			data.put("#{Attachment5}", this.getAttachmentName5());
			data.put("#{Attachment6}", this.getAttachmentName6());
			data.put("#{DocumentName}", this.getDocumentName());
			data.put("#{remark}", this.getRemark());
			data.put("#{ServiceFee}", this.getServiceFee());
			data.put("#{ArFee}", this.getArFee());
			data.put("#{DocumentDate}", this.getDocumentDate().replaceAll("-", "."));
			data.put("#{Contractor}", contractor.getEmp_name());
			data.put("#{Signer_Emp_id}", new Employee(dep.getSigner_Emp_id()).getEmp_name());
    		
    		try {
				oc.convertDocument(sampleDoc, outputDoc, data);
				return "doc/"+outputFile;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
    	}
    	return null;
    }

	public boolean getCanEditField(Field field) {
		if (this.canEdit() || this.onSearchMode()) {
			if(this.getDbActionMode().equals(Cnstnts.UPDATE)) {
				if(field.getName().equals(this.LinkOthers.getName()) ||
						field.getName().equals(this.IsAddToDos.getName())) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	public boolean dbExecute() throws Exception {
		this.resetError();
		if (this.getUserInfo() == null) {
			this.setErrorMessage("no userInfo object");
			return false;
		}
		if (this.checkHasError()) {
			return false;
		} else {
			if (this.getApplicant().trim().length() == 0) {
				this.setApplicant(this.getUserInfo().getAttribute("emp_id"));
			}
			if (this.getCreateDept().trim().length() == 0) {
				this.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
			}
			if (Cnstnts.SIGN.equals(this.getDbActionMode())) {
				this.doSignProcess();
				this.doApproveProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.signForm.send"));
				this.setForwardPage("menu.jsp");
			} else if (Cnstnts.CLOSE.equals(this.getDbActionMode())) {
				this.doCloseProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.closeForm.closed"));
				this.setForwardPage("menu.jsp");
			}
			else if (Cnstnts.INSERT.equals(this.getDbActionMode())) {
				if (this.insert()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
									  this.FlowKey.getValue(), 
									  this.getProgramId(), 
									  this.getUserInfo().getAttribute("emp_id"), 
									  this.getApplicant(),
									  this.getTableName(), 
									  this.getAliasName());
					}
					this.doOtherInsertProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.insert"));
					
					if(Util.compareTo(this.getInsertAddFlag(), "true")) {
						this.getUserInfo().setAttribute("InsertAddFlag", "true");
						
						clearAttribute();
					}
				} else {
					this.setErrorMessage(this.getTableName() + ".insert() error!!");
					return false;
				}
			} else if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
				if (this.update()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
								  	  this.FlowKey.getValue(), 
								  	  this.getProgramId(), 
								  	  this.getUserInfo().getAttribute("emp_id"), 
								  	  this.getApplicant(),
								  	  this.getTableName(), 
								  	  this.getAliasName());
					}
					this.doOtherUpdateProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.update"));
					if(this.LinkMode.getValue().equals(Cnstnts.HREF)){
						this.setForwardPage("menu.jsp");
					}
				} else {
					this.setErrorMessage(this.getTableName() + ".update() error!!");
					return false;
				}
			} else if (Cnstnts.DELETE.equals(this.getDbActionMode())) {
				if (this.delete()) {
					this.doOtherDeleteProcess();
					this.clearAttribute();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.delete"));
				} else {
					this.setErrorMessage(this.getTableName() + ".delete() error!!");
					return false;
				}
			}
			return true;
		}
	}
}