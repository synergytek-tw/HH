package deepspot.main;

import java.sql.ResultSet;
import java.util.*;
import deepspot.util.*;

public class MailLog {

  public MailLog(){}

  public MailLog(String KeyValue) {
    this.KeyValue=KeyValue;
    getAttribute();
    this.Details=this.getDetails(this.getKeyValue());
  }

  String KeyValue="";
  public void setKeyValue(String KeyValue){this.KeyValue=KeyValue;}
  public String getKeyValue(){return KeyValue;}

  String KeepLogAmount="";
  public void setKeepLogAmount(String KeepLogAmount){this.KeepLogAmount=KeepLogAmount;}
  public String getKeepLogAmount(){return KeepLogAmount;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}

  String TableName="MailLog";
  public String getTableName(){return TableName;}

  Vector<?> Details=new Vector<Object>();
  public void setDetails(Vector<?> Details){this.Details=Details;}
  public Vector<?> getDetails(){return this.Details;}
  public Vector<?> getDetails(String KeyValue){;
    Vector<?> vtr=new Vector<Object>();
    MailLog_detail detail=new MailLog_detail();
    vtr=detail.getDetails(KeyValue);
    detail=null;
    return vtr;
  }

  public boolean chkPkey() {
    DB db=null;
    ResultSet rs=null;
    boolean rtnFlag=false;
    String sqlStr="select * from MailLog where KeyValue='"+KeyValue+"'";
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
    String sqlStr="select * from MailLog where KeyValue='"+KeyValue+"'";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      if(rs.next()) {
        this.KeepLogAmount=rs.getString("KeepLogAmount");
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
    String sqlStr="select * from MailLog order by KeyValue";
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

  public Iterator<MailLog> getList() {
    DB db=null;
    ResultSet rs=null;
    Vector<MailLog> v=new Vector<MailLog>();
    String sqlStr="select * from MailLog order by KeyValue";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        MailLog obj=new MailLog();
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setKeepLogAmount(rs.getString("KeepLogAmount"));
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


  public void insert() {
    DB db=null;
    String sqlStr="insert into MailLog(KeyValue,KeepLogAmount) values('"+KeyValue+"','"+KeepLogAmount+"')";
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
    String sqlStr="update MailLog set KeyValue='"+KeyValue+"',KeepLogAmount='"+KeepLogAmount+"' where KeyValue='"+KeyValue+"'";
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
    String sqlStr="delete from MailLog where KeyValue='"+KeyValue+"'";
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
  
  private boolean delete(String KeepLogAmount) {
    boolean rtnFlag = true;
    DB db=null;
    ResultSet rs=null;
    int keepAmount = 0;
    try {
      if(KeepLogAmount.trim().length()>0){
        keepAmount = Integer.parseInt(KeepLogAmount);
      }
    } catch(Exception ex) {
      return false;
    }
    if(keepAmount>=0){
      if(keepAmount==0){
      	this.delete();
      } else {
        try {
          db = new DB();
          String sqlStr="select * from MailLog_detail where KeyValue='"+KeyValue+"' order by Seq_no desc";
      	  rs = db.executeQuery(sqlStr);
      	  int i=0;
      	  int lastKey=0;
      	  while(rs.next()){
      	    i++;
      	    if(i==keepAmount){
      	      lastKey=rs.getInt("Seq_no");
      	      break;
      	    }
      	  }
      	  if(lastKey>0){
      	    sqlStr="delete MailLog_detail where KeyValue='"+KeyValue+"' and Seq_no<"+lastKey;
      	    db.executeUpdate(sqlStr);
      	  }
      	  rs.close();
          db.close();
        } catch(Exception e) {
          e.printStackTrace();
          rtnFlag = false;
        } finally {
          rs=null;
          db=null;
        }
      }
    }
    return rtnFlag;
  }

  public boolean dbExcute(String db_type,String users) throws Exception {
    if(this.KeyValue.trim().length()==0) return false;
    boolean rtnFlag=false;
    boolean chkError = false;
    if(db_type.equals("update")||db_type.equals("insert")) chkError = true;
    if(chkError) {
    }
    if(this.Msg.equals("")) {
      MailLog_detail detail=new MailLog_detail();
      if(db_type.equals("insert")){
        if(this.chkPkey()){
          this.Msg=Util.getMsg("jsp.chkData.idError",users);
        } else {
          this.insert();
          detail.insert(this.KeyValue,this.Details.iterator());
          rtnFlag=true;
          this.Msg=Util.getMsg("jsp.chkData.insert",users);
        }
      }
      if(db_type.equals("update")){
        this.update();
        detail.update(this.KeyValue,this.Details.iterator());
        rtnFlag=true;
        this.Msg=Util.getMsg("jsp.chkData.update",users);
      }
      if(db_type.equals("delete")){
        if(this.delete(this.KeepLogAmount)){
          rtnFlag=true;
          this.Msg=Util.getMsg("jsp.chkData.delete",users);
        }
      }
      detail=null;
    }
    return rtnFlag;
  }

}