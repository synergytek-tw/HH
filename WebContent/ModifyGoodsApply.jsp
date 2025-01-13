<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.ModifyGoodsApply"/>
<jsp:setProperty name="thisObj" property="*"/>
<%
/* ========== getGoodsApplyFlag ========== */
  String goodsApplyFlag = null;
  if(request.getMethod().equals("GET")){
    goodsApplyFlag = request.getParameter("_goodsApplyFlag");
  }
  if(goodsApplyFlag==null){
    goodsApplyFlag=thisObj.getGoodsApplyFlag();
  } else {
    thisObj.setGoodsApplyFlag(goodsApplyFlag);
  }
%>
<%@ include file="include/jspHtml.include"%>