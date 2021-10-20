package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.repository.QuestionTypeRepository;

@Service
public class QuestionTypeService {

	@Autowired
	private QuestionTypeRepository repository;

	
	public List<QuestionType> findAll() {
		return repository.findAll();
	}
	
	public QuestionType save(QuestionType type) {
		return repository.save(type);
	}

}
