/*
 * @author Deepak Jindal
 *
 */
package com.reportpages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_RecPlanReport;

public class RecPlansReport extends Core {
	public Page_RecPlanReport RecPlanReport;

	@BeforeTest
	public void TestSetup() throws Exception {
		RecPlanReport = new Page_RecPlanReport(contr0l);

	}

	@Test(priority = 1, enabled = true)
	public void RecPlanReport1() throws InterruptedException {
		contr0l.get(baseUrl + prop.getProperty("RecPlansReport"));
		Thread.sleep(triggerwait);
	}

	@Test(priority = 2, enabled = false)
	public void Additional() throws InterruptedException {
	}
}