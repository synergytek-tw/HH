package deepspot.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.html.HtmlHeadTag;
import deepspot.html.SelectOneTag;
import deepspot.main.Department;
import deepspot.main.Employee;
import deepspot.main.Flow;
import deepspot.main.FlowEngin;
import deepspot.main.Flow_detail;
import deepspot.main.LogInfo;
import deepspot.main.ReportDefine;
import deepspot.main.UserBean;
import deepspot.main.Program;
import deepspot.util.Util;
import deepspot.basic.Cnstnts;

public class MasterBean {

	public MasterBean() {
		this.init();
	}

	public void init() {
		this.DbUtil = new DbUtil();
		this.FlowKey = new Field("FlowKey", this.TableName);
		this.Applicant = new Field("Applicant", this.TableName);
		this.CreateDept = new Field("CreateDept", this.TableName);
	}

	private String TableName;
	public void setTableName(String TableName) {
		this.TableName = TableName;
	}
	public String getTableName() {
		return this.TableName;
	}

	private UserBean userInfo;
	public void setUserInfo(UserBean userInfo) {
		this.userInfo = userInfo;
	}
	public UserBean getUserInfo() {
		return this.userInfo;
	}

	private DbUtil DbUtil;
	public void setDbUtil(DbUtil DbUtil) {
		this.DbUtil = DbUtil;
	}
	public DbUtil getDbUtil() {
		if (this.DbUtil == null) {
			this.DbUtil = new DbUtil();
		}
		return this.DbUtil;
	}

	private List<SelectItem> SelectList;
	public void setSelectList(List<SelectItem> SelectList) {
		this.SelectList = SelectList;
	}
	public List<SelectItem> getSelectList() {
		return this.SelectList;
	}

	private Field[] ShowField;
	public void setShowField(Field[] ShowField) {
		this.ShowField = ShowField;
	}
	public Field[] getShowField() {
		return this.ShowField;
	}

	private List<Object[]> SearchResult;
	public void setSearchResult(List<Object[]> SearchResult) {
		this.SearchResult = SearchResult;
	}
	public List<Object[]> getSearchResult() {
		return this.SearchResult;
	}

	public List<Field> DbFields;
	public void setDbFields(List<Field> DbFields) {
		this.DbFields = DbFields;
	}
	public void setDbFields() {
		this.DbFields = new ArrayList<Field>();
		this.DbFields.add(this.FlowKey);
		this.DbFields.add(this.Applicant);
		this.DbFields.add(this.CreateDept);
	}
	public List<Field> getDbFields() {
		return this.DbFields;
	}

	private List<List<Field>> Details;
	public void setDetails(List<List<Field>> Details) {
		this.Details = Details;
	}
	public List<List<Field>> getDetails() {
		return this.Details;
	}
	public List<List<Field>> getDetails(String FlowKey) {
		return null;
	}

	/* ========== about jspPage action properties & setter getter methord ========== */
	private List<?> DbActionList;
	public void setDbActionList(List<?> DbActionList) {
		this.DbActionList = DbActionList;
	}
	public List<?> getDbActionList() {
		return this.DbActionList;
	}

	private String SubmitFlag = Cnstnts.EMPTY_STRING;
	public void setSubmitFlag(String SubmitFlag) {
		this.SubmitFlag = SubmitFlag;
	}
	public String getSubmitFlag() {
		return this.SubmitFlag;
	}

	private String GetDataFlag = Cnstnts.EMPTY_STRING;
	public void setGetDataFlag(String GetDataFlag) {
		this.GetDataFlag = GetDataFlag;
	}
	public String getGetDataFlag() {
		return this.GetDataFlag;
	}

	private String ClearFlag = Cnstnts.EMPTY_STRING;
	public void setClearFlag(String ClearFlag) {
		this.ClearFlag = ClearFlag;
	}
	public String getClearFlag() {
		return this.ClearFlag;
	}
	
	private String KeepProcessFlag = Cnstnts.EMPTY_STRING;
	public void setKeepProcessFlag(String KeepProcessFlag) {
		this.KeepProcessFlag = KeepProcessFlag;
	}
	public String getKeepProcessFlag() {
		return this.KeepProcessFlag;
	}

	private String DeleteDetail = Cnstnts.EMPTY_STRING;
	public void setDeleteDetail(String DeleteDetail) {
		this.DeleteDetail = DeleteDetail;
	}
	public String getDeleteDetail() {
		return this.DeleteDetail;
	}

	public Field FlowKey;
	public void setFlowKey(String FlowKey) {
		this.FlowKey.setValue(FlowKey);
	}
	public String getFlowKey() {
		return this.FlowKey.getValue();
	}

	public Field Applicant;
	public void setApplicant(String Applicant) {
		this.Applicant.setValue(Applicant);
	}
	public String getApplicant() {
		return this.Applicant.getValue();
	}

	public Field CreateDept;
	public void setCreateDept(String CreateDept) {
		this.CreateDept.setValue(CreateDept);
	}
	public String getCreateDept() {
		return this.CreateDept.getValue();
	}

	private String Creator = Cnstnts.EMPTY_STRING;
	public void setCreator(String Creator) {
		this.Creator = Creator;
	}
	public String getCreator() {
		return this.Creator;
	}

	private String DataDept = Cnstnts.EMPTY_STRING;
	public void setDataDept(String DataDept) {
		this.DataDept = DataDept;
	}
	public String getDataDept() {
		return this.DataDept;
	}

	private String ProgramId = Cnstnts.EMPTY_STRING;
	public void setProgramId(String ProgramId) {
		this.ProgramId = ProgramId;
	}
	public String getProgramId() {
		return this.ProgramId;
	}

	private String TagId = Cnstnts.EMPTY_STRING;
	public void setTagId(String TagId) {
		this.TagId = TagId;
	}
	public String getTagId() {
		return this.TagId;
	}

	private String DbActionMode = Cnstnts.EMPTY_STRING;
	public void setDbActionMode(String DbActionMode) {
		this.DbActionMode = DbActionMode;
	}
	public String getDbActionMode() {
		return this.DbActionMode;
	}

	private String PageActionMode = Cnstnts.EMPTY_STRING;
	public void setPageActionMode(String PageActionMode) {
		this.PageActionMode = PageActionMode;
	}
	public String getPageActionMode() {
		return this.PageActionMode;
	}

	private String ModeLockFlag = Cnstnts.EMPTY_STRING;
	public void setModeLockFlag(String ModeLockFlag) {
		this.ModeLockFlag = ModeLockFlag;
	}
	public String getModeLockFlag() {
		return this.ModeLockFlag;
	}

	private String DoSearchFlag = Cnstnts.EMPTY_STRING;
	public void setDoSearchFlag(String DoSearchFlag) {
		this.DoSearchFlag = DoSearchFlag;
	}
	public String getDoSearchFlag() {
		return this.DoSearchFlag;
	}
	
	private String OpenerSetValue = Cnstnts.EMPTY_STRING;
	public void setOpenerSetValue(String OpenerSetValue) {
		this.OpenerSetValue = OpenerSetValue;
	}
	public String getOpenerSetValue() {
		return this.OpenerSetValue;
	}

	private String[] DeleteItems;
	public void setDeleteItems(String[] deleteItems) {
		this.DeleteItems = deleteItems;
	}
	public String[] getDeleteItems() {
		return this.DeleteItems;
	}

	/* ========== about flowing action properties & setter getter methord ========== */
	private String CloseReject = Cnstnts.EMPTY_STRING;
	public void setCloseReject(String CloseReject) {
		this.CloseReject = CloseReject;
	}
	public String getCloseReject() {
		return CloseReject;
	}

	private int FlowStep = 0;
	public void setFlowStep(int FlowStep) {
		this.FlowStep = FlowStep;
	}
	public int getFlowStep() {
		return FlowStep;
	}

	private String FlowStepName = Cnstnts.EMPTY_STRING;
	public void setFlowStepName(String FlowStepName) {
		this.FlowStepName = FlowStepName;
	}
	public String getFlowStepName() {
		return FlowStepName;
	}

	private String SignMemo = Cnstnts.EMPTY_STRING;
	public void setSignMemo(String SignMemo) {
		this.SignMemo = SignMemo;
	}
	public String getSignMemo() {
		return SignMemo;
	}

	private String Agree = Cnstnts.EMPTY_STRING;
	public void setAgree(String Agree) {
		this.Agree = Agree;
	}
	public String getAgree() {
		return Agree;
	}

	private String BackStep = Cnstnts.EMPTY_STRING;
	public void setBackStep(String BackStep) {
		this.BackStep = BackStep;
	}
	public String getBackStep() {
		return BackStep;
	}

	private String Decide = Cnstnts.EMPTY_STRING;
	public void setDecide(String Decide) {
		this.Decide = Decide;
	}
	public String getDecide() {
		return Decide;
	}

	private String RejectReason = Cnstnts.EMPTY_STRING;
	public void setRejectReason(String RejectReason) {
		this.RejectReason = RejectReason;
	}
	public String getRejectReason() {
		return RejectReason;
	}

	private String BackToSrcSigner = Cnstnts.EMPTY_STRING;
	public void setBackToSrcSigner(String BackToSrcSigner) {
		this.BackToSrcSigner = BackToSrcSigner;
	}
	public String getBackToSrcSigner() {
		return BackToSrcSigner;
	}

	/* ========== about pagination action properties & setter getter methord ========== */
	private String OrderKey = Cnstnts.FLOWKEY;
	public void setOrderKey(String OrderKey) {
		this.OrderKey = OrderKey;
	}
	public String getOrderKey() {
		return OrderKey;
	}

	private String OrderSequence = Cnstnts.DESC;
	public void setOrderSequence(String OrderSequence) {
		this.OrderSequence = OrderSequence;
	}
	public String getOrderSequence() {
		return OrderSequence;
	}

