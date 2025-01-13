<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean"/>
<% if(session.isNew()) session.setMaxInactiveInterval(10000); 
	String userId = userInfo.getAttribute("user_id");
	if(userId == null){
		userId = "";
	}
	String defaultTmarkName = request.getParameter("tmarkName");
	if(defaultTmarkName == null){
		defaultTmarkName = "";
	}
	String caseNo = request.getParameter("caseNo");
	if(caseNo == null){
		caseNo = "";
	}
	String preLoad = request.getParameter("preLoad");
	if(preLoad == null){
		preLoad = "";
	}
	

%>

<script type="text/javascript">
var host = location.host;
var path = 'http://' + host + '/PlusProject/TrademarkMonitor_New.jsp?user=<%=userId%>&tmarkName=<%=defaultTmarkName%>&caseNo=<%=caseNo%>&preLoad=<%=preLoad%>';


window.location = path;

</script>

</body>
</html>