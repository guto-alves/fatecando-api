package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "forum_thread_users")
public class ForumThreadUser {

	@EmbeddedId
	private ForumThreadUserId id = new ForumThreadUserId();

	private boolean upvoted;
	private boolean downvoted;

	public ForumThreadUser() {
	}

	public ForumThreadUser(ForumThread forumThread, User user) {
		id.setForumThread(forumThread);
		id.setUser(user);
	}

	@JsonIgnore
	public ForumThread getForumThread() {
		return id.getForumThread();
	}

	public void setForumThread(ForumThread forumThread) {
		id.setForumThread(forumThread);
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
		if (!(obj instanceof ForumThreadUser)) {
			return false;
		}
		ForumThreadUser other = (ForumThreadUser) obj;
		return Objects.equals(id, other.id);
	}

}
