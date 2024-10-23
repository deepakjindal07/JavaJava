package naukri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CustCookies {

	    public static void Save(WebDriver driver) throws IOException {
	        Set<Cookie> cookies = driver.manage().getCookies();
	        File file = new File("cookies2.txt");
	        FileWriter fileWriter = new FileWriter(file);

	        for (Cookie cookie : cookies) {
	            // Include the 'expires' attribute in the saved format if it has a value
	            String expires = cookie.getExpiry() != null ? "; expires=" + cookie.getExpiry().toString() : "";
	            fileWriter.write(cookie.getName() + "=" + cookie.getValue() +
	                    expires + "; domain=" + cookie.getDomain() +
	                    "; path=" + cookie.getPath() +
	                    "; secure=" + cookie.isSecure() +
	                    "; sameSite=" + (cookie.getSameSite() != null ? cookie.getSameSite() : "None") + "\n");
	        }

	        fileWriter.close();
	    }

	    public static void Load(WebDriver driver) throws IOException {
	        File file = new File("cookies2.txt");
	        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = bufferedReader.readLine()) != null) {
	            String[] cookieParts = line.split(";");

	            String name = null;
	            String value = null;
	            String domain = null;
	            String path = null;
	            boolean isSecure = false;
	            String sameSite = "None"; // Default value
	            Date expires = null;

	            for (String part : cookieParts) {
	                String[] keyValue = part.split("=", 2);
	                if (keyValue.length == 2) {
	                    String key = keyValue[0].trim();
	                    String val = keyValue[1].trim();

	                    // Set name and value from the first key-value pair
	                    if (name == null && value == null) {
	                        name = key;
	                        value = val;
	                    } else if (key.equalsIgnoreCase("domain")) {
	                        domain = val;
	                    } else if (key.equalsIgnoreCase("path")) {
	                        path = val;
	                    } else if (key.equalsIgnoreCase("secure")) {
	                        isSecure = true; // Set secure if the keyword is present
	                    } else if (key.equalsIgnoreCase("sameSite")) {
	                        sameSite = val; // Set sameSite value
	                    } else if (key.equalsIgnoreCase("expires")) {
	                        // Parse the expires date
	                        try {
	                            expires = new Date(val); // Using the Date constructor
	                        } catch (Exception e) {
	                            // Handle parsing error if needed
	                        }
	                    }
	                }
	            }

	            // Check if all required attributes are present
	            if (name != null && value != null && domain != null && path != null) {
	                // Create and add the cookie
	                Cookie cookie = new Cookie.Builder(name, value)
	                        .domain(domain)
	                        .path(path)
	                        .isSecure(isSecure)
	                        .sameSite(sameSite)
	                        .expiresOn(expires) // Set the expiration date if available
	                        .build();

	                driver.manage().addCookie(cookie);
	            }
	        }

	        bufferedReader.close();
	    }
	}
