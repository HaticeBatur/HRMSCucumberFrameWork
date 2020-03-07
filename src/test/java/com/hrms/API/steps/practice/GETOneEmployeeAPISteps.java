package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.hrms.utils.APIConstants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class GETOneEmployeeAPISteps {
	RequestSpecification request;
	Response response;
	
	
	@Given("user calling getOneEmployee API")
	public void user_calling_getOneEmployee_API() {
		  request = given().param("employee_id", POSTCreateEmployeeAPI.employeeID)
			   .header("Content-Type", "application/json")
			   .header("Authorization", SyntaxAPIAuthenticationSteps.Token);
	}

	@When("User retrieves response for getOneEployee API")
	public void user_retrieves_response_for_getOneEployee_API() {
	    response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
	    System.out.println("Get One Employee Response is --> ");
	    response.prettyPrint();
	}

	@Then("status code is {int} for getOneEmployee API")
	public void status_code_is_for_getOneEmployee_API(Integer int1) {
	    response.then().assertThat().statusCode(int1);
	}

	@Then("user validates created employee exists")
	public void user_validates_created_employee_exists() {
	    JsonPath jpathEvaluator = response.jsonPath();
	   String actualEmployeeID =  jpathEvaluator.get("employee[0].employee_id");
	   response.then().body("employee[0].employee_id", equalTo(POSTCreateEmployeeAPI.employeeID));
	   
	   try {
		   Assert.assertEquals("Verifying Employee IDs", POSTCreateEmployeeAPI.employeeID, actualEmployeeID);
	   }catch (AssertionError e) {
		   System.out.println("Employee IDs do not match");
	   }
	   System.out.println("Employee IDs match");
	}

}
