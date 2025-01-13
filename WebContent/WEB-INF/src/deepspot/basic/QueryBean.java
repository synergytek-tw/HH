package deepspot.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.html.HtmlHeadTag;
import deepspot.main.UserBean;

public class QueryBean {

	public QueryBean() throws Exception{
		this.init();
	}
	  
	public void init() throws Exception{
		this.DbUtil = new DbUtil();
	}
	
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
	
	/* ========== about jspPage action properties & setter getter methord ========== */
	
	private String SubmitFlag=Cnstnts.EMPTY_STRING;
	public void setSubmitFlag(String SubmitFlag){this.SubmitFlag=SubmitFlag;}
	public String getSubmitFlag(){return this.SubmitFlag;}
	  
	private String ProgramId=Cnstnts.EMPTY_STRING;
	public void setProgramId(String ProgramId){this.ProgramId=ProgramId;}
	public String getProgramId(){return this.ProgramId;}
	  
	private String TagId=Cnstnts.EMPTY_STRING;
	public void setTagId(String TagId){this.TagId=TagId;}
	public String getTagId(){return this.TagId;}
	
	private String ReportFile=Cnstnts.EMPTY_STRING;
	public void setReportFile(String ReportFile){this.ReportFile=ReportFile;}
	public String getReportFile(){return this.ReportFile;}
	
	private String ReportTitle=Cnstnts.EMPTY_STRING;
	public void setReportTitle(String ReportTitle){this.ReportTitle=ReportTitle;}
	public String getReportTitle(){return this.ReportTitle;}
	  
	private String Message=Cnstnts.EMPTY_STRING;
	public void setMessage(String Message){this.Message=Message;}
	public String getMessage(){return Message;}
	
	private String JavaScript=Cnstnts.EMPTY_STRING;
	public void setJavaScript(String JavaScript){this.JavaScript=JavaScript;}
	public String getJavaScript(){return JavaScript;}
	
	private String ButtonText=Cnstnts.EMPTY_STRING;
	public void setButtonText(String ButtonText){this.ButtonText=ButtonText;}
	public String getButtonText(){return ButtonText;}
	
	private boolean RunFlag;
	public void setRunFlag(boolean RunFlag){
		this.RunFlag = RunFlag;
	}
	public boolean runFlag(){
		return this.RunFlag;
	}
	  
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
	  
 	public void resetMessage(){
 		this.Message=Cnstnts.EMPTY_STRING;
 	}
	  
 	private String PageTitle=Cnstnts.EMPTY_STRING;
 	public void setPageTitle(String pageTitle){
 		this.PageTitle=pageTitle;
 	}
 	public String getPageTitle() throws Exception{
 		if(this.PageTitle.trim().length()==0){
 			this.setPageTitle(this.getUserInfo().getMsg(this.getProgramId()+".title"));
 		}
		return this.PageTitle;
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
  		return new HiddenTag().print(hm);
  	}
	  
  	private String getFilePrintBtn() throws Exception {
		String rtnString=Cnstnts.EMPTY_STRING;
		if(this.ReportFile.trim().length()>0){
			rtnString=Cnstnts.NEW_LINE +
			  "<input type='button' style='cursor: hand' " +
			  "value='" + this.ReportTitle + "' " +
			  "onClick='openAppendix(\""+this.ReportFile+"\",\"ReportFile\",800,800)'/>";
		}
		return rtnString;
  	}
  	
  	public String getSubmitBtn() throws Exception {
		String rtnString=Cnstnts.EMPTY_STRING;
		rtnString=Cnstnts.NEW_LINE +
				  "<input type='button' style='cursor: hand' " +
				  "value='" + userInfo.getMsg("jsp.common.submit")+"' " +
				  "onClick='document.input.submitFlag.value=\"true\";setValue()'/>";
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
	  	strBfr.append(newLine+this.getJavaScript());
	  	strBfr.append(newLine+"<form name='input' id='input' method='post'>");
	  	strBfr.append(this.printHiddenTags());
	  	strBfr.append(this.printHtmlBody());
		strBfr.append(newLine+"</form></center></body></html>");
		return strBfr.toString();
  	}

	public String printHtmlBody() throws Exception{
  		char newLine = Cnstnts.NEW_LINE;
  		String rtnString=newLine+"<table"+this.TableBgcolor+">";
  		rtnString += "<tr><td width='50%'><font size='3'><b>"+
  					 this.getPageTitle()+"</b><font>"+
  					 Html.getPrintImg(this.userInfo)+this.ButtonText+"</td>"+
  				     "<td align='right'>"+
  				     this.getFilePrintBtn()+this.getSubmitBtn()+
  				     "</td></tr></table>";
  		rtnString+=newLine+"<table"+this.TableBgcolor+">";
  		rtnString+=this.printMainTable();
  		rtnString+=newLine+"</table>";
  		rtnString+="<div id='resultHtml' name='resultHtml'>"+this.printResultTable()+"</div>";
  		return rtnString;
  	}
	  
  	public String printMainTable() throws Exception{
  		return Cnstnts.EMPTY_STRING;
  	}
  	
  	public String printResultTable() throws Exception{
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
	  
  	public String printMessage(){
  		StringBuffer strBfr = new StringBuffer();
  		if(this.Message.trim().length()>0){
  			strBfr.append("<script>alert('"+this.Message+"')</script>");
  		}
  		return strBfr.toString();
  	}

  	public void doAction(UserBean userInfo) throws Exception{
  		this.setUserInfo(userInfo);
  		if(this.userInfo==null || this.ProgramId.trim().length()==0){
			this.setPageTitle(userInfo.getProgramName(this.ProgramId));
		}
  	}
  	
}
