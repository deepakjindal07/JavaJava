package seleniumTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLinksTest {
	public static void main(String[] args) throws IOException, URISyntaxException {
		// Update your system's path, where Chromedriver.exe is present
		// System.setProperty("webdriver.chrome.driver", "D:\\mydir\\chromedriver.exe");

		// Initialize Webdriver Object
		WebDriver driver = new EdgeDriver();
		driver.get("https://phptravels.com/demo/");

		// Store all link elements (anchor tag elements in html) in a list
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		// Print no. of links stored in list
		for (int i = 1; i <= links.size()-1; i = i + 1) {
			// Print text of all the links

			if (!links.get(i).getText().equals("") && (links.get(i)).getAttribute("href").contains("//phptravels.c")) {

				System.out.println((links.get(i)).getText());
				System.out.println((links.get(i)).getAttribute("href"));
			}

			// Get href attribute
			WebElement elem = links.get(i);
			String linkUrl = elem.getAttribute("href");

			// Call Verify Links method
			//verifyLinks(linkUrl);

		}

		// Close WebDriver
		driver.quit();
	}

	public static void verifyLinks(String websiteLink) throws IOException, URISyntaxException {

		URI uri = new URI(websiteLink);

		if (!uri.toString().startsWith("javascript:")) {
			URL url = uri.toURL();

			if (url.getProtocol().equalsIgnoreCase("http") || url.getProtocol().equalsIgnoreCase("https")) {
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(5000);
				connection.connect();

				// Verify Response code
				if (connection.getResponseCode() >= 400) {
					System.out.println(websiteLink + " - " + connection.getResponseMessage() + "is a broken link");
				}
				// Fetching and Printing the response code obtained
				else {
					System.out.println(websiteLink + " - " + connection.getResponseMessage());
				}

				// Disconnect URL Connection
				connection.disconnect();
			}
		}
	}
}
