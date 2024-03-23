package com.Flipkart.pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartCartPage {

	WebDriver driver;
	WebDriverWait wait;

	public FlipkartCartPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));
	}

	@FindBy(name = "q")
	WebElement searchBox;
	@FindBy(xpath = "//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div/a[1]")
	WebElement product;
	@FindBy(xpath = "(//div[@class='_2WkVRV'])[1]")
	WebElement productBrand;
	@FindBy(xpath = "//a[@class='kmlXmn _31hAvz']")
	WebElement colorOptions;
	@FindBy(xpath = "//a[@class='_1fGeJ5 _2UVyXR _31hAvz']")
	WebElement sizeOptions;
	@FindBy(xpath = "//ul[@class='row']//li[1]//button")
	WebElement addCartButton;

	// Method to search for a Product
	public void searchProduct(String productName) {
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(productName);
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	// Method to select First Product
	public void selectFirstProduct() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(product));
		product.click();
		Thread.sleep(6000);
		Set<String> windowHandles = driver.getWindowHandles();
		// Switching to the second tab
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals("Title of the second tab")) {
				break;
			}
		}

	}

	// Method to select the Color of the product
	public void selectColor() {
		try {
			wait.until(ExpectedConditions.visibilityOf(colorOptions));
			colorOptions.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Method to select the Size of the product
	public void selectSize() {
		wait.until(ExpectedConditions.visibilityOf(sizeOptions));
		sizeOptions.click();
		
	}

	// Method to add the product to the shopping cart
	public void addToCart() {
		wait.until(ExpectedConditions.visibilityOf(addCartButton));
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			//jse.executeScript("window.scrollBy(0,2000)");
			WebElement questions = driver.findElement(By.xpath("//a[contains(text(),'All questions')] | //span[contains(text(),'Have doubts regarding this product?')]"));
			jse.executeScript("arguments[0].scrollIntoView();", questions);
			addCartButton.click();
		} catch (Exception e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-450)");
			wait.until(ExpectedConditions.visibilityOf(addCartButton));
			addCartButton.click();
		}
		
	}

	// Method to verify if the product is in the shopping cart
	public boolean isProductInCart() {
		WebElement cartProduct = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']"));
		if (!cartProduct.isDisplayed()) {
			return false;
		}

		return true;

	}
}
