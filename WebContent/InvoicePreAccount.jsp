<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.InvoicePreAccount"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
String amount = null;
if(request.getMethod().equals("GET")){
	amount = request.getParameter("_amount");
}
if(amount==null){
	amount=thisObj.getAmount();
}else {
  thisObj.setAmount(amount);
}

String miscellaneous = null;
if(request.getMethod().equals("GET")){
	miscellaneous = request.getParameter("_miscellaneous");
}
if(miscellaneous==null){
	miscellaneous=thisObj.getMiscellaneous();
}else {
  thisObj.setMiscellaneous(miscellaneous);
}


String currency = null;
if(request.getMethod().equals("GET")){
	currency = request.getParameter("_currency");
}
if(currency==null){
	currency=thisObj.getCurrency();
}else {
  thisObj.setCurrency(currency);
}

String invoiceCurrency = null;
if(request.getMethod().equals("GET")){
	invoiceCurrency = request.getParameter("_invoiceCurrency");
}
if(invoiceCurrency==null){
	invoiceCurrency=thisObj.getInvoiceCurrency();
}else {
  thisObj.setInvoiceCurrency(invoiceCurrency);
}
%>
<%@ include file="include/jspHtml.include"%>