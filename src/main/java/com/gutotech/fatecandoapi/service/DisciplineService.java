package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.repository.DisciplineRepository;

@Service
public class DisciplineService {

	@Autowired
	private DisciplineRepository repository;

	public List<Discipline> findAll() {
		return repository.findAll();
	}

	public Discipline findById(Long id) {
		return repository.findById(id).get();
	}
	
	public Discipline findAllBySemester(Integer semester) {
		return repository.findAllBySemester(semester).get();
	}

	public void save(Discipline discipline) {
		repository.save(discipline);
	}
}
