package com.gutotech.fatecandoapi.rest;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gutotech.fatecandoapi.model.Message;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.service.MessageService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/messages")
public class MessageRestController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Message>> getMessages() {
		User user = userService.findCurrentUser();
		return ResponseEntity.ok(messageService.findAllByRecipient(user));
	}

	@PostMapping
	public ResponseEntity<Message> sendMessage(@RequestBody @Valid Message message, HttpServletRequest request) {
		User user = userService.findCurrentUser();
		message.setFrom(user);

		if (message.getTo() == null || message.getTo().getEmail() == null) {
			throw new IllegalArgumentException("Please provide the recipient's email.");
		}

		User recipient = userService.findByEmail(message.getTo().getEmail());
		message.setTo(recipient);

		Message savedMessage = messageService.save(message);

		// @formatter:off
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("{id}")
			.buildAndExpand(savedMessage.getId())
			.toUri();
		// @formatter:on

		return ResponseEntity.created(uri).body(savedMessage);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
		Message message = messageService.findById(id);

		if (message.getTo() == userService.findCurrentUser()) {
			messageService.delete(message.getId());
		}

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteAll() {
		User user = userService.findCurrentUser();
		messageService.deleteAll(user);
		return ResponseEntity.noContent().build();
	}

}
