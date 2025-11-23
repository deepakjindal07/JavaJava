package supportprograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base_Backup {

    public static WebDriver contr0l;
    public static WebDriverWait wait;
    public static Properties prop;
    //public Assertion hardAssert = new Assertion();
    public String baseUrl;

    public static WebDriver initialize() throws InterruptedException, IOException
    {
    	prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
        prop.load(ip);

        WebDriver contr0l = null;

        //Softfail = new SoftAssert();

        String browserName = prop.getProperty("browser");
        //String chromeProfilePath = prop.getProperty("ChromeCookies"); //Use cookies

        //---------Select Browser initialize Driver as Contr0l---------//
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("start-maximized");
            //options.addArguments("--remote-allow-origins=*");
            //options.addArguments("chrome.switches", "--disable-extensions");
            //options.addArguments("user-data-dir=C:\\Users\\ExcelSoft\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
            //options.addArguments("--headless");
            //options.addArguments("--disable-gpu");
            //options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));

            options.addArguments("--window-position=x,y"); //Dual monitor setup
            contr0l = new ChromeDriver(options);

        } else if (browserName.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions eoption = new EdgeOptions();


            //eoption.addArguments("user-data-dir= C:\\Users\\ExcelSoft\\AppData\\Local\\Microsoft\\Edge\\User Data");
            //eoption.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir"));
            // eoption.addArguments("--window-position=1920,0"); //Second monitor.
            eoption.addArguments("--start-maximized"); // or --start-fullscreen
            //eoption.addArguments("prefs", "{\"enabled\": false}");
            //eoption.addArguments("prefs", "{\"browser\":{\"showSidebarInFullscreen\": false}}");


            contr0l = new EdgeDriver(eoption);

        } else if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            contr0l = new FirefoxDriver();

        } else if (browserName.equals("Safari")) {
            WebDriverManager.safaridriver().setup();
            contr0l = new SafariDriver();
        }

        wait = new WebDriverWait(contr0l,Duration.ofSeconds(60));
        //SoftAssert = new SoftAssert();
        return contr0l;
    }

    //----------setUpEnv----------//
    public  void setUpEnv(@Optional("QA") String env) {
        switch (env) {
            case "QA":
                baseUrl = prop.getProperty("QA"); // "https://gps-qa-sql.excelindia.com/";
                break;
            case "RC":
                baseUrl = prop.getProperty("RC"); //"http://byu-eps-rc.excelindia.com";
                break;
            case "STAGE":
                baseUrl = prop.getProperty("STAGE"); // "https://stage-eps.byui.edu";
                break;
            default:
                throw new IllegalArgumentException("Invalid environment specified: " + env);
        }
    }

//  //----------LoginIntoDashBoard----------//
//    public void LoginToDashBoard() throws InterruptedException {
//    	//System.out.println(baseUrl);
//    	contr0l.get(baseUrl+prop.getProperty("OldLogin"));
//
//        Page_LoginToDashboard page_DashBoardElement;
//        page_DashBoardElement = new Page_LoginToDashboard(contr0l);
//
//        Thread.sleep(1000);
//        page_DashBoardElement.ByuiLoginButtonTest(); // CAS
//        page_DashBoardElement.UserNameFieldTest(prop.getProperty("QAuser"));
//        page_DashBoardElement.PasswordFieldTest(prop.getProperty("QApass"));
//        page_DashBoardElement.CASLoginButtonTest();
//    }

    public static WebElement waitForElement(WebDriver contr0l, By locator, int timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(contr0l, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElement(WebDriver contr0l, WebElement element, int timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(contr0l, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ---------- Print severe level logs from browser ---------- //
    public String BrowserLogs(WebDriver contr0l)
    {
        LogEntries entry = contr0l.manage().logs().get(LogType.BROWSER);
        List<LogEntry> severeLogs = new ArrayList<>();

        for (LogEntry logEntry : entry) {
            if (logEntry.getLevel().equals(Level.SEVERE)) {
                severeLogs.add(logEntry);
            }
        }

        StringBuilder logMessageBuilder = new StringBuilder();
        for (LogEntry logEntry : severeLogs) {
            logMessageBuilder.append("On page: ").append(contr0l.getCurrentUrl()).append("\n\n");
            logMessageBuilder.append("Timestamp: ").append(logEntry.getTimestamp()).append("\n");
            logMessageBuilder.append("Level: ").append(logEntry.getLevel()).append("\n");
            logMessageBuilder.append("Message: ").append(logEntry.getMessage()).append("\n\n");
        }

        // Print logs to console
        //System.out.println(logMessageBuilder.toString());

        // Optionally, log the severe logs to a file
        try {
            FileWriter fileWriter = new FileWriter("severe_logs.txt");
            fileWriter.write(logMessageBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        return severeLogs.toString();
    }

    //---------GetScreenshot on Failed ---------//
    public String getScreenshotPath(String testCaseName, WebDriver control)
    {
        if (control instanceof TakesScreenshot) {
            TakesScreenshot ts = (TakesScreenshot) control;
            File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
            String destPath = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";

            try {
                FileUtils.copyFile(screenshotFile, new File(destPath));
                System.out.println("Screenshot captured: " + destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return destPath;
        } else {
            System.err.println("Driver does not support taking screenshots");
            return null;
        }
    }

@AfterSuite
	public void tearDown2() throws InterruptedException
{
    if (contr0l != null) {
		try {
            contr0l.quit();
            System.out.println("Driver Quitting...");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
	}
}
}