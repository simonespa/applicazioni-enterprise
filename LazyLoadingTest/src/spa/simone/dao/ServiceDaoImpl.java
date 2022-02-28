package spa.simone.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spa.simone.dto.Service;

@Repository
public class ServiceDaoImpl extends AbstractDao<Service> implements ServiceDao {

	@Autowired
	public ServiceDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
