package deepspot.basic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import deepspot.util.DB;

public class DbUtil {
	
	public boolean executeUpdate(String sql) {
		if(sql==null || sql.trim().length()==0){
			return false;
		}
		boolean rtnFlag = true;
		DB db;
		try {
			db=new DB();
			db.executeUpdate(sql);
			if(db.hasError()){
				rtnFlag = false;
			}
			db.close();
		} catch(Exception e) {
			rtnFlag = false;
			e.printStackTrace();
		} finally {
			db=null;
		}
		return rtnFlag;
	}
	
	public boolean executeUpdate(List<String> sqlList) {
		if(sqlList==null || sqlList.size()==0){
			return false;
		}
		boolean rtnFlag = true;
		DB db;
		String sqlStr=null;
		try {
			db=new DB();
			if(sqlList.size()>1){
				db.setAutoCommit(false);
			}	
			for(Iterator<String> itr=sqlList.iterator(); itr.hasNext();){
				sqlStr=(String)itr.next();
				if(sqlStr.trim().length()>0){
					db.executeUpdate(sqlStr);
					//System.out.println(sqlStr);
				}
			}
			if(sqlList.size()>1){
				if(db.hasError()){
					db.rollback();
				} else {
					db.commit();
				}
			}
			if(db.hasError()){
				rtnFlag = false;
			}
			db.close();
		} catch(Exception e) {
			rtnFlag = false;
			e.printStackTrace();
		} finally {
			db=null;
		}
		return rtnFlag;
	}
	
	public String getUpdateSQL(String tableName, List<Field> dbFields){
		if(tableName==null || tableName.trim().length()==0 
				|| dbFields==null || dbFields.size()==0){
			return Cnstnts.EMPTY_STRING;
		}
		DB db = new DB();
		String sqlStr="update "+tableName;
		String flowKey = Cnstnts.EMPTY_STRING;
		StringBuffer fields = new StringBuffer(" set ");
		int i=0;
		for(Iterator<Field> itr=dbFields.iterator();itr.hasNext();){
			Field field = (Field)itr.next();
			String fieldName = field.getName();
			String fieldValue = field.getValue();
			if(fieldName.equals("FlowKey")){
				flowKey = fieldValue;
			} else {
				i++;
				if(!Cnstnts.INT.equals(field.getDbType())){
					fieldValue = "'"+fieldValue+"'";
					if(field.getDbType().indexOf(Cnstnts.DB_TYPE_NVARCHAR)!=-1){
						if(db.DBTYPE.equals(Cnstnts.MSSQL)){
							fieldValue = "N"+fieldValue;
						}
					}
				}
				if(i==1){
					fields.append(fieldName+"="+fieldValue);
				} else {
					fields.append(","+fieldName+"="+fieldValue);
				}
			}
		}
		if(flowKey.equals(Cnstnts.EMPTY_STRING)) {
			sqlStr = Cnstnts.EMPTY_STRING;
		} else {
			sqlStr += fields.append(" where FlowKey='"+flowKey+"'").toString();
		}
		db=null;
		return sqlStr;
	}
	
