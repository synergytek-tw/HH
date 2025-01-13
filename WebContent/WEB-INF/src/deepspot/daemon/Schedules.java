/*
 * @(#)Schedules.java	1.0 2006/07/05
 * @author  Monte Liao
 * @version 1.0 , 2006/07/05
 */
package deepspot.daemon;

import java.util.*;

public class Schedules {
	
	private HashMap<Object, Schedule> schedules;
	private Date    lstModified;
	private Date    newModified;
	private static Schedules instance = new Schedules();
	
	private Schedules() {
		HashMap<Object, Schedule> hashMap = new HashMap<Object, Schedule>();
		this.schedules = hashMap;
	}
	
	/**
     * ��o Schedule �� instance
     *
     */
	public synchronized static Schedules getInstance() {
		return instance;
	}
	
	/**
     * �]�w�S�w��Ȫ� Schedule
     *
     * @param   job        instance of job(Timer or TimerTask)
     * @param   schedule   instance of Schedule
     */	
	public synchronized void setSchedule(Object job, Schedule schedule) {
		this.schedules.put(job,schedule);
	}
	
	/**
     * ��o�S�w��Ȫ� Schedule
     *
     * @param   job        instance of job(Timer or TimerTask)
     */	
	public synchronized Schedule getSchedule(Object job) {
        return (Schedule)this.schedules.get(job);
	}
	
	/**
     * ��o�Ҧ��� Schedule
     *
     */	
	public synchronized Object[] getSchedule() {
		    if(!this.schedules.values().isEmpty()) {
		    	return this.schedules.values().toArray();
		    }
  		  return null;
	}
	
	/**
     * @TODO ��o�S�w Schedule �� Job 
     *
     * @param   schedule   instance of Schedule
     */
	public synchronized Object[] getJobs(Schedule schedule) {
		Vector<Object> jobs = new Vector<Object>();
		for(Iterator<Object> it = schedules.keySet().iterator();it.hasNext();) {
			Object job = it.next();
			if(schedule.equalTo(this.getSchedule(job))) jobs.add(job);
		}
		return jobs.toArray();
	}
	
	/**
     * ��o�Ҧ����� Job(Timer or Task)
     *
     */
	public synchronized Object[] getJobs() {
		return this.schedules.keySet().toArray();
	}
	
	/**
     * �����Ҧ�����Ȥ� Schedule
     *
     */	
	public synchronized void removeSchedule() {
		Object[] jobs = this.getJobs();
		for(int i=0;i<jobs.length;i++) {
			this.removeSchedule(jobs[i]);
		}
	}
	
	/**
     * �����S�w��ȤΨ� Schedule
     *
     * @param   job        instance of job(Timer or TimerTask)
     */	
	public synchronized void removeSchedule(Object job) {
		if( job instanceof TimerTask) {
			TimerTask timerTask = (TimerTask)job;
			timerTask.cancel();
		}
		if( job instanceof Timer) {
			Timer timer = (Timer)job;
			timer.cancel();
		}
		this.schedules.remove(job);
		System.out.println("remove " + job);
	}
	
	/**
     * �����Ҧ��O�ɪ���Ȥ� Schedule
     *
     */	
	public synchronized void removeOverTimeSchedule() {
		Object[] jobs = this.getJobs();
		for(int i=0;i<jobs.length;i++) {
			Schedule schedule = this.getSchedule(jobs[i]);
			this.removeOverTimeSchedule(jobs[i], schedule);
		}
	}
	
	/**
     * �����O�ɪ���ȤΨ� Schedule
     *
     * @param   job        instance of job(Timer or TimerTask)
     * @param   when       execFinalDate(��氱��ɶ�)
     */	
	public synchronized void removeOverTimeSchedule(Object job, Date when) {
		if(this.chkOverTime(when)) {
			this.removeSchedule(job);
		}
	}
	
	/**
     * �����O�ɪ���ȤΨ� Schedule
     *
     * @param   job        instance of job(Timer or TimerTask)
     * @param   schedule   instance of Schedule
     */	
	public synchronized void removeOverTimeSchedule(Object job, Schedule schedule) {
		if(this.chkOverTime(schedule)){
			this.removeSchedule(job);
			System.out.println("remove overtime schedule " + job);
		}
	}
	
	/**
     * �O���ˬd, true �N��O��
     *
     * @param   when        ���ˮɶ�
     */	
	public boolean chkOverTime(Date when) {
		boolean flag = false;
		Date now = new Date();
		if( when == null || when.equals(new Date(0)) ) return flag;
		if( now.after(when) ) flag = true;
		return flag;
	}
	
	/**
     * �O���ˬd, true �N��O��
     *
     * @param   schedule       ���� schedule
     */	
	public boolean chkOverTime(Schedule schedule) {
		boolean flag = false;
		Date when = schedule.getExecFinalDate();
		if(when != null && !when.equals(new Date(0))) {
			flag = this.chkOverTime(when);
		}
		return flag;
	}
	
	/**
     * �ˬd�O�_�s�b
     *
     * @param   job           ���� job
     */	
	public boolean containsJob(Object job) {
		return this.schedules.containsKey(job);
	}
	
	/**
     * �ˬd�O�_�s�b
     *
     * @param   schedule       ���� schedule
     */	
	public synchronized boolean containsSchedule(Schedule schedule) {
		boolean flag = false;
		Object[] schedules = this.getSchedule();
		if(schedules != null ) {
			for(int i=0;i<schedules.length;i++) {
			  if(schedule.equalTo(schedules[i])) return true;
		  }
		}
		return flag;
	}
	
	/**
     * �]�w(��o)�W���ק�ɶ�
     * 
     * @param   lstModified       �W���ק�ɶ�
     */	
	public synchronized void setLstModified(Date lstModified) {
		this.lstModified = lstModified;
	}
	public synchronized Date getLstModified() {
		return this.lstModified;
	}
	/**
     * �]�w(��o)�̷s�ק�ɶ�
     *
     * @param   newModified       �̷s�ק�ɶ�
     */	
	public synchronized void setNewModified(Date newModified) {
		this.newModified = newModified;
	}
	public synchronized Date getNewModified() {
		return this.newModified;
	}
	
	/**
     * �]�w(��o)�̷s�ק�ɶ�
     *
     * @param   newModified       �̷s�ק�ɶ�
     * @param   lstModified       �W���ק�ɶ�
     */	
	public boolean chkModified(Date lstModified,Date newModified) {
		boolean flag = false;
		if( newModified==null || !lstModified.equals(newModified) ){
			System.out.println(" ****** Modified Changed ****** ");
			System.out.println("  " + new Date() );
			System.out.println(" ****** Modified Changed ****** ");
			flag = true;
		}
  	return flag;
	}
	

}
