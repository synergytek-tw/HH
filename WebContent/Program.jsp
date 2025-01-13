<%@ include file="includePage/pageHeader.jsp" %>

<%final String program_id="jsp.Program";
  final String thisJspPage="Program.jsp";
  String title=userInfo.getProgramName(program_id);
  int colspan = 2;
  String fieldAction = "";
  String dbAction = request.getParameter("formType");
  if(dbAction==null) dbAction=userInfo.getAction("Program");
  if(dbAction==null) dbAction="query";
  userInfo.setAction("Program",dbAction);%>

<%@ include file="includePage/getFlags.frameset" %>

<%if(useJavaBean) {%>
    <jsp:useBean id="thisBean" scope="page" class="deepspot.main.Program"/>
    <jsp:setProperty name="thisBean" property="*"/>
  <%if(setObjValue.equals("true")){
      userInfo.setObj("Program",thisBean);
    }
    if(getObjValue.equals("true")){
      thisBean = new Program(thisBean.getProgramId());
      userInfo.setObj("Program",thisBean);
    }
    if(submitValue.equals("true")){
      if(dbExcute){
        thisBean.dbExcute(dbAction,language);
        if(dbAction.equals("delete"))
          userInfo.removeObj("Program");
        else
          userInfo.setObj("Program",thisBean);
      }
      if(thisBean.getMsg()!=null && thisBean.getMsg().trim().length()>0) {%>
        <script>
          alert("<%=thisBean.getMsg()%>");
        </script>
      <%thisBean.setMsg("");
      }
      if(dbAction.equals("print")){%>

    <%}%>
  <%}
  }%>

<%Program thisObj;
  if(clearValue.equals("true") || userInfo.getObj("Program")==null){
    thisObj = new Program();
    userInfo.setObj("Program",thisObj);
  } else {
    thisObj=(Program)userInfo.getObj("Program");
  }%>

