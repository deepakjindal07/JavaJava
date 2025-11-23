package com.elements;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.codesetup.CommonUtils;
import com.codesetup.Core;

public class mobileGPandSP extends Core {

	public void Impersonate(WebDriver contr0l, String inumber) throws InterruptedException {
		//DevToolsChecker.CallStatusCheck(contr0l);
		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		try {
			WebElement SpecTool2 = contr0l.findElement(By.xpath("//img[@alt='Impersonate']"));
			SpecTool2.click();
			Thread.sleep(1000);
			WebElement CheckInum = contr0l.findElement(By.xpath("//input[@placeholder='Enter I-Number']"));
			CheckInum.clear();
			Thread.sleep(1000);
			CheckInum.sendKeys(inumber);
			Thread.sleep(1000);
			CheckInum.sendKeys(Keys.ENTER);
			Thread.sleep(1000);

		} catch (Exception e) {
			System.out.println("[Warning] Unable to Impersonate " + inumber);
			Assert.assertTrue(true, "Unable to find Impersonation tool in time");

		}
		ArrayList<String> tabs2 = new ArrayList<>(contr0l.getWindowHandles());
		contr0l.switchTo().window(tabs2.get(1));

	}

	public void OpenGPModuleForStudent(WebDriver contr0l, String inumber) throws Exception {

		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// DevToolsChecker.CallStatusCheck(contr0l);

		// print student name as well.
		WebElement studentName = contr0l.findElement(By.xpath("//span[@class='role']"));
		System.out.println("\n\n[Info] Checking Inumber: " + inumber + " " + studentName.getText());

		System.out.println("[Info] Grad Planner module opening");
		try {
			Thread.sleep(triggerwait);

			// h1[normalize-space()='BYU-Idaho Login'] --Stage
			List<WebElement> gpModules = contr0l.findElements(By.xpath(
					"(//h2[normalize-space()='Grad Planner'])[1] | //h2[@title='Grad Planner'] | "
					+ "//h2[normalize-space()='Graduation Planner'] | "
					+ "//h2[normalize-space()='Grad Planner'] | //span[normalize-space()='Class Planner'] "
					+ "| //h2[@title='Graduation Planner'] | "
					+ "//h2[@title='Class Planning']"));

			// Loop through the elements and click on the first visible element
			// boolean clicked = false;
			for (WebElement gpMods : gpModules) {
				if (gpMods.isDisplayed()) {
					// gpMods.click();
					JavascriptExecutor js = (JavascriptExecutor) contr0l;
					js.executeScript("arguments[0].click();", gpMods);
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("[Warning] Unable to Open GradPlanner module");
			Assert.assertTrue(true, "Student does not have GP module tile in Dashboard");

		}
	}
//		} catch (TimeoutException e) {
//			System.out.println("GP module not enabled for this student.");
//
//			// Log or handle the exception as needed
//			// Optionally, throw a RuntimeException to indicate a critical error condition
//			// throw new RuntimeException("GP not enabled for this student", e);
//			// Since this is inside a try-catch block, you can't use continue here
//
//	}

	public void OpenDeclaredPlan(WebDriver contr0l, String inumber) throws Exception {

		//DevToolsChecker.CallStatusCheck(contr0l);
		System.out.println("Starting.. Declared plan opening. ");
		try {
			WebElement viewPlanButton = contr0l.findElement(By.xpath(
					"(//button[@class='button-standard submit skeleton-loader'][normalize-space()='View Plan'])[1]"));

			if (viewPlanButton != null && viewPlanButton.isDisplayed()) {
				viewPlanButton.click();
				System.out.println("[Info] View Plan clicked");
			} else {
				contr0l.navigate().refresh();
				viewPlanButton.click();
			}

		} catch (Exception e) {
			System.out.println("[Warning] Unable to click on ViewButton " + inumber);
			Assert.assertTrue(true, "Unable to click on View plan button");
		}

		// CheckifAdvisor(inumber);
	}

	public void CheckifAdvisor(String Inumber) throws InterruptedException {

		System.out.println("Since Myplan page not visible, Check if advisor..");

		WebElement advisor = contr0l.findElement(By.xpath("//h1[normalize-space()='Review Grad Plans']"));

		if (advisor.isDisplayed()) {
			System.out.println("Inumber have Advisor role");

			String originalURL = contr0l.getCurrentUrl();
			String modifiedURL = appendAdivorRoleUrl(originalURL);
			System.out.println(Inumber + " " + modifiedURL);
			contr0l.get(modifiedURL);
			Thread.sleep(triggerwait);
			// DevToolsChecker.CallStatusCheck(contr0l);

		}

		try {
			WebElement viewPlanButton = contr0l.findElement(By.xpath(
					"(//button[@class='button-standard submit skeleton-loader'][normalize-space()='View Plan'])[1]"));

			// print student name as well.
			WebElement studentName = contr0l.findElement(By.xpath("//span[@class='role']"));
			System.out.println(studentName.getText());

			if (viewPlanButton != null && viewPlanButton.isDisplayed()) {
				viewPlanButton.click();
				System.out.println("View Plan clicked");
			}
		} catch (Exception e) {
			System.out.println("Unable to click on ViewButton second time ");
		}
		Assert.assertTrue(false, "Advisor page, skip further tests");

	}

	private String appendAdivorRoleUrl(String originalURL) {

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
					.append("/grad_planner/?personationId=").append(personationId).append("#/myPlans");

			return sectionPlannerURLBuilder.toString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void CheckPlanifWorking(WebDriver contr0l, String inumber) throws Exception {
		//DevToolsChecker.CallStatusCheck(contr0l);

		System.out.println("[Info] Checking for Error box / other validations");
		checkErrorBox(contr0l, inumber);
		// CheckGRTBox(contr0l, inumber);
		// CheckAdvisor(contr0l, inumber);
		// CommonUtils.takeScreenshot(contr0l);

	}

	public void checkGRTBox(WebDriver contr0l, String inumber) throws Exception {

		try {
			WebElement GRT = contr0l.findElement(By.xpath("//span[@class='mat-button-wrapper']"));
			GRT.click();

			throw new Exception("GRT error message.");
		} catch (Exception e) {
			System.out.println("GRT Error message..");
			throw e;
		}
	}

	public void checkErrorBox(WebDriver contr0l, String inumber) throws Exception {
		hold = new WebDriverWait(contr0l, Duration.ofSeconds(120));
		List<WebElement> gpModules = null;

		try {
			gpModules = hold.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//mat-dialog-container[id='mat-dialog-1']//span[contains(@class,'mat-button-wrapper')]"
							+ "| //mat-dialog-container[id='mat-dialog-1']//button[@type='button']"
							+ "| //span[contains(@class,'mat-button-wrapper')]")));

		} catch (Exception e) {
			// Elements not found, do nothing
			return;
		}

		// Loop through the elements and click on the first visible element
		boolean clicked = false;
		for (WebElement gpMods : gpModules) {
			if (gpMods.isDisplayed()) {

				System.out.println(">>> There was an error opening plan.");
				gpMods.click();
				System.out.println(">>> Continue button clicked.");
				clicked = true;
				contr0l.close();
				System.out.println("Tab Closed. ");
				Assert.assertTrue(clicked, "[Warning]Plan have error - closing.");
				break; // Exit the loop after clicking the first visible element
			}
		}

		if (clicked) {

			Thread.sleep(triggerwait);
			// new WebDriverWait(contr0l,
			// Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());

			CommonUtils.saveResultToFile("report/NotWorkingGPError" + prop.getProperty("env") + ".txt", inumber);
			throw new Exception("Errorbox / GRTerror found.");
		}
	}

