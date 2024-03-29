package com.gutotech.fatecandoapi.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.ForumThread;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.SubjectUser;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.assembler.ForumThreadModelAssembler;
import com.gutotech.fatecandoapi.model.assembler.SubjectModelAssembler;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.ForumThreadService;
import com.gutotech.fatecandoapi.service.SubjectService;
import com.gutotech.fatecandoapi.service.SubjectUserService;
import com.gutotech.fatecandoapi.service.TopicService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/subjects")
public class SubjectRestController {

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private SubjectModelAssembler subjectAssembler;

	@Autowired
	private TopicService topicService;

	@Autowired
	private UserService userService;

	@Autowired
	private SubjectUserService subjectUserService;

	@GetMapping
	public ResponseEntity<List<Subject>> getSubjects(
			@RequestParam(value = "semester", required = false) Integer semester,
			@RequestParam(value = "with-topics", required = false, defaultValue = "false") Boolean withTopics) {
		if (semester != null) {
			return ResponseEntity.ok(subjectService.findBySemester(semester));
		} else if (withTopics) {
			return ResponseEntity.ok(subjectService.findWithTopics());
		}
		
		if (userService.hasRoles(Roles.ADMIN, Roles.TEACHER)) {
			return ResponseEntity.ok(subjectService.findAll());
		}

		return ResponseEntity.ok(subjectService.findAllEnabled());
	}

	@GetMapping("search")
	public ResponseEntity<List<Subject>> search(@RequestParam String text) {
		return ResponseEntity.ok(subjectService.findBy(text));
	}

	@GetMapping("{id}")
	public EntityModel<Subject> getSubject(@PathVariable Long id) {
		Subject subject = subjectService.findById(id);
		
		if (!subject.isEnabled() && !userService.hasRoles(Roles.ADMIN, Roles.TEACHER)) {
			throw new IllegalStateException("A disciplina que você está tentando acessar não está ativa no momento.");
		}

		SubjectUser subjectUser = subjectUserService.findById(subject, userService.findCurrentUser());
		subjectUser.setAccessDate(new Date());
		subjectUserService.save(subjectUser);

		return subjectAssembler.toModel(subject);
	}

	@Secured(Roles.ADMIN)
	@PostMapping
	public ResponseEntity<EntityModel<Subject>> addSubject(@RequestBody @Valid Subject subject) {
		EntityModel<Subject> entityModel = subjectAssembler.toModel(subjectService.save(subject));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@Secured({Roles.ADMIN, Roles.TEACHER})
	@PutMapping("{id}")
	public ResponseEntity<?> updateSubject(@RequestBody @Valid Subject subject, @PathVariable Long id) throws IllegalAccessException {
		Subject currentSubject = subjectService.findById(id);
		
		if (userService.hasRoles(Roles.TEACHER) && !userService.findCurrentUser().getSubjects().contains(currentSubject)) {
			throw new IllegalAccessException("Você não tem permissão para alterar a disciplina " + currentSubject.getName());
		}
		
		currentSubject.setName(subject.getName());
		currentSubject.setCode(subject.getCode());
		currentSubject.setSemester(subject.getSemester());
		currentSubject.setDescription(subject.getDescription());
		currentSubject.setObjective(subject.getObjective());
		currentSubject.setEnabled(subject.isEnabled());

		EntityModel<Subject> entityModel = subjectAssembler.toModel(subjectService.save(currentSubject));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@Secured(Roles.ADMIN)
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteSubject(@PathVariable Long id) {
		Subject subject = subjectService.findById(id);
		subject.setEnabled(false);
		subjectService.save(subject);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}/like")
	public ResponseEntity<Void> toggleLike(@PathVariable Long id) {
		Subject subject = subjectService.findById(id);

		SubjectUser subjectUser = subjectUserService.findById(subject, userService.findCurrentUser());
		subjectUser.setLiked(!subjectUser.isLiked());
		subjectUserService.save(subjectUser);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("{id}/topics")
	public ResponseEntity<List<Topic>> getSubjectTopics(@PathVariable Long id) {
		Subject subject = subjectService.findById(id);
		List<Topic> topics = topicService.findBySubject(subject);
		return ResponseEntity.ok(topics);
	}

	@GetMapping("{id}/topics/test")
	public ResponseEntity<List<Topic>> getTopicsForTest(@PathVariable Long id) {
		Subject subject = subjectService.findById(id);
		List<Topic> topics = topicService.findTestTopics(subject);
		return ResponseEntity.ok(topics);
	}

	@GetMapping("{id}/topics/game")
	public ResponseEntity<List<Topic>> getTopicsForGame(@PathVariable Long id) {
		Subject subject = subjectService.findById(id);
		List<Topic> topics = topicService.findGameTopics(subject);
		return ResponseEntity.ok(topics);
	}

	// Forum Topics
	@Autowired
	private ForumThreadService forumThreadService;

	@Autowired
	private ForumThreadModelAssembler forumTopicAssembler;

	@GetMapping("{id}/forum-topics")
	public ResponseEntity<List<ForumThread>> getForumThreads(@PathVariable Long id) {
		Subject subject = subjectService.findById(id);
		return ResponseEntity.ok(subject.getForumThreads());
	}

	@PostMapping("{id}/forum-topics")
	public ResponseEntity<EntityModel<ForumThread>> addForumThread(@PathVariable() Long id,
			@RequestBody @Valid ForumThread forumThread) {
		Subject subject = subjectService.findById(id);
		forumThread.setSubject(subject);

		forumThread.setUser(userService.findCurrentUser());

		EntityModel<ForumThread> entityModel = forumTopicAssembler.toModel(forumThreadService.save(forumThread));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

}
