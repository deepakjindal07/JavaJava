/*
 * @author Deepak Jindal
 *
 */
package com.reportpages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_SubAuditErrorReport;

public class SubAuditErrorReport extends Core {
	public Page_SubAuditErrorReport SubAuditReport;

	@BeforeTest
	public void TestSetup() throws Exception {
		SubAuditReport = new Page_SubAuditErrorReport(contr0l);
	}

	@Test(priority = 1, enabled = true)
	public void SubAuditErrorReport1() throws InterruptedException {

		contr0l.get(baseUrl + prop.getProperty("SubAuditErrorReport"));
		Thread.sleep(triggerwait);
	}

	@Test(priority = 2, enabled = false)
	public void SubAuditErrorReport2() throws InterruptedException {

	}

}