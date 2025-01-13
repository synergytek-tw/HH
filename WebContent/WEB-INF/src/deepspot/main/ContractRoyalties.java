package deepspot.main;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class ContractRoyalties extends MultiDetail {

    public ContractRoyalties(){this.init();}

    public ContractRoyalties(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field RoyaltiesType;
    public void setRoyaltiesType(String RoyaltiesType){this.RoyaltiesType.setValue(RoyaltiesType);}
    public String getRoyaltiesType(){return this.RoyaltiesType.getValue();}

    public Field Amount;
    public void setAmount(String Amount){this.Amount.setValue(Amount);}
    public String getAmount(){return this.Amount.getValue();}
    
    public Field Description;
    public void setDescription(String Description){this.Description.setValue(Description);}
    public String getDescription(){return this.Description.getValue();}
    
    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}
    
    public Field PaymentDate;
    public void setPaymentDate(String PaymentDate){this.PaymentDate.setValue(PaymentDate);}
    public String getPaymentDate(){return this.PaymentDate.getValue();}
    
    final int FRAME_HEIGHT = 140;

    public void init() {
        super.init();
        this.setProgramId("jsp.ContractRoyalties");
        this.setTableName("ContractRoyalties");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.RoyaltiesType = new Field("RoyaltiesType", this.getTableName());
        this.RoyaltiesType.setCheckEmpty(true);
        this.RoyaltiesType.setDbType("varchar(50)");
        
        this.Amount = new Field("Amount", this.getTableName());
        this.Amount.setDbType("int");

        this.Description = new Field("Description", this.getTableName());
        this.Description.setCheckEmpty(true);
        this.Description.setDbType("nvarchar(200)");
        
        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");
        
        this.PaymentDate = new Field("PaymentDate", this.getTableName());
        this.PaymentDate.setDbType("varchar(10)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.RoyaltiesType);

        this.DbFields.add(this.Amount);

        this.DbFields.add(this.Description);
        
        this.DbFields.add(this.Status);
        
        this.DbFields.add(this.PaymentDate);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

        	this.Description.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Description.setSize(80);
            rtnString += this.printHtml(this.Description);
        	
        	this.Amount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Amount.setSize(5);

            this.RoyaltiesType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.RoyaltiesType.setSelectList(new Category().getChildList(this.RoyaltiesType));
            this.RoyaltiesType.setAnotherField(this.Amount);
            rtnString += this.printHtml(this.RoyaltiesType);
            
            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("PatentStatus"));
            
            this.PaymentDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.PaymentDate.setAnotherField(this.Status);
            rtnString += this.printHtml(this.PaymentDate);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
        	ContractRoyalties preObj = (ContractRoyalties) userInfo.getObj(this.getTableName());
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
		String thText2="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.ContractRoyalties.RoyaltiesType")+"</td>";
		String thText3="<td align='center' width='45%'>"+this.getUserInfo().getMsg("jsp.ContractRoyalties.Description")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.ContractRoyalties.Amount")+"</td>";
		String thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.ContractRoyalties.Status")+"</td>";
		String thText6="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.ContractRoyalties.PaymentDate")+"</td>";
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
			String RoyaltiesType = Cnstnts.EMPTY_STRING;
			String Description = Cnstnts.EMPTY_STRING;
			String Amount = Cnstnts.EMPTY_STRING;
			String PaymentDate = Cnstnts.EMPTY_STRING;
			String Status = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("RoyaltiesType")){
					RoyaltiesType = field.getValue();
				}
				if(field.getName().equals("Description")){
					Description = field.getValue();
				}
				if(field.getName().equals("Amount")){
					Amount = field.getValue();
				}
				if(field.getName().equals("Status")){
					Status = field.getValue();
				}
				if(field.getName().equals("PaymentDate")){
					PaymentDate = field.getValue();
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+categoryPrpt.getProperty(RoyaltiesType)+"</td>";
			String tdText3="<td>"+Description+"</td>";
			String tdText4="<td align='right'>"+Amount+"</td>";
			String tdText5="<td>"+categoryPrpt.getProperty(Status)+"</td>";
			String tdText6="<td align='center'>"+PaymentDate+"</td>";
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