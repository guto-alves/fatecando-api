package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class TestQuestionId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Test test;

	@ManyToOne
	private Question question;

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		return Objects.hash(question, test);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TestQuestionId)) {
			return false;
		}
		TestQuestionId other = (TestQuestionId) obj;
		return Objects.equals(question, other.question) && Objects.equals(test, other.test);
	}

}
