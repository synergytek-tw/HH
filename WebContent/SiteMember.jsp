<%@ include file="includePage/pageHeader.jsp" %>

<%final String program_id="jsp.SiteMember";
  final String thisJspPage="SiteMember.jsp";
  String title=userInfo.getProgramName(program_id);
  int colspan = 2;
  boolean showLogo = true;
  boolean showMenu = true;%>

<%@ include file="includePage/getFlags.new1" %>

<%if(useJavaBean) {%>
    <jsp:useBean id="thisBean" scope="page" class="deepspot.main.SiteMember"/>
    <jsp:setProperty name="thisBean" property="*"/>
  <%if(setObj){
      userInfo.setObj("SiteMember",thisBean);
    } else
    if(getObj){
      thisBean = new SiteMember(thisBean.getFlowKey());
      userInfo.setObj("SiteMember",thisBean);
    } else
    if(submit){
      if(dbExcute){
        thisBean.dbExcute(dbAction,language);
        if(dbAction.equals("delete"))
          userInfo.removeObj("SiteMember");
        else
          userInfo.setObj("SiteMember",thisBean);%>
        <script>
          alert("<%=thisBean.getMsg()%>");
        </script>
    <%} else
      if(dbAction.equals("print")){%>

    <%} else
      if(dbAction.equals("sign")){
        boolean errorFlag = false;
      /*int step = Integer.parseInt(request.getParameter("currentStep"));
        if(step==1) {
        
        }*/
        if(errorFlag){%>
          <script>
            alert("<%=thisBean.getMsg()%>");
          </script>
      <%} else {%>
        <%@ include file="includePage/sign.new"%>
        <%/*Flow f = new Flow(thisBean.getFlowKey());
          if(f.getStatus().equals("approve")){
            
          }*/%>
          <script>
            alert("<%=userInfo.getMsg("jsp.signForm.send")%>");
            location.replace("menu.jsp");
          </script>
      <%}
      } else
      if(dbAction.equals("close")){%>
        <%@ include file="includePage/close.new"%>
    <%}
    }
  }


  SiteMember thisObj;
  if(clearObj){
    thisObj=new SiteMember();
  } else
  if(setObj){
    thisObj=(SiteMember)userInfo.getObj("SiteMember");
  } else
  if(userInfo.getObj("SiteMember")==null){
    if(!flowKey.equals(""))
      thisObj = new SiteMember(flowKey);
    else
      thisObj = new SiteMember();
  } else {
    if(!flowKey.equals("") && (showSignForm || showCloseForm || showFlow))
      thisObj = new SiteMember(flowKey);
    else
      thisObj=(SiteMember)userInfo.getObj("SiteMember");
  }
  if(thisObj.getApplicant()==null || thisObj.getApplicant().equals(""))
    thisObj.setApplicant(emp_id);

  userInfo.setObj("SiteMember",thisObj);

  Flow thisFlow = new Flow(thisObj.getFlowKey());
  int currentStep = thisFlow.getFinished_steps() + 1;%>

