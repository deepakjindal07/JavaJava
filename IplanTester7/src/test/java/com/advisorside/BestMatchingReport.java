package com.advisorside;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.BestMatching;

public class BestMatchingReport extends Core{
	public BestMatching bestMatching;


	@BeforeTest
	public void TestSetup() throws Exception {
		bestMatching = new BestMatching(contr0l);
	}

	@Test(priority=1,enabled=true)
	public void BestMatchingReportTest1() throws InterruptedException{

	    contr0l.get(baseUrl+prop.getProperty("BestMatchingReport"));
	    Thread.sleep(2000);

		//boolean flag = Page_BestMatching.validateSearchBox();
		//Assert.assertTrue(flag);
	}

	@Test(priority=2,enabled=true)
	public void BestMatchingReportTest2() throws InterruptedException {
		bestMatching.EnterInumberInSearchBox("545046612");
		bestMatching.BachelorBoxClick();
		bestMatching.DeclaredBoxClick();
		bestMatching.emailbox();

		assertEquals(true, bestMatching.IsApplyFilterDisplayed());
		Thread.sleep(triggerwait);

		//bestMatching.ApplyFilterClick();
	}


}
