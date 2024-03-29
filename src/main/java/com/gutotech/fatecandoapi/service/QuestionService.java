package com.gutotech.fatecandoapi.service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.QuestionRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class QuestionService {
	private final int TOTAL_QUIZ_QUESTIONS = 3;

	private final int TOTAL_TEST_QUESTIONS = 10;

	@Autowired
	private QuestionRepository repository;

	public List<Question> findAll() {
		return repository.findAll();
	}
	
	public List<Question> findBySubjects(List<Subject> subjects) {
		return repository.findBySubject(subjects);
	}
	
	public List<Question> findByUser(User user) {
		return repository.findByUser(user);
	}
	
	public List<Question> findByTopic(Topic topic) {
		return repository.findByTopic(topic);
	}

	public List<Question> generateQuiz(Topic topic) {
		return getRandomQuestions(QuestionType.QUIZ, Arrays.asList(topic), TOTAL_QUIZ_QUESTIONS);
	}

	public List<Question> generateTest(List<Topic> topics) {
		return getRandomQuestions(QuestionType.TEST, topics, TOTAL_TEST_QUESTIONS);
	}

	public Question getRandomQuestion(QuestionType type, List<Topic> topics) {
		return getRandomQuestions(type, topics, 1).get(0);
	}

	public List<Question> getRandomQuestions(QuestionType type, List<Topic> topics, int quantity) {
		List<Question> questions = findByTypeAndTopicIn(type, topics);

		Collections.shuffle(questions, new SecureRandom());

		if (questions.size() > quantity) {
			return questions.subList(0, quantity);
		}

		return questions;
	}
	
	public List<Question> findByTypeAndTopicIn(QuestionType type, List<Topic> topics) {
		List<Question> questions = repository.findByTopicIn(topics);
		return questions.stream()
					.filter(question -> question.getTypes().contains(type))
					.collect(Collectors.toList());
	}

	public Question findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find question " + id));
	}

	public Question save(Question question) {
		return repository.save(question);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
