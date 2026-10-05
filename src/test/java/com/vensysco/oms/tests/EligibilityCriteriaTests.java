package com.vensysco.oms.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vensysco.oms.base.BaseTest;
import com.vensysco.oms.pages.EligibilityCriteriaPage;
import com.vensysco.oms.pages.LoginPage;
import com.vensysco.oms.pages.SignupPage;

public class EligibilityCriteriaTests extends BaseTest{
	
	@Test
	public void verifyCancelClick() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignUpLink();
		
		Thread.sleep(5000);
		
		EligibilityCriteriaPage eligibilityCriteriaPage = new EligibilityCriteriaPage(driver);
		eligibilityCriteriaPage.clickCancelBtn();
		
		boolean loginPageStatus = loginPage.isLoginPageOpen();
		Assert.assertTrue(loginPageStatus, "Login Page was not open");
	}
	
	@Test
	public void verifyOkayClick() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignUpLink();
		
		EligibilityCriteriaPage eligibilityCriteriaPage = new EligibilityCriteriaPage(driver);
		eligibilityCriteriaPage.clickOkayBtn();
		
		SignupPage signUpPage = new SignupPage(driver);
		boolean registrationPageStatus = signUpPage.isRegistrationPageOpen();
		
		Assert.assertTrue(registrationPageStatus, "Registration Page was not open");
	}
}
