package deepspot.main;

import java.sql.ResultSet;
import java.util.*;
import deepspot.util.*;

public class MailThreadConfig {

  public MailThreadConfig(){}

  public MailThreadConfig(String KeyValue) {
    this.KeyValue=KeyValue;
    getAttribute();
    this.Details=this.getDetails(this.getKeyValue());
  }

  String KeyValue="";
  public void setKeyValue(String KeyValue){this.KeyValue=KeyValue;}
  public String getKeyValue(){return KeyValue;}

  String ExecuteStatus="";
  public void setExecuteStatus(String ExecuteStatus){this.ExecuteStatus=ExecuteStatus;}
  public String getExecuteStatus(){return ExecuteStatus;}

  String LastExecuteTime="";
  public void setLastExecuteTime(String LastExecuteTime){this.LastExecuteTime=LastExecuteTime;}
  public String getLastExecuteTime(){return LastExecuteTime;}

  String NextExecuteTime="";
  public void setNextExecuteTime(String NextExecuteTime){this.NextExecuteTime=NextExecuteTime;}
  public String getNextExecuteTime(){return NextExecuteTime;}

  String DelayTime="";
  public void setDelayTime(String DelayTime){this.DelayTime=DelayTime;}
  public String getDelayTime(){return DelayTime;}

  String MailPeriod="";
  public void setMailPeriod(String MailPeriod){this.MailPeriod=MailPeriod;}
  public String getMailPeriod(){return MailPeriod;}

  String Host="";
  public void setHost(String Host){this.Host=Host;}
  public String getHost(){return Host;}

  String EmailAddress="";
  public void setEmailAddress(String EmailAddress){this.EmailAddress=EmailAddress;}
  public String getEmailAddress(){return EmailAddress;}

  String EmailAccount="";
  public void setEmailAccount(String EmailAccount){this.EmailAccount=EmailAccount;}
  public String getEmailAccount(){return EmailAccount;}

  String Password="";
  public void setPassword(String Password){this.Password=Password;}
  public String getPassword(){return Password;}

  String Authority="";
  public void setAuthority(String Authority){this.Authority=Authority;}
  public String getAuthority(){return Authority;}

  String TurnOn="";
  public void setTurnOn(String TurnOn){this.TurnOn=TurnOn;}
  public String getTurnOn(){return TurnOn;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}

  String TableName="MailThreadConfig";
  public String getTableName(){return TableName;}

  Vector<?> Details=new Vector<Object>();
  public void setDetails(Vector<?> Details){this.Details=Details;}
  public Vector<?> getDetails(){return this.Details;}
  public Vector<?> getDetails(String KeyValue){;
    Vector<?> vtr=new Vector<Object>();
    MailThreadConfig_detail detail=new MailThreadConfig_detail();
    vtr=detail.getDetails(KeyValue);
    detail=null;
    return vtr;
  }

