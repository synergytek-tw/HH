package deepspot.daemon;

import java.util.*;
import java.text.*;
import deepspot.util.*;

public class Schedule {
	
	private String groupName;
	private int    scheduleNo;
	private String scheduleName;
	private String scheduleApp;
	private Date   execInitDate;
	private Date   execFinalDate;
	private long   execFr;
	private long   delay;
	
	public Schedule() {
		this.groupName     = new String();//�L�s�զW�٫h�H�ť�
		this.scheduleNo    = 0;           //�L�s���h�H 0
		this.scheduleName  = new String();//�L����W�٫h�H�ť�
		this.scheduleApp   = new String();//�LFQDN�W�٫h�H�ť�
		this.execInitDate  = new Date(0); //�L�_�l�ɶ��h1970�~1��1��0��0��0��
		this.execFinalDate = new Date(0); //�L�����ɶ��h1970�~1��1��0��0��0��
		this.execFr        = 5000;        //�w�]�W�v�� 5 ��
		this.delay         = 0;           //�w�]���ɬ� 0 ��
	}
	
	public Schedule(String scheduleName, String scheduleApp) {
		this(scheduleApp);
		this.scheduleName = scheduleName;
	}
	
	public Schedule(String scheduleApp) {
		this();
		this.scheduleApp = scheduleApp;
	}
	
	public Schedule(Date execFinalDate) {
		this();
		this.execFinalDate = execFinalDate;
	}
	
	public Schedule(long execFr) {
		this();
		this.execFr = execFr;
	}
	
	public Schedule(long execFr, long delay) {
		this(execFr);
		this.execFr = execFr;
	}
	
	public Schedule(Date execInitDate, Date execFinalDate) {
		this(execFinalDate);
		this.execInitDate = execFinalDate;
	}
	
	public Schedule(Date execInitDate, Date execFinalDate, long execFr) {
		this(execInitDate, execFinalDate);
		this.execFr = execFr;
	}
	
	public Schedule(Date execInitDate, Date execFinalDate, long execFr, long delay) {
		this(execInitDate, execFinalDate, execFr);
		this.delay = delay;
	}
  
  /**
     * �]�w(���o)��{�s��
     *
     * @param   scheduleGroup   ��{�s��
     */	
  public synchronized void setGroupName(String groupName) {
  	this.groupName = groupName;
  }
  public synchronized String getGroupName() {
  	return this.groupName;
  }
  
  /**
     * �]�w(���o)��{�s��
     *
     * @param   scheduleNo   ��{�s��
     */	
  public synchronized void setScheduleNo(int scheduleNo) {
  	this.scheduleNo = scheduleNo;
  }
  public synchronized int getScheduleNo() {
  	return this.scheduleNo;
  }
  
  /**
     * �]�w(���o)��{�W��
     *
     * @param   scheduleName   ��{�W��
     */	
  public synchronized void setScheduleName(String scheduleName) {
  	this.scheduleName = scheduleName;
  }
  public synchronized String getScheduleName() {
  	return this.scheduleName;
  }
  
  /**
     * �]�w(���o)��{AP
     *
     * @param   scheduleApp    ��{AP
     */	
  public synchronized void setScheduleApp(String scheduleApp) {
  	this.scheduleApp = scheduleApp;
  }
  public synchronized String getScheduleApp() {
  	return this.scheduleApp;
  }
  
	/**
     * �]�w(���o)����_�l�ɶ�
     *
     * @param   execInitDate   ����_�l�ɶ�
     */	
	public synchronized void setExecInitDate(Date execInitDate){
		this.execInitDate = execInitDate;
	}
	public synchronized void setExecInitDate(String execInitDate) throws ParseException {
		if(execInitDate.equals("")) return;
		this.execInitDate = Util.toDate(execInitDate);
	}
	public synchronized Date getExecInitDate(){
		return this.execInitDate;
	}
	
	/**
     * �]�w(���o)���浲���ɶ�
     *
     * @param   execFinalDate   ���浲���ɶ�
     */
	public synchronized void setExecFinalDate(Date execFinalDate) {
		this.execFinalDate = execFinalDate;
	}
	public synchronized void setExecFinalDate(String execFinalDate) throws ParseException {
		if(execFinalDate.equals("")) return;
		this.execFinalDate = Util.toDate(execFinalDate);
	}
	public synchronized Date getExecFinalDate() {
		return execFinalDate;
	}
    
	/**
     * �]�w(���o)���橵��ɶ�
     *
     * @param   delay   ����}�l����ɶ�
     */
	public synchronized void setDelay(long delay) {
		this.delay = delay;
	}
	public synchronized void setDelay(String delay) throws NumberFormatException {
		if(delay.equals("")) return;
		this.delay = Long.parseLong(delay);
	}
	public synchronized long getDelay() {
		return delay;
	}

	/**
     * �]�w(���o)���涡�j�ɶ�
     *
     * @param   execFr   ����g��
     */
	public synchronized void setExecFr(long execFr) {
		this.execFr = execFr;
	}
	public synchronized void setExecFr(String execFr) throws NumberFormatException {
		if(execFr.equals("")) return;
		this.execFr = Long.parseLong(execFr);
	}
	public synchronized long getExecFr() {
		return execFr;
	}
	
	/**
	 *   ���s�զW��, ��{�s��, ��{�W��, ��{�������ε{��
     * ����� Schedule �O�_�ۦP, �S�w����ۦP�� true, �_�h false
     *
     * @param   obj    �ݤ��������
     */
	public synchronized boolean equalTo(Object obj) {
		boolean flag = true;
		String  groupName      = ((Schedule)obj).getGroupName();
		int     scheduleNo     = ((Schedule)obj).getScheduleNo();
		String  scheduleName   = ((Schedule)obj).getScheduleName();
		String  scheduleApp    = ((Schedule)obj).getScheduleApp();

		if(!this.groupName.equals(groupName))         return false;
		if( this.scheduleNo != scheduleNo)            return false;
		if(!this.scheduleName.equals(scheduleName))   return false;
    if(!this.scheduleApp.equals(scheduleApp))     return false;
    
		return flag;
	}
	
	/**
	 *   ������_�l�ɶ�, �����W�v, ����
     * ����� Schedule ����{�]�w�O�_�ۦP, �S�w����ۦP�� true, �_�h false
     *
     * @param   obj    �ݤ��������
     */
	public synchronized boolean isSameTime(Object obj) {
		boolean flag = true;
		Date    execFinalDate  = ((Schedule)obj).getExecFinalDate();
		Date    execInitDate   = ((Schedule)obj).getExecInitDate();
		long    execFr         = ((Schedule)obj).getExecFr();
		long    delay          = ((Schedule)obj).getDelay();

    if(!this.execInitDate.equals(execInitDate))   return false;
    if(!this.execFinalDate.equals(execFinalDate)) return false;
		if( this.execFr!=execFr)                      return false;
		if( this.delay !=delay)                       return false;

		return flag;
	}

}