	private int PageNo = Cnstnts.DEFAULT_PAGE_NO;
	public void setPageNo(int PageNo) {
		this.PageNo = PageNo;
	}
	public int getPageNo() {
		return PageNo;
	}

	private int PageRecords = Cnstnts.DEFAULT_PAGE_RECORDS;
	public void setPageRecords(int PageRecords) {
		this.PageRecords = PageRecords;
	}
	public int getPageRecords() {
		return PageRecords;
	}

	private int FindRecords = Cnstnts.DEFAULT_FIND_RECORDS;
	public void setFindRecords(int FindRecords) {
		this.FindRecords = FindRecords;
	}
	public int getFindRecords() {
		return FindRecords;
	}

	private int CurrentRecord = Cnstnts.DEFAULT_CURRENT_ECORD;
	public void setCurrentRecord(int CurrentRecord) {
		this.CurrentRecord = CurrentRecord;
	}
	public int getCurrentRecord() {
		return CurrentRecord;
	}

	/* ========== about jspPage css properties & setter getter methord ========== */
	private String PageBgcolor = Cnstnts.DEFAULT_PAGE_BGCOLOR;
	public void setPageBgcolor(String PageBgcolor) {
		this.PageBgcolor = PageBgcolor;
	}
	public String getPageBgcolor() {
		return PageBgcolor;
	}

	private String TableBgcolor = Cnstnts.DEFAULT_TABLE_BGCOLOR;
	public void setTableBgcolor(String TableBgcolor) {
		this.TableBgcolor = TableBgcolor;
	}
	public String getTableBgcolor() {
		return TableBgcolor;
	}

	private String ThBgcolor = Cnstnts.DEFAULT_TH_BGCOLOR;
	public void setThBgcolor(String ThBgcolor) {
		this.ThBgcolor = ThBgcolor;
	}
	public String getThBgcolor() {
		return ThBgcolor;
	}

	private String TrBgcolor1 = Cnstnts.DEFAULT_TR_BGCOLOR_1;
	public void setTrBgcolor1(String TrBgcolor1) {
		this.TrBgcolor1 = TrBgcolor1;
	}
	public String getTrBgcolor1() {
		return TrBgcolor1;
	}

	private String TrBgcolor2 = Cnstnts.DEFAULT_TR_BGCOLOR_2;
	public void setTrBgcolor2(String TrBgcolor2) {
		this.TrBgcolor2 = TrBgcolor2;
	}
	public String getTrBgcolor2() {
		return TrBgcolor2;
	}

	/* ========== other needed properties & setter getter methord ========== */
	private String OutputFile = Cnstnts.EMPTY_STRING;
	public void setOutputFile(String OutputFile) {
		this.OutputFile = OutputFile;
	}
	public String getOutputFile() {
		return OutputFile;
	}
	
	private String SampleDoc = Cnstnts.EMPTY_STRING;
	public void setSampleDoc(String SampleDoc) {
		this.SampleDoc = SampleDoc;
	}
	public String getSampleDoc() {
		return SampleDoc;
	}

	private String Message = Cnstnts.EMPTY_STRING;
	public void setMessage(String Message) {
		this.Message = Message;
	}
	public String getMessage() {
		return Message;
	}
	
	private String JavascriptCode = Cnstnts.EMPTY_STRING;
	public void setJavascriptCode(String JavascriptCode) {
		this.JavascriptCode = JavascriptCode;
	}
	public String getJavascriptCode() {
		return this.JavascriptCode;
	}

	private String ErrorMessage = Cnstnts.EMPTY_STRING;
	public void setErrorMessage(String ErrorMessage) {
		this.ErrorMessage = ErrorMessage;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}

	private String ForwardPage = Cnstnts.EMPTY_STRING;
	public void setForwardPage(String ForwardPage) {
		this.ForwardPage = ForwardPage;
	}
	public String getForwardPage() {
		return ForwardPage;
	}

	private String AliasName = Cnstnts.EMPTY_STRING;
	public void setAliasName(String AliasName) {
		this.AliasName = AliasName;
	}
	public String getAliasName() {
		return AliasName;
	}

	/* ========== about for JspPage used function ========== */
	public boolean onBtnSubmit() {
		if (Cnstnts.TRUE_FLAG.equals(this.SubmitFlag))
			return true;
		else
			return false;
	}

	public boolean onBtnSign() {
		if (Cnstnts.SIGN.equals(this.DbActionMode) && this.onBtnSubmit())
			return true;
		else
			return false;
	}

	public boolean onBtnClose() {
		if (Cnstnts.CLOSE.equals(this.DbActionMode) && this.onBtnSubmit())
			return true;
		else
			return false;
	}

	public boolean onBtnEnding() {
		if (Cnstnts.ENDING.equals(this.DbActionMode) && this.onBtnSubmit())
			return true;
		else
			return false;
	}

	public boolean onBtnClear() {
		if (Cnstnts.TRUE_FLAG.equals(this.ClearFlag))
			return true;
		else
			return false;
	}

	public boolean onBtnSearch() {
		if (Cnstnts.TRUE_FLAG.equals(this.DoSearchFlag)
				&& Cnstnts.SEARCH.equals(this.PageActionMode))
			return true;
		else
			return false;
	}

	public boolean onBtnDeleteDetail() {
		if (Cnstnts.TRUE_FLAG.equals(this.DeleteDetail)
				&& (Cnstnts.MAINTAIN.equals(this.PageActionMode) 
						&& (Cnstnts.INSERT.equals(this.DbActionMode) 
								|| Cnstnts.UPDATE.equals(this.DbActionMode))))
			return true;
		else
			return false;
	}

	public boolean onBtnCloseReject() {
		if (Cnstnts.TRUE_FLAG.equals(this.CloseReject)
				&& Cnstnts.MAINTAIN.equals(this.PageActionMode)
						&& Cnstnts.CLOSE.equals(this.DbActionMode))
			return true;
		else
			return false;
	}

	public void resetError() {
		this.Message = Cnstnts.EMPTY_STRING;
		this.ErrorMessage = Cnstnts.EMPTY_STRING;
		this.ForwardPage = Cnstnts.EMPTY_STRING;
	}

