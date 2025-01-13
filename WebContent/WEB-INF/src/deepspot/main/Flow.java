package deepspot.main;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Vector;
import deepspot.util.*;

public class Flow {

  public Flow(){}

  public Flow(String FlowKey) {
    this.FlowKey=FlowKey;
    this.getAttribute();
    this.Details = this.getDetails(this.getFlowKey());
  }

  String FlowKey="";
  public void setFlowKey(String FlowKey){this.FlowKey=FlowKey;}
  public String getFlowKey(){return FlowKey;}

  String Flow_id="";
  public void setFlow_id(String Flow_id){this.Flow_id=Flow_id;}
  public String getFlow_id(){return Flow_id;}

  String Flow_name="";
  public void setFlow_name(String Flow_name){this.Flow_name=Flow_name;}
  public String getFlow_name(){return Flow_name;}

  String Creater_id="";
  public void setCreater_id(String Creater_id){this.Creater_id=Creater_id;}
  public String getCreater_id(){return Creater_id;}

  String Creater_name="";
  public void setCreater_name(String Creater_name){this.Creater_name=Creater_name;}
  public String getCreater_name(){return Creater_name;}

  String Create_time="";
  public void setCreate_time(String Create_time){this.Create_time=Create_time;}
  public String getCreate_time(){return Create_time;}

  String Applicant_id="";
  public void setApplicant_id(String Applicant_id){this.Applicant_id=Applicant_id;}
  public String getApplicant_id(){return Applicant_id;}

  String Applicant_name="";
  public void setApplicant_name(String Applicant_name){this.Applicant_name=Applicant_name;}
  public String getApplicant_name(){return Applicant_name;}

  String Signer_id="";
  public void setSigner_id(String Signer_id){this.Signer_id=Signer_id;}
  public String getSigner_id(){return Signer_id;}

  String Signer_name="";
  public void setSigner_name(String Signer_name){this.Signer_name=Signer_name;}
  public String getSigner_name(){return Signer_name;}
  
  String SrcSigner_id="";
  public void setSrcSigner_id(String SrcSigner_id){this.SrcSigner_id=SrcSigner_id;}
  public String getSrcSigner_id(){return SrcSigner_id;}

  String Decider_id="";
  public void setDecider_id(String Decider_id){this.Decider_id=Decider_id;}
  public String getDecider_id(){return Decider_id;}

  String Decider_name="";
  public void setDecider_name(String Decider_name){this.Decider_name=Decider_name;}
  public String getDecider_name(){return Decider_name;}

  String Decide_time="";
  public void setDecide_time(String Decide_time){this.Decide_time=Decide_time;}
  public String getDecide_time(){return Decide_time;}

  String Closer_id="";
  public void setCloser_id(String Closer_id){this.Closer_id=Closer_id;}
  public String getCloser_id(){return Closer_id;}

  String Closer_name="";
  public void setCloser_name(String Closer_name){this.Closer_name=Closer_name;}
  public String getCloser_name(){return Closer_name;}

  String Closed_time="";
  public void setClosed_time(String Closed_time){this.Closed_time=Closed_time;}
  public String getClosed_time(){return Closed_time;}
  
  String CloseFlag="";
  public void setCloseFlag(String CloseFlag){this.CloseFlag=CloseFlag;}
  public String getCloseFlag(){return CloseFlag;}


  int Total_steps=0;
  public void setTotal_steps(int Total_steps){this.Total_steps=Total_steps;}
  public int getTotal_steps(){return Total_steps;}

  int Finished_steps=0;
  public void setFinished_steps(int Finished_steps){this.Finished_steps=Finished_steps;}
  public int getFinished_steps(){return Finished_steps;}

  String Status="";
  public void setStatus(String Status){this.Status=Status;}
  public String getStatus(){return Status;}
  
  String Form_tableName="";
  public void setForm_tableName(String Form_tableName){this.Form_tableName=Form_tableName;}
  public String getForm_tableName(){return Form_tableName;}

  String Msg="";
  public void setMsg(String Msg){this.Msg=Msg;}
  public String getMsg(){return Msg;}

  String TableName = "Flow";
  public String getTableName(){return TableName;}

  Vector<?> Details=new Vector<Object>();
  public void setDetails(Vector<?> Details){this.Details=Details;}
  public Vector<?> getDetails() {return this.Details;}
  public Vector<?> getDetails(String FlowKey){
    Vector<?> vtr = new Vector<Object>();
    Flow_detail detail = new Flow_detail();
    vtr = detail.getDetails(FlowKey);
    detail = null;
    return vtr;
  }

