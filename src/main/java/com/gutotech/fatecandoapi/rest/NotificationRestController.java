package com.gutotech.fatecandoapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Notification;
import com.gutotech.fatecandoapi.service.NotificationService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/notifications")
public class NotificationRestController {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserService userService;

	@GetMapping
	public List<Notification> getNotifications() {
		return notificationService.findByUser(userService.findCurrentUser());
	}

	@GetMapping("{id}")
	public Notification getNotification(@PathVariable Long id) throws IllegalAccessException {
		Notification notification = notificationService.findById(id);
		if (notification.getUser() != userService.findCurrentUser()) {
			throw new IllegalAccessException("Você não tem permissão para acessar esta notificação");
		}
		return notification;
	}

	@PutMapping("{id}/read")
	public Notification markAsRead(@PathVariable Long id) throws IllegalAccessException {
		Notification notification = notificationService.findById(id);
		if (notification.getUser() != userService.findCurrentUser()) {
			throw new IllegalAccessException("Você não tem permissão para modificar esta notificação");
		}
		notification.setRead(true);
		notificationService.save(notification);
		return notification;
	}

	@PutMapping("readall")
	public ResponseEntity<Void> readAll() {
		List<Notification> notifications = notificationService.findByUser(userService.findCurrentUser());
		notifications.stream().forEach(n -> n.setRead(true));
		notificationService.saveAll(notifications);
		return ResponseEntity.noContent().build();
	}

}
