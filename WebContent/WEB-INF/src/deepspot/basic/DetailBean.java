package deepspot.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.html.HtmlHeadTag;
import deepspot.main.UserBean;
import deepspot.util.Util;
import deepspot.basic.Cnstnts;

public class DetailBean {

	public DetailBean(){
		this.init();
	}
	  
	public void init(){
		this.FlowKey = new Field("FlowKey", this.TableName);
		this.Seq_no = new Field("Seq_no", this.TableName);
		this.DbUtil = new DbUtil();
	}
	  
	private String MasterBeanName;
	public void setMasterBeanName(String MasterBeanName){
		this.MasterBeanName=MasterBeanName;
	}
	public String getMasterBeanName(){return this.MasterBeanName;}
	  
	private String TableName;
	public void setTableName(String TableName){this.TableName=TableName;}
	public String getTableName(){return this.TableName;}
	
	private DbUtil DbUtil;
	public void setDbUtil(DbUtil DbUtil){this.DbUtil = DbUtil;}
	public DbUtil getDbUtil(){
		if(this.DbUtil==null){
			this.DbUtil = new DbUtil();
		}
		return this.DbUtil;
	}
	  
	private UserBean userInfo;
	public void setUserInfo(UserBean userInfo){this.userInfo=userInfo;}
	public UserBean getUserInfo(){return this.userInfo;}
	  
	private List<Field> DbFields;
	public void setDbFields(List<Field> DbFields){
		this.DbFields=DbFields;
	}
	public void setDbFields(){
		this.DbFields = new ArrayList<Field>();
		this.DbFields.add(this.FlowKey);
		this.DbFields.add(this.Seq_no);
	}
	public List<Field> getDbFields(){
		return this.DbFields;
	}
	
	/* ========== about jspPage action properties & setter getter methord ========== */
	protected boolean closeFlag;
	public void setCloseFlag(boolean closeFlag){this.closeFlag=closeFlag;}
	public boolean CloseFlag(){return this.closeFlag;}
	
	private String firstFlag;
	public void setFirstFlag(String firstFlag){this.firstFlag=firstFlag;}
	public String getFirstFlag(){return this.firstFlag;}
	public boolean FirstFlag(){
	  if(this.firstFlag!=null && Cnstnts.TRUE_FLAG.equals(this.firstFlag)){
		  return true;
	  } else {
		  return false;
	  }
	}
	
	private String SubmitFlag=Cnstnts.EMPTY_STRING;
	public void setSubmitFlag(String SubmitFlag){this.SubmitFlag=SubmitFlag;}
	public String getSubmitFlag(){return this.SubmitFlag;}
	  
	public Field FlowKey;
	public void setFlowKey(String FlowKey){this.FlowKey.setValue(FlowKey);}
	public String getFlowKey(){return this.FlowKey.getValue();}
	  
	public Field Seq_no;
	public void setSeq_no(String Seq_no){this.Seq_no.setValue(Seq_no);}
	public String getSeq_no(){return this.Seq_no.getValue();}
	  
	private String ProgramId=Cnstnts.EMPTY_STRING;
	public void setProgramId(String ProgramId){this.ProgramId=ProgramId;}
	public String getProgramId(){return this.ProgramId;}
	  
	private String TagId=Cnstnts.EMPTY_STRING;
	public void setTagId(String TagId){this.TagId=TagId;}
	public String getTagId(){return this.TagId;}
	  
	private String ActionMode=Cnstnts.EMPTY_STRING;
	public void setActionMode(String ActionMode){this.ActionMode=ActionMode;}
	public String getActionMode(){return this.ActionMode;}
	  
	private int RecordIndex;
	public void setRecordIndex(int RecordIndex){this.RecordIndex=RecordIndex;}
	public int getRecordIndex(){return this.RecordIndex;}
	  
	private String ErrorMessage=Cnstnts.EMPTY_STRING;
	public void setErrorMessage(String ErrorMessage){this.ErrorMessage=ErrorMessage;}
	public String getErrorMessage(){return ErrorMessage;}
	  
	/* ========== about jspPage css properties & setter getter methord ========== */
	private String PageBgcolor=Cnstnts.DEFAULT_PAGE_BGCOLOR;
	public void setPageBgcolor(String PageBgcolor){this.PageBgcolor=PageBgcolor;}
	public String getPageBgcolor(){return PageBgcolor;}
	  
	private String TableBgcolor=Cnstnts.DEFAULT_TABLE_BGCOLOR;
	public void setTableBgcolor(String TableBgcolor){this.TableBgcolor=TableBgcolor;}
	public String getTableBgcolor(){return TableBgcolor;}
	  
	private String ThBgcolor=Cnstnts.DEFAULT_TH_BGCOLOR;
	public void setThBgcolor(String ThBgcolor){this.ThBgcolor=ThBgcolor;}
	public String getThBgcolor(){return ThBgcolor;}
	  
	private String TrBgcolor1=Cnstnts.DEFAULT_TR_BGCOLOR_1;
	public void setTrBgcolor1(String TrBgcolor1){this.TrBgcolor1=TrBgcolor1;}
	public String getTrBgcolor1(){return TrBgcolor1;}
	  
