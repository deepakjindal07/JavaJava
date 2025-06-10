package restassuredTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Getrequest {

	public static void main(String[] args) {

		// Set Base URI
		RestAssured.baseURI = "https://reqres.in";

		// Send GET request
		Response response = RestAssured.given().header("x-api-key", "reqres-free-v1")
				// .queryParam("page", "2")
				.when()

				.get("/api/unknown").then()
				// .assertThat()
				// .statusCode(200)
				// .contentType("application/json; charset=utf-8")
				.extract().response();

		// Print status code and full response body
		System.out.println("Status Code: " + response.getStatusCode());
		//System.out.println("Response Body:\n" + response.getBody().asPrettyString());

		String firstUser = response.jsonPath().getString("data[0].name");
		
		// Parse JSON to extract a specific field
		//JsonPath jsonPath = response.jsonPath();
		//String firstUser = jsonPath.getString("data[0].first_name");
		System.out.println("First User's Name on Page 2: " + firstUser);
	}

//	@Test
//	public static void first() {
//		//
//		RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200);
//
//	}

}
