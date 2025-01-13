<%String leftPage = request.getParameter("left");
  if(leftPage==null) leftPage="";
  String rightPage = request.getParameter("right");
  if(rightPage==null) rightPage="";%>
<html>
  <head></head>

  <frameset cols="*,180" border="0">
     <frame src="<%=leftPage%>" name="Main_left_left" frameborder="0">
     <frame src="<%=rightPage%>" name="Main_left_right" frameborder="0">
  </frameset>

  <noframes>
     Your browser does not support frames.
  </noframes>
</html>