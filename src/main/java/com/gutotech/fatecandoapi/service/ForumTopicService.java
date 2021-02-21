package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.repository.ForumTopicRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class ForumTopicService {

	@Autowired
	private ForumTopicRepository repository;

	public List<ForumTopic> findAllByDiscipline(Discipline discipline) {
		return repository.findAllByDiscipline(discipline);
	}

	public ForumTopic findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find forum topic " + id));
	}

	public ForumTopic save(ForumTopic forumTopic) {
		return repository.save(forumTopic);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
