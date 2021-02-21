package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.model.ForumTopicComment;
import com.gutotech.fatecandoapi.repository.ForumTopicCommentRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class ForumTopicCommentService {

	@Autowired
	private ForumTopicCommentRepository repository;

	public List<ForumTopicComment> findAllByForumTopic(ForumTopic forumTopic) {
		return repository.findAllByForumTopic(forumTopic);
	}

	public ForumTopicComment findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find forum topic " + id));
	}

	public ForumTopicComment save(ForumTopicComment comment) {
		return repository.save(comment);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
