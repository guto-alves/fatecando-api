package com.gutotech.fatecandoapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.service.RewardService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/rewards")
public class RewardsRestController {

	@Autowired
	private RewardService rewardService;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Reward>> geUserRewards() {
		User user = userService.findCurrentUser();
		return ResponseEntity.ok(rewardService.findByUser(user));
	}

}
