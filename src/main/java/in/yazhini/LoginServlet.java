package in.yazhini;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.yazhini.validator.AdminService;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		boolean valid = AdminService.login(username, password, role);
		if (valid) {
			System.out.println("Successfully LoggedIn");
			response.sendRedirect("Listbooks.jsp");
		} else {

			String message = "Invalid Login Credentials";
			response.sendRedirect("Login.jsp?errorMessage=" + message);
		}

	}

}
