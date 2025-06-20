package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switch_Frame {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://example.com"); // Replace with your URL

		// Switch to iframe (by WebElement)
		WebElement iframe = driver.findElement(By.id("iframeID")); // or By.name("iframeName")
		driver.switchTo().frame(iframe);

		// Perform operations inside iframe
		WebElement insideElement = driver.findElement(By.id("insideElementID"));
		insideElement.click();

		// Switch back to the main content
		driver.switchTo().defaultContent();

		// Perform operations in the main page again
		WebElement outsideElement = driver.findElement(By.id("outsideElementID"));
		outsideElement.click();

		driver.quit();

	}

}
