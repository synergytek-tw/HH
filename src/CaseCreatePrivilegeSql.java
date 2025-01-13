import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.DbUtil;
import deepspot.basic.Field;
import deepspot.main.Department;
import deepspot.main.Employee;
import deepspot.main.Groups;
import deepspot.util.DB;
import deepspot.util.Util;


public class CaseCreatePrivilegeSql {
	Properties deptProp;
	DbUtil dbUtil;
	DB db;
	Map<String, Employee> emps = new HashMap<String, Employee>();

	public String insertSql = "insert into CasePrivilege(FlowKey,Applicant,CreateDept,ParentId,EmployeeId,Names,Title,DeptId,DeptName,Privilege,CaseType,CreateFrom,CaseKey,PrivilegeKind) " +
			"values (\"%s\",\"admin\",\"Demo\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"E\")";
	
	public String insertSql2 = "insert into CasePrivilege(FlowKey,Applicant,CreateDept,ParentId,EmployeeId,Names,Title,DeptId,DeptName,Privilege,CaseType,CreateFrom,CaseKey,PrivilegeKind) " +
			"values (\"%s\",\"admin\",\"Demo\",\"%s\",\"\",\"\",\"\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"D\")";
	public CaseCreatePrivilegeSql() {
		try {
			deptProp = new Department().getNamesPrpts();
			
			dbUtil = new DbUtil();
			db=new DB();
			/*
針對已經匯入的歷史案件資料，
請提供SQL 針對他們歷史案件資料， 將下列人寫加入該案件的案件權限分列表中, SQL 語法請email 給Tony cc給我，for他整理匯入資料用
1. 負責程序人員CaseAD（勾選：檢視＋編輯＋列印＋Tab ）若和G01重複就不用寫入
2. 業務人員Sale（勾選：僅檢視）
3. 和該案件關連的代辦事項todos 的承辦人（勾選：僅檢視） 

2.跑SQL掃下列規則將各該部門加入到對應的案件的案件權限：四類案件的案件編號2 前兩碼判斷部門 
如SH開頭的案號 為上海所程序部的案件 部門就設為 SHAD00  其他的案號一樣就設在該所程序部。
			 */
			int line = 0;
			int file = 0;
			BufferedWriter bw = bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream( new File("c:/case_privilege_" + file + ".sql")), "UTF-8"));
			
			String[] cass = {"patentcase", "trademarkcase", "legalcase", "copyrightcase"};
			String[] caseType = {"P", "T", "L", "C"};
			String[] InCharges = {"InCharge", "Sales", "InCharge", "InCharge"};
			List<String> ids = new ArrayList<String>();
			List<String> g01Ids = new Groups().getGroupMemberIds("G01");
			System.out.println("start in " + new Date());
			for(int i=0;i<cass.length;i++) {
				System.out.println("start do " + cass[i]);
				String sql = "select flowkey, caseno2 from " + cass[i] + "  ";
				List<List<Field>> keys = getFieldsList(sql, new String[]{"flowkey", "caseno2"});
				for(List<Field> fields : keys) {
					line++;
					if(line > 1000) {
						line = 0;
						file++;
						bw.close();
						bw = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream( new File("c:/case_privilege_" + file + ".sql")), "UTF-8"));
					}
					
					String key = fields.get(0).getValue();
					String caseno2 = fields.get(1).getValue();
					ids = new ArrayList<String>();
							
					bw.write("delete from caseprivilege where CaseKey='" + key + "';" + Cnstnts.NEW_LINE);
					
					sql = "select casead from " + cass[i] + " where flowkey ='" + key + "'";
					String casead = getFieldValue(sql, "casead");
					if(casead != null && !casead.equals("")) {
						boolean inG01Group = false;
						if(g01Ids.contains(casead)){
							inG01Group = true;
						}
						
						if(!inG01Group && !ids.contains(casead)) {
							ids.add(casead);
							bw.write(createPrivilege(casead, key, dbUtil, caseType[i], "111001"));
						}
					}
					
					sql = "select " + InCharges[i] + " from " + cass[i] + " where flowkey ='" + key + "'";
					String InCharge = getFieldValue(sql, InCharges[i]);
					if(InCharge != null && !InCharge.equals("") && !ids.contains(InCharge)) {
						boolean inG01Group = false;
						if(g01Ids.contains(InCharge)){
							inG01Group = true;
						}
						
						if(!inG01Group && !ids.contains(InCharge)) {
							ids.add(InCharge);
							bw.write(createPrivilege(InCharge, key, dbUtil, caseType[i], "100000"));
						}
					}
					
					sql = "select distinct AssignedTo from todos where parentid ='" + key + "' and AssignedTo != ''";
					List<String> assigns = getValueList(sql, "AssignedTo");
					if(assigns != null && !assigns.isEmpty()) {
						for(String assign : assigns) {
							if(!ids.contains(assign)) {
								boolean inG01Group = false;
								if(g01Ids.contains(assign)){
									inG01Group = true;
								}
								
								if(!inG01Group && !ids.contains(assign)) {
									ids.add(assign);
									bw.write(createPrivilege(assign, key, dbUtil, caseType[i], "100000"));
								}
							}
						}
					}
					
					if(!isEmpty(caseno2) && caseno2.length() >= 2) {
						String header = caseno2.substring(0, 2);
						
						bw.write(createPrivilege2(header + "AD00", key, dbUtil, caseType[i], "111101"));
					}
				}
				
				System.out.println("end do " + cass[i]);
			}
			System.out.println("end in " + new Date());
