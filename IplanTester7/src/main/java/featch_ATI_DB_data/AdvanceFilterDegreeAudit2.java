package featch_ATI_DB_data;

import java.io.FileReader;
import java.io.IOException;

//import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AdvanceFilterDegreeAudit2 {

    public static void main(String[] args) {
        double totalHoursEarned = 0.0; // Initialize total hours earned outside the loop

        try {
            // Load the JSON file using Gson
            JsonElement jsonElement = JsonParser.parseReader(new FileReader("DegreeAudit.txt"));

            // Check if the root element is an object
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                // Check if the "degreeAudit" object exists
                if (jsonObject.has("degreeAudit") && jsonObject.get("degreeAudit").isJsonObject()) {
                    JsonObject degreeAudit = jsonObject.getAsJsonObject("degreeAudit");

                    // Check if the "subAudits" array exists
                    if (degreeAudit.has("subAudits") && degreeAudit.get("subAudits").isJsonArray()) {
                        JsonArray subAudits = degreeAudit.getAsJsonArray("subAudits");

                        // Iterate over each element in the "subAudits" array
                        for (JsonElement subAuditElement : subAudits) {
                            if (subAuditElement.isJsonObject()) {
                                JsonObject subAudit = subAuditElement.getAsJsonObject();

                                // Check if the "requirements" array exists
                                if (subAudit.has("requirements") && subAudit.get("requirements").isJsonArray()) {
                                    JsonArray requirements = subAudit.getAsJsonArray("requirements");

                                    // Iterate over each requirement in the "requirements" array
                                    for (JsonElement requirementElement : requirements) {
                                        if (requirementElement.isJsonObject()) {
                                            JsonObject requirement = requirementElement.getAsJsonObject();
                                            // Extract and print the key and hoursEarned of each requirement
                                            if (requirement.has("description") && requirement.has("hoursEarned")) {
                                                String description = requirement.get("description").getAsString();
                                                double hoursEarned = requirement.get("hoursEarned").getAsDouble();
                                                System.out.println("Requirement Key: " + description);
                                                System.out.println("Hours Earned: " + hoursEarned);
                                                System.out.println("\n");

                                                // Accumulate hoursEarned to calculate total
                                                totalHoursEarned += hoursEarned;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        // Print the total number of hours earned
                        System.out.println("Total Hours Earned: " + totalHoursEarned);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}