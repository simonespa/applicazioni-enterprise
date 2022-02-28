package ae.spring.mail;

public interface MailService
{
    public void sendMail(final String to, final String subject, final String text, final String... cc);

}
