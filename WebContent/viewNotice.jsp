<%@ include file="includePage/pageHeader2.jsp" %>

<%final String program_id="jsp.Notice";
  final String thisJspPage="Notice.jsp";
  String title=userInfo.getMsg("jsp.menu.Notice");
  int colspan = 2;
  String fieldAction = "";
  String readonly = "readonly=\"true\" style=\"color:black\"";
  String dbAction = request.getParameter("formType");
  if(dbAction==null) dbAction=userInfo.getAction("Notice");
  if(dbAction==null) dbAction="query";
  
  String tr1 = " bgcolor='#F7F7F7'";
  String table_bgcolor="border='0' cellpadding='1' cellspacing='1' bgcolor='#D7D7D7' width='98%'";

  Notice thisObj = new Notice(request.getParameter("FlowKey"));%>

<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body>
  <table <%=table_bgcolor%>>
  <tr>
      <td align="center" colspan="<%=colspan%>" class="logField">
        <div class="logTitle"><%=title%></div>
      </td>     
  </tr>
  <tr <%=tr1%>>
    <td align="right" width="20%">
      <%=userInfo.getMsg("jsp.Notice.Summary")%>
    </td>
    <td>
      <textarea id="summary" name="summary" rows="2" cols="62" <%=readonly%>><%=thisObj.getSummary()%></textarea>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Notice.Content")%>
    </td>
    <td>
      <textarea id="content" name="content" rows="8" cols="62" <%=readonly%>><%=thisObj.getContent()%></textarea>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Notice.Appendix")%>
    </td>
    <td>
      <%if(!thisObj.getAppendix().equals("")){%>
        <input type="button" value="<%=userInfo.getMsg("jsp.Notice.openAppendix")%>" onClick="photoView('<%=thisObj.getAppendix()%>')"/>
      <%}%>
    
    
      <%if(thisObj.getLinkUrl().trim().length()>0 && thisObj.getUrlDateFrom().trim().length()>=10){
          boolean showButton = false;
          int year = Integer.parseInt(thisObj.getUrlDateFrom().substring(0,4));
          int month = Integer.parseInt(thisObj.getUrlDateFrom().substring(5,7));
          int day = Integer.parseInt(thisObj.getUrlDateFrom().substring(8,10));
          int thisYear = Integer.parseInt(Util.getYear());
          int thisMonth = Integer.parseInt(Util.getMonth());
          int today = Integer.parseInt(Util.getDay());
          if(thisYear >= year){
            if(thisMonth >= month){
              if(today >= day){
                showButton = true;
              } else {
                if(thisMonth > month){
                  showButton = true;
                } else {
                  if(thisYear > year) showButton = true;
                }
              }
            }
          }
          if(showButton){
            String linkTitle = userInfo.getMsg("jsp.Notice.link");
            if(thisObj.getLinkTitle().trim().length()>0) linkTitle = thisObj.getLinkTitle();%>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="<%=linkTitle%>" onClick="photoView('<%=thisObj.getLinkUrl()%>')"/>
      <%  }
        }%>
     </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Notice.CreateDept")%>
    </td>
    <td>
      <%Department deptobj=new Department(thisObj.getCreateDept());%>
      <input type="text" <%=readonly%> value="<%=deptobj.getDept_name()%>"/>
  
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   
      <%=userInfo.getMsg("jsp.Notice.Applicant")%>
    
      <%Employee empobj=new Employee(thisObj.getApplicant());%>
      <input type="text" <%=readonly%> value="<%=empobj.getEmp_name()%>"/>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Notice.DateFrom")%>
    </td>
    <td>
      <input type="text" id="dateFrom" name="dateFrom" <%=readonly%>
             value="<%=thisObj.getDateFrom()%>"/>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <%=userInfo.getMsg("jsp.Notice.DateTo")%>
    
      <input type="text" id="dateTo" name="dateTo" <%=readonly%>
             value="<%=thisObj.getDateTo()%>"/>
    </td>
  </tr>

  </table>
  </body>
</html>
