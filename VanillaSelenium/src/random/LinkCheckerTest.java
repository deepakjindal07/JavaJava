package random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.HttpURLConnection;
import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LinkCheckerTest {

    WebDriver driver;
    List<String> hrefList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty() && href.startsWith("http")) {
                hrefList.add(href);
            }
        }

        System.out.println("Total valid links found: " + hrefList.size());
    }

    @DataProvider(name = "linkProvider")
    public Object[][] linkProvider() {
        Object[][] data = new Object[hrefList.size()][1];
        for (int i = 0; i < hrefList.size(); i++) {
            data[i][0] = hrefList.get(i);
        }
        return data;
    }

    @Test(dataProvider = "linkProvider")
    public void testLinkStatus(String url) {
        try {
            URI uri = URI.create(url);
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setConnectTimeout(3000);
            conn.connect();

            int statusCode = conn.getResponseCode();
            System.out.println("Checking: " + url + " - Status: " + statusCode);

            Assert.assertTrue(statusCode < 400, "❌ Broken link: " + url + " - Status: " + statusCode);

        } catch (Exception e) {
            Assert.fail("⚠️ Exception checking link: " + url + " - " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
