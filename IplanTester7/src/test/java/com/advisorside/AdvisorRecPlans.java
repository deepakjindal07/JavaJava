
package com.advisorside;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_RecGradPlans;

public class AdvisorRecPlans extends Core {
	public Page_RecGradPlans recommendedplan;

	@BeforeTest
	public void TestSetup() throws Exception {
		recommendedplan = new Page_RecGradPlans(contr0l);
	}

	@Test(priority = 1, enabled = true, groups = { "Recommended grad plans page" })
	public void RecGradPlan1() throws InterruptedException {
		System.out.println("Running Recommended grad plans test");

		contr0l.get(baseUrl + prop.getProperty("RecGradPlans"));
		contr0l.navigate().refresh();
		Thread.sleep(triggerwait);

		recommendedplan.CollegeFilterTest();
		recommendedplan.ColSelect_Performing();

		recommendedplan.DeptFilterTest();
		recommendedplan.DeptSel_Art();

		recommendedplan.CatalogFilter();
		recommendedplan.CatalogFilterAll();

		recommendedplan.MajorFilter();
		recommendedplan.MajorSelect();

		// Open plan is any, from accordian / cog wheen / View plan.
		recommendedplan.SelectPlan();

		Thread.sleep(triggerwait);

		recommendedplan.CogWheelTest();
		Thread.sleep(5000);
		recommendedplan.ViewPlanTest();

		Thread.sleep(triggerwait);
	}

	@Test(priority = 2, enabled = false)
	public void RecGradPlan2() throws InterruptedException {

	}

}