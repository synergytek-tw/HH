<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.ChangePwd" />
<jsp:setProperty name="thisObj" property="*" />
<%
  if(thisObj.getFlowKey().trim().length()==0){
    thisObj = new ChangePwd(userInfo.getAttribute("user_id"));
  }
%>
<%@ include file="include/jspHtml.include" %>