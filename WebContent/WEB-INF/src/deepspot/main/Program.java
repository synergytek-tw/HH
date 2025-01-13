package deepspot.main;

import java.sql.ResultSet;
import java.util.*;
import deepspot.util.*;

public class Program {

  public Program(){}

  public Program(String ProgramId) {
    this.ProgramId=ProgramId;
    getAttribute();
  }

  String ProgramId="";
  public void setProgramId(String ProgramId){this.ProgramId=ProgramId;}
  public String getProgramId(){return ProgramId;}

  String ProgramName="";
  public void setProgramName(String ProgramName){this.ProgramName=ProgramName;}
  public String getProgramName(){return ProgramName;}

  int PageRecords=10;
  public void setPageRecords(int PageRecords){this.PageRecords=PageRecords;}
  public int getPageRecords(){return PageRecords;}

  String Url="";
  public void setUrl(String Url){this.Url=Url;}
  public String getUrl(){return Url;}
  
  String OnlineHelpUrl="";
  public void setOnlineHelpUrl(String OnlineHelpUrl){this.OnlineHelpUrl=OnlineHelpUrl;}
  public String getOnlineHelpUrl(){return OnlineHelpUrl;}
  
  String IsMenu="";
  public void setIsMenu(String IsMenu){this.IsMenu=IsMenu;}
  public String getIsMenu(){return IsMenu;}
  
  String ParentId="";
  public void setParentId(String ParentId){this.ParentId=ParentId;}
  public String getParentId(){return ParentId;}
  
  int Seq_no=0;
  public void setSeq_no(int Seq_no){this.Seq_no=Seq_no;}
  public int getSeq_no(){return Seq_no;}
  
  int Layer=0;
  public void setLayer(int Layer){this.Layer=Layer;}
  public int getLayer(){return Layer;}
  
  String ProgramMode="";
  public void setProgramMode(String ProgramMode){this.ProgramMode=ProgramMode;}
  public String getProgramMode(){return ProgramMode;}

  String UseFlow="";
  public void setUseFlow(String UseFlow){this.UseFlow=UseFlow;}
  public String getUseFlow(){return UseFlow;}

  String Flow_id="";
  public void setFlow_id(String Flow_id){this.Flow_id=Flow_id;}
  public String getFlow_id(){return Flow_id;}

  String BeginWord="";
  public void setBeginWord(String BeginWord){this.BeginWord=BeginWord;}
  public String getBeginWord(){return BeginWord;}

  int EndNoLength=3;
  public void setEndNoLength(int EndNoLength){this.EndNoLength=EndNoLength;}
  public int getEndNoLength(){return EndNoLength;}

  String Date_from="";
  public void setDate_from(String Date_from){this.Date_from=Date_from;}
  public String getDate_from(){return Date_from;}

  String Date_to="";
  public void setDate_to(String Date_to){this.Date_to=Date_to;}
  public String getDate_to(){return Date_to;}
  
  String CloseCanReject="";
  public void setCloseCanReject(String CloseCanReject){this.CloseCanReject=CloseCanReject;}
  public String getCloseCanReject(){return CloseCanReject;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}
  
  String QueryFunction="";
  public void setQueryFunction(String QueryFunction) {this.QueryFunction = QueryFunction;}
  public String getQueryFunction() {return QueryFunction;}
	  
  String UpdateFunction="";
  public void setUpdateFunction(String UpdateFunction) {this.UpdateFunction = UpdateFunction;}
  public String getUpdateFunction() {return UpdateFunction;}
  
  String InsertFunction="";
  public void setInsertFunction(String InsertFunction) {this.InsertFunction = InsertFunction;}
  public String getInsertFunction() {return InsertFunction;}
  
  String DeleteFunction="";
  public void setDeleteFunction(String DeleteFunction) {this.DeleteFunction = DeleteFunction;}
  public String getDeleteFunction() {return DeleteFunction;}
  
  String PrintFunction="";
  public void setPrintFunction(String PrintFunction) {this.PrintFunction = PrintFunction;}
  public String getPrintFunction() {return PrintFunction;}
  
  boolean LastElement=false;
  public void setLastElement(boolean LastElement) {this.LastElement = LastElement;}
  public boolean getLastElement() {return LastElement;}
  
  String DisplayMenu="";
  public void setDisplayMenu(String DisplayMenu) {this.DisplayMenu = DisplayMenu;}
  public String getDisplayMenu() {return DisplayMenu;}
  
