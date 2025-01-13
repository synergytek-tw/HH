<%@ include file="includePage/pageHeader.jsp" %>

<%final String program_id="jsp.SiteMenu";
  final String thisJspPage="SiteMenu.jsp";
  String title=userInfo.getProgramName(program_id);
  int colspan = 2;
  boolean showLogo = true;
  boolean showMenu = true;%>

<%@ include file="includePage/getFlags.new1" %>

<%if(useJavaBean) {%>
    <jsp:useBean id="thisBean" scope="page" class="deepspot.main.SiteMenu"/>
    <jsp:setProperty name="thisBean" property="*"/>
  <%if(setObj){
      userInfo.setObj("SiteMenu",thisBean);
    } else
    if(getObj){
      thisBean = new SiteMenu(thisBean.getFlowKey());
      userInfo.setObj("SiteMenu",thisBean);
    } else
    if(submit){
      if(dbExcute){
        thisBean.dbExcute(dbAction,language);
        if(dbAction.equals("delete"))
          userInfo.removeObj("SiteMenu");
        else
          userInfo.setObj("SiteMenu",thisBean);%>
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


  SiteMenu thisObj;
  if(clearObj){
    thisObj=new SiteMenu();
  } else
  if(setObj){
    thisObj=(SiteMenu)userInfo.getObj("SiteMenu");
  } else
  if(userInfo.getObj("SiteMenu")==null){
    if(!flowKey.equals(""))
      thisObj = new SiteMenu(flowKey);
    else
      thisObj = new SiteMenu();
  } else {
    if(!flowKey.equals("") && (showSignForm || showCloseForm || showFlow))
      thisObj = new SiteMenu(flowKey);
    else
      thisObj=(SiteMenu)userInfo.getObj("SiteMenu");
  }
  if(thisObj.getApplicant()==null || thisObj.getApplicant().equals(""))
    thisObj.setApplicant(emp_id);

  userInfo.setObj("SiteMenu",thisObj);

  Flow thisFlow = new Flow(thisObj.getFlowKey());
  int currentStep = thisFlow.getFinished_steps() + 1;%>

<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body><center>
  <form name="input" id="input" action="SiteMenu.jsp" method="post">
  <table class="input">

  <%@ include file="includePage/function.new1" %>

  <tr>
    <td align="right" width="25%">
      <%=userInfo.getMsg("jsp.SiteMenu.FlowKey")%>
    </td>
    <td>
  <%if(canSelect){%>
      <select id="flowKey" name="flowKey"  onChange="getValue()">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%SiteMenu SiteMenuObj=new SiteMenu();
        Iterator SiteMenuItr=SiteMenuObj.getTreeList();
        while(SiteMenuItr.hasNext()) {
          SiteMenu obj=(SiteMenu)SiteMenuItr.next();
          String preChart="";
          for(int i=1; i<obj.getLayer(); i++){
            preChart+="&nbsp;&nbsp;&nbsp;&nbsp;";
          }
          String sNo=obj.getFlowKey();
          String sName=obj.getSubject();
          if(sName.length()>15) sName=sName.substring(0,15)+"...";
          boolean sFlag=false;
          if(thisObj.getFlowKey().equals(sNo)) sFlag=true;%>
          <option value="<%=sNo%>"<%if(sFlag){%> selected<%}%>>
            <%=preChart+sNo%>-<%=sName%>
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
      <%=userInfo.getMsg("jsp.SiteMenu.Subject")%>
    </td>
    <td>
      <%fieldAction = disabled;
        if(fieldAction.equals(""))
          fieldAction = "onDblClick=\"openPhrase('subject')\" title=\"" + userInfo.getMsg("jsp.Flow.DblClick") + "\"";%>
          <textarea id="subject" name="subject" 
                    rows="1" cols="40" onChange="checkMaxLength('subject',100)"
                    <%=fieldAction%>><%=thisObj.getSubject()%></textarea>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMenu.Description")%>
    </td>
    <td>
      <%fieldAction = disabled;
        if(fieldAction.equals(""))
          fieldAction = "onDblClick=\"openPhrase('description')\" title=\"" + userInfo.getMsg("jsp.Flow.DblClick") + "\"";%>
          <textarea id="description" name="description" 
                    rows="2" cols="40" onChange="checkMaxLength('description',500)"
                    <%=fieldAction%>><%=thisObj.getDescription()%></textarea>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMenu.ParentKey")%>
    </td>
    <td>
      <%if(disabled.equals("")){%>
      <select id="parentKey" name="parentKey" onChange="setValue()">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%SiteMenu SiteMenuObj=new SiteMenu();
        Iterator SiteMenuItr=SiteMenuObj.getTreeList();
        while(SiteMenuItr.hasNext()) {
          SiteMenu obj=(SiteMenu)SiteMenuItr.next();
          String preChart="";
          for(int i=1; i<obj.getLayer(); i++){
            preChart+="&nbsp;&nbsp;&nbsp;&nbsp;";
          }
          String sNo=obj.getFlowKey();
          String sName=obj.getSubject();
          if(sName.length()>15) sName=sName.substring(0,15)+"...";
          boolean sFlag=false;
          if(thisObj.getParentKey().equals(sNo)) sFlag=true;%>
          <option value="<%=sNo%>"<%if(sFlag){%> selected<%}%>>
            <%=preChart+sNo%>-<%=sName%>
          </option>
      <%}%>
      </select>
  <%} else {%>
      <%SiteMenu obj=new SiteMenu(thisObj.getParentKey());%>
      <input type="text" <%=readonly%> value="<%=thisObj.getParentKey()%><%=obj.getSubject()%>"/>
      <input type="hidden" id="parentKey" name="parentKey"value="<%=thisObj.getParentKey()%>"/>
  <%}%>
    </td>
  </tr>
  
  <%if(thisObj.getParentKey().equals("")){%>
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMenu.MenuGroup")%>
    </td>
    <td>
      <select id="menuGroup" name="menuGroup" >
        <option value="TopMenu"<%if(thisObj.getMenuGroup().equals("TopMenu")){%> selected<%}%>>TopMenu</option>
        <option value="BottomMenu"<%if(thisObj.getMenuGroup().equals("BottomMenu")){%> selected<%}%>>BottomMenu</option>
      </select>
    </td>
  </tr>
  <%}%>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMenu.PageUrl")%>
    </td>
    <td>
      <input type="text" id="pageUrl" name="pageUrl" <%=disabled%>
             size='50' maxLength='100'
             value="<%=thisObj.getPageUrl()%>"/>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMenu.Display")%>
    </td>
    <td>
    <%if(disabled.equals("")){%>
        <input type="checkbox" id="display" name="display" onClick="setValue()"
               value="Y"<%if(thisObj.getDisplay().equals("Y")){%> checked<%}%>/>
    <%} else {%>
        <input type="hidden" id="display" name="display" value="<%=thisObj.getDisplay()%>"/>
      <%if(thisObj.getDisplay().equals("Y")){%>
          <img src="img/tick.gif"/>
      <%} else {%>
          <img src="img/cross.gif"/>
      <%}
      }
      if(thisObj.getDisplay().equals("Y")){%>      
      &nbsp;<%=userInfo.getMsg("jsp.SiteMenu.Target")%>
    
      <select id="target" name="target" >
        <option value="_top"<%if(thisObj.getTarget().equals("_top")){%> selected<%}%>>_top</option>
        <option value="_blank"<%if(thisObj.getTarget().equals("_blank")){%> selected<%}%>>_blank</option>
        <option value="Main"<%if(thisObj.getTarget().equals("Main")){%> selected<%}%>>Main</option>
        <option value="Main_left"<%if(thisObj.getTarget().equals("Main_left")){%> selected<%}%>>Main_left</option>
        <option value="Main_right"<%if(thisObj.getTarget().equals("Main_right")){%> selected<%}%>>Main_right</option>
        <option value="Main_right_left"<%if(thisObj.getTarget().equals("Main_right_left")){%> selected<%}%>>Main_right_left</option>
        <option value="Main_right_right"<%if(thisObj.getTarget().equals("Main_right_right")){%> selected<%}%>>Main_right_right</option>
      </select>
    <%}%>
    </td>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMenu.SortNo")%>
    </td>
    <td>
      <input type="text" id="sortNo" name="sortNo" <%=disabled%>
             size='5' maxLength='10'
             value="<%=thisObj.getSortNo()%>"/>
  </tr>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMenu.ShowPhoto")%>
    </td>
    <td>
      <%if(disabled.equals("")){%>
          <input type="checkbox" id="showPhoto" name="showPhoto" onClick="setValue()"
                 value="Y"<%if(thisObj.getShowPhoto().equals("Y")){%> checked<%}%>/>
      <%} else {%>
          <input type="hidden" id="showPhoto" name="showPhoto" value="<%=thisObj.getShowPhoto()%>"/>
        <%if(thisObj.getShowPhoto().equals("Y")){%>
            <img src="img/tick.gif"/>
        <%} else {%>
            <img src="img/cross.gif"/>
        <%}
        }%>
    </td>
  </tr>

  <%if(thisObj.getShowPhoto().equals("Y")){%>
  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMenu.PhotoUrl")%>
    </td>
    <td>
      <input type="text" id="photoUrl" name="photoUrl" size="40" <%=readonly%>
         <%if(disabled.equals("")){%>
             onClick="openUpload('photoUrl','Document/SiteMenu/<%=emp_id%>','')"
         <%}%>
             value="<%=thisObj.getPhotoUrl()%>"/>
      <%if(!thisObj.getPhotoUrl().equals("")){%>
        <input type="button" value="<%=userInfo.getMsg("jsp.closeForm.open")%>" onClick="photoView('<%=thisObj.getPhotoUrl()%>')"/>
      <%}%>
    </td>
  </tr>
  <%}%>

  <tr>
    <td align="right">
      <%=userInfo.getMsg("jsp.SiteMenu.Color")%>
    </td>
    <td>
      <input type="text" id="color" name="color" <%=disabled%>
             size='10' maxLength='20'
             value="<%=thisObj.getColor()%>"/>
      &nbsp;&nbsp;
      <%=userInfo.getMsg("jsp.SiteMenu.Bgcolor")%>
    
      <input type="text" id="bgcolor" name="bgcolor" <%=disabled%>
             size='10' maxLength='20'
             value="<%=thisObj.getBgcolor()%>"/>
    </td>
  </tr>

  <tr><td colspan="<%=colspan%>"><br></td></tr>

  <%@ include file="includePage/submit.new" %>

  </table>

  <%@ include file="includePage/showFlow.include" %>
  <%@ include file="includePage/signForm1.include" %>
  <%@ include file="includePage/closeForm.new" %>

  </form>
  </center></body>
</html>
