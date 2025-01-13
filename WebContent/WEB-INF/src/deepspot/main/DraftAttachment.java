package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
//import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.html.Html;

public class DraftAttachment extends MultiDetail {

    public DraftAttachment(){this.init();}

    public DraftAttachment(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}
    
    public Field AttachmentUrl;
    public void setAttachmentUrl(String AttachmentUrl){this.AttachmentUrl.setValue(AttachmentUrl);}
    public String getAttachmentUrl(){return this.AttachmentUrl.getValue();}

    public Field AttachmentName;
    public void setAttachmentName(String AttachmentName){this.AttachmentName.setValue(AttachmentName);}
    public String getAttachmentName(){return this.AttachmentName.getValue();}
    
    public Field AttachmentDate;
    public void setAttachmentDate(String AttachmentDate){this.AttachmentDate.setValue(AttachmentDate);}
    public String getAttachmentDate(){return this.AttachmentDate.getValue();}
    
    final int FRAME_HEIGHT = 180;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftAttachment");
        this.setTableName("DraftAttachment");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.AttachmentUrl = new Field("AttachmentUrl", this.getTableName());
        this.AttachmentUrl.setCheckEmpty(true);
        this.AttachmentUrl.setDbType("varchar(50)");

        this.AttachmentName = new Field("AttachmentName", this.getTableName());
        this.AttachmentName.setDbType("nvarchar(200)");
        
        this.AttachmentDate = new Field("AttachmentDate", this.getTableName());
        this.AttachmentDate.setDbType("varchar(10)");
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.AttachmentUrl);
        this.DbFields.add(this.AttachmentName);
        this.DbFields.add(this.AttachmentDate);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	
        	this.AttachmentUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.AttachmentUrl);

        	this.AttachmentName.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        	this.AttachmentName.setCols(80);
        	rtnString += this.printHtml(this.AttachmentName);
          
            this.AttachmentDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            rtnString += this.printHtml(this.AttachmentDate);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftAttachment preObj = (DraftAttachment) userInfo.getObj(this.getTableName());
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
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasult();
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasult() throws Exception {
		StringBuffer strBfr = new StringBuffer();
		
		boolean inG01Group = new Groups().inGorup("G01", this.getUserInfo().getAttribute("emp_id"));
		
		boolean canAssesFlag = false;
		Draft parentObj = (Draft)this.getUserInfo().getObj("Draft");
		if((parentObj!=null && parentObj.canEdit()) || inG01Group){
			canAssesFlag = true;
		}
		
		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText3="<td align='center' width='50%'>"+this.getUserInfo().getMsg("jsp.DraftAttachment.AttachmentName")+"</td>";
		String thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.DraftAttachment.AttachmentDate")+"</td>";
		String thText8="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.DraftAttachment.AttachmentUrl")+"</td>";
		String thText9="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.DraftAttachment.Applicant")+"</td>";
		String thText10=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(\"" + this.getTableName()+"\",\"insert\",\""+
							 parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftAttachmentDiv" +
							 "\",\"DraftAttachmentDiv\""+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText10 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+
								thText1+thText3+thText5+thText8+
								thText9+thText10+"</tr>");
		
		String SQL = "select * from "+this.getTableName()+" where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties empPrpt = new Employee().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String FlowKey = Cnstnts.EMPTY_STRING;
			String AttachmentUrl = Cnstnts.EMPTY_STRING;
			String AttachmentName = Cnstnts.EMPTY_STRING;
			String AttachmentDate = Cnstnts.EMPTY_STRING;
			String Applicant = Cnstnts.EMPTY_STRING;
			boolean isSelf = false;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Applicant")){
					if(this.getUserInfo().getAttribute("emp_id").equals(field.getValue())){
						isSelf = true;
					}
					Applicant = empPrpt.getProperty(field.getValue());
				}
				if(field.getName().equals("AttachmentUrl")){
					AttachmentUrl = "<input type='button' value='"+this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
										  "onClick='openAppendix(\""+field.getValue()+"\",\"DocumentUrl\",600,400)'>";
				}
				if(field.getName().equals("AttachmentName")){
					AttachmentName = field.getValue();
				}
				if(field.getName().equals("AttachmentDate")){
					AttachmentDate = field.getValue();
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText3="<td>"+AttachmentName+"</td>";
			String tdText5="<td align='center'>"+AttachmentDate+"</td>";
			String tdText8="<td align='center'>"+AttachmentUrl+"</td>";
			String tdText9="<td align='center'>"+Applicant+"</td>";
			String tdText10=Cnstnts.EMPTY_STRING;
			if(canAssesFlag && isSelf){ 
				String editImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(\"" + this.getTableName()+"\",\"update\",\""+
								 		FlowKey+"\","+this.FRAME_HEIGHT+",\"updateDraftAttachmentDiv" +
								 		"\",\"DraftAttachmentDiv\""+")'/>";
				
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(\"" + this.getTableName()+"\",\"delete\",\""+
				 						FlowKey+"\","+this.FRAME_HEIGHT+",\"updateDraftAttachmentDiv" +
				 						"\",\"DraftAttachmentDiv\""+")'/>";
				if(isSelf){
					tdText1 = "<td align='center'>"+editImg+"</td>";
					tdText10 = "<td align='center'>"+deleteImg+"</td>";
				} else {
					tdText1 = "<td align='center'>&nbsp;</td>";
					tdText10 = "<td align='center'>&nbsp;</td>";
				}
			}
			printValue = tdText1+tdText3+tdText5+tdText8+tdText9+tdText10;
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
			String cancelBtn = "<input type='button' onClick='parent.closeTabFrame(\"updateDraftAttachmentDiv" +"\",\"DraftAttachmentDiv\")' value='"+
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
