package com.gutotech.fatecandoapi.rest;

import java.util.Date;
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

import com.gutotech.fatecandoapi.model.Course;
import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.DisciplineUser;
import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.model.assembler.DisciplineModelAssembler;
import com.gutotech.fatecandoapi.model.assembler.ForumTopicModelAssembler;
import com.gutotech.fatecandoapi.service.CourseService;
import com.gutotech.fatecandoapi.service.DisciplineService;
import com.gutotech.fatecandoapi.service.DisciplineUserService;
import com.gutotech.fatecandoapi.service.ForumTopicService;
import com.gutotech.fatecandoapi.service.TopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/disciplines")
public class DisciplineRestController {

	@Autowired
	private DisciplineService disciplineService;

	@Autowired
	private DisciplineModelAssembler disciplineAssembler;

	@Autowired
	private TopicService topicService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private UserService userService;

	@Autowired
	private DisciplineUserService disciplineUserService;

	@GetMapping
	public ResponseEntity<List<Discipline>> getDisciplines(
			@RequestParam(value = "semester", required = false) Integer semester,
			@RequestParam(value = "course", required = false) Long courseId) {
		if (semester != null) {
			return ResponseEntity.ok(disciplineService.findAllBySemester(semester));
		} else if (courseId != null) {
			Course course = courseService.findById(courseId);
			return ResponseEntity.ok(disciplineService.findAllByCourse(course));
		}

		return ResponseEntity.ok(disciplineService.findAll());
	}

	@GetMapping("accessed")
	public ResponseEntity<List<Discipline>> getDisciplinesByAccessDate() {
		return ResponseEntity.ok(userService.findCurrentUser().getDisciplines());
	}

	@GetMapping("{id}")
	public EntityModel<Discipline> getDiscipline(@PathVariable Long id) {
		Discipline discipline = disciplineService.findById(id);

		DisciplineUser disciplineUser = getDisciplineUser(discipline);
		disciplineUser.setAccessDate(new Date());
		disciplineUserService.save(disciplineUser);

		if (!discipline.getDisciplineUsers().contains(disciplineUser)) {
			discipline.getDisciplineUsers().add(disciplineUser);
		}

		return disciplineAssembler.toModel(discipline);
	}

	@GetMapping("{id}/topics")
	public ResponseEntity<List<Topic>> getDisciplineTopics(@PathVariable Long id) {
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
	public ResponseEntity<?> updateDiscipline(@RequestBody @Valid Discipline discipline, @PathVariable Long id) {
		Discipline currentDiscipline = disciplineService.findById(id);
		currentDiscipline.setName(discipline.getName());
		currentDiscipline.setCode(discipline.getCode());
		currentDiscipline.setSemester(discipline.getSemester());
		currentDiscipline.setDescription(discipline.getDescription());
		currentDiscipline.setObjective(discipline.getObjective());

		if (discipline.getCourse() != null) {
			Course course = courseService.findById(discipline.getCourse().getId());
			currentDiscipline.setCourse(course);
		}

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

	@PutMapping("{id}/like")
	public ResponseEntity<Void> toggleLike(@PathVariable Long id) {
		Discipline discipline = disciplineService.findById(id);

		DisciplineUser disciplineUser = getDisciplineUser(discipline);
		disciplineUser.setLiked(!disciplineUser.isLiked());
		disciplineUserService.save(disciplineUser);

		return ResponseEntity.noContent().build();
	}

	private DisciplineUser getDisciplineUser(Discipline discipline) {
		DisciplineUser disciplineUser = discipline.getUser();

		if (disciplineUser.getUser() == null) {
			User user = userService.findCurrentUser();
			disciplineUser.setUser(user);
		}

		return disciplineUser;
	}

	// Forum Topics
	@Autowired
	private ForumTopicService forumTopicService;

	@Autowired
	private ForumTopicModelAssembler forumTopicAssembler;

	@GetMapping("{id}/forum-topics")
	public ResponseEntity<List<ForumTopic>> getForumTopics(@PathVariable Long id) {
		Discipline discipline = disciplineService.findById(id);
		return ResponseEntity.ok(discipline.getForumTopics());
	}

	@PostMapping("{id}/forum-topics")
	public ResponseEntity<EntityModel<ForumTopic>> addForumTopic(@PathVariable() Long id,
			@RequestBody @Valid ForumTopic forumTopic) {
		Discipline discipline = disciplineService.findById(id);
		forumTopic.setDiscipline(discipline);

		forumTopic.setUser(userService.findCurrentUser());

		EntityModel<ForumTopic> entityModel = forumTopicAssembler.toModel(forumTopicService.save(forumTopic));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

}
