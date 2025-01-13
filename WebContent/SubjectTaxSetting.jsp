<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.SubjectTaxSetting"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
thisObj.setRequest(request);
thisObj.setServletResponse(response);
%>
<%thisObj.doAction(userInfo);%>
<%=thisObj.printMessage()%>
<%=thisObj.printHtml()%>
<%
    if(Util.compareTo(thisObj.getDoSettingTaxFlag(),"true")){
    	%>
    	<script>
    		/*
	    	window.opener.document.input.serviceBusinessTax.value = document.getElementById('serviceBusinessTax').value;
	    	if($('input[name=\"serviceTaxInclude\"]:checked').val() != null){
		    	window.opener.document.input.serviceTaxInclude.value = $('input[name=\"serviceTaxInclude\"]:checked').val();
	    	}else{
	    		window.opener.document.input.serviceTaxInclude.value = "";
	    	}
	    	window.opener.document.input.attorneyBusinessTax.value = document.getElementById('attorneyBusinessTax').value;
	    	if($('input[name=\"attorneyTaxInclude\"]:checked').val() != null){
		    	window.opener.document.input.attorneyTaxInclude.value = $('input[name=\"attorneyTaxInclude\"]:checked').val();
	    	}else{
	    		window.opener.document.input.attorneyTaxInclude.value = "";
	    	}
	    	window.opener.document.input.officeBusinessTax.value = document.getElementById('officeBusinessTax').value;
	    	if($('input[name=\"officeTaxInclude\"]:checked').val() != null){
		    	window.opener.document.input.officeTaxInclude.value = $('input[name=\"officeTaxInclude\"]:checked').val();
	    	}else{
	    		window.opener.document.input.officeTaxInclude.value = "";
	    	}
	    	*/
	    	window.opener.setValue();
	    	window.close();
    	</script>
    	<%
    }
%>