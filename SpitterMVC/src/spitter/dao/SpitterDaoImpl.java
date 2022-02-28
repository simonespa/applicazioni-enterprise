package spitter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spitter.dto.Spitter;

@Repository("spitterDao")
public class SpitterDaoImpl implements SpitterDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Long save(Spitter spitter) {
		return (Long) session().save(spitter);
	}

	@Override
	public void update(Spitter spitter) {
		session().update(spitter);
	}

	@Override
	public void delete(Spitter spitter) {
		session().delete(spitter);
	}

	@Override
	public Spitter getById(Long id) {
		return (Spitter) session().get(Spitter.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Spitter> getAll() {
		return session().createCriteria(Spitter.class).list();
	}

	@Override
	public Spitter getByFirstname(String firstName) {
		return (Spitter) session().createCriteria(Spitter.class)
				.add(Restrictions.eq("firstName", firstName)).uniqueResult();
	}

}
