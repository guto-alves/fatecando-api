package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "forum_threads")
public class ForumThread {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please provide a title")
	private String title;

	@NotBlank(message = "Please provide a description")
	@Column(name = "body_html", columnDefinition = "TEXT")
	private String bodyHtml;

	@JsonIgnore
	@ManyToOne
	private Subject subject;

	@ManyToOne
	private User user;

	@ManyToMany
	private List<Topic> tags = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "forumThread", cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Date creationDate;

	@OneToMany(mappedBy = "id.forumThread", cascade = CascadeType.ALL)
	private List<ForumThreadUser> threadUsers = new ArrayList<>();

	public ForumThread() {
	}

	public ForumThread(String title, String bodyHtml, Subject subject, User user, List<Topic> tags) {
		this.title = title;
		this.bodyHtml = bodyHtml;
		this.subject = subject;
		this.user = user;
		this.tags = tags;
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

	public String getBodyHtml() {
		return bodyHtml;
	}

	public void setBodyHtml(String bodyHtml) {
		this.bodyHtml = bodyHtml;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Topic> getTags() {
		return tags;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public List<ForumThreadUser> getThreadUsers() {
		return threadUsers;
	}

	public Long getVoteCount() {
		return threadUsers.stream()
				.mapToLong((x) -> x.isUpvoted() ? 1 : x.isDownvoted() ? -1 : 0)
				.sum();
	}

	public ForumThreadUser getMe() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

		// @formatter:off
		return threadUsers.stream()
				.filter((c) -> c.getUser().getEmail().equals(currentUserEmail))
				.findFirst()
				.orElseGet(() -> {
					ForumThreadUser threadUser = new ForumThreadUser(this, null);
					threadUsers.add(threadUser);
					return threadUser;
				});
		// @formatter:on
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
		if (!(obj instanceof ForumThread)) {
			return false;
		}
		ForumThread other = (ForumThread) obj;
		return Objects.equals(id, other.id);
	}

}
