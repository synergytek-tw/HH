<%@ include file="includePage/pageHeader.jsp" %>

<%final String program_id="jsp.MenuInfo";
  String title=userInfo.getProgramName(program_id);
  int colspan = 2;%>
<%if(Cnstnts.TRUE_FLAG.equals(request.getParameter("leftReflash"))){%>
    <script>
      top.frames[3].frames[0].location.href='menu.jsp';
    </script>
<%}%>
<%/* �^���y�{������� */
  int signingCount = 0;
  int signedCount = 0;
  int rejectCount = 0;
  int wait2SignCount = 0;
  int agentSignCount = 0;
  int wait2CloseCount = 0;
  int wait2PayCount = 0;
  int noticeCount = 0;
  int ToDosCount = 0;
  int QuotationCount = 0;
  String emp_id = userInfo.getAttribute("emp_id");
  String target = "main_left";
  String tr1 = "#F8F9DB";
  String tr2 = "#F7F7F7";
  String bgcolor = tr2;
  String lineTitle = userInfo.getMsg("jsp.MenuInfo.lineTitle");
  String lineMessage = "";
  String url = "";
  Flow flow = new Flow(emp_id);
  wait2PayCount = flow.getWait2PayList(emp_id).size();
  String whereStr = "where closer_id='"+emp_id+"' or signer_id='"+emp_id+"' or applicant_id='"+emp_id+"'";
  Iterator itr = flow.getList(whereStr);
  if(itr.hasNext()){
    while(itr.hasNext()){
      Flow f = (Flow)itr.next();
      /* �i�椤��� */
      if(f.getStatus().equals("signing") && f.getApplicant_id().equals(emp_id)){
        signingCount++;
      }
      /* �w�����{�Ǫ�� */
      if(f.getStatus().equals("approve") && !f.getCloseFlag().equals("Y") 
      																		&& f.getApplicant_id().equals(emp_id)){
        signedCount++;
      }
      /* �Q��^��� */
      if(f.getStatus().equals("reject") && !f.getCloseFlag().equals("Y") 
      																		&& f.getApplicant_id().equals(emp_id)){
        rejectCount++;
      }
      /* ��ñ�֪�� */
      if(f.getStatus().equals("signing") && f.getSigner_id().equals(emp_id) 
      														&& f.getSigner_id().equals(f.getSrcSigner_id())){
        wait2SignCount++;
      }
      /* �N�zñ�֪�� */
      if(f.getStatus().equals("signing") && f.getSigner_id().equals(emp_id) 
      													 && !f.getSigner_id().equals(f.getSrcSigner_id())){
        agentSignCount++;
      }
      /* ���k�ɪ�� */
      if((f.getStatus().equals("approve") || f.getStatus().equals("reject")) 
                                 && f.getCloser_id().equals(emp_id) 
      													 && f.getClosed_time().trim().length()==0){
        wait2CloseCount++;
      }
    }
  }
  List ToDoList = new ToDos().getNotFinishedList(emp_id, userInfo);
  for(itr=ToDoList.iterator();itr.hasNext();){
    itr.next();
    ToDosCount++;
  }
  List noticeList = new Notice().getPersonalList(emp_id,userInfo.getAttribute("dept_id"));
  for(itr=noticeList.iterator();itr.hasNext();){
    itr.next();
    noticeCount++;
  }
  int blockCount = 0;
  if(signingCount>0) blockCount++;
  if(signedCount>0) blockCount++;
  if(rejectCount>0) blockCount++;
  if(wait2SignCount>0) blockCount++;
  if(agentSignCount>0) blockCount++;
  if(wait2CloseCount>0) blockCount++;
  if(wait2PayCount>0) blockCount++;
  if(noticeCount>0) blockCount++;
  if(ToDosCount>0) blockCount++;
%>

