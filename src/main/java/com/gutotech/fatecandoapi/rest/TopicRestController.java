package com.gutotech.fatecandoapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.service.TopicService;

@RestController
@RequestMapping("api/topics")
public class TopicRestController {

	@Autowired
	private TopicService service;

	@GetMapping
	public ResponseEntity<List<Topic>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Topic> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

}
