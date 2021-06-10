package in.yazhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.yazhini.model.BookDetails;
import in.yazhini.service.TestBookDetails;
import in.yazhini.validator.BookExistsValidator;

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
		try {
			String bookName = request.getParameter("bookName");
			String authorName = request.getParameter("authorName");
			String bookPrice = request.getParameter("bookPrice");
			String noOfBooks = request.getParameter("noOfBooks");
			Float bookPrice1 = Float.parseFloat(bookPrice);
			int noOfBooks1 = Integer.parseInt(noOfBooks);

			BookDetails books = new BookDetails();
			books.setBookName(bookName);
			books.setAuthorName(authorName);
			books.setBookPrice(bookPrice1);
			books.setNoOfBooks(noOfBooks1);
			BookExistsValidator.existsBook(bookName, authorName);
			boolean isAdded = TestBookDetails.addBook(books);
			if (isAdded) {
				String infoMessage = "Successfully Added";
				response.sendRedirect("ListBookDetails.jsp?infoMessage=" + infoMessage);
			}
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("AddBook.jsp?errorMessage=" + errorMessage);
		}
	}
}
