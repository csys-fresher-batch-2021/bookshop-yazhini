package in.yazhini.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.yazhini.util.ConnectionUtil;

public class CustomerShopDao {
	private CustomerShopDao() {
		// default constructor
	}

	public static boolean addDetails(String bookName, Integer noOfBooks, double price, double totalAmount,
			double gstAmount) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		// Get Connection
		boolean inserted = false;
		try {
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = "insert into customershop(BookName,NoOfBooks,Price,TotalAmount,GstAmount) values (?,?,?,?,?)";
			pst = connection.prepareStatement(sql);

			pst.setString(1, bookName);
			pst.setInt(2, noOfBooks);
			pst.setDouble(3, price);
			pst.setDouble(4, totalAmount);
			pst.setDouble(5, gstAmount);
			pst.executeUpdate();
			// Execute Query

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			ConnectionUtil.close1(connection, pst);

		}
		return inserted;
	}
}
