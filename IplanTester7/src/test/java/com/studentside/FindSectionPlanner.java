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

import com.TestUtil.TestUtil;
import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;
import com.elements.OpenSP;
import com.elements.Page_ClassSchedule;
import com.elements.Page_LoginToDashboard;

public class FindSectionPlanner extends Core {
	public CommonUtils gradPlanUtils;
	public TestUtil testUtil;
	public Page_ClassSchedule classSchedule; // empty
	public Page_LoginToDashboard dashBoardElement;
	public GradPlanMethods openDecPlan;
	public OpenSP openSP;
	public Object[][] testData;

	@BeforeTest
	public void TestSetup() throws Exception {
		openDecPlan = new GradPlanMethods(); // Create an instance of OpenDecPlan
		openSP = new OpenSP();
		gradPlanUtils = new CommonUtils();

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

	@Test(priority = 1, enabled = true, dataProvider = "beta-data", groups = { "Student" })
	public void GetWorkingSectionPlanner(String Inumber) throws InterruptedException, IOException {

		String originalHandle = contr0l.getWindowHandle();
		//Set<String> uniqueStudentNumbers = new LinkedHashSet<>(Inumbers);

		//for (String studentNumber : uniqueStudentNumbers) {
			if (Inumber != null && !Inumber.isEmpty()) {
				System.out.println("\nChecking student number " + Inumber);
				try {
					openDecPlan.Impersonate(contr0l, Inumber);
					OpenSP.OpenSPModuleTile(contr0l, Inumber);
					//contr0l.get(OpenSP.appendSectionPlannerUrl(contr0l.getCurrentUrl()));
					OpenSP.OpenSemester(contr0l, Inumber);
					OpenSP.CheckRegisterButton(contr0l);
					//TODO check further tests.

				} catch (Exception e) {
					 handleException(Inumber, e);
				} finally {
					GradPlanMethods.closeAllWindowsExceptOriginal(contr0l, originalHandle);
				}
			}
		}
//	}

	private void handleException(String Inumber, Exception e) {
		System.out.println("Error  Inumber " + Inumber + ": " + e.getMessage());
		e.printStackTrace();
	}

	@Test(priority = 2, enabled = false)
	public void Additional() throws InterruptedException {

	}
}