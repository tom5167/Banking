package BankingSystemDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	Connection conn = null;

	public static Connection jdbcConnection() {
		final String DB_URL = "jdbc:mysql://localhost/bankdb";
		final String USERNAME = "root";
		final String PASSWORD = "password";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
