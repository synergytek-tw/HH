package deepspot.main;

import java.sql.ResultSet;
import java.util.Iterator;

import org.dom4j.Element;

import deepspot.basic.Cnstnts;
import deepspot.util.DB;
import deepspot.util.Util;

public class FlowEngin{

  public static void run(String dbAction, String flowKey, String program_id, String creater,  
		  				 String applicant, String tableName, String aliasName) throws Exception {
    Flow flow;
    
    if(dbAction.equals("insert") || dbAction.equals("update")) {
      String flow_id = new Program(program_id).getFlow_id();
      if(flow_id==null || flow_id.trim().length()==0){
    	  flow_id = program_id;
      }
      
      Element flowInfo = Util.getFlowInfo(flow_id);
      if(flowInfo==null || flowInfo.elements().size()==0){
    	  return;
      }
      
      int total_steps = getTotalSteps(flowInfo);
      int finished_step = 0;
      int mastStep = finished_step+1;
      
      boolean skip = getSkip(flowInfo,mastStep);
      while(skip){
        String skipSqlStr = getSkipValueSqlStr(flowInfo,mastStep);
        if(!skipSqlStr.equals("")){
          skipSqlStr = "select * from " + tableName + " where FlowKey='" + flowKey +
                       "' and " + skipSqlStr;
          if(getDecideByValue(skipSqlStr)){
            mastStep++;
            finished_step++;
            skip = getSkip(flowInfo,mastStep);
          } else {
            skip=false;	
          }
        } else {
      	  skip=false;
        }
      }
      
      String SrcSigner_id = getSigner_id(flowInfo,mastStep,tableName,flowKey,applicant);
      boolean chkFlag = getChkFlag(flowInfo,mastStep);
      while(SrcSigner_id.equals(applicant) && chkFlag && total_steps>1){
       	mastStep++;
       	finished_step++;
       	skip = getSkip(flowInfo,mastStep);
        while(skip){
          String skipSqlStr = getSkipValueSqlStr(flowInfo,mastStep);
          if(!skipSqlStr.equals("")){
            skipSqlStr = "select * from " + tableName + " where FlowKey='" + flowKey +
                         "' and " + skipSqlStr;
            if(getDecideByValue(skipSqlStr)){
              mastStep++;
              finished_step++;
              skip = getSkip(flowInfo,mastStep);
              chkFlag = getChkFlag(flowInfo,mastStep);
              if(!chkFlag){
            	  skip = false;
              }
            } else {
              skip=false;	
            }
          } else {
          	skip=false;
          }
        }
        SrcSigner_id = getSigner_id(flowInfo,finished_step+1,tableName,flowKey,applicant);
        chkFlag = getChkFlag(flowInfo,mastStep);
      }
      JobAgent ja = new JobAgent();
      String signer_id = ja.getAgent(SrcSigner_id,Util.getDateTime());
      String tmpSigner = SrcSigner_id;
      while(!tmpSigner.equals(signer_id)){
      	if(signer_id.equals(SrcSigner_id)) break;
        tmpSigner = signer_id;
        signer_id = ja.getAgent(tmpSigner,Util.getDateTime());
      }
      Employee emp = new Employee(signer_id);
      String signer_name = emp.Emp_name.getValue();
      String title = new Category(emp.getTitle()).getNames();
      signer_name += title;
      
      String closer = flowInfo.attributeValue("closer");
      if(closer.equals("applicant")) {
    	closer = applicant;
      } else
      if(closer.equals("creater")) {
    	closer = creater;
      } else {
    	  Sponsor spn = new Sponsor(closer);
        if(spn.getEmp_id().equals("")) {
          closer = getAgentSigner(tableName,closer,flowKey);
          if(closer.equals("")){
            closer = applicant;	
          }
        } else {
          closer = spn.getEmp_id();
        }
      }
      
      emp = new Employee(closer);
      String closer_name = emp.Emp_name.getValue();
      title = new Category(emp.getTitle()).getNames();
      closer_name += title;
      
      emp = new Employee(creater);
      String creater_name = emp.Emp_name.getValue();
      title = new Category(emp.getTitle()).getNames();
      creater_name += title;
      
      emp = new Employee(applicant);
      String applicant_name = emp.Emp_name.getValue();
      title = new Category(emp.getTitle()).getNames();
      applicant_name += title;
      
      emp = null;
            
      flow = new Flow();
      flow.setFlowKey(flowKey);      
      flow.setFlow_id(flow_id);
      if(aliasName.trim().length()>0){
    	  aliasName = "-"+aliasName;
      }
      flow.setFlow_name(flowInfo.attributeValue("name")+aliasName);
      flow.setCreater_id(creater);
      flow.setCreater_name(creater_name);
      flow.setCreate_time(Util.getDateTime());
      flow.setApplicant_id(applicant);
      flow.setApplicant_name(applicant_name);
      flow.setCloser_id(closer);
      flow.setCloser_name(closer_name);
      flow.setSigner_id(signer_id);
      flow.setSigner_name(signer_name);
      flow.setSrcSigner_id(SrcSigner_id);
      flow.setStatus("signing");
      flow.setFinished_steps(finished_step);
      flow.setTotal_steps(total_steps);
      flow.setForm_tableName(tableName);
      
      flow.chkData();
      if(dbAction.equals("insert")) {
        flow.insert();
      } else {
        flow.update();
        Flow_detail fd = new Flow_detail(flowKey);
        fd.delete(flowKey);
        fd.chkData();
        fd.setSeq_no(0);
        fd.setStep(0);
        fd.setStep_name(Util.getMsg(new Account(applicant).getLanguage(), "jsp.closeForm.update"));
        fd.setSigner_id(applicant);
        fd.setSigner_name(applicant_name);
        fd.setSigned_time(Util.getDateTime());
        if(!fd.getFlowKey().equals(""))
          fd.insert();
        fd = null;
      }
      flow = null;
    }
  }
  
