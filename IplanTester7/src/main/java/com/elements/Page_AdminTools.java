package com.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_AdminTools {

    WebDriver contr0l;

    public Page_AdminTools(WebDriver contr0l) {
        this.contr0l = contr0l;
        PageFactory.initElements(contr0l, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Admin Tools']")
    WebElement Header;

    @FindBy(xpath = "//a[normalize-space()='Excess Credit Threshold']")
    WebElement ExcessCreditLink;

    @FindBy(xpath = "//a[normalize-space()='Freeze Program Changes']")
    WebElement FreezeProgramChanges_Lnk;

    @FindBy(xpath = "//input[@id='Text2']")
    WebElement SetLow;

    @FindBy(xpath = "//input[@id='Text3']")
    WebElement SetHigh;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement SaveButton;

    @FindBy(xpath = "//span[contains(text(),'Changes saved successfully.')]")
    WebElement ConfirmRibbon;

    @FindBy(xpath = "//span[contains(text(),'X')]")
    WebElement CloseBlueRibbon;

    @FindBy(xpath = "//div[3]/div")
    WebElement FreezeFlow2Ele;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Message'])[1]/following::textarea[1]")
    WebElement FreezeFlow3Ele;

    @FindBy(xpath = "//button[normalize-space()='ADD']")
    WebElement Freeze_Add;

    @FindBy(xpath = "//span[@class='mat-menu-trigger icon30 greenSetting'])[4]")
    WebElement FreezeFlow8Ele;

    @FindBy(xpath = "//ul[5]/li/span")
    WebElement FreezeFlow10Ele;

    @FindBy(xpath = "//div[@id='mat-menu-panel-3']/div/button[2]")
    WebElement FreezeFlow11Ele;

    @FindBy(linkText = "Manage Preferences")
    WebElement ManagePrefLink;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement CheckBox;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement SaveButton1;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='December'])[1]/following::button[1]")
    WebElement LastTest1;

    @FindBy(xpath = "//a[normalize-space()='Switch Major Config']")
    WebElement OpenSwitchMajorconfig1;

    @FindBy(xpath = "//button[normalize-space()='Add New Step']")
    WebElement ClickAddNew1;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/mat-dialog-container[1]/app-gp-edit-workflowsteps[1]/div[1]/ul[1]/li[2]/button[1]/span[2]")
    WebElement CloseDialog1;

    @FindBy(xpath = "//a[contains(text(),'Email Template')]")
    WebElement OpenEmailTemplates1;

    @FindBy(xpath = "//span[normalize-space()='Close']")
    WebElement CloseConfBox1;

    public void CloseConfBox() {
        CloseConfBox1.click();
    }

    public void OpenEmailTemplates() {
        OpenEmailTemplates1.click();
    }

    public void OpenSwitchMajorconfig() {
        OpenSwitchMajorconfig1.click();
    }

    public void ClickAddNew() {
        ClickAddNew1.click();
    }

    public void CloseDialog() {
        CloseDialog1.click();
    }

    public void OpenManagePref() {
        ManagePrefLink.click();
    }

    public void SaveButton() {
        SaveButton1.click();
    }

    public void CheckBox1() {
        CheckBox.click();
    }

    public void LastTest() {
        LastTest1.click();
    }

    public void FreezeFlow10() {
        FreezeFlow10Ele.sendKeys("TestMessage");
    }

    public void FreezeFlow11() {
        FreezeFlow11Ele.sendKeys("TestMessage");
    }

    public void FreezeFlow8() {
        FreezeFlow8Ele.click();
    }

    public void AddText() {
        Freeze_Add.click();
    }

    public void PressEsc() {
        Actions action = new Actions(contr0l);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

//    public void OpenCalendarTest() {
//        GPutils.waitForElement(contr0l, OpenCalendar, 5);
//        OpenCalendar.click();
//    }

    public void FreezeOpen() {
        FreezeProgramChanges_Lnk.click();
    }

    public boolean ConfirmRibbonVerify() {
        return ConfirmRibbon.isDisplayed();
    }

    public void ClickSaveButton() {
        SaveButton.click();
    }

    public void SetHighThreshold() {
        SetLow.sendKeys("15");
        SetHigh.click();
    }

    public void SetLowThreshold() {
        SetLow.sendKeys("10");
        SetLow.click();
    }

    public void OpenExcessCreditThreshold() {
        ExcessCreditLink.click();
    }

    public boolean AdminToolsHeader() {
        return Header.isDisplayed();
    }
}
