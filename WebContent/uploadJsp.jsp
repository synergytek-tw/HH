<%@ page contentType="text/html;charset=utf-8" errorPage="" pageEncoding="utf-8" %>
<%@ page import="java.util.*,deepspot.main.*,deepspot.util.*,com.deepspot.pdf.*,java.lang.StringBuffer,java.io.*,java.util.zip.*,javax.servlet.*,javax.servlet.http.*" %>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean"/>
<%String save = request.getParameter("save");
  String fileName = request.getParameter("fileName");
  String archive = request.getParameter("archive");
  if(archive==null) archive=".";
  boolean showPhoto = false;
  if(save==null) save = "";
  if(save.equals("true")){
    int bufsize=1024*10;
    int count,k;
    String boundary=null,str=null,filename=null;
    String lowerStr=null,ctype=null;
    byte[] b=new byte[bufsize];
    ServletInputStream in = request.getInputStream();
    
    ByteArrayOutputStream byteout=new ByteArrayOutputStream();
    ServletContext context=getServletConfig().getServletContext();
    int ss=-1,se=-1;
    try {
      while((count=in.readLine(b,0,bufsize))!=-1){
        if((k=request.getContentType().indexOf("boundary"))>=0){
          boundary=request.getContentType().substring(k+9);
          str=new String(b,0,count-2);
          lowerStr=str.toLowerCase();
          ss=lowerStr.indexOf("filename=");
          if(ss>=0){
            se=lowerStr.indexOf("\"",ss+10);
            if(se>=0){
              filename=str.substring(ss+10,se);
              if(fileName!=null){
                String subName = filename.substring(filename.lastIndexOf(".")+1);
                if(!subName.equals("")){
                  filename = fileName + "." + subName;
                } else { 
                  filename="";
                }
              } else {
                filename=filename.substring(filename.lastIndexOf("\\")+1);
              }
              filename=new String(filename.getBytes("8859_1"),"utf-8");
              count=in.readLine(b,0,bufsize);
              str=new String(b,0,count-2);
              lowerStr=str.toLowerCase();
              if((ss=lowerStr.indexOf("content-type"))>=0){
                ctype=str.substring(ss+14);
                count=in.readLine(b,0,4096);
                while((count=in.readLine(b,0,bufsize))!=-1){
                  byteout.write(b,0,count);
                }
                byte[] data=byteout.toByteArray();
                count=("--"+boundary+"--").length()+4;
                if(archive==null || archive.equals("")){
                  archive = "Photo";
                }
                File fileDir = new File(Util.getTomcatPath()+archive+"/");
                if(!fileDir.exists()) fileDir.mkdirs();
                
                fileName = Util.getTomcatPath() + archive + "/" + filename;
                
                File outFile = new File(fileName);
                if(outFile.exists()) outFile.delete();
                while(outFile.exists()){}
                
                FileOutputStream fos=new FileOutputStream(fileName);
                fos.write(data,0,data.length-count);
                fos.close();
                
                while(!outFile.exists()){showPhoto=false;}
                if(outFile.exists()){showPhoto = true;}
              }
            }
          }
        }
      }
      in.close();
      byteout.close();
    } catch(IOException e) {
      e.printStackTrace();
    }%>
<%String filePath = archive + "/" +filename;%>

<%if(showPhoto){%>
  <input type="button" value="<%=filePath%>" onClick="showFile('<%=filePath%>')"/>
  <script>
    function showFile(filePath){
       window.open(filePath,'Upload','scrollbars=yes,resizable');
    }
  </script>
<%}%>

<%} else {%>

<html>
  <head>
    <title>Upload</title>
  </head>
  <body>
  <%String parameters = "";
    if(archive!=null) parameters = "&archive=" + archive;
    if(fileName!=null) parameters += "&fileName=" + fileName;%>
    <form id="upload" name="upload" action="uploadJsp.jsp?save=true<%=parameters%>" enctype="multipart/form-data" method="post">
    <center>
    <table>
      <tr>
        <td align="center"><%=userInfo.getMsg("jsp.common.fileName")%>
          <input type="file" id="fileName" name="fileName" size="50"/>
        </td>
      </tr>
      <tr>
        <td align="center">
          <input type="button" value="<%=userInfo.getMsg("jsp.login.cancel")%>"
                 onClick="window.close()"/>
          <input type="submit" value="<%=userInfo.getMsg("jsp.common.upload")%>"/>
        </td>
      </tr>
    </table>
    </center>
    </form>
  </body>
</html>

<%}%>