  public boolean chkPkey() {
    DB db=null;
    ResultSet rs=null;
    boolean rtnFlag=false;
    String sqlStr="select * from MailThreadConfig where KeyValue='"+KeyValue+"'";
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
    String sqlStr="select * from MailThreadConfig where KeyValue='"+KeyValue+"'";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      if(rs.next()) {
        this.ExecuteStatus=rs.getString("ExecuteStatus");
        this.LastExecuteTime=rs.getString("LastExecuteTime");
        this.NextExecuteTime=rs.getString("NextExecuteTime");
        this.DelayTime=rs.getString("DelayTime");
        this.MailPeriod=rs.getString("MailPeriod");
        this.Host=rs.getString("Host");
        this.EmailAddress=rs.getString("EmailAddress");
        this.EmailAccount=rs.getString("EmailAccount");
        this.Password=rs.getString("Password");
        this.Authority=rs.getString("Authority");
        this.TurnOn=rs.getString("TurnOn");
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
    String sqlStr="select * from MailThreadConfig order by KeyValue";
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

  public Iterator<MailThreadConfig> getList() {
    DB db=null;
    ResultSet rs=null;
    Vector<MailThreadConfig> v=new Vector<MailThreadConfig>();
    String sqlStr="select * from MailThreadConfig order by KeyValue";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        MailThreadConfig obj=new MailThreadConfig();
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setExecuteStatus(rs.getString("ExecuteStatus"));
        obj.setLastExecuteTime(rs.getString("LastExecuteTime"));
        obj.setNextExecuteTime(rs.getString("NextExecuteTime"));
        obj.setDelayTime(rs.getString("DelayTime"));
        obj.setMailPeriod(rs.getString("MailPeriod"));
        obj.setHost(rs.getString("Host"));
        obj.setEmailAddress(rs.getString("EmailAddress"));
        obj.setEmailAccount(rs.getString("EmailAccount"));
        obj.setPassword(rs.getString("Password"));
        obj.setAuthority(rs.getString("Authority"));
        obj.setTurnOn(rs.getString("TurnOn"));
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

  public Iterator<MailThreadConfig> getPageList(int page, int pageRecords) {
    DB db=null;
    ResultSet rs=null;
    Vector<MailThreadConfig> v=new Vector<MailThreadConfig>();
    String sqlStr="select * from MailThreadConfig order by KeyValue";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      int record = 0;
      while(rs.next()) {
        record++;
        if(record<=page*pageRecords && record>(page-1)*pageRecords){
          MailThreadConfig obj=new MailThreadConfig();
          obj.setKeyValue(rs.getString("KeyValue"));
          obj.setExecuteStatus(rs.getString("ExecuteStatus"));
          obj.setLastExecuteTime(rs.getString("LastExecuteTime"));
          obj.setNextExecuteTime(rs.getString("NextExecuteTime"));
          obj.setDelayTime(rs.getString("DelayTime"));
          obj.setMailPeriod(rs.getString("MailPeriod"));
          obj.setHost(rs.getString("Host"));
          obj.setEmailAddress(rs.getString("EmailAddress"));
          obj.setEmailAccount(rs.getString("EmailAccount"));
          obj.setPassword(rs.getString("Password"));
          obj.setAuthority(rs.getString("Authority"));
          obj.setTurnOn(rs.getString("TurnOn"));
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
  	log(KeyValue);
    DB db=null;
    String sqlStr="insert into MailThreadConfig(KeyValue,ExecuteStatus,LastExecuteTime,NextExecuteTime,DelayTime,MailPeriod,Host,EmailAddress,EmailAccount,Password,Authority,TurnOn) values('"+KeyValue+"','"+ExecuteStatus+"','"+LastExecuteTime+"','"+NextExecuteTime+"','"+DelayTime+"','"+MailPeriod+"','"+Host+"','"+EmailAddress+"','"+EmailAccount+"','"+Password+"','"+Authority+"','"+TurnOn+"')";
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
  	log(KeyValue);
    DB db=null;
    String sqlStr="update MailThreadConfig set KeyValue='"+KeyValue+"',ExecuteStatus='"+ExecuteStatus+"',LastExecuteTime='"+LastExecuteTime+"',NextExecuteTime='"+NextExecuteTime+"',DelayTime='"+DelayTime+"',MailPeriod='"+MailPeriod+"',Host='"+Host+"',EmailAddress='"+EmailAddress+"',EmailAccount='"+EmailAccount+"',Password='"+Password+"',Authority='"+Authority+"',TurnOn='"+TurnOn+"' where KeyValue='"+KeyValue+"'";
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
    String sqlStr="delete from MailThreadConfig where KeyValue='"+KeyValue+"'";
    try {
      db=new DB();
      db.executeUpdate(sqlStr);
      sqlStr="delete from MailThreadConfig_detail where KeyValue='"+KeyValue+"'";
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
      MailThreadConfig_detail detail=new MailThreadConfig_detail();
      if(db_type.equals("insert")){
        if(this.chkPkey()){
          this.Msg=Util.getMsg("jsp.chkData.idError",users);
        } else {
          this.NextExecuteTime = this.checkNextExecuteTime(this.NextExecuteTime);
          this.KeyValue = Util.getNo(this.Host,3);
          this.insert();
          detail.insert(this.KeyValue,this.Details.iterator());
          rtnFlag=true;
          this.Msg=Util.getMsg("jsp.chkData.insert",users);
        }
      }
      if(db_type.equals("update")){
      	if(this.KeyValue.trim().length()==0) return false;
      	this.NextExecuteTime = this.checkNextExecuteTime(this.NextExecuteTime);
        this.update();
        detail.update(this.KeyValue,this.Details.iterator());
        rtnFlag=true;
        this.Msg=Util.getMsg("jsp.chkData.update",users);
      }
      if(db_type.equals("delete")){
      	if(this.KeyValue.trim().length()==0) return false;
        this.delete();
        rtnFlag=true;
        this.Msg=Util.getMsg("jsp.chkData.delete",users);
      }
      detail=null;
    }
    return rtnFlag;
  }
  
  private String checkNextExecuteTime(String NextExecuteTime) {
  	if(NextExecuteTime.trim().equals("")){
  		long now = System.currentTimeMillis();
  		GregorianCalendar gc = new GregorianCalendar();
  		gc.setTimeInMillis(now);
  		NextExecuteTime = 
  		gc.get(Calendar.YEAR)                    + "-" + 
  		Util.n2s((gc.get(Calendar.MONTH)+1),2)   + "-" + 
  		Util.n2s(gc.get(Calendar.DATE),2)        + " " +
  		Util.n2s(gc.get(Calendar.HOUR_OF_DAY),2) + ":" + 
  		Util.n2s(gc.get(Calendar.MINUTE),2)      + ":" + 
  		Util.n2s(gc.get(Calendar.SECOND),2);
  	}
  	return NextExecuteTime;
  }
  
  private void log(String keyValue) {
  	MailLog mLog = new MailLog(keyValue);
  	if(!mLog.chkPkey()) {
  		mLog.insert();
  	}
  }

}