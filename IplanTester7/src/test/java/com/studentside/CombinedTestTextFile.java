package com.studentside;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TestUtil.TestUtil;
import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;
import com.elements.OpenSP;

public class CombinedTestTextFile extends Core {

	public TestUtil testUtil;
	public CommonUtils gradPlanUtils;
	public GradPlanMethods openDecPlan;
	public Object[][] testData;

	@BeforeTest
	public void TestSetup() throws Exception {
		openDecPlan = new GradPlanMethods(); // Create an instance of OpenDecPlan
		gradPlanUtils = new CommonUtils();
		softAssert = new SoftAssert();
	}

	@DataProvider(name = "Text-data")
	public Object[][] dataProviderMethod() throws IOException {

		// print selected env.
		// select file acc to env.
		// If QA , select QA.txt

		String env = prop.getProperty("env");
		// System.out.println("Selected env: "+env);
		// String filePath = "src/main/resources/numbers.txt";

		String filePath;

		switch (env) {
		case "QA":
			filePath = "src/main/resources/QA.txt";
			break;
		case "RC":
			filePath = "src/main/resources/RC.txt";
			break;
		case "STAGE":
			filePath = "src/main/resources/STAGE.txt";
			break;
		case "TEST":
			filePath = "src/main/resources/TEST.txt";
			break;
		case "BT":
			filePath = "src/main/resources/BT.txt";
			break;
		case "SIRIUS":
			filePath = "src/main/resources/SIRIUS.txt";
			break;
		case "Core":
			filePath = "src/main/resources/CORE.txt";
			break;
		default:
			filePath = "src/main/resources/numbers.txt";
		}

		// return filePath;

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

	@Test(priority = 1, invocationCount = 1, enabled = true, dataProvider = "Text-data", groups = { "Student" })
	public void openDeclaredPlan(String Inumber) throws InterruptedException, IOException {
		System.out.println("Starting GradPlanner tests");

		contr0l.get(baseUrl + prop.getProperty("StudentDashBoard"));
		Thread.sleep(5000);
		contr0l.navigate().refresh();

		String originalHandle = contr0l.getWindowHandle();

		if (Inumber != null && !Inumber.isEmpty()) {
			try {
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

				System.out.println("GP Test complete");
				CommonUtils.saveResultToFile("report/GPWorking" + prop.getProperty("env") + ".txt", Inumber);
				ClassScheduleUrlManipulcation(Inumber);
				// Thread.sleep(triggerwait);
				// Show remaining Inumbers.

				// System.out.println("Remaining Inumbers: " + (totalNumbers - (i + 1)) + "/" +
				// totalNumbers);

			} catch (Exception e) {
				Reporter.log("XXXXXXXXXXX Section's Test Skipped. Main Interrupted Exception: XXXXXXXXXXX " + e);
				handleException(Inumber, e);
				// continue;
			} finally {
				GradPlanMethods.closeAllWindowsExceptOriginal(contr0l, originalHandle);
			}
		}
	}

	private void handleException(String Inumber, Exception e) {
		// System.out.println("Error processing Inumber " + Inumber + ": " +
		// e.getMessage());
		String notWorkingInumber = Inumber + " is not working: Reason: \n" + e.getMessage() + "\n\n";
		CommonUtils.saveResultToFile("report/NotWorking" + prop.getProperty("env") + ".txt", notWorkingInumber);
		// Log error message using a logging framework
		// logger.error("Error " + operation + " for Inumber " + Inumber + ": " +

	}

	@Test(priority = 2, enabled = false)
	public void ClassScheduleUrlManipulcation(String Inumber) throws InterruptedException {
		// String originalHandle = contr0l.getWindowHandle();
		// String Inumber = prop.getProperty("SP1");
		// String Inumber = "601501808";

		System.out.println("Checking Section Planner for " + Inumber);

		// String link = prop.getProperty("BT");
		// String SPurl = prop.getProperty("ClassSchedule");
		// System.out.println("Modified URL: " + modifiedURL);
		// contr0l.get(link + SPurl);

		try {
			// openDecPlan.Impersonate(contr0l, Inumber);

			// OpenSP.openClassScheduleTool(contr0l, Inumber);
			// It is available for Beta only, so We will manipulate URL to open SP.
			String originalURL = contr0l.getCurrentUrl();
			String modifiedURL = OpenSP.appendSectionPlannerUrl(originalURL);
			System.out.println(Inumber + " " + modifiedURL);
			contr0l.get(modifiedURL);

			// OpenSP.CheckDecPlanNameandRefresh(contr0l, Inumber);
			OpenSP.CheckPrevSemester(contr0l);

			OpenSP.OpenSemester(contr0l, Inumber);
			Thread.sleep(bigwait);
			OpenSP.CheckRegisterButton(contr0l);
			OpenSP.CheckPersonalEvent(contr0l);
			OpenSP.CheckCalendarView(contr0l);

			OpenSP.AddCourseToList(contr0l);

			System.out.println("SP Test complete");
			CommonUtils.saveResultToFile("report/CombinedWorking" + prop.getProperty("env") + ".txt",
					Inumber + " " + modifiedURL);

		} catch (Exception e) {
			handleException(Inumber, e);
			// softAssert.assertTrue(true); //TODO debug
		}
	}
}
