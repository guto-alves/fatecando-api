package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Course;
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
		return repository.findAllByOrderByName();
	}

	public List<Subject> findAllBySemester(Integer semester) {
		return repository.findAllBySemesterOrderByName(semester);
	}

	public List<Subject> findAllByCourse(Course course) {
		return repository.findAllByCourseOrderByName(course);
	}

	public List<Subject> findAllWithTopics() {
		return repository.findAllWithTopics();
	}

	public Subject save(Subject subject) {
		return repository.save(subject);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
