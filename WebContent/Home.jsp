<html>
  <head>
    <title>Home Page</title>
    <%@ include file="includePage/css.include" %>
    <%@ include file="includePage/js.include" %>
  </head>
  <frameset rows="21,*,20" frameborder="0">
   <frame src="logo.jsp" name="logo" frameborder="0" scrolling="no" noresize>
   <frameset id="frameset1" cols="200,*" border="0">
   	 <frameset rows="70,*" border="0">
		<frame src="logoicon.jsp" name="logoicon" frameborder="0" scrolling="no" noresize>
   	 	<frame src="left.jsp" name="left" frameborder="0">	
   	 </frameset>
     <frame src="main.jsp?left=menu.jsp&right=MenuInfo.jsp" name="main" frameborder="0">
   </frameset>
   <frame src="copyright.jsp" name="copyright" frameborder="0" scrolling="no" noresize>
  </frameset>
  <noframes>
     Your browser does not support frames.
  </noframes>
</html>