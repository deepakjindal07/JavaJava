
package com.advisorside;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_CourseAvailability;

public class CourseAvailability extends Core {
	private Page_CourseAvailability courseAvailability;

	@BeforeTest
	public void TestSetup() throws Exception {

		courseAvailability = new Page_CourseAvailability(contr0l);

	}

	@Test(priority = 1, enabled = true, groups = { "Admin" })
	public void CourseAvailability1() throws InterruptedException {
		System.out.println("Running Course Availability");

		contr0l.get(baseUrl + prop.getProperty("CourseAvailability"));
		contr0l.navigate().refresh();
		Thread.sleep(2000);

		courseAvailability.enterCourse();
		courseAvailability.clickSearch();



		hold = new WebDriverWait(contr0l, Duration.ofSeconds(30));

		List<WebElement> CollegeFilter = hold.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
				(By.xpath("//div[@id='mat-select-value-1']//spann"
						+ "| (//span)[15] | //div[@id='mat-select-value-17']//span")));

		// Loop through the elements and click on the first visible element
		for (WebElement College1 : CollegeFilter) {
			if (College1.isDisplayed()) {
				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor) contr0l;
				js.executeScript("arguments[0].click();", College1);


			}

			// WebElement CollegeFilter = contr0l.findElement(By.cssSelector(" |
			// div[id='mat-select-value-17'] span"));
			// CollegeFilter.click();

			WebElement CollegeOptions = contr0l.findElement(
					By.xpath("//span[@class='mat-option-text'][normalize-space()='Performing & Visual Arts']"));
			CollegeOptions.click();

			// ------Department

			WebElement DeptFilter = contr0l.findElement(By.xpath("//div[@id='mat-select-value-3']"));
			DeptFilter.click();

			WebElement DeptOption = contr0l
					.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='Art']"));
			DeptOption.click();

			// ------CourseStatus

			WebElement CourseFilter = contr0l.findElement(By.xpath("//div[@id='mat-select-value-5']"));
			CourseFilter.click();

			WebElement CourseOption = contr0l
					.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='RECURRENCE']"));
			CourseOption.click();
			Thread.sleep(10000);

			//WebElement StudentsPlanned = contr0l.findElement(By.xpath("//div[contains(text(),'Students Planned')]"));
			//StudentsPlanned.click();
			//Thread.sleep(10000);


		}
	}

	@Test(priority = 2, enabled = false, groups = { "Admin" })
	public void Additional() throws InterruptedException {
		courseAvailability.enterCourse();
		courseAvailability.clickSearch();
		Thread.sleep(5000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("courseResult")));
		boolean flag = courseAvailability.result();
		Assert.assertTrue(flag);
	}

}