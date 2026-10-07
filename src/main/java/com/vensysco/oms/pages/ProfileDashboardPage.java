package com.vensysco.oms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vensysco.oms.base.BasePage;

public class ProfileDashboardPage extends BasePage{
	
	public ProfileDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h5[normalize-space()='Authentication Successful']")
	private WebElement loginSuccessMsg;
	
	@FindBy(xpath="//span[normalize-space()='Basic Info']")
	private WebElement basicInfoBtn;
	
	@FindBy(xpath="//span[normalize-space()='Banking & PAN']")
	private WebElement bankingAndPanBtn;
	
	@FindBy(xpath="//span[normalize-space()='Education & Work']")
	private WebElement educationAndWorkBtn;
	
	@FindBy(xpath="//span[normalize-space()='Registered Address']")
	private WebElement registeredAddressBtn;
	
	@FindBy(xpath="//span[normalize-space()='KYC Documents']")
	private WebElement kycDocumentsBtn;
	
	@FindBy(xpath="//span[normalize-space()='Live Photo KYC']")
	private WebElement livePhotoKYCBtn;
	
	@FindBy(xpath="//span[normalize-space()='Review & Submit']")
	private WebElement reviewAndSubmitBtn;
	
	public boolean isLoginSuccessMsgDisplayed() {
		boolean isLoginSuccessful = waitForElementVisible(loginSuccessMsg).isDisplayed();
		return isLoginSuccessful;
	}
	
	public void clickBasicInfoBtn() {
		waitForElementToBeClickable(basicInfoBtn).click();
	}
	
	public void clickBankingAndPanBtn() {
		waitForElementToBeClickable(bankingAndPanBtn).click();
	}
	
	public void clickEducationAndWorkBtn() {
		waitForElementToBeClickable(educationAndWorkBtn).click();
	}
	
	public void clickRegisteredAddressBtn() {
		waitForElementToBeClickable(registeredAddressBtn).click();
	}
	
	public void clickKYCDocumentsBtn() {
		waitForElementToBeClickable(kycDocumentsBtn).click();
	}
	
	public void clickLivePhotoKYCBtn() {
		waitForElementToBeClickable(livePhotoKYCBtn).click();
	}
	
	public void clickReviewAndSubmitBtn() {
		waitForElementToBeClickable(reviewAndSubmitBtn).click();
	}
	
	

}
