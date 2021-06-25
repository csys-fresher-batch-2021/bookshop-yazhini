package in.yazhini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import in.yazhini.exception.DBException;
import in.yazhini.model.BookDetails;
import in.yazhini.model.Shopping;
import in.yazhini.model.UserDetails;
import in.yazhini.util.ConnectionUtil;

public class AllBookingsDAO {
	private AllBookingsDAO() {
		// Default Constructor
	}

	/**
	 * Get AllOrderList With CustomerName
	 * 
	 * @param AllBookingList
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return
	 */
	public static List<Shopping> getAllBookingList() throws DBException {
		List<Shopping> allBookList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select u.username as username,B.bookname as book_name,bd.quantity,bd.totalamount,bd.ordered_date,bd.name,bd.mobileno,bd.email_id,bd.address,bd.status from users u,BookDetails B,booking_details bd\r\n"
					+ "where bd.user_id = u.id and bd.book_id = B.id order by ordered_date asc;";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				Shopping shops = new Shopping();
				UserDetails user = new UserDetails();
				BookDetails book = new BookDetails();
				String username = result.getString("username");
				String bookName = result.getString("book_name");
				Integer quantity = result.getInt("quantity");
				Double totalamount = result.getDouble("totalamount");
				Timestamp orderedDate = result.getTimestamp("ordered_date");
				String name = result.getString("name");
				Long mobileno = result.getLong("mobileno");
				String emailId = result.getString("email_id");
				String address = result.getString("address");
				String status = result.getString("status");
				user.setUserName(username);
				shops.setUser(user);
				book.setBookName(bookName);
				shops.setBook(book);
				shops.setQuantity(quantity);
				shops.setTotalAmount(totalamount);
				LocalDateTime orderDate = orderedDate.toLocalDateTime();
				shops.setOrderedDate(orderDate);
				shops.setName(name);
				shops.setMobileNo(mobileno);
				shops.setEmailId(emailId);
				shops.setAddress(address);
				shops.setStatus(status);
				allBookList.add(shops);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch AllBookingDetails");
		} finally {
			ConnectionUtil.close1(connection, pst);
		}
		return allBookList;
	}
}
