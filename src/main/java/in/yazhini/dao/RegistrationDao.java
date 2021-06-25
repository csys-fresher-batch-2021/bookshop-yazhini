package in.yazhini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import in.yazhini.util.ConnectionUtil;

public class RegistrationDao {
	private RegistrationDao() {
		// default constructor
	}

	/**
	 * AddDetails
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return
	 */
	public static boolean addDetails(String name, String emailId, Long mobileNo, String address)
			throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean inserted = false;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into registration(name,emailid,mobileno,address) values (?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, emailId);
			pst.setLong(3, mobileNo);
			pst.setString(4, address);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close1(connection, pst);
		}
		return inserted;
	}
}
