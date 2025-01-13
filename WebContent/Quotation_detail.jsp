<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.Quotation_detail"/>
<%
	String [] markKeys = request.getParameterValues("markKey");
    if(markKeys!=null && markKeys.length>0){
      thisObj.setMarkKeys(markKeys);
    }
%>
<jsp:setProperty name="thisObj" property="*"/>
<%
thisObj.setRequest(request);
/*
	if(Util.compareTo(thisObj.getDocumentIn(), "true")) {
		String parentId = null;
		  if(request.getMethod().equals("GET")){
			  parentId = request.getParameter("parentId");
		  }
		  if(!Util.isEmpty(parentId)){
			  thisObj.setParentId(parentId);
		  }
		  
		  String client = null;
		  if(request.getMethod().equals("GET")){
			  client = request.getParameter("client");
		  }
		  if(!Util.isEmpty(client)){
			  thisObj.setClient(client);
		  }
		  
		  String patentType = null;
		  if(request.getMethod().equals("GET")){
			  patentType = request.getParameter("patentType");
		  }
		  if(!Util.isEmpty(patentType)){
			  thisObj.setPatentType(patentType);
		  }
	}
*/
%>
<%@ include file="include/jspHtml.include"%>
<%if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))){
    userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");%>
    <script>
      parent.resetFrame('<%=thisObj.getTableName()%>');
    </script>
<%}%>