package random;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Bonigarcia {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

		WebElement click1 = driver
				.findElement(By.xpath("//span[@class='commonModal__close']"));
		click1.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", click1); 
		

		// Ctrl + Click using Actions
		//Actions actions = new Actions(driver);
		//actions.keyDown(Keys.CONTROL).click(click1).keyUp(Keys.CONTROL).build().perform();
		//Thread.sleep(5000);

//		Set<String> windowList = driver.getWindowHandles();
//		for (String win : windowList)
//		{
//			System.out.println(win);
//			driver.switchTo().window(win);
//
//			if (driver.getCurrentUrl().contains("web-form"))
//			{
//				Thread.sleep(10000);
//				System.out.println("Page Found");
//				break;
//			}
//		}
		

		
//		int num=0;
//		while(windowList.size()>1) {
//			System.out.println(windowList.get(num));
//			//num++;
//		}

		// driver.switchTo().window(windowList.get(1));
		Thread.sleep(5000);

		// JavascriptExecutor js = (JavascriptExecutor) driver;

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshot.png");
		FileHandler.copy(src, dest);
		
		FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("screenshot.png"));


		driver.quit();

	}

}