<html>
  <head>
    <title><%=title%></title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <link href="css/default.css" rel="stylesheet" type="text/css">
    <script language="JavaScript" src="js/keywear.js"></script>
    <script language="JavaScript" src="js/tree.js"></script>
    <script language="JavaScript" src="js/ajax.js"></script>
    <meta http-equiv="refresh" content="600; url=MenuInfo.jsp?leftReflash=true">
  </head>
  <body>
    <DIV id=detail style="FILTER: shadow(color=#333333,direction=135); WIDTH: 140px; POSITION: absolute; HEIGHT: 0px"></DIV>
    <table width="170" border="0" cellpadding="1" cellspacing="1" bgcolor="#D7D7D7">
      <tr><td align='center' onClick='leftReflash();reflash()'><%=title%></td></tr>
    <%if(noticeCount>0){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.menu.Notice")+"-["+
                    userInfo.getMsg("jsp.MenuInfo.have")+noticeCount+
                    userInfo.getMsg("jsp.MenuInfo.record")+"]";
      url = "menu.jsp?showFlag=notice";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    <%if(ToDosCount>0){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.ToDos.title")+"-["+
                    userInfo.getMsg("jsp.MenuInfo.have")+ToDosCount+
                    userInfo.getMsg("jsp.MenuInfo.record")+"]";
      url = "menu.jsp?showFlag=ToDos";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    <%if(wait2SignCount>0){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.menu.waitSign")+"-["+
                    userInfo.getMsg("jsp.MenuInfo.have")+wait2SignCount+
                    userInfo.getMsg("jsp.MenuInfo.record")+"]";
      url = "menu.jsp?showFlag=wait2Sign";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    <%if(agentSignCount>0){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.Flow_detail.agentSigner")+"-["+
                    userInfo.getMsg("jsp.MenuInfo.have")+agentSignCount+
                    userInfo.getMsg("jsp.MenuInfo.record")+"]";
      url = "menu.jsp?showFlag=agentSign";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    <%if(signingCount>0){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.menu.signing")+"-["+
                    userInfo.getMsg("jsp.MenuInfo.have")+signingCount+
                    userInfo.getMsg("jsp.MenuInfo.record")+"]";
      url = "menu.jsp?showFlag=signing";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    <%if(signedCount>0){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.menu.processed")+"-["+
                    userInfo.getMsg("jsp.MenuInfo.have")+signedCount+
                    userInfo.getMsg("jsp.MenuInfo.record")+"]";
      url = "menu.jsp?showFlag=signed";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    <%if(rejectCount>0){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.menu.reject")+"-["+
                    userInfo.getMsg("jsp.MenuInfo.have")+rejectCount+
                    userInfo.getMsg("jsp.MenuInfo.record")+"]";
      url = "menu.jsp?showFlag=reject";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    <%if(wait2CloseCount>0){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.menu.waitClose")+"-["+
                    userInfo.getMsg("jsp.MenuInfo.have")+wait2CloseCount+
                    userInfo.getMsg("jsp.MenuInfo.record")+"]";
      url = "menu.jsp?showFlag=wait2Close";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    <%if(wait2PayCount>0){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.menu.wait2Pay")+"-["+
                    userInfo.getMsg("jsp.MenuInfo.have")+wait2PayCount+
                    userInfo.getMsg("jsp.MenuInfo.record")+"]";
      url = "menu.jsp?showFlag=wait2Pay";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    <%
      String canShowTmMonitor = "true"; 
      if(canShowTmMonitor.equals(userInfo.getAttribute("showTmMonitor"))){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.MenuInfo.TmMonitorResult");
      url = "menu.jsp?showFlag=tmMonitorResult";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>  
    <%if(blockCount>1){
      if(bgcolor.equals(tr2)){bgcolor=tr1;} else {bgcolor=tr2;}
      lineMessage = userInfo.getMsg("jsp.MenuInfo.showAll");
      url = "menu.jsp?showFlag=showAll";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td align='center'>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=lineTitle%>")'
             onMouseOut='mOut()'><%=lineMessage%></a>
        </td>
      </tr>
    <%}%>
    </table>
  </body>
</html>

<script>
document.onmousemove = mEvn;
dStyle = detail.style;
var x=0;
var y=0;
function mOvr(desc) {
  if(desc.length>0){
    var s = '<TABLE WIDTH="130" BORDER=0 CELLPADDING="2" CELLSPACING=0 BGCOLOR="#000066" style="filter:Alpha(opacity=70)">'+
              '<TR><TD>' +
                '<TABLE WIDTH=100% BORDER=0 CELLPADDING=0 CELLSPACING=0>'+
                  '<TR><TD><FONT COLOR="#ffffff" STYLE="font-size:9pt;">'+
                     desc +
                  '</FONT></TD></TR>'+
                '</TABLE>'+
              '</TD></TR>'+
            '</TABLE>';
    document.all["detail"].innerHTML = s;

   	dStyle.left = x+20;
    dStyle.top = y;
    dStyle.visibility = "visible";
  }
}

function mOut() {
	dStyle.visibility = "hidden";
}

//��o��m
function mEvn() {
  x=event.x;
  y=event.y;
}

function reflash(){
  location.reload();
}
function leftReflash(){
  top.frames[3].frames[0].location.reload();
}
</script>