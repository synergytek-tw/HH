<%@ page contentType="text/html;charset=utf-8" errorPage="" pageEncoding="utf-8" %>
<%@ page import="java.util.*,java.io.File,java.lang.StringBuffer,deepspot.main.*,deepspot.util.*,deepspot.basic.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean" />
<% if(userInfo.getAttribute("user_id")==null || !userInfo.getIsLogin()) {%>
     <script>
       windows.opener.replace("error.jsp");
       windows.close();
     </script>    
<% }%>
<script event="oncontextmenu" for="document">
  event.returnValue = false;
</script>
<%final String program_id="jsp.BudgetTransDetail";
  final String thisJspPage="BudgetTransDetail.jsp";
  String title=userInfo.getMsg("jsp.BudgetTransDetail.title");
  String paymentReport = request.getParameter("paymentReport");
  if(paymentReport==null) paymentReport="";
  String paymentDate = request.getParameter("paymentDate");
  if(paymentDate==null) paymentDate="";
  String paymentDate2 = request.getParameter("paymentDate2");
  if(paymentDate2==null) paymentDate2="";
  String memoDate = request.getParameter("memoDate");
  if(memoDate==null) memoDate="";
  String memoDate2 = request.getParameter("memoDate2");
  if(memoDate2==null) memoDate2="";
  String queryKey = request.getParameter("queryKey");
  if(queryKey==null) queryKey="";
  String accountingYear = request.getParameter("accountingYear");
  if(accountingYear==null) accountingYear="";
  String budgetDept = request.getParameter("budgetDept");
  if(budgetDept==null) budgetDept="";
  String planType = request.getParameter("planType");
  if(planType==null) planType=""; 
  String businessPlan = request.getParameter("businessPlan");
  if(businessPlan==null) businessPlan=""; 
  String workPlan = request.getParameter("workPlan");
  if(workPlan==null) workPlan="";
  String subject = request.getParameter("subject");
  if(subject==null) subject="";
  String status = request.getParameter("status");
  if(status==null) status="";
  String payAmount = request.getParameter("payAmount");
  if(payAmount==null) payAmount="";
  String payType = request.getParameter("payType");
  if(payType==null) payType="";
  String payee = request.getParameter("payee");
  if(payee==null) payee="";
  String yymm = request.getParameter("yymm");
  if(yymm==null) yymm="";%>

<html>
  <head>
    <title><%=title%></title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <link href="css/default.css" rel="stylesheet" type="text/css">
    <script language="JavaScript" src="js/basic.js"></script>
    <script language="JavaScript" src="js/tree.js"></script>
    <script language="JavaScript" src="js/ajax.js"></script>
  </head>
  <body>
  <input type='button' value='print' onClick='print()'/>
<%if(paymentReport.trim().length()>0){%>
  <%=new Budget().getBudgetTransDetailHtmlTable(planType,businessPlan,paymentReport,payType,payee,
  						paymentDate,paymentDate2,memoDate,memoDate2,userInfo)%>
<%} else {
    if(queryKey.trim().length()==0){%>
    <%=new Budget().getBudgetTransDetailHtmlTable(accountingYear,budgetDept,workPlan,subject,
    						  status,yymm,payAmount,userInfo)%>
  <%} else {%>
    <%=new Budget().getBudgetTotalReportHtmlTable(queryKey,accountingYear,budgetDept,planType,userInfo)%>
  <%}
  }%>
  </body>
</html>