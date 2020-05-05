package deleteBook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import addBook.AddBook;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml").addAnnotatedClass(AddBook.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			AddBook deBook = session.get(AddBook.class, id);
			session.delete(deBook);
			transaction.commit();
			response.sendRedirect("ViewBook.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}

	}

}
