package com.extratests;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Base;
import com.testutils.WebEventListeners;
import com.testutils.ExcelReader;
import java.util.Map;
import java.util.Set;

public class CheckDatabase extends Base {

	@Test
	public void ConfigVerification() throws IOException {
		try {
			// Retrieve data from Excel, assuming you have key-value pairs in the Excel
			// sheet
			Map<String, Object> excelData = ExcelReader.excelReader();

			// Get a set of all keys from the Excel data
			Set<String> keys = excelData.keySet();

			// Iterate through all keys and execute the query for each key
			for (String key : keys) {
				executeQueryForExcelKey(key, excelData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle SQLException appropriately
		}
	}

	private void executeQueryForExcelKey(String key, Map<String, Object> excelData) throws SQLException {
		if (excelData.containsKey(key)) {
			Object verifyValue = excelData.get(key);

			String db = prop.getProperty("db");

			String query = "select * from " + db + ".config.tblAppSetting tas where [Key] ='" + key + "'";
			System.out.println("Database Query: " + query);

			try (ResultSet resultSet = statement.executeQuery(query)) {
				// Log results to Extent Report
				ExtentTest test = WebEventListeners.getExtentTest();

				while (resultSet.next()) {
					// You can customize how you log the data from the database here.
					// For example, you can log it as a string.
					String resultString = resultSet.getString("DefaultValue");
					test.log(Status.INFO, "Result from database for key '" + key + "': " + resultString);

					// Convert the result from the database to a double for comparison
					double resultValue = Double.parseDouble(resultString);

					// Convert the VerifyValue from Excel to double
					double excelValue = Double.parseDouble(String.valueOf(verifyValue));

					// Compare the result from the database with the value from Excel
					if (resultValue == excelValue) {
						System.out.println(
								"Verification Passed: Value from Excel matches a result from the database for key '"
										+ key + "'.");
						test.log(Status.PASS,
								"Verification Passed: Value from Excel matches a result from the database for key '"
										+ key + "'.");
					} else {
						System.out.println(
								"Verification Failed: Value from Excel does not match a result from the database for key '"
										+ key + "'.");
						test.log(Status.FAIL,
								"Verification Failed: Value from Excel does not match a result from the database for key '"
										+ key + "'.");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// Handle SQLException appropriately
			}
		} else {
			System.out.println("Key '" + key + "' not found in Excel data.");
			// Handle the case when the key is not found in Excel
		}
	}
}
