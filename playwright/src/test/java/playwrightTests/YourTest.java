package playwrightTests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class YourTest {
    @Test
    public void testLogin() throws InterruptedException 
    {
        try (Playwright playwright = Playwright.create()) 
        {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.youtube.com/");
            
            //page.reload();

            //YourPage1 yourPage = new YourPage1(page);
            //yourPage.getUserNameInput().fill("your_username");
            //yourPage.getPasswordInput().fill("your_password");
            //yourPage.getSubmitButton().click();
            Thread.sleep(5000);
            
            //String title = page.title();
            PlaywrightAssertions.assertThat(page).hasTitle("YouTube");

            System.out.println("Seems Okay");

            // ... assertions and other test steps
        }
    }
}