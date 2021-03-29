package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	public List<Topic> findAll() {
		return repository.findAll();
	}

	public List<Topic> findAllByDiscipline(Discipline discipline) {
		return repository.findAllByDisciplineOrderByItemOrder(discipline);
	}

	public List<Topic> findAllByCreatedBy(User user) {
		return repository.findAllByCreatedBy(user);
	}

	public List<Topic> findAllBetween(long itemOrder1, long itemOrder2, long disciplineId) {
		return repository.findAllBetween(itemOrder1, itemOrder2, disciplineId);
	}

	public List<Topic> findAllFavorites(String email) {
		return repository.findAllFavorites(email);
	}

	public Topic findById(Long id) {
		return repository.findById(id).get();
	}

	public Topic findByIdWithPreviousAndNext(Long id) {
		Topic topic = findById(id);

		List<Topic> previousAndNext = repository.findPreviousAndNext(topic.getItemOrder(),
				topic.getDiscipline().getId());

		if (previousAndNext.size() == 1) {
			Topic foundTopic = previousAndNext.get(0);

			if (foundTopic.getItemOrder() < topic.getItemOrder()) {
				topic.setPrevious(foundTopic);
			} else {
				topic.setNext(foundTopic);
			}
		} else if (previousAndNext.size() == 2) {
			topic.setPrevious(previousAndNext.get(0));
			topic.setNext(previousAndNext.get(1));
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
