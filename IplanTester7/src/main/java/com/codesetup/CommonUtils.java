package com.codesetup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class CommonUtils {

	static Properties prop;
	// static JavascriptExecutor js;
	// public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") +
	// ("src/main/java/com/gp/qa/TestUtil/iNumber.xlsx");

	// This method handles the excel - opens it and reads the data from the
	// respective cells using a for-loop & returns it in the form of a string array

	public static Properties loadProperties() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/config.properties");
		prop.load(ip);
		return prop;
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
	public static void takeScreenshot(WebDriver control) throws IOException {
		// Convert WebDriver object to TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) control;

		// Capture screenshot as File
		File scrFile = ts.getScreenshotAs(OutputType.FILE);

		// Define the directory to save the screenshot
		String screenshotsDir = System.getProperty("user.dir") + "/screenshots/";

		// Create the directory if it doesn't exist
		File directory = new File(screenshotsDir);
		if (!directory.exists()) {
			directory.mkdirs(); // Create directories recursively
		}

		// Define the destination file path with formatted timestamp
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = screenshotsDir + timestamp + ".png";

		// Save the screenshot to the specified file path
		FileUtils.copyFile(scrFile, new File(filePath));

		// Print the path where the screenshot is saved
		System.out.println("Screenshot saved: " + filePath);
	}

	// ----------Wait time initialization----------//
//    public static WebElement waitForElement(WebDriver contr0l, By setLow, int timeoutInSeconds)
//    {
//        WebDriverWait wait = new WebDriverWait(contr0l, Duration.ofSeconds(timeoutInSeconds));
//        return wait.until(ExpectedConditions.invisibilityOfElementLocated(setLow));
//    }

	// ---------- Print severe level logs from browser ---------- //
	public static String BrowserLogs(WebDriver contr0l) {
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
		// System.out.println(logMessageBuilder.toString());

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

	public static void saveCookiesToFile(Set<Cookie> cookies, String string) throws IOException {
		File file = new File("cookies/"+string+".txt");
		FileWriter fileWriter = new FileWriter(file);

		for (Cookie cookie : cookies) {
			fileWriter.write(cookie.toString() + "\n");
		}

		fileWriter.close();
	}

	public static void loadCookiesFromFile(WebDriver contr0l, String baseUrl) throws IOException {

		File file;

		switch (baseUrl) {
		    case "QA":
		        file = new File("cookies/"+"cookiesQA.txt");
		        break;
		    case "SIRIUS":
		        file = new File("cookies/"+"cookiesSIRIUS.txt");
		        break;
		    case "RC":
		        file = new File("cookies/"+"cookiesRC.txt");
		        break;
		    case "BT":
		        file = new File("cookies/"+"cookiesBT.txt");
		        break;
		    case "TEST":
		        file = new File("cookies/"+"cookiesTEST.txt");
		        break;
		    case "STAGE":
		        file = new File("cookies/"+"cookiesSTAGE.txt");
		        break;
		    case "Core":
		        file = new File("cookies/"+"cookiesCore.txt");
		        System.out.println("Found");
		        break;
		    case "Prod":
		        file = new File("cookies/"+"cookiesProd.txt");
		        break;
		    default:
		        throw new IllegalArgumentException("Invalid environment: " + baseUrl);
		}


		//File file = new File("cookies.txt");
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


				contr0l.manage().addCookie(cookie);
				
				System.out.println("Cookie Loaded");
			}
		}

		bufferedReader.close();

		// Refresh the page after adding all cookies
		//contr0l.navigate().refresh();
	}

	String filename = "file.txt"; // Saved working Inumbers here
	/// ---- write result to file.

	public static void appendResultToFile(String filename, String newResult) {
		List<String> lines = readLinesFromFile(filename);

		// Append the new result
		lines.add(newResult);

		// Write the updated content back to the file
		writeLinesToFile(filename, lines);
	}

	private static List<String> readLinesFromFile(String filename) {
		List<String> lines = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		return lines;
	}

	private static void writeLinesToFile(String filename, List<String> lines) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			for (String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

	public static void saveResultToFile(String filename, String result) {
		try {
			if (result != null) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
				// Get current date and time
				LocalDateTime now = LocalDateTime.now();
				// Format the date and time
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String timestamp = now.format(formatter);
				// Write the timestamp and result to the file
				writer.write("Date:Time " + timestamp);
				writer.newLine();
				writer.write(result);
				writer.newLine();
				writer.close();
			}
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}

//    public static List<List<String>> excelDataProviderHelper() throws IOException {
//        // Provide the path to your Excel file
//        String excelFilePath = "src/main/java/com/TestUtil/Inumbers.xlsx";
//
//        // Create a FileInputStream to read the Excel file
//        FileInputStream inputStream = new FileInputStream(excelFilePath);
//
//        // Create a Workbook object for the Excel file
//        Workbook workbook = WorkbookFactory.create(inputStream);
//
//        // Get the first sheet from the workbook
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//
//        // Get the number of rows and columns in the sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
//
//        // Create a list to hold the data
//        List<List<String>> data = new ArrayList<>();
//
//        // Loop through each row and get the data from the columns
//        for (int i = 0; i < rowCount; i++) {
//            Row row = sheet.getRow(i);
//            List<String> rowData = new ArrayList<>();
//            for (int j = 0; j < columnCount; j++) {
//                Cell cell = row.getCell(j);
//                if (cell != null) {
//                    rowData.add(cell.getStringCellValue()); // Assuming data is string
//                } else {
//                    rowData.add(""); // If cell is empty, add an empty string
//                }
//            }
//            data.add(rowData);
//        }
//
//        // Close the workbook and input stream
//        workbook.close();
//        inputStream.close();
//
//        return data;
//    }

	public static List<List<String>> excelDataProvider(String fileName) throws IOException {
		// Construct the file path based on the fileName argument
		String excelFilePath = "src/main/resources/" + fileName + ".xlsx";

		// Create a FileInputStream to read the Excel file
		FileInputStream inputStream = new FileInputStream(excelFilePath);

		// Create a Workbook object for the Excel file
		Workbook workbook = WorkbookFactory.create(inputStream);

		// Get the first sheet from the workbook
		Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

		// Get the number of rows and columns in the sheet
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

		// Create a list to hold the data
		List<List<String>> data = new ArrayList<>();

		// Loop through each row and get the data from the columns
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			List<String> rowData = new ArrayList<>();
			for (int j = 0; j < columnCount; j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					rowData.add(cell.getStringCellValue()); // Assuming data is string
				} else {
					rowData.add(""); // If cell is empty, add an empty string
				}
			}
			data.add(rowData);
		}

		// Close the workbook and input stream
		workbook.close();
		inputStream.close();

		return data;
	}

	public static List<String> readNumbersFromFile() {
	    List<String> numbers = new ArrayList<>();
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/numbers.txt"));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            numbers.add(line.trim());
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return numbers;
	}

    public void applyDevToolsSettings() {
        // Inject JavaScript to select Network tab and filter XHR
        String script = "let checkExist = setInterval(() => {" +
                        "    if (window.UI && UI.inspectorView) {" +
                        "        clearInterval(checkExist);" +
                        "        const networkPanel = UI.inspectorView.panel('network');" +
                        "        networkPanel._networkLogView._filterParser.parse('xhr');" +
                        "    }" +
                        "}, 100);";  // Check every 100ms

        // Execute the script
       // ((JavascriptExecutor) contr0l).executeScript(script);
    }

    public static void clearCache(WebDriver driver) {
        if (driver instanceof JavascriptExecutor) {
        	System.out.println("JS cleaner");
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.localStorage.clear();");
            jsExecutor.executeScript("window.sessionStorage.clear();");
            jsExecutor.executeScript("window.location.reload();");
        } else {
            throw new UnsupportedOperationException("The driver does not support JavaScript execution.");
        }
    }

}
