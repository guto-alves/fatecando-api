package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "forum_topic_comment_users")
public class ForumTopicCommentUser {
	@EmbeddedId
	private ForumTopicCommentUserId id = new ForumTopicCommentUserId();

	private boolean upvoted;
	private boolean downvoted;

	public ForumTopicCommentUser() {
	}

	public ForumTopicCommentUser(ForumTopicComment forumTopicComment, User user) {
		id.setComment(forumTopicComment);
		id.setUser(user);
	}

	@JsonIgnore
	public ForumTopicComment getComment() {
		return id.getComment();
	}

	public void setComment(ForumTopicComment ForumTopicComment) {
		id.setComment(ForumTopicComment);
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
		if (!(obj instanceof ForumTopicCommentUser)) {
			return false;
		}
		ForumTopicCommentUser other = (ForumTopicCommentUser) obj;
		return Objects.equals(id, other.id);
	}

}
