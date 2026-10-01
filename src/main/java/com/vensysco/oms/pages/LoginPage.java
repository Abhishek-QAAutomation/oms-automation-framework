package com.vensysco.oms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vensysco.oms.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//button[text()='Forgot password?']")
	private WebElement forgotPasswordBtn;
	
	@FindBy(xpath="//button[text()='Sign up as Observer']")
	private WebElement signUpBtn;
	
	@FindBy(xpath="//h5[normalize-space()='Authentication Successful']")
	private WebElement loginSuccessMsg;
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clickForgotPassword() {
		forgotPasswordBtn.click();
	}
	
	public void clickSignUpBtn() {
		signUpBtn.click();
	}
}
	