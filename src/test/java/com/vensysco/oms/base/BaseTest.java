package com.vensysco.oms.base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	public Properties properties;
	
	@BeforeMethod
	public void setUp() {
		//Loading config.properties file
		try {
			FileReader file = new FileReader("./src//test//resources//config.properties");
			properties = new Properties();
			properties.load(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(properties.getProperty("appUrl"));
	}
	
	/*
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	*/
}
