package in.yazhini.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.yazhini.dao.BookDao;
import in.yazhini.dao.UserDao;
import in.yazhini.model.BookDetails;
import in.yazhini.model.Shopping;
import in.yazhini.model.UserDetails;
import in.yazhini.service.TestBookingDetails;

/**
 * Servlet implementation class AddDetailsServlet
 */
@WebServlet("/AddDetailsServlet")
public class AddDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Registration.jsp?errorMessage=";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String emailId = request.getParameter("emailId");
			String mobileNo = request.getParameter("mobileNo");
			long number = Long.parseLong(mobileNo);
			String address = request.getParameter("address");

			int userId = 0;
			int bookId = 0;
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String bookName = request.getParameter("bookName");
			double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
			LocalDateTime orderedDate = LocalDateTime.now();
			HttpSession session = request.getSession();

			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			for (UserDetails user : UserDao.getUserList()) {
				if (userName.trim().equals(user.getUserName())) {
					userId = user.getUserId();
				}
			}
			for (BookDetails book : BookDao.getBookList()) {

				if (bookName.trim().equals(book.getBookName())) {
					bookId = book.getBookId();

					break;
				}
			}
			Shopping shop = new Shopping();

			UserDetails users = new UserDetails();
			users.setUserId(userId);
			shop.setUser(users);

			BookDetails books = new BookDetails();
			books.setBookId(bookId);
			shop.setBook(books);

			shop.setQuantity(quantity);
			shop.setTotalAmount(totalAmount);
			shop.setOrderedDate(orderedDate);
			shop.setName(name);
			shop.setEmailId(emailId);
			shop.setMobileNo(number);
			shop.setAddress(address);

			TestBookingDetails.bookingDetails(shop, bookName, quantity);

			String infoMessage = "Your Order Successfully";
			response.sendRedirect("End.jsp?infoMessage=" + infoMessage);

		} catch (Exception e) {
			e.printStackTrace();

			String errorMessage = e.getMessage();
			response.sendRedirect(MSG + errorMessage);
		}
	}
}