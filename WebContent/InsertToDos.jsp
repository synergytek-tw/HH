<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.InsertToDos"/>
<jsp:setProperty name="thisObj" property="*"/>
<%@ include file="include/jspHtml.include"%>
<%
if("true".equals(userInfo.getAttribute(thisObj.getTableName()+"CloseFrame"))){
    userInfo.setAttribute(thisObj.getTableName()+"CloseFrame","false");
%>

    <script>
      //parent.resetFrame('<%=thisObj.getTableName()%>');
    </script>
<%
}
%>
<%
	
    if(userInfo.getAttribute("ToDoLoad")==null)
    {
    
 		String docId=request.getParameter("docid");
    	if(docId!=null)
    	{
 			if(docId.trim().length()>0)
 			{
 				PatentDocument doc = new PatentDocument(docId);
 				thisObj.setTaskDescription(doc.getDocumentName());
 				if(doc.getDocumentDate()!=Cnstnts.EMPTY_STRING){
 					thisObj.setStartDate(doc.getDocumentDate());
 				}
 		
 				thisObj.setMatter(doc.getDocumentProcess());
 			}
 		}
	}
 
  %>

  <script>
  
    <%
    if(userInfo.getAttribute("ToDoLoad")==null)
    {
	    userInfo.setAttribute("ToDoLoad", "false");
	    %>
	    document.getElementById("taskDescription").value='<%=thisObj.getTaskDescription()%>';
	    <%
	  	if(thisObj.getStartDate()!="")
	  	{
	  		%>
	  		document.getElementById("startDate").value='<%=thisObj.getStartDate()%>';
	  		<%
	  	}
	  	%>
	  	document.getElementById("matter").value='<%=thisObj.getMatter()%>';
	  	<%
    }
    %>
    
    
  </script>
  