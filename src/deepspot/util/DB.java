package deepspot.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.util.Vector;
import java.util.Iterator;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import deepspot.basic.Cnstnts;

public class DB{
	
	public static int getConnectionNumber = 0;
	
	public static String SQL_IFNULL = "IFNULL";
	public static String SQL_SUBSTR = "SUBSTR";
	public static String SQL_LENGTH = "LENGTH";
	public static String DBTYPE = Cnstnts.MYSQL;
  
	final String DATASOURCE = "java:comp/env/jdbc/dbInfo";
	/*
	final String DNS = "jdbc:jtds:sqlserver://localhost:1433/case";
	final String DRIVERS = "net.sourceforge.jtds.jdbc.Driver";
	final String USER = "sa";
	final String PASSWD = "gp2u03";
	*/
	private String DNS = "jdbc:mysql://localhost:3306/hh?useUnicode=true&amp;characterEncoding=utf-8";
	private String DRIVERS = "com.mysql.jdbc.Driver";
	private String USER = "root";
	private String PASSWD = "gp2u03";
//	private String PASSWD = "chi";
  
	private DataSource datasource;
	private Connection myConn;
	private Statement stmt;
	private PreparedStatement prestmt;
  
	private boolean autoCommit = true;
  
	private boolean errorFlag = false;
	public boolean hasError(){
		return this.errorFlag;
	}
  
	public DB() {
		try {
			Context ctx = new InitialContext();
			datasource  = (DataSource)ctx.lookup(DATASOURCE);
			myConn = datasource.getConnection();
			stmt = myConn.createStatement();
			
			getConnectionNumber++;
//			System.out.println("getConnection times : " + getConnectionNumber);
			try {
				throw new Exception();
			}
			catch(Exception e) {
//				StackTraceElement[] elms = e.getStackTrace();
//				for(int i=elms.length-1;i>=0;i--) {
//					if(elms[i].toString().startsWith("deepspot")) {
//						System.out.println(elms[i]);
//						System.out.println(elms[i-1]);
//						System.out.println(elms[9]);
//						System.out.println(elms[8]);
//						System.out.println(elms[7]);
////						System.out.println(elms[6]);
////						System.out.println(elms[5]);
////						System.out.println(elms[4]);
////						System.out.println(elms[3]);
////						System.out.println(elms[2]);
//						System.out.println(elms[1]);
//						System.out.println();
//						break;
//					}
//				}
//				e.printStackTrace();
//				System.out.println();
//				System.out.println();
			}
		} catch(Exception e) {
			try {
				Class.forName(DRIVERS).newInstance();
				myConn = DriverManager.getConnection(DNS, USER, PASSWD);
				stmt = myConn.createStatement();
			} catch(Exception ex){
				ex.printStackTrace();
			}
		}
 	}
  
	public DB(String sql) {
		try {
			Context ctx = new InitialContext();
			datasource  = (DataSource)ctx.lookup(DATASOURCE);
			myConn = datasource.getConnection();
			prestmt = myConn.prepareStatement(sql);
		} catch(Exception e) {
			try {
				Class.forName(DRIVERS).newInstance();
				myConn = DriverManager.getConnection(DNS, USER, PASSWD);
				prestmt = myConn.prepareStatement(sql);
			} catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
  
	public void setAutoCommit(boolean autoCommit) throws SQLException{
		this.autoCommit = autoCommit;
		myConn.setAutoCommit(this.autoCommit);
	}
  
	public void rollback() throws SQLException{
		if(!this.autoCommit){
			myConn.rollback();
		}
	}
  
	public void commit() throws SQLException{
		if(!this.autoCommit){
			myConn.commit();
		}
	}

	public void setString(int index,String value){
		try{
			prestmt.setString(index,value);
		} catch(Exception e){
			e.printStackTrace();
			this.errorFlag=true;
		}
	}
  
	public void setInt(int index,int value){
		try{
  	   prestmt.setInt(index,value);
		} catch(Exception e){
			e.printStackTrace();
			this.errorFlag=true;
		}
	}
  
	public void clearParameters(){
		try{
			prestmt.clearParameters();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
  
	public ResultSet executeQuery(String sql){
		try{
			if(stmt != null){
				return stmt.executeQuery(sql);
			}
			else return null;
		} catch(Exception e){
			System.out.println(sql);
			e.printStackTrace();
			this.errorFlag=true;
			return null;
		}
	}
  
	public ResultSet executeQuery(){
		try{
			if(prestmt != null)
				return prestmt.executeQuery();
			else return null;
		} catch(Exception e){
			e.printStackTrace();
			this.errorFlag=true;
			return null;
		}
	}
  
	public void executeUpdate(String sql){
		try{
			if(stmt != null)
				stmt.executeUpdate(sql);
		} catch(Exception e){
			System.out.println(sql);
			e.printStackTrace();
			this.errorFlag=true;
		}  
	}
  
	public void executeUpdate(){
		try{
			if(prestmt != null)
				prestmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
			this.errorFlag=true;
		}
	}

	public void close(){
		try{
			if (stmt != null){
				stmt.close();
			}
			if (prestmt != null){
				prestmt.close();
			}	
			myConn.close();
		} catch(Exception e){
			e.printStackTrace();      
		} finally {
			stmt = null;
			prestmt = null;
			myConn =null;
		}
	}
  
	public Iterator getTables() {
		Vector<String> tablesVtr = new Vector<String>();
		DatabaseMetaData dbmd;
		String[] tableTypes = {"TABLE"};
		ResultSet rs;
		try {
			dbmd = myConn.getMetaData();
			rs = dbmd.getTables(null,null,null,tableTypes);
			while(rs.next()) {
				String tableName = rs.getString("TABLE_NAME");
				tablesVtr.add(tableName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
		return tablesVtr.iterator();
	}
  
	public boolean chkTable(String tableName) {
		boolean rtnFlag = false;
		DatabaseMetaData dbmd;
		String[] tableTypes = {"TABLE"};
		ResultSet rs;
		try {
			dbmd = myConn.getMetaData();
			rs = dbmd.getTables(null,null,null,tableTypes);
			while(rs.next()) {
				String table_name = rs.getString("TABLE_NAME");
				if(table_name.equals(tableName)) {        
					rtnFlag = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
		return rtnFlag;
	}
  
}