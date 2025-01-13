<% /* include.getFlags.jsp */ %>
<% userInfo.getFlags(program_id);
   boolean alowInsert = userInfo.getAllowInsert();
   boolean alowUpdate = userInfo.getAllowUpdate();
   boolean alowDelete = userInfo.getAllowDelete();
   boolean alowPrint = userInfo.getAllowPrint();
   boolean allowQuery = userInfo.getAllowQuery();
   String dbAction = request.getParameter("dbAction");
   if(dbAction==null) dbAction="query";
   userInfo.setAttribute("requestUrl",request.getRequestURI());
   
   boolean showSignForm = false;
   String signForm = request.getParameter("signForm");
   if(signForm==null) signForm = "";
   if(dbAction.equals("sign")) signForm = "true";
   String flowKey = request.getParameter("flowKey");
   if(signForm.equals("true")) showSignForm = true;
   if(showSignForm) {
     alowInsert = false;
     alowUpdate = false;
     alowDelete = false;
     alowPrint = false;
     dbAction = "sign";
   }
   boolean showCloseForm = false;
   String closeForm = request.getParameter("closeForm");
   if(closeForm==null) closeForm = "";
   if(closeForm.equals("true")) showCloseForm = true;
   if(showCloseForm) {
     alowInsert = false;
     alowUpdate = false;
     alowDelete = false;
     alowPrint = false;
     dbAction = "close";
   }
   boolean showFlow = false;
   String flowForm = request.getParameter("showFlow");
   if(flowForm==null) flowForm = "";
   if(flowForm.equals("true")) showFlow = true;
   if(showFlow) {
     dbAction = "query";
   }
   String disabled = "";
   String readonly = "readonly=\"true\" style=\"color:black\"";
   if(dbAction.equals("query")||dbAction.equals("close")||dbAction.equals("print")
                              ||dbAction.equals("sign")||dbAction.equals("delete")){
     disabled = readonly;
   }
   String Ending = request.getParameter("Ending");
   if(Ending==null) Ending = "";
   if(Ending.equals("true")) {
     alowInsert = false;
     alowUpdate = false;
     alowDelete = false;
     alowPrint = false;
     dbAction = "Ending";
     disabled = readonly;
   }
   
   String final_result="";%>
<% /* include.getFlags.jsp */ %>