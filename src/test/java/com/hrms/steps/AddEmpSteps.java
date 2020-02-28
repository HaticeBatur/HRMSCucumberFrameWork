package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmpSteps extends CommonMethods{
	
	@Given("I logged into HRMS")
	public void i_logged_into_HRMS() {
	   login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}
	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
		dashboard.navigateToAddEmployee();
	}
	@When("I add {string} , {string} and {string}")
	public void i_add_and(String fName, String mName, String lName) {
	sendText(addEmp.firstName, fName);
	sendText(addEmp.middleName, mName);
	sendText(addEmp.lastName, lName);
	}
	@When("I click Save")
	public void i_click_Save(){
		click(addEmp.btnSave);
	}	
	@Then("i see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String string, String string2, String string3) {
		String actFirstName=pdetails.firstName.getAttribute("value");
		String actMiddleName=pdetails.middleName.getAttribute("value");
		String actLastName=pdetails.lastName.getAttribute("value");
		Assert.assertTrue("First name MISMATCH", string.equals(actFirstName));		
		Assert.assertTrue("Middle name MISMATCH", string2.equals(actMiddleName));		
		Assert.assertTrue("Last name MISMATCH", string3.equals(actLastName));
	}
	@When("I delete employee id")
	public void i_delete_employee_id() {
	    addEmp.employeeId.clear();
	}
	@Then("I see employee without employee id is being added")
	public void i_see_employee_without_employee_id_is_being_added() {
		boolean error= pdetails.lbpDetails.isDisplayed();
	    Assert.assertTrue("Personal details page displayed", error);
	}
	@Then("I see required error message next to the first and last name")
	public void i_see_required_error_message_next_to_the_first_and_last_name() {
	    if(addEmp.reqforFirstname.isDisplayed()) {
	    	Assert.assertEquals("Required", addEmp.reqforFirstname.getText());
	    	System.out.println("Required text is displayed for first name");
	    		if(addEmp.reqforLastname.isDisplayed()) {
	    			Assert.assertEquals("Required", addEmp.reqforLastname.getText());
	    			System.out.println("Required text is displayed for last name");
	    		}else {
	    			Assert.assertFalse("Required text is NOT displayed for last name", true);
	    }}else {
	    	Assert.assertFalse("Required text is NOT displayed", true);
	    }}
	@When("I click on create login details checkbox")
	public void i_click_on_create_login_details_checkbox() {
	    click(addEmp.createLoginDet);
	}
	@When("I enter {string} , {string} and confirm password")
	public void i_enter_and_confirm_password(String userName, String password) {
	    sendText(addEmp.empUsername, userName);
	    sendText(addEmp.userPassword, password);
	    sendText(addEmp.confirmPassword, password);
	}


	
}
