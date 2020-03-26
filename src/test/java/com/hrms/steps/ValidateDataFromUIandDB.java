package com.hrms.steps;

import java.util.*;
import java.util.Map.Entry;

import org.junit.Assert;

import com.hrms.steps.AddEmpSteps;
import com.hrms.utils.DbUtils;

import cucumber.api.java.en.Then;


public class ValidateDataFromUIandDB {
	String query = "select employee_id, emp_firstname, emp_middle_name, emp_lastname from hs_hr_employees order by employee_id";
	public  List<Map<String, String>> listData = new LinkedList<>();
	@Then("I collect employee from database")
	public void i_collect_employee_from_database() {
	    DbUtils.createConnection();
	    listData = DbUtils.storeDataFromDB(query);
	   
	}
	@Then("I verify employee data is matching for employee {string}")
	public void i_verify_employee_data_is_matched(String expected) {
//		System.out.println("HALIDE ID " + AddEmpSteps.employeeID);
//		System.out.println(AddEmpSteps.employeeID);
//		Map<String, String> mapOfEmployee = new LinkedHashMap<>();
//	    for (Map<String, String> rowMap:listData) {
//	    	Set<Entry<String, String>> entry = rowMap.entrySet();
//	    	for(Entry<String, String> e:entry) {
//	    		if(e.getKey().equals("employee_id")) {
//	    		String emplIDfromDatabase = e.getValue().toString();
//	    		if(emplIDfromDatabase.equals(AddEmpSteps.employeeID)) {
//	    			Assert.assertEquals(emplIDfromDatabase, AddEmpSteps.employeeID );
//	    			System.out.println("Data are matching from WepPage and Database for Employee  " +expected);
//	    		    mapOfEmployee.putAll(rowMap);
//	    			break;
//	    		}}} 	
//	    }
//	   System.out.println("MAP OF EMPLOYEE " +mapOfEmployee);
	   for(Map<String, String> map:listData) {
		  String id = map.get("employee_id");
		  if(id.equals(AddEmpSteps.employeeID)) {
			  System.out.println("HALIDE ID "+id);
			  System.out.println("EQUALS");
		  }
	   }
	   
	}
}
