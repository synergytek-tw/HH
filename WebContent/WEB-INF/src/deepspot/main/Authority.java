package deepspot.main;

import java.sql.ResultSet;
import java.util.*;
import deepspot.util.*;

public class Authority {

  public Authority(){}
  
  public Authority(String authorityType,String keyValue,String programId){
    this.AuthorityType = authorityType;
    this.KeyValue = keyValue;
    this.ProgramId = programId;
    this.getAttribute();
  }

  String AuthorityType="";
  public void setAuthorityType(String AuthorityType){this.AuthorityType=AuthorityType;}
  public String getAuthorityType(){return AuthorityType;}

  String KeyValue="";
  public void setKeyValue(String KeyValue){this.KeyValue=KeyValue;}
  public String getKeyValue(){return KeyValue;}

  String ProgramId="";
  public void setProgramId(String ProgramId){this.ProgramId=ProgramId;}
  public String getProgramId(){return ProgramId;}

  String DisplayMenu="";
  public void setDisplayMenu(String DisplayMenu){this.DisplayMenu=DisplayMenu;}
  public String getDisplayMenu(){return DisplayMenu;}
  
  String CanControlField="";
  public void setCanControlField(String CanControlField){this.CanControlField=CanControlField;}
  public String getCanControlField(){return CanControlField;}
  
  String AllowQuery="";
  public void setAllowQuery(String AllowQuery){this.AllowQuery=AllowQuery;}
  public String getAllowQuery(){return AllowQuery;}

  String AllowInsert="";
  public void setAllowInsert(String AllowInsert){this.AllowInsert=AllowInsert;}
  public String getAllowInsert(){return AllowInsert;}

  String AllowUpdate="";
  public void setAllowUpdate(String AllowUpdate){this.AllowUpdate=AllowUpdate;}
  public String getAllowUpdate(){return AllowUpdate;}

  String AllowDelete="";
  public void setAllowDelete(String AllowDelete){this.AllowDelete=AllowDelete;}
  public String getAllowDelete(){return AllowDelete;}

  String AllowPrint="";
  public void setAllowPrint(String AllowPrint){this.AllowPrint=AllowPrint;}
  public String getAllowPrint(){return AllowPrint;}
  
  String QueryAuthority="S";
  public void setQueryAuthority(String QueryAuthority){this.QueryAuthority=QueryAuthority;}
  public String getQueryAuthority(){return QueryAuthority;}
  
  String UpdateAuthority="S";
  public void setUpdateAuthority(String UpdateAuthority){this.UpdateAuthority=UpdateAuthority;}
  public String getUpdateAuthority(){return UpdateAuthority;}
  
  String DeleteAuthority="S";
  public void setDeleteAuthority(String DeleteAuthority){this.DeleteAuthority=DeleteAuthority;}
  public String getDeleteAuthority(){return DeleteAuthority;}
  
  String JobType="";
  public void setJobType(String JobType){this.JobType=JobType;}
  public String getJobType(){return JobType;}
  
  String CanUse="";
  public void setCanUse(String CanUse){this.CanUse=CanUse;}
  public String getCanUse(){return CanUse;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}

  String TableName="Authority";
  public String getTableName(){return TableName;}

