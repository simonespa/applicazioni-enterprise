package autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("autowiring/spring-idol.xml");
		Performer performer = (Performer) context.getBean("simone");
		performer.perform();
	}
	
}
