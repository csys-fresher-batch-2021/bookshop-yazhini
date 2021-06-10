package in.yazhini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerShopUtil {
	private CustomerShopUtil() {

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/bill_db";
		String username = "postgres";
		String password = "oracle";
		// Step 1: Load the jdbc driver in memory
		Class.forName(driverClass);
		// Step 2: Get the connection
		Connection connection = DriverManager.getConnection(url, username, password);
		
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