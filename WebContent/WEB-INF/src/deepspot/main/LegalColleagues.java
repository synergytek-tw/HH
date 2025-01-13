package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class LegalColleagues extends MultiDetail {

    public LegalColleagues(){this.init();}

    public LegalColleagues(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field EmpId;
    public void setEmpId(String EmpId){this.EmpId.setValue(EmpId);}
    public String getEmpId(){return this.EmpId.getValue();}

    public Field Role;
    public void setRole(String Role){this.Role.setValue(Role);}
    public String getRole(){return this.Role.getValue();}

    public Field Memo;
    public void setMemo(String Memo){this.Memo.setValue(Memo);}
    public String getMemo(){return this.Memo.getValue();}
    
    final int FRAME_HEIGHT = 150;

    public void init() {
        super.init();
        this.setProgramId("jsp.LegalColleagues");
        this.setTableName("LegalColleagues");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.EmpId = new Field("EmpId", this.getTableName());
        this.EmpId.setCheckEmpty(true);
        this.EmpId.setDbType("varchar(50)");

        this.Role = new Field("Role", this.getTableName());
        this.Role.setCheckEmpty(true);
        this.Role.setDbType("varchar(50)");

        this.Memo = new Field("Memo", this.getTableName());
        this.Memo.setDbType("nvarchar(500)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.EmpId);

        this.DbFields.add(this.Role);

        this.DbFields.add(this.Memo);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

            this.Role.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.EmpId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.EmpId.setSelectList(new Employee().getList());
            this.EmpId.setAnotherField(this.Role);
            this.EmpId.setColspan(1);
            rtnString += this.printHtml(this.EmpId);

            this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Memo.setCols(80);
            rtnString += this.printHtml(this.Memo);

        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            LegalColleagues preObj = (LegalColleagues) userInfo.getObj(this.getTableName());
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
		LegalCase parentObj = (LegalCase)this.getUserInfo().getObj("LegalCase");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE)){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.LegalColleagues.EmpId")+"</td>";
		String thText3="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.LegalColleagues.Role")+"</td>";
		String thText4="<td align='center' width='60%'>"+this.getUserInfo().getMsg("jsp.LegalColleagues.Memo")+"</td>";
		String thText5=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText5 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+"</tr>");
		
		String SQL = "select * from LegalColleagues where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, this.getDbFields());
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		Properties empPrpt = new Employee().getNamesPrpts();
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String EmpId = Cnstnts.EMPTY_STRING;
			String Role = Cnstnts.EMPTY_STRING;
			String Memo = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("EmpId")){
					EmpId = field.getValue();
				}
				if(field.getName().equals("Role")){
					Role = field.getValue();
				}
				if(field.getName().equals("Memo")){
					Memo = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
			}
			String onClick = " onClick='openAppendix(\"Employee.jsp?flowKey="+EmpId+
			  					"&_dbActionMode=query&getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td"+onClick+">"+empPrpt.getProperty(EmpId)+"</td>";
			String tdText3="<td>"+Role+"</td>";
			String tdText4="<td>"+Memo+"</td>";
			String tdText5=Cnstnts.EMPTY_STRING;
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
    

}
