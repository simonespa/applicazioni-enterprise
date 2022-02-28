package spa.simone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spa.simone.dto.HolidayPackage;
import spa.simone.dto.Service;
import spa.simone.dto.TourOperator;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(TourOperator.class);
		configuration.addAnnotatedClass(HolidayPackage.class);
		configuration.addAnnotatedClass(Service.class);
		configuration.configure("mysql.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public static void shutDown() {
		sessionFactory.close();
	}

}
