<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.PaymentDetail"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
thisObj.setPaymentDetailType("D");

/* ========== openWindow ========== */
String _openWindow = null;
if(request.getMethod().equals("GET")){
	_openWindow = request.getParameter("_openWindow");
}
if(_openWindow != null){
  thisObj.setOpenWindow(_openWindow);
}
%>


<%@ include file="include/jspHtml.include"%>
<%if("true".equals(userInfo.getAttribute("PaymentDetailCloseFrame"))){

	    userInfo.setAttribute("PaymentDetailCloseFrame","false");
if(thisObj.getOpenWindow() == null || !"true".equals(thisObj.getOpenWindow())) {
%>
        <script>
          parent.resetFrame('PaymentDetail');
          parent.document.input.amount.value = <%=userInfo.getAttribute("amount")%>;
          parent.setValue();
        </script>
<%
    }
    else {
%>
        <script>
          window.opener.setValue();
          window.close();
        </script>
<%
    }
  }
%>
