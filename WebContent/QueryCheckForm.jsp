<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.QueryCheckForm"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
  //request.setCharacterEncoding("big5");
  String para = request.getParameter("queryText4");  // 取得 HTTP request 的參數
  if(!Util.isEmpty(request.getParameter("QueryText4"))) {
	  para = request.getParameter("QueryText4");
  }
  String para2 = request.getParameter("queryText5");
  if(!Util.isEmpty(request.getParameter("QueryText5"))) {
	  para2 = request.getParameter("QueryText5");
  }
  String mquerytext6 = request.getParameter("mquerytext6");  // 取得 HTTP request 的參數
  String mquerytext7 = request.getParameter("mquerytext7");


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
<%
	String [] markKeys = request.getParameterValues("markKey");
    if(markKeys!=null && markKeys.length>0){
      thisObj.setMarkKeys(markKeys);
    }
    
    String initValue = request.getParameter("initValue");
    if(initValue!=null){
      thisObj.setInitValue(initValue);
    }
%>
<jsp:setProperty name="thisObj" property="mquerytext4" value="<%=para%>" />
<jsp:setProperty name="thisObj" property="mquerytext5" value="<%=para2%>" />
<jsp:setProperty name="thisObj" property="mquerytext6" value="<%=mquerytext6%>" />
<jsp:setProperty name="thisObj" property="mquerytext7" value="<%=mquerytext7%>" />
<%thisObj.doAction(userInfo);%>
<%=thisObj.printMessage()%>
<%=thisObj.printHtml()%>