package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class TrademarkDocument extends MultiDetail {

    public TrademarkDocument(){this.init();}

    public TrademarkDocument(String FlowKey) {
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
    
    final int FRAME_HEIGHT = 200;

    public void init() {
        super.init();
        this.setProgramId("jsp.TrademarkDocument");
        this.setTableName("TrademarkDocument");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.DocumentType = new Field("DocumentType", this.getTableName());
        this.DocumentType.setCheckEmpty(true);
        this.DocumentType.setDbType("varchar(50)");

        this.DocumentUrl = new Field("DocumentUrl", this.getTableName());
        this.DocumentUrl.setCheckEmpty(true);
        this.DocumentUrl.setDbType("varchar(50)");

        this.DocumentName = new Field("DocumentName", this.getTableName());
        this.DocumentName.setDbType("nvarchar(100)");
        
        this.DocumentNo = new Field("DocumentNo", this.getTableName());
        this.DocumentNo.setDbType("varchar(50)");
        
        this.DocumentKind = new Field("DocumentKind", this.getTableName());
        this.DocumentKind.setDbType("varchar(50)");
        
        this.DocumentTarget = new Field("DocumentTarget", this.getTableName());
        this.DocumentTarget.setDbType("varchar(50)");
        
        this.DocumentDate = new Field("DocumentDate", this.getTableName());
        this.DocumentDate.setDbType("varchar(10)");
        
        this.DocumentProcess = new Field("DocumentProcess", this.getTableName());
        this.DocumentProcess.setDbType("varchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.DocumentType);

        this.DbFields.add(this.DocumentUrl);

        this.DbFields.add(this.DocumentName);
        
        this.DbFields.add(this.DocumentDate);
        
        this.DbFields.add(this.DocumentNo);
        
        this.DbFields.add(this.DocumentKind);
        
        this.DbFields.add(this.DocumentTarget);
        
        this.DbFields.add(this.DocumentProcess);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

        	this.DocumentName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.DocumentName.setSize(40);

            this.DocumentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.DocumentType.setSelectList(new Category().getChildList(this.DocumentType));
            this.DocumentType.setAnotherField(this.DocumentName);
            rtnString += this.printHtml(this.DocumentType);
            
            this.DocumentUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.DocumentUrl);
            
            this.DocumentDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.DocumentNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.DocumentNo.setAnotherField(this.DocumentDate);
            rtnString += this.printHtml(this.DocumentNo);
            
            this.DocumentKind.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.DocumentKind.setSelectList(new Category().getChildList(this.DocumentKind));
            
            this.DocumentTarget.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.DocumentTarget.setAnotherField(this.DocumentKind);
            rtnString += this.printHtml(this.DocumentTarget);
            
            this.DocumentProcess.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.DocumentProcess);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            TrademarkDocument preObj = (TrademarkDocument) userInfo.getObj(this.getTableName());
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
    
    protected String getSearchReasult(UserBean userInfo,String parentId) throws Exception {
    	this.setDoSearchFlag(Cnstnts.TRUE_FLAG);
		this.setPageActionMode(Cnstnts.SEARCH);
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasult();
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasult() throws Exception {
		if (this.onBtnSearch()) {
			this.setSearchResult(this.getSearchList());
		}

		StringBuffer strBfr = new StringBuffer();
		if (this.getShowField() == null || this.getShowField().length == 0
				|| this.getSearchResult() == null) {
			return strBfr.toString();
		}
		
		boolean canAssesFlag = false;
		TrademarkCase parentObj = (TrademarkCase)this.getUserInfo().getObj("TrademarkCase");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE)){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.DocumentType")+"</td>";
		String thText3="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.DocumentName")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.DocumentNo")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.DocumentDate")+"</td>";
		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.DocumentKind")+"</td>";
		String thText7="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.DocumentTarget")+"</td>";
		String thText8="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.DocumentProcess")+"</td>";
		String thText9="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentDocument.DocumentUrl")+"</td>";
		String thText10=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
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
			String tdText8="<td>"+DocumentProcess+"</td>";
			String tdText9="<td align='center'>"+DocumentUrl+"</td>";
			String tdText10=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(getElementById(\"tabText\").value,\"update\",\""+
								 		FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(getElementById(\"tabText\").value,\"delete\",\""+
				 						FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
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
