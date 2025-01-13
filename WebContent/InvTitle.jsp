<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.InvTitle"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
String parentId = null;
if(request.getMethod().equals("GET")){
	parentId = request.getParameter("_parentId");
}
if(parentId==null){
	parentId=thisObj.getParentId();
}else {
  thisObj.setParentId(parentId);
}
%>
<%@ include file="include/jspHtml.include"%>