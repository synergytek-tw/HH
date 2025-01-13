package deepspot.main;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Vector;
import deepspot.util.*;

public class Flow_detail {

  public Flow_detail(){}

  public Flow_detail(String FlowKey) {
    this.FlowKey=FlowKey;
  }

  String FlowKey="";
  public void setFlowKey(String FlowKey){this.FlowKey=FlowKey;}
  public String getFlowKey(){return FlowKey;}
  
  int Seq_no=0;
  public void setSeq_no(int Seq_no){this.Seq_no=Seq_no;}
  public int getSeq_no(){return Seq_no;}

  int Step=0;
  public void setStep(int Step){this.Step=Step;}
  public int getStep(){return Step;}

  String Step_name="";
  public void setStep_name(String Step_name){this.Step_name=Step_name;}
  public String getStep_name(){return Step_name;}

  String Signer_id="";
  public void setSigner_id(String Signer_id){this.Signer_id=Signer_id;}
  public String getSigner_id(){return Signer_id;}

  String Signer_name="";
  public void setSigner_name(String Signer_name){this.Signer_name=Signer_name;}
  public String getSigner_name(){return Signer_name;}

  String Signer_title="";
  public void setSigner_title(String Signer_title)
  {this.Signer_title=Signer_title;}
  public String getSigner_title(){return Signer_title;}

  String Signer_department="";
  public void setSigner_department(String Signer_department)
  {this.Signer_department=Signer_department;}
  public String getSigner_department(){return Signer_department;}

  String Signed_time="";
  public void setSigned_time(String Signed_time){this.Signed_time=Signed_time;}
  public String getSigned_time(){return Signed_time;}

  String Signed_result="";
  public void setSigned_result(String Signed_result)
  {this.Signed_result=Signed_result;}
  public String getSigned_result(){return Signed_result;}

  String Decided="";
  public void setDecided(String Decided){this.Decided=Decided;}
  public String getDecided(){return Decided;}

  String Memo="";
  public void setMemo(String Memo){this.Memo=Memo;}
  public String getMemo(){return Memo;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}

  String TableName = "Flow_detail";
  public String getTableName(){return TableName;}
  
  public void chkData() {}

