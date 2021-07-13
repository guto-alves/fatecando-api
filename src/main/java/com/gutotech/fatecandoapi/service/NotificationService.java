package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Notification;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;

	public Notification findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Notification> findByUser(User user) {
		return repository.findByUserOrderByIdDesc(user);
	}

	public Notification save(Notification notification) {
		return repository.save(notification);
	}

}
