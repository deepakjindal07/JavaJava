package supportprograms;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiLoginCaptures {
    public static void main(String[] args) {
        try {
            List<String> environments = URLFetcher1.fetchEnvironments(
                "https://gps-qa-sql.excelindia.com/",
                "https://sirius-qa.excelindia.com/"
            );

            for (String environment : environments) {
                System.out.println("Running for environment: " + environment);

                WebDriver driver = WebDriverInitializer.initializeWebDriver();
                HiddenLoginHandler1.performHiddenLogin(driver, environment);
                driver.quit(); // Close the WebDriver after each iteration
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class URLFetcher1 {
    public static List<String> fetchEnvironments(String... environments) {
        List<String> environmentUrls = new ArrayList<>();
        for (String environment : environments) {
            environmentUrls.add(environment);
        }
        return environmentUrls;
    }
}

class WebDriverInitializer {
    public static WebDriver initializeWebDriver() {
        // Initialize WebDriver (ChromeDriver in this case)
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}

class HiddenLoginHandler1 {
    public static void performHiddenLogin(WebDriver driver, String environment) throws InterruptedException {
        // Open the URL
        driver.get(environment);
        Thread.sleep(10000); // Wait for page to load

        // Perform hidden login
        // Your login logic here...

        // Example:
        System.out.println("Login completed for environment: " + environment);
    }
}
