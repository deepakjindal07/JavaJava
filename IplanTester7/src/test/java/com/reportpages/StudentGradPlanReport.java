/*
 * @author Deepak Jindal
 *
 */
package com.reportpages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_StudentGradPlanReport;

public class StudentGradPlanReport extends Core {
	public Page_StudentGradPlanReport StudentGPR;

	@BeforeTest
	public void TestSetup() throws Exception {
		StudentGPR = new Page_StudentGradPlanReport(contr0l);

	}

	@Test(priority = 1, enabled = true)
	public void StudentGradPlanReport1() throws InterruptedException {
		contr0l.get(baseUrl + prop.getProperty("StudentGradPlanReport"));
		Thread.sleep(triggerwait);
		// Assert.assertTrue(StudentGPR.CheckHeadlines());
	}

	@Test(priority = 2, enabled = false)
	public void Additional() throws InterruptedException {
	}
}