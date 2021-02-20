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
		return repository.findAllByDiscipline(discipline);
	}

	public List<Topic> findAllByUser(User user) {
		return repository.findAllByUser(user);
	}

	public Topic findById(Long id) {
		return repository.findById(id).get();
	}

	public Topic save(Topic topic) {
		return repository.save(topic);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
