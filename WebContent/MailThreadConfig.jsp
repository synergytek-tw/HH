<%@ include file="includePage/pageHeader.jsp" %>

<%final String program_id="jsp.MailThreadConfig";
  final String thisJspPage="MailThreadConfig.jsp";
  String title=userInfo.getProgramName(program_id);
  int colspan = 2;
  String fieldAction = "";
  String dbAction = request.getParameter("formType");
  if(dbAction==null) dbAction=userInfo.getAction("MailThreadConfig");
  if(dbAction==null) dbAction="query";
  userInfo.setAction("MailThreadConfig",dbAction);%>

<%@ include file="includePage/getFlags.frameset" %>

<%if(useJavaBean) {%>
    <jsp:useBean id="thisBean" scope="page" class="deepspot.main.MailThreadConfig"/>
    <jsp:setProperty name="thisBean" property="*"/>
  <%MailThreadConfig tmpMastObj = (MailThreadConfig)userInfo.getObj("MailThreadConfig");
    thisBean.setDetails(tmpMastObj.getDetails());%>
  <%if(setObjValue.equals("true")){
      userInfo.setObj("MailThreadConfig",thisBean);
    }
    if(getObjValue.equals("true")){
      if(thisBean.getKeyValue()==null)
        thisBean = new MailThreadConfig();
      else
        thisBean = new MailThreadConfig(thisBean.getKeyValue());
      userInfo.setObj("MailThreadConfig",thisBean);
    }
    if(submitValue.equals("true")){
      if(dbExcute){
        thisBean.dbExcute(dbAction,language);
        if(dbAction.equals("delete"))
          userInfo.removeObj("MailThreadConfig");
        else
          userInfo.setObj("MailThreadConfig",thisBean);
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
    MailThreadConfig tmpMastObj=(MailThreadConfig)userInfo.getObj("MailThreadConfig");
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
        MailThreadConfig_detail detailObj = (MailThreadConfig_detail)detailItr.next();
        amount += detailObj.getAmount;
      }
      tmpMastObj.setAmount(amount);
      */
      tmpMastObj.setDetails(tmpDetails);
      userInfo.setObj("MailThreadConfig",tmpMastObj);
    }
  }%>
<%MailThreadConfig thisObj;
  if(clearValue.equals("true") || userInfo.getObj("MailThreadConfig")==null){
    thisObj = new MailThreadConfig();
    userInfo.setObj("MailThreadConfig",thisObj);
  } else {
    thisObj=(MailThreadConfig)userInfo.getObj("MailThreadConfig");
  }%>

