package deepspot.main;

import java.sql.ResultSet;
import java.util.*;
import deepspot.util.*;
import deepspot.daemon.*;

public class ScheduleManager {

  public ScheduleManager(){}

  public ScheduleManager(String KeyValue) {
    this.KeyValue=KeyValue;
    getAttribute();
    this.Details=this.getDetails(this.getKeyValue());
  }

  String KeyValue="";
  public void setKeyValue(String KeyValue){this.KeyValue=KeyValue;}
  public String getKeyValue(){return KeyValue;}

  String GroupName="";
  public void setGroupName(String GroupName){this.GroupName=GroupName;}
  public String getGroupName(){return GroupName;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}

  String TableName="ScheduleManager";
  public String getTableName(){return TableName;}

  Vector<?> Details=new Vector<Object>();
  public void setDetails(Vector<?> Details){this.Details=Details;}
  public Vector<?> getDetails(){return this.Details;}
  public Vector<?> getDetails(String KeyValue){;
    Vector<?> vtr=new Vector<Object>();
    ScheduleManager_detail detail=new ScheduleManager_detail();
    vtr=detail.getDetails(KeyValue);
    detail=null;
    return vtr;
  }

  public boolean chkPkey() {
    DB db=null;
    ResultSet rs=null;
    boolean rtnFlag=false;
    String sqlStr="select * from ScheduleManager where KeyValue='"+KeyValue+"'";
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
    String sqlStr="select * from ScheduleManager where KeyValue='"+KeyValue+"'";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      if(rs.next()) {
        this.GroupName=rs.getString("GroupName");
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
    String sqlStr="select * from ScheduleManager order by KeyValue";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        rtnPrpt.setProperty(rs.getString("KeyValue"),rs.getString("Names"));
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

  public Iterator<ScheduleManager> getList() {
    DB db=null;
    ResultSet rs=null;
    Vector<ScheduleManager> v=new Vector<ScheduleManager>();
    String sqlStr="select * from ScheduleManager order by KeyValue";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        ScheduleManager obj=new ScheduleManager();
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setGroupName(rs.getString("GroupName"));
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

  public Iterator<ScheduleManager> getPageList(int page, int pageRecords) {
    DB db=null;
    ResultSet rs=null;
    Vector<ScheduleManager> v=new Vector<ScheduleManager>();
    String sqlStr="select * from ScheduleManager order by KeyValue";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      int record = 0;
      while(rs.next()) {
        record++;
        if(record<=page*pageRecords && record>(page-1)*pageRecords){
          ScheduleManager obj=new ScheduleManager();
          obj.setKeyValue(rs.getString("KeyValue"));
          obj.setGroupName(rs.getString("GroupName"));
          v.add(obj);
        }
        if(record>page*pageRecords) break;
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

  public void insert() {
    DB db=null;
    String sqlStr="insert into ScheduleManager(KeyValue,GroupName) values('"+KeyValue+"','"+GroupName+"')";
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
    String sqlStr="update ScheduleManager set KeyValue='"+KeyValue+"',GroupName='"+GroupName+"' where KeyValue='"+KeyValue+"'";
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
    String sqlStr="delete from ScheduleManager where KeyValue='"+KeyValue+"'";
    try {
      db=new DB();
      db.executeUpdate(sqlStr);
      sqlStr="delete from ScheduleManager_detail where KeyValue='"+KeyValue+"'";
      db.executeUpdate(sqlStr);
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      db=null;
    }
  }

  public boolean dbExcute(String db_type,String users) throws Exception {
    boolean rtnFlag=false;
    boolean chkError = false;
    if(db_type.equals("update")||db_type.equals("insert")) chkError = true;
    if(chkError) {
    }
    if(this.Msg.equals("")) {
      ScheduleManager_detail detail=new ScheduleManager_detail();
      if(db_type.equals("insert")){
        if(this.chkPkey()){
          this.Msg=Util.getMsg("jsp.chkData.idError",users);
        } else {
          this.KeyValue=Util.getNo("Schedule",3);
          this.setModified();//�b �W,�R,�� ���ݭ��s�]�w��{���̫�ק�ɶ�
          this.insert();
          detail.insert(this.KeyValue,this.Details.iterator());
          rtnFlag=true;
          this.Msg=Util.getMsg("jsp.chkData.insert",users);
        }
      }
      if(db_type.equals("update")){
      	if(this.KeyValue.trim().length()==0) return false;
      	this.setModified();//�b �W,�R,�� ���ݭ��s�]�w��{���̫�ק�ɶ�
        this.update();
        detail.update(this.KeyValue,this.Details.iterator());
        rtnFlag=true;
        this.Msg=Util.getMsg("jsp.chkData.update",users);
      }
      if(db_type.equals("delete")){
      	if(this.KeyValue.trim().length()==0) return false;
      	this.setModified();//�b �W,�R,�� ���ݭ��s�]�w��{���̫�ק�ɶ�
        this.delete();
        rtnFlag=true;
        this.Msg=Util.getMsg("jsp.chkData.delete",users);
      }
      detail=null;
    }
    return rtnFlag;
  }
  
  private void setModified() {
  	Schedules.getInstance().setNewModified(new Date());
  }

}