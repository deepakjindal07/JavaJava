/*
 * @author Deepak Jindal
 *
 */
package supportprograms;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TestUtil.TestUtil;
import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;
import com.elements.Page_LoginToDashboard;

public class DebugPractice extends Core {
	public TestUtil testUtil;
	public Page_LoginToDashboard dashBoardElement;
	public GradPlanMethods openDecPlan;
	public Object[][] testData;

	@BeforeTest
	public void TestSetup() throws Exception {
		CommonUtils.loadCookiesFromFile(contr0l,prop.getProperty("env"));
		contr0l.navigate().refresh();
//		XHRChecker.check(contr0l);
		Thread.sleep(1000);

		dashBoardElement = new Page_LoginToDashboard(contr0l);
		openDecPlan = new GradPlanMethods(); // Create an instance of OpenDecPlan
		softAssert = new SoftAssert();
	}

	@Test(priority = 1, enabled = true, groups = { "Student" })

	public void openDeclaredPlan() throws InterruptedException, IOException {
	    String originalHandle = contr0l.getWindowHandle();
	    String Inumber = prop.getProperty("D1");


	    try {

	        DebugImpersonate(contr0l, Inumber);
	        Thread.sleep(10000);
//	        openDecPlan.OpenGPModuleForStudent(contr0l, Inumber);
//	        openDecPlan.OpenDeclaredPlan(contr0l, Inumber);
//	        //Thread.sleep(triggerwait); added in method.
//	        openDecPlan.GetPlanStatus(contr0l, Inumber);


	    } catch (InterruptedException e) {
	        handleException("processing", Inumber, e);
	        throw new RuntimeException("Failed to open declared plan for Inumber " + Inumber, e);

	    } finally {
	        GradPlanMethods.closeAllWindowsExceptOriginal(contr0l, originalHandle);
	    }
	}

	private void handleException(String operation, String Inumber, Exception e) {
		System.out.println("Error processing Inumber " + Inumber + ": " + e.getMessage());
		String notWorkingInumber = Inumber + " is not working: " + e.getMessage();
		CommonUtils.saveResultToFile("report/NotWorking"+prop.getProperty("env")+".txt", notWorkingInumber);
	    // Log error message using a logging framework
	    // logger.error("Error " + operation + " for Inumber " + Inumber + ": " + e.getMessage(), e);
	}


	@Test(priority = 2, enabled = false)
	public void Additional() throws InterruptedException {

	}

	public void DebugImpersonate(WebDriver contr0l, String inumber) throws InterruptedException {
		WebElement SpecTool2 = contr0l.findElement(By.xpath("//img[@alt='Impersonate']"));
		SpecTool2.click();
		Thread.sleep(1000);
		System.out.println("GOing to click on Inumber search tool");

		WebElement CheckInum = contr0l.findElement(By.xpath("//input[@placeholder='Enter X-Number']"));
		CheckInum.clear();
		CheckInum.sendKeys(inumber);
		Thread.sleep(1000);
		CheckInum.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		// CheckInum.sendKeys(Keys.CONTROL +"\t");

//		String Tab1 = contr0l.getWindowHandle();
//		ArrayList<String> tabs2 = new ArrayList<String>(contr0l.getWindowHandles());
//		if (!tabs2.isEmpty()) {
//			contr0l.switchTo().window(tabs2.get(1));
//		}

		// TODO if new tab has been opened, switch otherwise don't and throw error.
		ArrayList<String> tabs2 = new ArrayList<>(contr0l.getWindowHandles());
		contr0l.switchTo().window(tabs2.get(1));

	}
}