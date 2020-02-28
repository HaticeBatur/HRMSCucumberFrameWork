package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class SampleAPITests {
	
//	@Test
	public void getAllJobTitles() {
		Response response=RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3OTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk5MCwidXNlcklkIjoiMjY5In0.t2E1bt6nR2IGOgdpl-2jr6CKECapHILukmy2WrHHKd8")
		.when().get("http://54.167.125.15/syntaxapi/api/jobTitle.php");
		response.prettyPrint();
		
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);	
	}
//	@Test
	public void getOneEmployee() {
		Response response=RestAssured.given().param("employee_id", "06177A").contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3OTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk5MCwidXNlcklkIjoiMjY5In0.t2E1bt6nR2IGOgdpl-2jr6CKECapHILukmy2WrHHKd8")
			.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");
			response.prettyPrint();
		
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);
	}
//	@Test
	public void getAllEmployeeStatus() {
		Response response=RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3OTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk5MCwidXNlcklkIjoiMjY5In0.t2E1bt6nR2IGOgdpl-2jr6CKECapHILukmy2WrHHKd8")
			.when().get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");
			response.prettyPrint();
		
		int actualResponse=response.getStatusCode();
		System.out.println(actualResponse);
	}
//	@Test
	public void createEmployee() {
		
		String requestBody = "{\n    \"emp_firstname\": \"Hatchnm\",\n    \"emp_lastname\": \"z\",\n    \"emp_middle_name\": \"Senior\",\n    \"emp_gender\": \"2\",\n    \"emp_birthday\": \"1974-02-19\",\n    \"emp_status\": \"Worker\",\n    \"emp_job_title\": \"Cloud Consultant\"\n}";
		
		Response response=RestAssured.given().contentType("application/json").header("Authorization", 
			"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3OTAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk5MCwidXNlcklkIjoiMjY5In0.t2E1bt6nR2IGOgdpl-2jr6CKECapHILukmy2WrHHKd8")
			.body(requestBody)
			.when().post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
			
			response.prettyPrint();
			int actualStatusCode=response.getStatusCode();
			Assert.assertEquals(200, actualStatusCode);
			
	}
	@Test
	public void getAllEmployees() {
		Response response=RestAssured.given().contentType("application/json")
				.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI1OTI3MDEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjcwNzkwMSwidXNlcklkIjoiMjY5In0.mw5FBv6Dx2aszOMCg78aG7B-5huBbQ8IyzYANvlwzPE")
				.when().get("http://54.167.125.15/syntaxapi/api/getAllEmployees.php");
			response.prettyPrint();
			int actualStatusCode=response.getStatusCode();
			Assert.assertEquals(200, actualStatusCode);
	}
	
}
