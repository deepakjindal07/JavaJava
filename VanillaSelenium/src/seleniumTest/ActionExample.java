package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionExample {
    public static void main(String[] args) {
        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to a webpage
        driver.get("https://www.example.com");

        // Find the elements you want to interact with
        WebElement element1 = driver.findElement(By.id("element1"));
        WebElement element2 = driver.findElement(By.id("element2"));

        // Create an Actions instance
        Actions actions = new Actions(driver);

        // Perform actions
        actions.moveToElement(element1)
                .click()
                .pause(2000)
                .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .moveToElement(element2)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();

        // Close the browser
        driver.quit();
    }
}


