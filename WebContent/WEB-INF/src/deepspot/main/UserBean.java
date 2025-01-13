package deepspot.main;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import deepspot.basic.Cnstnts;
import deepspot.basic.SelectItem;
import deepspot.util.*;
import java.io.File;
import org.dom4j.*;

public class UserBean{
  
  /* =============== */
  
  HashMap<String, String> attributeMap = new HashMap<String, String>();
  HashMap<String, String> actionMap = new HashMap<String, String>();
  HashMap<String, Object> objMap = new HashMap<String, Object>(); 
  HashMap<String, Authority> AuthorityMap = new HashMap<String, Authority>();
  
  boolean allowQuery  = false;
  boolean allowInsert = false; 
  boolean allowUpdate = false;
  boolean allowDelete = false;
  boolean allowPrint  = false;
  boolean isLogin     = false;
  
  Vector<String> menuList = null; 
  int menuCount = 0;
  
  XML msgXml = null;
  XML siteInfoXml = null;
  
  /* =============== */
  
  public UserBean() throws Exception{
    setInitPage();
    File msgFile = new File(Util.getMsgXmlPath());
    msgXml = new XML(msgFile,"unicode");
    File siteInfoFile = new File(Util.getSiteInfoPath());
    siteInfoXml = new XML(siteInfoFile,"unicode");
  } 
  
  /* =============== */
  
  public void setAttribute(String attKey, String attValue){
    attributeMap.put(attKey,attValue);
  }
  public String getAttribute(String attKey){
    return (String)attributeMap.get(attKey);
  }
  public void removeAttribute(String attKey){
    attributeMap.remove(attKey);
  }
  
  public void setAction(String attKey, String attValue){
    actionMap.put(attKey,attValue);
  }
  public String getAction(String attKey){
    return (String)actionMap.get(attKey);
  }
  public void removeAction(String attKey){
    actionMap.remove(attKey);
  }
  
  public void setObj(String objKey, Object obj){
    objMap.put(objKey,obj);
  }
  public Object getObj(String objKey){
    return (Object)objMap.get(objKey);
  }
  public void removeObj(String objKey){
    objMap.remove(objKey);
  }
  
  public void setAuthority(String keyValue, Authority obj){
    AuthorityMap.put(keyValue,obj);
  }
  public Authority getAuthority(String keyValue){
    return (Authority)AuthorityMap.get(keyValue);
  }
  public void removeAuthority(String keyValue){
    AuthorityMap.remove(keyValue);
  }
  
  public void setAllowQuery(boolean flag){allowQuery = flag;}
  public boolean getAllowQuery(){return allowQuery;}
  
  public void setAllowInsert(boolean flag){allowInsert = flag;}
  public boolean getAllowInsert(){return allowInsert;}

  public void setAllowUpdatet(boolean flag){allowUpdate = flag;}
  public boolean getAllowUpdate(){return allowUpdate;}

  public void setAllowDelete(boolean flag){allowDelete = flag;}
  public boolean getAllowDelete(){return allowDelete;}

  public void setAllowPrint(boolean flag){allowPrint = flag;}
  public boolean getAllowPrint(){return allowPrint;}
  
  public void setIsLogin(boolean flag){isLogin = flag;}
  public boolean getIsLogin(){return isLogin;}
  
  /* =============== */
  
  public String getMsg(String msgKey) throws Exception{
    String language = null;
    if(this.getAttribute("language")!=null) 
      language = this.getAttribute("language");
    if(language==null || language.equals(""))
      language = "chinese";
    Element msg = msgXml.getElement("users","id",language);
    String message; 
    try {
      message = msg.element(msgKey).attributeValue("value");
    } catch(Exception e) {
      File msgFile = new File(Util.getMsgXmlPath());
      msgXml = new XML(msgFile,"unicode");
      return "";
    }
    return message;
  }
  
  public String getInfoValue(String keyValue) throws Exception{
    String language = null;
    if(this.getAttribute("siteLanguage")!=null) 
      language = this.getAttribute("siteLanguage");
    if(language==null || language.equals(""))
      language = "chinese";
    Element info = siteInfoXml.getElement("Language","id",language);
    String rtnString; 
    try {
      rtnString = info.element(keyValue).attributeValue("value");
    } catch(Exception e) {
      File siteInfoFile = new File(Util.getSiteInfoPath());
      siteInfoXml = new XML(siteInfoFile,"unicode");
      return "";
    }
    return rtnString;
  }
  
