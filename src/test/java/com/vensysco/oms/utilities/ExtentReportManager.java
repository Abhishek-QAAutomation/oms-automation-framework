package com.vensysco.oms.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String reportName;
	
	public void onStart(ITestContext context) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date = new Date();
		String currentDateTimeStamp = dateFormat.format(date);
		
		reportName = "Test_Report_" + currentDateTimeStamp + ".html";
		  
		sparkReporter = new ExtentSparkReporter(".//reports//" + reportName);
		
		sparkReporter.config().setDocumentTitle("OMS Automation Report");
		sparkReporter.config().setReportName("OMS Functional Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Applicaton", "ObserverManagementSystem");
		extent.setSystemInfo("Module", "Observer");
		extent.setSystemInfo("Project Manager", "Reyaz");
		extent.setSystemInfo("QA Lead", "Anil Kumar");
		extent.setSystemInfo("Automation Developed By", "Abhishek Rai");
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "got successfully executed");
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + "got failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
