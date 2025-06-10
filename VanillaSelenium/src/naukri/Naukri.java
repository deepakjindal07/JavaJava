package naukri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Naukri {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
		driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
				.sendKeys("deepak.jindal07@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("123456@");
		driver.findElement(By.xpath("//button[@type='submit']")).click(); //

		// SaveLogin(driver);
		Thread.sleep(5000);

		driver.get("https://www.naukri.com/mnjuser/recommendedjobs");

		String currWindow = driver.getWindowHandle();

		List<WebElement> Oneday = driver.findElements(By.xpath("(//span[contains(text(),'1 Day Ago')])"));

		for (WebElement L : Oneday)
		{
			L.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			Set<String> WH = driver.getWindowHandles();
			for (String win : WH)
			{
				if (!win.equals(currWindow))
				{
					driver.switchTo().window(win);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					driver.findElement(By.xpath("(//button[@id='apply-button'])[1]")).click();
					Thread.sleep(20000);
				}
			}

			driver.close();

			Thread.sleep(2000);
			driver.switchTo().window(currWindow);
			Thread.sleep(5000);
		}

		Thread.sleep(5000);

	}

	private static void SaveLogin(WebDriver driver) throws IOException {
		File file = new File("src/naukri/cookies.txt");
		if (!file.exists())
		{
			file.getParentFile().mkdirs();
			file.createNewFile();
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		for (Cookie cookie : driver.manage().getCookies())
		{
			writer.write(cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" + cookie.getPath()
					+ ";" + (cookie.getExpiry() != null ? cookie.getExpiry().toString() : "null") + ";"
					+ cookie.isSecure());
			writer.newLine();
		}

		writer.close();

	}

}
