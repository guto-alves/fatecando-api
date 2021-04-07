package com.gutotech.fatecandoapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Comment;
import com.gutotech.fatecandoapi.model.CommentUser;
import com.gutotech.fatecandoapi.service.CommentService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("comments")
public class CommentRestController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	@GetMapping("{id}")
	public ResponseEntity<Comment> getComment(@PathVariable Long id) {
		return ResponseEntity.ok(commentService.findById(id));
	}

	@PostMapping("{id}/upvote")
	public ResponseEntity<Comment> addUpvote(@PathVariable Long id) {
		Comment comment = commentService.findById(id);
		CommentUser commentUser = comment.getMe();

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

		commentService.save(comment);

		return ResponseEntity.ok(comment);
	}

	@PostMapping("{id}/downvote")
	public ResponseEntity<Comment> addDownvote(@PathVariable Long id) {
		Comment comment = commentService.findById(id);

		CommentUser commentUser = comment.getMe();

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

		commentService.save(comment);

		return ResponseEntity.ok(comment);
	}

}
