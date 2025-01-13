<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.FeeSchedule"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
	String [] markKeys = request.getParameterValues("markKey");
    if(markKeys!=null && markKeys.length>0){
      thisObj.setMarkKeys(markKeys);
    }
%>
<%thisObj.doAction(userInfo);%>
<%=thisObj.printMessage()%>
<%=thisObj.printHtml()%>