package in.yazhini.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
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

	/**
	 * AddBooking
	 * 
	 * @param Shop
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return
	 */
	public static void addBooking(Shopping shop) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = " insert into booking_details(user_id,book_id,quantity,totalamount,ordered_date,delivery_date,name,mobileno,email_id,address)\r\n"
					+ " values (?,?,?,?,?,?,?,?,?,?)";
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
			Date deliveryDate = Date.valueOf(shop.getDeliveryDate());
			pst.setDate(6, deliveryDate);
			pst.setString(7, shop.getName());
			pst.setLong(8, shop.getMobileNo());
			pst.setString(9, shop.getEmailId());
			pst.setString(10, shop.getAddress());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close1(connection, pst);
		}
	}

	/**
	 * Get UserBookingList
	 * 
	 * @param userId
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return
	 */
	public static List<Shopping> getUserBookingList(int userId) throws DBException {
		List<Shopping> userBookList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select u.username as username,B.bookname as book_name,bd.quantity,bd.totalamount,bd.ordered_date,bd.delivery_date,bd.name,bd.mobileno,bd.address,bd.status from users u,BookDetails B,booking_details bd\r\n"
					+ "	where bd.user_id = u.id and bd.book_id = B.id and u.id = ?;";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId);
			result = pst.executeQuery();
			while (result.next()) {
				Shopping shop = new Shopping();
				UserDetails user = new UserDetails();
				BookDetails book = new BookDetails();
				String username = result.getString("username");
				String bookName = result.getString("book_name");
				Integer quantity = result.getInt("quantity");
				Double totalamount = result.getDouble("totalamount");
				Timestamp orderedDate = result.getTimestamp("ordered_date");
				Date date = result.getDate("delivery_date");
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
				LocalDate deliveryDate = date.toLocalDate();
				shop.setDeliveryDate(deliveryDate);
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
