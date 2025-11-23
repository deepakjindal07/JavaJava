package com.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codesetup.Core;

public class Page_SubAuditErrorReport	extends Core {

	WebDriver contr0l;

	// Initializing the Page Objects:
	public Page_SubAuditErrorReport(WebDriver contr0l) {
		this.contr0l = contr0l;
		PageFactory.initElements(contr0l, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Sub-Audit Error Report')]")
	WebElement button;

	public boolean headerTest() {
		return button.isDisplayed();
	}

}

