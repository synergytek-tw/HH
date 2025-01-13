<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.QueryForm"/>
<%
  //request.setCharacterEncoding("big5");
  String para = request.getParameter("QueryText4");  // 取得 HTTP request 的參數
  String para2 = request.getParameter("QueryText5");
  
  String queryText2 = null;
  if(request.getMethod().equals("GET")){
	  queryText2 = request.getParameter("_queryText2");
  }
  if(queryText2 != null) {
	  thisObj.setQueryText2(queryText2);
  }
  String queryText3 = null;
  if(request.getMethod().equals("GET")){
	  queryText3 = request.getParameter("_queryText3");
  }
  if(queryText3 != null) {
	  thisObj.setQueryText3(queryText3);
  }
%>

<jsp:setProperty name="thisObj" property="*"/>
<jsp:setProperty name="thisObj" property="mquerytext4" value="<%=para%>" />
<jsp:setProperty name="thisObj" property="mquerytext5" value="<%=para2%>" />
<%thisObj.doAction(userInfo);%>
<%=thisObj.printMessage()%>
<%=thisObj.printHtml()%>