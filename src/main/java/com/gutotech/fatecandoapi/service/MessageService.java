package com.gutotech.fatecandoapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Chat;
import com.gutotech.fatecandoapi.model.Message;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.MessageRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public Message findById(Long id) {
		return messageRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find message " + id));
	}

	public Message save(Message message) {
		return messageRepository.save(message);
	}
	
	public List<Message> saveAll(List<Message> messages) {
		return messageRepository.saveAll(messages);
	}

	public void delete(Long id) {
		messageRepository.deleteById(id);
	}

	@Transactional
	public void deleteAll(User user) {
		messageRepository.deleteByTo(user);
	}

	public List<Message> findByChat(Chat chat) {
		return messageRepository.findByChatOrderByDate(chat);
	}

}
