package com.vensysco.oms.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vensysco.oms.base.BasePage;

public class BankingAndPanTab extends BasePage{
	
	public BankingAndPanTab(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='Banking & PAN']")
	private WebElement bankingAndPanPageHeader;
	
	@FindBy(xpath="//input[@placeholder='XXXX-XXXX-XXXX']")
	private WebElement aadharNumberField;
	
	@FindBy(xpath="//input[@placeholder='ABCDE1234F']")
	private WebElement panNumberField;
	
	@FindBy(xpath="//span[text()='SELECT BANK']")
	private WebElement selectBankDropdown;
	
	@FindBy(xpath="//input[@placeholder='Search bank...']")
	private WebElement bankSearchField;
	
	@FindBy(xpath="//input[@placeholder='e.g. SBIN0000691']")
	private WebElement ifscCodeField;
	
	@FindBy(xpath="//input[@placeholder='Branch name (auto-filled from IFSC)']")
	private WebElement branchNameField;
	
	@FindBy(xpath="//input[@placeholder='Enter bank account number']")
	private WebElement accountNumberField;
	
	@FindBy(xpath="//span[normalize-space()='Save & Continue']")
	private WebElement saveAndContinueBtn;
	
	public boolean isBankingAndPanPageOpen() {
		boolean bankingAndPanPageStatus = waitForElementVisible(bankingAndPanPageHeader).isDisplayed();
		return bankingAndPanPageStatus;
	}
	
	public void enterAadharNumber(String aadharNumber) {
		aadharNumberField.sendKeys(aadharNumber);
	}
	
	public void enterPanNumber(String panNumber) {	
		panNumberField.sendKeys(panNumber);
	}
	
	public void selectBank(String bankName) {
		waitForElementToBeClickable(selectBankDropdown).click();
		waitForElementVisible(bankSearchField).sendKeys(bankName);
		
		WebElement bankOption = driver.findElement(By.xpath("//div[@role='option']//span[normalize-space()='" +bankName+ "']"));
		
		waitForElementToBeClickable(bankOption).click();
	}
	
	public void enterIFSCCode(String ifscCode) {
		ifscCodeField.sendKeys(ifscCode);
	}
	
	public void enterBranchName(String branchName) {
		
		branchNameField.sendKeys(branchName);
		
	}
	
	public void enterAccountNumber(String accNumber) {
		accountNumberField.sendKeys(accNumber);
	}
	
	public void clickSaveAndContinue() {
		saveAndContinueBtn.click();
	}

}
