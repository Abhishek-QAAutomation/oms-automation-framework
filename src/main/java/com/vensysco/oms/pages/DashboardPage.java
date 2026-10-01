package com.vensysco.oms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vensysco.oms.base.BasePage;

public class DashboardPage extends BasePage{
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h5[normalize-space()='Authentication Successful']")
	private WebElement loginSuccessMsg;
	
	public boolean isLoginSuccessMsgDisplayed() {
		boolean isLoginSuccessful = loginSuccessMsg.isDisplayed();
		return isLoginSuccessful;
	}

}
