package com.studentside;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codesetup.CommonUtils;
import com.codesetup.Core;
import com.elements.GradPlanMethods;
import com.elements.OpenSP;

public class GetSPURLset extends Core {

    private GradPlanMethods gradPlanMethods;

    @BeforeTest
    public void setupTest() throws Exception {
        gradPlanMethods = new GradPlanMethods();
    }

    @DataProvider(name = "excel-data")
    public Object[][] excelDataProvider() throws IOException {
        List<List<String>> dataFromExcel = CommonUtils.excelDataProvider("Inumber");
        Object[][] data = new Object[dataFromExcel.size()][1];
        for (int i = 0; i < dataFromExcel.size(); i++) {
            List<String> row = dataFromExcel.get(i);
            data[i][0] = new ArrayList<>(row);
        }
        return data;
    }

    @Test(priority = 1, enabled = true, dataProvider = "excel-data", invocationCount = 4, groups = { "Student" })
    public void createURL(ArrayList<String> inumbers) throws InterruptedException, IOException {
        String originalHandle = contr0l.getWindowHandle();
        Set<String> uniqueInumbers = new LinkedHashSet<>(inumbers);
        for (String inumber : uniqueInumbers) {
            if (inumber != null && !inumber.isEmpty()) {
                gradPlanMethods.Impersonate(contr0l, inumber);
                String originalURL = contr0l.getCurrentUrl();
                String modifiedURL = OpenSP.appendSectionPlannerUrl(originalURL);
                System.out.println(inumber + " " + modifiedURL);
                GradPlanMethods.closeAllWindowsExceptOriginal(contr0l, originalHandle);
                CommonUtils.saveResultToFile("report/SectionPlannerURL"+prop.getProperty("env")+".txt", inumber + " " + modifiedURL);
            }
        }
    }

    @Test(priority = 2, enabled = false)
    public void additional() throws InterruptedException {
        // Additional test logic goes here
    }
}
