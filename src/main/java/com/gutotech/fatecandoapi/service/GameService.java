package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Game;
import com.gutotech.fatecandoapi.model.GameStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.GameRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;

	public List<Game> findAll() {
		return repository.findAllByStatus(GameStatus.WAITING);
	}

	public Game findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find game " + id));
	}

	public Game findByUser(User user) {
		return repository.findByPlayers_Email(user.getEmail());
	}

	public Game save(Game game) {
		return repository.save(game);
	}
	
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
