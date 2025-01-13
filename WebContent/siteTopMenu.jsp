<%@ include file="includePage/pageHeader.frameset" %>

<html>
  <body bgcolor="#D7FDD0">
    <table style="POSITION: absolute; TOP: 0; LEFT: 2; FONT-SIZE: 14px;"
           border="0" cellpadding="1" cellspacing="1" bgcolor="#D7D7D7">
      <tr>
  <%Iterator itr = new SiteMenu().getDisplayList("TopMenu");
    while(itr.hasNext()){
      SiteMenu obj = (SiteMenu)itr.next();
      String url = obj.getPageUrl();
      String target = obj.getTarget();
      String bgcolor = obj.getBgcolor();
      String color = obj.getColor();
      String showPhoto = obj.getShowPhoto();
      String photoUrl = obj.getPhotoUrl();%>
        <td bgcolor='<%=bgcolor%>' width="100" align='center' style="FONT-Color: <%=color%>;"    
            onMouseOver='this.style.backgroundColor="#FFFF88";this.style.fontSize="18px"' 
            onMouseOut='this.style.backgroundColor="<%=bgcolor%>";this.style.fontSize="14px"'>
          <a href="<%=url%>" target="<%=target%>"><%=obj.getSubject()%></a>
        </td>
  <%}%>
      </tr>
    </table>
  </body>
</html>