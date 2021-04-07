package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Comment;
import com.gutotech.fatecandoapi.rest.ForumRestController;

@Component
public class CommentModelAssembler
		implements RepresentationModelAssembler<Comment, EntityModel<Comment>> {

	@Override
	public EntityModel<Comment> toModel(Comment comment) {
		return EntityModel.of(comment, //
				linkTo(methodOn(ForumRestController.class).getComment(comment.getForumThread().getId(), comment.getId()))
						.withSelfRel(),
				linkTo(methodOn(ForumRestController.class).getComments(comment.getForumThread().getId()))
						.withRel("comments"),
				linkTo(methodOn(ForumRestController.class).getForumThread(comment.getForumThread().getId()))
						.withRel("forumTopic"));
	}

}
