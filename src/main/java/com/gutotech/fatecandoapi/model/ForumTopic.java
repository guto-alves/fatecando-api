package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ForumTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please provide a title")
	private String title;

	@NotBlank(message = "Please provide a description")
	@Column(length = 2000)
	private String description;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int likes;

	@JsonIgnore
	@ManyToOne
	private Discipline discipline;

	@ManyToOne
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "forumTopic", cascade = CascadeType.ALL)
	private Set<ForumTopicComment> comments = new HashSet<>();

	public ForumTopic() {
	}

	public ForumTopic(String title, String description, Discipline discipline, User user) {
		this.title = title;
		this.description = description;
		this.discipline = discipline;
		this.user = user;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ForumTopicComment> getComments() {
		return comments;
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

	@Override
	public String toString() {
		return "ForumTopic [id=" + id + ", title=" + title + ", likes=" + likes + "]";
	}

}
