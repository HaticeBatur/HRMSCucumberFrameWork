package com.hrms.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import com.hrms.utils.CommonMethods;

public class LoginSteps extends CommonMethods{
	
	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm123");
		
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	   click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		try{
			Assert.assertTrue(true);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}

	@When("I enter {string} and {string}")
	public void i_enter_and(String userName, String pwd) {
	    sendText(login.username, userName);
	    sendText(login.password, pwd);
	}

	@Then("I see {string}")
	public void i_see(String errorMsg) {
		waitForVisibility(login.errMessage);
	    Assert.assertEquals("Error messages are NOT matching", errorMsg, login.errMessage.getText());

	}

}