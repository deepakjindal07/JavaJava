package com.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;


public class Page_Umbraco extends Core {

	WebDriver contr0l;

	// Initializing the Page Objects:
	public Page_Umbraco(WebDriver contr0l) {
		this.contr0l = contr0l;
		PageFactory.initElements(contr0l, this);
	}

	//--Impersonation
	@FindBy(xpath = "//a[@class='specIcon']//img")
	WebElement SpectsIcon;

	//button[@title='Search']
	@FindBy(xpath = "//a[@title='Search']")
	WebElement SpectsIconSearch;

	@FindBy(xpath = "//button[@title='Search']")
	WebElement SpectsIconSearch2;


	@FindBy(xpath="//input[@placeholder='Enter I-Number']")
	WebElement SearchInumber;


	//h2[title='Class Planning']
	//h2[normalize-space()='Class Planning']
	//h2[contains(text(),'Grad Planner')]

	@FindBy(xpath = "//h2[normalize-space()='Class Planning']")
	WebElement GradPlannerButton;

	//InsideGPLandingPage
	@FindBy(xpath = "//h1[contains(text(),'Review Grad Plans')]")
	WebElement ReviewGPpage;

	@FindBy(xpath = "//i[contains(text(),'Menu')]")
	WebElement Menu1;

	@FindBy(xpath = "//div[contains(text(),'Home')]")
	WebElement homeTile;

	@FindBy(xpath = "//li[@class='new-menu-cards ng-scope']//li[2]//a[1]//eps-feature[1]//div[2]")
	WebElement AcademicPrepTile;

	@FindBy(xpath = "//li[3]//a[1]//eps-feature[1]//div[2]")
	WebElement CareerExplorationTile;

	@FindBy(xpath = "//div[contains(text(),'Graduation Planner')]")
	WebElement GPTile;

	@FindBy(xpath = "//div[contains(text(),'Career Preparation')]")
	WebElement CareerPrepTile;

	@FindBy(xpath = "//div[contains(text(),'Career and Internships')]")
	WebElement CareerInternTile;

	@FindBy(xpath = "//div[contains(text(),'Internship Approval')]")
	WebElement InternshipTile;

	@FindBy(xpath = "//div[contains(text(),'Tutoring')]")
	WebElement TutoringTile;

	@FindBy(xpath = "//div[contains(text(),'Academic Advising')]")
	WebElement AcademicAdvising;

	@FindBy(xpath = "//div[contains(text(),'Student Performance')]")
	WebElement StudentPerformance;

	@FindBy(xpath = "//div[contains(text(),'Alerts')]")
	WebElement AlertTile;

	@FindBy(xpath = "//div[contains(text(),'Internship V2')]")
	WebElement Internship2Tile;

	@FindBy(xpath = "//div[contains(text(),'Academic Preparation V2')]")
	WebElement AcademicPrep2Tle;

	@FindBy(xpath = "//div[contains(text(),'Career Exploration V2')]")
	WebElement CareerExpV2Tile;

	@FindBy(xpath = "//div[contains(text(),'Advising V2')]")
	WebElement AdvisingV2Tile;

	@FindBy(xpath = "//div[@id='msg']")
	WebElement CASerrMSG;


	public void GradPlannerButton() {
		GradPlannerButton.click();
	}

	public void SpectsIconTest(){
		SpectsIcon.click();
	}

	public void WaitTillSpectsIconTest(){
		SpectsIcon.isDisplayed();
	}
	public void SearchInumberTest(String inumber){
		SearchInumber.sendKeys(inumber);
	}

	public void SearchInumberClearTest(){
		SearchInumber.clear();
	}

	public void SpectsIconSearchTest(){
		SpectsIconSearch.click();
	}

	public void SpectsIconSearchTest2(){
		SpectsIconSearch2.click();
	}

	public void StudentGPModuleTest(){
		GradPlannerButton.click();
	}

	public boolean ReviewGPpageTest(){
		return ReviewGPpage.isDisplayed();
	}

	public boolean adminStudent() throws InterruptedException{
	    boolean value = contr0l.findElements(By.xpath("//h1[contains(text(),'Review Grad Plans')]")).size()>0;
		return value;
	}

	public void Menu1Test(){
		Menu1.click();
	}

	public void GPTileTest() {
		GPTile.click();
	}

	public boolean AcademicAdvisingTest() {
		return AcademicAdvising.isDisplayed();
	}

	public String CASerrMSGTest(WebDriver contr0l){
		return CASerrMSG.getText();
	}

	public boolean CASerrMSGShowingTest(WebDriver contr0l){
		return CASerrMSG.isDisplayed();
	}

}

