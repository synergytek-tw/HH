package deepspot.daemon;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import deepspot.basic.DbUtil;
import deepspot.main.Category;
import deepspot.main.PatentCase;
import deepspot.main.TrademarkCase;
import deepspot.util.Config;
import deepspot.util.Util;

public class DownloadFile2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filePath = request.getParameter("outputFile");
		if(filePath.startsWith("up/")) {
			filePath = java.net.URLDecoder.decode(filePath, "UTF-8");
		}
		String caseType = request.getParameter("type");
		String key = request.getParameter("key");
		
		System.out.println("filePath=" + filePath);
		System.out.println("type=" + caseType);
		System.out.println("key=" + key);
		
		if(!Util.isEmpty(filePath)) {
				
			ServletOutputStream op = response.getOutputStream();
			String mimetype = Config.ctx.getMimeType(filePath);
	
			File f = new File(Util.getTomcatPath() + filePath);
			
			String fileName = f.getName();
			
			String extension = "";

			int i = fileName.lastIndexOf('.');
			int j = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

			if (i > j) {
			    extension = fileName.substring(i+1);
			}
			
			if(!Util.isEmpty(caseType) && !Util.isEmpty(key)){
				Properties categoryProp = null;
				try {
					categoryProp = new Category().getNamesPrpts();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String nowDate = Util.getDate().replaceAll("-", "");
				
				if(caseType.equals("p")){
					PatentCase p = new PatentCase(key);
					String title =  p.getTitle();
					String office = p.getPatentOffice();
					String type = p.getPatentType();
					if(categoryProp != null){
						office = categoryProp.getProperty(office);
						type = categoryProp.getProperty(type);
					}
					
					if(title.length() > 50){
						title = title.substring(0, 50) + "¡P¡P¡P";
					}
					fileName = title + "_" + office + "-" + type + "_" + nowDate;
					fileName = fileName.replaceAll("<", "").replaceAll(">", "").replaceAll(":", "").replaceAll("\"", "").replaceAll("/", "").replaceAll("\\\\", "").replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "").replaceAll("|", "").replaceAll("\\?", "").replaceAll("\\*", "");
					fileName = fileName + "." + extension;
				}else if(caseType.equals("t")){
					TrademarkCase t = new TrademarkCase(key);
					String title =  t.getTitle();
					String office = t.getOffice();
					String type = t.getTrademarkClassification();
					
					if(title.length() > 50){
						title = title.substring(0, 50) + "¡P¡P¡P";
					}
					fileName = title + "_" + office + "-" + type + "_" + nowDate;
					fileName = fileName.replaceAll("<", "").replaceAll(">", "").replaceAll(":", "").replaceAll("\"", "").replaceAll("/", "").replaceAll("\\\\", "").replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "").replaceAll("|", "").replaceAll("\\?", "").replaceAll("\\*", "");
					fileName = fileName + "." + extension;
				}
				
			}
			
	
			String userAgent = request.getHeader("user-agent");
			boolean isInternetExplorer = (userAgent.indexOf("MSIE") > -1);
			try {
			    byte[] fileNameBytes = fileName.getBytes((isInternetExplorer) ? ("windows-1250") : ("utf-8"));
			    String dispositionFileName = "";
			    for (byte b: fileNameBytes) dispositionFileName += (char)(b & 0xff);

			    String disposition = "attachment; filename=\"" + dispositionFileName + "\"";
			    response.setHeader("Content-disposition", disposition);
			} catch(UnsupportedEncodingException ence) {
			    // 
			}
	
			//
			// Stream to the requester.
			//
			int length = 0;
			byte[] bbuf = new byte[2048];
			DataInputStream in = new DataInputStream(new FileInputStream(f));
	
			while ((in != null) && ((length = in.read(bbuf)) != -1)) {
				op.write(bbuf, 0, length);
			}
	
			in.close();
			op.flush();
			op.close();
	
//			out.clear();
//			out = pageContext.pushBody();
		}
	}
}
