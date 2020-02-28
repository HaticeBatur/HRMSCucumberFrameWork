package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ReportsPageElements {
	
	@FindBy(id="search_search")
	public WebElement searchBox;
	
	@FindBy(css="input.searchBtn")
	public WebElement searchBtn;
	
	@FindBy(id="resultTable")
	public WebElement resultTable;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[text()='No Records Found']")
	public WebElement noResultText;
	
	public ReportsPageElements () {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
