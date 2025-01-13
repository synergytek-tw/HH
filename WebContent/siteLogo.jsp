<%@ include file="includePage/pageHeader.frameset" %>
<%String color=userInfo.getInfoValue("siteLogo.jsp.color"),
         bgcolor=userInfo.getInfoValue("siteLogo.jsp.bgcolor"),
         background=userInfo.getInfoValue("siteLogo.jsp.background"),
         font_family=userInfo.getInfoValue("siteLogo.jsp.font_family");%>
<html>
  <head>
  </head>
  <body bgcolor="#6E6E6E">
    <table style="POSITION: absolute; TOP: 0; LEFT: 0;" width="100%"
             cellpadding="0" cellspacing="0" border="0" <%=background%> align="left"><tr>
      <td width="25%" align="left">
          <a href="site.jsp" target="_top"><img src="/site/img/logo.jpg" border="0"></a>
      </td>
      <td width="50%" align="center">
        <%String style="style=\"font-family:'"+font_family+"';font-size:30px;color:"+color+";text-align:center;letter-spacing:normal;\"";%>
        <div <%=style%>><%=userInfo.getInfoValue("site.jsp.title")%></div>
      </td>
      <td align="right">
        <table width="100" height="27" align="right" background="img/right_icons.gif">
          <tr>
            <td width="10"><a href="mailto: contact@deepspot.com" target=""><img src="img/i_mail01.gif" title="" border=0></a></td>
            <td width="10"><a href="siteMap.jsp" target="Main"><img src="img/i_site01.gif" title="" border=0></a></td>
            <td width="10"><a href="javascript:window.external.addfavorite('http://fox/site','deepspot');" target=""><img src="img/i_favorite01.gif" title="" border=0></a></td>
            
          </tr>
        </table>
      </td>
    </tr></table>
  </body>
</html>