package deepspot.mail;

import java.util.*;
import java.text.*;
import deepspot.main.*;
import deepspot.util.*;

public class MailTask extends TimerTask {
	
	private HashMap<String, Timer>  hm;

  public void run() {
  	System.out.println("(1)Mail Task Begin");

    MailAgentTask task;
	  Timer    timer ;
    String   keyValue         = "";
    @SuppressWarnings("unused")
	String   delayTime        = "";
    String   mailPeriod       = "";
    String   lastExecuteTime  = "";
    String   nextExecuteTime  = "";
    String   turnOn           = "";

    Iterator<?> it = new MailThreadConfig().getList();
    hm = new HashMap<String, Timer>();
    
		while( it.hasNext() ) {
			MailThreadConfig obj = (MailThreadConfig)it.next();
			keyValue        = obj.getKeyValue();
			lastExecuteTime = obj.getLastExecuteTime();
			nextExecuteTime = obj.getNextExecuteTime();
			delayTime       = obj.getDelayTime();
			mailPeriod      = obj.getMailPeriod();
			turnOn          = obj.getTurnOn();

      if( turnOn.trim().equals("Y") ) {
      	Vector<?> objs_detail   = new MailThreadConfig_detail().getDetails(keyValue);
      	System.out.println(keyValue + "(2-1)Service is turn on");
      	
      	if(!objs_detail.isEmpty()) {
      		for(Iterator<?> it_=objs_detail.iterator();it_.hasNext(); ) {
      			MailThreadConfig_detail obj_detail = (MailThreadConfig_detail)it_.next();
      			if(this.chkTime(obj_detail.getMailTime())&& !obj_detail.getScheduled().equals("Y")) {
      				lock(obj_detail);
      				if(hm.containsKey(keyValue)) {
      					timer = (Timer)hm.get(keyValue);
      				} else {
      			    //timer = new Timer(keyValue);
      			    timer = new Timer();
      			  }
      	      task  = new MailAgentTask(obj,obj_detail);
      	      timer.schedule(task,toDigitDate(nextExecuteTime).getTime());
      	      hm.put(keyValue, timer);
      	    }
      		}
      	  
      	}
      	//��s�]�w��
      	String [] executeTime = 
      	reComputeTime(mailPeriod,lastExecuteTime,nextExecuteTime);
        updateMailThreadConfig(keyValue, executeTime[0],executeTime[1]);
      	
      } else {
      	System.out.println(keyValue + "(2-2)Service is turn off");
      	if(hm.containsKey(keyValue)) {
      	  timer = (Timer)hm.get(keyValue);
      	  hm.remove(keyValue);
      	  if(timer != null) {
      	  	timer.cancel();
      	  	//timer.purge() ;
      	  	timer = null;
      	  }
      	}
      
      }
    
		}

	}
	
	private Calendar toDigitDate(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		@SuppressWarnings("unused")
		ParsePosition pp = new ParsePosition(0);
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		try {
			date = sdf.parse(time);
			sdf.set2DigitYearStart(date);
			calendar = sdf.getCalendar();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return calendar;
	}
	
	private void updateMailThreadConfig(String keyValue,String lastExecuteTime,String nextExecuteTime) {
		MailThreadConfig config = new MailThreadConfig(keyValue);
		config.getAttribute();
		config.setLastExecuteTime(lastExecuteTime);
		config.setNextExecuteTime(nextExecuteTime);
		config.update();
	}


	private String[] reComputeTime(String mailPeriod,String lastExecuteTime,String nextExecuteTime) {
    
		long period  = Long.parseLong(mailPeriod)*60*1000;
		long next    = toDigitDate(nextExecuteTime).getTimeInMillis();
		long now     = System.currentTimeMillis();
		Date d_next  = new Date(next);
		Date d_now   = new Date(now);
		if(d_next.before(d_now)) {
			lastExecuteTime = this.setTime(now);
			nextExecuteTime = this.setTime((long)(now + period));
		}
		System.out.println("LastExec: " + lastExecuteTime);
    System.out.println("NextExec: " + nextExecuteTime);
    return new String[]{lastExecuteTime,nextExecuteTime};
	}
	
	private String setTime(long time) {
		GregorianCalendar gc = new GregorianCalendar();
  	gc.setTimeInMillis(time);
  	String tmpTime = 
  	gc.get(Calendar.YEAR)                    + "-" + 
  	Util.n2s((gc.get(Calendar.MONTH)+1),2)   + "-" + 
  	Util.n2s(gc.get(Calendar.DATE),2)        + " " +
  	Util.n2s(gc.get(Calendar.HOUR_OF_DAY),2) + ":" + 
  	Util.n2s(gc.get(Calendar.MINUTE),2)      + ":" + 
  	Util.n2s(gc.get(Calendar.SECOND),2);
  	return tmpTime;
	}
	
	private boolean chkTime(String mailTime) {
  	if(mailTime.trim().equals("") || mailTime== null) return true;
  	boolean flag  = false;
  	Date dateMail = null;
  	Date dateNow  = new Date(System.currentTimeMillis());
  	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	@SuppressWarnings("unused")
	ParsePosition pp = new ParsePosition(0);
  	try {
  		dateMail = sdf.parse(mailTime);
  		sdf.set2DigitYearStart(dateMail);
  	} catch(Exception e) {
  		e.printStackTrace();
  	}
  	flag = dateMail.before(dateNow) ? true : false ; 
  	return flag;
  }
  
  private void lock(Object obj_detail) {
  	MailThreadConfig_detail tmp = (MailThreadConfig_detail)obj_detail;
  	tmp.update(tmp.getKeyValue(),tmp.getSeq_no(),"Scheduled","Y");
  }

}