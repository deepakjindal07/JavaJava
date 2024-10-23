package naukri;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {
	
	public static void saveCookies(WebDriver driver, String domain) {
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getDomain().contains(domain)) {
				System.out.println("Saving cookie: " + cookie.getName() + " = " + cookie.getValue());
			}
		}
	}

	public static void loadCookies(WebDriver driver, String domain) {
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getDomain().contains(domain)) {
				driver.manage().deleteCookie(cookie);
			}
		}

		// Assuming you have a list of cookies to load
		List<Cookie> cookiesToLoad = getCookiesToLoad(domain);

		for (Cookie cookie : cookiesToLoad) {
			driver.manage().addCookie(cookie);
		}
	}

	private static List<Cookie> getCookiesToLoad(String domain) {
		// Implement your logic to retrieve the cookies to load from a database or other
		// source
		List<Cookie> cookiesToLoad = new ArrayList<>();
		// Add cookies to the list
		return cookiesToLoad;
	}

}
