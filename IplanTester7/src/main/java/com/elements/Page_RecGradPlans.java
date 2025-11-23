package com.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;

public class Page_RecGradPlans extends Core {

	WebDriver contr0l;

	// Initializing the Page Objects:
	public Page_RecGradPlans(WebDriver contr0l) {
		this.contr0l = contr0l;
		PageFactory.initElements(contr0l, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search Courses']")
	WebElement Searchbox;

	@FindBy(xpath = "//a[@class='search-button-link']")
	WebElement MagIcon;

	@FindBy(xpath = "//strong[contains(text(),'REL 100')]")
	WebElement courseResult;

	@FindBy(xpath = "//div[contains(text(),'Students Planned')]")
	WebElement StudentsPlanned;

//	@FindBy(xpath = "//span[normalize-space()='College']")
//    private List<WebElement> CollegeFilterIndexed;

	@FindBy(xpath = "(//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c81-4 ng-star-inserted'])[1]")
	WebElement CollegeFilter;

	@FindBy(xpath = "//span[@class='mat-option-text'][normalize-space()='Academic Success & IDS']")
	WebElement Coll_Value;

	@FindBy(xpath = "(//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c81-6 ng-star-inserted'])[1]")
	WebElement DeptFilter;

	@FindBy(xpath = "//span[@class='mat-option-text'][normalize-space()='Interdiscip. Studies']")
	WebElement Dept_art;

	@FindBy(xpath = "(//div[@id='mat-select-value-5'])[1]")
	WebElement CatalogFilterSelect;

	@FindBy(xpath = "//span[contains(text(),'ALL')]")
	WebElement CatalogFilterAllSelect;

	@FindBy(xpath = "(//div[@id='mat-select-value-7'])[1]")
	WebElement MajorSelect;

	@FindBy(xpath = "//span[@class='mat-option-text'][normalize-space()='399 GENERAL STUDIES - ASSOCIATE OF SCIENCE DEGREE']")
	WebElement MajorFromListSelect;

	@FindBy(xpath = "(//span[@class='mat-expansion-indicator ng-tns-c69-14 ng-trigger ng-trigger-indicatorRotate ng-star-inserted'])[1]")
	WebElement ExpandFirstPlan;

	@FindBy(xpath = "(//button[@aria-haspopup='true'])[1]")
	WebElement CogWheel;

	@FindBy(xpath = "(//button[@role='menuitem'])[1]")
	WebElement Cog_ViewPlan;

//	@FindBy(xpath = "driver.findElement(By.xpath(\"(//button[@class='mat-focus-indicator mat-menu-trigger menu-list mat-menu-item mat-menu-item-submenu-trigger ng-tns-c90-85 ng-star-inserted mat-menu-item-highlighted'])[1]\"))")
//	WebElement Cog_ViewPlan1;
//
//	@FindBy(xpath = "//h3[@title='Semester 1']//span[contains(text(),'Semester')]")
//	WebElement Semester1;

//	public void IsSemShowing() {
//		Semester1.click();
//	}

	public void CogWheelTest() {
		CogWheel.click();

	}

	public void ViewPlanTest(){
		Cog_ViewPlan.click();
	}

	public void SelectPlan() {
		ExpandFirstPlan.click();
	}

	public void MajorFilter() {
		MajorSelect.click();
	}

	public void MajorSelect() {
		MajorFromListSelect.click();
	}

	public void CatalogFilter() {
		CatalogFilterSelect.click();
	}

	public void CatalogFilterAll() {
		CatalogFilterAllSelect.click();
	}

	public void CollegeFilterTest() {
		CollegeFilter.click();
	}

	public void DeptSel_Art() {
		Dept_art.click();
	}

	public void DeptFilterTest() {
		DeptFilter.click();
	}

	public void ColSelect_Performing() {
		Coll_Value.click();
	}

//	public void CollegeFilterTestIndexed(int index) {
//		if (index >= 1 && index <= CollegeFilterIndexed.size()) {
//			WebElement ele = CollegeFilterIndexed.get(index - 1);
//			ele.click();
//		}
//	}

	public void enterCourse() {
		Searchbox.sendKeys("rel 100");
	}

	public void clickSearch() {
		MagIcon.click();
	}

	public void StudentsPlanned() {
		StudentsPlanned.isDisplayed();
	}

	public boolean result() {
		return courseResult.isDisplayed();
	}

}