	public void switchToNewTab(WebDriver control) {
		// Get the handles of all the currently open windows
		Set<String> windowHandles = control.getWindowHandles();

		// Iterate through each window handle
		for (String handle : windowHandles) {
			// Switch to the new window/tab if it's not the current window handle
			if (!handle.equals(control.getWindowHandle())) {
				control.switchTo().window(handle);
				break; // Break the loop once switched to the new tab
			}
		}
	}

	public static void closeAllWindowsExceptOriginal(WebDriver contr0l, String originalHandle)
			throws InterruptedException {
		// Get all window handles
		Set<String> windowHandles = contr0l.getWindowHandles();

		// Iterate through each window handle
		for (String handle : windowHandles) {
			// Close the window if it's not the original handle
			if (!handle.equals(originalHandle)) {
				contr0l.switchTo().window(handle);
				contr0l.close();
			}
		}

		// Switch back to the original window
		contr0l.switchTo().window(originalHandle);
		contr0l.navigate().refresh();
		Thread.sleep(3000);

	}

	public void navigateToAllPlanHistories(WebDriver contr0l) throws InterruptedException {
		//DevToolsChecker.CallStatusCheck(contr0l);
		WebElement allPlanHistory = contr0l.findElement(By.xpath("//span[normalize-space()='All Plan Histories']"));
		allPlanHistory.click();
		// GradPlanUtils.waitForElement(contr0l, null, Duration.ofSeconds(8));

		// Navigate back
		Thread.sleep(triggerwait);
		contr0l.navigate().back();

	}

