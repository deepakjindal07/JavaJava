package shine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Apply_1 {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.shine.com/myshine/home");
		driver.manage().window().maximize();

		Thread.sleep(5000);
		loadCookie(driver);

		//for (int i = 0; i < 100; i++)
		//{

		while (true) {
		    // Find and click all Apply buttons on the current page
		    List<WebElement> applyButtons = driver.findElements(By.xpath("//button[contains(text(),'Apply')]"));
		    System.out.println("Apply Buttons on this page: " + applyButtons.size());

		    for (int i = 0; i < applyButtons.size(); i++) {
		        try {
		            List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(text(),'Apply')]"));
		            WebElement applyButton = buttons.get(i);

		            if (applyButton.isDisplayed() && applyButton.isEnabled()) {
		                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyButton);
		                Thread.sleep(500);
		                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyButton);
		                System.out.println("Clicked button " + (i + 1));
		                Thread.sleep(1000); // slight delay to handle loading
		            }
		        } catch (Exception e) {
		            System.out.println("Failed to click button " + (i + 1) + ": " + e.getMessage());
		        }
		    }

		    // Try to click the "Next" button if it exists and is enabled
		    try {
		        WebElement next = driver.findElement(By.xpath("//img[@class='paginationNova_rs__MYIE_']"));
		        if (next.isDisplayed() ) { //&& next.isEnabled()) {
		            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
		            Thread.sleep(500);
		            next.click();
		            Thread.sleep(2000); // wait for next page to load
		        } else {
		            break; // no more next button
		        }
		    } catch (Exception e) {
		        System.out.println("No more pages or Next button not found.");
		        break;
		    }
		}


		driver.quit();

	}

	private static void loadCookie(WebDriver driver) throws IOException, ParseException {
		File file = new File("cookies.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line;

		while ((line = bufferedReader.readLine()) != null)
		{
			String[] token = line.split(";");
			String name = token[0];
			String value = token[1];
			String domain = token[2];
			String path = token[3];
			java.util.Date expiry = null;

			SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

			if (!token[4].equals("null"))
			{
				expiry = formatter.parse(token[4]);
			}

			boolean isSecure = Boolean.parseBoolean(token[5]);

			Cookie cookie = new Cookie.Builder(name, value).domain(domain).path(path).expiresOn(expiry)
					.isSecure(isSecure).build();

			driver.manage().addCookie(cookie);
		}

		bufferedReader.close();

		// Reload the page after adding cookies
		driver.navigate().refresh();

	}

}
