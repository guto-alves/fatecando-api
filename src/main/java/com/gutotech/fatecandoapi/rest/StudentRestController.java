package com.gutotech.fatecandoapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Student;
import com.gutotech.fatecandoapi.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentRestController {

	@Autowired
	private StudentService service;

	@GetMapping
	public ResponseEntity<List<Student>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Student> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
}
