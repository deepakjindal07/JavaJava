package seleniumTest;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenAllLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.drive",
		// "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (WebElement link : links) {

			// print the links i.e. http://google.com or https://www.gmail.com
			
			String linkText = link.getText().trim(); // Trim leading/trailing spaces
            String linkHref = link.getAttribute("href");

            if (!linkText.isEmpty()) {  // Print only links with text
                System.out.println("Link Text: " + linkText);
                System.out.println("Link URL: " + linkHref);
                link.click();
                Thread.sleep(5000);
                driver.navigate().back(); // Navigate back to the main page after each click
            }

			// print the links text
			System.out.println(link.getText());
		}
		 driver.quit(); //
	}
}
