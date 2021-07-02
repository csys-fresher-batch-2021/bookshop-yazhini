package in.yazhini.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.yazhini.dao.AllBookingsDAO;
import in.yazhini.exception.DBException;
import in.yazhini.model.Shopping;
import in.yazhini.util.GsonUtil;

@WebServlet("/AllBookingServlet")
public class AllBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			List<Shopping> allBookList = AllBookingsDAO.getAllBookingList();
			Gson gson = GsonUtil.create();
			String json = gson.toJson(allBookList);
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.flush();	
		} catch (DBException | IOException e) {
			JsonObject object=new JsonObject();
			object.addProperty("errorMessage" , e.getMessage());
			out.println(object);
		}
		out.flush();
	}
}
