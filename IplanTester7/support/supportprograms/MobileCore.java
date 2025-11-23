package supportprograms;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.codesetup.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileCore {
	public static WebDriver driver;
	public static WebDriverWait hold;
	public static Properties prop;
	public static String baseUrl;
	public static SoftAssert softAssert;
	public static int triggerwait = 10000;
	public static int bigwait = 10000;

	@BeforeSuite
	public void MobileCoreSetup() throws IOException, InterruptedException {

		prop = CommonUtils.loadProperties();
		// String env = prop.getProperty("env");
		// baseUrl = "https://sirius-qa.excelindia.com/";

		WebDriverManager.chromedriver().setup();

		// Define the mobile emulation settings
		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

		// Set the ChromeOptions to use mobile emulation
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("disable-notifications");
		chromeOptions.addArguments("disable-popup-blocking");
		chromeOptions.addArguments("incognito");
		chromeOptions.addArguments("disable-extensions");
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("lang=en-US");
		chromeOptions.addArguments("--user-data-dir=" +	System.getProperty("java.io.tmpdir"));

		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		chromeOptions.addArguments("--auto-open-devtools-for-tabs");

		driver = new ChromeDriver(chromeOptions);

		// Initialize the ChromeDriver with the options

		// System.out.println(" "+prop.getProperty("env"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://sirius-qa.excelindia.com");
		Thread.sleep(1000);

		//applyDevToolsSettings();

		CommonUtils.loadCookiesFromFile(driver, prop.getProperty("env"));
		Thread.sleep(2000);

	}

    public static void applyDevToolsSettings() {
        // Inject JavaScript to select Network tab and filter XHR
        String script = "let checkExist = setInterval(() => {" +
                        "    if (window.UI && UI.inspectorView) {" +
                        "        clearInterval(checkExist);" +
                        "        const networkPanel = UI.inspectorView.panel('network');" +
                        "        networkPanel._networkLogView._filterParser.parse('xhr');" +
                        "    }" +
                        "}, 100);";  // Check every 100ms

        // Execute the script
        ((JavascriptExecutor) driver).executeScript(script);
    }

	@AfterSuite
	public void tearDown() throws InterruptedException {
		System.out.println("Attempting Closing..");

		//
		if (driver != null) {
			try {
				driver.close();
				driver.quit();
				System.out.println("Driver Quitting...");
			} catch (NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
		} else {
			System.out.println("WebDriver instance is null.");
		}
	}
}
