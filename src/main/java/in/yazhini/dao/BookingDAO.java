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

public class BookingDAO {
	private BookingDAO() {

	}

	public static void addBooking(Shopping shop) {
		Connection connection = null;
		PreparedStatement pst = null;
		// Get Connection
		try {
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = " insert into booking_details(user_id,book_id,quantity,totalamount,ordered_date,name,mobileno,email_id,address)\r\n"
					+ " values (?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			UserDetails user = new UserDetails();
			BookDetails book = new BookDetails();
			user = shop.getUser();
			int userId = user.getUserId();
			book = shop.getBook();
			int bookId = book.getBookId();

			pst.setInt(1, userId);
			pst.setInt(2, bookId);
			pst.setInt(3, shop.getQuantity());
			pst.setDouble(4, shop.getTotalAmount());
			Timestamp orderedDate = Timestamp.valueOf(shop.getOrderedDate());
			pst.setTimestamp(5, orderedDate);
			pst.setString(6, shop.getName());
			pst.setLong(7, shop.getMobileNo());
			pst.setString(8, shop.getEmailId());
			pst.setString(9, shop.getAddress());
			pst.executeUpdate();
			// Execute Query

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			ConnectionUtil.close1(connection, pst);

		}

	}

	public static List<Shopping> getUserBookingList(int userId) throws DBException {
		List<Shopping> userBookList = new ArrayList<>();
		// store the user Booking Details in arraylist
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select u.username as username,B.bookname as book_name,bd.quantity,bd.totalamount,bd.ordered_date,bd.name,bd.mobileno,bd.address,bd.status from users u,BookDetails B,booking_details bd\r\n"
					+ "	where bd.user_id = u.id and bd.book_id = B.id and u.id = ?;";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId);
			result = pst.executeQuery();
			while (result.next()) {
				Shopping shop = new Shopping();
				// create a object to store the user details
				UserDetails user = new UserDetails();
				BookDetails book = new BookDetails();
				String username = result.getString("username");
				String bookName = result.getString("book_name");
				Integer quantity = result.getInt("quantity");
				Double totalamount = result.getDouble("totalamount");
				Timestamp orderedDate = result.getTimestamp("ordered_date");
				String name = result.getString("name");
				Long mobileno = result.getLong("mobileno");
				String address = result.getString("address");
				String status = result.getString("status");

				user.setUserName(username);
				shop.setUser(user);
				book.setBookName(bookName);
				shop.setBook(book);
				shop.setQuantity(quantity);
				shop.setTotalAmount(totalamount);
				LocalDateTime orderDate = orderedDate.toLocalDateTime();
				shop.setOrderedDate(orderDate);
				shop.setName(name);
				shop.setMobileNo(mobileno);
				shop.setAddress(address);
				shop.setStatus(status);
				userBookList.add(shop);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch UserBookingDetails");

		} finally {
			ConnectionUtil.close1(connection, pst);
		}
		return userBookList;
	}

}
