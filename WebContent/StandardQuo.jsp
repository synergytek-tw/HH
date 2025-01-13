<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.StandardQuo"/>

<%
	String [] markKeys = request.getParameterValues("markKey");
    if(markKeys!=null && markKeys.length>0){
      thisObj.setMarkKeys(markKeys);
    }
%>
<jsp:setProperty name="thisObj" property="*"/>
<%
/*
String patentOffice = null;
if(request.getMethod().equals("GET")){
	patentOffice = request.getParameter("_patentOffice");
}
if(patentOffice!=null){
	thisObj.setPatentOffice(patentOffice);
}

String patentType = null;
if(request.getMethod().equals("GET")){
	patentType = request.getParameter("_patentType");
}
if(patentType!=null){
	thisObj.setPatentType(patentType);
}
*/
%>
<%@ include file="include/jspHtml.include"%>