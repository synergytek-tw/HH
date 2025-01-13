<%String leftPage = request.getParameter("left");
  if(leftPage==null) leftPage="";
  String rightPage = request.getParameter("right");
  if(rightPage==null) rightPage="";%>
<html>
  <head>
  <meta http-equiv="X-UA-Compatible" content="IE=7">
    <title>MyFavorPage</title>
    <%@ include file="includePage/css.include" %>
    <%@ include file="includePage/js.include" %>
  </head>

  <frameset cols="*,200" border="0">
     <frame src="<%=leftPage%>" name="main_left" frameborder="0">
     <frame src="<%=rightPage%>" name="main_right" frameborder="0">
  </frameset>

  <noframes>
     Your browser does not support frames.
  </noframes>
</html>