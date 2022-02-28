package spa.simone.dao;

import java.util.List;

import spa.simone.dto.HolidayPackage;

public interface HolidayPackageDao extends GenericDao<HolidayPackage> {

	public List<HolidayPackage> findByTouroperatorId(Long id);
	
}
