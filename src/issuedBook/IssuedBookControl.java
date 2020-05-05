package issuedBook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IssuedBookControl
 */
@WebServlet("/IssuedBookControl")
public class IssuedBookControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		int bid = Integer.parseInt(req.getParameter("bid"));
		BookIssued bi = new BookIssued();
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		try {
			bi.addIssuedBook(sid, name, mobile, email, bid);
			RequestDispatcher dispatcher = req.getRequestDispatcher("IssuedBook.html");
			dispatcher.include(req, res);
			out.print("Issued book successfully..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
