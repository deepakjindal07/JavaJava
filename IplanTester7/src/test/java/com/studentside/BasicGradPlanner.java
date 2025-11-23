/*
88. * @author Deepak Jindal
 *
 */
package com.studentside;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TestUtil.TestUtil;
import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;

public class BasicGradPlanner extends Core {

	public TestUtil testUtil;
	public CommonUtils gradPlanUtils;
	public GradPlanMethods openDecPlan;
	public Object[][] testData;

	@BeforeTest
	public void TestSetup() throws Exception {
		openDecPlan = new GradPlanMethods(); // Create an instance of OpenDecPlan
		gradPlanUtils = new CommonUtils();
		softAssert = new SoftAssert();
	}

	@Test(priority = 1, enabled = true, groups = { "Student" })

	public void GraduationPlanner() throws Exception {

		System.out.println("=================Running Basic GP Tests=================");
		String Inumber = prop.getProperty("D3");

		contr0l.get(baseUrl + prop.getProperty("StudentDashBoard"));
		Thread.sleep(5000);
		contr0l.navigate().refresh();
		String originalHandle = contr0l.getWindowHandle();

		try {

			openDecPlan.Impersonate(contr0l, Inumber);


			openDecPlan.OpenGPModuleForStudent(contr0l, Inumber);
			String PersonationID = contr0l.getCurrentUrl();


			openDecPlan.OpenDeclaredPlan(contr0l, Inumber);
			Thread.sleep(triggerwait);


			openDecPlan.CheckPlanifWorking(contr0l, Inumber);
			contr0l.get(PersonationID);
			contr0l.navigate().refresh();
			Thread.sleep(5000);

			openDecPlan.GetPlanStatus(contr0l, Inumber);
			// Thread.sleep(triggerwait);
			contr0l.get(PersonationID);
			contr0l.navigate().refresh();

			openDecPlan.navigateToAllPlanHistories(contr0l);


			openDecPlan.CreateAltPlan(contr0l, Inumber);
			// Thread.sleep(triggerwait);

		} catch (Exception e) {
			//e.printStackTrace();
			 } finally {
			 GradPlanMethods.closeAllWindowsExceptOriginal(contr0l, originalHandle);
		}
	}

	@Test(priority = 2, enabled = false)
	public void Additional() throws InterruptedException {

	}
}