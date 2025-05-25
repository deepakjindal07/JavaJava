package restassured;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CheckAPIStatus {
	public static void main(String[] args) {
		// API endpoint
		String url = "https://epsbyui.atlassian.net/"; // Replace with the actual URL you want to check

		// Sending GET request
		Response response = RestAssured.get(url);

		// Getting the status code
		int statusCode = response.getStatusCode();
		Headers something = response.headers();
		
//		List<Header> head = response.getHeaders().getList(url);
//		
//		System.out.println(head);
		

		// Verifying the response
		if (statusCode == 200)
		{
			System.out.println("PASS: API is up. Status code: " + statusCode);
			System.out.println(something);
		} else
		{
			System.out.println("FAIL: API returned status code " + statusCode);
		}
	}
}
