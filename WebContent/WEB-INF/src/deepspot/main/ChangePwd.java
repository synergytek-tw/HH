package deepspot.main;

import java.util.Iterator;
import java.util.List;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.SelectItem;

public class ChangePwd extends Account {

	private String ObjectName;
	
	public void setObjetName(String ObjectName){
		this.ObjectName = ObjectName;
	}
	
	public String getObjectName(){
		return this.ObjectName;
	}
	
	public Field SrcPassword;

	public void setSrcPassword(String SrcPassword) {
		this.SrcPassword.setValue(SrcPassword);
	}

	public String getSrcPassword() {
		return this.SrcPassword.getValue();
	}
	
	public Field NewPassword;

	public void setNewPassword(String NewPassword) {
		this.NewPassword.setValue(NewPassword);
	}

	public String getNewPassword() {
		return this.NewPassword.getValue();
	}
	
	public Field ConformPassword;

	public void setConformPassword(String ConformPassword) {
		this.ConformPassword.setValue(ConformPassword);
	}

	public String getConformPassword() {
		return this.ConformPassword.getValue();
	}

	public ChangePwd() {
		this.init();
		this.getAttribute();
	}

	public ChangePwd(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.changePwd");
		this.setObjetName("ChangePwd");

		this.SrcPassword = new Field("SrcPassword", this.ObjectName);
		this.SrcPassword.setCheckEmpty(true);
		
		this.NewPassword = new Field("NewPassword", this.ObjectName);
		this.NewPassword.setCheckEmpty(true);
		
		this.ConformPassword = new Field("ConformPassword", this.ObjectName);
		this.ConformPassword.setCheckEmpty(true);
		
		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
	}

	public String printSearchTable() throws Exception {
		return Cnstnts.EMPTY_STRING;
	}
	
	public List<SelectItem> getList(){
		return null;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {
			this.Password.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
			rtnString += this.printTag(this.Password);
			
			this.OpenMenu.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
			rtnString += this.printTag(this.OpenMenu);
			
			this.Language.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
			rtnString += this.printTag(this.Language);

			this.Emp_id.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
			rtnString += this.printTag(this.Emp_id);

			this.EffectDateTo.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
			rtnString += this.printTag(this.EffectDateTo);

			this.EffectDateFrom.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
			rtnString += this.printTag(this.EffectDateFrom);
			
			this.SrcPassword.setHtmlType(Cnstnts.HTML_TAG_PASSWORD);
			rtnString += this.printHtml(this.SrcPassword);
			
			this.NewPassword.setHtmlType(Cnstnts.HTML_TAG_PASSWORD);
			rtnString += this.printHtml(this.NewPassword);
			
			this.ConformPassword.setHtmlType(Cnstnts.HTML_TAG_PASSWORD);
			rtnString += this.printHtml(this.ConformPassword);			
		}
		return rtnString;
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			ChangePwd preObj = (ChangePwd) userInfo.getObj(this.ObjectName);
			if(preObj!=null){
				this.setSearchResult(preObj.getSearchResult());
			}
		}
	}

	public boolean checkUpdateError() throws Exception {
		if(super.checkInsertError()){
			return true;
		} else {
			if(!this.SrcPassword.getValue().equals(this.Password.getValue())){
				this.setErrorMessage(this.getErrorMessage(this.SrcPassword));
				return true;
			} else
			if(!this.ConformPassword.getValue().equals(this.NewPassword.getValue())){
				this.setErrorMessage(this.getErrorMessage(this.ConformPassword));
				return true;
			} else {
				this.setPassword(this.NewPassword.getValue());
			}
			return false;
		}
	}
	
	public boolean checkFieldEmptyError() throws Exception{
		super.checkFieldEmptyError();  
		this.setDbFields();
		List<Field> chkList = this.getDbFields();
		chkList.add(this.NewPassword);
		chkList.add(this.ConformPassword);
		chkList.add(this.SrcPassword);
		for(Iterator<Field> itr=chkList.iterator();itr.hasNext();){
			Field field = (Field)itr.next();
			if(field.checkEmpty()){
				if(field.getValue().trim().length()==0){
					String errorMsg = this.getUserInfo().getMsg(this.getProgramId()+"."+
							field.getName())+this.getUserInfo().getMsg("jsp.common.EmptyError");
					this.setErrorMessage(errorMsg);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean dbExecute() throws Exception {
		boolean rtnFlag = super.dbExecute();
		if(rtnFlag){
			this.setMessage(this.getUserInfo().getMsg("jsp.changePwd.saved"));
		}
		return rtnFlag;
	}

}