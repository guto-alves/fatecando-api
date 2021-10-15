package com.gutotech.fatecandoapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.access.event.AuthorizedEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.service.UserService;

@Component
public class HttpSessionEventListener {

	@Autowired
	private UserService userService;

	@EventListener
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof AuthorizedEvent) {
			Authentication auth = ((AuthorizedEvent) event).getAuthentication();
			if (auth != null) {
				User user = userService.findByEmail(auth.getName());
				if (user != null && !user.isEnabled()) {
					throw new IllegalStateException("Sua conta está inativa.");
				}
			}
		}
	}
}