  public static void run(Flow_detail fd) throws Exception {
    String flowKey = fd.getFlowKey();
    Flow flow = new Flow(flowKey);
    Element flowInfo = Util.getFlowInfo(flow.getFlow_id());
    int detailStep = flow.getFinished_steps()+1;
    int mastStep = detailStep + 1;
    String tableName = flow.getForm_tableName();
    
    boolean skip = getSkip(flowInfo,mastStep);
    while(skip){
      String skipSqlStr = getSkipValueSqlStr(flowInfo,mastStep);
      if(!skipSqlStr.equals("")){
        skipSqlStr = "select * from " + tableName + " where FlowKey='" + flowKey +
                     "' and " + skipSqlStr;
        if(getDecideByValue(skipSqlStr)){
          mastStep++;
          skip = getSkip(flowInfo,mastStep);
        } else {
          skip=false;	
        }
      } else {
      	skip=false;
      }
    }
    
    int total_step = flow.getTotal_steps();
    String sqlStr = getSqlStr(flowInfo,detailStep);
    boolean decideByValue = false;
    boolean canApprove = true;
    boolean lookCanApprove = getLookCanApprove(flowInfo,detailStep);
    if(lookCanApprove){
      canApprove = getCanApprove(flowInfo,detailStep,flow.getApplicant_id());
    }
    
    if(sqlStr.length()>0) {
      sqlStr = "select * from " + tableName + " where FlowKey='" + flowKey +
               "' and " + sqlStr;
      //System.out.println(sqlStr);
      decideByValue=getDecideByValue(sqlStr);
    }
    String SrcSigner_id = "";
    if(mastStep <= total_step) {
      SrcSigner_id = getSigner_id(flowInfo, mastStep, flow.getForm_tableName(),
                               flowKey, flow.getApplicant_id());
      boolean chkFlag = getChkFlag(flowInfo,mastStep);
      while(SrcSigner_id.equals(flow.getApplicant_id()) && chkFlag){
      	mastStep++;
      	skip = getSkip(flowInfo,mastStep);
        while(skip){
          String skipSqlStr = getSkipValueSqlStr(flowInfo,mastStep);
          if(!skipSqlStr.equals("")){
            skipSqlStr = "select * from " + tableName + " where FlowKey='" + flowKey +
                         "' and " + skipSqlStr;
            if(getDecideByValue(skipSqlStr)){
              mastStep++;
              skip = getSkip(flowInfo,mastStep);
            } else {
              skip=false;	
            }
          } else {
          	skip=false;
          }
        }
        SrcSigner_id = getSigner_id(flowInfo,mastStep,flow.getForm_tableName(),
                                 flowKey, flow.getApplicant_id());
      }
    }
    JobAgent ja = new JobAgent();
    String signer_id = ja.getAgent(SrcSigner_id,Util.getDateTime());
    String tmpSigner = SrcSigner_id;
    while(!tmpSigner.equals(signer_id)){
      if(signer_id.equals(SrcSigner_id)) break;
      tmpSigner = signer_id;
      signer_id = ja.getAgent(tmpSigner,Util.getDateTime());
    }
    boolean decide = false;
    if(fd.getDecided().equals("1")) decide = true;
    
    String status = flow.getStatus();
    String sign_result = fd.getSigned_result();
    if(sign_result.equals("reject")) {
      status = "reject";
      signer_id = "";
      SrcSigner_id = "";
    }
    if(sign_result.equals("agree")) {
      if(decide || detailStep>=total_step || (decideByValue && canApprove)) {
      	status = "approve";
        signer_id = "";
        SrcSigner_id = "";
      }
    }
    Employee emp = new Employee(signer_id);
    String signer_name = emp.Emp_name.getValue();
    String title = new Category(emp.getTitle()).getNames();
    emp = null;
    signer_name += title;
    flow.setSigner_id(signer_id);
    flow.setSrcSigner_id(SrcSigner_id);
    flow.setSigner_name(signer_name);
    flow.setFinished_steps(mastStep-1);
    flow.setStatus(status);
    if(status.equals("reject") || status.equals("approve")) {
      if(status.equals("approve")){
        flow.setTotal_steps(flow.getFinished_steps());
      }
      flow.setDecider_id(fd.getSigner_id());
      flow.setDecider_name(fd.getSigner_name());
      flow.setDecide_time(Util.getDateTime());
      fd.setDecided("1");
      fd.setSigned_result(status);
    }
      
    fd.setSeq_no(detailStep);
    fd.setStep(detailStep);
    fd.setStep_name(getStep_name(flowInfo,detailStep));
    
    fd.insert();
    flow.update();
  }
  
