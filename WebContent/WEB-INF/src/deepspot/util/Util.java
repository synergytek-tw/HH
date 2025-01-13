package deepspot.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;

import org.dom4j.Element;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.SelectItem;
import deepspot.main.Employee;
import deepspot.main.Department;
import deepspot.main.Program;
import deepspot.main.UserBean;


import com.athenasoft.ooutil.OoConverter;

public class Util{
	private static Calendar calendar = new GregorianCalendar();
	private static int year,month,day,hh,mm,ss;
	//private static String tomcatPath = "webapps/site/";
	//private static String tomcatPath = "/usr/local/tomcat5/webapps/site/";//for Linux use
	private static String tomcatPath = Config.ctx.getRealPath("/").replaceAll("\\\\","/");
	private static String pdfPath = tomcatPath + "pdf/";
	private static String csvPath = tomcatPath + "csv/";
	private static String docPath = tomcatPath + "doc/";
	private static String xmlPath = tomcatPath + "WEB-INF/xmlschema/";
	private static String msgXmlPath = xmlPath + "message.xml";
	private static String siteInfoPath = xmlPath + "siteInfo.xml";
	private static String flowXmlPath = xmlPath + "flowInfo.xml";
	private static String dataBaseXml = xmlPath + "dbInfo.xml";
	private static String defaultConnectChar = "-";
  
	public static String getTomcatPath() {
		return tomcatPath;
	}
  
	public static String getMsgXmlPath() {
		return msgXmlPath;
	}
  
	public static String getSiteInfoPath() {
		return siteInfoPath;
	}
  
	public static String getFlowXmlPath() {
		return flowXmlPath;
	}
  
	public static String getDataBaseXml() {
	    return dataBaseXml;
	}
  
	public static String getPdfPath() {
		return pdfPath;
	}
  
	public static String getCsvPath() {
		return csvPath;
	}
	
	public static String getDocPath() {
		return docPath;
	}
  
