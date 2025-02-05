package playwrightTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SimpleScript {

	public static void main(String[] args) throws InterruptedException 
	{
		
		try (Playwright playwright = Playwright.create()) 
		{
			Browser browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://demoqa.com/text-box");

			// Thread.sleep(5000);
			page.locator("xpath=(//li[@id='item-0'])[1]").click();

			System.out.println("IjustClicked");
			page.locator("xpath=//div[@class='col-md-9 col-sm-12']//input[@id='userName']").fill("Hello");
			System.out.println("IjustClicked");

			page.close();

		}
	}

}
