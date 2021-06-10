package in.yazhini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDetailsUtil {
	private RegistrationDetailsUtil() {

	}

	private static final String DRIVER_CLASS_NAME = System.getenv("spring.datasource.driver-class-name");
	private static final String URL = "jdbc:postgresql://projecttracker.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com/bankapp_db";
	private static final String USERNAME = System.getenv("spring.datasource.username");
	private static final String PASSWORD = System.getenv("spring.datasource.password");

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = null;

		// Step 1: Load the database driver 1234in memory
		Class.forName(DRIVER_CLASS_NAME);

		// Step 2: Get the connection from database
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void close1(Connection con, PreparedStatement pst) {
		try {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}