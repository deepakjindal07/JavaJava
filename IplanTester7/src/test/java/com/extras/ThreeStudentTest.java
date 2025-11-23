
package com.extras;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;

public class ThreeStudentTest extends Core {

	public CommonUtils gradPlanUtils;
	public GradPlanMethods openDecPlan;
	public Object[][] testData;


	@BeforeTest
	public void CodeSetup() throws Exception {

		openDecPlan = new GradPlanMethods();

	}

	/// -------------------////
	@DataProvider(name = "InumberCollection")
	public Object[][] getCRMTestData() {
		// Object data[][] = TestUtil.getTestData(sheetName);
		// return data;
		return new Object[][] { { "916827180" }, { "620418166" }, { "505876377" } };
	}

	@Test(priority = 1, dataProvider = "InumberCollection")
	public void SearchInumber(String Inumber) throws InterruptedException {

		System.out.println(Inumber);

	}

	@Override
	@AfterTest
	public void tearDown() {
		contr0l.quit();
	}

}
