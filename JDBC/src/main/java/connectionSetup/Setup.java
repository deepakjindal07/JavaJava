package connectionSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Setup {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:sqlserver://10.12.2.162:1433;databaseName=EPS_QA_Sirius;encrypt=true;trustServerCertificate=true;";
		String user = "CS_Reader";
		String pass = "R3ad3r";

		//DefaultValue
		String com2 = "select * from EPS_QA.config.tblAppSetting tas where [Key] ='StartMocking'";

		Connection connection = DriverManager.getConnection(url, user, pass);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(com2);

		System.out.println("Connection established");

		int columnCount = resultSet.getMetaData().getColumnCount();
		List<String> results = new ArrayList<>(); // Create an empty list to store results

		while (resultSet.next())
		{
			StringBuilder row = new StringBuilder(); // Use StringBuilder for efficient string concatenation
			for (int i = 1; i <= columnCount; i++)
			{
				
				//resultSet.get
				row.append(resultSet.getString(i));

			}
			results.add(row.toString()); // Add the complete row as a string to the list
			// System.out.println(row); // Print the row for debugging purposes (optional)
		}

		System.out.println(results);

	}

}
