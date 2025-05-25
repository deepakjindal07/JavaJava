package playwrightTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SimpleScript {

	public static void main(String[] args) throws InterruptedException {
		try (Playwright playwright = Playwright.create())
		{
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			// .firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page1 = context.newPage();
			page1.navigate("https://example.com");
			System.out.println("Opened Tab 1");

			// Open a new tab
			Page page2 = context.newPage();
			page2.navigate("https://demoqa.com");
			System.out.println("Opened Tab 2");

			// Get all open tabs (pages)
			for (Page p : context.pages())
			{
				System.out.println("Tab URL: " + p.url());
			}

			page1.close();
			page2.close();
			browser.close(); // Good practice to close the browser as well
		}
	}
}
