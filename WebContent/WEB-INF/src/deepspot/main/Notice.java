package deepspot.main;

import java.sql.ResultSet;
import java.util.*;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.Html;
import deepspot.util.DB;
import deepspot.util.Util;

public class Notice extends MasterBean {

	public Field Summary;
	public void setSummary(String Summary){this.Summary.setValue(Summary);}
	public String getSummary(){return this.Summary.getValue();}

	public Field Content;
	public void setContent(String Content){this.Content.setValue(Content);}
	public String getContent(){return this.Content.getValue();}

	public Field Appendix;
	public void setAppendix(String Appendix){this.Appendix.setValue(Appendix);}
	public String getAppendix(){return this.Appendix.getValue();}

	public Field DateFrom;
	public void setDateFrom(String DateFrom){this.DateFrom.setValue(DateFrom);}
	public String getDateFrom(){return this.DateFrom.getValue();}

	public Field DateTo;
	public void setDateTo(String DateTo){this.DateTo.setValue(DateTo);}
	public String getDateTo(){return this.DateTo.getValue();}

	public Field LinkUrl;
	public void setLinkUrl(String LinkUrl){this.LinkUrl.setValue(LinkUrl);}
	public String getLinkUrl(){return this.LinkUrl.getValue();}

	public Field LinkTitle;
	public void setLinkTitle(String LinkTitle){this.LinkTitle.setValue(LinkTitle);}
	public String getLinkTitle(){return this.LinkTitle.getValue();}

	public Field UrlDateFrom;
	public void setUrlDateFrom(String UrlDateFrom){this.UrlDateFrom.setValue(UrlDateFrom);}
	public String getUrlDateFrom(){return this.UrlDateFrom.getValue();}

	public Notice_detail myDetail;
	public void setMyDetail(Notice_detail myDetail){
		this.myDetail = myDetail;
	}
	public Notice_detail getMyDetail(){
		return this.myDetail;
	}

	public Notice() {
		this.init();
	}

	public Notice(String FlowKey) {
		this.init();
		this.setFlowKey(FlowKey);
		this.getAttribute();
	}

	public void init() {
		super.init();
		this.setProgramId("jsp.Notice");
		this.setTableName("Notice");

		this.Summary = new Field("Summary", this.getTableName());
		this.Summary.setCheckEmpty(true);
		this.Summary.setSearchCondition(Cnstnts.LIKE);
		
		this.Content = new Field("Content", this.getTableName());
		this.Content.setCheckEmpty(true);
		
		this.Appendix = new Field("Appendix", this.getTableName());
		
		this.DateFrom = new Field("DateFrom", this.getTableName());
		this.DateFrom.setCheckEmpty(true);
		
		this.DateTo = new Field("DateTo", this.getTableName());
		this.DateTo.setCheckEmpty(true);
		
		this.LinkUrl = new Field("LinkUrl", this.getTableName());
		
		this.LinkTitle = new Field("LinkTitle", this.getTableName());
		
		this.UrlDateFrom = new Field("UrlDateFrom", this.getTableName());

		this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

		this.setSearchListPrpts();
		
		this.myDetail = new Notice_detail();
		this.setDetails(new ArrayList<List<Field>>());
	}
	
	public void setDbFields() {
		super.setDbFields();
		this.DbFields.add(this.Summary);
		this.DbFields.add(this.Content);
		this.DbFields.add(this.Appendix);
		this.DbFields.add(this.DateFrom);
		this.DbFields.add(this.DateTo);
		this.DbFields.add(this.LinkUrl);
		this.DbFields.add(this.LinkTitle);
		this.DbFields.add(this.UrlDateFrom);
	}

