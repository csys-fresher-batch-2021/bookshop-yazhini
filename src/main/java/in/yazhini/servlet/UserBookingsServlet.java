package in.yazhini.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.yazhini.dao.BookingDAO;
import in.yazhini.dao.UserDao;
import in.yazhini.exception.DBException;
import in.yazhini.model.Shopping;
import in.yazhini.model.UserDetails;

/**
 * Servlet implementation class AllbookingServlet
 */
@WebServlet("/UserBookingsServlet")
public class UserBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserBookingsServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = 0;

		try {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			for (UserDetails user : UserDao.getUserList()) {
				if (userName.equals(user.getUserName())) {
					userId = user.getUserId();
				}
			}
			List<Shopping> userBookingList = BookingDAO.getUserBookingList(userId);
			request.setAttribute("BOOKING_DETAILS", userBookingList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userBookingDetails.jsp");
			requestDispatcher.forward(request, response);
		} catch (DBException | ServletException | IOException e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("userBookingDetails.jsp?errorMessage=" + errorMessage);
		}
	}

}