	private String TrBgcolor2=Cnstnts.DEFAULT_TR_BGCOLOR_2;
	public void setTrBgcolor2(String TrBgcolor2){this.TrBgcolor2=TrBgcolor2;}
	public String getTrBgcolor2(){return TrBgcolor2;}
	  
	/* ========== about for JspPage used function ========== */
	public boolean onBtnSubmit(){
		if(Cnstnts.TRUE_FLAG.equals(this.SubmitFlag))
			return true;
	  	else
	  		return false;
	}
	  
 	public void resetError(){
 		this.ErrorMessage=Cnstnts.EMPTY_STRING;
 	}
	  
 	public String getPageTitle() throws Exception{
		if(this.userInfo==null || this.ProgramId.trim().length()==0)
	  		return Cnstnts.EMPTY_STRING;
		String title=userInfo.getProgramName(this.ProgramId);
		if(Cnstnts.UPDATE.equals(this.ActionMode)){
			title = userInfo.getMsg("jsp.function.update")+title;
		} 
		if(Cnstnts.INSERT.equals(this.ActionMode)){
  			title = userInfo.getMsg("jsp.function.insert")+title;
  		}
  		return "<font size='3'><b>"+title+"</b><font>";
  	}
	  
 	public String printHeadTag() throws Exception{
  		List<String> linkTagList = new ArrayList<String>();
  		linkTagList.add("css/login.css");
  		linkTagList.add("css/default.css");
  		List<String> scriptTagList = new ArrayList<String>();
  		scriptTagList.add("js/basic.js");
  		scriptTagList.add("js/ajax.js");
  		scriptTagList.add("js/AC_RunActiveContent.js");
  		scriptTagList.add("js/AC_ActiveX.js");
  		HtmlHeadTag headTag = new HtmlHeadTag(this.getPageTitle(),linkTagList,scriptTagList);
  		return headTag.print();
  	}
	  
  	public String printHiddenTags(){
  		HashMap<String,String> hm = new HashMap<String,String>();
  		hm.put("submitFlag",Cnstnts.EMPTY_STRING);
  		hm.put("tagId",Cnstnts.EMPTY_STRING);
  		hm.put("recordIndex",String.valueOf(this.RecordIndex));
  		hm.put("actionMode",this.ActionMode);
  	
  		return new HiddenTag().print(hm);
  	}	
  
  	public String getCancelBtn() throws Exception {
		String rtnString=Cnstnts.EMPTY_STRING;
		
		rtnString=Cnstnts.NEW_LINE +
				  "<input type='button' style='cursor: hand' " +
	              "value='" + userInfo.getMsg("jsp.common.cancel")+"' " +
	              "onClick='parent.closeDetail()'/>";
		
		return rtnString;
  	}
	  
  	public String getSubmitBtn() throws Exception {
		String rtnString=Cnstnts.EMPTY_STRING;
		rtnString=Cnstnts.NEW_LINE +
				  "<input type='button' style='cursor: hand' " +
				  "value='" + userInfo.getMsg("jsp.common.submit")+"' " +
				  "onClick='document.input.submitFlag.value=\"true\";document.input.submit()'/>";
		return rtnString;
  	}
	  
  	public String printHtml() throws Exception{
	  	char newLine = Cnstnts.NEW_LINE;
	  	String onLoadStr = Cnstnts.EMPTY_STRING;
	  	if(this.TagId.trim().length()>0){
	  		onLoadStr = " onLoad='document.input."+this.TagId+".focus()'";
	  	}
	  	StringBuffer strBfr = new StringBuffer("<html>");
	  	strBfr.append(this.printHeadTag());
	  	strBfr.append(newLine+"<body"+this.PageBgcolor+onLoadStr+"><center>");
	  	strBfr.append(newLine+"<form name='input' id='input' method='post'>");
	  	strBfr.append(this.printHiddenTags());
	  	strBfr.append(this.printHtmlBody());
		strBfr.append(newLine+"</form></center></body></html>");
		return strBfr.toString();
  	}
	  
  	public String printHtmlBody() throws Exception{
  		char newLine = Cnstnts.NEW_LINE;
  		String rtnString=newLine+"<table"+this.TableBgcolor+">";
  		rtnString += "<tr><td width='50%'>"+this.getPageTitle()+"</td>"+
  				     "<td align='center'>"+this.getCancelBtn()+this.getSubmitBtn()+
  				     "</td></tr></table>";
  		rtnString+=newLine+"<table"+this.TableBgcolor+">";
  		rtnString+=this.printMaintainTable();
  		rtnString+=newLine+"</table>";
  		return rtnString;
  	}
	  
  	public String printMaintainTable() throws Exception{
  		return Cnstnts.EMPTY_STRING;
  	}
	  
