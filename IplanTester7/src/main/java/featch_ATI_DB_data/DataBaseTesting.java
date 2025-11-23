package featch_ATI_DB_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseTesting {

	private static final String DB_URL = "jdbc:sqlserver://10.12.2.162:1433;databaseName=EPS_QA_Sirius;encrypt=true;trustServerCertificate=true;";
	private static final String USER = "CS_Reader";
	private static final String PASSWORD = "R3ad3r";

	public static List<String> executeQuery(String query) {

		List<String> results = new ArrayList<>(); // Create an empty list to store results

		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {

//			while (resultSet.next()) {
//				int status = resultSet.getInt(1);
//				System.out.println(status);
//			}

			int columnCount = resultSet.getMetaData().getColumnCount();

			while (resultSet.next()) {
				StringBuilder row = new StringBuilder(); // Use StringBuilder for efficient string concatenation
				for (int i = 1; i <= columnCount; i++) {
					row.append(resultSet.getString(i));
					if (i < columnCount) {
						row.append(", ");
					}
				}
				results.add(row.toString()); // Add the complete row as a string to the list
				// System.out.println(row); // Print the row for debugging purposes (optional)
			}

		} catch (SQLException e) {
			e.printStackTrace(); // Handle or log the exception as needed
		}
		return results;
	}

	public static void DB(String comx) throws SQLException {
		final String user = "CS_Reader";
		final String pass = "R3ad3r";
		Connection exl = null;
		Statement stmt = null;

		try {
			// Open a connection
			exl = DriverManager.getConnection(DB_URL, user, pass);

			// Execute a query
			stmt = exl.createStatement();

			// Select DefaultValue from config.tblAppSetting tas where [Key] ='StartMocking'
			String command1 = comx;

			ResultSet result = stmt.executeQuery(command1);

			// Extract Data
			while (result.next()) {
				int status = result.getInt(1);
				System.out.println(status);
			}
		} finally {
			// Close resources in a finally block to ensure they are closed even if an
			// exception occurs
			if (stmt != null) {
				stmt.close();
			}
			if (exl != null) {
				exl.close();
			}
		}
	}
}