<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
<script language="javascript">
function testMail(){
	if(!document.input.TestAddress.value) {
		alert('請輸入測試信箱');
	}	
	
	document.input.sendTestMail.value="true";
	document.input.submit();
}
</script>
  <body>
  <center>
  <form name="input" id="input" action="MailThreadConfig.jsp" method="post">
  <input type="hidden" name="sendTestMail" id="sendTestMail">
  <div id="PrintScope">
  <table <%=table_bgcolor%>>

  <%@ include file="includePage/function.frameset1" %>

  <tr <%=tr1%>>
    <td align="right" width="20%">
      <%=userInfo.getMsg("jsp.MailThreadConfig.KeyValue")%>
    </td>
    <td colspan="3">
  <%if(canSelect){%>
      <select id="keyValue" name="keyValue"  onChange="getValue()">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%MailThreadConfig MailThreadConfigObj=new MailThreadConfig();
        Iterator MailThreadConfigItr=MailThreadConfigObj.getList();
        while(MailThreadConfigItr.hasNext()) {
          MailThreadConfig obj=(MailThreadConfig)MailThreadConfigItr.next();
          String sNo=obj.getKeyValue();
          String sName=obj.getEmailAddress();
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
           value="<%=userInfo.getMsg("jsp.MailThreadConfig.DefaultKeyValue")%>"/>
    <%}else{%>
    <input type="text" id="keyValue" name="keyValue"
           value="<%=thisObj.getKeyValue()%>"/>
    <%}%>
  <%}%>
    &nbsp;&nbsp;  
    <%=userInfo.getMsg("jsp.MailThreadConfig.ExecuteStatus")%>
    
    <%MailThreadConfig tmpObj = new MailThreadConfig(thisObj.getKeyValue());
      if(tmpObj.getTurnOn().toUpperCase().equals("N") || tmpObj.getTurnOn().equals("")){%>
      <input type="text" disabled size="10"
             value="<%=userInfo.getMsg("jsp.MailThreadConfig.DefaultExecuteStatusOff")%>"/>
    <%}else{%>
      <input type="text" disabled size="10"
             value="<%=userInfo.getMsg("jsp.MailThreadConfig.DefaultExecuteStatusOn")%>"/>
    <%}%>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.LastExecuteTime")%>
    </td>
    <td width="30%">
      <%if(tmpObj.getLastExecuteTime().equals("")){%>
      <input type="text" disabled
             value="<%=userInfo.getMsg("jsp.MailThreadConfig.DefaultLastExecuteTime")%>"/>
      <%}else{%>
      <input type="text" id="lastExecuteTime" name="lastExecuteTime" <%=disabled%>
             value="<%=tmpObj.getLastExecuteTime()%>"/>
      <%}%>
    </td>
    <td align="right" width="20%">
      <%=userInfo.getMsg("jsp.MailThreadConfig.NextExecuteTime")%><br>
      <%=userInfo.getMsg("jsp.MailThreadConfig.DefaultLastExecuteTimeNote")%>
    </td>
    <td width="30%">
      <%if(tmpObj.getNextExecuteTime().equals("")){%>
      <input type="text" id="nextExecuteTime" name="nextExecuteTime" size="20" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openDateTime('nextExecuteTime')"
        <%}%>
             value="<%=tmpObj.getNextExecuteTime()%>"/>
      <%}else{%>
      <input type="text" id="nextExecuteTime" name="nextExecuteTime" size="20" <%=readonly%>
        <%if(disabled.equals("")){%>
             onClick="openDateTime('nextExecuteTime')"
        <%}%>
             value="<%=tmpObj.getNextExecuteTime()%>"/>
      <%}%>
    </td>
  </tr>
  
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.DelayTime")%>
    </td>
    <td>
      <input type="text" id="delayTime" name="delayTime" <%=disabled%>
             size="2" value="<%=thisObj.getDelayTime()%>"/>
    </td>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.MailPeriod")%>
    </td>
    <td>
      <%if(thisObj.getMailPeriod().equals("")){%>
      <input type="text" disabled size="10" 
             value="<%=userInfo.getMsg("jsp.MailThreadConfig.DefaultMailPeriod")%>"/>
      <input type="hidden" id="mailPeriod" name="mailPeriod" <%=disabled%>
             value="60"/>
      <%}else{%>
      <input type="text" id="mailPeriod" name="mailPeriod" <%=disabled%>
             size="2" value="<%=thisObj.getMailPeriod()%>"/>
      <%}%>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.Host")%>
    </td>
    <td>
      <input type="text" id="host" name="host" <%=disabled%> size="25" value="<%=thisObj.getHost()%>"/>
      <%=userInfo.getMsg("jsp.MailThreadConfig.SmtpPort")%><input type="text" id="smtpPort" name="smtpPort" <%=disabled%> size="6" value="<%=thisObj.getSmtpPortString()%>"/>
    </td>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.EmailAddress")%>
    </td>
    <td>
      <input type="text" id="emailAddress" name="emailAddress" <%=disabled%>
             size="25" value="<%=thisObj.getEmailAddress()%>"/>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.EmailAccount")%>
    </td>
    <td>
      <input type="text" id="emailAccount" name="emailAccount" <%=disabled%>
             size="25" value="<%=thisObj.getEmailAccount()%>"/>
    </td>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.Password")%>
    </td>
    <td>
      <input type="password" id="password" name="password" <%=disabled%>
             value="<%=thisObj.getPassword()%>"/>
    </td>
  </tr>

  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.Authority")%>
    </td>
    <td>
      <%if(disabled.equals("")){%>
          <input type="checkbox" id="authority" name="authority" value="Y"<%if(tmpObj.getAuthority().equals("Y")){%> checked<%}%>/>
      <%} else {%>
          <input type="hidden" id="authority" name="authority" value="<%=tmpObj.getAuthority()%>"/>
        <%if(tmpObj.getAuthority().equals("Y")){%>
            <img src="img/tick.gif"/>
        <%} else {%>
            <img src="img/cross.gif"/>
        <%}
        }%>
    </td>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.Exchange")%>
    </td>
    <td>
    <%if(disabled.equals("")){%>
          <input type="checkbox" id="exchange" name="exchange" value="Y"<%if(tmpObj.getExchange().equals("Y")){%> checked<%}%>/>
      	<%} else {%>
          <input type="hidden" id="exchange" name="exchange" value="<%=tmpObj.getExchange()%>"/>
	        <%if(tmpObj.getExchange().equals("Y")){%>
	            <img src="img/tick.gif"/>
	        <%} else {%>
	            <img src="img/cross.gif"/>
	        <%}
        }%>
    
    </td>
  </tr>
  
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.SecurityType")%>
    </td>
    <td>
      <%if(disabled.equals("")){%>
      <input type="radio" id="securityType" name="securityType" value="TLS" <%=disabled%> <%if(tmpObj.getSecurityType().equals("TLS")){%> checked<%}%>/>TLS
      <input type="radio" id="securityType" name="securityType" value="SSL" <%=disabled%> <%if(tmpObj.getSecurityType().equals("SSL")){%> checked<%}%>/>SSL
      <input type="radio" id="securityType" name="securityType" value="" <%=disabled%> <%if(Util.isEmpty(tmpObj.getSecurityType())){%> checked<%}%>/><%=userInfo.getMsg("jsp.MailThreadConfig.NoneSecurityType")%>
      <%} else {%>
          <input type="hidden" id="securityType" name="securityType" value="<%=tmpObj.getSecurityType()%>"/>
          <%
            if(Util.compareTo(tmpObj.getSecurityType(), "TLS")){
          %> TLS
          <%
            }
            else if(Util.compareTo(tmpObj.getSecurityType(), "SSL")){
          %> SSL
          <%
            }
            else {
          %><%=userInfo.getMsg("jsp.MailThreadConfig.NoneSecurityType")%>
          <%
            }
          %>
          
      <%}%>
      
      
    </td>
    <td align="right">
    	<%=userInfo.getMsg("jsp.MailThreadConfig.TurnOn")%>
    </td>
    <td>
		<%if(disabled.equals("")){%>
			<input type="checkbox" id="turnOn" name="turnOn" value="Y"<%if(tmpObj.getTurnOn().equals("Y")){%> checked<%}%>/>
		<%} else {%>
			<input type="hidden" id="turnOn" name="turnOn" value="<%=tmpObj.getTurnOn()%>"/>
			<%if(tmpObj.getTurnOn().equals("Y")){%>
			  <img src="img/tick.gif"/>
			<%} else {%>
			  <img src="img/cross.gif"/>
			<%}
		}%>
    </td>
  </tr>
  <tr <%=tr1%>>
    <td align="right">
      <%=userInfo.getMsg("jsp.MailThreadConfig.TestAddress")%>
    </td>
    <td colspan="3">
    	<input type="text" id="testAddress" name="testAddress" <%=disabled%> value="<%=thisObj.getTestAddress()%>" size="40"/>
    	<%if(disabled.equals("")){%>
      	<input type="button" value="<%=userInfo.getMsg("jsp.MailThreadConfig.TestBtn")%>" onclick="document.input.sendTestMail.value='true';setSubmitValue('update')">
      	<%} %>
    </td>
  </tr>
  
  </table>

  <input type="hidden" id="deleteDetailValue" name="deleteDetailValue" value=""/>
