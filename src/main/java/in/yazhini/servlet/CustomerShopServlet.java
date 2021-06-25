package in.yazhini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.yazhini.model.CustomerShop;
import in.yazhini.service.TestCustomerShop;

@WebServlet("/CustomerShopServlet")
public class CustomerShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String bookName = request.getParameter("bookName");
		String noOfBooks = request.getParameter("noOfBooks");
		String userName = (String) session.getAttribute("LOGGED_IN_USER");
		try {
			int quantity = Integer.parseInt(noOfBooks);
			CustomerShop bill = TestCustomerShop.shoppingList(bookName, quantity, userName);
			response.sendRedirect("Bill.jsp?bookName=" + bill.getBookName() + "&noOfBooks=" + bill.getNoOfBooks()
					+ "&price=" + bill.getPrice() + "&totalAmount=" + bill.getTotalAmount() + "&gstAmount="
					+ bill.getGst() + "&bookId=" + bill.getBookId());
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("CustomerShop.jsp?errorMessage=" + errorMessage);
		}
	}
}
