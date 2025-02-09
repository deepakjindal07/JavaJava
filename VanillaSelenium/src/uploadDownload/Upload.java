package uploadDownload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver contr0l = new ChromeDriver();
		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(5000);

		// downloadkaro(contr0l);
		// Uploadkaro(contr0l);

		Thread.sleep(5000);

		contr0l.close();
		contr0l.quit();

	}

	@SuppressWarnings("unused")
	private static void Uploadkaro(WebDriver contr0l) {
		contr0l.get("https://practice.expandtesting.com/upload");
		WebElement file1 = contr0l.findElement(By.xpath("//input[@data-testid='file-input']"));
		file1.sendKeys("C://Users//Deepak//Downloads//test.pdf"); // Provide the absolute file path


		//JavascriptExecutor js = (JavascriptExecutor) contr0l;
		//js.executeScript("arguments[0].click();", file1);

	}

	@SuppressWarnings("unused")
	private static void downloadkaro(WebDriver contr0l) {
		contr0l.get("https://practice.expandtesting.com/download");
		WebElement file1 = contr0l.findElement(By.xpath("//a[@data-testid='1738635873367_pdf-sample.pdf']"));

		JavascriptExecutor js = (JavascriptExecutor) contr0l;
		js.executeScript("arguments[0].click();", file1);

	}

}
