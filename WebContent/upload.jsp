<%@ page contentType="text/html;charset=utf-8" errorPage="" pageEncoding="utf-8" %>
<%@ page import="java.util.*,java.lang.StringBuffer,deepspot.main.*,deepspot.util.*,deepspot.basic.*,java.io.*" %>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean"/>
<jsp:useBean id="dbUtil" scope="session" class="deepspot.basic.DbUtil"/>
<%String save = request.getParameter("save");
  if(save==null) save="";
  
  String fileName = request.getParameter("fileName");
  if(fileName==null) fileName="";
  
  String origFileName = fileName;
  String saveFileName = fileName;

  String archive = request.getParameter("archive");
  if(archive==null) archive="";
  
  String obj_id = request.getParameter("obj_id");
  if(obj_id==null) obj_id="";
 
  
  String detail = request.getParameter("detail");
  if(detail==null) detail="";
  
  String descriptionField = request.getParameter("descriptionField");
  if(descriptionField==null) descriptionField="";
  
  boolean showPhoto = false;
  
  if(save.equals("true")){
%>
  
  <%boolean breakFlag = false;
    int bufsize=1024*10;
    int count,k;
    String boundary=null,str=null,filename=null;
    String lowerStr=null,ctype=null,descriptionText=null;;
    byte[] b=new byte[bufsize];
    ServletInputStream in = request.getInputStream();
    
    ByteArrayOutputStream byteout=new ByteArrayOutputStream();
    ServletContext context=getServletConfig().getServletContext();
    int ss=-1,se=-1;
    try {
      while((count=in.readLine(b,0,bufsize))!=-1){
        if((k=request.getContentType().indexOf("boundary"))>=0){
          boundary=request.getContentType().substring(k+9);
          str=new String(b,0,count-2,"utf-8");
          lowerStr=str.toLowerCase();
          ss=lowerStr.indexOf("filename=");
          if(ss>=0){
            se=lowerStr.indexOf("\"",ss+10);
            if(se>=0){
              filename=str.substring(ss+10,se);
              descriptionText = filename.substring(0,filename.lastIndexOf("."));
              origFileName = filename;
              String subName = filename.substring(filename.lastIndexOf(".")+1);
              if(subName.trim().length()>=3){
            	  if(subName.trim().length()>3){
            		  if(subName.equals("jasper")) {
            			  subName = "jasper";
            		  }
            		  else if(subName.equals("html")) {
            			  subName = "html";
            		  }
            	      else if(subName.substring(subName.length()-1).toLowerCase().equals("x")){
            			  subName = subName.substring(subName.length()-4);
            		  } else {
            			  subName = subName.substring(subName.length()-3);
            		  }
            	  }
                  filename = Util.getNo("UL"+Util.getDayOfYear(),3) + "." + subName;
                  //filename = new String(filename.getBytes("8859_1"),"utf-8");
              } else {
                breakFlag = true;
                break;
              }
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
                
                saveFileName = archive + "/" + filename;
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
      
      dbUtil.executeUpdate("insert into uploadfile values('" + saveFileName + "', '" + origFileName + "');");
    } catch(IOException e) {
      e.printStackTrace();
    }%>
<%String filePath = archive + "/" +filename;
  if(breakFlag) {
    filePath="";
  }%>

  <script>
    window.opener.document.getElementById('<%=obj_id%>').value = "<%=filePath%>";
    <%if(!Util.isEmpty(descriptionField)){ %>
    
	    if(window.opener.document.getElementById('<%=descriptionField%>').value == null || window.opener.document.getElementById('<%=descriptionField%>').value == ''){
		    window.opener.document.getElementById('<%=descriptionField%>').value = "<%=descriptionText%>";
	    }
	<%}%>
    window.close();
  </script>

<%} else {%>

<html>
  <head>
    <title>Upload</title>
  </head>
  <body>
  <%String parameters = "";
    if(archive!=null) parameters = "&archive=" + archive;
    if(obj_id!=null) parameters += "&obj_id=" + obj_id;
    if(detail!=null) parameters += "&detail=" + detail;
    if(descriptionField!=null) parameters += "&descriptionField=" + descriptionField;%>
    <form id="upload" name="upload" action="upload.jsp?save=true<%=parameters%>" enctype="multipart/form-data" method="post">
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