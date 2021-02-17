package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Discipline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	@Column(unique = true)
	private String code;

	@Column(length = 2500)
	private String description;

	private String objetive;

	private int semester;

	@JsonIgnore
	@OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Topic> topics = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Test> tests = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ForumTopic> forum = new ArrayList<>();

	public Discipline() {
	}

	public Discipline(String name, String code, String description, String objetive, int semester) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.objetive = objetive;
		this.semester = semester;
	}

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

	public String getObjetive() {
		return objetive;
	}

	public void setObjetive(String objetive) {
		this.objetive = objetive;
	}

	public int getSemestre() {
		return semester;
	}

	public void setSemestre(int semester) {
		this.semester = semester;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public List<Test> getTests() {
		return tests;
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

}
