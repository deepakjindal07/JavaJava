package com.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;

public class Page_ClassSchedule extends Core {

	WebDriver contr0l;

	public Page_ClassSchedule(WebDriver contr0l) {
		this.contr0l = contr0l;
		PageFactory.initElements(contr0l, this);
	}


	@FindBy(xpath = "//span[normalize-space()='View & Add 2nd Block']")
	WebElement ViewAddBlockButton;


	@FindBy (xpath = "//span[normalize-space()='Plan & Register']" )
	WebElement PlanRegisterButton ;

	@FindBy (xpath ="//body[1]/app-root[1]/div[1]/div[1]/div[1]/app-home-parent-screen[1]/div[1]/div[2]/app-home-prev-sem-view[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/a[1]")
	WebElement PrevSemester;

	@FindBy (xpath ="//div[@class='back-btn']//a[contains(text(),'Home')]")
	WebElement HomeButton;



	public boolean isViewAddBlockButtonVisible(){
		//GPutils.waitForElement(contr0l, ViewAddBlockButton, 30);
		return ViewAddBlockButton.isDisplayed();
	}

	public void ViewAddBlockButtonCheck(){
		ViewAddBlockButton.click();
	}

	public void PlanRegisterButtonCheck(){
		PlanRegisterButton.click();
	}

	public void PrevSemesterCheck(){
		PrevSemester.click();
	}

	public void HomeButtonCheck(){
		HomeButton.click();
	}


//	public void XXX() {
//		XXX.sendKeys("TestMessage");
//	}
//
//
//	public void XXX() {
//		Actions action = new Actions(contr0l);
//		action.sendKeys(Keys.ESCAPE).build().perform();
//		//contr0l.sendKeys(Keys.ESCAPE); // Close
//	}
//
//
//	public boolean XXX(){
//		GPutils.waitForElement(contr0l, XXX, 20);
//		return XXX.isDisplayed();
//	}

}

