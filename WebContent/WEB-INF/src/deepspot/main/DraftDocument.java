package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.html.Html;

public class DraftDocument extends MultiDetail {

    public DraftDocument(){this.init();}

    public DraftDocument(String FlowKey) {
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
  
    public Field DocumentDate;
    public void setDocumentDate(String DocumentDate){this.DocumentDate.setValue(DocumentDate);}
    public String getDocumentDate(){return this.DocumentDate.getValue();}
    
    public Field DocumentPublication;
    public void setDocumentPublication(String DocumentPublication){this.DocumentPublication.setValue(DocumentPublication);}
    public String getDocumentPublication(){return this.DocumentPublication.getValue();}
    
    public Field DocumentArea;
    public void setDocumentArea(String DocumentArea){this.DocumentArea.setValue(DocumentArea);}
    public String getDocumentArea(){return this.DocumentArea.getValue();}
    
    final int FRAME_HEIGHT = 200;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftDocument");
        this.setTableName("DraftDocument");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.DocumentType = new Field("DocumentType", this.getTableName());
        this.DocumentType.setCheckEmpty(true);
        this.DocumentType.setDbType("varchar(50)");

        this.DocumentUrl = new Field("DocumentUrl", this.getTableName());
        this.DocumentUrl.setCheckEmpty(true);
        this.DocumentUrl.setDbType("varchar(100)");

        this.DocumentName = new Field("DocumentName", this.getTableName());
        this.DocumentName.setCheckEmpty(true);
        this.DocumentName.setDbType("nvarchar(100)");
        
        this.DocumentPublication = new Field("DocumentPublication", this.getTableName());
        this.DocumentPublication.setDbType("varchar(50)");
        
        this.DocumentDate = new Field("DocumentDate", this.getTableName());
        this.DocumentDate.setCheckEmpty(true);
        this.DocumentDate.setDbType("varchar(10)");
        
        this.DocumentArea = new Field("DocumentArea", this.getTableName());
        this.DocumentArea.setDbType("varchar(50)");
        
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
        
        this.DbFields.add(this.DocumentPublication);
        
        this.DbFields.add(this.DocumentArea);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	
        	this.DocumentDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

            this.DocumentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.DocumentType.setSelectList(new Category().getChildList("DraftDocumentType"));
            this.DocumentType.setAnotherField(this.DocumentDate);
            rtnString += this.printHtml(this.DocumentType);
            
            this.DocumentName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.DocumentName.setSize(50);
            rtnString += this.printHtml(this.DocumentName);
            
            this.DocumentUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.DocumentUrl);
           
            this.DocumentPublication.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.DocumentPublication.setSize(30);
            rtnString += this.printHtml(this.DocumentPublication);
            
            this.DocumentArea.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.DocumentArea.setSize(30);
            rtnString += this.printHtml(this.DocumentArea);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftDocument preObj = (DraftDocument) userInfo.getObj(this.getTableName());
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
		StringBuffer strBfr = new StringBuffer();
		
		boolean canAssesFlag = false;
		Draft parentObj = (Draft)this.getUserInfo().getObj("Draft");
		if(parentObj!=null && parentObj.canEdit()){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.DraftDocument.DocumentType")+"</td>";
		String thText3="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.DraftDocument.DocumentName")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.DraftDocument.DocumentDate")+"</td>";
		String thText5="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.DraftDocument.DocumentPublication")+"</td>";
		String thText6="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.DraftDocument.DocumentArea")+"</td>";
		String thText7="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.DraftDocument.DocumentUrl")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(\"" + this.getTableName()+"\",\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftDocumentDiv" +"\",\"DraftDocumentDiv\""+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+
								thText1+thText2+thText3+thText4+
								thText5+thText6+thText7+thText8+"</tr>");
		
		Properties categoryPrpt = new Category().getChildPrpts("DraftDocumentType");
		String SQL = "select * from "+this.getTableName()+" where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			DraftDocument obj = new DraftDocument();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					obj.FlowKey.setValue(field.getValue());
				}
				if(field.getName().equals("DocumentType")){
					obj.DocumentType.setValue(categoryPrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("DocumentUrl")){
					String Btn = "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
					  "onClick='openAppendix(\""+field.getValue()+"\",\"DocumentUrl\",600,400)'>";
					obj.DocumentUrl.setValue(Btn);
				}
				if(field.getName().equals("DocumentName")){
					obj.DocumentName.setValue(field.getValue());
				}
				if(field.getName().equals("DocumentDate")){
					obj.DocumentDate.setValue(field.getValue());
				}
				if(field.getName().equals("DocumentPublication")){
					obj.DocumentPublication.setValue(field.getValue());
				}
				if(field.getName().equals("DocumentArea")){
					obj.DocumentArea.setValue(field.getValue());
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+obj.DocumentType.getValue()+"</td>";
			String tdText3="<td>"+obj.DocumentName.getValue()+"</td>";
			String tdText4="<td>"+obj.DocumentDate.getValue()+"</td>";
			String tdText5="<td>"+obj.DocumentPublication.getValue()+"</td>";
			String tdText6="<td>"+obj.DocumentArea.getValue()+"</td>";
			String tdText7="<td align='center'>"+obj.DocumentUrl.getValue()+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(\"" + this.getTableName()+"\",\"update\",\""+
								 		obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftDocumentDiv" +
								 		"\",\"DraftDocumentDiv\""+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(\"" + this.getTableName()+"\",\"delete\",\""+
				 						obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftDocumentDiv" +
				 						"\",\"DraftDocumentDiv\""+")'/>";
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			String onClick = "";
			strBfr.append(newLine + "<tr "+bgColor+onClick+">"+printValue+"</tr>");
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
		if(!this.getDbActionMode().equals(Cnstnts.QUERY)){
			String cancelBtn = "<input type='button' onClick='parent.closeTabFrame(\"updateDraftDocumentDiv" +"\",\"DraftDocumentDiv\")' value='"+
								this.getUserInfo().getMsg("jsp.closeForm.cancel")+"'>";
			strBfr.append(cancelBtn);	
			strBfr.append(Html.getDetailSubmitBtn(this.getUserInfo(), this.getDbActionMode()));
		}
		strBfr.append(this.getDbActionSelectItem());
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "</tr>");
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
}
