package in.yazhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.yazhini.service.TestBookDetails;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MSG = "DeleteBook.jsp?errorMessage=";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");

		boolean isDeleted = TestBookDetails.deleteBook(bookName, authorName);
		
			if (isDeleted) {
				String infoMessage = "Successfully Deleted";
				response.sendRedirect("ListBookDetails.jsp?infoMessage=" + infoMessage);
			} else {
				String errorMessage = "Unable To Delete BookName ";
				response.sendRedirect(MSG + errorMessage);
			}
	}
}
