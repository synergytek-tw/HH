<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.AccMemo"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
	String [] pdfKeys = request.getParameterValues("pdfKey");
    if(pdfKeys!=null && pdfKeys.length>0){
      thisObj.setPdfKeys(pdfKeys);
    }
%>
<%@ include file="include/jspHtml.include"%>