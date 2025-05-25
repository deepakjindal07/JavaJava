package playwrightTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Script2 {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright play = Playwright.create();
		
		Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();

		Page pg = context.newPage();

		pg.navigate("https://www.google.com");

		Thread.sleep(10000);

		pg.close();

	}

}
