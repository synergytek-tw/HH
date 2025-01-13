package deepspot.main;

import java.util.Iterator;
import java.util.List;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class TrademarkApplicant extends MultiDetail {

    public TrademarkApplicant(){this.init();}

    public TrademarkApplicant(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field ApplicantOrder;
    public void setApplicantOrder(String ApplicantOrder){this.ApplicantOrder.setValue(ApplicantOrder);}
    public String getApplicantOrder(){return this.ApplicantOrder.getValue();}

    public Field ApplicantId;
    public void setApplicantId(String ApplicantId){this.ApplicantId.setValue(ApplicantId);}
    public String getApplicantId(){return this.ApplicantId.getValue();}

    public Field ApplicantName;
    public void setApplicantName(String ApplicantName){this.ApplicantName.setValue(ApplicantName);}
    public String getApplicantName(){return this.ApplicantName.getValue();}
    
    final int FRAME_HEIGHT = 120;

    public void init() {
        super.init();
        this.setProgramId("jsp.TrademarkApplicant");
        this.setTableName("TrademarkApplicant");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.ApplicantOrder = new Field("ApplicantOrder", this.getTableName());
        this.ApplicantOrder.setDbType("varchar(50)");

        this.ApplicantId = new Field("ApplicantId", this.getTableName());
        this.ApplicantId.setCheckEmpty(true);
        this.ApplicantId.setDbType("varchar(50)");

        this.ApplicantName = new Field("ApplicantName", this.getTableName());
        this.ApplicantName.setDbType("nvarchar(100)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.ApplicantOrder);

        this.DbFields.add(this.ApplicantId);

        this.DbFields.add(this.ApplicantName);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

            this.ApplicantOrder.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ApplicantOrder.setSize(1);
            rtnString += this.printHtml(this.ApplicantOrder);
            //rtnString += this.printHtml(this.ParentId);
            this.ApplicantName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ApplicantName.setSize(40);
            String whereStr = Cnstnts.EMPTY_STRING;
    		
    		whereStr =" where FlowKey='"+this.getParentId() + "'";
    		
    		String SQL="select * from Trademarkcase"+
    					whereStr;
    		//Field Client=new Field()
    		Field Client;
    		Client= new Field("Client","patentcase");
    		Client.setDbType("NVarchar,100");
    		Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
    		String ClientID = Cnstnts.EMPTY_STRING;
    		ClientID= this.getDbUtil().getFieldValue(SQL, Client);
    		Client.setValue(SQL);
    		//rtnString+=this.printHtml(Client);
            this.ApplicantName.setButtonValue(this.getUserInfo().getMsg("jsp.PatentApplicant.QueryApplicant"));
            this.ApplicantName.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=Applicant" +
            		"&submitFlag=true&QueryText4=" + ClientID  +"\",\"Applicant\",800,600)");

            this.ApplicantId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ApplicantId.setSize(10);
            this.ApplicantId.setAnotherField(this.ApplicantName);
            rtnString += this.printHtml(this.ApplicantId);

        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            TrademarkApplicant preObj = (TrademarkApplicant) userInfo.getObj(this.getTableName());
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
		String thText2="<td align='center' width='5%'>"+this.getUserInfo().getMsg("jsp.TrademarkApplicant.ApplicantOrder")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.FlowKey")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Applicant.Nationality")+"</td>";
		String thText5="<td align='center' width='28%'>"+this.getUserInfo().getMsg("jsp.Applicant.Names")+"</td>";
		String thText6="<td align='center' width='27%'>"+this.getUserInfo().getMsg("jsp.Applicant.EnglishNames")+"</td>";
		String thText7="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Applicant.IdNo")+"</td>";
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
		
		String SQL = "select pa.FlowKey as ApplicantId, pa.ApplicantOrder, a.* "+
		 			 "from TrademarkApplicant pa inner join Applicant a "+
		 			 "on pa.ApplicantId=a.FlowKey where pa.ParentId='"+this.getParentId()+"' "+
		 			 "order by pa.ApplicantOrder";
		Applicant applicant = new Applicant();
		applicant.setDbFields();
		List<Field> fieldList = applicant.getDbFields();
		fieldList.add(this.ApplicantId);
		fieldList.add(this.ApplicantOrder);
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator<List<Field>> itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String ApplicantOrder = Cnstnts.EMPTY_STRING;
			String ApplicantId = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String Nationality = Cnstnts.EMPTY_STRING;
			String Names = Cnstnts.EMPTY_STRING;
			String EnglishNames = Cnstnts.EMPTY_STRING;
			String IdNo = Cnstnts.EMPTY_STRING;
			for(Iterator<Field> fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("ApplicantOrder")){
					ApplicantOrder = field.getValue();
				}
				if(field.getName().equals("ApplicantId")){
					ApplicantId = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Nationality")){
					Nationality = field.getValue();
				}
				if(field.getName().equals("Names")){
					Names = field.getValue();
				}
				if(field.getName().equals("EnglishNames")){
					EnglishNames = field.getValue();
				}
				if(field.getName().equals("IdNo")){
					IdNo = field.getValue();
				}
			}
			String onClick = " onClick='openAppendix(\"Applicant.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=query&getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"TrademarkApplicant\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'>"+ApplicantOrder+"</td>";
			String tdText3="<td"+onClick+">"+FlowKey+"</td>";
			String tdText4="<td align='center'>"+Nationality+"</td>";
			String tdText5="<td>"+Names+"</td>";
			String tdText6="<td>"+EnglishNames+"</td>";
			String tdText7="<td>"+IdNo+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(getElementById(\"tabText\").value,\"update\",\""+
								 		ApplicantId+"\","+this.FRAME_HEIGHT+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(getElementById(\"tabText\").value,\"delete\",\""+
				 						ApplicantId+"\","+this.FRAME_HEIGHT+")'/>";
				tdText8 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8;
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
