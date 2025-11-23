package com.mobiletesting;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.CommonUtils;
import com.elements.GradPlanMethods;
import com.elements.mobileGPandSP;

import supportprograms.MobileCore;

public class GPMobileTesting extends MobileCore {

	public CommonUtils gradPlanUtils;
	//public GradPlanMethods openDecPlan;
	public mobileGPandSP mobileGPandSP;

	@BeforeTest
	public void MobileTestSetup() throws Exception {

		gradPlanUtils = new CommonUtils();
		//openDecPlan = new GradPlanMethods();
		mobileGPandSP = new mobileGPandSP();

		driver.get("https://sirius-qa.excelindia.com");
		Thread.sleep(1000);
		driver.navigate().refresh();

	}

	@Test(priority = 1, enabled = true, groups = { "Student" })

	public void MobileGraduationPlanner() throws Exception {

		System.out.println("=================Running Basic GP Tests=================");
		String Inumber = prop.getProperty("D3");

		// driver.get(baseUrl + prop.getProperty("StudentDashBoard"));
		// Thread.sleep(5000);
		// driver.navigate().refresh();
		String originalHandle = driver.getWindowHandle();

		try {

			mobileGPandSP.Impersonate(driver, Inumber);

			mobileGPandSP.OpenGPModuleForStudent(driver, Inumber);
			String PersonationID = driver.getCurrentUrl();

			mobileGPandSP.OpenDeclaredPlan(driver, Inumber);
//			Thread.sleep(triggerwait);
//
//			openDecPlan.CheckPlanifWorking(driver, Inumber);
//			driver.get(PersonationID);
//			driver.navigate().refresh();
//			Thread.sleep(5000);
//
//			openDecPlan.GetPlanStatus(driver, Inumber);
//			// Thread.sleep(triggerwait);
//			driver.get(PersonationID);
//			driver.navigate().refresh();
//
//			openDecPlan.navigateToAllPlanHistories(driver);
//
//			openDecPlan.CreateAltPlan(driver, Inumber);
//			// Thread.sleep(triggerwait);

		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			GradPlanMethods.closeAllWindowsExceptOriginal(driver, originalHandle);
		}
	}

	@Test(priority = 1, enabled = false, groups = { "Student" })

	public void MobileSectionPlanner() throws Exception {

		// Open a website
		driver.get("https://www.msn.com");
		Thread.sleep(10000);

		// Print the title of the page
		System.out.println("Title of the page is: " + driver.getTitle());

	}
}
