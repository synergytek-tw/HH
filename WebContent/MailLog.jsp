<%@ include file="includePage/pageHeader.jsp" %>

<%final String program_id="jsp.MailLog";
  final String thisJspPage="MailLog.jsp";
  String title=userInfo.getProgramName(program_id);
  int colspan = 2;
  String fieldAction = "";
  String dbAction = request.getParameter("formType");
  if(dbAction==null) dbAction=userInfo.getAction("MailLog");
  if(dbAction==null) dbAction="query";
  userInfo.setAction("MailLog",dbAction);%>

<%@ include file="includePage/getFlags.frameset" %>

<%if(useJavaBean) {%>
    <jsp:useBean id="thisBean" scope="page" class="deepspot.main.MailLog"/>
    <jsp:setProperty name="thisBean" property="*"/>
  <%MailLog tmpMastObj = (MailLog)userInfo.getObj("MailLog");
    thisBean.setDetails(tmpMastObj.getDetails());%>
  <%if(setObjValue.equals("true")){
      userInfo.setObj("MailLog",thisBean);
    }
    if(getObjValue.equals("true")){
      if(thisBean.getKeyValue()==null)
        thisBean = new MailLog();
      else
        thisBean = new MailLog(thisBean.getKeyValue());
      userInfo.setObj("MailLog",thisBean);
    }
    if(submitValue.equals("true")){
      if(dbExcute){
        thisBean.dbExcute(dbAction,language);
        if(dbAction.equals("delete"))
          userInfo.removeObj("MailLog");
        else
          userInfo.setObj("MailLog",thisBean);
      }
      if(thisBean.getMsg()!=null && !thisBean.getMsg().equals("")) {%>
        <script>
          alert("<%=thisBean.getMsg()%>");
        </script>
      <%thisBean.setMsg("");
      }
      if(dbAction.equals("print")){%>

    <%}%>
  <%}
  }%>

<%if(deleteDetail) {
    String [] deleteItems = request.getParameterValues("delete");
    MailLog tmpMastObj=(MailLog)userInfo.getObj("MailLog");
    if(deleteItems!=null && deleteItems.length>0){
      Vector tmpDetails=tmpMastObj.getDetails();
      for(int i=0;i<deleteItems.length;i++){
        int seq_no = Integer.parseInt(deleteItems[i]);
        tmpDetails.remove(seq_no-i);
      }
      /*
      Iterator detailItr = tmpDetails.iterator();
      int amount = 0;
      while(detailItr.hasNext()){
        MailLog_detail detailObj = (MailLog_detail)detailItr.next();
        amount += detailObj.getAmount;
      }
      tmpMastObj.setAmount(amount);
      */
      tmpMastObj.setDetails(tmpDetails);
      userInfo.setObj("MailLog",tmpMastObj);
    }
  }%>
<%MailLog thisObj;
  if(clearValue.equals("true") || userInfo.getObj("MailLog")==null){
    thisObj = new MailLog();
    userInfo.setObj("MailLog",thisObj);
  } else {
    thisObj=(MailLog)userInfo.getObj("MailLog");
  }%>

<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body>
  <center>
  <form name="input" id="input" action="MailLog.jsp" method="post">
  <div id="PrintScope">
  <table <%=table_bgcolor%>>

  <%@ include file="includePage/function.frameset1" %>

  <tr <%=tr1%>>
    <td align="right" width="20%">
      <%=userInfo.getMsg("jsp.MailLog.KeyValue")%>
    </td>
    <td colspan="3">
  <%if(canSelect){%>
      <select id="keyValue" name="keyValue"  onChange="getValue()">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%MailLog MailLogObj=new MailLog();
        Iterator MailLogItr=MailLogObj.getList();
        while(MailLogItr.hasNext()) {
          MailLog obj=(MailLog)MailLogItr.next();
          String sNo=obj.getKeyValue();
          boolean sFlag=false;
          if(thisObj.getKeyValue()!=null) 
            if(thisObj.getKeyValue().equals(sNo)) sFlag=true;%>
          <option value="<%=sNo%>"<%if(sFlag){%> selected<%}%>>
            <%=sNo%>
          </option>
      <%}%>
      </select>
  <%} else {%>
    <input type="text" id="keyValue" name="keyValue"
           value="<%=thisObj.getKeyValue()%>"/>
  <%}%>
    </td>
  </tr>

  <%if(dbAction.equals("delete")){%>
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailLog.KeepLogAmount")%>
    </td>
    <td colspan="3">
      <input type="text" id="keepLogAmount" name="keepLogAmount" size="4"
             value="<%=thisObj.getKeepLogAmount()%>"/>
    </td>
  </tr>
  <%}%>
  </table>

  <input type="hidden" id="deleteDetailValue" name="deleteDetailValue" value=""/>
  
  <table <%=table_bgcolor%>>
    <tr>
      <td>
        <font size='3'><b><%=userInfo.getMsg("jsp.MailLog_detail.title")%></b></font>
      </td>
    </tr>
    
<%Iterator detailItr = thisObj.getDetails().iterator();
  int i = 0;
  while(detailItr.hasNext()) {
    MailLog_detail obj = (MailLog_detail)detailItr.next();%>
    <tr <%if(i%2==1){%><%=tr1%><%}else{%><%=tr2%><%}%>>
      <td><%=obj.getLogDetail()%></td>
    </tr>
<%}%>
  </table>
  </div>
  </form>
  </center>
  </body>
</html>
