package deepspot.main;

import java.util.Iterator;
import java.util.List;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class TrademarkAttorney extends MultiDetail {

    public TrademarkAttorney(){this.init();}

    public TrademarkAttorney(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field AttorneyType;
    public void setAttorneyType(String AttorneyType){this.AttorneyType.setValue(AttorneyType);}
    public String getAttorneyType(){return this.AttorneyType.getValue();}

    public Field Attorney;
    public void setAttorney(String Attorney){this.Attorney.setValue(Attorney);}
    public String getAttorney(){return this.Attorney.getValue();}

    public Field AttorneyName;
    public void setAttorneyName(String AttorneyName){this.AttorneyName.setValue(AttorneyName);}
    public String getAttorneyName(){return this.AttorneyName.getValue();}
    
    final int FRAME_HEIGHT = 120;

    public void init() {
        super.init();
        this.setProgramId("jsp.TrademarkAttorney");
        this.setTableName("TrademarkAttorney");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.AttorneyType = new Field("AttorneyType", this.getTableName());
        this.AttorneyType.setDbType("varchar(50)");

        this.Attorney = new Field("Attorney", this.getTableName());
        this.Attorney.setCheckEmpty(true);
        this.Attorney.setDbType("varchar(50)");

        this.AttorneyName = new Field("AttorneyName", this.getTableName());
        this.AttorneyName.setDbType("nvarchar(100)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.AttorneyType);

        this.DbFields.add(this.Attorney);

        this.DbFields.add(this.AttorneyName);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

            this.AttorneyType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.AttorneyType.setSelectList(new Category().getChildList(this.AttorneyType));
            rtnString += this.printHtml(this.AttorneyType);
            
            this.AttorneyName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.AttorneyName.setSize(40);
            this.AttorneyName.setButtonValue(this.getUserInfo().getMsg("jsp.PatentAttorney.QueryAttorney"));
            this.AttorneyName.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=Attorney" +
            		"&submitFlag=true\",\"Attorney\",800,600)");

            this.Attorney.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Attorney.setSize(10);
            this.Attorney.setAnotherField(this.AttorneyName);
            rtnString += this.printHtml(this.Attorney);

        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            TrademarkAttorney preObj = (TrademarkAttorney) userInfo.getObj(this.getTableName());
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
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentAttorney.AttorneyType")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Attorney.FlowKey")+"</td>";
		String thText4="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.Attorney.Nationality")+"</td>";
		String thText5="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.Attorney.Firm")+"</td>";
		String thText6="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.Attorney.FullName")+"</td>";
		String thText7="<td align='center' width='12%'>"+this.getUserInfo().getMsg("jsp.Attorney.Contact")+"</td>";
		String thText8="<td align='center' width='13%'>"+this.getUserInfo().getMsg("jsp.Attorney.Tel1")+"</td>";
		String thText9=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText9 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+
									thText4+thText5+thText6+thText7+thText8+thText9+"</tr>");
		
		String SQL = "select pa.FlowKey as Attorney, c.Names as AttorneyType, a.* "+
					 "from TrademarkAttorney pa "+
					 "inner join Attorney a on pa.Attorney=a.FlowKey "+
					 "left join Category c on pa.AttorneyType=c.FlowKey "+
					 "where pa.ParentId='"+this.getParentId()+"' "+
					 "order by pa.FlowKey";
		Attorney attorney = new Attorney();
		attorney.setDbFields();
		List<Field> fieldList = attorney.getDbFields();
		fieldList.add(this.Attorney);
		fieldList.add(this.AttorneyType);
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String Attorney = Cnstnts.EMPTY_STRING;
			String AttorneyType = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String Nationality = Cnstnts.EMPTY_STRING;
			String Firm = Cnstnts.EMPTY_STRING;
			String LastName = Cnstnts.EMPTY_STRING;
			String FirstName = Cnstnts.EMPTY_STRING;
			String Contact = Cnstnts.EMPTY_STRING;
			String Tel1 = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("Attorney")){
					Attorney = field.getValue();
				}
				if(field.getName().equals("AttorneyType")){
					AttorneyType = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Nationality")){
					Nationality = field.getValue();
				}
				if(field.getName().equals("Firm")){
					Firm = field.getValue();
				}
				if(field.getName().equals("FirstName")){
					FirstName = field.getValue();
				}
				if(field.getName().equals("LastName")){
					LastName = field.getValue();
				}
				if(field.getName().equals("Contact")){
					Contact = field.getValue();
				}
				if(field.getName().equals("Tel1")){
					Tel1 = field.getValue();
				}
			}
			String onClick = " onClick='openAppendix(\"Attorney.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=query&getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'>"+AttorneyType+"</td>";
			String tdText3="<td"+onClick+">"+FlowKey+"</td>";
			String tdText4="<td align='center'>"+Nationality+"</td>";
			String tdText5="<td>"+Firm+"</td>";
			String tdText6="<td>"+LastName+FirstName+"</td>";
			String tdText7="<td>"+Contact+"</td>";
			String tdText8="<td>"+Tel1+"</td>";
			String tdText9=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(getElementById(\"tabText\").value,\"update\",\""+
								 		Attorney+"\","+this.FRAME_HEIGHT+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(getElementById(\"tabText\").value,\"delete\",\""+
				 						Attorney+"\","+this.FRAME_HEIGHT+")'/>";
				tdText9 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8+tdText9;
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
