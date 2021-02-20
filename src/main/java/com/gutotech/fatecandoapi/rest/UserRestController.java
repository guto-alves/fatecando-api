package com.gutotech.fatecandoapi.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.UserModelAssembler;
import com.gutotech.fatecandoapi.service.RewardService;
import com.gutotech.fatecandoapi.service.TopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private RewardService rewardService;

	@Autowired
	private TopicService topicService;

	@Autowired
	private UserModelAssembler assembler;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("{id}")
	public EntityModel<User> getUser(@PathVariable Long id) {
		return assembler.toModel(userService.findById(id));
	}

	@PostMapping
	public ResponseEntity<EntityModel<User>> saveUser(@RequestBody @Valid User user) {
		EntityModel<User> entityModel = assembler.toModel(userService.save(user));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<EntityModel<User>> updateUser(@RequestBody @Valid User user, @PathVariable Long id) {
		User currentUser = userService.findById(id);
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setGender(user.getGender());
		currentUser.setBirthDate(user.getBirthDate());
		currentUser.setCourse(user.getCourse());

		EntityModel<User> entityModel = assembler.toModel(userService.save(currentUser));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@GetMapping("{id}/rewards")
	public ResponseEntity<List<Reward>> getUserRewards(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(rewardService.findAllByUser(user));
	}

	@GetMapping("{id}/topics")
	public ResponseEntity<List<Topic>> getUserTopics(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(topicService.findAllByUser(user));
	}
}
