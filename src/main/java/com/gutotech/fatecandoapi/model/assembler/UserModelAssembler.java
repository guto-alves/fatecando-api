package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.rest.CourseRestController;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

	@Override
	public EntityModel<User> toModel(User user) {
		return EntityModel.of(user, //
				linkTo(methodOn(CourseRestController.class).getCourse(user.getId())).withSelfRel(),
				linkTo(methodOn(CourseRestController.class).getAllCourses()).withRel("users"));
	}

}
