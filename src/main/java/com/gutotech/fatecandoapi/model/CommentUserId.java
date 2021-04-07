package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CommentUserId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true)
	private Comment comment;

	@ManyToOne(optional = true)
	private User user;

	public CommentUserId() {
	}

	public CommentUserId(Comment comment, User user) {
		this.comment = comment;
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CommentUserId)) {
			return false;
		}
		CommentUserId other = (CommentUserId) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(user, other.user);
	}

}
