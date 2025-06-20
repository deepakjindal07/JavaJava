package seleniumTest2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement a = driver.findElement(By.xpath("//div[@id='withOptGroup']//div[@class=' css-1hwfws3']"));
		a.click();
		
		Thread.sleep(2000); 
		
		//WebElement b = driver.findElement(By.xpath("//div[@id='react-select-9-option-0-0']"));
		//b.click();
		
		List<WebElement> listdd = driver.findElements(By.xpath("//div[@class=' css-26l3qy-menu']"));
		
		for(WebElement e: listdd) {
			System.out.println(e.getText());
		}
		
		Thread.sleep(5000); 
		driver.quit();
		
	}

}
