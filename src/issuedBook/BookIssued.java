package issuedBook;

import java.text.DateFormat;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import addBook.AddBook;
import addBook.AddBookDao;

public class BookIssued {

	public void addIssuedBook(int studentId, String name, long mobile, String email,int bookId) {
		Date date = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatDate.format(date);
		SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml").addAnnotatedClass(AddBook.class)
				.addAnnotatedClass(IssuedBook.class).buildSessionFactory();
		Session session = factory.openSession();
		String status = "no";
		try {
			Transaction transaction = session.beginTransaction();
			IssuedBook is = new IssuedBook();
			
			is.setStudentId(studentId);
			is.setName(name);
			is.setEmail(email);
			is.setMobile(mobile);
			is.setDate(strDate);
			is.setStatus(status);
			is.setBookId(bookId);
			session.save(is);
			AddBook addBook = session.get(AddBook.class, bookId);
			addBook.setQuantity(addBook.getQuantity()-1);
			addBook.setIssued(addBook.getIssued()+1);
			session.update(addBook);
			transaction.commit();
			
		} catch (Exception e) {

		}
	}

}
