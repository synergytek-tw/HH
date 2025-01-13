<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.TrademarkDocument"/>
<jsp:setProperty name="thisObj" property="*"/>
<%@ include file="include/jspHtml.include"%>

<%
if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))) {
	userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");

	if("true".equals(userInfo.getAttribute("InsertAddFlag"))){
		userInfo.setAttribute("InsertAddFlag", "false");
%>
	<script>
	parent.resetFrame('TrademarkToDos');
    </script>
<%
	}
	else {
%>
    <script>
      parent.resetFrame('<%=thisObj.getTableName()%>');
      parent.resetFrame('TrademarkToDos');
      parent.document.input.lastSchedule.value = '<%=userInfo.getAttribute("LastSchedule")%>';
      parent.resetTodosTab('TrademarkCase', '<%=thisObj.getParentId()%>');
    </script>
<%
	}
}
%>