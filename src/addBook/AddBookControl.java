package addBook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBookControl
 */
@WebServlet("/AddBookControl")
public class AddBookControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int issued = Integer.parseInt(request.getParameter("issued"));
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			AddBookDao dao = new AddBookDao();
			dao.addBook(name, author, publisher, quantity,issued);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddBook.html");
			dispatcher.include(request, response);
			out.print("Book added successfully...");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
