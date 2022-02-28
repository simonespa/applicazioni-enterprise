package hibernate;

import hibernate.dto.City;
import hibernate.dto.CityTag;
import hibernate.dto.House;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration conf = new Configuration();
			conf.addAnnotatedClass(City.class);
			conf.addAnnotatedClass(CityTag.class);
			conf.addAnnotatedClass(House.class);
			conf.configure("mysql.cfg.xml");
			sessionFactory = conf.buildSessionFactory();
		}
		return sessionFactory;
	}
}