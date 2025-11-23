package com.TestUtil;

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
import com.codesetup.CommonUtils;
import com.codesetup.Core;

public class WebEventListeners extends Core implements ITestListener {

    private ExtentReports extent = ExtentReporterNG2.extentReportGenerator();
    private ExtentTest test;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    CommonUtils GPuitils = new CommonUtils();

    public WebEventListeners() throws IOException {
        super();
    }

    @Override
	public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName())
        .assignCategory(result.getMethod().getGroups());
        extentTest.set(test);
    }

    @Override
	public void onTestSuccess(ITestResult result) {

        // Get the log messages from the Reporter and include them in the Extent Report
        List<String> reporterLogs = Reporter.getOutput(result);
        if (!reporterLogs.isEmpty()) {
            StringBuilder logMessage = new StringBuilder();
            //logMessage.append("\n");
            for (String log : reporterLogs) {
                logMessage.append(log).append("\n");
            }
            test.log(Status.INFO, logMessage.toString());
        }


        String logs = CommonUtils.BrowserLogs(contr0l);
        		//BrowserLogs(contr0l);
        if (logs != null) {
            test.log(Status.INFO, "ConsoleLogs" + logs);
            //System.out.println("\n");
        }
        test.log(Status.PASS, "Successful");
        System.out.println("Success of test cases and its details are: " + result.getName());


    }

    @Override
	public void onTestFailure(ITestResult result) {
        test.log(Status.INFO, CommonUtils.BrowserLogs(contr0l));
        extentTest.get().fail(result.getThrowable());

        String methodName = result.getMethod().getMethodName();
        String screenshotPath = CommonUtils.getScreenshotPath(methodName, contr0l);

        //WebDriver contr0l = null; // Move this declaration here if needed
        Object testObject = result.getInstance();
        Class<?> clazz = result.getTestClass().getRealClass();
        try {
            contr0l = (WebDriver) clazz.getDeclaredField("contr0l").get(testObject);
        } catch (Exception e1) {

        }
        extentTest.get().addScreenCaptureFromPath(screenshotPath);

        test.log(Status.FAIL, "TEST FAILED");
        System.out.println("Failed Test : " + result.getName());

    }

//    public void onTestSkipped(ITestResult result) {
//        System.out.println("Skip of test cases and its details are : " + result.getName());
//     }
//
//     public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        //System.out.println("Failure of test cases and its details are : "+result.getName());
//     }

     @Override
	public void onStart(ITestContext context) {
        //System.out.println("Failure of test cases and its details are : "+context.getFailedTests());
     }

     @Override
	public void onFinish(ITestContext context) {
    	//Softfail.assertAll();
    	System.out.println("Suite execution complete");
        //extent.flush();
    	//contr0l.quit();
     }

}
