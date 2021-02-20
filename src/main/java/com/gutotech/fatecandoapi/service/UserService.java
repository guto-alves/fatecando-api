package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.UserRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User findById(Long id) {
		return repository.findById(id) //
				.orElseThrow(() -> new ResourceNotFoundException("Could not find user " + id));
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User save(User user) {
		return repository.save(user);
	}
}