  public boolean chkPkey() {
    DB db=null;
    ResultSet rs=null;
    boolean rtnFlag=false;
    String sqlStr="select * from Flow_detail where Flowkey='" + FlowKey +
                  "' and Seq_no=" + Seq_no;
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
    String sqlStr="select * from Flow_detail where Flowkey='" + FlowKey +
                  "' and Seq_no="+Seq_no; 
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      if(rs.next()) {
      	this.Step=rs.getInt("Step");
        this.Step_name=rs.getString("Step_name");
        this.Signer_id=rs.getString("Signer_id");
        this.Signer_name=rs.getString("Signer_name");
        this.Signer_title=rs.getString("Signer_title");
        this.Signer_department=rs.getString("Signer_department");
        this.Signed_time=rs.getString("Signed_time");
        this.Signed_result=rs.getString("Signed_result");
        this.Decided=rs.getString("Decided");
        this.Memo=rs.getString("Memo");
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

  public Vector<Flow_detail> getDetails(String FlowKey) {
    DB db=null;
    ResultSet rs=null;
    Vector<Flow_detail> v=new Vector<Flow_detail>();
    String sqlStr="select * from Flow_detail where FlowKey='" + FlowKey +
                  "' order by Seq_no"; 
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        Flow_detail obj=new Flow_detail();
        obj.setFlowKey(rs.getString("FlowKey"));
        obj.setSeq_no(rs.getInt("Seq_no"));
        obj.setStep(rs.getInt("Step"));
        obj.setStep_name(rs.getString("Step_name"));
        obj.setSigner_id(rs.getString("Signer_id"));
        obj.setSigner_name(rs.getString("Signer_name"));
        obj.setSigner_title(rs.getString("Signer_title"));
        obj.setSigner_department(rs.getString("Signer_department"));
        obj.setSigned_time(rs.getString("Signed_time"));
        obj.setSigned_result(rs.getString("Signed_result"));
        obj.setDecided(rs.getString("Decided"));
        obj.setMemo(rs.getString("Memo"));
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
    return v;
  }
  
  public Vector<Flow_detail> getTimeOrderDetails(String FlowKey) {
	  DB db=null;
	  ResultSet rs=null;
	  Vector<Flow_detail> v=new Vector<Flow_detail>();
	  String sqlStr="select * from Flow_detail where FlowKey='" + FlowKey +
	                "' order by Signed_time"; 
	  try {
	      db=new DB();
	      rs=db.executeQuery(sqlStr);
	      while(rs.next()) {
	    	  Flow_detail obj=new Flow_detail();
	    	  obj.setFlowKey(rs.getString("FlowKey"));
	    	  obj.setSeq_no(rs.getInt("Seq_no"));
	    	  obj.setStep(rs.getInt("Step"));
	    	  obj.setStep_name(rs.getString("Step_name"));
	    	  obj.setSigner_id(rs.getString("Signer_id"));
	    	  obj.setSigner_name(rs.getString("Signer_name"));
	    	  obj.setSigner_title(rs.getString("Signer_title"));
	    	  obj.setSigner_department(rs.getString("Signer_department"));
	    	  obj.setSigned_time(rs.getString("Signed_time"));
	    	  obj.setSigned_result(rs.getString("Signed_result"));
		      obj.setDecided(rs.getString("Decided"));
		      obj.setMemo(rs.getString("Memo"));
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
	  return v;
  }

  public void insert(String FlowKey, Iterator<?> details) {
    DB db=null;
    String sqlStr="insert into Flow_detail(FlowKey,Seq_no,Step,Step_name," +
                                          "Signer_id,Signer_name,Signer_title,"+
                                          "Signer_department,Signed_time," +
                                          "Signed_result,Decided,Memo) " +
                                   "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      db=new DB(sqlStr);
      int seq_no = 0;
      while(details.hasNext()) {
      	seq_no++;
      	Flow_detail obj = (Flow_detail)details.next();
      	db.setString(1,FlowKey);
      	db.setInt(2,seq_no);
      	db.setInt(3,obj.getStep());
      	db.setString(4,obj.getStep_name());
      	db.setString(5,obj.getSigner_id());
      	db.setString(6,obj.getSigner_name());
      	db.setString(7,obj.getSigner_title());
      	db.setString(8,obj.getSigner_department());
      	db.setString(9,obj.getSigned_time());
      	db.setString(10,obj.getSigned_result());
      	db.setString(11,obj.getDecided());
      	db.setString(12,obj.getMemo());
        db.executeUpdate();
      }
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      db=null;
    }
  }
  
  public void insert() {
    DB db=null;
    String sqlStr="insert into Flow_detail(FlowKey,Seq_no,Step,Step_name," +
                                          "Signer_id,Signer_name,Signer_title,"+
                                          "Signer_department,Signed_time," +
                                          "Signed_result,Decided,Memo) " +
                                   "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      db=new DB(sqlStr);
      	db.setString(1,this.FlowKey);
      	db.setInt(2,this.Seq_no);
      	db.setInt(3,this.Step);
      	db.setString(4,this.Step_name);
      	db.setString(5,this.Signer_id);
      	db.setString(6,this.Signer_name);
      	db.setString(7,this.Signer_title);
      	db.setString(8,this.Signer_department);
      	db.setString(9,this.Signed_time);
      	db.setString(10,this.Signed_result);
      	db.setString(11,this.Decided);
      	db.setString(12,this.Memo);
        db.executeUpdate();
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      db=null;
    }
  }

  public void update(String FlowKey, Iterator<?> details) {
    this.delete(FlowKey);
    this.insert(FlowKey,details);
  }

  public void delete(String FlowKey) {
    DB db=null;
    String sqlStr="delete from Flow_detail where FlowKey='" + FlowKey + "'";
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

}