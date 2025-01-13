<% /* include.error.jsp */%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*,java.io.File,java.lang.StringBuffer,deepspot.main.*,deepspot.util.*,com.deepspot.pdf.*" %>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean"/>
<%if(userInfo.getAttribute("user_id")==null || !userInfo.getIsLogin()) {%>
    You have not login yet!  or  Your session has timeout!<br><br>
    Please logout first and login again.    <a href="logout.jsp" target="_top">Logout</a>
<%} else {%>
    There has some unknown system error!!<br><br>
    Please contact with us.
 
<%}%>
<% /* include.error.jsp */%>