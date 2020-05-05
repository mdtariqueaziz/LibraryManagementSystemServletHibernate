package Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginControlServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String userN = "tarique";
		String passW = "12345";
		try {
			LoginDao dao = new LoginDao();
			String userType = req.getParameter("userType");
			if (userType.equals("admin")) {
				if (userN.equals(username) && passW.equals(password)) {
					dao.addLogin(username, password);
					res.sendRedirect("Admin.html");
				}
			}
			if (userType.equals("librarian")) {
				if (userN.equals(username) && passW.equals(password)) {
					dao.addLogin(username, password);
					res.sendRedirect("Librarian.html");
				}

			}

			else {
				res.sendRedirect("Error.html");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
