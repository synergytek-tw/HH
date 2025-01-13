package deepspot.main;

import java.sql.ResultSet;
import java.util.*;

import deepspot.basic.Cnstnts;
import deepspot.util.*;

public class MailThreadConfig_detail {

  public MailThreadConfig_detail(){}

  public MailThreadConfig_detail(String KeyValue) {
    this.KeyValue=KeyValue;
  }

  String KeyValue="";
  public void setKeyValue(String KeyValue){this.KeyValue=KeyValue;}
  public String getKeyValue(){return KeyValue;}

  int Seq_no=0;
  public void setSeq_no(int Seq_no){this.Seq_no=Seq_no;}
  public int getSeq_no(){return Seq_no;}

  String SourceTableName="";
  public void setSourceTableName(String SourceTableName){this.SourceTableName=SourceTableName;}
  public String getSourceTableName(){return SourceTableName;}

  String PKey="";
  public void setPKey(String PKey){this.PKey=PKey;}
  public String getPKey(){return PKey;}

  String MailTo="";
  public void setMailTo(String MailTo){this.MailTo=MailTo;}
  public String getMailTo(){return MailTo;}

  String CCTo="";
  public void setCCTo(String CCTo){this.CCTo=CCTo;}
  public String getCCTo(){return CCTo;}

  String BCCTo="";
  public void setBCCTo(String BCCTo){this.BCCTo=BCCTo;}
  public String getBCCTo(){return BCCTo;}

  String Title="";
  public void setTitle(String Title){this.Title=Title;}
  public String getTitle(){return Title;}

  String Content="";
  public void setContent(String Content){this.Content=Content;}
  public String getContent(){return Content;}

  String AttachFile="";
  public void setAttachFile(String AttachFile){this.AttachFile=AttachFile;}
  public String getAttachFile(){return AttachFile;}

  String MailTime="";
  public void setMailTime(String MailTime){this.MailTime=MailTime;}
  public String getMailTime(){return MailTime;}
  
  String Scheduled="";
  public void setScheduled(String Scheduled){this.Scheduled=Scheduled;}
  public String getScheduled(){return Scheduled;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}

  String TableName="MailThreadConfig_detail";
  public String getTableName(){return TableName;}

  public void chkData(String users) throws Exception{
    this.Msg="";
  }

  public void insert(String keyValue,Iterator<?> details) {
    if(keyValue.equals(Cnstnts.EMPTY_STRING)){
      Iterator<?> mailConfigItr = new MailThreadConfig().getList();
      if(mailConfigItr.hasNext()) {
      	MailThreadConfig mailObj = (MailThreadConfig)mailConfigItr.next();
      	keyValue=mailObj.getKeyValue();
      } else return;
    }
    DB db=null;
    String sqlStr="insert into MailThreadConfig_detail(KeyValue,Seq_no,SourceTableName,PKey,MailTo,CCTo,BCCTo,Title,Content,AttachFile,MailTime,Scheduled) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      db=new DB(sqlStr);
      int seq_no=0;
      while(details.hasNext()){
        seq_no++;
        MailThreadConfig_detail obj=(MailThreadConfig_detail)details.next();
        obj.chk1(keyValue);
        db.setString(1,keyValue);
        db.setInt(2,seq_no);
        db.setString(3,obj.getSourceTableName());
        db.setString(4,obj.getPKey());
        db.setString(5,obj.getMailTo());
        db.setString(6,obj.getCCTo());
        db.setString(7,obj.getBCCTo());
        db.setString(8,obj.getTitle());
        db.setString(9,obj.getContent());
        db.setString(10,obj.getAttachFile());
        db.setString(11,obj.getMailTime());
        db.setString(12,obj.getScheduled());
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
  
  public void update(String KeyValue,int SeqNo,String fieldName,String value){
    DB db=null;
    String sqlStr="update MailThreadConfig_detail " +
                  "set " + fieldName + "='" + value + "' where " +
                  "KeyValue='" + KeyValue + "' and " +
                  "Seq_no='" + SeqNo + "'";
                  
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
  
  public void update(String fieldName,String value){
    DB db=null;
    String sqlStr="update MailThreadConfig_detail " +
                  "set " + fieldName + "='" + value + "'";
                  
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

  public void delete(String KeyValue) {
    DB db=null;
    String sqlStr="delete from MailThreadConfig_detail where KeyValue='"+KeyValue+"'";
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
  
  public void delete(String KeyValue,List<?> SeqNo) {
  	DB db=null;
  	String SeqNos = "";
  	for(int i=0;i<SeqNo.size();i++) {
  		SeqNos += ((Integer)SeqNo.get(i)).intValue() +",";
  	}
  	SeqNos = SeqNos.substring(0,SeqNos.lastIndexOf(","));
    String sqlStr="delete from MailThreadConfig_detail where KeyValue='"+KeyValue+"' and Seq_no in(" + SeqNos + ")";
    try {
      db=new DB();
      db.executeUpdate(sqlStr);
      sqlStr="delete from MailThreadConfig_detail where KeyValue='"+KeyValue+"' and Seq_no in(" + SeqNos + ")";
      db.executeUpdate(sqlStr);
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      db=null;
    }
  	
  }

  public Vector<MailThreadConfig_detail> getDetails(String KeyValue){
    DB db=null;
    ResultSet rs=null;
    Vector<MailThreadConfig_detail> v=new Vector<MailThreadConfig_detail>();
    String sqlStr="select * from MailThreadConfig_detail where KeyValue='"+KeyValue+"' order by Seq_no";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()){
        MailThreadConfig_detail obj=new MailThreadConfig_detail();
        obj.setKeyValue(rs.getString("KeyValue"));
        obj.setSeq_no(rs.getInt("Seq_no"));
        obj.setSourceTableName(rs.getString("SourceTableName"));
        obj.setPKey(rs.getString("PKey"));
        obj.setMailTo(rs.getString("MailTo"));
        obj.setCCTo(rs.getString("CCTo"));
        obj.setBCCTo(rs.getString("BCCTo"));
        obj.setTitle(rs.getString("Title"));
        obj.setContent(rs.getString("Content"));
        obj.setAttachFile(rs.getString("AttachFile"));
        obj.setMailTime(rs.getString("MailTime"));
        obj.setScheduled(rs.getString("Scheduled"));
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
  
  private void chk1(String keyValue){
  	if(this.SourceTableName.equals("")) this.SourceTableName = this.TableName;
  	if(this.PKey.equals("")) this.PKey = keyValue;
  }
}