package com.gutotech.fatecandoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Game;
import com.gutotech.fatecandoapi.repository.GameRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;

	public Game save(Game game) {
		return repository.save(game);
	}

	public Game findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find game " + id));
	}
}
