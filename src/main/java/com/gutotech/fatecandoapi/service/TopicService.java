package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	public List<Topic> findAll() {
		return repository.findAll();
	}

	public List<Topic> findApproved() {
		return repository.findByStatus(UploadStatus.APPROVED);
	}

	public List<Topic> findBySubject(Subject subject) {
		return repository.findBySubjectAndStatusOrderByItemOrder(subject, UploadStatus.APPROVED);
	}
	
	public List<Topic> findBySubjects(List<Subject> subjects) {
		return repository.findBySubjectInOrderByItemOrder(subjects);
	}

	public List<Topic> findByCreatedBy(User user) {
		return repository.findByCreatedBy(user);
	}

	public List<Topic> findBetween(long itemOrder1, long itemOrder2, long subjectId) {
		return repository.findBetween(itemOrder1, itemOrder2, subjectId);
	}

	public List<Topic> findFavorites(String email) {
		return repository.findFavorites(email);
	}

	public List<Topic> findAnnotated(String email) {
		return repository.findAnnotated(email);
	}

	public List<Topic> findGameTopics(Subject subject) {
		return repository.findFor(subject, QuestionType.GAME);
	}
	
	public List<Topic> findGameTopics() {
		return findGameTopics(null /* all subjects */);
	}

	public List<Topic> findTestTopics(Subject subject) {
		return repository.findFor(subject, QuestionType.TEST);
	}

	public Topic findById(Long id) {
		return repository.findById(id).get();
	}

	public Topic findByIdWithPreviousAndNext(Long id) {
		Topic topic = findById(id);

		List<Topic> topics = findBySubject(topic.getSubject());
		
		int topicIndex = topics.indexOf(topic);
		if (topicIndex - 1  >= 0) {
			topic.setPrevious(topics.get(topicIndex - 1));			
		}
		
		if (topicIndex + 1  < topics.size()) {
			topic.setNext(topics.get(topicIndex + 1));			
		}

		return topic;
	}

	public Topic save(Topic topic) {
		return repository.save(topic);
	}

	public void saveAll(List<Topic> topics) {
		repository.saveAll(topics);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
