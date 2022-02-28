package spa.simone.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spa.simone.dto.TourOperator;

@Repository
public class TourOperatorDaoImpl extends AbstractDao<TourOperator> implements TourOperatorDao {

	@Autowired
	public TourOperatorDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
