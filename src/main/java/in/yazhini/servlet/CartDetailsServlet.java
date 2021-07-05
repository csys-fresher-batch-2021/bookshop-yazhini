package in.yazhini.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.yazhini.dao.UserDao;
import in.yazhini.exception.ServiceException;
import in.yazhini.model.UserDetails;
import in.yazhini.service.CartService;

/**
 * Servlet implementation class CartDetailsServlet
 */
@WebServlet("/CartDetailsServlet")
public class CartDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDetailsServlet() {
             super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = 0;
		try {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			for (UserDetails user : UserDao.getUserList()) {
				if (userName.equals(user.getUserName())) {
					userId = user.getUserId();
				}
			}
			CartService.addcart(userId, bookId);
			String infoMessage = "Successfully Added To Cart";
			response.sendRedirect("ListBookDetails.jsp?infoMessage=" + infoMessage);
	} catch (ServiceException e) {
		e.printStackTrace();
		String errorMessage = e.getMessage();
		response.sendRedirect("ListBookDetails.jsp?errorMessage=" + errorMessage);
	}
	}
}