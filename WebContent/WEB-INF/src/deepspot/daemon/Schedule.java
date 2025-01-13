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
		this.groupName     = new String();//無群組名稱則以空白
		this.scheduleNo    = 0;           //無編號則以 0
		this.scheduleName  = new String();//無中文名稱則以空白
		this.scheduleApp   = new String();//無FQDN名稱則以空白
		this.execInitDate  = new Date(0); //無起始時間則1970年1月1日0時0分0秒
		this.execFinalDate = new Date(0); //無結束時間則1970年1月1日0時0分0秒
		this.execFr        = 5000;        //預設頻率為 5 秒
		this.delay         = 0;           //預設延時為 0 秒
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
     * 設定(取得)行程群組
     *
     * @param   scheduleGroup   行程群組
     */	
  public synchronized void setGroupName(String groupName) {
  	this.groupName = groupName;
  }
  public synchronized String getGroupName() {
  	return this.groupName;
  }
  
  /**
     * 設定(取得)行程編號
     *
     * @param   scheduleNo   行程編號
     */	
  public synchronized void setScheduleNo(int scheduleNo) {
  	this.scheduleNo = scheduleNo;
  }
  public synchronized int getScheduleNo() {
  	return this.scheduleNo;
  }
  
  /**
     * 設定(取得)行程名稱
     *
     * @param   scheduleName   行程名稱
     */	
  public synchronized void setScheduleName(String scheduleName) {
  	this.scheduleName = scheduleName;
  }
  public synchronized String getScheduleName() {
  	return this.scheduleName;
  }
  
  /**
     * 設定(取得)行程AP
     *
     * @param   scheduleApp    行程AP
     */	
  public synchronized void setScheduleApp(String scheduleApp) {
  	this.scheduleApp = scheduleApp;
  }
  public synchronized String getScheduleApp() {
  	return this.scheduleApp;
  }
  
	/**
     * 設定(取得)執行起始時間
     *
     * @param   execInitDate   執行起始時間
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
     * 設定(取得)執行結束時間
     *
     * @param   execFinalDate   執行結束時間
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
     * 設定(取得)執行延遲時間
     *
     * @param   delay   執行開始延遲時間
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
     * 設定(取得)執行間隔時間
     *
     * @param   execFr   執行週期
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
	 *   比對群組名稱, 行程編號, 行程名稱, 行程所屬應用程式
     * 比對兩個 Schedule 是否相同, 特定條件相同為 true, 否則 false
     *
     * @param   obj    待比較的物件
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
	 *   比對執行起始時間, 執行頻率, 延時
     * 比對兩個 Schedule 的行程設定是否相同, 特定條件相同為 true, 否則 false
     *
     * @param   obj    待比較的物件
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
