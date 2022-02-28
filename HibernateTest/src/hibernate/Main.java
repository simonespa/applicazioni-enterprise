package hibernate;

import hibernate.dto.City;
import hibernate.dto.CityTag;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		CityTag tag1 = new CityTag();
		tag1.setName("tag1");
		session.save(tag1);
		CityTag tag2 = new CityTag();
		tag2.setName("tag2");
		session.save(tag2);
		CityTag tag3 = new CityTag();
		tag3.setName("tag3");
		session.save(tag3);
		CityTag tag4 = new CityTag();
		tag4.setName("tag4");
		session.save(tag4);

		City c1 = new City();
		c1.setName("City1");
		c1.addCityTag(tag1);
		c1.addCityTag(tag3);
		session.save(c1);

		City c2 = new City();
		c2.setName("City2");
		c2.addCityTag(tag1);
		session.save(c2);

		City c3 = new City();
		c3.setName("City3");
		c3.addCityTag(tag2);
		c3.addCityTag(tag4);
		session.save(c3);
		transaction.commit();

		transaction = session.beginTransaction();

		Long[] tags = { 1L };
		StringBuilder queryBuilder = new StringBuilder("select distinct city.id from City city");
		for (int i = 1; i <= tags.length; i++) {
			queryBuilder.append(", CityClassification c").append(i);
		}
		queryBuilder.append(" where city.id = c1.cityId");
		for (int i = 1; i < tags.length; i++) {
			queryBuilder.append(" and c").append(i).append(".cityId = c").append(i + 1)
					.append(".cityId");
		}
		for (int i = 1; i <= tags.length; i++) {
			queryBuilder.append(" and c").append(i).append(".cityTagId = ?");
		}

		SQLQuery query = session.createSQLQuery(queryBuilder.toString());
		for (int i = 0; i < tags.length; i++) {
			query.setParameter(i, tags[i]);
		}
		
		System.out.println(queryBuilder.toString());
		
		
		List result = query.list();
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

		transaction.commit();

		session.close();
	}
}
