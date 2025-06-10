package shine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Login_1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.shine.com/myshine/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement user = driver.findElement(By.xpath("(//input[@id='id_email_login'])[1]"));
		user.click();
		user.sendKeys("deepak.jindal07@gmail.com");

		WebElement pass = driver.findElement(By.xpath("(//input[@id='id_password'])[1]"));
		pass.click();
		pass.sendKeys("India@123");

		driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Login'])[1]")).click();
		Thread.sleep(20000);

		SaveLogin(driver);

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		List<WebElement> apply = driver.findElements(By.xpath("(//button[contains(text(),'Apply')])"));
//		System.out.println("Total Links: " + apply.size());
//		
//		//driver.switchTo().alert().accept();
//
//		for (WebElement apply1 : apply)
//		{
//
//			if (apply1.isDisplayed() && apply1.isEnabled())
//			{
//				apply1.click();
//			}
//			Thread.sleep(2000);
//		}

		driver.quit();

	}

	private static void SaveLogin(WebDriver driver) throws IOException {
		// driver = driver;
		File file = new File("src/shine/cookies.txt");
		file.delete(); // Delete if already exists
		file.createNewFile();

		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie ck : cookies)
		{
			bufferedWriter.write(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
					+ ck.getExpiry() + ";" + ck.isSecure());
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
		fileWriter.close();

	}

}
