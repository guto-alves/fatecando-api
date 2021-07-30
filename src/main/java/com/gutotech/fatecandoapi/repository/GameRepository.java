package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Game;
import com.gutotech.fatecandoapi.model.GameStatus;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	List<Game> findByStatus(GameStatus status);

	Game findByPlayers_Email(String email);

}
