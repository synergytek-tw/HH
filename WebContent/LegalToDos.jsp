<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.LegalToDos"/>
<jsp:setProperty name="thisObj" property="*"/>
<%@ include file="include/jspHtml.include"%>
<%
if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))) {
	userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");

	if("true".equals(userInfo.getAttribute("InsertAddFlag"))){
		userInfo.setAttribute("InsertAddFlag", "false");
%>
	<script>
	parent.resetFrame('CasePrivilege');
    </script>
<%
	}
	else {
%>
    <script>
      parent.resetFrame('LegalToDos');
      parent.resetFrame('CasePrivilege');
      parent.resetTodosTab('LegalCase', '<%=thisObj.getParentId()%>');
    </script>
<%}

}%>