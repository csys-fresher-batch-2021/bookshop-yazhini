package in.yazhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.yazhini.service.CustomerSelectBooks;

/**
 * Servlet implementation class CustomerSelectServlet
 */
@WebServlet("/CustomerSelectServlet")
public class CustomerSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MSG = "CustomerShop.jsp?errorMessage=";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		String noOfBooks = request.getParameter("noOfBooks");
		int noOfBooks1 = Integer.parseInt(noOfBooks);

		boolean isAdded = CustomerSelectBooks.validateNoOfBooks(bookName, noOfBooks1);

		if (isAdded) {
			String errorMessage = "Successfully Added";
			response.sendRedirect("Bill.jsp?errorMessage=" + errorMessage);
		} else {
			String errorMessage = "Invalid BookName or NoOfBooks is NotAvailable";
			response.sendRedirect(MSG + errorMessage);
		}
	}

}
