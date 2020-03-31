package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import com.hrms.utils.CommonMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class SampleAPITests {

	public static String Token;

	String generateTokenURI="http://166.62.36.207/syntaxapi/api/generateToken.php";
	
	@Test
	public void user_generates_token() {
	
	    Response response = given().header("Content-Type", "application/json").body(CommonMethods.readJson("generateToken.json"))
	    .when().post(generateTokenURI);
	   
	  
	   Token="Bearer " + response.jsonPath().getString("token");
	  System.out.println(response.prettyPrint()); 
	   //ReadWriteFile.writeTextIntoFile(APIConstants.JSON_FILEPATH + "token.txt", "Bearer "+response.jsonPath().get("token"));
	   
	}
	@Test
	public void getAllJobTitles() {
		System.out.println(Token);
		Response response=RestAssured.given().contentType("application/json").header("Authorization", Token)
		.when().get("http://166.62.36.207/syntaxapi/api/jobTitle.php");
		System.out.println("&&&&&&&&&&&&&&getAllJobTitles");	
		response.prettyPrint();
		
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);	
	}
	@Test
	public void getOneEmployee() {
		Response response=RestAssured.given().param("employee_id", "06177A").contentType("application/json").header("Authorization", Token)
			.when().get("http://166.62.36.207/syntaxapi/api/getOneEmployee.php");
		System.out.println("&&&&&&&&&&&&&&getOneEmployee");		
		response.prettyPrint();
		
		int actualResponseCode=response.getStatusCode();
		System.out.println(actualResponseCode);
	}
	@Test
	public void getAllEmployeeStatus() {
		Response response=RestAssured.given().contentType("application/json").header("Authorization", Token)
			.when().get("http://166.62.36.207/syntaxapi/api/employeeStatus.php");
		System.out.println("&&&&&&&&&&&&&&getAllEmployeeStatus");	
		response.prettyPrint();
		
		int actualResponse=response.getStatusCode();
		System.out.println(actualResponse);
	}
	@Test
	public void createEmployee() {
		
		String requestBody = "{\n    \"emp_firstname\": \"Hatchnm\",\n    \"emp_lastname\": \"z\",\n    \"emp_middle_name\": \"Senior\",\n    \"emp_gender\": \"2\",\n    \"emp_birthday\": \"1974-02-19\",\n    \"emp_status\": \"Worker\",\n    \"emp_job_title\": \"Cloud Consultant\"\n}";
		
		Response response=RestAssured.given().contentType("application/json").header("Authorization", 
				Token)
			.body(requestBody)
			.when().post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
			System.out.println("&&&&&&&&&&&&&&createEmployee");
			response.prettyPrint();
			int actualStatusCode=response.getStatusCode();
			Assert.assertEquals(200, actualStatusCode);
			
	}
	@Test
	public void getAllEmployees() {
		Response response=RestAssured.given().contentType("application/json")
				.header("Authorization", Token)
				.when().get("http://166.62.36.207/syntaxapi/api/getAllEmployees.php");
		System.out.println("&&&&&&&&&&&&&&getAllEmployees");	
		response.prettyPrint();
			int actualStatusCode=response.getStatusCode();
			try{
				Assert.assertEquals(200, actualStatusCode);
			}catch(Exception e) {
				System.out.println("Actual status code is  --> "+actualStatusCode);
			}
	}
	
}
