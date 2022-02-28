package annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("annotations/application-context.xml");
		Performer performer = (Performer) context.getBean("eddie");
		performer.perform();
	}
	
}
