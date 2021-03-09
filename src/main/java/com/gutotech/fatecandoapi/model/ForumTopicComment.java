package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ForumTopicComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please provide a valid content.")
	@Column(length = 2000)
	private String content;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int likes;

	@ManyToOne
	private User user;

	@JsonIgnore
	@ManyToOne
	private ForumTopic forumTopic;

	public ForumTopicComment() {
	}

	public ForumTopicComment(String content, User user, ForumTopic forumTopic) {
		this.content = content;
		this.user = user;
		this.forumTopic = forumTopic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ForumTopic getForumTopic() {
		return forumTopic;
	}

	public void setForumTopic(ForumTopic forumTopic) {
		this.forumTopic = forumTopic;
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
		if (!(obj instanceof ForumTopicComment)) {
			return false;
		}
		ForumTopicComment other = (ForumTopicComment) obj;
		return Objects.equals(id, other.id);
	}

}
