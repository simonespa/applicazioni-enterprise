package spa.simone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spa.simone.service.SpringService;

public class ServiceFactory {

	private static ApplicationContext context;
	private static final String CONTEXT_PATH = "applicationContext.xml";

	static {
		context = new ClassPathXmlApplicationContext(CONTEXT_PATH);
	}

	private ServiceFactory() {
	}

	public static SpringService getSpringService() {
		return context.getBean(SpringService.class);
	}

}
