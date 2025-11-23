//package supportprograms;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v122.performance.Performance;
//import org.openqa.selenium.devtools.v122.performance.model.Metric;
//
//public class CodekruTest {
//
//    public static void main(String[] args) {
//
//        // pass the path of the chromedriver location in the second argument
//        System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\selenium-java\\chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
//
//        DevTools devTools = driver.getDevTools();
//        devTools.createSession();
//
//        devTools.send(Performance.enable(Optional.empty()));
//        List<Metric> metricList = devTools.send(Performance.getMetrics());
//
//        driver.get("https://www.makemytrip.com");
//
//        for (Metric m : metricList) {
//            System.out.println(m.getName() + " = " + m.getValue());
//        }
//
//    }
//
//}
