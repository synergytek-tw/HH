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
�ưȩҪ����ݿ�ƶ������H�󤧲��ͬ��Q�ηs�W�\��ToDosMailTask(����NotFinishToDosMailTask�\��)
��l����A���o�H�Ƶ{�ɷ|���K�h�ˬd�Ҧ�ToDos��ơA�ˬd�O�_�����ݿ�ƶ������������(AlertDate)��
��쪺����O�_�����ѡA�B��MailDate������Ƭ�Null�ɫh�o�H��G01�s�դH���C

�Y��ToDos�����Ŀ惡���q���Ȥ�(ContectClient)���A�h��o�H��G01�s�դH���ɫh�P�ɵo�H�������ݿ�ƶ�
ParentId���ץ󤤡��Ȥ��p���H(ClientContect)����줤���������p���H(applicant)��
 */
		/*
		 * �D���GIPS�޲z�t�δ��ܰT���w�����ި�q��
		 * 
		 * ���e�G
		 * 
�ݿ�ƶ��t�δ����T��

�ץ������G 
���ҽs���G
�ץ�W�١G 
�k�w�����G 
�ץ�ʽ�G 
�u�@���ػ����G
�Ӽ����O�G(�Ȧ��b�ݩ�ӼЮץ�Todos�o�X�q��mail�ɪ�mail���e�~�|��ܥX�Ӧ��ﶵ�A
����쬰�ھ�Todos��ParentId�����p���ץ�TrademarkClassification)

���ҽs���G����쬰ToDos ��ParentId
�ץ�W�١G����쬰�ھ�Todos��ParentId�����p���ץ�Title���
�k�w�����G����쬰ToDos ��LegalDueDate
�ץ�ʽ�G����쬰ToDos ��Matter
�u�@���ػ����G����쬰ToDos ��TaskDescription
		 */
		DbUtil dbUtil = new DbUtil();

		String sql = "select FlowKey from ToDos where FlowKey != '' and AlertDate='"+now+"' and (MailDate is null or MailDate='')";
		List<String> keys = dbUtil.getValueList(sql, "FlowKey");
		String keysCond = dbUtil.getInCondSql(sql, "FlowKey");
		System.out.println("Send Alert ToDos Mails number : " + keys.size());
		for (String key : keys) {
//			String mailTitle = "IPS�޲z�t�δ��ܰT���w�ݿ�ƶ��t�δ����q��";
			String mailTitle = "�t�δ���-���ҽs��-�u�@���ػ���-�ӿ�H";
			String mailContent = "�ݿ�ƶ��t�δ����T��<br><br>";
			String ClientContect = "";
			String AssignedTo = "";
			String TaskCreator ="";
			String AssignedToSupervisor = "";
			ToDos todos = new ToDos(key);
			/* �o�H�ɶ��令��todos��������� */
			String mailTime = todos.getAlertDate() + " 00:00:00";

			sql = "select 'P' as casetype from patentcase where flowkey='" + todos.getParentId() + "' " + "union "
					+ "select 'T' as casetype from trademarkcase where flowkey='" + todos.getParentId() + "' " + "union "
					+ "select 'L' as casetype from legalcase where flowkey='" + todos.getParentId() + "'";
			List<String> cases = dbUtil.getValueList(sql, "casetype");
			if (!cases.isEmpty()) {
				String caseType = cases.get(0);
				if (Util.compareTo(caseType, "P")) {
					PatentCase patent = new PatentCase(todos.getParentId());
					mailTitle = "�t�δ���-" + patent.getCaseNo() + "-" + 
								todos.getTaskDescription() + "-" + empProp.getProperty(todos.getAssignedTo());
					
					String applicantName = "";
					String sql2 = "select flowkey from patentapplicant where parentid='" + patent.getFlowKey() + "'";
					List<String> keys2 = dbUtil.getValueList(sql2, "flowkey");
					for(int i=0;i<keys2.size();i++) {
						if(i==0) {
							applicantName = new PatentApplicant(keys2.get(i)).getApplicantName();
						}
						else {
							applicantName += "�B" + new PatentApplicant(keys2.get(i)).getApplicantName();
						}
					}
					
					mailContent += "�ץ������G�M�Q�ץ�<br>" + "���ҽs���G" + patent.getCaseNo() + "<br>" + "�ץ�W�١G" + patent.getTitle()
							+ "<br>" + "�k�w�����G" + todos.getLegalDueDate() + "<br>" + "�ץ�ʽ�G"
							+ matterProp.getProperty(todos.getMatter()) + "<br>"
							+ "�u�@���ػ����G" + todos.getTaskDescription() + "<br>"
							+ "�ӿ�H�G" + empProp.getProperty(todos.getAssignedTo()) + "<br>"
							+ "�ӽФH�G" + applicantName + "<br>";
					ClientContect = patent.getClientContect();
					AssignedTo = todos.getAssignedTo();
					TaskCreator = todos.getTaskCreator();
					Employee assingnedEmployee = new Employee(AssignedTo);
					Department assingnedDepartment = new Department(assingnedEmployee.getDept_id());		
					AssignedToSupervisor = assingnedDepartment.getSigner_Emp_id();
				} else if (Util.compareTo(caseType, "L")) {
					LegalCase patent = new LegalCase(todos.getParentId());
					mailTitle = "�t�δ���-" + patent.getCaseNo() + "-" + 
					todos.getTaskDescription() + "-" + empProp.getProperty(todos.getAssignedTo());
					
					String applicantName = "";
					String sql2 = "select flowkey from LegalApplicant where parentid='" + patent.getFlowKey() + "'";
					List<String> keys2 = dbUtil.getValueList(sql2, "flowkey");
					for(int i=0;i<keys2.size();i++) {
						if(i==0) {
							applicantName = new LegalApplicant(keys.get(i)).getApplicantName();
						}
						else {
							applicantName += "�B" + new LegalApplicant(keys.get(i)).getApplicantName();
						}
					}
					
					mailContent += "�ץ������G�k�߮ץ�<br>" + "���ҽs���G" + patent.getCaseNo() + "<br>" + "�ץ�W�١G" + patent.getTitle()
							+ "<br>" + "�k�w�����G" + todos.getLegalDueDate() + "<br>" + "�ץ�ʽ�G"
							+ categoryProp.getProperty(todos.getMatter()) + "<br>"
							+ "�u�@���ػ����G" + todos.getTaskDescription() + "<br>"
							+ "�ӿ�H�G" + empProp.getProperty(todos.getAssignedTo()) + "<br>"
							+ "�ӽФH�G" + applicantName + "<br>";
					ClientContect = patent.getClientContect();
					AssignedTo = todos.getAssignedTo();
					TaskCreator = todos.getTaskCreator();
					Employee assingnedEmployee = new Employee(AssignedTo);
					Department assingnedDepartment = new Department(assingnedEmployee.getDept_id());		
					AssignedToSupervisor = assingnedDepartment.getSigner_Emp_id();
				} else if (Util.compareTo(caseType, "T")) {
					TrademarkCase patent = new TrademarkCase(todos.getParentId());
					mailTitle = "�t�δ���-" + patent.getCaseNo() + "-" + 
					todos.getTaskDescription() + "-" + empProp.getProperty(todos.getAssignedTo());
					
					String applicantName = "";
					String sql2 = "select flowkey from TrademarkApplicant where parentid='" + patent.getFlowKey() + "'";
					List<String> keys2 = dbUtil.getValueList(sql2, "flowkey");
					for(int i=0;i<keys2.size();i++) {
						if(i==0) {
							applicantName = new TrademarkApplicant(keys.get(i)).getApplicantName();
						}
						else {
							applicantName += "�B" + new TrademarkApplicant(keys.get(i)).getApplicantName();
						}
					}
					
					mailContent += "�ץ������G�ӼЮץ�<br>" + "���ҽs���G" + patent.getCaseNo() + "<br>" + "�ץ�W�١G" + patent.getTitle() 
							+ "<br>" + "�k�w�����G" + todos.getLegalDueDate() + "<br>" + "�ץ�ʽ�G"
							+ categoryProp.getProperty(todos.getMatter()) + "<br>"
							+ "�u�@���ػ����G" + todos.getTaskDescription() + "<br>"
							+ "�Ӽ����O�G" + patent.getTrademarkClassification() + "<br>"
							+ "�ӿ�H�G" + empProp.getProperty(todos.getAssignedTo()) + "<br>"
							+ "�ӽФH�G" + applicantName + "<br>";
					ClientContect = patent.getClientContect();
					AssignedTo = todos.getAssignedTo();
					TaskCreator = todos.getTaskCreator();
					Employee assingnedEmployee = new Employee(AssignedTo);
					Department assingnedDepartment = new Department(assingnedEmployee.getDept_id());		
					AssignedToSupervisor = assingnedDepartment.getSigner_Emp_id();
				}
			}
//System.out.println(mailContent);
//			mailContent += "�u�@���ػ����G" + todos.getTaskDescription() + "<br>" + "�ӿ�H�G" + empProp.getProperty(todos.getAssignedTo()) + "<br>" + "�_�l��G"
//					+ Util.getRocDate(todos.getStartDate2()) + "<br>" + "���������G" + Util.getRocDate(todos.getInternalDueDate()) + "<br>" + "�ưȩҨ����G"
//					+ Util.getRocDate(todos.getAttorneyDueDate()) + "<br>" + "�k�w�����G" + Util.getRocDate(todos.getLegalDueDate()) + "<br><br>"
//					+ "<a href='http://192.168.200.17:8080/SasWafer/'>�}��IPS�M�Q�޲z�t��<a/><br>";
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
				// �o�H��G01�s�ժ����󬰫ݿ�ƶ������A �� "TDS01" �B�l��o�e�]�w"�o�e��G01�s��(GroupSendCheck)" �� "Y"
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
			
			// �o�H���ӿ�H�����󬰫ݿ�ƶ������A �� "TDS01" �B  �l��o�e�]�w"�o�e�ӿ�H(AssignToCheck)" �� "Y" �B
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
			
			// ��ToDosStatus����� �O�_��TDS01  �Y��TDS01 �h�o�H���N��ƶ����H
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
			
			// ��ToDosStatus����� �O�_��TDS01  �Y��TDS01 �h�o�H���N��ƶ��ӿ�H���ݳ������D��
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
			 * �n�[�JNotifyTarget
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
