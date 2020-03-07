package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.junit.Test;

public class StoringDataFromDb {
	
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbURL = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
//	@Test
//	public void getAndStoreData() throws SQLException {
//		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
//		Statement st = con.createStatement();
//		ResultSet rset = st.executeQuery("select id, name, country_code from ohrm_location");
//		ResultSetMetaData rsetData = rset.getMetaData();
//
//		List<Map<String, String>> listData = new ArrayList<>();
//		
//		while(rset.next()) {
//			Map<String, String> map = new LinkedHashMap<>();
//			map.put("id", rset.getObject("id").toString());
//			map.put("name", rset.getObject("name").toString());
//			map.put("country_code", rset.getObject("country_code").toString());
//			
//			listData.add(map);
//		}
//		for(Map<String, String> map:listData) {
//			System.out.println(map);
//		}
//	}
	
	@Test
	public void getAndStoreDataEnhanced() throws SQLException {
		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Statement st = con.createStatement();
		ResultSet rset = st.executeQuery("select * from ohrm_location");
		ResultSetMetaData rsetData = rset.getMetaData();
		
		List<Map<String, String>> listData = new ArrayList<>();
		Map<String, String> rowMap;
		
		while (rset.next()) {
			rowMap =new LinkedHashMap<>();
			for ( int i=1; i<rsetData.getColumnCount(); i++) {
			rowMap.put(rsetData.getColumnName(i), rset.getObject(i).toString());
			
			}
			listData.add(rowMap);
		}
			
		System.out.println(listData);
		
		for(Map<String, String> map:listData) {
			System.out.println(map);
		}
	}
}
