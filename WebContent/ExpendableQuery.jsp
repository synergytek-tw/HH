<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.ExpendableQuery"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
if(Cnstnts.TRUE_FLAG.equals(request.getParameter("printPdfFlag"))){
    String [] pdfKeys = request.getParameterValues("pdfKey");
    if(pdfKeys!=null && pdfKeys.length>0){
      thisObj.setPdfKeys(pdfKeys);
    }
}
%>
<%thisObj.doAction(userInfo);%>
<%=thisObj.printMessage()%>
<%=thisObj.printHtml()%>