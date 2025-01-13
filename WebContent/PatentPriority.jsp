<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.PatentPriority"/>
<jsp:setProperty name="thisObj" property="*"/>
<%@ include file="include/jspHtml.include"%>
<%if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))){
    userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");
    PatentCase caseData = new PatentCase(userInfo.getAttribute("RelatePatentCaseFlowKey"));
    %>
    <script>
		parent.document.getElementById("priorityDeadLine").value = "<%=caseData.getPriorityDeadLine()%>";
		parent.resetFrame('<%=thisObj.getTableName()%>');
    </script>
<%}%>