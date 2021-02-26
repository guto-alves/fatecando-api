package com.gutotech.fatecandoapi.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
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
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.TopicModelAssembler;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.TopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/topics")
public class TopicRestController {

	@Autowired
	private TopicService service;

	@Autowired
	private TopicModelAssembler assembler;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Topic>> getAllTopics() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("{id}")
	public EntityModel<Topic> getTopic(@PathVariable Long id) {
		return assembler.toModel(service.findById(id));
	}

	@PostMapping
	public ResponseEntity<EntityModel<Topic>> addTopic(@RequestBody @Valid Topic topic) {
		EntityModel<Topic> entityModel = assembler.toModel(service.save(topic));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateTopic(@RequestBody @Valid Topic topic, @PathVariable Long id) {
		Topic currentTopic = service.findById(id);
		currentTopic.setName(topic.getName());
		currentTopic.setDescription(topic.getDescription());
		currentTopic.setHtmlContent(topic.getHtmlContent());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(Roles.ADMIN_ROLE))) {
			currentTopic.setStatus(topic.getStatus());
			currentTopic.setRequired(topic.isRequired());
		}

		EntityModel<Topic> entityModel = assembler.toModel(service.save(currentTopic));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("upload")
	public ResponseEntity<EntityModel<Topic>> uploadTopic(@RequestBody @Valid Topic topic) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		topic.setUser(userService.findByEmail(email));

		topic.setStatus(UploadStatus.WAITING_FOR_RESPONSE);
		topic.setRequired(false);
		topic.getUsersWhoLiked().clear();

		EntityModel<Topic> entityModel = assembler.toModel(service.save(topic));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PostMapping("{id}/toggle-required")
	public ResponseEntity<?> makeRequired(@PathVariable Long id) {
		Topic topic = service.findById(id);

		topic.setRequired(!topic.isRequired());

		EntityModel<Topic> entityModel = assembler.toModel(service.save(topic));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PostMapping("{id}/change-status")
	public ResponseEntity<?> changeStatus(@RequestBody UploadStatus status, @PathVariable Long id) {
		Topic topic = service.findById(id);

		topic.setStatus(status);

		EntityModel<Topic> entityModel = assembler.toModel(service.save(topic));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PostMapping("{id}/like")
	public ResponseEntity<?> addLike(@PathVariable Long id) {
		User user = userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

		Topic topic = service.findById(id);

		if (topic.getUsersWhoLiked().contains(user)) {
			topic.getUsersWhoLiked().remove(user);
		} else {
			topic.getUsersWhoLiked().add(user);
		}

		EntityModel<Topic> entityModel = assembler.toModel(service.save(topic));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

}
