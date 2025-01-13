package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class ContractAuthorize extends MultiDetail {

    public ContractAuthorize(){this.init();}

    public ContractAuthorize(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Nationality;
    public void setNationality(String Nationality){this.Nationality.setValue(Nationality);}
    public String getNationality(){return this.Nationality.getValue();}

    public Field PatentType;
    public void setPatentType(String PatentType){this.PatentType.setValue(PatentType);}
    public String getPatentType(){return this.PatentType.getValue();}

    public Field PatentNo;
    public void setPatentNo(String PatentNo){this.PatentNo.setValue(PatentNo);}
    public String getPatentNo(){return this.PatentNo.getValue();}
    
    public Field PatentNames;
    public void setPatentNames(String PatentNames){this.PatentNames.setValue(PatentNames);}
    public String getPatentNames(){return this.PatentNames.getValue();}
    
    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}
    
    public Field Authorize;
    public void setAuthorize(String Authorize){this.Authorize.setValue(Authorize);}
    public String getAuthorize(){return this.Authorize.getValue();}
    
    final int FRAME_HEIGHT = 140;

    public void init() {
        super.init();
        this.setProgramId("jsp.ContractAuthorize");
        this.setTableName("ContractAuthorize");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.Nationality = new Field("Nationality", this.getTableName());
        this.Nationality.setDbType("varchar(50)");

        this.PatentType = new Field("PatentType", this.getTableName());
        this.PatentType.setCheckEmpty(true);
        this.PatentType.setDbType("varchar(50)");
        
        this.PatentNo = new Field("PatentNo", this.getTableName());
        this.PatentNo.setCheckEmpty(true);
        this.PatentNo.setDbType("varchar(50)");

        this.PatentNames = new Field("PatentNames", this.getTableName());
        this.PatentNames.setCheckEmpty(true);
        this.PatentNames.setDbType("nvarchar(100)");
        
        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");
        
        this.Authorize = new Field("Authorize", this.getTableName());
        this.Authorize.setDbType("varchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        
        this.DbFields.add(this.Nationality);

        this.DbFields.add(this.PatentType);

        this.DbFields.add(this.PatentNo);

        this.DbFields.add(this.PatentNames);
        
        this.DbFields.add(this.Status);
        
        this.DbFields.add(this.Authorize);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

        	this.PatentNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.PatentType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.PatentType.setSelectList(new Category().getChildList(this.PatentType));
            this.PatentType.setAnotherField(this.PatentNo);
            rtnString += this.printHtml(this.PatentType);
            
            this.Nationality.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Nationality.setSelectList(new Category().getChildList(this.Nationality));
            rtnString += this.printHtml(this.Nationality);
            
            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("PatentStatus"));
            rtnString += this.printHtml(this.Status);
            
            this.PatentNames.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.PatentNames.setSize(80);
            rtnString += this.printHtml(this.PatentNames);
            
            this.Authorize.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Authorize);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
        	ContractAuthorize preObj = (ContractAuthorize) userInfo.getObj(this.getTableName());
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
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ContractAuthorize.Nationality")+"</td>";
		String thText3="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ContractAuthorize.PatentType")+"</td>";
		String thText4="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.ContractAuthorize.PatentNo")+"</td>";
		String thText5="<td align='center' width='40%'>"+this.getUserInfo().getMsg("jsp.ContractAuthorize.PatentNames")+"</td>";
		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ContractAuthorize.Status")+"</td>";
		String thText7="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.ContractAuthorize.Authorize")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText7+thText8+"</tr>");
		
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
			String Nationality = Cnstnts.EMPTY_STRING;
			String PatentType = Cnstnts.EMPTY_STRING;
			String PatentNo = Cnstnts.EMPTY_STRING;
			String PatentNames = Cnstnts.EMPTY_STRING;
			String Status = Cnstnts.EMPTY_STRING;
			String Authorize = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Nationality")){
					Nationality = field.getValue();
				}
				if(field.getName().equals("PatentType")){
					PatentType = field.getValue();
				}
				if(field.getName().equals("PatentNo")){
					PatentNo = field.getValue();
				}
				if(field.getName().equals("PatentNames")){
					PatentNames = field.getValue();
				}
				if(field.getName().equals("Status")){
					Status = field.getValue();
				}
				if(field.getName().equals("Authorize")){
					Authorize = field.getValue();
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+categoryPrpt.getProperty(Nationality)+"</td>";
			String tdText3="<td>"+categoryPrpt.getProperty(PatentType)+"</td>";
			String tdText4="<td>"+PatentNo+"</td>";
			String tdText5="<td>"+PatentNames+"</td>";
			String tdText6="<td>"+Status+"</td>";
			String tdText7="<td>"+Authorize+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
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
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8;
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

