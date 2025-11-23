package com.elements;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codesetup.Core;

public class Page_ReviewGpElements extends Core {

    public WebDriver contr0l;
    WebDriverWait wait;

    // Initializing the Page Objects:
    public Page_ReviewGpElements(WebDriver contr0l) {
        this.contr0l = contr0l;
        wait = new WebDriverWait(contr0l, Duration.ofSeconds(10));
        PageFactory.initElements(contr0l, this);
    }

    //--Class Planner.
    @FindBy(xpath = "//h2[normalize-space()='Class Planning']")
    WebElement ClickGPClassPlanner;

    @FindBy(xpath = "(//input[@id='mat-input-0'])[1]")
    WebElement SearchBox;

    @FindBy(xpath = "(//div[@id='mat-select-value-1'])[1] | (//div[@id='mat-select-value-1'])[1]")
    WebElement CollegeFilter;

    @FindBy(xpath = "//span[normalize-space()='Physical Sci & Eng']")
    WebElement CollegeFilter2;

    @FindBy(xpath = "(//div[@id='mat-select-value-7'])[1] | //div[@id='mat-select-value-7']")
    WebElement DeptFilter1;

    @FindBy(xpath = "//span[normalize-space()='Computer Info Technology']")
    WebElement DeptFilter2;

    @FindBy(xpath = "(//div[@id='mat-select-value-13'])[1] | //div[@id='mat-select-value-13']")
    WebElement MajorFilter1;

    @FindBy(xpath = "//span[normalize-space()='679 Applied Technology']")
    WebElement MajorFilter2;

    @FindBy(xpath = "(//button[normalize-space()='Apply Filters'])[1]")
    WebElement ApplyFilter;

    @FindBy(xpath = "//mat-icon[normalize-space()='close']")
    WebElement CloseSearch;

    @FindBy(xpath = "//mat-row[1]//mat-cell[9]//mat-icon[1]")
    WebElement DecPlan;

    @FindBy(xpath = "//div[@title='EPSOne Ithaca']")
    WebElement resultInReviewGP;

    public void OpenDecPlan() {
        DecPlan.click();
    }

    public void CloseSearchBoxText() {
        CloseSearch.click();
    }

    public void ClickGPClassPlannerTest() {
        ClickGPClassPlanner.click();
    }

    public void Search4Student() throws InterruptedException {
        SearchBox.sendKeys("120799032");
        SearchBox.sendKeys(Keys.ENTER);

        SearchBox.sendKeys(Keys.ARROW_DOWN);
        SearchBox.sendKeys(Keys.ENTER);
    }

    public void CollegeFilterTest() throws InterruptedException {
        CollegeFilter.click();
        CollegeFilter2.click();
    }

    public void DeptFilterTest() throws InterruptedException {
        DeptFilter1.click();
        DeptFilter2.click();
    }

    public void MajorFilterTest() throws InterruptedException {
        MajorFilter1.click();
        MajorFilter2.click();
    }

    public void ApplyFilterTest() {
        ApplyFilter.click();
    }
}


