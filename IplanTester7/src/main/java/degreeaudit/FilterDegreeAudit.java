package degreeaudit;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FilterDegreeAudit {

	public static List<String> FindMajor(String Inumber) {

		List<String> keyList = new ArrayList<>();
        //String filePath = "DegreeAudit.txt";
        try (FileReader reader = new FileReader("DegreeAudits\\"+Inumber+".txt")) {
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
                                keyList.add(keyValue);

                                //System.out.println("Key: " + keyValue);
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
        return keyList;
    }
}