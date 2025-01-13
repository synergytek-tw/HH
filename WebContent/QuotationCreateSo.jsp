<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.QuotationCreateSo"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
	session.setAttribute("createSoFlag", null);

	String [] kindSelects = request.getParameterValues("kindSelect");
    if(kindSelects!=null && kindSelects.length>0){
      thisObj.setKindSelects(kindSelects);
    }
    String [] typeSelects = request.getParameterValues("typeSelect");
    if(typeSelects!=null && typeSelects.length>0){
      thisObj.setTypeSelects(typeSelects);
    }
    String [] officeSelects = request.getParameterValues("officeSelect");
    if(officeSelects!=null && officeSelects.length>0){
      thisObj.setOfficeSelects(officeSelects);
    }

    String [] caseNumber1 = request.getParameterValues("caseNumber1");
    if(caseNumber1!=null && caseNumber1.length>0){
      thisObj.setCaseNumber1(caseNumber1);
    }

    String [] caseNumber2 = request.getParameterValues("caseNumber2");
    if(caseNumber2!=null && caseNumber2.length>0){
      thisObj.setCaseNumber2(caseNumber2);
    }

    String [] caseNumber3 = request.getParameterValues("caseNumber3");
    if(caseNumber3!=null && caseNumber3.length>0){
      thisObj.setCaseNumber3(caseNumber3);
    }

    String [] caseNumber4 = request.getParameterValues("caseNumber4");
    if(caseNumber4!=null && caseNumber4.length>0){
      thisObj.setCaseNumber4(caseNumber4);
    }
    
    String [] groups = request.getParameterValues("groups");
    if(groups!=null && groups.length>0){
      thisObj.setGroups(groups);
    }
    
    String [] releatedCaseNo = request.getParameterValues("releatedCaseNo");
    if(releatedCaseNo!=null && releatedCaseNo.length>0){
      thisObj.setReleatedCaseNo(releatedCaseNo);
    }
    
    String [] naGroups = request.getParameterValues("naGroups");
    if(naGroups!=null && naGroups.length>0){
      thisObj.setNaGroups(naGroups);
    }
%>
<%@ include file="include/jspHtml.include"%>

<%
	if(session.getAttribute("createSoFlag") != null) {
%>
<%
		if((Boolean)session.getAttribute("createSoFlag")) {
%>
<script>
			window.opener.setValue();
			alert('<%=thisObj.getUserInfo().getMsg("jsp.QuotationCreateSo.CreateSuccess")%>');
			window.close();
</script>
<%
		}
		else {
%>
<script>
			alert('<%=thisObj.getUserInfo().getMsg("jsp.QuotationCreateSo.CreateFalse")%>');
</script>
<%
		}
	}
%>
<script>
top.$.unblockUI();
</script>