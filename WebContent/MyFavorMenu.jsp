<%@ include file="includePage/pageHeader.jsp" %>

<%final String program_id="jsp.MyFavor";
  final String thisJspPage="MyFavorMenu.jsp";
  String title=userInfo.getProgramName(program_id);
  int colspan = 2;%>

<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body>
    <DIV id=detail style="FILTER: shadow(color=#333333,direction=135); WIDTH: 140px; POSITION: absolute; HEIGHT: 120px"></DIV>
    <table width="170" border="0" cellpadding="1" cellspacing="1" bgcolor="#D7D7D7">
      <tr><td align=center><%=title%></td></tr>
  <%Iterator itr = new MyFavor().getPersonList(userInfo.getAttribute("emp_id")).iterator();
    int i = 0;
    String bgcolor;
    while(itr.hasNext()){
      i++;
      if(i%2==0) bgcolor = "#F7F7F7";
      else bgcolor = "#F8F9DB"; 
      
      HashMap<String,String> map = (HashMap<String,String>)itr.next();
      String PageUrl = (String)map.get("PageUrl");
      String UseMyFile = (String)map.get("UseMyFile");
      String FileUrl = (String)map.get("FileUrl");
      String NewWindow = (String)map.get("NewWindow");
      String Description = (String)map.get("Description");
      String Subject = (String)map.get("Subject");
      
      String url = PageUrl;
      if(UseMyFile.trim().equals("Y"))
        url = FileUrl;
        
      String target = "main_left";
      if(NewWindow.trim().equals("Y"))
        target = "_blank";%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="#FFFF80"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td>
          <a href="<%=url%>" target="<%=target%>" onMouseOver='mOvr("<%=Description%>")'
             onMouseOut='mOut()'><%=Subject%></a>
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

//¨ú±o¦ì¸m
function mEvn() {
  x=event.x;
  y=event.y;
}
</script>