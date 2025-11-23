package com.advisorside;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_EmailTemplates;

public class EmailTemplate extends Core {
	Page_EmailTemplates mailTemplate;

	@BeforeTest
	public void TestSetup() throws Exception {
		mailTemplate = new Page_EmailTemplates(contr0l);

	}

	@Test(priority = 1, enabled = true, groups = { "Admin" })
	public void EmailTemp1() throws InterruptedException {
		contr0l.get(baseUrl + prop.getProperty("EmailTemplates"));

		WebElement EmailTemp1 = contr0l.findElement(By.xpath(
		    "//body[1]/app-root[1]/div[2]/div[1]/app-email-template[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[4]/span[1]"));
		EmailTemp1.click();
		Thread.sleep(triggerwait);

	}

	@Test(priority = 2, enabled = false)
	public void Additional() throws InterruptedException {
		// Assert.assertTrue(EmailTemplate.CheckHeadlines());

	}

}