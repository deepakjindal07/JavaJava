package restassured;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import static io.restassured.RestAssured.*;

public class HybridRestAssured {

	public static void main(String[] args) throws InterruptedException {

		// Optional: Set up ChromeDriver location
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled");

		WebDriver driver = new ChromeDriver(options);

		try
		{
			driver.get("https://sirius-qa.excelindia.com/enterprisev2/");
			Thread.sleep(5000);
			driver.get("https://sirius-qa.excelindia.com/enterprisev2/#/admin/excelsoft/login");

			// Click login with Google (modify selector as per your app)
			driver.findElement(By.xpath("//button[normalize-space()='Excelsoft Login']")).click();

			// Wait and perform Gmail login steps
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId")));
			email.sendKeys("deepak.jindal@excelsoftcorp.com");
			driver.findElement(By.id("identifierNext")).click();

			WebElement password = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@class='Xb9hP']//input[@type='password']")));
			password.sendKeys("India@555");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();

			// Wait for redirection after login
			wait.until(ExpectedConditions.urlContains("dashboard")); // or some other secure page

			// Get cookies from Selenium
			Set<org.openqa.selenium.Cookie> seleniumCookies = driver.manage().getCookies();
			List<Cookie> restAssuredCookies = new ArrayList<>();

			for (org.openqa.selenium.Cookie selCookie : seleniumCookies)
			{
				Cookie restCookie = new Cookie.Builder(selCookie.getName(), selCookie.getValue())
						.setDomain(selCookie.getDomain()).setPath(selCookie.getPath()).setSecured(selCookie.isSecure())
						.setHttpOnly(selCookie.isHttpOnly()).setExpiryDate(selCookie.getExpiry()).build();

				restAssuredCookies.add(restCookie);
			}

			Cookies cookies = new Cookies(restAssuredCookies);

			// Use cookies in Rest Assured API call
			RestAssured.baseURI = "https://your-app.com";
			given().cookies(cookies).when().get("/api/protected").then().statusCode(200);

		} finally
		{
			driver.quit();
		}
	}
}
