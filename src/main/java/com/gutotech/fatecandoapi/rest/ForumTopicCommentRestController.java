package com.gutotech.fatecandoapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.ForumTopicComment;
import com.gutotech.fatecandoapi.model.ForumTopicCommentUser;
import com.gutotech.fatecandoapi.service.ForumTopicCommentService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("comments")
public class ForumTopicCommentRestController {

	@Autowired
	private ForumTopicCommentService commentService;

	@Autowired
	private UserService userService;

	@GetMapping("{id}")
	public ResponseEntity<ForumTopicComment> getComment(@PathVariable Long id) {
		return ResponseEntity.ok(commentService.findById(id));
	}

	@PostMapping("{id}/upvote")
	public ResponseEntity<ForumTopicComment> addUpvote(@PathVariable Long id) {
		ForumTopicComment forumTopicComment = commentService.findById(id);
		ForumTopicCommentUser commentUser = forumTopicComment.getMe();

		if (commentUser.isUpvoted()) {
			commentUser.setUpvoted(false);
			commentUser.setDownvoted(false);
		} else {
			commentUser.setUpvoted(true);
			commentUser.setDownvoted(false);
		}

		if (commentUser.getUser() == null) {
			commentUser.setUser(userService.findCurrentUser());
		}

		commentService.save(forumTopicComment);

		return ResponseEntity.ok(forumTopicComment);
	}

	@PostMapping("{id}/downvote")
	public ResponseEntity<ForumTopicComment> addDownvote(@PathVariable Long id) {
		ForumTopicComment forumTopicComment = commentService.findById(id);

		ForumTopicCommentUser commentUser = forumTopicComment.getMe();

		if (commentUser.isDownvoted()) {
			commentUser.setDownvoted(false);
			commentUser.setUpvoted(false);
		} else {
			commentUser.setDownvoted(true);
			commentUser.setUpvoted(false);
		}

		if (commentUser.getUser() == null) {
			commentUser.setUser(userService.findCurrentUser());
		}

		commentService.save(forumTopicComment);

		return ResponseEntity.ok(forumTopicComment);
	}

}
