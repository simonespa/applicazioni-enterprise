package ae.spring.bean.four;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4
{
    public static void main(final String[] args)
    {
        final ApplicationContext context = new ClassPathXmlApplicationContext("ae/spring/bean/four/bean-config.xml");

        final User user = context.getBean("user", User.class);
        System.out.println(user.getUserAccount());
    }
}
