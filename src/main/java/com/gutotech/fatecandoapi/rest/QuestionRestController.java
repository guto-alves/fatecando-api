package com.gutotech.fatecandoapi.rest;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.Feedback;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.QuestionDTO;
import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.RewardType;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.QuestionModelAssembler;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.AnswerUtils;
import com.gutotech.fatecandoapi.service.QuestionService;
import com.gutotech.fatecandoapi.service.QuestionTypeService;
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
	private AnswerUtils answerUtils;

	@Autowired
	private RewardService rewardService;

	@Secured({ Roles.ADMIN, Roles.TEACHER })
	@GetMapping
	public ResponseEntity<List<Question>> getQuestions() {
		if (userService.hasRoles(Roles.TEACHER)) {
			return ResponseEntity.ok(questionService.findBySubjects(userService.findCurrentUser().getSubjects()));
		}

		return ResponseEntity.ok(questionService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getQuestion(@PathVariable Long id) {
		Question question = questionService.findById(id);

		if (question.getUser() == userService.findCurrentUser() || userService.hasRoles(Roles.TEACHER, Roles.ADMIN)) {
			return ResponseEntity.ok(new QuestionDTO(question));
		}

		return ResponseEntity.ok(question);
	}

	@Autowired
	private QuestionTypeService questionTypeService;

	@GetMapping("types")
	public ResponseEntity<List<QuestionType>> getQuestionTypes() {
		return ResponseEntity.ok(questionTypeService.findAll());
	}

	@PostMapping
	public ResponseEntity<?> addQuestion(@RequestBody @Valid Question question, HttpServletRequest request) {
		if (question.getAlternatives().stream().noneMatch(alternative -> alternative.getFeedback().isCorrect())) {
			return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
					"The question must have at lest one correct alternative", request.getRequestURI()));
		}

		User user = userService.findCurrentUser();
		question.setId(null);
		question.setTopic(topicService.findById(question.getTopic().getId()));
		question.setUser(user);
		question.setStatus(userService.hasRoles(Roles.ADMIN, Roles.TEACHER) ? UploadStatus.APPROVED
				: UploadStatus.WAITING_FOR_RESPONSE);
		question.getAlternatives().stream()
				.forEach(alternative -> alternative.getFeedback().setAlternative(alternative));

		EntityModel<Question> entityModel = questionAssembler.toModel(questionService.save(question));

		rewardService.add(RewardType.CONTRIBUTIONS, user);
		user.getUserActivity().incrementContentUploaded();
		userService.save(user);

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateQuestion(@RequestBody @Valid Question updatedQuestion, @PathVariable Long id,
			HttpServletRequest request) {
		Question currentQuestion = questionService.findById(id);

		boolean hasAdminRole = userService.hasRoles(Roles.ADMIN, Roles.TEACHER);

		if (!hasAdminRole && currentQuestion.getStatus() != UploadStatus.EDITABLE) {
			return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
					"Question is not UploadStatus.EDITABLE", request.getRequestURI()));
		}

		if (updatedQuestion.getAlternatives().stream()
				.noneMatch(alternative -> alternative.getFeedback().isCorrect())) {
			return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
					"Question must have at lest one correct alternative", request.getRequestURI()));
		}

		if (hasAdminRole) {
			currentQuestion.setStatus(updatedQuestion.getStatus());
		} else {
			currentQuestion.setStatus(UploadStatus.EDITED);
		}

		currentQuestion.setDescription(updatedQuestion.getDescription());
		currentQuestion.setTypes(updatedQuestion.getTypes());
		currentQuestion.setAlternatives(updatedQuestion.getAlternatives());
		currentQuestion.setTopic(updatedQuestion.getTopic());

		questionService.save(currentQuestion);

		return ResponseEntity.noContent().build();
	}

	@Secured({ Roles.ADMIN, Roles.TEACHER })
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
		questionService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("{questionId}/answer/{alternativeId}")
	public ResponseEntity<Feedback> answerQuestion(@PathVariable("questionId") Long questionId,
			@PathVariable("alternativeId") Long alternativeId) {
		User user = userService.findCurrentUser();

		Question question = questionService.findById(questionId);

		Alternative chosenAlternative = question.getAlternatives().stream() //
				.filter((a) -> Objects.equals(a.getId(), alternativeId)) //
				.findFirst() //
				.orElseThrow(() -> new ResourceNotFoundException("Could not find alternative " + alternativeId));

		answerUtils.saveAnswer(chosenAlternative, user);

		return ResponseEntity.ok(chosenAlternative.getFeedback());
	}

}