  String OpenMenu="";
  public void setOpenMenu(String OpenMenu) {this.OpenMenu = OpenMenu;}
  public String getOpenMenu() {return OpenMenu;}
  
  String AllowQuery="";
  public void setAllowQuery(String AllowQuery) {this.AllowQuery = AllowQuery;}
  public String getAllowQuery() {return AllowQuery;}
   
  String AllowInsert="";
  public void setAllowInsert(String AllowInsert) {this.AllowInsert = AllowInsert;}
  public String getAllowInsert() {return AllowInsert;}
	  
  String AllowUpdate="";
  public void setAllowUpdate(String AllowUpdate) {this.AllowUpdate = AllowUpdate;}
  public String getAllowUpdate() {return AllowUpdate;}
  
  String AllowDelete="";
  public void setAllowDelete(String AllowDelete) {this.AllowDelete = AllowDelete;}
  public String getAllowDelete() {return AllowDelete;}

  String AllowPrint="";
  public void setAllowPrint(String AllowPrint) {this.AllowPrint = AllowPrint;}
  public String getAllowPrint() {return AllowPrint;}
  
  String CanControlField="";
  public void setCanControlField(String CanControlField){this.CanControlField=CanControlField;}
  public String getCanControlField(){return CanControlField;}
  
  String QueryAuthority="";
  public void setQueryAuthority(String QueryAuthority){this.QueryAuthority=QueryAuthority;}
  public String getQueryAuthority(){return QueryAuthority;}
  
  String UpdateAuthority="";
  public void setUpdateAuthority(String UpdateAuthority){this.UpdateAuthority=UpdateAuthority;}
  public String getUpdateAuthority(){return UpdateAuthority;}
  
  String DeleteAuthority="";
  public void setDeleteAuthority(String DeleteAuthority){this.DeleteAuthority=DeleteAuthority;}
  public String getDeleteAuthority(){return DeleteAuthority;}
  
  String LogUpdate="";
  public void setLogUpdate(String LogUpdate){this.LogUpdate=LogUpdate;}
  public String getLogUpdate(){return LogUpdate;}
  
  String LogDelete="";
  public void setLogDelete(String LogDelete){this.LogDelete=LogDelete;}
  public String getLogDelete(){return LogDelete;}
  
  String LogPrint="";
  public void setLogPrint(String LogPrint){this.LogPrint=LogPrint;}
  public String getLogPrint(){return LogPrint;}
  
  String JobType="";
  public void setJobType(String JobType){this.JobType=JobType;}
  public String getJobType(){return JobType;}
  
  String CanUse="";
  public void setCanUse(String CanUse){this.CanUse=CanUse;}
  public String getCanUse(){return CanUse;}
  
  String TableName="Program";
  public String getTableName() {return TableName;}

  public void chkData() {}
  
  public boolean logDelete(){
	  if(this.LogDelete.equals("1")){
		  return true;
	  } else {
		  return false;
	  }
  }

