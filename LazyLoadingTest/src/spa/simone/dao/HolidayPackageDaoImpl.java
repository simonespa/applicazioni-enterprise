package spa.simone.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spa.simone.dto.HolidayPackage;

@Repository
public class HolidayPackageDaoImpl extends AbstractDao<HolidayPackage> implements HolidayPackageDao {

	@Autowired
	public HolidayPackageDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public List<HolidayPackage> findByTouroperatorId(Long id) {
		Criteria criteria = session().createCriteria(HolidayPackage.class);
		criteria.add(Restrictions.eq("tourOperator.id", id));
		return criteria.list();
	}

}
