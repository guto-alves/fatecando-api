package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Answer {

	@EmbeddedId
	private AnswerId id = new AnswerId();

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastAnswered;

	// This is used to calculate the rating score
	private int score;

	private boolean hit;

	public Answer() {
	}

	public Answer(Student student, Question question) {
		id.setStudent(student);
		id.setQuestion(question);
	}

	public Date getLastAnswered() {
		return lastAnswered;
	}

	public void setLastAnswered(Date lastAnswered) {
		this.lastAnswered = lastAnswered;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
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
		if (!(obj instanceof Answer)) {
			return false;
		}
		Answer other = (Answer) obj;
		return Objects.equals(id, other.id);
	}

}
