package com.gutotech.fatecandoapi.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Value("${client.apps}")
	private String clientApps;

	@Autowired
	private MailSender mailSender;

	@Async("taskExecutor")
	public void sendVerificationTokenEmail(VerificationToken verificationToken) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom("Fatecando");
		sm.setTo(verificationToken.getUser().getEmail());
		sm.setSubject("Confirme sua conta no Fatecando");
		sm.setText("\nObrigado por se inscrever no Fatecando!\n\n"
				+ String.format("Clique no link para confirmar sua conta: %s/registration-confirm?token=%s",
						clientApps.split(",")[0], verificationToken.getToken()));
		mailSender.send(sm);
	}

}
