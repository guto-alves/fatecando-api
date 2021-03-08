package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.rest.DisciplineRestController;
import com.gutotech.fatecandoapi.rest.ForumRestController;

@Component
public class ForumTopicModelAssembler implements RepresentationModelAssembler<ForumTopic, EntityModel<ForumTopic>> {

	@Override
	public EntityModel<ForumTopic> toModel(ForumTopic forumTopic) {
		return EntityModel.of(forumTopic, //
				linkTo(methodOn(ForumRestController.class).getForumTopic(forumTopic.getId())).withSelfRel(),
				linkTo(methodOn(ForumRestController.class).getComments(forumTopic.getId())).withRel("comments"),
				linkTo(methodOn(DisciplineRestController.class)
						.getForumTopics(forumTopic.getDiscipline().getId())).withRel("forumTopics"));
	}

}
