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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String name;

	@NotBlank
	@Column(length = 20, unique = true)
	private String code;

	@NotBlank
	@Column(length = 1000)
	private String description;

	@NotBlank
	@Column(length = 500)
	private String objective;

	@Min(1)
	@Max(12)
	private int semester;

	@JsonIgnore
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private Set<Topic> topics = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	@OrderBy("creationDate DESC")
	private List<ForumThread> forumThreads = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "id.subject")
	private List<SubjectUser> subjectUsers = new ArrayList<>();

	public Subject() {
	}

	public Subject(String name, String code, String description, String objetive, int semester) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.objective = objetive;
		this.semester = semester;
	}

	// Utility methods that synchronize both ends whenever a child element is added or removed.
	public void addTopic(Topic topic) {
		topics.add(topic);
		topic.setSubject(this);
	}

	public void removeTopic(Topic topic) {
		topics.remove(topic);
		topic.setSubject(null);
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

	public List<ForumThread> getForumThreads() {
		return forumThreads;
	}

	public List<SubjectUser> getSubjectUsers() {
		return subjectUsers;
	}

	public void setSubjectUsers(List<SubjectUser> subjectUsers) {
		this.subjectUsers = subjectUsers;
	}

	public SubjectUser getUser() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		return subjectUsers.stream() //
				.filter(info -> info.getUser().getEmail().equals(email)) //
				.findFirst() //
				.orElse(new SubjectUser(this, null));
	}

	public long getLikes() {
		return subjectUsers.stream() //
				.filter(SubjectUser::isLiked) //
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
		if (!(obj instanceof Subject)) {
			return false;
		}
		Subject other = (Subject) obj;
		return Objects.equals(id, other.id);
	}

}
