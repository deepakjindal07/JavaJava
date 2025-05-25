package seleniumTest;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MMT {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");

		// Thread.sleep(10000);

		String windows = driver.getWindowHandle();

//		driver.switchTo().window(windows);

		WebElement xbtn = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
		xbtn.click();

		Thread.sleep(2000);
//
//		WebElement From = driver.findElement(By.xpath("//span[@data-cy='defaultFromValue']"));
//		From.click();
//		Thread.sleep(2000);
//
//		WebElement From2 = driver.findElement(By.xpath("//input[@placeholder='From']"));
//		From2.sendKeys("kash");
//		Thread.sleep(2000);
//		From2.sendKeys(Keys.ARROW_DOWN);
//		From2.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);

		// Robot r = new Robot();
		// r.createScreenCapture(yes);
		
		JavascriptExecutor js1 = ((JavascriptExecutor) driver);
		js1.executeScript("arguments[0].click();", xbtn);

		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot.toPath(), new File("screenshot.png").toPath());

	}

}