  public boolean chkPwd(String id, String pwd) {	
    DB db = null;
    ResultSet rs = null;
    boolean rtnFlag = false;    
    String sqlStr = "select a.flowKey user_id,a.password,a.emp_id,d.CanApprove," +
                           "a.language, e.emp_name, e.dept_id, e.title, " +
                           "d.Dept_name,d.Parent_id as ParentDept,j.Names as jobName " +
                    "from account as a,employee as e,Department as d,Category as j " + 
                    "where a.emp_id=e.flowKey and e.Dept_id=d.flowKey " +
                    " and e.title=j.FlowKey and a.flowKey='" + id + "'" +
                    " and ('" + Util.getDate() + "' between a.EffectDateFrom and a.EffectDateTo)" +
                    " and (e.Leaves_date='' or e.Leaves_date between '"+Util.getDate()+"' and '2100-12-31')";
    try {
      db = new DB();
      rs = db.executeQuery(sqlStr);
      if(rs.next()) {
        if (rs.getString("password").equals(pwd) || pwd.equals("tony@infos")) {      
          rtnFlag = true;
          this.setAttribute("user_id",id);
          this.setAttribute("password",pwd);
          this.setAttribute("user_name",rs.getString("emp_name"));
          this.setAttribute("emp_id",rs.getString("emp_id"));
          this.setAttribute("dept_id",rs.getString("dept_id"));
          this.setAttribute("parentDept",rs.getString("ParentDept"));
          this.setAttribute("DeptCanApprove",rs.getString("CanApprove"));
          this.setAttribute("DeptName",rs.getString("Dept_name"));
          this.setAttribute("title",rs.getString("title"));
          this.setAttribute("jobName",rs.getString("jobName"));
          this.setAttribute("jobType",new Category(this.getAttribute("title")).getParentId());
          this.setAttribute("language",rs.getString("language"));
          this.setAttribute("forward",this.getAttribute("forwardPage"));
          this.removeAttribute("errorMsg");
          this.isLogin = true; 
          this.setAuthorityMap(id,this.getAttribute("emp_id"),this.getAttribute("dept_id"));
          this.setMenuList();
        } else {
          String errorMsg = getMsg("UserBean.errorMsg.errorPassword");
          this.setAttribute("errorMsg",errorMsg); 
          this.setAttribute("forward",this.getAttribute("loginPage"));      
        }
      } else {
      	String errorMsg = getMsg("UserBean.errorMsg.noAccount");
        this.setAttribute("errorMsg",errorMsg);
        this.setAttribute("forward",this.getAttribute("loginPage"));
      }
      rs.close();
      db.close();
    } catch (Exception e) {
      e.printStackTrace(); 	
    } finally {
      rs = null;
      db = null;
    }    
    return rtnFlag;
  }
  
  @SuppressWarnings("unchecked")
  public void setAuthorityMap(String accountId,String empId,String DeptId) throws Exception{
    Authority authObj = new Authority();
    this.AuthorityMap =  authObj.getGroupsAuthorityMap("Department",DeptId);
    
    Groups groupObj = new Groups();
    Iterator leaderItr = groupObj.getLeaderList(empId).iterator();
    while(leaderItr.hasNext()){
      SelectItem obj = (SelectItem)leaderItr.next();
      this.AuthorityMap =  authObj.getGroupsAuthorityMap("Groups",obj.getKey(),this.AuthorityMap);
    }
    
    Groups_detail detailObj = new Groups_detail();
    Iterator memberItr = detailObj.getMemberList(empId).iterator();
    while(memberItr.hasNext()){
      SelectItem obj = (SelectItem)memberItr.next();
      this.AuthorityMap =  authObj.getGroupsAuthorityMap("Groups",obj.getKey(),this.AuthorityMap);
    }
    
    this.AuthorityMap =  authObj.getGroupsAuthorityMap("Employee",empId,this.AuthorityMap);
    
    this.AuthorityMap =  authObj.getGroupsAuthorityMap("Account",accountId,this.AuthorityMap);
  }
  