  private static String getSqlStr(Element flowInfo, int step) {
    Iterator<?> elementItr = flowInfo.elementIterator();
    String sqlStr = "";
    while(elementItr.hasNext()) {
      Element e = (Element)elementItr.next();
      if(Integer.parseInt(e.attributeValue("id"))==step) {
        sqlStr = e.attributeValue("decideByValue");
        if(sqlStr==null) sqlStr = "";
        break;
      }
    }
    return sqlStr;
  }
  
  private static String getSkipValueSqlStr(Element flowInfo, int step) {
    Iterator<?> elementItr = flowInfo.elementIterator();
    String sqlStr = "";
    while(elementItr.hasNext()) {
      Element e = (Element)elementItr.next();
      if(Integer.parseInt(e.attributeValue("id"))==step) {
        sqlStr = e.attributeValue("skipValue");
        if(sqlStr==null) sqlStr = "";
        break;
      }
    }
    return sqlStr;
  }
  
  public static String getStep_name(Element flowInfo, int step) {
    Iterator<?> elementItr = flowInfo.elementIterator();
    String step_name = "";
    while(elementItr.hasNext()) {
      Element e = (Element)elementItr.next();
      if(Integer.parseInt(e.attributeValue("id"))==step) {
        step_name = e.attributeValue("desc");
        break;
      }
    }
    return step_name;
  }
  
  private static boolean getLookCanApprove(Element flowInfo, int step) {
    Iterator<?> elementItr = flowInfo.elementIterator();
    boolean rtnFlag = false;
    while(elementItr.hasNext()) {
      Element e = (Element)elementItr.next();
      if(Integer.parseInt(e.attributeValue("id"))==step) {
      	String lookCanApprove = e.attributeValue("lookCanApprove");
      	if(lookCanApprove == null) lookCanApprove = "";
        if(lookCanApprove.equals("yes")) rtnFlag = true;
        break;
      }
    }
    return rtnFlag;
  }
  
