package deepspot.basic;

import java.util.List;
import java.util.Properties;

import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.html.SelectOneTag;
import deepspot.main.FlowEngin;
import deepspot.main.Program;
import deepspot.main.UserBean;
import deepspot.util.Util;

public class MultiDetail extends MasterBean{

	public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}
    
    final int FRAME_HEIGHT = 120;
    
    private String parentClassName;
    public void setParentClassName(String parentClassName){
    	this.parentClassName = parentClassName;
    }
    public String getParentClassName(){
    	return this.parentClassName;
    }
    
    private String parentFlowKey;
    public void setparentFlowKey(String parentFlowKey){
    	this.parentFlowKey = parentFlowKey;
    }
    public String getparentFlowKey(){
    	return this.parentFlowKey;
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	if(this.ParentId==null){
        		this.ParentId = new Field("ParentId",this.getTableName());
        	}
            rtnString += this.ParentId.printHiddenTag();
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        }
        return rtnString;
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        return this.doSearch(whereStr);
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
			String cancelBtn = "<input type='button' onClick='parent.closeTabFrame()' value='"+
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
    
    protected String getPageTitle() throws Exception {
		if (this.getUserInfo() == null || this.getProgramId().trim().length() == 0)
			return Cnstnts.EMPTY_STRING;
		String title = getUserInfo().getProgramName(this.getProgramId());
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())) {
			if (this.getDbActionMode().equals(Cnstnts.INSERT)) {
				title = getUserInfo().getMsg("jsp.function.insert")+title;
			} else if (this.getDbActionMode().equals(Cnstnts.UPDATE)) {
				title = getUserInfo().getMsg("jsp.function.update")+title;
			} else if (this.getDbActionMode().equals(Cnstnts.DELETE)) {
				title = getUserInfo().getMsg("jsp.function.delete")+title;
			}
		}
		return title;
	}
    
    protected String getDbActionSelectItem() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;

		if ((Cnstnts.TRUE_FLAG.equals(this.getModeLockFlag()) 
				&& !this.getProgramMode().equals("M"))
					|| Cnstnts.MAINTAIN.equals(this.getPageActionMode())
						|| Cnstnts.SEARCH.equals(this.getDbActionMode())) {
			return new HiddenTag("dbActionMode", this.getDbActionMode()).toString();
		}
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())
				&& this.getDbActionList() == null) {
			this.setDbActionList(this.getUserInfo().getDbActionList(this.parentClassName));
		}

		SelectOneTag selectItem = new SelectOneTag(Cnstnts.DB_ACTION_MODE,
				Cnstnts.SET_VALUE, this.getDbActionMode(), this.getDbActionList());

		rtnString = selectItem.toString();

		return rtnString;
	}
    
    protected String getSearchReasult(UserBean userInfo,String parentId) throws Exception {
    	this.setDoSearchFlag(Cnstnts.TRUE_FLAG);
		this.setPageActionMode(Cnstnts.SEARCH);
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasult();
    }
    
    protected String getDataAuthorityWhereSQL(String whereStr) throws Exception {
		return whereStr;
	}
    
    protected boolean canUpdate(){
    	return false;
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.ParentId);
    }
    
    public String printSearchReasult() throws Exception {
		return null;
	}
    
    protected void setSearchListPrpts() {
        Field[] showField = {this.FlowKey};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }
    
    public void doAction(UserBean userInfo) throws Exception {
		this.setUserInfo(userInfo);
		if (this.getApplicant().trim().length() == 0 || this.canEdit()) {
			this.setApplicant(userInfo.getAttribute("emp_id"));
		}
		if (this.getCreateDept().trim().length() == 0 || this.canEdit()) {
			this.setCreateDept(userInfo.getAttribute("dept_id"));
		}
		if (!this.getModeLockFlag().equals(Cnstnts.TRUE_FLAG)) {
			if (this.getProgramMode().equals("M")) {
				this.setPageActionMode(Cnstnts.MAINTAIN);
				this.setModeLockFlag(Cnstnts.TRUE_FLAG);
			} else if (this.getProgramMode().equals("S")) {
				this.setPageActionMode(Cnstnts.SEARCH);
				this.setModeLockFlag(Cnstnts.TRUE_FLAG);
			}
		}
		if (this.getDataFromDB()) {
			this.setPreObj(userInfo);
			this.getAttribute();
		} else {
			if (userInfo.getObj(this.getTableName()) != null) {
				this.setPreObj(userInfo);
				if (this.canAccessDB())
					if(this.dbExecute()){
						userInfo.setAttribute(this.getTableName()+"CloseFrame", "true");
					} else {
						userInfo.setAttribute(this.getTableName()+"CloseFrame", "false");
					}
				if (this.onBtnClear()) {
					this.clearAttribute();
					this.setSearchResult(null);
				}
				if (!this.getDbActionMode().equals(Cnstnts.INSERT)
						&& this.FlowKey.getValue().trim().length() == 0
						&& this.getPageActionMode().equals(Cnstnts.MAINTAIN)) {
					this.clearAttribute();
				}
			}
		}
	}
    
    public String printFlowKey() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING; 
		rtnString += this.FlowKey.printHiddenTag();
		return rtnString;
	}
    
    public boolean checkHasError() throws Exception {
		if (Cnstnts.INSERT.equals(this.getDbActionMode())) {
			if (this.checkInsertError()) {
				return true;
			}
			if (this.chkPkey()) {
				this.setErrorMessage(this.getUserInfo().getMsg("jsp.chkData.idError"));
				return true;
			}
			if (this.getFlowKey().trim().length() == 0) {
				this.setFlowKey(Util.getNo(this.getParentId(),3));
			}
			if (this.chkPkey()) {
				this.setErrorMessage(this.getUserInfo().getMsg("jsp.chkData.idError"));
				return true;
			}
		}
		if (Cnstnts.UPDATE.equals(this.getDbActionMode())
				|| Cnstnts.DELETE.equals(this.getDbActionMode())) {
			if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
				if (checkUpdateError()) {
					return true;
				}
			} else {
				if (checkDeleteError()) {
					return true;
				}
			}
		}
		return false;
	}
    
    public boolean dbExecute() throws Exception {
		this.resetError();
		if (this.getUserInfo() == null) {
			this.setErrorMessage("no userInfo object");
			return false;
		}
		if (this.checkHasError()) {
			return false;
		} else {
			if (this.getApplicant().trim().length() == 0) {
				this.setApplicant(this.getUserInfo().getAttribute("emp_id"));
			}
			if (this.getCreateDept().trim().length() == 0) {
				this.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
			}
			if (Cnstnts.SIGN.equals(this.getDbActionMode())) {
				this.doSignProcess();
				this.doApproveProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.signForm.send"));
				this.setForwardPage("menu.jsp");
			} else if (Cnstnts.CLOSE.equals(this.getDbActionMode())) {
				this.doCloseProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.closeForm.closed"));
				this.setForwardPage("menu.jsp");
			} else if (Cnstnts.INSERT.equals(this.getDbActionMode())) {
				if (this.insert()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
									  this.FlowKey.getValue(), 
									  this.getProgramId(), 
									  this.getUserInfo().getAttribute("emp_id"), 
									  this.getApplicant(),
									  this.getTableName(), 
									  this.getAliasName());
					}
					this.doOtherInsertProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.insert"));
				} else {
					this.setErrorMessage(this.getTableName() + ".insert() error!!");
					return false;
				}
			} else if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
				if (this.update()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
								  	  this.FlowKey.getValue(), 
								  	  this.getProgramId(), 
								  	  this.getUserInfo().getAttribute("emp_id"), 
								  	  this.getApplicant(),
								  	  this.getTableName(), 
								  	  this.getAliasName());
					}
					this.doOtherUpdateProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.update"));
				} else {
					this.setErrorMessage(this.getTableName() + ".update() error!!");
					return false;
				}
			} else if (Cnstnts.DELETE.equals(this.getDbActionMode())) {
				if (this.delete()) {
					this.doOtherDeleteProcess();
					this.clearAttribute();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.delete"));
				} else {
					this.setErrorMessage(this.getTableName() + ".delete() error!!");
					return false;
				}
			}
			return true;
		}
	}
	
}
