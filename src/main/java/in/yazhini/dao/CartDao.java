package in.yazhini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.yazhini.exception.DBException;
import in.yazhini.model.BookDetails;
import in.yazhini.model.CartDetails;
import in.yazhini.model.UserDetails;
import in.yazhini.util.ConnectionUtil;

public class CartDao {
	private CartDao() {

	}

	public static void addCart(int userId, int bookId) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = " insert into cart_details(user_id,book_id) values(?,?);";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, bookId);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable To AddDetails");
		} finally {
			ConnectionUtil.close1(connection, pst);
		}
	}

	public static List<CartDetails> getUserCartList(int userId) {
		List<CartDetails> cartList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select cd.id,u.username,b.bookname,b.authorname,b.bookprice,b.noofbooks from users u,bookdetails b,cart_details cd \r\n"
					+ "	where u.id=cd.user_id and b.id=cd.book_id and u.id=?;";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId);
			result = pst.executeQuery();
			while (result.next()) {
				CartDetails cart = new CartDetails();
				UserDetails user = new UserDetails();
				BookDetails book = new BookDetails();

				Integer cartId = result.getInt("id");
				String userName = result.getString("userName");
				String bookName = result.getString("bookName");
				String authorName = result.getString("authorName");
				Float bookPrice = result.getFloat("bookPrice");
				Integer noOfBooks = result.getInt("noOfBooks");

				cart.setId(cartId);
				user.setUserName(userName);
				cart.setUserDetails(user);
				book.setBookName(bookName);
				book.setAuthorName(authorName);
				book.setBookPrice(bookPrice);
				book.setNoOfBooks(noOfBooks);
				cart.setBookDetails(book);
				cartList.add(cart);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch CartDetails");
		} finally {
			ConnectionUtil.close1(connection, pst);
		}
		return cartList;
	}

	public static List<CartDetails> getCartList() {
		List<CartDetails> cartList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select cd.id,u.username,b.bookname,b.authorname,b.bookprice,b.noofbooks from users u,bookdetails b,cart_details cd \r\n"
					+ "	where u.id=cd.user_id and b.id=cd.book_id;";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				CartDetails cart = new CartDetails();
				UserDetails user = new UserDetails();
				BookDetails book = new BookDetails();

				Integer cartId = result.getInt("id");
				String userName = result.getString("userName");
				String bookName = result.getString("bookName");
				String authorName = result.getString("authorName");
				Float bookPrice = result.getFloat("bookPrice");
				Integer noOfBooks = result.getInt("noOfBooks");

				cart.setId(cartId);
				user.setUserName(userName);
				cart.setUserDetails(user);
				book.setBookName(bookName);
				book.setAuthorName(authorName);
				book.setBookPrice(bookPrice);
				book.setNoOfBooks(noOfBooks);
				cart.setBookDetails(book);
				cartList.add(cart);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to fetch CartDetails");
		} finally {
			ConnectionUtil.close1(connection, pst);
		}
		return cartList;
	}

	public static void deleteCart(int userId, int bookId) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM cart_details WHERE user_id= ? and book_id=? ";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, bookId);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Delete CartDetails");
		} finally {
			ConnectionUtil.close1(connection, pst);
		}
	}

}
