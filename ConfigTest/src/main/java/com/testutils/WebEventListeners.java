package com.testutils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Base;

public class WebEventListeners extends Base implements ITestListener {

	private ExtentReports extent = ExtentReporterNG2.extentReportGenerator();
	private ExtentTest test;
	private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

	GPutils GPuitils = new GPutils();

	public WebEventListeners() throws IOException {
		super();
		//extent = ExtentReporterNG2.extentReportGenerator();
	}

	public static ExtentTest getExtentTest() {
		return testThreadLocal.get();
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName()).assignCategory(result.getMethod().getGroups());
		testThreadLocal.set(test);
	}

	public void onTestSuccess(ITestResult result) {

		// Get the log messages from the Reporter and include them in the Extent Report
		/*
		 * List<String> reporterLogs = Reporter.getOutput(result); if
		 * (!reporterLogs.isEmpty()) { StringBuilder logMessage = new StringBuilder();
		 * for (String log : reporterLogs) { logMessage.append(log).append("\n"); }
		 * test.log(Status.INFO, logMessage.toString()); }
		 * 
		 * 
		 * String logs = GPutils.BrowserLogs(contr0l); if (logs != null) {
		 * test.log(Status.INFO, "ConsoleLogs" + logs);
		 */
		// }
		test.log(Status.PASS, "Successful");
		System.out.println("Success of test cases and its details are: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		/*
		 * test.log(Status.INFO, GPutils.BrowserLogs(contr0l));
		 * test.fail(result.getThrowable());
		 * 
		 * String methodName = result.getMethod().getMethodName(); String screenshotPath
		 * = GPutils.getScreenshotPath(methodName, contr0l);
		 * 
		 * Object testObject = result.getInstance(); Class<?> clazz =
		 * result.getTestClass().getRealClass(); try { contr0l = (WebDriver)
		 * clazz.getDeclaredField("contr0l").get(testObject); } catch (Exception e1) {
		 * 
		 * } test.addScreenCaptureFromPath(screenshotPath);
		 */

		test.log(Status.FAIL, "TEST FAILED");
		System.out.println("Failed Test : " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Skip of test cases and its details are : " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Implement if needed
	}

	public void onStart(ITestContext context) {
		// Implement if needed
	}

	public void onFinish(ITestContext context) {
		System.out.println("Suite execution complete");
		extent.flush();
	}
}
