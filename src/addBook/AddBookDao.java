package addBook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddBookDao {
	public void addBook(String name, String author, String publisher, int quantity, int issued) {

		SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml").addAnnotatedClass(AddBook.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			AddBook add = new AddBook();
			add.setName(name);
			add.setAuthor(author);
			add.setPublisher(publisher);
			add.setQuantity(quantity);
			add.setIssued(issued);
			session.save(add);
			transaction.commit();

		} catch (Exception e) {
			session.close();
			factory.close();
		}

	}

}
