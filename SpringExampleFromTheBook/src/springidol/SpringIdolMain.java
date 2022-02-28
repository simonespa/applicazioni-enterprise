package springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolMain {

	public static void main(String[] args) throws PerformanceException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springidol/spring-idol.xml");
		Performer performer = (Performer) context.getBean("carl");
		performer.perform();
	}
	
}