package com.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;

public class Page_CourseAvailability	extends Core {

	WebDriver contr0l;

	// Initializing the Page Objects:
	public Page_CourseAvailability(WebDriver contr0l) {
		this.contr0l = contr0l;
		PageFactory.initElements(contr0l, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search Courses']")
	WebElement Searchbox;

	@FindBy(xpath="//a[@class='search-button-link']")
	WebElement MagIcon;

	@FindBy(xpath="//strong[contains(text(),'REL 100')]")
	WebElement courseResult;

	@FindBy(xpath="//div[contains(text(),'Students Planned')]")
	WebElement StudentsPlanned;


	public boolean validateSearchBox(){
		return Searchbox.isDisplayed();
	}

	public void enterCourse(){
		Searchbox.sendKeys("ART 101");
	}

	public void clickSearch(){
		MagIcon.click();
	}

	public void StudentsPlanned(){
		StudentsPlanned.isDisplayed();
	}

	public boolean result() {
		return courseResult.isDisplayed();
	}

}

