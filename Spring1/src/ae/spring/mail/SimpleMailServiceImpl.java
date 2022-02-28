package ae.spring.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SimpleMailServiceImpl implements MailService {
	
	private JavaMailSender mailSender;
	private SimpleMailMessage simpleMailMessage;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public SimpleMailMessage getSimpleMailMessage() {
		return simpleMailMessage;
	}

	@Override
	public void sendMail(final String to, final String subject, final String text,
			final String... cc) {
		simpleMailMessage.setTo(to);
		simpleMailMessage.setCc(cc);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);
		mailSender.send(simpleMailMessage);
	}

	public void setMailSender(final JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setSimpleMailMessage(final SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}
}
