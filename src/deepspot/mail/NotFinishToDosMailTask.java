package deepspot.mail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimerTask;
import java.util.Vector;

import deepspot.basic.Cnstnts;
import deepspot.basic.DbUtil;
import deepspot.main.Category;
import deepspot.main.Department;
import deepspot.main.Employee;
import deepspot.main.Groups_detail;
import deepspot.main.LegalCase;
import deepspot.main.MailManager;
import deepspot.main.MailThreadConfig_detail;
import deepspot.main.PatentCase;
import deepspot.main.PatentMatterConfig;
import deepspot.main.ToDos;
import deepspot.main.TrademarkCase;
import deepspot.util.Util;

public class NotFinishToDosMailTask extends TimerTask {
	public NotFinishToDosMailTask() {
		super();
	}

	@Override
	public void run() {
		// 各模組的期限管制資料新增後承辦人在期限管制完成前該承辦人會在每日收到一封提醒信
		/*
		 * 主旨：IPS管理系統提示訊息─期限管制通知
		 * 
		 * 內容：
		 * 
		 * 期限管制系統提醒訊息 案件類型：專利案件 案件編號： P2-10001TW 類別：發明 案件程序：美國暫時申請 工作項目說明：
		 * 申請案件繳件 承辦人：何思樺 起始日：2010年10月01日 內部到期日：2010年10月15日 事務所到期日：2010年10月30日
		 * 法定到期日：2010年11月10日
		 * 
		 * 開啟IPS專利管理系統
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(new Date());
		Calendar cNow = Calendar.getInstance();
		int nowDay = cNow.get(Calendar.DAY_OF_WEEK);
//		System.out.println("nowDay="+nowDay);

		Properties empProp = null;
		Properties deptProp = null;
		Properties categoryProp = null;
		Properties matterProp = null;
		String link = "";
		MailManager mailManager = new MailManager("MailManager");
		List<Integer> sendTypeList = new ArrayList<Integer>(); 
    	if(mailManager != null){
    		link = mailManager.getMailLink();
    		if(mailManager.getAlertDateSend() != null && Util.compareTo(mailManager.getAlertDateSend(), "Y")){
    			sendTypeList.add(0);
    		}
    		if(mailManager.getAlertSun() != null && Util.compareTo(mailManager.getAlertSun(), "Y")){
    			sendTypeList.add(1);
    		}
			if(mailManager.getAlertMon() != null && Util.compareTo(mailManager.getAlertMon(), "Y")){
				sendTypeList.add(2);		
    		}
			if(mailManager.getAlertTue() != null && Util.compareTo(mailManager.getAlertTue(), "Y")){
				sendTypeList.add(3);
			}
			if(mailManager.getAlertWed() != null && Util.compareTo(mailManager.getAlertWed(), "Y")){
				sendTypeList.add(4);		
    		}
			if(mailManager.getAlertThu() != null && Util.compareTo(mailManager.getAlertThu(), "Y")){
				sendTypeList.add(5);
			}
			if(mailManager.getAlertFri() != null && Util.compareTo(mailManager.getAlertFri(), "Y")){
				sendTypeList.add(6);		
    		}
			if(mailManager.getAlertSat() != null && Util.compareTo(mailManager.getAlertSat(), "Y")){
				sendTypeList.add(7);
			}
    	}
    	
		try {
			empProp = new Employee().getNamesPrpts();
			deptProp = new Department().getNamesPrpts();
			categoryProp = new Category().getNamesPrpts();
			matterProp = new PatentMatterConfig().getNamesPrpts();
		} catch (Exception e) {
		}
		Vector mailDataVtr = new Vector();

		DbUtil dbUtil = new DbUtil();
		/*修改發信條件必需勾選是否提醒才會發信 */
		String sql = "select FlowKey from ToDos where (FinishedDate IS NULL or FinishedDate ='') and (MailDate < '"
				+ now + "' or maildate is null) and AlertDate IS NOT NULL and AlertDate!='' and (AlertDate <= '" + now + "')";
		List<String> keys = dbUtil.getValueList(sql, "FlowKey");
		String keysCond = dbUtil.getInCondSql(sql, "FlowKey");
//		System.out.println("Send Not Finish ToDos Mails number : "
//				+ keys.size());
		int countSend = 0;
		for (String key : keys) {
			ToDos todos = new ToDos(key);
			boolean sendMail = false;
			if(sendTypeList.contains(0) && Util.compareTo(todos.getAlertDate(), now)){
				sendMail = true;
				countSend ++;
			}else if(sendTypeList.contains(nowDay)){
				sendMail = true;
				countSend ++;
			}
			
			String mailTitle = "IPS管理系統提示訊息─期限管制通知";
			String mailContent = "期限管制系統提醒訊息<br><br>";
			
			if(sendMail){
				/*發信時間改成抓todos的提醒日期*/
				String mailTime = todos.getAlertDate() + " 00:00:00";

				sql = "select 'P' as casetype from patentcase where flowkey='"
						+ todos.getParentId()
						+ "' "
						+ "union "
						+ "select 'T' as casetype from trademarkcase where flowkey='"
						+ todos.getParentId() + "' " + "union "
						+ "select 'L' as casetype from legalcase where flowkey='"
						+ todos.getParentId() + "'";
				List<String> cases = dbUtil.getValueList(sql, "casetype");
				if (!cases.isEmpty()) {
					String caseType = cases.get(0);
					if (Util.compareTo(caseType, "P")) {
						PatentCase patent = new PatentCase(todos.getParentId());
						mailContent += "案件類型：專利案件<br>" + "案件編號："
								+ patent.getCaseNo() + "<br>"
								+ "申請專利名稱：" 
								+ patent.getTitle() + "<br>"
								+ "類別："
								+ categoryProp.getProperty(patent.getPatentType())
								+ "<br>" + "案件程序："
								+ matterProp.getProperty(todos.getMatter())
								+ "<br>";
					} else if (Util.compareTo(caseType, "L")) {
						LegalCase patent = new LegalCase(todos.getParentId());
						mailContent += "案件類型：法律案件<br>" + "案件編號："
								+ patent.getCaseNo() + "<br>" 
								+ "合作計畫名稱："
								+ patent.getTitle() + "<br>"
								+ "類別："
								+ categoryProp.getProperty(patent.getSubType())
								+ "<br>" + "案件程序："
								+ categoryProp.getProperty(todos.getMatter())
								+ "<br>";
					} else if (Util.compareTo(caseType, "T")) {
						TrademarkCase patent = new TrademarkCase(todos
								.getParentId());
						mailContent += "案件類型：商標案件<br>"
								+ "案件編號："
								+ patent.getCaseNo()
								+ "<br>"
								+ "商標名稱："
								+ patent.getTitle() + "<br>"
								+ "類別："
								+ categoryProp.getProperty(patent
										.getTrademarkType()) + "<br>" + "案件程序："
								+ categoryProp.getProperty(todos.getMatter())
								+ "<br>";
					}
				}

				mailContent += "工作項目說明："
						+ todos.getTaskDescription()
						+ "<br>"
						+ "承辦人："
						+ empProp.getProperty(todos.getAssignedTo())
						+ "<br>"
						+ "起始日："
						+ Util.getRocDate(todos.getStartDate())
						+ "<br>"
						+ "內部到期日："
						+ Util.getRocDate(todos.getInternalDueDate())
						+ "<br>"
						+ "事務所到期日："
						+ Util.getRocDate(todos.getAttorneyDueDate())
						+ "<br>"
						+ "法定到期日："
						+ Util.getRocDate(todos.getLegalDueDate())
						+ "<br><br>"
						+ "<a href='" + link + "'>開啟IPS專利管理系統<a/><br>";

				String AssignedTo = "";
				String TaskCreator = "";
				String AssignedToSupervisor = "";

				AssignedTo = todos.getAssignedTo();
				TaskCreator = todos.getTaskCreator();
				Employee assingnedEmployee = new Employee(AssignedTo);
				Department assingnedDepartment = new Department(assingnedEmployee.getDept_id());	
				AssignedToSupervisor = assingnedDepartment.getSigner_Emp_id();
				
				MailManager mailCheck = new MailManager("MailManager");
				//emps為寄信人員列表，而藉此來過濾重複寄信問題，先建立emps清單，若需寄給G01群組則先將G01群組人員加入。
				List<String> emps = new ArrayList<String>();
				Groups_detail detail = new Groups_detail();
				try {
					if(Util.compareTo(mailCheck.getGroupSendCheck(),"Y")){
					emps = detail.getGroupMemberIdList("G01");
					}
				}
				catch(Exception e){}
				
				try {
					// 發信給G01群組的條件為待辦事項的“是否完成(finished)” 不為 "Y" 且郵件發送設定"發送給G01群組(GroupSendCheck)" 為 "Y"
					if(!Util.compareTo(todos.getFinished(), "Y") && Util.compareTo(mailCheck.getGroupSendCheck(),"Y")) {
						for(String id : emps) {
							Employee employee = new Employee(id);
							if (!Util.isEmpty(employee.getEmail())) {
								MailThreadConfig_detail mailData = new MailThreadConfig_detail();
								mailData.setSourceTableName("Draft.sendMail01");
								mailData.setPKey(Util.getNo("DfMail" + Util.getDayOfYear(), 2));
								mailData.setTitle(mailTitle);
								mailData.setMailTime(mailTime);
								mailData.setContent(mailContent);
								mailData.setMailTo(employee.getEmail());
								mailDataVtr.add(mailData);
							}
						}
					}
				}
				catch(Exception e){}
				
				// 發信給承辦人的條件為待辦事項的“是否完成(finished)” 不為 "Y" 且  郵件發送設定"發送承辦人(AssignToCheck)" 為 "Y" 且
				if(!Util.compareTo(todos.getFinished(), "Y") && Util.compareTo(mailCheck.getAssignToCheck(),"Y") && emps.indexOf(AssignedTo) == -1 ) {
					System.out.println("AssignedTo="+AssignedTo);
					Employee employee = new Employee(AssignedTo);
					if (!Util.isEmpty(employee.getEmail())) {
						MailThreadConfig_detail mailData = new MailThreadConfig_detail();
						mailData.setSourceTableName("Draft.sendMail01");
						mailData.setPKey(Util.getNo("DfMail" + Util.getDayOfYear(), 2));
						mailData.setTitle(mailTitle);
						mailData.setMailTime(mailTime);
						mailData.setContent(mailContent);
						mailData.setMailTo(employee.getEmail());
						mailDataVtr.add(mailData);
						emps.add(AssignedTo);
					}
				}
				
				// “Finished”欄位 是否為Y  若為Y 則不發信給代辦事項交辦人
				if(!Util.compareTo(todos.getFinished(), "Y") && Util.compareTo(mailCheck.getCreatorCheck(),"Y") && emps.indexOf(TaskCreator) == -1 ) {
					System.out.println("TaskCreator="+TaskCreator);
					Employee employee = new Employee(TaskCreator);
					if (!Util.isEmpty(employee.getEmail())) {
						MailThreadConfig_detail mailData = new MailThreadConfig_detail();
						mailData.setSourceTableName("Draft.sendMail01");
						mailData.setPKey(Util.getNo("DfMail" + Util.getDayOfYear(), 2));
						mailData.setTitle(mailTitle);
						mailData.setMailTime(mailTime);
						mailData.setContent(mailContent);
						mailData.setMailTo(employee.getEmail());
						mailDataVtr.add(mailData);
						emps.add(TaskCreator);
					}
				}
				
				// “Finished”欄位 是否為Y  若為Y 則不發信給代辦事項承辦人所屬部門之主管
				if(!Util.compareTo(todos.getFinished(), "Y") && Util.compareTo(mailCheck.getSupervisorCheck(),"Y") && emps.indexOf(AssignedToSupervisor) == -1) {
					System.out.println("AssignedToSupervisor="+AssignedToSupervisor);
					Employee employee = new Employee(AssignedToSupervisor);
					if (!Util.isEmpty(employee.getEmail())) {
						MailThreadConfig_detail mailData = new MailThreadConfig_detail();
						mailData.setSourceTableName("Draft.sendMail01");
						mailData.setPKey(Util.getNo("DfMail" + Util.getDayOfYear(), 2));
						mailData.setTitle(mailTitle);
						mailData.setMailTime(mailTime);
						mailData.setContent(mailContent);
						mailData.setMailTo(employee.getEmail());
						mailDataVtr.add(mailData);
					}
				}
				/*
				Employee employee = new Employee(todos.getAssignedTo());
				if (!Util.isEmpty(employee.getEmail())) {
					MailThreadConfig_detail mailData = new MailThreadConfig_detail();
					mailData.setSourceTableName("Draft.sendMail01");
					mailData.setPKey(Util.getNo("DfMail" + Util.getDayOfYear(), 2));
					mailData.setTitle(mailTitle);
					mailData.setMailTime(mailTime);
					mailData.setContent(mailContent);
					mailData.setMailTo(employee.getEmail());
					mailDataVtr.add(mailData);
				}
				*/
			}
		}
		
		System.out.println("Send Not Finish ToDos Mails number : "
				+ countSend);

		sql = "update todos set maildate='" + now + "' where flowkey in ("
				+ keysCond + ")";
		dbUtil.executeUpdate(sql);

		new MailThreadConfig_detail().insert(Cnstnts.EMPTY_STRING, mailDataVtr
				.iterator());
	}

}
