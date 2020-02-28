package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportsSteps extends CommonMethods{
	
	@Given("I navigated to Reports Page")
	public void i_navigated_to_Reports_Page() {
	    dashboard.navigateToReportsPage();
	}
	@When("I enter report name as {string}")
	public void i_enter_report_name_as(String reportName) {
	    sendText(report.searchBox, reportName);
	}
	@When("I click on search button")
	public void i_click_on_search_button() {
	   click(report.searchBtn);
	}
	@Then("I see {string} text")
	public void i_see_text(String text) {
		if(report.resultTable.getText().contains(text)) {
	      Assert.assertTrue(report.resultTable.getText().contains(text));
		}else {
		  waitForVisibility(report.noResultText);
		  System.out.println("Message appears as --> "+report.noResultText.getText());
		}
	}
		
}
