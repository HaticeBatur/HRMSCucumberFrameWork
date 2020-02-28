package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{

		@FindBy(linkText="Leave")
		public WebElement leaveLnk;
		
		@FindBy(linkText="Leave List")
		public WebElement leaveList;
		
		@FindBy(linkText="PIM")
		public WebElement pim;
		
		@FindBy(linkText="Add Employee")
		public WebElement addEmployee;
		
		@FindBy(id="welcome")
		public WebElement welcomeText;
		
		@FindBy(css="[id$=PredefinedReports")
		public WebElement reports;
		
		public DashboardPageElements() {
			PageFactory.initElements(BaseClass.driver, this);
		}

		public void navigateToLeaveList() {
			jsClick(leaveLnk);
			jsClick(leaveList);
		}
		public void navigateToAddEmployee() {
			jsClick(pim);
			jsClick(addEmployee);
		}
		public void navigateToReportsPage() {
			jsClick(pim);
			jsClick(reports);
		}
}
