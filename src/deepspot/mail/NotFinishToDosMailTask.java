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
		// �U�Ҳժ������ި��Ʒs�W��ӿ�H�b�����ި���e�өӿ�H�|�b�C�馬��@�ʴ����H
		/*
		 * �D���GIPS�޲z�t�δ��ܰT���w�����ި�q��
		 * 
		 * ���e�G
		 * 
		 * �����ި�t�δ����T�� �ץ������G�M�Q�ץ� �ץ�s���G P2-10001TW ���O�G�o�� �ץ�{�ǡG����Ȯɥӽ� �u�@���ػ����G
		 * �ӽЮץ�ú�� �ӿ�H�G���� �_�l��G2010�~10��01�� ���������G2010�~10��15�� �ưȩҨ����G2010�~10��30��
		 * �k�w�����G2010�~11��10��
		 * 
		 * �}��IPS�M�Q�޲z�t��
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
		/*�ק�o�H���󥲻ݤĿ�O�_�����~�|�o�H */
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
			
			String mailTitle = "IPS�޲z�t�δ��ܰT���w�����ި�q��";
			String mailContent = "�����ި�t�δ����T��<br><br>";
			
			if(sendMail){
				/*�o�H�ɶ��令��todos���������*/
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
						mailContent += "�ץ������G�M�Q�ץ�<br>" + "�ץ�s���G"
								+ patent.getCaseNo() + "<br>"
								+ "�ӽбM�Q�W�١G" 
								+ patent.getTitle() + "<br>"
								+ "���O�G"
								+ categoryProp.getProperty(patent.getPatentType())
								+ "<br>" + "�ץ�{�ǡG"
								+ matterProp.getProperty(todos.getMatter())
								+ "<br>";
					} else if (Util.compareTo(caseType, "L")) {
						LegalCase patent = new LegalCase(todos.getParentId());
						mailContent += "�ץ������G�k�߮ץ�<br>" + "�ץ�s���G"
								+ patent.getCaseNo() + "<br>" 
								+ "�X�@�p�e�W�١G"
								+ patent.getTitle() + "<br>"
								+ "���O�G"
								+ categoryProp.getProperty(patent.getSubType())
								+ "<br>" + "�ץ�{�ǡG"
								+ categoryProp.getProperty(todos.getMatter())
								+ "<br>";
					} else if (Util.compareTo(caseType, "T")) {
						TrademarkCase patent = new TrademarkCase(todos
								.getParentId());
						mailContent += "�ץ������G�ӼЮץ�<br>"
								+ "�ץ�s���G"
								+ patent.getCaseNo()
								+ "<br>"
								+ "�ӼЦW�١G"
								+ patent.getTitle() + "<br>"
								+ "���O�G"
								+ categoryProp.getProperty(patent
										.getTrademarkType()) + "<br>" + "�ץ�{�ǡG"
								+ categoryProp.getProperty(todos.getMatter())
								+ "<br>";
					}
				}

				mailContent += "�u�@���ػ����G"
						+ todos.getTaskDescription()
						+ "<br>"
						+ "�ӿ�H�G"
						+ empProp.getProperty(todos.getAssignedTo())
						+ "<br>"
						+ "�_�l��G"
						+ Util.getRocDate(todos.getStartDate())
						+ "<br>"
						+ "���������G"
						+ Util.getRocDate(todos.getInternalDueDate())
						+ "<br>"
						+ "�ưȩҨ����G"
						+ Util.getRocDate(todos.getAttorneyDueDate())
						+ "<br>"
						+ "�k�w�����G"
						+ Util.getRocDate(todos.getLegalDueDate())
						+ "<br><br>"
						+ "<a href='" + link + "'>�}��IPS�M�Q�޲z�t��<a/><br>";

				String AssignedTo = "";
				String TaskCreator = "";
				String AssignedToSupervisor = "";

				AssignedTo = todos.getAssignedTo();
				TaskCreator = todos.getTaskCreator();
				Employee assingnedEmployee = new Employee(AssignedTo);
				Department assingnedDepartment = new Department(assingnedEmployee.getDept_id());	
				AssignedToSupervisor = assingnedDepartment.getSigner_Emp_id();
				
				MailManager mailCheck = new MailManager("MailManager");
				//emps���H�H�H���C��A���Ǧ��ӹL�o���ƱH�H���D�A���إ�emps�M��A�Y�ݱH��G01�s�իh���NG01�s�դH���[�J�C
				List<String> emps = new ArrayList<String>();
				Groups_detail detail = new Groups_detail();
				try {
					if(Util.compareTo(mailCheck.getGroupSendCheck(),"Y")){
					emps = detail.getGroupMemberIdList("G01");
					}
				}
				catch(Exception e){}
				
				try {
					// �o�H��G01�s�ժ����󬰫ݿ�ƶ������O�_����(finished)�� ���� "Y" �B�l��o�e�]�w"�o�e��G01�s��(GroupSendCheck)" �� "Y"
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
				
				// �o�H���ӿ�H�����󬰫ݿ�ƶ������O�_����(finished)�� ���� "Y" �B  �l��o�e�]�w"�o�e�ӿ�H(AssignToCheck)" �� "Y" �B
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
				
				// ��Finished����� �O�_��Y  �Y��Y �h���o�H���N��ƶ����H
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
				
				// ��Finished����� �O�_��Y  �Y��Y �h���o�H���N��ƶ��ӿ�H���ݳ������D��
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
