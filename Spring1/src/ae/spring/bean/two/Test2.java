package ae.spring.bean.two;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

	private static ApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("ae/spring/bean/two/bean-config.xml");
	}

	@Test
	public void test() {
		final Manager manager1 = context.getBean("pippo", Manager.class);
		manager1.run();

		System.out.println();

		final Manager manager2 = context.getBean("topolino", Manager.class);
		manager2.run();

		final Manager manager3 = context.getBean("topolino", Manager.class);
		manager3.run();

		System.out.println("manager2 != manager3 == " + (manager2 != manager3));
		assertThat(manager2, is(not(equalTo(manager3))));
	}
}
