package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Course;
import com.gutotech.fatecandoapi.repository.CourseRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;

	public Course findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find course " + id));
	}

	public List<Course> findAll() {
		return repository.findAllByOrderByName();
	}

	public Course save(Course course) {
		return repository.save(course);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
