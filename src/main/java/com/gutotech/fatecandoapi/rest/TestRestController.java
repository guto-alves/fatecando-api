package com.gutotech.fatecandoapi.rest;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.Feedback;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.Test;
import com.gutotech.fatecandoapi.model.TestQuestion;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.service.AlternativeService;
import com.gutotech.fatecandoapi.service.AnswerUtils;
import com.gutotech.fatecandoapi.service.QuestionService;
import com.gutotech.fatecandoapi.service.SubjectService;
import com.gutotech.fatecandoapi.service.TestQuestionService;
import com.gutotech.fatecandoapi.service.TestService;
import com.gutotech.fatecandoapi.service.TopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/tests")
public class TestRestController {

	@Autowired
	private TestService testService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private TestQuestionService testQuestionService;
	
	@Autowired
	private AnswerUtils answerUtils;
	
	@Autowired
	private TopicService topicService;
	
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

		Subject subject = subjectService.findById(test.getSubject().getId());

		List<Topic> validTopics = topicService.findTestTopics(subject);

		if (!validTopics.containsAll(test.getTopics())) {
			throw new IllegalArgumentException("The chosen topics must be of the same Subject!");
		}
		
		test.setSubject(subject);
		test.setUser(user);		
		testService.save(test);
		
		List<TestQuestion> questions = questionService.generateTest(test.getTopics())
				.stream()
				.map(question -> new TestQuestion(test, question))
				.collect(Collectors.toList());
		
		test.setTestQuestions(testQuestionService.saveAll(questions));

		URI uri = ServletUriComponentsBuilder //
				.fromCurrentRequest() //
				.build().toUri();

		return ResponseEntity.created(uri).body(test);
	}
	
	@Autowired
	private AlternativeService alternativeService;
	
	@PostMapping("check")
	public ResponseEntity<List<Feedback>> checkAnswers(@RequestBody Set<Long> alternativeIds) {
		User user = userService.findCurrentUser();
		Test test = testService.findByUser(user);
		
		if (test == null) {
			throw new IllegalStateException("No active test");
		}
		
		List<Alternative> validAlternatives = test.getTestQuestions().stream()
			.map((a) -> a.getQuestion().getAlternatives())
			.flatMap(List::stream)
			.collect(Collectors.toList());
		
		List<Alternative> chosenAlternatives = alternativeService.findByIdIn(alternativeIds);
		
		if (validAlternatives.containsAll(chosenAlternatives)) {
			if (chosenAlternatives.stream().map(Alternative::getQuestion).distinct().count() != 
					test.getTestQuestions().size()) {
				throw new IllegalArgumentException("Você esqueceu de responder alguma(s) pergunta(s)");
			}
			
			chosenAlternatives.forEach((alternative) -> answerUtils.saveAnswer(alternative, user));
			
			return ResponseEntity.ok(chosenAlternatives.stream()
				.map(Alternative::getFeedback)
				.collect(Collectors.toList()));
		}
		
		throw new IllegalArgumentException("Invalid alternative id");
	}

	@DeleteMapping
	public ResponseEntity<Void> finishTest() {
		User user = userService.findCurrentUser();

		testService.delete(testService.findByUser(user));

		user.getUserActivity().incrementCompleteTests();
		userService.save(user);

		return ResponseEntity.noContent().build();
	}

}
