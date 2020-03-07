package com.hrms.API.steps.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.hrms.API.steps.practice.GetJobTitlesApi;

import cucumber.api.java.en.Then;

public class JDBCJobTitle {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:type driver:host:port/name of the database
	String dbUrl = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
	@Then("user compares the results btw API and SQL")
	public void user_compares_the_results_btw_API_and_SQL() throws SQLException {
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		List <String> listJobTitle = new ArrayList<String>();
		System.out.println("Connection is created");
		Statement st = connection.createStatement();
		ResultSet rset = st.executeQuery("select * from ohrm_job_title");
		
		String data ;
		while (rset.next()) {
			data = rset.getObject("job_title").toString();
			listJobTitle.add(data);
		}
		for(int i=0; i<GetJobTitlesApi.jobTitleArray.length(); i++) {
			String[] jobName =GetJobTitlesApi.jobTitleArray.get(i).toString().split("\"");
			
			for(int j=0; j<jobName.length;) {
				if(jobName[3].equals(listJobTitle.get(i))) {
					System.out.println("Result Match for " + jobName[3] + " AND " +listJobTitle.get(i));
				}else {
					System.out.println("Result DOES NOT Match for " +jobName[3] + " AND " +listJobTitle.get(i));
				}	
				break;
			}
			
			
		}
		rset.close();
		st.close();
		connection.close();
	}
}
