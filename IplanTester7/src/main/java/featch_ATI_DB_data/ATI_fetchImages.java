package featch_ATI_DB_data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class ATI_fetchImages {
	public static void main(String[] args) throws IOException {
		System.out.println("Get Student Images");
		// RachaelCheck1("164694346");
		GetPhotos(Inumbers);
		// FilterDegreeAudit.FindMajor("164694346");
	}

	public static void GetPhotos(List<String> Inumbers) throws IOException {
		Cookie cookie = loadBYUICookieFromFile("cookies\\RachaelBYUIForms.txt");

		for (String Inumber : Inumbers) {

			String CurrentInumberFileName = "StudentsPhotos\\" + Inumber + ".jpg";
			System.out.println(CurrentInumberFileName);
			File file = new File(CurrentInumberFileName);

			if (file.exists()) {

				//System.out.println(CurrentInumberFileName);
				// Code to exit the loop and switch to next Inumber
				System.out.println("File " + CurrentInumberFileName + " exists. Moving to the next Inumber.");
				// Assuming you're in a loop, use continue to go to the next iteration.
				// Replace `loop` with the actual loop control variable or mechanism
				continue; // This exits the current method, which is equivalent to continuing in this
						// context.
			} else {

				Response response = RestAssured.given().cookie(cookie.getName(), cookie.getValue())
						.header("X-Byui-Api-Key", "LHGGiZaS8QgLV67qp5R3").contentType("application/json")
						.get("https://rachel.byui.edu/api/AcademicTools/v1/persons/" + Inumber + "/photo");

				// System.out.println("For Inumber: " + Inumber + ", Response: " +
				// response.getStatusCode() + " Body: "+ response.getBody().asString());
				System.out.println("For Inumber: " + Inumber + ", Response: " + response.getStatusCode());
				byte[] imageBytes = response.getBody().asByteArray();

				// Save the byte array to a file
				try (FileOutputStream fos = new FileOutputStream(new File("StudentsPhotos/" + Inumber + ".jpg"))) {
					fos.write(imageBytes);
					System.out.println("Image saved successfully");
				} catch (IOException e) {
					System.err.println("Error saving the image: " + e.getMessage());
				}
			}
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

	static List<String> Inumbers = Arrays.asList("680064217", "364035622", "538843665", "816856953", "788645116",
			"936839047", "285824363", "325846929", "517015507", "401420020", "955681123", "621574774", "203939197",
			"190140601", "867426148", "042740771", "013870044", "591949515", "977553502", "941492656", "162755009",
			"830752192", "984869763", "797667150", "718808460", "595524975", "566668592", "254095748", "601501808",
			"122071980", "954785518", "907768370", "705258268", "839487921", "294782133", "361824758", "257931411",
			"899470712", "567334785", "913202723", "694833527", "169135806", "717267280", "360801375", "661596848",
			"662547419", "455910506", "259549922", "075816783", "193659059", "284334676", "090478622", "595869516",
			"582304407", "389722569", "784162553", "654500007", "632398771", "166798478", "694682314", "242249488",
			"552372675", "025391916", "648562569", "102139399");

}
