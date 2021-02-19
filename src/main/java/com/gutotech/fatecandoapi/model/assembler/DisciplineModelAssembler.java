package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.rest.CourseRestController;

@Component
public class DisciplineModelAssembler implements RepresentationModelAssembler<Discipline, EntityModel<Discipline>> {

	@Override
	public EntityModel<Discipline> toModel(Discipline discipline) {
		return EntityModel.of(discipline,
				linkTo(methodOn(CourseRestController.class).getCourse(discipline.getId())).withSelfRel(),
				linkTo(methodOn(CourseRestController.class).getAllCourses()).withRel("disciplines"));
	}

}
