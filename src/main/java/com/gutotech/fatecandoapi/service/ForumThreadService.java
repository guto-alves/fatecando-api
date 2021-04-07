package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.ForumThread;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.repository.ForumThreadRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class ForumThreadService {

	@Autowired
	private ForumThreadRepository repository;

	public List<ForumThread> findAllBySubject(Subject subject) {
		return repository.findAllBySubject(subject);
	}

	public ForumThread findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find forum topic " + id));
	}

	public ForumThread save(ForumThread forumThread) {
		return repository.save(forumThread);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
