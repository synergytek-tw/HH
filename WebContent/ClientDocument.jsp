<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.ClientDocument"/>
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
    </script>
<%
	}
}
%>
