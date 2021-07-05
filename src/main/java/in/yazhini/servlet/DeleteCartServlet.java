package in.yazhini.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.yazhini.dao.BookDao;
import in.yazhini.dao.UserDao;
import in.yazhini.model.BookDetails;
import in.yazhini.model.UserDetails;
import in.yazhini.service.CartService;


/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartServlet() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookName = request.getParameter("bookName");
		System.out.println(bookName);
		int userId=0;
		int bookId=0;
		try {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			for (UserDetails user : UserDao.getUserList()) {
				if (userName.equals(user.getUserName())) {
					userId = user.getUserId();
				}
			}
			for (BookDetails books : BookDao.getBookList()) {
				if (bookName.equals(books.getBookName())) {
					bookId = books.getBookId();
				}
			}
			System.out.println(userId + "y"+ bookId);
			CartService.deleteUser(userId,bookId);
			String infoMessage = "Successfully Removed";
			response.sendRedirect("UserCartServlet?infoMessage=" + infoMessage);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("MyCart.jsp" + errorMessage);
		}
        }
	}
