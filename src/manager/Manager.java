package manager;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Manager {
	private static Manager manager;
	private Session session;

	private Manager() {

	}
	
	public static Manager getInstance() {
		if (manager == null) {
			manager = new Manager();
		}
		return manager;
	}
	
	public void init() {
		initSession();
		System.out.println("Hello");
		
		
		endSession();
		
	}

	private void endSession() {
		session.close();		
	}

	private void initSession() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		// Get the session object.
		session = sessionFactory.openSession();		
	}
	
	
}
