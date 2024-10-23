import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Connection;

public class JdbDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String host = "localhost";
		String port = "3306";

		//Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root", "root");

		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Qadbt","root","");  
		//here Qabt is database name, root is username and password  
		
		//To create SQL statement
		Statement s = con.createStatement();
		
		//Execute query
		ResultSet rs = s.executeQuery("select * from Employeeinfor");

		while (rs.next()) {
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("id"));
			System.out.println(rs.getString("location"));
			System.out.println(rs.getString("age"));
		}

	}

}
