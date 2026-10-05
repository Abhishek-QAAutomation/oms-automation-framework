package com.vensysco.oms.tests;

import org.testng.annotations.Test;

import com.vensysco.oms.base.BaseTest;
import com.vensysco.oms.pages.EducationAndWorkTab;
import com.vensysco.oms.pages.LoginPage;
import com.vensysco.oms.utilities.RandomDataGenerator;

public class TC003_EducationAndWorkTabTests extends BaseTest{
	
	@Test
	public void selectEducationTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		EducationAndWorkTab educationAndWorkTab = new EducationAndWorkTab(driver);
		educationAndWorkTab.selectQualification(properties.getProperty("education"));
		educationAndWorkTab.enterIstituteName("MGKVP");
		educationAndWorkTab.clickRetiredRadioBtn();
		educationAndWorkTab.clickWorkingRadioBtn();
		educationAndWorkTab.selectOrganizationType("Central Government");
		educationAndWorkTab.enterCurrentOrganization("Vensysco");
		educationAndWorkTab.enterPost("Quality Assurance Engineer");
		educationAndWorkTab.selectWorkingPeriodFrom("Feb", "2024");
	}

}
