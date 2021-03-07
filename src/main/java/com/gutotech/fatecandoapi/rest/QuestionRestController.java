package com.gutotech.fatecandoapi.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.Answer;
import com.gutotech.fatecandoapi.model.AnswerId;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.RewardType;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.QuestionModelAssembler;
import com.gutotech.fatecandoapi.service.AnswerService;
import com.gutotech.fatecandoapi.service.QuestionService;
import com.gutotech.fatecandoapi.service.RewardService;
import com.gutotech.fatecandoapi.service.TopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/questions")
public class QuestionRestController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionModelAssembler questionAssembler;

	@Autowired
	private TopicService topicService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private RewardService rewardService;

	@GetMapping
	public ResponseEntity<List<Question>> getQuestions() {
		return ResponseEntity.ok(questionService.findAll());
	}

	@GetMapping("{id}")
	public EntityModel<Question> getQuestion(@PathVariable Long id) {
		return questionAssembler.toModel(questionService.findById(id));
	}

	@GetMapping("topic/{topicId}")
	public ResponseEntity<List<Question>> getTopicQuestions(@PathVariable Long topicId) {
		Topic topic = topicService.findById(topicId);
		return ResponseEntity.ok(questionService.findAllByTopic(topic));
	}

	@PostMapping("upload")
	public ResponseEntity<?> uploadQuestion(@RequestBody @Valid Question question, HttpServletRequest request) {
		if (question.getTopic() == null || question.getUser() == null) {
			// This will throw a exception if not find the topic or user
			topicService.findById(question.getTopic().getId());
			userService.findById(question.getUser().getId());
		}

		if (question.getAlternatives().stream().noneMatch(Alternative::isCorrect)) {
			return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
					"Question must have at lest one correct alternative", request.getRequestURI()));
		}

		question.setId(null);
		question.setStatus(UploadStatus.WAITING_FOR_RESPONSE);

		EntityModel<Question> entityModel = questionAssembler.toModel(questionService.save(question));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateQuestion(@RequestBody @Valid Question updatedQuestion, @PathVariable Long id,
			HttpServletRequest request) {
		Question currentQuestion = questionService.findById(id);

		if (currentQuestion.getStatus() != UploadStatus.EDITABLE) {
			return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
					"Question is not UploadStatus.EDITABLE", request.getRequestURI()));
		}

		if (updatedQuestion.getAlternatives().stream().noneMatch(Alternative::isCorrect)) {
			return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
					"Question must have at lest one correct alternative", request.getRequestURI()));
		}

		currentQuestion.setDescription(updatedQuestion.getDescription());
		currentQuestion.setType(updatedQuestion.getType());
		currentQuestion.setAlternatives(updatedQuestion.getAlternatives());
		currentQuestion.setTopic(updatedQuestion.getTopic());
		currentQuestion.setUser(updatedQuestion.getUser());

		EntityModel<Question> entityModel = questionAssembler.toModel(questionService.save(currentQuestion));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}/change-status")
	public ResponseEntity<?> changeStatus(@RequestBody Question question, @PathVariable Long id) {
		Question currentQuestion = questionService.findById(id);

		currentQuestion.setStatus(question.getStatus());

		EntityModel<Question> entityModel = questionAssembler.toModel(questionService.save(currentQuestion));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PostMapping("{questionId}/answer/{alternativeId}")
	public ResponseEntity<Map<String, Object>> answerQuestion( //
			@PathVariable("questionId") Long questionId, //
			@PathVariable("alternativeId") Long alternativeId) {
		User user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

		Question question = questionService.findById(questionId);

		Alternative chosenAlternative = question.getAlternatives().stream() //
				.filter((a) -> a.getId() == alternativeId) //
				.findFirst() //
				.orElseThrow(() -> new ResourceNotFoundException("Could not find alternative " + alternativeId));

		Answer lastAnswer = answerService.findById(new AnswerId(user, question));

		if (lastAnswer == null) {
			lastAnswer = new Answer(user, question, false);
		}

		if (!lastAnswer.isCorrect()) {
			Reward reward;

			if (chosenAlternative.isCorrect()) {
				reward = new Reward(RewardType.RIGHT_ANSWER, user);
				user.getUserActivity().incrementRightAnswers();
			} else {
				reward = new Reward(RewardType.WRONG_ANSWER, user);
				user.getUserActivity().incrementWrongAnswers();
			}

			rewardService.save(reward);
			userService.save(user);

			lastAnswer.setCorrect(chosenAlternative.isCorrect());
			answerService.save(lastAnswer);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("correct", chosenAlternative.isCorrect());
		map.put("feedback", chosenAlternative.getFeedback());

		return ResponseEntity.ok(map);
	}

}