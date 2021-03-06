package in.yazhini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.yazhini.exception.ServiceException;
import in.yazhini.validator.LoginPage;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		if (role.equals("ADMIN")) {
			boolean valid1 = LoginPage.adminLogin(userName, password, role);
			if (valid1) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", userName);
				session.setAttribute("ROLE", "ADMIN");
				response.sendRedirect("ListBookDetails.jsp");
			} else {
				String message = "Invalid Login Credentials";
				response.sendRedirect("Login.jsp?errorMessage=" + message);
			}
		} else {
			try {
				boolean adminLogin = LoginPage.customerLogin(userName, password);
				if (adminLogin) {
					HttpSession session = request.getSession();
					session.setAttribute("LOGGED_IN_USER", userName);
					session.setAttribute("ROLE", "CUSTOMER");
					response.sendRedirect("ListBookDetails.jsp");
				} else {
					throw new ServiceException("InValid User Credential");
				}
			} catch (Exception e) {
				e.printStackTrace();
				String errorMessage = e.getMessage();
				response.sendRedirect("Login.jsp?errorMessage=" + errorMessage);
			}
		}
	}
}
