package com.setup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.testutils.GPutils;

public class Base {
	
	public static WebDriver contr0l;
	public static WebDriverWait wait;
	public static Properties prop;
	public String baseUrl;
	private Connection connection;
	public static Statement statement;

//	protected Statement getStatement() {
//		return statement;
//	}

	@BeforeSuite
	public void DataBaseSetup() throws IOException, SQLException {
		String dbUrl = "jdbc:sqlserver://;serverName=10.12.2.80;databaseName=EPS_QA";
		String dbUser = "CS_Reader";
		String dbPassword = "R3ad3r";

		connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		statement = connection.createStatement();
		prop = GPutils.loadProperties();
		
	}

	/*
	 * public void DriverSetup() throws IOException, InterruptedException { contr0l
	 * = initialize(); GPutils.FirstLoginToDashBoard(contr0l);
	 * 
	 * @BeforeTest
	 * 
	 * @Parameters("env") public void commonSetup(String env) throws Exception {
	 * GPutils.setUpEnv(env); GPutils.LoginToDashBoard(contr0l); } }
	 */

	public static WebDriver initialize() throws InterruptedException, IOException {

		WebDriver contr0l = null;
		
		String browserName = prop.getProperty("browser");

		// String chromeProfilePath = prop.getProperty("ChromeCookies"); //Use cookies
		// ---------Select Browser initialize Driver as Contr0l---------//
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			// options.addArguments("--remote-allow-origins=*");
			// options.addArguments("chrome.switches", "--disable-extensions");
			// options.addArguments("user-data-dir=C:\\Users\\ExcelSoft\\AppData\\Local\\Google\\Chrome\\User
			// Data\\Default");
			// options.addArguments("--headless");
			// options.addArguments("--disable-gpu");
			// options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));

			// options.addArguments("--window-position=x,y"); //Dual monitor setup
			contr0l = new ChromeDriver(options);

		} else if (browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions eoption = new EdgeOptions();

			// options.addArguments("user-data-dir=/path/to/user/data/directory");

			// eoption.addArguments("--remote-allow-origins=*");

			// eoption.addArguments("user-data-dir=C:\\Users\\ExcelSoft\\AppData\\Local\\Microsoft\\Edge\\User
			// Data2");
			// eoption.addArguments("--user-data-dir=" +
			// System.getProperty("java.io.tmpdir"));
			// eoption.addArguments("--disable-extensions"); //Second monitor.
			// eoption.addArguments("--start-maximized"); // or --start-fullscreen
			// eoption.addArguments("prefs", "{\"enabled\": false}");
			// eoption.addArguments("prefs", "{\"browser\":{\"showSidebarInFullscreen\":
			// false}}");

			contr0l = new EdgeDriver(eoption);

		} else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			contr0l = new FirefoxDriver();

		} else if (browserName.equals("Safari")) {
			WebDriverManager.safaridriver().setup();
			contr0l = new SafariDriver();
		}

		wait = new WebDriverWait(contr0l, Duration.ofSeconds(60));
		return contr0l;
	}

	// ----------SetUpTestEnv----------//
	public void setUpEnv(@Optional("RC") String env) throws IOException {
		prop = GPutils.loadProperties();
		switch (env) {
		case "QA":
			baseUrl = prop.getProperty("QA"); // "https://gps-qa-sql.excelindia.com/";
			break;
		case "RC":
			baseUrl = prop.getProperty("RC"); // "http://byu-eps-rc.excelindia.com";
			break;
		case "STAGE":
			baseUrl = prop.getProperty("STAGE"); // "https://stage-eps.byui.edu";
			break;
		case "TEST":
			baseUrl = prop.getProperty("TEST"); // "https://stage-eps.byui.edu";
			break;
		case "BT":
			baseUrl = prop.getProperty("BT");
			break;
		default:
			throw new IllegalArgumentException("Invalid environment specified: " + env);
		}
		contr0l.get(baseUrl + prop.getProperty("OldLogin"));
	}

	@AfterSuite
	public void tearDown2() throws InterruptedException, SQLException {
		if (contr0l != null)
			try {
				contr0l.quit();
				System.out.println("Driver Quitting...");
			} catch (NullPointerException e) {
				System.out.println("NullPointerException thrown!");
			}
		// close SQL connection
		statement.close();
		connection.close();
	}
}
