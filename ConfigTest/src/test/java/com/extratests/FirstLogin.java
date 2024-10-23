package com.extratests;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.setup.Base;
import com.testutils.GPutils;


public class FirstLogin {
	
	public static Properties prop;
    public static void FirstLoginToDashBoard(WebDriver contr0l) throws InterruptedException, IOException {

//        Page_LoginToDashBoard2 Page_DashBoardElement;
//        Page_DashBoardElement = new Page_LoginToDashBoard2(contr0l);
//        Page_DashBoardElement.ByuiLoginButtonTest(); // CAS
//        Page_DashBoardElement.UserNameFieldTest("epsone");
//        Page_DashBoardElement.PasswordFieldTest("eps0n3");
//        Page_DashBoardElement.CASLoginButtonTest();
//        Thread.sleep(8000);
        
        WebElement ByuiLoginButton = contr0l.findElement(By.xpath("//button[@id='casContainer']"));
        // Click the ByuiLoginButton using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) contr0l;
        js.executeScript("arguments[0].click();", ByuiLoginButton);

        // Wait for the UserNameField and interact with it
        WebElement UserNameField = GPutils.waitForElement(contr0l, By.xpath("//input[@id='username']"), 20);
        UserNameField.clear();
        UserNameField.sendKeys("epsone");

        // Locate and interact with the PasswordField
        WebElement PasswordField = contr0l.findElement(By.xpath("//input[@id='password']"));
        PasswordField.clear();
        PasswordField.sendKeys("eps0n3");

        // Locate and interact with the CASLoginButton
        WebElement CASLoginButton = contr0l.findElement(By.xpath("//input[@class='btn-submit']"));
        CASLoginButton.click();
        
        // Get cookies and save them to a temporary file
        Set<Cookie> cookies = contr0l.manage().getCookies();
        GPutils.saveCookiesToFile(cookies); 
    }
}
