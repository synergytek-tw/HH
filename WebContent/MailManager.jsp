<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.MailManager" />
<jsp:setProperty name="thisObj" property="*" />
<%
  if(thisObj.getFlowKey().trim().length()==0){
    thisObj = new MailManager("MailManager");
  }
%>
<%@ include file="include/jspHtml.include" %>