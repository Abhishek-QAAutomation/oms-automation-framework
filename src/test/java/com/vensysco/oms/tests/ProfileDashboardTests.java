package com.vensysco.oms.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vensysco.oms.base.BaseTest;
import com.vensysco.oms.pages.BankingAndPanTab;
import com.vensysco.oms.pages.EducationAndWorkTab;
import com.vensysco.oms.pages.KYCDocumentsPage;
import com.vensysco.oms.pages.LoginPage;
import com.vensysco.oms.pages.ProfileDashboardPage;
import com.vensysco.oms.pages.RegisteredAddressPage;

public class ProfileDashboardTests extends BaseTest{
	
	
	@Test(priority = 1)
	public void verifyBankingAndPanTabOpen() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickBankingAndPanBtn();
		
		BankingAndPanTab bankingAndPan = new BankingAndPanTab(driver);
		
		Assert.assertTrue(bankingAndPan.isBankingAndPanPageOpen(), "Banking & Pan tab was not clicked correctly.");
	}
	
	
	@Test(priority = 2)
	public void verifyEducationAndWorkTabOpen() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickEducationAndWorkBtn();
		
		EducationAndWorkTab educationAndWorkTab = new EducationAndWorkTab(driver);
		
		Assert.assertTrue(educationAndWorkTab.isEducationAndWorkTabOpen(), "Education & Work button was not clicked correctly.");
	}
	
	@Test(priority = 3)
	public void verifyRegisteredAddressTabOpen() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickRegisteredAddressBtn();
		
		RegisteredAddressPage registeredAddressPage = new RegisteredAddressPage(driver);
		
		Assert.assertTrue(registeredAddressPage.isRegisteredAddressPageOpen(), "Registered Address button was not clicker correctly.");
	}

	@Test(priority = 4)
	public void verifyKYCTabOpen() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickKYCDocumentsBtn();
		
		KYCDocumentsPage kycDocumentsPage = new KYCDocumentsPage(driver);
		
		Assert.assertTrue(kycDocumentsPage.isKYCTabOpen(), "KYC Documents button was not clicked correctly.");
	}
	
	

}
