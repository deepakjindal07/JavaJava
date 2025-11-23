package supportprograms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TestUtil.TestUtil;
import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;
import com.elements.OpenSP;

public class CombinedTest extends Core {

	public TestUtil testUtil;
	public CommonUtils gradPlanUtils;
	public GradPlanMethods openDecPlan;
	public Object[][] testData;

	@BeforeTest
	public void TestSetup(ITestContext context) throws Exception {
		openDecPlan = new GradPlanMethods(); // Create an instance of OpenDecPlan
		gradPlanUtils = new CommonUtils();
		softAssert = new SoftAssert();

		// context.setAttribute("WebDriver", contr0l);
	}

	@DataProvider(name = "Text-data")
	public Object[][] dataProviderMethod() throws IOException {
		String filePath = "src/main/resources/numbers.txt";
		List<String> numbersList = readNumbersFromFile(filePath);
		Collections.shuffle(numbersList); // Shuffle the list to get a random order
		Object[][] data = new Object[numbersList.size()][1];
		for (int i = 0; i < numbersList.size(); i++) {
			data[i][0] = numbersList.get(i);
		}
		return data;
	}

	public List<String> readNumbersFromFile(String filePath) throws IOException {
		List<String> numbersList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				numbersList.add(line.trim());
			}
		}
		return numbersList;
	}

	@Test(priority = 1, invocationCount = 1, enabled = false, dataProvider = "Text-data", groups = { "Student" })

	public void openDeclaredPlan(String Inumber) throws Exception {

		contr0l.get(baseUrl + prop.getProperty("StudentDashBoard"));
		Thread.sleep(5000);
		contr0l.navigate().refresh();
		String originalHandle = contr0l.getWindowHandle();

		if (Inumber != null && !Inumber.isEmpty()) {
			try {
				// System.out.println("\nChecking Inumber " + Inumber);

				openDecPlan.Impersonate(contr0l, Inumber);

				openDecPlan.OpenGPModuleForStudent(contr0l, Inumber);
				String PersonationID = contr0l.getCurrentUrl();

				openDecPlan.OpenDeclaredPlan(contr0l, Inumber);
				// Thread.sleep(bigwait); //CheckErrobox, waits for 2 mins.

				openDecPlan.CheckPlanifWorking(contr0l, Inumber);

				// Open Myplan landing page.
				contr0l.get(PersonationID);
				contr0l.navigate().refresh();
				Thread.sleep(5000);

				openDecPlan.GetPlanStatus(contr0l, Inumber);

				openDecPlan.CreateAltPlan(contr0l, Inumber);

				contr0l.get(PersonationID);
				contr0l.navigate().refresh();
				Thread.sleep(5000);

				openDecPlan.navigateToAllPlanHistories(contr0l);

				//SectionPlanner(Inumber); ULR not working, let GP test complete first, then use SP testing.

				CommonUtils.saveResultToFile("report/WorkingGP" + prop.getProperty("env") + ".txt", Inumber);

			} catch (RuntimeException | InterruptedException e) {
				Assert.assertTrue(true, "Exception occured for this Inumber");
				System.out.println("Interrupted Exception:" + e);
				handleException(Inumber, e);
			}

			finally {
				GradPlanMethods.closeAllWindowsExceptOriginal(contr0l, originalHandle);
			}
		}
	}

	private void handleException(String Inumber, Exception e) {
		System.out.println("Error processing Inumber " + Inumber + ": " + e.getMessage());
		String notWorkingInumber = Inumber + " is not working: " + e.getMessage();
		CommonUtils.saveResultToFile("report/NotWorking" + prop.getProperty("env") + ".txt", notWorkingInumber);
		// Log error message using a logging framework
		// logger.error("Error " + operation + " for Inumber " + Inumber + ": " +
		// e.getMessage(), e);
	}

	// Set data provider of txt file, where working Inumbers are saved.

	@Test(priority = 2, invocationCount = 1, enabled = true, dataProvider = "Text-data", groups = { "Student" })

	public void SectionPlanner(String Inumber) throws InterruptedException {
		// String originalHandle = contr0l.getWindowHandle();
		// String Inumber = prop.getProperty("SP1");
		// String Inumber = "601501808";
		// System.out.println("\n[Info] Checking Section Planner for " + Inumber);

		contr0l.get(baseUrl + prop.getProperty("StudentDashBoard"));
		Thread.sleep(5000);
		contr0l.navigate().refresh();
		String originalHandle = contr0l.getWindowHandle();

		try {
			// ArrayList<String> tabs2 = new ArrayList<String>(contr0l.getWindowHandles());
			// contr0l.switchTo().window(tabs2.get(1));
			openDecPlan.Impersonate(contr0l, Inumber);
			String originalURL = contr0l.getCurrentUrl();
			//System.out.println("URL before modify " + contr0l.getCurrentUrl());
			String modifiedURL = OpenSP.appendSectionPlannerUrl(originalURL);
			System.out.println("[URL] " + modifiedURL);
			contr0l.get(modifiedURL);

			// print student name as well.
			WebElement studentName = contr0l.findElement(By.xpath("//span[@class='role']"));
			System.out.println("\n\n[Info] Checking Inumber: " + Inumber + " " + studentName.getText());


			OpenSP.CheckDecPlanNameandRefresh(contr0l, Inumber);
			Thread.sleep(triggerwait);

			OpenSP.CheckPrevSemester(contr0l);
			Thread.sleep(triggerwait);

			OpenSP.OpenSemester(contr0l, Inumber);
			Thread.sleep(triggerwait);

			OpenSP.CheckRegisterButton(contr0l);
			OpenSP.CheckPersonalEvent(contr0l);
			OpenSP.CheckCalendarView(contr0l);
			Thread.sleep(triggerwait);

			OpenSP.AddCourseToList(contr0l);
			Thread.sleep(triggerwait);

			System.out.println("[Complete] Inumber check for GP / SP done.");
			CommonUtils.saveResultToFile("report/WorkingSP" + prop.getProperty("env") + ".txt", Inumber);

		} catch (Exception e) {
			handleException(Inumber, e);
			// softAssert.assertTrue(true); //TODO debug
		} finally {
			GradPlanMethods.closeAllWindowsExceptOriginal(contr0l, originalHandle);
		}
	}

}
