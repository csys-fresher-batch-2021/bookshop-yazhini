package in.yazhini.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDetailsUtil {
	private RegistrationDetailsUtil() {

	}

	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/Registration_db";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "oracle";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// Step 1: Load the jdbc driver in memory
		Class.forName(DRIVER_CLASS_NAME);
		// Step 2: Get the connection
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
