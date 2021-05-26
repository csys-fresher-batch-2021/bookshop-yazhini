package in.yazhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.yazhini.service.TestBookDetails;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		String bookPrice = request.getParameter("bookPrice");
		String noOfBooks = request.getParameter("noOfBooks");
		Float bookPrice1 = Float.parseFloat(bookPrice);
		int noOfBooks1 = Integer.parseInt(noOfBooks);

		boolean isAdded = TestBookDetails.addBook(bookName, authorName, bookPrice1, noOfBooks1);

		try {
			if (isAdded) {
				String errorMessage = "Successfully Added";
				response.sendRedirect("ListBookDetails.jsp?errorMessage=" + errorMessage);
			} else {
				String errorMessage = "Invalid BookName or The BookName Already Added";
				response.sendRedirect("Modify.jsp?errorMessage=" + errorMessage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}
}
