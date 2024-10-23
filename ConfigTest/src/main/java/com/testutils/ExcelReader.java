package com.testutils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

	public static Map<String, Object> excelReader() throws IOException {
		String filePath = "src/main/resources/ConfigValues.xlsx"; // Replace with the path to your Excel (.xlsx) file

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet

			Map<String, Object> cellValues = new HashMap<>();

			// Iterate through rows
			for (Row row : sheet) {
				Cell cellA = row.getCell(0); // Column A (Key)
				Cell cellB = row.getCell(1); // Column B (Value)

				if (cellA != null && cellB != null) {
					// Read key as a string
					String key = cellA.getStringCellValue();

					// Check the cell's data type and add the value to the map
					Object value;
					switch (cellB.getCellType()) {
					case STRING:
						value = cellB.getStringCellValue();
						break;
					case NUMERIC:
						value = cellB.getNumericCellValue();
						break;
					case BOOLEAN:
						value = cellB.getBooleanCellValue();
						break;
					case BLANK:
						// Handle empty cells if needed
						value = "";
						break;
					default:
						// Handle other cell types if necessary
						value = "";
						break;
					}

					// Add the key-value pair to the map
					cellValues.put(key, value);
				}
			}

			return cellValues;
		} catch (IOException e) {
			e.printStackTrace();
			// Handle IOException appropriately
			return Collections.emptyMap(); // Return an empty map in case of an error
		}
	}
}
