package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Chat;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.ChatRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class ChatService {

	@Autowired
	private ChatRepository repository;

	public Chat save(Chat chat) {
		return repository.save(chat);
	}

	public Chat findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find chat " + id));
	}

	public List<Chat> findByUser(User user) {
		return repository.findByUser(user);
	}

	public Chat getPrivateChat(User me, User user) {
		return findByUser(me).stream().filter(chat -> {
			if (chat.getUsers().contains(user) && chat.isPvt()) {
				return true;
			}
			return false;
		}).findFirst().orElse(null);
	}

}
