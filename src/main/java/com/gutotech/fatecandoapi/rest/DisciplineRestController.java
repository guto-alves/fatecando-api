package com.gutotech.fatecandoapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.service.DisciplineService;
import com.gutotech.fatecandoapi.service.ForumTopicService;
import com.gutotech.fatecandoapi.service.TopicService;

@RestController
@RequestMapping("api/disciplines")
public class DisciplineRestController {

	@Autowired
	private DisciplineService disciplineService;

	@Autowired
	private TopicService topicService;

	@Autowired
	private ForumTopicService forumTopicService;

	@GetMapping
	public ResponseEntity<List<Discipline>> findAll(
			@RequestParam(value = "semester", required = false) Integer semester) {
		if (semester != null) {
			ResponseEntity.ok(disciplineService.findAllBySemester(semester));
		}

		return ResponseEntity.ok(disciplineService.findAll());
	}

	@GetMapping("{id}")
	private ResponseEntity<Discipline> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(disciplineService.findById(id));
	}

	@GetMapping("{id}/topics")
	private ResponseEntity<List<Topic>> findAllTopicsByDiscipline(@PathVariable("id") Long id) {
		Discipline discipline = disciplineService.findById(id);

		List<Topic> topics = topicService.findAllByDiscipline(discipline);

		return ResponseEntity.ok(topics);
	}

	@GetMapping("{id}/forumtopics")
	private ResponseEntity<List<ForumTopic>> findAllForumTopicsByDiscipline(@PathVariable("id") Long id) {
		Discipline discipline = disciplineService.findById(id);

		List<ForumTopic> forumTopics = forumTopicService.findAllByDiscipline(discipline);

		return ResponseEntity.ok(forumTopics);
	}

}
