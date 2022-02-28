package ae.spring.bean.one;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	private static ApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("ae/spring/bean/one/bean-config.xml");
	}

	@Test
	public void getBean1() {
		final User user1 = (User) context.getBean("pippo");
		assertThat(user1.desc(), is(equalTo("Firstname: null, Lastname: null")));
	}

	@Test
	public void getBean2() {
		final User user2 = context.getBean("pluto", User.class);
		assertThat(user2.desc(), is(equalTo("Firstname: Ciccio, Lastname: Pasticcio")));
	}

	@Test
	public void getBean3() {
		final User user3 = context.getBean("topolino", User.class);
		assertThat(user3.desc(), is(equalTo("Firstname: Tizio, Lastname: Caio")));
	}
}
