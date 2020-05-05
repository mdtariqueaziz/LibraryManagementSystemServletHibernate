package modifyLib;

import java.io.IOException;
import java.io.PrintWriter;

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

import addLibrarian.AddLibrariDao;
import addLibrarian.AddLibrary;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UpdateUser")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml")
				.addAnnotatedClass(AddLibrary.class).buildSessionFactory();
		PrintWriter out = response.getWriter();
		Session s = factory.openSession();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String emai = request.getParameter("email");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		AddLibrary library = new AddLibrary(name, emai, mobile);
		library.setId(id);
		Transaction t = s.beginTransaction();
		s.update(library);
		t.commit();
		RequestDispatcher dispatcher = request.getRequestDispatcher("ModifyLib.jsp?id="+id);
		dispatcher.include(request, response);
		out.print("Record modified successfully...");
		
	}

}
