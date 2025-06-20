package restassuredTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;


public class Postreq {

	public static void main(String[] args) {

		// Set Base URI
		RestAssured.baseURI = "https://reqres.in";

		// Create JSON request body
		String requestBody = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";

		// Send POST request
        Response response = RestAssured.given()
               // .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1").body(requestBody)
            .when()
                .post("/api/users")
            .then()
                .statusCode(201)
                //.body("name", equalTo("morpheus"))
               // .body("job", equalTo("leader"))
                .extract().response();

		// Print response
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body:\n" + response.getBody().asPrettyString());
	}

}
