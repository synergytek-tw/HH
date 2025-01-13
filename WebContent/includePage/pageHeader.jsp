<% /* include.pageHeader.jsp */%>
<%@ page contentType="text/html;charset=utf-8" errorPage="" pageEncoding="utf-8" %>
<%@ page import="java.util.*,java.io.File,java.lang.StringBuffer,deepspot.main.*,deepspot.basic.*,deepspot.html.*,deepspot.util.*,com.deepspot.pdf.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean"/>
<% if(userInfo.getAttribute("user_id")==null || !userInfo.getIsLogin()) {%>
     <script>
       location.replace("error.jsp");
     </script>    
<% }%>
<% /* include.pageHeader.jsp */%>