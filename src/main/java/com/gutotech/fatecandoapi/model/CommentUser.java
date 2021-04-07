package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment_users")
public class CommentUser {
	@EmbeddedId
	private CommentUserId id = new CommentUserId();

	private boolean upvoted;
	private boolean downvoted;

	public CommentUser() {
	}

	public CommentUser(Comment comment, User user) {
		id.setComment(comment);
		id.setUser(user);
	}

	@JsonIgnore
	public Comment getComment() {
		return id.getComment();
	}

	public void setComment(Comment Comment) {
		id.setComment(Comment);
	}

	@JsonIgnore
	public User getUser() {
		return id.getUser();
	}

	public void setUser(User user) {
		id.setUser(user);
	}

	public boolean isUpvoted() {
		return upvoted;
	}

	public void setUpvoted(boolean upvoted) {
		this.upvoted = upvoted;
	}

	public boolean isDownvoted() {
		return downvoted;
	}

	public void setDownvoted(boolean downvoted) {
		this.downvoted = downvoted;
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
		if (!(obj instanceof CommentUser)) {
			return false;
		}
		CommentUser other = (CommentUser) obj;
		return Objects.equals(id, other.id);
	}

}
