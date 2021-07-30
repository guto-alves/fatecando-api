package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.ForumThread;
import com.gutotech.fatecandoapi.model.Comment;
import com.gutotech.fatecandoapi.repository.CommentRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;

	public List<Comment> findByForumThread(ForumThread forumThread) {
		return repository.findByForumThread(forumThread);
	}

	public Comment findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find forum topic " + id));
	}

	public Comment save(Comment comment) {
		return repository.save(comment);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
