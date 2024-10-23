package naukri;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Naukri {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
		driver.findElement(By.xpath("//a[@id='login_Layer']"))
		.click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
		.sendKeys("deepak.jindal07@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']"))
		.sendKeys("123456@");
		driver.findElement(By.xpath("//button[@type='submit']"))
		.click(); //

		// CustCookies.Save(driver);

		Thread.sleep(5000);
		driver.get("https://www.naukri.com/recommendedjobs");

		String currWindow = driver.getWindowHandle();

		List<WebElement> Oneday = new ArrayList<>();
		Oneday = driver.findElements(By.xpath("(//span[contains(text(),'1 Day Ago')])"));

		for (WebElement L : Oneday) {
			L.click();
			driver.findElement(By.xpath("//button[@id='apply-button']")).click();
			driver.close();

			Thread.sleep(2000);
			driver.switchTo().window(currWindow);
			Thread.sleep(5000);
		}

		// driver.findElement(By.xpath("//button[@id='apply-button']");

		/*
		 * Thread.sleep(5000); CustCookies.Load(driver);
		 * 
		 * for (Cookie cookie : driver.manage().getCookies()) {
		 * System.out.println(cookie); }
		 * 
		 * Thread.sleep(1000); driver.navigate().refresh();
		 * 
		 * Thread.sleep(10000);
		 */

	}

}
