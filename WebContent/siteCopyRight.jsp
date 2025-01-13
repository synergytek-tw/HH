<%@ include file="includePage/pageHeader.frameset" %> 
<%String color=userInfo.getInfoValue("siteLogo.jsp.color"),
         bgcolor=userInfo.getInfoValue("siteLogo.jsp.bgcolor"),
         background=userInfo.getInfoValue("siteLogo.jsp.background"),
         font_family=userInfo.getInfoValue("siteLogo.jsp.font_family");%>
<html>
  <head>
</head>
  <body <%=bgcolor%>>
      <table 
style="POSITION: absolute; TOP: 4; FONT-SIZE: 16px;"
           cellpadding="0" cellspacing="0" border="0" align="center">
        <tr>
          <td align="center" style="Color: <%=color%>;" >
            <%=userInfo.getMsg("jsp.copyright")%>&copy;<%=userInfo.getMsg("jsp.copyright.1")%>
          </td>
        </tr>
      </table>
 
  </body>
</html>