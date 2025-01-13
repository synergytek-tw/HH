<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.CasePrivilege"/>
<jsp:setProperty name="thisObj" property="*"/>
<%@ include file="include/jspHtml.include"%>
<%
	String [] markKeys = request.getParameterValues("markKey");
    if(markKeys!=null && markKeys.length>0){
      thisObj.setMarkKeys(markKeys);
    }
%>
<%if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))){
    userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");%>
    <script>
      parent.resetFrame('<%=thisObj.getTableName()%>');
      parent.resetFrame('<%=thisObj.getTableName()%>2');
    </script>
<%}%>