package in.yazhini.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.yazhini.exception.DBException;

import in.yazhini.model.UserDetails;
import in.yazhini.util.ConnectionUtil;

public class UserDao {
	public static boolean addUser(UserDetails users) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		// Get Connection
		boolean inserted = false;
		try {
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = "insert into users(userName,password) values (?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, users.getUserName());
			pst.setString(2, users.getPassword());

			pst.executeUpdate();
			// Execute Query

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch UserDetails");
		} finally {

			ConnectionUtil.close1(connection, pst);

		}
		return inserted;
	}

	public static List<UserDetails> getUserList() throws DBException {
		List<UserDetails> userList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from users";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				UserDetails user = new UserDetails();

				Integer userId = result.getInt("id");
				String userName = result.getString("username");
				String password = result.getString("password");

				user.setUserId(userId);
				;
				user.setUserName(userName);
				user.setPassword(password);

				userList.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("You are a newUser So Please CreateAccount In MyBookShop");

		} finally {
			ConnectionUtil.close1(connection, pst);
		}
		return userList;
	}

}
