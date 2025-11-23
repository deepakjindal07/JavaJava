package supportprograms;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.codesetup.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiLoginCaputes {

	public static Properties prop = new Properties();

	public static WebDriver driver;
	public static WebDriverWait holdx;

	public static void defineenv() throws IOException {
		prop = CommonUtils.loadProperties();
		List<String> urls = fetchURLs("QA", "SIRIUS"); // Specify environments here
		System.out.println("URLs:");

		// Once URL is retrived.
		for (String url : urls) {
			System.out.println(url);
		}

	}

	public static List<String> fetchURLs(String... environments) {
		List<String> urls = new ArrayList<>();
		for (String environment : environments) {
			String url = prop.getProperty(environment);
			if (url != null && !url.isEmpty()) {
				urls.add(url);
			} else {
				System.out.println("URL for environment '" + environment + "' not found.");
			}
		}
		return urls;
	}

	@Test
	public static void TestSetup() throws IOException, InterruptedException {
		// prop = CommonUtils.loadProperties();
		// String env = prop.getProperty("env");
		// String baseUrl = Core.getBaseUrl(env);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Here please iterate all the envs.
		driver.get("https://gps-qa-sql.excelindia.com/");
		Thread.sleep(10000);

		HiddenLogin(driver);

	}

	public static void HiddenLogin(WebDriver contr0l) throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(contr0l, Duration.ofSeconds(30));

		WebElement BYUiButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-primary'][normalize-space()='Campus & Online']")));

		if (BYUiButton != null && BYUiButton.isDisplayed()) {
			contr0l.get("https://gps-qa-sql.excelindia.com/enterprisev2/#/admin/excelsoft/login");
		} else {
			System.out.println("Campus & Online button is not visible");
			return; // Return or handle accordingly
		}

		WebElement ByuiLoginButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Excelsoft Login']")));

		((JavascriptExecutor) contr0l).executeScript("arguments[0].click();", ByuiLoginButton);

		System.out.println("Hidden ExcelSoft Login button clicked");

		// Interact with login fields
		WebElement userNameField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='identifierId']")));
		userNameField.clear();
		userNameField.sendKeys("deepak.jindal@asdf");

		WebElement nextButton = contr0l.findElement(By.xpath("//span[normalize-space()='Next']"));
		nextButton.click();

		WebElement passNameField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Passwd']")));
		passNameField.clear();
		passNameField.sendKeys("asdfasdf");

		WebElement finalNextButton = contr0l.findElement(By.xpath("//span[normalize-space()='Next']"));
		finalNextButton.click();

		// Wait for the welcome message
		WebElement board = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Welcome to I-PLAN']")));

		// Save cookies
		Set<Cookie> cookies = contr0l.manage().getCookies();
		CommonUtils.saveCookiesToFile(cookies, "QA");

		System.out.println("Hidden Login Done - Cookie Saved");
	}
}
