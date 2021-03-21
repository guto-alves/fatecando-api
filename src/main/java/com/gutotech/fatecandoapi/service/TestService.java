package com.gutotech.fatecandoapi.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Test;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.TestRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class TestService {

	@Autowired
	private TestRepository repository;

	public Test findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find test " + id));
	}

	public Test findByUser(User user) {
		return repository.findByUser(user).orElse(null);
	}

	public Test save(Test test) {
		return repository.save(test);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	public void deleteByUser(User user) {
		repository.deleteByUser(user);
	}

}
