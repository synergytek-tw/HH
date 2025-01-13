<%@ include file="includePage/pageHeader.frameset" %>
<%String background="bgcolor='#01458E'";%>
<%String style="style=\"font-size:16px;color:#FFFFFF;text-align:center;letter-spacing:normal;\"";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #D8EBFF;
}
.style1 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 15px;
	letter-spacing:2px;
}
#titleright {
	background-image: url(images/title1_4.jpg);
	background-repeat: no-repeat;
	background-position: right;
	float: right;
	height: 80px;
	width: 600px;
}

#titlelogout {
	float: right;
	height: 80px;
	width: 210px;
	text-align: left;
	padding-top: 15px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #0000BF;
	font-weight: 800;
	line-height: 2em;
	margin-top: 0px;
}
#titlelogout a:link, .titlelogout a:visited, .titlelogout a:active {
	color: #FFF;
	text-decoration: none;
}
#titlelogout a:hover {
	color: #FFFF00;
	text-decoration: none;
}
.rightlogout {
				text-align: right;
}
.bottomline {
				border-bottom: 1px solid #6FBFEF;
}
-->
</style>
<script src="js/jquery-1.7.2.min.js"></script>
<script language="javascript">
function accordion() {
	var cols1 = '200,*';
	var cols2 = '0,*';
	var frameset = $(window.parent.document).find('#frameset1');
	var cols = frameset.attr('cols');
	if(cols == cols1) {
		frameset.attr('cols', cols2);
	}
	else if(cols == cols2) {
		frameset.attr('cols', cols1);
	}
}
</script>
</head>
  <body >
  <table bgcolor='#FFFFFF' width="100%" border="0" cellpadding="0"  height="15"  cellspacing="0" class="bottomline">
  <tr>
	<td width=250 align="left">
		<a href="main.jsp?left=menu.jsp&right=MenuInfo.jsp" target="main" style="font-size:16px;color:#663300;text-align:center;letter-spacing:normal;"><img src="images/home.gif" alt="<%=userInfo.getMsg("jsp.menu.home")%>" width="51" height="16" border="0" title="<%=userInfo.getMsg("jsp.menu.home")%>"></a>
		<a href="main.jsp?left=calendar.jsp&right=MyFavorMenu.jsp" target="main" style="font-size:16px;color:#663300;text-align:center;letter-spacing:normal;"><img src="images/favorite.gif" alt="<%=userInfo.getMsg("jsp.MyFavor.title")%>" width="82" height="16" border="0" title="<%=userInfo.getMsg("jsp.MyFavor.title")%>"></a>
		<a href="javascript:accordion();" style="text-decoration: none;font-size:13px;color:#663300;text-align:center;letter-spacing:normal;"><img src="images/accordion.gif" alt="<%=userInfo.getMsg("jsp.menu.accordion")%>" width="82" height="16" border="0" title="<%=userInfo.getMsg("jsp.menu.accordion")%>"></a>
	</td>
    <td class="rightlogout" >
    	<font color =#0000BF>Welcome</font>&#160;<%=userInfo.getAttribute("user_id")%></font>&#160;&#160;<a href="logout.jsp" target="_top"><img src="images/logout.gif" alt="<%=userInfo.getMsg("jsp.common.logout")%>" width="47" height="16" border="0" title="<%=userInfo.getMsg("jsp.common.logout")%>"></a>
    </td>
  </tr>

</table>
<!-- 
<table bgcolor='#FFFFFF' width="100%" border="0" cellpadding="0" cellspacing="0">
  <tbody> <tr>
	<td></td>
    <td><img src="<%=userInfo.logo %>" alt="logo"  height="60" border="0"/></td>
	<td></td>
  </tr>
</tbody></table>
 -->
  </body>
</html>
