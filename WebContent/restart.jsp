<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*" %>
<%!
  public static void reboot(String batchPath) throws Exception {
    Runtime r = Runtime.getRuntime();
    System.out.println("reboot Tomcat : " + batchPath);
    r.exec("cmd /k " + batchPath);
  }
%>
<%String batchPath = request.getParameter("batchPath");
  if(batchPath==null) 
    batchPath = "D:/Tomcat5/webapps/newCase/WEB-INF/restart.bat";
  
  String runClass = request.getParameter("runClass");
  try {
    if(runClass!=null && runClass.equals("true")){
      reboot(batchPath);
    }
  } catch (Exception e) {}%>
  
<form id="input" name="input" action="restart.jsp?runClass=true" method="post">
  <input type="submit" value="Restar Tomcat Now!!!" />
</form>
