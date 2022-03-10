package manager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Bodega;
import model.Campo;
import model.Entrada;
import model.TipoVid;
import model.Vid;

public class Manager {
	private static Manager manager;
	private Session session;
	private Transaction tx;

	private Bodega winery;
	private Campo field;
	private List<Entrada> entrada;

	private Manager() {
		entrada = new ArrayList<>();
		winery = new Bodega();
		field = new Campo();
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
		entrada = getAllEntrada();

		for (Entrada en : entrada) {
			System.out.println(en);
			switch (en.getInstrucction().charAt(0)) {
			case 'B':
				insertWinery(en.getInstrucction().split(" ")[1]);
				break;
			case 'C':
				field();
				break;
			case 'V':
					TipoVid sumno = TipoVid.valueOf(en.getInstrucction().split(" ")[1].toUpperCase());
				newVidToField(sumno,en.getInstrucction().split(" ")[2]);
				break;
			}
		}
	}

	private void newVidToField(TipoVid type, String amount) {
		Vid vid = new Vid(type, Integer.parseInt(amount));
		
		field.getVid().add(vid);
		
	}

	private void field() {
		field.setWinery(winery);
		
		try {

			tx = session.beginTransaction();

			session.save(field);

			tx.commit();
			// System.out.println("Inserted Successfully.");

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback(); // Roll back if any exception occurs.
			e.printStackTrace();
		}

	}

	private void insertWinery(String type) {
		
		winery = new Bodega(type);
		
		try {

			tx = session.beginTransaction();

			session.save(winery);

			tx.commit();
			// System.out.println("Inserted Successfully.");

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback(); // Roll back if any exception occurs.
			e.printStackTrace();
		}
	}

	private ArrayList<Entrada> getAllEntrada() {
		ArrayList<Entrada> entry = new ArrayList<>();

		try {
			tx = session.beginTransaction();

			Query q = session.createQuery("from Entrada");

			q.list();

			entry.addAll(q.list());

			tx.commit();
			System.out.println("Get All Successfully.");

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return entry;
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
