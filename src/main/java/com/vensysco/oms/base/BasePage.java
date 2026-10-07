package com.vensysco.oms.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	protected WebElement waitForElementVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	protected WebElement waitForElementPresent(By locator) {

	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected Boolean waitForElementSelect(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	protected WebElement waitForElementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}


}
