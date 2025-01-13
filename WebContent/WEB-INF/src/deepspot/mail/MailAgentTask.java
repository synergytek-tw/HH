package deepspot.mail;

import java.util.*;
import java.text.*;
import deepspot.main.*;
import deepspot.util.*;
import deepspot.daemon.*;
import com.deepspot.mail.EZMail;

public class MailAgentTask extends TimerTask {
	
	public MailAgentTask() {
		super();
	}
	
	public MailAgentTask(Object obj, Object obj_detail) {
		this();
		this.config = (MailThreadConfig)obj;
		this.detail     = (MailThreadConfig_detail)obj_detail;
	}
	
	private MailThreadConfig config;
	private MailThreadConfig_detail detail;
	public void run() {
  	System.out.println("(3)Sub Mail Action");
  	String keyValue = this.config.getKeyValue();
  	List<Integer>   seqNos   = new ArrayList<Integer>();
  	String host     = this.config.getHost();
  	String alias    = this.config.getEmailAddress();
  	String account  = this.config.getEmailAccount();
  	String password = this.config.getPassword();
  	List<String>   logs     = new ArrayList<String>();
  	
  	int    seqNo      = detail.getSeq_no();
  	String mailTime   = detail.getMailTime();  
  	String mailTo     = detail.getMailTo();    
  	String CCTo       = detail.getCCTo();      
  	String BCCTo      = detail.getBCCTo();     
  	String title      = detail.getTitle();     
  	String content    = detail.getContent();   
  	String attachFile = detail.getAttachFile();
  	if(!attachFile.trim().equals("")) attachFile = treatPath(attachFile);
  	System.out.println(attachFile);
    try {

  	  System.out.println("(4)Theat mail schedule");
  	  
  	  
  	  // �N�Ҧ��T���զX����@��r��, �é�J���X��
  	  StringBuffer sb   = new StringBuffer();
  	  sb.append(Util.getDateTime()).append("#["); 
  	  sb.append(mailTo).append("#");    
  	  sb.append(CCTo).append("#");      
  	  sb.append(BCCTo).append("]#[");   
  	  sb.append(title).append("]#[");   
  	  sb.append(content).append("]#["); 
  	  sb.append(attachFile).append("]");

  	  if( chkTime(mailTime) || mailTo.trim().equals("") ) {
  	  	
  	  	new EZMail(host,account,alias,password);
  	  	EZMail.setEmailAddress(mailTo);
  	  	if(!CCTo.trim().equals("")) EZMail.setCC(CCTo);
  	  	if(!BCCTo.trim().equals("")) EZMail.setBCC(BCCTo);
  	  	if(!title.trim().equals("")) EZMail.setSubject(title);
  	  	if(!content.trim().equals("")) EZMail.setContent(content);
  	  	if(!attachFile.trim().equals("")) EZMail.setAttachFile(attachFile);
  	  	EZMail.send();
  	  	EZMail.close();
  	  	logs.add(sb.toString());
  	  	seqNos.add(new Integer(seqNo));
  	  	
  	  }//end if
  	  	
  	} catch(Exception e) {
  		e.printStackTrace();
  		unlock(keyValue,seqNo);
  	} finally {
  		
  	  if(!logs.isEmpty()) {
  	  	this.log_detail(keyValue,logs);
  	  	logs.clear();
  	  }
  	  if(!seqNos.isEmpty()) {
    	  new MailThreadConfig_detail().delete(keyValue,seqNos);
    	  seqNos.clear();
      }
      
  	}

  }
  
  private boolean chkTime(String mailTime) {
  	if(mailTime.trim().equals("") || mailTime== null) return true;
  	boolean flag  = false;
  	Date dateMail = null;
  	Date dateNow  = new Date(System.currentTimeMillis());
  	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	try {
  		dateMail = sdf.parse(mailTime);
  		sdf.set2DigitYearStart(dateMail);
  	} catch(Exception e) {
  		e.printStackTrace();
  	}
  	flag = dateMail.before(dateNow) ? true : false ; 
  	return flag;
  }

  /*TODO*/
  private String treatPath(String paths) {
  	String path  = ScheduleManagerServlet.ctx.getRealPath("/").replaceAll("\\\\","/");
  	return (path + paths);
  }
  
  private void log_detail(String keyValue,List<String> logs) {
  	Vector<MailLog_detail> vt = new Vector<MailLog_detail>();
  	MailLog_detail mLog_detail = null;
  	for(int i=0;i<logs.size();i++) {
  		mLog_detail = new MailLog_detail();
  		mLog_detail.setLogDetail((String)logs.get(i));
  		vt.add(mLog_detail);
  	}
  	mLog_detail.insert(keyValue,vt.iterator());
  }
  
  private void unlock(String keyValue,int seqNo) {
  	detail.update(keyValue,seqNo,"Scheduled","N");
  }

}