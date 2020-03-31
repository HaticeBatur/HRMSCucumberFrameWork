package com.hrms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DbUtils {
	
	private static Connection conn;
	private static Statement st;
	private static ResultSet rset;
	private static List<Map<String,String>> listData;
	
	public static void createConnection () {
		try {
			conn = DriverManager.getConnection(ConfigsReader.getProperty("dbUrl"), 
					ConfigsReader.getProperty("dbUsername"), ConfigsReader.getProperty("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Retrieves data and stored inside List<Map>
	 * return List<Map<String, String>>
	 */
	public static List<Map<String, String>> storeDataFromDB (String sqlQuery){
		try {
			st = conn.createStatement();
			rset = st.executeQuery(sqlQuery);
			ResultSetMetaData rsetData = rset.getMetaData();
			
			listData = new ArrayList<>();
			Map<String, String> rowMap;
			
			while (rset.next()) {
				rowMap = new LinkedHashMap<>();
				for(int i=1; i<=rsetData.getColumnCount(); i++) {
					rowMap.put(rsetData.getColumnName(i), rset.getObject(i).toString());
				}
				listData.add(rowMap);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listData;
	}
	
	public static void closeResources () {
		try {
			
			if(rset!=null) {
				rset.close();
			}
			if(rset!=null) {
				st.close();
			}
			if(rset!=null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