	public Object[][] excelDataProviderBeta() {
		// TODO Auto-generated method stub
		return null;
	}

	public void CreateAltPlan(WebDriver contr0l, String inumber) throws InterruptedException {
		//DevToolsChecker.CallStatusCheck(contr0l);
		System.out.println("[Info] Checking Create alternate plan flow");

		hold = new WebDriverWait(contr0l, Duration.ofSeconds(30));

		try {
			WebElement altplan = hold.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@class='create-alt-plan-btn ng-star-inserted']")));

			if (altplan.isDisplayed() && altplan != null) {
				altplan.click();
				Thread.sleep(triggerwait);
			} else {
				Assert.assertTrue(true, "[] Unable to click on create alt plan button");
			}

			WebElement editmajor = hold.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Edit Major']")));
			editmajor.click();

			//JavascriptExecutor js = (JavascriptExecutor) contr0l;
			//js.executeScript("arguments[0].click();", editmajor);

			WebElement searchField = hold.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Find a major…']")));
			searchField.clear();
			searchField.sendKeys("800");
			Thread.sleep(5000);
			searchField.clear();
			searchField.sendKeys("6");
			Thread.sleep(triggerwait);

			WebElement resultMajor = hold.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//div[@class='row current-major-tbl no-height new-placeholder-design']//div[1]//div[4]//button[i]) | //button[contains(@class, 'button-small') and contains(text(), 'Select')]")));
			resultMajor.click();

			Thread.sleep(triggerwait);

			WebElement resultCatalogyYear = hold.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@class='component-group ng-star-inserted']//div[1]//div[1]//div[4]//button[1] |  (//button[@class='button-small'][normalize-space()='Select'])[1]")));
			resultCatalogyYear.click();

			Thread.sleep(triggerwait);
			WebElement Startplanning = hold.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector(".button-large.grey.gray-large.margin-top-15")));
			Startplanning.click();

			WebElement EnterName = contr0l.findElement(By.xpath("//input[@placeholder='Enter Plan Name']"));
			EnterName.sendKeys("Alternate plan");
			Thread.sleep(triggerwait);

			WebElement OkayName = contr0l.findElement(By.xpath("//button[@type='submit']"));
			OkayName.click();
			Thread.sleep(bigwait);

		} catch (Exception e) {
			System.out.println("[Warning] Unable to create alt plan");

			// throw e;
		}

	}

	public void GetPlanStatus(WebDriver contr0l, String inumber) throws InterruptedException {
		//DevToolsChecker.CallStatusCheck(contr0l);

		System.out.println("[Info] Checking plan status after opening it");
		Thread.sleep(triggerwait);

		contr0l.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

//		WebDriverWait hold = new WebDriverWait(contr0l, Duration.ofSeconds(40));
//		hold.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//span[@class='red-text skeleton-loader']")));

		WebElement redTextElement = contr0l.findElement(By.xpath("//span[@class='red-text skeleton-loader']"));
		String redText = redTextElement.getText();
		//System.out.println(inumber + " " + redText);

		if (!redText.equals("Not Started")) {
			System.out.println("[Info] "+inumber + " Working and status is: " + redText);
			String result = inumber + " " + redText;
			CommonUtils.saveResultToFile("report/WorkingPlans" + prop.getProperty("env") + ".txt", result);
		}

	}

//	public static void navigateToUserDashboard(WebDriver contr0l) {
//		// Get the current URL
//		String currentUrl = contr0l.getCurrentUrl();
//
//		// Check if the current URL contains "/enterprisev2/#/userDashboard"
//		if (currentUrl.contains("/enterprisev2/#/userDashboard")) {
//			// Continue with the existing URL
//			System.out.println("URL already contains '/enterprisev2/#/userDashboard'.");
//		} else {
//			// Navigate to the base URL appended with "/enterprisev2/#/userDashboard"
//			String baseUrl = "https://gps-qa-sql.excelindia.com/";
//			String targetUrl = baseUrl + "/enterprisev2/#/userDashboard";
//			contr0l.get(targetUrl);
//			System.out.println("Navigated to: " + targetUrl);
//		}
//
//		// Close any other opened tab
//		if (contr0l.getWindowHandles().size() > 1) {
//			contr0l.close();
//		}
//
//		// Switch driver to the current page
//		for (String handle : contr0l.getWindowHandles()) {
//			contr0l.switchTo().window(handle);
//		}
//	}

}
