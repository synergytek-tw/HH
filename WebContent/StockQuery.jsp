<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.StockQuery"/>
<jsp:setProperty name="thisObj" property="*"/>
<%thisObj.doAction(userInfo);%>
<%=thisObj.printMessage()%>
<%=thisObj.printHtml()%>