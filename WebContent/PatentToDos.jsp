<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.PatentToDos"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
String byThePieceFlag = null;
byThePieceFlag = request.getParameter("_byThePieceFlag");
if(byThePieceFlag==null){
	byThePieceFlag=thisObj.getByThePieceFlag();
}
else {
  thisObj.setByThePieceFlag(byThePieceFlag);
}
%>
<%@ include file="include/jspHtml.include"%>
<%
if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))) {
	userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");

	if("true".equals(userInfo.getAttribute("InsertAddFlag"))){
		userInfo.setAttribute("InsertAddFlag", "false");
%>
	<script>
	parent.resetFrame('CasePrivilege');
    parent.resetTodosTab('PatentCase', '<%=thisObj.getParentId()%>');
    </script>
<%
	}
	else {
%>
    <script>
      parent.resetFrame('PatentToDos');
      parent.resetFrame('CasePrivilege');
      parent.resetTodosTab('PatentCase', '<%=thisObj.getParentId()%>');
    </script>
<%
	}
}
%>