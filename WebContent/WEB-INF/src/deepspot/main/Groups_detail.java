package deepspot.main;

import java.util.Iterator;
import java.util.List;

import deepspot.basic.Cnstnts;
import deepspot.basic.DetailBean;
import deepspot.basic.Field;
import deepspot.basic.SelectItem;

import deepspot.util.Util;

public class Groups_detail extends DetailBean{

	Field Emp_id;
	public void setEmp_id(String Emp_id){this.Emp_id.setValue(Emp_id);}
	public String getEmp_id(){return this.Emp_id.getValue();}

	Field JobTitle;
	public void setJobTitle(String JobTitle){this.JobTitle.setValue(JobTitle);}
	public String getJobTitle(){return this.JobTitle.getValue();}

	Field DateFrom;
	public void setDateFrom(String DateFrom){this.DateFrom.setValue(DateFrom);}
	public String getDateFrom(){return this.DateFrom.getValue();}

	Field DateTo;
	public void setDateTo(String DateTo){this.DateTo.setValue(DateTo);}
	public String getDateTo(){return this.DateTo.getValue();}
  
	public Groups_detail(){
		this.init();
	}

	public Groups_detail(String FlowKey) {
		this.init();
		this.FlowKey.setValue(FlowKey);
	}
	
	public void init() {
  		super.init();
		this.setProgramId("jsp.Groups_detail");
		this.setTableName("Groups_detail");

		this.Emp_id = new Field("Emp_id", this.getTableName());
		this.Emp_id.setCheckEmpty(true);
		
		this.JobTitle = new Field("JobTitle", this.getTableName());
		
		this.DateFrom = new Field("DateFrom", this.getTableName());
		
		this.DateTo = new Field("DateTo", this.getTableName());
		
		this.setDbFields();
	}
	
	public void setDbFields() {
		super.setDbFields();
		this.getDbFields().add(this.Emp_id);
		this.getDbFields().add(this.JobTitle);
		this.getDbFields().add(this.DateFrom);
		this.getDbFields().add(this.DateTo);
	}
	
	public String printMaintainTable() throws Exception{
  		String rtnString = Cnstnts.EMPTY_STRING;
  		
  		this.JobTitle.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
  		this.JobTitle.setSelectList(new Category().getChildList(this.JobTitle));
  		
  		this.Emp_id.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
  		this.Emp_id.setSelectList(new Employee().getList());
  		this.Emp_id.setColspan(1);
  		this.Emp_id.setAnotherField(this.JobTitle);
  		rtnString += this.printHtml(this.Emp_id);
  		
  		if(this.DateFrom.getValue().trim().length()==0 
  				|| this.DateTo.getValue().trim().length()==0){
  			Groups parent = (Groups)this.getUserInfo().getObj("Groups");
  			this.DateFrom.setValue(parent.getDateFrom());
  			this.DateTo.setValue(parent.getDateTo());
  		}
  		
  		this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
  		
  		this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
  		this.DateFrom.setAnotherField(this.DateTo);
  		this.DateFrom.setColspan(1);
  		rtnString += this.printHtml(this.DateFrom);
  		
		return rtnString;
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
			Groups parentObj = (Groups)userInfo.getObj("Groups");
			this.setDbFields();
			if(Cnstnts.INSERT.equals(this.getActionMode())){
				parentObj.getDetails().add(this.getDbFields());
			}
			if(Cnstnts.UPDATE.equals(this.getActionMode())){
				parentObj.getDetails().set(this.getRecordIndex(), this.getDbFields());
			}
		} else {
			if(Cnstnts.UPDATE.equals(this.getActionMode())){
				Groups parentObj = (Groups)userInfo.getObj("Groups");
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
  	
  	public List<SelectItem> getMemberList(String empId) throws Exception{
		String SQL = "select * from "+this.getTableName()+" where Emp_id='" + empId + "'" +
	    			 " and ('"+Util.getDate()+"' between DateFrom and DateTo)" +
	    			 " order by FlowKey,Seq_no";
		return this.getDbUtil().getSelectItemList(SQL, this.FlowKey, null);
	}
  
}