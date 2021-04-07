package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.SubjectUser;
import com.gutotech.fatecandoapi.model.SubjectUserId;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.SubjectUserRepository;

@Service
public class SubjectUserService {

	@Autowired
	private SubjectUserRepository repository;

	public List<SubjectUser> findAll() {
		return repository.findAll();
	}

	public SubjectUser findById(Subject subject, User user) {
		SubjectUserId id = new SubjectUserId(subject, user);
		return repository.findById(id).orElse(new SubjectUser(id, null, false));
	}

	public SubjectUser save(SubjectUser subjectUser) {
		return repository.save(subjectUser);
	}

}
