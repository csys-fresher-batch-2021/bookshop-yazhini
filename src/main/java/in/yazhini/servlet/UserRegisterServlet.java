package in.yazhini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.yazhini.model.UserDetails;
import in.yazhini.service.TestUser;
import in.yazhini.validator.UserValidator;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userName = request.getParameter("name");
			String password = request.getParameter("password");
			UserDetails users = new UserDetails();
			users.setUserName(userName);
			users.setPassword(password);
			UserValidator.existsUser(userName);
			TestUser.addUser(users);
			String infoMessage = "Successfully Added CLICK on LoginPage";
			response.sendRedirect("UserRegister.jsp?infoMessage=" + infoMessage);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			response.sendRedirect("UserRegister.jsp?errorMessage=" + errorMessage);
		}
	}
}
