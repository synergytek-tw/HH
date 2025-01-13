<%@ include file="includePage/pageHeader.jsp" %>

<%final String program_id="jsp.ScheduleManager";
  final String thisJspPage="ScheduleManager.jsp";
  String title=userInfo.getProgramName(program_id);
  int colspan = 2;
  String fieldAction = "";
  String dbAction = request.getParameter("formType");
  if(dbAction==null) dbAction=userInfo.getAction("ScheduleManager");
  if(dbAction==null) dbAction="query";
  userInfo.setAction("ScheduleManager",dbAction);%>

<%@ include file="includePage/getFlags.frameset" %>

<%if(useJavaBean) {%>
    <jsp:useBean id="thisBean" scope="page" class="deepspot.main.ScheduleManager"/>
    <jsp:setProperty name="thisBean" property="*"/>
  <%ScheduleManager tmpMastObj = (ScheduleManager)userInfo.getObj("ScheduleManager");
    thisBean.setDetails(tmpMastObj.getDetails());%>
  <%if(setObjValue.equals("true")){
      userInfo.setObj("ScheduleManager",thisBean);
    }
    if(getObjValue.equals("true")){
      if(thisBean.getKeyValue()==null)
        thisBean = new ScheduleManager();
      else
        thisBean = new ScheduleManager(thisBean.getKeyValue());
      userInfo.setObj("ScheduleManager",thisBean);
    }
    if(submitValue.equals("true")){
      if(dbExcute){
        thisBean.dbExcute(dbAction,language);
        if(dbAction.equals("delete"))
          userInfo.removeObj("ScheduleManager");
        else
          userInfo.setObj("ScheduleManager",thisBean);
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
    ScheduleManager tmpScheduleManager=(ScheduleManager)userInfo.getObj("ScheduleManager");
    Vector tmpDetails=tmpScheduleManager.getDetails();
    if(deleteItems!=null){
      for(int i=0;i<deleteItems.length;i++){
        int seq_no = Integer.parseInt(deleteItems[i]);
        tmpDetails.remove(seq_no-i);
      }
      /*
      Iterator detailItr = tmpDetails.iterator();
      int amount = 0;
      while(detailItr.hasNext()){
        ScheduleManager_detail detailObj = (ScheduleManager_detail)detailItr.next();
        amount += detailObj.getAmount;
      }
      tmpScheduleManager.setAmount(amount);
      */
      tmpScheduleManager.setDetails(tmpDetails);
      userInfo.setObj("ScheduleManager",tmpScheduleManager);
    }
  }%>
<%ScheduleManager thisObj;
  if(clearValue.equals("true")){
    thisObj = new ScheduleManager();
    userInfo.setObj("ScheduleManager",thisObj);
  }
  if(userInfo.getObj("ScheduleManager")==null) {
    thisObj = new ScheduleManager();
  } else {
    thisObj=(ScheduleManager)userInfo.getObj("ScheduleManager");
  }
  userInfo.setObj("ScheduleManager",thisObj);%>

<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body>
  <center>
  <form name="input" id="input" action="ScheduleManager.jsp" method="post">
  <div id="PrintScope">
  <table <%=table_bgcolor%>>

  <%@ include file="includePage/function.frameset1" %>

  <tr <%=tr1%>>
    <td align="right" width="20%">
      <%=userInfo.getMsg("jsp.ScheduleManager.KeyValue")%>
    </td>
    <td colspan="3">
  <%if(canSelect){%>
      <select id="keyValue" name="keyValue"  onChange="getValue()">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%ScheduleManager ScheduleManagerObj=new ScheduleManager();
        Iterator ScheduleManagerItr=ScheduleManagerObj.getList();
        while(ScheduleManagerItr.hasNext()) {
          ScheduleManager obj=(ScheduleManager)ScheduleManagerItr.next();
          String sNo=obj.getKeyValue();
          String sName=obj.getGroupName();
          if(sName.length()>15) sName=sName.substring(0,15)+"...";
          boolean sFlag=false;
          if(thisObj.getKeyValue()!=null) 
            if(thisObj.getKeyValue().equals(sNo)) sFlag=true;%>
          <option value="<%=sNo%>"<%if(sFlag){%> selected<%}%>>
            <%=sNo%>-<%=sName%>
          </option>
      <%}%>
      </select>
  <%} else {%>
    <%if(thisObj.getKeyValue().equals("")){%>
    <input type="text" disabled
           value="<%=userInfo.getMsg("jsp.ScheduleManager.D4KeyValue")%>"/>
    <input type="hidden" id="keyValue" name="keyValue"
           value="<%=thisObj.getKeyValue()%>"/>
    <%}else{%>
    <input type="text" id="keyValue" name="keyValue"
           value="<%=thisObj.getKeyValue()%>"/>
    <%}%>
  <%}%>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.ScheduleManager.GroupName")%>
    </td>
    <td colspan="3">
      <input type="text" id="groupName" name="groupName" <%=disabled%>
             size="30" value="<%=thisObj.getGroupName()%>"/>
    </td>
  </tr>
  </table>

  <input type="hidden" id="deleteDetailValue" name="deleteDetailValue" value=""/>
  <input type="hidden" id="addDetail" name="addDetail" value=""/>
  <input type="hidden" id="index" name="index" value=""/>

<%ScheduleManager_detail thisDetailObj=new ScheduleManager_detail();
  String addDetail = request.getParameter("addDetail");
  if(addDetail==null){
    addDetail="";
  }
  String indexStr = request.getParameter("index");
  if(indexStr==null){
    indexStr="";
  }
  int index=0;
  if(indexStr.length()>0) index=Integer.parseInt(indexStr);
  if(index>0){
    thisDetailObj=(ScheduleManager_detail)thisObj.getDetails().get(index-1);
  }
  if(addDetail.equals("newOne") || addDetail.equals("addToRecords") 
                                || addDetail.equals("setDetailValue")
                                || addDetail.equals("updateRecords")){%>
    <jsp:useBean id="thisDetailBean" scope="page" class="deepspot.main.ScheduleManager_detail"/>
    <jsp:setProperty name="thisDetailBean" property="*"/>
  <%if(addDetail.equals("addToRecords")){
      addDetail="";
      thisDetailBean.chkData(userInfo.getAttribute("language"));
      String errorMsg = thisDetailBean.getMsg();
      if(errorMsg==null) errorMsg="";
      if(!errorMsg.equals("")) {
        addDetail="newOne";%>
        <script>
          alert("<%=errorMsg%>");
        </script>
    <%} else {
        Vector tmpDetails = thisObj.getDetails();
        tmpDetails.add(thisDetailBean);
        thisObj.setDetails(tmpDetails);
        addDetail="";
      }
    }
    if(addDetail.equals("updateRecords")){
      thisObj.getDetails().set(index-1,thisDetailBean);
      addDetail="";index=0;
    }
    thisDetailObj = thisDetailBean;
  }%>

  <table <%=table_bgcolor%>>
    <tr>
      <td colspan="7">
        <font size='3'><b><%=userInfo.getMsg("jsp.ScheduleManager_detail.title")%></b></font>
      </td>
    </tr>
    <tr <%=th_bgcolor%>>
      <th width="4%">
        <%if(disabled.equals("") && !addDetail.equals("newOne")){%>
          <img src="img/addanchr.gif" style="cursor: hand"
               title="<%=userInfo.getMsg("jsp.Flow_detail.addNew")%>"
               onClick="document.input.addDetail.value='newOne';setValue()"/>
        <%}%>
      </th>
      <th width="20%"><%=userInfo.getMsg("jsp.ScheduleManager_detail.ScheduleName")%></th>
      <th width="22%"><%=userInfo.getMsg("jsp.ScheduleManager_detail.ScheduleApp")%></th>
      <th width="20%"><%=userInfo.getMsg("jsp.ScheduleManager_detail.ScheduleInitDate")%></th>
      <th width="20%"><%=userInfo.getMsg("jsp.ScheduleManager_detail.ScheduleFinalDate")%></th>
      <th width="10%"><%=userInfo.getMsg("jsp.ScheduleManager_detail.ScheduleRate")%></th>
      <th align="center" width="4%">
        <%if(disabled.equals("") && !addDetail.equals("newOne")){%>
          <img src="img/C_Delete_Md_N.png" style="cursor: hand"
               title="<%=userInfo.getMsg("jsp.usersDetail.delete")%>"
               onClick="deleteDetail()"/>
        <%}%>
      </td>
    </tr>
<%Iterator detailItr = thisObj.getDetails().iterator();
  int i=0;
  while(detailItr.hasNext()) {
    ScheduleManager_detail obj = (ScheduleManager_detail)detailItr.next();%>
    <tr <%if(i%2==1){%><%=tr1%><%}else{%><%=tr2%><%}%>>
      <td align="center">
    <%if(index==i+1){%>
        <img src="img/save_s.png" style="cursor: hand"
             title="<%=userInfo.getMsg("jsp.common.saveDetail")%>"
             onClick="document.input.index.value='<%=index%>';document.input.addDetail.value='updateRecords';setValue()"/>
      </td>
      <td>
        <input type="text" id="scheduleName" name="scheduleName"
               size="14" value="<%=thisDetailObj.getScheduleName()%>"/>
      </td>
      <td>
        <input type="text" id="scheduleApp" name="scheduleApp"
               size="20" value="<%=thisDetailObj.getScheduleApp()%>"/>
      </td>
      <td>
        <input type="text" id="scheduleInitDate" name="scheduleInitDate"  readonly
             onClick="openDateTime('scheduleInitDate')"
             size="14" value="<%=thisDetailObj.getScheduleInitDate()%>"/>
      </td>
      <td>
        <input type="text" id="scheduleFinalDate" name="scheduleFinalDate"  readonly
             onClick="openDateTime('scheduleFinalDate')"
             size="14" value="<%=thisDetailObj.getScheduleFinalDate()%>"/>
      </td>
      <td>
          <input type="text" id="scheduleRate" name="scheduleRate"
                 size="3" value="<%=thisDetailObj.getScheduleRate()%>"/>
          <%=userInfo.getMsg("jsp.ScheduleManager_detail.second")%>
      </td>
      <td align="center">
        <img src="img/C_Delete_Md_N.png" style="cursor: hand"
             title="<%=userInfo.getMsg("jsp.common.cancel")%>"
             onClick="setValue()"/>
    <%} else {%>
      <%if(disabled.equals("") && !addDetail.equals("newOne")){%>
        <img src="img/edit2.gif" style="cursor: hand"
             title="<%=userInfo.getMsg("jsp.Flow.edit")%>"
             onClick="document.input.index.value='<%=i+1%>';setValue()"/>
      <%}%>
      </td>
      <td><%=obj.getScheduleName()%></td>
      <td><%=obj.getScheduleApp()%></td>
      <td><%=obj.getScheduleInitDate()%></td>
      <td><%=obj.getScheduleFinalDate()%></td>
      <td><%=obj.getScheduleRate()%><%=userInfo.getMsg("jsp.ScheduleManager_detail.second")%></td>
      <td align="center">
      <%if(disabled.equals("") && !addDetail.equals("newOne")){%>
        <input type="checkbox" name="delete"
               title="<%=userInfo.getMsg("jsp.usersDetail.delete2")%>"
               value="<%=i%>"/>
      <%}
      }%>
      </td>
      <%i++;%>
    </tr>
<%}
  if(addDetail.equals("newOne")){%>
    <tr <%if(i%2==0){%><%=tr1%><%}else{%><%=tr2%><%}%>>
      <td align="center">
        <img src="img/save_s.png" style="cursor: hand"
             title="<%=userInfo.getMsg("jsp.common.saveDetail")%>"
             onClick="document.input.addDetail.value='addToRecords';setValue()"/>
      </td>
      <td>
        <input type="text" id="scheduleName" name="scheduleName"
               size="14" value="<%=thisDetailObj.getScheduleName()%>"/>
      </td>
      <td>
        <input type="text" id="scheduleApp" name="scheduleApp"
               size="20" value="<%=thisDetailObj.getScheduleApp()%>"/>
      </td>
      <td>
        <input type="text" id="scheduleInitDate" name="scheduleInitDate"  readonly
             onClick="openDateTime('scheduleInitDate')"
             size="14" value="<%=thisDetailObj.getScheduleInitDate()%>"/>
      </td>
      <td>
        <input type="text" id="scheduleFinalDate" name="scheduleFinalDate"  readonly
             onClick="openDateTime('scheduleFinalDate')"
             size="14" value="<%=thisDetailObj.getScheduleFinalDate()%>"/>
      </td>
      <td>
          <input type="text" id="scheduleRate" name="scheduleRate"
                 size="3" value="<%=thisDetailObj.getScheduleRate()%>"/>
          <%=userInfo.getMsg("jsp.ScheduleManager_detail.second")%>
      </td>
      <td align="center">
        <img src="img/C_Delete_Md_N.png" style="cursor: hand"
             title="<%=userInfo.getMsg("jsp.common.cancel")%>"
             onClick="setValue()"/>
      </td>
    </tr>
<%}%>
  </table></div></form></center></body>
</html>
