package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Answer;
import com.gutotech.fatecandoapi.model.AnswerId;
import com.gutotech.fatecandoapi.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository repository;

	public List<Answer> findAll() {
		return repository.findAll();
	}

	public Answer findById(AnswerId id) {
		return repository.findById(id).orElse(null);
	}

	public Answer save(Answer answer) {
		return repository.save(answer);
	}

}
