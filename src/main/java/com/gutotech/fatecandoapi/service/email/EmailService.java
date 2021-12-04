package com.gutotech.fatecandoapi.service.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

	@Value("${client.apps}")
	private String clientApps;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Async("taskExecutor")
	public void sendVerificationToken(VerificationToken verificationToken) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
			mmh.setFrom("Fatecando");
			mmh.setTo(verificationToken.getUser().getEmail());
			mmh.setSubject("Confirme sua conta no Fatecando");

			Context context = new Context();
			context.setVariable("link", String.format("%s/registration-confirm?token=%s", 
					clientApps.split(",")[0], verificationToken.getToken()));
			mmh.setText(templateEngine.process("email/confirm-email", context), true);

			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			sendVerificationTokenSimple(verificationToken);
			return;
		}
	}

	@Async("taskExecutor")
	private void sendVerificationTokenSimple(VerificationToken verificationToken) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom("Fatecando");
		sm.setTo(verificationToken.getUser().getEmail());
		sm.setSubject("Confirme sua conta no Fatecando");
		sm.setText("\nObrigado por se inscrever no Fatecando!\n\n"
				+ String.format("Clique no link para confirmar sua conta: %s/registration-confirm?token=%s",
						clientApps.split(",")[0], verificationToken.getToken()));
		javaMailSender.send(sm);
	}

}
