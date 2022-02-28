package spa.simone.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDao<T extends Serializable> implements GenericDao<T> {

	private Class<T> dtoClass;
	private static SessionFactory sessionFactory;

	public AbstractDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		// Risolve a runtime il tipo dei parametri della classe
		// AbstractGenericDAO. In questo caso solo "T".
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		// Recupera la prima (e l'unica) classe parametrizzata
		dtoClass = (Class<T>) type.getActualTypeArguments()[0];
	}

	protected Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Long save(T dto) {
		return (Long) session().save(dto);
	}

	@Override
	public void delete(T dto) {
		session().delete(dto);
	}

	@Override
	public void update(T dto) {
		session().update(dto);
	}

	@Override
	public T findById(Long id, boolean proxy) {
		if (proxy) {
			return (T) session().load(dtoClass, id);
		} else {
			return (T) session().get(dtoClass, id);
		}
	}

	@Override
	public List<T> findAll() {
		return session().createCriteria(dtoClass).list();
	}

}
