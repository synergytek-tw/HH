<%@ include file="includePage/pageHeader.jsp" %>

<%final String program_id="jsp.SiteNews";
  final String thisJspPage="SiteNews.jsp";
  String title=userInfo.getProgramName(program_id);
  int colspan = 2;
  boolean showLogo = true;
  boolean showMenu = true;%>

<%@ include file="includePage/getFlags.new1" %>

<%if(useJavaBean) {%>
    <jsp:useBean id="thisBean" scope="page" class="deepspot.main.SiteNews"/>
    <jsp:setProperty name="thisBean" property="*"/>
  <%if(setObj){
      userInfo.setObj("SiteNews",thisBean);
    } else
    if(getObj){
      thisBean = new SiteNews(thisBean.getFlowKey());
      userInfo.setObj("SiteNews",thisBean);
    } else
    if(submit){
      if(dbExcute){
        thisBean.dbExcute(dbAction,language);
        if(dbAction.equals("delete"))
          userInfo.removeObj("SiteNews");
        else
          userInfo.setObj("SiteNews",thisBean);%>
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


  SiteNews thisObj;
  if(clearObj){
    thisObj=new SiteNews();
  } else
  if(setObj){
    thisObj=(SiteNews)userInfo.getObj("SiteNews");
  } else
  if(userInfo.getObj("SiteNews")==null){
    if(!flowKey.equals(""))
      thisObj = new SiteNews(flowKey);
    else
      thisObj = new SiteNews();
  } else {
    if(!flowKey.equals("") && (showSignForm || showCloseForm || showFlow))
      thisObj = new SiteNews(flowKey);
    else
      thisObj=(SiteNews)userInfo.getObj("SiteNews");
  }
  if(thisObj.getApplicant()==null || thisObj.getApplicant().equals(""))
    thisObj.setApplicant(emp_id);

  userInfo.setObj("SiteNews",thisObj);

  Flow thisFlow = new Flow(thisObj.getFlowKey());
  int currentStep = thisFlow.getFinished_steps() + 1;%>

<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body><center>
  <form name="input" id="input" action="SiteNews.jsp" method="post">
  <table class="input">

  <%@ include file="includePage/function.new1" %>

  <tr>
    <td align="right" width="28%">
      <%=userInfo.getMsg("jsp.SiteNews.FlowKey")%>
    </td>
    <td>
  <%if(canSelect){%>
      <select id="flowKey" name="flowKey"  onChange="getValue()">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%SiteNews SiteNewsObj=new SiteNews();
        Iterator SiteNewsItr=SiteNewsObj.getList();
        while(SiteNewsItr.hasNext()) {
          SiteNews obj=(SiteNews)SiteNewsItr.next();
          String sNo=obj.getFlowKey();
          String sName=obj.getSubject();
          if(sName.length()>15) sName=sName.substring(0,15)+"...";
          boolean sFlag=false;
          if(thisObj.getFlowKey().equals(sNo)) sFlag=true;%>
          <option value="<%=sNo%>"<%if(sFlag){%> selected<%}%>>
            <%=sNo%>-<%=sName%>
          </option>
      <%}%>
      </select>
  <%} else {%>
    <input type="text" id="flowKey" name="flowKey"
           value="<%=thisObj.getFlowKey()%>"/>
    <%=userInfo.getMsg("jsp.Form.systemGeneration")%>
  <%}%>
    </td>
  </tr>

  <input type="hidden" id="applicant" name="applicant" value="<%=thisObj.getApplicant()%>"/>
    
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteNews.Subject")%>
    </td>
    <td>
      <%fieldAction = disabled;
        if(fieldAction.equals(""))
          fieldAction = "onDblClick=\"openPhrase('subject')\" title=\"" + userInfo.getMsg("jsp.Flow.DblClick") + "\"";%>
          <textarea id="subject" name="subject" 
                    rows="2" cols="50" onChange="checkMaxLength('subject',200)"
                    <%=fieldAction%>><%=thisObj.getSubject()%></textarea>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteNews.Content")%>
    </td>
    <td>
      <%fieldAction = disabled;
        if(fieldAction.equals(""))
          fieldAction = "onDblClick=\"openPhrase('content')\" title=\"" + userInfo.getMsg("jsp.Flow.DblClick") + "\"";%>
          <textarea id="content" name="content" 
                    rows="5" cols="50" onChange="checkMaxLength('content',1000)"
                    <%=fieldAction%>><%=thisObj.getContent()%></textarea>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteNews.PubDate")%>
    </td>
    <td>
      <input type="text" id="pubDate" name="pubDate" size="10" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openCalendar('pubDate')"
        <%}%>
             value="<%=thisObj.getPubDate()%>"/>
      &nbsp;&nbsp;
      <%=userInfo.getMsg("jsp.SiteNews.PubUnit")%>
    
      <input type="text" id="pubUnit" name="pubUnit" <%=disabled%>
             size='12' maxLength='50'
             value="<%=thisObj.getPubUnit()%>"/>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteNews.Appendix")%>
    </td>
    <td>
      <input type="text" id="appendix" name="appendix" size="40" <%=readonly%>
         <%if(disabled.equals("")){%>
             onClick="openUpload('appendix','Document/SiteNews/<%=emp_id%>','')"
         <%}%>
             value="<%=thisObj.getAppendix()%>"/>
      <%if(!thisObj.getAppendix().equals("")){%>
        <input type="button" value="<%=userInfo.getMsg("jsp.closeForm.open")%>" onClick="photoView('<%=thisObj.getAppendix()%>')"/>
      <%}%>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteNews.EffectFlag")%>
    </td>
    <td>
      <%if(disabled.equals("")){%>
          <input type="checkbox" id="effectFlag" name="effectFlag" value="Y"<%if(thisObj.getEffectFlag().equals("Y")){%> checked<%}%>/>
      <%} else {%>
          <input type="hidden" id="effectFlag" name="effectFlag" value="<%=thisObj.getEffectFlag()%>"/>
        <%if(thisObj.getEffectFlag().equals("Y")){%>
            <img src="img/tick.gif"/>
        <%} else {%>
            <img src="img/cross.gif"/>
        <%}
        }%>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteNews.DateFrom")%>
    </td>
    <td>
      <input type="text" id="dateFrom" name="dateFrom" size="10" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openCalendar('dateFrom')"
        <%}%>
             value="<%=thisObj.getDateFrom()%>"/>
      
      <%=userInfo.getMsg("jsp.SiteNews.DateTo")%>
    
      <input type="text" id="dateTo" name="dateTo" size="10" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openCalendar('dateTo')"
        <%}%>
             value="<%=thisObj.getDateTo()%>"/>
    </td>
  </tr>

  <input type="hidden" id="createTime" name="createTime" value="<%=thisObj.getCreateTime()%>"/>

  <tr><td colspan="<%=colspan%>"><br></td></tr>

  <%@ include file="includePage/submit.new" %>

  </table>

  <%@ include file="includePage/showFlow.include" %>
  <%@ include file="includePage/signForm1.include" %>
  <%@ include file="includePage/closeForm.new" %>

  </form>
  </center></body>
</html>
