package gradPlanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class RachaelLogin {

	static List<String> Inumbers = Arrays.asList("057804357", "654500007", "254095748");

	public static void main(String[] args) throws IOException {

		RachaelLogin1();
		//RachaelMultiCheck(Inumbers);
	}

	public static void RachaelLogin1() {
		Response response = RestAssured

				.given().header("X-Byui-Api-Key", "LHGGiZaS8QgLV67qp5R3").formParam("username", "EPSQA")
				.formParam("password", "tPX29S9TQhT7mxS2RDCjLPDIA0D65v4p").when()
				.post("https://rachel.byui.edu/Api/Services/Login");

		Cookie byuiFormsCookie = response.getDetailedCookie("BYUIForms");
		System.out.println(
				"Rachael Login Reponse :" + response.getStatusCode() + " Response Body :" + response.asString());
		saveATICookiesToFile("cookies/RachaelBYUIForms.txt", byuiFormsCookie);
	}

	public static void RachaelMultiCheck(List<String> Inumbers) throws IOException {
		Cookie cookie = loadBYUICookieFromFile("cookies\\RachaelBYUIForms.txt");

		for (String Inumber : Inumbers) {
			Response response = RestAssured.given().cookie(cookie.getName(), cookie.getValue())
					.header("X-Byui-Api-Key", "LHGGiZaS8QgLV67qp5R3").contentType("application/json")
					.get("https://rachel.byui.edu/api/AcademicTools/v1/persons/" + Inumber + "/ExtendedDegreeAudit");

			System.out.println("For Inumber: " + Inumber + ", Response: " + response.getStatusCode() + " Body: "
					+ response.getBody().asString());
		}
	}

	public static void saveATICookiesToFile(String filename, Cookie cookie) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			writer.println(cookie.toString());
		} catch (IOException e) {
			System.out.println("Error writing cookie to file: " + e.getMessage());
		}

	}

	public static Cookie loadBYUICookieFromFile(String filename) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String cookieString = reader.readLine();
		String[] parts = cookieString.split("; "); // Split by "; "
		for (String part : parts) {
			String[] pair = part.split("=", 2);
			if (pair.length == 2 && pair[0].equals("BYUIForms")) {
				return new Cookie.Builder(pair[0], pair[1]).build();
			}
		}
		System.out.println("Invalid cookie format in file: " + filename);
		return null;
	}
}
