package com.gutotech.fatecandoapi.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Course;
import com.gutotech.fatecandoapi.model.assembler.CourseModelAssembler;
import com.gutotech.fatecandoapi.service.CourseService;

@RestController
@RequestMapping("courses")
public class CourseRestController {

	@Autowired
	private CourseService service;

	@Autowired
	private CourseModelAssembler assembler;

	@GetMapping
	public CollectionModel<EntityModel<Course>> getAllCourses() {
		List<EntityModel<Course>> courses = service.findAll().stream() //
				.map(assembler::toModel) //
				.collect(Collectors.toList());

		return CollectionModel.of(courses, //
				linkTo(methodOn(CourseRestController.class).getAllCourses()).withSelfRel());
	}

	@GetMapping("{id}")
	public EntityModel<Course> getCourse(@PathVariable Long id) {
		Course course = service.findById(id);

		return assembler.toModel(course);
	}

	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody @Valid Course course, BindingResult bindingResult) {
		EntityModel<Course> entityModel = assembler.toModel(service.save(course));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateCourse(@RequestBody @Valid Course course, //
			@PathVariable Long id, BindingResult bindingResult) {
		Course currentCourse = service.findById(id);
		currentCourse.setName(course.getName());
		currentCourse.setSemesters(course.getSemesters());

		EntityModel<Course> entityModel = assembler.toModel(currentCourse);

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
