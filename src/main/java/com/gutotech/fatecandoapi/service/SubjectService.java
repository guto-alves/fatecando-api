package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.repository.SubjectRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository repository;

	public Subject findById(Long id) {
		return repository.findById(id) //
				.orElseThrow(() -> new ResourceNotFoundException("Could not find subject " + id));
	}

	public List<Subject> findAll() {
		return repository.findByOrderByName();
	}
	
	public List<Subject> findAllEnabled() {
		return repository.findEnabledByOrderByName();
	}

	public List<Subject> findBySemester(Integer semester) {
		return repository.findBySemesterOrderByName(semester);
	}

	public List<Subject> findWithTopics() {
		return repository.findWithTopics();
	}

	public List<Subject> findBy(String text) {
		return repository.findBy(text);
	}

	public Subject save(Subject subject) {
		return repository.save(subject);
	}
	
}
