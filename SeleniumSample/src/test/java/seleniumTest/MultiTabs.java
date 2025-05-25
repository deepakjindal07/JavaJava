package seleniumTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class MultiTabs {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.com/");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()='Help']")).click();
		Thread.sleep(5000);

		String curr = driver.getWindowHandle();
		Set<String> ls = driver.getWindowHandles();

		for (String one : ls)
		{
			if (one != curr)
			{
				driver.switchTo().window(one);
				Thread.sleep(5000);
			}
		}
		
        // Highlight the element using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'");

        // Take screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile, new File("screenshot.png"));
        System.out.println("Screenshot saved!");
		
		driver.close();

	}

}
