//package supportprograms;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v122.performance.Performance;
//import org.openqa.selenium.devtools.v122.performance.model.Metric;
//import org.openqa.selenium.devtools.v122.performancetimeline.PerformanceTimeline;
//
//public class GetMetrics {
//
//    final static String PROJECT_PATH = System.getProperty("user.dir");
//
//    public static void main(String[] args){
//        System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "/src/main/resources/chromedriver");
//        ChromeDriver driver = new ChromeDriver();
////        DevTools devTools = driver.getDevTools();
//        devTools.createSession();
//        devTools.send(PerformanceTimeline.enable(null));
//
//        driver.get("https://www.google.org");
//
//        List<Metric> metrics = devTools.send(Performance.getMetrics());
//        List<String> metricNames = metrics.stream()
//                .map(o -> o.getName())
//                .collect(Collectors.toList());
//
//        devTools.send(Performance.disable());
//
//        List<String> metricsToCheck = Arrays.asList(
//                "Timestamp", "Documents", "Frames", "JSEventListeners",
//                "LayoutObjects", "MediaKeySessions", "Nodes",
//                "Resources", "DomContentLoaded", "NavigationStart");
//
//        metricsToCheck.forEach( metric -> System.out.println(metric +
//                " is : " + metrics.get(metricNames.indexOf(metric)).getValue()));
//    }
//}
