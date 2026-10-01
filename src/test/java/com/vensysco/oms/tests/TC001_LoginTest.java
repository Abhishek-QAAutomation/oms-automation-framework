package com.vensysco.oms.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vensysco.oms.base.BaseTest;
import com.vensysco.oms.pages.DashboardPage;
import com.vensysco.oms.pages.LoginPage;

public class TC001_LoginTest extends BaseTest {
	
	@Test
	public void verifyLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isLoginSuccessMsgDisplayed());
	}
}
