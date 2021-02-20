package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ForumTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String title;

	@Column(length = 2000)
	private String description;

	private Date createdAt;
	private Date updatedAt;
	private int likes;

	@JsonIgnore
	@ManyToOne
	private User user;

	@JsonIgnore
	@ManyToOne
	private Discipline discipline;

	public ForumTopic() {
	}

	public ForumTopic(String title, String description, Date createdAt, Discipline discipline) {
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.discipline = discipline;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public User getStudent() {
		return user;
	}

	public void setStudent(User user) {
		this.user = user;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
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
		if (!(obj instanceof ForumTopic)) {
			return false;
		}
		ForumTopic other = (ForumTopic) obj;
		return Objects.equals(id, other.id);
	}

}
