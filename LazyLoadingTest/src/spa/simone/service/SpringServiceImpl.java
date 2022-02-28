package spa.simone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spa.simone.dao.HolidayPackageDao;
import spa.simone.dao.TourOperatorDao;
import spa.simone.dto.HolidayPackage;
import spa.simone.dto.TourOperator;

@Service
@Transactional
public class SpringServiceImpl implements SpringService {

	@Autowired
	private TourOperatorDao tourOperatorDao;
	@Autowired
	private HolidayPackageDao holidayPackageDao;

	@Override
	public Long saveTourOperator(TourOperator tourOperator) {
		return tourOperatorDao.save(tourOperator);
	}

	@Override
	public Long saveHolidayPackage(HolidayPackage holidayPackage) {
		return holidayPackageDao.save(holidayPackage);
	}

	@Override
	public void updateTourOperator(TourOperator tourOperator) {
		tourOperatorDao.update(tourOperator);
	}

	@Override
	@Transactional(readOnly = true)
	public TourOperator getTourOperatorById(Long id, boolean proxy) {
		return tourOperatorDao.findById(id, proxy);
	}

	@Override
	@Transactional(readOnly = true)
	public HolidayPackage getHolidayPackageById(Long id, boolean proxy) {
		return holidayPackageDao.findById(id, proxy);
	}

	@Override
	public List<HolidayPackage> getHolidayPackagesByTouroperatorId(Long id) {
		return holidayPackageDao.findByTouroperatorId(id);
	}

}