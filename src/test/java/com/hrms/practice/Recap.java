package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Recap {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbURL = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
	@Test
	public void gettingConnected () throws SQLException {
		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		DatabaseMetaData dbMateData = con.getMetaData();
		String dbName = dbMateData.getDatabaseProductName();
		Statement st = con.createStatement();
		
		ResultSet rset = st.executeQuery("select * from ohrm_skill");
		ResultSetMetaData rsetMetaData = rset.getMetaData();
		int cols = rsetMetaData.getColumnCount();
		List <String > colList = new ArrayList<String>();
		for (int i=1; i<=cols; i++){
			colList.add(rsetMetaData.getColumnName(i));
		}
		System.out.println("Column List " + colList);
		
		String id;
		String skills;
		
		while (rset.next()) {
			id = rset.getObject("id").toString();
			skills = rset.getObject("name").toString();
			System.out.println(id+ " = "+skills);
		}
		rset.close();
		st.close();
		con.close();
	}
}
