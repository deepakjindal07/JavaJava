//package supportprograms;
//
//import java.util.Optional;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v122.network.Network;
//import org.openqa.selenium.devtools.v122.network.model.Request;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class XhrList {
//
//    public static void main(String[] args) {
//        // Setup WebDriver
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        // Create a DevTools session
//        DevTools devTools = ((ChromeDriver) driver).getDevTools();
//        devTools.createSession();
//
//        // Enable network events
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//        // Add listener to capture network requests
//        devTools.addListener(Network.requestWillBeSent(), event -> {
//            Request request = event.getRequest();
//            String url = request.getUrl();
//            //String url = request.get
//
//            // Check if it's an XHR request
//            if ("xmlhttprequest".equals(request.getUrl())) {
//                System.out.println("XHR request URL: " + url);
//            } else {
//                System.out.println("Other request URL: " + url);
//            }
//        });
//
//        // Navigate to a webpage
//        driver.get("https://makemytrip.com");
//
//        // Wait for some time to capture XHR requests
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Quit the driver
//        driver.quit();
//    }
//}
