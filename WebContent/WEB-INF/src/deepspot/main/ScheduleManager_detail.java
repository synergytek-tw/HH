package deepspot.main;

import java.sql.ResultSet;
import java.util.*;
import deepspot.util.*;

public class ScheduleManager_detail {

  public ScheduleManager_detail(){}

  public ScheduleManager_detail(String KeyValue) {
    this.KeyValue=KeyValue;
  }

  String KeyValue="";
  public void setKeyValue(String KeyValue){this.KeyValue=KeyValue;}
  public String getKeyValue(){return KeyValue;}

  int Seq_no=0;
  public void setSeq_no(int Seq_no){this.Seq_no=Seq_no;}
  public int getSeq_no(){return Seq_no;}

  String ScheduleName="";
  public void setScheduleName(String ScheduleName){this.ScheduleName=ScheduleName;}
  public String getScheduleName(){return ScheduleName;}

  String ScheduleApp="";
  public void setScheduleApp(String ScheduleApp){this.ScheduleApp=ScheduleApp;}
  public String getScheduleApp(){return ScheduleApp;}

  String ScheduleInitDate="";
  public void setScheduleInitDate(String ScheduleInitDate){this.ScheduleInitDate=ScheduleInitDate;}
  public String getScheduleInitDate(){return ScheduleInitDate;}

  String ScheduleFinalDate="";
  public void setScheduleFinalDate(String ScheduleFinalDate){this.ScheduleFinalDate=ScheduleFinalDate;}
  public String getScheduleFinalDate(){return ScheduleFinalDate;}

  String ScheduleRate="";
  public void setScheduleRate(String ScheduleRate){this.ScheduleRate=ScheduleRate;}
  public String getScheduleRate(){return ScheduleRate;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}

  String TableName="ScheduleManager_detail";
  public String getTableName(){return TableName;}

  public void chkData(String users) throws Exception{
    this.Msg="";
  }

  public void insert(String keyValue,Iterator<?> details) {
    DB db=null;
    String sqlStr="insert into ScheduleManager_detail(KeyValue,Seq_no,ScheduleName,ScheduleApp,ScheduleInitDate,ScheduleFinalDate,ScheduleRate) values(?,?,?,?,?,?,?)";
    try {
      db=new DB(sqlStr);
      int seq_no=0;
      while(details.hasNext()){
        seq_no++;
        ScheduleManager_detail obj=(ScheduleManager_detail)details.next();
        db.setString(1,keyValue);
        db.setInt(2,seq_no);
        db.setString(3,obj.getScheduleName());
        db.setString(4,obj.getScheduleApp());
        db.setString(5,obj.getScheduleInitDate());
        db.setString(6,obj.getScheduleFinalDate());
        db.setString(7,obj.getScheduleRate());
        db.executeUpdate();
      }
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      db=null;
    }
  }

  public void update(String KeyValue,Iterator<?> details){
    this.delete(KeyValue);
    this.insert(KeyValue,details);
  }

  public void delete(String KeyValue) {
    DB db=null;
    String sqlStr="delete from ScheduleManager_detail where KeyValue='"+KeyValue+"'";
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

  public Vector<ScheduleManager_detail> getDetails(String KeyValue){
    DB db=null;
    ResultSet rs=null;
    Vector<ScheduleManager_detail> v=new Vector<ScheduleManager_detail>();
    String sqlStr="select * from ScheduleManager_detail where KeyValue='"+KeyValue+"' order by Seq_no";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()){
        ScheduleManager_detail obj=new ScheduleManager_detail();
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setSeq_no(rs.getInt("Seq_no"));
        obj.setScheduleName(rs.getString("ScheduleName"));
        obj.setScheduleApp(rs.getString("ScheduleApp"));
        obj.setScheduleInitDate(rs.getString("ScheduleInitDate"));
        obj.setScheduleFinalDate(rs.getString("ScheduleFinalDate"));
        obj.setScheduleRate(rs.getString("ScheduleRate"));
        v.add(obj);
      }
      rs.close();
      db.close();
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      rs=null;
      db=null;
    }
    return v;
  }
  
  public Vector<ScheduleManager_detail> getDetails(){
    DB db=null;
    ResultSet rs=null;
    Vector<ScheduleManager_detail> v=new Vector<ScheduleManager_detail>();
    String sqlStr="select * from ScheduleManager_detail";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()){
        ScheduleManager_detail obj=new ScheduleManager_detail();
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setSeq_no(rs.getInt("Seq_no"));
        obj.setScheduleName(rs.getString("ScheduleName"));
        obj.setScheduleApp(rs.getString("ScheduleApp"));
        obj.setScheduleInitDate(rs.getString("ScheduleInitDate"));
        obj.setScheduleFinalDate(rs.getString("ScheduleFinalDate"));
        obj.setScheduleRate(rs.getString("ScheduleRate"));
        v.add(obj);
      }
      rs.close();
      db.close();
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      rs=null;
      db=null;
    }
    return v;
  }
}