<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean"/>
<% userInfo.setAttribute("logoutPage","logout.jsp");
   userInfo.setAttribute("menuPage","Home.jsp");%>
<% if(session.isNew()) session.setMaxInactiveInterval(10800); 
   
   String title=userInfo.getMsg("jsp.login.title"); 
   
   String user_id = request.getParameter("user_id");
   if(user_id==null) user_id="";
   String password = request.getParameter("password");
   if(password==null) password="";
   
   if(request.getParameter("login_id")!=null) {
     user_id = request.getParameter("login_id");
     password="do not check password";
   }
   
   if(!user_id.equals("") && !password.equals("")) {   
     userInfo.chkPwd(user_id,password);
     if(userInfo.getAttribute("errorMsg")!=null){%>
       <script>
         alert("<%=userInfo.getAttribute("errorMsg")%>");  
         location.replace("logout.jsp");     
       </script>
     <%userInfo.removeAttribute("errorMsg");
     } else {
       userInfo.setAttribute("user_id",user_id);
       userInfo.setAttribute("password",password);
     }%>
     <script>
       location.replace("Home.jsp");
     </script>
 <%}%>
 
 <head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=7">


  <title><%=title%></title>
  <link href="css/style.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	background-color: #FFFFFF;
}
.style1 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 15px;
	letter-spacing:2px;
}
#titleleft {
	background-image: url(images/title1_4.jpg);
	background-repeat: no-repeat;
	background-position: right;
	float: right;
	height: 80px;
	width: 360px;
}
#titleleftlogo {
	float: left;
	height: 80px;
	width: 200px;
}

-->
</style>
</head><body onLoad="document.input.user_id.focus()">
<table bgcolor='#FFFFFF' width="100%" border="0" cellpadding="0" 
cellspacing="0" height=60 >
  <tbody> <tr>
	<td></td>
    <td><img src="<%=userInfo.logo %>" alt="logo" height="60" /></td>
	<td></td>
  </tr>
</tbody></table>
<br>
<form name="input" id="input" action="login.jsp" method="post">
<table width="35%" align="center" border="0" cellpadding="0" 
cellspacing="0">
  <tbody>	<TR>
		<TD width="29">
			<IMG SRC="images/table2_01.gif" WIDTH=29 HEIGHT=52 ALT=""></TD>
		<TD background="images/table2_02.gif"><br>
<div align="center" class="style1">專利商標法律事務所管理系統</div></TD>
		<TD width="31">
			<IMG SRC="images/table2_03.gif" WIDTH=31 HEIGHT=52 ALT=""></TD>
	</TR>
	<TR>
		<TD rowspan="3" background="images/table2_04.gif">&nbsp;</TD>
		<TD height="50" bgcolor="#FFFFFF" align="center" class="title"><%=userInfo.getMsg("jsp.login.account")%>：
        <input type="text" id="user_id" name="user_id"/></TD>
		<TD rowspan="3" background="images/table2_06.gif">&nbsp;</TD>
	</TR>
	<TR>
	  <TD bgcolor="#FFFFFF"><hr noshade="noshade" size="1"></TD>
  </TR>
	<TR>
	  <TD height="50" bgcolor="#FFFFFF" align="center" class="title"><%=userInfo.getMsg("jsp.login.password")%>：
        <input type="password" id="password" name="password"/></TD>
  </TR>
	<TR>
		<TD>
			<IMG SRC="images/table2_07.gif" WIDTH=29 HEIGHT=83 ALT=""></TD>
		<TD background="images/table2_08.gif"><label>
        <div align="center">
          <input type="submit" value="<%=userInfo.getMsg("jsp.login.login")%>"/>
        </div>
		</label><br></TD>
		<TD>
			<IMG SRC="images/table2_09.gif" WIDTH=31 HEIGHT=83 ALT=""></TD>
	</TR>
</tbody></table>
<br><br><br><br><br><br><br><br><br><br><br><br>
<center><%=userInfo.getMsg("jsp.copyright")%>&copy;<%=userInfo.getMsg("jsp.copyright.1")%><a href="<%=userInfo.getMsg("jsp.copyright.link")%>"><%=userInfo.getMsg("jsp.copyright.3")%></a><%=userInfo.getMsg("jsp.copyright.4")%></center>
</form>
</body></html>