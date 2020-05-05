package returnBook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import addBook.AddBook;
import issuedBook.IssuedBook;

public class ReturnDao {

	public void returnBook(int iId,int bId) {
		SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml").addAnnotatedClass(AddBook.class)
				.addAnnotatedClass(IssuedBook.class).buildSessionFactory();
		Session session = factory.openSession();
		String status = "yes";

		try {
			Transaction transaction = session.beginTransaction();
			IssuedBook book = session.get(IssuedBook.class, iId);
			AddBook ab = session.get(AddBook.class, bId);
			ab.setIssued(ab.getIssued() - 1);
			ab.setQuantity(ab.getQuantity() + 1);
			book.setStatus(status);
			session.update(ab);
			session.update(book);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			factory.close();
			session.close();
		}

	}

}
