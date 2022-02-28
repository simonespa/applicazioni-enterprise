package ae.spring.bean.i18n;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    public static void main(final String[] args)
    {
        final MessageSource resources = new ClassPathXmlApplicationContext("ae/spring/bean/i18n/spring-config.xml");

        final String message = resources.getMessage("welcome", null, "Default", null);
        System.out.println(message);

        final String messageEN = resources.getMessage("welcome", null, "Default", Locale.UK);
        System.out.println(messageEN);
    }
}
