package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class PersonalDetailsSteps extends CommonMethods{
	
	@When("I enter employee details as {string}, {string}, {string}")
	public void i_enter_employee_details(String fName, String mName, String lName) {
	    
	    	sendText(addEmp.firstName, fName);
	    	sendText(addEmp.middleName, mName);
	    	sendText(addEmp.lastName, lName);
	    
	}

	@Then("I am able to modify Employee Details")
	public void i_am_able_to_modify_Employee_Details(DataTable modifyEmpDetails) {
		List<Map<String, String>> modifyList=modifyEmpDetails.asMaps();
		for(Map<String, String> map:modifyList) {
			//click on edit
			waitForClickability(pdetails.edit_saveBtn);
			click(pdetails.edit_saveBtn);
			sendText(pdetails.txtLicenNo, map.get("DriverLisence"));
			sendText(pdetails.txtLicenExpDate, map.get("ExpirationDate"));
			sendText(pdetails.txtSSN, map.get("SSN"));
			sendText(pdetails.txtSIN, map.get("SIN"));
			sendText(pdetails.DOB, map.get("DateOfBirth"));
			pdetails.selectGender(map.get("Gender"));
			selectDdValue(pdetails.selectNation, map.get("Nationality"));
			selectDdValue(pdetails.maritalSt, map.get("MaritalStatus"));
			
			//click on save
			click(pdetails.edit_saveBtn);
			}
	}
}
