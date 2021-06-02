package in.yazhini.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.yazhini.util.RegistrationDetailsUtil;

public class RegistrationDao {

	private RegistrationDao() {
		// default constructor
	}

	public static boolean addDetails(String name, String emailId, Long mobileNo, String address) {
		Connection connection = null;
		PreparedStatement pst = null;
		// Get Connection
		boolean inserted = false;
		try {
			connection = RegistrationDetailsUtil.getConnection();
			// prepare data
			String sql = "insert into registration1(name,emailid,mobileno,address) values (?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, emailId);
			pst.setLong(3, mobileNo);
			pst.setString(4, address);
			pst.executeUpdate();
			// Execute Query

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {

			RegistrationDetailsUtil.close1(connection, pst);

		}
		return inserted;
	}
}