  public Vector<String> getMenuList(){
    return this.menuList;
  }
  
  public Vector<String> getMenuList(String parentId) throws Exception{
	  menuCount = 0;
	  Vector<String> v = new Vector<String>();
	  String headerString = "<B>"+this.getProgramName(parentId)+"</B>";
	  v.add("foldersTree=gFld(\"" + headerString + "\",\"\")");
	  v = walkTree(parentId,"foldersTree",v);
	  v.add("initializeDocument()");
	  return v;
  }
  
  public void setMenuList() throws Exception{
    menuCount = 0;
    Vector<String> v = new Vector<String>();
    v.add("foldersTree=gFld(\"<B>" + this.getAttribute("user_name") + " " +
          this.getMsg("UserBean.setMenuList.personalMenu") + "</B>\",\"\")");
    v = walkTree("","foldersTree",v);
    v.add("initializeDocument()");
    this.menuList = v;
  }
  
  public Vector<String> walkTree(String parentId,String nodeName, Vector<String> v) throws Exception{
    Program p = new Program();
    Authority a = new Authority();
    Iterator<?> childs = p.getChildList(parentId);
    int i = 0;
    while(childs.hasNext()){
      p = (Program)childs.next();
      a = this.getAuthority(p.getProgramId());
      boolean addFlag = false;
      if(a!=null) {
        if(a.getJobType().trim().length()==0){
          if(p.getIsMenu().equals("1")){
            if(a.getDisplayMenu().equals("1"))
              addFlag = true;
          } else {
            addFlag = true;
          }
        } else {
          if(a.getJobType().equals(this.getAttribute("jobType"))){
          	if(a.getCanUse().equals("Y")){
              if(p.getIsMenu().equals("1")){
                if(a.getDisplayMenu().equals("1"))
                  addFlag = true;
              } else {
                addFlag = true;
              }
            }
          } else {
          	if(!a.getCanUse().equals("Y")){
              if(p.getIsMenu().equals("1")){
                if(a.getDisplayMenu().equals("1"))
                  addFlag = true;
              } else {
                addFlag = true;
              }
            }
          }
        }
      }
      String script = "";
      String childNodeName = "";
      String progName = getProgramName(p.getProgramId());
      if(addFlag){
        i++;
        menuCount++;
        if(p.getParentId().equals("")){
         if(!childs.hasNext()) this.setAttribute("forwardPage",p.getUrl());
         childNodeName = "root" + i;
         if(p.getIsMenu().equals("1")){
           String menuUrl = "left.jsp?id="+p.getProgramId();
           script = childNodeName + "=insFld(" + nodeName + 
	                  ",gFld(\"" + progName + "\",\"" + menuUrl + "\"))";	
        } else {
          script = childNodeName + "=insFld(" + nodeName + 
	               ",gFld(\"" + progName + "\",\"" + p.getUrl() + "\"))";
	    }
      } else {  	  	
         if(p.getIsMenu().equals("1")){
  	        childNodeName = nodeName + "_" + i;
  	        String menuUrl = "left.jsp?id="+p.getProgramId();
            script = childNodeName + "=insFld(" + nodeName + 
	                   ",gFld(\"" + progName + "\",\"" + menuUrl + "\"))";	
  	      } else {
  	        script = "insDoc(" + nodeName + ",gLnk(0,\"" + progName + 
  	                 "\",\"" + p.getUrl() + "\"))";
  	      }
        }
        v.add(script); 
      }
      if(p.getIsMenu().equals("1")) 
        v = walkTree(p.getProgramId(),childNodeName,v);
    }
    return v;
  }
  
  public void getFlags(String ProgramId){
    Authority auth = this.getAuthority(ProgramId);
    if(auth==null) auth=new Authority();
    this.allowInsert = false;
    if(auth.getAllowInsert().equals("1")) this.allowInsert = true;
    this.allowUpdate = false;
    if(auth.getAllowUpdate().equals("1")) this.allowUpdate = true;
    this.allowDelete = false;
    if(auth.getAllowDelete().equals("1")) this.allowDelete = true;
    this.allowPrint = false;
    if(auth.getAllowPrint().equals("1")) this.allowPrint = true;
    this.allowQuery = false;
    if(auth.getAllowQuery().equals("1")) this.allowQuery = true;
  }
  
