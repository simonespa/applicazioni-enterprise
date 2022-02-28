package spa.simone.service;

import java.util.List;

import spa.simone.dto.HolidayPackage;
import spa.simone.dto.TourOperator;

public interface SpringService {

	public Long saveTourOperator(TourOperator tourOperator);

	public Long saveHolidayPackage(HolidayPackage holidayPackage);

	public void updateTourOperator(TourOperator tourOperator);

	public TourOperator getTourOperatorById(Long id, boolean proxy);

	public HolidayPackage getHolidayPackageById(Long id, boolean proxy);

	public List<HolidayPackage> getHolidayPackagesByTouroperatorId(Long id);

}
