package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ForumTopicCommentUserId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true)
	private ForumTopicComment comment;

	@ManyToOne(optional = true)
	private User user;

	public ForumTopicCommentUserId() {
	}

	public ForumTopicCommentUserId(ForumTopicComment forumTopicComment, User user) {
		this.comment = forumTopicComment;
		this.user = user;
	}

	public ForumTopicComment getComment() {
		return comment;
	}

	public void setComment(ForumTopicComment comment) {
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
		if (!(obj instanceof ForumTopicCommentUserId)) {
			return false;
		}
		ForumTopicCommentUserId other = (ForumTopicCommentUserId) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(user, other.user);
	}

}
