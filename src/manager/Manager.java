package manager;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Bodega;
import model.Campo;
import model.Entrada;

public class Manager {
	private static Manager manager;
	private Session session;
	private Transaction tx;

	private Entrada entrada;
	private Bodega winery;
	private Campo field;

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
		game();
		endSession();

	}

	private void game() {
		for (int i = 1; i < 20; i++) {
			entrada = getEntrada(i);
			entrada();
			// Crea un objeto bodega en base de datos.
		}
	}

	private void entrada() {
		String instrucction = entrada.toString().split(" ")[0];
		String type = entrada.toString().split(" ")[1];
		switch (instrucction) {
		case "B":
			insertWinery(type);
			break;
		}

	}

	private void insertWinery(String type) {
		try {
		
			tx = session.beginTransaction();

			session.save(type);

			tx.commit();
			System.out.println("Inserted Successfully.");

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback(); // Roll back if any exception occurs.
			e.printStackTrace();
		}
	}

	private Entrada getEntrada(int i) {
		try {
			tx = session.beginTransaction();

			Entrada entrada = session.get(Entrada.class, i);

			System.out.println(entrada.toString());

			tx.commit();
			System.out.println("Saved Successfully.");

			return entrada;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback(); // Roll back if any exception occurs.
			e.printStackTrace();
		}

		return null;
	}

	private void endSession() {
		session.close();
	}

	private void initSession() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// Get the session object.
		session = sessionFactory.openSession();
	}

}
