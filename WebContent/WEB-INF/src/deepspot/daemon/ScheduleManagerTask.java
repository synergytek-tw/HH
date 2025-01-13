package deepspot.daemon;

import java.util.*;

import deepspot.main.*;
import java.text.*;

public class ScheduleManagerTask extends TimerTask {
	Timer timer;
	public ScheduleManagerTask() {
		super();
		timer = ScheduleManagerServlet.getTimer();
	}

	public void run() {
		//�ˬd��{�O�_���, �ð��B�m
	  removeOverTimeSchedule();
		
		//�ˬd��{��O�_�Q�ק�L
		if( chkModified() ) {
			try {
			  //�M���ª���{
			  Schedules.getInstance().removeSchedule();
		    //���s��J��{
		    this.setSchedule(loadAllSchedule());
		    //���s�]�w�̫�ק�ɶ�
		    this.setModified();
		  } catch(ClassNotFoundException e) {
		  	e.printStackTrace();
		  } catch(InstantiationException e) {
		  	e.printStackTrace();
		  } catch(IllegalAccessException e) {
		  	e.printStackTrace();
		  } catch(ParseException e) {
		  	e.printStackTrace();
		  } finally {
		  }
		}
		
	}
	
	private synchronized boolean chkModified() {
		Schedules schedules = Schedules.getInstance();
		Date lstModified = schedules.getLstModified();
		Date newModified = schedules.getNewModified();
		return schedules.chkModified(lstModified, newModified);
	}
	
	private synchronized void setModified() {
		Schedules schedules = Schedules.getInstance();
		Date now = new Date();
		schedules.setLstModified(now);
		schedules.setNewModified(now);
	}

	private synchronized void removeOverTimeSchedule() {
		Schedules schedules = Schedules.getInstance();
	  schedules.removeOverTimeSchedule();
	}
	
	/**��J�Ҧ���{���O*/
  private synchronized HashMap<String, Vector<?>> loadAllSchedule() {
  	Iterator<?> it = new ScheduleManager().getList();
  	HashMap<String, Vector<?>>  hm = new HashMap<String, Vector<?>>();
  	while(it.hasNext()) {
  		ScheduleManager tmp = (ScheduleManager)it.next();
  		String keyValue = tmp.getKeyValue();
  		Vector<?> vt = loadSchedule(keyValue);
  		hm.put(keyValue,vt);
  	}
  	return hm;
  }
  
  /**��J�S�w keyValue ����{*/
	private synchronized Vector<?> loadSchedule(String keyValue) {
		ScheduleManager_detail scheduleLst = new ScheduleManager_detail();
		Vector<?> vt = scheduleLst.getDetails(keyValue);
		return vt;
	}
	
	/**�]�w��{��*/
	private synchronized void setSchedule(HashMap<?, ?> allScheduleData) throws
	    ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
	    	
		for(Iterator<?> it=allScheduleData.keySet().iterator();it.hasNext();) {
			String keyValue     = (String)it.next();
			Vector<?> allSchedules = (Vector<?>)allScheduleData.get(keyValue);
			for(int i=0;i<allSchedules.size();i++) {
				ScheduleManager_detail tmp = (ScheduleManager_detail)allSchedules.get(i);
				Schedules schedules        = Schedules.getInstance();
				Schedule  schedule         = new Schedule();
				int    seqNo             = tmp.getSeq_no();
			  String scheduleName      = tmp.getScheduleName();
			  String scheduleApp       = tmp.getScheduleApp();
			  String scheduleInitDate  = tmp.getScheduleInitDate();
			  String scheduleFinalDate = tmp.getScheduleFinalDate();
			  String scheduleRate      = tmp.getScheduleRate();
			  schedule.setGroupName(keyValue);
			  schedule.setScheduleNo(seqNo);
			  schedule.setScheduleName(scheduleName);
			  schedule.setScheduleApp(scheduleApp);
			  schedule.setExecInitDate(scheduleInitDate);
			  schedule.setExecFinalDate(scheduleFinalDate);
			  schedule.setExecFr(scheduleRate);

				if( !schedules.chkOverTime(schedule) && !schedules.containsSchedule(schedule)) {

					Class<?> c = Class.forName(scheduleApp);
					if(c.newInstance() instanceof TimerTask) {
						TimerTask task = (TimerTask)c.newInstance();
						timer.schedule(task,schedule.getExecInitDate(),schedule.getExecFr()*1000);
						schedules.setSchedule(task,schedule);
						System.out.println("set task="+task+",schedule="+schedule);
					}
				/**
				} else if(schedules.chkOverTime(schedule) && schedules.containsSchedule(schedule)) {
          System.out.println("�O�ɥB�s�b����{:" + schedule);          	
          */
				} else {
					
				}
				
			}
		}
	}

}
