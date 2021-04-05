package com.gutotech.fatecandoapi.service;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.repository.QuestionRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repository;

	public List<Question> findAll() {
		return repository.findAll();
	}

	public List<Question> findAllByTopic(Topic topic) {
		return repository.findAllByTopic(topic);
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
		return repository.findByTypeAndTopicIn(type, topics);
	}

	public Question findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Could not find question " + id));
	}

	public Question save(Question question) {
		return repository.save(question);
	}
}
