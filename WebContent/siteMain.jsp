<%@ include file="includePage/pageHeader.frameset" %>
<%String leftPage = request.getParameter("left");
  if(leftPage==null) leftPage=userInfo.getInfoValue("siteMain.jsp.leftFrame.src.default");
  if(leftPage==null) leftPage="";
  
  String rightPage = request.getParameter("right");
  if(rightPage==null) rightPage=userInfo.getInfoValue("siteMain.jsp.rightFrame.src.default");
  if(rightPage==null) rightPage="";
  
  String parentKey = request.getParameter("pid");
  if(parentKey!=null) leftPage+="?pid="+parentKey;%>
<html>
  <head></head>

  <frameset cols="200,*" border="0">
     <frame src="<%=leftPage%>" name="Main_left" frameborder="0">
     <frame src="<%=rightPage%>" name="Main_right" frameborder="0">
  </frameset>

  <noframes>
     Your browser does not support frames.
  </noframes>
</html>