package deepspot.main;

import java.util.Iterator;
import java.util.List;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class PatentInventor extends MultiDetail {

    public PatentInventor(){this.init();}

    public PatentInventor(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field InventorType;
    public void setInventorType(String InventorType){this.InventorType.setValue(InventorType);}
    public String getInventorType(){return this.InventorType.getValue();}
    
    public Field InventorOrder;
    public void setInventorOrder(String InventorOrder){this.InventorOrder.setValue(InventorOrder);}
    public String getInventorOrder(){return this.InventorOrder.getValue();}
    
    public Field ContributionShare;
    public void setContributionShare(String ContributionShare){this.ContributionShare.setValue(ContributionShare);}
    public String getContributionShare(){return this.ContributionShare.getValue();}

    public Field Inventor;
    public void setInventor(String Inventor){this.Inventor.setValue(Inventor);}
    public String getInventor(){return this.Inventor.getValue();}

    public Field InventorName;
    public void setInventorName(String InventorName){this.InventorName.setValue(InventorName);}
    public String getInventorName(){return this.InventorName.getValue();}
    
    final int FRAME_HEIGHT = 120;

    public void init() {
        super.init();
        this.setProgramId("jsp.PatentInventor");
        this.setTableName("PatentInventor");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.InventorType = new Field("InventorType", this.getTableName());
        this.InventorType.setDbType("varchar(50)");
        
        this.InventorOrder = new Field("InventorOrder", this.getTableName());
        this.InventorOrder.setDbType("varchar(20)");
        
        this.ContributionShare = new Field("ContributionShare", this.getTableName());
        this.ContributionShare.setDbType("int");

        this.Inventor = new Field("Inventor", this.getTableName());
        this.Inventor.setCheckEmpty(true);
        this.Inventor.setDbType("varchar(50)");

        this.InventorName = new Field("InventorName", this.getTableName());
        this.InventorName.setDbType("nvarchar(100)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.InventorType);
        
        this.DbFields.add(this.InventorOrder);
        
        this.DbFields.add(this.ContributionShare);

        this.DbFields.add(this.Inventor);

        this.DbFields.add(this.InventorName);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	
        	this.ContributionShare.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ContributionShare.setSize(1);

            this.InventorType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.InventorType.setSelectList(new Category().getChildList(this.InventorType));
            this.InventorType.setAnotherField(this.ContributionShare);
            
            this.InventorOrder.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InventorOrder.setSize(1);
            this.InventorOrder.setAnotherField(this.InventorType);
            rtnString += this.printHtml(this.InventorOrder);
            
            String whereStr = Cnstnts.EMPTY_STRING;
    		
    		whereStr =" where FlowKey='"+this.getParentId() + "'";
    		
    		String SQL="select * from patentcase"+
    					whereStr;
    		//Field Client=new Field()
    		Field Client;
    		Client= new Field("Client","patentcase");
    		Client.setDbType("NVarchar,100");
    		Client.setHtmlType(Cnstnts.HTML_TAG_TEXT);
    		String ClientID = Cnstnts.EMPTY_STRING;
    		ClientID= this.getDbUtil().getFieldValue(SQL, Client);
    		Client.setValue(SQL);
    		
            this.InventorName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InventorName.setSize(40);
            this.InventorName.setButtonValue(this.getUserInfo().getMsg("jsp.PatentInventor.QueryInventor"));
            this.InventorName.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=Inventors" +
            		"&submitFlag=true&QueryText4=" + ClientID +"\",\"Inventors\",800,600)");

            this.Inventor.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Inventor.setSize(10);
            this.Inventor.setAnotherField(this.InventorName);
            rtnString += this.printHtml(this.Inventor);

        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            PatentInventor preObj = (PatentInventor) userInfo.getObj(this.getTableName());
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
		PatentCase parentObj = (PatentCase)this.getUserInfo().getObj("PatentCase");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE) 
				&& parentObj.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='5%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.InventorOrder")+"</td>";
		String thText3="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.InventorType")+"</td>";
		String thText4="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.Inventors.FlowKey")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.Inventors.Nationality")+"</td>";
		String thText6="<td align='center' width='25%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.Names")+"</td>";
		String thText7="<td align='center' width='25%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.EnglishNames")+"</td>";
		String thText8="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentInventor.ContributionShare")+"</td>";
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
		
		String SQL = "select pi.FlowKey as Inventor, c.Names as InventorType, "+
							"pi.InventorOrder, pi.ContributionShare, e.* "+
					 "from PatentInventor pi "+
					 "inner join Employee e on pi.Inventor=e.FlowKey "+
					 "inner join Category c on pi.InventorType=c.FlowKey "+
					 "where pi.ParentId='"+this.getParentId()+"' "+
					 "order by pi.InventorOrder";
		Employee inventors = new Employee();
		inventors.setDbFields();
		List<Field> fieldList = inventors.getDbFields();
		fieldList.add(this.Inventor);
		fieldList.add(this.InventorOrder);
		fieldList.add(this.InventorType);
		fieldList.add(this.ContributionShare);
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String Inventor = Cnstnts.EMPTY_STRING;
			String InventorOrder = Cnstnts.EMPTY_STRING;
			String InventorType = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String Nationality = Cnstnts.EMPTY_STRING;
			String Emp_name = Cnstnts.EMPTY_STRING;
			String EngName = Cnstnts.EMPTY_STRING;
			String ContributionShare = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("Inventor")){
					Inventor = field.getValue();
				}
				if(field.getName().equals("InventorType")){
					InventorType = field.getValue();
				}
				if(field.getName().equals("InventorOrder")){
					InventorOrder = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("Nationality")){
					Nationality = field.getValue();
				}
				if(field.getName().equals("Emp_name")){
					Emp_name = field.getValue();
				}
				if(field.getName().equals("EngName")){
					EngName = field.getValue();
				}
				if(field.getName().equals("ContributionShare")){
					ContributionShare = field.getValue();
				}
			}
			String onClick = " onClick='openAppendix(\"Employee.jsp?flowKey="+FlowKey+
			  					"&_dbActionMode=query&getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"PatentApplicant\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'>"+InventorOrder+"</td>";
			String tdText3="<td align='center'>"+InventorType+"</td>";
			String tdText4="<td"+onClick+">"+FlowKey+"</td>";
			String tdText5="<td align='center'>"+Nationality+"</td>";
			String tdText6="<td>"+Emp_name+"</td>";
			String tdText7="<td>"+EngName+"</td>";
			String tdText8="<td align='center'>"+ContributionShare+"%</td>";
			String tdText9=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(getElementById(\"tabText\").value,\"update\",\""+
								 		Inventor+"\","+this.FRAME_HEIGHT+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(getElementById(\"tabText\").value,\"delete\",\""+
				 						Inventor+"\","+this.FRAME_HEIGHT+")'/>";
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