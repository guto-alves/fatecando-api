package com.gutotech.fatecandoapi.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.RewardDTO;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/rewards")
public class RewardRestController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<RewardDTO>> geUserRewards() {
		User user = userService.findCurrentUser();
		List<RewardDTO> rewards = user.getUserRewards().stream()
				.map(RewardDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(rewards);
	}

}
