package deepspot.main;

import java.util.Iterator;
import java.util.List;

import deepspot.basic.Cnstnts;
import deepspot.basic.DetailBean;
import deepspot.basic.Field;
import deepspot.basic.SelectItem;
import deepspot.util.Util;

public class Notice_detail extends DetailBean {

	Field AuthorityType;
	public void setAuthorityType(String AuthorityType){
		this.AuthorityType.setValue(AuthorityType);
	}
	public String getAuthorityType(){
		return this.AuthorityType.getValue();
	}

	Field AuthorityId;
	public void setAuthorityId(String AuthorityId){
		this.AuthorityId.setValue(AuthorityId);
	}
	public String getAuthorityId(){
		return this.AuthorityId.getValue();
	}
	
	Field OrderId;
	public void setOrderId(String OrderId){
		this.OrderId.setValue(OrderId);
	}
	public String getOrderId(){
		return this.OrderId.getValue();
	}
	
	public Notice_detail(){
		this.init();
	}

	public Notice_detail(String FlowKey) {
		this.init();
		this.FlowKey.setValue(FlowKey);
	}
	
	public void init() {
  		super.init();
		this.setProgramId("jsp.Notice_detail");
		this.setTableName("Notice_detail");

		this.AuthorityType = new Field("AuthorityType", this.getTableName());
		this.AuthorityType.setCheckEmpty(true);
		
		this.AuthorityId = new Field("AuthorityId", this.getTableName());
		
		this.OrderId = new Field("OrderId", this.getTableName());
		
		this.setDbFields();
	}
	
	public void setDbFields() {
		super.setDbFields();
		this.getDbFields().add(this.AuthorityType);
		if(this.AuthorityType.getValue().equals("All")){
  			this.AuthorityId.setCheckEmpty(false);
  		} else {
  			this.AuthorityId.setCheckEmpty(true);
  		}
		this.getDbFields().add(this.AuthorityId);
  		this.getDbFields().add(this.OrderId);
	}
	
	public String printMaintainTable() throws Exception{
  		String rtnString = Cnstnts.EMPTY_STRING;
  		
  		this.OrderId.setHtmlType(Cnstnts.HTML_TAG_TEXT);
  		rtnString += this.printHtml(this.OrderId);
  		
  		if(this.AuthorityType.getValue().equals("All") 
  				|| this.AuthorityType.getValue().trim().length()==0){
  			this.AuthorityId.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
  			this.AuthorityId.setValue(Cnstnts.EMPTY_STRING);
  			this.AuthorityId.setCheckEmpty(false);
  		} else {
  			this.AuthorityId.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
  			this.AuthorityId.setCheckEmpty(true);
  			if(this.AuthorityType.getValue().equals("Department")){
  				this.AuthorityId.setSelectList(new Department().getRootTreeList());
  			}
  			if(this.AuthorityType.getValue().equals("Employee")){
  				this.AuthorityId.setSelectList(new Employee().getList());
  			}
  			if(this.AuthorityType.getValue().equals("Groups")){
  				this.AuthorityId.setSelectList(new Groups().getList());
  			}
  		}
  		
  		this.AuthorityType.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
  		this.AuthorityType.setSelectList(new Category().getChildList(this.AuthorityType));
  		this.AuthorityType.setOnChange("setValue()");
  		this.AuthorityType.setAnotherField(this.AuthorityId);
  		rtnString += this.printHtml(this.AuthorityType);
  		
		return rtnString;
  	}
	
	public List<List<Field>> getDetails(String FlowKey){
	    String SQL = "select * from "+this.getTableName()+" where FlowKey='" +
	    			 FlowKey+"' order by OrderId";
	    return this.getDbUtil().getFieldsList(SQL, this.getDbFields());
	}
  
	public List<SelectItem> getMemberList(String empId) throws Exception{
		String SQL = "select * from "+this.getTableName()+" where Emp_id='" + empId + "'" +
	    			 " and ('"+Util.getDate()+"' between DateFrom and DateTo)" +
	    			 " order by FlowKey,Seq_no";
		return this.getDbUtil().getSelectItemList(SQL, this.FlowKey, null);
	}
  
  	@SuppressWarnings("unchecked")
	public void doAction(UserBean userInfo) throws Exception{
		this.setUserInfo(userInfo);
		if(this.onBtnSubmit()){
			if(this.checkFieldEmptyError()){
				return;
			} else {
				if(this.checkHasAnotherError()){
					return;
				} else {
					this.setCloseFlag(true);
				}
			}
			Notice parentObj = (Notice)userInfo.getObj("Notice");
			if(parentObj==null) parentObj = new Notice();
			this.setDbFields();
			if(Cnstnts.INSERT.equals(this.getActionMode())){
				parentObj.getDetails().add(this.getDbFields());
			}
			if(Cnstnts.UPDATE.equals(this.getActionMode())){
				parentObj.getDetails().set(this.getRecordIndex(), this.getDbFields());
			}
		} else {
			if(Cnstnts.UPDATE.equals(this.getActionMode()) && this.FirstFlag()){
				Notice parentObj = (Notice)userInfo.getObj("Notice");
				if(parentObj==null) parentObj = new Notice();
				parentObj.setDbFields();
				List<Field> parentFields = (List<Field>)parentObj.getDetails()
											.get(this.getRecordIndex());
				this.setDbFields();
				for(Iterator parentFieldsItr=parentFields.iterator();
												parentFieldsItr.hasNext();){
					Field parentField = (Field)parentFieldsItr.next();
					if(parentField!=null){
						for(Iterator thisFieldsItr=this.getDbFields().
								iterator();thisFieldsItr.hasNext();){
							Field thisField = (Field)thisFieldsItr.next();
							if(thisField!=null 
									&& thisField.getName().equals(parentField.getName())){
								thisField.setValue(parentField.getValue());
							}
						}
					}
				}
			}
		}
	}
  	
  	private boolean checkHasAnotherError() throws Exception{
  		return false;
  	}
	
}