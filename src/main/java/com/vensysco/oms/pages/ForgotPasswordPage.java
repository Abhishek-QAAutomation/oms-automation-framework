package com.vensysco.oms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vensysco.oms.base.BasePage;

public class ForgotPasswordPage extends BasePage{
	
	public ForgotPasswordPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='Forgot password?']")
	private WebElement forgotPasswordPageHeader;
	
	public boolean isForgotPasswordPageDisplayed() {
		boolean pageHeaderStatus = waitForElementVisible(forgotPasswordPageHeader).isDisplayed();
		return pageHeaderStatus;
	}

}
