<%@ include file="includePage/pageHeader2.jsp" %>

<%final String program_id="jsp.MailThreadConfig_detail";
  String fieldAction = "";
  String setObjValue = request.getParameter("setObjValue");
  if(setObjValue==null) setObjValue="";
  String submitValue = request.getParameter("submitValue");
  if(submitValue==null) submitValue="";
  String formAction = request.getParameter("formAction");
  if(formAction==null) formAction="";
  String indexStr = request.getParameter("index");
  if(indexStr==null) indexStr="0";
  int index = Integer.parseInt(indexStr);
  String title;
  if(formAction.equals("insert")) {
    title = userInfo.getMsg("jsp.function.insert");
  } else {
    title = userInfo.getMsg("jsp.function.update");
  }
  title += userInfo.getMsg("jsp.MailThreadConfig_detail.title");
  
  String tr1 = " bgcolor='#F7F7F7'";
  String table_bgcolor="border='0' cellpadding='1' cellspacing='1' bgcolor='#D7D7D7' width='98%'";

  boolean useJavaBean = false;
  if(submitValue.equals("true")||setObjValue.equals("true")) useJavaBean=true;
  if(useJavaBean) {%>
    <jsp:useBean id="thisBean" scope="page" class="deepspot.main.MailThreadConfig_detail"/>
    <jsp:setProperty name="thisBean" property="*"/>
  <%thisBean.setCCTo(request.getParameter("cCTo"));
    thisBean.setBCCTo(request.getParameter("bCCTo"));
    thisBean.setPKey(request.getParameter("pKey"));
    if(setObjValue.equals("true")){
      userInfo.setObj("MailThreadConfig_detail",thisBean);
    } else {
      thisBean.chkData(userInfo.getAttribute("language"));
      String errorMsg = thisBean.getMsg();
      if(errorMsg==null) errorMsg="";
      if(!errorMsg.equals("")) {
        userInfo.setObj("MailThreadConfig_detail",thisBean);%>
        <script>
          alert("<%=errorMsg%>");
        </script>
    <%} else {
        MailThreadConfig tmpObj = (MailThreadConfig)userInfo.getObj("MailThreadConfig");
        Vector tmpDetails = tmpObj.getDetails();
        if(formAction.equals("insert")) {
          tmpDetails.add(thisBean);
        } else {
          tmpDetails.set(index,thisBean);
        }
        Iterator detailItr = tmpDetails.iterator();
        int amount = 0;
        while(detailItr.hasNext()){
          MailThreadConfig_detail detailObj = (MailThreadConfig_detail)detailItr.next();

        }
        //tmpObj.setAmount(amount);
        userInfo.setObj("MailThreadConfig",tmpObj);
        tmpObj = null;%>
<%    }
    }
  }
  MailThreadConfig_detail thisObj;
  if(formAction.equals("insert")) {
    thisObj = new MailThreadConfig_detail();
  } else {
    MailThreadConfig tmpMailThreadConfig=(MailThreadConfig)userInfo.getObj("MailThreadConfig");
    Vector tmpDetails = tmpMailThreadConfig.getDetails(); 
    thisObj = (MailThreadConfig_detail)tmpDetails.get(index);
    tmpMailThreadConfig = null;
    tmpDetails = null;
  }
  if(userInfo.getObj("MailThreadConfig_detail")!=null) {
    thisObj = (MailThreadConfig_detail)userInfo.getObj("MailThreadConfig_detail");
    userInfo.removeObj("MailThreadConfig_detail");
  }%>
