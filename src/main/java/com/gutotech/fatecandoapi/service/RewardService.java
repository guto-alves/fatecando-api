package com.gutotech.fatecandoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.RewardRepository;

@Service
public class RewardService {

	@Autowired
	private RewardRepository repository;

	public List<Reward> findAllByUser(User user) {
		return repository.findAllByUserOrderByDateDesc(user);
	}

	public Reward save(Reward reward) {
		return repository.save(reward);
	}

}
