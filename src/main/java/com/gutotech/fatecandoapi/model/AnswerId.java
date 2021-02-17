package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AnswerId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Question question;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		return Objects.hash(question, student);
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
		return Objects.equals(question, other.question) && Objects.equals(student, other.student);
	}

}
