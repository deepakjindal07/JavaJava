package com.codesetup;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OldCookieCapture {

	private static String baseUrl1;
	private static WebDriver contr0l;
	private static WebDriverWait hold;
	private static Properties prop;

	@BeforeClass
	@Parameters("Environment")
	public void setUp(String Environment) throws Exception {

		prop = CommonUtils.loadProperties();
		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("disable-notifications");
		chromeOptions.addArguments("disable-popup-blocking");
		chromeOptions.addArguments("incognito");
		chromeOptions.addArguments("disable-extensions");
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));
		chromeOptions.addArguments("ignore-certificate-errors");
		chromeOptions.addArguments("enable-automation");
		chromeOptions.addArguments("lang=en-US");

		contr0l = new ChromeDriver(chromeOptions);

		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		hold = new WebDriverWait(contr0l, Duration.ofSeconds(90));

		// Get env url as per parameter value.
		baseUrl1 = getBaseUrl1(Environment);
		System.out.println("Login for: " + baseUrl1);
		contr0l.get(baseUrl1);
	}

	@Test
	@Parameters("Environment")
	public void TestSetup(String Environment) throws Exception {
		HiddenLogin(contr0l,Environment);
	}

	@Parameters("Environment")
	public void HiddenLogin(WebDriver contr0l, String Environment) throws InterruptedException, IOException {

		Thread.sleep(1000);

		WebElement BYUiButton = hold.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-primary'][normalize-space()='Campus & Online']")));
		if (BYUiButton != null && BYUiButton.isDisplayed()) {
			contr0l.get(baseUrl1 + prop.getProperty("Login"));
			System.out.println("Normal >> " + baseUrl1 + prop.getProperty("Login"));
		} else {
			System.out.println("[Warning] Campus & Online button is not visible");
		}

		Thread.sleep(1000);

		WebElement ByuiLoginButton = hold.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Excelsoft Login']")));
		JavascriptExecutor js = (JavascriptExecutor) contr0l;
		js.executeScript("arguments[0].click();", ByuiLoginButton);

		System.out.println("[Info] Hidden ExcelSoft Login button clicked");

		// Login Method.
		login(contr0l, prop.getProperty("username"), prop.getProperty("password"));

		try {
			hold = new WebDriverWait(contr0l, Duration.ofSeconds(120));
			WebElement board = contr0l.findElement(By.xpath("//span[@class='userEmail'][normalize-space()='Deepak Jindal']"));
			hold.until(ExpectedConditions.visibilityOf(board));

			//System.out.println("Value: "+Environment);
			//Thread.sleep(100000);

			Set<Cookie> cookies = contr0l.manage().getCookies();
			CommonUtils.saveCookiesToFile(cookies, "cookies" + Environment);

			System.out.println("[Passed] Cookie Captured");
		} catch (Exception e) {
			System.out.println("[Failed] Unable to capture cookie");
			e.printStackTrace();
			Assert.fail("Unable to capture cookie");
		}
	}

	private void login(WebDriver contr0l, String username, String password) throws InterruptedException {
		WebElement UserNameField = contr0l.findElement(By.xpath("//input[@id='identifierId']"));
		UserNameField.clear();
		UserNameField.sendKeys("deepak.jindal@excelsoftcorp.com");

		WebElement NextButton = contr0l.findElement(By.xpath("//span[normalize-space()='Next']"));
		NextButton.click();

		Thread.sleep(1000); // Wait for the password field to be visible

		WebElement PassNameField = contr0l.findElement(By.xpath("//input[@name='Passwd']"));
		PassNameField.clear();
		PassNameField.sendKeys("india@555");
		PassNameField.sendKeys(Keys.ENTER);

		System.out.println("[Info] User/Pass entered..");
	}

	public static String getBaseUrl1(String env) {
		switch (env) {
		case "QA":
			return prop.getProperty("QA");
		case "RC":
			return prop.getProperty("RC");
		case "STAGE":
			return prop.getProperty("STAGE");
		case "TEST":
			return prop.getProperty("TEST");
		case "BT":
			return prop.getProperty("BT");
		case "SIRIUS":
			return prop.getProperty("SIRIUS");
		case "Core":
			return prop.getProperty("Core");
		case "Prod":
			return prop.getProperty("Prod");
		default:
			throw new IllegalArgumentException("Invalid environment specified: " + env);
		}
	}

	@AfterClass
	public void tearDown() {
		if (contr0l != null) {
			contr0l.quit();
		}
	}
}
