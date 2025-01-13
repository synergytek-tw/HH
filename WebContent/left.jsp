<%@ include file="includePage/pageHeader.jsp" %>

<%String DeptName = userInfo.getAttribute("DeptName");
  String jobName = userInfo.getAttribute("jobName");
  String background = "background='img/logo_background.gif'";  
  if(DeptName!=null && jobName!=null){%>
<html>
  <head>
    <%@ include file="includePage/css.include" %> 
    <%@ include file="includePage/js.include" %>
  </head>
  <body>
  <!--
  <table width="180">
  	<tr>
    	<%String style="style=\"font-size:16px;color:#663300;text-align:center;letter-spacing:normal;\"";%>
    	<td <%=background%>>
    		<a href="main.jsp?left=menu.jsp&right=MenuInfo.jsp" target="main" <%=style%>><b>[<%=userInfo.getMsg("jsp.menu.home")%>]</b></a>
            <a href="main.jsp?left=calendar.jsp&right=MyFavorMenu.jsp" target="main" <%=style%>><b>[<%=userInfo.getMsg("jsp.MyFavor.title")%>]</b></a>
        </td>      
    </tr>
  </table><br>
  -->
  <table width="180">
  <%
    Iterator menu;
    menu = userInfo.getMenuList().iterator(); 
  %>
 
    <tr>
      <td>        
        <script>
 		  var open = false;
          <%while(menu.hasNext()) {
              String script = (String)menu.next();%>
              <%=script%>
          <%}%>
		  <%Account acc = new Account(userInfo.getAttribute("user_id"));
		  if(acc.getOpenMenu().equals("Y")){%>
         		 d.openAll();
      			 open = true;
		  <%} else {%>
   		  		d.closeAll();
   		  <%}%>
		  
          function listButton(){
			if(open){
				d.closeAll();
				open = false;
			}else{
				d.openAll();
				open = true;
			}		
          }
        </script>
      </td> 
    </tr>   
  </table>
<%}%>
  </body>
</html>
