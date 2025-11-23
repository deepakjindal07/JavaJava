
package com.advisorside;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_ReviewGpElements;

public class ReviewStudentGradPlan extends Core {
	private Page_ReviewGpElements reviewGp;

	@BeforeClass
	public void TestSetup() throws Exception {
		reviewGp = new Page_ReviewGpElements(contr0l);
	}

	@Test(priority = 1, enabled = true)
	public void SearchSingleGradPlanforReview() throws InterruptedException, IOException {
		System.out.println("Running Review GradPlan test");
		contr0l.get(baseUrl + prop.getProperty("ReviewGradPlan"));
		contr0l.navigate().refresh();

		hold = new WebDriverWait(contr0l, Duration.ofSeconds(30));
		WebElement SearchBox = hold.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by Student Name or I-Number']")));
		SearchBox.sendKeys("775558206");
		SearchBox.sendKeys(Keys.ENTER);

		WebElement enter2 = hold
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='searchcontent']")));
		enter2.click();

		WebElement OpenPlan = hold.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//mat-icon[@role='img'][normalize-space()='karrow_forward_ios'])[4]")));
		OpenPlan.click();
		Thread.sleep(bigwait);
	}

	@Test(priority = 2, enabled = true)
	public void SearchListOfGradPlansforReview() throws InterruptedException, IOException {

		contr0l.get(baseUrl + prop.getProperty("ReviewGradPlan"));
		contr0l.navigate().refresh();

		Thread.sleep(1000);
		reviewGp.CollegeFilterTest();
		Thread.sleep(1000);
		reviewGp.DeptFilterTest();
		Thread.sleep(1000);
		reviewGp.MajorFilterTest();
		Thread.sleep(1000);
		reviewGp.ApplyFilterTest();
		Thread.sleep(1000);
		//Thread.sleep(triggerwait);

		hold = new WebDriverWait(contr0l, Duration.ofSeconds(60));
		WebElement result = hold.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//mat-icon[@role='img'][normalize-space()='karrow_forward_ios'])")));
		result.click();
		Thread.sleep(bigwait);

	}
}