<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body><center>
  <form name="input" id="input" action="SiteMember.jsp" method="post">
  <table class="input">

  <%@ include file="includePage/function.new1" %>

  <tr>
    <td align="right" width="25%">
      <%=userInfo.getMsg("jsp.SiteMember.FlowKey")%>
    </td>
    <td>
  <%if(canSelect){%>
      <select id="flowKey" name="flowKey"  onChange="getValue()">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%SiteMember SiteMemberObj=new SiteMember();
        Iterator SiteMemberItr=SiteMemberObj.getList();
        while(SiteMemberItr.hasNext()) {
          SiteMember obj=(SiteMember)SiteMemberItr.next();
          String sNo=obj.getFlowKey();
          String sName=obj.getName();
          if(sName.length()>15) sName=sName.substring(0,15)+"...";
          boolean sFlag=false;
          if(thisObj.getFlowKey().equals(sNo)) sFlag=true;%>
          <option value="<%=sNo%>"<%if(sFlag){%> selected<%}%>>
            <%=sNo%>-<%=sName%>
          </option>
      <%}%>
      </select>
  <%} else {%>
    <input type="text" id="flowKey" name="flowKey" <%=readonly%>
           value="<%=thisObj.getFlowKey()%>"/>
    <%=userInfo.getMsg("jsp.Form.systemGeneration")%>
  <%}%>
    </td>
  </tr>

  <input type="hidden" id="applicant" name="applicant" value="<%=thisObj.getApplicant()%>"/></tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.Account")%>
    </td>
    <td>
      <input type="text" id="account" name="account" <%=disabled%>
             size='12' maxLength='12'
             value="<%=thisObj.getAccount()%>"/>
      &nbsp;&nbsp;
      <%=userInfo.getMsg("jsp.SiteMember.Password")%>
   
      <input type="password" id="password" name="password" size="12" <%=disabled%>
             value="<%=thisObj.getPassword()%>"/>
    </td>
  </tr>
  
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.Name")%>
    </td>
    <td>
      <input type="text" id="name" name="name" <%=disabled%>
             size='12' maxLength='50'
             value="<%=thisObj.getName()%>"/>
      &nbsp;&nbsp;
      <%=userInfo.getMsg("jsp.SiteMember.Birthday")%>
    
      <input type="text" id="birthday" name="birthday" size="12" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openCalendar('birthday')"
        <%}%>
             value="<%=thisObj.getBirthday()%>"/>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.IdCardNo")%>
    </td>
    <td>
      <input type="text" id="idCardNo" name="idCardNo" <%=disabled%>
             size='12' maxLength='12'
             value="<%=thisObj.getIdCardNo()%>"/>
      &nbsp;&nbsp;
      <%=userInfo.getMsg("jsp.SiteMember.Email")%>
     
      <input type="text" id="email" name="email" <%=disabled%>
             size='20' maxLength='50'
             value="<%=thisObj.getEmail()%>"/>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.Mobile")%>
    </td>
    <td>
      <input type="text" id="mobile" name="mobile" <%=disabled%>
             size='12' maxLength='20'
             value="<%=thisObj.getMobile()%>"/>
      &nbsp;&nbsp;
      <%=userInfo.getMsg("jsp.SiteMember.Tel")%>
    
      <input type="text" id="tel" name="tel" <%=disabled%>
             size='12' maxLength='20'
             value="<%=thisObj.getTel()%>"/>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.Address")%>
    </td>
    <td>
      <input type="text" id="address" name="address" <%=disabled%>
             size='50' maxLength='100'
             value="<%=thisObj.getAddress()%>"/>
    </td>
  </tr>

  <!--
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.DateFrom")%>
    </td>
    <td>
      <input type="text" id="dateFrom" name="dateFrom" size="12" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openCalendar('dateFrom')"
        <%}%>
             value="<%=thisObj.getDateFrom()%>"/>
    
      <%=userInfo.getMsg("jsp.SiteMember.DateTo")%>
    
      <input type="text" id="dateTo" name="dateTo" size="12" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openCalendar('dateTo')"
        <%}%>
             value="<%=thisObj.getDateTo()%>"/>
    </td>
  </tr>
  
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.Alias")%>
    </td>
    <td>
      <input type="text" id="alias" name="alias" <%=disabled%>
             size='20' maxLength='50'
             value="<%=thisObj.getAlias()%>"/>
    </td>
  </tr>
  
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.MemberType")%>
    </td>
    <td>
      <input type="text" id="memberType" name="memberType" <%=disabled%>
             size='20' maxLength='20'
             value="<%=thisObj.getMemberType()%>"/>
    </td>
  </tr>
  
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.UnitName")%>
    </td>
    <td>
      <input type="text" id="unitName" name="unitName" <%=disabled%>
             size='20' maxLength='50'
             value="<%=thisObj.getUnitName()%>"/>
    </td>
  </tr>
  
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.PhotoUrl")%>
    </td>
    <td>
      <input type="text" id="photoUrl" name="photoUrl" size="40" <%=readonly%>
         <%if(disabled.equals("")){%>
             onClick="openUpload('photoUrl','Document/SiteMember/<%=emp_id%>','')"
         <%}%>
             value="<%=thisObj.getPhotoUrl()%>"/>
      <%if(!thisObj.getPhotoUrl().equals("")){%>
        <input type="button" value="<%=userInfo.getMsg("jsp.closeForm.open")%>" onClick="photoView('<%=thisObj.getPhotoUrl()%>')"/>
      <%}%>
    </td>
  </tr>
  
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMember.CreateTime")%>
    </td>
    <td>
      <input type="text" id="createTime" name="createTime" <%=readonly%>
             size='20' maxLength='20'
             value="<%=thisObj.getCreateTime()%>"/>
    </td>
  </tr>
  -->

  <tr><td colspan="<%=colspan%>"><br></td></tr>

  <%@ include file="includePage/submit.new" %>

  </table>

  <%@ include file="includePage/showFlow.include" %>
  <%@ include file="includePage/signForm1.include" %>
  <%@ include file="includePage/closeForm.new" %>

  </form>
  </center></body>
</html>
