package com.Flipkart.utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {


	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL) 
	{
	 if(browserName.equals("Chrome"))
	 {
		 //System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(30)));
	 }
	 else if(browserName.equals("Edge"))
	 {
		 System.setProperty("webdriver.chrome.driver", "./Drivers/msedgedriver.exe");
		 driver=new EdgeDriver();
		 driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(30)));
	 }
	 else
	 {
		 System.out.println("We do not support this browser");
	 }
	 driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(30)));
	 driver.manage().window().maximize();
	 driver.get(appURL);
	 driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(30)));
	 
	 
	 return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.close();;
	}




}