	public static HashMap<String, Object> makePdfCell(String Text, String ImgPath, int Size, int Colspan, 
                                                                 int Rowspan, int Location) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("Text",Text);
		hm.put("Image",ImgPath);
		hm.put("Size",new Integer(Size));
		hm.put("Colspan",new Integer(Colspan));
		hm.put("Rowspan",new Integer(Rowspan));
		hm.put("Location",new Integer(Location));
		return hm;
	}
  
	public static HashMap<String, Object> makePdfTable(int Columns, int Border, float Width, 
                                     int Padding, int Spacing, Iterator<?> TableData) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("Columns",new Integer(Columns));
		hm.put("Border",new Float(Border));
		hm.put("Width",new Float(Width));
		hm.put("Padding",new Integer(Padding));
		hm.put("Spacing",new Integer(Spacing));
		hm.put("TableData",TableData);
		return hm;
	}
  
	public static HashMap<String, Object> makePdfText(String Text, String ImgPath, int Size, int Location) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("Text",Text);
		hm.put("Image",ImgPath);
		hm.put("Size",new Integer(Size));
		hm.put("Location",new Integer(Location));
		return hm;
	}
  
	public static HashMap<String, Object> makePdfData(Iterator<?> DocHeader, HashMap<?, ?> DocTable, Iterator<?> DocFooter) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("DocHeader",DocHeader);
		hm.put("DocTable",DocTable);
		hm.put("DocFooter",DocFooter);
		return hm;
	}
  
	public static HashMap<String, Object> makePdfDoc(String Title, String Subject, String Author, 
                                   String Header, String ImgPath, String FilePath, Iterator<?> Data) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("Title",Title);
		hm.put("Subject",Subject);
		hm.put("Author",Author);
		hm.put("Header",Header);
		hm.put("Image",ImgPath);
		hm.put("FilePath",FilePath);
		hm.put("Data",Data);
		return hm;
	}
  
	public static String getYear() {
		calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		return n2s(year,4);
	}
  
	public static String getYear(int i) {
		calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		return n2s(year+i,4);
	}
  
	public static String getMonth() {
		calendar = new GregorianCalendar();
		month = calendar.get(Calendar.MONTH)+1;    
		return n2s(month,2);
	}
  
	public static String getDay() {    
		calendar = new GregorianCalendar();
		day = calendar.get(Calendar.DATE);
		return n2s(day,2);
	}
  
	public static String getDate() {
		calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);    
		return n2s(year,4) + defaultConnectChar + n2s(month,2) + defaultConnectChar + n2s(day,2);
	}
	
	public static String getDate(int i) {
		calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);
		int lastday = calendar.getActualMaximum(Calendar.DATE);
		int n = day - i;
		if(n<=0){
			month-=1;
			if(month==0){
				month=12;
				year-=1;
			}
			Calendar cal = new GregorianCalendar(year,month-1,1);
			int dd = cal.getActualMaximum(Calendar.DATE);
			day = dd + n;
		} else {
			if(n>lastday){
				month+=1;
				if(month>12){
					month=1;
					year+=1;
				}
				day = n - lastday;
			} else {
				day = n;
			}
		}
		return n2s(year,4) + defaultConnectChar + n2s(month,2) + defaultConnectChar + n2s(day,2);
	}
	
	public static String getDate(String refDate,int i) {
		if(refDate.length()<10) return Cnstnts.EMPTY_STRING;
		
		year = Integer.parseInt(refDate.substring(0,4));
		month = Integer.parseInt(refDate.substring(5,7));
		day = Integer.parseInt(refDate.substring(8,10));
		Calendar calendar = new GregorianCalendar(year,month-1,day);
		int lastday = calendar.getActualMaximum(Calendar.DATE);
		int n = day + i;
		if(n>lastday){
			month+=1;
			if(month>12){
				month=1;
				year+=1;
			}
			day = n - lastday;
		} else {
			day = n;
		}
		return n2s(year,4) + defaultConnectChar + n2s(month,2) + defaultConnectChar + n2s(day,2);
	}
  
	public static String getDayOfYear() {
		calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		day = calendar.get(Calendar.DAY_OF_YEAR);    
		return n2s(year,4).substring(2,4) + n2s(day,3);
	}
  
	public static String getDate(String connectChar) {
		calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);    
		return n2s(year,4) + connectChar + n2s(month,2) + connectChar + n2s(day,2);
	}
  
	public static String dayOfWeek(String thisDate) throws Exception {
		if(thisDate==null || thisDate.trim().length()<10){
			return Cnstnts.EMPTY_STRING;
		}
		int yy = Integer.parseInt(thisDate.substring(0,4));
		int mm = Integer.parseInt(thisDate.substring(5,7));
		int dd = Integer.parseInt(thisDate.substring(8,10));
		return dayOfWeek(yy,mm,dd);
	}
  
	public static String dayOfWeek(int yy, int mm, int dd) throws Exception {
		String sun = "7";
		String mon = "1";
		String tue = "2";
		String wed = "3";
		String thr = "4";
		String fri = "5";
		String sat = "6";
		final String[] weekdays = {sun,mon,tue,wed,thr,fri,sat};        
		Calendar cal = new GregorianCalendar(yy,mm-1,dd);
		return weekdays[cal.get(Calendar.DAY_OF_WEEK)-1];
	}
  
	public static String getTime() {    
		calendar = new GregorianCalendar();
		hh = calendar.get(Calendar.HOUR_OF_DAY);
		mm = calendar.get(Calendar.MINUTE);
		return n2s(hh,2) + ":" + n2s(mm,2);
	}
  
	public static String getDateTime() {    
		calendar = new GregorianCalendar();
		hh = calendar.get(Calendar.HOUR_OF_DAY);
		mm = calendar.get(Calendar.MINUTE);
		ss = calendar.get(Calendar.SECOND);
		return getDate() + " " + n2s(hh,2) + ":" + n2s(mm,2) + ":" + n2s(ss,2);
	}
  
	public static String n2s(int in, int len) {
	    String inString = String.valueOf(in);
	    String tmpString = "";
	    for(int i=0; i<len-inString.length(); i++) {
	      tmpString += "0"; 
	    }
	    return tmpString + inString;
 	}
	
	public static String lastNumString(int in, int len) {
	    String inString = String.valueOf(in);
	    if(inString.length()>=len){
	    	return inString;
	    }
	    String zeoString = "";
	    for(int i=0; i<len-inString.length(); i++) {
	    	zeoString += "0"; 
	    }
	    return zeoString + inString;
 	}
  
	public static String firstOfMonth() {
	    calendar = new GregorianCalendar();
	    year = calendar.get(Calendar.YEAR);
	    month = calendar.get(Calendar.MONTH)+1;
	    day = 1;  
	    return n2s(year,4) + defaultConnectChar + n2s(month,2) + defaultConnectChar + n2s(day,2);
	}
  
	public static String lastOfMonth() {
	    calendar = new GregorianCalendar();
	    year = calendar.get(Calendar.YEAR);
	    month = calendar.get(Calendar.MONTH)+1;
	    day = calendar.getActualMaximum(Calendar.DATE);  
	    return n2s(year,4) + defaultConnectChar + n2s(month,2) + defaultConnectChar + n2s(day,2);
	}
  
	public static String firstOfMonth(int yy,int mm) {  
		return n2s(yy,4) + defaultConnectChar + n2s(mm,2) + defaultConnectChar + n2s(1,2);
	}
  
	public static String lastOfMonth(int yy,int mm) {
	    Calendar calendar = new GregorianCalendar(yy,mm-1,1);
	    int dd = calendar.getActualMaximum(Calendar.DATE);  
	    return n2s(yy,4) + defaultConnectChar + n2s(mm,2) + defaultConnectChar + n2s(dd,2);
	}
  
	public static String getMsg(String msgKey, String language) throws Exception {    
	    if(language==null) language="chinese";
	    File msgFile = new File(msgXmlPath);
	    XML msgXml = new XML(msgFile,"unicode");
	    Element msg = msgXml.getElement("users","id",language);
	    String rtnStr = "";
	    try {
	      rtnStr = msg.element(msgKey).attributeValue("value");
	    } catch(Exception e) {
	      rtnStr = "";
	    }
	    return rtnStr;
	}
  
	public static List<SelectItem> getLanguages() throws Exception {
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		File msgFile = new File(msgXmlPath);
		XML msgXml = new XML(msgFile,"unicode");
		for(Iterator<?> itr=msgXml.getElements("users").iterator();itr.hasNext();){
			Element e = (Element)itr.next();
			String language = e.attributeValue("id");
			SelectItem item = new SelectItem(language,language);
			rtnList.add(item);
		}
		return rtnList;
 	}
  
	public static List<SelectItem> getFlows() throws Exception {
	    List<SelectItem> rtnList = new ArrayList<SelectItem>();
	    File flowFile = new File(flowXmlPath);
	    XML flowXml = new XML(flowFile);
	    Iterator<?> flowsItr = flowXml.getElements("flow").iterator();
	    while(flowsItr.hasNext()) {
	    	Element e = (Element)flowsItr.next();
	    	String key = e.attributeValue("id");
	    	String value = key+"-"+e.attributeValue("name");
	    	rtnList.add(new SelectItem(key,value));      
	    }
	    return rtnList;
	}
	
	public static List<SelectItem> getFlowSteps(String flow_id) throws Exception {
	    List<SelectItem> rtnList = new ArrayList<SelectItem>();
	    Element flowInfo = getFlowInfo(flow_id);
	    for(Iterator<?> itr=flowInfo.elementIterator();itr.hasNext();){
	    	Element e = (Element)itr.next();
	    	String key = e.attributeValue("id");
	    	String value = key+"-"+e.attributeValue("desc");
	    	rtnList.add(new SelectItem(key,value));  
	    }
	    return rtnList;
	}
  
	public static XML getFlowXML() throws Exception {
		File xmlFile = new File(flowXmlPath);
		XML flowXML = new XML(xmlFile);
		return flowXML;
	}
  
	public static Element getFlowInfo(String flow_id) throws Exception {
	    File xmlFile = new File(flowXmlPath);
	    XML flowXML = new XML(xmlFile);
	    Element flowInfo = flowXML.getElement("flow","id",flow_id);
	    return flowInfo;
	}

	public static String getNo(String beginWord,int noLength) {   
	    DB db;
	    ResultSet rs;
	    String pkey = beginWord;
	    String selectStr = "select no from pkeyNo where pkey='" + pkey + "'";
	    String sqlStr;
	    int no;
	    try {
	    	db = new DB();
	    	rs = db.executeQuery(selectStr);
	    	if(rs.next()) {
	    		no = rs.getInt("no") + 1;
	    		sqlStr = "update pkeyNo set no=" + no + " where pkey='" + pkey + "'";
	    	} else {
	    		no = 1;
	    		sqlStr = "insert into pkeyNo(pkey,no) values('" + pkey + "',1)";
	    	}
	    	rs.close();
	    	db.executeUpdate(sqlStr);
	    	db.close();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    } finally {
	    	rs = null;
	    	db = null;
	    }
	    return pkey + "." + lastNumString(no,noLength);
	}
	
	public static String getAutoNo(String programId) {   
	    DB db;
	    ResultSet rs;
	    Program program = new Program(programId);
	    String pkey = program.getBeginWord()+Util.getDate().replaceAll("-", Cnstnts.EMPTY_STRING);
	    String selectStr = "select no from pkeyNo where pkey='" + pkey + "'";
	    String sqlStr;
	    int no;
	    try {
	    	db = new DB();
	    	rs = db.executeQuery(selectStr);
	    	if(rs.next()) {
	    		no = rs.getInt("no") + 1;
	    		sqlStr = "update pkeyNo set no=" + no + " where pkey='" + pkey + "'";
	    	} else {
	    		no = 1;
	    		sqlStr = "insert into pkeyNo(pkey,no) values('" + pkey + "',1)";
	    	}
	    	rs.close();
	    	db.executeUpdate(sqlStr);
	    	db.close();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    } finally {
	    	rs = null;
	    	db = null;
	    }
	    return pkey + "." + lastNumString(no,program.getEndNoLength());
	}
  
	public static String getSeqNo(String beginWord,int noLength) {   
	    DB db;
	    ResultSet rs;
	    String pkey = beginWord;
	    String selectStr = "select no from pkeyNo where pkey='" + pkey + "'";
	    String sqlStr;
	    int no;
	    try {
	    	db = new DB();
	    	rs = db.executeQuery(selectStr);
	    	if(rs.next()) {
	    		no = rs.getInt("no") + 1;
	    		sqlStr = "update pkeyNo set no=" + no + " where pkey='" + pkey + "'";
	    	} else {
	    		no = 1;
	    		sqlStr = "insert into pkeyNo(pkey,no) values('" + pkey + "',1)";
	    	}
	    	rs.close();
	    	db.executeUpdate(sqlStr);
	    	db.close();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    } finally {
	    	rs = null;
	    	db = null;
	    }
	    return n2s(no,noLength);
	 }
  
	public static String getCertificate_no(String applicant,String program_id,int noLength) {   
		Employee emp = new Employee(applicant);
		Department dpt = new Department(emp.Dept_id.getValue());
		String beginWord = dpt.getDept_code()+(Integer.parseInt(Util.getYear())-1911);
		String rtnStr = getNo(beginWord,noLength);
		return rtnStr;
	}
  
	public static String getPdfNo(String fileName) {   
	    DB db;
	    ResultSet rs;
	    String pkey = fileName;
	    String selectStr = "select no from pkeyNo where pkey='" + pkey + "'";
	    String sqlStr;
	    int no;
	    try {
	    	db = new DB();
	    	rs = db.executeQuery(selectStr);
	    	if(rs.next()) {
	    		no = rs.getInt("no") + 1;
	    		if(no>10) no=1;
	    		sqlStr = "update pkeyNo set no=" + no + " where pkey='" + pkey + "'";
	    	} else {
	    		no = 1;
	    		sqlStr = "insert into pkeyNo(pkey,no) values('" + pkey + "',1)";
	    	}
	    	rs.close();
	    	db.executeUpdate(sqlStr);
	    	db.close();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    } finally {
	    	rs = null;
	    	db = null;
	    }
	    return pkey + n2s(no,2);
	}

	public static void writeToFile(File outFile, StringBuffer pageContent) 
                                                throws IOException {
	    FileWriter fileOut = null;
	    try {
	    	fileOut = new FileWriter(outFile);
	    	fileOut.write(pageContent.toString());
	    } 
	    catch (Exception e) {e.printStackTrace();}
	    finally {   
	    	fileOut.close();
	    }
	}
  
	public static String getChar(int inputNumber, int position){
		String numberStr = (inputNumber + "").trim();
		int StringLength = numberStr.length();
		String rtnString = "";
		if(position==StringLength+1) return "$";
		int i = 0;
		for(int j=StringLength; j>0; j--){
				i++;
	      if(i==position){
	    	  rtnString = numberStr.substring(j-1,j);
	    	  break;
	      }
		}
		return rtnString;
	}
  
	public static String number2chinese(long inputNumber) throws Exception{
	    String numberStr = (inputNumber + "").trim();
	    int StringLength = numberStr.length();
	    if(StringLength>18) return numberStr;
	    String n00 = getMsg("Util.number2chinese.n00","chinese");
	    String n0 = getMsg("Util.number2chinese.n0","chinese");
	    String n1 = getMsg("Util.number2chinese.n1","chinese");
	    String n2 = getMsg("Util.number2chinese.n2","chinese");
	    String n3 = getMsg("Util.number2chinese.n3","chinese");
	    String n4 = getMsg("Util.number2chinese.n4","chinese");
	    String n5 = getMsg("Util.number2chinese.n5","chinese");
	    String n6 = getMsg("Util.number2chinese.n6","chinese");
	    String n7 = getMsg("Util.number2chinese.n7","chinese");
	    String n8 = getMsg("Util.number2chinese.n8","chinese");
	    String n9 = getMsg("Util.number2chinese.n9","chinese");
	    String n10 = getMsg("Util.number2chinese.n10","chinese");
	    String n11 = getMsg("Util.number2chinese.n11","chinese");
	    String n12 = getMsg("Util.number2chinese.n12","chinese");
	    String n13 = getMsg("Util.number2chinese.n13","chinese");
	    String n14 = getMsg("Util.number2chinese.n14","chinese");
	    String n15 = getMsg("Util.number2chinese.n15","chinese");
	    String n99 = getMsg("Util.number2chinese.n99","chinese");
	    String numberChinese[] = {n0,n1,n2,n3,n4,n5,n6,n7,n8,n9};
	    String chineseWord[] = {n99,n10,n11,n12,n13,n10,n11,n12,n14,n10,
	    						n11,n12,n15,n10,n11,n12,n13,n10,n11,n12};
	    String rtnString = n00;
	    String tmpString ="";
	    int i = 0;
	    for(int j=StringLength; j>0; j--){
	    	i++;
	    	String nStr = numberStr.substring(j-1,j);
	    	int n = Integer.parseInt(nStr);
	    	nStr = numberChinese[n]+chineseWord[i-1];
	    	nStr += tmpString;
	    	tmpString = nStr;
	    }
	    rtnString += tmpString;
	    return rtnString;
	}
  
	public static String cnLong2cnShort(String inputCnNumber) throws Exception{
  	
	    String rtnString = inputCnNumber;
	    
	    String n0 = getMsg("Util.number2chinese.n0","chinese");
	    String n13 = getMsg("Util.number2chinese.n13","chinese");
	    String n14 = getMsg("Util.number2chinese.n14","chinese");
	    String n15 = getMsg("Util.number2chinese.n15","chinese");
	    
	    String n20 = getMsg("Util.number2chinese.n20","chinese");
	    String n21 = getMsg("Util.number2chinese.n21","chinese");
	    String n22 = getMsg("Util.number2chinese.n22","chinese");
	    String n23 = getMsg("Util.number2chinese.n23","chinese");
	    String n24 = getMsg("Util.number2chinese.n24","chinese");
	    String n25 = getMsg("Util.number2chinese.n25","chinese");
	    String n26 = getMsg("Util.number2chinese.n26","chinese");
	    String n30 = getMsg("Util.number2chinese.n30","chinese");
	    String n31 = getMsg("Util.number2chinese.n31","chinese");
	    String n32 = getMsg("Util.number2chinese.n32","chinese");
	    String n33 = getMsg("Util.number2chinese.n33","chinese");
	    String n34 = getMsg("Util.number2chinese.n34","chinese");
	    String n35 = getMsg("Util.number2chinese.n35","chinese");
	    
	    String n98 = getMsg("Util.number2chinese.n98","chinese");
	    String n99 = getMsg("Util.number2chinese.n99","chinese");
	    
	    rtnString = rtnString.replaceAll(n20,n0);
	    rtnString = rtnString.replaceAll(n21,n0);
	    rtnString = rtnString.replaceAll(n22,n0);
	    rtnString = rtnString.replaceAll(n23,n0);
	    
	    rtnString = rtnString.replaceAll(n24,n13);
	    rtnString = rtnString.replaceAll(n30,n13);
	    
	    rtnString = rtnString.replaceAll(n25,n14);
	    rtnString = rtnString.replaceAll(n31,n14);
	    rtnString = rtnString.replaceAll(n33,n14);
	    
	    rtnString = rtnString.replaceAll(n26,n15);
	    rtnString = rtnString.replaceAll(n32,n15);
	    rtnString = rtnString.replaceAll(n34,n15);
	    rtnString = rtnString.replaceAll(n35,n15);
	    
	    boolean reCallSelf = false;
	    if(rtnString.indexOf(n20) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n21) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n22) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n23) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n24) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n25) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n26) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n30) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n31) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n32) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n33) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n34) != -1) reCallSelf = true;
	    if(rtnString.indexOf(n35) != -1) reCallSelf = true;
	    
	    if(reCallSelf) {
	      rtnString = cnLong2cnShort(rtnString);
	    } else {
	      rtnString = rtnString.replaceAll(n98,n99);
	    }
	    
	    return rtnString;
    
	}
  
	public static String outFormat(int inputNumber, int commaLength, int totalLength) {
	    String numberStr ;
	    if(inputNumber < 0){
	    	numberStr = ((0-inputNumber) + "").trim();
	    } else {
	    	numberStr = (inputNumber + "").trim();
	    }
	    int StringLength = numberStr.length();
	    String rtnString = "";
	    int i = 0;
	    for(int j=StringLength; j>0; j--){
	    	i++;
	    	String subString = numberStr.substring(j-1,j);
	    	rtnString = subString + rtnString;
	    	if(i % commaLength ==0 && i!=StringLength){
	    		rtnString = "," + rtnString;
	    	}
	    }
	    if(inputNumber < 0) rtnString = "-" + rtnString;
	    if(totalLength > rtnString.length()){
	    	for(i=rtnString.length(); i<=totalLength; i++){
	    		rtnString = "  " + rtnString;
	    	}
	    }
	    return rtnString;
	}
  
	public static String outFormat(double inputNumber, int _length) {
	    NumberFormat nf = NumberFormat.getInstance();
	    nf.setMaximumFractionDigits(_length);
	    return nf.format(inputNumber).toString();
	}
  
	public static String date2Chinese(String inDate, String outFormat) throws Exception {
	    String rtnStr = Cnstnts.EMPTY_STRING;
	    if(inDate.trim().length()<10) {
	    	if(outFormat.equals(Cnstnts.D2C_BEGIN)){
	    		rtnStr = getMsg("Util.date2Chinese.begin","chinese");
	    	} else if(outFormat.equals(Cnstnts.D2C_END)){
	    		rtnStr = getMsg("Util.date2Chinese.end","chinese");
	    	} else if(outFormat.equals(Cnstnts.D2C_LONG)){
	    		rtnStr = getMsg("Util.date2Chinese.long","chinese");
	    	} else if(outFormat.equals(Cnstnts.D2C_SHORT)){
	    		rtnStr = getMsg("Util.date2Chinese.short","chinese");
	    	} else if(outFormat.equals(Cnstnts.D2C_YYMMDD)){
	    		rtnStr = getMsg("Util.date2Chinese.yymmdd","chinese");
	    	} else if(outFormat.equals(Cnstnts.D2C_YYMMDD_BEGIN)){
	    		rtnStr = getMsg("Util.date2Chinese.yymmdd","chinese")+
	    				 getMsg("Util.date2Chinese.Begin","chinese");
	    	} else if(outFormat.equals(Cnstnts.D2C_YYMMDD_END)){
	    		rtnStr = getMsg("Util.date2Chinese.yymmdd","chinese")+
				 		 getMsg("Util.date2Chinese.End","chinese");
	    	}
	    	return rtnStr;
	    }
	    int year = Integer.parseInt(inDate.substring(0,4))-1911;
	    String month = inDate.substring(5,7);
	    String day = inDate.substring(8,10);
	    String hour = Cnstnts.EMPTY_STRING;
	    String minute = Cnstnts.EMPTY_STRING;
	    String second = Cnstnts.EMPTY_STRING;
	    if(inDate.length()>12){
	    	hour = inDate.substring(11,13);
	    	if(Integer.parseInt(hour)>0){
	    		hour = hour + getMsg("Util.date2Chinese.hour","chinese");
	    	} else {
	    		hour = Cnstnts.EMPTY_STRING;
	    	}
	    }
	    if(inDate.length()>15){
	    	minute = inDate.substring(14,16);
	    	if(Integer.parseInt(minute)>0){
	    		minute = minute + getMsg("Util.date2Chinese.minute","chinese");
	    	} else {
	    		minute = Cnstnts.EMPTY_STRING;
	    	}
	    }
	    if(inDate.length()>18){
	    	second = inDate.substring(17,19);
	    	if(Integer.parseInt(second)>0){
	    		second = second + getMsg("Util.date2Chinese.second","chinese");
	    	}else {
	    		second = Cnstnts.EMPTY_STRING;
	    	}
	    }
	    hour = hour + minute + second;
	    if(outFormat.equals(Cnstnts.D2C_BEGIN)){
	    	rtnStr = getMsg("Util.date2Chinese.sBegin","chinese") +
	    			year + getMsg("Util.date2Chinese.year","chinese") +
	    			month + getMsg("Util.date2Chinese.month","chinese") +
	    			day + getMsg("Util.date2Chinese.day","chinese") +
	    			hour + getMsg("Util.date2Chinese.Begin","chinese");
	    } else if(outFormat.equals(Cnstnts.D2C_END)){
	    	rtnStr = getMsg("Util.date2Chinese.sEnd","chinese")+
	    			year + getMsg("Util.date2Chinese.year","chinese") +
	    			month + getMsg("Util.date2Chinese.month","chinese") +
	    			day + getMsg("Util.date2Chinese.dayEnd","chinese")+
	    			hour + getMsg("Util.date2Chinese.End","chinese");
	    } else if(outFormat.equals(Cnstnts.D2C_LONG)){
	    	rtnStr = getMsg("Util.date2Chinese.sLong","chinese")+
	      			year + getMsg("Util.date2Chinese.year","chinese") +
	      			month + getMsg("Util.date2Chinese.month","chinese") +
	      			day + getMsg("Util.date2Chinese.day","chinese") + hour;
	    } else if(outFormat.equals(Cnstnts.D2C_SHORT)){
	    	rtnStr = getMsg("Util.date2Chinese.sShort","chinese")+
	    			year + getMsg("Util.date2Chinese.year","chinese") +
	    			month + getMsg("Util.date2Chinese.month","chinese") +
	    			day + getMsg("Util.date2Chinese.day","chinese") + hour;
	    } else if(outFormat.equals(Cnstnts.D2C_YYMMDD)){
	    	rtnStr = year + getMsg("Util.date2Chinese.year","chinese") +
					 month + getMsg("Util.date2Chinese.month","chinese") +
					 day + getMsg("Util.date2Chinese.day","chinese") + hour;
	    } else if(outFormat.equals(Cnstnts.D2C_YYMMDD_BEGIN)){
	    	rtnStr = year + getMsg("Util.date2Chinese.year","chinese") +
	    			 month + getMsg("Util.date2Chinese.month","chinese") +
			 		 day + getMsg("Util.date2Chinese.day","chinese")+
		    		 hour + getMsg("Util.date2Chinese.Begin","chinese");
	    } else if(outFormat.equals(Cnstnts.D2C_YYMMDD_END)){
	    	rtnStr = year + getMsg("Util.date2Chinese.year","chinese") +
	    			 month + getMsg("Util.date2Chinese.month","chinese") +
	 		  		 day + getMsg("Util.date2Chinese.day","chinese")+
		    		 hour + getMsg("Util.date2Chinese.End","chinese");
	    }
	    return rtnStr;
	}
  
	public static Date toDate(String textDate) throws ParseException{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date = sdf.parse(textDate);
	    sdf.set2DigitYearStart(date);
	    return date;
	}
  
	public static boolean chkID(String IDNO) {
	    int idnoLen=IDNO.length();
	    int idnoTotal=0;
	    if(idnoLen!=10) return false;
	    IDNO = IDNO.toUpperCase();
	    boolean IsOK=false;
	    String areaID="ABCDEFGHJKLMNPQRSTUVXYWZIO";
	    for(int i=0;i<areaID.length();i++){
	    	if (areaID.substring(i,i+1).equals(IDNO.substring(0,1))) {
	    		idnoTotal=i+10;
	    		break;
	    	}
	    }
	    idnoTotal = Integer.parseInt(String.valueOf(idnoTotal).substring(0,1)) +
	                Integer.parseInt(String.valueOf(idnoTotal).substring(1,2))*9 +
	                Integer.parseInt(IDNO.substring(IDNO.length()-1,IDNO.length()));
	    for(int i=1;i<IDNO.length()-1;i++){
	    	idnoTotal+=Integer.parseInt(IDNO.substring(i,i+1))*(9-i);
	    }
	    if (idnoTotal % 10 ==0) IsOK=true;
	    return IsOK;
	}
  
	public static boolean chkEmail(String email) {
	    String [] str = email.split("@",2);
	    if(!str[str.length-1].matches(".*?\\w+\\.\\w+$")) return false;
	    for(int i=0;i<str.length;i++) {
	    	Pattern p = Pattern.compile("\\w+[\\p{Punct}&&[^\\.\\-_]]\\w+");
	    	Matcher m = p.matcher(str[i]);
	    	if(m.find()) return false;
	    }
	    return true;
	}
  
	public static boolean chkIntVaule(String fieldValue){
		String[] intValues = {"-","0","1","2","3","4","5","6","7","8","9"};
		for(int i=0; i<fieldValue.length(); i++){
			String intChar = fieldValue.substring(i,i+1);
			boolean findFlag = false;
			int startValue = 0;
			if(i>0){
				startValue = 1;
			}
			for(int j=startValue; j<intValues.length; j++){
				if(intChar.equals(intValues[j])){
					findFlag = true;
					break;
				}
			}
			if(!findFlag){
				return false;
			}
		}
		return true;
	}
  
	public static int pureIntVaule(String fieldValue){
		String[] intValues = {"-","0","1","2","3","4","5","6","7","8","9","."};
		String numberStr = Cnstnts.EMPTY_STRING;
		int counter = 0;
		for(int i=0; i<fieldValue.length(); i++){
			String intChar = fieldValue.substring(i,i+1);
			for(int j=0; j<intValues.length; j++){
				if(intChar.equals(intValues[j])){
					if(intChar.equals(".")){
						counter++;
						if(counter>1){
							break;
						}
					}
					if(intChar.equals("-")){
						if(i>0){
							break;
						}
					}
					numberStr += intChar;
					break;
				}
			}
		}
		if(numberStr.equals(Cnstnts.EMPTY_STRING)){
			numberStr = "0";
		}
		return Integer.parseInt(numberStr);
	}
	
	public static float pureFloatVaule(String fieldValue){
		String[] intValues = {"-","0","1","2","3","4","5","6","7","8","9","."};
		String numberStr = Cnstnts.EMPTY_STRING;
		int counter = 0;
		for(int i=0; i<fieldValue.length(); i++){
			String intChar = fieldValue.substring(i,i+1);
			for(int j=0; j<intValues.length; j++){
				if(intChar.equals(intValues[j])){
					if(intChar.equals(".")){
						counter++;
						if(counter>1){
							break;
						}
					}
					if(intChar.equals("-")){
						if(i>0){
							break;
						}
					}
					numberStr += intChar;
					break;
				}
			}
		}
		if(numberStr.equals(Cnstnts.EMPTY_STRING)){
			numberStr = "0";
		}
		return Float.parseFloat(numberStr);
	}
  
	public static boolean chkFloatVaule(String fieldValue){
		String[] floatValues = {"-","0","1","2","3","4","5","6","7","8","9","."};
		for(int i=0; i<fieldValue.length(); i++){
			String floatChar = fieldValue.substring(i,i+1);
			boolean findFlag = false;
			int counter = 0;
			int startValue = 0;
			if(i>0){
				startValue = 1;
			}
			for(int j=startValue; j<floatValues.length; j++){
				if(floatChar.equals(floatValues[j])){
					if(floatChar.equals(".")){
						counter++;
						if(counter>1){
							return false;
						}
					}
					findFlag = true;
					break;
				}
			}
			if(!findFlag){
				return false;
			}
		}
		return true;
	}
  
	public static String changeMsg(String users,String final_result) throws Exception {
		if(final_result.equals("agree")) final_result=getMsg("jsp.closeForm.agree",users);
		else if(final_result.equals("approve")) final_result=getMsg("jsp.closeForm.approve",users);
		else if(final_result.equals("reject")) final_result=getMsg("jsp.closeForm.reject",users);
		else if(final_result.equals("cancel")) final_result=getMsg("jsp.closeForm.cancel",users);
		else if(final_result.equals("sendBack")) final_result=getMsg("jsp.closeForm.sendBack",users);
		else if(final_result.equals("backSigner")) final_result=getMsg("jsp.closeForm.backSigner",users);
		return final_result;
	}
  
	public static void createWordDoc(HashMap<?, ?> dataInfo, String sampleFile, String outputFile){
		OoConverter oc = new OoConverter("localhost", "8100");
		sampleFile = "file:///" + tomcatPath + sampleFile;
		outputFile = "file:///" + tomcatPath + outputFile;
		try {
			oc.convertDocument(sampleFile, outputFile, dataInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  
	public static String addWhereOrAnd(String whereStr,String fieldName,String fieldValue){
		if(fieldValue.trim().length()>0){
			if(whereStr.trim().length()==0) {
				return " where "+fieldName+" = '"+fieldValue+"'";
			} else {
				return whereStr += " and "+fieldName+" = '"+fieldValue+"'";
			}
		} else {
			return whereStr;
	   }
	}
  
	public static String addWhereSQL(String whereStr,Field fieldObj){
		String operator = fieldObj.getSearchCondition();
		if(!Cnstnts.LIKE.equals(operator) && !Cnstnts.EQUAL.equals(operator)){
			return whereStr;
		}
		String fieldName=fieldObj.getName();
		String fieldValue=fieldObj.getValue();
		if(fieldValue.trim().length()>0){
			if(whereStr.trim().length()==0) {
				whereStr = " where ";
			} else {
				whereStr += " and ";
			}
			if(Cnstnts.LIKE.equals(operator)){
				whereStr += fieldName+" like '%"+fieldValue+"%'";
			} else {
				whereStr += fieldName+" ='"+fieldValue+"'";
			}
		}
		return whereStr;
	}
  
	public static String addBetweenSQL(String whereStr,
										Field beginDate,Field endDate){
		if(beginDate.getValue().trim().length()==0 
				&& endDate.getValue().trim().length()==0){
			return whereStr;
		}
		if(beginDate.getValue().trim().length()==0){
			beginDate.setValue("2000-01-01");
		}
		if(endDate.getValue().trim().length()==0){
			endDate.setValue("3000-01-01");
		}
		return addBetweenSQL(whereStr,beginDate.getName(),
				beginDate.getValue(),endDate.getValue());
	}
  
	public static String addBetweenSQL(String whereStr,String fieldName,
          							 int beginValue, int endValue){
		if(whereStr.trim().length()==0) {
			whereStr = " where ";
		} else {
			whereStr += " and ";
		}
		whereStr+=" ("+fieldName+" between "+beginValue+" and "+endValue+")";
		return whereStr;
	}
  
	public static String addBetweenSQL(String whereStr,String fieldName,
          							 String beginValue, String endValue){
		if(whereStr.trim().length()==0) {
			whereStr = " where ";
		} else {
			whereStr += " and ";
		}
		whereStr+=" ("+fieldName+" between '"+beginValue+"' and '"+endValue+"')";
		return whereStr;
	}
  
	public static String addOrderSQL(String sqlStr,
		  						   String orderKey, String orderSequence){
		if(orderKey.trim().length()==0 || sqlStr.trim().length()==0){
			return sqlStr;
		}	  
		sqlStr += " order by "+orderKey+" "+orderSequence;
		return sqlStr;
	}

	public static boolean chkInDate(String effectDateFrom, 
								String effectDateTo, String chkDate) {
		if(effectDateFrom.trim().length()<10 
				|| effectDateTo.trim().length()<10 
						|| chkDate.trim().length()<10){
			return false;
		}
		Calendar dateFrom = Calendar.getInstance();
		dateFrom.set(Integer.parseInt(effectDateFrom.substring(0,4)), 
				Integer.parseInt(effectDateFrom.substring(5,7)), 
				Integer.parseInt(effectDateFrom.substring(8,10)));
		Calendar dateTo = Calendar.getInstance();
		dateTo.set(Integer.parseInt(effectDateTo.substring(0,4)), 
				Integer.parseInt(effectDateTo.substring(5,7)), 
				Integer.parseInt(effectDateTo.substring(8,10)));
		Calendar thisDate = Calendar.getInstance();
		thisDate.set(Integer.parseInt(chkDate.substring(0,4)), 
				Integer.parseInt(chkDate.substring(5,7)), 
				Integer.parseInt(chkDate.substring(8,10)));
		if(thisDate.before(dateFrom) || thisDate.after(dateTo)){
			return false;
		}
		return true;
	}

	public static int getSchoolYear() {
		int schoolYear = Integer.parseInt(Util.getYear())-1911;
		int month = Integer.parseInt(Util.getMonth());
		if(month<9){
			schoolYear++;
		}
		return schoolYear;
	}

	public static String getTickImg(String value) {
		String rtnImg = Cnstnts.EMPTY_STRING;
		if(value.equals("Y")){
			rtnImg = "<img src='img/tick.gif'>";
		}
		return rtnImg;
	}

	public static String getOpenAppendixBtn(UserBean userInfo,String fileUrl) throws Exception {
		String rtnBtn = Cnstnts.EMPTY_STRING;
		if(fileUrl.trim().length()>0){
			rtnBtn = "<input type='button' value='"+userInfo.getMsg("jsp.common.openFile")+"' " +
					        "onClick='openAppendix(\""+fileUrl+"\",\"openFile\",800,600)'/>";
		}
		return rtnBtn;
	}
	
	public static String getGraphURL(String fileName){
		String rtnString = null;
		String[] pathText = getTomcatPath().split("/");
		for(int i=0; i<pathText.length; i++){
			if(pathText[i].equals("webapps")){
				rtnString = "/"+pathText[i+1]+"/servlet/DisplayChart?filename="+fileName;
				break;
			}
		}
		return rtnString;
	}
  
}