package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Notification;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.UploadStatus;
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

	public void saveAll(List<Notification> notifications) {
		repository.saveAll(notifications);
	}

	public Notification save(Topic topic) {
		Notification notification = null;

		if (topic.getStatus() == UploadStatus.APPROVED) {
			notification = new Notification("Seu tópico " + topic.getName() + " foi aprovado!",
					"/topic/" + topic.getId(), topic.getCreatedBy());
		} else if (topic.getStatus() == UploadStatus.DISAPPROVED) {
			notification = new Notification("Seu tópico " + topic.getName() + " foi considerado spam!", "/users/topics",
					topic.getCreatedBy());
		} else if (topic.getStatus() == UploadStatus.EDITABLE) {
			notification = new Notification(
					"Revisamos seu tópico " + topic.getName() + " e vimos que pode ser melhorado!", "users/topics",
					topic.getCreatedBy());
		}

		return notification != null ? save(notification) : null;
	}

	public Notification save(Question question) {
		Notification notification = null;

		if (question.getStatus() == UploadStatus.APPROVED) {
			notification = new Notification("Questão aprovada!", "/questions/" + question.getId(), question.getUser());
		} else if (question.getStatus() == UploadStatus.DISAPPROVED) {
			notification = new Notification("Questão reprovada!", "/questions", question.getUser());
		} else if (question.getStatus() == UploadStatus.EDITABLE) {
			notification = new Notification("Revisamos sua questão e vimos que pode ser melhorada!", "/questions",
					question.getUser());
		}

		return notification != null ? save(notification) : null;
	}
}
