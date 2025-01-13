<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.Expendable"/>
<jsp:setProperty name="thisObj" property="*"/>
<%String goodsApplyFlag = null;
  if(request.getMethod().equals("GET")){
    goodsApplyFlag = request.getParameter("_goodsApplyFlag");
  }
  if(goodsApplyFlag==null){
    goodsApplyFlag=thisObj.getGoodsApplyFlag();
  }
  thisObj.setGoodsApplyFlag(goodsApplyFlag);%>
<%@ include file="include/jspHtml.include"%>