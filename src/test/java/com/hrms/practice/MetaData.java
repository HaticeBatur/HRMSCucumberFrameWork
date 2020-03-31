package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaData {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test 
	public void getMetaData () throws SQLException {
		Connection c = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		DatabaseMetaData dbData = c.getMetaData();
		
		String dbname = dbData.getDatabaseProductName();
		String dbversion = dbData.getDatabaseProductVersion();
		System.out.println(dbname);
		System.out.println(dbversion);
		
		Statement st = c.createStatement();
		ResultSet rset = st.executeQuery("select * from hs_hr_employees where emp_number = 4347");
		ResultSetMetaData resultData = rset.getMetaData();
		
		int cols = resultData.getColumnCount();
		System.out.println(cols);
		System.out.println("-----------RESULTSET ----------");
		
		while(rset.next()){
			for(int i=1; i<=cols; i++) {
			if(rset.getObject(resultData.getColumnName(i))==null);
			else System.out.println(rset.getObject(resultData.getColumnName(i).toString()));
			}
		}
		
//		String colname=resultData.getColumnName(1);
//		System.out.println("&&&&&&&&&& "+colname);
	System.out.println("-----------RESULTSET METADATA----------");
		String colName;
			for(int i=1; i<=cols; i++) {
				colName = resultData.getColumnName(i);
				System.out.println(colName);
			}
			rset.close();
			st.close();
			c.close();
		}
	
	}

