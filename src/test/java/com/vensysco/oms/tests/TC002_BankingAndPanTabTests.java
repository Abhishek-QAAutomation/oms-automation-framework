package com.vensysco.oms.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vensysco.oms.base.BaseTest;
import com.vensysco.oms.pages.BankingAndPanTab;
import com.vensysco.oms.pages.EducationAndWorkTab;
import com.vensysco.oms.pages.LoginPage;
import com.vensysco.oms.utilities.RandomDataGenerator;

public class TC002_BankingAndPanTabTests extends BaseTest{
	
	@Test
	public void verifySubmit() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		BankingAndPanTab bankingAndPanTab = new BankingAndPanTab(driver);
		bankingAndPanTab.enterAadharNumber(RandomDataGenerator.randomAadharNumber());
		bankingAndPanTab.enterPanNumber(RandomDataGenerator.randomPanNumber());
		bankingAndPanTab.selectBank(properties.getProperty("bankName"));
		bankingAndPanTab.enterIFSCCode(RandomDataGenerator.randomIFSCCode());
		bankingAndPanTab.enterBranchName(properties.getProperty("branchName"));
		bankingAndPanTab.enterAccountNumber(RandomDataGenerator.randomAccountNumber());
		bankingAndPanTab.clickSaveAndContinue();
		EducationAndWorkTab educationAndWorkTab = new EducationAndWorkTab(driver);
		boolean isSectionSaved = educationAndWorkTab.isSectionCompleted();
		Assert.assertTrue(isSectionSaved);
		
	}

}
