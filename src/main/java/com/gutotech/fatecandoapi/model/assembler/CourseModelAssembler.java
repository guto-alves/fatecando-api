package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Course;
import com.gutotech.fatecandoapi.rest.CourseRestController;

@Component
public class CourseModelAssembler implements RepresentationModelAssembler<Course, EntityModel<Course>> {

	@Override
	public EntityModel<Course> toModel(Course course) {
		return EntityModel.of(course,
				linkTo(methodOn(CourseRestController.class).getCourse(course.getId())).withSelfRel(),
				linkTo(methodOn(CourseRestController.class).getAllCourses()).withRel("courses")); 
	}

}
