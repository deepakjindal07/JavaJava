package com.advisorside;


import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_AdminTools;

public class AdminToolsPage extends Core {
	public Page_AdminTools adminTools;

	@BeforeTest
	public void TestSetup() throws IOException, InterruptedException {
		adminTools = new Page_AdminTools(contr0l);
	}

	@Test(priority = 1, enabled = true, groups = { "Admin" }, description = "Test on admin side pages.")
	public void AdminTools() throws InterruptedException, IOException {

		System.out.println("Checking AdminTool page.");
		contr0l.get(baseUrl + prop.getProperty("AdminTools"));
		contr0l.navigate().refresh();
		Thread.sleep(triggerwait);

		// Assert admin tools page.
		//WebElement test = contr0l.findElement(By.xpath("//h2[normalize-space()='Excess Credit Threshold']"));
		//String CurrentText =test.getText();
		//String expectedText = "E@xcess Credit Threshold";
		//assertEquals(CurrentText,expectedText);

	}

	@Test(priority = 2, enabled = false)
	public void Additional() throws InterruptedException {

		System.out.println("Checking Additional tests..");

		//WebElement test = contr0l.findElement(By.xpath("//h2[normalize-space()='Excess Credit Threshold']"));
		//String CurrentText =test.getText();
		//String expectedText = "Excess Credit Threshold";
		//assertEquals(CurrentText,expectedText);

//		adminTools.SetLowThreshold();
//		adminTools.SetHighThreshold();
//		adminTools.ClickSaveButton();
//		//Assert.assertTrue(adminTools.ConfirmRibbonVerify(), "Ribbon is Not		 displayed.");
//		adminTools.FreezeOpen();
//		adminTools.OpenManagePref();
//		adminTools.CheckBox1();
//		adminTools.CloseConfBox();
//		adminTools.SaveButton();
//		adminTools.OpenSwitchMajorconfig();
//		adminTools.ClickAddNew();
//		adminTools.CloseDialog();
//		adminTools.OpenEmailTemplates();
	}

	@Test()
	public void test2(){

		//adminTools.OpenEmailTemplates();

	}

	@Test()
	public void test3(){

		//adminTools.OpenSwitchMajorconfig();

	}

}