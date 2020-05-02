package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;

import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class POSTCreateEmployeeAPI {
	private static RequestSpecification request;
	private Response response;
	public static Object employeeID;
	
	
	@Given("user calls createEmployee API")
	public void user_calls_createEmployee_API_to_verify_that_an_employee_was_created() {
	    request = given().header("Content-Type", "application/json")
	    	.header("Authorization", SyntaxAPIAuthenticationSteps.Token);
	    request.body(CommonMethods.readJson("createEmployee.json"));
	    
	}

	@When("user receives response from createEmployee")
	public void user_retrieves_response_for_createEmployee_API() {
	    response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
	    System.out.println("Create employee Response --->");
	    response.prettyPrint();
	}

	@Then("status code is {int}")
	public void status_code_is_for_createEmployeeAPI(Integer int1) {
	    response.then().assertThat().statusCode(int1);
	}

	@Then("user validates employee is created")
	public void user_validates_employee_was_created() {
		
		response.then().body("Message", equalTo("Entry Created"));
	    response.then().body("Employee[0].emp_firstname", equalTo("Cristy"));
	    JsonPath jsonPathEvaluator = response.jsonPath();
	    employeeID = jsonPathEvaluator.get("Employee[0].employee_id");
	   System.out.println("New Employee ID is "+ employeeID);   
	}
	  @Then("user keeps the new employee's id")
	    public void user_keeps_the_new_employee_s_id() {
	        Map<String, Object> result = response.jsonPath().get("Employee[0]");
	       System.out.println("Employee Map " + result);
	       employeeID =  result.get("employee_id");
	        System.out.println("Employee id is " +employeeID);
	        
	        List<String> list = response.jsonPath().getList( "Employee");
	        System.out.println("List of employee  is    "+list);
	    }
}
