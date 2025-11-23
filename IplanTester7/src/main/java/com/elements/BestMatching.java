package com.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;

public class BestMatching	extends Core {

	WebDriver contr0l;
	// Initializing the Page Objects:
	public BestMatching(WebDriver contr0l) {
		this.contr0l = contr0l;
		PageFactory.initElements(contr0l, this);
	}

	@FindBy(xpath = "//textarea[@placeholder='Search by iNumbers ...']")
	WebElement Searchbox;

	@FindBy(xpath ="(//span[@class='mat-checkbox-inner-container'])[4]")
	WebElement Bachelor;

	@FindBy(xpath ="(//span[@class='mat-checkbox-inner-container'])[5]")
	WebElement Declared;


	@FindBy(xpath="//input[@name='email']")
	WebElement emailbox;

	@FindBy(xpath="//button[@class='mat-focus-indicator mt-x mat-raised-button mat-button-base']")
	WebElement ApplyFilter;


	public boolean validateSearchBox(){
		return Searchbox.isDisplayed();
	}

	public void EnterInumberInSearchBox(String Inumber){
		Searchbox.sendKeys(Inumber);
	}

	public void BachelorBoxClick () {
		Bachelor.click();
	}

	public void DeclaredBoxClick () {
		Declared.click();
	}

	public void emailbox () {
		emailbox.sendKeys("deepak.jindal@excelindia.com");
	}

	public void ApplyFilterClick() throws InterruptedException {
		Thread.sleep(2000);
		ApplyFilter.click();
	}

	public boolean IsApplyFilterDisplayed() {
		return ApplyFilter.isDisplayed();
	}
}

