package deepspot.main;

import java.util.Iterator;
import java.util.List;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.html.Html;

public class DraftInventor extends MultiDetail {

    public DraftInventor(){this.init();}

    public DraftInventor(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field InventorId;
    public void setInventorId(String InventorId){this.InventorId.setValue(InventorId);}
    public String getInventorId(){return this.InventorId.getValue();}
    
    public Field InventorOrder;
    public void setInventorOrder(String InventorOrder){this.InventorOrder.setValue(InventorOrder);}
    public String getInventorOrder(){return this.InventorOrder.getValue();}
    
    public Field ChineseName;
    public void setChineseName(String ChineseName){this.ChineseName.setValue(ChineseName);}
    public String getChineseName(){return this.ChineseName.getValue();}
    
    public Field EnglishName;
    public void setEnglishName(String EnglishName){this.EnglishName.setValue(EnglishName);}
    public String getEnglishName(){return this.EnglishName.getValue();}

    public Field Email;
    public void setEmail(String Email){this.Email.setValue(Email);}
    public String getEmail(){return this.Email.getValue();}

    public Field Address;
    public void setAddress(String Address){this.Address.setValue(Address);}
    public String getAddress(){return this.Address.getValue();}
    
    public Field ContributionShare;
    public void setContributionShare(String ContributionShare){this.ContributionShare.setValue(ContributionShare);}
    public String getContributionShare(){return this.ContributionShare.getValue();}
    
    final int FRAME_HEIGHT = 180;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftInventor");
        this.setTableName("DraftInventor");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.InventorId = new Field("InventorId", this.getTableName());
        this.InventorId.setDbType("varchar(50)");
        
        this.InventorOrder = new Field("InventorOrder", this.getTableName());
        this.InventorOrder.setDbType("int");
        
        this.ChineseName = new Field("ChineseName", this.getTableName());
        this.ChineseName.setCheckEmpty(true);
        this.ChineseName.setDbType("varchar(50)");

        this.EnglishName = new Field("EnglishName", this.getTableName());
        this.EnglishName.setDbType("nvarchar(50)");
        
        this.Email = new Field("Email", this.getTableName());
        this.Email.setDbType("varchar(100)");
        
        this.Address = new Field("Address", this.getTableName());
        this.Address.setDbType("varchar(200)");
        
        this.ContributionShare = new Field("ContributionShare", this.getTableName());
        this.ContributionShare.setDbType("nvarchar(50)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.InventorId);
        this.DbFields.add(this.InventorOrder);
        this.DbFields.add(this.ChineseName);
        this.DbFields.add(this.EnglishName);
        this.DbFields.add(this.Email);
        this.DbFields.add(this.Address);
        this.DbFields.add(this.ContributionShare);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	rtnString += this.InventorId.printHiddenTag();
        	
        	if(this.getInventorOrder().trim().length()==0 
        			|| this.getInventorOrder().equals("0")){
        		this.setInventorOrder(this.getInventorOrderNum());
        	}
        	
        	this.ContributionShare.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ContributionShare.setSize(1);
        	this.ContributionShare.setAfterText("%");
        	this.ContributionShare.setButtonValue(this.getUserInfo().getMsg("jsp.DraftInventor.QueryInventor"));
            this.ContributionShare.setButtonClick("openAppendix(\"QueryForm.jsp?queryClass=Employee" +
            									  "&reflashTag=DraftInventor\",\"Employee\",800,600)");
            
            this.InventorOrder.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.InventorOrder.setSize(1);
            this.InventorOrder.setAnotherField(this.ContributionShare);
            rtnString += this.printHtml(this.InventorOrder);
            
            this.EnglishName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.EnglishName.setReadonly(true);

            this.ChineseName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.ChineseName.setReadonly(true);
            this.ChineseName.setAnotherField(this.EnglishName);
            rtnString += this.printHtml(this.ChineseName);
                		
            this.Email.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Email.setReadonly(true);
            this.Email.setSize(50);
            rtnString += this.printHtml(this.Email);

            this.Address.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Address.setReadonly(true);
            this.Address.setCols(60);
            this.Address.setRows(2);
            rtnString += this.printHtml(this.Address);
        }
        return rtnString;
    }

    private String getInventorOrderNum() {
		String SQL = "select count(*)+1 as OrderNum from DraftInventor where ParentId='"+this.getParentId()+"'";
		return this.getDbUtil().getFieldValue(SQL, new Field("OrderNum"));
	}

