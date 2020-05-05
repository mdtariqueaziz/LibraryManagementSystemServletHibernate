package Login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoginDao {
	public void addLogin(String username, String password) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Login.class).buildSessionFactory();
		Session session = factory.openSession();
		System.out.println(session);
		System.out.println(username);
		try {
			Transaction transaction = session.beginTransaction();
			Login login = new Login();
			login.setUsername(username);
			login.setPassword(password);
			session.save(login);
			transaction.commit();
			System.out.println("Successfully..");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}

	}

}
