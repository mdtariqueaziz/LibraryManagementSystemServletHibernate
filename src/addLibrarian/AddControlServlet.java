package addLibrarian;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddControlServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		try {
			AddLibrariDao dao = new AddLibrariDao();
			dao.addLibrary(name, email, mobile);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddLibrarian.html");
			requestDispatcher.include(req, res);
			out.print("Librarian added successfully..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