  public boolean chkPkey() {
    DB db=null;
    ResultSet rs=null;
    boolean rtnFlag=false;
    String sqlStr="select * from Authority where AuthorityType='"+AuthorityType+"'"+
                                           " and KeyValue='"+KeyValue+"'"+
                                           " and ProgramId='"+ProgramId+"'";
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
    DB db=null;
    ResultSet rs=null;
    String sqlStr="select * from Authority where AuthorityType='"+AuthorityType+"'"+
                                           " and KeyValue='"+KeyValue+"'"+
                                           " and ProgramId='"+ProgramId+"'";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      if(rs.next()) {
        this.DisplayMenu=rs.getString("DisplayMenu");
        this.CanControlField=rs.getString("CanControlField");
        this.AllowQuery=rs.getString("AllowQuery");
        this.AllowInsert=rs.getString("AllowInsert");
        this.AllowUpdate=rs.getString("AllowUpdate");
        this.AllowDelete=rs.getString("AllowDelete");
        this.AllowPrint=rs.getString("AllowPrint");
        this.QueryAuthority=rs.getString("QueryAuthority");
        this.UpdateAuthority=rs.getString("UpdateAuthority");
        this.DeleteAuthority=rs.getString("DeleteAuthority");
        this.JobType=rs.getString("JobType");
        this.CanUse=rs.getString("CanUse");
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
  
  public Vector<Program> getAuthority(String authorityType,String keyValue,Vector<?> v) {
    HashMap<String, Authority> authorityMap = getGroupsAuthorityMap(authorityType,keyValue);
    Vector<Program> rtnVtr = new Vector<Program>();
    Iterator<?> itr = v.iterator();
    while(itr.hasNext()){
      Program pObj = (Program)itr.next();
      if(authorityMap.get(pObj.getProgramId())!=null){
        Authority aObj = (Authority)authorityMap.get(pObj.getProgramId());
        pObj.setDisplayMenu(aObj.getDisplayMenu());
        pObj.setCanControlField(aObj.getCanControlField());
        pObj.setAllowQuery(aObj.getAllowQuery());
        pObj.setAllowInsert(aObj.getAllowInsert());
        pObj.setAllowUpdate(aObj.getAllowUpdate());
        pObj.setAllowDelete(aObj.getAllowDelete());
        pObj.setAllowPrint(aObj.getAllowPrint());
        pObj.setQueryAuthority(aObj.getQueryAuthority());
        pObj.setUpdateAuthority(aObj.getUpdateAuthority());
        pObj.setDeleteAuthority(aObj.getDeleteAuthority());
        pObj.setJobType(aObj.getJobType());
        pObj.setCanUse(aObj.getCanUse());
      }
      rtnVtr.add(pObj);
    }
    return rtnVtr;
  }

  public Iterator<Authority> getList() {
    DB db=null;
    ResultSet rs=null;
    Vector<Authority> v=new Vector<Authority>();
    String sqlStr="select * from Authority order by AuthorityType,KeyValue,ProgramId";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        Authority obj=new Authority();
        obj.setAuthorityType(rs.getString("AuthorityType"));
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setProgramId(rs.getString("ProgramId"));
        obj.setDisplayMenu(rs.getString("DisplayMenu"));
        obj.setCanControlField(rs.getString("CanControlField"));
        obj.setAllowQuery(rs.getString("AllowQuery"));
        obj.setAllowInsert(rs.getString("AllowInsert"));
        obj.setAllowUpdate(rs.getString("AllowUpdate"));
        obj.setAllowDelete(rs.getString("AllowDelete"));
        obj.setAllowPrint(rs.getString("AllowPrint"));
        obj.setQueryAuthority(rs.getString("QueryAuthority"));
        obj.setUpdateAuthority(rs.getString("UpdateAuthority"));
        obj.setDeleteAuthority(rs.getString("DeleteAuthority"));
        obj.setJobType(rs.getString("JobType"));
        obj.setCanUse(rs.getString("CanUse"));
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
  
  public HashMap<String, Authority> getGroupsAuthorityMap(String authorityType,String keyValue) {
    DB db=null;
    ResultSet rs=null;
    HashMap<String, Authority> rtnMap = new HashMap<String, Authority>();
    
    if(authorityType.equals("Department")){
      String parentId = new Department(keyValue).getParent_id();
      while(!parentId.equals("")){
      	rtnMap=getGroupsAuthorityMap(authorityType,parentId,rtnMap);
      	parentId = new Department(parentId).getParent_id();
      }
    }
    
    String sqlStr="select * from Authority where AuthorityType='"+authorityType+"' and KeyValue='"+keyValue+"' order by KeyValue,ProgramId";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      int count = 0;
      while(rs.next()) {
      	count++;
        Authority obj=new Authority();
        obj.setAuthorityType(rs.getString("AuthorityType"));
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setProgramId(rs.getString("ProgramId"));
        obj.setDisplayMenu(rs.getString("DisplayMenu"));
        obj.setCanControlField(rs.getString("CanControlField"));
        obj.setAllowQuery(rs.getString("AllowQuery"));
        obj.setAllowInsert(rs.getString("AllowInsert"));
        obj.setAllowUpdate(rs.getString("AllowUpdate"));
        obj.setAllowDelete(rs.getString("AllowDelete"));
        obj.setAllowPrint(rs.getString("AllowPrint"));
        obj.setQueryAuthority(rs.getString("QueryAuthority"));
        obj.setUpdateAuthority(rs.getString("UpdateAuthority"));
        obj.setDeleteAuthority(rs.getString("DeleteAuthority"));
        obj.setJobType(rs.getString("JobType"));
        obj.setCanUse(rs.getString("CanUse"));
        rtnMap.put(obj.getProgramId(),obj);
      }
      rs.close();
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      rs=null;
      db=null;
    }
    return rtnMap;
  }
  
  public HashMap<String, Authority> getGroupsAuthorityMap(String authorityType,String keyValue,HashMap<String, Authority> hMap) {
    DB db=null;
    ResultSet rs=null;
    String sqlStr="select * from Authority where AuthorityType='"+authorityType+"' and KeyValue='"+keyValue+"' order by KeyValue,ProgramId";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        Authority obj=new Authority();
        obj.setAuthorityType(rs.getString("AuthorityType"));
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setProgramId(rs.getString("ProgramId"));
        obj.setDisplayMenu(rs.getString("DisplayMenu"));
        obj.setCanControlField(rs.getString("CanControlField"));
        obj.setAllowQuery(rs.getString("AllowQuery"));
        obj.setAllowInsert(rs.getString("AllowInsert"));
        obj.setAllowUpdate(rs.getString("AllowUpdate"));
        obj.setAllowDelete(rs.getString("AllowDelete"));
        obj.setAllowPrint(rs.getString("AllowPrint"));
        obj.setQueryAuthority(rs.getString("QueryAuthority"));
        obj.setUpdateAuthority(rs.getString("UpdateAuthority"));
        obj.setDeleteAuthority(rs.getString("DeleteAuthority"));
        obj.setJobType(rs.getString("JobType"));
        obj.setCanUse(rs.getString("CanUse"));
        if(authorityType.equals("Department")){
          if(hMap.get(obj.getProgramId())==null)
            hMap.put(obj.getProgramId(),obj);
        } else {
          hMap.put(obj.getProgramId(),obj);
        }
      }
      rs.close();
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      rs=null;
      db=null;
    }
    return hMap;
  }

