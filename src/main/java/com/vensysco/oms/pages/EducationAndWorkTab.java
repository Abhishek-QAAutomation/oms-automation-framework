package com.vensysco.oms.pages;

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
	private WebElement instOrUniNameField;
	
	@FindBy(xpath="//span[normalize-space()='Working']")
	private WebElement workingRadioBtn;
	
	@FindBy(xpath="//span[normalize-space()='Retired']")
	private WebElement retiredRadioBtn;
	
	@FindBy(xpath="//span[normalize-space()='SELECT TYPE']")
	private WebElement organizationTypeDropdown;
	
	@FindBy(xpath="//input[@placeholder='Enter organisation name']")
	private WebElement organizationNameField;
	
	@FindBy(xpath="//input[@placeholder='Enter designation']")
	private WebElement postOrDesignationField;
	
	
	
	public boolean isSectionCompleted() {
		boolean isSectionCompletedMsgDisplayed = sectionCompletionMsg.isDisplayed();
		return isSectionCompletedMsgDisplayed;
	}

}
