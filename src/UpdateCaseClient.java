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


public class UpdateCaseClient {
	Properties deptProp;
	DbUtil dbUtil;
	DB db;
	Map<String, Employee> emps = new HashMap<String, Employee>();

	public String insertSql = "insert into CasePrivilege(FlowKey,Applicant,CreateDept,ParentId,EmployeeId,Names,Title,DeptId,DeptName,Privilege,CaseType,CreateFrom,CaseKey,PrivilegeKind) " +
			"values (\"%s\",\"admin\",\"Demo\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"E\")";
	
	public UpdateCaseClient() {
		try {
			dbUtil = new DbUtil();
			db=new DB();
			int line = 0;
			int file = 0;
			BufferedWriter bw = bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream( new File("c:/updateCaseClient" + file + ".sql")), "UTF-8"));
			
			
			String[] cass = {"patentcase", "trademarkcase", "legalcase", "copyrightcase"};
			String[] applydates = {"ApplyDate", "FillingDate", ".TargetStartDate", "TargetFinishDate"};
			String[] createdates = {"CaseStartDate", "AttorneyDate", "TargetStartDate", "TmpField_05"};
			System.out.println("start in " + new Date());
			for(int i=0;i<1;i++) {
				System.out.println("start do " + cass[i]);
				
				String sql = "SELECT DISTINCT client FROM  `" + cass[i] + "` ";
				List<String> clients = getValueList(sql, "client");
				for(String client : clients) {
					sql = "SELECT companyname FROM client where flowkey ='" + client + "'";

					String companyname = getFieldValue(sql, "companyname");
					
					bw.write("update " + cass[i] + " set clientname='" + companyname + "' where client ='" + client + "';" + Cnstnts.NEW_LINE);
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
		UpdateCaseClient test = new UpdateCaseClient();
	}
	

	
	public static String arrayToIncond(Object[] array) {
		String result = "''";
		if(array != null) {
			for(Object o : array) {
				try {
					String s = o.toString();
					if(!isEmpty(s)) {
						if(result.equals("''")) {
							result = "'" + s + "'";
	 					}
						else {
							result += ",'" + s + "'";
						}
					}
				}
				catch(Exception e) {}
			}
			
		}
		
		return result;
	}
}