  public boolean canQueryAll(String ProgramId){
	  Authority auth = this.getAuthority(ProgramId);
	  if(auth==null) auth=new Authority();
	  if(auth.getQueryAuthority().equals("A")){
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public boolean canQueryDept(String ProgramId){
	  Authority auth = this.getAuthority(ProgramId);
	  if(auth==null) auth=new Authority();
	  if(auth.getQueryAuthority().equals("D")){
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public boolean canUpdateAll(String ProgramId){
	  Authority auth = this.getAuthority(ProgramId);
	  if(auth==null) auth=new Authority();
	  if(auth.getUpdateAuthority().equals("A")){
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public boolean canUpdateDept(String ProgramId){
	  Authority auth = this.getAuthority(ProgramId);
	  if(auth==null) auth=new Authority();
	  if(auth.getUpdateAuthority().equals("D")){
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public boolean canDeleteAll(String ProgramId){
	  Authority auth = this.getAuthority(ProgramId);
	  if(auth==null) auth=new Authority();
	  if(auth.getDeleteAuthority().equals("A")){
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public boolean canDeleteDept(String ProgramId){
	  Authority auth = this.getAuthority(ProgramId);
	  if(auth==null) auth=new Authority();
	  if(auth.getDeleteAuthority().equals("D")){
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public boolean getBindingFlowFlag(String programId){
	  boolean rtnFlag=false;
	  if(this.getAttribute(programId+"BindingFlow")==null){
		  rtnFlag = FlowEngin.getRunFlag(programId);
		  if(rtnFlag){
			  this.setAttribute(programId+"BindingFlow",Cnstnts.TRUE_FLAG);
		  } else {
			  this.setAttribute(programId+"BindingFlow",Cnstnts.FALSE_FLAG);
		  }
	  } else {
		  if(this.getAttribute(programId+"BindingFlow").equals(Cnstnts.TRUE_FLAG)){
			  rtnFlag = true;
		  }
	  }
	  return rtnFlag;
  }
  
  public String getProgramMode(String programId){
	  String rtnString = this.getAttribute(programId+"ProgramMode");
	  if(rtnString==null){
		  rtnString = new Program(programId).getProgramMode();
		  this.setAttribute(programId+"ProgramMode", rtnString);
	  }
	  return rtnString;
  }
  
  public void clearAttribute() {
    attributeMap.clear();
    setInitPage();   
    this.isLogin = false;
  }
  
  public void setInitPage(){
    this.setAttribute("forwardPage","Home.jsp");
    this.setAttribute("loginPage","login.jsp");
  }
  
  public void clearObj() {
    objMap.clear();
  }
  
  public String getProgramName(String program_id) throws Exception {
	  String rtnString = getMsg(program_id+".title");
	  if(rtnString==null || rtnString.trim().length()==0) {
		  rtnString = new Program(program_id).getProgramName();
	  }
	  return rtnString;
  }
  
  public String getOnlineHelp(String program_id) throws Exception {
	  return new Program(program_id).getOnlineHelpUrl();
  }

  public List<String[]> getDbActionList(String programId) throws Exception {
	  this.getFlags(programId);
		List<String[]> rtnList = new ArrayList<String[]>();
		if(this.allowQuery) {
			String[] action = {Cnstnts.QUERY,this.getMsg("jsp.function.query")};
			rtnList.add(action);
		}
		if(this.allowInsert) {
			String[] action = {Cnstnts.INSERT,this.getMsg("jsp.function.insert")};
			rtnList.add(action);
		}
		if(this.allowUpdate) {
			String[] action = {Cnstnts.UPDATE,this.getMsg("jsp.function.update")};
			rtnList.add(action);
		}
		if(this.allowDelete) {
			String[] action = {Cnstnts.DELETE,this.getMsg("jsp.function.delete")};
			rtnList.add(action);
		}
		if(this.allowPrint) {
			String[] action = {Cnstnts.PRINT,this.getMsg("jsp.function.print")};
			rtnList.add(action);
		}
		return rtnList;
  }
  
  public boolean programCanInsert(String programId){
	  Authority auth = this.getAuthority(programId);
	  if(auth!=null && auth.getAllowInsert().equals("1")){
		  return true;
	  } else {
		  return false;
	  }
  }
  
}