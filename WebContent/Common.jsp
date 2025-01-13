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
<%
  final String program_id="jsp.Common";
  final String thisJspPage="Common.jsp";
  String title = userInfo.getMsg("jsp.common.HtmlTitle");
  String beanName = request.getParameter("beanName");
  if(beanName==null) beanName="";
  String flowKey = request.getParameter("flowKey");
  if(flowKey==null) flowKey="";
%>

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
<%if(beanName.equals("Vendor") && flowKey.trim().length()>0){
        Vendor vendor = new Vendor(flowKey);
        vendor.setUserInfo(userInfo);%>
  <%=vendor.printHtml(flowKey)%>
<%}%>
  </body>
</html>