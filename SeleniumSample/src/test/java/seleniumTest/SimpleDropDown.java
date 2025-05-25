package seleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleDropDown {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
	}

	@Test(enabled = false)
	public void selectFromDropdown() {
		WebElement drop1 = driver.findElement(By.id("carselect"));
		Select sel = new Select(drop1);
		sel.selectByIndex(2); // Honda
	}

	@Test(enabled = false)
	public void newWindow() throws InterruptedException {

		String currTab = driver.getWindowHandle();
		WebElement nw = driver.findElement(By.xpath("//button[text()='Open Window']"));
		nw.click();
		Thread.sleep(2000);
		for (String s : driver.getWindowHandles())
		{
			if (s != currTab)
			{
				driver.switchTo().window(s);
			}
		}
		System.out.println(driver.getTitle());
		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void newFrame() throws InterruptedException {
		
		WebElement frameName = driver.findElement(By.tagName("iframe"));

		driver.switchTo().frame(frameName);
		driver.findElement(By.xpath("//a[@href='/home']")).click();
		Thread.sleep(10000);
	}

	@Test
	public void alert() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Thread.sleep(5000);
		
		driver.switchTo().alert().accept();
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
