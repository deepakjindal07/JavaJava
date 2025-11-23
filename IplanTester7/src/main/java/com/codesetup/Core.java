package com.codesetup;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Core {
	protected static WebDriver contr0l;
	public static WebDriverWait hold;
	public static Properties prop;
	public static String baseUrl;
	public static SoftAssert softAssert;
	public static int triggerwait = 10000;
	public static int bigwait = 30000;
	// 10s 10000 | 30s 30000 | 1m 60000 | 2m 120000 | 5m 300000 | 10m 600000 | 15
	// 900000

	// Set up environment and initialize WebDriver before suite
	@BeforeSuite
	public void CoreSetup() throws IOException, InterruptedException {

		// Reporter.log("Something test",true);
		prop = CommonUtils.loadProperties();
		String env = prop.getProperty("env");
		baseUrl = getBaseUrl(env);

		SetupBrowser(prop.getProperty("browser"));

		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		contr0l.get(baseUrl);
		Thread.sleep(1000);

		CommonUtils.loadCookiesFromFile(contr0l, prop.getProperty("env"));
		Thread.sleep(1000);

		// DevToolsChecker.CallStatusCheck(contr0l);
		System.out.println("Testing on " + env + " " + prop.getProperty("browser"));
		System.out.println("Time for trigger set at:" + triggerwait / 1000 + " Seconds");
		System.out.println("Time for BigWait set at:" + bigwait / 1000 + " Seconds");

	}

	// Initialize WebDriver based on browserName
	public static void SetupBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			// WebDriverManager.chromedriver().clearDriverCache().setup(); //Clear cache

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("disable-notifications");
			chromeOptions.addArguments("disable-popup-blocking");
			chromeOptions.addArguments("incognito");
			chromeOptions.addArguments("disable-extensions");
			chromeOptions.addArguments("disable-infobars");
			// chromeOptions.addArguments("--remote-allow-origins=*");

			chromeOptions.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));
			chromeOptions.addArguments("ignore-certificate-errors");
			chromeOptions.addArguments("enable-automation");
			chromeOptions.addArguments("lang=en-US");
			contr0l = new ChromeDriver(chromeOptions);
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--start-maximized");
			edgeOptions.addArguments("disable-infobars");
			edgeOptions.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));
			contr0l = new EdgeDriver(edgeOptions);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("-private"); // Equivalent to incognito mode
			firefoxOptions.addPreference("permissions.default.desktop-notification", 2); // Equivalent to disabling
																							// notifications
			firefoxOptions.addPreference("dom.disable_open_during_load", false); // Equivalent to disabling popup
																					// blocking
			firefoxOptions.addPreference("dom.webnotifications.enabled", false); // Another way to disable notifications
			firefoxOptions.addPreference("extensions.enabled", false); // Equivalent to disabling extensions
			firefoxOptions.addPreference("browser.urlbar.showSearch", false); // Equivalent to hiding infobars
			firefoxOptions.addPreference("security.certerrors.mitm.auto_enable_enterprise_roots", false); // Equivalent
																											// to
																											// ignoring
																											// certificate
																											// errors
			firefoxOptions.addPreference("intl.accept_languages", "en-US"); // Setting language

			contr0l = new FirefoxDriver();
			break;

		case "safari":
			contr0l = new SafariDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}
	}

	// Get the base URL based on environment, i.e www.env-byui.com
	public static String getBaseUrl(String env) {
		return switch (env) {
		case "QA" -> prop.getProperty("QA");
		case "RC" -> prop.getProperty("RC");
		case "STAGE" -> prop.getProperty("STAGE");
		case "TEST" -> prop.getProperty("TEST");
		case "BT" -> prop.getProperty("BT");
		case "SIRIUS" -> prop.getProperty("SIRIUS");
		case "Core" -> prop.getProperty("Core");
		case "Prod" -> prop.getProperty("Prod");
		default -> throw new IllegalArgumentException("Invalid environment specified: " + env);
		};

	}

	@AfterSuite
	public void tearDown() throws InterruptedException {
		System.out.println("Attempting Closing..");

		//
		if (contr0l != null) {
			try {
				contr0l.close();
				contr0l.quit();
				System.out.println("Driver Quitting...");
			} catch (NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
		} else {
			System.out.println("WebDriver instance is null.");
		}
	}
}
