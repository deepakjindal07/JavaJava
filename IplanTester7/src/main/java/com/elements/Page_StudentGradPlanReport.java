package com.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;

public class Page_StudentGradPlanReport	extends Core {

	WebDriver contr0l;

	// Initializing the Page Objects:
	public Page_StudentGradPlanReport(WebDriver contr0l) {
		this.contr0l = contr0l;
		PageFactory.initElements(contr0l, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Student Grad Plan Report')]")
	WebElement Header;


	public boolean CheckHeadlines() {
		return Header.isDisplayed();
	}

}

