package supportprograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestUtil.TestUtil;
import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;
import com.google.common.io.Files;

public class RefreshDAstory extends Core {

	public TestUtil testUtil;
	public CommonUtils gradPlanUtils;
	public GradPlanMethods openDecPlan;
	public Object[][] testData;

	@BeforeTest
	public void TestSetup(ITestContext context) throws Exception {
		//openDecPlan = new GradPlanMethods(); // Create an instance of OpenDecPlan
		//gradPlanUtils = new CommonUtils();
		//softAssert = new SoftAssert();

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
				
				File screenshot = ((TakesScreenshot) contr0l).getScreenshotAs(OutputType.FILE);
				Files.copy(screenshot, new File("screenshot.png"));
			}
		}
		return numbersList;
	}

	@Test(priority = 1, invocationCount = 1, enabled = false, dataProvider = "Text-data", groups = { "Student" })

	public void openDeclaredPlan(String Inumber) throws Exception {

		contr0l.get("https://sirius-qa.excelindia.com/tenantconfig/#/login");
		Thread.sleep(5000);
		contr0l.navigate().refresh();
		//String originalHandle = contr0l.getWindowHandle();

		// navigate to left navigation and access the page.

		if (Inumber != null && !Inumber.isEmpty()) {
			try {
				// System.out.println("\nChecking Inumber " + Inumber);

				openDecPlan.Impersonate(contr0l, Inumber);


				CommonUtils.saveResultToFile("report/RefreshDA" + prop.getProperty("env") + ".txt", Inumber);

			} catch (RuntimeException | InterruptedException e) {
				Assert.assertTrue(true, "Exception occured for this Inumber");
				System.out.println("Interrupted Exception:" + e);
				handleException(Inumber, e);
			}

			finally {
				//GradPlanMethods.closeAllWindowsExceptOriginal(contr0l, originalHandle);
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

}