	public String getInsertSQL(String tableName,List<Field> dbFields){
		if(tableName==null || tableName.trim().length()==0 
				|| dbFields==null || dbFields.size()==0){
			return Cnstnts.EMPTY_STRING;
		}
		DB db = new DB();
		String sqlStr="insert into "+tableName;
		StringBuffer fields = new StringBuffer("(");
		StringBuffer values = new StringBuffer("values(");
		int i=0;
		for(Iterator<Field> itr=dbFields.iterator();itr.hasNext();i++){
			Field field = (Field)itr.next();
			String fieldName = field.getName();
			String fieldValue = field.getValue();
			if(!field.getDbType().equals(Cnstnts.INT)){
				fieldValue = "'"+fieldValue+"'";
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
		db=null;
		return sqlStr;
	}
	
	public String getDetailInsertSQL(Field flowKey,int seq_no,
									 List<Field> detailFields) {
		if(flowKey==null || detailFields==null || detailFields.size()==0){
			return Cnstnts.EMPTY_STRING;
		}
		DB db = new DB();
		String sqlStr="insert into "+flowKey.getTableName()+"_detail";
		StringBuffer fields = new StringBuffer("("+flowKey.getName()+",Seq_no");
		StringBuffer values = new StringBuffer("values('"+flowKey.getValue()+"',"+seq_no);
		for(Iterator<Field> itr=detailFields.iterator();itr.hasNext();){
			Field field = (Field)itr.next();
			if(!field.getName().equals("FlowKey") && !field.getName().equals("Seq_no")){
				String fieldName = field.getName();
				String fieldValue = field.getValue();
				if(!field.getDbType().equals(Cnstnts.INT)){
					fieldValue = "'"+fieldValue+"'";
					if(field.getDbType().indexOf(Cnstnts.DB_TYPE_NVARCHAR)!=-1){
						if(db.DBTYPE.equals(Cnstnts.MSSQL)){
							fieldValue = "N"+fieldValue;
						}
					}
				}
				fields.append(","+fieldName);
				values.append(","+fieldValue);
			}
		}
		sqlStr += fields.append(")").toString()+values.append(")").toString();
		db=null;
		return sqlStr;
	}
	
	public List<SelectItem> getList(Field field, Properties mapingPrpt) throws Exception {
		DB db;
		ResultSet rs;
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		String sqlStr="select * from "+field.getTableName()+" order by FlowKey";
		try {
			db=new DB();
			rs=db.executeQuery(sqlStr);
			while(rs.next()) {
				String key = rs.getObject(field.getName()).toString();
				String value = mapingPrpt.getProperty(key);
				if(value.length()>20){
					value = value.substring(0,20)+"...";
				}
				if(value==null){
					value = key;
				} else {
					value = key+"-"+value;
				}
				rtnList.add(new SelectItem(key,value));
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return rtnList;
	}
	
	public List<SelectItem> getChildList(SelectItem item, Field parentField,
										 Field nameField, Field flagField){
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		DB db;
		ResultSet rs;
		String sqlStr = "select * from " + nameField.getTableName() +
						" where "+parentField.getName()+"='" + item.getKey() + "'";
		String preChar = Cnstnts.EMPTY_STRING;
		for(int i=0; i<item.getLayer(); i++){
			preChar += "&nbsp;&nbsp;&nbsp;";
		}
		try {
			db = new DB();
			rs = db.executeQuery(sqlStr);
			while(rs.next()) {
				String key = rs.getString("FlowKey");
				String value = rs.getObject(nameField.getName()).toString();
				if(value.length()>20){
					value = value.substring(0,20)+"...";
				}
				boolean hasChild = false;
				if(rs.getString(flagField.getName()).equals("Y")){
					hasChild = true;
				}
				SelectItem childItem = new SelectItem(key,preChar+key+"-"+value);
				childItem.setParentKey(item.getKey());
				childItem.setLayer(item.getLayer()+1);
				childItem.setChildFlag(hasChild);
				childItem.setOnlyMenuFlag(item.onlyMenu());
				if(item.onlyMenu()){
					if(childItem.hasChild()){
						rtnList.add(childItem);
					}
				} else {
					rtnList.add(childItem);
				}
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			db = null;
		}
		return rtnList;
	}
	
	public List<SelectItem> getChildList(SelectItem item, Field parentField,
			 Field nameField, Field flagField, Field dateField){
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		if(!item.hasChild()){
			return rtnList;
		}
		DB db;
		ResultSet rs;
		String sqlStr = "select * from " + nameField.getTableName() +
						" where "+parentField.getName()+"='" + item.getKey() + "'"+
						" and "+dateField.getName()+"<='" + dateField.getValue() + "'";
		//System.out.println(sqlStr);
		String preChar = Cnstnts.EMPTY_STRING;
		for(int i=0; i<item.getLayer(); i++){
			preChar += "&nbsp;&nbsp;&nbsp;";
		}
		try {
			db = new DB();
			rs = db.executeQuery(sqlStr);
			while(rs.next()) {
				String key = rs.getString("FlowKey");
				String value = rs.getObject(nameField.getName()).toString();
				boolean hasChild = false;
				if(rs.getString(flagField.getName()).equals("Y")){
					hasChild = true;
				}
				SelectItem childItem = new SelectItem(key,preChar+key+"-"+value);
				childItem.setParentKey(item.getKey());
				childItem.setLayer(item.getLayer()+1);
				childItem.setChildFlag(hasChild);
				childItem.setOnlyMenuFlag(item.onlyMenu());
				if(item.onlyMenu()){
					if(childItem.hasChild()){
						rtnList.add(childItem);
					}
				} else {
					rtnList.add(childItem);
				}
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			db = null;
		}
		return rtnList;
	}
	
	public List<SelectItem> getSelectItemList(String SQL, Field field) throws Exception {
		DB db;
		ResultSet rs;
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		try {
			db=new DB();
			rs=db.executeQuery(SQL);
			while(rs.next()) {
				String key = rs.getString("FlowKey");
				String value = rs.getObject(field.getName()).toString();
				if(value.length()>20){
					value = value.substring(0,20)+"...";
				}
				if(value==null) {
					value = key;
				} else {
					if(value.trim().length()>0){
						value = key + "-" + value;
					} else {
						value = key;
					}
				}
				rtnList.add(new SelectItem(key,value));
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return rtnList;
	}
	
	public List<SelectItem> getSelectItemList(String SQL, Field field, int legth) throws Exception {
		DB db;
		ResultSet rs;
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		try {
			db=new DB();
			rs=db.executeQuery(SQL);
			while(rs.next()) {
				String key = rs.getString("FlowKey");
				String value = rs.getObject(field.getName()).toString();
				if(value.length()>legth){
					value = value.substring(0,legth)+"...";
				}
				if(value==null) {
					value = key;
				} else {
					if(value.trim().length()>0){
						value = key + "-" + value;
					} else {
						value = key;
					}
				}
				rtnList.add(new SelectItem(key,value));
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return rtnList;
	}
	
	public List<SelectItem> getSelectItemUnitNameList(String SQL, Field unitField1, Field unitField2) throws Exception {
		DB db;
		ResultSet rs;
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		try {
			db=new DB();
			rs=db.executeQuery(SQL);
			while(rs.next()) {
				String key = rs.getString("FlowKey");
				String value = rs.getObject(unitField1.getName()).toString()+
							   "-"+rs.getObject(unitField2.getName()).toString();
				
				rtnList.add(new SelectItem(key,value));
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return rtnList;
	}
	
	public List<SelectItem> getSelectItemList(String SQL, 
				Field keyField, Field valueField) throws Exception {
		DB db;
		ResultSet rs;
		List<SelectItem> rtnList = new ArrayList<SelectItem>();
		try {
			db=new DB();
			rs=db.executeQuery(SQL);
			while(rs.next()) {
				String key = rs.getString(keyField.getName());
				String value = Cnstnts.EMPTY_STRING;
				if(valueField!=null){
					value = rs.getString(valueField.getName());
					if(value.length()>20){
						value = value.substring(0,20)+"...";
					}
				}
				rtnList.add(new SelectItem(key,value));
			}		
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return rtnList;
	}
	
	public Properties getNamesPrpts(Field field) throws Exception {
		DB db=null;
		ResultSet rs=null;
		Properties rtnPrpt = new Properties();
		rtnPrpt.setProperty(Cnstnts.EMPTY_STRING, Cnstnts.EMPTY_STRING);
		String sqlStr="select * from "+field.getTableName()+" order by FlowKey";
		try {
			db=new DB();
			rs=db.executeQuery(sqlStr);
			while(rs.next()) {
				rtnPrpt.setProperty(rs.getString("FlowKey"),
									rs.getObject(field.getName()).toString());
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return rtnPrpt;
	}
	
	public Properties getNamesPrpts(Field field1,Field field2) throws Exception {
		DB db=null;
		ResultSet rs=null;
		Properties rtnPrpt = new Properties();
		rtnPrpt.setProperty(Cnstnts.EMPTY_STRING, Cnstnts.EMPTY_STRING);
		String sqlStr="select * from "+field1.getTableName()+" order by FlowKey";
		try {
			db=new DB();
			rs=db.executeQuery(sqlStr);
			while(rs.next()) {
				rtnPrpt.setProperty(rs.getString("FlowKey"),
									rs.getObject(field1.getName()).toString()+"-"+
									rs.getObject(field2.getName()).toString());
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return rtnPrpt;
	}
	
	public Properties getFieldPrpts(String SQL,String fieldName) throws Exception {
		DB db=null;
		ResultSet rs=null;
		Properties rtnPrpt = new Properties();
		rtnPrpt.setProperty(Cnstnts.EMPTY_STRING, Cnstnts.EMPTY_STRING);
		try {
			db=new DB();
			rs=db.executeQuery(SQL);
			while(rs.next()) {
				rtnPrpt.setProperty(rs.getString("FlowKey"),
									rs.getObject(fieldName).toString());
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return rtnPrpt;
	}
	
	public boolean chkPkey(Field field) {
		String SQL = "select * from "+field.getTableName()+
					 " where "+field.getName()+"='"+field.getValue()+"'";
		return this.chkPkey(SQL);
	}
	
	public boolean chkPkey(String SQL) {
		DB db=null;
		ResultSet rs=null;
		boolean rtnFlag=false;
		try {
			db=new DB();
			rs=db.executeQuery(SQL);
			if(rs.next()) {
				rtnFlag=true;
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return rtnFlag;
	}
	
	public HashMap<String, String> getAttributesMap(Field FlowKey, HashMap<?, ?> attributeMap) {
		HashMap<String, String> attsMap = new HashMap<String, String>();
		if(attributeMap==null)
			return attsMap;
		Set<?> attsKeySet = attributeMap.keySet();
		DB db=null;
		ResultSet rs=null;
		String sqlStr="select * from "+FlowKey.getTableName()+
					  " where FlowKey='"+FlowKey.getValue()+"'";
		try {
			db=new DB();
			rs=db.executeQuery(sqlStr);
			if(rs.next()) {
				for(Iterator<?> itr=attsKeySet.iterator();itr.hasNext();){
					String attributeName = (String)itr.next();
					if(attributeName.equals("TableName")){
						attsMap.put(attributeName,FlowKey.getTableName());
					} else {
						attsMap.put(attributeName,rs.getObject(attributeName).toString());
					}
				}
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return attsMap;
	}
	
	public HashMap<String, String> getDocMap(String SQL, HashMap<?, ?> attributeMap) {
		HashMap<String, String> attsMap = new HashMap<String, String>();
		if(attributeMap==null)
			return attsMap;
		Set<?> attsKeySet = attributeMap.keySet();
		DB db=null;
		ResultSet rs=null;
		try {
			db=new DB();
			rs=db.executeQuery(SQL);
			if(rs.next()) {
				for(Iterator<?> itr=attsKeySet.iterator();itr.hasNext();){
					String attributeName = (String)itr.next();
					if(!attributeName.equals("TableName")){
						attsMap.put("${"+attributeName+"}",rs.getObject(attributeName).toString());
					}
				}
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return attsMap;
	}
	
	public List<Object[]> getList(String SQL, Field[] fields) throws Exception{
		DB db=null;
		ResultSet rs=null;
		List<Object[]> lst=new ArrayList<Object[]>();
		try {
			db=new DB();
			rs=db.executeQuery(SQL);
			while(rs.next()) {
				Object[] findData = new String[fields.length+1];
				findData[0]=rs.getObject("FlowKey");
				for(int i=1;i<=fields.length;i++){
					findData[i]=rs.getString(fields[i-1].getName());
				}
				lst.add(findData);
			}
			rs.close();
			db.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs=null;
			db=null;
		}
		return lst;
	}
	
	public void getAttribute(Field FlowKey, List<Field> fields) {
		DB db;
		ResultSet rs;
		String sqlStr = "select * from " + FlowKey.getTableName()
				+ " where FlowKey='" + FlowKey.getValue() + "'";
		try {
			db = new DB();
			rs = db.executeQuery(sqlStr);
			if (rs != null && rs.next()) {
				for(Iterator<Field> itr=fields.iterator();itr.hasNext();){
					Field field = (Field)itr.next();
					if(rs.getObject(field.getName())!=null){
						field.setValue(rs.getObject(field.getName()).toString());
					} else {
						field.setValue(Cnstnts.EMPTY_STRING);
					}
				}
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			db = null;
		}
	}
	
	public void getAttribute(String SQL, List<Field> fields) {
		DB db;
		ResultSet rs;
		try {
			db = new DB();
			rs = db.executeQuery(SQL);
			if (rs != null && rs.next()) {
				for(Iterator<Field> itr=fields.iterator();itr.hasNext();){
					Field field = (Field)itr.next();
					field.setValue(rs.getObject(field.getName()).toString());
				}
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			db = null;
		}
	}
	
	public List<List<Field>> getFieldsList(String SQL, List<Field> fields){
		List<List<Field>> rtnList = new ArrayList<List<Field>>();
		DB db;
		ResultSet rs;
		try {
			db = new DB();
			rs = db.executeQuery(SQL);
			while (rs.next()) {
				List<Field> fieldList = new ArrayList<Field>();
				for(Iterator<Field> itr=fields.iterator();itr.hasNext();){
					Field field = (Field)itr.next();
					Field newField = new Field(field.getName(),field.getTableName());
					newField.setAliasName(field.getAliasName());
					newField.setLinkFlag1(field.linkFlag1());
					newField.setShowFlag(field.showFlag());
					newField.setLinkMode1(field.getLinkMode1());
					newField.setLinkParameter1(field.getLinkParameter1());
					newField.setDbActionMode1(field.getDbActionMode1());
					newField.setLinkFlag2(field.linkFlag2());
					newField.setLinkMode2(field.getLinkMode2());
					newField.setLinkParameter2(field.getLinkParameter2());
					newField.setDbActionMode2(field.getDbActionMode2());
					newField.setListWidth(field.getListWidth());
					newField.setAlign(field.getAlign());
					newField.setHtmlType(field.getHtmlType());
					if(field!=null && rs.getObject(field.getName())!=null){
						newField.setValue(rs.getObject(field.getName()).toString());
					} else {
						newField.setValue(Cnstnts.EMPTY_STRING);
					}
					fieldList.add(newField);
				}
				rtnList.add(fieldList);
			}
			rs.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			db = null;
		}
		return rtnList;
	}
	
	public String getFieldValue(String SQL, Field field) {
		String rtnString = Cnstnts.EMPTY_STRING;
		if(field==null){
			return rtnString;
		}
		DB db;
		ResultSet rs;
		int totalcount=0;
		try {
			db = new DB();
			rs = db.executeQuery(SQL);
			
			while (rs.next()) {
				rtnString = rs.getString(field.getName());
				if(rtnString==null){
					rtnString = Cnstnts.EMPTY_STRING;
				}
				totalcount+=1;
				break;
			}
			
			rs.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			db = null;
		}
		return rtnString;
	}

}
