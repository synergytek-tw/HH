<%@ include file="includePage/pageHeader.frameset" %>
<%String language = request.getParameter("language");
  if(language!=null) 
    userInfo.setAttribute("siteLanguage",language);
  else
    userInfo.setAttribute("siteLanguage","chinese");
  
  String rows = "",
         keyValue1 = "site.jsp.frameset.",
         keyValue2 = ".src";
  String[] frameset = {"Logo","TopMenu","Main","BottomMenu","CopyRight"};
  boolean[] showFrame = {false,false,false,false,false};
  String[] srcPage = {"","","","",""};
  String[] framesetSrc = {keyValue1+frameset[0]+keyValue2,
                          keyValue1+frameset[1]+keyValue2,
                          keyValue1+frameset[2]+keyValue2,
                          keyValue1+frameset[3]+keyValue2,
                          keyValue1+frameset[4]+keyValue2};
  for(int i=0;i<framesetSrc.length;i++){
    System.out.println(framesetSrc[i]);
    String[] data = userInfo.getInfoValue(framesetSrc[i]).split(",");
    if(data.length>1){
      showFrame[i]=true;
      srcPage[i]=data[0];
      if(rows.equals("")) rows = data[1];
      else rows += ","+data[1];
    }
  }%>
<html>
<head>
  <title><%=userInfo.getInfoValue("site.jsp.title")%></title>
<%@ include file="includePage/css.include" %>
<%@ include file="includePage/js.include" %>
</head>

<frameset rows="<%=rows%>" frameborder="0">
<%for(int i=0;i<frameset.length;i++){
    if(showFrame[i]){%>
  <frame src="<%=srcPage[i]%>" name="<%=frameset[i]%>" frameborder="0" noresize <%if(!frameset[i].equals("Main")){%>scrolling="no"<%}%>>
  <%}
  }%>
</frameset>

<noframes>
     Your browser does not support frames.
</noframes>
</html>