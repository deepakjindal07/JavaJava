package seleniumTest;



import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class SimpleStartBrowser {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to GeckoDriver (Firefox driver)
        //System.setProperty("webdriver.gecko.driver", "C:\\eclipse\\selenium-java\\geckodriver.exe");

        // Set Firefox binary location
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        // Instantiate WebDriver (FirefoxDriver) with options
        WebDriver driver = new FirefoxDriver(options);

        // Navigate to Google
        driver.get("https://www.google.com");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Wait for 5 seconds
        TimeUnit.SECONDS.sleep(5);

        // Close the browser
        driver.quit();
    }
}
