package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import java.util.*;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class GoRestSteps {
	
	 private static Response response;
	 private static RequestSpecification request;
	    
	@When("I provide a request data")
	public void i_provide_a_request_data() {
		 request = given().header("Content-Type", "application/json")
         .header("Authorization", "Bearer 059MHCzH0kLQS_wTwCMeniTFjKrLvtSTE7fM");
		 //request.log().all();
	}

	@When("I make a call to albums API")
	public void i_make_a_call_to_albums_API() {
		int albumId = 4;
	    response = request.when().get("https://gorest.co.in/public-api/albums/" + albumId);
	}

	@Then("I validate that {int} is the status code")
	public void i_validate_that_is_the_status_code(int expectedStatusCode) {
		//1st way 
		response.then().assertThat().statusCode(expectedStatusCode);
	   //String responseBody = response.prettyPrint();
	   //2nd way
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
	}

	@Then("I validate response body")
	public void i_validate_response_body() {
	   //1st way
		response.then().body("_meta.rateLimit.limit", Matchers.equalTo(60));
		response.then().body("_meta.message", Matchers.equalTo("OK. Everything worked as expected."));
		response.then().body("result._links.self.href", Matchers.equalTo("https://gorest.co.in/public-api/albums/4"));
		//2nd way
		JsonPath jsonPath = response.jsonPath();
		String result = jsonPath.prettify();
		System.out.println(result);
		String expectedTitle = jsonPath.getString("result.title");
		String actualTitle = "Quos culpa est nemo aspernatur.";
		Assert.assertEquals(expectedTitle, actualTitle);
		String userID = jsonPath.get("result.user_id");
		
//		JsonPath jsonPath = response.jsonPath();
//		String result = jsonPath.prettify();
//		List <Object> albums = jsonPath.get("result");
//		Object album = albums.get(0);
//		System.out.println(album);
		
		//3rd way
		JSONObject jsonObject = new JSONObject (response.asString());
		System.out.println(jsonObject);
		JSONObject meta = jsonObject.getJSONObject("_meta");
		System.out.println(meta);
		JSONObject rateLimit = meta.getJSONObject("rateLimit");
		System.out.println(rateLimit);
		
		int limitInt = rateLimit.getInt("limit");
		System.out.println(limitInt);
		int limitInt2 = (int) rateLimit.get("limit");
		System.out.println(limitInt2);
		
		//not work because limit is not s String
//		String limitString = (String)rateLimit.get("limit");
//		System.out.println(limitString);
		
		
		
	}
}