  	public String printHtml(Field field) throws Exception{
  		String rtnString=Cnstnts.EMPTY_STRING;
  		char newLine = Cnstnts.NEW_LINE;
  		rtnString=newLine+"  <tr"+field.getBgcolor()+">";
  		rtnString+=newLine+"    <td align='right' width='20%'>"+getAlias(field)+"</td>";
  		rtnString+=newLine+"    <td"+field.printColspan()+">"+ this.printTag(field)+"</td>";
  		if(field.getColspan()==1 && field.getAnotherField()!=null){
  			rtnString+=newLine+"    <td align='right' width='15%'>"+getAlias(field.getAnotherField())+"</td>";
  			rtnString+=newLine+"    <td>"+ this.printTag(field.getAnotherField())+"</td>";
  		}
  		rtnString+=newLine+"  </tr>";
  	  
  		return rtnString;
    }
	  
  	public String getAlias(Field field) throws Exception{
  		String rtnString = Html.getAlias(field, userInfo);
  		if((this.ActionMode.equals(Cnstnts.INSERT) 
  				|| this.ActionMode.equals(Cnstnts.UPDATE)) 
  						&& field.checkEmpty()){
  			rtnString = "<font color='red' size='1'>"+
			  			userInfo.getMsg("jsp.common.Require")+
			  			"*</font>"+rtnString;
  		}
  		return rtnString;
  	}
	  
  	public String printTag(Field field) throws Exception{
  		field.setCanEdit(true);
  		String rtnString = Html.printTag(field, userInfo);
  		if(field.getAnotherField()!=null && field.getColspan()>1){
  			rtnString += getAlias(field.getAnotherField())+ printTag(field.getAnotherField());
  		}
  		return rtnString;
    }
	  
  	public String printErrorMessage(){
  		StringBuffer strBfr = new StringBuffer();
  		if(this.ErrorMessage.trim().length()>0){
  			strBfr.append("<script>alert('"+this.ErrorMessage+"')</script>");
  		}
  		if(this.closeFlag){
  			strBfr.append("<script>parent.setValue()</script>");
  		}
  		return strBfr.toString();
  	}
	  
  	protected boolean checkFieldEmptyError() throws Exception{
  		this.setDbFields();
  		for(Iterator<Field> itr=this.DbFields.iterator();itr.hasNext();){
  			Field field = (Field)itr.next();
  			if(field!=null){ 
  				if(field.checkEmpty()){
  					if(field.getValue().trim().length()==0){
  	  					String errorMsg = this.userInfo.getMsg(ProgramId+"."+field.getName())+
  	  								  	  this.userInfo.getMsg("jsp.common.EmptyError");
  	  					this.setTagId(field.getTagName());
  	  					this.setErrorMessage(errorMsg);
  	  					return true;
  	  				}
  				}
  				if(field.getValue().trim().length()>0){
  					if(Cnstnts.DB_TYPE_INT.equals(field.getDbType())){
  	  					if(!Util.chkIntVaule(field.getValue())){
  	  					String errorMsg = this.userInfo.getMsg("jsp.common.intError");
	  						this.setTagId(field.getTagName());
	  						this.setErrorMessage(errorMsg);
	  						return true;
  	  					}
  	  				} else 
  	  				if(Cnstnts.DB_TYPE_FLOAT.equals(field.getDbType())){
  	  					if(!Util.chkFloatVaule(field.getValue())){
  	  					String errorMsg = this.userInfo.getMsg("jsp.common.intError");
	  						this.setTagId(field.getTagName());
	  						this.setErrorMessage(errorMsg);
	  						return true;
	  					}
  	  				} else {
  	  					if(field.getValue().indexOf("'")!=-1){
  	  						String errorMsg = this.userInfo.getMsg("jsp.common.charError");
  	  						this.setTagId(field.getTagName());
  	  						this.setErrorMessage(errorMsg);
  	  						return true;
  	  					}
  	  				}
  				} else {
  					if(field.getDbType().equals(Cnstnts.DB_TYPE_INT)){
  						field.setValue("0");
  					} else 
  					if(field.getDbType().equals(Cnstnts.DB_TYPE_FLOAT)){
  						field.setValue("0.0");
  					}
  				}
  			}
  		}
  		return false;
  	}
	  
  	public String onAjaxRequest(String dataValue,String tagMode){
  		return "you must over write onAjaxRequest(String '"+dataValue+"',"+
  			   "String '"+tagMode+"') methord in "+this.TableName+".java";
  	}
	  
  	public String getErrorMessage(Field field) throws Exception{
  		return this.getUserInfo().getMsg(this.getProgramId()+"."+field.getName()+".Error");
  	}
  	
  	public List<List<Field>> getDetails(String FlowKey){
	    String SQL = "select * from "+this.getTableName()+" where FlowKey='" +
	    			 FlowKey+"' order by Seq_no";
	    return this.getDbUtil().getFieldsList(SQL, this.getDbFields());
	}
  	
  	public void getAttribute(String seqNo) {
  	  if(this.FlowKey.getValue().trim().length()==0){
  		  return;
  	  }
  	  String SQL = "select * from "+this.getTableName()+
  	  			   " where FlowKey='"+this.FlowKey.getValue()+"' and Seq_no="+seqNo;
  	  this.setDbFields();
  	  this.getDbUtil().getAttribute(SQL, this.DbFields);
    }
  
}