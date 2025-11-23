package featch_ATI_DB_data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class FilterDegreeAudit {

	// FilterDegreeAudit(){}

	public static List<String> FindMajor(String inumber) {
		List<String> keyValues = new ArrayList<>();
		// Path to the JSON file
		// String filePath = "DegreeAudit.txt";

		// Create a Gson instance
		// Gson gson = new Gson();

		try (FileReader reader = new FileReader("DegreeAudits\\" + inumber + ".txt")) {
			// Parse the JSON file
			JsonElement rootElement = JsonParser.parseReader(reader);

			// Get the "degreeAudit" object
			JsonObject degreeAudit = rootElement.getAsJsonObject().getAsJsonObject("degreeAudit");
			if (degreeAudit != null) {
				// Get the "subAudit" array
				JsonArray subAuditArray = degreeAudit.getAsJsonArray("subAudits");
				if (subAuditArray != null) {
					// Iterate over the elements in the "subAudit" array
					for (JsonElement subAuditElement : subAuditArray) {
						// Check if the element is a JsonObject
						if (subAuditElement.isJsonObject()) {
							JsonObject subAudit = subAuditElement.getAsJsonObject();
							// Get the "key" value and print it
							JsonElement keyElement = subAudit.get("key");
							if (keyElement != null && keyElement.isJsonPrimitive()) {
								String keyValue = keyElement.getAsString();
								// System.out.println("Key: " + keyValue);

								// List<String> keyValues = new ArrayList<>();
								keyValues.add(keyValue);

								// return keyValues;
							} else {
								System.out.println("No 'key' found in subAudit object");
							}
						}
					}
				} else {
					System.out.println("No 'subAudit' array found");
				}
			} else {
				System.out.println("No 'degreeAudit' object found");
			}
		} catch (IOException e) {
			System.err.println("Error reading JSON file: " + e.getMessage());
		}

		// System.out.println("KV"+keyValues);
		return keyValues;

	}
}