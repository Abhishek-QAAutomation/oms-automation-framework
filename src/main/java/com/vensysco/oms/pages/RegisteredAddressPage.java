package com.vensysco.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vensysco.oms.base.BasePage;

public class RegisteredAddressPage extends BasePage{
	
	public RegisteredAddressPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[text()='Education & Work details saved successfully.']")
	private WebElement 	sectionCompletionMsg;
	
	@FindBy(xpath="//h2[text()='Registered Address']")
	private WebElement registeredAddressPageHeader;
	
	@FindBy(xpath="(//input[@placeholder='House / Flat No., Building, Street Name'])[1]")
	private WebElement addressLine1Field;
	
	@FindBy(xpath="(//div[@role='combobox'])[1]")
	private WebElement residentialStateDropdown;
	
	@FindBy(xpath="(//div[@role='combobox'])[2]")
	private WebElement residentialCityDropdown;
	
	@FindBy(xpath="(//input[@placeholder='6-digit PIN code'])[1]")
	private WebElement residentialPinCodeField;
	
	@FindBy(xpath="//label[normalize-space()='Same as Registered Residential Address']")
	private WebElement sameAsResidentialAddressCheckboxLabel;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement sameAsResidentialAddressCheckboxInput;
	
	
	public boolean isRegisteredAddressPageOpen() {
		boolean registeredAddressPageStatus = waitForElementVisible(registeredAddressPageHeader).isDisplayed();
		return registeredAddressPageStatus;
	}
	
	public boolean isSectionCompleted() {
		boolean isSectionCompletedMsgDisplayed = sectionCompletionMsg.isDisplayed();
		return isSectionCompletedMsgDisplayed;
	}
	
	public void enterResidentialAddressLine1(String address) {
		addressLine1Field.sendKeys(address);
	}
	
	public void selectResidentialState(String state) throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToBeClickable(residentialStateDropdown).click();
		By stateOption = By.xpath("//div[@role='option']//span[normalize-space()='" + state +"']");
		waitForElementToBeClickable(stateOption).click();
	}
	
	public String getSelectedState() throws InterruptedException {
		String actualSelectedState = residentialStateDropdown.getText().trim();
		return actualSelectedState;
	}
	
	public void selectResidentialCity(String city) throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToBeClickable(residentialCityDropdown).click();
		By cityOption = By.xpath("//div[@role='option']//span[normalize-space()='"+ city +"']");
		waitForElementToBeClickable(cityOption).click();
	}
	
	public void enterResidentialPinCode(String pinCode) {
		residentialPinCodeField.sendKeys(pinCode);
	}
	
	public void checkSameAsResidentialAddressCheckbox() {
		waitForElementToBeClickable(sameAsResidentialAddressCheckboxLabel).click();
	}
	
	public boolean getSameAsResidentialAddressCheckboxStatus() {
		boolean sameAsResidentialAddressStatus = waitForElementSelect(sameAsResidentialAddressCheckboxInput);
		return sameAsResidentialAddressStatus;
	}

}
