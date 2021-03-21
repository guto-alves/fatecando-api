package com.gutotech.fatecandoapi.rest;

import java.net.URI;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Test;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.service.QuestionService;
import com.gutotech.fatecandoapi.service.TestService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/tests")
public class TestRestController {
	private static final SecureRandom random = new SecureRandom();

	@Autowired
	private TestService testService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<Test> getTest() {
		return ResponseEntity.ok(testService.findByUser(userService.findCurrentUser()));
	}

	@PostMapping
	public ResponseEntity<Test> startTest(@RequestBody @Valid Test test) {
		User user = userService.findCurrentUser();

		if (testService.findByUser(user) != null) {
			throw new IllegalStateException("The user already has a dependent test");
		}

		List<Question> testQuestions = new ArrayList<>();

		test.getTopics().forEach((topic) -> {
			List<Question> topicQuestions = questionService.findAllByTopic(topic);

			if (topicQuestions.size() > 0) {
				testQuestions.add(topicQuestions.get(random.nextInt(topicQuestions.size())));
			}
		});

		test.setQuestions(testQuestions);
		test.setUser(userService.findCurrentUser());

		testService.save(test);

		URI uri = ServletUriComponentsBuilder //
				.fromCurrentRequest() //
				.path("{id}") //
				.buildAndExpand(test.getId()) //
				.toUri();

		return ResponseEntity.created(uri).body(test);
	}

	@DeleteMapping
	public ResponseEntity<Void> finishTest() {
		User user = userService.findCurrentUser();

		testService.deleteByUser(user);

		user.getUserActivity().incrementCompleteTests();
		userService.save(user);

		return ResponseEntity.noContent().build();
	}

}
