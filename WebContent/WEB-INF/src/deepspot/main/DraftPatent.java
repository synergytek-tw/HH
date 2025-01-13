package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.html.Html;

public class DraftPatent extends MultiDetail {

    public DraftPatent(){this.init();}

    public DraftPatent(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field PatentOffice;
    public void setPatentOffice(String PatentOffice){this.PatentOffice.setValue(PatentOffice);}
    public String getPatentOffice(){return this.PatentOffice.getValue();}
    
    public Field PatentNo;
    public void setPatentNo(String PatentNo){this.PatentNo.setValue(PatentNo);}
    public String getPatentNo(){return this.PatentNo.getValue();}
    
    public Field UploadFile;
    public void setUploadFile(String UploadFile){this.UploadFile.setValue(UploadFile);}
    public String getUploadFile(){return this.UploadFile.getValue();}
    
    final int FRAME_HEIGHT = 100;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftPatent");
        this.setTableName("DraftPatent");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");
        
        this.PatentOffice = new Field("PatentOffice",this.getTableName());
        this.PatentOffice.setDbType("varchar(50)");
        this.PatentOffice.setCheckEmpty(true);
                
        this.PatentNo = new Field("PatentNo",this.getTableName());
        this.PatentNo.setDbType("varchar(50)");
        this.PatentNo.setCheckEmpty(true);
        
        this.UploadFile = new Field("UploadFile",this.getTableName());
        this.UploadFile.setDbType("varchar(50)");
        this.UploadFile.setCheckEmpty(true);
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.PatentOffice);
        this.DbFields.add(this.PatentNo);
        this.DbFields.add(this.UploadFile);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	
        	this.PatentNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.PatentNo.setSize(30);
        	
        	this.PatentOffice.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.PatentOffice.setSelectList(new Category().getChildList(this.PatentOffice));
        	this.PatentOffice.setAnotherField(this.PatentNo);
        	rtnString += this.printHtml(this.PatentOffice);
        	
        	this.UploadFile.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
        	rtnString += this.printHtml(this.UploadFile);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftPatent preObj = (DraftPatent) userInfo.getObj(this.getTableName());
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
		String thText2="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.DraftPatent.PatentOffice")+"</td>";
		String thText3="<td align='center' width='70%'>"+this.getUserInfo().getMsg("jsp.DraftPatent.PatentNo")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.DraftPatent.UploadFile")+"</td>";
		String thText5=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(\"" + this.getTableName()+"\",\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftPatentDiv" +"\",\"DraftPatentDiv\""+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText5 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+
									thText2+thText3+thText4+thText5+"</tr>");
		
		String SQL = "select * from "+this.getTableName()+" where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties patentTypePrpt = new Category().getChildPrpts("PatentOffice");
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			DraftPatent obj = new DraftPatent();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					obj.FlowKey.setValue(field.getValue());
				}
				if(field.getName().equals("PatentOffice")){
					obj.PatentOffice.setValue(patentTypePrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("PatentNo")){
					obj.PatentNo.setValue(field.getValue());
				}
				if(field.getName().equals("UploadFile")){
					String Btn = "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
					  "onClick='openAppendix(\""+field.getValue()+"\",\"DocumentUrl\",600,400)'>";
					obj.UploadFile.setValue(Btn);
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'>"+obj.PatentOffice.getValue()+"</td>";
			String tdText3="<td>"+obj.PatentNo.getValue()+"</td>";
			String tdText4="<td align='center'>"+obj.UploadFile.getValue()+"</td>";
			String tdText5=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(\"" + this.getTableName()+"\",\"update\",\""+
								 		obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftPatentDiv" +
								 		"\",\"DraftPatentDiv\""+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(\"" + this.getTableName()+"\",\"delete\",\""+
				 						obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftPatentDiv" +
				 						"\",\"DraftPatentDiv\""+")'/>";
				tdText5 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
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
			String cancelBtn = "<input type='button' onClick='parent.closeTabFrame(\"updateDraftPatentDiv" +"\",\"DraftPatentDiv\")' value='"+
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