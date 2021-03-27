package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Course;
import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.repository.DisciplineRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class DisciplineService {

	@Autowired
	private DisciplineRepository repository;

	public Discipline findById(Long id) {
		return repository.findById(id)//
				.orElseThrow(() -> new ResourceNotFoundException("Could not find discipline " + id));
	}

	public List<Discipline> findAll() {
		return repository.findAllByOrderByName();
	}

	public List<Discipline> findAllBySemester(Integer semester) {
		return repository.findAllBySemesterOrderByName(semester);
	}

	public List<Discipline> findAllByCourse(Course course) {
		return repository.findAllByCourseOrderByName(course);
	}
	
	public List<Discipline> findAllWithTopics() {
		return repository.findAllWithTopics();
	}

	public Discipline save(Discipline discipline) {
		return repository.save(discipline);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
