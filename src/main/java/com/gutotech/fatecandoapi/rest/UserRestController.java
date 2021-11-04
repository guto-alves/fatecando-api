package com.gutotech.fatecandoapi.rest;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

import com.gutotech.fatecandoapi.model.PasswordForm;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.RewardDTO;
import com.gutotech.fatecandoapi.model.Role;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.Ticket;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.UserDTO;
import com.gutotech.fatecandoapi.model.UserRegistration;
import com.gutotech.fatecandoapi.model.assembler.UserModelAssembler;
import com.gutotech.fatecandoapi.repository.RoleRepository;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.QuestionService;
import com.gutotech.fatecandoapi.service.TicketService;
import com.gutotech.fatecandoapi.service.TopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserModelAssembler assembler;

	@Autowired
	private TopicService topicService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private TicketService ticketService;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("{id}")
	public EntityModel<User> getUser(@PathVariable Long id) {
		return assembler.toModel(userService.findById(id));
	}

	@GetMapping("search")
	public ResponseEntity<List<User>> searchUsers(@RequestParam String filter) {
		List<User> users = userService.findByNameOrEmail(filter);
		users.remove(userService.findCurrentUser());
		return ResponseEntity.ok(users);
	}

	@PostMapping("login")
	public User login(@RequestParam String email, @RequestParam String password) {
		return userService.login(email, password);
	}

	@PostMapping
	public ResponseEntity<EntityModel<User>> registerUser(@RequestBody @Valid UserRegistration userDto) {
		User user = new User(userDto.getFullName(), userDto.getEmail(), userDto.getPassword());
		EntityModel<User> entityModel = assembler.toModel(userService.register(user));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<EntityModel<User>> updateUser(@RequestBody @Valid UserDTO updatedUser,
			@PathVariable Long id) {
		User currentUser = userService.findById(id);

		if (currentUser != userService.findCurrentUser() && !userService.hasRoles(Roles.TEACHER, Roles.ADMIN)) {
			throw new IllegalStateException("Você não tem permissão para realizar está ação.");
		}

		currentUser.setFullName(updatedUser.getFullName());
		currentUser.setDescription(updatedUser.getDescription());
		currentUser.setGender(updatedUser.getGender());
		currentUser.setBirthDate(updatedUser.getBirthDate());

		Role teacherRole = roleRepository.findByName(Roles.TEACHER);

		if (!currentUser.isTeacher() && updatedUser.isTeacher()) {
			currentUser.setAuthorizedTeacher(false);
		} else if (currentUser.isTeacher() && updatedUser.isTeacher()) {
			if (!currentUser.getSubjects().containsAll(updatedUser.getSubjects())) {
				currentUser.setAuthorizedTeacher(false);
				currentUser.getRoles().remove(teacherRole);
			}
		} else if (currentUser.isTeacher() && !updatedUser.isTeacher()) {
			currentUser.setAuthorizedTeacher(false);
			currentUser.setTeacher(false);
			currentUser.getRoles().remove(teacherRole);
			updatedUser.getSubjects().clear();
		}

		currentUser.setTeacher(updatedUser.isTeacher());
		currentUser.setSubjects(updatedUser.getSubjects());

		if (userService.hasRoles(Roles.ADMIN, Roles.TEACHER)) {
			currentUser.setEnabled(updatedUser.isEnabled());
		}

		if (userService.hasRoles(Roles.ADMIN)) {
			if (updatedUser.isAuthorizedTeacher()) {
				currentUser.getRoles().add(teacherRole);
			} else {
				currentUser.getRoles().remove(teacherRole);
			}
			currentUser.setAuthorizedTeacher(updatedUser.isAuthorizedTeacher());
		}

		EntityModel<User> entityModel = assembler.toModel(userService.save(currentUser));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("password")
	public ResponseEntity<Void> updatePassword(@RequestBody PasswordForm password) {
		User user = userService.findCurrentUser();
		userService.updatePassoword(user, password);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("me")
	public EntityModel<User> getCurrentUser() {
		return assembler.toModel(userService.findCurrentUser());
	}

	@GetMapping("me/roles")
	public ResponseEntity<Set<Role>> getUserRoles() {
		return ResponseEntity.ok(userService.findCurrentUser().getRoles());
	}

	@GetMapping("me/subjects")
	public ResponseEntity<List<Subject>> getMySubjects() {
		return ResponseEntity.ok(userService.findCurrentUser().getSubjects());
	}

	@GetMapping("{id}/subjects")
	public ResponseEntity<List<Subject>> getMySubjects(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findById(id).getSubjects());
	}

	@GetMapping("me/subjects/last-accessed")
	public ResponseEntity<List<Subject>> getLatestSubjectsAccessed() {
		return ResponseEntity.ok(userService.findCurrentUser().getAccessedSubjects());
	}

	@GetMapping("me/topics")
	public ResponseEntity<List<Topic>> getUserTopics() {
		User user = userService.findCurrentUser();
		return ResponseEntity.ok(topicService.findByCreatedBy(user));
	}

	@GetMapping("me/topics/favorites")
	public ResponseEntity<List<Topic>> getFavoriteTopics() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return ResponseEntity.ok(topicService.findFavorites(email));
	}

	@GetMapping("me/topics/annotated")
	public ResponseEntity<List<Topic>> getAnnotatedTopics() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		return ResponseEntity.ok(topicService.findAnnotated(email));
	}

	@GetMapping("me/questions")
	public ResponseEntity<List<Question>> getUserQuestions() {
		User user = userService.findCurrentUser();
		return ResponseEntity.ok(questionService.findByUser(user));
	}
	
	@GetMapping("me/tickets")
	public ResponseEntity<List<Ticket>> getUserTickets() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return ResponseEntity.ok(ticketService.findByUser(name));
	}

	@GetMapping("me/rewards")
	public ResponseEntity<List<RewardDTO>> geUserRewards() {
		User user = userService.findCurrentUser();
		List<RewardDTO> rewards = user.getUserRewards().stream() //
				.map(RewardDTO::new) //
				.collect(Collectors.toList());
		return ResponseEntity.ok(rewards);
	}

	@GetMapping("ranking")
	public ResponseEntity<List<User>> getRanking() {
		// @formatter:off
		List<User> users = userService.findAll()
				.stream()
				.filter(user -> user.getScore() > 0)
				.sorted(Comparator.comparing(User::getScore).reversed())
				.collect(Collectors.toList());
		// @formatter:on
		return ResponseEntity.ok(users);
	}

}
