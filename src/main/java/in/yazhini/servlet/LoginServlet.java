package in.yazhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.yazhini.validator.LoginPage;

/**
 * Servlet implementation class Login_actionSelvlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		if (role.equals("ADMIN")) {
			boolean valid1 = LoginPage.adminLogin(username, password, role);
			if (valid1) {

				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", username);
				session.setAttribute("ROLE", "ADMIN");
				response.sendRedirect("ListBookDetails.jsp");
			} else {

				String message = "Invalid Login Credentials";
				response.sendRedirect("Login.jsp?errorMessage=" + message);
			}
		} else {
			boolean valid2 = LoginPage.customerLogin(username, password, role);
			if (valid2) {

				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", username);
				session.setAttribute("ROLE", "CUSTOMER");
				response.sendRedirect("ListBookDetails.jsp");
			} else {

				String message = "Invalid Login Credentials";
				response.sendRedirect("Login.jsp?errorMessage=" + message);

			}

		}
	}
}
