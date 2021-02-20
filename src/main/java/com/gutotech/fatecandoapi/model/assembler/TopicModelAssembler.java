package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.rest.CourseRestController;

@Component
public class TopicModelAssembler implements RepresentationModelAssembler<Topic, EntityModel<Topic>> {

	@Override
	public EntityModel<Topic> toModel(Topic topic) {
		return EntityModel.of(topic,
				linkTo(methodOn(CourseRestController.class).getCourse(topic.getId())).withSelfRel(),
				linkTo(methodOn(CourseRestController.class).getAllCourses()).withRel("topics"));
	}

}
