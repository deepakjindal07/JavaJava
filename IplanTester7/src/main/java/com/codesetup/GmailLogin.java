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
import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailLogin {

	//private static final String TEMP_PROFILE_DIR = System.getProperty("java.io.tmpdir") + "/excelsoft";
	//private static final String COOKIES_FILE_FORMAT = "cookies_%s.txt";

	public static void main(String[] args) throws Exception {
		// String env = args.length > 0 ? args[0] : "QA"; // Default to QA

		Properties prop = CommonUtils.loadProperties();
		String env = prop.getProperty("env");

		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		//chromeOptions.addArguments("--user-data-dir=" + TEMP_PROFILE_DIR); // Use temporary profile
		chromeOptions.addArguments("incognito");
		// Add other desired Chrome options

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String baseUrl = getBaseUrl(env, prop);
		System.out.println("Login for: " + baseUrl);
		driver.get(baseUrl);

		try {
			performHiddenLogin(driver, prop);

			Set<Cookie> cookies = driver.manage().getCookies();
			CommonUtils.saveCookiesToFile(cookies, "cookies" + env);


			System.out.println("[Passed] Cookie Captured");
		} catch (Exception e) {
			System.out.println("[Failed] Unable to capture cookie");
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	private static String getBaseUrl(String env, Properties prop) {
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
			throw new IllegalArgumentException("Invalid env specified: " + env);
		}
	}

	private static void performHiddenLogin(WebDriver driver, Properties prop) throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

		WebElement campusOnlineButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-primary'][normalize-space()='Campus & Online']")));
		if (campusOnlineButton != null && campusOnlineButton.isDisplayed()) {
			driver.get(getBaseUrl(prop.getProperty("env"), prop) + prop.getProperty("Login"));
			System.out.println(
					"Normal >> " + getBaseUrl(prop.getProperty("env"), prop) + prop.getProperty("Login"));
		} else {
			System.out.println("[Warning] Campus & Online button is not visible");
		}

		Thread.sleep(1000);

		WebElement excelsoftLoginButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Excelsoft Login']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", excelsoftLoginButton);

		System.out.println("[Info] Hidden ExcelSoft Login button clicked");

		login(driver, prop.getProperty("username"), prop.getProperty("password"));

		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//span[@class='userEmail'][normalize-space()='Deepak Jindal']"))));
	}

	private static void login(WebDriver driver, String username, String password) throws InterruptedException, IOException {
		WebElement userNameField = driver.findElement(By.xpath("//input[@id='identifierId']"));
		userNameField.clear();
		userNameField.sendKeys(username);

		WebElement nextButton = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
		nextButton.click();

		Thread.sleep(1000);

		WebElement passNameField = driver.findElement(By.xpath("//input[@name='Passwd']"));
		passNameField.clear();
		passNameField.sendKeys(password);
		passNameField.sendKeys(Keys.ENTER);

		System.out.println("[Info] User/Pass entered..");
		
		Duration.ofSeconds(5);
		
		Properties prop = CommonUtils.loadProperties();
		
		Set<Cookie> cookies = driver.manage().getCookies();
		CommonUtils.saveCookiesToFile(cookies, "cookies" + prop.getProperty("env"));
	}

//	private static void saveCookiesToFile(Set<Cookie> cookies, String fileName) throws IOException {
//		File cookieFile = new File(TEMP_PROFILE_DIR, fileName);
//		Files.write(cookieFile.toPath(),
//				cookies.stream().map(cookie -> cookie.getName() + "=" + cookie.getValue()).collect(Collectors.toList()),
//				StandardCharsets.UTF_8);
//
//		
//		
//	}
}