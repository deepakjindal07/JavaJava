//package com.codesetup;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//
//
//public class DevToolsChecker {
//
//	public static void CallStatusCheck(WebDriver contr0l) throws InterruptedException {
//
//		DevTools devTools = ((ChromeDriver) contr0l).getDevTools();
//		devTools.createSession();
//
//		devTools.send(Network.enable(Optional.of(1000000), Optional.of(1000000), Optional.of(1000000)));
//
//		// Add listener to check for XHR responses with status codes 500, 501, 502, 503,
//		devTools.addListener(Network.responseReceived(), responseReceived -> {
//
//			int status = responseReceived.getResponse().getStatus();
//			String url = responseReceived.getResponse().getUrl();
//
//			if (status == 477 || status == 404 ||status == 500 || status == 501 || status == 502 || status == 503 || status == 504) {
//				System.out.println("XHR call to " + url + " returned a " + status + " status code ");
//			}
//		});
//	}
//
//	// Gives call status.
//	public static void Findbreakingcalls(WebDriver contr0l) {
//		DevTools devTools = ((ChromeDriver) contr0l).getDevTools();
//		devTools.createSession();
//
//		// Enable network events
//		devTools.send(Network.enable(Optional.of(1000000), Optional.of(1000000), Optional.of(1000000)));
//
//		devTools.addListener(Network.responseReceived(), responseReceived -> {
//			String url = responseReceived.getResponse().getUrl();
//
//			List<String> callsToCheck = Arrays.asList("GetAndUpdateDegreeAuditFromATIAsync", "GetStudentGradPlanReport",
//					"GetAllGradPlansWithComponents", "GetAllGradPlansWithComponents", "GetHistoriedPlanForStudent",
//					"UpdateSubAuditAndElectiveCredits", "PlanSelectedCourseByStudent", "FetchBestMatchingMajors",
//					"GetStudentGradPlan", "GetCurrentMajorGRTRules");
//
//			String responseFileName = "report/CallTimeresponse.txt"; // File name for saving response data
//			boolean responseCaptured = false; // Flag to track if response has been captured
//
//			for (String call : callsToCheck) {
//				if (url.contains(call) && !responseCaptured) {
//					// Get response details
//					String requestUrl = url;
//					int status = responseReceived.getResponse().getStatus();
//
//					System.out.println("URL: " + requestUrl);
//					System.out.println("Status: " + status);
//
//					// Save response data to file
//					CommonUtils.saveResultToFile(responseFileName, requestUrl + " " + status);
//
//					// Set the flag to true to indicate that the response has been captured
//					responseCaptured = true;
//					// Exit the loop after capturing the first response
//					break;
//				}
//			}
//		});
//	}
//
//	// Performance is not acurate..
//	public static void analyzePerformance3(WebDriver contr0l) {
//		DevTools devTools = ((ChromeDriver) contr0l).getDevTools();
//		devTools.createSession();
//
//		// Enable network events
//		devTools.send(Network.enable(Optional.of(1000000), Optional.of(1000000), Optional.of(1000000)));
//
//		// Enable performance monitoring
//		devTools.send(Performance.enable(Optional.empty()));
//
//		devTools.addListener(Network.responseReceived(), responseReceived -> {
//
//			String url = responseReceived.getResponse().getUrl();
//			int status = responseReceived.getResponse().getStatus();
//
//			List<String> callsToCheck = Arrays.asList("GetAndUpdateDegreeAuditFromATIAsync", "GetStudentGradPlanReport",
//					"GetAllGradPlansWithComponents", "GetAllGradPlansWithComponents", "GetHistoriedPlanForStudent",
//					"UpdateSubAuditAndElectiveCredits", "PlanSelectedCourseByStudent", "FetchBestMatchingMajors",
//					"GetStudentGradPlan");
//
//			// Check if the URL matches any of the calls to check
//			if (callsToCheck.stream().anyMatch(url::contains)) {
//
//				// Get the DevToolsCommandDuration metric value
//				Optional<Metric> ProcessTimeMetric = devTools.send(Performance.getMetrics()).stream()
//						.filter(metric -> metric.getName().equals("ProcessTime")).findFirst();
//
//				// Check if the DevToolsCommandDuration metric is present
//				ProcessTimeMetric.ifPresent(metric -> {
//					Number devToolsCommandDurationValue = metric.getValue();
//					double devToolsCommandDurationSeconds = devToolsCommandDurationValue.doubleValue();
//
//					// Print the URL, status, and DevToolsCommandDuration time in seconds
//					System.out.println("URL: " + url);
//					System.out.println("Status: " + status);
//					System.out.println("PerformanceTime: " + devToolsCommandDurationSeconds);
//				});
//			}
//		});
//	}
//
//	public static void check2(WebDriver contr0l) {
//
//		try {
//			// Create a DevTools session
//			DevTools devTools = ((ChromeDriver) contr0l).getDevTools();
//			devTools.createSession();
//
//			// Enable network events
//			devTools.send(org.openqa.selenium.devtools.v85.network.Network.enable(Optional.of(1000000),
//					Optional.of(1000000), Optional.of(1000000)));
//
//			// Add listener to check for XHR responses
//			devTools.addListener(org.openqa.selenium.devtools.v85.network.Network.responseReceived(),
//					responseReceived -> {
//						int status = responseReceived.getResponse().getStatus();
//						String url = responseReceived.getResponse().getUrl();
//						if (status == 200 || status == 501 || status == 502 || status == 503 || status == 504) {
//							System.out.println("XHR call to " + url + " returned a " + status + " status code.");
//						}
//					});
//		} catch (Exception e) {
//			System.out.println("Error initializing DevTools: " + e.getMessage());
//			// Handle the exception as needed
//		}
//	}
//}
