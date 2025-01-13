package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class LegalPriority extends MultiDetail {

    public LegalPriority(){this.init();}

    public LegalPriority(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field Country;
    public void setCountry(String Country){this.Country.setValue(Country);}
    public String getCountry(){return this.Country.getValue();}

    public Field PriorityDate;
    public void setPriorityDate(String PriorityDate){this.PriorityDate.setValue(PriorityDate);}
    public String getPriorityDate(){return this.PriorityDate.getValue();}

    public Field ApplyNo;
    public void setApplyNo(String ApplyNo){this.ApplyNo.setValue(ApplyNo);}
    public String getApplyNo(){return this.ApplyNo.getValue();}
    
    public Field CaseNo;
    public void setCaseNo(String CaseNo){this.CaseNo.setValue(CaseNo);}
    public String getCaseNo(){return this.CaseNo.getValue();}
    
    public Field Document;
    public void setDocument(String Document){this.Document.setValue(Document);}
    public String getDocument(){return this.Document.getValue();}
    
    final int FRAME_HEIGHT = 140;

    public void init() {
        super.init();
        this.setProgramId("jsp.LegalPriority");
        this.setTableName("LegalPriority");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.Country = new Field("Country", this.getTableName());
        this.Country.setCheckEmpty(true);
        this.Country.setDbType("varchar(50)");

        this.PriorityDate = new Field("PriorityDate", this.getTableName());
        this.PriorityDate.setCheckEmpty(true);
        this.PriorityDate.setDbType("varchar(10)");
        
        this.ApplyNo = new Field("ApplyNo", this.getTableName());
        this.ApplyNo.setDbType("varchar(50)");
        
        this.CaseNo = new Field("CaseNo", this.getTableName());
        this.CaseNo.setDbType("varchar(50)");

        this.Document = new Field("Document", this.getTableName());
        this.Document.setDbType("nvarchar(100)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.Country);

        this.DbFields.add(this.PriorityDate);
        
        this.DbFields.add(this.ApplyNo);
        
        this.DbFields.add(this.CaseNo);

        this.DbFields.add(this.Document);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

        	this.PriorityDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

            this.Country.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Country.setSelectList(new Category().getChildList(this.Country));
            this.Country.setAnotherField(this.PriorityDate);
            this.Country.setColspan(1);
            rtnString += this.printHtml(this.Country);
            
            this.CaseNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.ApplyNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ApplyNo.setAnotherField(this.CaseNo);
            this.ApplyNo.setColspan(1);
            rtnString += this.printHtml(this.ApplyNo);
            
            this.Document.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.Document);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
        	LegalPriority preObj = (LegalPriority) userInfo.getObj(this.getTableName());
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
		String thText2="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.LegalPriority.Country")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.LegalPriority.PriorityDate")+"</td>";
		String thText4="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.LegalPriority.ApplyNo")+"</td>";
		String thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.LegalPriority.CaseNo")+"</td>";
		String thText6="<td align='center' width='40%'>"+this.getUserInfo().getMsg("jsp.LegalPriority.Document")+"</td>";
		String thText7=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText7 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+thText6+thText7+"</tr>");
		
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
			String Country = Cnstnts.EMPTY_STRING;
			String PriorityDate = Cnstnts.EMPTY_STRING;
			String ApplyNo = Cnstnts.EMPTY_STRING;
			String CaseNo = Cnstnts.EMPTY_STRING;
			String Document = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Country")){
					Country = field.getValue();
				}
				if(field.getName().equals("PriorityDate")){
					PriorityDate = field.getValue();
				}
				if(field.getName().equals("ApplyNo")){
					ApplyNo = field.getValue();
				}
				if(field.getName().equals("CaseNo")){
					CaseNo = field.getValue();
				}
				if(field.getName().equals("Document")){
					Document = field.getValue();
					if(Document.trim().length()>0){
						Document += "<input type='button' value='"+
									this.getUserInfo().getMsg("jsp.common.openFile")+"' "+
									"onClick='openAppendix(\""+Document+"\",\"PriorityDate\",600,400)'>";
					}
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+categoryPrpt.getProperty(Country)+"</td>";
			String tdText3="<td align='center'>"+PriorityDate+"</td>";
			String tdText4="<td>"+ApplyNo+"</td>";
			String tdText5="<td>"+CaseNo+"</td>";
			String tdText6="<td>"+Document+"</td>";
			String tdText7=Cnstnts.EMPTY_STRING;
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
				tdText7 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			String onClick = "";
			strBfr.append(newLine + "<tr"+bgColor+onClick+">"+printValue+"</tr>");
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

