package GetRole.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class SubAuditinATI {
	//public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//System.out.println("Check DA response");

		//RachaelCheck1("926892689");
		//RachaelMultiCheck(Inumbers);

		//FilterDegreeAudit.FindMajor("164694346");
	//}

	public static List<String> RachaelCheck1(String inumber) throws IOException {
		Cookie cookie = loadBYUICookieFromFile("cookies\\RachaelBYUIForms.txt");
		Response response = RestAssured.given().cookie(cookie.getName(), cookie.getValue())
				.header("X-Byui-Api-Key", "LHGGiZaS8QgLV67qp5R3").contentType("application/json")
				.get("https://rachel.byui.edu/api/AcademicTools/v1/persons/" + inumber + "/ExtendedDegreeAudit");

		// System.out.println("Response: " + response.getStatusCode() + " Body: " +
		// response.getBody().asString());
		String DAresponse = response.getBody().asString();

		// Write to file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("DegreeAudits/" + inumber + ".txt"))) {
			writer.write(DAresponse);
			System.out.println("[Passed] DA Successfully Saved.");
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}

		// Find Subaudits from the saved DA
		return FilterDAJson.FindMajor(inumber);
	}

	public static void RachaelMultiCheck(List<String> Inumbers) throws IOException {
		Cookie cookie = loadBYUICookieFromFile("cookies\\RachaelBYUIForms.txt");

		for (String Inumber : Inumbers) {
			Response response = RestAssured.given().cookie(cookie.getName(), cookie.getValue())
					.header("X-Byui-Api-Key", "LHGGiZaS8QgLV67qp5R3").contentType("application/json")
					.get("https://rachel.byui.edu/api/AcademicTools/v1/persons/" + Inumber + "/ExtendedDegreeAudit");

			//System.out.println("For Inumber: " + Inumber + ", Response: " + response.getStatusCode() + " Body: "+ response.getBody().asString());
			System.out.println("For Inumber: " + Inumber + ", Response: " + response.getStatusCode());
			String DAresponse = response.getBody().asString();


			// Write to file
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("DegreeAudits/" + Inumber + ".txt"))) {
				writer.write(DAresponse);
				System.out.println("[Passed] Successfully Saved.");
			} catch (IOException e) {
				System.err.println("Error writing to file: " + e.getMessage());
			}

			FilterDAJson.FindMajor(Inumber);
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

	static List<String> Inumbers = Arrays.asList("164694346", "166798478", "216074249");

}
