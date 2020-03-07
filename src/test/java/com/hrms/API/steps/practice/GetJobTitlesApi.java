package com.hrms.API.steps.practice;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetJobTitlesApi {
	
	private static RequestSpecification request;
	private Response response;
	String jobTitlesURI= "http://54.167.125.15/syntaxapi/api/jobTitle.php";
	public static JSONArray jobTitleArray;
	
	@Given("user calls GETJobTitles API")
	public void user_calls_GETJobTitles_API() {
	    request = given().header("Content-Type", "Application/json")
	    		.header("Authorization", SyntaxAPIAuthenticationSteps.Token);
	}

	@When("user retrieves response from getJobTitles")
	public void user_retrieves_response_from_getJobTitles() {
	    response = request.when().get(jobTitlesURI);
//	    System.out.print("Job Titles Response -->");
//	    response.prettyPrint(); 
	}
    @Then("status codeis {int}")
    public void status_code_is(int expected) {
        response.then().assertThat().statusCode(expected);
        Assert.assertEquals(expected, response.getStatusCode()); 
        System.out.println("Response Status Code:"+response.getStatusCode());
    }
    @Then("user verifies the number of Job Titles")
    public void user_verifies_the_number_of_Job_Titles() {
        List<String> list = response.jsonPath().getList("\"Job Title List\"");
        System.out.println("The number of Job Title is " + list.size());
        int expectedJobTitleNumber=Integer.parseInt(CommonMethods.readJson("JobTitleNumber.json").replaceAll("[^\\d]", ""));
        Assert.assertEquals(expectedJobTitleNumber, list.size());
    }
    @Then ("user validates job titles")
    public void user_validates_job_titles() {
    	JSONObject json = new JSONObject(response.prettyPrint());
    	JSONArray array = json.getJSONArray("Job Title List");
    	JSONObject jobtitle = new JSONObject (CommonMethods.readJson("jobTitles.json"));
    	JSONArray titleArray = jobtitle.getJSONArray("Job Title List");
    	jobTitleArray = titleArray;
    	
    	List<Map<String, String>> mapList = new ArrayList<>();
    	List<String> list = new ArrayList<String>();
    	Map<Integer, String> mapTotal= new HashMap<>();
    	
    	System.out.println("------------ VALIDATE JOB TITLES--------------");
    	for (int i=0; i<titleArray.length(); i++) {
	    	Map<String, String> map= new HashMap<>();
	    	String[] str = titleArray.get(i).toString().split("\"");
	    	for(int j=0; j<str.length; j++) {
	    		map.put(str[1], str[3]);
	    		mapList.add(map);
	    		list.add(str[3]);
	    		mapTotal.put(i, str[3]);
	    		break;
	    	}
	    	try {
	    		Assert.assertTrue(mapTotal.get(i).equals(array.get(i)));
	    		System.out.println("Job Title --> " +mapTotal.get(i) + " --> MATCH ");
	    	}catch (AssertionError e) {
	    		System.out.println("Job Title --> " +mapTotal.get(i) + " --> ****** DO NOT MATCH ******");
	    	}
    	}
    	System.out.println("MAPLIST--> " + mapList);
    	System.out.println("LIST of Job Titles --> " + list);
    	System.out.println("WHOLE MAP-->" + mapTotal);
    }
}
