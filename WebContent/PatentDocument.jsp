<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.PatentDocument"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
thisObj.setRequest(request);
%>
<%@ include file="include/jspHtml.include"%>
<%if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))){
    userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");
    if("true".equals(userInfo.getAttribute("InsertAddFlag"))){
		userInfo.setAttribute("InsertAddFlag", "false");
%>
	<script>
	parent.resetFrame('PatentToDos');
    </script>
<%
	}
	else {
%>
    <script>
      parent.resetFrame('<%=thisObj.getTableName()%>');
      parent.resetFrame('PatentToDos');
      parent.document.input.lastSchedule.value = '<%=userInfo.getAttribute("LastSchedule")%>';
      parent.resetTodosTab('PatentCase', '<%=thisObj.getParentId()%>');
      //parent.setValue();
    </script>
<%
	}
}
%>

<%if("true".equals(userInfo.getAttribute("GoToDos"))){
    userInfo.setAttribute("GoToDos","false");%>
    <script>
      parent.resetFrame("ToDos");
      
      parent.openToDosTabFrame("ToDos","insert","<%=thisObj.getParentId()%>",340,"&docid="+('<%=thisObj.getFlowKey()%>'));
      
    </script>
<%}%>
<%if("true".equals(userInfo.getAttribute("SetStatus"))){
    userInfo.setAttribute("SetStatus","false");%>
    <script>
      parent.setPCStatus('<%=userInfo.getAttribute("Status")%>');
    </script>
<%}%>