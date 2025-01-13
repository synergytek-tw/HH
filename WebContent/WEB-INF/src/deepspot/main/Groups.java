package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.Html;
import deepspot.util.Util;

public class Groups extends MasterBean {

	public Field Names;
	public void setNames(String Names) {
		this.Names.setValue(Names);
	}
	public String getNames() {
		return this.Names.getValue();
	}
	
	public Field Leader;
	public void setLeader(String Leader) {
		this.Leader.setValue(Leader);
	}
	public String getLeader() {
		return this.Leader.getValue();
	}

	public Field DateFrom;
	public void setDateFrom(String DateFrom) {
		this.DateFrom.setValue(DateFrom);
	}
	public String getDateFrom() {
		return this.DateFrom.getValue();
	}

	public Field DateTo;
	public void setDateTo(String DateTo) {
		this.DateTo.setValue(DateTo);
	}
	public String getDateTo() {
		return this.DateTo.getValue();
	}
	
	public Groups_detail myDetail;
	public void setMyDetail(Groups_detail myDetail){
		this.myDetail = myDetail;
	}
	public Groups_detail getMyDetail(){
		return this.myDetail;
	}

	public Groups() {
		this.init();
	}

	public Groups(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.Groups");
		this.setTableName("Groups");

		this.Names = new Field("Names", this.getTableName());
		this.Names.setCheckEmpty(true);
		this.Names.setSearchCondition(Cnstnts.LIKE);
		
		this.Leader = new Field("Leader", this.getTableName());
		this.Leader.setCheckEmpty(true);
		
		this.DateFrom = new Field("DateFrom", this.getTableName());
		this.DateFrom.setCheckEmpty(true);
		
		this.DateTo = new Field("DateTo", this.getTableName());
		this.DateTo.setCheckEmpty(true);

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
		
		this.myDetail = new Groups_detail();
		this.setDetails(new ArrayList<List<Field>>());
	}

	public void setDbFields() {
		super.setDbFields();
		this.DbFields.add(this.Names);
		this.DbFields.add(this.Leader);
		this.DbFields.add(this.DateFrom);
		this.DbFields.add(this.DateTo);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {			
			this.Leader.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Leader.setSelectList(new Employee().getList());
			
			this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Names.setAnotherField(this.Leader);
			rtnString += this.printHtml(this.Names);

			this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.DateFrom.setAnotherField(this.DateTo);
			rtnString += this.printHtml(this.DateFrom);
		}
		return rtnString;
	}

