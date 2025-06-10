package naukri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Apply_1 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loadCookie(driver);

		// driver.get("https://www.naukri.com/recommendedjobs");

		String currWindow = driver.getWindowHandle();

		List<WebElement> Oneday = new ArrayList<>();
		Oneday = driver.findElements(By.xpath("(//span[contains(text(),'1 Day Ago')])"));

		for (WebElement L : Oneday)
		{
			L.click();
			driver.findElement(By.xpath("//button[@id='apply-button']")).click();
			driver.close();

			Thread.sleep(2000);
			driver.switchTo().window(currWindow);
			Thread.sleep(5000);
		}

		Thread.sleep(10000);

	}

	private static void loadCookie(WebDriver driver) throws IOException, ParseException {

		//driver.get("https://www.naukri.com/"); // must match the domain
		BufferedReader reader = new BufferedReader(new FileReader("src/naukri/cookies.txt"));
		String line;

		while ((line = reader.readLine()) != null)
		{
			String[] token = line.split(";", -1);
			if (token.length < 6)
				continue;

			String name = token[0];
			String value = token[1];
			String domain = token[2];
			String path = token[3];
			String expiryRaw = token[4];
			boolean isSecure = Boolean.parseBoolean(token[5]);

			Date expiry = null;
			if (!"null".equals(expiryRaw))
			{
				SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
				expiry = formatter.parse(expiryRaw);
			}

			Cookie cookie = (expiry != null)
					? new Cookie.Builder(name, value).domain(domain).path(path).expiresOn(expiry).isSecure(isSecure)
							.build()
					: new Cookie.Builder(name, value).domain(domain).path(path).isSecure(isSecure).build();

			driver.manage().addCookie(cookie);
		}

		reader.close();
		driver.navigate().refresh();
	}

}
