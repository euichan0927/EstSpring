package helloworld.hellospring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class SimpleJdbcTest {
	static final String DB_URL = "jdbc:mysql://localhost:11802/test";
	//static final String DB_URL = "jdbc:mysql://127.0.0.1:11802/test"; // ==> localhost == 127.0.0.1
	static final String USER = "root";
	static final String PASS = "root";
	static final String QUERY = "SELECT * FROM student";

	public static void main(String[] args) {
		// Open & get a connection
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(QUERY);) {
			// Extract data from result set after execute query
			while (rs.next()) {
				// Retrieve by column name
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(", name: " + rs.getString("name")+"\n");

			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
