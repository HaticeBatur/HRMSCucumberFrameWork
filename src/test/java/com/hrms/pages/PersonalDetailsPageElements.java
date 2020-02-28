package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {
	
	
	@FindBy(css="div[id='profile-pic'] h1")
	public WebElement empName;
	
	@FindBy(css="div[class='head'] h1")
	public WebElement lbpDetails;
	
	@FindBy(id="personal_txtEmpFirstName")
	public WebElement firstName;
	
	@FindBy(id="personal_txtEmpMiddleName")
	public WebElement middleName;
	
	@FindBy(id="personal_txtEmpLastName")
	public WebElement lastName;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement empId;
	
	@FindBy(css="input#btnSave")
	public WebElement edit_saveBtn;
	
	@FindBy(css="#personal_txtLicenNo")
	public WebElement txtLicenNo;
	
	@FindBy(css="#personal_txtNICNo")
	public WebElement txtSSN;
	
	@FindBy(xpath="//input[@id='personal_txtLicExpDate']")
	public WebElement txtLicenExpDate;
	
	@FindBy(css="input[id*='txtSINNo']")
	public WebElement txtSIN;
	
	@FindBy(css="input[id*='optGender']")
	public List<WebElement> gender;
	
	@FindBy(xpath="//ul[@class='radio_list']/li")
	public List<WebElement> genderList;
	
	@FindBy(xpath="//ul[@class='radio_list']/li")
	public List<WebElement> maleList;
	
	@FindBy(css="input[id*='optGender_1']")
	public WebElement optMale;
	
	@FindBy(css="input[id*='optGender_2']")
	public WebElement optFemale;
	
	@FindBy(css="select[id*='cmbNation']")
	public WebElement selectNation;
	
	@FindBy(css="select[id*='cmbMarital']")
	public WebElement maritalSt;
	
	@FindBy(css="input[id*='DOB']")
	public WebElement DOB;
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void selectGender(String text) {
        if (text.equalsIgnoreCase("Male")) {
            optMale.click();
        }else if(text.equalsIgnoreCase("Female")) {
            optFemale.click();
        }
    }



	 
}
