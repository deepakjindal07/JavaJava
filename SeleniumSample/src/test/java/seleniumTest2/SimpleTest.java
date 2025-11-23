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
		driver.manage().window().maximize();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//WebElement ele = driver.findElement(By.xpath("")); 
		
		List<WebElement> ele2 =  driver.findElements(By.tagName("a"));
		
		for (WebElement abc : ele2) {
			//System.out.println("Element name"+abc);
			
			String linkUrl = abc.getAttribute("href");
			System.out.println(linkUrl);
		}
		
		driver.close();
		driver.quit();
		
		
	}

}
