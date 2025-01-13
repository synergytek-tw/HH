<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.ToDosQuery"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
	String [] markKeys = request.getParameterValues("markKey");
    if(markKeys!=null && markKeys.length>0){
      thisObj.setMarkKeys(markKeys);
    }
    
    thisObj.setRequest(request);
    thisObj.setServletResponse(response);
%>
<%thisObj.doAction(userInfo);%>
<%=thisObj.printMessage()%>
<%=thisObj.printHtml()%>
<%
if(!Util.isEmpty(thisObj.getOutputFile())) {
%>
<script>
downloadFile('<%=thisObj.getOutputFile()%>');
</script>
<%
}
%>