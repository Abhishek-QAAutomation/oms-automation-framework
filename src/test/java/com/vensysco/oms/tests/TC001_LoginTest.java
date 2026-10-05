package com.vensysco.oms.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vensysco.oms.base.BaseTest;
import com.vensysco.oms.pages.DashboardPage;
import com.vensysco.oms.pages.EligibilityCriteriaPage;
import com.vensysco.oms.pages.ForgotPasswordPage;
import com.vensysco.oms.pages.LoginPage;

public class TC001_LoginTest extends BaseTest {
	
	@Test(priority =1)
	public void verifyLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isLoginSuccessMsgDisplayed());
	}
	
	@Test(priority=2)
	public void verifyForgotPasswordClick() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickForgotPasswordLink();
		
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		boolean pageDisplayingStatus = forgotPasswordPage.isForgotPasswordPageDisplayed();
		Assert.assertTrue(pageDisplayingStatus, "Forgot Password page was not displayed");
	}
	
	@Test(priority=3)
	public void verifySignUpAsObserverClick() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickSignUpLink();
		
		EligibilityCriteriaPage eligibilityCriteriaPage = new EligibilityCriteriaPage(driver);
		boolean popUpStatus = eligibilityCriteriaPage.isPopUpDisplayed();
		Assert.assertTrue(popUpStatus, "Eligiblity Criteria pupup was not open");
	}
}
