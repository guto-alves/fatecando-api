package com.gutotech.fatecandoapi.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.AnswerUtils;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Test;
import com.gutotech.fatecandoapi.service.QuestionService;
import com.gutotech.fatecandoapi.service.TestService;

@RestController
@RequestMapping("api/tests")
public class TestRestController {

	@Autowired
	private TestService testService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerUtils answerUtils;

	@GetMapping("{id}")
	public ResponseEntity<Test> getTest(@PathVariable Long id) {
		return ResponseEntity.ok(testService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Test> startTest(@RequestBody @Valid Test test) {
		List<Question> testQuestions = new ArrayList<>();

		test.getTopics().forEach((topic) -> {
			List<Question> topicQuestions = questionService.findAllByTopic(topic);

			if (topicQuestions.size() > 0) {
				testQuestions.add(topicQuestions.get(0));
			}
		});

		test.setQuestions(testQuestions);
		test.setStartTimestamp(System.currentTimeMillis());

		testService.save(test);

		URI uri = ServletUriComponentsBuilder //
				.fromCurrentRequest() //
				.path("{id}") //
				.buildAndExpand(test.getId()) //
				.toUri();

		return ResponseEntity.created(uri).body(test);
	}

	@PostMapping("{id}")
	public ResponseEntity<?> finishTest(@RequestBody Map<Long, Long> questionsAndAlternativesMap,
			@PathVariable("id") Long id) {
		Test test = testService.findById(id);

		int validAnswersCount = 0;
		int totalHits = 0;
		int totalErrors = 0;

		Map<String, Object> result = new HashMap<>();

		for (Question question : test.getQuestions()) {
			if (questionsAndAlternativesMap.containsKey(question.getId())) {
				Long chosenAlternativeId = questionsAndAlternativesMap.get(question.getId());

				Alternative chosenAlternative = question.getAlternatives().stream()
						.filter((alternative) -> alternative.getId() == chosenAlternativeId) //
						.findFirst() //
						.orElse(null);

				if (chosenAlternative != null) {
					answerUtils.saveQuestionAnswer(question, chosenAlternative, test.getUser());

					if (chosenAlternative.isCorrect()) {
						totalHits++;
					} else {
						totalErrors++;
					}

					validAnswersCount++;
				} else { // invalid answers
					break;
				}
			} else { // invalid answers
				break;
			}
		}

		if (validAnswersCount != test.getQuestions().size()) {
			throw new IllegalArgumentException("Invalid answers");
		}

		testService.deleteById(id);

		result.put("totalHits", totalHits);
		result.put("totalErros", totalErrors);
		result.put("hitPercentage", totalHits / test.getQuestions().size() * 100);

		return ResponseEntity.ok(result);
	}

}