<%
			String scriptText = "<script>"+
								"function openFrame(jspName,dbActionMode,index,frameHight){"+
								"  var frameWidth=document.getElementById('detailTable').offsetWidth;"+
								"  var frameDiv=document.getElementById('frameDiv');"+
								"  var srcUrl=jspName+'.jsp?formAction='+dbActionMode;"+
								"  if(dbActionMode=='update'){"+
								"    srcUrl += '&index='+index;"+
								"  }"+
								"  frameDiv.innerHTML=\"<iframe "+
									"src='\"+srcUrl+\"' height='\"+frameHight+\"' width='\"+(frameWidth-10)+\"'></iframe>\";"+
								"}"+
								"function closeFrame(){"+
								"  var frameDiv=document.getElementById('frameDiv');"+
								"  frameDiv.innerHTML='';"+
								"}"+
								"</script>";
%>
<%if(disabled.equals("")){%>
  <%=scriptText%>
<%}%>
  <table id='detailTable' <%=table_bgcolor%>>
    <tr>
      <td colspan="7">
        <div class="logTitle"><%=userInfo.getMsg("jsp.MailThreadConfig_detail.title")%></div>
      </td>
    </tr>
    <tr><td colspan="7"><div id='frameDiv'></div></td></tr>
    <tr <%=th_bgcolor%>>
      <td align='center' width="3%">
    <%if(disabled.equals("")){%>
        <img src="img/addanchr.gif" style="cursor: hand"
             title="<%=userInfo.getMsg("jsp.Flow_detail.addNew")%>"
             onClick='openFrame("MailThreadConfig_detail","insert",0,350)'/>
    <%}%>
      </td>
      <td align='center' width="14%"><%=userInfo.getMsg("jsp.MailThreadConfig_detail.MailTo")%></td>
      <td align='center' width="14%"><%=userInfo.getMsg("jsp.MailThreadConfig_detail.CCTo")%></td>
      <td align='center' width="20%"><%=userInfo.getMsg("jsp.MailThreadConfig_detail.Title")%></td>
      <td align='center' width="32%"><%=userInfo.getMsg("jsp.MailThreadConfig_detail.Content")%></td>
      <td align='center' width="14%"><%=userInfo.getMsg("jsp.MailThreadConfig_detail.MailTime")%></td>
      <td align='center' width="3%">
    <%if(disabled.equals("")){%>
        <img src="img/C_Delete_Md_N.png" style="cursor: hand"
             title="<%=userInfo.getMsg("jsp.usersDetail.delete")%>"
             onClick="document.input.deleteDetailValue.value='true';setValue()""/>
    <%}%>
      </td>
    </tr>
<%Iterator detailItr = thisObj.getDetails().iterator();
  int i = 0;
  while(detailItr.hasNext()) {
    MailThreadConfig_detail obj = (MailThreadConfig_detail)detailItr.next();%>
    <tr <%=tr1%>>
      <td align="center">
      <%if(disabled.equals("")){%>
        <img src="img/edit2.gif" style="cursor: hand"
             title="<%=userInfo.getMsg("jsp.Flow.edit")%>"
             onClick='openFrame("MailThreadConfig_detail","update",<%=i%>,350)'/>
      <%}%>
      </td>
      <td><%=obj.getMailTo()%></td>
      <td><%=obj.getCCTo()%></td>
      <td><%=obj.getTitle()%></td>
      <td><%=obj.getContent()%></td>
      <td align='center'><%=obj.getMailTime()%></td>
      <td align='center'>
      <%if(disabled.equals("")){%>
        <input type="checkbox" name="delete"
               title="<%=userInfo.getMsg("jsp.usersDetail.delete2")%>"
               value="<%=i%>"/>
      <%}%>
      </td>
      <%i++;%>
    </tr>
<%}%>
  </table></div></form></center></body>
</html>
