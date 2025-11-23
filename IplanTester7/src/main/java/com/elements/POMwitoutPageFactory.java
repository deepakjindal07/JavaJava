package com.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class POMwitoutPageFactory {

	WebDriver contr0l;

	//Constructor that will be automatically //called as soon as the object of the class is created
	public POMwitoutPageFactory (WebDriver contr0l) {
		this.contr0l=contr0l;
	}


	public By ByuiLogin = By.xpath("//img[@alt='BYUI Login Button']");

	//Method to click login button
	public void ByuiClickLogin() throws InterruptedException {
		//Thread.sleep(5000);
		contr0l.findElement(ByuiLogin).click();
		Thread.sleep(500);
	}
}

