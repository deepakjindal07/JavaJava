package seleniumTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.OffsetMapping.ForSelfCallHandle;

public class expandtesting {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Broken image finder;
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// FindBrokenimg();
		// fileUpload();
		dropdown();

		driver.close();

	}

	private static void dropdown() throws InterruptedException {
		driver.get("https://practice.expandtesting.com/dropdown");
		WebElement b1 = driver.findElement(By.xpath("//select[@id='country']"));
		b1.click();

		Select sel = new Select(b1);
		List<WebElement> l = sel.getOptions();

		for (WebElement a : l) {
			System.out.println(a.getText());
		}

//		WebElement select = driver.findElement(By.tagName("select"));
//		List<WebElement> allOptions = select.findElements(By.tagName("option"));
//
//		for (WebElement option : allOptions) {
//			System.out.println(String.format("Value is: %s", option.getAttribute("value")));
//			option.click();
//		}

		// JavascriptExecutor js = ((JavascriptExecutor) driver);
		// js.executeScript("arguments[0].click()", b1);

	}

	private static void fileUpload() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/upload");
		WebElement uploadbox = driver.findElement(By.id("fileInput"));
		// Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(uploadbox));
		// uploadbox.click();
		// uploadbox.sendKeys("/location.png");

		JavascriptExecutor js1 = ((JavascriptExecutor) (driver));
		js1.executeScript("arguments[0].click();", uploadbox);
		Thread.sleep(5000);
	}

	public static void FindBrokenimg() {
		// driver = new EdgeDriver();
		driver.get("https://practice.expandtesting.com/broken-images");
		List<WebElement> links = driver.findElements(By.tagName("img"));

		for (WebElement link : links) {

			String x = link.getAttribute("src");
			System.out.println("link : " + x);

			if (link.getAttribute("naturalWidth").equals("0")) {
				System.out.println("IsBroken");
			}

		}
	}
}
