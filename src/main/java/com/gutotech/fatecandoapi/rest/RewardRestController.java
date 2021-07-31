package com.gutotech.fatecandoapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.RewardType;
import com.gutotech.fatecandoapi.service.RewardService;

@RestController
@RequestMapping("api/rewards")
public class RewardRestController {

	@Autowired
	private RewardService rewardService;

	@GetMapping
	public ResponseEntity<List<Reward>> getRewards() {
		return ResponseEntity.ok(rewardService.findAll());
	}

	@GetMapping("types")
	public ResponseEntity<RewardType[]> getRewardTypes() {
		return ResponseEntity.ok(RewardType.values());
	}

}
