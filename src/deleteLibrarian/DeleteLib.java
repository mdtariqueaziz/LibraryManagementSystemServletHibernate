package deleteLibrarian;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import addLibrarian.AddLibrary;

/**
 * Servlet implementation class DeleteLib
 */
@WebServlet("/DeleteLib1")
public class DeleteLib extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml")
				.addAnnotatedClass(AddLibrary.class).buildSessionFactory();
		Session session = factory.openSession();

		try {
			Transaction transaction = session.beginTransaction();
			AddLibrary library = session.get(AddLibrary.class, Integer.parseInt(id));
			session.delete(library);
			transaction.commit();
			response.sendRedirect("ViewLib.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			factory.close();
			session.close();
		}
	}

}
