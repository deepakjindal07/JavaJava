
package com.advisorside;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codesetup.Core;
import com.elements.Page_ReviewStudentApp;

public class StudentApplication extends Core {
	public Page_ReviewStudentApp reviewApplication;

	@BeforeTest
	public void TestSetup() throws Exception {
		reviewApplication = new Page_ReviewStudentApp(contr0l);
	}

	@Test(priority = 1, enabled = true, groups = { "Admin" })
	public void ReviewStudentApplication1() throws InterruptedException {
		System.out.println("Running Review Student Application Test");
		contr0l.get(baseUrl + prop.getProperty("ReviewStudentApplication"));
		contr0l.navigate().refresh();

		// Assert.assertTrue(reviewApplication.CheckHeadlines());
		Thread.sleep(5000);
	}

	@DataProvider(name = "Switch-data")
	public Object[][] SwitchMethod() throws IOException {
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

	@Test(priority = 2, enabled = true, dataProvider = "Switch-data")
	public void ReviewStudentApplication2(String Inumber) throws InterruptedException {
		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		if (Inumber != null && !Inumber.isEmpty()) {

			WebElement box = contr0l.findElement(By.xpath("//input[@id='appOnlyMajor_Search']"));
			box.sendKeys(Inumber);
			box.sendKeys(Keys.ENTER);
			//Thread.sleep(triggerwait);

			WebElement res1 = contr0l.findElement(By.xpath(" //mat-icon[normalize-space()='arrow_forward_ios']"));
			res1.click();

			WebElement button = contr0l.findElement(By.xpath("//button[normalize-space()='Accept']"));
			button.click();

			System.out.println("Accepted for " + Inumber);
		}
	}
}