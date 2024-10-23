package com.testutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GPutils {

	public static Properties prop;
	static JavascriptExecutor js;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ ("src/main/java/com/gp/qa/TestUtil/iNumber.xlsx");

	// This method handles the excel - opens it and reads the data from the
	// respective cells using a for-loop & returns it in the form of a string array

	public static Properties loadProperties() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ConfigValues");
		prop.load(ip);
		return prop;
	}

	public static String[][] getExcelData(String fileName, String sheetName) throws IOException {
		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fileName);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			int noOfCols = row.getLastCellNum();
			Cell cell;
			data = new String[noOfRows - 1][noOfCols];
			for (int i = 1; i < noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					row = sheet.getRow(i);
					cell = row.getCell(j);
					data[i - 1][j] = cell.getStringCellValue().toString();
				}
			}
			workbook.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("The exception is: " + e.getMessage());
		}
		return data;
	}

	// ----------- Create folder to store Screenshot ----//
	public static String FolderCreation() {
		String timestamp = new SimpleDateFormat("yyyy MM dd   hh mm ss").format(new java.util.Date());
		File file = new File(System.getProperty("user.dir") + "/screenshots/" + timestamp);
		file.mkdir();
		String x1 = file.getAbsolutePath();
		return x1;
	}

	// --------Take Screenshot - pass 'SavePath' ------//
	public void takeScreenshot(WebDriver contr0l) throws IOException {
		File scrFile = ((TakesScreenshot) contr0l).getScreenshotAs(OutputType.FILE);
		// String currentDir = System.getProperty("user.dir");
		// FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +
		// System.currentTimeMillis() + ".png"));
		FileUtils.copyFile(scrFile, new File("/" + System.currentTimeMillis() + ".png"));

	}

	// ----------Wait time initialization----------//
	public static WebElement waitForElement(WebDriver contr0l, By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(contr0l, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static WebElement waitForElement(WebDriver contr0l, WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(contr0l, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// ---------- Print severe level logs from browser ---------- //
	/*
	 * public static String BrowserLogs(WebDriver contr0l) { LogEntries entry =
	 * contr0l.manage().logs().get(LogType.BROWSER); List<LogEntry> severeLogs = new
	 * ArrayList<LogEntry>();
	 * 
	 * for (LogEntry logEntry : entry) { if
	 * (logEntry.getLevel().equals(Level.SEVERE)) { severeLogs.add(logEntry); } }
	 * 
	 * StringBuilder logMessageBuilder = new StringBuilder(); for (LogEntry logEntry
	 * : severeLogs) {
	 * logMessageBuilder.append("On page: ").append(contr0l.getCurrentUrl()).append(
	 * "\n\n");
	 * logMessageBuilder.append("Timestamp: ").append(logEntry.getTimestamp()).
	 * append("\n");
	 * logMessageBuilder.append("Level: ").append(logEntry.getLevel()).append("\n");
	 * logMessageBuilder.append("Message: ").append(logEntry.getMessage()).append(
	 * "\n\n"); }
	 * 
	 * // Print logs to console //System.out.println(logMessageBuilder.toString());
	 * 
	 * // Optionally, log the severe logs to a file try { FileWriter fileWriter =
	 * new FileWriter("severe_logs.txt");
	 * fileWriter.write(logMessageBuilder.toString()); fileWriter.close(); } catch
	 * (IOException e) { System.err.println("Error writing to file: " +
	 * e.getMessage()); } return severeLogs.toString(); }
	 */

	// ---------GetScreenshot on Failed ---------//
	public static String getScreenshotPath(String testCaseName, WebDriver control) {
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

	public static void saveCookiesToFile(Set<Cookie> cookies) throws IOException {
		File file = new File("cookies.txt");
		FileWriter fileWriter = new FileWriter(file);

		for (Cookie cookie : cookies) {
			fileWriter.write(cookie.toString() + "\n");
		}

		fileWriter.close();
	}

	public static void loadCookiesFromFile(WebDriver driver) throws IOException {
		File file = new File("cookies.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line;

		while ((line = bufferedReader.readLine()) != null) {
			String[] cookieParts = line.split(";");

			String name = null;
			String value = null;
			String domain = null;
			String path = null;
			boolean isSecure = false;
			String sameSite = "";

			for (String part : cookieParts) {
				String[] keyValue = part.split("=", 2);
				if (keyValue.length == 2) {
					String key = keyValue[0].trim();
					String val = keyValue[1].trim();

					if (key.equalsIgnoreCase("_ei")) {
						name = key;
						value = val;
					} else if (key.equalsIgnoreCase("domain")) {
						domain = val;
					} else if (key.equalsIgnoreCase("path")) {
						path = val;
					} else if (key.equalsIgnoreCase("secure")) {
						isSecure = true;
					} else if (key.equalsIgnoreCase("sameSite")) {
						sameSite = val;
					}
				}
			}

			if (name != null && value != null && domain != null && path != null) {
				Cookie cookie = new Cookie.Builder(name, value).domain(domain).path(path).isSecure(isSecure)
						.sameSite(sameSite).build();

				driver.manage().addCookie(cookie);
			}
		}

		bufferedReader.close();

		// Refresh the page after adding all cookies
		driver.navigate().refresh();
	}
}
