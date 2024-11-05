package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredExample {
    public static void main(String[] args) {
        // Send a GET request to a sample API endpoint
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        // Get the status code from the response
        int statusCode = response.getStatusCode();

        // Print the status code
        System.out.println("Status Code: " + statusCode);

        // Verify if the status code is 200
        if (statusCode == 200) {
            System.out.println("Request was successful.");
        } else {
            System.out.println("Request failed with status code: " + statusCode);
        }
    }
}
