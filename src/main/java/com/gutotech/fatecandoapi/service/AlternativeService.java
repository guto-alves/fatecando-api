package com.gutotech.fatecandoapi.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.repository.AlternativeRepository;

@Service
public class AlternativeService {

	@Autowired
	private AlternativeRepository repository;

	public List<Alternative> findByIdIn(Set<Long> ids) {
		return repository.findByIdIn(ids);
	}
	
}
