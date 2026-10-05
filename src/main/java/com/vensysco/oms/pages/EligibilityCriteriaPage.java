package com.vensysco.oms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vensysco.oms.base.BasePage;

public class EligibilityCriteriaPage extends BasePage{
	
	public EligibilityCriteriaPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@role='dialog']")
	private WebElement eligibilityCriteriaPopUp;
	
	@FindBy(xpath="//span[normalize-space()='Okay']")
	private WebElement okayBtn;
	
	@FindBy(xpath="//span[normalize-space()='Cancel']")
	private WebElement cancelBtn;
	
	public boolean isPopUpDisplayed() {
		boolean eligibilityPopUpStatus = waitForElementVisible(eligibilityCriteriaPopUp).isDisplayed();
		return eligibilityPopUpStatus;
	}
	
	public void clickOkayBtn() {
		okayBtn.click();
	}
	
	public void clickCancelBtn() {
		cancelBtn.click();
	}

}
