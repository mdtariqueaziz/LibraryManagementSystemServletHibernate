package returnBook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReturnControl
 */
@WebServlet("/ReturnControl")
public class ReturnControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int bId = Integer.parseInt(req.getParameter("bid"));
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		ReturnDao dao = new ReturnDao();
		PrintWriter out = res.getWriter();

		try {
			dao.returnBook(bId,bookId);
			RequestDispatcher dispatcher = req.getRequestDispatcher("Return.html");
			dispatcher.include(req, res);
			out.print("Book retured successfully..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
