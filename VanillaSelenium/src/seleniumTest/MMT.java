package seleniumTest;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.By;
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
		
//		File x = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		Files.copy(x, new File("something.png"));
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
	    com.google.common.io.Files.copy(screenshot, new File("screenshot.png"));
		
		//Files.copy("abc.png",screenshot);
		
		//Files.copy(screenshot, new File("screenshot.png"));

		// Take a screenshot
		// File screenshot2 = ((TakesScreenshot)
		// driver).getScreenshotAs(OutputType.FILE);
		// Specify the destination to save the screenshot
		// File destination = new File("path/to/screenshot.png");
		// Copy the screenshot to the specified location
		// Files.copy(screenshot, destination);

	}

}
