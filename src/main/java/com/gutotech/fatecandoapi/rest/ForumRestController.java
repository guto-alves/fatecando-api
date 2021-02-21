package com.gutotech.fatecandoapi.rest;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.model.ForumTopicComment;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.ForumTopicCommentModelAssembler;
import com.gutotech.fatecandoapi.model.assembler.ForumTopicModelAssembler;
import com.gutotech.fatecandoapi.service.DisciplineService;
import com.gutotech.fatecandoapi.service.ForumTopicCommentService;
import com.gutotech.fatecandoapi.service.ForumTopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/forum-topics")
public class ForumRestController {

	@Autowired
	private ForumTopicService forumTopicService;

	@Autowired
	private ForumTopicModelAssembler forumTopicAssembler;

	@Autowired
	private UserService userService;

	@Autowired
	private DisciplineService disciplineService;

	@Autowired
	private ForumTopicCommentService commentService;

	@Autowired
	private ForumTopicCommentModelAssembler commentAssembler;

	@GetMapping
	public ResponseEntity<List<ForumTopic>> getForumTopicsByDiscipline(@RequestParam("discipline") Long disciplineId) {
		Discipline discipline = disciplineService.findById(disciplineId);

		List<ForumTopic> forumTopics = forumTopicService.findAllByDiscipline(discipline);

		return ResponseEntity.ok(forumTopics);
	}

	@GetMapping("{id}")
	public EntityModel<ForumTopic> getForumTopic(@PathVariable("id") Long id) {
		return forumTopicAssembler.toModel(forumTopicService.findById(id));
	}

	@PostMapping
	public ResponseEntity<EntityModel<ForumTopic>> addForumTopic(@RequestBody @Valid ForumTopic forumTopic) {
		if (forumTopic.getUser() == null) {
			throw new IllegalArgumentException("Forum Topic must contain the user who created it");
		}

		if (forumTopic.getDiscipline() == null) {
			throw new IllegalArgumentException("Forum Topic must have a Discipline");
		}

		User user = userService.findById(forumTopic.getUser().getId());
		forumTopic.setUser(user);

		Discipline discipline = disciplineService.findById(forumTopic.getDiscipline().getId());
		forumTopic.setDiscipline(discipline);

		EntityModel<ForumTopic> entityModel = forumTopicAssembler.toModel(forumTopicService.save(forumTopic));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteForumTopic(@PathVariable Long id) {
		forumTopicService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}/comments")
	public ResponseEntity<Set<ForumTopicComment>> getComments(@PathVariable("id") Long id) {
		ForumTopic forumTopic = forumTopicService.findById(id);
		return ResponseEntity.ok(forumTopic.getComments());
	}

	@GetMapping("{id}/comments/{commentId}")
	public EntityModel<ForumTopicComment> getComment(@PathVariable("id") Long id,
			@PathVariable("commentId") Long commentId) {
		ForumTopic forumTopic = forumTopicService.findById(id);

		ForumTopicComment comment = forumTopic.getComments().stream() //
				.filter((c) -> c.getId() == commentId) //
				.findFirst() //
				.orElseThrow(() -> new ResourceNotFoundException("Could not find comment " + commentId));

		return commentAssembler.toModel(comment);
	}

	@PostMapping("{id}/comments")
	public ResponseEntity<EntityModel<ForumTopicComment>> addComment(@RequestBody @Valid ForumTopicComment comment,
			@PathVariable("id") Long id) {
		ForumTopic forumTopic = forumTopicService.findById(id);
		comment.setForumTopic(forumTopic);

		if (comment.getUser() == null) {
			throw new IllegalArgumentException("Comment must contain the user who created it");
		}

		User user = userService.findById(comment.getUser().getId());
		comment.setUser(user);

		EntityModel<ForumTopicComment> entityModel = commentAssembler.toModel(commentService.save(comment));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

}
