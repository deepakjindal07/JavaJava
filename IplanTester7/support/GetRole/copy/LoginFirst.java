package GetRole.copy;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class LoginFirst {

	public static void main(String[] args) throws IOException {
		//System.out.println("Login BYUi API.. ");
		RachaelLogin();
		//StageLogin();
		//ProdLogin();
		//getResponseBody1();
		//getResponseBodies(Inumbers);
	}
	public static void RachaelLogin() {
		Response response = RestAssured.given().header("X-Byui-Api-Key", "LHGGiZaS8QgLV67qp5R3")
				.formParam("username", "EPSQA").formParam("password", "tPX29S9TQhT7mxS2RDCjLPDIA0D65v4p").when()
				.post("https://rachel.byui.edu/Api/Services/Login");

		Cookie byuiFormsCookie = response.getDetailedCookie("BYUIForms");
		System.out.println(
				"Rachael Login Reponse :" + response.getStatusCode() + " Response Body :" + response.asString());
		saveATICookiesToFile("cookies/RachaelBYUIForms.txt", byuiFormsCookie);
	}

	public static void saveATICookiesToFile(String filename, Cookie cookie) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			writer.println(cookie.toString());
		} catch (IOException e) {
			System.out.println("Error writing cookie to file: " + e.getMessage());
		}
	}

	private static void ProdLogin() {
		Response response = RestAssured.given().header("X-Byui-Api-Key", "ZE8Cy98vtxRaBFxgBLW8")
				.formParam("username", "EPS").formParam("password", "tLgYMrFcivj9wFHAPqsr7NKYU93c37AH").when()
				.post("https://web.byui.edu/api/Services/Login");

		Cookie byuiFormsCookie = response.getDetailedCookie("BYUIForms");
		System.out
				.println("Prod Login Reponse :" + response.getStatusCode() + " Response Body :" + response.asString());
		saveATICookiesToFile("cookies/ProdBYUIForms.txt", byuiFormsCookie);

	}

	private static void StageLogin() {
		Response response = RestAssured.given().header("X-Byui-Api-Key", "LHGGiZaS8QgLV67qp5R3")
				.formParam("username", "EPS").formParam("password", "tLgYMrFcivj9wFHAPqsr7NKYU93c37AH").when()
				.post("https://rachel.byui.edu/Api/Services/Login");

		Cookie byuiFormsCookie = response.getDetailedCookie("BYUIForms");
		System.out
				.println("Stage Login Reponse :" + response.getStatusCode() + " Response Body :" + response.asString());
		saveATICookiesToFile("cookies/StageBYUIForms.txt", byuiFormsCookie);

	}


//	static List<String> Inumbers = Arrays.asList("329926509", "436322418", "208100681", "859877629", "924955425",
//			"817177642", "302520417", "424720118", "959547610", "588071928", "629901532", "544337980", "046938231",
//			"413481013");

}
