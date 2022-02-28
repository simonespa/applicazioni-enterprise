package spitter.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spitter.dto.Spittle;

@Repository("spittleDao")
public class SpittleDaoImpl implements SpittleDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Long save(Spittle spittle) {
		return (Long) session().save(spittle);
	}

	@Override
	public void update(Spittle spittle) {
		session().update(spittle);
	}

	@Override
	public void delete(Spittle spittle) {
		session().delete(spittle);
	}

	@Override
	public Spittle getById(Long id) {
		return (Spittle) session().get(Spittle.class, id);
	}

	@Override
	public List<Spittle> getAll() {
		return (List<Spittle>) session().createCriteria(Spittle.class).list();
	}

	@Override
	public List<Spittle> getFirst(Integer size) {
		return (List<Spittle>) session().createCriteria(Spittle.class).list();
	}

}
