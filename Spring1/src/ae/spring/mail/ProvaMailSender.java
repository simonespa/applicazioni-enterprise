package ae.spring.mail;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;

public class ProvaMailSender
{
    public static Date getDate()
    {
        final Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, -4);
        return calendar.getTime();
    }

    public static void main(final String[] args)
    {
        final ApplicationContext ctx = new ClassPathXmlApplicationContext("ae/spring/mail/applicationContext.xml");
        final SimpleMailMessage simpleMailMessage = (SimpleMailMessage) ctx.getBean("simpleMailMessage");
        simpleMailMessage.setSentDate(getDate());

        final MailService mailService = (MailService) ctx.getBean("simpleMailService");
        mailService.sendMail("spa.simone@gmail.com", "Spring Java Mail", "Hai ricevuto questo messaggio perché mi sto esercitando.");
    }

}
