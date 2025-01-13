<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.PayChargeMamage"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
	String [] markKeys = request.getParameterValues("markKey");
    if(markKeys!=null && markKeys.length>0){
      thisObj.setMarkKeys(markKeys);
    }
%>
<%
	String [] markKeys2 = request.getParameterValues("markKey2");
    if(markKeys2!=null && markKeys2.length>0){
      thisObj.setMarkKeys2(markKeys2);
    }
%>
<%@ include file="include/jspHtml.include"%>