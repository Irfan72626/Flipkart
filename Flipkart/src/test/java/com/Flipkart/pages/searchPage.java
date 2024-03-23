package com.Flipkart.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPage {
	WebDriver driver;
	WebDriverWait wait;

	public searchPage(WebDriver ldriver) {
		this.driver = ldriver;
		this.wait = new WebDriverWait(driver,(Duration.ofSeconds(10)));
	}

	@FindBy(name = "q")
	WebElement searchBox;
	@FindBy(xpath = "//div[@class='_2WkVRV']")
	WebElement productName;
	@FindBy(xpath = "//a[@class='IRpwTa']")
	WebElement productDescription;
	@FindBy(xpath = "//div[@class='_30jeq3']")
	WebElement productPrice;

	public void searchProduct(String productName) {
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(productName);
		searchBox.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void scrapeProductInfoAndSaveToCsv(int numPages) {
		String csvFile = "Products.csv";
		try {
			FileWriter writer = new FileWriter(csvFile);
			for (int page = 1; page <= numPages; page++) {
				List<WebElement> product = driver.findElements(By.xpath("//div[@class='_2WkVRV']"));
				for (int i = 1; i <= product.size(); i++) {

					String productName = driver.findElement(By.xpath("(//div[@class='_2WkVRV'])[" + i + "]")).getText();
					String productPrice = driver.findElement(By.xpath("(//div[@class='_30jeq3'])[" + i + "]")).getText()
							.replaceAll("[^0-9.]", "");
					String productDescription = "";
					try {
						productDescription = driver.findElement(By.xpath("(//a[@class='IRpwTa'])[" + i + "]")).getText()
								.replace(",", " ");
						
					} catch (Exception e) {
						// productDescription is not available for the product
					}
                    System.out.println(productDescription);
					writer.append(productName + "," + productPrice + "," + productDescription + "\n");
				}
				WebElement nextButton = driver.findElement(By.xpath("(//a[@class='ge-49M'])[" + page + "]"));
				nextButton.click();
				System.out.println("page: " + page);
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
