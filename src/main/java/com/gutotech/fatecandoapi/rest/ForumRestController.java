package com.gutotech.fatecandoapi.rest;

import java.util.Objects;
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

import com.gutotech.fatecandoapi.model.Comment;
import com.gutotech.fatecandoapi.model.ForumThread;
import com.gutotech.fatecandoapi.model.ForumThreadUser;
import com.gutotech.fatecandoapi.model.assembler.CommentModelAssembler;
import com.gutotech.fatecandoapi.model.assembler.ForumThreadModelAssembler;
import com.gutotech.fatecandoapi.service.CommentService;
import com.gutotech.fatecandoapi.service.ForumThreadService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/forum-threads")
public class ForumRestController {

	@Autowired
	private ForumThreadService forumThreadService;

	@Autowired
	private ForumThreadModelAssembler forumTopicAssembler;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CommentModelAssembler commentAssembler;

	@Autowired
	private UserService userService;

	@GetMapping("{id}")
	public EntityModel<ForumThread> getForumThread(@PathVariable Long id) {
		ForumThread thread = forumThreadService.findById(id);
		ForumThreadUser me = thread.getMe();
		me.setViewed(true);
		if (me.getUser() == null) {
			me.setUser(userService.findCurrentUser());
		}
		forumThreadService.save(thread);
		return forumTopicAssembler.toModel(thread);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteForumThread(@PathVariable Long id) {
		forumThreadService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}/comments/{commentId}")
	public EntityModel<Comment> getComment(@PathVariable("id") Long id, @PathVariable("commentId") Long commentId) {
		ForumThread forumThread = forumThreadService.findById(id);

		Comment comment = forumThread.getComments().stream() //
				.filter((c) -> Objects.equals(c.getId(), commentId)) //
				.findFirst() //
				.orElseThrow(() -> new ResourceNotFoundException("Could not find comment " + commentId));

		return commentAssembler.toModel(comment);
	}

	@GetMapping("{id}/comments")
	public ResponseEntity<Set<Comment>> getComments(@PathVariable("id") Long id) {
		ForumThread forumThread = forumThreadService.findById(id);
		return ResponseEntity.ok(forumThread.getComments());
	}

	@PostMapping("{id}/comments")
	public ResponseEntity<EntityModel<Comment>> addComment(@PathVariable("id") Long id,
			@RequestBody @Valid Comment comment) {
		ForumThread forumThread = forumThreadService.findById(id);

		comment.setForumTopic(forumThread);

		comment.setUser(userService.findCurrentUser());

		EntityModel<Comment> entityModel = commentAssembler.toModel(commentService.save(comment));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PostMapping("{id}/upvote")
	public ResponseEntity<ForumThread> addUpvote(@PathVariable Long id) {
		ForumThread thread = forumThreadService.findById(id);
		ForumThreadUser threadUser = thread.getMe();

		if (threadUser.isUpvoted()) {
			threadUser.setUpvoted(false);
			threadUser.setDownvoted(false);
		} else {
			threadUser.setUpvoted(true);
			threadUser.setDownvoted(false);
		}

		if (threadUser.getUser() == null) {
			threadUser.setUser(userService.findCurrentUser());
		}

		forumThreadService.save(thread);

		return ResponseEntity.ok(thread);
	}

	@PostMapping("{id}/downvote")
	public ResponseEntity<ForumThread> addDownvote(@PathVariable Long id) {
		ForumThread thread = forumThreadService.findById(id);

		ForumThreadUser threadUser = thread.getMe();

		if (threadUser.isDownvoted()) {
			threadUser.setDownvoted(false);
			threadUser.setUpvoted(false);
		} else {
			threadUser.setDownvoted(true);
			threadUser.setUpvoted(false);
		}

		if (threadUser.getUser() == null) {
			threadUser.setUser(userService.findCurrentUser());
		}

		forumThreadService.save(thread);

		return ResponseEntity.ok(thread);
	}

}
