package com.extras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestUtil.TestUtil;
import com.codesetup.Core;
import com.elements.Page_LoginToDashboard;

public class ImpersonateFromExcel extends Core {
	TestUtil testUtil;
	Page_LoginToDashboard dashBoardElement;

	public void CodeSetup(String env) throws Exception {
		testUtil = new TestUtil();
		dashBoardElement = new Page_LoginToDashboard(contr0l);
	}

	private List<List<String>> remainingValues = null;

	@DataProvider(name = "excel-data")
	public Object[][] excelDataProvider() throws IOException {
		String filePath = System.getProperty("user.dir") + "/src/main/java/com/TestUtil/iNumbers.xlsx";
		if (remainingValues == null || remainingValues.isEmpty()) {
			remainingValues = TestUtil.getExcelData(filePath, "Sheet1");
		}
		Object[][] testData = new Object[remainingValues.size()][1];
		for (int i = 0; i < remainingValues.size(); i++) {
			testData[i][0] = remainingValues.get(i);
		}
		return testData;
	}

//    @DataProvider(name = "beta-data")
//    public Object[][] excelDataProviderBeta() throws IOException {
//        String filePath = System.getProperty("user.dir") + "/src/main/java/com/TestUtil/Beta.xlsx";
//        if (remainingValues == null || remainingValues.isEmpty()) {
//            remainingValues = TestUtil.getExcelData(filePath, "Sheet1");
//        }
//        // Create a copy of remainingValues to avoid concurrent modification
//        List<String> testDataCopy = new ArrayList<>(remainingValues);
//        Object[][] testData = new Object[testDataCopy.size()][1];
//        for (int i = 0; i < testDataCopy.size(); i++) {
//            testData[i][0] = testDataCopy.get(i);
//        }
//        return testData;
//    }

	@Test(priority = 1, dataProvider = "excel-data", enabled = true)
	public void CheckAdminImpersonationDeclaredPlans(String Inumber) throws Exception {

		System.out.println(Inumber);

		ArrayList<String> tabs2 = new ArrayList<>(contr0l.getWindowHandles());
		Thread.sleep(500);
		contr0l.switchTo().window(tabs2.get(1));
	}
}
