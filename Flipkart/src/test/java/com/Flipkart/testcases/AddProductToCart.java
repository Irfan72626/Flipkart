package com.Flipkart.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Flipkart.pages.BaseClass;
import com.Flipkart.pages.FlipkartCartPage;


public class AddProductToCart extends BaseClass {
	
	@Test
	public void verifyAddProductToCart() throws InterruptedException {
		logger = report.createTest("VerifyAddProductToCart");
		FlipkartCartPage flipkartCartPage =PageFactory.initElements(driver, FlipkartCartPage.class);
		logger.info("Searching for the product");
		flipkartCartPage.searchProduct("T-shirts");
		logger.info("Succesfully searched for the T-shirts");
		flipkartCartPage.selectFirstProduct();
		logger.info("Selected the first product from the search result");
		flipkartCartPage.selectColor();
		logger.info("Selected the color of the product");
		flipkartCartPage.selectSize();
		logger.info("Selected the size of the product");
		flipkartCartPage.addToCart();
		logger.info("Product is added to the cart");
		boolean isProductInCart=flipkartCartPage.isProductInCart();
		Assert.assertTrue(isProductInCart, "Product is not added to the shopping cart");
		if(isProductInCart) {
			logger.pass("Product successfully added to the cart");
		}else {
			logger.fail("Product is not added to the cart");
		}
		logger.pass("Successfully Executed");
		
		 
		
	}

}
