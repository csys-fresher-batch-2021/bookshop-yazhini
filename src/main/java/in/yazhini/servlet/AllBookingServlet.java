package in.yazhini.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.yazhini.dao.AllBookingsDAO;
import in.yazhini.exception.DBException;
import in.yazhini.model.Shopping;

@WebServlet("/AllBookingServlet")
public class AllBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Shopping> allBookList = AllBookingsDAO.getAllBookingList();
			request.setAttribute("AllBOOKING_DETAILS", allBookList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AllBookings.jsp");
			requestDispatcher.forward(request, response);
		} catch (DBException | ServletException | IOException e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("AllBookings.jsp?errorMessage=" + errorMessage);
		}
	}
}
