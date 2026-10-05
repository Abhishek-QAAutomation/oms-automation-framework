package com.vensysco.oms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vensysco.oms.base.BasePage;

public class SignupPage extends BasePage{
	
	public SignupPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[text()='Observer Registration']")
	private WebElement registrationPageHeader;
	
	public boolean isRegistrationPageOpen() {
		boolean registrationPageStatus = waitForElementVisible(registrationPageHeader).isDisplayed();
		return registrationPageStatus;
	}

}