	public boolean canAccessDB() {
		if (!Cnstnts.TRUE_FLAG.equals(this.SubmitFlag))
			return false;
		if (Cnstnts.QUERY.equals(this.DbActionMode))
			return false;
		if (Cnstnts.INSERT.equals(this.DbActionMode))
			return true;
		else {
			if (this.getFlowKey().trim().length() > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean canEdit() {
		if (this.getFlowKey() == null) {
			return false;
		}
		if (Cnstnts.MAINTAIN.equals(this.PageActionMode)
				&& (Cnstnts.INSERT.equals(this.DbActionMode) 
						|| ((Cnstnts.UPDATE.equals(this.DbActionMode) 
								&& this.getFlowKey().trim().length() > 0)))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean canSubmit() {
		if (Cnstnts.SEARCH.equals(this.PageActionMode)
				|| this.getFlowKey() == null) {
			return false;
		}
		if (Cnstnts.INSERT.equals(this.DbActionMode)) {
			return true;
		}
		if (this.getFlowKey().trim().length() == 0
				|| Cnstnts.QUERY.equals(this.DbActionMode)
				|| Cnstnts.SIGN.equals(this.DbActionMode)
				|| Cnstnts.CLOSE.equals(this.DbActionMode)
				|| Cnstnts.ENDING.equals(this.DbActionMode)) {
			return false;
		} else {
			return true;
		}
	}

	protected String getPageTitle() throws Exception {
		if (this.userInfo == null || this.ProgramId.trim().length() == 0)
			return Cnstnts.EMPTY_STRING;
		String title = userInfo.getProgramName(this.ProgramId);
		if (Cnstnts.SEARCH.equals(this.PageActionMode)) {
			title += " - " + userInfo.getMsg("jsp.Program.SearchMode");
		}
		if (Cnstnts.MAINTAIN.equals(this.PageActionMode)) {
			if (this.DbActionMode.equals(Cnstnts.SIGN)) {
				title += userInfo.getMsg("jsp.common.SIGN");
			} else if (this.DbActionMode.equals(Cnstnts.CLOSE)) {
				title += userInfo.getMsg("jsp.common.CLOSE");
			} else {
				title += " - " + userInfo.getMsg("jsp.Program.MaintainMode");
			}
		}
		return title;
	}

	private String getHelpImg() throws Exception {
		String helpUrl = new Program(this.ProgramId).getOnlineHelpUrl();
		if (helpUrl.trim().length() == 0)
			return Cnstnts.EMPTY_STRING;
		else
			return Html.getHelpImg(helpUrl, this.userInfo);
	}

	private String getPrintBtn() throws Exception {
		if (this.onBtnSubmit()){
			if(this.OutputFile.trim().length() > 0){
				return Html.getPrintBtn(this.OutputFile, this.userInfo);
			}
		} 
		return Cnstnts.EMPTY_STRING;
	}

	public boolean onSearchMode() {
		if (Cnstnts.SEARCH.equals(this.PageActionMode))
			return true;
		else
			return false;
	}

	public boolean onMaintainMode() {
		if (Cnstnts.MAINTAIN.equals(this.PageActionMode))
			return true;
		else
			return false;
	}

	public boolean hasBindingFlow() {
		return userInfo.getBindingFlowFlag(this.getProgramId());
	}

	public boolean getDataFromDB() {
		if (Cnstnts.TRUE_FLAG.equals(this.GetDataFlag))
			return true;
		else
			return false;
	}

	public String getProgramMode() {
		return userInfo.getProgramMode(this.getProgramId());
	}

	public String printHeadTag() throws Exception {
		List<String> linkTagList = new ArrayList<String>();
		linkTagList.add("css/login.css");
		linkTagList.add("css/default.css");
		linkTagList.add("css/smoothness/jquery-ui-1.7.2.custom.css");
		List<String> scriptTagList = new ArrayList<String>();
		scriptTagList.add("js/basic.js");
		scriptTagList.add("js/tree.js");
		scriptTagList.add("js/ajax.js");
		scriptTagList.add("js/AC_RunActiveContent.js");
		scriptTagList.add("js/AC_ActiveX.js");
		scriptTagList.add("js/jquery-1.3.2.min.js");
		scriptTagList.add("js/jquery-ui-1.7.2.custom.min.js");
		HtmlHeadTag headTag = new HtmlHeadTag(this.getPageTitle(), linkTagList,
				scriptTagList);
		return headTag.print();
	}

	public String printHiddenTags() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("submitFlag", Cnstnts.EMPTY_STRING);
		hm.put("getDataFlag", Cnstnts.EMPTY_STRING);
		hm.put("clearFlag", Cnstnts.EMPTY_STRING);
		hm.put("keepProcessFlag", Cnstnts.EMPTY_STRING);
		hm.put("deleteDetail", Cnstnts.EMPTY_STRING);
		hm.put("closeReject", Cnstnts.EMPTY_STRING);
		hm.put("doSearchFlag", Cnstnts.EMPTY_STRING);
		hm.put("backToSrcSigner", Cnstnts.EMPTY_STRING);
		hm.put("tagId", Cnstnts.EMPTY_STRING);
		hm.put("recordIndex", Cnstnts.EMPTY_STRING);
		hm.put("orderKey", this.OrderKey);
		hm.put("currentRecord", String.valueOf(this.CurrentRecord));
		hm.put("orderSequence", this.OrderSequence);
		hm.put("modeLockFlag", this.ModeLockFlag);
		hm.put("pageActionMode", this.PageActionMode);
		hm.put("applicant", this.getApplicant());
		hm.put("createDept", this.getCreateDept());
		hm.put("openerSetValue", this.getOpenerSetValue());
		return new HiddenTag().print(hm);
	}

	public String getSwitchModeImg() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (Cnstnts.TRUE_FLAG.equals(this.ModeLockFlag)) {
			return rtnString;
		}
		if (this.PageActionMode.equals(Cnstnts.MAINTAIN)) {
			rtnString = Html.getSearchModeImg(this.userInfo);
		}

		if (this.PageActionMode.equals(Cnstnts.SEARCH)) {
			rtnString = Html.getMaintainModeImg(this.userInfo);
		}
		return rtnString;
	}

	public String getClearBtn() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;

		if (Cnstnts.INSERT.equals(this.DbActionMode)
				|| Cnstnts.SEARCH.equals(this.PageActionMode)) {
			rtnString = Html.getClearBtn(this.userInfo);
		}
		return rtnString;
	}

	public String getSubmitBtn() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if(this.getDbActionMode().equals(Cnstnts.PRINT) 
				&& this.getPageActionMode().equals(Cnstnts.MAINTAIN)){
			List<SelectItem> sampleDocs = new ReportDefine().getList(this.getProgramId());
			if(sampleDocs.size()>0){
				if(sampleDocs.size()>1){
					rtnString = "<select id='sampleDoc' name='sampleDoc'>";
					for(Iterator<SelectItem> itr=sampleDocs.iterator();itr.hasNext();){
						SelectItem option = (SelectItem)itr.next();
						String selected = Cnstnts.EMPTY_STRING;
						if(this.getSampleDoc().equals(option.getKey())){
							selected=Cnstnts.SELECTED;
						}
						rtnString += "  <option value='"+option.getKey()+"'"+selected+">"+
										option.getValue()+"</option>";
					}
					rtnString += "</select>";
				} else {
					rtnString = "<input type='hidden' id='sampleDoc' name='sampleDoc' " +
									   "value='"+sampleDocs.get(0).getValue()+"'/>";
				}				
			}
		}
		
		if (this.canSubmit()) {
			if (!this.getApplicant().equals(userInfo.getAttribute("emp_id"))) {
				if (Cnstnts.UPDATE.equals(this.DbActionMode)) {
					if (!userInfo.canUpdateAll(this.ProgramId)) {
						if (!userInfo.canUpdateDept(this.ProgramId)) {
							return rtnString;
						} else {
							if (!this.getCreateDept().equals(userInfo.getAttribute("dept_id"))) {
								if (!this.chkInDept()) {
									return rtnString;
								}
							}
						}
					}
				}
				if (Cnstnts.DELETE.equals(this.DbActionMode)) {
					if (!userInfo.canDeleteAll(this.ProgramId)) {
						if (!userInfo.canDeleteDept(this.ProgramId)) {
							return rtnString;
						} else {
							if (!this.getCreateDept().equals(userInfo.getAttribute("dept_id"))) {
								if (!this.chkInDept()) {
									return rtnString;
								}
							}
						}
					}
				}
			}
			rtnString += Html.getSubmitBtn(this.userInfo, this.DbActionMode, null);
		}
		return rtnString;
	}

	protected boolean chkInDept() throws Exception {
		boolean matchFlag = false;
		Department dept = new Department(this.userInfo.getAttribute("dept_id"));
		SelectItem item = dept.getSelectItem();
		for (Iterator<?> itr = dept.getTreeList(item).iterator(); itr.hasNext();) {
			SelectItem dptItem = (SelectItem) itr.next();
			if (this.getCreateDept().equals(dptItem.getKey())) {
				matchFlag = true;
				break;
			}
		}
		return matchFlag;
	}

	protected String getDbActionSelectItem() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;

		if ((Cnstnts.TRUE_FLAG.equals(this.getModeLockFlag()) 
				&& !this.getProgramMode().equals("M"))
					|| (Cnstnts.MAINTAIN.equals(this.getPageActionMode()) 
						&& (Cnstnts.SIGN.equals(this.getDbActionMode())
							|| Cnstnts.CLOSE.equals(this.getDbActionMode()) 
								|| Cnstnts.ENDING.equals(this.getDbActionMode())))
									|| Cnstnts.SEARCH.equals(this.getPageActionMode())) {
			rtnString = new HiddenTag("dbActionMode", this.getDbActionMode()).toString();
			if (Cnstnts.CLOSE.equals(this.getDbActionMode())) {
				rtnString += Html.getCloseBtn(this.getUserInfo());
			}
			return rtnString;
		}
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())
				&& this.getDbActionList() == null) {
			this.setDbActionList(getUserInfo().getDbActionList(this.getProgramId()));
		}

		SelectOneTag selectItem = new SelectOneTag(Cnstnts.DB_ACTION_MODE,
				Cnstnts.SET_VALUE, this.getDbActionMode(), this.getDbActionList());

		rtnString = selectItem.toString();

		return rtnString;
	}

	public String getSearchImg() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;

		if (Cnstnts.SEARCH.equals(this.getPageActionMode())) {
			rtnString = Html.getDoSearchImg(this.getUserInfo());
		}

		return rtnString;
	}

	public String printFunctionBar() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		StringBuffer strBfr = new StringBuffer();
		strBfr.append(newLine + "<div id='functionBarDiv'><table id='functionBar' " + this.TableBgcolor + ">");
		strBfr.append(newLine + "<tr>");
		strBfr.append(newLine + "<td>");
		strBfr.append(newLine + "<div class='logTitle'>");
		strBfr.append(newLine + this.getPageTitle());
		strBfr.append(Html.getReflashImg(this.getUserInfo()));
		strBfr.append(Html.getPrintImg(this.getUserInfo()));
		strBfr.append(this.getHelpImg());
		strBfr.append(this.getSwitchModeImg());
		strBfr.append(newLine + "</div>");
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "<td align='right'>");
		strBfr.append(this.getPrintBtn());
		strBfr.append(this.getClearBtn());
		strBfr.append(this.getSubmitBtn());
		strBfr.append(this.getPreRecordImg());
		strBfr.append(this.getNextRecordImg());
		strBfr.append(this.getDbActionSelectItem());
		strBfr.append(this.getSearchImg());
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "</tr>");
		strBfr.append(newLine + "</table></div>");
		return strBfr.toString();
	}

	private String getPreRecordImg() throws Exception {
		StringBuffer strBfr = new StringBuffer();
		if (this.SearchResult == null
				|| Cnstnts.TRUE_FLAG.equals(this.ModeLockFlag)) {
			return strBfr.toString();
		}
		if (this.onMaintainMode() && this.getFlowKey().trim().length() > 0
				&& !Cnstnts.INSERT.equals(this.DbActionMode)) {
			if (this.CurrentRecord == 0)
				this.CurrentRecord = 1;
			if (this.CurrentRecord > 1 && this.SearchResult.size() >= this.CurrentRecord) {
				strBfr.append(Cnstnts.NEW_LINE
						+ "<img src='img/icon_06.gif' style='cursor: hand' "
						+ "width='14px' height='14px' border='0' " + "title='"
						+ userInfo.getMsg("jsp.common.preRecord") + "' "
						+ "onClick='document.input.currentRecord.value=\""
						+ (this.CurrentRecord - 1) + "\";gotoData(\""
						+ this.SearchResult.get(this.CurrentRecord - 2)[0]
						+ "\")'>");
			}
		}
		return strBfr.toString();
	}

	private String getNextRecordImg() throws Exception {
		StringBuffer strBfr = new StringBuffer();
		if (this.SearchResult == null
				|| Cnstnts.TRUE_FLAG.equals(this.ModeLockFlag)) {
			return strBfr.toString();
		}
		if (this.onMaintainMode() && this.getFlowKey().trim().length() > 0
				&& !Cnstnts.INSERT.equals(this.DbActionMode)) {
			if (this.CurrentRecord == 0)
				this.CurrentRecord = 1;
			if (this.SearchResult.size() > this.CurrentRecord) {
				strBfr.append(Cnstnts.NEW_LINE
						+ "<img src='img/icon_05.gif' style='cursor: hand' "
						+ "width='14px' height='14px' border='0' " + "title='"
						+ userInfo.getMsg("jsp.common.nextRecord") + "' "
						+ "onClick='document.input.currentRecord.value=\""
						+ (this.CurrentRecord + 1) + "\";gotoData(\""
						+ this.SearchResult.get(this.CurrentRecord)[0]
						+ "\")'>");
			}
		}
		return strBfr.toString();
	}

	public String printHtml() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String onLoadStr = Cnstnts.EMPTY_STRING;
		if (this.TagId.trim().length() > 0) {
			onLoadStr = " onLoad='document.input." + this.TagId + ".focus()'";
		}
		StringBuffer strBfr = new StringBuffer("");
		strBfr.append(Cnstnts.NEW_LINE+"<html>");
		strBfr.append(this.printHeadTag());
		strBfr.append(newLine + "<body" + this.PageBgcolor + onLoadStr + "><center>");
		strBfr.append(this.printBodyDiv());
		strBfr.append(newLine + "</center></body></html>");
		return strBfr.toString();
	}
	
	public String printBodyDiv() throws Exception{
		char newLine = Cnstnts.NEW_LINE;
		StringBuffer strBfr = new StringBuffer();
		strBfr.append(newLine + "<div id='bodyDiv'><form name='input' id='input' method='post'>");
		strBfr.append(this.printHiddenTags());
		strBfr.append(this.printFunctionBar());
		strBfr.append(this.printHtmlBody());
		strBfr.append(this.getFlowDetail());
		strBfr.append(this.getSignForm());
		strBfr.append(this.getCloseForm());
		strBfr.append(newLine + "</form></center></div>");
		return strBfr.toString();
	}

	public String printHtmlBody() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine + "<table id='bodyTable' " + this.TableBgcolor + ">";
		rtnString += this.printFlowKey();
		if (this.onSearchMode()) {
			rtnString += this.printSearchTable();
		} else {
			rtnString += this.printMaintainTable();
		}
		rtnString += newLine + "</table>";
		 
		if (this.onSearchMode()) {
			rtnString += this.printSearchReasult();
		}
		return rtnString;
	}

	public String printSearchTable() throws Exception {
		return Cnstnts.EMPTY_STRING;
	}

	public String printMaintainTable() throws Exception {
		return Cnstnts.EMPTY_STRING;
	}

	public List<SelectItem> getList() throws Exception {
		return this.getDbUtil().getList(this.FlowKey, this.getNamesPrpts());
	}

	public String printFlowKey() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String flowKeyHtml = Cnstnts.EMPTY_STRING;
		String requireMessage = Cnstnts.EMPTY_STRING;
		if (this.getProgramMode().equals("M")
				&& this.PageActionMode.equals(Cnstnts.MAINTAIN)
				&& (this.DbActionMode.equals(Cnstnts.UPDATE)
				|| this.DbActionMode.equals(Cnstnts.DELETE) 
				|| this.DbActionMode.equals(Cnstnts.QUERY))) {
			flowKeyHtml = newLine
					+ "      <select id='flowKey' name='flowKey' onChange='"
					+ "document.input.getDataFlag.value=\"true\";setValue()'>";
			flowKeyHtml += newLine + "        <option value=''>"
					+ userInfo.getMsg("jsp.account.select") + "</option>";
			List<SelectItem> selectList = this.getList();
			if (selectList == null) {
				this.FlowKey.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
				return this.printTag(this.FlowKey);
			} else {
				if (selectList.size() > 0) {
					for (Iterator<SelectItem> itr = selectList.iterator(); itr.hasNext();) {
						SelectItem item = (SelectItem) itr.next();
						String selected = Cnstnts.EMPTY_STRING;
						if (item.getKey().equals(this.getFlowKey())) {
							selected = " selected";
						}
						flowKeyHtml += newLine + "        <option value='"
								+ item.getKey() + "'" + selected + ">"
								+ item.getValue() + "</option>";
					}
				}
			}
			flowKeyHtml += newLine + "      </select>";
		} else {
			String readonly = " readonly";
			String insertMessage = Cnstnts.EMPTY_STRING;
			if (this.PageActionMode.equals(Cnstnts.MAINTAIN)
					&& this.DbActionMode.equals(Cnstnts.INSERT)) {
				readonly = " maxLength='50'";
				if (new Program(this.getProgramId()).getBeginWord().trim()
						.length() > 0) {
					insertMessage = "<img src='img/OneClick.png' style='cursor: hand' "
							+ "title='"
							+ userInfo.getMsg("jsp.common.clearFieldValue")
							+ "' "
							+ "onClick='document.input.flowKey.value=\"\"'>"
							+ userInfo.getMsg("jsp.common.autoGeneration");
				} else {
					requireMessage = "<font color='red'>"
							+ userInfo.getMsg("jsp.common.Require")
							+ "*</font>";
				}

			}
			if (this.PageActionMode.equals(Cnstnts.SEARCH)) {
				readonly = " maxLength='50'";
			}
			flowKeyHtml = "      <input type='text' id='flowKey' name='flowKey'"
					+ readonly
					+ " value='"
					+ this.getFlowKey()
					+ "'"
					+ this.FlowKey.printOnChange() + "/>" + insertMessage;

		}
		StringBuffer strBfr = new StringBuffer();
		strBfr.append(newLine + "  <tr" + Cnstnts.DEFAULT_TR_BGCOLOR_1 + ">");
		strBfr.append(newLine
				+ "    <td align='right'"
				+ this.FlowKey.getWidth()
				+ ">"
				+ requireMessage
				+ userInfo
						.getMsg(this.ProgramId + "." + this.FlowKey.getName())
				+ "</td>");
		strBfr.append(newLine + "    <td colspan='3'>");
		strBfr.append(newLine + flowKeyHtml);
		strBfr.append(newLine + "    </td>");
		strBfr.append(newLine + "  </tr>");
		
		if ((this.userInfo.canQueryAll(this.ProgramId) 
				|| this.userInfo.canQueryDept(this.ProgramId))
						&& this.PageActionMode.equals(Cnstnts.SEARCH)) {
			strBfr.append(newLine + "  <tr" + Cnstnts.DEFAULT_TR_BGCOLOR_1 + ">");
			strBfr.append(newLine + "    <td align='right'" + this.FlowKey.getWidth() + ">"
					+ userInfo.getMsg("jsp.common.CreateDept") + "</td>");
			strBfr.append(newLine + "    <td colspan='3'>");
			if (this.userInfo.canQueryAll(this.ProgramId)) {
				strBfr.append(newLine
						+ "      <select id='dataDept' name='dataDept' "
						+ "onChange='setValue()'>");
				strBfr.append(newLine + "        <option value=''>"
						+ userInfo.getMsg("jsp.account.select") + "</option>");
				for (Iterator<?> itr = new Department().getRootTreeList()
						.iterator(); itr.hasNext();) {
					SelectItem deptItem = (SelectItem) itr.next();
					String selected = Cnstnts.EMPTY_STRING;
					if (deptItem.getKey().equals(this.DataDept)) {
						selected = " selected";
					}
					strBfr.append(newLine + "        <option value='"
							+ deptItem.getKey() + "'" + selected + ">"
							+ deptItem.getValue() + "</option>");
				}
				strBfr.append(newLine + "      </select>&nbsp;");
			} else {
				Department dept = new Department(userInfo
						.getAttribute("dept_id"));
				SelectItem item = dept.getSelectItem();
				Iterator<?> itr = dept.getTreeList(item).iterator();
				if (itr.hasNext()) {
					strBfr.append(newLine
							+ "      <select id='dataDept' name='dataDept' "
							+ "onChange='setValue()'>");
					strBfr.append(newLine + "        <option value=''>"
							+ userInfo.getMsg("jsp.account.select")
							+ "</option>");
					String selected = Cnstnts.EMPTY_STRING;
					if (userInfo.getAttribute("dept_id").equals(this.DataDept)) {
						selected = " selected";
					}
					strBfr.append(newLine + "        <option value='"
							+ userInfo.getAttribute("dept_id") + "'" + selected
							+ ">" + userInfo.getAttribute("dept_id") + "-"
							+ userInfo.getAttribute("DeptName") + "</option>");
					while (itr.hasNext()) {
						SelectItem deptItem = (SelectItem) itr.next();
						selected = Cnstnts.EMPTY_STRING;
						if (deptItem.getKey().equals(this.DataDept)) {
							selected = " selected";
						}
						strBfr.append(newLine + "        <option value='"
								+ deptItem.getKey() + "'" + selected + ">"
								+ deptItem.getValue() + "</option>");
					}
					strBfr.append(newLine + "      </select>");
				} else {
					strBfr.append(newLine + "      "
							+ userInfo.getAttribute("DeptName") + "&nbsp;");
					strBfr.append(newLine
									+ "      <input type='hidden' id='dataDept' name='dataDept' value='"
									+ userInfo.getAttribute("dept_id") + "'/>");
				}
			}
			strBfr.append(newLine + "      "
					+ userInfo.getMsg("jsp.common.Creater"));
			strBfr.append(newLine
					+ "      <select id='creater' name='creater'>");
			strBfr.append(newLine + "        <option value=''>"
					+ userInfo.getMsg("jsp.account.select") + "</option>");
			for (Iterator<?> itr = new Employee().getDeptList(this.DataDept).iterator(); itr.hasNext();) {
				SelectItem item = (SelectItem) itr.next();
				String selected = Cnstnts.EMPTY_STRING;
				if (this.Creator.equals(item.getKey())) {
					selected = " selected";
				}
				strBfr.append(newLine + "        <option value='"
						+ item.getKey() + "'" + selected + ">"
						+ item.getValue() + "</option>");
			}
			strBfr.append(newLine + "      </select>");
			strBfr.append(newLine + "    </td>");
			strBfr.append(newLine + "  </tr>");
		}

		return strBfr.toString();
	}

	public String printHtml(Field field) throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		char newLine = Cnstnts.NEW_LINE;
		rtnString = newLine + "  <tr" + field.getBgcolor() + ">";
		rtnString += newLine + "    <td align='right' width='20%'>"
				+ getAlias(field) + "</td>";
		rtnString += newLine + "    <td" + field.printColspan() + ">"
				+ this.printTag(field) + "</td>";
		if (field.getColspan() == 1 && field.getAnotherField() != null) {
			rtnString += newLine + "    <td align='right' width='15%'>"
					+ getAlias(field.getAnotherField()) + "</td>";
			rtnString += newLine + "    <td>"
					+ this.printTag(field.getAnotherField()) + "</td>";
		}
		rtnString += newLine + "  </tr>";

		return rtnString;
	}
	
	public String printDivTagHtml(Field field) throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		char newLine = Cnstnts.NEW_LINE;
		rtnString = newLine + "  <tr" + field.getBgcolor() + ">";
		rtnString += newLine + "    <td align='right' width='20%'>"
				+ getDivAlias(field) + "</td>";
		rtnString += newLine + "    <td" + field.printColspan() + ">"
				+ this.printDivTag(field) + "</td>";
		if (field.getColspan() == 1 && field.getAnotherField() != null) {
			rtnString += newLine + "    <td align='right' width='15%'>"
					+ getDivAlias(field.getAnotherField()) + "</td>";
			rtnString += newLine + "    <td>"
					+ this.printDivTag(field.getAnotherField()) + "</td>";
		}
		rtnString += newLine + "  </tr>";

		return rtnString;
	}

	public String getAlias(Field field) throws Exception {
		String rtnString = Html.getAlias(field, userInfo);
		if (field.checkEmpty() && this.canEdit() && this.onMaintainMode()) {
			rtnString = "<font color='red' size='1'>"
					+ userInfo.getMsg("jsp.common.Require") + "*</font>"
					+ rtnString;
		}
		return rtnString;
	}

	public String getDivAlias(Field field) throws Exception {
		String rtnString = Html.getAlias(field, userInfo);
		if (field.checkEmpty() && this.canEdit() && this.onMaintainMode()) {
			rtnString = "<font color='red' size='1'>"
					+ userInfo.getMsg("jsp.common.Require") + "*</font>"
					+ rtnString;
		}
		if (field.getHtmlType().equals(Cnstnts.HTML_TAG_HIDDEN)) {
			rtnString = Cnstnts.EMPTY_STRING;
		}
		return "<div id='" + field.getTagName() + "AliasDiv' name='"
				+ field.getTagName() + "AliasDiv'>" + rtnString + "</div>";
	}

	public String printTag(Field field) throws Exception {
		field.setCanEdit(this.getCanEditField(field));
		String rtnString = Html.printTag(field, userInfo);
		if (field.getAnotherField() != null && field.getColspan() > 1) {
			rtnString += getAlias(field.getAnotherField())
					+ printTag(field.getAnotherField());
		}
		return rtnString;
	}

	public String printDivTag(Field field) throws Exception {
		field.setCanEdit(this.getCanEditField(field));
		String rtnString = "<div id='" + field.getTagName() + "Div' name='"
				+ field.getTagName() + "Div'>" + Html.printTag(field, userInfo)
				+ "</div>";
		if (field.getAnotherField() != null && field.getColspan() > 1) {
			rtnString += getDivAlias(field.getAnotherField())
					+ printDivTag(field.getAnotherField());
		}
		return rtnString;
	}

	public boolean getCanEditField(Field field) {
		if (this.canEdit() || this.onSearchMode()) {
			return true;
		} else {
			return false;
		}
	}

	private String getFlowDetail() throws Exception {
		if (this.getFlowKey() == null)
			return Cnstnts.EMPTY_STRING;
		String rtnString = Cnstnts.EMPTY_STRING;
		if (Cnstnts.MAINTAIN.equals(this.PageActionMode)
				&& this.getFlowKey().trim().length() > 0
				&& this.hasBindingFlow()) {
			rtnString = Html.getFlowDetail(this.FlowKey, this.userInfo);
		}
		return rtnString;
	}

	private String getSignForm() throws Exception {
		StringBuffer strBfr = new StringBuffer();
		if (Cnstnts.MAINTAIN.equals(this.PageActionMode)
				&& Cnstnts.SIGN.equals(this.DbActionMode)
				&& this.getFlowKey().trim().length() > 0
				&& this.hasBindingFlow()) {
			strBfr.append(Html.getSignForm(this.FlowKey, this.userInfo,
					this.FlowStepName));
		}
		return strBfr.toString();
	}

	private String getCloseForm() throws Exception {
		StringBuffer strBfr = new StringBuffer();
		if (Cnstnts.MAINTAIN.equals(this.PageActionMode)
				&& Cnstnts.CLOSE.equals(this.DbActionMode)
				&& this.getFlowKey().trim().length() > 0
				&& this.hasBindingFlow()) {
			strBfr.append(Html.getCloseForm(this.FlowKey, this.userInfo,
					this.ProgramId));
		}
		return strBfr.toString();
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

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		if (this.getFindRecords() > 0) {
			int totalPages = ((this.getFindRecords() - (this.getFindRecords() % this
					.getPageRecords())) / this.getPageRecords()) + 1;
			if (this.getFindRecords() % this.getPageRecords() == 0)
				totalPages -= 1;
			if (this.getPageNo() == 0 || this.getPageNo() > totalPages)
				this.setPageNo(1);
			strBfr.append(newLine + "  <tr><td align='center' colspan='"
					+ this.getShowField().length + "'>");
			String selected10 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 10) {
				selected10 = " selected";
			}
			String selected20 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 20) {
				selected20 = " selected";
			}
			String selected50 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 50) {
				selected50 = " selected";
			}
			String selected100 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 100) {
				selected100 = " selected";
			}
			String selected200 = Cnstnts.EMPTY_STRING;
			if (this.getPageRecords() == 200) {
				selected200 = " selected";
			}
			strBfr.append(newLine
							+ "    "
							+ this.getUserInfo().getMsg("jsp.common.findTotal")
							+ this.getFindRecords()
							+ getUserInfo().getMsg("jsp.common.datas")
							+ "/"
							+ this.getUserInfo().getMsg("jsp.common.prePage")
							+ "<select id='pageRecords' name='pageRecords' "
							+ "onChange='document.input.doSearchFlag.value=\"true\";"
							+ "document.input.pageNo.value=\"1\";setValue()'>"
							+ "<option value='10'" + selected10
							+ ">10</option>" + "<option value='20'"
							+ selected20 + ">20</option>"
							+ "<option value='50'" + selected50
							+ ">50</option>" + "<option value='100'"
							+ selected100 + ">100</option>"
							+ "<option value='200'" + selected200
							+ ">200</option>" + "</select>"
							+ this.getUserInfo().getMsg("jsp.common.datas")
							+ "/"
							+ this.getUserInfo().getMsg("jsp.common.total")
							+ totalPages
							+ this.getUserInfo().getMsg("jsp.common.page"));
			if (this.getPageNo() > 2) {
				strBfr.append(newLine
								+ "    <img src='img/icon_03.gif' style='cursor: hand' border='0' "
								+ "title='"
								+ this.getUserInfo().getMsg(
										"jsp.common.firstPage")
								+ "' "
								+ "onClick='document.input.pageNo.value=\"1\";"
								+ "document.input.doSearchFlag.value=\"true\";setValue()'/>");
			}
			if (this.getPageNo() > 1) {
				strBfr.append(newLine
								+ "    <img src='img/icon_06.gif' style='cursor: hand' border='0' "
								+ "title='"
								+ this.getUserInfo().getMsg(
										"jsp.common.backPage")
								+ "' "
								+ "onClick='document.input.pageNo.value=\""
								+ (this.getPageNo() - 1)
								+ "\";"
								+ "document.input.doSearchFlag.value=\"true\";setValue()'/>");
			}
			strBfr.append(newLine
							+ "    <select id='pageNo' name='pageNo' "
							+ "onChange='document.input.doSearchFlag.value=\"true\";setValue()'>");
			for (int i = 1; i <= totalPages; i++) {
				String selectedStr = Cnstnts.EMPTY_STRING;
				if (i == this.getPageNo())
					selectedStr = Cnstnts.SELECTED;
				strBfr.append(newLine + "      <option value='" + i + "'"
						+ selectedStr + ">");
				strBfr.append(newLine + "        "
						+ this.getUserInfo().getMsg("jsp.function.page1") + i
						+ this.getUserInfo().getMsg("jsp.function.page2"));
				strBfr.append(newLine + "      </option>");
			}
			strBfr.append(newLine + "    </select>");
			if (totalPages > this.getPageNo()) {
				strBfr.append(newLine
								+ "    <img src='img/icon_05.gif' style='cursor: hand' border='0' "
								+ "title='"
								+ this.getUserInfo().getMsg(
										"jsp.common.forward")
								+ "' "
								+ "onClick='document.input.pageNo.value=\""
								+ (this.getPageNo() + 1)
								+ "\";"
								+ "document.input.doSearchFlag.value=\"true\";setValue()'/>");
			}
			if (totalPages > this.getPageNo() + 1) {
				strBfr.append(newLine
								+ "    <img src='img/icon_04.gif' style='cursor: hand' border='0' "
								+ "title='"
								+ this.getUserInfo().getMsg(
										"jsp.common.lastPage")
								+ "' "
								+ "onClick='document.input.pageNo.value=\""
								+ totalPages
								+ "\";"
								+ "document.input.doSearchFlag.value=\"true\";setValue()'/>");
			}
			strBfr.append(newLine + "  </td></tr>");
		}
		strBfr.append(newLine + "  <tr" + this.getThBgcolor()
				+ " style='cursor: hand' " + "title='"
				+ this.getUserInfo().getMsg("jsp.common.reOrder") + "'>");
		for (int i = 0; i < this.getShowField().length; i++) {
			String fieldName = this.getShowField()[i].getName();
			strBfr.append(newLine + "    <td align='center' onClick='setOrderKey(\""
					+ fieldName + "\")'" + ">");
			strBfr.append(newLine
					+ "      "
					+ this.getUserInfo().getMsg(
							this.getProgramId() + "." + fieldName));
			if (this.getOrderKey().equals(fieldName)) {
				String imgSrc = "img/up_pointer.png";
				if (this.getOrderSequence().equals(Cnstnts.DESC))
					imgSrc = "img/down_pointer.png";
				strBfr.append(" <img src='" + imgSrc + "'>");
			}
			strBfr.append(newLine + "    </td>");
		}
		strBfr.append(newLine + "  </tr>");
		if (this.getSearchResult().size() > 0) {
			boolean showSubTotal = false;
			for (int i = 0; i < this.getSearchResult().size(); i++) {
				Object[] data = this.getSearchResult().get(i);
				String trBgcolor = this.getTrBgcolor1();
				if (i % 2 == 0)
					trBgcolor = this.getTrBgcolor2();
				strBfr.append(newLine + "  <tr" + trBgcolor
						+ " style='cursor: hand' " + "title='"
						+ this.getUserInfo().getMsg("jsp.common.viewDetail")
						+ "' "
						+ "onClick='document.input.currentRecord.value=\""
						+ (i + 1) + "\";document.input.dbActionMode.value=\"query\";"
						+"gotoData(\"" + data[0].toString()
						+ "\")'>");
				for (int j = 1; j < data.length; j++) {
					String showData = Cnstnts.EMPTY_STRING;
					if (data[j] != null) {
						showData = data[j].toString();
					}
					if (this.getShowField()[j - 1].subTotalFlag()
							&& this.getShowField()[j - 1].getDbType().equals(
									Cnstnts.INT)) {
						this.getShowField()[j - 1].setAlign(Cnstnts.RIGHT);
						int subTotal = this.getShowField()[j - 1].getSubTotal();
						if (showData.trim().length() == 0) {
							showData = "0";
						}
						this.getShowField()[j - 1].setSubtotal(subTotal
								+ Integer.parseInt(showData));
						showSubTotal = true;
						showData = Util
								.outFormat(Integer.parseInt(showData), 3);
					}
					if (this.getShowField()[j - 1].getMapingPrpt() != null) {
						String mapingName = this.getShowField()[j - 1]
						    					.getMapingPrpt().getProperty(showData);
						if(mapingName==null){
							mapingName = Cnstnts.EMPTY_STRING;
						}
						if (this.getShowField()[j - 1].notShowCode()) {
							showData = mapingName;
						} else {
							showData += "-" + mapingName;
						}
					}
					strBfr.append(newLine + "    <td "
							+ this.getShowField()[j - 1].printListWidth()
							+ this.getShowField()[j - 1].printAlign() + ">"
							+ showData + "</td>");
				}
				strBfr.append(newLine + "  </tr>");
			}
			if (showSubTotal) {
				strBfr.append(newLine + "  <tr>");
				for (int i = 0; i < this.getShowField().length; i++) {
					if (this.getShowField()[i].subTotalFlag()
							&& this.getShowField()[i].getDbType().equals(
									Cnstnts.INT)) {
						strBfr.append(newLine
								+ "    <td align='right'>"
								+ Util.outFormat(this.getShowField()[i]
										.getSubTotal(), 3) + "</td>");
					} else {
						strBfr.append(newLine + "    <td></td>");
					}
				}
				strBfr.append(newLine + "  </tr>");
			}
		} else {
			strBfr.append(newLine + "  <tr" + this.getTrBgcolor1() + ">");
			strBfr.append(newLine + "    <td align='center' colspan='"
					+ this.getShowField().length + "'>"
					+ this.getUserInfo().getMsg("jsp.common.noRecords")
					+ "</td>");
			strBfr.append(newLine + "  </tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}

	public String printErrorMessage() {
		StringBuffer strBfr = new StringBuffer();
		if (this.getErrorMessage().trim().length() > 0) {
			strBfr.append("<script>alert('" + this.getErrorMessage()
					+ "')</script>");
		}
		return strBfr.toString();
	}

	public String printMessage() {
		StringBuffer strBfr = new StringBuffer();
		if (this.Message.trim().length() > 0) {
			strBfr.append("<script>alert('" + this.Message + "')</script>");
		}
		if(this.getOpenerSetValue().equals(Cnstnts.TRUE_FLAG)
				&& this.SubmitFlag.equals(Cnstnts.TRUE_FLAG)){
			this.setJavascriptCode("this.opener.setValue();"+this.getJavascriptCode());
		}
		if (this.JavascriptCode.trim().length() > 0) {
			strBfr.append("<script>" + this.JavascriptCode + "</script>");
		}
		if (this.ForwardPage.trim().length() > 0) {
			strBfr.append("<script>location.replace('" + this.ForwardPage
					+ "')</script>");
		}
		return strBfr.toString();
	}

	public List<Object[]> getSearchList() throws Exception {
		return null;
	}
	
	public List<Object[]> doSearch(String whereStr,String AliasName) throws Exception {
		whereStr = this.getDataAuthorityWhereSQL(whereStr);
		String SQL = "select *," + AliasName + " from " + this.TableName + " " + whereStr;
		SQL = Util.addOrderSQL(SQL, this.OrderKey, this.OrderSequence);
		if (this.PageNo == 0)
			this.setPageNo(1);
		int recordCount = 0;

		List<Object[]> rtnList = new ArrayList<Object[]>();

		Iterator<?> itr = this.getDbUtil().getList(SQL, this.ShowField).iterator();
		while (itr.hasNext()) {
			Object[] record = (Object[]) itr.next();
			recordCount++;
			if (recordCount <= this.PageNo * this.PageRecords
					&& recordCount > (this.PageNo - 1) * this.PageRecords) {
				rtnList.add(record);
			}
		}
		this.setFindRecords(recordCount);
		return rtnList;
	}
	
	public List<Object[]> doSearch(String whereStr) throws Exception {
		whereStr = this.getDataAuthorityWhereSQL(whereStr);
		String SQL = "select * from " + this.TableName + " " + whereStr;
		SQL = Util.addOrderSQL(SQL, this.OrderKey, this.OrderSequence);
		if (this.PageNo == 0)
			this.setPageNo(1);
		int recordCount = 0;

		List<Object[]> rtnList = new ArrayList<Object[]>();

		Iterator<?> itr = this.getDbUtil().getList(SQL, this.ShowField).iterator();
		while (itr.hasNext()) {
			Object[] record = (Object[]) itr.next();
			recordCount++;
			if (recordCount <= this.PageNo * this.PageRecords
					&& recordCount > (this.PageNo - 1) * this.PageRecords) {
				rtnList.add(record);
			}
		}
		this.setFindRecords(recordCount);
		return rtnList;
	}

	public boolean chkPkey() {
		return this.getDbUtil().chkPkey(this.FlowKey);
	}

	public boolean dbExecute() throws Exception {
		this.resetError();
		if (this.userInfo == null) {
			this.ErrorMessage = "no userInfo object";
			return false;
		}
		if (this.checkHasError()) {
			return false;
		} else {
			if (Cnstnts.SIGN.equals(this.DbActionMode)) {
				this.doSignProcess();
				this.doApproveProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.signForm.send"));
				this.ForwardPage = "menu.jsp";
			} else if (Cnstnts.CLOSE.equals(this.DbActionMode)) {
				this.doCloseProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.closeForm.closed"));
				this.ForwardPage = "menu.jsp";
			} else if (Cnstnts.INSERT.equals(this.DbActionMode)) {
				if (this.getApplicant().trim().length() == 0) {
					this.setApplicant(this.userInfo.getAttribute("emp_id"));
				}
				if (this.getCreateDept().trim().length() == 0) {
					this.setCreateDept(this.userInfo.getAttribute("dept_id"));
				}
				if (this.insert()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
									  this.FlowKey.getValue(), 
									  this.getProgramId(), 
									  this.getUserInfo().getAttribute("emp_id"), 
									  this.getApplicant(),
									  this.getTableName(), 
									  this.AliasName);
					}
					this.doOtherInsertProcess();
					this.Message = this.userInfo.getMsg("jsp.chkData.insert");
					this.ForwardPage = this.getTableName()+".jsp?_pageActionMode="+Cnstnts.MAINTAIN +
							"&_flowKey="+this.getFlowKey()+"&_getDataFlag=true";
				} else {
					this.setErrorMessage(this.TableName + ".insert() error!!");
					return false;
				}
			} else if (Cnstnts.UPDATE.equals(this.DbActionMode)) {
				if (this.update()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
								  	  this.FlowKey.getValue(), 
								  	  this.getProgramId(), 
								  	  this.getUserInfo().getAttribute("emp_id"), 
								  	  this.getApplicant(),
								  	  this.getTableName(), 
								  	  this.AliasName);
					}
					this.doOtherUpdateProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.update"));
					this.ForwardPage = this.getTableName()+".jsp?_pageActionMode="+Cnstnts.MAINTAIN +
						"&_flowKey="+this.getFlowKey()+"&_getDataFlag=true";
				} else {
					this.setErrorMessage(this.TableName + ".update() error!!");
					return false;
				}
			} else if (Cnstnts.DELETE.equals(this.DbActionMode)) {
				if (this.delete()) {
					this.doOtherDeleteProcess();
					this.clearAttribute();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.delete"));
					if(this.getUserInfo().getProgramMode(this.getProgramId()).equals("B")){
						this.ForwardPage = this.getTableName()+".jsp?doSearchFlag=true" +
								"&_pageActionMode="+Cnstnts.SEARCH;
					} else {
						this.ForwardPage = this.getTableName()+".jsp?_pageActionMode="+Cnstnts.MAINTAIN;
					}
				} else {
					this.setErrorMessage(this.TableName + ".delete() error!!");
					return false;
				}
			}
			return true;
		}
	}

	public void doOtherDeleteProcess() throws Exception {
	}

	public void doOtherUpdateProcess() throws Exception {
	}

	public void doOtherInsertProcess() throws Exception {
	}

	public void doPrintProcess() throws Exception {
	}

	public void doSignProcess() throws Exception {
		if (this.hasBindingFlow()) {
			if (Cnstnts.TRUE_FLAG.equals(this.BackToSrcSigner)) {
				Flow flow = new Flow(this.getFlowKey());
				flow.setSigner_id(flow.getSrcSigner_id());
				flow.setSigner_name(new Employee(flow.getSrcSigner_id()).Emp_name.getValue());
				flow.update();

				Flow_detail fd = new Flow_detail();
				fd.setFlowKey(this.getFlowKey());
				fd.setSeq_no(this.FlowStep);
				fd.setStep(this.FlowStep);
				fd.setStep_name(userInfo
						.getMsg("jsp.closeForm.sendBackFlowName"));
				fd.setMemo(this.SignMemo);
				fd.setSigner_id(userInfo.getAttribute("emp_id"));
				fd.setSigner_name(userInfo.getAttribute("user_name"));
				fd.setSigner_title(userInfo.getAttribute("jobName"));
				fd.setSigner_department(userInfo.getAttribute("DeptName"));
				fd.setSigned_result("sendBack");
				fd.setSigned_time(Util.getDateTime());
				fd.insert();
			} else {
				if ("2".equals(this.Agree)) {
					String backInfo[] = this.BackStep.split("-");
					Flow flow = new Flow(this.getFlowKey());
					flow.setFinished_steps(Integer.parseInt(backInfo[0]) - 1);
					flow.setSigner_id(backInfo[1]);
					flow.setSigner_name(backInfo[2]);
					flow.setSrcSigner_id(backInfo[1]);
					flow.update();

					Flow_detail fd = new Flow_detail();
					fd.setFlowKey(this.getFlowKey());
					fd.setSeq_no(this.FlowStep);
					fd.setStep(this.FlowStep);
					fd.setStep_name(this.FlowStepName);
					fd.setMemo(this.SignMemo);
					fd.setSigner_id(userInfo.getAttribute("emp_id"));
					fd.setSigner_name(userInfo.getAttribute("user_name"));
					fd.setSigner_title(userInfo.getAttribute("jobName"));
					fd.setSigner_department(userInfo.getAttribute("DeptName"));
					fd.setSigned_result("backSigner");
					fd.setSigned_time(Util.getDateTime());
					fd.insert();
				} else {
					String signed_result = "reject";
					if ("1".equals(this.Agree)) {
						signed_result = "agree";
					}
					Flow_detail fd = new Flow_detail();
					fd.setFlowKey(this.getFlowKey());
					fd.setMemo(this.SignMemo);
					fd.setSigner_id(userInfo.getAttribute("emp_id"));
					fd.setSigner_name(userInfo.getAttribute("user_name"));
					fd.setSigner_title(userInfo.getAttribute("jobName"));
					fd.setSigner_department(userInfo.getAttribute("DeptName"));
					fd.setSigned_result(signed_result);
					fd.setDecided(this.Decide);
					fd.setSigned_time(Util.getDateTime());

					FlowEngin.run(fd);
				}
			}
		}
	}

	public void doCloseProcess() throws Exception {
		if (Cnstnts.TRUE_FLAG.equals(this.CloseReject)) {
			Flow flow = new Flow(this.getFlowKey());
			flow.setDecider_id(userInfo.getAttribute("emp_id"));
			flow.setDecider_name(userInfo.getAttribute("user_name"));
			flow.setTotal_steps(this.FlowStep);
			flow.setFinished_steps(this.FlowStep);
			flow.setStatus("reject");
			flow.setCloseFlag("N");
			flow.setClosed_time(Util.getDateTime());
			flow.update();

			Flow_detail fd = new Flow_detail();
			fd.setFlowKey(this.getFlowKey());
			fd.setSeq_no(this.FlowStep);
			fd.setStep(this.FlowStep);
			fd.setStep_name(userInfo.getMsg("jsp.closeForm.closeReject"));
			fd.setDecided("1");
			fd.setSigner_id(userInfo.getAttribute("emp_id"));
			fd.setSigner_name(userInfo.getAttribute("user_name"));
			fd.setSigner_title(userInfo.getAttribute("jobName"));
			fd.setSigner_department(userInfo.getAttribute("DeptName"));
			fd.setSigned_time(Util.getDateTime());
			fd.setSigned_result("reject");
			fd.setMemo(this.RejectReason);
			fd.insert();
		} else {
			Flow flow = new Flow(this.getFlowKey());
			flow.setClosed_time(Util.getDateTime());
			flow.update();
		}
	}

	protected String getLogSQL(HashMap<?, ?> beforeMap) throws Exception {
		return new LogInfo().getLogInfoSQL(beforeMap, this.getAttributesMap(),
				this.userInfo.getAttribute("language"), this.DbActionMode);
	}

	public boolean checkHasError() throws Exception {
		if (Cnstnts.INSERT.equals(this.DbActionMode)) {
			if (this.checkInsertError()) {
				return true;
			}
			if (this.chkPkey()) {
				this.ErrorMessage = this.userInfo.getMsg("jsp.chkData.idError");
				return true;
			}
			if (this.getFlowKey().trim().length() == 0){
				this.setFlowKey(FlowEngin.getFlowKey(this.ProgramId));
			}
			if (this.getFlowKey().trim().length() == 0) {
				this.ErrorMessage = this.userInfo.getMsg("jsp.chkData.noIdError");
				return true;
			}
			if (this.chkPkey()) {
				this.ErrorMessage = this.userInfo.getMsg("jsp.chkData.idError");
				return true;
			}
		}
		if (Cnstnts.UPDATE.equals(this.DbActionMode)
				|| Cnstnts.DELETE.equals(this.DbActionMode)) {
			if (this.hasBindingFlow()) {
				if (!FlowEngin.getUpdateFlag(this.getFlowKey())) {
					this.ErrorMessage = this.userInfo
							.getMsg("jsp.chkData.flow");
					return true;
				}
			}
			if (Cnstnts.UPDATE.equals(this.DbActionMode)) {
				if (checkUpdateError()) {
					return true;
				}
			} else {
				if (checkDeleteError()) {
					return true;
				}
			}
		}
		if (Cnstnts.SIGN.equals(this.DbActionMode)) {
			if (checkSignError()) {
				return true;
			}
			if (!"1".equals(this.Agree) && this.SignMemo.trim().length() == 0) {
				this.ErrorMessage = this.userInfo
						.getMsg("jsp.closeForm.rejectReason");
				return true;
			}
			if (Cnstnts.TRUE_FLAG.equals(this.BackToSrcSigner)
					&& this.SignMemo.trim().length() == 0) {
				this.ErrorMessage = this.userInfo
						.getMsg("jsp.closeForm.backToSrcSigner");
				return true;
			}
		}
		if (Cnstnts.CLOSE.equals(this.DbActionMode)) {
			if (Cnstnts.TRUE_FLAG.equals(this.CloseReject)
					&& this.RejectReason.trim().length() == 0) {
				this.ErrorMessage = this.userInfo
						.getMsg("jsp.closeForm.rejectReason");
				return true;
			}
		}
		return false;
	}

	protected boolean checkFieldEmptyError() throws Exception {
		this.setDbFields();
		for (Iterator<Field> itr = this.DbFields.iterator(); itr.hasNext();) {
			Field field = (Field) itr.next();
			if (field != null) {
				if (field.checkEmpty()) {
					if (field.getValue().trim().length() == 0) {
						String errorMsg = this.userInfo.getMsg(ProgramId + "."
								+ field.getName())
								+ this.userInfo.getMsg("jsp.common.EmptyError");
						this.setTagId(field.getTagName());
						this.setErrorMessage(errorMsg);
						return true;
					}
				}
				if (field.getValue().trim().length() > 0) {
					if (Cnstnts.DB_TYPE_INT.equals(field.getDbType())) {
						if (!Util.chkIntVaule(field.getValue())) {
							String errorMsg = this.userInfo
									.getMsg("jsp.common.intError");
							this.setTagId(field.getTagName());
							this.setErrorMessage(errorMsg);
							return true;
						}
					} else if (Cnstnts.DB_TYPE_FLOAT.equals(field.getDbType())) {
						if (!Util.chkFloatVaule(field.getValue())) {
							String errorMsg = this.userInfo
									.getMsg("jsp.common.intError");
							this.setTagId(field.getTagName());
							this.setErrorMessage(errorMsg);
							return true;
						}
					} else {
						if (field.getValue().indexOf("'") != -1) {
							String errorMsg = this.userInfo
									.getMsg("jsp.common.charError");
							this.setTagId(field.getTagName());
							this.setErrorMessage(errorMsg);
							return true;
						}
					}
				} else {
					if (field.getDbType().equals(Cnstnts.DB_TYPE_INT)) {
						field.setValue("0");
					} else if (field.getDbType().equals(Cnstnts.DB_TYPE_FLOAT)) {
						field.setValue("0.0");
					}
				}
			}
		}
		return false;
	}

	public boolean checkInsertError() throws Exception {
		return this.checkFieldEmptyError();
	}

	public boolean checkUpdateError() throws Exception {
		return this.checkFieldEmptyError();
	}

	public boolean checkDeleteError() throws Exception {
		return false;
	}

	public boolean checkSignError() throws Exception {
		return false;
	}

	public void doApproveProcess() throws Exception {
	}

	@SuppressWarnings("unchecked")
	public boolean insert() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.FlowKey.setValue(this.FlowKey.getValue().trim());
		this.setDbFields();
		sqlList.add(this.getDbUtil()
				.getInsertSQL(this.TableName, this.DbFields));
		if (this.Details != null && this.Details.size() > 0) {
			int i = 1;
			for (Iterator itr = this.Details.iterator(); itr.hasNext(); i++) {
				List<Field> detailFields = (List<Field>) itr.next();
				sqlList.add(this.getDbUtil().getDetailInsertSQL(this.FlowKey,
						i, detailFields));
			}
		}
		return this.getDbUtil().executeUpdate(sqlList);
	}

	@SuppressWarnings("unchecked")
	public boolean update() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.setDbFields();
		sqlList.add(this.getDbUtil()
				.getUpdateSQL(this.TableName, this.DbFields));
		if (this.Details != null) {
			sqlList.add("delete from " + this.TableName
					+ "_detail where FlowKey='" + this.getFlowKey() + "'");
			if (this.Details.size() > 0) {
				int i = 1;
				for (Iterator itr = this.Details.iterator(); itr.hasNext(); i++) {
					List<Field> detailFields = (List<Field>) itr.next();
					sqlList.add(this.getDbUtil().getDetailInsertSQL(
							this.FlowKey, i, detailFields));
				}
			}
		}
		if (new Program(this.ProgramId).getLogUpdate().equals("1")) {
			HashMap beforeMap = this.getAttributesMap(this.FlowKey);
			if (beforeMap != null) {
				sqlList.add(this.getLogSQL(beforeMap));
			}
		}
		return this.getDbUtil().executeUpdate(sqlList);
	}

	public boolean delete() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.setDbFields();
		if (this.hasBindingFlow()) {
			sqlList.add("delete from Flow where FlowKey='" + this.getFlowKey()
					+ "'");
			sqlList.add("delete from Flow_detail where FlowKey='"
					+ this.getFlowKey() + "'");
		}
		sqlList.add("delete from " + this.TableName + " where FlowKey='"
				+ this.getFlowKey() + "'");
		if (this.Details != null) {
			sqlList.add("delete from " + this.TableName
					+ "_detail where FlowKey='" + this.getFlowKey() + "'");
		}
		if (new Program(this.ProgramId).getLogDelete().equals("1")) {
			sqlList.add(this.getLogSQL(null));
		}
		return this.getDbUtil().executeUpdate(sqlList);
	}

	protected String getDataAuthorityWhereSQL(String whereStr) throws Exception {
		whereStr = Util.addWhereSQL(whereStr, this.FlowKey);
		whereStr = Util.addWhereOrAnd(whereStr, this.Applicant.getName(),this.Creator);
		if(this.getDataDept().trim().length()>0){
			String deptStr = "CreateDept in('"+this.getDataDept()+"'";
			Department dept = new Department(this.getDataDept());
			SelectItem item = dept.getSelectItem();
			for (Iterator<?> itr = dept.getTreeList(item).iterator(); itr.hasNext();) {
				SelectItem dptItem = (SelectItem) itr.next();
				deptStr += ",'" + dptItem.getKey() + "'";
			}
			deptStr += ")";
			if (deptStr.length() > 0) {
				if (whereStr.length() > 0) {
					whereStr += " and " + deptStr;
				} else {
					whereStr = " where " + deptStr;
				}
			}
		}
		if (!userInfo.canQueryAll(this.ProgramId)) {
			if (!userInfo.canQueryDept(this.ProgramId)) {
				if(this.Applicant.getValue().trim().length()==0){
					this.setApplicant(userInfo.getAttribute("emp_id"));
				}
				whereStr = Util.addWhereSQL(whereStr, this.Applicant);
			} else {
				String deptStr = "CreateDept in('" + this.userInfo.getAttribute("dept_id") + "'";
				int i = 0;
				Department dept = new Department(this.userInfo.getAttribute("dept_id"));
				SelectItem item = dept.getSelectItem();
				for (Iterator<?> itr = dept.getTreeList(item).iterator(); itr.hasNext(); i++) {
					SelectItem dptItem = (SelectItem) itr.next();
					deptStr += ",'" + dptItem.getKey() + "'";
				}
				deptStr += ")";
				if (deptStr.length() > 0) {
					if (whereStr.length() > 0) {
						whereStr += " and " + deptStr;
					} else {
						whereStr = " where " + deptStr;
					}
				}
			}
		}
		return whereStr;
	}

	public Properties getNamesPrpts(Field field) throws Exception {
		return this.getDbUtil().getNamesPrpts(field);
	}

	public Properties getNamesPrpts() throws Exception {
		return null;
	}

	public HashMap<String, String> getAttributesMap() {
		this.setDbFields();
		HashMap<String, String> attsMap = new HashMap<String, String>();
		attsMap.put("TableName", this.TableName);
		for (Iterator<Field> itr = this.DbFields.iterator(); itr.hasNext();) {
			Field dbField = (Field) itr.next();
			attsMap.put(dbField.getName(), dbField.getValue());
		}
		return attsMap;
	}

	public HashMap<?, ?> getAttributesMap(Field FlowKey) {
		return this.getDbUtil().getAttributesMap(this.FlowKey,
				this.getAttributesMap());
	}
	
	public HashMap<String, String> getBasicDocMap() {
		this.setDbFields();
		HashMap<String, String> attsMap = new HashMap<String, String>();
		for (Iterator<Field> itr = this.DbFields.iterator(); itr.hasNext();) {
			Field dbField = (Field) itr.next();
			attsMap.put("${"+dbField.getName()+"}", dbField.getValue());
		}
		return attsMap;
	}
	
	public HashMap<?, ?> getDocMap(String SQL, HashMap<String, String> fieldMap) {
		return this.getDbUtil().getDocMap(SQL,fieldMap);
	}

	public void getAttribute() {
		if (this.FlowKey.getValue().trim().length() == 0) {
			return;
		}
		this.setDbFields();
		this.getDbUtil().getAttribute(this.FlowKey, this.DbFields);
	}

	public void clearAttribute() {
		this.setCreator(Cnstnts.EMPTY_STRING);
		this.setDataDept(Cnstnts.EMPTY_STRING);
		this.FlowStepName = Cnstnts.EMPTY_STRING;
		this.FlowStep = 0;
		this.setDbFields();
		for (Iterator<Field> itr = this.DbFields.iterator(); itr.hasNext();) {
			Field field = (Field) itr.next();
			field.setValue(Cnstnts.EMPTY_STRING);
		}
		if (this.Details != null) {
			this.setDetails(new ArrayList<List<Field>>());
		}
	}

	public void doAction(UserBean userInfo) throws Exception {
		this.setUserInfo(userInfo);
		if (this.getApplicant().trim().length() == 0) {
			this.setApplicant(userInfo.getAttribute("emp_id"));
		}
		if (this.getCreateDept().trim().length() == 0) {
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
		if (Cnstnts.PRINT.equals(this.getDbActionMode())
				&& Cnstnts.MAINTAIN.equals(this.getPageActionMode())
				&& this.onBtnSubmit() && this.getFlowKey().trim().length() > 0) {
			this.doPrintProcess();
		}
		if ((Cnstnts.SIGN.equals(this.getDbActionMode()) 
				|| Cnstnts.CLOSE.equals(this.getDbActionMode()))
						&& Cnstnts.MAINTAIN.equals(this.getPageActionMode())
								&& this.getFlowKey().trim().length() > 0) {
			Flow f = new Flow(this.getFlowKey());
			this.setFlowStep(f.getFinished_steps() + 1);
			this.setFlowStepName(FlowEngin.getStep_name(Util.getFlowInfo(f.getFlow_id()), this.getFlowStep()));
		} else {
			this.setFlowStepName(Cnstnts.EMPTY_STRING);
			this.setFlowStep(0);
		}
		if (this.getDataFromDB()) {
			this.setPreObj(userInfo);
			this.getAttribute();
		} else {
			if (userInfo.getObj(this.getTableName()) != null) {
				this.setPreObj(userInfo);
				if (this.canAccessDB())
					this.dbExecute();
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

	public void setPreObj(UserBean userInfo) throws Exception {
	}

	public String onAjaxRequest(String dataValue, String tagMode) {
		return "you must over write onAjaxRequest(String '" + dataValue + "',"
				+ "String '" + tagMode + "') methord in " + this.TableName+ ".java";
	}
	
	public String onAjaxRequest(String dataValue,String otherValue,String flashMode) throws Exception{
		return null;
	}

	public String getErrorMessage(Field field) throws Exception {
		return this.getUserInfo().getMsg(
				this.getProgramId() + "." + field.getName() + ".Error");
	}

	public String getEditImg(int record) throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.canEdit()) {
			rtnString = Html.getEditImg(this.getUserInfo(), record);
		}
		return rtnString;
	}

	public String getInsertImg() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.canEdit()) {
			rtnString = Html.getInsertImg(this.getUserInfo());
		}
		return rtnString;
	}

	public String getDeleteImg() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.canEdit()) {
			rtnString = Html.getDeleteImg(this.getUserInfo());
		}
		return rtnString;
	}

	public String getDeleteCheckbox(int record) throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.canEdit()) {
			rtnString = Html.getDeleteCheckbox(this.getUserInfo(), record);
		}
		return rtnString;
	}

}