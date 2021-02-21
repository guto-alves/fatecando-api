package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AnswerId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User user;

	@ManyToOne
	private Question question;

	public AnswerId() {
	}

	public AnswerId(User user, Question question) {
		this.user = user;
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		return Objects.hash(question, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AnswerId)) {
			return false;
		}
		AnswerId other = (AnswerId) obj;
		return Objects.equals(question, other.question) && Objects.equals(user, other.user);
	}

}
