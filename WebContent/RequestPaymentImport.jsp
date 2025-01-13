<jsp:useBean id="thisObj" scope="page" class="deepspot.main.RequestPaymentImport"/>
<jsp:setProperty name="thisObj" property="*"/>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean" />
<%
  String flowkey=request.getParameter("flowkey");
 %>
<%=thisObj.importtodo(userInfo,flowkey)%>