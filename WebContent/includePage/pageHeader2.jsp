<% /* include.pageHeader.jsp */%>
<%@ page contentType="text/html;charset=utf-8" errorPage="includePage/pageHeader2.jsp?error=true" 
         pageEncoding="utf-8" %>
<%@ page import="java.util.*,deepspot.main.*,deepspot.util.*,com.deepspot.pdf.*,java.lang.StringBuffer,java.io.File" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean"/>
<% if(session.isNew()) session.setMaxInactiveInterval(10000); 
   String error = request.getParameter("error");
   if(error==null) error="";
   if(userInfo.getAttribute("user_id")==null || !userInfo.getIsLogin() || error.equals("true")) {%>
     <script>
       window.close();
	     window.opener.location.replace("logout.jsp");
     </script>      
<% }%>
<% /* include.pageHeader.jsp */%>