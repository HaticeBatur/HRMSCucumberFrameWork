package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements {
	
	@FindBy (id="firstName")
	public WebElement firstName;
	
	@FindBy (id="middleName")
	public WebElement middleName;
	
	@FindBy (id="lastName")
	public WebElement lastName;
	
	@FindBy (id="employeeId")
	public WebElement employeeId;
	
	@FindBy (css="input#chkLogin")
	public WebElement createLoginDet;
	
	@FindBy (id="user_name")
	public WebElement empUsername;
	
	@FindBy(id="btnSave")
	public WebElement btnSave;
	
	@FindBy (xpath="//span[@for='firstName']")
	public WebElement reqforFirstname;
	
	@FindBy (xpath="//span[@for='lastName']")
	public WebElement reqforLastname;
	
	@FindBy (id="user_password")
	public WebElement userPassword;
	
	@FindBy (id="re_password")
	public WebElement confirmPassword;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void addEmployee(String firstname, String middlename, String lastname) {
		CommonMethods.sendText(firstName, firstname);
		CommonMethods.sendText(middleName, middlename);
		CommonMethods.sendText(lastName, lastname);
		employeeId.clear();
		CommonMethods.click(createLoginDet);
		CommonMethods.sendText(empUsername, firstname+lastname);
		CommonMethods.click(btnSave);
	}
}
