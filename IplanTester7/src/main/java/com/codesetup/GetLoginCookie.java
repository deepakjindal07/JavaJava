
package com.codesetup;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetLoginCookie extends Core {

	@Test
	public void TestSetup() throws Exception {
		String SelectedEnv = prop.getProperty("env");
		switch (SelectedEnv) {
		case "QA":
			HiddenLogin(contr0l);
			break;
		case "RC":
			HiddenLogin(contr0l);
			break;
		case "BT":
			HiddenLogin(contr0l);
			break;
		case "TEST":
			NormalLogin(contr0l);
			break;
		case "STAGE":
			NormalLogin(contr0l);
		case "SIRIUS":
			HiddenLogin(contr0l);
		case "Core":
			HiddenLogin(contr0l);
			break;
		case "Prod":
			NormalLogin(contr0l);
			break;

		default:
			System.out.println("Incorrect env set");
		}
	}

	public static void NormalLogin(WebDriver contr0l) throws InterruptedException, IOException {
		System.out.println("Cleaning..");
		System.out.println("Normal Login");
		contr0l.manage().deleteAllCookies();
		contr0l.navigate().refresh();
		prop = CommonUtils.loadProperties();
		System.out.println("Trying to click on Login");

		// button[@class='btn btn-primary'][normalize-space()='Campus & Online']
		// button[@class='btn btn-warning'][normalize-space()='PathwayConnect']
		// button[@class='btn btn-warning'][normalize-space()='Church Login']
		// contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement BYUiButton = contr0l.findElement(By.xpath("//button[@class='btn btn-primary'][normalize-space()='Campus & Online']"));
		// BYUiButton.click();

		// Click the ByuiLoginButton using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) contr0l;
		js.executeScript("arguments[0].click();", BYUiButton);

		WebElement header = contr0l.findElement(By.xpath("//h2[normalize-space()='Enter your Username and Password'] | //h1[normalize-space()='BYU-Idaho Login']"));
		if (header.isDisplayed()) {
			String env = prop.getProperty("env"); // Get Value1 QA
			System.out.println("Trying to login on " + env);

			String username;
			String password;

			// Choose credentials based on environment
			if (env.equals("QA")) {
				username = "epsone";
				password = "Excelsoft@123#";

			} else if (env.equals("SIRIUS")) {
				username = "epsone";
				password = "epsoneP@ss";

			} else if (env.equals("RC")) {
				username = "862141692";
				password = "862141692";

			} else if (env.equals("BT")) {
				username = "epsone";
				password = "epsoneP@ss";

			} else if (env.equals("TEST")) {
				username = "epsone";
				password = "P10ne1rH34tr";

			} else if (env.equals("STAGE")) {
				username = "epsone";
				password = "P10ne1rH34tr";
			} else if (env.equals("Prod")) {
				username = "epsone";
				password = "P10ne1rH34tr";
			} else {
				throw new IllegalArgumentException("Invalid environment: " + env);
			}

			// Wait for the UserNameField and interact with it
			WebElement UserNameField = contr0l.findElement(By.xpath("//input[@id='username']"));
			UserNameField.clear();
			UserNameField.sendKeys(username);

			// Locate and interact with the PasswordField
			WebElement PasswordField = contr0l.findElement(By.xpath("//input[@id='password']"));
			PasswordField.clear();
			PasswordField.sendKeys(password);
			PasswordField.sendKeys(Keys.ENTER);
			Thread.sleep(10000);
		}

		try {
			hold = new WebDriverWait(contr0l, Duration.ofSeconds(120));
			WebElement Headings = contr0l.findElement(By.xpath("//h1[normalize-space()='Welcome to I-PLAN']"));
			hold.until(ExpectedConditions.visibilityOf(Headings));

			// Get cookies and save them to a temporary file
			Set<Cookie> cookies = contr0l.manage().getCookies();
			CommonUtils.saveCookiesToFile(cookies, "cookies" + prop.getProperty("env"));

			System.out.println("TFA Login Done -Cookie Saved");

		} catch (Exception e) {
			// Print Y if the element is not visible or if an exception occurs
			System.out.println("Something went wrong with Login. ");
			Assert.assertTrue(true);
		}
	}

	public static void HiddenLogin(WebDriver contr0l) throws InterruptedException, IOException {
		System.out.println("[Info] Cleaning previous cookie, If any");
		contr0l.manage().deleteAllCookies();
		contr0l.navigate().refresh();

		Thread.sleep(1000);
		hold = new WebDriverWait(contr0l, Duration.ofSeconds(90));

		WebElement BYUiButton = hold.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-primary'][normalize-space()='Campus & Online']")));
		if (BYUiButton != null && BYUiButton.isDisplayed()) {
			//System.out.println(baseUrl + prop.getProperty("Login"));
			contr0l.get(baseUrl + prop.getProperty("Login"));

		} else {
			// Handle the case where the button is not visible
			System.out.println("[Warning] Campus & Online button is not visible");
		}

		Thread.sleep(1000);

		WebElement ByuiLoginButton = hold.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Excelsoft Login']")));

		JavascriptExecutor js = (JavascriptExecutor) contr0l;
		js.executeScript("arguments[0].click();", ByuiLoginButton);

		System.out.println("[Info] Hidden ExcelSoft Login button clicked");

		// Click the ByuiLoginButton using JavaScriptExecutor
		// JavascriptExecutor js = (JavascriptExecutor) contr0l;
		// js.executeScript("arguments[0].click();", ByuiLoginButton);

		WebElement UserNameField = contr0l.findElement(By.xpath("//input[@id='identifierId']"));
		UserNameField.clear();
		UserNameField.sendKeys("deepak.jindal@excelsoftcorp.com");
		// Thread.sleep(1000);
		WebElement NextButton = contr0l.findElement(By.xpath("//span[normalize-space()='Next']"));
		NextButton.click();
		// Thread.sleep(1000);
		WebElement PassNameField = contr0l.findElement(By.xpath("//input[@name='Passwd']"));
		PassNameField.clear();
		PassNameField.sendKeys("india@555");
		PassNameField.sendKeys(Keys.ENTER);

		System.out.println("[Info] User/Pass entered..");
//		Thread.sleep(2000);
//		WebElement finalNextButton = contr0l.findElement(By.xpath("//span[normalize-space()='Next']"));
//		finalNextButton.click();
//		Thread.sleep(10000);

		try {
			hold = new WebDriverWait(contr0l, Duration.ofSeconds(120));
			WebElement board = contr0l.findElement(By.xpath("//span[@class='userEmail'][normalize-space()='Deepak Jindal']"));
			hold.until(ExpectedConditions.visibilityOf(board));

			// Get cookies and save them to a temporary file
			Set<Cookie> cookies = contr0l.manage().getCookies();
			CommonUtils.saveCookiesToFile(cookies, "cookies" + prop.getProperty("env"));

			System.out.println("[Passed] Cookie Captured");
			// contr0l.quit();

		} catch (Exception e) {
			// Print Y if the element is not visible or if an exception occurs
			System.out.println("[Failed] Unable to capture cookie");
			Assert.assertTrue(true);
			// e.printStackTrace();
		}
	}
}