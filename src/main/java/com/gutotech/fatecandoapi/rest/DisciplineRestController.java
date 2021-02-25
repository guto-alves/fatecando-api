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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.assembler.DisciplineModelAssembler;
import com.gutotech.fatecandoapi.service.DisciplineService;
import com.gutotech.fatecandoapi.service.TopicService;

@RestController
@RequestMapping("api/disciplines")
public class DisciplineRestController {

	@Autowired
	private DisciplineService disciplineService;

	@Autowired
	private DisciplineModelAssembler disciplineAssembler;

	@Autowired
	private TopicService topicService;

	@GetMapping
	public ResponseEntity<List<Discipline>> getDisciplines(
			@RequestParam(value = "semester", required = false) Integer semester) {
		if (semester != null) {
			return ResponseEntity.ok(disciplineService.findAllBySemester(semester));
		}

		return ResponseEntity.ok(disciplineService.findAll());
	}

	@GetMapping("{id}")
	public EntityModel<Discipline> getDiscipline(@PathVariable Long id) {
		return disciplineAssembler.toModel(disciplineService.findById(id));
	}

	@GetMapping("{id}/topics")
	public ResponseEntity<List<Topic>> getTopicsByDiscipline(@PathVariable Long id) {
		Discipline discipline = disciplineService.findById(id);

		List<Topic> topics = topicService.findAllByDiscipline(discipline);

		return ResponseEntity.ok(topics);
	}

	@PostMapping
	public ResponseEntity<EntityModel<Discipline>> addDiscipline(@RequestBody @Valid Discipline discipline) {
		EntityModel<Discipline> entityModel = disciplineAssembler.toModel(disciplineService.save(discipline));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateCourse(@RequestBody @Valid Discipline discipline, //
			@PathVariable Long id) {
		Discipline currentDiscipline = disciplineService.findById(id);
		currentDiscipline.setName(discipline.getName());
		currentDiscipline.setCode(discipline.getCode());
		currentDiscipline.setSemester(discipline.getSemester());
		currentDiscipline.setDescription(discipline.getDescription());
		currentDiscipline.setObjective(discipline.getObjective());

		EntityModel<Discipline> entityModel = disciplineAssembler.toModel(disciplineService.save(currentDiscipline));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteDiscipline(@PathVariable Long id) {
		disciplineService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
