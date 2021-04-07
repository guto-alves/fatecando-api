package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please provide a valid content.")
	@Column(name = "body_html", columnDefinition = "TEXT")
	private String bodyHtml;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Date creationDate;

	@ManyToOne
	private User user;

	@JsonIgnore
	@ManyToOne
	private ForumThread forumThread;

	@JsonIgnore
	@OneToMany(mappedBy = "id.comment", cascade = CascadeType.ALL)
	private List<CommentUser> commentUsers = new ArrayList<>();

	public Comment() {
	}

	public Comment(String bodyHtml, User user, ForumThread forumThread) {
		this.bodyHtml = bodyHtml;
		this.user = user;
		this.forumThread = forumThread;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ForumThread getForumThread() {
		return forumThread;
	}

	public void setForumTopic(ForumThread forumThread) {
		this.forumThread = forumThread;
	}

	public long getVoteCount() {
		return commentUsers.stream() //
				.mapToLong(c -> c.isUpvoted() ? 1 : c.isDownvoted() ? -1 : 0) //
				.sum();
	}

	public CommentUser getMe() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

		// @formatter:off
		return commentUsers.stream()
				.filter((c) -> c.getUser().getEmail().equals(currentUserEmail))
				.findFirst()
				.orElseGet(() -> {
					CommentUser commentUser = new CommentUser(this, null);
					commentUsers.add(commentUser);
					return commentUser;
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
		if (!(obj instanceof Comment)) {
			return false;
		}
		Comment other = (Comment) obj;
		return Objects.equals(id, other.id);
	}

}
