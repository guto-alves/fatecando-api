package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Institution;
import com.gutotech.fatecandoapi.repository.InstitutionRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class InstitutionService {

	@Autowired
	private InstitutionRepository repository;

	public Institution findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find institution " + id));
	}

	public List<Institution> findAll() {
		return repository.findAllByOrderByName();
	}

	public Institution save(Institution institution) {
		return repository.save(institution);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
