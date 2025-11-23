package featch_ATI_DB_data;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;


import com.codesetup.CommonUtils;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

	

public class ATI_CheckSubauditFromATI {
	
	static Properties prop;
	
	public static void main(String[] args) throws IOException, SQLException {
		// String student = "025391916";
		
		prop = CommonUtils.loadProperties();

		for (String number : Inumbers) {

			System.out.println("Checking Subaudits in DA from BYUi ATI");
			List<String> rachaelATIResults = RachaelCheck1(number);
			// System.out.println(rachaelATIResults);
			// RachaelMultiCheck(Inumbers);
			// FilterDegreeAudit.FindMajor("164694346");
			List<String> rachaelDBResults = DataBaseCheck.DB_check(number);
			// System.out.println(rachaelDBResults);

			System.out.println();
			System.out.println("Checking Inumber: " + number);

			if (compareList(rachaelATIResults, rachaelDBResults)) {

				System.out.println("Inumber Updated - EqualSubAudits");
				
			} else {
				System.out.println("Inumber not uptodate - Difference Subaudit");
			}

		}
	}

	private static boolean compareList(List<String> rachaelATIResults, List<String> rachaelDBResults) {
		Set<String> set1 = new HashSet<>(rachaelATIResults);
		Set<String> set2 = new HashSet<>(rachaelDBResults);

		// Remove elements containing "UNVBCH" or "UPDBCH"
		set1.removeIf(element -> element.contains("UNVBCH") || element.contains("UPDBCH"));
		// set2.removeIf(element -> element.contains("UNVBCH") ||
		// element.contains("UPDBCH"));

		// Check if the remaining elements in both sets are equal
		System.out.println("BYUi  : " + set1);
		System.out.println("CoreDB: " + set2);
		
		boolean areEqual = set1.equals(set2);
	    if (areEqual) {
			String result = set2.toString();
			System.out.println("Result is:  "+result);
			CommonUtils.saveResultToFile("report/UpdatedSubaudits" + prop.getProperty("env") + ".txt", result);
		}

		return areEqual;
	}

	public static List<String> RachaelCheck1(String Inumber) throws IOException {
		Cookie cookie = loadBYUICookieFromFile("cookies\\RachaelBYUIForms.txt");
		Response response = RestAssured.given().cookie(cookie.getName(), cookie.getValue())
				.header("X-Byui-Api-Key", "LHGGiZaS8QgLV67qp5R3").contentType("application/json")
				.get("https://rachel.byui.edu/api/AcademicTools/v1/persons/" + Inumber + "/ExtendedDegreeAudit");

		// System.out.println("Response: " + response.getStatusCode() + " Body: " +
		// response.getBody().asString());
		String DAresponse = response.getBody().asString();

		// Write to file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("DegreeAudits/" + Inumber + ".txt"))) {
			writer.write(DAresponse);
			System.out.println("DA Successfully as file.");
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}

		// Find Subaudits from the saved DA

		return FilterDegreeAudit.FindMajor(Inumber);
	}

	public static void RachaelMultiCheck(List<String> Inumbers) throws IOException {
		Cookie cookie = loadBYUICookieFromFile("cookies\\RachaelBYUIForms.txt");

		for (String Inumber : Inumbers) {
			Response response = RestAssured.given().cookie(cookie.getName(), cookie.getValue())
					.header("X-Byui-Api-Key", "LHGGiZaS8QgLV67qp5R3").contentType("application/json")
					.get("https://rachel.byui.edu/api/AcademicTools/v1/persons/" + Inumber + "/ExtendedDegreeAudit");

			// System.out.println("For Inumber: " + Inumber + ", Response: " +
			// response.getStatusCode() + " Body: "+ response.getBody().asString());
			System.out.println("For Inumber: " + Inumber + ", Response: " + response.getStatusCode());
			String DAresponse = response.getBody().asString();

			// Write to file
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("DegreeAudits/" + Inumber + ".txt"))) {
				writer.write(DAresponse);
				System.out.println("[Passed] Successfully Saved.");
			} catch (IOException e) {
				System.err.println("Error writing to file: " + e.getMessage());
			}

			FilterDegreeAudit.FindMajor(Inumber);
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

	static List<String> Inumbers = Arrays.asList("880723436", "936839047", "163966974", "788645116", "795635479", "131776269", "357792858", "561646466", "772971499", "815697327", "231049736", "325846929", "517015507", "006408087", "955681123", "840334875", "114299514", "288960700", "575126334", "283703963", "718808460", "907768370", "639550174", "074426892", "606993414", "538119969", "011538648", "830752192", "088846176", "030256092", "492286654", "764279446", "984869763", "401420020", "169135806", "362741932", "362950917");

}
