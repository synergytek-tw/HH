<%@ page contentType="text/html;charset=utf-8" errorPage="" pageEncoding="utf-8" %>
<%@ page import="java.util.*,java.io.File,java.lang.StringBuffer,deepspot.main.*,deepspot.util.*,deepspot.basic.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean" />
<%
  String tagMode=request.getParameter("tagMode");
  String dataValue=request.getParameter("dataValue");
  String className=request.getParameter("clsName");
  String otherValue=request.getParameter("otherValue");
  if(otherValue==null) otherValue="";
  Ajax obj = new Ajax(userInfo,className);
  String responseData=obj.onAjaxRequest(dataValue,otherValue,tagMode).trim();
%>
<%=responseData%>