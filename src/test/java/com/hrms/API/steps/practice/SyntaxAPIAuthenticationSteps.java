package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.*;

import org.junit.Test;

import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ReadWriteFile;

import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SyntaxAPIAuthenticationSteps {
	
	private Response response;
	public static String Token;
	private static RequestSpecification request;
	String generateTokenURI="http://166.62.36.207/syntaxapi/api/generateToken.php";
	
	@Given("user generates token")
	//@Test
	public void user_generates_token() {

	    request = given().header("Content-Type", "application/json");
	    
	    //System.out.println(request.log().all());
	   response = request.body(CommonMethods.readJson("generateToken.json"))
	    .when().post(generateTokenURI);
	   
	  
	   Token="Bearer " + response.jsonPath().getString("token");
	  System.out.println(response.prettyPrint()); 
	   //ReadWriteFile.writeTextIntoFile(APIConstants.JSON_FILEPATH + "token.txt", "Bearer "+response.jsonPath().get("token"));
	   
	}
	
}
