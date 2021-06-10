package in.yazhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.yazhini.service.TestRegistrationDetails;

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
		String name = request.getParameter("name");
		String emailId = request.getParameter("emailId");
		String mobileNo = request.getParameter("mobileNo"); // covert a mobileNo in long
		long number = Long.parseLong(mobileNo);
		String address = request.getParameter("address");
		try {
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String bookName = request.getParameter("bookName");
			boolean isAdded = TestRegistrationDetails.addDetails(name, emailId, number, address, quantity, bookName);
			if (isAdded) {
				String infoMessage = "Successfully Added";
				response.sendRedirect("End.jsp?infoMessage=" + infoMessage);
			} else {
				String errorMessage = "Invalid Details Credentials";
				response.sendRedirect(MSG + errorMessage);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
