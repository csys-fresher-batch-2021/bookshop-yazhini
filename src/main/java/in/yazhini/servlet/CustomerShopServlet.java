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
		int Quantity = Integer.parseInt(noOfBooks);
		double gst = 0.08;
		boolean isAdded = TestCustomerShop.shoppingList(bookName, Quantity);
		TestCustomerShop.gstCalculation(bookName, gst);
		if (isAdded) {
			String errorMessage = "Succefully Added";
			response.sendRedirect("Bill.jsp?errorMessage=" + errorMessage);

		} else {
			String errorMessage = "InValid BookName or NoOfBooks";
			response.sendRedirect("CustomerShop.jsp?errorMessage=" + errorMessage);
		}
	}
}