//			for(String s : g01Ids) {
//				System.out.println(s);
//			}
			bw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String createPrivilege(String AssignedTo, String FlowKey, DbUtil dbUtil, String caseType, String privilege) throws Exception {
			Employee emp = null;
			if(emps.get(AssignedTo) != null) {
				emp = emps.get(AssignedTo);
			}
			else {
				emp = new Employee(AssignedTo);
				emps.put(AssignedTo, emp);
			}
			
			String sql2 = String.format(insertSql, this.getPkeyNo(FlowKey, 3, false, "."), FlowKey, AssignedTo, 
					emp.getEmp_name(), emp.getTitle(), emp.getDept_id(), deptProp.getProperty(emp.getDept_id()), 
					privilege, caseType, FlowKey, FlowKey);
			return sql2 + ";" + Cnstnts.NEW_LINE;
	}
	
	public String createPrivilege2(String deptId, String FlowKey, DbUtil dbUtil, String caseType, String privilege) throws Exception {
		String sql2 = String.format(insertSql2, this.getPkeyNo(FlowKey, 3, false, "."), FlowKey, 
				deptId, deptProp.getProperty(deptId), 
				privilege, caseType, FlowKey, FlowKey);

		return sql2 + ";" + Cnstnts.NEW_LINE;
}

	public String getPkeyNo(String beginWord, int noLength,
			boolean appendDate, String appendSeparator) {
		return getPkeyNo(beginWord, noLength, appendDate, appendSeparator, true);
	}
	
	public String getPkeyNo(String beginWord, int noLength,
			boolean appendDate, String appendSeparator, boolean insertDb) {
		ResultSet rs;
		String pkey = beginWord;
		if (appendDate) {
			pkey = beginWord + Util.getDate("");
		}
		
		if(db == null) {
			db = new DB();
			System.out.println("init db");
		}

		String selectStr = "select no from pkeyNo where pkey='" + pkey + "'";
		String sqlStr;
		int no;
		try {
			rs = db.executeQuery(selectStr);
			if (rs.next()) {
				no = rs.getInt("no") + 1;
				sqlStr = "update pkeyNo set no=" + no + " where pkey='" + pkey
						+ "'";
			} else {
				no = 1;
				sqlStr = "insert into pkeyNo(pkey,no) values('" + pkey + "',1)";
			}
			rs.close();
			if(insertDb) {
				db.executeUpdate(sqlStr);
			}
//			db.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			rs = null;
		}
		return pkey + appendSeparator + n2s(no, noLength);
	}
	
	public static String n2s(int in, int len) {
	    String inString = String.valueOf(in);
	    String tmpString = "";
	    for(int i=0; i<len-inString.length(); i++) {
	      tmpString += "0"; 
	    }
	    return tmpString + inString;
 	}
	


	public List<String> getValueList(String SQL, String fieldName) {
		List<String> result = new ArrayList<String>();
		ResultSet rs=null;
		if(db == null) {
			db = new DB();
			System.out.println("init db");
		}
		
		try {
			rs=db.executeQuery(SQL);
			while(rs.next()) {    
				result.add(rs.getString(fieldName));
			}
			rs.close();
//			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
		}
		return result;
	}


	
	public String getFieldValue(String SQL, String fieldName) {
		String rtnString = Cnstnts.EMPTY_STRING;
		ResultSet rs;
		int totalcount=0;
		try {
			rs = db.executeQuery(SQL);
			
			while (rs.next()) {
				rtnString = rs.getString(fieldName);
				if(rtnString==null){
					rtnString = Cnstnts.EMPTY_STRING;
				}
				totalcount+=1;
				break;
			}
			
			rs.close();
//			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
//			db = null;
		}
		return rtnString;
	}


	
	public String getInsertSQL(String tableName,List<Field> dbFields){
		if(tableName==null || tableName.trim().length()==0 
				|| dbFields==null || dbFields.size()==0){
			return Cnstnts.EMPTY_STRING;
		}
		String sqlStr="insert into "+tableName;
		StringBuffer fields = new StringBuffer("(");
		StringBuffer values = new StringBuffer("values(");
		int i=0;
		for(Iterator itr=dbFields.iterator();itr.hasNext();i++){
			Field field = (Field)itr.next();
			String fieldName = field.getName();
			String fieldValue = field.getValue();
			if(!field.getDbType().equals(Cnstnts.INT) && !field.getDbType().equals(Cnstnts.FLOAT)){
				if(fieldValue.indexOf("\"") != -1 ) {
					fieldValue = fieldValue.replaceAll("\"", "\"\"");
				}
				fieldValue = "\""+fieldValue+"\"";
				if(field.getDbType().indexOf(Cnstnts.DB_TYPE_NVARCHAR)!=-1){
					if(db.DBTYPE.equals(Cnstnts.MSSQL)){
						fieldValue = "N"+fieldValue;
					}
				}
			}
			if(i>0){
				fieldName = ","+fieldName;
				fieldValue = ","+fieldValue;
			}
			fields.append(fieldName);
			values.append(fieldValue);
		}
		sqlStr += fields.append(")").toString()+values.append(")").toString();
		return sqlStr;
	}

	public List<List<Field>> getFieldsList(String SQL, String[] fieldNames){
		List<List<Field>> rtnList = new ArrayList<List<Field>>();
		ResultSet rs;
		try {
			rs = db.executeQuery(SQL);
			while (rs.next()) {
				List<Field> fieldList = new ArrayList<Field>();
				for(String name : fieldNames){
					Field newField = new Field(name);
					if(rs.getObject(name) == null) {
						newField.setValue("");
					}
					else {
						newField.setValue(rs.getObject(name)+"");
					}
					fieldList.add(newField);
				}
				rtnList.add(fieldList);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
		return rtnList;
	}

	public static boolean isEmpty(String value) {
	    if(value == null || value.equals("")) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	
	public static void  main(String args[]) {
		CaseCreatePrivilegeSql test = new CaseCreatePrivilegeSql();
	}
}
