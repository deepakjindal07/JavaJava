package supportprograms;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogger {

    public static WebDriver driver;
    public static Logger log;

    public static void main(String[] args) throws InterruptedException {
        log = LogManager.getLogger(TestLogger.class);

        // Configure WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Myntra website
        driver.get("https://www.myntra.com/");
        log.info("Navigated to Myntra website");

        Thread.sleep(5000);

        // Perform actions
        log.info("Clicking on 'Women' link");
        try {
            boolean text = driver.findElement(By.xpath("//a[contains(text(),'Women')]")).isDisplayed();
            if (text) {
                log.info("'Women' link is displayed");
            }
        } catch (Exception e) {
            log.error("Exception occurred: Element Not Found", e);
        } finally {
            // Close the browser
            driver.quit();
            log.info("Quitting the driver");
        }
    }
}
