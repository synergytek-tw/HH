package deepspot.mail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimerTask;
import java.util.Vector;

import deepspot.basic.Cnstnts;
import deepspot.basic.DbUtil;
import deepspot.main.Applicant;
import deepspot.main.Category;
import deepspot.main.Department;
import deepspot.main.Employee;
import deepspot.main.Groups_detail;
import deepspot.main.LegalApplicant;
import deepspot.main.LegalCase;
import deepspot.main.MailManager;
import deepspot.main.MailThreadConfig_detail;
import deepspot.main.PatentApplicant;
import deepspot.main.PatentCase;
import deepspot.main.PatentMatterConfig;
import deepspot.main.ToDos;
import deepspot.main.TrademarkApplicant;
import deepspot.main.TrademarkCase;
import deepspot.util.Util;

public class ToDosMailTask extends TimerTask {
	public ToDosMailTask() {
		super();
	}

	@Override
	public void run() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(new Date());

		Properties empProp = null;
		Properties applicantProp = null;
		Properties deptProp = null;
		Properties categoryProp = null;
		Properties matterProp = null;
		try {
			empProp = new Employee().getNamesPrpts();
			applicantProp = new Applicant().getNamesPrpts();
			deptProp = new Department().getNamesPrpts();
			categoryProp = new Category().getNamesPrpts();
			matterProp = new PatentMatterConfig().getNamesPrpts();
		} catch (Exception e) {
		}
		Vector mailDataVtr = new Vector();

/*
事務所版本待辦事項提醒信件之產生為利用新增功能ToDosMailTask(類似NotFinishToDosMailTask功能)
當郵件伺服器發信排程時會順便去檢查所有ToDos資料，檢查是否此筆待辦事項的“提醒日期(AlertDate)”
欄位的日期是否為今天，且“MailDate”欄位資料為Null時則發信給G01群組人員。

若此ToDos中有勾選此“通知客戶(ContectClient)”，則於發信給G01群組人員時則同時發信給此筆待辦事項
ParentId的案件中“客戶聯絡人(ClientContect)”欄位中紀錄的“聯絡人(applicant)”
 */
		/*
		 * 主旨：IPS管理系統提示訊息─期限管制通知
		 * 
		 * 內容：
		 * 
待辦事項系統提醒訊息

案件類型： 
本所編號：
案件名稱： 
法定到期日： 
案件性質： 
工作項目說明：
商標類別：(僅有在屬於商標案件的Todos發出通知mail時的mail內容才會顯示出來此選項，
此欄位為根據Todos的ParentId所關聯的案件的TrademarkClassification)

本所編號：此欄位為ToDos 的ParentId
案件名稱：此欄位為根據Todos的ParentId所關聯的案件的Title欄位
法定到期日：此欄位為ToDos 的LegalDueDate
案件性質：此欄位為ToDos 的Matter
工作項目說明：此欄位為ToDos 的TaskDescription
		 */
		DbUtil dbUtil = new DbUtil();

