package com.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;

public class Page_EmailTemplates	extends Core {

	WebDriver contr0l;

	// Initializing the Page Objects:
	public Page_EmailTemplates(WebDriver contr0l) {
		this.contr0l = contr0l;
		PageFactory.initElements(contr0l, this);
	}

	@FindBy(xpath = "//h1[normalize-space()='Email Templates']")
	WebElement Headline;


	public boolean CheckHeadlines(){
		return Headline.isDisplayed();
	}

}

