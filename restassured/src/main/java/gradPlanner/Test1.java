package gradPlanner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Test1 {

	@Test
	public void testGetUser() {
		given()
			.baseUri("https://reqres.in") //use authentication for 200 
			.header("Content-Type", "application/json")
		    .param("page", 2)
		.when()
			.get("/api/users/2")
		.then()
			.statusCode(401).body("data.id",	equalTo(2));
			
	}

}