		String sql = "select FlowKey from ToDos where FlowKey != '' and AlertDate='"+now+"' and (MailDate is null or MailDate='')";
		List<String> keys = dbUtil.getValueList(sql, "FlowKey");
		String keysCond = dbUtil.getInCondSql(sql, "FlowKey");
		System.out.println("Send Alert ToDos Mails number : " + keys.size());
		for (String key : keys) {
//			String mailTitle = "IPS管理系統提示訊息─待辦事項系統提醒通知";
			String mailTitle = "系統提醒-本所編號-工作項目說明-承辦人";
			String mailContent = "待辦事項系統提醒訊息<br><br>";
			String ClientContect = "";
			String AssignedTo = "";
			String TaskCreator ="";
			String AssignedToSupervisor = "";
			ToDos todos = new ToDos(key);
			/* 發信時間改成抓todos的提醒日期 */
			String mailTime = todos.getAlertDate() + " 00:00:00";

			sql = "select 'P' as casetype from patentcase where flowkey='" + todos.getParentId() + "' " + "union "
					+ "select 'T' as casetype from trademarkcase where flowkey='" + todos.getParentId() + "' " + "union "
					+ "select 'L' as casetype from legalcase where flowkey='" + todos.getParentId() + "'";
			List<String> cases = dbUtil.getValueList(sql, "casetype");
			if (!cases.isEmpty()) {
				String caseType = cases.get(0);
				if (Util.compareTo(caseType, "P")) {
					PatentCase patent = new PatentCase(todos.getParentId());
					mailTitle = "系統提醒-" + patent.getCaseNo() + "-" + 
								todos.getTaskDescription() + "-" + empProp.getProperty(todos.getAssignedTo());
					
					String applicantName = "";
					String sql2 = "select flowkey from patentapplicant where parentid='" + patent.getFlowKey() + "'";
					List<String> keys2 = dbUtil.getValueList(sql2, "flowkey");
					for(int i=0;i<keys2.size();i++) {
						if(i==0) {
							applicantName = new PatentApplicant(keys2.get(i)).getApplicantName();
						}
						else {
							applicantName += "、" + new PatentApplicant(keys2.get(i)).getApplicantName();
						}
					}
					
					mailContent += "案件類型：專利案件<br>" + "本所編號：" + patent.getCaseNo() + "<br>" + "案件名稱：" + patent.getTitle()
							+ "<br>" + "法定到期日：" + todos.getLegalDueDate() + "<br>" + "案件性質："
							+ matterProp.getProperty(todos.getMatter()) + "<br>"
							+ "工作項目說明：" + todos.getTaskDescription() + "<br>"
							+ "承辦人：" + empProp.getProperty(todos.getAssignedTo()) + "<br>"
							+ "申請人：" + applicantName + "<br>";
					ClientContect = patent.getClientContect();
					AssignedTo = todos.getAssignedTo();
					TaskCreator = todos.getTaskCreator();
					Employee assingnedEmployee = new Employee(AssignedTo);
					Department assingnedDepartment = new Department(assingnedEmployee.getDept_id());		
					AssignedToSupervisor = assingnedDepartment.getSigner_Emp_id();
				} else if (Util.compareTo(caseType, "L")) {
					LegalCase patent = new LegalCase(todos.getParentId());
					mailTitle = "系統提醒-" + patent.getCaseNo() + "-" + 
					todos.getTaskDescription() + "-" + empProp.getProperty(todos.getAssignedTo());
					
					String applicantName = "";
					String sql2 = "select flowkey from LegalApplicant where parentid='" + patent.getFlowKey() + "'";
					List<String> keys2 = dbUtil.getValueList(sql2, "flowkey");
					for(int i=0;i<keys2.size();i++) {
						if(i==0) {
							applicantName = new LegalApplicant(keys.get(i)).getApplicantName();
						}
						else {
							applicantName += "、" + new LegalApplicant(keys.get(i)).getApplicantName();
						}
					}
					
					mailContent += "案件類型：法律案件<br>" + "本所編號：" + patent.getCaseNo() + "<br>" + "案件名稱：" + patent.getTitle()
							+ "<br>" + "法定到期日：" + todos.getLegalDueDate() + "<br>" + "案件性質："
							+ categoryProp.getProperty(todos.getMatter()) + "<br>"
							+ "工作項目說明：" + todos.getTaskDescription() + "<br>"
							+ "承辦人：" + empProp.getProperty(todos.getAssignedTo()) + "<br>"
							+ "申請人：" + applicantName + "<br>";
					ClientContect = patent.getClientContect();
					AssignedTo = todos.getAssignedTo();
					TaskCreator = todos.getTaskCreator();
					Employee assingnedEmployee = new Employee(AssignedTo);
					Department assingnedDepartment = new Department(assingnedEmployee.getDept_id());		
					AssignedToSupervisor = assingnedDepartment.getSigner_Emp_id();
				} else if (Util.compareTo(caseType, "T")) {
					TrademarkCase patent = new TrademarkCase(todos.getParentId());
					mailTitle = "系統提醒-" + patent.getCaseNo() + "-" + 
					todos.getTaskDescription() + "-" + empProp.getProperty(todos.getAssignedTo());
					
					String applicantName = "";
					String sql2 = "select flowkey from TrademarkApplicant where parentid='" + patent.getFlowKey() + "'";
					List<String> keys2 = dbUtil.getValueList(sql2, "flowkey");
					for(int i=0;i<keys2.size();i++) {
						if(i==0) {
							applicantName = new TrademarkApplicant(keys.get(i)).getApplicantName();
						}
						else {
							applicantName += "、" + new TrademarkApplicant(keys.get(i)).getApplicantName();
						}
					}
					
					mailContent += "案件類型：商標案件<br>" + "本所編號：" + patent.getCaseNo() + "<br>" + "案件名稱：" + patent.getTitle() 
							+ "<br>" + "法定到期日：" + todos.getLegalDueDate() + "<br>" + "案件性質："
							+ categoryProp.getProperty(todos.getMatter()) + "<br>"
							+ "工作項目說明：" + todos.getTaskDescription() + "<br>"
							+ "商標類別：" + patent.getTrademarkClassification() + "<br>"
							+ "承辦人：" + empProp.getProperty(todos.getAssignedTo()) + "<br>"
							+ "申請人：" + applicantName + "<br>";
					ClientContect = patent.getClientContect();
					AssignedTo = todos.getAssignedTo();
					TaskCreator = todos.getTaskCreator();
					Employee assingnedEmployee = new Employee(AssignedTo);
					Department assingnedDepartment = new Department(assingnedEmployee.getDept_id());		
					AssignedToSupervisor = assingnedDepartment.getSigner_Emp_id();
				}
			}
//System.out.println(mailContent);
//			mailContent += "工作項目說明：" + todos.getTaskDescription() + "<br>" + "承辦人：" + empProp.getProperty(todos.getAssignedTo()) + "<br>" + "起始日："
//					+ Util.getRocDate(todos.getStartDate2()) + "<br>" + "內部到期日：" + Util.getRocDate(todos.getInternalDueDate()) + "<br>" + "事務所到期日："
//					+ Util.getRocDate(todos.getAttorneyDueDate()) + "<br>" + "法定到期日：" + Util.getRocDate(todos.getLegalDueDate()) + "<br><br>"
//					+ "<a href='http://192.168.200.17:8080/SasWafer/'>開啟IPS專利管理系統<a/><br>";
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
				// 發信給G01群組的條件為待辦事項的狀態 為 "TDS01" 且郵件發送設定"發送給G01群組(GroupSendCheck)" 為 "Y"
				if(Util.compareTo(todos.getToDosStatus(), "TDS01") && Util.compareTo(mailCheck.getGroupSendCheck(),"Y")) {
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
			
			// 發信給承辦人的條件為待辦事項的狀態 為 "TDS01" 且  郵件發送設定"發送承辦人(AssignToCheck)" 為 "Y" 且
			if(Util.compareTo(todos.getToDosStatus(), "TDS01") && Util.compareTo(mailCheck.getAssignToCheck(),"Y") && emps.indexOf(AssignedTo) == -1 ) {
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
			
			// “ToDosStatus”欄位 是否為TDS01  若為TDS01 則發信給代辦事項交辦人
			if(Util.compareTo(todos.getToDosStatus(), "TDS01") && Util.compareTo(mailCheck.getCreatorCheck(),"Y") && emps.indexOf(TaskCreator) == -1 ) {
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
			
			// “ToDosStatus”欄位 是否為TDS01  若為TDS01 則發信給代辦事項承辦人所屬部門之主管
			if(Util.compareTo(todos.getToDosStatus(), "TDS01") && Util.compareTo(mailCheck.getSupervisorCheck(),"Y") && emps.indexOf(AssignedToSupervisor) == -1) {
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
			
			if(Util.compareTo(todos.getContectClient(), "Y")) {
				System.out.println("ClientContect="+ClientContect);
				Applicant applicant = new Applicant(ClientContect);
				if (!Util.isEmpty(applicant.getEmail())) {
					MailThreadConfig_detail mailData = new MailThreadConfig_detail();
					mailData.setSourceTableName("Draft.sendMail01");
					mailData.setPKey(Util.getNo("DfMail" + Util.getDayOfYear(), 2));
					mailData.setTitle(mailTitle);
					mailData.setMailTime(mailTime);
					mailData.setContent(mailContent);
					mailData.setMailTo(applicant.getEmail());
					mailDataVtr.add(mailData);
				}
			}
			
			/*
			 * 要加入NotifyTarget
			 */
			if(Util.compareTo(todos.getToDosStatus(), "TDS01") && !Util.isEmpty(todos.getNotifyTarget())) {
				System.out.println("NotifyTarget="+todos.getNotifyTarget());
				String[] targets = todos.getNotifyTarget().split(";");
				for(String target : targets) {
					if (!Util.isEmpty(target)) {
						MailThreadConfig_detail mailData = new MailThreadConfig_detail();
						mailData.setSourceTableName("Draft.sendMail01");
						mailData.setPKey(Util.getNo("DfMail" + Util.getDayOfYear(), 2));
						mailData.setTitle(mailTitle);
						mailData.setMailTime(mailTime);
						mailData.setContent(mailContent);
						mailData.setMailTo(target);
						mailDataVtr.add(mailData);
					}
				}
			}
		}
		
		sql = "update todos set maildate='" + now + "' where flowkey in (" + keysCond + ")";
		dbUtil.executeUpdate(sql);

		new MailThreadConfig_detail().insert(Cnstnts.EMPTY_STRING, mailDataVtr.iterator());
	}

}
