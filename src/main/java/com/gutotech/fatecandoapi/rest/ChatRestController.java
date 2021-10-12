package com.gutotech.fatecandoapi.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Chat;
import com.gutotech.fatecandoapi.model.Message;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.service.ChatService;
import com.gutotech.fatecandoapi.service.MessageService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/chats")
public class ChatRestController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserService userService;

	@Autowired
	private ChatService chatService;

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@GetMapping
	public ResponseEntity<List<Chat>> getChats() {
		User user = userService.findCurrentUser();
		return ResponseEntity.ok(chatService.findByUser(user));
	}

	@GetMapping("{id}")
	public ResponseEntity<List<Message>> getMessages(@PathVariable Long id) {
		Chat chat = chatService.findById(id);
		User user = userService.findCurrentUser();

		if (!chat.getUsers().contains(user)) {
			throw new IllegalArgumentException("You don't have permission to access the messages of the chat " + id);
		}

		return ResponseEntity.ok(messageService.findByChat(chat));
	}

	@GetMapping("messages/private/{email}")
	public ResponseEntity<List<Message>> getPrivateMessages(@PathVariable String email) {
		Chat chat = chatService.getPrivateChat(userService.findCurrentUser(), userService.findByEmail(email));
		return ResponseEntity.ok(messageService.findByChat(chat));
	}

	@GetMapping("messages/{id}")
	public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
		Message message = messageService.findById(id);

		if (message.getFrom() == userService.findCurrentUser()) {
			messageService.delete(message.getId());
		}

		return ResponseEntity.noContent().build();
	}

	@MessageMapping("/messages")
	public void sendSpecific(@Payload Message message, Principal user, @Header("simpSessionId") String sessionId)
			throws Exception {
		final boolean hasChatId = message.getChat() != null && message.getChat().getId() != null;
		final boolean hasRecipient = message.getTo() != null && StringUtils.hasText(message.getTo().getEmail());

		if (!hasChatId && !hasRecipient) {
			throw new IllegalArgumentException("Please provide the recipient's email or a chat id.");
		}

		message.setFrom(userService.findCurrentUser());
		message.setNewMessage(true);

		if (hasRecipient) {
			message.setTo(userService.findByEmail(message.getTo().getEmail()));
		}

		if (hasChatId) {
			Chat chat = chatService.findById(message.getChat().getId());
			message.setChat(chat);
		} else {
			Chat chat = chatService.getPrivateChat(message.getFrom(), message.getTo());

			if (chat == null) {
				chat = new Chat(message.getFrom(), message.getTo(), true);
				chatService.save(chat);
			}

			message.setChat(chat);
		}

		if (message.getChat().getUsers().contains(message.getFrom()) && !message.getChat().isBlocked()) {
			messageService.save(message);

			Chat chat = message.getChat();
			chat.setLastMessage(message);
			chatService.save(chat);

			message.getChat().getUsers().forEach((u) -> {
				simpMessagingTemplate.convertAndSendToUser(u.getEmail(), "/secured/user/queue/specific-user",
						chatService.findByUser(u));
			});

			simpMessagingTemplate.convertAndSend("/secured/message/queue/chat-" + chat.getId(),
					messageService.findByChat(chat));
		}
	}

}