  private static String getLookCanApproveSigner(Element flowInfo, int step, String applicant, String deptId) {
    Iterator<?> elementItr = flowInfo.elementIterator();
    String rtnSigner = "";
    if(applicant.equals("") || deptId.equals("")) return rtnSigner;
    while(elementItr.hasNext()) {
      Element e = (Element)elementItr.next();
      if(Integer.parseInt(e.attributeValue("id"))==step) {
      	String lookCanApprove = e.attributeValue("lookCanApprove");
      	if(lookCanApprove == null) lookCanApprove = "";
        if(lookCanApprove.equals("untilCanApproveSigner")) {
          if(deptId.equals("applicant")){
            deptId = new Employee(applicant).Dept_id.getValue();
          }
          boolean findSigner = true;
          if(deptId.equals("")) findSigner=false;
          while(findSigner){
            Department dptObj = new Department(deptId);
            String canApprove = dptObj.getCanApprove();
            if(canApprove.equals("Y") && !dptObj.getSigner_Emp_id().equals(applicant)){
              rtnSigner = dptObj.getSigner_Emp_id();
              findSigner = false;	
            } else {
              deptId = dptObj.getParent_id();
              if(deptId.equals("")) findSigner = false;
            }
          }
          if(rtnSigner.equals(applicant) && findSigner)
            getLookCanApproveSigner(flowInfo, step, applicant, deptId);
        } else {
          if(deptId.equals("applicant")) {
            rtnSigner = new Department(new Employee(applicant).Dept_id.getValue()).getSigner_Emp_id();
          } else {
            rtnSigner = new Department(deptId).getSigner_Emp_id();
          }	
        }
        break;
      }
    }
    return rtnSigner;
  }
  
  private static String getSigner_id(Element flowInfo, int step, String tableName, 
                                                       String flowKey, String applicant) {
    Iterator<?> elementItr = flowInfo.elementIterator();
    String signer_id = "";
    while(elementItr.hasNext()) {
      Element e = (Element)elementItr.next();
      if(Integer.parseInt(e.attributeValue("id"))==step) {
        String signer_type = e.attributeValue("signer_type");
        if(signer_type==null) signer_type = "";
        
        String dept = e.attributeValue("dept");
        if(dept==null) dept = "";
        
        String Sponsor_id = e.attributeValue("Sponsor_id");
        if(Sponsor_id==null) Sponsor_id = "";
                 
        String Sponsor_table = e.attributeValue("Sponsor_table");
        if(Sponsor_table==null) Sponsor_table = "";
        
        String Sponsor_field = e.attributeValue("Sponsor_field");
        if(Sponsor_field==null) Sponsor_field = "";
        
        if(signer_type.equals("agent")){
          signer_id = getAgentSigner(tableName,e.attributeValue("field_name"),flowKey);
        }
        if(signer_type.equals("dept_manager")){
          signer_id = getLookCanApproveSigner(flowInfo, step, applicant, dept);
        }
        if(signer_type.equals("Sponsor")){
          /*
          if(Sponsor_table.equals("BudgetSubject")){
            String seqStr = "select " + Sponsor_field + " from " + tableName + 
                            " where FlowKey = '" + flowKey + "'";
            String idValue = getIdValue(seqStr,Sponsor_field);
            BudgetSubject bsObj = new BudgetSubject();
            signer_id = bsObj.getSponsor(idValue);
          }
          */
          Sponsor spn = new Sponsor(Sponsor_id);
          if(signer_id.equals("")) signer_id = spn.getEmp_id();
        }
        if(signer_type.equals("dept_member")){
          signer_id = e.attributeValue("member_id");
        }
        break;
      }
    }
    return signer_id;
  }
  
  private static boolean getCanApprove(Element flowInfo, int step,String applicant) {
    Iterator<?> elementItr = flowInfo.elementIterator();
    boolean rtnFlag = true;
    while(elementItr.hasNext()) {
      Element e = (Element)elementItr.next();
      if(Integer.parseInt(e.attributeValue("id"))==step) {
        String signer_type = e.attributeValue("signer_type");
        String dept = e.attributeValue("dept");
        if(signer_type.equals("dept_manager")){
          String canApproveValue = "";
          if(dept.equals("applicant")) {
            canApproveValue = new Department(new Employee(applicant).Dept_id.getValue()).getCanApprove();
          } else {
            canApproveValue = new Department(dept).getCanApprove();
          }
          if(canApproveValue.equals("Y")) rtnFlag = true;
          else rtnFlag = false;
        }
        break;
      }
    }
    return rtnFlag;
  }
  
  private static boolean getSkip(Element flowInfo, int step) {
    Iterator<?> elementItr = flowInfo.elementIterator();
    boolean rtnFlag = false;
    while(elementItr.hasNext()) {
      Element e = (Element)elementItr.next();
      if(Integer.parseInt(e.attributeValue("id"))==step) {
        String skip = e.attributeValue("skip");
        if(skip==null) skip = "";
        if(skip.equals("yes")){
          rtnFlag = true;
        }
        break;
      }
    }
    return rtnFlag;
  }
  
