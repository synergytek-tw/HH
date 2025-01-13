package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
//import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.html.Html;

public class DraftPic extends MultiDetail {

    public DraftPic(){this.init();}

    public DraftPic(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field PicName;
    public void setPicName(String PicName){this.PicName.setValue(PicName);}
    public String getPicName(){return this.PicName.getValue();}
    
    public Field PicUrl;
    public void setPicUrl(String PicUrl){this.PicUrl.setValue(PicUrl);}
    public String getPicUrl(){return this.PicUrl.getValue();}
    
    final int FRAME_HEIGHT = 150;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftPic");
        this.setTableName("DraftPic");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.PicName = new Field("PicName",this.getTableName());
        this.PicName.setDbType("varchar(200)");
       
        this.PicUrl= new Field("PicUrl",this.getTableName());
        this.PicUrl.setDbType("varchar(50)");
        this.PicUrl.setCheckEmpty(true);
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.PicName);
        this.DbFields.add(this.PicUrl);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

        	this.PicUrl.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.PicUrl);

        	this.PicName.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        	this.PicName.setCols(60);
        	rtnString += this.printHtml(this.PicName);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftPic preObj = (DraftPic) userInfo.getObj(this.getTableName());
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
		String thText2="<td align='center' width='40%'>"+this.getUserInfo().getMsg("jsp.DraftPic.title")+"</td>";
		String thText3="<td align='center' width='40%'>"+this.getUserInfo().getMsg("jsp.DraftPic.PicName")+"</td>";
		String thText4="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.DraftPic.Applicant")+"</td>";
		String thText5=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(\"" + this.getTableName()+"\",\"insert\",\""+
							 parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftPicDiv" +
							 "\",\"DraftPicDiv\""+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText5 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+
								thText1+thText2+thText3+thText4+thText5+"</tr>");
		
		String SQL = "select * from "+this.getTableName()+" where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties empPrpt = new Employee().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext(); i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String FlowKey = Cnstnts.EMPTY_STRING;
			String PicUrl = Cnstnts.EMPTY_STRING;
			String PicName = Cnstnts.EMPTY_STRING;
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
				if(field.getName().equals("PicUrl")){
					PicUrl = field.getValue();
				}
				if(field.getName().equals("PicName")){
					PicName = field.getValue();
				}
			}
			String tdText1 = Cnstnts.EMPTY_STRING;
			String tdText2 = "<td><img src='"+PicUrl+"' height='100px' " +
					"onClick='openAppendix(\""+PicUrl+"\",\"DraftPic\",800,600)'/></td>";
			String tdText3 = "<td>"+PicName+"</td>";
			String tdText4 = "<td align='center'>"+Applicant+"</td>";
			String tdText5 = Cnstnts.EMPTY_STRING;
			if(canAssesFlag && isSelf){ 
				String editImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(\"" + this.getTableName()+"\",\"update\",\""+
								 		FlowKey+"\","+this.FRAME_HEIGHT+",\"updateDraftPicDiv" +"\",\"DraftPicDiv\""+")'/>";
				tdText1 = "<td align='center'>"+editImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(\"" + this.getTableName()+"\",\"delete\",\""+
				 						FlowKey+"\","+this.FRAME_HEIGHT+",\"updateDraftPicDiv" +"\",\"DraftPicDiv\""+")'/>";
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
			String cancelBtn = "<input type='button' onClick='parent.closeTabFrame(\"updateDraftPicDiv" +"\",\"DraftPicDiv\")' value='"+
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
