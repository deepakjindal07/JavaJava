
package com.extras;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_LoginToDashboard;

public class UserDashBoard extends Core {
	Page_LoginToDashboard dashBoardElement;

	@BeforeClass
	public void TestSetup() throws Exception {
		dashBoardElement = new Page_LoginToDashboard(contr0l);

		// Open Dashboard page.
		contr0l.get(baseUrl + prop.getProperty("StudentDashBoard"));
		Thread.sleep(5000);
		contr0l.navigate().refresh();

	}

	@Test(priority = 1, enabled = true)
	public void DashBoardTest() throws InterruptedException, IOException {
		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Running DashboardTest");


	    //boolean isHomeDisplayed = dashBoardElement.isHomeDisplayed();

		//Assert.assertTrue(isHomeDisplayed, "Home element is not displayed");
		//Assert.assertTrue(dashBoardElement.isGradPlannerDisplayed(), "Grad Planner element is not displayed");
		//Assert.assertTrue(dashBoardElement.isSectionPlannerDisplayed(), "Section Planner element is not displayed");
		Assert.assertTrue(dashBoardElement.isFooterDisplayed(), "Footer element is not displayed");
		Assert.assertTrue(dashBoardElement.isHelpDisplayed(), "Help element is not displayed");
		Assert.assertTrue(dashBoardElement.isImpersonateToolDisplayed(), "Impersonate Tool element is not displayed");
		Assert.assertTrue(dashBoardElement.isLogoDisplayed(), "Logo element is not displayed");
		Assert.assertTrue(dashBoardElement.isTileMenuDisplayed(), "Tile Menu element is not displayed");
		Assert.assertTrue(dashBoardElement.isHomeBindingDisplayed(), "Home Binding element is not displayed");

	}

	@Test(priority = 2, enabled = true)
	public void MenuTest() throws InterruptedException, IOException {
		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Running MenuTest");
		dashBoardElement.OpenMenu();
		//dashBoardElement.isHomeDisplayed();
		//dashBoardElement.isGradPlannerDisplayed2();
		//dashBoardElement.isSectionPlannerDisplayed2();

	}
}
