/*
 * @author Deepak Jindal
 *
 */
package OldCodeRemoveThese.StudentsPhotos;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestUtil.TestUtil;
import com.codesetup.Core;
import com.elements.Page_LoginToDashboard;

public class ImpersonateDayStudent extends Core {

	TestUtil testUtil;
	Page_LoginToDashboard dashBoardElement;

	@BeforeTest
	public void CodeSetup(String env) throws Exception {

		testUtil = new TestUtil();
		dashBoardElement = new Page_LoginToDashboard(contr0l);
	}

	@Test(priority = 1, enabled = true)
	public void ImpersonationTest() throws InterruptedException {

//		DashBoardElement.Menu1Test();	Thread.sleep(5000);
//		DashBoardElement.GPTileTest();
//	    ArrayList<String> tabs2 = new ArrayList<String>(contr0l.getWindowHandles()); Thread.sleep(2000);
//	    contr0l.switchTo().window(tabs2.get(1));      // selenium flow will work on tab 2
//

	}

	@Test(priority = 23, enabled = false) // , dependsOnMethods = {"ImpersonationTest", "MyPlanLandingPage"})
	public void ImpersonationTest3() {
//		dashBoardElement.isGreenViewPlanButtonDisplayed();
//		String com= StudentsideDeclaredplan.GetCompletedTest();
//		String IP= StudentsideDeclaredplan.GetInProgressTest();
//		String Plan= StudentsideDeclaredplan.GetPlannedTest();
//		String UnPlan= StudentsideDeclaredplan.GetUnPlannedTest();
//		String Total= StudentsideDeclaredplan.GetTotalTest();

//		System.out.println("Completed Credits : "+com);
//		System.out.println(IP);
//		System.out.println(Plan);
//		System.out.println("UnPlanned Credits : "+UnPlan);
//		System.out.println("Total Credits : "+Total);
	}

	@AfterTest
	public void closeDriver() // (WebDriver contr0l)
	{
		if (contr0l != null) {
			contr0l.quit();
		}
	}
}