  private static int getTotalSteps(Element flowInfo) {
    Iterator<?> elementItr = flowInfo.elementIterator();
    int steps = 0;
    while(elementItr.hasNext()) {
      elementItr.next();
      steps++;
    }
    return steps;
  }
  
  private static String getPkeyNo(String beginWord,int noLength) {   
    DB db;
    ResultSet rs;
    String pkey = beginWord + Util.getDate("");
    String selectStr = "select no from pkeyNo where pkey='" + pkey + "'";
    String sqlStr;
    int no;
    try {
      db = new DB();
      rs = db.executeQuery(selectStr);
      if(rs.next()) {
      	no = rs.getInt("no") + 1;
      	sqlStr = "update pkeyNo set no=" + no + " where pkey='" + pkey + "'";
      } else {
      	no = 1;
      	sqlStr = "insert into pkeyNo(pkey,no) values('" + pkey + "',1)";
      }
      rs.close();
      db.executeUpdate(sqlStr);
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    } finally {
      rs = null;
      db = null;
    }
    return pkey + "." + Util.n2s(no,noLength);
  }
  
  private static String getAgentSigner(String tableName, String fieldName, String flowKey) {   
    DB db;
    ResultSet rs;
    String rtnStr = "";
    String selectStr = "select "+fieldName+" from " + tableName + " where FlowKey='" + flowKey + "'";
    try {
      db = new DB();
      rs = db.executeQuery(selectStr);
      if(rs.next()) {
      	rtnStr = rs.getString(fieldName);
      }
      rs.close();
      db.close();
    } catch(Exception e) {
      System.out.println("FlowEngin.getAgentSigner() DB error: "+selectStr);
    } finally {
      rs = null;
      db = null;
    }
    return rtnStr;
  }
  
  private static boolean getDecideByValue(String sqlStr) {   
    DB db;
    ResultSet rs;
    boolean rtnFlag = false;
    try {
      db = new DB();
      rs = db.executeQuery(sqlStr);
      if(rs.next()) {
      	rtnFlag = true;
      }
      rs.close();
      db.close();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      rs = null;
      db = null;
    }
    return rtnFlag;
  }
  
  public static String getFlowKey(String program_id) {
    Program p = new Program(program_id);
    String beginWord = p.getBeginWord();
    int endNoLength = p.getEndNoLength();
    
    if(beginWord.trim().length()>0 && endNoLength>0)
      return getPkeyNo(beginWord,endNoLength);
    else
      return Cnstnts.EMPTY_STRING;
  }
  
  public static boolean getRunFlag(String program_id) {
    Program prog = new Program(program_id);
    if(prog.getUseFlow().equals("1") && prog.getFlow_id().trim().length()>0) 
    	return true;
    else 
    	return false;
  }
  
  public static boolean getDecideFlag(String flowKey) throws Exception {
    if(flowKey==null) flowKey=Cnstnts.EMPTY_STRING;;
    boolean rtnFlag = false;
    Flow flow = new Flow(flowKey);
    String flow_id = flow.getFlow_id();
    int finished_steps = flow.getFinished_steps();
    Element flowInfo = Util.getFlowInfo(flow_id);
    if(flowInfo!=null){
      for(Iterator<?> itr=flowInfo.elementIterator();itr.hasNext();) {
        Element e = (Element)itr.next();
        int step = Integer.parseInt(e.attributeValue("id"));
        if(step == finished_steps+1) {
          String decide = e.attributeValue("decide");
          if(decide!=null) {
            if(decide.equals("yes")) rtnFlag = true;
          }
          break;
        }
      }
    }
    return rtnFlag;
  }
  
  public static boolean getUpdateFlag(String flowKey) throws Exception {
    boolean rtnFlag = true;
    Flow flow = new Flow();
    flow.setFlowKey(flowKey);
    flow.getAttribute();
    if(flow.getStatus().equals("approve") || flow.getClosed_time().length()!=0) 
    	rtnFlag = false;
    return rtnFlag;
  }
  
  private static boolean getChkFlag(Element flowInfo, int step) throws Exception {
    boolean rtnFlag = true;
    Iterator<?> itr = flowInfo.elementIterator();
    int flowStep = 0;
    while(itr.hasNext()){
      flowStep++;
      Element e = (Element)itr.next();
      if(flowStep==step){
      	String checkSelf = e.attributeValue("checkSelf");
      	if(checkSelf==null) checkSelf="";
        if(checkSelf.equals("no")) rtnFlag = false;
      }
    }
    return rtnFlag;
  }
  
}