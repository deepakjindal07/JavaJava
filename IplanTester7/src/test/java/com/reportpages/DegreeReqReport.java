/*
 * @author Deepak Jindal
 *
 */
package com.reportpages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_DegreeReqReport;

public class DegreeReqReport extends Core {
	public Page_DegreeReqReport DegreeReqReport;

	@BeforeTest
	public void TestSetup() throws Exception {
		DegreeReqReport = new Page_DegreeReqReport(contr0l);
	}

	@Test(priority = 1, enabled = true)
	public void DegreeReqReport1() throws InterruptedException {
		contr0l.get(baseUrl + prop.getProperty("DegreeReqReport"));
		Thread.sleep(triggerwait);
	}

	@Test(priority = 2, enabled = false)
	public void Additionals() throws InterruptedException {
	}
}