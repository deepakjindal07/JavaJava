package restassuredTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;


public class Postreq {

	public static void main(String[] args) {

		// Set Base URI
		RestAssured.baseURI = "https://reqres.in";

		// Create JSON request body
		String requestBody = "{\n" + "  \"name\": \"morpheus\",\n" + "  \"job\": \"leader\"\n" + "}";

		// Send POST request
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
            .when()
                .post("/api/users")
            .then()
                .statusCode(401)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .extract().response();

		// Print response
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Response Body:\n" + response.getBody().asPrettyString());
	}

}
