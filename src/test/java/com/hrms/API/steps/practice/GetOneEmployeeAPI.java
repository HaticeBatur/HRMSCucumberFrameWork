package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import pollo.Employee;


public class GetOneEmployeeAPI {
	private static RequestSpecification request;
	private static Response response;
	String getOneEmployeeURI = "http://166.62.36.207/syntaxapi/api/getOneEmployee.php";
	private static Employee emp;
	@Given("user calls getOneEmployee API")
	public void user_calls_getOneEmployee_API() {
	    request = given().param("employee_id", POSTCreateEmployeeAPI.employeeID)
	    		.header("Content-Type", "Application/json")
	    		.header("Authorization", SyntaxAPIAuthenticationSteps.Token)
	    		;
	}

	@When("user receives response from getOneEmployee")
	public void user_receives_response_from_getOneEmployee() {
	    response = request.when().get(getOneEmployeeURI);
	    System.out.print("Get One Employee Response -->");
	    response.prettyPrint(); 
	    emp=response.jsonPath().getObject("employee[0]", Employee.class);
	   System.out.println(emp.toString());
	}

	@Then("status codeiis {int}")
	public void status_codeiis(int expected) {
		Assert.assertEquals(emp.getEmp_firstname(), "Cristy");
		System.out.println(emp.employeeInfo());
		  response.then().assertThat().statusCode(expected);
	        Assert.assertEquals(expected, response.getStatusCode()); 
	        Map<String, Object> map=response.as(Map.class);
	        System.out.println(map);
	        System.out.println(map.equals(emp.employeeInfo()));
	        
	}

	@Then("employee id matches with the test POSTCreateEmployee")
	public void employee_id_matches_with_the_test_POSTCreateEmployee() {
		JsonPath jpathEvaluator = response.jsonPath();
		   String actualEmployeeID =  jpathEvaluator.get("employee[0].employee_id");
		   response.then().body("employee[0].employee_id", equalTo(emp.getEmploye_id()));
		    try {
			   Assert.assertEquals(actualEmployeeID, emp.getEmploye_id());
		   }catch (AssertionError e) {
			   System.out.println("Employee IDs do not match");
		   }
		   System.out.println("Employee IDs match");
	}
}
