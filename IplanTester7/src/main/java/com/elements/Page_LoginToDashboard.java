package com.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;

public class Page_LoginToDashboard extends Core {

    WebDriver driver;

    // Initializing the Page Objects:
    public Page_LoginToDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[normalize-space()='Home']")
    WebElement home;

    @FindBy(xpath = "//h2[normalize-space()='Grad Planner']")
    WebElement gradPlanner2;

    @FindBy(xpath = "//h2[normalize-space()='Section Planner']")
    WebElement sectionPlanner2;

    @FindBy(xpath = "//div[@id='section']")
    WebElement footer;

    @FindBy(xpath = "//img[@alt='help']")
    WebElement help;

    @FindBy(xpath = "//img[@alt='Impersonate']")
    WebElement impersonateTool;

    @FindBy(xpath = "//i[@class='menu']")
    WebElement tileMenu;

    @FindBy(xpath = "//img[@id='applogo']")
    WebElement logo;

    @FindBy(xpath = "//div[@class='ng-binding']")
    WebElement homeBinding;

    // Method to check if Home element is displayed
    public boolean isHomeDisplayed() {
        return home.isDisplayed();
    }

    // Method to check if Grad Planner element is displayed
    public boolean isGradPlannerDisplayed() {
        return gradPlanner.isDisplayed();
    }

    // Method to check if Section Planner element is displayed
    public boolean isSectionPlannerDisplayed() {
        return sectionPlanner.isDisplayed();
    }

    // Method to check if Footer element is displayed
    public boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }

    // Method to check if Help element is displayed
    public boolean isHelpDisplayed() {
        return help.isDisplayed();
    }

    // Method to check if Impersonate Tool element is displayed
    public boolean isImpersonateToolDisplayed() {
        return impersonateTool.isDisplayed();
    }

    // Method to check if Tile Menu element is displayed
    public boolean isTileMenuDisplayed() {
        return tileMenu.isDisplayed();
    }

    // Method to check if Logo element is displayed
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    // Method to check if Home Binding element is displayed
    public boolean isHomeBindingDisplayed() {
        return homeBinding.isDisplayed();
    }

    //CLick on Meny on Dashboard.
    public void OpenMenu() {
    	tileMenu.click();
    }

    //------------------------ Menu ----------

    @FindBy(xpath = "//div[contains(text(),'Mentoring Dashboard')]")
    WebElement mentoring;

    @FindBy(xpath = "//div[contains(text(),'Academic Preparation')]")
    WebElement academicPreparation;

    @FindBy(xpath = "//div[contains(text(),'Career Preparation')]")
    WebElement careerPreparation;

    @FindBy(xpath = "//div[contains(text(),'Internships Approval')]")
    WebElement internship;

    @FindBy(xpath = "//div[contains(text(),'Career and Internships')]")
    WebElement careerAndInternship;

    @FindBy(xpath = "//div[contains(text(),'Academic Advising')]")
    WebElement academicAdvising;

    @FindBy(xpath = "//div[contains(text(),'Grad Planner')]")
    WebElement gradPlanner;

    @FindBy(xpath = "//div[contains(text(),'Tutoring')]")
    WebElement tutoring;

    @FindBy(xpath = "//div[contains(text(),'Section Planner')]")
    WebElement sectionPlanner;

    // Method to check if the menu is displayed
//    public boolean isMenuDisplayed() {
//        return menuToClick2.isDisplayed();
//    }

    // Method to check if Mentoring is displayed
    public boolean isMentoringDisplayed() {
        return mentoring.isDisplayed();
    }

    // Method to check if Academic Preparation is displayed
    public boolean isAcademicPreparationDisplayed() {
        return academicPreparation.isDisplayed();
    }

    // Method to check if Career Preparation is displayed
    public boolean isCareerPreparationDisplayed() {
        return careerPreparation.isDisplayed();
    }

    // Method to check if Internship is displayed
    public boolean isInternshipDisplayed() {
        return internship.isDisplayed();
    }

    // Method to check if Career and Internships is displayed
    public boolean isCareerAndInternshipDisplayed() {
        return careerAndInternship.isDisplayed();
    }

    // Method to check if Academic Advising is displayed
    public boolean isAcademicAdvisingDisplayed() {
        return academicAdvising.isDisplayed();
    }

    // Method to check if Grad Planner is displayed
    public boolean isGradPlannerDisplayed2() {
        return gradPlanner.isDisplayed();
    }

    // Method to check if Tutoring is displayed
    public boolean isTutoringDisplayed() {
        return tutoring.isDisplayed();
    }

    // Method to check if Section Planner is displayed
    public boolean isSectionPlannerDisplayed2() {
        return sectionPlanner.isDisplayed();
    }
}


