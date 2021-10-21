package com.gutotech.fatecandoapi.rest;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Review;
import com.gutotech.fatecandoapi.model.RewardType;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.TopicUser;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.TopicModelAssembler;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.NotificationService;
import com.gutotech.fatecandoapi.service.QuestionService;
import com.gutotech.fatecandoapi.service.RewardService;
import com.gutotech.fatecandoapi.service.SubjectService;
import com.gutotech.fatecandoapi.service.TopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/topics")
public class TopicRestController {

	@Autowired
	private TopicService topicService;

	@Autowired
	private TopicModelAssembler assembler;

	@Autowired
	private UserService userService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private RewardService rewardService;

	@GetMapping
	public ResponseEntity<List<Topic>> getApprovedTopics() {
		return ResponseEntity.ok(topicService.findApproved());
	}

	@Secured({ Roles.ADMIN, Roles.TEACHER })
	@GetMapping("admin")
	public ResponseEntity<List<Topic>> getTopics() {
		if (userService.hasRoles(Roles.TEACHER)) {
			return ResponseEntity.ok(topicService.findBySubjects(userService.findCurrentUser().getSubjects()));
		}

		return ResponseEntity.ok(topicService.findAll());
	}

	@GetMapping("{id}")
	public EntityModel<Topic> getTopic(@PathVariable Long id,
			@RequestParam(name = "previous-next", required = false, defaultValue = "false") boolean withPreviousAndNext) {
		Topic topic;

		if (withPreviousAndNext) {
			topic = topicService.findByIdWithPreviousAndNext(id);
		} else {
			topic = topicService.findById(id);
		}

		return assembler.toModel(topic);
	}

