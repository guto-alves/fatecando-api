package com.gutotech.fatecandoapi.rest;

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
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.model.ForumTopicComment;
import com.gutotech.fatecandoapi.model.assembler.ForumTopicCommentModelAssembler;
import com.gutotech.fatecandoapi.model.assembler.ForumTopicModelAssembler;
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
	private ForumTopicCommentService commentService;

	@Autowired
	private ForumTopicCommentModelAssembler commentAssembler;

	@Autowired
	private UserService userService;

	@GetMapping("{id}")
	public EntityModel<ForumTopic> getForumTopic(@PathVariable Long id) {
		return forumTopicAssembler.toModel(forumTopicService.findById(id));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteForumTopic(@PathVariable Long id) {
		forumTopicService.deleteById(id);
		return ResponseEntity.noContent().build();
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

	@GetMapping("{id}/comments")
	public ResponseEntity<Set<ForumTopicComment>> getComments(@PathVariable("id") Long id) {
		ForumTopic forumTopic = forumTopicService.findById(id);
		return ResponseEntity.ok(forumTopic.getComments());
	}

	@PostMapping("{id}/comments")
	public ResponseEntity<EntityModel<ForumTopicComment>> addComment(@PathVariable("id") Long id,
			@RequestBody @Valid ForumTopicComment comment) {
		ForumTopic forumTopic = forumTopicService.findById(id);

		comment.setForumTopic(forumTopic);

		comment.setUser(userService.findCurrentUser());

		EntityModel<ForumTopicComment> entityModel = commentAssembler.toModel(commentService.save(comment));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

}
