package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.repository.ForumTopicRepository;

@Service
public class ForumTopicService {

	@Autowired
	private ForumTopicRepository repository;

	public List<ForumTopic> findAll() {
		return repository.findAll();
	}

	public List<ForumTopic> findAllByDiscipline(Discipline discipline) {
		return repository.findAllByDiscipline(discipline);
	}

	public ForumTopic findById(Long id) {
		return repository.findById(id).get();
	}

	public void save(ForumTopic student) {
		repository.save(student);
	}

}
