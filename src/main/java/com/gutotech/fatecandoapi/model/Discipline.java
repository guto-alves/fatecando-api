package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Discipline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String name;

	@NotBlank
	@Column(unique = true)
	private String code;

	@NotBlank
	@Column(length = 2500)
	private String description;

	@NotBlank
	private String objective;

	private int semester;

	@JsonIgnore
	@OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
	private Set<Topic> topics = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
	private List<ForumTopic> forumTopics = new ArrayList<>();

	@ManyToOne
	private Course course;

	@JsonIgnore
	@OneToMany(mappedBy = "id.discipline")
	private List<DisciplineUser> disciplineUsers = new ArrayList<>();

	public Discipline() {
	}

	public Discipline(String name, String code, String description, String objetive, int semester, Course course) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.objective = objetive;
		this.semester = semester;
		this.course = course;
	}

	// Utility methods that synchronize both ends whenever a child element is added
	// or removed.
	public void addTopic(Topic topic) {
		topics.add(topic);
		topic.setDiscipline(this);
	}

	public void removeTopic(Topic topic) {
		topics.remove(topic);
		topic.setDiscipline(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public List<ForumTopic> getForumTopics() {
		return forumTopics;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<DisciplineUser> getDisciplineUsers() {
		return disciplineUsers;
	}

	public void setDisciplineUsers(List<DisciplineUser> disciplineUsers) {
		this.disciplineUsers = disciplineUsers;
	}

	public DisciplineUser getUser() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		return disciplineUsers.stream() //
				.filter(info -> info.getUser().getEmail().equals(email)) //
				.findFirst() //
				.orElse(new DisciplineUser(this, null));
	}

	public long getLikes() {
		return disciplineUsers.stream() //
				.filter(DisciplineUser::isLiked) //
				.count();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Discipline)) {
			return false;
		}
		Discipline other = (Discipline) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Discipline [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

}
