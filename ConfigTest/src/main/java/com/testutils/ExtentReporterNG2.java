package com.testutils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG2 {

	static ExtentReports extent;

	public static ExtentReports extentReportGenerator() throws IOException {

//		String path = System.getProperty("user.dir")+"\\reports\\index.html";
//		
//		// Check if index.html exists, If it does, create index2.html
//		File indexFile = new File(path);
//		if (indexFile.exists()) {
//		    // Find the last index number in the filename
//		    int lastIndex = 1;
//		    while (new File(System.getProperty("user.dir") + "\\reports\\index" + lastIndex + ".html").exists()) {
//		        lastIndex++;
//		    }
//		    
//		    // Create a new file with an incremented index number
//		    path = System.getProperty("user.dir") + "\\reports\\index" + lastIndex + ".html";
//		}

		String dateStr = new Date().toString().replace(":", "_").replace(" ", "_");
		String reportFileName = "TestReport_" + dateStr + ".html";
		String reportFilePath = System.getProperty("user.dir") + File.separator + "reports" + File.separator
				+ reportFileName;

		System.out.println("Please check report at: " + reportFilePath);
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportFilePath);
		reporter.config().setReportName("GP Automation Result");
		reporter.config().setDocumentTitle("Automation Test Results");
		reporter.config().setCss(reportFilePath);

		reporter.loadXMLConfig("extent_config.xml");
		reporter.config().setEncoding("UTF-8");
		reporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Deepak Jindal");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser", "Edge");
		extent.setSystemInfo("Environment", "RC");

		return extent;
	}

}
