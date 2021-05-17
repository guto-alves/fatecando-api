package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ForumThreadUserId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private ForumThread forumThread;

	@ManyToOne
	private User user;

	public ForumThread getForumThread() {
		return forumThread;
	}

	public void setForumThread(ForumThread forumThread) {
		this.forumThread = forumThread;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(forumThread, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ForumThreadUserId)) {
			return false;
		}
		ForumThreadUserId other = (ForumThreadUserId) obj;
		return Objects.equals(forumThread, other.forumThread) && Objects.equals(user, other.user);
	}

}
