package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repository;
	
	public List<Question> findAll() {
		return repository.findAll();
	}
	
	public Question findById(Long id) {
		return repository.findById(id).get();
	}
	
//	public Question findByTopic(Long id) {
//		return repository.findById(id).get();
//	}
	
	public void save(Question question) {
		repository.save(question);
	}
}
