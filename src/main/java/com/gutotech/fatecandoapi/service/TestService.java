package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Test;
import com.gutotech.fatecandoapi.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository repository;

	public List<Test> findAll() {
		return repository.findAll();
	}

	public Test findById(Long id) {
		return repository.findById(id).get();
	}

	public void save(Test test) {
		repository.save(test);
	}
}
