package com.gutotech.fatecandoapi.rest;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.gutotech.fatecandoapi.model.Comment;
import com.gutotech.fatecandoapi.model.ForumThread;
import com.gutotech.fatecandoapi.model.ForumThreadUser;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.assembler.CommentModelAssembler;
import com.gutotech.fatecandoapi.model.assembler.ForumThreadModelAssembler;
import com.gutotech.fatecandoapi.service.CommentService;
import com.gutotech.fatecandoapi.service.ForumThreadService;
import com.gutotech.fatecandoapi.service.SubjectService;
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

	@Autowired
	private SubjectService subjectService;

	// filters: NoAnswer, NoAcceptedAnswer
	// sort: Newest, Votes, Visits
	@GetMapping
	public ResponseEntity<List<ForumThread>> search(@RequestParam("subject") Long subjectId,
			@RequestParam(required = false, defaultValue = "Newest") String sort,
			@RequestParam(name = "filter", required = false, defaultValue = "") List<String> filters,
			@RequestParam(name = "topic", required = false, defaultValue = "") List<Long> topics) {
		Subject subject = subjectService.findById(subjectId);

		List<ForumThread> forumThreads = subject.getForumThreads();

		Comparator<ForumThread> comparator = null;

		if (sort.equals("Votes")) {
			comparator = Comparator.comparing(ForumThread::getVoteCount).reversed();
		} else if (sort.equals("Visits")) {
			comparator = Comparator.comparing(ForumThread::getViewCount).reversed();
		} else {
			comparator = Comparator.comparing(ForumThread::getCreationDate).reversed();
		}

		// @formatter:off
			List<Topic> taggedWith = topics.stream()
					.map(t -> new Topic(t))
					.collect(Collectors.toList());
			
			List<ForumThread> result = forumThreads.stream()
				.filter(thread -> {
					if (filters.contains("NoAnswer") ) {
						if (thread.getComments().size() > 0) {
							return false;
						}
					}
					
					if (filters.contains("NoAcceptedAnswer") ) {
						if (thread.isAnswered()) {
							return false;
						}
					}
					
					if (taggedWith.size() > 0) {
						if (taggedWith.stream().anyMatch(taggedTopic -> !thread.getTags().contains(taggedTopic))) {
							return false;
						}
					}
					
					return true;
				})
				.sorted(comparator)
				.collect(Collectors.toList());
			// @formatter:on

		return ResponseEntity.ok(result);
	}

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
	public ResponseEntity<List<Comment>> getComments(@PathVariable("id") Long id) {
		ForumThread forumThread = forumThreadService.findById(id);
		List<Comment> comments = forumThread.getComments()
				.stream()
				.collect(Collectors.toList());
		
		Optional<Comment> acceptedComment = comments.stream()
			.filter(Comment::isAccepted)
			.findFirst();
		if (acceptedComment.isPresent()) {
			Comment comment = acceptedComment.get();
			comments.remove(comment);
			comments.add(0, comment);			
		}
		
		return ResponseEntity.ok(comments);
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
