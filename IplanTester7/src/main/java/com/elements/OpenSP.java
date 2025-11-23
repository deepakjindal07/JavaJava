package com.elements;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.codesetup.CommonUtils;
import com.codesetup.Core;

public class OpenSP extends Core {

	static SoftAssert softassert = new SoftAssert();
	public static Object CheckDecPlanName;

	public static void OpenSPModuleTile(WebDriver contr0l, String iNumber) throws InterruptedException {

		// h2[normalize-space()='SectionPlanner']
		// h2[normalize-space()='Class Schedule Tool'

		String moduleHeaderXpath = "//h2[normalize-space()='SectionPlanner']";

		try {
			WebElement classScheduleToolElement = contr0l.findElement(By.xpath(moduleHeaderXpath));
			if (classScheduleToolElement != null) {
				classScheduleToolElement.click();

				System.out.println("Class Schedule Tool opened for " + iNumber);
				CommonUtils.saveResultToFile("report/SectionPlannerWorking" + prop.getProperty("env") + ".txt",
						iNumber);
				// Optionally add a delay after clicking the element
				// Thread.sleep(10000);
			} else {
				System.out.println("Class Schedule Tool module not visible for " + iNumber);
				softassert.assertTrue(true);
				CommonUtils.saveResultToFile("sectionplannernotworking.txt", iNumber);
			}
		} catch (NoSuchElementException e) {
			System.out
					.println("Error occurred while opening Class Schedule Tool for " + iNumber + ": " + e.getMessage());

			softassert.assertTrue(true);
			// GradPlanUtils.saveResultToFile("error.log", iNumber + ": " + e.getMessage());
		}
	}

	public static void OpenSemester(WebDriver contr0l, String iNumber) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(contr0l, Duration.ofSeconds(60));
		System.out.println("[Info] Opening semester in section planner");