	public String printSearchTable() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if (this.onSearchMode()) {			
			this.Summary.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			this.Summary.setCols(50);
			this.Summary.setRows(2);
			rtnString += this.printHtml(this.Summary);

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
			this.Summary.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			this.Summary.setCols(50);
			this.Summary.setRows(2);
			rtnString += this.printHtml(this.Summary);
			
			this.Content.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
			this.Content.setCols(50);
			this.Content.setRows(5);
			rtnString += this.printHtml(this.Content);
			
			this.Appendix.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
			rtnString += this.printHtml(this.Appendix);

			this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

			this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			this.DateFrom.setAnotherField(this.DateTo);
			rtnString += this.printHtml(this.DateFrom);
			
			/*
			this.LinkUrl.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.LinkUrl.setSize(50);
			rtnString += this.printHtml(this.LinkUrl);
			
			this.UrlDateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
			
			this.LinkTitle.setHtmlType(Cnstnts.HTML_TAG_TEXT);
			this.LinkTitle.setAnotherField(this.UrlDateFrom);
			rtnString += this.printHtml(this.LinkTitle);
			*/
			
			if(this.myDetail!=null){
				rtnString += this.printDetailTable();
			}
		}
		return rtnString;
	}

	public void setSearchListPrpts() {
		this.FlowKey.setListWidth("15%");
		
		this.Applicant.setListWidth("15%");
		try {
			this.Applicant.setMapingPrpt(new Employee().getNamesPrpts());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.Summary.setListWidth("46%");
		
		this.DateFrom.setListWidth("12%");
		
		this.DateTo.setListWidth("12%");
		
		Field[] showField = { this.FlowKey, this.Applicant, this.Summary,
							  this.DateFrom, this.DateTo};
		this.setShowField(showField);
		this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
	}

	public List<Object[]> getSearchList() throws Exception {
		String whereStr = Cnstnts.EMPTY_STRING;
		whereStr = Util.addWhereSQL(whereStr, this.Summary);
		whereStr = Util.addBetweenSQL(whereStr, this.DateFrom, this.DateTo);
		return this.doSearch(whereStr);
	}

	public void clearAttribute() {
		super.clearAttribute();
		this.setDetails(new ArrayList<List<Field>>());
	}

	public Properties getNamesPrpts() throws Exception {
		return super.getNamesPrpts(this.Summary);
	}

	public void setPreObj(UserBean userInfo){
		if (userInfo.getObj(this.getTableName()) != null) {
			Notice preObj = (Notice) userInfo.getObj(this.getTableName());
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
		Properties empNamePrpts = new Employee().getNamesPrpts();
		Properties dptNamePrpts = new Department().getNamesPrpts();
		Properties grpNamePrpts = new Groups().getNamesPrpts();
		Properties prpts = new Properties();
		if(this.getDetails()!=null && this.getDetails().size()>0){
			int i=0;
			for(Iterator detailItr=this.getDetails().iterator();detailItr.hasNext();i++){
				List<Field> fields = (List<Field>)detailItr.next();
				String trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
				if(i%2==0) trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
				rtnString += newLine+"  <tr"+trBgcolor+">";
				rtnString += newLine+"    <td align='center'>"+
							 this.getEditImg(i)+"</td>";
				for(Iterator fieldsItr=fields.iterator();fieldsItr.hasNext();){
					Field detailField = (Field)fieldsItr.next();
					if(detailField!=null 
							&& !"FlowKey".equals(detailField.getName()) 
									&& !"Seq_no".equals(detailField.getName())){
						String showName = detailField.getValue();
						if(detailField.getName().equals(
								this.myDetail.AuthorityType.getName())){
							if(showName.equals("Department")){
								prpts = dptNamePrpts;
							} else 
							if(showName.equals("Employee")){
								prpts = empNamePrpts;
							} else
							if(showName.equals("Groups")){
								prpts = grpNamePrpts;
							}
							if(categoryNamePrpts.getProperty(showName)!=null){
								showName += "-"+categoryNamePrpts.getProperty(showName);
							}
						}
						if(detailField.getName().equals(
								this.myDetail.AuthorityId.getName())){
							if(prpts.getProperty(showName)!=null){
								showName += "-"+prpts.getProperty(showName);
							}
						}
						rtnString += newLine+"    <td width='47%'>"+showName+"</td>";
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
  
	public List<Notice> getPersonalList(String empId,String deptId) throws Exception {
		String groupString = Cnstnts.EMPTY_STRING;
    
		Iterator<?> itr = new Groups().getLeaderList(empId).iterator();
		while(itr.hasNext()){
			SelectItem obj = (SelectItem)itr.next();
			if(groupString.equals(Cnstnts.EMPTY_STRING)) 
				groupString += "'"+obj.getKey()+"'";
			else 
				groupString += "," + "'"+obj.getKey()+"'";
		}
    
		Groups_detail groupDetails = new Groups_detail();
		itr = groupDetails.getMemberList(empId).iterator();
		while(itr.hasNext()){
			SelectItem obj = (SelectItem)itr.next();
			if(groupString.equals(Cnstnts.EMPTY_STRING)) 
				groupString += "'"+obj.getKey()+"'";
			else 
				groupString += "," + "'"+obj.getKey()+"'";
		}
    
		if(!groupString.equals(""))
			groupString = " or (nd.AuthorityType='Groups' and nd.AuthorityId in(" + 
						  groupString + "))";
		
		List<Notice> rtnList = new ArrayList<Notice>();
    	String SQL="select n.* from Notice as n, Notice_detail as nd " +
                  "where (n.FlowKey = nd.FlowKey) and " +
                  "('" + Util.getDate() + "' between n.DateFrom and n.DateTo) and " +
                  "(nd.AuthorityType='All' or (nd.AuthorityType='Department' and nd.AuthorityId='" +
                  deptId+"') or " + "(nd.AuthorityType='Employee' and nd.AuthorityId='" +
                  empId+"')"+groupString+")";
    	DB db=null;
		ResultSet rs=null;
    	try {
    		db=new DB();
    		rs=db.executeQuery(SQL);
    		while(rs.next()) {
    			Notice obj=new Notice();
    			obj.setFlowKey(rs.getString("FlowKey"));
		        obj.setSummary(rs.getString("Summary"));
		        obj.setContent(rs.getString("Content"));
		        obj.setAppendix(rs.getString("Appendix"));
		        obj.setApplicant(rs.getString("Applicant"));
		        obj.setCreateDept(rs.getString("CreateDept"));
		        obj.setDateFrom(rs.getString("DateFrom"));
		        obj.setDateTo(rs.getString("DateTo"));
		        obj.setLinkUrl(rs.getString("LinkUrl"));
		        obj.setLinkTitle(rs.getString("LinkTitle"));
		        obj.setUrlDateFrom(rs.getString("UrlDateFrom"));
		        rtnList.add(obj);
    		}
    		rs.close();
    		db.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		rs=null;
    		db=null;
    	}
    	return rtnList;
	}

}