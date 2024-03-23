package com.Flipkart.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Flipkart.pages.BaseClass;
import com.Flipkart.pages.FlipkartCartPage;
import com.Flipkart.pages.searchPage;

public class ProductInfo extends BaseClass{
	
	@Test
	public void productInfoExtraction() {
		logger = report.createTest("ProductInfoExtraction");
		searchPage searchPage =PageFactory.initElements(driver, searchPage.class);
		searchPage.searchProduct("T-shirts");
		searchPage.scrapeProductInfoAndSaveToCsv(3);
	}

}