  public void insert() {
    DB db=null;
    String sqlStr="insert into Authority(AuthorityType,KeyValue,ProgramId,DisplayMenu,CanControlField,AllowQuery,AllowInsert,AllowUpdate,AllowDelete,AllowPrint,JobType,CanUse,QueryAuthority,UpdateAuthority,DeleteAuthority) values('"+AuthorityType+"','"+KeyValue+"','"+ProgramId+"','"+DisplayMenu+"','"+CanControlField+"','"+AllowQuery+"','"+AllowInsert+"','"+AllowUpdate+"','"+AllowDelete+"','"+AllowPrint+"','"+JobType+"','"+CanUse+"','"+QueryAuthority+"','"+UpdateAuthority+"','"+DeleteAuthority+"')";
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
    String sqlStr="update Authority set DisplayMenu='"+DisplayMenu+"',CanControlField='"+CanControlField+"',AllowQuery='"+AllowQuery+"',AllowInsert='"+AllowInsert+"',AllowUpdate='"+AllowUpdate+"',AllowDelete='"+AllowDelete+"',AllowPrint='"+AllowPrint+"',JobType='"+JobType+"',CanUse='"+CanUse+"',QueryAuthority='"+QueryAuthority+"',UpdateAuthority='"+UpdateAuthority+"',DeleteAuthority='"+DeleteAuthority+"'"+
                  " where AuthorityType='"+AuthorityType+"'"+
                    " and KeyValue='"+KeyValue+"'"+
                    " and ProgramId='"+ProgramId+"'"; 
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
    String sqlStr="delete from Authority where AuthorityType='"+AuthorityType+"'"+
                                         " and KeyValue='"+KeyValue+"'"+
                                         " and ProgramId='"+ProgramId+"'";
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

  public void dbExcute() throws Exception {
    if(!this.DisplayMenu.equals("1") && !this.AllowQuery.equals("1") &&
       !this.AllowInsert.equals("1") && !this.AllowUpdate.equals("1") && 
       !this.AllowDelete.equals("1") && !this.AllowPrint.equals("1")) {
      this.delete();
    } else {
      if(this.chkPkey())
        this.update();
      else
        this.insert();
    }
  }
  
  public boolean dbExcute(String db_type,String users) throws Exception {
    if(this.KeyValue.trim().length()==0) return false;
    boolean rtnFlag=false;
    boolean chkError = false;
    if(db_type.equals("update")||db_type.equals("insert")) chkError = true;
    if(chkError) {
    }
    if(this.Msg.equals("")) {
      if(db_type.equals("insert")){
        if(this.chkPkey()){
          this.Msg=Util.getMsg(users,"jsp.chkData.idError");
        } else {
          this.insert();
          rtnFlag=true;
          this.Msg=Util.getMsg(users,"jsp.chkData.insert");
        }
      }
      if(db_type.equals("update")){
        this.update();
        rtnFlag=true;
        this.Msg=Util.getMsg(users,"jsp.chkData.update");
      }
      if(db_type.equals("delete")){
        this.delete();
        rtnFlag=true;
        this.Msg=Util.getMsg(users,"jsp.chkData.delete");
      }
    }
    return rtnFlag;
  }

}