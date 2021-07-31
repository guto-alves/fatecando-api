package com.gutotech.fatecandoapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.RewardType;
import com.gutotech.fatecandoapi.model.RewardUser;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.RewardRepository;
import com.gutotech.fatecandoapi.repository.RewardUserRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class RewardService {

	@Autowired
	private RewardRepository rewardRepository;

	@Autowired
	private RewardUserRepository rewardUserRepository;

	public List<Reward> findAll() {
		return rewardRepository.findAll();
	}

	public Reward findById(Long id) {
		return rewardRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find reward " + id));
	}

	public Reward save(Reward reward) {
		return rewardRepository.save(reward);
	}

	public RewardUser add(RewardType type, User user) {
		Reward reward = rewardRepository.findByType(type);
		RewardUser rewardUser = new RewardUser(new Date(), reward, user);
		return rewardUserRepository.save(rewardUser);
	}

}