	public String printMaintainTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onMaintainMode()) {			
			this.Leader.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
			this.Leader.setSelectList(new Employee().getList());
			
			this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.Names.setAnotherField(this.Leader);
			rtnString += this.printHtml(this.Names);

			this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

			this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.DateFrom.setAnotherField(this.DateTo);
			rtnString += this.printHtml(this.DateFrom);
			
			if(this.myDetail!=null){
				rtnString += this.printDetailTable();
			}
		}
		return rtnString;
	}

	public void setSearchListPrpts() {
		this.FlowKey.setListWidth("18%");
		
		this.Names.setListWidth("22%");
		
		this.Leader.setListWidth("18%");
		try {
			this.Leader.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.DateFrom.setListWidth("18%");
		
		this.DateTo.setListWidth("18%");
		
		Field[] showField = { this.FlowKey, this.Names, this.Leader,
							  this.DateFrom, this.DateTo};
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Names);
		whereStr = Util.addWhereSQL(whereStr, this.Leader);
		whereStr = Util.addBetweenSQL(whereStr, this.DateFrom, this.DateTo);
		return this.doSearch(whereStr);
	}
	
	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Names);
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			Groups preObj = (Groups) userInfo.getObj(this.getTableName());
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
	
	@SuppressWarnings("unchecked")
	private String printDetailTable() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine+"</table>";
		rtnString+=newLine+Html.getJavaScriptFunction(this.getTableName());
		rtnString+=newLine+"<table"+Cnstnts.DEFAULT_TABLE_BGCOLOR+">";
		rtnString+=newLine+"  <tr><td colspan='"+this.myDetail.getDbFields().size()+"'>"
						  +this.myDetail.getPageTitle()+"</td></tr>";
		rtnString+=newLine+"  <tr"+Cnstnts.DEFAULT_TH_BGCOLOR+">";
		rtnString+=newLine+"    <td width='3%' align='center'>"+this.getInsertImg()+"</td>";
		for(Iterator itr=this.myDetail.getDbFields().iterator();itr.hasNext();){
			Field detailField = (Field)itr.next();
			if(detailField!=null 
					&& !"FlowKey".equals(detailField.getName()) 
							&& !"Seq_no".equals(detailField.getName())){
				rtnString += newLine+"    <td align='center'>"+
							 this.myDetail.getAlias(detailField)+"</td>";
			}
		}
		rtnString+=newLine+"    <td width='3%' align='center'>"+this.getDeleteImg()+"</td>";
		rtnString+=newLine+"  </tr>";
		Properties categoryNamePrpts = new Category().getNamesPrpts();
		Properties employeeNamePrpts = new Employee().getNamesPrpts();
		if(this.getDetails()!=null && this.getDetails().size()>0){
			int i=0;
			for(Iterator detailItr=this.getDetails().iterator();detailItr.hasNext();i++){
				List<Field> fields = (List<Field>)detailItr.next();
				String trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
				if(i%2==0) trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
				rtnString += newLine+"  <tr"+trBgcolor+">";
				rtnString += newLine+"    <td align='center'>"+this.getEditImg(i)+"</td>";
				for(Iterator fieldsItr=fields.iterator();fieldsItr.hasNext();){
					Field detailField = (Field)fieldsItr.next();
					if(detailField!=null 
							&& !"FlowKey".equals(detailField.getName()) 
									&& !"Seq_no".equals(detailField.getName())){
						String showName = detailField.getValue();
						if(detailField.getName().equals(
								this.myDetail.JobTitle.getName())){
							if(categoryNamePrpts.getProperty(showName)!=null){
								showName += "-"+categoryNamePrpts.getProperty(showName);
							}
						}
						if(detailField.getName().equals(
								this.myDetail.Emp_id.getName())){
							if(employeeNamePrpts.getProperty(showName)!=null){
								showName += "-"+employeeNamePrpts.getProperty(showName);
							}
						}
						rtnString += newLine+"    <td width='23%'>"+showName+"</td>";
					}
				}
				rtnString += newLine+"    <td align='center'>"+
							 this.getDeleteCheckbox(i)+"</td>";
				rtnString += newLine+"  </tr>";
			}
		}
		if(this.canEdit()){
			rtnString += newLine + "  <tr><td colspan='"+this.myDetail.getDbFields().size()+
						"' align='center'>" + "<div id='showDetail'></div></td></tr>";
		}
		return rtnString;
	}
	
	public void doAction(UserBean userInfo) throws Exception{
		if(this.myDetail!=null){
			this.myDetail.setUserInfo(userInfo);
			if (this.getDataFromDB()) {
				this.setDetails(this.myDetail.getDetails(this.FlowKey.getValue()));
			}
		}
		super.doAction(userInfo);
	}
	
	public List<SelectItem> getLeaderList(String leader) throws Exception {
		String SQL = "select * from " + this.getTableName()
					 + " where Leader='" + leader + "'";
		return this.getDbUtil().getSelectItemList(SQL, this.Names);
	}
	
	public boolean inGorup(String groupId, String empId) throws Exception {
		String SQL = "select FlowKey from Groups "+
		 			 "where FlowKey='"+groupId+"' and Leader='" + empId + "' "+
		 			 "UNION "+
		 			 "select FlowKey from Groups_detail "+
		 			 "where FlowKey='"+groupId+"' and Emp_id='" + empId + "' ";
		if(this.getDbUtil().getSelectItemList(SQL, this.FlowKey).size()>0){
			return true;
		}
		return false;
	}

}