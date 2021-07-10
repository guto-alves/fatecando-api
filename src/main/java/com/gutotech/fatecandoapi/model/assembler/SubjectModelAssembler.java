package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.rest.SubjectRestController;

@Component
public class SubjectModelAssembler implements RepresentationModelAssembler<Subject, EntityModel<Subject>> {

	@Override
	public EntityModel<Subject> toModel(Subject subject) {
		return EntityModel.of(subject,
				linkTo(methodOn(SubjectRestController.class).getSubject(subject.getId())).withSelfRel(),
				linkTo(methodOn(SubjectRestController.class).getSubjects(null, null)).withRel("subjects"),
				linkTo(methodOn(SubjectRestController.class).getSubjectTopics(subject.getId())).withRel("topics"),
				linkTo(methodOn(SubjectRestController.class).getForumThreads(subject.getId())).withRel("forumTopics"));
	}

}
