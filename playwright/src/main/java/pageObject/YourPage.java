package pageObject;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class YourPage {
    private final Page page;

    public YourPage(Page page) {
        this.page = page;
    }

    public Locator getUserNameInput() {
        return page.locator("#username");
    }

    public Locator getPasswordInput() {
        return page.locator("#password");
    }

    // ... other page elements and actions
}