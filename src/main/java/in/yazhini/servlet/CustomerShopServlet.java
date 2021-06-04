package in.yazhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.yazhini.service.TestCustomerShop;

/**
 * Servlet implementation class CustomerShopServlet
 */
@WebServlet("/CustomerShopServlet")
public class CustomerShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookName = request.getParameter("bookName");
		String noOfBooks = request.getParameter("noOfBooks");
		int quantity = Integer.parseInt(noOfBooks);

		boolean isAdded = TestCustomerShop.shoppingList(bookName, quantity);

		if (isAdded) {
			String errorMessage = "Succefully Added";
			response.sendRedirect("Bill.jsp?errorMessage=" + errorMessage);

		} else {
			String errorMessage = "InValid BookName or NoOfBooks";
			response.sendRedirect("CustomerShop.jsp?errorMessage=" + errorMessage);
		}
	}
}
