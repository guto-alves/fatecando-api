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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.TopicUser;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.TopicModelAssembler;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.DisciplineService;
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
	private DisciplineService disciplineService;

	@GetMapping
	public ResponseEntity<List<Topic>> getAllTopics() {
		return ResponseEntity.ok(topicService.findAll());
	}

	@GetMapping("{id}")
	public EntityModel<Topic> getTopic(@PathVariable Long id) {
		return assembler.toModel(topicService.findById(id));
	}

	@PostMapping
	public ResponseEntity<?> addTopic(@RequestBody @Valid Topic topic, HttpServletRequest request) {
		if (topic.getDiscipline() == null || topic.getDiscipline().getId() == null) {
			return ResponseEntity.badRequest()
					.body(new ErrorResponse(HttpStatus.BAD_REQUEST, "Invalid discipline", request.getRequestURI()));
		}

		topic.setDiscipline(disciplineService.findById(topic.getDiscipline().getId()));
		topic.setCreatedBy(userService.findCurrentUser());
		topic.setStatus(UploadStatus.WAITING_FOR_RESPONSE);
		EntityModel<Topic> entityModel = assembler.toModel(topicService.save(topic));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateTopic(@RequestBody @Valid Topic topic, @PathVariable Long id,
			HttpServletRequest request) {
		Topic currentTopic = topicService.findById(id);
		currentTopic.setName(topic.getName());
		currentTopic.setDescription(topic.getDescription());
		currentTopic.setHtmlContent(topic.getHtmlContent());

		if (topic.getDiscipline() == null || topic.getDiscipline().getId() == null) {
			return ResponseEntity.badRequest().body(
					new ErrorResponse(HttpStatus.BAD_REQUEST, "Invalid topic discipline", request.getRequestURI()));
		}

		currentTopic.setDiscipline(disciplineService.findById(topic.getDiscipline().getId()));

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(Roles.ADMIN))) {
			currentTopic.setRequired(topic.isRequired());
			currentTopic.setStatus(topic.getStatus());
		}

		topicService.save(currentTopic);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
		topicService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("upload")
	public ResponseEntity<EntityModel<Topic>> uploadTopic(@RequestBody @Valid Topic topic) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		topic.setCreatedBy(userService.findByEmail(email));

		topic.setStatus(UploadStatus.WAITING_FOR_RESPONSE);
		topic.setRequired(false);

		EntityModel<Topic> entityModel = assembler.toModel(topicService.save(topic));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PostMapping("{id}/toggle-required")
	public ResponseEntity<?> makeRequired(@PathVariable Long id) {
		Topic topic = topicService.findById(id);

		topic.setRequired(!topic.isRequired());

		EntityModel<Topic> entityModel = assembler.toModel(topicService.save(topic));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PostMapping("{id}/change-status")
	public ResponseEntity<?> changeStatus(@RequestBody UploadStatus status, @PathVariable Long id) {
		Topic topic = topicService.findById(id);

		topic.setStatus(status);

		EntityModel<Topic> entityModel = assembler.toModel(topicService.save(topic));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}/like")
	public ResponseEntity<Void> toggleLike(@PathVariable Long id) {
		Topic topic = topicService.findById(id);

		TopicUser topicUser = getUserInfo(topic);

		topicUser.setLiked(!topicUser.isLiked());

		topicService.save(topic);

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

	@PutMapping("{id}/annotation")
	public ResponseEntity<Void> saveAnnotation(@RequestBody String annotation, @PathVariable Long id) {
		Topic topic = topicService.findById(id);

		TopicUser topicUser = getUserInfo(topic);

		topicUser.setAnnotation(annotation);

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

	@PutMapping("drag/{draggedTopicId}/{relatedTopicId}")
	public ResponseEntity<Void> dragTopic(@PathVariable("draggedTopicId") Long draggedTopicId,
			@PathVariable("relatedTopicId") Long relatedTopicId) {
		Topic draggedTopic = topicService.findById(draggedTopicId);
		Topic relatedTopic = topicService.findById(relatedTopicId);

		List<Topic> topics = draggedTopic.getItemOrder() < relatedTopic.getItemOrder()
				? topicService.findAllBetween(draggedTopic.getItemOrder(), relatedTopic.getItemOrder(),
						draggedTopic.getDiscipline().getId())
				: topicService.findAllBetween(relatedTopic.getItemOrder(), draggedTopic.getItemOrder(),
						draggedTopic.getDiscipline().getId());

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
