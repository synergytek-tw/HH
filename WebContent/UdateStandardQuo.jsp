<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.UdateStandardQuo"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
	String [] markKeys = request.getParameterValues("markKey");
    if(markKeys!=null && markKeys.length>0){
      thisObj.setMarkKeys(markKeys);
    }
    
    thisObj.setRequest(request);
    thisObj.setServletResponse(response);
%>
<%@ include file="include/jspHtml.include"%>
