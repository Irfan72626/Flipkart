# Selenium WebDriver Automation Script with TestNG
This project contains an automation script written in Java using Selenium WebDriver and TestNG to simulate adding a product to the cart on a website and it includes a test class `ProductInfo` for scraping data from the web browser and storing it into a CSV file.
## Setup
1. **Java Development Kit (JDK)**:
  - Make sure you have JDK installed on your system. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. **WebDriver for Chrome**:
  - Download the chromedriver executable compatible with your Chrome browser version from [here](https://chromedriver.chromium.org/downloads).
  - Place the chromedriver executable in the `drivers` folder of the project.
3. **Dependencies**:
  - This project uses Maven as a build tool. Make sure you have Maven installed on your system.
  - The required dependencies are managed in the pom.xml file.
## Configuration
1. **Chromedriver Path**:
  - The `chromedriver.exe` file is located in the `drivers` folder of the project.
  - The `AddProductToCartTest.java` class and `ProductInfo.java` class are configured to use the chromedriver from this location. No further action is required.
## Running the Script
1. **Using IDE**:
  - Import the project into your preferred IDE (e.g., IntelliJ, Eclipse).
  - Run the `AddProductToCartTest` class as a TestNG test.
  - Run the `ProductInfo` class as a TestNG test.
## Expected Output
  - The `AddProductToCartTest` script will open a Chrome browser, navigate to the specified website, and simulate adding a product to the cart.
  - The `ProductInfo` script will scrape data from the web browser and store it into a CSV file.
## Troubleshooting
  - If the scripts fail due to webdriver path or other dependencies, make sure to double-check the configuration steps.
  - Ensure that your chromedriver version matches your Chrome browser version.
