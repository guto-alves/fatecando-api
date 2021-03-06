package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Notification;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;

	@Autowired
	private UserService userService;

	public Notification findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Notification> findByUser(User user) {
		return repository.findByUserOrderByIdDesc(user);
	}

	public Notification save(Notification notification) {
		return repository.save(notification);
	}
	
	public void saveAll(List<Notification> notifications) {
		repository.saveAll(notifications);
	}

}