	@PostMapping
	public ResponseEntity<?> addTopic(@RequestBody @Valid Topic topic, HttpServletRequest request) {
		if (topic.getSubject() == null || topic.getSubject().getId() == null) {
			return ResponseEntity.badRequest()
					.body(new ErrorResponse(HttpStatus.BAD_REQUEST, "Invalid subject", request.getRequestURI()));
		}

		User user = userService.findCurrentUser();

		topic.setSubject(subjectService.findById(topic.getSubject().getId()));
		topic.setCreatedBy(user);
		topic.setStatus(userService.hasRoles(Roles.ADMIN, Roles.TEACHER) ? UploadStatus.APPROVED
				: UploadStatus.WAITING_FOR_RESPONSE);

		EntityModel<Topic> entityModel = assembler.toModel(topicService.save(topic));

		rewardService.add(RewardType.CONTRIBUTIONS, user);
		user.getUserActivity().incrementContentUploaded();
		userService.save(user);

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateTopic(@RequestBody @Valid Topic updatedTopic, @PathVariable Long id,
			HttpServletRequest request) {
		Topic currentTopic = topicService.findById(id);

		if (userService.hasRoles(Roles.ADMIN, Roles.TEACHER)) {
			if (updatedTopic.getSubject() == null || updatedTopic.getSubject().getId() == null) {
				return ResponseEntity.badRequest().body(
						new ErrorResponse(HttpStatus.BAD_REQUEST, "Invalid topic subject", request.getRequestURI()));
			}

			currentTopic.setName(updatedTopic.getName());
			currentTopic.setDescription(updatedTopic.getDescription());
			currentTopic.setBodyHtml(updatedTopic.getBodyHtml());
			currentTopic.setRequired(updatedTopic.isRequired());
			currentTopic.setStatus(updatedTopic.getStatus());
			currentTopic.setSubject(updatedTopic.getSubject());

			notificationService.save(currentTopic);
		} else { // common user
			if (!SecurityContextHolder.getContext().getAuthentication().getName()
					.equals(currentTopic.getCreatedBy().getEmail())) {
				return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
						"You are trying to edit a topic that you did not create", request.getRequestURI()));
			}

			if (currentTopic.getStatus() != UploadStatus.EDITABLE) {
				return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST,
						"Topic status does not allow edits", request.getRequestURI()));
			}

			currentTopic.setName(updatedTopic.getName());
			currentTopic.setDescription(updatedTopic.getDescription());
			currentTopic.setBodyHtml(updatedTopic.getBodyHtml());
			currentTopic.setStatus(UploadStatus.EDITED);
		}

		topicService.save(currentTopic);

		return ResponseEntity.noContent().build();
	}

	@Secured(Roles.ADMIN)
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
		topicService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}/finished")
	public ResponseEntity<Void> toggleFinished(@PathVariable Long id) {
		Topic topic = topicService.findById(id);

		TopicUser topicUser = getUserInfo(topic);

		topicUser.setFinished(!topicUser.isFinished());

		if (topicUser.isFinished()) {
			topicUser.setFinishDate(new Date());
		} else {
			topicUser.setFinishDate(null);
		}

		topicService.save(topic);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}/favorite")
	public ResponseEntity<Void> toggleFavorite(@PathVariable Long id) {
		Topic topic = topicService.findById(id);

		TopicUser topicUser = getUserInfo(topic);

		topicUser.setFavorite(!topicUser.isFavorite());

		topicService.save(topic);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}/annotation")
	public ResponseEntity<Void> saveAnnotation(@RequestBody String annotation, @PathVariable Long id) {
		Topic topic = topicService.findById(id);

		TopicUser topicUser = getUserInfo(topic);

		topicUser.setAnnotation(annotation);

		topicService.save(topic);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}/review")
	public ResponseEntity<Void> saveReview(@RequestBody Review review, @PathVariable Long id) {
		Topic topic = topicService.findById(id);

		TopicUser topicUser = getUserInfo(topic);

		topicUser.setReview(review);

		topicService.save(topic);

		return ResponseEntity.noContent().build();
	}

	@Secured({ Roles.ADMIN, Roles.TEACHER })
	@GetMapping("{id}/reviews")
	public ResponseEntity<List<Review>> getReviews(@PathVariable Long id) {
		Topic topic = topicService.findById(id);

		return ResponseEntity.ok(topic.getReviews());
	}

	@Secured({ Roles.ADMIN, Roles.TEACHER })
	@PutMapping("drag/{draggedTopicId}/{relatedTopicId}")
	public ResponseEntity<Void> dragTopic(@PathVariable("draggedTopicId") Long draggedTopicId,
			@PathVariable("relatedTopicId") Long relatedTopicId) {
		Topic draggedTopic = topicService.findById(draggedTopicId);
		Topic relatedTopic = topicService.findById(relatedTopicId);

		User currentUser = userService.findCurrentUser();
		if (userService.hasRoles(Roles.TEACHER) && !currentUser.getSubjects().contains(draggedTopic.getSubject())) {
			throw new IllegalStateException("Você não tem permissão para alterar a ordem dos tópicos da disciplina "
					+ draggedTopic.getSubject().getName());
		}

		List<Topic> topics = draggedTopic.getItemOrder() < relatedTopic.getItemOrder()
				? topicService.findBetween(draggedTopic.getItemOrder(), relatedTopic.getItemOrder(),
						draggedTopic.getSubject().getId())
				: topicService.findBetween(relatedTopic.getItemOrder(), draggedTopic.getItemOrder(),
						draggedTopic.getSubject().getId());

		final int TOTAL_TOPICS = topics.size();

		Topic firstTopic = topics.get(0);
		Topic lastTopic = topics.get(TOTAL_TOPICS - 1);

		if (TOTAL_TOPICS == 2) {
			long aux = firstTopic.getItemOrder();
			firstTopic.setItemOrder(lastTopic.getItemOrder());
			lastTopic.setItemOrder(aux);
		} else if (draggedTopic.getItemOrder() < relatedTopic.getItemOrder()) {
			for (Topic topic : topics) {
				topic.setItemOrder(topic.getItemOrder() - 1);
			}

			firstTopic.setItemOrder(firstTopic.getItemOrder() + TOTAL_TOPICS);
		} else {
			for (Topic topic : topics) {
				topic.setItemOrder(topic.getItemOrder() + 1);
			}

			lastTopic.setItemOrder(lastTopic.getItemOrder() - TOTAL_TOPICS);
		}

		topicService.saveAll(topics);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}/quiz")
	public ResponseEntity<List<Question>> getQuiz(@PathVariable Long id) {
		Topic topic = topicService.findById(id);
		return ResponseEntity.ok(questionService.generateQuiz(topic));
	}

	@Secured({ Roles.ADMIN, Roles.TEACHER })
	@GetMapping("{id}/questions")
	public ResponseEntity<List<Question>> getTopicQuestions(@PathVariable Long id) {
		Topic topic = topicService.findById(id);
		return ResponseEntity.ok(questionService.findByTopic(topic));
	}

	private TopicUser getUserInfo(Topic topic) {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

		TopicUser topicUser = topic.getTopicUsers().stream()
				.filter(info -> info.getUser().getEmail().equals(currentUserEmail)) //
				.findFirst() //
				.orElse(null);

		if (topicUser == null) {
			User currentUser = userService.findCurrentUser();

			topicUser = new TopicUser(currentUser, topic);

			topic.getTopicUsers().add(topicUser);
		}

		return topicUser;
	}

}