	public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftInventor preObj = (DraftInventor) userInfo.getObj(this.getTableName());
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
	public String printDraftInventors(UserBean userInfo, String parentId) throws Exception {
		StringBuffer strBfr = new StringBuffer();
		
		boolean canAssesFlag = false;
		Draft parentObj = (Draft)userInfo.getObj("Draft");
		if(parentObj!=null && parentObj.canEdit()){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='5%'>"+userInfo.getMsg("jsp.DraftInventor.InventorOrder")+"</td>";
		String thText3="<td align='center' width='12%'>"+userInfo.getMsg("jsp.DraftInventor.ChineseName")+"</td>";
		String thText4="<td align='center' width='12%'>"+userInfo.getMsg("jsp.DraftInventor.EnglishName")+"</td>";
		String thText5="<td align='center' width='23%'>"+userInfo.getMsg("jsp.DraftInventor.Email")+"</td>";
		String thText6="<td align='center' width='33%'>"+userInfo.getMsg("jsp.DraftInventor.Address")+"</td>";
		String thText7="<td align='center' width='10%'>"+userInfo.getMsg("jsp.DraftInventor.ContributionShare")+"</td>";
		String thText8=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+userInfo.getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(\"" + this.getTableName() +"\",\"insert\",\""+
							 parentId+"\","+this.FRAME_HEIGHT+",\"updateDraftInventorDiv" +"\",\"DraftInventorDiv\""+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText8 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+
									thText4+thText5+thText6+thText7+thText8+"</tr>");
		
		String SQL = "select * from DraftInventor where ParentId='"+parentId+"' "+
					 "order by InventorOrder";
		DraftInventor inventors = new DraftInventor();
		inventors.setDbFields();
		List<Field> fieldList = inventors.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			DraftInventor obj = new DraftInventor();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals(obj.FlowKey.getName())){
					obj.FlowKey.setValue(field.getValue());
				}
				if(field.getName().equals(obj.InventorId.getName())){
					obj.InventorId.setValue(field.getValue());
				}
				if(field.getName().equals(obj.InventorOrder.getName())){
					obj.InventorOrder.setValue(field.getValue());
				}
				if(field.getName().equals(obj.ChineseName.getName())){
					obj.ChineseName.setValue(field.getValue());
				}
				if(field.getName().equals(obj.EnglishName.getName())){
					obj.EnglishName.setValue(field.getValue());
				}
				if(field.getName().equals(obj.Address.getName())){
					obj.Address.setValue(field.getValue());
				}
				if(field.getName().equals(obj.Email.getName())){
					obj.Email.setValue(field.getValue());
				}
				if(field.getName().equals(obj.ContributionShare.getName())){
					obj.ContributionShare.setValue(field.getValue());
				}
			}
			String onClick = " onClick='openAppendix(\"Employee.jsp?flowKey="+obj.getInventorId()+
			  					"&_dbActionMode=query&getDataFlag=true&_pageActionMode=maintain"+
			  					"\",\"Employee\",800,600)' style='cursor:hand'";
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td align='center'>"+obj.getInventorOrder()+"</td>";
			String tdText3="<td"+onClick+">"+obj.getChineseName()+"</td>";
			String tdText4="<td>"+obj.getEnglishName()+"</td>";
			String tdText5="<td>"+obj.getEmail()+"</td>";
			String tdText6="<td>"+obj.getAddress()+"</td>";
			String tdText7="<td align='center'>"+obj.getContributionShare()+"%"+"</td>";
			String tdText8=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+userInfo.getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(\"" + this.getTableName() +"\",\"update\",\""+
								 		obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftInventorDiv" +"\",\"DraftInventorDiv\""+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+userInfo.getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(\"" + this.getTableName() +"\",\"delete\",\""+
				 						obj.getFlowKey()+"\","+this.FRAME_HEIGHT+",\"updateDraftInventorDiv" +"\",\"DraftInventorDiv\""+")'/>";
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
			String cancelBtn = "<input type='button' onClick='parent.closeTabFrame(\"updateDraftInventorDiv" +"\",\"DraftInventorDiv\")' value='"+
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
    	this.setDoSearchFlag(Cnstnts.TRUE_FLAG);
		this.setPageActionMode(Cnstnts.SEARCH);
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printDraftInventors(userInfo, parentId);
    }
    
}