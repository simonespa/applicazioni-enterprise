package spa.simone;

import spa.simone.dto.HolidayPackage;
import spa.simone.dto.TourOperator;
import spa.simone.service.SpringService;
import static spa.simone.ServiceFactory.getSpringService;

public class Main {

	public static void main(String[] args) {
		SpringService service = getSpringService();
		
		TourOperator tourOperator = new TourOperator();
		tourOperator.setName("TourOperator1");
		tourOperator.setAddress("Via Roma");
		service.saveTourOperator(tourOperator);
		
		HolidayPackage holidayPackage = new HolidayPackage();
		holidayPackage.setName("Holiday Package");
		holidayPackage.setDescription("Descrizione");
		
		tourOperator = service.getTourOperatorById(tourOperator.getId(), true);
		holidayPackage.setTourOperator(tourOperator);
		tourOperator.addHolidayPackage(holidayPackage);
		service.saveHolidayPackage(holidayPackage);
	}

}
