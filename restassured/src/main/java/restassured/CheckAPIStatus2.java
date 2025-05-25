package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CheckAPIStatus2 {

//	public static void main(String[] args) {
//		try
//		{
//			RestAssured.given().when().get("https://epsb1yui.atlassian.net").then()
//					.statusCode(200); // Validate status code
//
//			System.out.println("✅ PASS: API returned status 200.");
//		} catch (AssertionError e)
//		{
//			System.out.println("❌ FAIL: API did not return status 200.");
//			e.printStackTrace(); // Print error details for debugging
//		}

		// testAPIStatusCode();
		//EntireResponse();
//	}

	@Test
	public static void EntireResponse() {

		//RestAssured.given().when().get("https://sirius-qa.excelindia.com/").then().statusCode(200).log().all();
	}
	
	

	@Test
	public static void testAPIStatusCode() {
//		Response response = RestAssured.get("https://epsbyui.atlassian.net");
//		int statusCode = response.getStatusCode();
//
//		System.out.println("Response Status Code: " + statusCode);
//
//		// Assert to validate the response
//		Assert.assertEquals(statusCode, 200, "❌ FAIL: API did not return status 200.");
//
//		System.out.println("✅ PASS: API returned status 200.");

		RestAssured.given().when().get("https://sirius-qa.excelindia.com/").then().statusCode(200); // Validate status code
		
		RestAssured.given().when().get("https://sirius-qa.excelindia.com/enterprisev2/#/admin/excelsoft/login").then().statusCode(200); 
		
		//RestAssured.given().
	}

}
