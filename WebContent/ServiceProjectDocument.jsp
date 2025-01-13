<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.ServiceProjectDocument"/>
<jsp:setProperty name="thisObj" property="*"/>
<%@ include file="include/jspHtml.include"%>

<%
if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))) {
	userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");

	if("true".equals(userInfo.getAttribute("InsertAddFlag"))){
		userInfo.setAttribute("InsertAddFlag", "false");
%>
	<script>
	parent.resetFrame('ServiceProjectToDos');
    </script>
<%
	}
	else {
%>
    <script>
      parent.resetFrame('<%=thisObj.getTableName()%>');
  	  parent.resetFrame('ServiceProjectToDos');
      parent.resetTodosTab('ServiceProject', '<%=thisObj.getParentId()%>');
      //parent.setValue();
    </script>
<%
	}
}
%>