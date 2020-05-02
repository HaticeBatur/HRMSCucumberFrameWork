package com.hrms.steps;

import java.util.*;

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
		System.out.println("HALIDE ID from UI-->" + AddEmpSteps.employeeID);
		
		//Verify the employee and store the data of this employee in form of MAP
		Map<String, String> mapOfEmployee = new LinkedHashMap<>();
		String emplIDfromDatabase;
		boolean idMatch=false;
	    for (Map<String, String> rowMap:listData) {
	    
	    	for(Map.Entry each:rowMap.entrySet()) {
	    		if(each.getKey().equals("employee_id")) {
	    		emplIDfromDatabase = each.getValue().toString();
	    		if(emplIDfromDatabase.equals(AddEmpSteps.employeeID)) {
	    			idMatch=true;
	    			System.out.println("Data are matching from UI and Database for Employee --> " + expected);
	    		    mapOfEmployee.putAll(rowMap);
	    			break;
	    		}
	    	  }
	    	} 	
	    }
	    Assert.assertTrue(idMatch);
	    
	   System.out.println("MAP OF EMPLOYEE " +mapOfEmployee);
	   
	   //Verify the employee only by its ID
	   for(Map<String, String> map:listData) {
		  String id = map.get("employee_id");
		  if(id.equals(AddEmpSteps.employeeID)) {
			  System.out.println("HALIDE ID from Database-->"+id);
		  }
	   }
	}
}