  public boolean chkPkey() {
    DB db=null;
    ResultSet rs=null;
    boolean rtnFlag=false;
    String sqlStr="select * from Program where ProgramId='"+ProgramId+"'";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      if(rs.next()) {
        rtnFlag=true;
      }
      rs.close();
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      rs=null;
      db=null;
    }
    return rtnFlag;
  }

  public void getAttribute() {
    this.chkData();
    DB db=null;
    ResultSet rs=null;
    String sqlStr="select * from Program where ProgramId='"+ProgramId+"'";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      if(rs.next()) {
        this.ProgramName=rs.getString("ProgramName");
        this.PageRecords=rs.getInt("PageRecords");
        this.Url=rs.getString("Url");
        this.IsMenu=rs.getString("IsMenu");
        this.Seq_no=rs.getInt("Seq_no");
        this.OnlineHelpUrl=rs.getString("OnlineHelpUrl");
        this.ParentId=rs.getString("ParentId");
        this.ProgramMode=rs.getString("ProgramMode");
        this.UseFlow=rs.getString("UseFlow");
        this.Flow_id=rs.getString("Flow_id");
        this.BeginWord=rs.getString("BeginWord");
        this.EndNoLength=rs.getInt("EndNoLength");
        this.Date_from=rs.getString("Date_from");
        this.Date_to=rs.getString("Date_to");
        this.CloseCanReject=rs.getString("CloseCanReject");
        this.QueryFunction=rs.getString("QueryFunction");
        this.UpdateFunction=rs.getString("UpdateFunction");
        this.InsertFunction=rs.getString("InsertFunction");
        this.DeleteFunction=rs.getString("DeleteFunction");
        this.PrintFunction=rs.getString("PrintFunction");
        this.LogUpdate=rs.getString("LogUpdate");
        this.LogDelete=rs.getString("LogDelete");
        this.LogPrint=rs.getString("LogPrint");
      }
      rs.close();
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      rs=null;
      db=null;
    }
  }

  public Properties getNamesList() {
    DB db=null;
    ResultSet rs=null;
    Properties rtnPrpt = new Properties();
    String sqlStr="select * from Program order by ProgramId";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        rtnPrpt.setProperty(rs.getString("ProgramId"),rs.getString("ProgramName"));
      }
      rs.close();
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      rs=null;
      db=null;
    }
    return rtnPrpt;
  }

  public Iterator<Program> getList() {
    DB db=null;
    ResultSet rs=null;
    Vector<Program> v=new Vector<Program>();
    String sqlStr="select * from Program order by ProgramId";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        Program obj=new Program();
        obj.setProgramId(rs.getString("ProgramId"));
        obj.setProgramName(rs.getString("ProgramName"));
        obj.setPageRecords(rs.getInt("PageRecords"));
        obj.setUrl(rs.getString("Url"));
        obj.setIsMenu(rs.getString("IsMenu"));
        obj.setSeq_no(rs.getInt("Seq_no"));
        obj.setOnlineHelpUrl(rs.getString("OnlineHelpUrl"));
        obj.setParentId(rs.getString("ParentId"));
        obj.setProgramMode(rs.getString("ProgramMode"));
        obj.setUseFlow(rs.getString("UseFlow"));
        obj.setFlow_id(rs.getString("Flow_id"));
        obj.setBeginWord(rs.getString("BeginWord"));
        obj.setEndNoLength(rs.getInt("EndNoLength"));
        obj.setDate_from(rs.getString("Date_from"));
        obj.setDate_to(rs.getString("Date_to"));
        obj.setCloseCanReject(rs.getString("CloseCanReject"));
        obj.setQueryFunction(rs.getString("QueryFunction"));
        obj.setUpdateFunction(rs.getString("UpdateFunction"));
        obj.setInsertFunction(rs.getString("InsertFunction"));
        obj.setDeleteFunction(rs.getString("DeleteFunction"));
        obj.setPrintFunction(rs.getString("PrintFunction"));
        obj.setLogUpdate(rs.getString("LogUpdate"));
        obj.setLogDelete(rs.getString("LogDelete"));
        obj.setLogPrint(rs.getString("LogPrint"));
        v.add(obj);
      }
      rs.close();
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      rs=null;
      db=null;
    }
    return v.iterator();
  }
  
  public Iterator<Program> getChildList(String parentId) {
    DB db=null;
    ResultSet rs=null;
    Vector<Program> v=new Vector<Program>();
    String sqlStr="select * from Program where ParentId='"+parentId+"' order by Seq_no,ProgramId";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        Program obj=new Program();
        obj.setProgramId(rs.getString("ProgramId"));
        obj.setProgramName(rs.getString("ProgramName"));
        obj.setPageRecords(rs.getInt("PageRecords"));
        obj.setUrl(rs.getString("Url"));
        obj.setIsMenu(rs.getString("IsMenu"));
        obj.setSeq_no(rs.getInt("Seq_no"));
        obj.setOnlineHelpUrl(rs.getString("OnlineHelpUrl"));
        obj.setParentId(rs.getString("ParentId"));
        obj.setProgramMode(rs.getString("ProgramMode"));
        obj.setUseFlow(rs.getString("UseFlow"));
        obj.setFlow_id(rs.getString("Flow_id"));
        obj.setBeginWord(rs.getString("BeginWord"));
        obj.setEndNoLength(rs.getInt("EndNoLength"));
        obj.setDate_from(rs.getString("Date_from"));
        obj.setDate_to(rs.getString("Date_to"));
        obj.setCloseCanReject(rs.getString("CloseCanReject"));
        obj.setQueryFunction(rs.getString("QueryFunction"));
        obj.setUpdateFunction(rs.getString("UpdateFunction"));
        obj.setInsertFunction(rs.getString("InsertFunction"));
        obj.setDeleteFunction(rs.getString("DeleteFunction"));
        obj.setPrintFunction(rs.getString("PrintFunction"));
        obj.setLogUpdate(rs.getString("LogUpdate"));
        obj.setLogDelete(rs.getString("LogDelete"));
        obj.setLogPrint(rs.getString("LogPrint"));
        v.add(obj);
      }
      rs.close();
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      rs=null;
      db=null;
    }
    return v.iterator();
  }
  
  public Iterator<Program> getMenuList() throws Exception {
    Vector<Program> v = new Vector<Program>();
    v = walkTreeMenu("",v,0);
    return v.iterator();
  }
  
  private Vector<Program> walkTreeMenu(String parentId, Vector<Program> v, int layer) throws Exception{
    Iterator<?> childs = this.getChildList(parentId);
    layer++;
    while(childs.hasNext()){
      Program p = (Program)childs.next();
      p.setLayer(layer);
      if(!childs.hasNext())
        p.setLastElement(true);
      if(p.getIsMenu().equals("1")) { 
        v.add(p);
        v = walkTreeMenu(p.getProgramId(),v,layer);
      }
    }
    return v;
  }
  
  public Vector<Program> getTreeList() throws Exception {
    Vector<Program> v = new Vector<Program>();
    v = walkTree("",v,0);
    return v;
  }
  
  public Vector<Program> getTreeList(String parentId) throws Exception {
    Vector<Program> v = new Vector<Program>();
    v = walkTree(parentId,v,0);
    return v;
  }
  
  private Vector<Program> walkTree(String parentId, Vector<Program> v, int layer) throws Exception{
    Iterator<?> childs = this.getChildList(parentId);
    layer++;
    while(childs.hasNext()){
      Program p = (Program)childs.next();
      p.setLayer(layer);
      if(!childs.hasNext())
        p.setLastElement(true);
      v.add(p);
      if(p.getIsMenu().equals("1")) 
        v = walkTree(p.getProgramId(),v,layer);
    }
    return v;
  }
  
  public Iterator<Program> getProgList() {  	
    DB db = null;
    ResultSet rs = null;
    Vector<Program> v = new Vector<Program>();    
    String sqlStr = "select * from " + TableName + " where isMenu='0' order by Seq_no,ProgramId";
    try {
      db = new DB();
      rs = db.executeQuery(sqlStr);
      while (rs.next()) {
      	Program obj=new Program();
        obj.setProgramId(rs.getString("ProgramId"));
        obj.setProgramName(rs.getString("ProgramName"));
        obj.setPageRecords(rs.getInt("PageRecords"));
        obj.setUrl(rs.getString("Url"));
        obj.setIsMenu(rs.getString("IsMenu"));
        obj.setSeq_no(rs.getInt("Seq_no"));
        obj.setOnlineHelpUrl(rs.getString("OnlineHelpUrl"));
        obj.setParentId(rs.getString("ParentId"));
        obj.setProgramMode(rs.getString("ProgramMode"));
        obj.setUseFlow(rs.getString("UseFlow"));
        obj.setFlow_id(rs.getString("Flow_id"));
        obj.setBeginWord(rs.getString("BeginWord"));
        obj.setEndNoLength(rs.getInt("EndNoLength"));
        obj.setDate_from(rs.getString("Date_from"));
        obj.setDate_to(rs.getString("Date_to"));
        obj.setCloseCanReject(rs.getString("CloseCanReject"));
        obj.setQueryFunction(rs.getString("QueryFunction"));
        obj.setUpdateFunction(rs.getString("UpdateFunction"));
        obj.setInsertFunction(rs.getString("InsertFunction"));
        obj.setDeleteFunction(rs.getString("DeleteFunction"));
        obj.setPrintFunction(rs.getString("PrintFunction"));
        obj.setLogUpdate(rs.getString("LogUpdate"));
        obj.setLogDelete(rs.getString("LogDelete"));
        obj.setLogPrint(rs.getString("LogPrint"));
        v.add(obj);
      }
      rs.close();
      db.close();
    } catch (Exception e) {
      e.printStackTrace(); 	
    } finally {
      rs = null;
      db = null;
    }    
    return v.iterator();
  }

  public void insert() {
    DB db=null;
    String sqlStr="insert into Program(ProgramId,"+
                                      "ProgramName,"+
                                      "PageRecords,"+
                                      "Url,"+
                                      "IsMenu,"+
                                      "Seq_no,"+
                                      "OnlineHelpUrl,"+
                                      "ParentId,"+
                                      "ProgramMode,"+
                                      "UseFlow,"+
                                      "Flow_id,"+
                                      "BeginWord,"+
                                      "EndNoLength,"+
                                      "Date_from,"+
                                      "Date_to,"+
                                      "CloseCanReject,"+
                                      "LogUpdate,"+
                                      "LogDelete,"+
                                      "LogPrint,"+
                                      "QueryFunction,"+
                                      "UpdateFunction,"+
                                      "InsertFunction,"+
                                      "DeleteFunction,"+
                                      "PrintFunction)"+ 
                            "values('"+ProgramId+"',"+
                                   "'"+ProgramName+"',"+
                                       PageRecords+","+
                                   "'"+Url+"',"+
                                   "'"+IsMenu+"',"+
                                       Seq_no+","+
                                   "'"+OnlineHelpUrl+"',"+
                                   "'"+ParentId+"',"+
                                   "'"+ProgramMode+"',"+
                                   "'"+UseFlow+"',"+
                                   "'"+Flow_id+"',"+
                                   "'"+BeginWord+"',"+
                                       EndNoLength+","+
                                   "'"+Date_from+"',"+
                                   "'"+Date_to+"',"+
                                   "'"+CloseCanReject+"',"+
                                   "'"+LogUpdate+"',"+
                                   "'"+LogDelete+"',"+
                                   "'"+LogPrint+"',"+
                                   "'"+QueryFunction+"',"+
                                   "'"+UpdateFunction+"',"+
                                   "'"+InsertFunction+"',"+
                                   "'"+DeleteFunction+"',"+
                                   "'"+PrintFunction+"')";
    try {
      db=new DB();
      db.executeUpdate(sqlStr);
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      db=null;
    }
  }

  public void update() {
    DB db=null;
    String sqlStr="update Program set ProgramId='"+ProgramId+"',"+
                                   "ProgramName='"+ProgramName+"',"+
                                   "PageRecords="+PageRecords+","+
                                           "Url='"+Url+"',"+
                                        "IsMenu='"+IsMenu+"',"+
                                        "Seq_no="+Seq_no+","+
                                 "OnlineHelpUrl='"+OnlineHelpUrl+"',"+
                                      "ParentId='"+ParentId+"',"+
                                      "ProgramMode='"+ProgramMode+"',"+
                                       "UseFlow='"+UseFlow+"',"+
                                       "Flow_id='"+Flow_id+"',"+
                                     "BeginWord='"+BeginWord+"',"+
                                   "EndNoLength="+EndNoLength+","+
                                     "Date_from='"+Date_from+"',"+
                                       "Date_to='"+Date_to+"',"+
                                "CloseCanReject='"+CloseCanReject+"',"+
                                     "LogUpdate='"+LogUpdate+"',"+
                                     "LogDelete='"+LogDelete+"',"+
                                      "LogPrint='"+LogPrint+"',"+
                                 "QueryFunction='"+QueryFunction+"',"+
                                "UpdateFunction='"+UpdateFunction+"',"+
                                "InsertFunction='"+InsertFunction+"',"+
                                "DeleteFunction='"+DeleteFunction+"',"+
                                 "PrintFunction='"+PrintFunction+"' "+
                  "where ProgramId='"+ProgramId+"'";
    try {
      db=new DB();
      db.executeUpdate(sqlStr);
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      db=null;
    }
  }

  public void delete() {
    DB db=null;
    String sqlStr="delete from Program where ProgramId='"+ProgramId+"'";
    try {
      db=new DB();
      db.executeUpdate(sqlStr);
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      db=null;
    }
  }

  public boolean dbExcute(String db_type,String users) throws Exception {
    this.chkData();
    this.Msg=null;
    boolean chkError = false;
    if(db_type.equals("update")||db_type.equals("insert")) chkError = true;
    if(chkError) {
    }
    if(this.Msg==null) {
      if(db_type.equals("insert")){
        if(this.chkPkey()){
          this.Msg=Util.getMsg("jsp.chkData.idError",users);
          return false;
        } else {
          this.insert();
          this.Msg=Util.getMsg("jsp.chkData.insert",users);
          return true;
        }
      }
      if(db_type.equals("update")){
        this.update();
        this.Msg=Util.getMsg("jsp.chkData.update",users);
        return true;
      }
      if(db_type.equals("delete")){
        this.delete();
        this.Msg=Util.getMsg("jsp.chkData.delete",users);
        return true;
      }
    }
    this.Msg=Util.getMsg("jsp.chkData.dbExecuteError",users);
    return false;
  }

  public boolean closeCanReject() {
	if(this.CloseCanReject.equals("Y"))
		return true;
	else
		return false;
  }

}