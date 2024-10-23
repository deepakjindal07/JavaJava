package com.browserstack;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @SuppressWarnings("unchecked")
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
    }
    
    @Test
    public static void getTitle() {
    	String title = driver.getTitle();
    	String expectedTitle = "Google";
    	assert title.equals(expectedTitle) : "Expected title '" + expectedTitle + "' but found '" + title + "'";
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
