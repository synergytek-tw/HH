package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class ContractDocument extends MultiDetail {

    public ContractDocument(){this.init();}

    public ContractDocument(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field DocumentType;
    public void setDocumentType(String DocumentType){this.DocumentType.setValue(DocumentType);}
    public String getDocumentType(){return this.DocumentType.getValue();}

    public Field DocumentUrl;
    public void setDocumentUrl(String DocumentUrl){this.DocumentUrl.setValue(DocumentUrl);}
    public String getDocumentUrl(){return this.DocumentUrl.getValue();}

    public Field DocumentName;
    public void setDocumentName(String DocumentName){this.DocumentName.setValue(DocumentName);}
    public String getDocumentName(){return this.DocumentName.getValue();}
    
    public Field Edition;
    public void setEdition(String Edition){this.Edition.setValue(Edition);}
    public String getEdition(){return this.Edition.getValue();}
    
    final int FRAME_HEIGHT = 140;

    public void init() {
        super.init();
        this.setProgramId("jsp.ContractDocument");
        this.setTableName("ContractDocument");

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
        
        this.Edition = new Field("Edition", this.getTableName());
        this.DocumentName.setDbType("varchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.DocumentType);

        this.DbFields.add(this.DocumentUrl);

        this.DbFields.add(this.DocumentName);
        
        this.DbFields.add(this.Edition);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

        	this.DocumentName.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.DocumentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.DocumentType.setSelectList(new Category().getChildList(this.DocumentType));
            this.DocumentType.setAnotherField(this.DocumentName);
            rtnString += this.printHtml(this.DocumentType);
            
            this.DocumentUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.DocumentUrl);
            
            this.Edition.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Edition);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
        	ContractDocument preObj = (ContractDocument) userInfo.getObj(this.getTableName());
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
		Contract parentObj = (Contract)this.getUserInfo().getObj("Contract");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE) 
				&& parentObj.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.ContractDocument.DocumentType")+"</td>";
		String thText3="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.ContractDocument.DocumentName")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ContractDocument.Edition")+"</td>";
		String thText5="<td align='center' width='50%'>"+this.getUserInfo().getMsg("jsp.ContractDocument.DocumentUrl")+"</td>";
		String thText6=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText6 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+"</tr>");
		
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
			String Edition = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("DocumentType")){
					DocumentType = field.getValue();
				}
				if(field.getName().equals("DocumentUrl")){
					DocumentUrl = field.getValue();
					DocumentUrl += "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
										  "onClick='openAppendix(\""+DocumentUrl+"\",\"DocumentUrl\",600,400)'>";
				}
				if(field.getName().equals("DocumentName")){
					DocumentName = field.getValue();
				}
				if(field.getName().equals("Edition")){
					Edition = field.getValue();
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+categoryPrpt.getProperty(DocumentType)+"</td>";
			String tdText3="<td>"+DocumentName+"</td>";
			String tdText4="<td>"+Edition+"</td>";
			String tdText5="<td>"+DocumentUrl+"</td>";
			String tdText6=Cnstnts.EMPTY_STRING;
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
				tdText6 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6;
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
