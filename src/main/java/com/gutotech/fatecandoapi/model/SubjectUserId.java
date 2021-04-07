package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class SubjectUserId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true)
	private Subject subject;

	@ManyToOne(optional = true)
	private User user;

	public SubjectUserId() {
	}

	public SubjectUserId(Subject subject, User user) {
		this.subject = subject;
		this.user = user;
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

	@Override
	public int hashCode() {
		return Objects.hash(subject, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SubjectUserId)) {
			return false;
		}
		SubjectUserId other = (SubjectUserId) obj;
		return Objects.equals(subject, other.subject) && Objects.equals(user, other.user);
	}

}
