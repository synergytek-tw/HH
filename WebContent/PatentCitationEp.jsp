<%@ include file="include/jspHeader.include" %>
<jsp:useBean id="thisObj" scope="page" class="deepspot.main.PatentCitationEp"/>
<jsp:setProperty name="thisObj" property="*"/>
<%/* ========== include/propertiesAccess.include ========== */%> 

<%
/* ========== doSearchFlag prorerty access ========== */
  String doSearchFlag = null;
  if(request.getMethod().equals("GET")){
    doSearchFlag = request.getParameter("_doSearchFlag");
  }
  if(doSearchFlag==null){
    doSearchFlag=thisObj.getDoSearchFlag();
  }

/* ========== orderSequence prorerty access ========== */
  String orderSequence = null;
  if(request.getMethod().equals("GET")){
    orderSequence = request.getParameter("_orderSequence");
  }
  if(orderSequence==null){
    orderSequence=thisObj.getOrderSequence();
  }
  if(orderSequence.trim().length()==0){
    orderSequence=userInfo.getAction("PatentCitationEp"+"OrderSequence");
  }
  if(orderSequence==null){
    orderSequence=Cnstnts.DESC;
  }
  thisObj.setOrderSequence(orderSequence);
  userInfo.setAction("PatentCitationEp"+"OrderSequence",orderSequence);
  
/* ========== orderKey prorerty access ========== */
  String orderKey = null;
  if(request.getMethod().equals("GET")){
    orderKey = request.getParameter("_orderKey");
  }
  if(orderKey==null){
    orderKey=thisObj.getOrderKey();
  }
  if(orderKey.trim().length()==0){
    orderKey=userInfo.getAction("PatentCitationEp"+"OrderKey");
  }
  if(orderKey==null){
    orderKey="flowKey";
  }
  thisObj.setOrderKey(orderKey);
  userInfo.setAction("PatentCitationEp"+"OrderKey",orderKey);
  
/* ========== dbActionMode prorerty access ========== */
  String dbActionMode = null;
  if(request.getMethod().equals("GET")){
    dbActionMode = request.getParameter("_dbActionMode");
  }
  if(dbActionMode==null){
    dbActionMode=thisObj.getDbActionMode();
  }
  if(dbActionMode.trim().length()==0){
    dbActionMode=userInfo.getAction("PatentCitationEp");
  }
  if(dbActionMode==null){
    dbActionMode=Cnstnts.QUERY;
  }
  thisObj.setDbActionMode(dbActionMode);
  if(!dbActionMode.equals("sign") && !dbActionMode.equals("close") && !dbActionMode.equals("ending")){
    userInfo.setAction("PatentCitationEp",dbActionMode);
  }
  
  /* ========== pageActionMode prorerty access ========== */
  String pageActionMode = null;
  if(request.getMethod().equals("GET")){
    pageActionMode = request.getParameter("_pageActionMode");
  }
  if(pageActionMode==null){
    pageActionMode=thisObj.getPageActionMode();
  }
  if(pageActionMode.trim().length()==0){
    pageActionMode=userInfo.getAction("PatentCitationEp"+Cnstnts.PAGE_ACTION_MODE);
  }
  if(pageActionMode==null){
    pageActionMode=Cnstnts.SEARCH;
  }
  thisObj.setPageActionMode(pageActionMode);
  userInfo.setAction("PatentCitationEp"+Cnstnts.PAGE_ACTION_MODE,pageActionMode);
 
  
  /* ========== getDataFlag ========== */
  String getDataFlag = null;
  if(request.getMethod().equals("GET")){
    getDataFlag = request.getParameter("_getDataFlag");
  }
  if(getDataFlag==null){
    getDataFlag=thisObj.getGetDataFlag();
  } else {
    thisObj.setGetDataFlag(getDataFlag);
  }
  
  /* ========== modeLockFlag ========== */
  String modeLockFlag = null;
  if(request.getMethod().equals("GET")){
    modeLockFlag = request.getParameter("_modeLockFlag");
  }
  if(modeLockFlag==null){
    modeLockFlag=thisObj.getModeLockFlag();
  } else {
    thisObj.setModeLockFlag(modeLockFlag);
  }

  /* ========== tagId ========== */
  String tagId = null;
  if(request.getMethod().equals("GET")){
    tagId = request.getParameter("_tagId");
  }
  if(tagId==null){
    tagId=thisObj.getTagId(); 
    modeLockFlag=tagId;
  } else {
    thisObj.setTagId(tagId);
  }
   
  /* ========== clearflag ========== */
  String clear = null;
  if(request.getMethod().equals("GET")){
    clear = request.getParameter("_clearFlag");
  }
  if(clear!=null){
    thisObj.setClearFlag(clear);
  }
   
  /* ========== flowKey ========== */
  String flowKey = null;
  if(request.getMethod().equals("GET")){
    flowKey = request.getParameter("_flowKey");
  }
  if(flowKey==null){
    flowKey=thisObj.getFlowKey();
  } else {
    thisObj.setFlowKey(flowKey);
  }
  
  if(thisObj.onBtnDeleteDetail()){
    String[] deleteItems = request.getParameterValues("delete");
    if(deleteItems!=null) {
      thisObj.setDeleteItems(deleteItems);
    }
  }
  thisObj.doAction(userInfo);
  userInfo.setObj("PatentCitationEp",thisObj);
%>
<%=thisObj.printMessage()%>
<%=thisObj.printErrorMessage()%>
<%=thisObj.printHtml()%>
  
<%/* ========== include/propertiesAccess.include ========== */%>

<%if("true".equals(userInfo.getAttribute("PatentCitationEpCloseFrame"))){
    userInfo.setAttribute("PatentCitationEpCloseFrame","false");%>
    <script>
      parent.resetFrame('PatentCitationEp');
    </script>
<%}%>