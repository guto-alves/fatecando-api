package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.ForumThread;
import com.gutotech.fatecandoapi.rest.SubjectRestController;
import com.gutotech.fatecandoapi.rest.ForumRestController;

@Component
public class ForumThreadModelAssembler implements RepresentationModelAssembler<ForumThread, EntityModel<ForumThread>> {

	@Override
	public EntityModel<ForumThread> toModel(ForumThread forumThread) {
		return EntityModel.of(forumThread, //
				linkTo(methodOn(ForumRestController.class).getForumThread(forumThread.getId())).withSelfRel(),
				linkTo(methodOn(ForumRestController.class).getComments(forumThread.getId())).withRel("comments"),
				linkTo(methodOn(SubjectRestController.class)
						.getForumThreads(forumThread.getSubject().getId())).withRel("forumTopics"));
	}

}
