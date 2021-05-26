package in.yazhini.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String bookName = request.getParameter("BookName");
		out.println(bookName);

		boolean isDeleted= TestBookDetails.deleteBook(bookName);
		try {
			if (isDeleted) {
				String errorMessage = "Successfully Deleted";
				response.sendRedirect("ListBookDetails.jsp?errorMessage=" + errorMessage);
			} else {
				String errorMessage = "Invalid BookName ";
				response.sendRedirect("Modify.jsp?errorMessge="+ errorMessage);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
