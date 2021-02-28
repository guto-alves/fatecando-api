package com.gutotech.fatecandoapi.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("api/courses")
public class CourseRestController {

	@Autowired
	private CourseService service;

	@Autowired
	private CourseModelAssembler assembler;

	@GetMapping
	public ResponseEntity<List<Course>> getAllCourses() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("{id}")
	public EntityModel<Course> getCourse(@PathVariable Long id) {
		Course course = service.findById(id);

		return assembler.toModel(course);
	}

	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody @Valid Course course) {
		EntityModel<Course> entityModel = assembler.toModel(service.save(course));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateCourse(@RequestBody @Valid Course course, @PathVariable Long id) {
		Course currentCourse = service.findById(id);
		currentCourse.setName(course.getName());
		currentCourse.setCode(course.getCode());
		currentCourse.setImageUrl(course.getImageUrl());
		currentCourse.setSemesters(course.getSemesters());
		currentCourse.setDescription(course.getDescription());
		currentCourse.setInstitution(course.getInstitution());

		EntityModel<Course> entityModel = assembler.toModel(service.save(currentCourse));

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
