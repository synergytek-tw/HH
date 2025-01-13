<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.QuotationOption"/>
<jsp:setProperty name="thisObj" property="*"/>
<%@ include file="include/jspHtml.include"%>
<%if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))){
    userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");
    if(!Util.compareTo(thisObj.getMainPageIn(), "true") &&
    		!Util.compareTo(thisObj.getMainPageIn(), "true1")) {    
%>
    <script>
      parent.resetFrame('<%=thisObj.getTableName()%>');
    </script>
<%
    }
    else {
    	String status = "QU15";
    	String approved = "N";
    	if(request.getAttribute("ApproveStatus") != null 
    			&& Util.compareTo(request.getAttribute("ApproveStatus").toString(), "QAS01")) {
    		status = "QU30";
    		approved = "Y";
    	}
%>
	<script>
	  window.opener.document.input.newStatus.value='<%=status%>';
	  window.opener.document.input.approved.value='<%=approved%>';
      //window.opener.setValue();
      window.opener.close();
      window.close();
    </script>
<%
    }
}
%>