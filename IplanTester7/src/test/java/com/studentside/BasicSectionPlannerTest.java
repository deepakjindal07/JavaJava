/*
 * @author Deepak Jindal
 *
 */
package com.studentside;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestUtil.TestUtil;
import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;
import com.elements.OpenSP;
import com.elements.Page_LoginToDashboard;

public class BasicSectionPlannerTest extends Core {
	GradPlanMethods openDecPlan;
	TestUtil testUtil;
	Page_LoginToDashboard dashBoardElement;

	@BeforeTest
	public void TestSetup() throws Exception {
		dashBoardElement = new Page_LoginToDashboard(contr0l);
		openDecPlan = new GradPlanMethods(); // Create an instance of OpenDecPlan

	}

	@Test(priority = 1, enabled = true)
	public void SectionPlanner() throws InterruptedException {
		System.out.println("=================Running Basic SP tests=================");

		String Inumber = prop.getProperty("D3");
		contr0l.get(baseUrl + prop.getProperty("StudentDashBoard"));
		Thread.sleep(2000);
		contr0l.navigate().refresh();

		// String SPurl = prop.getProperty("ClassSchedule");
		// System.out.println("Modified URL: " + modifiedURL);
		// contr0l.get(link + SPurl);

		try {
			openDecPlan.Impersonate(contr0l, Inumber);

			// Access section planner by URL manipulation.
			String originalURL = contr0l.getCurrentUrl();
			String modifiedURL = OpenSP.appendSectionPlannerUrl(originalURL);
			System.out.println(Inumber + " " + modifiedURL);
			contr0l.get(modifiedURL);
			Thread.sleep(2000);
			//DevToolsChecker.CallStatusCheck(contr0l);
			contr0l.navigate().refresh();

			// OpenSP.CheckDecPlanNameandRefresh(contr0l, Inumber);
			// OpenSP.CheckPrevSemester(contr0l);

			OpenSP.OpenSemester(contr0l, Inumber);
			// OpenSP.CheckRegisterButton(contr0l);
			// OpenSP.CheckPersonalEvent(contr0l);
			// OpenSP.CheckCalendarView(contr0l);
			OpenSP.AddCourseToList(contr0l);

			System.out.println("SP check done");

		} catch (Exception e) {
			handleException(Inumber, e);
			CommonUtils.saveResultToFile("report/NotWorkingSP" + (prop.getProperty("env")) + ".txt", Inumber);
		} finally {
			// OpenDecPlan.closeAllWindowsExceptOriginal(contr0l, originalHandle);
		}
	}

	private void handleException(String Inumber, Exception e) {
		System.out.println("Error processing Inumber " + Inumber + ": " + e.getMessage());
		String notWorkingInumber = Inumber + "\n\n is not working: " + e.getMessage();
		CommonUtils.saveResultToFile("report/NotWorking" + prop.getProperty("env") + ".txt", notWorkingInumber);
	}
}
