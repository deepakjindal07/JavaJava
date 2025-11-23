package com.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.codesetup.Core;


public class TestUtil extends Core {

	// private static WebDriver contr0l;

	// public static long PAGE_LOAD_TIMEOUT = 30;
	// public static long IMPLICIT_WAIT = 30;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ ("src/main/java/com/gp/qa/TestUtil/iNumber.xlsx");

	// static XSSFWorkbook workbook;
	// static workbook workbook;
	static JavascriptExecutor js;

	// This method handles the excel - opens it and reads the data from the
	// respective cells using a for-loop & returns it in the form of a string array


    public static List<List<String>> getExcelData(String fileName, String sheetName) throws IOException {
        List<List<String>> data = new ArrayList<>();
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                for (Row row : sheet) {
                    List<String> rowData = new ArrayList<>();
                    for (Cell cell : row) {
                        rowData.add(cell.getStringCellValue());
                    }
                    data.add(rowData);
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return data;
    }


	// ----- Create folder to store Screenshot ----//
	public static String FolderCreation() {
		String timestamp = new SimpleDateFormat("yyyy MM dd   hh mm ss").format(new java.util.Date());
		File file = new File(System.getProperty("user.dir") + "/screenshots/" + timestamp);
		file.mkdir();
		String x1 = file.getAbsolutePath();
		return x1;
	}

	// ---Take Screenshot - pass 'SavePath' ------//
	public void takeScreenshot(WebDriver contr0l) throws IOException {
		File scrFile = ((TakesScreenshot) contr0l).getScreenshotAs(OutputType.FILE);
		// String currentDir = System.getProperty("user.dir");
		// FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +
		// System.currentTimeMillis() + ".png"));
		FileUtils.copyFile(scrFile, new File("/" + System.currentTimeMillis() + ".png"));

	}

	// ----------LoginIntoDashBoard----------//
//	public void LoginToDashBoard() throws InterruptedException {
//		contr0l.get(prop.getProperty("NewQA"));
//		Thread.sleep(5000);
//
//		Page_LoginToDashBoard Page_DashBoardElement;
//		Page_DashBoardElement = new Page_LoginToDashBoard(contr0l);
//
//		Page_DashBoardElement.ByuiLoginButtonTest();
//		Page_DashBoardElement.UserNameFieldTest(prop.getProperty("username"));
//		Page_DashBoardElement.PasswordFieldTest(prop.getProperty("pass"));
//		Page_DashBoardElement.CASLoginButtonTest();
//	}

	// ---------Get Console Logs---------//
	public String BrowserLogs(WebDriver contr0l) {
		LogEntries entry = contr0l.manage().logs().get(LogType.BROWSER);
		List<LogEntry> Logs = entry.getAll();
		for (LogEntry Log : Logs) {

			System.out.println("On page:" + contr0l.getCurrentUrl());
			System.out.println("Logs: " + Log);
		}
		for (LogEntry Log : Logs) {
			System.out.println("Level is: " + Log.getLevel());
			System.out.println("Message is: " + Log.getMessage());
		}

		return Logs.toString();
	}

	// ---------GetScreenshot on Failed ---------//
	public String getScreenshotPath(String testCaseName, WebDriver control) {
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
	// ---------GetScreenshot on Failed2 ---------//
//    public void getScreenshotPath(ITestResult result) throws IOException {
//        if (ITestResult.FAILURE == result.getStatus()); {
//            //System.out.println("FailStatus "+ITestResult.FAILURE);
//            //System.out.println("ActualStatus "+result.getStatus());
//            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(contr0l);
//            ImageIO.write(screenshot.getImage(), "jpg", new File("c:\\tmp\\ElementScreenshot2.jpg"));
//        }
//    }

	public void closeDriver1(WebDriver contr0l) {
		if (contr0l != null) {
			contr0l.quit();
		}
	}

	// ---------ExtentReporter---------//
//    public static void reportingTool() {
//        extent = new ExtentReports();
//        spark = new ExtentSparkReporter("spark.html");
//        spark.config().setTheme(Theme.STANDARD);
//        spark.config().setDocumentTitle("Report");
//        extent.attachReporter(spark);
//    }

	// Get the GraphicsEnvironment
	// Get all available screen devices
	// java.awt.GraphicsEnvironment ge =
	// java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
	// java.awt.GraphicsDevice[] gd = ge.getScreenDevices();
	// Check if there are more than one screens available
	// if (gd.length > 1) {
	// Get the second screen and set the browser window position on it
	// contr0l.manage().window().setPosition(new
	// Point(gd[1].getDefaultConfiguration().getBounds().x,
	// gd[1].getDefaultConfiguration().getBounds().y));

//  WebElement element = CustomWait.waitForElement(driver, By.id("yourElementId"), 10);
//  //---------Get Console Logs---------//
//  public String BrowserLogs(WebDriver contr0l) {
//      LogEntries entry = contr0l.manage().logs().get(LogType.BROWSER);
//      List < LogEntry > Logs = entry.getAll();
//      for (LogEntry Log: Logs) {
//
//          System.out.println("On page:" + contr0l.getCurrentUrl());
//          System.out.println("Logs: " + Log);
//      }
//      for (LogEntry Log: Logs) {
//          System.out.println("Level is: " + Log.getLevel());
//          System.out.println("Message is: " + Log.getMessage());
//      }
//
//      return Logs.toString();
//  }

//  public String BrowserLogs(WebDriver control) {
//      LogEntries entry = control.manage().logs().get(LogType.BROWSER);
//      List<LogEntry> severeLogs = new ArrayList<LogEntry>();
//
//      for (LogEntry logEntry : entry) {
//          if (logEntry.getLevel().toString().equals("SEVERE")) {
//              severeLogs.add(logEntry);
//          }
//      }
//
//      for (LogEntry logEntry : severeLogs) {
//          System.out.println("On page: " + control.getCurrentUrl()+"/n/n");
//          System.out.println("Logs: " + logEntry);
//      }
//
//      return severeLogs.toString();
//  }

}
