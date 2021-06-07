package in.yazhini.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;

import java.sql.SQLException;

import in.yazhini.util.ConnectionUtil;

public class BookDao {
	private BookDao() {
		// default constructor
	}

	/**
	 * add the bookname,authorname,bookprice and noofbooks to database
	 * 
	 * @param bookname
	 * @param authorname
	 * @param bookprice
	 * @param noofbooks
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public static boolean addBook(String bookName, String authorName, float bookPrice, int noOfBooks) {
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

		} catch (SQLException e) {
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
	 * @throws SQLException
	 * 
	 */
	public static boolean deleteBook(String bookName) {
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
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			ConnectionUtil.close1(connection, pst);
		}
		return false;

	}

}
