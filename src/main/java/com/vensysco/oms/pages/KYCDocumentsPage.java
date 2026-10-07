package com.vensysco.oms.pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vensysco.oms.base.BasePage;

public class KYCDocumentsPage extends BasePage{
	
	public KYCDocumentsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='KYC Documents']")
	private WebElement kycDocumentsTab;
	
	public boolean isKYCTabOpen() {
		boolean kycTabOpenStatus = waitForElementVisible(kycDocumentsTab).isDisplayed();
		return kycTabOpenStatus;
	}
	
	private WebElement getFileInput(String documentName) {
		String xpath = "//h4[.//span[normalize-space()='" + documentName + "']]" + "/ancestor::div[contains(@class, 'bg-white')][1]" +"//input[@type='file']";
		
		return waitForElementPresent(By.xpath(xpath));
	}
	
	public void uploadDocuments(String documentName, String filePath) throws IOException {
		Path path = Paths.get(filePath);
		
		if(!Files.exists(path)) {
			throw new RuntimeException("File does not exist: " + path.toAbsolutePath());
		}
		
		if (!Files.isRegularFile(path)) {
            throw new RuntimeException("Path is not a valid file: " + path.toAbsolutePath());
        }
		
	    // Check file size - application allows maximum 5 MB
        long fileSizeInBytes = Files.size(path);
        long maxSizeInBytes = 5 * 1024 * 1024;

        if(fileSizeInBytes > maxSizeInBytes) {
            throw new RuntimeException("File exceeds 5 MB limit: " + path.toAbsolutePath());
        }
        
        WebElement fileInput = getFileInput(documentName);

        // sendKeys works directly with input[type=file]
        fileInput.sendKeys(path.toAbsolutePath().toString());
	}
	
    /**
     * Verify that the file has actually been selected.
     *
     * This checks the browser's FileList, not just the visual UI.
     */
    public boolean isFileUploaded(String documentName, String expectedFilePath) {

        Path path = Paths.get(expectedFilePath);

        if (!Files.exists(path)) {
            throw new RuntimeException(
                    "Expected file does not exist: " + path.toAbsolutePath()
            );
        }

        String expectedFileName = path.getFileName().toString();

        WebElement fileInput = getFileInput(documentName);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Check FileList length
        Long fileCount = (Long) js.executeScript(
                "return arguments[0].files.length;",
                fileInput
        );

        if (fileCount == null || fileCount == 0) {
            return false;
        }

        // Get actual uploaded file name from browser FileList
        String actualFileName = (String) js.executeScript(
                "return arguments[0].files[0].name;",
                fileInput
        );

        return expectedFileName.equals(actualFileName);
    }
    	
    
    /*Returns the uploaded filename.Useful for debugging.*/
    public String getUploadedFileName(String documentName) {

        WebElement fileInput = getFileInput(documentName);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (String) js.executeScript(
                "return arguments[0].files.length > 0 "
                + "? arguments[0].files[0].name "
                + ": '';",
                fileInput
        );
    }
}
