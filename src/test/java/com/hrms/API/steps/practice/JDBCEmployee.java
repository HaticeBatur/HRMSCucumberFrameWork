package com.hrms.API.steps.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Then;

public class JDBCEmployee {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbURL = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	String query= "select emp_number, emp_firstname, emp_middle_name, emp_lastname,"
			+ "emp_marital_status, emp_birthday  from hs_hr_employees order by emp_number";
	public static int employeeNumber;
	@Then("find emp number in JDBC")
	public void find_emp_number_in_JDBC() throws SQLException {
		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		System.out.println("Connection is created ");
		Statement st = conn.createStatement();
		ResultSet rset = st.executeQuery(query);
		ResultSetMetaData resultData = rset.getMetaData();
		int columns = resultData.getColumnCount();
		rset = st.executeQuery(query);
		List<Map<String, String>> employeeList = new ArrayList<>();
		
		while(rset.next()) {
			Map<String, String> map = new LinkedHashMap<>();
			for(int j=1; j<=columns; j++) {
				String key = resultData.getColumnName(j);
				String value ;
				if(rset.getObject(j)!=null) {
					value = rset.getObject(j).toString();
					if(value.equals("")) {
						map.put(key, null);
					}else {
					map.put(key, value);
					}
				}else {
					map.put(key, null);
				}
			}
			employeeList.add(map);
		}
		System.out.println("LIST OF EMPLOYEE -->");
		for(Map<String, String> mapEmp : employeeList) {
		System.out.println(mapEmp);
		employeeNumber++;
		}
		System.out.println("EMPLOYEE NUMBER --> " + employeeNumber);
		rset.close();
		st.close();
		conn.close();
	}
}
