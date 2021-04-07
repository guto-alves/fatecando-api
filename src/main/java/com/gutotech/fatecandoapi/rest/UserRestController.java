package com.gutotech.fatecandoapi.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.UserModelAssembler;
import com.gutotech.fatecandoapi.service.TopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserRestController {

	@Autowired
	private UserService userService;

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

	@GetMapping("me")
	public EntityModel<User> getCurrentUser() {
		return assembler.toModel(userService.findCurrentUser());
	}

	@GetMapping("me/disciplines/last-accessed")
	public ResponseEntity<List<Subject>> getLatestSubjectsAccessed() {
		return ResponseEntity.ok(userService.findCurrentUser().getDisciplines());
	}

	@GetMapping("me/topics")
	public ResponseEntity<List<Topic>> getUserTopics() {
		User user = userService.findCurrentUser();
		return ResponseEntity.ok(topicService.findAllByCreatedBy(user));
	}

	@GetMapping("me/topics/favorites")
	public ResponseEntity<List<Topic>> getFavoriteTopics() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return ResponseEntity.ok(topicService.findAllFavorites(email));
	}

	@GetMapping("me/topics/annotated")
	public ResponseEntity<List<Topic>> getAnnotatedTopics() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return ResponseEntity.ok(topicService.findAllAnnotated(email));
	}

	@PostMapping("login")
	public User login(@RequestParam("email") String email, @RequestParam("password") String password) {
		return userService.login(email, password);
	}

	@PostMapping
	public ResponseEntity<EntityModel<User>> registerUser(@RequestBody @Valid User user) {
		EntityModel<User> entityModel = assembler.toModel(userService.register(user));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<EntityModel<User>> updateUser(@RequestBody @Valid User user, @PathVariable Long id) {
		User currentUser = userService.findById(id);
		currentUser.setFullName(user.getFullName());
		currentUser.setGender(user.getGender());
		currentUser.setBirthDate(user.getBirthDate());
		currentUser.setCourse(user.getCourse());

		EntityModel<User> entityModel = assembler.toModel(userService.save(currentUser));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

}
