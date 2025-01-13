<% /* include.pageHeader.frameset */%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="deepspot.main.*,deepspot.util.*" %>
<%request.setCharacterEncoding("utf-8"); 
  String background="bgcolor='#FFFFFF'";%>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean"/>
<% /* include.pageHeader.frameset */%>
<html>
  <head>
    <%@ include file="includePage/css.include" %>
  </head>
  <body <%=background%>>
    <table  style="POSITION: absolute; TOP: -10; LEFT: 0; FONT-SIZE: 14px; color: #000000;"
            class="copyright" cellpadding="0" cellspacing="0" border="0" <%=background%> align="center">
      <tr <%=background%>>
        <td align="center" <%=background%>>
          <%=userInfo.getMsg("jsp.copyright")%>&copy;<%=userInfo.getMsg("jsp.copyright.1")%>
          <a target="_blank" style="text-decoration:none;" href="<%=userInfo.getMsg("jsp.copyright.link")%>"><%=userInfo.getMsg("jsp.copyright.3")%></a><%=userInfo.getMsg("jsp.copyright.4")%>
        </td>
      </tr>
      <tr <%=background%>>
        <td align="center" <%=background%>>
          <%=userInfo.getMsg("jsp.copyright.2")%>
        </td>
      </tr>
    </table>
  </body>
</html>
<script event="oncontextmenu" for="document">
  event.returnValue = false;
</script>