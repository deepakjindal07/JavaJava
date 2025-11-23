package com.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;

public class SPMethods extends Core {

    WebDriver driver;

    // Initializing the Page Objects:
    public SPMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[normalize-space()='Grad Planner']")
    WebElement gradPlanButton;

    @FindBy(xpath = "//button[contains(text(),'View Plan')]")
    WebElement viewPlanButton;

    @FindBy(xpath = "//button[contains(text(),'View Course Availability')]")
    WebElement courseAvailabilityButton;

    @FindBy(xpath = "//a[@class='search-button-link']")
    WebElement magIcon;

    @FindBy(xpath = "//strong[contains(text(),'REL 100')]")
    WebElement courseResult;

    @FindBy(xpath = "//div[contains(text(),'Students Planned')]")
    WebElement studentsPlanned;

    @FindBy(xpath = "//p[@class='blue-text']")
    WebElement completedCourseCount;

    @FindBy(xpath = "//li[@class='inproogress-text']") // Typo in 'inprogress-text'
    WebElement inProgress;

    @FindBy(xpath = "//li[@class='planned-text']")
    WebElement planned;

    @FindBy(xpath = "//p[@class='grey-text']")
    WebElement unPlanned;

    @FindBy(xpath = "//p[@class='black-text']")
    WebElement totalCredits;

    @FindBy(xpath = "//a[contains(text(),'Electives')]")
    WebElement electivesTab;

    @FindBy(xpath = "//span[contains(text(),'Excess')]")
    WebElement excessTab;

    @FindBy(xpath = "//span[@class='declared-plan']")
    WebElement verifyPlanOpened;

    public void clickViewPlanButton() {
        viewPlanButton.click();
    }

    public boolean checkCourseAvailability() {
        return courseAvailabilityButton.isDisplayed();
    }

    public String getCompletedCourseCount() {
        return completedCourseCount.getText();
    }

    public String getInProgress() {
        return inProgress.getText();
    }

    public String getPlanned() {
        return planned.getText();
    }

    public String getTotalCredits() {
        return totalCredits.getText();
    }

    public String getUnPlanned() {
        return unPlanned.getText();
    }

    public void clickElectivesTab() {
        electivesTab.click();
    }

    public void getElectivesCount() {
    }

    public void clickExcessTab() {
        excessTab.click();
    }

    public void clickGradPlanButton() {
        gradPlanButton.click();
    }

    public void clickOpenDeclaredPlan() {
    }

    public void getStudentName() {
    }

    public boolean isPlanOpened() throws InterruptedException {
        return verifyPlanOpened.isDisplayed();
    }
}
