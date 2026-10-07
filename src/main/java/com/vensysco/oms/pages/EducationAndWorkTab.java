package com.vensysco.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vensysco.oms.base.BasePage;

public class EducationAndWorkTab extends BasePage{
	
	public EducationAndWorkTab(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='Education & Work']")
	private WebElement educationAndWorkTabHeader;
	
	@FindBy(xpath="//div[text()='Section details saved successfully.']")
	private WebElement 	sectionCompletionMsg;
	
	@FindBy(xpath="(//div[@role='combobox'])[1]")
	private WebElement highestQualificationDropdown;
	
	@FindBy(xpath="//input[@placeholder='Enter Institute / University Name']")
	private WebElement instituteNameField;
	
	@FindBy(xpath="//label[.//input[@name='employmentStatus' and @value='working']]")
	private WebElement workingRadioBtnLabel;
	
	@FindBy(xpath="//input[@name='employmentStatus' and @value='working']")
	private WebElement workingRadioBtnInput;
	
	@FindBy(xpath="//label[.//input[@name='employmentStatus' and @value='retired']]")
	private WebElement retiredRadioBtnLabel;
	
	@FindBy(xpath="//input[@name='employmentStatus' and @value='retired']")
	private WebElement retiredRadioBtnInput;
	
	@FindBy(xpath="(//div[@role='combobox'])[2]")
	private WebElement organizationTypeDropdown;
	
	@FindBy(xpath="//input[@placeholder='Enter organisation name']")
	private WebElement currentOrganizationNameField;
	
	@FindBy(xpath="//input[@placeholder='Enter designation']")
	private WebElement postOrDesignationField;
	
	@FindBy(xpath="(//div[@role='combobox'])[3]")
	private WebElement workingPeriodFromMonthDropdown;
	
	@FindBy(xpath="(//div[@role='combobox'])[4]")
	private WebElement workingPeriodFromYearDropdown;
	
	@FindBy(xpath="//span[normalize-space()='Add Organisation']")
	private WebElement addOrganizationBtn;
	
	@FindBy(xpath="//button[contains(normalize-space(), 'Save & Continue')]")
	private WebElement saveAndContinueBtn;
	

	public boolean isEducationAndWorkTabOpen() {
		boolean educationAndWorkTabStaus = waitForElementVisible(educationAndWorkTabHeader).isDisplayed();
		return educationAndWorkTabStaus;
	}
	
	public boolean isSectionCompleted() {
		boolean isSectionCompletedMsgDisplayed = sectionCompletionMsg.isDisplayed();
		return isSectionCompletedMsgDisplayed;
	}
	
	public void selectQualification(String education) throws InterruptedException {
		Thread.sleep(10000);
		waitForElementToBeClickable(highestQualificationDropdown).click();
		By qualificationOption= By.xpath("//div[@role='option']//span[normalize-space()='" + education +"']");
		waitForElementToBeClickable(qualificationOption).click();
	}
	
	public String getSelectedQualification() {
		String actualSelectedOption = highestQualificationDropdown.getText().trim();
		return actualSelectedOption;
	}
	
	public void enterInstituteName(String instituteName) {
		instituteNameField.sendKeys(instituteName);
	}
	
	public void clickRetiredRadioBtn() {
		waitForElementToBeClickable(retiredRadioBtnLabel).click();
	}
	
	public boolean getRetiredRadioBtnSelectionStatus() {
		boolean retiredRadioBtnStatus = waitForElementSelect(retiredRadioBtnInput);
		return retiredRadioBtnStatus;
	}
	
	public void clickWorkingRadioBtn() {
		waitForElementToBeClickable(workingRadioBtnLabel).click();
	}
	
	public boolean getWorkingRadioBtnSelectionStatus() {
		boolean workingRadioBtnStatus = waitForElementSelect(workingRadioBtnInput);
		return workingRadioBtnStatus;
	}
	
	public void selectOrganizationType(String orgType) throws InterruptedException {
		Thread.sleep(10000);
		waitForElementToBeClickable(organizationTypeDropdown).click();
		By organizationTypeOption = By.xpath("//div[@role='option' and normalize-space(.)='" + orgType + "']");
		waitForElementToBeClickable(organizationTypeOption).click();
	}
	
	public String getSelectedOrganizationType() {
		String actualSelectedOrganizationType= organizationTypeDropdown.getText().trim();
		return actualSelectedOrganizationType;
	}
	
	public void enterCurrentOrganization(String currentOrganizationName) {
		currentOrganizationNameField.sendKeys(currentOrganizationName);
	}
	
	public void enterPost(String post) {
		postOrDesignationField.sendKeys(post);
	}
	
	public void selectWorkingPeriodFrom(String month, String year) throws InterruptedException {
		waitForElementToBeClickable(workingPeriodFromMonthDropdown).click();
		By monthOption = By.xpath("//div[@role='option']//span[normalize-space()='" + month +"']");
		waitForElementToBeClickable(monthOption).click();
		waitForElementToBeClickable(workingPeriodFromYearDropdown).click();
		By yearDropdownOption = By.xpath("//div[@role='option']//span[normalize-space()='" + year +"']");
		waitForElementToBeClickable(yearDropdownOption).click();
	}
	
	public String getSelectedWorkingPeriodFrom() {
		String actualSelectedWorkingPeriodFrom = (workingPeriodFromMonthDropdown.getText() + workingPeriodFromYearDropdown.getText()).trim();
		return actualSelectedWorkingPeriodFrom;
	}
	
	public void clickOnSaveAndContinueBtn() {
		waitForElementToBeClickable(saveAndContinueBtn).click();
	}

}
