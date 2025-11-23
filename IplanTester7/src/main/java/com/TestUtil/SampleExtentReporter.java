package com.TestUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleExtentReporter {

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");

	WebDriver contr0l;

	@BeforeTest
	public void Launch() {
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Report");
		extent.attachReporter(spark);

		WebDriverManager.chromedriver().setup();
		contr0l = new ChromeDriver();
		contr0l.get("https://www.google.com");

	}

	@AfterTest
	public void TearDown() {
		extent.flush();
		contr0l.quit();
	}

	@Test
	public void TestCase() {
		ExtentTest test = extent.createTest("Verify the title")
				.assignAuthor("DeepakJindal")
				.assignCategory("Functional Test case")
				.assignDevice("Windows");
		test.info("I am testing Title of webpage");

		String pagetitle = contr0l.getTitle();
		if(pagetitle.equals("google")) {
			System.out.println("Title Is "+pagetitle);
		} else {
			System.out.println("Title is"+pagetitle);
		}
	}

	@Test
	public void TestCase2() {
		ExtentTest test = extent.createTest("Verify the Incorrect title");
		test.info("I am testing Title of webpage");

		String pagetitle = contr0l.getTitle();
		if(pagetitle.equals("CornHub")) {
			System.out.println("Title Is "+pagetitle);
		} else {
			System.out.println("Title is"+pagetitle);
		}
	}



}