<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body>
  <center>
  <form name="input" id="input" action="Program.jsp" method="post">
  <div id="PrintScope">
  <table <%=table_bgcolor%>>

  <%@ include file="includePage/function.frameset1" %>

  <tr <%=tr1%>>
    <td align="right" width="20%">
      <%=userInfo.getMsg("jsp.Program.Program_id")%>
    </td>
    <td colspan="3">
  <%if(canSelect){%>
      <select id="programId" name="programId"  onChange="getValue()">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%Program ProgramObj=new Program();
        Iterator ProgramItr=ProgramObj.getTreeList().iterator();
        while(ProgramItr.hasNext()) {
          Program obj=(Program)ProgramItr.next();
          String preChart="";
          for(int i=1; i<obj.getLayer(); i++){
            preChart+="&nbsp;&nbsp;&nbsp;&nbsp;";
          }
          String sNo=obj.getProgramId();
          String sName=obj.getProgramName();
          if(sName.length()>15) sName=sName.substring(0,15);
          boolean sFlag=false;
          if(thisObj.getProgramId()!=null) 
            if(thisObj.getProgramId().equals(sNo)) sFlag=true;%>
          <option value="<%=sNo%>"<%if(sFlag){%> selected<%}%>>
            <%=preChart+sNo%>-<%=sName%>
          </option>
      <%}%>
      </select>
  <%} else {%>
    <input type="text" id="programId" name="programId"
           value="<%=thisObj.getProgramId()%>"/>
  <%}%>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.ProgramName")%>
    </td>
    <td colspan="3">
      <input type="text" id="programName" name="programName" <%=disabled%>
             size="40" value="<%=thisObj.getProgramName()%>"/>
    </td>
  </tr>
  
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.ParentId")%>
    </td>
    <td colspan="3">
    <%if(disabled.equals("")){%>
      <select id="parentId" name="parentId">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%Program ProgObj=new Program();
        Iterator ProgItr=ProgObj.getMenuList();
        while(ProgItr.hasNext()) {
          Program obj=(Program)ProgItr.next();
          String preChart="";
          for(int i=1; i<obj.getLayer(); i++){
            preChart+="&nbsp;&nbsp;&nbsp;&nbsp;";
          }
          String sNo=obj.getProgramId();
          String sName=obj.getProgramName();
          if(sName.length()>15) sName=sName.substring(0,15);
          boolean sFlag=false;
          if(thisObj.getParentId().equals(sNo)) sFlag=true;%>
          <option value="<%=sNo%>"<%if(sFlag){%> selected<%}%>>
            <%=preChart+sNo%>-<%=sName%>
          </option>
      <%}%>
      </select>
    <%} else {%>
      <input type="text" id="parentId" name="parentId"
             value="<%=thisObj.getParentId()%>"/>
    <%}%>
    </td>
  </tr>
  
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.IsMenu")%>
    </td>
    <td width="30%">
    <%if(disabled.equals("")){%>
      <select id="isMenu" name="isMenu" onChange="setValue()">
	<option value="1"<%if(thisObj.getIsMenu().equals("1")){%> selected<%}%>>
	  <%=userInfo.getMsg("jsp.program.menu")%>
	</option>
	<option value="0"<%if(thisObj.getIsMenu().equals("0")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.program.program")%>
        </option>
      </select>
    <%} else {
        String isMenu = userInfo.getMsg("jsp.program.menu");
        if(thisObj.getIsMenu().equals("0"))
          isMenu = userInfo.getMsg("jsp.program.program");%>
      <input type="text" size="2" <%=readonly%> value="<%=isMenu%>"/>
      <input type="hidden" id="isMenu" name="isMenu" value="<%=thisObj.getIsMenu()%>"/>
    <%}%>
    </td>
    <td align="right" width="20%">
      <%=userInfo.getMsg("jsp.Program.Seq_no")%>
    </td>
    <td width="30%">
      <input type="text" id="seq_no" name="seq_no" <%=disabled%>
             onChange="checkNumber('seq_no')"
             size="4" value="<%=thisObj.getSeq_no()%>"/>
    </td>
  </tr>

<%if(thisObj.getIsMenu().equals("0")){%>
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.Url")%>
    </td>
    <td colspan="3">
      <input type="text" id="url" name="url" <%=disabled%>
             size="50" value="<%=thisObj.getUrl()%>"/>
    </td>
  </tr>
  
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.OnlineHelpUrl")%>
    </td>
    <td colspan="3">
      <input type="text" id="onlineHelpUrl" name="onlineHelpUrl" <%=readonly%>
             size="50" value="<%=thisObj.getOnlineHelpUrl()%>"
             onClick='openUpload("onlineHelpUrl","help/Program/<%=userInfo.getAttribute("emp_id")%>","")'
             onDblClick='setValue()'/>
    <%if(thisObj.getOnlineHelpUrl().trim().length()>0){%>
    	<input type='button' value='<%=userInfo.getMsg("jsp.common.openFile")%>'
    		   onClick='openAppendix("<%=thisObj.getOnlineHelpUrl()%>","help",800,600)'>
    <%}%>
    </td>
  </tr>
  
  <tr <%=tr1%>>
    <td align="right" width="20%">
      <%=userInfo.getMsg("jsp.Program.ProgramMode")%>
    </td>
    <td width="30%">
      <select id="programMode" name="programMode">
	      <option value="B"<%if(thisObj.getProgramMode().equals("B")){%> selected<%}%>>
	        <%=userInfo.getMsg("jsp.Program.BothMode")%>
	      </option>
	      <option value="M"<%if(thisObj.getProgramMode().equals("M")){%> selected<%}%>>
	        <%=userInfo.getMsg("jsp.Program.MaintainMode")%>
	      </option>
	      <option value="S"<%if(thisObj.getProgramMode().equals("S")){%> selected<%}%>>
	        <%=userInfo.getMsg("jsp.Program.SearchMode")%>
	      </option>
      </select>
    </td>
    
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.PageRecords")%>
    </td>
    <td>
      <input type="text" id="pageRecords" name="pageRecords" <%=disabled%>
             onChange="checkNumber('pageRecords')"
             size="4" value="<%=thisObj.getPageRecords()%>"/>
    </td>
  </tr>
  
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.usersDetail.function")%>
    </td>
    <td colspan="3">
      <input type="checkbox" id="queryFunction" name="queryFunction" 
             value="1"<%if(thisObj.getQueryFunction().equals("1")){%> checked<%}%>/>
      <img src="img/C_Find_Sm_N.png" 
           title="<%=userInfo.getMsg("jsp.usersDetail.query")%>"/>&nbsp;&nbsp;&nbsp;
      
      <input type="checkbox" id="updateFunction" name="updateFunction" 
             value="1"<%if(thisObj.getUpdateFunction().equals("1")){%> checked<%}%>/>
      <img src="img/edit2.gif" 
           title="<%=userInfo.getMsg("jsp.usersDetail.edit")%>"/>&nbsp;&nbsp;&nbsp;
      
      <input type="checkbox" id="insertFunction" name="insertFunction" 
             value="1"<%if(thisObj.getInsertFunction().equals("1")){%> checked<%}%>/>
      <img src="img/addanchr.gif" 
           title="<%=userInfo.getMsg("jsp.usersDetail.add")%>"/>&nbsp;&nbsp;&nbsp;
      
      <input type="checkbox" id="deleteFunction" name="deleteFunction" 
             value="1"<%if(thisObj.getDeleteFunction().equals("1")){%> checked<%}%>/>
      <img src="img/C_Delete_Md_N.png" 
           title="<%=userInfo.getMsg("jsp.usersDetail.del")%>"/>&nbsp;&nbsp;&nbsp;
      
      <input type="checkbox" id="printFunction" name="printFunction" 
             value="1"<%if(thisObj.getPrintFunction().equals("1")){%> checked<%}%>/>
      <img src="img/C_Print_Md_N.png" 
           title="<%=userInfo.getMsg("jsp.usersDetail.print")%>"/>
    </td>
  </tr>
  
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.SystemLog")%>
    </td>
    <td colspan="3">
      <input type="checkbox" id="logInsert" name="logInsert" 
             value="1"<%if(thisObj.getLogInsert().equals("1")){%> checked<%}%>/>
      <img src="img/addanchr.gif" 
           title="<%=userInfo.getMsg("jsp.Program.LogInsert")%>"/>&nbsp;&nbsp;&nbsp;
           
      <input type="checkbox" id="logUpdate" name="logUpdate" 
             value="1"<%if(thisObj.getLogUpdate().equals("1")){%> checked<%}%>/>
      <img src="img/edit2.gif" 
           title="<%=userInfo.getMsg("jsp.Program.LogUpdate")%>"/>&nbsp;&nbsp;&nbsp;
      
      <input type="checkbox" id="logDelete" name="logDelete" 
             value="1"<%if(thisObj.getLogDelete().equals("1")){%> checked<%}%>/>
      <img src="img/C_Delete_Md_N.png" 
           title="<%=userInfo.getMsg("jsp.Program.LogDelete")%>"/>&nbsp;&nbsp;&nbsp;
      
      <input type="checkbox" id="logPrint" name="logPrint" 
             value="1"<%if(thisObj.getLogPrint().equals("1")){%> checked<%}%>/>
      <img src="img/C_Print_Md_N.png" 
           title="<%=userInfo.getMsg("jsp.Program.LogPrint")%>"/>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.UseFlow")%>
    </td>
    <td colspan="3">
      <%if(disabled.equals("")){%>
          <input type="checkbox" id="useFlow" name="useFlow" value="1"
                 <%if(thisObj.getUseFlow().equals("1")){%> checked<%}%>
                 onClick="setValue()"/>
      <%} else {%>
          <input type="hidden" id="useFlow" name="useFlow" value="<%=thisObj.getUseFlow()%>"/>
        <%if(thisObj.getUseFlow().equals("1")){%>
            <img src="img/tick.gif"/>
        <%} else {%>
            <img src="img/cross.gif"/>
        <%}
        }%>
    </td>
  </tr>
  
  <%if(thisObj.getUseFlow().equals("1")){%>
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.Flow_id")%>
    </td>
    <td>
      <select id="flow_id" name="flow_id">
        <option value=""><%=userInfo.getMsg("jsp.account.select")%></option>
        <%for(Iterator itr=Util.getFlows().iterator();itr.hasNext();) {
            SelectItem item = (SelectItem)itr.next();
            String flow_id = item.getKey();
            String flow_name = item.getValue();
            boolean sFlag = false;
            if(thisObj.getFlow_id().equals(flow_id)) sFlag = true;%>
        <option value="<%=flow_id%>"<%if(sFlag){%> selected<%}%>>
          <%=flow_name%>
        </option>
       <%}%>
      </select>
    </td>

    <td align="right">
      <%=userInfo.getMsg("jsp.Program.CloseCanReject")%>
    </td>
    <td>
      <%if(disabled.equals("")){%>
          <input type="checkbox" id="closeCanReject" name="closeCanReject" value="Y"
                 <%if(thisObj.getCloseCanReject().equals("Y")){%> checked<%}%>/>
      <%} else {%>
          <input type="hidden" id="closeCanReject" name="closeCanReject" value="<%=thisObj.getCloseCanReject()%>"/>
        <%if(thisObj.getCloseCanReject().equals("Y")){%>
            <img src="img/tick.gif"/>
        <%} else {%>
            <img src="img/cross.gif"/>
        <%}
        }%>
    </td>
  </tr>
  <%}%>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.BeginWord")%>
    </td>
    <td>
      <input type="text" id="beginWord" name="beginWord" <%=disabled%>
             size="4" value="<%=thisObj.getBeginWord()%>"/>
    </td>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.EndNoLength")%>
    </td>
    <td>
      <input type="text" id="endNoLength" name="endNoLength" <%=disabled%>
             onChange="checkNumber('endNoLength')"
             size="4" value="<%=thisObj.getEndNoLength()%>"/>
    </td>
  </tr>

  <!--
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.Date_from")%>
    </td>
    <td>
      <input type="text" id="date_from" name="date_from" size="10" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openCalendar('date_from')"
        <%}%>
             value="<%=thisObj.getDate_from()%>"/>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.Program.Date_to")%>
    </td>
    <td>
      <input type="text" id="date_to" name="date_to" size="10" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openCalendar('date_to')"
        <%}%>
             value="<%=thisObj.getDate_to()%>"/>
    </td>
  </tr>
  -->
<%}%>
  </table>
  </div>
  </form>
  </center>
  </body>
</html>
