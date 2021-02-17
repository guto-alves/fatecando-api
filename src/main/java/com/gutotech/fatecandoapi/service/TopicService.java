package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;

	public List<Topic> findAll() {
		return repository.findAll();
	}

	public Topic findById(Long id) {
		return repository.findById(id).get();
	}

	public List<Topic> findAllByDiscipline(Discipline discipline) {
		return repository.findAllByDiscipline(discipline);
	}

	public void save(Topic topic) {
		repository.save(topic);
	}
}
