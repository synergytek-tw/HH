package deepspot.main;

import java.sql.ResultSet;
import java.util.*;
import deepspot.util.*;

public class MailLog_detail {

  public MailLog_detail(){}

  public MailLog_detail(String KeyValue) {
    this.KeyValue=KeyValue;
  }

  String KeyValue="";
  public void setKeyValue(String KeyValue){this.KeyValue=KeyValue;}
  public String getKeyValue(){return KeyValue;}

  int Seq_no=0;
  public void setSeq_no(int Seq_no){this.Seq_no=Seq_no;}
  public int getSeq_no(){return Seq_no;}

  String LogDetail="";
  public void setLogDetail(String LogDetail){this.LogDetail=LogDetail;}
  public String getLogDetail(){return LogDetail;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}

  String TableName="MailLog_detail";
  public String getTableName(){return TableName;}

  public void chkData(String users) throws Exception{
    this.Msg="";
  }

  public void insert(String keyValue,Iterator<?> details) {
    DB db=null;
    String sqlStr="insert into MailLog_detail(KeyValue,LogDetail) values(?,?)";
    try {
      db=new DB(sqlStr);
      int seq_no=0;
      while(details.hasNext()){
        seq_no++;
        MailLog_detail obj=(MailLog_detail)details.next();
        db.setString(1,keyValue);
        db.setString(2,obj.getLogDetail());
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
    String sqlStr="delete from MailLog_detail where KeyValue='"+KeyValue+"'";
    try {
      db=new DB();
      db.executeUpdate(sqlStr);
      sqlStr="delete from MailLog_detail where KeyValue='"+KeyValue+"'";
      db.executeUpdate(sqlStr);
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      db=null;
    }
  }

  public Vector<MailLog_detail> getDetails(String KeyValue){
    DB db=null;
    ResultSet rs=null;
    Vector<MailLog_detail> v=new Vector<MailLog_detail>();
    String sqlStr="select * from MailLog_detail where KeyValue='"+KeyValue+"' order by Seq_no desc";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()){
        MailLog_detail obj=new MailLog_detail();
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setSeq_no(rs.getInt("Seq_no"));
        obj.setLogDetail(rs.getString("LogDetail"));
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