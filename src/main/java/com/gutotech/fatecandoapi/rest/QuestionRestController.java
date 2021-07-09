package com.gutotech.fatecandoapi.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.RewardType;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.QuestionModelAssembler;
import com.gutotech.fatecandoapi.security.Roles;
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

	@Secured(Roles.ADMIN)
	@GetMapping
	public ResponseEntity<List<Question>> getQuestions() {
		return ResponseEntity.ok(questionService.findAll());
	}

	@GetMapping("{id}")
	public EntityModel<Question> getQuestion(@PathVariable Long id) {
		return questionAssembler.toModel(questionService.findById(id));
	}

	@GetMapping("types")
	public ResponseEntity<QuestionType[]> getQuestionTypes() {
		return ResponseEntity.ok(QuestionType.values());
	}

	@PostMapping
	public ResponseEntity<?> addQuestion(@RequestBody @Valid Question question, HttpServletRequest request) {
		if (question.getAlternatives().stream().noneMatch(Alternative::isCorrect)) {
			return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
					"The question must have at lest one correct alternative", request.getRequestURI()));
		}

		question.setId(null);
		question.setTopic(topicService.findById(question.getTopic().getId()));
		question.setUser(userService.findCurrentUser());
		question.setStatus(UploadStatus.WAITING_FOR_RESPONSE);

		EntityModel<Question> entityModel = questionAssembler.toModel(questionService.save(question));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateQuestion(@RequestBody @Valid Question updatedQuestion, @PathVariable Long id,
			HttpServletRequest request) {
		Question currentQuestion = questionService.findById(id);

		boolean hasAdminRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(Roles.ADMIN));

		if (!hasAdminRole && currentQuestion.getStatus() != UploadStatus.EDITABLE) {
			return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
					"Question is not UploadStatus.EDITABLE", request.getRequestURI()));
		}

		if (updatedQuestion.getAlternatives().stream().noneMatch(Alternative::isCorrect)) {
			return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
					"Question must have at lest one correct alternative", request.getRequestURI()));
		}

		if (hasAdminRole) {
			currentQuestion.setStatus(updatedQuestion.getStatus());
		}

		currentQuestion.setDescription(updatedQuestion.getDescription());
		currentQuestion.setType(updatedQuestion.getType());
		currentQuestion.setAlternatives(updatedQuestion.getAlternatives());
		currentQuestion.setTopic(updatedQuestion.getTopic());

		questionService.save(currentQuestion);

		return ResponseEntity.noContent().build();
	}

	@PostMapping("{questionId}/answer/{alternativeId}")
	public ResponseEntity<Map<String, Object>> answerQuestion( //
			@PathVariable("questionId") Long questionId, //
			@PathVariable("alternativeId") Long alternativeId) {
		User user = userService.findCurrentUser();

		Question question = questionService.findById(questionId);

		Alternative chosenAlternative = question.getAlternatives().stream() //
				.filter((a) -> Objects.equals(a.getId(), alternativeId)) //
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
