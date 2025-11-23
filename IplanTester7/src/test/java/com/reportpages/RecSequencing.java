/*
 * @author Deepak Jindal
 *
 */
package com.reportpages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_RecSequencing;

public class RecSequencing extends Core {
	public Page_RecSequencing RecSequencing;

	@BeforeTest
	public void TestSetup() throws Exception {
		RecSequencing = new Page_RecSequencing(contr0l);

	}

	@Test(priority = 1, enabled = true)
	public void RecSequencing1() throws InterruptedException {
		contr0l.get(baseUrl + prop.getProperty("RecSequencing"));
		Thread.sleep(triggerwait);
	}

	@Test(priority = 2, enabled = false)
	public void RecSequencing2() throws InterruptedException {
	}
}