  public void chkData() {}

  public boolean chkPkey() {
    DB db=null;
    ResultSet rs=null;
    boolean rtnFlag=false;
    String sqlStr="select * from Flow where FlowKey='"+FlowKey+"'";
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
    String sqlStr="select * from Flow where FlowKey='"+FlowKey+"'";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      if(rs.next()) {
        this.Flow_id=rs.getString("Flow_id");
        this.Flow_name=rs.getString("Flow_name");
        this.Creater_id=rs.getString("Creater_id");
        this.Creater_name=rs.getString("Creater_name");
        this.Create_time=rs.getString("Create_time");
        this.Applicant_id=rs.getString("Applicant_id");
        this.Applicant_name=rs.getString("Applicant_name");
        this.Signer_id=rs.getString("Signer_id");
        this.Signer_name=rs.getString("Signer_name");
        this.SrcSigner_id=rs.getString("SrcSigner_id");
        this.Decider_id=rs.getString("Decider_id");
        this.Decider_name=rs.getString("Decider_name");
        this.Decide_time=rs.getString("Decide_time");
        this.Closer_id=rs.getString("Closer_id");
        this.Closer_name=rs.getString("Closer_name");
        this.Closed_time=rs.getString("Closed_time");
        this.CloseFlag=rs.getString("CloseFlag");
        this.Total_steps=rs.getInt("Total_steps");
        this.Finished_steps=rs.getInt("Finished_steps");
        this.Status=rs.getString("Status");
        this.Form_tableName=rs.getString("Form_tableName");
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

  public Iterator<Flow> getList() {
    DB db=null;
    ResultSet rs=null;
    Vector<Flow> v=new Vector<Flow>();
    String sqlStr="select * from Flow order by FlowKey";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        Flow obj=new Flow();
        obj.setFlowKey(rs.getString("FlowKey"));
        obj.setFlow_id(rs.getString("Flow_id"));
        obj.setFlow_name(rs.getString("Flow_name"));
        obj.setCreater_id(rs.getString("Creater_id"));
        obj.setCreater_name(rs.getString("Creater_name"));
        obj.setCreate_time(rs.getString("Create_time"));
        obj.setApplicant_id(rs.getString("Applicant_id"));
        obj.setApplicant_name(rs.getString("Applicant_name"));
        obj.setSigner_id(rs.getString("Signer_id"));
        obj.setSigner_name(rs.getString("Signer_name"));
        obj.setSrcSigner_id(rs.getString("SrcSigner_id"));
        obj.setDecider_id(rs.getString("Decider_id"));
        obj.setDecider_name(rs.getString("Decider_name"));
        obj.setDecide_time(rs.getString("Decide_time"));
        obj.setCloser_id(rs.getString("Closer_id"));
        obj.setCloser_name(rs.getString("Closer_name"));
        obj.setClosed_time(rs.getString("Closed_time"));
        obj.setCloseFlag(rs.getString("CloseFlag"));
        obj.setTotal_steps(rs.getInt("Total_steps"));
        obj.setFinished_steps(rs.getInt("Finished_steps"));
        obj.setStatus(rs.getString("Status"));
        obj.setForm_tableName(rs.getString("Form_tableName"));
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
  
  public Iterator<Flow> getPressList() {
    DB db=null;
    ResultSet rs=null;
    Vector<Flow> v=new Vector<Flow>();
    String sqlStr="select * from Flow where Signer_id!='' order by Signer_id";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        Flow obj=new Flow();
        obj.setFlowKey(rs.getString("FlowKey"));
        obj.setFlow_id(rs.getString("Flow_id"));
        obj.setFlow_name(rs.getString("Flow_name"));
        obj.setCreater_id(rs.getString("Creater_id"));
        obj.setCreater_name(rs.getString("Creater_name"));
        obj.setCreate_time(rs.getString("Create_time"));
        obj.setApplicant_id(rs.getString("Applicant_id"));
        obj.setApplicant_name(rs.getString("Applicant_name"));
        obj.setSigner_id(rs.getString("Signer_id"));
        obj.setSigner_name(rs.getString("Signer_name"));
        obj.setSrcSigner_id(rs.getString("SrcSigner_id"));
        obj.setDecider_id(rs.getString("Decider_id"));
        obj.setDecider_name(rs.getString("Decider_name"));
        obj.setDecide_time(rs.getString("Decide_time"));
        obj.setCloser_id(rs.getString("Closer_id"));
        obj.setCloser_name(rs.getString("Closer_name"));
        obj.setClosed_time(rs.getString("Closed_time"));
        obj.setCloseFlag(rs.getString("CloseFlag"));
        obj.setTotal_steps(rs.getInt("Total_steps"));
        obj.setFinished_steps(rs.getInt("Finished_steps"));
        obj.setStatus(rs.getString("Status"));
        obj.setForm_tableName(rs.getString("Form_tableName"));
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
  
  public Iterator<Flow> getList(String whereStr) {
    DB db=null;
    ResultSet rs=null;
    Vector<Flow> v=new Vector<Flow>();
    String sqlStr="select * from Flow " + whereStr + " order by FlowKey";
    try {
      db=new DB();
      rs=db.executeQuery(sqlStr);
      while(rs.next()) {
        Flow obj=new Flow();
        obj.setFlowKey(rs.getString("FlowKey"));
        obj.setFlow_id(rs.getString("Flow_id"));
        obj.setFlow_name(rs.getString("Flow_name"));
        obj.setCreater_id(rs.getString("Creater_id"));
        obj.setCreater_name(rs.getString("Creater_name"));
        obj.setCreate_time(rs.getString("Create_time"));
        obj.setApplicant_id(rs.getString("Applicant_id"));
        obj.setApplicant_name(rs.getString("Applicant_name"));
        obj.setSigner_id(rs.getString("Signer_id"));
        obj.setSigner_name(rs.getString("Signer_name"));
        obj.setSrcSigner_id(rs.getString("SrcSigner_id"));
        obj.setDecider_id(rs.getString("Decider_id"));
        obj.setDecider_name(rs.getString("Decider_name"));
        obj.setDecide_time(rs.getString("Decide_time"));
        obj.setCloser_id(rs.getString("Closer_id"));
        obj.setCloser_name(rs.getString("Closer_name"));
        obj.setClosed_time(rs.getString("Closed_time"));
        obj.setCloseFlag(rs.getString("CloseFlag"));
        obj.setTotal_steps(rs.getInt("Total_steps"));
        obj.setFinished_steps(rs.getInt("Finished_steps"));
        obj.setStatus(rs.getString("Status"));
        obj.setForm_tableName(rs.getString("Form_tableName"));
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
  /*
  public List<Flow> getWait2PayList(String closer_id) {
	    DB db=null;
	    ResultSet rs=null;
	    List<Flow> rtnList=new ArrayList<Flow>();
	    String sqlStr="SELECT f.* FROM GoodsApply g INNER JOIN Flow f "+
	    			  "ON g.FlowKey = f.FlowKey AND f.Status = 'approve' "+
	    			  						   "AND f.Closer_id = '"+closer_id+"' "+
	    			  "WHERE (g.FlowKey NOT IN "+
	    			  "(SELECT G.FlowKey FROM GoodsApply G INNER JOIN "+
	    			  				   "(SELECT GoodsApplyNo, SUM(Amount) AS PaymentAmount "+
	    			  				           "FROM VoucherPayment WHERE (GoodsApplyNo <> '') "+
	    			  				           "GROUP BY GoodsApplyNo) P "+
	    			   "ON G.FlowKey = P.GoodsApplyNo AND G.Amount = P.PaymentAmount))";
	    try {
	      db=new DB();
	      rs=db.executeQuery(sqlStr);
	      while(rs.next()) {
	        Flow obj=new Flow();
	        obj.setFlowKey(rs.getString("FlowKey"));
	        obj.setFlow_id(rs.getString("Flow_id"));
	        obj.setFlow_name(rs.getString("Flow_name"));
	        obj.setCreater_id(rs.getString("Creater_id"));
	        obj.setCreater_name(rs.getString("Creater_name"));
	        obj.setCreate_time(rs.getString("Create_time"));
	        obj.setApplicant_id(rs.getString("Applicant_id"));
	        obj.setApplicant_name(rs.getString("Applicant_name"));
	        obj.setSigner_id(rs.getString("Signer_id"));
	        obj.setSigner_name(rs.getString("Signer_name"));
	        obj.setSrcSigner_id(rs.getString("SrcSigner_id"));
	        obj.setDecider_id(rs.getString("Decider_id"));
	        obj.setDecider_name(rs.getString("Decider_name"));
	        obj.setDecide_time(rs.getString("Decide_time"));
	        obj.setCloser_id(rs.getString("Closer_id"));
	        obj.setCloser_name(rs.getString("Closer_name"));
	        obj.setClosed_time(rs.getString("Closed_time"));
	        obj.setCloseFlag(rs.getString("CloseFlag"));
	        obj.setTotal_steps(rs.getInt("Total_steps"));
	        obj.setFinished_steps(rs.getInt("Finished_steps"));
	        obj.setStatus(rs.getString("Status"));
	        obj.setForm_tableName(rs.getString("Form_tableName"));
	        rtnList.add(obj);
	      }
	      rs.close();
	      db.close();
	    } catch(Exception e) {
	      e.printStackTrace();
	    } finally {
	      rs=null;
	      db=null;
	    }
	    return rtnList;
	  }
  	  */
  public void updateCloseFlag(String[] removeItems) {
    String whereStr = "";
    for(int i=0;i<removeItems.length;i++){
      if(whereStr.equals("")){
      	whereStr = " where FlowKey in('"+removeItems[i]+"'";
      } else {
      	whereStr += ",'"+removeItems[i]+"'";
      }
    }
    if(whereStr.equals("")){
      return;
    } else {
      whereStr += ") ";
    }
    DB db=null;
    String sqlStr="update Flow set CloseFlag='Y'"+ whereStr;
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
  
  public void updateCloseTime(String[] removeItems) {
	  String whereStr = "";
	  for(int i=0;i<removeItems.length;i++){
		  if(whereStr.equals("")){
			  whereStr = " where FlowKey in('"+removeItems[i]+"'";
		  } else {
			  whereStr += ",'"+removeItems[i]+"'";
		  }
	  }
	  if(whereStr.equals("")){
		  return;
	  } else {
		  whereStr += ") ";
	  }
	  DB db=null;
	  String sqlStr="update Flow set Closed_time='"+Util.getDateTime()+"'"+ whereStr;
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
  
  public void batchAgree(String[] agreeItems, UserBean userInfo) throws Exception {
	  for(int i=0;i<agreeItems.length;i++){
		  String signed_result = "agree";
		  Flow_detail fd = new Flow_detail();
	      fd.setFlowKey(agreeItems[i]);
	      fd.setMemo("batch agree");
	      fd.setSigner_id(userInfo.getAttribute("emp_id"));
	      fd.setSigner_name(userInfo.getAttribute("user_name"));
	      fd.setSigner_title(userInfo.getAttribute("jobName"));
	      fd.setSigner_department(userInfo.getAttribute("DeptName"));
	      fd.setSigned_result(signed_result);
	      fd.setDecided("");
	      fd.setSigned_time(Util.getDateTime());
	      
	      FlowEngin.run(fd);
	  }
  }

  public void insert() {
    DB db=null;
    String sqlStr="insert into Flow(FlowKey,"            + "Flow_id," +
                                   "Flow_name,"          + "Creater_id," +
                                   "Creater_name,"       + "Create_time," +
                                   "Applicant_id,"       + "Applicant_name," +
                                   "Signer_id,"          + "Signer_name," +
                                   "SrcSigner_id,"       + "CloseFlag," +
                                   "Decider_id,"         + "Decider_name," +
                                   "Decide_time,"        + "Closer_id," +
                                   "Closer_name,"        + "Closed_time," +
                                   "Total_steps,"        + "Finished_steps," +
                                   "Status,"             + "Form_tableName) " +
                       "values('" + FlowKey + "','"      + Flow_id + "',N'" +
                                    Flow_name + "','"    + Creater_id + "',N'" +
                                    Creater_name + "','" + Create_time + "','" +
                                    Applicant_id + "',N'"+ Applicant_name +"','" +
                                    Signer_id + "',N'"   + Signer_name + "','" +
                                    SrcSigner_id + "','" + CloseFlag + "','" +
                                    Decider_id + "',N'"  + Decider_name + "','" +
                                    Decide_time + "','"  + Closer_id + "',N'" +
                                    Closer_name + "','"  + Closed_time + "'," +
                                    Total_steps + ","    + Finished_steps + ",'" + 
                                    Status + "','"       + Form_tableName+"')";
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
    String sqlStr="update Flow set Flow_id='"         + Flow_id + 
                                "',Flow_name=N'"       + Flow_name +
                                "',Creater_id='"      + Creater_id +
                                "',Creater_name=N'"   + Creater_name +
                                "',Create_time='"     + Create_time +
                                "',Applicant_id='"    + Applicant_id +
                                "',Applicant_name=N'" + Applicant_name +
                                "',Signer_id='"       + Signer_id +
                                "',Signer_name=N'"    + Signer_name +
                                "',SrcSigner_id='"    + SrcSigner_id +
                                "',Decider_id='"      + Decider_id +
                                "',Decider_name=N'"   + Decider_name +
                                "',Decide_time='"     + Decide_time +
                                "',Closer_id='"       + Closer_id +
                                "',Closer_name=N'"    + Closer_name +
                                "',Closed_time='"     + Closed_time +
                                "',CloseFlag='"       + CloseFlag +
                                "',Total_steps="      + Total_steps +
                                 ",Finished_steps="   + Finished_steps +
                                 ",Status='"          + Status +
                                "',Form_tableName='"  + Form_tableName +
                          "' where FlowKey='"         + FlowKey+"'";
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
    String sqlStr="delete from Flow where FlowKey='" + FlowKey + "'";
    try {
      db=new DB();
      db.executeUpdate(sqlStr);
      sqlStr="delete from Flow_detail where FlowKey='" + FlowKey + "'";
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
    boolean rtnFlag=false;
    this.Msg=null;
    if(this.FlowKey.length()==0) this.Msg=Util.getMsg(users,"prg.Flow.FlowKey");
    if(this.Flow_id.length()==0) this.Msg=Util.getMsg(users,"prg.Flow.Flow_id");
    if(this.Flow_name.length()==0) this.Msg=Util.getMsg(users,"prg.Flow.Flow_name");
    if(this.Creater_id.length()==0) this.Msg=Util.getMsg(users,"prg.Flow.Creater_id");
    if(this.Creater_name.length()==0) this.Msg=Util.getMsg(users,"prg.Flow.Creater_name");
    if(this.Create_time.length()==0) this.Msg=Util.getMsg(users,"prg.Flow.Create_time");
    if(this.Applicant_id.length()==0) this.Msg=Util.getMsg(users,"prg.Flow.Applicant_id");
    if(this.Applicant_name.length()==0) this.Msg=Util.getMsg(users,"prg.Flow.Applicant_name");
    if(this.Msg==null) {
      Flow_detail detail = new Flow_detail();
      if(db_type.equals("insert")){
        if(this.chkPkey()){
          this.Msg=Util.getMsg(users,"jsp.chkData.idError");
        } else {
          this.insert();
          detail.insert(this.FlowKey,this.Details.iterator());          
          rtnFlag=true;
          this.Msg=Util.getMsg(users,"jsp.chkData.insert");
        }
      }
      if(db_type.equals("update")){
      	this.Decider_id = "";
      	this.Decider_name = "";
      	this.Decide_time = "";
        this.update();        
        detail.update(this.FlowKey,this.Details.iterator());
        rtnFlag=true;
        this.Msg=Util.getMsg(users,"jsp.chkData.update");
      }
      if(db_type.equals("delete")){
        this.delete();
        rtnFlag=true;
        this.Msg=Util.getMsg(users,"jsp.chkData.delete");
      }
      detail = null;
    }
    return rtnFlag;
  }
  
  public Iterator<Flow> getSQLList(String SQL) {
	    DB db=null;
	    ResultSet rs=null;
	    Vector<Flow> v=new Vector<Flow>();
	    try {
	      db=new DB();
	      rs=db.executeQuery(SQL);
	      while(rs.next()) {
	        Flow obj=new Flow();
	        obj.setFlowKey(rs.getString("FlowKey"));
	        obj.setFlow_id(rs.getString("Flow_id"));
	        obj.setFlow_name(rs.getString("Flow_name"));
	        obj.setCreater_id(rs.getString("Creater_id"));
	        obj.setCreater_name(rs.getString("Creater_name"));
	        obj.setCreate_time(rs.getString("Create_time"));
	        obj.setApplicant_id(rs.getString("Applicant_id"));
	        obj.setApplicant_name(rs.getString("Applicant_name"));
	        obj.setSigner_id(rs.getString("Signer_id"));
	        obj.setSigner_name(rs.getString("Signer_name"));
	        obj.setSrcSigner_id(rs.getString("SrcSigner_id"));
	        obj.setDecider_id(rs.getString("Decider_id"));
	        obj.setDecider_name(rs.getString("Decider_name"));
	        obj.setDecide_time(rs.getString("Decide_time"));
	        obj.setCloser_id(rs.getString("Closer_id"));
	        obj.setCloser_name(rs.getString("Closer_name"));
	        obj.setClosed_time(rs.getString("Closed_time"));
	        obj.setCloseFlag(rs.getString("CloseFlag"));
	        obj.setTotal_steps(rs.getInt("Total_steps"));
	        obj.setFinished_steps(rs.getInt("Finished_steps"));
	        obj.setStatus(rs.getString("Status"));
	        obj.setForm_tableName(rs.getString("Form_tableName"));
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
  
}