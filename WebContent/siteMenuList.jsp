<%@ include file="includePage/pageHeader.frameset" %>
<%String parentKey = request.getParameter("pid");
  if(parentKey==null) parentKey="HomePage";
  SiteMenu thisObj = new SiteMenu(parentKey);%>
<html>
  <body bgcolor="#D5FFFF">
    <table style="POSITION: absolute; TOP: 2; LEFT: 2; FONT-SIZE: 14px;"
           width="196" border="0" cellpadding="1" cellspacing="1" bgcolor="#D7D7D7">
      <tr><th height="30"><%=thisObj.getSubject()%></th></tr>
  <%Iterator itr = thisObj.getTreeList(parentKey);
    int i=0,layer=0;
    String bgcolor;
    while(itr.hasNext()){
      i++;
      if(i%2==0) bgcolor = "#F7F7F7";
      else bgcolor = "#FFFFFF"; 
      SiteMenu obj = (SiteMenu)itr.next();
      String url = obj.getPageUrl();
      String target = obj.getTarget();
      /*
      String bgcolor = obj.getBgcolor();
      String color = obj.getColor();
      String showPhoto = obj.getShowPhoto();
      String photoUrl = obj.getPhotoUrl();
      */
      String preChart = "";
      for(int j=1;j<obj.getLayer();j++){
        preChart+="&nbsp;&nbsp;&nbsp;&nbsp;";
      }%>
      <tr bgcolor='<%=bgcolor%>' onMouseOver='this.style.backgroundColor="lightyellow"'
                                 onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
        <td height="28"
            onMouseOver='this.style.backgroundColor="#FFFF88"' 
            onMouseOut='this.style.backgroundColor="<%=bgcolor%>"'>
          <%=preChart%><a href="<%=url%>" target="<%=target%>" onMouseOver='this.style.fontSize="18px"' 
                          onMouseOut='this.style.fontSize="14px"'><%=obj.getSubject()%></a>
        </td>
      </tr>
  <%}%>
    </table>
  </body>
</html>