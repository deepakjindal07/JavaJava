package seleniumTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Sel {

	public static void main(String[] args) {
			try (Playwright playwright = Playwright.create())
			{
				Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
				BrowserContext context = browser.newContext();
				Page page = context.newPage();

				page.navigate("https://www.letskodeit.com/practice"); // Replace with actual URL
				page.locator("//button[@id='openwindow']").click();
				//page.
				//page.click("text=OpenWindow"); // Click on element with text "Username"
				//page.click("text=Password"); // Click on element with text "Password"
			}
		}
	

}
