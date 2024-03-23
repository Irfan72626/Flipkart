package com.Flipkart.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Flipkart.utility.BrowserFactory;
import com.Flipkart.utility.ConfigDataProvider;
import com.Flipkart.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass 
{
	public static WebDriver driver;
	public static ConfigDataProvider config;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() 
	{
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/Flipkart"+Helper.getCurrentDateTime() +".html"));
	    report= new ExtentReports();
	    report.attachReporter(extent);
	
	
	}
	
	
	@BeforeClass
	public void setup() 
	{
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getTestURL());
		
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());

		}
		report.flush();
	}

}