		try {
			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
					"//span[normalize-space()='Plan & Register'] | //span[normalize-space()='Plan Schedule'] | //span[normalize-space()='View & Add 2nd Block']")));

			// Loop through the elements and click on the first visible element
			for (WebElement element : elements) {
				if (element.isDisplayed()) {
					Thread.sleep(5000);
					element.click();
					System.out.println("Clicked on: " + element.getText());
					Thread.sleep(1000);
					// Handle Pop-up while opening available sem.
					checkPOPups(contr0l);

					break; // Exit loop after clicking the first visible element
				}
			}
			WebElement SelectedSem = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='selected-semester']")));

			if (SelectedSem.isDisplayed()) {
				System.out.println("[Info] Semester page opened for planning sections");
				System.out.println("[Info] "+SelectedSem.getText());

			}

			CommonUtils.saveResultToFile("report/SPworkingon" + prop.getProperty("env") + ".txt", iNumber);
		} catch (Exception e) {
			System.out.println("Unable to open any semester");
			throw e;
		}
	}

	static void checkPOPups(WebDriver Contr0l) {

		// button[normalize-space()='GO TO HOME']
		// button[normalize-space()='Plan Classes without grad plan']

		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// hold = new WebDriverWait(contr0l, Duration.ofSeconds(10));

		try {
			List<WebElement> elements = contr0l.findElements(By.xpath("//button[normalize-space()='GO TO HOME'] | "
					+ "//button[normalize-space()='Plan Classes without grad plan'] | "
					+ "//span[normalize-space()='Continue']"));

			// Loop through the elements and click on the first visible element
			for (WebElement element : elements) {
				try {
					// Wait for the element to become clickable within the maximum timeout
					// wait.until(ExpectedConditions.elementToBeClickable(element));
					// If the element is clickable, click it and break out of the loop
					element.click();
					break;
				} catch (Exception e) {
					// If a TimeoutException occurs, continue to the next element
					continue;
				}
			}
		} catch (Exception e) {
			// Handle other exceptions here if needed
			// e.printStackTrace(); // Print the exception stack trace for debugging
		}
	}

	public static void switchToFirstTabAndCloseOthers(WebDriver contr0l) throws InterruptedException {
		// Get handles of all windows/tabs
		Set<String> windowHandles = contr0l.getWindowHandles();

		// Get the handle of the current tab
		String currentTabHandle = contr0l.getWindowHandle();

		// Close all tabs except the current one
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(currentTabHandle)) {
				contr0l.switchTo().window(windowHandle);
				contr0l.close();
			}
		}

		// Switch back to the first tab
		contr0l.switchTo().window(windowHandles.iterator().next());

		Thread.sleep(2000);
	}

	public static String appendSectionPlannerUrl(String originalURL) {
		try {
			// Parse the original URL
			URI uri = new URI(originalURL);
			// Get the query parameters from the original URL
			String query = uri.getQuery();
			String personationId = null;
			// Parse the query parameters to extract the personationId
			if (query != null) {
				String[] queryParams = query.split("&");
				for (String param : queryParams) {
					String[] keyValue = param.split("=");
					if (keyValue.length == 2 && keyValue[0].equals("personationId")) {
						personationId = keyValue[1];
						break;
					}
				}
			}

			if (personationId == null) {
				// If personationId not found in query parameters, extract from path
				personationId = uri.getPath().replace("/", "");
			}

			// Build the sectionPlanner URL with the extracted personationId
			StringBuilder sectionPlannerURLBuilder = new StringBuilder();
			sectionPlannerURLBuilder.append(uri.getScheme()).append("://").append(uri.getHost())
					.append("/sectionPlanner/?personationId=").append(personationId).append("#/Home");

			return sectionPlannerURLBuilder.toString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void CheckPrevSemester(WebDriver contr0l) throws InterruptedException {

	    try {
	    	contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        System.out.println("[Info] Checking previous semester if any.");
	        WebElement element = contr0l.findElement(By.xpath("//body//app-root//div//div//div//div//div//div//div[1]//div[1]//div[1]//div[3]//a[1]"));

	        // Check if the element is visible
	        if (element.isDisplayed()) {
	            Thread.sleep(5000);
	            System.out.println("[Info] Previous semester showing, checking..");
	            JavascriptExecutor js = (JavascriptExecutor) contr0l;
	            js.executeScript("arguments[0].click();", element);
	            // Wait for 10 seconds
	            Thread.sleep(10000);
	            contr0l.navigate().back();
	            System.out.println("Going back to main page");
	        } else {
	            // Throw an exception and print the message
	            //throw new NoSuchElementException("Previous semester not visible");
	        	System.out.println("[Info || Warning] Previous semester not visible");
	        }
	    } catch (InterruptedException | NoSuchElementException e) {
	        //System.out.println("An error occurred while checking previous semester: " + e.getMessage());
	    	System.out.println("Previous semester not visible for student");
	       // e.printStackTrace();
	    }

	}

	public static void CheckRegisterButton(WebDriver contr0l) throws InterruptedException {
		System.out.println("[Info] Testing Register Button");
		WebElement element = contr0l.findElement(By.xpath("//button[normalize-space()='My Registration']"));

		// Check if the element is visible
		if (element.isDisplayed()) {
			// Click on the element
			element.click();
			Thread.sleep(1000);
			element.click();
		} else {
			// Throw an exception and print the message
			throw new RuntimeException("[Warning] Register Button not clickable");
		}

	}

	public static void CheckPersonalEvent(WebDriver contr0l) throws InterruptedException {

		System.out.println("[Info] Checking Personal Event");
		// Click on the "Add Personal Event" button
		WebElement addEventButton = contr0l.findElement(By.xpath("//button[normalize-space()='Add Personal Event']"));
		addEventButton.click();

		// Enter text "Testing" in the input field
		WebElement eventTitleInput = contr0l.findElement(By.xpath("//input[@placeholder='Event Title']"));
		eventTitleInput.sendKeys("Testing");

		WebElement checkbox = contr0l.findElement(
				By.cssSelector("label[for='mat-checkbox-1-input'] span[class='mat-checkbox-inner-container']"));
		Thread.sleep(1000);
		// By.xpath("//label[@for='mat-checkbox-33-input']//span[@class='mat-checkbox-inner-container']"));

		JavascriptExecutor js = (JavascriptExecutor) contr0l;
		js.executeScript("arguments[0].click();", checkbox);

		Thread.sleep(1000);

		// Click on the "Apply" button
		WebElement applyButton = contr0l.findElement(By.xpath("//button[normalize-space()='Apply']"));
		applyButton.click();
		Thread.sleep(1000);

	}

	public static void CheckCalendarView(WebDriver contr0l) throws InterruptedException {
		System.out.println("[Info] Checking Calendar View");
		WebElement Lview = contr0l.findElement(By.xpath("//button[normalize-space()='List View']"));
		Lview.click();
		Thread.sleep(3000);

		WebElement CView = contr0l.findElement(By.xpath("//button[normalize-space()='Calendar View']"));
		CView.click();
		Thread.sleep(3000);

	}

	public static void AddCourseToList(WebDriver contr0l) throws InterruptedException {
		// Check if the button "Add Course to List" is visible
		WebElement addCourseButton = contr0l.findElement(By.xpath("//button[normalize-space()='Add Course to List']"));
		if (addCourseButton.isDisplayed()) {
			addCourseButton.click();
		}

		// Check if the card title "Search all courses" is visible
		WebElement searchCoursesTitle = contr0l
				.findElement(By.xpath("//mat-card-title[normalize-space()='Search all courses']"));
		if (searchCoursesTitle.isDisplayed()) {

			searchCoursesTitle.click();
			// Perform action related to search all courses
			WebElement searchInput = contr0l.findElement(By.xpath("//input[@placeholder='Search Courses']"));
			searchInput.sendKeys("rel 100");

			Thread.sleep(triggerwait);

			// Perform another action if required
			// For example, click on the add circle image
			WebElement addCircleImage = contr0l.findElement(By.xpath("//img[@src='assets/images/add_circle.svg']"));
			addCircleImage.click();

			JavascriptExecutor js = (JavascriptExecutor) contr0l;
			js.executeScript("arguments[0].click();", addCircleImage);

			// Check if the button "PLAN COURSE" is visible
			WebElement planCourseButton = contr0l.findElement(By.xpath("//button[normalize-space()='PLAN COURSE']"));
			if (planCourseButton.isDisplayed()) {
				planCourseButton.click();
			}
			Thread.sleep(triggerwait);
		}

		// Click on the overlay button
		WebElement overlayButton = contr0l.findElement(By.xpath("//button[@class='overlay-btn']"));
		overlayButton.click();

		// Click on the plus icon image
		WebElement plusIconImage = contr0l.findElement(By.xpath("//img[@class='icon-plus']"));
		plusIconImage.click();

		Thread.sleep(triggerwait);

	}

	public static void CheckDecPlanNameandRefresh(WebDriver contr0l, String inumber) throws Exception {

		WebDriverWait wait = new WebDriverWait(contr0l, Duration.ofSeconds(60));

		try {
			contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			System.out.println("[Info] Refreshing DA before further checks.");

			WebElement refresh = contr0l.findElement(By.xpath("//a[normalize-space()='Refresh']"));
			Thread.sleep(5000);
			refresh.click();

			//Then wait until page is loaded again.
			WebElement registrationButton = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='My Class Schedule Tool']")));

			if(registrationButton.isDisplayed() && registrationButton != null) {
				System.out.println("[Info] DA refresh clicked..");
			}


		} catch (Exception e) {
			System.out.println("[Warning] Refresh DA button not visible.. ");
			//e.printStackTrace();
		}
	}

	// TODO need further logic, how to check if plan is working..
	public static void isplanworking(WebDriver contr0l, String inumber) throws Exception {

		// Thread.sleep(10000);

		try {
			WebElement isWorking = contr0l.findElement(By.xpath("//button[normalize-space()='Create Gradplan']"));

			if (isWorking.isDisplayed()) {
				isWorking.click();

				GradPlanMethods gradPlanMethods = new GradPlanMethods();
				gradPlanMethods.switchToNewTab(contr0l);
				gradPlanMethods.OpenDeclaredPlan(contr0l, inumber);
				gradPlanMethods.GetPlanStatus(contr0l, inumber);

				// Thread.sleep(10000);
				// Wait for 30 seconds.
			}
		} catch (Exception e) {
			System.out.println("Element 'Create Gradplan' is not visible or not found.");
			throw e;
		}

	}

}
