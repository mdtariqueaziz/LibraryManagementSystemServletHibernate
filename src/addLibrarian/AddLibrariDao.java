package addLibrarian;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.*;

public class AddLibrariDao {

	public void addLibrary(String name, String email, long mobile) {

		SessionFactory factory = new Configuration().configure("AddLibrarian.cfg.xml")
				.addAnnotatedClass(AddLibrary.class).buildSessionFactory();
		Session session = factory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			AddLibrary add = new AddLibrary();
			add.setName(name);
			add.setEmail(email);
			add.setMobile(mobile);
			session.save(add);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
