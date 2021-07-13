package com.gutotech.fatecandoapi.util;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

import com.gutotech.fatecandoapi.model.Chat;
import com.gutotech.fatecandoapi.service.ChatService;
import com.gutotech.fatecandoapi.service.UserService;

@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

	@Autowired
	private ChatService chatService;

	@Autowired
	private UserService userService;

	@Override
	protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
		messages
			.simpDestMatchers("/secured/**").authenticated()
			.anyMessage().authenticated();
	}

	@Override
	protected void customizeClientInboundChannel(ChannelRegistration registration) {
		registration.interceptors(new ChannelInterceptor() {
			@Override
			public Message<?> preSend(Message<?> message, MessageChannel channel) {
				StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);

				if (StompCommand.SUBSCRIBE.equals(headerAccessor.getCommand())) {
					Principal userPrincipal = headerAccessor.getUser();

					if (!validateSubscription(userPrincipal, headerAccessor.getDestination())) {
						throw new MessagingException("No permission for this topic");
					}
				}

				return ChannelInterceptor.super.preSend(message, channel);
			}
		});
	}

	private boolean validateSubscription(Principal principal, String topicDestination) {
		if (principal == null) {
			return false;
		}

		if (topicDestination.contains("chat")) {
			Chat chat = chatService.findById(Long.parseLong(topicDestination.split("-")[1]));
			return chat.getUsers().contains(userService.findCurrentUser());
		}

		return true;
	}

	@Override
	protected boolean sameOriginDisabled() {
		return true;
	}

}