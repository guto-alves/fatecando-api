package com.gutotech.fatecandoapi.service.email;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.VerificationTokenRepository;

@Service
public class VerificationTokenService {

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private EmailService emailService;

	public VerificationToken findByToken(String VerificationToken) {
		return verificationTokenRepository.findByToken(VerificationToken);
	}

	public void createVerificationToken(User user) {
		final String token = UUID.randomUUID().toString();

		VerificationToken verificationToken = new VerificationToken(token, user);
		verificationTokenRepository.save(verificationToken);

		emailService.sendVerificationToken(verificationToken);
	}

	public void delete(VerificationToken verificationToken) {
		verificationTokenRepository.delete(verificationToken);
	}
}
