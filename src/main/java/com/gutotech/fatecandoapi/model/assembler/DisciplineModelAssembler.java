package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.rest.DisciplineRestController;

@Component
public class DisciplineModelAssembler implements RepresentationModelAssembler<Discipline, EntityModel<Discipline>> {

	@Override
	public EntityModel<Discipline> toModel(Discipline discipline) {
		return EntityModel.of(discipline,
				linkTo(methodOn(DisciplineRestController.class).getDiscipline(discipline.getId())).withSelfRel(),
				linkTo(methodOn(DisciplineRestController.class).getDisciplines(null, null, null)).withRel("disciplines"),
				linkTo(methodOn(DisciplineRestController.class).getDisciplineTopics(discipline.getId()))
						.withRel("topics"),
				linkTo(methodOn(DisciplineRestController.class).getForumTopics(discipline.getId()))
						.withRel("forumTopics"));
	}

}
