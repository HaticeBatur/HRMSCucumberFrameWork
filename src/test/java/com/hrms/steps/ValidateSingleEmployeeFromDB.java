package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.DbUtils;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class ValidateSingleEmployeeFromDB {
	
	String query="select emp_firstname, emp_middle_name, emp_lastname " + 
			"from hs_hr_employees where employee_id=" + AddEmpSteps.employeeID;
	List<Map<String, String>> singleEmpDatabase;
	@Then("I collect the single employee from database")
	public void i_collect_the_single_employee_from_database() {
	    DbUtils.createConnection();
	    singleEmpDatabase = DbUtils.storeDataFromDB(query);
	}

	@Then("I verify employee data is matching for single employee")
	public void i_verify_employee_data_is_matching_for_single_employee(DataTable singleEmpDataTable) {
		
	    Assert.assertTrue(singleEmpDataTable.asMaps().equals(singleEmpDatabase));
	}
}
