package com.vensysco.oms.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vensysco.oms.base.BaseTest;
import com.vensysco.oms.pages.EducationAndWorkTab;
import com.vensysco.oms.pages.LoginPage;
import com.vensysco.oms.pages.ProfileDashboardPage;
import com.vensysco.oms.pages.RegisteredAddressPage;

public class TC003_EducationAndWorkTabTests extends BaseTest{
	
	@Test(priority=1)
	public void verifyHighestQualificationDorpdownSelection() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickEducationAndWorkBtn();
		
		String expectedQualification = properties.getProperty("education");		
		EducationAndWorkTab educationAndWorkTab = new EducationAndWorkTab(driver);
		educationAndWorkTab.selectQualification(expectedQualification);
		Assert.assertEquals(educationAndWorkTab.getSelectedQualification(), expectedQualification, "Qualification was not selected correctly");
	} 
	
	@Test(priority = 2)
	public void verifyOrganizationTypeDropdownSelection() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickEducationAndWorkBtn();
		
		String expectedOrganizationType = properties.getProperty("organizationType");
		EducationAndWorkTab educationAndWorkTab = new EducationAndWorkTab(driver);
		educationAndWorkTab.selectOrganizationType(expectedOrganizationType);
		Assert.assertEquals(educationAndWorkTab.getSelectedOrganizationType(), expectedOrganizationType, "Organization Type was not selected correctly");
	}
	
	@Test(priority = 3)
	public void verifyWorkingPeriodFromSelection() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickEducationAndWorkBtn();
		
		String expectedWorkingPeriodFromMonth = properties.getProperty("workingPeriodMonth");
		String expectedWorkingPeriodFromYear = properties.getProperty("workingPeriodYear");
		String expectedWorkingPeriodFrom = expectedWorkingPeriodFromMonth + expectedWorkingPeriodFromYear;
		EducationAndWorkTab educationAndWorkTab = new EducationAndWorkTab(driver);
		educationAndWorkTab.selectWorkingPeriodFrom(expectedWorkingPeriodFromMonth, expectedWorkingPeriodFromYear);
		Assert.assertEquals(educationAndWorkTab.getSelectedWorkingPeriodFrom(), expectedWorkingPeriodFrom, "Working Period From was not selected correctly");
	}
	
	@Test(priority = 4)
	public void verifyRetiredRadioBtnSelection() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickEducationAndWorkBtn();
		
		EducationAndWorkTab educationAndWorkTab = new EducationAndWorkTab(driver);
		educationAndWorkTab.clickRetiredRadioBtn();
		Assert.assertTrue(educationAndWorkTab.getRetiredRadioBtnSelectionStatus(), "Retired radio button was not selected correctly");
	}
	
	@Test(priority = 5)
	public void verifyWorkingRadioBtnSelection() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickEducationAndWorkBtn();
		
		EducationAndWorkTab educationAndWorkTab = new EducationAndWorkTab(driver);
		educationAndWorkTab.clickRetiredRadioBtn();
		educationAndWorkTab.clickWorkingRadioBtn();
		Assert.assertTrue(educationAndWorkTab.getWorkingRadioBtnSelectionStatus(), "Working radio button was not selected correctly");
	}
	
	@Test(priority = 6)
	public void verifySubmit() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickEducationAndWorkBtn();
		
		EducationAndWorkTab educationAndWorkTab = new EducationAndWorkTab(driver);
		educationAndWorkTab.selectQualification(properties.getProperty("education"));
		educationAndWorkTab.enterInstituteName(properties.getProperty("instituteName"));
		educationAndWorkTab.selectOrganizationType(properties.getProperty("organizationType"));
		educationAndWorkTab.enterCurrentOrganization(properties.getProperty("organizationName"));
		educationAndWorkTab.enterPost(properties.getProperty("Post"));
		educationAndWorkTab.selectWorkingPeriodFrom(properties.getProperty("workingPeriodMonth"), properties.getProperty("workingPeriodYear"));
		educationAndWorkTab.clickOnSaveAndContinueBtn();
		
		RegisteredAddressPage registeredAddressPage = new RegisteredAddressPage(driver);
		
		Assert.assertTrue(registeredAddressPage.isSectionCompleted(), "Section was not completed successfully.");
	}

}
