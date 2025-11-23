/*
 * @author Deepak Jindal
 *
 */
package com.studentside;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;

public class FindGradPlanner extends Core {

	public CommonUtils gradPlanUtils;
	public GradPlanMethods openDecPlan;
	public Object[][] testData;

	@BeforeTest
	public void TestSetup() throws Exception {
		openDecPlan = new GradPlanMethods();
		gradPlanUtils = new CommonUtils();
		prop = CommonUtils.loadProperties();
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

	@Test(priority = 1, enabled = true, dataProvider = "excel-data", invocationCount = 1, groups = { "Student" })

	public void GetWorkingInumbers(String Inumber) throws InterruptedException, IOException {

		//Thread.sleep(1000);
		//Set<String> uniqueInumbers = new LinkedHashSet<>(Inumbers);

		contr0l.get(baseUrl + prop.getProperty("StudentDashBoard"));
		Thread.sleep(5000);
		contr0l.navigate().refresh();
		String originalHandle = contr0l.getWindowHandle();

		//for (String Inumber : uniqueInumbers) {
			if (Inumber != null && !Inumber.isEmpty()) {
				System.out.println("\n" + "Checking Inumber " + Inumber); // TODO check later.
				// processedCount++;
				try {

					openDecPlan.Impersonate(contr0l, Inumber);


					openDecPlan.OpenGPModuleForStudent(contr0l, Inumber);


					openDecPlan.OpenDeclaredPlan(contr0l, Inumber);


					openDecPlan.GetPlanStatus(contr0l, Inumber);

				} catch (Exception e) {
					handleException(Inumber, e);
				} finally {
					GradPlanMethods.closeAllWindowsExceptOriginal(contr0l, originalHandle);
				}
			}
		}
	//}

	private void handleException(String Inumber, Exception e) {
		System.out.println("Error processing Inumber " + Inumber + ": " + e.getMessage());
	}
}