<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body>
  <center>
  <form name="input" id="input" action="MailThreadConfig_detail.jsp" method="post">
    <input type="hidden" id="formAction" name="formAction" value="<%=formAction%>"/>
    <input type="hidden" id="submitValue" name="submitValue" value=""/>
    <input type="hidden" id="setObjValue" name="setObjValue" value=""/>
    <input type="hidden" id="index" name="index" value="<%=index%>"/>
    <table <%=table_bgcolor%>>
      <tr>
        <td colspan="2" class="logField">
          <div class="logTitle">
          	<%=title%>
          	<input type="button" value="<%=userInfo.getMsg("jsp.login.cancel")%>" 
          			onClick="parent.closeFrame();"/>
           	<input type="button" value="<%=userInfo.getMsg("jsp.common.submit")%>" 
           			onClick="setSubmitValue();parent.setValue()"/>
          </div>
        </td>
      </tr>
      <tr <%=tr1%>>
        <td align="right" width="20%">
          <%=userInfo.getMsg("jsp.MailThreadConfig_detail.SourceTableName")%>
        </td>
        <td>
        <%if(thisObj.getSourceTableName().equals("")){%>
        <input type="text" disabled
             value="<%=userInfo.getMsg("jsp.MailThreadConfig_detail.DefaultSourceTableName")%>"/>
        <input type="hidden" id="sourceTableName" name="sourceTableName"
             value="<%=thisObj.getSourceTableName()%>"/>
        <%}else{%>
        <input type="text" id="sourceTableName" name="sourceTableName"
             value="<%=thisObj.getSourceTableName()%>"/>
        <%}%>
        
        <%=userInfo.getMsg("jsp.MailThreadConfig_detail.PKey")%>
        
        <%if(thisObj.getPKey().equals("")) {%>
        <input type="text" disabled
             value="<%=userInfo.getMsg("jsp.MailThreadConfig_detail.DefaultPKey")%>"/>
        <input type="hidden" id="pKey" name="pKey"
             value="<%=thisObj.getPKey()%>"/>
        <%}else{%>
        <input type="text" id="pKey" name="pKey"
             value="<%=thisObj.getPKey()%>"/>
        <%}%>
        </td>
      </tr>
      <tr <%=tr1%>>
        <td align="right">
          <%=userInfo.getMsg("jsp.MailThreadConfig_detail.MailTo")%>
        </td>
        <td>
      <input type="text" id="mailTo" name="mailTo"
             size="50" value="<%=thisObj.getMailTo()%>"/>
        </td>
      </tr>
      <tr <%=tr1%>>
        <td align="right">
          <%=userInfo.getMsg("jsp.MailThreadConfig_detail.CCTo")%>
        </td>
        <td>
      <input type="text" id="cCTo" name="cCTo"
             size="50" value="<%=thisObj.getCCTo()%>"/>
        </td>
      </tr>
      <tr <%=tr1%>>
        <td align="right">
          <%=userInfo.getMsg("jsp.MailThreadConfig_detail.BCCTo")%>
        </td>
        <td>
      <input type="text" id="bCCTo" name="bCCTo"
             size="50" value="<%=thisObj.getBCCTo()%>"/>
        </td>
      </tr>
      <tr <%=tr1%>>
        <td align="right">
          <%=userInfo.getMsg("jsp.MailThreadConfig_detail.Title")%>
        </td>
        <td>
      <input type="text" id="title" name="title"
             size="50" value="<%=thisObj.getTitle()%>"/>
        </td>
      </tr>
      <tr <%=tr1%>>
        <td align="right">
          <%=userInfo.getMsg("jsp.MailThreadConfig_detail.Content")%>
        </td>
        <td>
        <textarea id="content" name="content" rows="5" cols="52"><%=thisObj.getContent()%></textarea>
        </td>
      </tr>
      <tr <%=tr1%>>
        <td align="right">
          <%=userInfo.getMsg("jsp.MailThreadConfig_detail.AttachFile")%>
        </td>
        <td>
      <input type="text" id="attachFile" name="attachFile" size="50" 
             onClick="openUpload('attachFile','Document/ApplyCaseRegist_detail/<%=userInfo.getAttribute("emp_id")%>','')"
             value="<%=thisObj.getAttachFile()%>"/>
      <%if(!thisObj.getAttachFile().equals("")){%>
        <input type="button" value="<%=userInfo.getMsg("jsp.Car.LookPhoto")%>" onClick="photoView('<%=thisObj.getAttachFile()%>')"/>
      <%}%>
        </td>
      </tr>
      <tr <%=tr1%>>
        <td align="right">
          <%=userInfo.getMsg("jsp.MailThreadConfig_detail.MailTime")%>
        </td>
        <td>
        
        <%if(thisObj.getMailTime().equals("")){%>
        <input type="text" id="mailTime" name="mailTime" size="20" readonly
             onClick="openDateTime('mailTime')"
             value="<%=thisObj.getMailTime()%>"/>
        <%}else{%>
        <input type="text" id="mailTime" name="mailTime" size="20" readonly
             onClick="openDateTime('mailTime')"
             value="<%=thisObj.getMailTime()%>"/>
        <%}%>

        </td>
      </tr>
    </table>
  </form>
  </center>
  </body>
</html>
