package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.TestQuestion;
import com.gutotech.fatecandoapi.repository.TestQuestionRepository;

@Service
public class TestQuestionService {

	@Autowired
	private TestQuestionRepository repository;

	public List<TestQuestion> saveAll(List<TestQuestion> testQuestions) {
		return repository.saveAll(testQuestions);
	}
	
}
