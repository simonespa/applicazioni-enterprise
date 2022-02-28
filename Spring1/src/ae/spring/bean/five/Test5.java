package ae.spring.bean.five;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {

	public static void main(final String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext(
				"ae/spring/bean/five/bean-config.xml");

		final User user2 = context.getBean("pluto", User.class);
		user2.desc();

		final UserDescriber userDescriber = context.getBean("paperino", UserDescriber.class);
		System.out.println(userDescriber.describe(user2));
	}
	
}