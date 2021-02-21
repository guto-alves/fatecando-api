package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.ForumTopicComment;
import com.gutotech.fatecandoapi.rest.ForumRestController;

@Component
public class ForumTopicCommentModelAssembler
		implements RepresentationModelAssembler<ForumTopicComment, EntityModel<ForumTopicComment>> {

	@Override
	public EntityModel<ForumTopicComment> toModel(ForumTopicComment comment) {
		return EntityModel.of(comment, //
				linkTo(methodOn(ForumRestController.class).getComment(comment.getForumTopic().getId(), comment.getId()))
						.withSelfRel(),
				linkTo(methodOn(ForumRestController.class).getComments(comment.getForumTopic().getId()))
						.withRel("comments"),
				linkTo(methodOn(ForumRestController.class).getForumTopic(comment.getForumTopic().getId()))
						.withRel("forumTopic"));
	}

}
