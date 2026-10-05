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
	
	@FindBy(xpath="//div[text()='Section details saved successfully.']")
	private WebElement 	sectionCompletionMsg;
	
	@FindBy(xpath="//span[normalize-space()='SELECT QUALIFICATION']")
	private WebElement highestQualificationDropdown;
	
	@FindBy(xpath="//input[@placeholder='Enter Institute / University Name']")
	private WebElement instituteNameField;
	
	@FindBy(xpath="//span[normalize-space()='Working']")
	private WebElement workingRadioBtn;
	
	@FindBy(xpath="//span[normalize-space()='Retired']")
	private WebElement retiredRadioBtn;
	
	@FindBy(xpath="//span[normalize-space()='SELECT TYPE']")
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
	
	
	
	public boolean isSectionCompleted() {
		boolean isSectionCompletedMsgDisplayed = sectionCompletionMsg.isDisplayed();
		return isSectionCompletedMsgDisplayed;
	}
	
	public void selectQualification(String education) throws InterruptedException {
		highestQualificationDropdown.click();
		Thread.sleep(5000);
		WebElement option= driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + education +"']"));
		Thread.sleep(5000);
		option.click();
	}
	
	public void enterIstituteName(String instituteName) {
		instituteNameField.sendKeys(instituteName);
	}
	
	public void clickRetiredRadioBtn() {
		retiredRadioBtn.click();
	}
	
	public void clickWorkingRadioBtn() {
		workingRadioBtn.click();
	}
	
	public void selectOrganizationType(String orgType) throws InterruptedException {
		organizationTypeDropdown.click();
		Thread.sleep(5000);
		WebElement option = driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + orgType +"']"));
		Thread.sleep(5000);
		option.click();
	}
	
	public void enterCurrentOrganization(String currentOrganizationName) {
		currentOrganizationNameField.sendKeys(currentOrganizationName);
	}
	
	public void enterPost(String post) {
		postOrDesignationField.sendKeys(post);
	}
	
	public void selectWorkingPeriodFrom(String month, String year) throws InterruptedException {
		workingPeriodFromMonthDropdown.click();
		Thread.sleep(5000);
		WebElement monthOption = driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + month +"']"));
		monthOption.click();
		Thread.sleep(5000);
		workingPeriodFromYearDropdown.click();
		WebElement yearDropdown = driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" + year +"']"));
		yearDropdown.click();
	}

}
