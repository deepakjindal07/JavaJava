package seleniumTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;

public class RedBusTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement From = driver.findElement(By.xpath("//input[@id='src']"));
		From.click();
		From.sendKeys("Delhi");
		Thread.sleep(1000);
		From.sendKeys(Keys.ENTER);

		WebElement to = driver.findElement(By.xpath("//input[@id='dest']"));
		to.click();
		Thread.sleep(1000);
		to.sendKeys("Goa");
		to.sendKeys(Keys.ENTER);

		// WebElement SBtn =
		// driver.findElement(By.xpath("//button[@id='search_button']"));
		// SBtn.click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@id='onwardCal']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[normalize-space()='Help']")).click();

		final String OrigTab = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();

		for (String Tab : tabs) {
			if (!Objects.equals(Tab, OrigTab)) {
				driver.switchTo().window(Tab);
				System.out.println("CurrentTab:" + driver.getWindowHandle());
			}

		}
		System.out.println("Closing tabs in 5 seconds");
		Thread.sleep(5000);

		Set<String> currentTabs = driver.getWindowHandles();
		for (String tab : currentTabs) {
			if (!tab.equals(OrigTab)) {
				driver.switchTo().window(tab);
				driver.close();
			}
		}

		// Switch back to the original tab
		driver.switchTo().window(OrigTab);

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("location.png"));
	}

}
