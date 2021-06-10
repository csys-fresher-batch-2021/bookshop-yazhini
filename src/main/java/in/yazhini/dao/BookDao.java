package in.yazhini.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.yazhini.model.BookDetails;
import in.yazhini.util.ConnectionUtil;

public class BookDao {
	private BookDao() {
		// default constructor
	}

	private static final List<BookDetails> bookList = new ArrayList<>();

	public static List<BookDetails> getUser() {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select * from BookDetails";
			pst = connection.prepareStatement(sql);
			result = pst.executeQuery();
			while (result.next()) {
				BookDetails user = new BookDetails();
				String bookName = result.getString("bookName");
				String authorName = result.getString("authorName");
				Float bookPrice = result.getFloat("bookPrice");
				Integer noOfBooks = result.getInt("noOfBooks");

				user.setBookName(bookName);
				user.setAuthorName(authorName);
				user.setBookPrice(bookPrice);
				user.setNoOfBooks(noOfBooks);
				bookList.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to fetch BookDetails");
		} finally {
			ConnectionUtil.close1(connection, pst);
		}
		return bookList;
	}

	/**
	 * add the bookname,authorname,bookprice and noofbooks to database
	 * 
	 * @param bookname
	 * @param authorname
	 * @param bookprice
	 * @param noofbooks
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean addBook(String bookName, String authorName, float bookPrice, int noOfBooks)
			throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		// Get Connection
		boolean inserted = false;
		try {
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = "insert into BookDetails(bookname,authorname,bookprice,noofbooks) values (?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, bookName);
			pst.setString(2, authorName);
			pst.setFloat(3, bookPrice);
			pst.setInt(4, noOfBooks);
			pst.executeUpdate();
			// Execute Query

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			ConnectionUtil.close1(connection, pst);

		}
		return inserted;
	}

	/**
	 * Delete specific data in database
	 * 
	 * @param bookName
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * 
	 */
	public static boolean deleteBook(String bookName, String authorName) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = "DELETE FROM BookDetails WHERE bookname= ?;";

			// Execute Query
			pst = connection.prepareStatement(sql);
			pst.setString(1, bookName);
			pst.setString(1, authorName);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			ConnectionUtil.close1(connection, pst);
		}
		return false;

	}
}